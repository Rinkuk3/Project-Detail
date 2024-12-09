package com.td.mbna.msec.midtier.customerprofile.payload.customeragreement;

import com.td.mbna.msec.midtier.types.common.BaseRequest;
import lombok.Data;

@Data
public class CaptureAgreementRequest extends BaseRequest {
    private RequestPayload requestPayload;
}
