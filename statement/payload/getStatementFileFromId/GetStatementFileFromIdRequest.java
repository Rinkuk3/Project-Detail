package com.td.mbna.msec.midtier.statement.payload.getStatementFileFromId;

import com.td.mbna.msec.midtier.types.common.BaseRequest;

public class GetStatementFileFromIdRequest extends BaseRequest{

	private static final long serialVersionUID = -8912263830110196376L;
	private RequestPayload requestPayload;

    public RequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(RequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }

}
