package com.td.mbna.msec.midtier.auditlog.payload.response;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class CreateAuditLogResponse extends BaseResponse {

	private static final long serialVersionUID = -3255706629309040935L;
    private ResponsePayload responsePayload;


    public ResponsePayload getResponsePayload() {
        return responsePayload;
    }


    public void setResponsePayload(ResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }
}
