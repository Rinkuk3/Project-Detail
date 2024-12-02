package com.td.mbna.msec.midtier.auditlog.payload.request;

import com.td.mbna.msec.midtier.types.common.BaseRequest;

public class CreateAuditLogRequest extends BaseRequest {

	private static final long serialVersionUID = 5442796701294374013L;
    private RequestPayload requestPayload;
	
    public RequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(RequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }
}
