package com.td.mbna.msec.midtier.customerprofile.payload.retrievevaletdata;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class RetrieveValetDataResponse extends BaseResponse {

	private static final long serialVersionUID = -1229325854329327646L;
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
