package com.td.mbna.msec.midtier.offers;

//import com.mbnaweb.xsd.msgs.offers.RequestCashAdvanceRegistrationRequest;
import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.mbofp.MbnaOFP;
import com.td.mbna.msec.midtier.offers.payload.requestcashadvanceregistration.RequestCashAdvanceRegistrationRequest;
import com.td.mbna.msec.midtier.offers.payload.requestcashadvanceregistration.RequestCashAdvanceRegistrationResponse;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.BackEndSrvcUtil;
import com.td.mbna.msec.midtier.util.JaxbUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.UuidUtil;
import com.td.mbna.msec.midtier.util.ods.OdsHelper;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RequestCashAdvanceRegistrationOperation implements MsecMidtierCommonOperations<RequestCashAdvanceRegistrationRequest, RequestCashAdvanceRegistrationResponse> {

	private static MbnaLogger logger = new MbnaLogger(RequestCashAdvanceRegistrationOperation.class);
	
	private final static String TdOp_requestCashAdvanceRegistration = "requestCashAdvanceRegistration";
	
	@Autowired
	private ValangValidator requestCashAdvanceRegistrationRequestValidator;

	@Autowired 
	private MbnaOFP mbnaOFP;

	private MsecValidator msecValidator;

	@PostConstruct
	private void init() {
		msecValidator = new MsecVlangValidator(requestCashAdvanceRegistrationRequestValidator);
	}
	@Override
	public RequestCashAdvanceRegistrationResponse invokeService(RequestCashAdvanceRegistrationRequest request, String... token) {
		if(request ==  null || request.getRequestPayload() ==  null ){
			return null;
		}
    	try {
			String acctNum = request.getAcctNum();
			String custId = request.getCustId();

			// First, we need to call updateOfferDisposition
			Map<String, Object> paramValues = new HashMap<String, Object>();
			paramValues.put("msgId1", UuidUtil.genUuid());
			paramValues.put("msgId2", UuidUtil.genUuid());
			paramValues.put("acctId", acctNum);
			paramValues.put("roleCD", request.getRequestPayload().getRoleCD());
			if(request.getRequestPayload().getSelectedOffer() != null){
				paramValues.put("offerId", request.getRequestPayload().getSelectedOffer().getOfferID());
				paramValues.put("subProductId", request.getRequestPayload().getSelectedOffer().getSubProductId());
			}
			
			this.mbnaOFP.updateOfferDisposition(paramValues, token[0]);
    		
    		String cardNumber = OdsHelper.getCreditCardNum(custId, acctNum);
			
    		// Second, call requestCashAdvanceRegistration
			Map<String, Object> paramValues2 = new HashMap<String, Object>();
			paramValues2.put("msgId", UuidUtil.genUuid());
			paramValues2.put("msgId2", UuidUtil.genUuid());
			paramValues2.put("acctID", acctNum);
			paramValues2.put("cardNum", cardNumber);
			if(request.getRequestPayload().getSelectedOffer() != null){
				paramValues2.put("offerID", request.getRequestPayload().getSelectedOffer().getOfferID());
				paramValues2.put("subProductID", request.getRequestPayload().getSelectedOffer().getSubProductId());
				paramValues2.put("feeType", request.getRequestPayload().getSelectedOffer().getCaOffer().getEligibleNegotiatedType());
			}
		
			String loginId = request.getSessionInfo().getLoginId();						
			JAXBContext mtJaxBContext = JaxbUtil.getJaxbContext("com.mbnaweb.xsd.msgs.offers");	
			RequestCashAdvanceRegistrationResponse response = (RequestCashAdvanceRegistrationResponse) BackEndSrvcUtil.invokeService(TdOp_requestCashAdvanceRegistration, TdOp_requestCashAdvanceRegistration, TdOp_requestCashAdvanceRegistration, TdOp_requestCashAdvanceRegistration, loginId, acctNum, acctNum,
																												paramValues2, null, BackEndSrvcUtil.TDOperation.TdOfferFulfillmentService_requestCashAdvanceRegistration,
																												mtJaxBContext);
			
			return response;
			
		} catch (Exception e) {
			logger.error("UpdateBalanceProtectionInsurance ", e.getMessage(), e);
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

	@Override
	public EmailInfo getEmailInfoBean(BaseRequest request, BaseResponse response) {
		return null;
	}

	@Override
	public MsecValidator getValidator() {
		return msecValidator;
	}
}
