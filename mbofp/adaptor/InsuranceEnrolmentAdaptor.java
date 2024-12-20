package com.td.mbna.msec.midtier.mbofp.adaptor;

import com.td.api.mbofp.request.insuranceenrolment.Individual;
import com.td.api.mbofp.request.insuranceenrolment.InsuranceEnrolmentEvent;
import com.td.api.mbofp.request.insuranceenrolment.InsuranceEnrolmentRequest;
import com.td.api.mbofp.response.insuranceenrolment.InsuranceEnrolmentResponse;
import com.td.api.mbofp.shared.AgreementAltkey;
import com.td.mbna.msec.midtier.offers.payload.requestinsurance.RequestInsuranceResponse;
import com.td.mbna.msec.midtier.util.services.MSECConstants;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class InsuranceEnrolmentAdaptor extends MbnaOfpAdaptor {

    public InsuranceEnrolmentRequest getRequest(Map<String, Object> params) {
        AgreementAltkey agreementAltkey = new AgreementAltkey();
        agreementAltkey.setCardNum((String) params.get(PARAM_CARD_NO));

        Individual individual = new Individual();
        individual.setPartyId((String) params.get(PARAM_CUSTOMER_ID));

        InsuranceEnrolmentEvent insuranceEnrolmentEvent = new InsuranceEnrolmentEvent();
        insuranceEnrolmentEvent.setAgreementAltkey(agreementAltkey);
        insuranceEnrolmentEvent.setIndividual(individual);
        insuranceEnrolmentEvent.setProductId((String) params.get(PARAM_SUBPRODUCT_ID));
        insuranceEnrolmentEvent.setSolicitationChannelTypeCd(MSECConstants.INTERNET_SECURE);
        insuranceEnrolmentEvent.setAccessChannelTypeCd(MSECConstants.ONLINE_SECURE_SITE);

        InsuranceEnrolmentRequest request = new InsuranceEnrolmentRequest();
        request.setInsuranceEnrolmentEvent(insuranceEnrolmentEvent);
        return request;
    }

    public RequestInsuranceResponse getResponse(InsuranceEnrolmentResponse ier) {
        RequestInsuranceResponse response = new RequestInsuranceResponse();
        com.td.mbna.msec.midtier.offers.payload.requestinsurance.ResponsePayload responsePayload = new com.td.mbna.msec.midtier.offers.payload.requestinsurance.ResponsePayload();
        
        // check ier status:  eventId
        if (ier != null && ier.getEventId() != null) {
        	responsePayload.setStatus(true);
        } else {
        	responsePayload.setStatus(false);
        }
        
        response.setResponsePayload(responsePayload);
        return response;
    }
    /*
	public InsuranceEnrolmentResponse insuranceEnrolment(Map<String, Object> params, String token) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(apiOfmCcaEndPoint)
        		.path(PATH_ACCOUNT + (String)params.get(PARAM_ACCOUNT_NO) + PATH_INSURANCE_ENROLMENT);
        
        AgreementAltkey agreementAltkey = new AgreementAltkey();
        agreementAltkey.setCardNum((String)params.get(PARAM_CARD_NO));

        Individual individual = new Individual();
        individual.setPartyId((String)params.get(PARAM_CUSTOMER_ID));
        
        InsuranceEnrolmentEvent insuranceEnrolmentEvent = new InsuranceEnrolmentEvent();
        insuranceEnrolmentEvent.setAgreementAltkey(agreementAltkey);
        insuranceEnrolmentEvent.setIndividual(individual);
        insuranceEnrolmentEvent.setProductId((String)params.get(PARAM_SUBPRODUCT_ID));
        insuranceEnrolmentEvent.setSolicitationChannelTypeCd(MSECConstants.INTERNET_SECURE);
        insuranceEnrolmentEvent.setAccessChannelTypeCd(MSECConstants.ONLINE_SECURE_SITE);
        
        InsuranceEnrolmentRequest request = new InsuranceEnrolmentRequest();
        request.setInsuranceEnrolmentEvent(insuranceEnrolmentEvent);
        
        HttpEntity<InsuranceEnrolmentRequest> requestEntity = new HttpEntity<>(request, addAuthorizationHeader(token));
        
        ResponseEntity<InsuranceEnrolmentResponse> responseEntity = restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.POST, requestEntity, InsuranceEnrolmentResponse.class);

		return responseEntity.getBody();

	}	*/

}
