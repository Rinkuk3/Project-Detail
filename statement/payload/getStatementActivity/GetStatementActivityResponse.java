package com.td.mbna.msec.midtier.statement.payload.getStatementActivity;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class GetStatementActivityResponse extends BaseResponse {
	
	private static final long serialVersionUID = -348124780156645824L;
	private ResponsePayload responsePayload;

    public ResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(ResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

}
