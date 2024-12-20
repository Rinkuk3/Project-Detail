package com.td.mbna.msec.midtier.offers;

import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.mbofp.MbnaOFP;
import com.td.mbna.msec.midtier.offers.payload.requestproductchange.RequestProductChangeRequest;
import com.td.mbna.msec.midtier.offers.payload.requestproductchange.RequestProductChangeResponse;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.UuidUtil;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import javax.annotation.PostConstruct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RequestProductChangeOperation implements MsecMidtierCommonOperations<RequestProductChangeRequest, RequestProductChangeResponse> {
    private static MbnaLogger logger = new MbnaLogger(RequestProductChangeOperation.class);

    private ValangValidator requestProductChangeRequestValidator;

    @Autowired
    private MbnaOFP mbnaOFP;

    private MsecValidator msecValidator;

    @PostConstruct
    private void init() {
        msecValidator = new MsecVlangValidator(requestProductChangeRequestValidator);
    }

    @Override
    public RequestProductChangeResponse invokeService(RequestProductChangeRequest request, String... token) {
        try {
            String acctNum = request.getAcctNum();

            // First, we need to call updateOfferDisposition
            Map<String, Object> paramValues = new HashMap<String, Object>();
            paramValues.put("msgId1", UuidUtil.genUuid());
            paramValues.put("msgId2", UuidUtil.genUuid());
            paramValues.put("offerId", request.getRequestPayload().getSelectedOffer().getOfferID());
            paramValues.put("acctId", acctNum);
            paramValues.put("roleCD", request.getRequestPayload().getRoleCD());
            paramValues.put("subProductId", request.getRequestPayload().getSelectedOffer().getSubProductId());

            this.mbnaOFP.updateOfferDisposition(paramValues, token[0]);

            // Second, call requestProductChange
            Map<String, Object> paramValues2 = new HashMap<String, Object>();
            paramValues2.put("msgId", UuidUtil.genUuid());
            paramValues2.put("msgId2", UuidUtil.genUuid());
            paramValues2.put("offerID", request.getRequestPayload().getSelectedOffer().getOfferID());
            paramValues2.put("acctId", acctNum);
            paramValues2.put("subProductID", request.getRequestPayload().getSelectedOffer().getSubProductId());
            paramValues2.put("offerContext", request.getRequestPayload().getSelectedOffer().getOfferType());
            paramValues2.put("langPref", request.getRequestPayload().getLanguagePref());
            paramValues2.put("cardNumber", request.getRequestPayload().getCardNumber());

            RequestProductChangeResponse response = mbnaOFP.requestProductChange(paramValues2, token[0]);
            return response;
        } catch (Exception e) {
            logger.error("invokeService", e.getMessage(), e);
            throw MidtierUtilHelper.prepareBusinessException("MS542", "MS542", e);
        }
    }

    @Override
    public boolean requiresDisclosureConsent() {
        return true;
    }

    @Override
    public String getConsentDisclosureFailedMsgCode() {
        return "MS542";
    }

    @Override
    public boolean generateAutoComment() {
        return false;
    }

    @Override
    public List<String> createAutoComment(BaseRequest request, BaseResponse response) {
        return null;
    }

//	private static final String PC_FIRST_NAME = "firstName";
//	private static final String PC_APP_DATE = "appDate";
//	private static final String PC_PRODUCT_NAME = "productName";
//	private static final String PC_LAST_FOUR_DIGIT = "cardLastFourDigit";

//    public EmailInfo getEmailInfoBean(BaseRequest request, BaseResponse response) {
//		EmailNotificationInfoType emailNotificationInfoType = ((RequestProductChangeRequest) request).getRequestPayload().getEmailNotificationInfo();
//		EmailInfoImpl emailInfoBean = new EmailInfoImpl(emailNotificationInfoType, request.getSessionInfo().getLoginId(), IMBNAConstants.ALERT_TYPE_CD_PRODUCTCHANGE, request.getIsPrimaryUser() == null ? false : request.getIsPrimaryUser().booleanValue());
//		emailInfoBean.setConnectId(request.getSessionInfo().getConnectId());
//        if (emailNotificationInfoType == null) {
//        	return null;
//        }
//
//        emailInfoBean.setAcctNum(request.getAcctNum());
//        
//		LocalDate now = LocalDate.now();
//		emailInfoBean.addAttribute(PC_FIRST_NAME, emailNotificationInfoType.getPrimaryUserFirstName());
//		emailInfoBean.addAttribute(PC_APP_DATE, ISO_DATE.format(now));
//		emailInfoBean.addAttribute(PC_LAST_FOUR_DIGIT, emailNotificationInfoType.getPrimaryUserCardEnding());  
//		emailInfoBean.addAttribute(PC_PRODUCT_NAME, emailNotificationInfoType.getCardName());
//
//		return emailInfoBean;
//    }
    
	@Override
	public EmailInfo getEmailInfoBean(BaseRequest request, BaseResponse response) {
	  return null;
	}

	@Override
    public MsecValidator getValidator() {
        return msecValidator;
    }
}
