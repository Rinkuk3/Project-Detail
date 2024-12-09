package com.td.mbna.msec.midtier.customerprofile.payload.retrievecapd;

import com.td.mbna.msec.midtier.types.common.BaseRequest;

public class RetrieveCapdRequest extends BaseRequest {

	private static final long serialVersionUID = -3571151244868502266L;
	private RequestPayload requestPayload;

    public RequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(RequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }
    
    
}
