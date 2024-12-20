package com.td.mbna.msec.midtier.mbcapd.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.td.api.mbcapd.request.retrievecapd.AgreementInquiryRequest;
import com.td.api.mbcapd.response.retrievecapd.AgreementInquiryResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.retrievecapd.RetrieveCapdRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.retrievecapd.RetrieveCapdResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.retrievevaletdata.RetrieveValetDataRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.retrievevaletdata.RetrieveValetDataResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.savevaletdata.SaveValetDataRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.savevaletdata.SaveValetDataResponse;
import com.td.mbna.msec.midtier.mbcapd.adaptor.MbnaCapdAdaptor;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MSECConstants;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;

@Service
public class MbnaCapdFacade {
    private static final String apiCapdEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_CAPD_ENDPT);
    private static final String apiValetEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_VALET_API_ENDPT);
    private static final String apiValetTrashEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_VALET_API_TRASH_ENDPT);

    private static final MbnaLogger logger = new MbnaLogger(MbnaCapdFacade.class);

    @Autowired
    protected RestTemplate restTemplate;

    @Autowired
    private MbnaCapdAdaptor mbnaCapdAdaptor;
    
    public RetrieveCapdResponse retrieveCapd(RetrieveCapdRequest retrieveCapdRequest, String... token){
    	AgreementInquiryRequest agreementInquiryRequest = mbnaCapdAdaptor.getRequest(retrieveCapdRequest);
    	if (agreementInquiryRequest == null) {
    		return null;
    	}
    	
    	HttpEntity<AgreementInquiryRequest> requestEntity = new HttpEntity<>(agreementInquiryRequest, addAuthorizationHeader(token[0]));
    	ResponseEntity<AgreementInquiryResponse> responseEntity = null;
        try{
            responseEntity = restTemplate.exchange(apiCapdEndPoint, HttpMethod.POST, requestEntity, AgreementInquiryResponse.class);
            if (responseEntity != null && responseEntity.getBody()!=null){
            	return mbnaCapdAdaptor.getResponse(responseEntity.getBody());
            }
        } catch (Exception e){
        	logger.error("MbnaCapdFacade.retrieveCapd()", " Failed to call CAPD API: custID = " + retrieveCapdRequest.getCustId());
        	return null;
        }

    	return null; //mbnaCapdAdaptor.getResponse(retrieveCapdRequest.getSessionInfo().getConnectId());
    }
    
    public SaveValetDataResponse saveValetData(SaveValetDataRequest request, String... token){
    	SaveValetDataResponse response = new SaveValetDataResponse();
    	if (request == null || request.getRequestPayload() == null){
        	logger.error("MbnaCapdFacade.saveValetData() failed with null requestPayload");
    		return null;
    	}
    	
    	HttpEntity<com.td.mbna.msec.midtier.customerprofile.payload.savevaletdata.RequestPayload> requestEntity = new HttpEntity<>(request.getRequestPayload(), addAuthorizationHeader(token[0]));

    	ResponseEntity<com.td.mbna.msec.midtier.customerprofile.payload.savevaletdata.ResponsePayload> responseEntity = null;
        try{
            responseEntity = restTemplate.exchange(apiValetEndPoint, HttpMethod.POST, requestEntity, com.td.mbna.msec.midtier.customerprofile.payload.savevaletdata.ResponsePayload.class);
            if (responseEntity != null && responseEntity.getBody()!=null){
            	response.setResponsePayload(responseEntity.getBody());
            }
        } catch (Exception e){
        	logger.error("MbnaCapdFacade.saveValetData() failed with call valet API");
        	return null;
        }

    	return response;
    }

    public RetrieveValetDataResponse retrieveValetData(RetrieveValetDataRequest request, String... token){
    	RetrieveValetDataResponse response = new RetrieveValetDataResponse();
    	if (request == null || request.getRequestPayload() == null){
    		logger.error("MbnaCapdFacade.retrieveValetData() failed with null requestPayload");
    		return null;
    	}
    	
    	HttpEntity<com.td.mbna.msec.midtier.customerprofile.payload.retrievevaletdata.RequestPayload> requestEntity = new HttpEntity<>(request.getRequestPayload(), addAuthorizationHeader(token[0]));
    	
    	ResponseEntity<com.td.mbna.msec.midtier.customerprofile.payload.retrievevaletdata.ResponsePayload> responseEntity = null;
    	try{
    		responseEntity = restTemplate.exchange(apiValetTrashEndPoint, HttpMethod.POST, requestEntity, com.td.mbna.msec.midtier.customerprofile.payload.retrievevaletdata.ResponsePayload.class);
    		if (responseEntity != null && responseEntity.getBody()!=null){
    			response.setResponsePayload(responseEntity.getBody());
    		}
    	} catch (Exception e){
    		logger.error("MbnaCapdFacade.retrieveValetData() failed with call valet trash API");
    		return null;
    	}
    	
    	return response;
    }
    
    private HttpHeaders addAuthorizationHeader(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(MSECConstants.AUTHORIZATION, token);
        return headers;
    }
    
}
