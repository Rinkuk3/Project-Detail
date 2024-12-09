package com.td.mbna.msec.midtier.customerprofile.payload.savevaletdata;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class SaveValetDataResponse extends BaseResponse {

	private static final long serialVersionUID = 4804234920365072586L;
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
