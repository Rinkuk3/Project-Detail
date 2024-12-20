package com.td.mbna.msec.midtier.rewards;

import com.td.mbna.msec.midtier.account.payload.getrewardsbalances.GetRewardsBalancesRequest;
import com.td.mbna.msec.midtier.account.payload.getrewardsbalances.GetRewardsBalancesResponse;
import com.td.mbna.msec.midtier.account.payload.getrewardssaml.GetRewardsSamlRequest;
import com.td.mbna.msec.midtier.account.payload.getrewardssaml.GetRewardsSamlResponse;
import com.td.mbna.msec.midtier.rewards.facade.MbnaRewardsFacade;
import com.td.mbna.msec.midtier.util.perf.ProfileLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MbnaRewardsImpl implements MbnaRewards {

    @Autowired
    private MbnaRewardsFacade mbnaRewardsFacade;
    
	@Override
	@ProfileLog
	public GetRewardsBalancesResponse getRewardsBalances(GetRewardsBalancesRequest request, String token) {
		return mbnaRewardsFacade.getRewardsBalanceInfo(request, token);
	}

	@Override
	@ProfileLog
	public GetRewardsSamlResponse getRewardsSaml(GetRewardsSamlRequest request, String token) {
		return mbnaRewardsFacade.getRewardsSaml(request, token);
	}


}
