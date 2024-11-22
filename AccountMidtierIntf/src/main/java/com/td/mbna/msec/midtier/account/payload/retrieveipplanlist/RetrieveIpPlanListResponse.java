package com.td.mbna.msec.midtier.account.payload.retrieveipplanlist;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class RetrieveIpPlanListResponse extends BaseResponse {
	
	private static final long serialVersionUID = 1517464344915070171L;
	
//	@SerializedName("ResponsePayload")
    private ResponsePayload responsePayload;

    public ResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(ResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

}
