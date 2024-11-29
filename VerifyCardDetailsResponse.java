package com.td.mbna.msec.midtier.account.payload.addaccount;

import lombok.Data;

@Data
public class VerifyCardDetailsResponse {
    private Boolean success;
    private String errorCode;
}
