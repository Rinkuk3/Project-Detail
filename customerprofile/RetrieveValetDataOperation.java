package com.td.mbna.msec.midtier.customerprofile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.td.mbna.msec.midtier.customerprofile.payload.retrievevaletdata.RetrieveValetDataRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.retrievevaletdata.RetrieveValetDataResponse;
import com.td.mbna.msec.midtier.mbcapd.MbnaCapd;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;

@Component
public class RetrieveValetDataOperation implements MsecMidtierCommonOperations<RetrieveValetDataRequest, RetrieveValetDataResponse> {

//    private static final MbnaLogger logger = new MbnaLogger(RetrieveValetDataOperation.class);

    @Autowired
    private MbnaCapd mbnaCapd;
    
    @Override
    public RetrieveValetDataResponse invokeService(RetrieveValetDataRequest request, String... token) {
    	return mbnaCapd.retrieveValetData(request, token);
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
