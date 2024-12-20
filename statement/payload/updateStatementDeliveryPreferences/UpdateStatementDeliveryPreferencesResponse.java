package com.td.mbna.msec.midtier.statement.payload.updateStatementDeliveryPreferences;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class UpdateStatementDeliveryPreferencesResponse extends BaseResponse {

	private static final long serialVersionUID = 8688178818139785571L;
	private ResponsePayload responsePayload;

    public ResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(ResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

}
