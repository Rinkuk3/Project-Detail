package com.td.mbna.msec.midtier.statement.payload.getStatementListForYear;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class GetStatementListForYearResponse extends BaseResponse {

	private static final long serialVersionUID = 260403090203550145L;
	private ResponsePayload responsePayload;

    public ResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(ResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

}
