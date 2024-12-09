package com.td.mbna.msec.midtier.customerprofile.payload.retrievevaletdata;

import com.td.mbna.msec.midtier.types.common.BaseRequest;

public class RetrieveValetDataRequest extends BaseRequest {

	private static final long serialVersionUID = 4749400442989904944L;
	private RequestPayload requestPayload;

    public RequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(RequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }
    
    
}
