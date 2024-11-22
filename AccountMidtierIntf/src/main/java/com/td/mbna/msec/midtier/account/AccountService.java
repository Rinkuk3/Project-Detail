package com.td.mbna.msec.midtier.account;

import com.td.mbna.msec.midtier.account.payload.deleteaccount.DeleteAccountRequest;
import com.td.mbna.msec.midtier.account.payload.deleteaccount.DeleteAccountResponse;
import com.td.mbna.msec.midtier.account.payload.getaccountsnapshot.GetAccountSnapshotRequest;
import com.td.mbna.msec.midtier.account.payload.getaccountsnapshot.GetAccountSnapshotResponse;
import com.td.mbna.msec.midtier.account.payload.getrewardsbalances.GetRewardsBalancesRequest;
import com.td.mbna.msec.midtier.account.payload.getrewardsbalances.GetRewardsBalancesResponse;
import com.td.mbna.msec.midtier.account.payload.getrewardssaml.GetRewardsSamlRequest;
import com.td.mbna.msec.midtier.account.payload.getrewardssaml.GetRewardsSamlResponse;
import com.td.mbna.msec.midtier.account.payload.retrieveipplanlist.RetrieveIpPlanListRequest;
import com.td.mbna.msec.midtier.account.payload.retrieveipplanlist.RetrieveIpPlanListResponse;

public interface AccountService {
	public GetAccountSnapshotResponse getAccountSnapshot(GetAccountSnapshotRequest request, String... token);
	public DeleteAccountResponse deleteAccount(DeleteAccountRequest request, String... token);
	public RetrieveIpPlanListResponse retrieveIpPlanList(RetrieveIpPlanListRequest request, String... token);
	public GetRewardsBalancesResponse getRewardsBalances(GetRewardsBalancesRequest request, String... token);
	public GetRewardsSamlResponse getRewardsSaml(GetRewardsSamlRequest request, String... token);
}
