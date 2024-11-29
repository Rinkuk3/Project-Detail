package com.td.mbna.msec.midtier.account.payload.addaccount;


import com.td.mbna.msec.midtier.types.common.BaseRequest;
import lombok.Data;

@Data
public class VerifyCardRequest extends BaseRequest {
    private static final long serialVersionUID = -8017989369062932504L;
    private RequestPayload requestPayload;
}
