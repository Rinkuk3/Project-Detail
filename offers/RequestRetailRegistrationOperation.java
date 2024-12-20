package com.td.mbna.msec.midtier.offers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.mbofp.MbnaOFP;
import com.td.mbna.msec.midtier.offers.payload.requestretailregistration.RequestRetailRegistrationRequest;
import com.td.mbna.msec.midtier.offers.payload.requestretailregistration.RequestRetailRegistrationResponse;
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


@Component
public class RequestRetailRegistrationOperation implements MsecMidtierCommonOperations<RequestRetailRegistrationRequest, RequestRetailRegistrationResponse> {
	private static MbnaLogger logger = new MbnaLogger(RequestRetailRegistrationOperation.class);
	
	private final static String TdOp_requestRetailRegistration = "requestRetailRegistration";
	@Autowired
	private ValangValidator requestRetailRegistrationRequestValidator;

	@Autowired 
	private MbnaOFP mbnaOFP;
	
	private MsecValidator msecValidator;

	@PostConstruct
	private void init() {
		msecValidator = new MsecVlangValidator(requestRetailRegistrationRequestValidator);
	}
	@Override
	public RequestRetailRegistrationResponse invokeService(RequestRetailRegistrationRequest request, String... token) {
    	try {
    		String loginId = request.getSessionInfo().getLoginId();						
			String acctNum = request.getAcctNum();
			String custId = request.getCustId();
			

			// First, we need to call updateOfferDisposition
			Map<String, Object> paramValues = new HashMap<String, Object>();
			paramValues.put("msgId1", UuidUtil.genUuid());
			paramValues.put("msgId2", UuidUtil.genUuid());
			paramValues.put("offerId", request.getRequestPayload().getSelectedOffer().getOfferID());
			paramValues.put("acctId", acctNum);
			paramValues.put("roleCD", request.getRequestPayload().getRoleCD());
			paramValues.put("subProductId", request.getRequestPayload().getSelectedOffer().getSubProductId());
			
			this.mbnaOFP.updateOfferDisposition(paramValues, token[0]);
			JAXBContext mtJaxBContext = JaxbUtil.getJaxbContext("com.mbnaweb.xsd.msgs.offers");	

    		
    		String cardNumber=null;
			cardNumber = OdsHelper.getCreditCardNum(custId, acctNum);
			
			// Second, call requestRetailRegistration
			Map<String, Object> paramValues2 = new HashMap<String, Object>();
			paramValues2.put("msgId", UuidUtil.genUuid());
			paramValues2.put("msgId2", UuidUtil.genUuid());
			paramValues2.put("offerID", request.getRequestPayload().getSelectedOffer().getOfferID());
			paramValues2.put("acctID", acctNum);
			paramValues2.put("cardNum", cardNumber);
			paramValues2.put("subProductID", request.getRequestPayload().getSelectedOffer().getSubProductId());
			

			RequestRetailRegistrationResponse mtRes = (RequestRetailRegistrationResponse) BackEndSrvcUtil.invokeService(TdOp_requestRetailRegistration, TdOp_requestRetailRegistration, TdOp_requestRetailRegistration, TdOp_requestRetailRegistration, loginId, acctNum, acctNum,
																												paramValues2, null, BackEndSrvcUtil.TDOperation.TdOfferFulfillmentService_requestRetailRegistration,
																												mtJaxBContext);
			
			return mtRes;
			
		} catch (Exception e) {
			logger.error("invoke", e.getMessage(), e);

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
