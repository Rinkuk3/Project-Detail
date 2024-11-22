package com.td.mbna.msec.midtier.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.td.mbna.msec.midtier.account.payload.getrewardsbalances.GetRewardsBalancesRequest;
import com.td.mbna.msec.midtier.account.payload.getrewardsbalances.GetRewardsBalancesResponse;
import com.td.mbna.msec.midtier.rewards.MbnaRewards;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.MbnaLogger;

@Component
public class GetRewardsBalancesOperation implements MsecMidtierCommonOperations<GetRewardsBalancesRequest, GetRewardsBalancesResponse> {

    private static MbnaLogger logger = new MbnaLogger(GetRewardsBalancesOperation.class);

    @Autowired
    private MbnaRewards mbnaRewards;

    @Override
    public GetRewardsBalancesResponse invokeService(GetRewardsBalancesRequest request, String... token) {

		try {
			return mbnaRewards.getRewardsBalances(request, token[0]);
		} catch (Exception e) {
			logger.error("GetRewardsBalancesOperation", "invokeService", e);
			return new GetRewardsBalancesResponse(); // eat the exception, return empty response
		}
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