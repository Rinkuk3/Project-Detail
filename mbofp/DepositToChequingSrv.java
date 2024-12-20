package com.td.mbna.msec.midtier.mbofp;

import com.td.mbna.msec.midtier.transfer.payload.deposittochequing.DepositToChequingResponse;
import com.td.mbna.msec.midtier.transfer.payload.deposittochequing.ResponsePayload;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MSECConstants;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DepositToChequingSrv {
    private static MbnaLogger logger = new MbnaLogger(DepositToChequingSrv.class);

    private static String mbadaApiEndpt = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_MBADA_API_ENDPT);
    private static final String REQUEST_ENTITY = " requestEntity = ";
    private static final String NULL_MESSAGE  = " return is null";
    private static final String KEY_TYPE = "keyType";
    private static final String PARTY_KEY = "partyKey";
    private static final String DISPLAY_PARTY_KEY = " partyKey = ";
    @Autowired
    private RestTemplate restTemplate;


    public DepositToChequingResponse depositToChequing(String connectId, String cardNumber, String partyKey, String token) {
        logger.debug("DepositToChequingSrv:depositToChequing(String cardNumber, String partyKey)::cardNumber="
                +cardNumber+DISPLAY_PARTY_KEY+partyKey);
        DepositToChequingResponse depositToChequingResponse = new DepositToChequingResponse();
        try {
            Map<String, String> urlParams = new HashMap<>();
            urlParams.put(KEY_TYPE, "c");
            urlParams.put("key", cardNumber);
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(mbadaApiEndpt).path("/balancetransfers");
            HttpHeaders headers = new HttpHeaders();
            headers.add(MSECConstants.CONNECT_ID, connectId);
            headers.add(MSECConstants.AUTHORIZATION, token);
            headers.setContentType(MediaType.APPLICATION_JSON);
            Map<String, String> map= new LinkedHashMap<>();
            map.put(PARTY_KEY, partyKey);
            HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(map, headers);
            ResponseEntity<DepositToChequingResponse> depositToChequingResponseBody =  null;
            if(builder != null){
                logger.debug("depositToChequing(String connectId, String cardNumber, String partyKey, " +
                        "String token)::builder="+builder.toUriString()+REQUEST_ENTITY+requestEntity.toString());
                depositToChequingResponseBody = restTemplate.exchange(builder.buildAndExpand(urlParams).toUriString(),
                        HttpMethod.POST, requestEntity, DepositToChequingResponse.class);
            }
            if(depositToChequingResponseBody == null || depositToChequingResponseBody.getBody() == null){
                logger.error("DepositToChequingSrv:depositToChequing",NULL_MESSAGE);
                return null;
            }
            ResponsePayload responsePayload = new ResponsePayload();

            responsePayload.setStatus(depositToChequingResponseBody.getStatusCode().is2xxSuccessful());
            depositToChequingResponse.setResponsePayload(responsePayload);
            return depositToChequingResponse;

        } catch (Exception e) {

            logger.error("DepositToChequingSrv:depositToChequing",e.getLocalizedMessage(),e);
        }

        return null;
    }

}
