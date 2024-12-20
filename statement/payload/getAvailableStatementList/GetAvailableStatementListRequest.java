package com.td.mbna.msec.midtier.statement.payload.getAvailableStatementList;

import com.td.mbna.msec.midtier.statement.payload.getAvailableStatementList.RequestPayload;
import com.td.mbna.msec.midtier.types.common.BaseRequest;

public class GetAvailableStatementListRequest extends BaseRequest{
	
	private static final long serialVersionUID = 1055546357510456617L;
	private RequestPayload requestPayload;


    public RequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(RequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }
}
