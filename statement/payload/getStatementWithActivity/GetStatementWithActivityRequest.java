package com.td.mbna.msec.midtier.statement.payload.getStatementWithActivity;

import com.td.mbna.msec.midtier.types.common.BaseRequest;

public class GetStatementWithActivityRequest extends BaseRequest{
	
	private static final long serialVersionUID = 2308517922817883581L;
	private RequestPayload requestPayload;

    public RequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(RequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }

}
