package com.td.mbna.msec.midtier.rewards.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.td.api.rewards.request.getrewardssaml.RewardsSamlRequest;
import com.td.api.rewards.response.getrewardsbalances.RewardsBalanceList;
import com.td.api.rewards.response.getrewardsbalances.RewardsBalancesResponse;
import com.td.api.rewards.response.getrewardssaml.RewardsSamlResponse;
import com.td.mbna.msec.midtier.account.payload.getrewardsbalances.GetRewardsBalancesRequest;
import com.td.mbna.msec.midtier.account.payload.getrewardsbalances.GetRewardsBalancesResponse;
import com.td.mbna.msec.midtier.account.payload.getrewardssaml.GetRewardsSamlRequest;
import com.td.mbna.msec.midtier.account.payload.getrewardssaml.GetRewardsSamlResponse;
import com.td.mbna.msec.midtier.rewards.adaptor.GetRewardsBalancesAdaptor;
import com.td.mbna.msec.midtier.rewards.adaptor.GetRewardsSamlAdaptor;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MSECConstants;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;

@Service
public class MbnaRewardsFacade {
    private static final String rewardsBlancesApiEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_REWARDS_BAL_API_ENDPT);
    private static final String ssoSamlApiEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_REWARDS_SAML_API_ENDPT);
    private static final String ssoSamlBaseAuth = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_REWARDS_SAML_BASE_AUTH);

    protected static final String PATH_INFORMATION = "/information";
    protected static final String PATH_LOYALTYAGREEMENTS = "/v1/loyaltyagreements/a";
    protected static final String PATH_AVAILABLEBALANCES = "/availablebalances";

    private static MbnaLogger logger = new MbnaLogger(MbnaRewardsFacade.class);

    @Autowired
    protected RestTemplate restTemplate;

    @Autowired
    private GetRewardsSamlAdaptor getRewardsSamlAdaptor;

    @Autowired
    private GetRewardsBalancesAdaptor getRewardsBalancesAdaptor;

    public GetRewardsBalancesResponse getRewardsBalances(GetRewardsBalancesRequest request, String token) {
    	String url = UriComponentsBuilder.fromHttpUrl(rewardsBlancesApiEndPoint)
    			.path(PATH_LOYALTYAGREEMENTS)
    			.path(request.getAcctNum())
    			.path(PATH_AVAILABLEBALANCES)
    			.toUriString();
    	
    	HttpEntity<?> requestEntity = new HttpEntity<>(addAuthorizationHeader(token));
    	
    	try {
    		HttpEntity<RewardsBalanceList> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, RewardsBalanceList.class);
    		return getRewardsBalancesAdaptor.getResponse(responseEntity.getBody());
    	} catch (Exception e) {
    		logger.error("MbnaRewardsFacade:getRewardsBalances", request.getAcctNum(), e);
    		return new GetRewardsBalancesResponse();//empty object in case of exception from API
    	}
    }
    
    public GetRewardsBalancesResponse getRewardsBalanceInfo(GetRewardsBalancesRequest request, String token) {
        String url = UriComponentsBuilder.fromHttpUrl(rewardsBlancesApiEndPoint)
		.path(request.getAcctNum() + PATH_INFORMATION)
		.toUriString();

        HttpEntity<?> requestEntity = new HttpEntity<>(addAuthorizationHeader(token));

        try {
        	HttpEntity<RewardsBalancesResponse> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, RewardsBalancesResponse.class);
            return getRewardsBalancesAdaptor.getResponse(responseEntity.getBody());
        } catch (Exception e) {
            logger.error("MbnaRewardsFacade:getRewardsBalanceInfo", request.getAcctNum(), e);
            return new GetRewardsBalancesResponse();//empty object in case of exception from API
        }
    }

    public GetRewardsSamlResponse getRewardsSaml(GetRewardsSamlRequest request, String token) {
    	String url = UriComponentsBuilder.fromUriString(ssoSamlApiEndPoint).toUriString();

    	RewardsSamlRequest rewardsSamlRequest = getRewardsSamlAdaptor.getRequest(request);
        HttpEntity<RewardsSamlRequest> requestEntity = new HttpEntity<>(rewardsSamlRequest, addAuthorizationHeader("Basic "+ssoSamlBaseAuth));
        ResponseEntity<RewardsSamlResponse> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, RewardsSamlResponse.class);
        return getRewardsSamlAdaptor.getResponse(responseEntity.getBody());
    }

    private HttpHeaders addAuthorizationHeader(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(MSECConstants.AUTHORIZATION, token);
        return headers;
    }
}
