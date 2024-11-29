package com.td.mbna.msec.midtier.account.payload.addaccount;

import com.td.mbna.msec.midtier.types.common.BaseResponse;
import lombok.Data;

@Data
public class VerifyCardResponse extends BaseResponse {
    private Boolean success;
    private String errorCode;
    private Boolean lpa;
}
