package com.td.mbna.msec.midtier.offers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.td.mbna.msec.midtier.offers.payload.retrieveoffers.RetrieveOffersResponse;
import com.td.mbna.msec.midtier.offers.payload.retrieveoffersforaccounts.RetrieveOffersForAccountsRequest;
import com.td.mbna.msec.midtier.offers.payload.retrieveoffersforaccounts.RetrieveOffersForAccountsResponse;
import com.td.mbna.msec.midtier.types.common.AccountOfferInputType;
import com.td.mbna.msec.midtier.types.common.AccountOffersType;
import com.td.mbna.msec.midtier.types.common.PromotionOfferType;
import com.td.mbna.msec.midtier.mbofp.MbnaOFP;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.ParallelServiceCaller;
import com.td.mbna.msec.midtier.util.ServiceCall;
import com.td.mbna.msec.midtier.util.services.MSECConstants;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;

@Component
public class RetrieveOffersForAccountsOperation implements MsecMidtierCommonOperations<RetrieveOffersForAccountsRequest, RetrieveOffersForAccountsResponse> {

	private static MbnaLogger logger = new MbnaLogger(RetrieveOffersForAccountsOperation.class);

	@Autowired 
	private MbnaOFP mbnaOFP;

	@Override
	public RetrieveOffersForAccountsResponse invokeService(RetrieveOffersForAccountsRequest request, String... token) {
    	try {
    		RetrieveOffersForAccountsResponse response = new RetrieveOffersForAccountsResponse();
    		com.td.mbna.msec.midtier.offers.payload.retrieveoffersforaccounts.ResponsePayload payload = new com.td.mbna.msec.midtier.offers.payload.retrieveoffersforaccounts.ResponsePayload();
    		response.setResponsePayload(payload);
    		List<AccountOffersType> acctOffersList = payload.getAccountOffers();
    		List<AccountOfferInputType> accts = request.getRequestPayload().getAccountOfferInput();
    		
    		// Schedule web service calls to be executed in parallel
    		final ParallelServiceCaller rtrOffersCaller = new ParallelServiceCaller();
       		for (final AccountOfferInputType acct : accts) {
       			ServiceCall<?> rtrOffersCall = new ServiceCall<RetrieveOffersResponse>() {
					@Override
					public RetrieveOffersResponse invoke() throws Exception {
			        	Map<String, String> params = new HashMap<>(2);
			            params.put(MSECConstants.TD_OFP_API_AGREEMENT_ID, acct.getAcctNum());
			            params.put(MSECConstants.TD_OFP_API_PARTY_ID, request.getCustId());
						return mbnaOFP.retrieveOfferList(params, token[0]);
					}
       			};
       			rtrOffersCaller.scheduleCall(acct.getAcctNum(), rtrOffersCall);
       		}
       		
       		// Wait for all the spawned web service calls to be completed
       		rtrOffersCaller.sync();
     		
     		// Extract response from web service calls and set values in the final response accordingly.
       		for (final AccountOfferInputType acct : accts) {
    			final AccountOffersType acctOffers = new AccountOffersType();
    			acctOffers.setAcctNum(acct.getAcctNum());
    			RetrieveOffersResponse roRes = rtrOffersCaller.getResponse(acct.getAcctNum(), RetrieveOffersResponse.class);
    			List<PromotionOfferType> offers = acctOffers.getPromotionOffer();
    			for (PromotionOfferType offer : roRes.getResponsePayload().getPromotionOffer()) {
    				offers.add(offer);
    			}
    			
    			acctOffersList.add(acctOffers);
       		}
    		return response;
    	}
    	catch (Exception e) {
    		logger.error("invokeService", e.getMessage(), e);
			throw MidtierUtilHelper.prepareBusinessException("MS542", "MS542", e);
    	}
    }


	public void scheduleRetrieveOffersForAccounts(String connectId, String custId, com.mbnaweb.xsd.msgs.account.GetAccountOverviewsResponse acctOverviewsRes, ParallelServiceCaller rtrOffersCaller, String token) throws Exception {
    	List<com.mbnaweb.xsd.types.common.AcctOverviewType> acctOverviews = acctOverviewsRes.getResponsePayload().getCustAccts();

		for (com.mbnaweb.xsd.types.common.AcctOverviewType acctOverview : acctOverviews) {
			if(acctOverview == null){
				continue;
			}
   			ServiceCall<?> rtrOffersCall = new ServiceCall<RetrieveOffersResponse>() {
				@Override
				public RetrieveOffersResponse invoke() throws Exception {
		        	Map<String, String> params = new HashMap<>(3);
		            params.put(MSECConstants.TD_OFP_API_AGREEMENT_ID, acctOverview.getAcctNum());
		            params.put(MSECConstants.CONNECT_ID, connectId);
		            params.put(MSECConstants.TD_OFP_API_PARTY_ID, custId);
		            if(acctOverview.getCreditLimit() != null){
		            	params.put(MSECConstants.TD_OFP_API_CREDIT_LIMIT, acctOverview.getCreditLimit().toString());
		            }
					return mbnaOFP.retrieveOfferList(params, token);
				}
   			};
   			rtrOffersCaller.scheduleCall(acctOverview.getAcctNum(), rtrOffersCall);
   		}
	}

	
	public RetrieveOffersForAccountsResponse getRetrieveOffersForAccountsResult(List<String> acctNumbers, ParallelServiceCaller rtrOffersCaller) throws Exception {
		RetrieveOffersForAccountsResponse response = new RetrieveOffersForAccountsResponse();
		com.td.mbna.msec.midtier.offers.payload.retrieveoffersforaccounts.ResponsePayload payload = new com.td.mbna.msec.midtier.offers.payload.retrieveoffersforaccounts.ResponsePayload();
		response.setResponsePayload(payload);
		List<AccountOffersType> acctOffersList = payload.getAccountOffers();

 		// Extract response from web service calls and set values in the final response accordingly.
   		for (String acctNum : acctNumbers) {
			RetrieveOffersResponse roRes = rtrOffersCaller.getResponse(acctNum, RetrieveOffersResponse.class);
			final AccountOffersType acctOffers = new AccountOffersType();
			acctOffers.setAcctNum(acctNum);
			if(roRes != null && roRes.getResponsePayload() != null){
				acctOffers.getPromotionOffer().addAll(roRes.getResponsePayload().getPromotionOffer());
			}
			acctOffersList.add(acctOffers);
   		}
		return response;
	}
	
	@Override
	public boolean requiresDisclosureConsent() {
		return false;
	}

	@Override
	public String getConsentDisclosureFailedMsgCode() {
		return null;
	}

	@Override
	public boolean generateAutoComment() {
		return false;
	}

	@Override
	public List<String> createAutoComment(BaseRequest request, BaseResponse response) {
		return null;
	}

	@Override
	public EmailInfo getEmailInfoBean(BaseRequest request, BaseResponse response) {
		return null;
	}

	@Override
	public MsecValidator getValidator() {
		return null;
	}
}
