package com.td.mbna.msec.midtier.offers;

import com.td.mbna.msec.midtier.mbofp.MbnaOFP;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.*;
import com.td.mbna.msec.midtier.util.tsys.TsysHelper;
import com.td.mbna.msec.midtier.util.tsys.TsysRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RequestInsuranceOperation implements MsecMidtierCommonOperations<com.td.mbna.msec.midtier.offers.payload.requestinsurance.RequestInsuranceRequest, com.td.mbna.msec.midtier.offers.payload.requestinsurance.RequestInsuranceResponse> {

	private static MbnaLogger logger = new MbnaLogger(RequestInsuranceOperation.class);

	@Autowired 
	private MbnaOFP mbnaOFP;

	@Override
	public com.td.mbna.msec.midtier.offers.payload.requestinsurance.RequestInsuranceResponse invokeService(com.td.mbna.msec.midtier.offers.payload.requestinsurance.RequestInsuranceRequest request, String... token) {
    	String interimDate = "1970-01-01";
    	String interimNumeric = "0";
    	String interimString = "EMPTY";

		try {
			
			//need to call update offer disposition
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

			//second call requestInsurance
			// Retrieve relevant details from UI request and auto-generate the Message ID
			paramValues.clear();
			paramValues = TsysHelper.genStandardParams(TsysRequest.requestInsurance, request);
			
			com.td.mbna.msec.midtier.offers.payload.requestinsurance.RequestPayload requestPL = request.getRequestPayload();
			
	    	paramValues.put("accountNo", (request.getAcctNum() == null || request.getAcctNum().length() == 0) ? interimNumeric : request.getAcctNum()); 			
	    	paramValues.put("cardNumber", (requestPL.getCardNumber() == null || requestPL.getCardNumber().length() == 0) ? interimNumeric : requestPL.getCardNumber()); 			
	    	paramValues.put("offerId", (requestPL.getSelectedOffer().getOfferID() == null || requestPL.getSelectedOffer().getOfferID().length() == 0) ? interimNumeric : requestPL.getSelectedOffer().getOfferID());
	    	paramValues.put("subProductId",(requestPL.getSelectedOffer().getSubProductId() == null || requestPL.getSelectedOffer().getSubProductId().length() == 0) ? interimNumeric : requestPL.getSelectedOffer().getSubProductId());
	    	
	    	com.td.mbna.msec.midtier.types.common.CardHolderType cardHolder = requestPL.getCardHolder();
	    	paramValues.put("customerId", (cardHolder.getCustomerID() == null || cardHolder.getCustomerID().length() == 0) ? interimNumeric : cardHolder.getCustomerID()); 			
			paramValues.put("birthDt", (cardHolder.getBirthDate() == null || cardHolder.getBirthDate().length() == 0) ? interimDate : cardHolder.getBirthDate());
			paramValues.put("firstName", (cardHolder.getFirstName() == null || cardHolder.getFirstName().length() == 0) ? interimString : cardHolder.getFirstName());
			paramValues.put("lastName", (cardHolder.getLastName() == null || cardHolder.getLastName().length() == 0) ? interimString : cardHolder.getLastName());
			paramValues.put("languagePreference", (requestPL.getCardHolder().getLanguageCode() == null || requestPL.getCardHolder().getLanguageCode().length() == 0) ? interimString : requestPL.getCardHolder().getLanguageCode());

			paramValues.put("primaryPhoneNumber", (requestPL.getPrimaryPhoneNumber().getPhoneNumber() == null || requestPL.getPrimaryPhoneNumber().getPhoneNumber().length() == 0) ? interimString : requestPL.getPrimaryPhoneNumber().getPhoneNumber());

			com.td.mbna.msec.midtier.types.common.UnformattedAddress address = requestPL.getAddress();
			paramValues.put("addressLine1", (address.getAddrLine1() == null || address.getAddrLine1().length() == 0) ? interimString : address.getAddrLine1());
			paramValues.put("addressLine2", (address.getAddrLine2() == null || address.getAddrLine2().length() == 0) ? interimString : address.getAddrLine2());
			paramValues.put("city", (address.getCity() == null || address.getCity().length() == 0) ? interimString : address.getCity());
			paramValues.put("province", (address.getProvince() == null || address.getProvince().length() == 0) ? interimString : address.getProvince());
			paramValues.put("postalCode", (address.getPostalCode() == null || address.getPostalCode().length() == 0) ? interimDate : address.getPostalCode());
	    	paramValues.put("callId", "-1");
	    	paramValues.put("associatedId", "");

	    	com.td.mbna.msec.midtier.offers.payload.requestinsurance.RequestInsuranceResponse response = this.mbnaOFP.insuranceEnrolment(paramValues, token[0]);
	    	return response;

		} catch (Exception e) {
			logger.error("invokeService", e.getMessage(), e);
			throw ExceptionUtil.genRuntimeException(e);
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
		return null;
	}
}
