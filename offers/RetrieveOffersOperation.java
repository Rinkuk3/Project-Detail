package com.td.mbna.msec.midtier.offers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.td.mbna.msec.midtier.mbofp.MbnaOFP;
import com.td.mbna.msec.midtier.offers.payload.retrieveoffers.RetrieveOffersRequest;
import com.td.mbna.msec.midtier.offers.payload.retrieveoffers.RetrieveOffersResponse;

import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;

import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MSECConstants;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;

@Component
public class RetrieveOffersOperation implements MsecMidtierCommonOperations<RetrieveOffersRequest, RetrieveOffersResponse> {

    private static MbnaLogger logger = new MbnaLogger(RetrieveOffersOperation.class);
    private static final String GENERAL_ERROR = "MS601";

	@Autowired 
	private MbnaOFP mbnaOFP;
	
    @Override
    public RetrieveOffersResponse invokeService(RetrieveOffersRequest request, String... token) {
    	try {
        	Map<String, String> params = new HashMap<>(2);
            params.put(MSECConstants.TD_OFP_API_AGREEMENT_ID, request.getAcctNum());
            params.put(MSECConstants.TD_OFP_API_PARTY_ID, request.getCustId());
			return mbnaOFP.retrieveOfferList(params, token[0]);
		} catch (Exception e) {
            logger.error("RetrieveOffersOperation:invokeService", e.getLocalizedMessage(), e);
            throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,GENERAL_ERROR);
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
