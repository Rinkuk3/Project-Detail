package com.td.mbna.msec.midtier.autopay.payload.validatebankaccount;

import java.io.Serializable;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class ValidateBankAccountResponse extends BaseResponse implements Serializable
{
	private static final long serialVersionUID = 123L;
	
	private ResponsePayload responsePayload;

	public ValidateBankAccountResponse() {
		this.responsePayload = new ResponsePayload();
	}

	public ResponsePayload getResponsePayload() {
		return responsePayload;
	}

	public void setResponsePayload(ResponsePayload responsePayload) {
		this.responsePayload = responsePayload;
	} 
}
