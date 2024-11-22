package com.td.mbna.msec.midtier.account.payload.getaccountsnapshot;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class GetAccountSnapshotResponse extends BaseResponse {

	private static final long serialVersionUID = -5259105443432927116L;
	
    private ResponsePayload responsePayload;

    public ResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(ResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }


}
