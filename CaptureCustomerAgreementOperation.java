package com.td.mbna.msec.midtier.customerprofile;

import com.td.mbna.msec.midtier.customerprofile.payload.customeragreement.CaptureAgreementRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.customeragreement.CaptureAgreementResponse;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CaptureCustomerAgreementOperation implements MsecMidtierCommonOperations<CaptureAgreementRequest, CaptureAgreementResponse> {

    public CaptureAgreementResponse invokeService(CaptureAgreementRequest request, String... token) {
        String methodName ="CaptureCustomerAgreementOperation::invokeService";
        CaptureAgreementResponse captureAgreementResponse = new CaptureAgreementResponse();
        return captureAgreementResponse;
    }

    @Override
    public boolean requiresDisclosureConsent() {
        return true;
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
