package com.td.mbna.msec.midtier.autopay.payload.updatepad;

import java.io.Serializable;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class UpdatePadResponse extends BaseResponse implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private ResponsePayload responsePayload;

	public ResponsePayload getResponsePayload() {
		return responsePayload;
	}

	public void setResponsePayload(ResponsePayload responsePayload) {
		this.responsePayload = responsePayload;
	} 
}
