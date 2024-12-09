package com.td.mbna.msec.midtier.customerprofile.payload.savevaletdata;

import com.td.mbna.msec.midtier.types.common.BaseRequest;

public class SaveValetDataRequest extends BaseRequest {

	private static final long serialVersionUID = -8234683016084927337L;
	private RequestPayload requestPayload;

    public RequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(RequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }
    
    
}
