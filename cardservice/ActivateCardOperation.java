package com.td.mbna.msec.midtier.cardservice;

import static java.time.format.DateTimeFormatter.ISO_DATE;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.td.mbna.msec.midtier.mbnaad.MbnaAd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import com.td.api.mbcca.CardInfo;
import com.td.mbna.msec.midtier.cardservice.payload.activatecard.ActivateCardRequest;
import com.td.mbna.msec.midtier.cardservice.payload.activatecard.ActivateCardResponse;
import com.td.mbna.msec.midtier.cardservice.payload.eligibility.AuthorizedUser;
import com.td.mbna.msec.midtier.cardservice.payload.validatecpi.RequestPayload;
import com.td.mbna.msec.midtier.cardservice.payload.validatecpi.ValidateCPIRequest;
import com.td.mbna.msec.midtier.cardservice.payload.validatecpi.ValidateCPIResponse;
import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.mbcca.MbnaCCA;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.services.EmailInfoImpl;
import com.td.mbna.msec.midtier.services.IMBNAConstants;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.types.common.EmailNotificationInfoType;
import com.td.mbna.msec.midtier.util.CustomerNotesUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;
import com.td.mbna.msec.midtier.util.tsys.TsysHelper;
import com.td.mbna.msec.midtier.util.tsys.TsysRequest;

@Component
public class ActivateCardOperation extends CardActivationBaseOperations implements MsecMidtierCommonOperations<ActivateCardRequest, ActivateCardResponse> {

    private static MbnaLogger logger = new MbnaLogger(ActivateCardOperation.class);

    private final static String TdOp_activateCard = "activateCard";
    private static final String GENERAL_ERROR = "MS601";
	private static final String CONTENT_CD = "contentCd";
	private static final String AC_FIRST_NAME = "firstName";
	private static final String AC_APP_DATE = "appDate";
	private static final String AC_PRODUCT_NAME = "productName";
	private static final String AC_LAST_FOUR_DIGIT = "cardLastFourDigit";

    @Autowired
    private ActivationUtil activationUtil;

    @Autowired
    private ValidateCPIOperation validateCPI;

    @Autowired
    private ValangValidator activateCardRequestValidator;
    private MsecValidator msecValidator;

    @Autowired
    private MbnaCCA mbnaCCA;

    @Autowired
    private MbnaAd mbnaAd;

    @PostConstruct
    private void init() {
        msecValidator = new MsecVlangValidator(activateCardRequestValidator);
    }
    @Override
    public ActivateCardResponse invokeService(ActivateCardRequest request, String... token) {
        // Calling validate cpi first always as in com.mbnaweb.cardservice.impl.ActivateCardOperationImpl.activateCard
        ValidateCPIResponse validateCPIResponse = validateCPI.invokeService(createValidateCPIRequest(request),token);

        String methodName="ActivateCardOperation:invokeService";
        if (validateCPIResponse.getErrorMsgs() != null && validateCPIResponse.getErrorMsgs().size() > 0) {
        	String desc = "CardActivation Step 5::1 - ValidateCPI failed ";
			logger.error(methodName,desc);
            throw  MidtierUtilHelper.prepareBusinessException(validateCPIResponse.getErrorMsgs().get(0),validateCPIResponse.getErrorMsgs().get(0)+desc);
        }
        logger.debug("succesfully called validate cpi. calling activate card");
        // 5.2
        if (! request.getRequestPayload().isMultiCard()) {
            //BAU for single card.
            return activateCard(request,true, token[0]);
        }
        
        // multi card
        ActivateCardResponse response = null;

        //if primary user
        if (request.getIsPrimaryUser() != null && request.getIsPrimaryUser()) {

            //check if pch already activated
            if (request.getRequestPayload().getPCHActivated() == null || !request.getRequestPayload().getPCHActivated()) {

                //activate PCH first
            	//5.3
                response = activateCard(request,false, token[0]);

                //pch activation fails, return right away.
                if (response.getResponsePayload().getStatus() == null || !response.getResponsePayload().getStatus()) {
                	String desc = "CardActivation Step 5::3 - PCH activation failed!";
                	logger.error(methodName,desc);
                	return response;
                }

            }

            //check if any AUs to be activated
            // 5.4
            if (request.getRequestPayload().getAuthorizedUsers() != null && request.getRequestPayload().getAuthorizedUsers().size() > 0) {

                ActivateCardRequest anAuCardActivateRequest;
                com.td.mbna.msec.midtier.cardservice.payload.activatecard.RequestPayload requestPayload;

                ActivateCardResponse anAuCardResponse = new ActivateCardResponse();
                boolean allAuPassed = true;

                for(AuthorizedUser authorizedUser : request.getRequestPayload().getAuthorizedUsers() ) {

                	if(authorizedUser == null){
                		continue;
                	}
                    requestPayload = new com.td.mbna.msec.midtier.cardservice.payload.activatecard.RequestPayload();
                    requestPayload.setCardNum(authorizedUser.getCardNumber());
                    requestPayload.setPartyKey(request.getRequestPayload().getPartyKey());
                    anAuCardActivateRequest = new ActivateCardRequest();
                    anAuCardActivateRequest.setAcctNum(authorizedUser.getCardNumber());
                    anAuCardActivateRequest.setAliasCustId(authorizedUser.getCustomerId());
                    anAuCardActivateRequest.setRequestPayload(requestPayload);
                    anAuCardActivateRequest.setSessionInfo(request.getSessionInfo());

                    anAuCardResponse = activateCard(anAuCardActivateRequest,false, token[0]);

                    if (!anAuCardResponse.getResponsePayload().getStatus()) {
                        allAuPassed = false;
                        break;
                    }

                }

                if (response == null) {
					if (allAuPassed) {
						return anAuCardResponse;
					} else {
						anAuCardResponse.getResponsePayload().setStatus(false);
						String desc = "CardActivation Step 5::4 - AU activation failed!";
	                	logger.error(methodName,desc);
						return anAuCardResponse;
					}
                }
                
                if (!allAuPassed) {
                	response.getResponsePayload().setStatus(false);
                	String desc = "CardActivation Step 5::5 - AU activation failed!";
                	logger.error(methodName,desc);
                	return response;
                }
                
                if (allAuPassed && response.getResponsePayload().getStatus()) {
                	return response;
                }                    
            }

            return response;

        }
        // if au user
    	CardInfo cardInfo = null;
        try {
            cardInfo = mbnaCCA.retrieveCreditCardInfo(request.getSessionInfo().getConnectId(), request.getRequestPayload().isMultiCard(), request.getCardNum(),request.getAliasCustId(),request.getIsPrimaryUser(),token[0]);
        } catch (Exception e) {
            String desc = "CardActivation Step 5::6 - MBCCA retrieveCreditCardInfo during card activation process failed!";
        	logger.error(methodName,desc+e.getLocalizedMessage(),e);
            throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,desc);
        }
        
        if(cardInfo ==  null || cardInfo.getCard() == null || cardInfo.getCard().getLastCardRequestReasonCd() == null){
        	String desc = "CardActivation Step 5::7 - MBCCA retrieveCreditCardInfo during card activation process, cardinfo is null or no required info returned";
        	logger.error(methodName,desc);
        	throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,desc);            	
        }
        
        ActivationUtil.LastRequestReason lastRequestReason = ActivationUtil.LastRequestReason.getEnum(cardInfo.getCard().getLastCardRequestReasonCd());
        
        if (activationUtil.canAUActivate(lastRequestReason)) {
        	return activateCard(request,false,token[0]);
        } else {
        	String desc = "CardActivation Step 5::8 - this AU is not eligible to activate card.";
        	logger.error(methodName,desc);
        	//TODO: GENERAL_ERROR to be replaced :add a error message code for this one
        	throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,desc);
        }
    }

    private ActivateCardResponse activateCard(ActivateCardRequest request, boolean activateAll, String ...token) {

    	String methodName="ActivateCardOperation:invokeService:activateCard";
    	logger.debug("succesfully called validate cpi. proceeding with activation");
    	
    	String loginId = request.getSessionInfo().getLoginId();
    	String cardNum = request.getCardNum();
    	String custId = request.getAliasCustId();
    	if (request.getRequestPayload().getCustId() != null){
    		custId = request.getRequestPayload().getCustId();
    	}
        if (request.getRequestPayload().getCardNum() != null){
            cardNum = request.getRequestPayload().getCardNum();
        }
    	
    	Map<String, Object> paramValues = TsysHelper.genStandardParams(TsysRequest.activateCard, request);
    	paramValues.put("custId", custId);
    	
    	// if only one card to be activated, we need to pass the card number and set activateAll to be false
    	if (!activateAll) {
    		paramValues.put("allCards",false);
    		paramValues.put("cardNum",request.getRequestPayload().getCardNum());
    	}
    	
    	logger.debug("Calling CardService:activateCard...REST API......");

        return mbnaAd.activateCard(request.getSessionInfo().getConnectId(), cardNum, request.getRequestPayload().getPartyKey(),token[0]);

    }

    private ValidateCPIRequest createValidateCPIRequest(ActivateCardRequest activateCardRequest)  {


        ValidateCPIRequest validateCPIRequest = new ValidateCPIRequest();
        validateCPIRequest.setSessionInfo(activateCardRequest.getSessionInfo());
        validateCPIRequest.setAuditInfo(null);
        validateCPIRequest.setMultiCard(activateCardRequest.isMultiCard());
        validateCPIRequest.setAcctNum(activateCardRequest.getAcctNum());

        RequestPayload validateCPIRequestPayload = new RequestPayload();

        validateCPIRequestPayload.setAcctId(activateCardRequest.getRequestPayload().getAcctId());
        validateCPIRequestPayload.setCardNum(activateCardRequest.getRequestPayload().getCardNum());
        validateCPIRequestPayload.setCustId(activateCardRequest.getRequestPayload().getCustId());
        validateCPIRequestPayload.setCvc(activateCardRequest.getRequestPayload().getCvc());
        validateCPIRequestPayload.setExpiryMonth(activateCardRequest.getRequestPayload().getExpiryMonth());
        validateCPIRequestPayload.setExpiryYear(activateCardRequest.getRequestPayload().getExpiryYear());
        validateCPIRequestPayload.setRealExpiryMonth(activateCardRequest.getRequestPayload().getRealExpiryMonth());
        validateCPIRequestPayload.setRealExpiryYear(activateCardRequest.getRequestPayload().getRealExpiryYear());
        validateCPIRequest.setRequestPayload(validateCPIRequestPayload);


        return validateCPIRequest;

    }

    @Override
    public boolean requiresDisclosureConsent() {
        return false;
    }

    @Override
    public String getConsentDisclosureFailedMsgCode() {
        return null;
    }

    @Override
    public boolean generateAutoComment() {
        return true;
    }

    @Override
    public List<String> createAutoComment(BaseRequest request, BaseResponse response) {
        List<String> comment = new ArrayList<String>();
        String header = CustomerNotesUtil.getHeaderContent(request, "Activation");
        comment.add(header);

        return comment;
    }

    @Override
    public EmailInfo getEmailInfoBean(BaseRequest baseRequest, BaseResponse baseResponse) {
//    TODO: do we need to check if failed before send out email - 2021-02-09 by harry	
//        // Do not send email if it is not successful
//        if (baseResponse != null && "Failure".equalsIgnoreCase(baseResponse.getStatus())){
//        	return null;
//        }
    	
    	EmailInfoImpl emailInfoBean = new EmailInfoImpl();

    	ActivateCardRequest request = (ActivateCardRequest) baseRequest;
    	ActivateCardResponse response = (ActivateCardResponse) baseResponse;
        if (response.getResponsePayload().getStatus() == null || !response.getResponsePayload().getStatus()) {
            return null;
        }
        
        EmailNotificationInfoType emailNotificationInfoType = request.getRequestPayload().getEmailNotificationInfoType();
		emailInfoBean = new EmailInfoImpl(emailNotificationInfoType, baseRequest.getSessionInfo().getLoginId(), IMBNAConstants.ALERT_TYPE_CD_SECUREGENERIC, request.getIsPrimaryUser() == null ? false : request.getIsPrimaryUser().booleanValue());
		emailInfoBean.setConnectId(baseRequest.getSessionInfo().getConnectId());
		
		if (emailNotificationInfoType == null){
			return null;
		}
		
		emailInfoBean.setAcctNum(request.getAcctNum());

        LocalDate now = LocalDate.now();
		emailInfoBean.addAttribute(CONTENT_CD, IMBNAConstants.BUSINESSEVENT_ID_ACTIVATECARDREQUEST);
		emailInfoBean.addAttribute(AC_FIRST_NAME, emailNotificationInfoType.getPrimaryUserFirstName());
		emailInfoBean.addAttribute(AC_APP_DATE, ISO_DATE.format(now));
		emailInfoBean.addAttribute(AC_LAST_FOUR_DIGIT, emailNotificationInfoType.getPrimaryUserCardEnding());  
		emailInfoBean.addAttribute(AC_PRODUCT_NAME, emailNotificationInfoType.getCardName());
		
        return emailInfoBean;
    }

    @Override
    public MsecValidator getValidator() {
        return msecValidator;
    }



}
