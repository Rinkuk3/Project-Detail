package com.td.mbna.msec.midtier.mbnaad;

import com.td.api.kms.request.AddEncryptionJobRq;
import com.td.mbna.msec.midtier.cardservice.payload.activatecard.ActivateCardResponse;
import com.td.mbna.msec.midtier.cardservice.payload.activatecard.ResponsePayload;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MSECConstants;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CardActivationSrv {

    private static MbnaLogger logger = new MbnaLogger(CardActivationSrv.class);

    private static String mbadaApiEndpt = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_MBADA_API_ENDPT);
    private static final String REQUEST_ENTITY = " requestEntity = ";
    private static final String NULL_MESSAGE  = " return is null";
    private static final String KEY_TYPE = "keyType";
    private static final String PARTY_KEY = "partyKey";
    private static final String DISPLAY_PARTY_KEY = " partyKey = ";
    @Autowired
    private RestTemplate restTemplate;


    public ActivateCardResponse activateCard(String connectId, String cardNumber, String partyKey, String token) {
        logger.debug("CardActivationSrv:activateCard(String cardNumber, String partyKey)::cardNumber="+cardNumber+DISPLAY_PARTY_KEY+partyKey);
        ActivateCardResponse activateCardResponse = new ActivateCardResponse();
        try {
            Map<String, String> urlParams = new HashMap<>();
            urlParams.put(KEY_TYPE, "c");
            urlParams.put("key", cardNumber);
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(mbadaApiEndpt).path("/{keyType}{key}/activation");
            HttpHeaders headers = new HttpHeaders();
            headers.add(MSECConstants.CONNECT_ID, connectId);
            headers.add(MSECConstants.AUTHORIZATION, token);
            headers.setContentType(MediaType.APPLICATION_JSON);
            Map<String, String> map= new LinkedHashMap<>();
            map.put(PARTY_KEY, partyKey);
            HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(map, headers);
            ResponseEntity<ActivateCardResponse> activateCardResponseBody =  null;
            if(builder != null){
                logger.debug("activateCard(String connectId, String cardNumber, String partyKey, String token)::builder="+builder.toUriString()+REQUEST_ENTITY+requestEntity.toString());
                activateCardResponseBody = restTemplate.exchange(builder.buildAndExpand(urlParams).toUriString(), HttpMethod.POST, requestEntity, ActivateCardResponse.class);
            }
            if(activateCardResponseBody == null || activateCardResponseBody.getBody() == null){
                logger.error("CardServicesInfoSrv:activateCard",NULL_MESSAGE);
                return null;
            }
            ResponsePayload responsePayload = new ResponsePayload();
            responsePayload.setStatus(activateCardResponseBody.getStatusCode().is2xxSuccessful());
            responsePayload.setReturnCode(activateCardResponse.getStatus());
            activateCardResponse.setResponsePayload(responsePayload);
            //activateCardResponse.getResponsePayload().setStatus(activateCardResponseBody.getStatusCode().is2xxSuccessful());
            return activateCardResponse;

        } catch (Exception e) {

            logger.error("CardActivationSrv:activateCard",e.getLocalizedMessage(),e);
        }

        return null;
    }
}
