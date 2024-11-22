package com.td.mbna.msec.midtier.account;

import com.td.mbna.msec.midtier.account.payload.deleteaccount.DeleteAccountResponse;
import com.td.mbna.msec.midtier.account.payload.getaccountsnapshot.GetAccountSnapshotRequest;
import com.td.mbna.msec.midtier.account.payload.getrewardsbalances.GetRewardsBalancesRequest;
import com.td.mbna.msec.midtier.account.payload.getrewardsbalances.GetRewardsBalancesResponse;
import com.td.mbna.msec.midtier.account.payload.getrewardssaml.GetRewardsSamlRequest;
import com.td.mbna.msec.midtier.account.payload.getrewardssaml.GetRewardsSamlResponse;
import com.td.mbna.msec.midtier.account.payload.retrieveipplanlist.RetrieveIpPlanListRequest;
import com.td.mbna.msec.midtier.account.payload.retrieveipplanlist.RetrieveIpPlanListResponse;
import com.td.mbna.msec.midtier.account.AccountService;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.perf.ProfileLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	private final static MbnaLogger logger = new MbnaLogger(AccountServiceImpl.class);

	@Autowired
	private GetRewardsBalancesOperation getRewardsBalancesOperation;

	@Autowired
	private GetRewardsSamlOperation getRewardsSamlOperation;
	
	@Autowired
	private DeleteAccountOperation deleteAccountOperation;
	
	@Autowired
	private GetAccountSnapshotOperation getAccountSnapshotOperation;
	
	@Autowired
	private RetrieveIpPlanListOperation retrieveIpPlanListOperation;

	@ProfileLog
	public DeleteAccountResponse deleteAccount(com.td.mbna.msec.midtier.account.payload.deleteaccount.DeleteAccountRequest deleteAccountRequest, String... token){
		logger.info("Entering AccountService.deleteAccount()...");
		return deleteAccountOperation.invokeService(deleteAccountRequest, token);
	}

	@ProfileLog
	public com.td.mbna.msec.midtier.account.payload.getaccountsnapshot.GetAccountSnapshotResponse getAccountSnapshot(
			GetAccountSnapshotRequest request, String... token) {

		logger.info("Entering AccountService.getAccountSnapshot()...");
		return getAccountSnapshotOperation.invokeService(request,token);
	}

	@Override
	@ProfileLog
	public RetrieveIpPlanListResponse retrieveIpPlanList(RetrieveIpPlanListRequest request, String... token) {
		return retrieveIpPlanListOperation.invokeService(request, token);
	}

	@Override
	@ProfileLog
	public GetRewardsBalancesResponse getRewardsBalances(GetRewardsBalancesRequest request, String... token) {
		return getRewardsBalancesOperation.invokeService(request, token);
	}

	@Override
	@ProfileLog
	public GetRewardsSamlResponse getRewardsSaml(GetRewardsSamlRequest request, String... token) {
		return getRewardsSamlOperation.invokeService(request, token);
	}

}
