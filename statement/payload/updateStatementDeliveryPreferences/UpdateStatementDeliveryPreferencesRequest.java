package com.td.mbna.msec.midtier.statement.payload.updateStatementDeliveryPreferences;

import com.td.mbna.msec.midtier.types.common.BaseRequest;

public class UpdateStatementDeliveryPreferencesRequest extends BaseRequest{
	
	private static final long serialVersionUID = 4815266981014717458L;
	private RequestPayload requestPayload;

    public RequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(RequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }

}
