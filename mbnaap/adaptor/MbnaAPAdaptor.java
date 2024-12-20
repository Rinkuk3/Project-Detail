package com.td.mbna.msec.midtier.mbnaap.adaptor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

import com.td.api.mbnaap.common.*;
import com.td.api.mbpad.request.addconsent.AddConsentRequest;
import com.td.api.mbpad.request.addconsent.CreditCardAgreementPaymentInstruction;
import com.td.api.mbpad.request.adddirectcredit.AddDirectCreditRequest;
import com.td.api.mbpad.response.adddirectcredit.AddDirectCreditResponse;
import com.td.api.mbpad.response.retrievedirectcredit.RetrieveDirectCreditResponse;
import com.td.api.mbpad.response.retrievedirectcreditlist.RetrieveDirectCreditListResponse;
import com.td.mbna.msec.midtier.autopay.payload.addpad.AddPadRequest;
import com.td.mbna.msec.midtier.autopay.payload.addpad.AddPadResponse;
import com.td.mbna.msec.midtier.autopay.payload.checkpadenrolled.CheckPadEnrolledResponse;
import com.td.mbna.msec.midtier.autopay.payload.retrievepad.RetrievePadResponse;

@Service
public class MbnaAPAdaptor {
	
	private static final String STATUS_ACTIVE = "ACTIVE";
	private static final String STATUS_PENDING = "PENDING";

	public CheckPadEnrolledResponse checkPadEnrolled(RetrieveDirectCreditListResponse response){
		CheckPadEnrolledResponse checkPadEnrolledResponse = new CheckPadEnrolledResponse();
		checkPadEnrolledResponse.getResponsePayload().setEnrolledForPad(false);
		
		if (response == null || response.getDirectCredit() == null || response.getDirectCredit().isEmpty()){
			return checkPadEnrolledResponse;
		}
		
		for (DirectCredit dc: response.getDirectCredit()){
			if ((STATUS_ACTIVE.equalsIgnoreCase(dc.getStatusCd()) || STATUS_PENDING.equalsIgnoreCase(dc.getStatusCd()) ) && dc.getArrangementId() != null && dc.getArrangementId().trim().length() > 0){
				checkPadEnrolledResponse.getResponsePayload().setArrangementId(dc.getArrangementId().trim());
				checkPadEnrolledResponse.getResponsePayload().setEnrolledForPad(true);
				checkPadEnrolledResponse.getResponsePayload().setWithin90Days(false);
				checkPadEnrolledResponse.getResponsePayload().setStatusCd(dc.getStatusCd());
				long before90Days = (new Date()).getTime() - (1000 * 60 * 60 * 24 * 90);
				if (dc.getStatusStartDttm() != null && dc.getStatusStartDttm().getTime() > before90Days ){
					checkPadEnrolledResponse.getResponsePayload().setWithin90Days(true);
				}
			}
		}

		return checkPadEnrolledResponse;
	}

	public RetrievePadResponse getRetrivePadResponse(RetrieveDirectCreditResponse retrieveDirectCreditResponse) {
	    RetrievePadResponse response = new RetrievePadResponse();
	    if (retrieveDirectCreditResponse == null || retrieveDirectCreditResponse.getDirectCredit() == null ) {
	    	return response;
	    }
	    
	    response.getResponsePayload().setStatusCd(retrieveDirectCreditResponse.getDirectCredit().getStatusCd());

	    if (retrieveDirectCreditResponse.getDirectCredit().getInternalDirectCredit() == null) {
	    	return response;
	    }
	    
	    InternalDirectCredit internalDirectCredit = retrieveDirectCreditResponse.getDirectCredit().getInternalDirectCredit();

	    response.getResponsePayload().setTimePeriodCd(internalDirectCredit.getTimePeriodCd());
	    response.getResponsePayload().setPaymentTypeName(internalDirectCredit.getPaymentTypeName());
	    response.getResponsePayload().setBranchAddressTxt(internalDirectCredit.getBranchAddressTxt());

	    if (internalDirectCredit.getGenericAgreementAltkey() == null) {
	    	return response;
	    }
	    
	    response.getResponsePayload().setBankNum(internalDirectCredit.getGenericAgreementAltkey().getBankNum());
	    response.getResponsePayload().setBranchNum(internalDirectCredit.getGenericAgreementAltkey().getBranchNum());
	    response.getResponsePayload().setBankAccount(internalDirectCredit.getGenericAgreementAltkey().getAccountNum());
	    
	    return response;
	}
	public AddConsentRequest getAddConsentRequest(AddPadRequest addPadRequest, boolean toAddConsentExisting) {
		if (addPadRequest == null || addPadRequest.getRequestPayload() == null ) {
			return null;
		}
	
		AddConsentRequest addConsentRequest = new AddConsentRequest();
		CreditCardAgreementPaymentInstruction creditCardAgreementPaymentInstruction = new CreditCardAgreementPaymentInstruction();

		if (toAddConsentExisting) {
			CreditCardAgreementAltkey creditCardAgreementAltkey = new CreditCardAgreementAltkey();
			creditCardAgreementAltkey.setCardNum(addPadRequest.getRequestPayload().getCardNum());
			creditCardAgreementPaymentInstruction.setCreditCardAgreementAltkey(creditCardAgreementAltkey);
		}
		creditCardAgreementPaymentInstruction.setPaymentHoldConsentCd("5");
		creditCardAgreementPaymentInstruction.setConfirmationLetterRequiredInd(false);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		long currentTime = (new Date()).getTime();
		Date latencyTime = new Date(currentTime + 2000); //network latency

		String paymentHoldDt = simpleDateFormat.format(latencyTime);
		creditCardAgreementPaymentInstruction.setPaymentHoldDt(paymentHoldDt);
		
		addConsentRequest.setCreditCardAgreementPaymentInstruction(creditCardAgreementPaymentInstruction);
		return addConsentRequest;
	}
	
	public AddDirectCreditRequest getAddDirectCreditRequest(AddPadRequest addPadRequest) {
		if (addPadRequest == null || addPadRequest.getRequestPayload() == null ) {
			return null;
		}
		
		AddDirectCreditRequest addDirectCreditRequest = new AddDirectCreditRequest();
		DirectCredit directCredit = new DirectCredit();
		InternalDirectCredit internalDirectCredit = new InternalDirectCredit();

		internalDirectCredit.setTimePeriodCd(addPadRequest.getRequestPayload().getTimePeriodCd());
		internalDirectCredit.setPaymentTypeName(addPadRequest.getRequestPayload().getPaymentTypeName());
		internalDirectCredit.setRecurrenceCnt(999);
		internalDirectCredit.setTelephoneChannelInd(true);
		internalDirectCredit.setCreditCardAgreementCycleDateNum(addPadRequest.getRequestPayload().getCreditCardAgreementCycleDateNum());
		
		CreditCardAgreementAltkey creditCardAgreementAltkey = new CreditCardAgreementAltkey();
		creditCardAgreementAltkey.setCardNum(addPadRequest.getRequestPayload().getCardNum());
		GenericAgreementAltkey genericAgreementAltkey = new GenericAgreementAltkey();
		genericAgreementAltkey.setBankNum(addPadRequest.getRequestPayload().getBankNum());
		genericAgreementAltkey.setBranchNum(addPadRequest.getRequestPayload().getBranchNum());
		genericAgreementAltkey.setAccountNum(addPadRequest.getRequestPayload().getBankAccount());
//		genericAgreementAltkey.setAccountNum(addPadRequest.getAcctNum());
		MbpdExtension mbpdExtension = new MbpdExtension();
		mbpdExtension.setChequingAgreementHolderFullName(addPadRequest.getRequestPayload().getChequingAgreementHolderFullName());
		
		internalDirectCredit.setCreditCardAgreementAltkey(creditCardAgreementAltkey);
		internalDirectCredit.setGenericAgreementAltkey(genericAgreementAltkey);
		internalDirectCredit.setMbpdExtension(mbpdExtension);
		
		directCredit.setInternalDirectCredit(internalDirectCredit);
		addDirectCreditRequest.setDirectCredit(directCredit);
		return addDirectCreditRequest;
	}

	public AddPadResponse getAddPadResponse(AddDirectCreditResponse body) {
		AddPadResponse response = new AddPadResponse();
		response.getResponsePayload().setArrangementId(body.getArrangementId());
		
		return response;
	}

}
