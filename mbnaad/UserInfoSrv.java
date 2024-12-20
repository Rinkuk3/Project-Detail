package com.td.mbna.msec.midtier.mbnaad;


import com.td.mbna.msec.midtier.cardreplacement.payload.replacecard.ReplaceCardRequest;
import com.td.mbna.msec.midtier.cardreplacement.payload.replacecard.ReplaceCardResponse;
import com.td.mbna.msec.midtier.cardreplacement.payload.replacecard.ResponsePayload;
import com.td.mbna.msec.midtier.mbnaad.exception.MBNAException;
import com.td.mbna.msec.midtier.mbnaad.request.response.UserInformation;
import com.td.mbna.msec.midtier.mbnaad.request.response.DeliveryAddress;
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
import java.util.Map;

@Service
public class UserInfoSrv {

    private static MbnaLogger logger = new MbnaLogger(UserInfoSrv.class);

    private static String mbadaApiEndpt = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_MBADA_API_ENDPT);
    private static final String REQUEST_ENTITY = " requestEntity = ";
    private static final String NULL_MESSAGE  = " return is null";

    private static final String DISPLAY_PARTY_KEY = " partyKey = ";
    @Autowired
    private RestTemplate restTemplate;


    public Boolean issueCardForAU(com.mbnaweb.xsd.msgs.customerprofile.AddAuthorizedUserRequest addAuthorizedUserRequest,com.mbnaweb.xsd.msgs.customerprofile.AddAuthorizedUserResponse response, String cardNumber, String token) {
        logger.debug("UserInfoSrv:issueCard(String cardNumber, String partyKey)::cardNumber="+addAuthorizedUserRequest.getCardNum()+DISPLAY_PARTY_KEY+addAuthorizedUserRequest.getAliasCustId());
        try {


            UserInformation authorizedUser = new UserInformation();
            UserInformation.CardInfo cardInfo = new UserInformation.CardInfo();
            UserInformation.DeliveryInfo deliveryInfo = new UserInformation.DeliveryInfo();
            UserInformation.DeliveryInfo.Address address = new UserInformation.DeliveryInfo.Address();
            cardInfo.setTypeCd("Primary");

            com.mbnaweb.xsd.types.common.UnformattedAddress auAddress = addAuthorizedUserRequest.getRequestPayload().getAuthorizedUserAddress();



            address.setCity(auAddress.getCity());
            address.setAddressLine1(auAddress.getAddrLine1().substring(0, auAddress.getAddrLine1().indexOf(' ')));
            address.setAddressLine2(auAddress.getAddrLine1().substring(auAddress.getAddrLine1().indexOf(' ') + 1));
            address.setPostalCode(auAddress.getPostalCode());
            address.setTerritory(auAddress.getProvince());
            address.setCountryCd("CN");
            deliveryInfo.setAddress(address);


            authorizedUser.setCardNum(cardNumber);
            authorizedUser.setCardInfo(cardInfo);
            authorizedUser.setChargeFeeInd(false);
            authorizedUser.setDeliveryInfo(deliveryInfo);
            String newlyAddedCustomerId = response.getResponsePayload().getNewAliasCustId();
            authorizedUser.setPartyKey(newlyAddedCustomerId);
            authorizedUser.setReasonCd("New");
            authorizedUser.setReissueInd(false);
            authorizedUser.setNumberOfCardCnt(1);


            ResponseEntity<DeliveryAddress> addAuthorizedUserResponseBody = callIssueCardService(addAuthorizedUserRequest.getSessionInfo().getConnectId(), authorizedUser, token);
            if(addAuthorizedUserResponseBody == null || addAuthorizedUserResponseBody.getBody() == null){
                logger.error("UserInfoSrv : issueCard ", NULL_MESSAGE);
                return false;
            }
            logger.debug("output Response : " + addAuthorizedUserResponseBody.getBody().toString());

            if (addAuthorizedUserResponseBody.getStatusCode().is2xxSuccessful()) {
                logger.debug("succesfully issued card.");
                return true;
            } else {
                logger.error("UserInfoSrv:issueCard Issue Card failed."+ addAuthorizedUserResponseBody.getStatusCodeValue());
                return false;
            }

        } catch (Exception e) {

            logger.error("UserInfoSrv:issueCard",e.getLocalizedMessage(),e);
        }

        return false;
    }

    private ResponseEntity<DeliveryAddress> callIssueCardService(String connectId, UserInformation userInformation, String token) {
        Map<String, String> urlParams = new HashMap<>();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(mbadaApiEndpt);
        HttpHeaders headers = new HttpHeaders();
        headers.add(MSECConstants.CONNECT_ID, connectId);
        headers.add(MSECConstants.AUTHORIZATION, token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UserInformation> requestEntity = new HttpEntity<>(userInformation, headers);
        ResponseEntity<DeliveryAddress> addAuthorizedUserResponseBody =  null;
        if(builder != null){
            logger.debug("UserInfoSrv:issueCard(String cardNumber, String partyKey, String token)::builder="+ builder.toUriString()+REQUEST_ENTITY+requestEntity.toString());
            addAuthorizedUserResponseBody = restTemplate.postForEntity(builder.buildAndExpand(urlParams).toUriString(), requestEntity, DeliveryAddress.class);

        }
        return addAuthorizedUserResponseBody;
    }

    public ReplaceCardResponse issueCard(String connectId, ReplaceCardRequest replaceCardRequest, String token) throws MBNAException {
        ReplaceCardResponse response = new ReplaceCardResponse();
        ResponsePayload responsePayload = new ResponsePayload();
        UserInformation userInformation = new UserInformation();
        UserInformation.CardInfo cardInfo = new UserInformation.CardInfo();
        cardInfo.setTypeCd("Primary");
        userInformation.setCardInfo(cardInfo);
        userInformation.setPartyKey(replaceCardRequest.getRequestPayload().getAliasCustID());
        userInformation.setNumberOfCardCnt(1);
        userInformation.setReasonCd("Special");
        userInformation.setChargeFeeInd(false);
        userInformation.setReissueInd(false);
        userInformation.setCardNum(replaceCardRequest.getRequestPayload().getCardNumber());

        ResponseEntity<DeliveryAddress> replaceCardResponseBody = null;

        try {
            replaceCardResponseBody = callIssueCardService(connectId, userInformation, token);
            if (replaceCardResponseBody == null || replaceCardResponseBody.getBody() == null) {
                logger.error("UserInfoSrv:issueCard", NULL_MESSAGE);
            }
            if ( replaceCardResponseBody!=null) {

                responsePayload.setStatus(replaceCardResponseBody.getStatusCode().is2xxSuccessful());

                response.setResponsePayload(responsePayload);
                logger.debug(" UserInfoSrv:issueCard : output response : " + replaceCardResponseBody.getBody().toString());
            }
        } catch (Exception exception) {
            if (exception instanceof HttpClientErrorException && (((HttpClientErrorException) exception).getResponseBodyAsString().contains("Card Request is already outstanding."))) {
                logger.error("UserInfoSrv:issueCard : replace card error response " + ((HttpClientErrorException) exception).getResponseBodyAsString());
                throw new MBNAException("Card Request is already outstanding.");
            } else {
                return null;
            }
        }
        return response;
    }

}

