package com.td.mbna.msec.midtier.statement.payload.getStatementListForYear;

import com.td.mbna.msec.midtier.types.common.BaseRequest;

public class GetStatementListForYearRequest extends BaseRequest{

	private static final long serialVersionUID = -3537034063435436890L;
	private RequestPayload requestPayload;

    public RequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(RequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }

}
