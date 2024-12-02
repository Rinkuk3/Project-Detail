package com.td.mbna.msec.midtier.autopay.payload.checkpadenrolled;

import com.td.mbna.msec.midtier.autopay.payload.checkpadenrolled.ResponsePayload;
import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class CheckPadEnrolledResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1L;
	
	private ResponsePayload responsePayload;

	public CheckPadEnrolledResponse() {
		this.responsePayload = new ResponsePayload();
	}

	public ResponsePayload getResponsePayload() {
		return responsePayload;
	}

	public void setResponsePayload(ResponsePayload responsePayload) {
		this.responsePayload = responsePayload;
	} 
}
