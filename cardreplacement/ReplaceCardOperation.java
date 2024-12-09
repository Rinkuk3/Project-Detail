package com.td.mbna.msec.midtier.cardreplacement;

import static java.time.format.DateTimeFormatter.ISO_DATE;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.ws.soap.SOAPFaultException;

import com.td.mbna.msec.midtier.exceptions.BusinessException;
import com.td.mbna.msec.midtier.mbnaad.MbnaAd;
import com.td.mbna.msec.midtier.mbnaad.exception.MBNAException;
import com.td.mbna.msec.midtier.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import com.td.mbna.msec.midtier.cardreplacement.payload.replacecard.ReplaceCardRequest;
import com.td.mbna.msec.midtier.cardreplacement.payload.replacecard.ReplaceCardResponse;
import com.td.mbna.msec.midtier.cardreplacement.payload.replacecard.RequestPayload;
import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.services.EmailInfoImpl;
import com.td.mbna.msec.midtier.services.IMBNAConstants;
import com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.types.common.EmailNotificationInfoType;
import com.td.mbna.msec.midtier.types.common.FieldErrorType;
import com.td.mbna.msec.midtier.types.common.UnformattedAddress;
import com.td.mbna.msec.midtier.types.common.ValidationException;
import com.td.mbna.msec.midtier.util.services.JAXBJsonConverter;

@Component
public class ReplaceCardOperation implements MsecMidtierCommonOperations<ReplaceCardRequest, ReplaceCardResponse> {

    private static MbnaLogger logger = new MbnaLogger(ReplaceCardOperation.class);
    private final static String TD_ISSUECARD_PREFIX = "issueCard_replaceCard";
    private final static String SPACE = " ";
    
    private static final String CONTENT_CD = "contentCd";
	private static final String REPLCARD_FIRST_NAME = "firstName";
	private static final String REPLCARD_DATE = "appDate";
	private static final String REPLCARD_PRODUCT_NAME = "productName";
	private static final String REPLCARD_FOUR_DIGIT = "cardLastFourDigit";

    @Autowired
    private MbnaAd mbnaAd;
    @Autowired
    private ValangValidator replaceCardRequestValidator;

    private MsecValidator msecReplaceCardRequestValidator;

	@PostConstruct
	private void init() {
		msecReplaceCardRequestValidator = new MsecVlangValidator(replaceCardRequestValidator);
	}

	@Override
	public ReplaceCardResponse invokeService(ReplaceCardRequest request, String... token) {
		
		ReplaceCardResponse response = new ReplaceCardResponse();
		if (request.getRequestPayload().getConfirmed() == null || !request.getRequestPayload().getConfirmed()) {
			response.setStatus("Success");
			return response;
		}

		String loginId = request.getSessionInfo().getLoginId();
    	
    	try {
    		Map<String, Object> paramValues = new HashMap<String, Object>();
    		paramValues.put("acctNum", request.getAcctNum());
    		paramValues.put("msgId", UuidUtil.genUuid());
    		paramValues.put("msgId2", UuidUtil.genUuid());    		
    		paramValues.put("CustomerID", request.getRequestPayload().getAliasCustID());
    		String issuerId = TDwsServiceUtil.getTDServiceParam(TDwsServiceUtil.ISSUERID);    		    		
    		paramValues.put("issuerId", issuerId);    		   		    		
    		paramValues.put("CardType", "Primary");
    		paramValues.put("NumberOfCardsRequired", "1");
    		paramValues.put("CardRequestReason", "Special");
    		paramValues.put("ChargeDeliveryFeeInd", "false");
    		paramValues.put("ForceReissueIndicator", "false");
    		paramValues.put("acctId", request.getAcctNum());
			paramValues.put("allCards",!request.isMultiCard());
			paramValues.put("cardNum",request.getRequestPayload().getCardNumber());

            logger.debug("Calling Replace Card service for card replacement");
            return mbnaAd.issueCard(request.getSessionInfo().getConnectId(), request, token[0]);
        } catch (Exception e) {
             logger.error("error message : " + e.getMessage());
             if( e.getMessage().contains("Card Request is already outstanding.")) {
                ValidationException vex = new ValidationException();
                FieldErrorType fldErr = new FieldErrorType();
                fldErr.setField("CardReplacement");
                fldErr.setErrorCode("MS286");
                fldErr.setErrorDescription("Card Request is already outstanding.");
                fldErr.setSeverity("ERROR");
                vex.getFieldError().add(fldErr);

                throw vex;
            } else {
                throw ExceptionUtil.genRuntimeException(e);
            }
        }
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
    public List<String> createAutoComment(BaseRequest baseRequest, BaseResponse response) {
        ReplaceCardRequest request = ((ReplaceCardRequest) baseRequest);
        List<String> customerNotes = new ArrayList<String>();
        if (request.getRequestPayload().getConfirmed() == null || !request.getRequestPayload().getConfirmed()) {
            return customerNotes;
        }
        // Do not create autocomment if it is not successful
        if (response != null && "Failure".equalsIgnoreCase(response.getStatus())) return null;
        customerNotes.add(CustomerNotesUtil.getHeaderContent(request, "Replacement card"));
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Requested For: ");
        strBuilder.append(request.getRequestPayload().getRequestedAccountHolderName());
        strBuilder.append("  Sent to address: ");
        strBuilder.append(getAddressFromRequest(request.getRequestPayload()));
        customerNotes.add(strBuilder.toString());
        return customerNotes;
    }

    private String getAddressFromRequest(RequestPayload requestPayload) {

        UnformattedAddress address = requestPayload.getAddress();

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(address.getAddrLine1());
        if (address.getCity() != null && !address.getCity().isEmpty()) {
            strBuilder.append(SPACE);
            strBuilder.append(address.getCity());
        }
        if (address.getProvince() != null && !address.getProvince().isEmpty()) {
            strBuilder.append(",").append(SPACE);
            strBuilder.append(address.getProvince());
        }
        if (address.getPostalCode() != null && !address.getPostalCode().isEmpty()) {
            strBuilder.append(SPACE);
            strBuilder.append(address.getPostalCode());
        }

        return strBuilder.toString();
    }

    @Override
    public EmailInfo getEmailInfoBean(BaseRequest baseRequest, BaseResponse baseResponse) {
    	
        // Do not send email if it is not successful
        if (baseResponse != null && "Failure".equalsIgnoreCase(baseResponse.getStatus())){
        	return null;
        }

        EmailInfoImpl emailInfo = new EmailInfoImpl();
        emailInfo.setLogonId(baseRequest.getSessionInfo().getLoginId());
        
    	ReplaceCardRequest request = ((ReplaceCardRequest) baseRequest);
        if (request.getRequestPayload().getConfirmed() == null || !request.getRequestPayload().getConfirmed()) {
        	emailInfo.setTriggerEmailNotification(false);
            return emailInfo;
        }
        
        EmailNotificationInfoType notificationInfo = request.getRequestPayload().getEmailNotificationInfo();
        
		emailInfo = new EmailInfoImpl(notificationInfo, baseRequest.getSessionInfo().getLoginId(), IMBNAConstants.ALERT_TYPE_CD_SECUREGENERIC, request.getIsPrimaryUser() == null ? false : request.getIsPrimaryUser().booleanValue());
		emailInfo.setConnectId(baseRequest.getSessionInfo().getConnectId());
		if (notificationInfo == null){
			return null;
		}

		emailInfo.setAcctNum(request.getAcctNum());
        
        emailInfo.addAttribute(CONTENT_CD,IMBNAConstants.BUSINESSEVENT_ID_REPLACECARDREQUEST);
        emailInfo.addAttribute(REPLCARD_FIRST_NAME, notificationInfo.getPrimaryUserFirstName());
        emailInfo.addAttribute(REPLCARD_DATE, ISO_DATE.format(LocalDate.now()));
        emailInfo.addAttribute(REPLCARD_PRODUCT_NAME, notificationInfo.getCardName());
        emailInfo.addAttribute(REPLCARD_FOUR_DIGIT, notificationInfo.getPrimaryUserCardEnding());
        
        return emailInfo;
    }

    @Override
    public MsecValidator getValidator() {
        return msecReplaceCardRequestValidator;
    }
}
