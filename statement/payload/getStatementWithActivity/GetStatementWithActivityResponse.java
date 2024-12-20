package com.td.mbna.msec.midtier.statement.payload.getStatementWithActivity;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class GetStatementWithActivityResponse extends BaseResponse {
	
	private static final long serialVersionUID = -845489024858649123L;
	private ResponsePayload responsePayload;

    public ResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(ResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

}
