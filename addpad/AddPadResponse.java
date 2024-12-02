package com.td.mbna.msec.midtier.autopay.payload.addpad;

import java.io.Serializable;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class AddPadResponse extends BaseResponse implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private ResponsePayload responsePayload;

	public AddPadResponse() {
		this.responsePayload = new ResponsePayload();
	}

	public ResponsePayload getResponsePayload() {
		return responsePayload;
	}

	public void setResponsePayload(ResponsePayload responsePayload) {
		this.responsePayload = responsePayload;
	} 
}
