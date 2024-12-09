package com.td.mbna.msec.midtier.cardlock;

import com.td.mbna.msec.midtier.cardlock.payload.*;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MSECConstants;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CardLockFacade {

    private static final String cardLockApiEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_CARD_CONTROL_API_ENDPT);

    protected static final String PATH_INFORMATION = "/customers/";

    protected static final String CONTROL_PATH_INFORMATION = "/controls";

    private static MbnaLogger logger = new MbnaLogger(CardLockFacade.class);

    @Autowired
    protected RestTemplate restTemplate;


    public CardLockResponse getCardStatus(CardLockRequest request, String token) {

        CardLockResponse cardLockResponse =  new CardLockResponse();
        ResponsePayload responsePayload = new ResponsePayload();
        String url = UriComponentsBuilder.fromHttpUrl(cardLockApiEndPoint)
                .path(request.getRequestPayload().getAccountId())
                .path(PATH_INFORMATION)
                .path(request.getRequestPayload().getCustId())
                .path(CONTROL_PATH_INFORMATION)
                .toUriString();

        HttpEntity<?> requestEntity = new HttpEntity<>(addAuthorizationHeader(request.getSessionInfo().getConnectId(), token));

        try {
            HttpEntity<CardControlResponse> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, CardControlResponse.class);
            logger.debug("CardLockFacade:getCardStatus " , responseEntity.getBody().getCardAuthorizationStatus().toString());
            responsePayload.setCardAuthorizationStatus(responseEntity.getBody().getCardAuthorizationStatus());
            cardLockResponse.setResponsePayload(responsePayload);
            cardLockResponse.setStatus(String.valueOf(((ResponseEntity) responseEntity).getStatusCodeValue()));
            logger.debug("CardLockFacade:getCardStatus " , responseEntity.getBody().toString());
             return  cardLockResponse;
        } catch (Exception e) {
            cardLockResponse.setStatus(((HttpStatusCodeException)e).getStatusCode().toString());
            cardLockResponse.setErrorMsgs(new ArrayList<>(Collections.singleton(e.getMessage())));
            logger.error("CardLockFacade:getCardStatus - accountId ", request.getRequestPayload().getAccountId(), e.getCause());
            return cardLockResponse;//empty object in case of exception from API
        }
    }

    public CardLockResponse updateCardStatus(CardLockRequest request, String token) {

        CardLockResponse cardLockResponse =  new CardLockResponse();
        ResponsePayload responsePayload = new ResponsePayload();
        Map<String , String> response = new LinkedHashMap<>();
        CardControlResponse cardControlResponse = new CardControlResponse();
        String url = UriComponentsBuilder.fromHttpUrl(cardLockApiEndPoint)
                .path(request.getAcctNum())
                .path(PATH_INFORMATION)
                .path(request.getAliasCustId())
                .path(CONTROL_PATH_INFORMATION)
                .toUriString();

        cardControlResponse.setCardAuthorizationStatus(request.getRequestPayload().getCardAuthorizationStatus());
        HttpEntity<?> requestEntity = new HttpEntity<>(cardControlResponse, addAuthorizationHeader(request.getSessionInfo().getConnectId(), token));
        try {
            HttpEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Object.class);
            response = (Map<String, String>) responseEntity.getBody();
            responsePayload.setConfirmationNumber(response.get("confirmationNumber"));
            cardLockResponse.setResponsePayload(responsePayload);
            cardLockResponse.setStatus(String.valueOf(((ResponseEntity) responseEntity).getStatusCodeValue()));
            logger.debug("CardLockFacade:getCardStatus " , responseEntity.getBody().toString());
            return cardLockResponse;
        } catch (Exception e) {
            cardLockResponse.setStatus(((HttpStatusCodeException)e).getStatusCode().toString());
            cardLockResponse.setErrorMsgs(new ArrayList<>(Collections.singleton(e.getMessage())));
            logger.error("CardLockFacade:updateCardStatus", request.getAcctNum(), e.getCause());
            return cardLockResponse;//empty object in case of exception from API
        }
    }

    private HttpHeaders addAuthorizationHeader(String connectId, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(MSECConstants.CONNECT_ID, connectId);
        headers.add(MSECConstants.AUTHORIZATION, token);
        return headers;
    }


}
