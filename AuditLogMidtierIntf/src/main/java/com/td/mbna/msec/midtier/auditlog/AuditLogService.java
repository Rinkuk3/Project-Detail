package com.td.mbna.msec.midtier.auditlog;

import com.td.mbna.msec.midtier.auditlog.payload.request.CreateAuditLogRequest;
import com.td.mbna.msec.midtier.auditlog.payload.response.CreateAuditLogResponse;

public interface AuditLogService {
	public CreateAuditLogResponse createAuditLogRequest(CreateAuditLogRequest request);

}
