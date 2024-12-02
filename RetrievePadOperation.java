package com.td.mbna.msec.midtier.autopay;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.td.mbna.msec.midtier.autopay.payload.retrievepad.RetrievePadRequest;
import com.td.mbna.msec.midtier.autopay.payload.retrievepad.RetrievePadResponse;
import com.td.mbna.msec.midtier.mbnaap.MbnaAP;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;

@Component
public class RetrievePadOperation implements MsecMidtierCommonOperations<RetrievePadRequest, RetrievePadResponse> {

    private final static MbnaLogger logger = new MbnaLogger(RetrievePadOperation.class);

    private static final String GENERAL_ERROR = "MS601";
    
	@Autowired
    private MbnaAP mbnaAP;

    @Override
    public RetrievePadResponse invokeService(RetrievePadRequest request, String... token) {

        try {
        	RetrievePadResponse response = mbnaAP.retrievePad(request.getRequestPayload().getArrangementId(), token[0]);
            return response;
        } catch (Exception e) {
            logger.error("AccountService:RetrievePadOperation", e.getLocalizedMessage(), e);
            throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR, " RetrievePadOperation falied ", e);
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
