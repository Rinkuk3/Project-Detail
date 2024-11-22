package com.td.mbna.msec.midtier.auditlog;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.td.mbna.msec.midtier.auditlog.payload.request.CreateAuditLogRequest;
import com.td.mbna.msec.midtier.auditlog.payload.response.CreateAuditLogResponse;
//import com.td.mbna.msec.midtier.persistance.hibernate.DBService;
import com.td.mbna.msec.midtier.persistance.mybatis.DBMybatisService;
import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.perf.ProfileLog;
import com.td.mbna.msec.midtier.util.services.AuditingService;


@Service("dbAuditLogService")
public class AuditLogServiceImpl implements AuditLogService {

    private final static MbnaLogger logger = new MbnaLogger(AuditLogServiceImpl.class);

    @ProfileLog
    public com.td.mbna.msec.midtier.auditlog.payload.response.CreateAuditLogResponse createAuditLogRequest(CreateAuditLogRequest request) {
        CreateAuditLogResponse response = new CreateAuditLogResponse();

        if (!ConfigUtil.auditActive()) {
            return response;
        }

        response.setStatus("");
        if (request.getRequestPayload() != null && request.getRequestPayload().getStatus() != null) {
            response.setStatus(request.getRequestPayload().getStatus());
        }
        if (request.getAuditInfo() == null) {
            logger.info("createAuditLogRequest", "auditInfo is null on " + request);
            return response;
        }

        if (request.getAuditInfo().getLogLastLogin() != null && request.getAuditInfo().getLogLastLogin()) {
            DBMybatisService.logLastLogin(request.getCustId(), new Date());
//            DBService.logLastLogin(request.getCustId(), new Date());
        } else {
            long auditStopTime = System.currentTimeMillis();
            long processingTime = 0;
            if (request.getAuditInfo().getAuditStartTime() != null) {
                if (request.getAuditInfo().getAuditStartTime() > 0) {
                    processingTime = auditStopTime - request.getAuditInfo().getAuditStartTime();
                }
            }
            //AuditingService.createAuditLog(request, response, new Date(), processingTime);
        }

        return response;

    }
   
}
