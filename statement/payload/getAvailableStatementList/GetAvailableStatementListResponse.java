package com.td.mbna.msec.midtier.statement.payload.getAvailableStatementList;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class GetAvailableStatementListResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1602101676253874674L;
	private ResponsePayload responsePayload;

    public ResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(ResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

}
