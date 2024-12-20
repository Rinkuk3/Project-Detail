package com.td.api.mbna.msec.midtier.mbnaparty.payload;

import com.td.mbna.msec.midtier.types.common.BaseRequest;
import lombok.Data;

@Data
public class VerifyCardRequest extends BaseRequest {

    private RequestPayload requestPayload;
}