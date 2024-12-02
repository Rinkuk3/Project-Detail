package com.td.mbna.msec.midtier.autopay.payload.retrievepad;

import com.td.mbna.msec.midtier.autopay.payload.retrievepad.ResponsePayload;
import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class RetrievePadResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1517464344915070171L;
	
    private ResponsePayload responsePayload;

    public RetrievePadResponse() {
		this.responsePayload = new ResponsePayload();
	}

    public ResponsePayload getResponsePayload() {
        return responsePayload;
    }

	public void setResponsePayload(ResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

}
