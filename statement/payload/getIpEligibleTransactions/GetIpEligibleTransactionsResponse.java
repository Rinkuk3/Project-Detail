package com.td.mbna.msec.midtier.statement.payload.getIpEligibleTransactions;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class GetIpEligibleTransactionsResponse extends BaseResponse {

	private static final long serialVersionUID = -6577366115269402825L;
	private ResponsePayload responsePayload;

    public ResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(ResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

    @Override
    public String toString() {
        return "GetIpEligibleTransactionsResponse{" +
                "responsePayload=" + responsePayload +
                '}';
    }
}
