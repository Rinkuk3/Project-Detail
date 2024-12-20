package com.td.mbna.msec.midtier.statement;

import static java.time.format.DateTimeFormatter.ISO_DATE;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.td.mbna.msec.midtier.mbcca.MbnaCCA;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.services.EmailInfoImpl;
import com.td.mbna.msec.midtier.services.IMBNAConstants;
import com.td.mbna.msec.midtier.statement.payload.updateStatementDeliveryPreferences.ResponsePayload;
import com.td.mbna.msec.midtier.statement.payload.updateStatementDeliveryPreferences.UpdateStatementDeliveryPreferencesRequest;
import com.td.mbna.msec.midtier.statement.payload.updateStatementDeliveryPreferences.UpdateStatementDeliveryPreferencesResponse;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.types.common.DeliveryPreferenceType;
import com.td.mbna.msec.midtier.types.common.EmailNotificationInfoType;
import com.td.mbna.msec.midtier.util.CustomerNotesUtil;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;

import org.apache.commons.lang3.StringUtils;

@Component
public class UpdateStatementDeliveryPreferencesOperationReal implements MsecMidtierCommonOperations<UpdateStatementDeliveryPreferencesRequest, UpdateStatementDeliveryPreferencesResponse> {

    private static MbnaLogger logger = new MbnaLogger(UpdateStatementDeliveryPreferencesOperationReal.class);
    private static final String OPT_IN = "Opt-in eStatement";
    private static final String OPT_OUT = "Opt-out eStatement";    
    private static final String CONTENT_CD = "contentCd";
	private static final String ESTATEMENT_FIRST_NAME = "firstName";
	private static final String ESTATEMENT_DATE = "appDate";
	private static final String ESTATEMENT_PRODUCT_NAME = "productName";
	private static final String ESTATEMENT_CARD_FOUR_DIGIT = "cardLastFourDigit";
	
    @Autowired
    private MbnaCCA mbnaCCA;
    
    @Autowired
    private Executor midtierExecutor;

    public UpdateStatementDeliveryPreferencesResponse invokeService(UpdateStatementDeliveryPreferencesRequest jsonRequest, String... token) {
    	if(jsonRequest == null || jsonRequest.getRequestPayload() == null){
    		return null;
    	}
        try {

            String acctNum = jsonRequest.getAcctNum();

            //1 = create electronic billing call, 0 = update/maintenance call
            String notEnrolled = "Active/Currently Enrolled".equalsIgnoreCase(jsonRequest.getRequestPayload().getAcctDeliveryPreference().getEnrollmentStatus()) ? "0" : "1";

            // Not applicable anymore - /*1 = paper, 0 = paperless*/
            boolean deact = true;
            if (jsonRequest.getRequestPayload().getAcctDeliveryPreference().getAcctDeliveryPreference() == DeliveryPreferenceType.ONLINE) {

                deact = false;
                notEnrolled = "1";
            }

            UpdateStatementDeliveryPreferencesResponse resp = null;

            if ("1".equals(notEnrolled)) {
            	String emailAddress = jsonRequest.getRequestPayload().getEmailNotificationInfo() != null? jsonRequest.getRequestPayload().getEmailNotificationInfo().getPrimaryUserEmailAddress() : null;
                mbnaCCA.createElectronicBilling(acctNum, jsonRequest.isMultiCard() ? jsonRequest.getCardNum() : null, jsonRequest.isMultiCard(), emailAddress, token[0]);
            }

            try {
                mbnaCCA.updateElectronicBilling(acctNum, jsonRequest.isMultiCard(), jsonRequest.isMultiCard() ? jsonRequest.getCardNum() : null, deact, token[0]);

                UpdateStatementDeliveryPreferencesResponse response = new UpdateStatementDeliveryPreferencesResponse();
                ResponsePayload responsePayload = new ResponsePayload();
                responsePayload.setAcctDeliveryPreference(jsonRequest.getRequestPayload().getAcctDeliveryPreference());
                response.setResponsePayload(responsePayload);
                response.setStatus("Success");
                
                midtierExecutor.execute(() -> {
                    List<String> comment = createAutoComment(jsonRequest);
                    if (comment != null){
                    	mbnaCCA.creatCustomerNotes(comment, jsonRequest, token);
                    }
                });
                
                return response;

            } catch (Exception e) {
                logger.error("invokeService", "tdStatusCode is not 0:" + resp);
                return null;
            }

        } catch (Exception e) {
            logger.error("invokeService", e.getLocalizedMessage(), e);
            throw ExceptionUtil.genRuntimeException(e);
        }
    }

    @Override
    public boolean requiresDisclosureConsent() {
        return false;
    } // set this to false to prevent duplicate consent

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
        com.td.mbna.msec.midtier.statement.payload.updateStatementDeliveryPreferences.UpdateStatementDeliveryPreferencesRequest mtRequest = (com.td.mbna.msec.midtier.statement.payload.updateStatementDeliveryPreferences.UpdateStatementDeliveryPreferencesRequest) request;

        String optWhat = "Opt-in eStatement";
        if (mtRequest.getRequestPayload().getAcctDeliveryPreference().getAcctDeliveryPreference() == com.td.mbna.msec.midtier.types.common.DeliveryPreferenceType.PAPER)
            optWhat = "Opt-out eStatement";

        String header = CustomerNotesUtil.getHeaderContent(request, optWhat);

        notes.add(header);
        return notes;
    }
    
    public List<String> createAutoComment(UpdateStatementDeliveryPreferencesRequest request){
        	 
    	List<String> notes = new ArrayList<String>();
    	
    	String optWhat = OPT_IN;
    	String prefType = request.getRequestPayload().getAcctDeliveryPreference().getAcctDeliveryPreference().value();
    	
        if ( !StringUtils.isBlank(prefType) ) {
        	optWhat = prefType.equalsIgnoreCase(DeliveryPreferenceType.PAPER.value()) ? OPT_OUT : OPT_IN;
        }

        String header = CustomerNotesUtil.getHeaderContent(request, optWhat);

        notes.add(header);
        
    	return notes;
    
    }

    @Override
    public EmailInfo getEmailInfoBean(BaseRequest baseRequest, BaseResponse response) {
    	UpdateStatementDeliveryPreferencesRequest request = ((UpdateStatementDeliveryPreferencesRequest) baseRequest);
        EmailNotificationInfoType notificationInfo = request.getRequestPayload().getEmailNotificationInfo();
        if(notificationInfo == null){
        	logger.warn("notificationInfo is null!!");
        	return null;
        }
        EmailInfoImpl emailInfoBean = new EmailInfoImpl(notificationInfo, baseRequest.getSessionInfo().getLoginId(), 
        		IMBNAConstants.ALERT_TYPE_CD_SECUREGENERIC, request.getIsPrimaryUser() == null ? false : request.getIsPrimaryUser().booleanValue());
        emailInfoBean.setConnectId(baseRequest.getSessionInfo().getConnectId());
        // ************ Fields Identified from the UI
        if (request.getRequestPayload().getEmailNotificationInfo() != null) {

            String acctDeliveryPreference = request.getRequestPayload().getAcctDeliveryPreference()
                    .getAcctDeliveryPreference().value();
            if (acctDeliveryPreference.equalsIgnoreCase(DeliveryPreferenceType.ONLINE.value()))
            	emailInfoBean.addAttribute(CONTENT_CD, IMBNAConstants.ESTATEMENT_OPT_IN);
            else
            	emailInfoBean.addAttribute(CONTENT_CD, IMBNAConstants.ESTATEMENT_OPT_OUT);

        }
        
        emailInfoBean.setAcctNum(request.getAcctNum());
		
		emailInfoBean.addAttribute(ESTATEMENT_FIRST_NAME, notificationInfo.getPrimaryUserFirstName());
		emailInfoBean.addAttribute(ESTATEMENT_DATE, ISO_DATE.format(LocalDate.now()));
		emailInfoBean.addAttribute(ESTATEMENT_PRODUCT_NAME, notificationInfo.getCardName());
		emailInfoBean.addAttribute(ESTATEMENT_CARD_FOUR_DIGIT, notificationInfo.getPrimaryUserCardEnding());
		
        return emailInfoBean;
    }

    @Override
    public MsecValidator getValidator() {
        return null;
    }
}