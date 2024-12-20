package com.td.mbna.msec.midtier.mbofp.adaptor;

import com.td.api.mbofp.request.productchange.Party;
import com.td.api.mbofp.request.productchange.ProductChangeEvent;
import com.td.api.mbofp.request.productchange.ProductChangeRequest;
import com.td.api.mbofp.response.productchange.ProductChangeResponse;
import com.td.api.mbofp.shared.AgreementAltkey;
import com.td.mbna.msec.midtier.offers.payload.requestproductchange.RequestProductChangeResponse;
import com.td.mbna.msec.midtier.util.services.MSECConstants;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductChangeAdaptor extends MbnaOfpAdaptor {

    public ProductChangeRequest getRequest(Map<String, Object> params) {
        AgreementAltkey agreementAltkey = new AgreementAltkey();
        agreementAltkey.setCardNum((String) params.get(PARAM_CARD_NO));

        Party party = new Party();
        party.setLanguageTypeCd((String) params.get(PARAM_LANG_PREF));

        ProductChangeEvent productChangeEvent = new ProductChangeEvent();
        productChangeEvent.setAgreementAltkey(agreementAltkey);
        productChangeEvent.setParty(party);
        productChangeEvent.setEventReasonCd(EVENT_REASON_CODE_PC);
        productChangeEvent.setProductId((String) params.get(PARAM_SUBPRODUCT_ID));
        productChangeEvent.setSolicitationChannelTypeCd(MSECConstants.INTERNET_SECURE);
        productChangeEvent.setAccessChannelTypeCd(MSECConstants.ONLINE_SECURE_SITE);

        ProductChangeRequest request = new ProductChangeRequest();
        request.setProductChangeEvent(productChangeEvent);
        return request;
    }

    public RequestProductChangeResponse getResponse(ProductChangeResponse pcr) {
        RequestProductChangeResponse response = new RequestProductChangeResponse();
        com.td.mbna.msec.midtier.offers.payload.requestproductchange.ResponsePayload responsePayload = new com.td.mbna.msec.midtier.offers.payload.requestproductchange.ResponsePayload();

        // check pcr status:  eventId
        if (pcr != null && pcr.getEventId() != null) {
        	responsePayload.setStatus(true);
        } else {
        	responsePayload.setStatus(false);
        }

        response.setResponsePayload(responsePayload);
        return response;
    }
	/*
	public ProductChangeResponse productChange(Map<String, Object> params, String token) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(apiOfmCcaEndPoint)
        		.path(PATH_ACCOUNT + (String)params.get(PARAM_ACCT_ID) + PATH_PRODUCT_CHANGE);
        
        AgreementAltkey agreementAltkey = new AgreementAltkey();
        agreementAltkey.setCardNum((String)params.get(PARAM_CARD_NO));
        
        Party party = new Party();
        party.setLanguageTypeCd((String)params.get(PARAM_LANG_PREF));
//      party.setIdentificationMembershipNum(identificationMembershipNum);
        
        ProductChangeEvent productChangeEvent = new ProductChangeEvent();
        productChangeEvent.setAgreementAltkey(agreementAltkey);
        productChangeEvent.setParty(party);
        productChangeEvent.setEventReasonCd(PRODUCT_CHANGE_OFFER);
        productChangeEvent.setProductId((String)params.get(PARAM_SUBPRODUCT_ID));
        productChangeEvent.setSolicitationChannelTypeCd(MSECConstants.INTERNET_SECURE);
        productChangeEvent.setAccessChannelTypeCd(MSECConstants.ONLINE_SECURE_SITE);

        ProductChangeRequest request = new ProductChangeRequest();
        request.setProductChangeEvent(productChangeEvent);
        
        HttpEntity<ProductChangeRequest> requestEntity = new HttpEntity<>(request, addAuthorizationHeader(token));

        ResponseEntity<ProductChangeResponse> responseEntity = restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.POST, requestEntity, ProductChangeResponse.class);

		return responseEntity.getBody();
	}	
*/
}
