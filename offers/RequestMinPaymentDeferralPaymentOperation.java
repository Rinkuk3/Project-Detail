package com.td.mbna.msec.midtier.offers;

import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.mbofp.MbnaOFP;
import com.td.mbna.msec.midtier.offers.payload.requestminpaymentdeferral.RequestMinPaymentDeferralRequest;
import com.td.mbna.msec.midtier.offers.payload.requestminpaymentdeferral.RequestMinPaymentDeferralResponse;
import com.td.mbna.msec.midtier.offers.payload.requestminpaymentdeferral.ResponsePayload;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.CustomerNotesUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.UuidUtil;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RequestMinPaymentDeferralPaymentOperation implements MsecMidtierCommonOperations<RequestMinPaymentDeferralRequest, RequestMinPaymentDeferralResponse> {

    MbnaLogger logger = new MbnaLogger(RequestMinPaymentDeferralPaymentOperation.class);

    @Autowired
    private MbnaOFP mbnaOFP;

    @Autowired
    private ValangValidator requestMinPaymentDeferralRequestValidation;


    @Override
    public RequestMinPaymentDeferralResponse invokeService(RequestMinPaymentDeferralRequest request, String... token) {

        String acctNum = request.getAcctNum();

        try {

            Map<String, Object> paramValues = new HashMap<String, Object>();
            paramValues.put("msgId1", UuidUtil.genUuid());
            paramValues.put("msgId2", UuidUtil.genUuid());
            paramValues.put("offerId", request.getRequestPayload().getSelectedOffer().getOfferID());
            paramValues.put("acctID", acctNum);
            paramValues.put("acctId", acctNum);
            paramValues.put("roleCD", request.getRequestPayload().getRoleCD());
            paramValues.put("subProductId", request.getRequestPayload().getSelectedOffer().getSubProductId());

            mbnaOFP.updateOfferDisposition(paramValues, token[0]);

            RequestMinPaymentDeferralResponse response = new RequestMinPaymentDeferralResponse();
            response.setResponsePayload(new ResponsePayload());
            response.getResponsePayload().setStatus(true);

            return response;

        } catch (Exception e) {
            logger.error("RequestMinPaymentDeferralPaymentOperation:invokeService","Failed to updateOfferDisposition for MinPaymentDeferral for accountId="+acctNum,e);
            throw MidtierUtilHelper.prepareBusinessException("MS542", "MS542", e);
        }
    }

    @Override
    public boolean requiresDisclosureConsent() {
        return true;
    }

    @Override
    public String getConsentDisclosureFailedMsgCode() {
        return "MS542";
    }

    @Override
    public boolean generateAutoComment() {
        return true;
    }

    @Override
    public List<String> createAutoComment(BaseRequest request, BaseResponse response) {
        List<String> comment = new ArrayList<String>();
        String header = CustomerNotesUtil.getHeaderContent(request, "Minimum Payment Deferral");
        comment.add(header);

        return comment;
    }

    @Override
    public EmailInfo getEmailInfoBean(BaseRequest request, BaseResponse response) {
        return null;
    }

    @Override
    public MsecValidator getValidator() {
        return new MsecVlangValidator(requestMinPaymentDeferralRequestValidation);
    }
}
