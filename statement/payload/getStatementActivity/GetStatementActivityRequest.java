package com.td.mbna.msec.midtier.statement.payload.getStatementActivity;

import com.td.mbna.msec.midtier.types.common.BaseRequest;

public class GetStatementActivityRequest extends BaseRequest{
	
	private static final long serialVersionUID = 2904395646707570075L;
	private RequestPayload requestPayload;


    public RequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(RequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }


}
