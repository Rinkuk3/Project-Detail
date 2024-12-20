package com.td.mbna.msec.midtier.mbnaad;

import com.td.api.kms.request.AddEncryptionJobRq;
import com.td.mbna.msec.midtier.mbnaad.request.response.RetrieveAccessCardListRs;
import com.td.mbna.msec.midtier.mbnaad.request.response.RetrievePinRs;
import com.td.mbna.msec.midtier.mbnaad.request.response.accesscard.RetrieveAccessCard;
import com.td.mbna.msec.midtier.pinmanagement.payload.changepin.ChangePinResponse;
import com.td.mbna.msec.midtier.pinmanagement.payload.getpin.GetPinResponse;
import com.td.mbna.msec.midtier.pinmanagement.payload.unlockpin.UnblockPinResponse;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
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
public class ChipCardInfoSrv {

    private static MbnaLogger logger = new MbnaLogger(ChipCardInfoSrv.class);

    private static String mbadaApiEndpt = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_MBADA_API_ENDPT);

    private static final String PIN_CHANGE_SCRIPT_NAME = "PCHG";
    private static final String DISPLAY_PARTY_KEY = " partyKey = ";
    private static final String REQUEST_ENTITY = " requestEntity = ";
    private static final String NULL_MESSAGE  = " return is null";
    private static final String KEY_TYPE = "keyType";
    private static final String PARTY_KEY = "partyKey";

    @Autowired
    private RestTemplate restTemplate;

    public RetrieveAccessCardListRs retrieveChipCardInfo(String connectId, String cardNumber, String partyKey, String token) {
    	logger.debug("retrieveChipCardInfo(String cardNumber, String partyKey, String token)::cardNumber="+cardNumber+DISPLAY_PARTY_KEY +partyKey);

        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(mbadaApiEndpt)
                                            .queryParam("cardKeyTypeCd","AB")
                                            .queryParam("cardKey", cardNumber)
                                            .queryParam(PARTY_KEY, partyKey)
                                            .queryParam("mostCurrentInd", "false");

            HttpHeaders headers = new HttpHeaders();
            headers.add(MSECConstants.CONNECT_ID, connectId);
            headers.add(MSECConstants.AUTHORIZATION, token);

            HttpEntity<?> requestEntity = new HttpEntity<AddEncryptionJobRq>(null, headers);
            ResponseEntity<RetrieveAccessCardListRs> chipCardResponse =  null;
            if(builder != null){
            	logger.debug("retrieveChipCardInfo(String cardNumber, String partyKey, String token)::builder="+builder.toUriString()+REQUEST_ENTITY +requestEntity.toString());
            	chipCardResponse = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, RetrieveAccessCardListRs.class);
            }
			if(chipCardResponse == null){
				logger.error("ChipCardInfoSrv.retrieveChipCardInfo",NULL_MESSAGE);
				return null;
			}
            return chipCardResponse.getBody();

        } catch (Exception e) {

            logger.error("ChipCardInfoSrv.retrieveChipCardInfo",e.getLocalizedMessage(),e);
        }

        return null;
    }


    public RetrieveAccessCard retrieveAccessCardList(String connectId,String cardNumber, String token) {

        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(mbadaApiEndpt).path("/c"+cardNumber);

            HttpHeaders headers = new HttpHeaders();
            headers.add(MSECConstants.CONNECT_ID, connectId);
            headers.add(MSECConstants.AUTHORIZATION, token);

            HttpEntity<?> requestEntity = new HttpEntity<AddEncryptionJobRq>(null, headers);
            ResponseEntity<RetrieveAccessCard> retrieveAccessCardResponseEntity = null;
			if(builder != null){
				retrieveAccessCardResponseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, RetrieveAccessCard.class);
			}
			if(retrieveAccessCardResponseEntity == null){
				logger.error("ChipCardInfoSrv:retrieveAccessCardList", "the return is null");
				return null;
			}
            return retrieveAccessCardResponseEntity.getBody();


        } catch (Exception e) {
            logger.error("ChipCardInfoSrv:retrieveAccessCardList", "Failed in retrieve Access CardList",e);
        }

        return null;
    }

    public GetPinResponse viewPin(String connectId, String cardNumber, String partyKey, String token) {
        logger.debug("ChipCardInfoSrv:viewPin(String cardNumber, String partyKey, String token)::cardNumber="+cardNumber+ DISPLAY_PARTY_KEY  +partyKey);
        GetPinResponse getPinResponse = new GetPinResponse();
        try {

            // URI (URL) parameters
            Map<String, String> urlParams = new HashMap<>();
            urlParams.put(KEY_TYPE, "c");
            urlParams.put("key", cardNumber);
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(mbadaApiEndpt).path("/{keyType}{key}/pin")
                    .queryParam(PARTY_KEY , partyKey);

            HttpHeaders headers = new HttpHeaders();
            headers.add(MSECConstants.CONNECT_ID, connectId);
            headers.add(MSECConstants.AUTHORIZATION, token);

            HttpEntity<?> requestEntity = new HttpEntity<AddEncryptionJobRq>(null, headers);
            ResponseEntity<RetrievePinRs> viewPinResponseResponseEntity =  null;
            if(builder != null){
                logger.debug("viewPin(String connectId, String cardNumber, String partyKey, String token)::builder="+builder.toUriString()+REQUEST_ENTITY +requestEntity.toString());
                viewPinResponseResponseEntity = restTemplate.exchange(builder.buildAndExpand(urlParams).toUriString(), HttpMethod.GET, requestEntity, RetrievePinRs.class);
            }
            if(viewPinResponseResponseEntity == null || viewPinResponseResponseEntity.getBody() == null){
                logger.error("ChipCardInfoSrv:viewPin",NULL_MESSAGE);
                return null;
            }
            getPinResponse.getResponsePayload().setEncryptedPinBlock(viewPinResponseResponseEntity.getBody().getPinNumEncrypted());
            return getPinResponse;

        } catch (Exception e) {

            logger.error("ChipCardInfoSrv.viewPin",e.getLocalizedMessage(),e);
        }

        return null;
    }

    public ChangePinResponse updatePin(String connectId, String cardNumber,String encryptedPin, String partyKey, String token) {
        logger.debug("ChipCardInfoSrv:updatePin::cardNumber="+cardNumber+ DISPLAY_PARTY_KEY +partyKey);

        ChangePinResponse changePinResponse = new ChangePinResponse();
        try {

            // URI (URL) parameters
            Map<String, String> urlParams = new HashMap<>();
            urlParams.put(KEY_TYPE, "c");
            urlParams.put("key", cardNumber);
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(mbadaApiEndpt).path("/{keyType}{key}/pin");


            HttpHeaders headers = new HttpHeaders();
            headers.add(MSECConstants.CONNECT_ID, connectId);
            headers.add(MSECConstants.AUTHORIZATION, token);
            headers.setContentType(MediaType.APPLICATION_JSON);
            //PartialUpdateAccessCardPINRq

            Map<String, String> map= new LinkedHashMap<>();
            map.put(PARTY_KEY , partyKey);
            map.put("pinNumEncrypted", encryptedPin);
            map.put("pinChangeIssuerScriptName", PIN_CHANGE_SCRIPT_NAME);

            HttpEntity<?> requestEntity = new HttpEntity<>(map, headers);
            ResponseEntity<Object> changePinResponseResponseEntity =  null;
            if(builder != null){
                logger.debug("updatePin(String connectId, String cardNumber, String partyKey, String token)::builder="+builder.toUriString()+REQUEST_ENTITY +requestEntity.toString());
                changePinResponseResponseEntity = restTemplate.exchange(builder.buildAndExpand(urlParams).toUriString(), HttpMethod.PATCH, requestEntity,Object.class);
            }
            if(changePinResponseResponseEntity == null){
                logger.error("ChipCardInfoSrv:updatePin",NULL_MESSAGE);
                return null;
            }
            changePinResponse.getResponsePayload().setStatus(changePinResponseResponseEntity.getStatusCode().is2xxSuccessful());
            return changePinResponse;

        } catch (Exception e) {

            logger.error("ChipCardInfoSrv.updatePin",e.getLocalizedMessage(),e);
        }

        return null;
    }

    public UnblockPinResponse unblockPin(String connectId, String cardNumber, String partyKey, String token, String seqNumber, Boolean allowPinChangeInd) {
        logger.debug("ChipCardInfoSrv:unblockPin::cardNumber="+cardNumber+PARTY_KEY +partyKey);
        UnblockPinResponse unblockPinResponse = new UnblockPinResponse();
        try {

            // URI (URL) parameters
            Map<String, String> urlParams = new HashMap<>();
            urlParams.put(KEY_TYPE, "c");
            urlParams.put("key", cardNumber);
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(mbadaApiEndpt).path("/{keyType}{key}/chipcard");
            HttpHeaders headers = new HttpHeaders();
            headers.add(MSECConstants.CONNECT_ID, connectId);
            headers.add(MSECConstants.AUTHORIZATION, token);
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String,Object> jsonObject = new LinkedHashMap<>();
            Map<String,Object> chipCardJsonObject = new LinkedHashMap<>();
            jsonObject.put(PARTY_KEY, partyKey);
            jsonObject.put("sequenceNum", seqNumber);
            jsonObject.put("allowingPINChangeInd", allowPinChangeInd);
            jsonObject.put("allowingCashAdvanceTransactionInd", true);
            jsonObject.put("pinUnblockOnlineInd", true);
            jsonObject.put("pinUnblockOfflineInd", false);
            chipCardJsonObject.put("chipCard", jsonObject);

            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(chipCardJsonObject, headers);
            ResponseEntity<Object> requestPinByMailResponseBody =  null;
            if(builder != null){
                logger.debug("unblockPin(String connectId, String cardNumber, String partyKey, String token)::builder="+builder.toUriString()+REQUEST_ENTITY +requestEntity.toString());
                requestPinByMailResponseBody = restTemplate.exchange(builder.buildAndExpand(urlParams).toUriString(), HttpMethod.PATCH, requestEntity, Object.class);
            }
            if(requestPinByMailResponseBody == null){
                logger.error("ChipCardInfoSrv:unblockPin",NULL_MESSAGE);
                return null;
            }
            unblockPinResponse.getResponsePayload().setStatus(requestPinByMailResponseBody.getStatusCode().is2xxSuccessful());
            return unblockPinResponse;

        } catch (Exception e) {

            logger.error("ChipCardInfoSrv.unblockPin",e.getLocalizedMessage(),e);
        }

        return null;
    }

    public RetrieveAccessCard verifyCardExpiry(String connectId,String cardNumber, String token) {
        if(MSECConstants.MOCK_MBADA_API_ERROR){
            logger.error("MBADA API call returns error", "Mock error for api down");
            throw ExceptionUtil.genBusinessException("MS804", "Mock error for api down");
        }
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(mbadaApiEndpt).path("/c" + cardNumber);
        HttpHeaders headers = new HttpHeaders();
        headers.add(MSECConstants.CONNECT_ID, connectId);
        headers.add(MSECConstants.AUTHORIZATION, token);
        HttpEntity<?> requestEntity = new HttpEntity<AddEncryptionJobRq>(null, headers);
        ResponseEntity<RetrieveAccessCard> response = null;
        try {
            response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, RetrieveAccessCard.class);
            if (response == null) {
                logger.error("ChipCardInfoSrv:verifyCardExpiry", "the return is null");
                return null;
            }
        } catch (Exception e) {
            logger.error(" restTemplate.exchange:: exception when calling " + builder.toUriString() + " message : " + e.getLocalizedMessage());
        }
        return response.getBody();
    }

}
