package com.td.mbna.msec.midtier.statement.payload.getIpEligibleTransactions;

import com.td.mbna.msec.midtier.types.common.BaseRequest;

public class GetIpEligibleTransactionsRequest extends BaseRequest {

	private static final long serialVersionUID = -4952139904050670691L;
	private RequestPayload requestPayload;

    public RequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(RequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }


}
