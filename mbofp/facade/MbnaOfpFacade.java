package com.td.mbna.msec.midtier.mbofp.facade;

import com.td.api.mbofp.request.balancetransfer.BalanceTransferRequest;
import com.td.api.mbofp.request.installmentplan.AddTargetPromotionAgreementFinancialEventRequest;
import com.td.api.mbofp.request.insuranceenrolment.InsuranceEnrolmentRequest;
import com.td.api.mbofp.request.productchange.ProductChangeRequest;
import com.td.api.mbofp.request.updateofferdisposition.UpdateOfferDispositionRequest;
import com.td.api.mbofp.response.balancetransfer.BalanceTransferResponse;
import com.td.api.mbofp.response.installmentplan.AddTargetPromotionAgreementFinancialEventResponse;
import com.td.api.mbofp.response.insuranceenrolment.InsuranceEnrolmentResponse;
import com.td.api.mbofp.response.productchange.ProductChangeResponse;
import com.td.api.mbofp.response.retrieveofferlist.RetrieveOfferListRs;
import com.td.api.mbofp.response.updateofferdisposition.UpdateOfferDispositionResponse;
import com.td.mbna.msec.midtier.mbofp.adaptor.*;
import com.td.mbna.msec.midtier.offers.payload.requestInstallmentPlan.RequestInstallmentPlanRequest;
import com.td.mbna.msec.midtier.offers.payload.requestinsurance.RequestInsuranceResponse;
import com.td.mbna.msec.midtier.offers.payload.requestproductchange.RequestProductChangeResponse;
import com.td.mbna.msec.midtier.offers.payload.retrieveoffers.RetrieveOffersResponse;
import com.td.mbna.msec.midtier.transfer.payload.balancetransfertocreditor.BalanceTransferToCreditorResponse;
import com.td.mbna.msec.midtier.transfer.payload.deposittochequing.DepositToChequingResponse;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MSECConstants;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class MbnaOfpFacade {
    protected static final String apiRetrieveOffersEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_OFP_OFFERS_ENDPT);
    protected static final String apiOfmCcaEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_OFM_API_ENDPT);
    protected static final String apiOfpCcaEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_OFP_CCA_ENDPT);
    protected static final String apiOfpBtEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_OFP_BT_ENDPT);
    private static final String apiOfpIpEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_OFP_API_ENDPT) + "/targetpromotionagreementfinancialevents";

    protected static final String PARAM_ACCOUNT_NO = "accountNo";
    protected static final String PARAM_ACCT_ID = "acctId";
    protected static final String PARAM_SUBPRODUCT_ID = "subProductId";

    protected static final String PATH_ACCOUNT = "/a";
    protected static final String PATH_PARTYRESPONSES = "/partyresponses";
    protected static final String PATH_PROMOTIONOFFERS = "/promotionoffers/";
    protected static final String PATH_PRODUCT_CHANGE = "/productchangeevents";
    protected static final String PATH_INSURANCE_ENROLMENT = "/insuranceenrolmentevents";

    private static MbnaLogger logger = new MbnaLogger(MbnaOfpFacade.class);

    @Autowired
    protected RestTemplate restTemplate;

    @Autowired
    private DepositToChequingAdaptor depositToChequingAdaptor;

    @Autowired
    private BalanceTransferAdaptor balanceTransferAdaptor;

    @Autowired
    private InsuranceEnrolmentAdaptor insuranceEnrolmentAdaptor;

    @Autowired
    private OffersRetrievalAdaptor offersRetrievalAdaptor;

    @Autowired
    private ProductChangeAdaptor productChangeAdaptor;

    @Autowired
    private UpdateOfferDispositionAdaptor updateOfferDispositionAdaptor;

    @Autowired
    private InstallmentPlanAdaptor installmentPlanAdaptor;

    public void updateOfferDisposition(Map<String, Object> params, String token) {
    	logger.debug("updateOfferDisposition(Map<String, Object> params, String token)::params="+params.toString());
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(apiOfpCcaEndPoint)
                .path(PATH_ACCOUNT + params.get(PARAM_ACCT_ID) + PATH_PROMOTIONOFFERS + params.get(PARAM_SUBPRODUCT_ID) + PATH_PARTYRESPONSES);
        HttpEntity<UpdateOfferDispositionRequest> requestEntity = new HttpEntity<>(updateOfferDispositionAdaptor.getRequest(params), prepareHeader(null, token));
        try {
        	logger.debug("updateOfferDisposition(Map<String, Object> params, String token)::uriComponentsBuilder="+uriComponentsBuilder.toString());
	        restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.POST, requestEntity, UpdateOfferDispositionResponse.class);
        } catch (Exception e){
        	String desc = "OFP offer disposition service failed ";
			logger.error("updateOfferDisposition", desc+e.getMessage(), e);
			throw MidtierUtilHelper.prepareBusinessException("MS601", "Failed when calling API to update offer disposition."+desc, e);
        }
        return;
    }

    public RequestProductChangeResponse requestProductChange(Map<String, Object> params, String token) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(apiOfmCcaEndPoint)
                .path(PATH_ACCOUNT + params.get(PARAM_ACCT_ID) + PATH_PRODUCT_CHANGE);
        HttpEntity<ProductChangeRequest> requestEntity = new HttpEntity<>(productChangeAdaptor.getRequest(params), prepareHeader(null, token));
        ResponseEntity<ProductChangeResponse> responseEntity = restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.POST, requestEntity, ProductChangeResponse.class);
        return productChangeAdaptor.getResponse(responseEntity.getBody());
    }

    public RetrieveOffersResponse retrieveOfferList(Map<String, String> params, String token) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(apiRetrieveOffersEndPoint);
        uriComponentsBuilder.queryParam(MSECConstants.TD_OFP_API_AGREEMENT_ID, params.get(MSECConstants.TD_OFP_API_AGREEMENT_ID));
        uriComponentsBuilder.queryParam(MSECConstants.TD_OFP_API_PARTY_ID, params.get(MSECConstants.TD_OFP_API_PARTY_ID));
        uriComponentsBuilder.queryParam(MSECConstants.TD_OFP_API_SOLICITATION_CHANNEL, MSECConstants.INTERNET_SECURE);
        uriComponentsBuilder.queryParam(MSECConstants.TD_OFP_API_ACCESS_CHANNEL, MSECConstants.ONLINE_SECURE_SITE);
        String connectId = (String)params.get(MSECConstants.CONNECT_ID);
        HttpEntity<?> requestEntity = new HttpEntity<>(prepareHeader(connectId,token));

        try {
            ResponseEntity<RetrieveOfferListRs> responseEntity = restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET, requestEntity, RetrieveOfferListRs.class);
            return offersRetrievalAdaptor.getResponse(responseEntity.getBody(), params);
        } catch (Exception e) {
            logger.error("retrieveOfferList", "Failed from API"+uriComponentsBuilder.toUriString(), e);
            return offersRetrievalAdaptor.getResponse(null, params); //empty offer list in case of exception from API
            //throw ExceptionUtil.genRuntimeException(e);
        }
    }

    public RequestInsuranceResponse insuranceEnrolment(Map<String, Object> params, String token) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(apiOfmCcaEndPoint)
                .path(PATH_ACCOUNT + params.get(PARAM_ACCOUNT_NO) + PATH_INSURANCE_ENROLMENT);
        HttpEntity<InsuranceEnrolmentRequest> requestEntity = new HttpEntity<>(insuranceEnrolmentAdaptor.getRequest(params), prepareHeader(null, token));
        ResponseEntity<InsuranceEnrolmentResponse> responseEntity = restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.POST, requestEntity, InsuranceEnrolmentResponse.class);
        return insuranceEnrolmentAdaptor.getResponse(responseEntity.getBody());
    }

    public DepositToChequingResponse depositToChequing(Map<String, Object> params, String token) {
        BalanceTransferRequest request = depositToChequingAdaptor.getRequest(params);
        HttpEntity<BalanceTransferRequest> requestEntity = new HttpEntity<>(request, prepareHeader(null, token));
        ResponseEntity<BalanceTransferResponse> responseEntity = restTemplate.exchange(apiOfpBtEndPoint, HttpMethod.POST, requestEntity, BalanceTransferResponse.class);
        return depositToChequingAdaptor.getResponse(responseEntity.getBody());
    }

    public BalanceTransferToCreditorResponse balanceTransferToCreditor(Map<String, Object> params, String token) {
        BalanceTransferRequest request = balanceTransferAdaptor.getRequest(params);
        HttpEntity<BalanceTransferRequest> requestEntity = new HttpEntity<>(request, prepareHeader(null, token));
        ResponseEntity<BalanceTransferResponse> responseEntity = restTemplate.exchange(apiOfpBtEndPoint, HttpMethod.POST, requestEntity, BalanceTransferResponse.class);
        return balanceTransferAdaptor.getResponse(responseEntity.getBody());
    }

    public AddTargetPromotionAgreementFinancialEventResponse requestInstallmentPlan(RequestInstallmentPlanRequest requestInstallmentPlanRequest, String token) {
        AddTargetPromotionAgreementFinancialEventRequest request = installmentPlanAdaptor.generateIPFinancialEventRequest(requestInstallmentPlanRequest);
        HttpEntity<AddTargetPromotionAgreementFinancialEventRequest> requestEntity = new HttpEntity<>(request,prepareHeader(null, token));
        ResponseEntity<AddTargetPromotionAgreementFinancialEventResponse> responseEntity = restTemplate.exchange(apiOfpIpEndPoint, HttpMethod.POST, requestEntity, AddTargetPromotionAgreementFinancialEventResponse.class);
        return responseEntity.getBody();
    }

    private HttpHeaders prepareHeader(String connectId, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(MSECConstants.CONNECT_ID, connectId);
        headers.add(MSECConstants.AUTHORIZATION, token);
        return headers;
    }
}
