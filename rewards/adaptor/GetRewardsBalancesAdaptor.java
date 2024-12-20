package com.td.mbna.msec.midtier.rewards.adaptor;

import org.springframework.stereotype.Service;

import com.td.api.rewards.response.getrewardsbalances.RewardsBalanceDTO;
import com.td.api.rewards.response.getrewardsbalances.RewardsBalanceItem;
import com.td.api.rewards.response.getrewardsbalances.RewardsBalanceList;
import com.td.api.rewards.response.getrewardsbalances.RewardsBalancesResponse;
import com.td.mbna.msec.midtier.account.payload.getrewardsbalances.GetRewardsBalancesResponse;

@Service
public class GetRewardsBalancesAdaptor extends MbnaRewardsAdaptor {

    public GetRewardsBalancesResponse getResponse(RewardsBalancesResponse rbr) {
        GetRewardsBalancesResponse response = new GetRewardsBalancesResponse();
    	
        if (rbr != null && rbr.getRewardsBalance() != null && rbr.getRewardsBalance().getAvailable() != null){
        	RewardsBalanceDTO rewardsBalance =  rbr.getRewardsBalance().getAvailable();
        	response.getResponsePayload().setAvailableBalanceQty(rewardsBalance.getValue());
        	response.getResponsePayload().setLoyaltyUnitOfMeasure(rewardsBalance.getRewardscurrency());
        }
        
        return response;
    }

	public GetRewardsBalancesResponse getResponse(RewardsBalanceList rbl) {
        GetRewardsBalancesResponse response = new GetRewardsBalancesResponse();
    	
        if (rbl != null && rbl.getAvailableBalance() != null && !rbl.getAvailableBalance().isEmpty()){
        	RewardsBalanceItem rewardsBalanceItem =  rbl.getAvailableBalance().get(0);
        	response.getResponsePayload().setAvailableBalanceQty(rewardsBalanceItem.getAvailableBalanceQty());
        	response.getResponsePayload().setLoyaltyUnitOfMeasure(rewardsBalanceItem.getLoyaltyUnitOfMeasureCd());
        }
        
        return response;
	}

}
