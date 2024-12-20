package com.td.mbna.msec.midtier.statement.payload.getStatementFileFromId;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class GetStatementFileFromIdResponse extends BaseResponse {

	private static final long serialVersionUID = 8692301396629463146L;
	private ResponsePayload responsePayload;

    public ResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(ResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

}
