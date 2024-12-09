package com.td.mbna.msec.midtier.creditcard;

import static java.time.format.DateTimeFormatter.ISO_DATE;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import com.td.mbna.msec.midtier.creditcard.payload.decreasecardlimit.DecreaseCardLimitRequest;
import com.td.mbna.msec.midtier.creditcard.payload.decreasecardlimit.DecreaseCardLimitResponse;
import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.mbcca.MbnaCCA;
import com.td.mbna.msec.midtier.mbcca.adaptor.TdCreditCardAdaptor;
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

@Component
public class DecreaseCardLimitOperation implements MsecMidtierCommonOperations<DecreaseCardLimitRequest, DecreaseCardLimitResponse> {

    @Autowired
    private ValangValidator decreaseCardLimitRequestValidator;
    private MsecValidator msecDecreaseCardLimitRequestValidator;

    @Autowired
    private MbnaCCA mbnaCCA;

    @PostConstruct
    private void init() {
        msecDecreaseCardLimitRequestValidator = new MsecVlangValidator(decreaseCardLimitRequestValidator);
    }

    private final static String CREDIT_LIMIT_CHANGE_ACT = "DECR";
    private static final String CONTENT_CD = "contentCd";
	private static final String DECR_FIRST_NAME = "firstName";
	private static final String DECR_DATE = "appDate";
	private static final String DECR_PRODUCT_NAME = "productName";
	private static final String DECR_FOUR_DIGIT = "cardLastFourDigit";

	private static MbnaLogger logger = new MbnaLogger(DecreaseCardLimitOperation.class);

    @Override
    public DecreaseCardLimitResponse invokeService(DecreaseCardLimitRequest jsonRequest, String... token) {

        try {

            if (jsonRequest.getRequestPayload().getConfirmed() == null || !jsonRequest.getRequestPayload().getConfirmed()) {
                return new DecreaseCardLimitResponse();
            }

            // Generate updateCardLimit request for the backend web service operation

            Map<String, Object> paramValues = new HashMap<>();
            paramValues.put(TdCreditCardAdaptor.NEW_LIMIT, jsonRequest.getRequestPayload().getCreditLimit());

            paramValues.put(TdCreditCardAdaptor.CUR_LIMIT, jsonRequest.getRequestPayload().getCurrentCreditLimit());

            paramValues.put(TdCreditCardAdaptor.CREDIT_LIMIT_CHANGE_ACTION, CREDIT_LIMIT_CHANGE_ACT);

            if (jsonRequest.isMultiCard()) {
                paramValues.put("allCards", false);
                paramValues.put("cardNum", jsonRequest.getCardNum());
            }

            
            return mbnaCCA.decreaseCreditLmt(jsonRequest.getAcctNum(), jsonRequest.isMultiCard(),
                    jsonRequest.getCardNum(), paramValues, token[0]);

        } catch (Exception e) {
        	String desc = "CLD 1::1 -  mbnaCCA.decreaseCreditLmt call failed" ;
        	logger.error("DecreaseCardLimitOperation:invokeService",desc);
        	throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,desc);
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
    public List<String> createAutoComment(BaseRequest request, BaseResponse response) {
        DecreaseCardLimitRequest decreaseCardLimitReq = (DecreaseCardLimitRequest) request;
        List<String> comments = new ArrayList<String>();
        if (decreaseCardLimitReq.getRequestPayload().getConfirmed() == null || !decreaseCardLimitReq.getRequestPayload().getConfirmed()) {
            return comments;
        }
        StringBuilder sb = new StringBuilder();
        String header = CustomerNotesUtil.getHeaderContent(request, "CLD");
        sb.append(header);
        sb.append("Decrease credit limit to: $").append(decreaseCardLimitReq.getRequestPayload().getCreditLimit().toString());
        comments.add(sb.toString());
        logger.info("creating auto comment for CLD");
        return comments;
    }

    @Override
    public EmailInfo getEmailInfoBean(BaseRequest baseRequest, BaseResponse response) {
		
		DecreaseCardLimitRequest request = ((DecreaseCardLimitRequest) baseRequest);
		
		if (request.getRequestPayload().getConfirmed() == null || !request.getRequestPayload().getConfirmed() ) {
			return null;
		}
    	
		EmailNotificationInfoType notificationInfo = request.getRequestPayload().getEmailNotificationInfo();
		EmailInfoImpl emailInfoBean = new EmailInfoImpl(notificationInfo, baseRequest.getSessionInfo().getLoginId(), IMBNAConstants.ALERT_TYPE_CD_SECUREGENERIC, request.getIsPrimaryUser() == null ? false : request.getIsPrimaryUser().booleanValue());
		emailInfoBean.setConnectId(baseRequest.getSessionInfo().getConnectId());
		if (notificationInfo == null){
			return null;
		}
		
		emailInfoBean.setAcctNum(request.getAcctNum());
		
    	emailInfoBean.addAttribute(CONTENT_CD, IMBNAConstants.BUSINESSEVENT_ID_DECREASECARDLIMITREQUEST);
		emailInfoBean.addAttribute(DECR_FIRST_NAME, notificationInfo.getPrimaryUserFirstName());
		emailInfoBean.addAttribute(DECR_DATE, ISO_DATE.format(LocalDate.now()));
		emailInfoBean.addAttribute(DECR_PRODUCT_NAME, notificationInfo.getCardName());
		emailInfoBean.addAttribute(DECR_FOUR_DIGIT, notificationInfo.getPrimaryUserCardEnding());  
		
		return emailInfoBean;
    }

    @Override
    public MsecValidator getValidator() {
        return msecDecreaseCardLimitRequestValidator;
    }
}
