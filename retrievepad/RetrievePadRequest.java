package com.td.mbna.msec.midtier.autopay.payload.retrievepad;

import com.td.mbna.msec.midtier.autopay.payload.retrievepad.RequestPayload;
import com.td.mbna.msec.midtier.types.common.BaseRequest;

public class RetrievePadRequest extends BaseRequest{

	private static final long serialVersionUID = -1569184844834858075L;
	
	private RequestPayload requestPayload;

	public RequestPayload getRequestPayload() {
		return requestPayload;
	}

	public void setRequestPayload(RequestPayload requestPayload) {
		this.requestPayload = requestPayload;
	}
	

}
