package com.td.mbna.msec.midtier.statement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.td.mbna.msec.midtier.mbcca.MbnaCCA;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.statement.payload.MultiAcctDeliveryPreferenceType;
import com.td.mbna.msec.midtier.statement.payload.updateStatementDeliveryPreferences.UpdateStatementDeliveryPreferencesRequest;
import com.td.mbna.msec.midtier.statement.payload.updateStatementDeliveryPreferences.UpdateStatementDeliveryPreferencesResponse;
import com.td.mbna.msec.midtier.types.common.AuditInfo;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.types.common.DeliveryPreferenceType;
import com.td.mbna.msec.midtier.util.CustomerNotesUtil;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.ParallelServiceCaller;
import com.td.mbna.msec.midtier.util.ServiceCall;


@Component
public class UpdateStatementDeliveryPreferencesOperation implements MsecMidtierCommonOperations<UpdateStatementDeliveryPreferencesRequest, UpdateStatementDeliveryPreferencesResponse> {

    private static final String UPDATE_SUCCESS = "success";
    private static MbnaLogger logger = new MbnaLogger(UpdateStatementDeliveryPreferencesOperation.class);
	
    @Autowired
    private UpdateStatementDeliveryPreferencesOperationReal operationReal;

    @Autowired
    private MbnaCCA mbnaCCA;

    public UpdateStatementDeliveryPreferencesResponse invokeService(UpdateStatementDeliveryPreferencesRequest jsonRequest, String... token) {
        if (jsonRequest.getSessionInfo() != null && "eStatementDisclosure".equals(jsonRequest.getSessionInfo().getClientAction()) &&
                (jsonRequest.getRequestPayload().getDisclosureInfo() == null || jsonRequest.getRequestPayload().getDisclosureInfo().size() == 0)) {

            com.td.mbna.msec.midtier.types.common.BusinessException faultInfo = new com.td.mbna.msec.midtier.types.common.BusinessException();
            faultInfo.setErrorCode("MS535");
            faultInfo.setErrorDescription("no disclosure info");
            throw new com.td.mbna.msec.midtier.exceptions.BusinessException("no disclosure info", faultInfo);
        }

        try {
            //UpdateStatementDeliveryPreferencesRequest request = JAXBJsonConverter.convert(jsonRequest);;
            if (jsonRequest.getRequestPayload().getMultiAcctDiveryPrefRq() != null && jsonRequest.getRequestPayload().getMultiAcctDiveryPrefRq().size() > 0) {
                return operateMultiAcctStatementDeliveryPref(jsonRequest, token);
            }
            return operationReal.invokeService(jsonRequest, token);

        } catch (Exception e) {
            logger.error("UpdateStatementDeliveryPreferencesOperation", e.getMessage(), e);
            throw ExceptionUtil.genRuntimeException(e);
        }

    }

    private UpdateStatementDeliveryPreferencesResponse operateMultiAcctStatementDeliveryPref(
            UpdateStatementDeliveryPreferencesRequest request, String... token) throws Exception {

        //verifyRequest(request);
        ParallelServiceCaller updateSvcCaller = new ParallelServiceCaller();

        for (MultiAcctDeliveryPreferenceType prefType : request.getRequestPayload()
                .getMultiAcctDiveryPrefRq()) {
            scheduleServiceCall(updateSvcCaller, generateRequest(prefType, request), token);
        }

        updateSvcCaller.sync();

        return generateResponse(request, updateSvcCaller);
    }

    private void scheduleServiceCall(ParallelServiceCaller updateSvcCaller,
                                     final UpdateStatementDeliveryPreferencesRequest request, String... token) throws Exception {

        ServiceCall<?> updSvcCall = new ServiceCall<UpdateStatementDeliveryPreferencesResponse>() {
            @Override
            public UpdateStatementDeliveryPreferencesResponse invoke() throws Exception {
                UpdateStatementDeliveryPreferencesResponse updateResult = null;
                try {
                    updateResult = operationReal.invokeService(request, token);
                } catch (Exception exp) {
                    logger.error("invoke", exp.getLocalizedMessage(), exp);
                    throw exp;
                }
                return updateResult;
            }
        };

        updateSvcCaller.scheduleCall(request.getAcctNum(), updSvcCall);
    }

    private UpdateStatementDeliveryPreferencesRequest generateRequest(
            MultiAcctDeliveryPreferenceType prefType, UpdateStatementDeliveryPreferencesRequest request) {

        UpdateStatementDeliveryPreferencesRequest req = new UpdateStatementDeliveryPreferencesRequest();
        com.td.mbna.msec.midtier.statement.payload.updateStatementDeliveryPreferences.RequestPayload pl = new com.td.mbna.msec.midtier.statement.payload.updateStatementDeliveryPreferences.RequestPayload();

        if (request.getAuditInfo() != null) {
            AuditInfo auditLogType = new AuditInfo();

            BeanUtils.copyProperties(request.getAuditInfo(), auditLogType);
            auditLogType.setCardEnding(prefType.getAcctDeliveryPreference().getAcctEnding());
            auditLogType.setCardStarting(prefType.getAcctDeliveryPreference().getCardStarting());
            req.setAuditInfo(auditLogType);
        }

        pl.setAcctDeliveryPreference(prefType.getAcctDeliveryPreference());
        pl.setEmailNotificationInfo(prefType.getEmailNotificationInfo());
        pl.getDisclosureInfo().addAll(prefType.getDisclosureInfo());

        req.setMultiCard(request.isMultiCard());
        req.setAcctNum(prefType.getAcctDeliveryPreference().getAcctId());
        req.setAliasCustId(prefType.getAliasCustId());
        req.setCustId(request.getCustId());
        req.setCustInterface(request.getCustInterface());
        req.setIsPrimaryUser(request.getIsPrimaryUser());
        req.setLanguagePref(request.getLanguagePref());
        req.setRequestPayload(pl);
        req.setSessionInfo(request.getSessionInfo());

        return req;
    }

    private UpdateStatementDeliveryPreferencesResponse generateResponse(
            UpdateStatementDeliveryPreferencesRequest request, ParallelServiceCaller updateSvcCaller)
            throws Exception {

        UpdateStatementDeliveryPreferencesResponse response = new UpdateStatementDeliveryPreferencesResponse();
        com.td.mbna.msec.midtier.statement.payload.updateStatementDeliveryPreferences.ResponsePayload pl = new com.td.mbna.msec.midtier.statement.payload.updateStatementDeliveryPreferences.ResponsePayload();
        response.setResponsePayload(pl);
        for (MultiAcctDeliveryPreferenceType prefType : request.getRequestPayload()
                .getMultiAcctDiveryPrefRq()) {
            UpdateStatementDeliveryPreferencesResponse rs = updateSvcCaller.getResponse(prefType
                            .getAcctDeliveryPreference().getAcctId(),
                    UpdateStatementDeliveryPreferencesResponse.class);

            //If there is any issue with the response like failures or errors, the response will be null
            //Below with this check, we make sure we do not change anything in that case.
            if (rs == null) break;

            MultiAcctDeliveryPreferenceType multiAcctPrefType = new MultiAcctDeliveryPreferenceType();
            multiAcctPrefType.setAcctDeliveryPreference(rs.getResponsePayload().getAcctDeliveryPreference());
            multiAcctPrefType.setAuditInfo(request.getAuditInfo());
            if (rs.getStatus().equalsIgnoreCase(UPDATE_SUCCESS)) {
                multiAcctPrefType.setStatus(true);
            } else {
                multiAcctPrefType.setStatus(false);
            }
            multiAcctPrefType.getErrorMsgs().addAll(rs.getErrorMsgs());

            response.getResponsePayload().getMultiAcctDiveryPrefRs().add(multiAcctPrefType);
        }

        return response;
    }

    @Override
    public boolean requiresDisclosureConsent() {
        return true;
    }

    @Override
    public String getConsentDisclosureFailedMsgCode() {
        return null;
    }

    @Override
    public boolean generateAutoComment() {
        return false;
    }

    @Override
    public List<String> createAutoComment(BaseRequest request, BaseResponse response) {
        List<String> notes = new ArrayList<String>();
        UpdateStatementDeliveryPreferencesRequest mtRequest = (UpdateStatementDeliveryPreferencesRequest) request;

        String optWhat = "Opt-in eStatement";
        if (mtRequest.getRequestPayload().getAcctDeliveryPreference().getAcctDeliveryPreference() == DeliveryPreferenceType.PAPER)
            optWhat = "Opt-out eStatement";

        String header = CustomerNotesUtil.getHeaderContent(request, optWhat);

        notes.add(header);
        return notes;
    }

    @Override
    public EmailInfo getEmailInfoBean(BaseRequest baseRequest, BaseResponse response) {
    	return null;
    	
//        UpdateStatementDeliveryPreferencesRequest request = ((UpdateStatementDeliveryPreferencesRequest) baseRequest);
//        EmailNotificationInfoType notificationInfo = request.getRequestPayload().getEmailNotificationInfo();
//        if(notificationInfo == null){
//        	logger.warn("notificationInfo is null!!");
//        	return null;
//        }
//        EmailInfoImpl emailInfoBean = new EmailInfoImpl(notificationInfo, baseRequest.getSessionInfo().getLoginId(), 
//        		IMBNAConstants.ALERT_TYPE_CD_SECUREGENERIC, request.getIsPrimaryUser().booleanValue());
//        
//        // ************ Fields Identified from the UI
//        if (request.getRequestPayload().getEmailNotificationInfo() != null) {
//
//            String acctDeliveryPreference = request.getRequestPayload().getAcctDeliveryPreference()
//                    .getAcctDeliveryPreference().value();
//            if (acctDeliveryPreference.equalsIgnoreCase(DeliveryPreferenceType.ONLINE.value()))
//            	emailInfoBean.addAttribute(CONTENT_CD, IMBNAConstants.ESTATEMENT_OPT_IN);
//            else
//            	emailInfoBean.addAttribute(CONTENT_CD, IMBNAConstants.ESTATEMENT_OPT_OUT);
//
//        }
//        
//        emailInfoBean.setAcctNum(request.getAcctNum());
//        emailInfoBean.setCustId(request.getCustId());
//		
//		emailInfoBean.addAttribute(ESTATEMENT_FIRST_NAME, notificationInfo.getPrimaryUserFirstName());
//		emailInfoBean.addAttribute(ESTATEMENT_DATE, ISO_DATE.format(LocalDate.now()));
//		emailInfoBean.addAttribute(ESTATEMENT_PRODUCT_NAME, notificationInfo.getCardName());
//		emailInfoBean.addAttribute(ESTATEMENT_CARD_FOUR_DIGIT, notificationInfo.getPrimaryUserCardEnding());
//		
//        return emailInfoBean;
    }

    @Override
    public MsecValidator getValidator() {
        return null;
    }
}