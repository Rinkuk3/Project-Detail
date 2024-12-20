package com.td.mbna.msec.midtier.rewards;

import com.td.mbna.msec.midtier.account.payload.getrewardsbalances.GetRewardsBalancesRequest;
import com.td.mbna.msec.midtier.account.payload.getrewardsbalances.GetRewardsBalancesResponse;
import com.td.mbna.msec.midtier.account.payload.getrewardssaml.GetRewardsSamlRequest;
import com.td.mbna.msec.midtier.account.payload.getrewardssaml.GetRewardsSamlResponse;

public interface MbnaRewards {
	public GetRewardsBalancesResponse getRewardsBalances(GetRewardsBalancesRequest request, String token);
	public GetRewardsSamlResponse getRewardsSaml(GetRewardsSamlRequest request, String token);

}
