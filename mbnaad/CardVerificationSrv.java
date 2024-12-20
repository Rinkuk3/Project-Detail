package com.td.mbna.msec.midtier.mbnaad;


import com.td.mbna.msec.midtier.cardservice.payload.validatecpi.ResponsePayload;
import com.td.mbna.msec.midtier.cardservice.payload.validatecpi.ValidateCPIResponse;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MSECConstants;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
@Service
public class CardVerificationSrv {

    private static MbnaLogger logger = new MbnaLogger(CardVerificationSrv.class);

    private static String mbadaApiEndpt = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_MBADA_API_ENDPT);
    private static final String REQUEST_ENTITY = " requestEntity = ";
    private static final String KEY_TYPE = "keyType";
    @Autowired
    private RestTemplate restTemplate;


    public ValidateCPIResponse cardVerification(String connectId, String cardNumber, String cvv, String expiryYear, String expiryMonth, String token) {
        logger.debug("CardVerification:cardVerification(String cardNumber)::cardNumber="+cardNumber);
        ValidateCPIResponse validateCPIResponse = new ValidateCPIResponse();
        try {
            Map<String, String> urlParams = new HashMap<>();
            urlParams.put(KEY_TYPE, "c");
            urlParams.put("key", cardNumber);
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(mbadaApiEndpt).path("/{keyType}{key}/verification");
            HttpHeaders headers = new HttpHeaders();
            headers.add(MSECConstants.CONNECT_ID, connectId);
            headers.add(MSECConstants.AUTHORIZATION, token);
            headers.setContentType(MediaType.APPLICATION_JSON);
            Map<String, String> map= new LinkedHashMap<>();
            map.put("cardSecurityCd", cvv);
            if(Integer.valueOf(expiryMonth) > 10) {
                map.put("expirationYm", expiryYear + "-" + expiryMonth);
            } else {
                map.put("expirationYm", expiryYear + "-0" + expiryMonth);
            }
            HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(map, headers);
            ResponseEntity<Object> activateCardResponseBody =  null;
            if(builder != null){
                logger.debug("cardVerification(String connectId, String cardNumber, String cvv, String expiryYear, String expiryMonth, String token)::builder="+builder.toUriString()+REQUEST_ENTITY+requestEntity);
                activateCardResponseBody = restTemplate.exchange(builder.buildAndExpand(urlParams).toUriString(), HttpMethod.POST, requestEntity, Object.class);
            }
            ResponsePayload responsePayload = new ResponsePayload();

            if (activateCardResponseBody!=null && (activateCardResponseBody.getStatusCode() == HttpStatus.OK || activateCardResponseBody.getStatusCode() == HttpStatus.NO_CONTENT)) {
                    responsePayload.setStatus(true);
            }
            validateCPIResponse.setResponsePayload(responsePayload);
            return validateCPIResponse;

        } catch (Exception e) {

            logger.error("CardVerificationSrv:cardVerification",e.getLocalizedMessage(),e);
        }

        return null;
    }

    public ValidateCPIResponse cardCVCVerification(String connectId, String cardNumber, String cvv, String expiryYearMonth, String token) {
        logger.debug("CardVerification:cardCVVVerification(String cardNumber)::cardNumber=" + cardNumber);
        ValidateCPIResponse validateCPIResponse = new ValidateCPIResponse();
        ResponsePayload responsePayload = new ResponsePayload();
        ResponseEntity<Object> activateCardResponseBody = null;
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put(KEY_TYPE, "c");
        urlParams.put("key", cardNumber);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(mbadaApiEndpt).path("/{keyType}{key}/verification");
        Map<String, String> map = new LinkedHashMap<>();
        map.put("cardSecurityCd", cvv);
        map.put("expirationYm", expiryYearMonth);
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(map, addAuthorizationHeader(token, connectId));
        try {
            if(builder != null){
                logger.debug("cardVerification(String connectId, String cardNumber, String cvv, String expiryYear, String expiryMonth, String token)::builder=" + builder.toUriString() + REQUEST_ENTITY + requestEntity);
                activateCardResponseBody = restTemplate.exchange(builder.buildAndExpand(urlParams).toUriString(), HttpMethod.POST, requestEntity, Object.class);
            }
            if (activateCardResponseBody != null && (activateCardResponseBody.getStatusCode() == HttpStatus.OK || activateCardResponseBody.getStatusCode() == HttpStatus.NO_CONTENT)) {
                responsePayload.setStatus(true);
            }
            validateCPIResponse.setResponsePayload(responsePayload);
        }
        catch (HttpClientErrorException httpClientError) {
            if (httpClientError.getStatusCode().is4xxClientError()) {
                responsePayload.setStatus(false);
                validateCPIResponse.setResponsePayload(responsePayload);
            }
            logger.error(" restTemplate.exchange:: exception when calling " + builder.toUriString() + " message : " + httpClientError.getLocalizedMessage());
            return validateCPIResponse;
        }catch (Exception e) {
            logger.error(" restTemplate.exchange:: exception when calling " + builder.toUriString() + " message : " + e.getLocalizedMessage());
            return validateCPIResponse;
        }
        return validateCPIResponse;
    }

    private HttpHeaders addAuthorizationHeader(String token, String connectId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(MSECConstants.CONNECT_ID, connectId);
        headers.add(MSECConstants.AUTHORIZATION, token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
