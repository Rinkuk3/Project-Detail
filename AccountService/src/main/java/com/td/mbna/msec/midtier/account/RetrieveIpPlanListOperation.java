package com.td.mbna.msec.midtier.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.td.mbna.msec.midtier.account.payload.retrieveipplanlist.RetrieveIpPlanListRequest;
import com.td.mbna.msec.midtier.account.payload.retrieveipplanlist.RetrieveIpPlanListResponse;
import com.td.mbna.msec.midtier.mbcca.MbnaCCA;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;

@Component
public class RetrieveIpPlanListOperation implements MsecMidtierCommonOperations<RetrieveIpPlanListRequest, RetrieveIpPlanListResponse> {

    private final static MbnaLogger logger = new MbnaLogger(RetrieveIpPlanListOperation.class);

    private static final String GENERAL_ERROR = "MS601";
    
	@Autowired
    private MbnaCCA mbnaCCA;

    @Override
    public RetrieveIpPlanListResponse invokeService(RetrieveIpPlanListRequest request, String... token) {

        try {
        	RetrieveIpPlanListResponse response = mbnaCCA.retrieveIpPlanList(request.getSessionInfo().getConnectId(), request.getAcctNum(), token[0]);
            return response;
        } catch (Exception e) {
            logger.error("AccountService:RetrieveIpPlanListOperation", e.getLocalizedMessage(), e);
            throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR, " RetrieveIpPlanListOperation falied ", e);
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
