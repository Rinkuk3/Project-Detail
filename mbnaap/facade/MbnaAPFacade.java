package com.td.mbna.msec.midtier.mbnaap.facade;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.td.api.mbpad.request.addconsent.AddConsentRequest;
import com.td.api.mbpad.request.adddirectcredit.AddDirectCreditRequest;
import com.td.api.mbpad.response.adddirectcredit.AddDirectCreditResponse;
import com.td.api.mbpad.response.retrievebranch.RetrieveBranchResponse;
import com.td.api.mbpad.response.retrievedirectcredit.RetrieveDirectCreditResponse;
import com.td.api.mbpad.response.retrievedirectcreditlist.RetrieveDirectCreditListResponse;
import com.td.api.mbpad.response.validone.ValidoneResponse;
import com.td.mbna.msec.midtier.autopay.payload.addpad.AddPadRequest;
import com.td.mbna.msec.midtier.autopay.payload.addpad.AddPadResponse;
import com.td.mbna.msec.midtier.autopay.payload.checkpadenrolled.CheckPadEnrolledResponse;
import com.td.mbna.msec.midtier.autopay.payload.retrievepad.RetrievePadResponse;
import com.td.mbna.msec.midtier.autopay.payload.updatepad.UpdatePadRequest;
import com.td.mbna.msec.midtier.autopay.payload.validatebankaccount.ValidateBankAccountRequest;
import com.td.mbna.msec.midtier.autopay.payload.validatebankaccount.ValidateBankAccountResponse;
import com.td.mbna.msec.midtier.mbnaap.adaptor.MbnaAPAdaptor;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MSECConstants;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;

import static com.td.mbna.msec.midtier.util.services.MSECConstants.APAPI_VERIFYPAD_TIMEOUT;

@Service
public class MbnaAPFacade {
    private static final String apiApEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_AP_API_ENDPT);
    private static final String apiBranchesEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_AP_BRANCHES_ENDPT);
    private static final String apiApConsentEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_AP_API_CONSENT_ENDPT);
    
    private static final String QUERY_PARAMETER_CARDNUM = "cardNum";
    private static final String QUERY_PARAMETER_BANKNUM = "bankNum";
    private static final String QUERY_PARAMETER_BRANCHNUM = "branchNum";
    private static final String QUERY_PARAMETER_ACCOUNTNUM = "accountNum";

    private static final MbnaLogger logger = new MbnaLogger(MbnaAPFacade.class);

    @Autowired
    protected RestTemplate restTemplate;
    @Autowired
    private MbnaAPAdaptor mbnaAPAdaptor; 
    
	public CheckPadEnrolledResponse checkEnrolledForPad(String cardNum, String token) {

        List<String> queryParamValue = new ArrayList<>();
        queryParamValue.add(cardNum);

        MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<>();
        queryParameters.put(QUERY_PARAMETER_CARDNUM, queryParamValue);

        String url = UriComponentsBuilder
        		.fromHttpUrl(apiApEndPoint)
        		.queryParams(queryParameters)
        		.build()
        		.encode()
        		.toUriString();

        HttpEntity<?> requestEntity = new HttpEntity<>(addAuthorizationHeader(token));
        
        ResponseEntity<RetrieveDirectCreditListResponse> httpResponse = null;
		Instant startTime = Instant.now();
		try {
			httpResponse = restTemplate.exchange(url, HttpMethod.GET, requestEntity, RetrieveDirectCreditListResponse.class);
		} catch (Exception e) {
			logger.error(" restTemplate.exchange:: exception when calling " + url + " message : " + e.getLocalizedMessage());
			return null;
		}

		Instant endTime = Instant.now();
		Duration timeElapsed = Duration.between(startTime, endTime);
		logger.debug(" API request time: "+startTime+" API response time: "+endTime+ " Time taken: "+timeElapsed.toMillis());
		if (timeElapsed.toMillis() > APAPI_VERIFYPAD_TIMEOUT){
			logger.error("API response more than the specified timeframe: " + timeElapsed.toMillis());
			return null;
		}

        CheckPadEnrolledResponse response = null;//new CheckPadEnrolledResponse();
        
		if (httpResponse != null) {					
			response= mbnaAPAdaptor.checkPadEnrolled(httpResponse.getBody());
		}
		
		if (response != null && response.getResponsePayload()!= null && response.getResponsePayload().getArrangementId() != null) {
			RetrievePadResponse retrievePadResponse = retrievePad(response.getResponsePayload().getArrangementId(), token);
			if (retrievePadResponse != null && retrievePadResponse.getResponsePayload() != null) {
				response.getResponsePayload().setAccountNum(retrievePadResponse.getResponsePayload().getBankAccount());
			}
		}
		
		return response;
	}

	public RetrievePadResponse retrievePad(String arrangementId, String token) {
		if (arrangementId == null) {
			return new RetrievePadResponse();
		}
		
		String methodName = "retrievePad(" + arrangementId + ")";

        String url = UriComponentsBuilder.fromHttpUrl(apiApEndPoint).path("/"+arrangementId).build().encode().toUriString();

        HttpEntity<?> requestEntity = new HttpEntity<>(addAuthorizationHeader(token));
        
        ResponseEntity<RetrieveDirectCreditResponse> httpResponse = null;
		try {
			httpResponse = restTemplate.exchange(url, HttpMethod.GET, requestEntity, RetrieveDirectCreditResponse.class);
		} catch (Exception e) {
			logger.error(" restTemplate.exchange:: exception when calling " + url + " message : " + e.getLocalizedMessage());
			return null;
		}

        logger.toJson(methodName, httpResponse);
		RetrievePadResponse response = mbnaAPAdaptor.getRetrivePadResponse(httpResponse.getBody());
		
		return response;
	}
	
	public boolean deletePad(String arrangementId, String token) {
		return false;
	}

	public AddPadResponse addPad(AddPadRequest addPadRequest, String token) {
		String methodName = "addPad()";
		
		//step 1. get consent
		boolean toAddConsent = true;
		String apiApConsentEndPointCard = apiApConsentEndPoint + "/c" + addPadRequest.getRequestPayload().getCardNum();
    	HttpEntity getConsentRequestEntity = new HttpEntity<>(addAuthorizationHeader(token));

    	ResponseEntity<AddConsentRequest> getConsentHttpResponse = null;
        try{
        	getConsentHttpResponse = restTemplate.exchange(apiApConsentEndPointCard, HttpMethod.GET, getConsentRequestEntity, AddConsentRequest.class);
          } catch (Exception e){
        	logger.error("failed when call " + apiApConsentEndPointCard);
        	return null;
        }

        if (getConsentHttpResponse != null && getConsentHttpResponse.getBody() != null && getConsentHttpResponse.getBody().getCreditCardAgreementPaymentInstruction() != null && getConsentHttpResponse.getStatusCode().is2xxSuccessful()){
        	toAddConsent = false;
        }

		//step 2. add/patch consent
		AddConsentRequest addConsentRequest = mbnaAPAdaptor.getAddConsentRequest(addPadRequest, toAddConsent);
    	if (addConsentRequest == null){
        	logger.error(methodName, "AddConsentRequest is null");
    		return null;
    	}

    	HttpEntity<AddConsentRequest> addConsentRequestEntity = new HttpEntity<>(addConsentRequest, addAuthorizationHeader(token));
    	logger.toJson(methodName, addConsentRequestEntity);

    	HttpMethod method = HttpMethod.PATCH;
    	String url = apiApConsentEndPointCard;
    	if (toAddConsent) {
    		method = HttpMethod.POST;
    		url = apiApConsentEndPoint;
    	}
    	
    	ResponseEntity<AddDirectCreditResponse> addConsentHttpResponse = null;
        try{
        	addConsentHttpResponse = restTemplate.exchange(url, method, addConsentRequestEntity, AddDirectCreditResponse.class);
        } catch (Exception e){
        	logger.error("failed when call " + url);
        	return null;
        }
        logger.toJson(methodName, getConsentHttpResponse);
        if (!getConsentHttpResponse.getStatusCode().is2xxSuccessful()){
        	logger.error("http response status code is: " + getConsentHttpResponse.getStatusCode());
        	return null;
        }

        if (toAddConsent) {
        	method = HttpMethod.PATCH;
        	url = apiApConsentEndPointCard;
        	addConsentHttpResponse = null;
        	addConsentRequest = mbnaAPAdaptor.getAddConsentRequest(addPadRequest, false);
        	addConsentRequestEntity = new HttpEntity<>(addConsentRequest, addAuthorizationHeader(token));
            try{
            	addConsentHttpResponse = restTemplate.exchange(url, method, addConsentRequestEntity, AddDirectCreditResponse.class);
            } catch (Exception e){
            	logger.error("failed when call " + url);
            	return null;
            }
            logger.toJson(methodName, getConsentHttpResponse);
            if (!getConsentHttpResponse.getStatusCode().is2xxSuccessful()){
            	logger.error("http response status code is: " + getConsentHttpResponse.getStatusCode());
            	return null;
            }
        }
        
        //step 3. add pad
    	AddDirectCreditRequest addDirectCreditRequest = mbnaAPAdaptor.getAddDirectCreditRequest(addPadRequest);
    	if (addDirectCreditRequest == null){
        	logger.error(methodName, "AddDirectCreditRequest is null");
    		return null;
    	}
    	
    	HttpEntity<AddDirectCreditRequest> addDirectCreditRequestEntity = new HttpEntity<>(addDirectCreditRequest, addAuthorizationHeader(token));
    	logger.toJson(methodName, addDirectCreditRequest);
    	ResponseEntity<AddDirectCreditResponse> addDirectCreditResponseHttpResponse = null;
        try{
        	addDirectCreditResponseHttpResponse = restTemplate.exchange(apiApEndPoint, HttpMethod.POST, addDirectCreditRequestEntity, AddDirectCreditResponse.class);
          } catch (Exception e){
        	logger.error("failed when call "+apiApEndPoint);
        	return null;
        }
        logger.toJson(methodName, addDirectCreditResponseHttpResponse);

    	return mbnaAPAdaptor.getAddPadResponse(addDirectCreditResponseHttpResponse.getBody());
	}
	
	public String updatePad(UpdatePadRequest updatePadRequest, String token) {
		return null;
	}
	
	public ValidateBankAccountResponse validateBankAccount(ValidateBankAccountRequest request, String token){

		ValidateBankAccountResponse response = new ValidateBankAccountResponse();
		response.getResponsePayload().setValidAccount(false);

        String methodName = "validateBankAccount()";
		String url = UriComponentsBuilder.fromHttpUrl(apiApEndPoint).path("/eligibilities/deposittransactionagreements/validone")
				.queryParam(QUERY_PARAMETER_BANKNUM, request.getRequestPayload().getBankNum())
				.queryParam(QUERY_PARAMETER_BRANCHNUM, request.getRequestPayload().getBranchNum())
				.queryParam(QUERY_PARAMETER_ACCOUNTNUM, request.getRequestPayload().getBankAccount())
				.build().encode().toUriString();

		logger.debug(methodName, url);
		
        HttpEntity<?> requestEntity = new HttpEntity<>(addAuthorizationHeader(token));
        
        ValidoneResponse validoneResponse = null;
		try {
			ResponseEntity<ValidoneResponse> httpResponse = restTemplate.exchange(url, HttpMethod.GET, requestEntity, ValidoneResponse.class);
			if (httpResponse == null) {
				return response;
			}
			validoneResponse = httpResponse.getBody();

			if (validoneResponse == null) {
				return response;
			}
			// when reached to this line, the validation is passed
			response.getResponsePayload().setValidAccount(true);
			
		} catch (HttpClientErrorException e) {
			logger.warn(" restTemplate.exchange:: exception when calling " + url + " message : " + e.getLocalizedMessage());
			String status = e.getResponseBodyAsString();
			response.setStatus(status);
		} catch (RestClientResponseException  e) {
			logger.warn(" restTemplate.exchange:: exception when calling " + url + " message : " + e.getLocalizedMessage());
			String status = e.getResponseBodyAsString();
			response.setStatus(status);
		} catch (RestClientException e) {
			logger.warn(" restTemplate.exchange:: exception when calling " + url + " message : " + e.getLocalizedMessage());
			response.setStatus("MS601");
		}
		
		return response;
	}
	
    private HttpHeaders addAuthorizationHeader(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(MSECConstants.AUTHORIZATION, token);
        return headers;
    }

	public RetrieveBranchResponse retrieveBranch(String bankNum, String branchNum, String token) {
		RetrieveBranchResponse response = null;//ew RetrieveBranchResponse();
        String methodName = "retrieveBranch()";
		String url = UriComponentsBuilder.fromHttpUrl(apiBranchesEndPoint)
				.queryParam(QUERY_PARAMETER_BANKNUM, bankNum)
				.queryParam(QUERY_PARAMETER_BRANCHNUM, branchNum)
				.build().encode().toUriString();

		logger.debug(methodName, url);
		
        HttpEntity<?> requestEntity = new HttpEntity<>(addAuthorizationHeader(token));
		try {
			ResponseEntity<RetrieveBranchResponse> httpResponse = restTemplate.exchange(url, HttpMethod.GET, requestEntity, RetrieveBranchResponse.class);
			if (httpResponse != null) {
				response = httpResponse.getBody();
			}
		} catch (RestClientException e) {
			logger.error(" restTemplate.exchange:: exception when calling " + url + " message : " + e.getLocalizedMessage());
		}

		return response;
	}

}
