package com.td.mbna.msec.midtier.customerprofile.payload.retrievecapd;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class RetrieveCapdResponse extends BaseResponse {

	private static final long serialVersionUID = -8958533592246403549L;
	private ResponsePayload responsePayload;


    public ResponsePayload getResponsePayload() {
    	if(responsePayload == null){
    		return new ResponsePayload();
    	}
        return responsePayload;
    }

    public void setResponsePayload(ResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

}
