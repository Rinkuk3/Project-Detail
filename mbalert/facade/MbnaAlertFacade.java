package com.td.mbna.msec.midtier.mbalert.facade;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.td.api.mbalert.request.addalertevent.AlertEventRequest;
import com.td.api.mbalert.response.addalertevent.AlertEventResponse;
import com.td.mbna.msec.midtier.mbalert.adaptor.AlertEventAdaptor;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.services.IMBNAConstants;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.perf.ProfileLog;
import com.td.mbna.msec.midtier.util.services.MSECConstants;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;

@Service
public class MbnaAlertFacade {
    private static final String apiAlertEventEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_ALERT_EVENT_ENDPT);
	private static final String BT_REFERENCE_NUMBER = "referenceNumber";
	private static final String CONTENT_CD = "contentCd";
	private static final String BT_TO_CREDITOR = "bttocreditor";
	private static final String UPDATE_PROFILE = "KycUpdateProfile";

    private static final String IP_APP_DATE = "appDate";
    private static final String IP_NICK_NAME = "planNickname";
    private static final String IP_TERM = "planTerm";
    private static final String IP_AIR = "air";
    private static final String IP_FEE_RATE = "feeRate";
    private static final String IP_EFFECTIVE_DATE = "effctvDate";
    private static final String IP_PURCHASE_AMT = "purchAmt";
    private static final String IP_BORROW_COST = "borrowCost";
    private static final String IP_FEE_AMT = "feeAmt";
    private static final String IP_TOTAL_INTEREST = "totalInterest";
    private static final String IP_TOTAL_PLAN_AMT = "totalPlanAmt";
    private static final String IP_MONTHLY_PLAN_AMT = "monthlyPlanAmt";
    private static final String IP_MIN_PAYMENT = "minPmt";

    private static final MbnaLogger logger = new MbnaLogger(MbnaAlertFacade.class);

    @Autowired
    protected RestTemplate restTemplate;

    @Autowired
    private AlertEventAdaptor alertEventAdaptor;
    
    @ProfileLog
    public boolean addAlertEvent(EmailInfo emailInfo) {
    	if (emailInfo == null) {
    		logger.error("addAlertEvent failed since emailInfo is null");
    		return false;
    	}

        if (emailInfo.getBusinessEventID() == null || emailInfo.getBusinessEventID().equals("")) {
            logger.error("email business event is null for accountNum: " + emailInfo.getAcctNum());
            return false;
        }

        if (emailInfo.getPrimaryEmailAddress() == null || emailInfo.getPrimaryEmailAddress().trim().equals("")) {
            logger.error("Primary email of the user is null for accountNum: " + emailInfo.getAcctNum());
            return false;
        }

        if (BT_TO_CREDITOR.equalsIgnoreCase((String)emailInfo.getAttribute(CONTENT_CD))){
        	boolean allSent = true;
        	for (String confirmationNumber : emailInfo.getConfirmationNumbers()) {
        		emailInfo.addAttribute(BT_REFERENCE_NUMBER, confirmationNumber);
        		boolean sent = sendEmail(emailInfo);
        		if (!sent) {
        			logger.error("Failed to send email with BT confirmation Number: " + confirmationNumber);
        			allSent = false;
        		}
        	}
        	return allSent;
        } 
        
    	boolean sent = sendEmail(emailInfo);
    	if (!sent && IMBNAConstants.ALERT_TYPE_CD_IPENROLLMENT.equals(emailInfo.getBusinessEventID())){
    		logIPEmailInfo(emailInfo);
    	} else if (UPDATE_PROFILE.equalsIgnoreCase((String)emailInfo.getAttribute(CONTENT_CD))){
		 	if (emailInfo.getOldEmailAddress() != null){
		 		emailInfo.setPrimaryEmailAddress(emailInfo.getOldEmailAddress());
			 	sent = sendEmail(emailInfo);
		 	}
		}
    	
    	return sent;
    }

	private boolean sendEmail(EmailInfo emailInfo) {
		if (emailInfo == null || emailInfo.getPrimaryEmailAddress() == null || emailInfo.getPrimaryEmailAddress().trim().isEmpty()){
			logger.error("MbnaAlertFacade.sendEmail()","request EmailInfo is null or incomplete ! ");
			return false;
		}
		
		AlertEventRequest request = alertEventAdaptor.getRequest(emailInfo);
        HttpEntity<AlertEventRequest> requestEntity = new HttpEntity<>(request, addAuthorizationHeader(emailInfo.getToken()));

        
        ResponseEntity<AlertEventResponse> responseEntity = null;
        try{
            responseEntity = restTemplate.exchange(apiAlertEventEndPoint, HttpMethod.POST, requestEntity, AlertEventResponse.class);
            if (responseEntity != null && responseEntity.getBody()!=null){
            	return true;
            }
        } catch (Exception e){
        	logger.error("MbnaAlertFacade.sendEmail()", " Failed to call Alert Events API: getBusinessEventID = " + emailInfo.getBusinessEventID()+" contentCd = "+(String)emailInfo.getAttribute(CONTENT_CD)+" of cid = "+emailInfo.getConnectId(), e);
        	return false;
        }
        
        return false;
	}

    private HttpHeaders addAuthorizationHeader(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(MSECConstants.AUTHORIZATION, token);
        return headers;
    }
    
    private static final String IP_EMAIL_INFO_LOG_FORMAT = "%n==SEND IP EMAIL FAILED INFO START(%s)==%ntsysAccountId=%s%nlanguagePreference=%s%nbusinessEventId=%s%nchannel=Secure Site%nemailAddress=%s%nfirstName=%s%nAppDate=%s%ncardLastFourDigit=%s%nPlanNickname=%s%nPlanTerm=%s%nAIR=%s%nFeeRate=%s%nEffctvDate=%s%nPurchAmt=%s%nBorrowCost=%s%nFeeAmt=%s%nTotalInterest=%s%nTotalPlanAmt=%s%nMonthlyPlanAmt=%s%nMinPmt=%s%nCid=%s%nEventId=SEND IP EMAIL FAILED INFO%n==SEND IP EMAIL FAILED INFO END==";

    private static void logIPEmailInfo(EmailInfo emailInfo) {
        logger.mandatory(String.format(IP_EMAIL_INFO_LOG_FORMAT, 
        		UUID.randomUUID().toString(), 
        		emailInfo.getAcctNum(),
        		emailInfo.getPrimaryLanguagePref(), 
        		emailInfo.getBusinessEventID(), 
        		emailInfo.getPrimaryEmailAddress(), 
        		emailInfo.getPrimaryUserInfo().getFirstName(),
                emailInfo.getAttribute(IP_APP_DATE), 
                emailInfo.getCardEnding(), 
                emailInfo.getAttribute(IP_NICK_NAME), 
                emailInfo.getAttribute(IP_TERM), 
                emailInfo.getAttribute(IP_AIR), 
                emailInfo.getAttribute(IP_FEE_RATE),
                emailInfo.getAttribute(IP_EFFECTIVE_DATE), 
                emailInfo.getAttribute(IP_PURCHASE_AMT), 
                emailInfo.getAttribute(IP_BORROW_COST), 
                emailInfo.getAttribute(IP_FEE_AMT),
                emailInfo.getAttribute(IP_TOTAL_INTEREST), 
                emailInfo.getAttribute(IP_TOTAL_PLAN_AMT), 
                emailInfo.getAttribute(IP_MONTHLY_PLAN_AMT), 
                emailInfo.getAttribute(IP_MIN_PAYMENT),
                emailInfo.getConnectId()
                ));
    }

}
