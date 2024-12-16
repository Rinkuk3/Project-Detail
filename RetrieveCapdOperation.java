package com.td.mbna.msec.midtier.customerprofile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.td.mbna.msec.midtier.customerprofile.payload.retrievecapd.RetrieveCapdRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.retrievecapd.RetrieveCapdResponse;
import com.td.mbna.msec.midtier.mbcapd.MbnaCapd;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;

@Component
public class RetrieveCapdOperation implements MsecMidtierCommonOperations<RetrieveCapdRequest, RetrieveCapdResponse> {

    private static MbnaLogger logger = new MbnaLogger(RetrieveCapdOperation.class);

    @Autowired
    private MbnaCapd mbnaCapd;
    
	@Override
	public RetrieveCapdResponse invokeService(RetrieveCapdRequest request, String... token) {

		RetrieveCapdResponse response = mbnaCapd.retrieveCapd(request, token);

		if (response == null){
			String message = " Got a null response from mbnaCapd.retriveCapd method. ";
	    	logger.error(message);
			throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,message);
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
        return true;
    }

    @Override
    public List<String> createAutoComment(BaseRequest request, BaseResponse response) {
        return null;
    }

    @Override
    public EmailInfo getEmailInfoBean(BaseRequest baseRequest, BaseResponse baseResponse) {
    	return null;
    }

    @Override
    public MsecValidator getValidator() {
        return null;
    }
}
