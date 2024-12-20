package com.td.mbna.msec.midtier.ofm.facade;

import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.td.api.ofm.request.TSvcRetrieveCreditCardAgreementPartyFeatureListRq;
import com.td.api.ofm.response.TSvcRetrieveCreditCardAgreementPartyFeatureListRs;
import com.td.mbna.msec.midtier.eligibility.payload.getentitlementflags.GetEntitlementFlagsRequest;
import com.td.mbna.msec.midtier.eligibility.payload.getentitlementflags.GetEntitlementFlagsResponse;
import com.td.mbna.msec.midtier.ofm.adapter.MbnaOfmAdapter;
import com.td.mbna.msec.midtier.util.services.MSECConstants;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;

import static com.td.mbna.msec.midtier.util.services.MSECConstants.MOCK_OFM_API_ERROR;
import static java.lang.Boolean.TRUE;

@Component
public class MbnaOfmFacade {

    private static final String ofmApiEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_OFM_API_ENDPT);

    private static final MbnaLogger logger = new MbnaLogger(MbnaOfmFacade.class);

    @Autowired
    private MbnaOfmAdapter ofmAdapter;

    @Autowired
    private RestTemplate restTemplate;

    public GetEntitlementFlagsResponse retrieveEligibility(GetEntitlementFlagsRequest retrieveEligibilityRequest, boolean chatElig, String token)  {
        TSvcRetrieveCreditCardAgreementPartyFeatureListRs ofmApiResponse = retrieveEligibility(retrieveEligibilityRequest.getSessionInfo().getConnectId(), ofmAdapter.buildTsvcRetrieveCreditCardAgreementPartyFeatureListRq(retrieveEligibilityRequest), token);
        return ofmAdapter.convert(ofmApiResponse, retrieveEligibilityRequest, chatElig);
    }

    public TSvcRetrieveCreditCardAgreementPartyFeatureListRs retrieveFeaturesList(String connectId, String cardNumber, String partyId, String token) {

        if(MOCK_OFM_API_ERROR){
            logger.error("OFM API call returns error", "mock error for api down");
            throw ExceptionUtil.genBusinessException("MS804", "mock error for API Down");
        }
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(ofmApiEndPoint + "/" + MSECConstants.TD_OFM_API_KEYTYPE + cardNumber + "/" + MSECConstants.TD_OFM_API_PARTIES + "/" + partyId + "/" + MSECConstants.TD_OFM_API_FEATURES);
        uriComponentsBuilder.queryParam(MSECConstants.TD_OFM_API_SOLICIATIONCHANNELTYPECD, "INTERNET-SECURE");
        uriComponentsBuilder.queryParam(MSECConstants.TD_OFM_API_ACCESSCHANNELTYPECD, "ONLINE-SECURE-SITE");
        HttpEntity<?> requestEntity = new HttpEntity<>(prepareHeader(connectId,token));
        HttpEntity<TSvcRetrieveCreditCardAgreementPartyFeatureListRs> httpResponseEntity = null;
        try {
            httpResponseEntity = restTemplate.exchange(uriComponentsBuilder.build().toUri(), HttpMethod.GET, requestEntity, TSvcRetrieveCreditCardAgreementPartyFeatureListRs.class);
        } catch (RestClientException exception) {
             String msg = "OFM Api returns error response "+ exception.getMessage();
             logger.error(msg);
            throw ExceptionUtil.genBusinessException("MS804", msg);
        }

        if (httpResponseEntity ==  null){
            String msg = " OFM API returns null for connectId =" + connectId;
            logger.error(msg);
            throw ExceptionUtil.genBusinessException("MS804", msg);
        }
        logger.info("OFM response for connection : " + connectId + "api response "+ httpResponseEntity.getBody());
        return httpResponseEntity.getBody();
    }


    public TSvcRetrieveCreditCardAgreementPartyFeatureListRs retrieveEligibility(String connectId, TSvcRetrieveCreditCardAgreementPartyFeatureListRq retrieveEligibilityRequest, String token) {
    	
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(ofmApiEndPoint + "/" + MSECConstants.TD_OFM_API_KEYTYPE + retrieveEligibilityRequest.getCardNum() + "/" + MSECConstants.TD_OFM_API_PARTIES + "/" + retrieveEligibilityRequest.getPartyId() + "/" + MSECConstants.TD_OFM_API_FEATURES);
        uriComponentsBuilder.queryParam(MSECConstants.TD_OFM_API_SOLICIATIONCHANNELTYPECD, retrieveEligibilityRequest.getSolicitationChannelTypeCd());
        uriComponentsBuilder.queryParam(MSECConstants.TD_OFM_API_ACCESSCHANNELTYPECD, retrieveEligibilityRequest.getAccessChannelTypeCd());
        HttpEntity<?> requestEntity = new HttpEntity<>(prepareHeader(connectId,token));
        HttpEntity<TSvcRetrieveCreditCardAgreementPartyFeatureListRs> httpResponseEntity = restTemplate.exchange(uriComponentsBuilder.build().toUri(), HttpMethod.GET, requestEntity, TSvcRetrieveCreditCardAgreementPartyFeatureListRs.class);
        return httpResponseEntity.getBody();
    }


    public static HttpHeaders prepareHeader(String connectId, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(MSECConstants.CONNECT_ID, connectId);
        headers.add(MSECConstants.AUTHORIZATION,token);
        return headers;
    }

}
