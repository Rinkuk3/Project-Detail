package com.td.mbna.msec.midtier.util.services;

import java.util.Date;

import javax.naming.InitialContext;

import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
//import commonj.work.Work;
//import commonj.work.WorkManager;

public class AuditingService {

    // boolean indicating whether creation of AuditLog directly is enabled or not
    private static final String MBNA_AUDITLOG_SYNC = "mbna.auditlog.sync";
    private static final String TRANSACTION_SUCCESS = "Success";
    private static final String TRANSACTION_FAILURE = "Failure";


    private static final MbnaLogger logger = new MbnaLogger(AuditingService.class); // skip initialization under unit test flow. ??

    //private final static WorkManager workMgr = loadWorkMgr();

    private final static boolean doSyncAuditLog = "true".equals(ConfigUtil.getProperty(MBNA_AUDITLOG_SYNC));

   /* private static WorkManager loadWorkMgr() {
        try {
            InitialContext ctx = new InitialContext();
            return (WorkManager) ctx.lookup("java:comp/env/wm/auditlog");
        } catch (Exception e) {
            logger.error("Failed to initialize auditlog work manager", e);
            throw new IllegalArgumentException("Failed to initialize auditlog work manager", e);
        }
    }*/

    /**
     * Looks up the WorkManager and schedules the work of creating AuditLog.
     * In case property mbna.auditlog.sync is true, calls the creation of AuditLog directly.
     *
     * @param baseRequest    - this is the application request that needs to be logged to AuditLog
     * @param baseResponse   - this is the application response that needs to be logged to AuditLog
     * @param startTime      - this is the start time of the request to backend
     * @param processingTime - this is the time taken by the backend to process the request
     */
    public static void createAuditLog(BaseRequest baseRequest, BaseResponse baseResponse, Date startTime, long processingTime) {

        if (!ConfigUtil.auditActive()) {
            return;
        }

        if (baseRequest.getAuditInfo() == null) {
            return;
        }

        // Only do the Audit Log when there is an error
        if (TRANSACTION_FAILURE.equals(baseRequest.getAuditInfo().getTransactionStatus())) {
            return;
        } else if (TRANSACTION_SUCCESS.equals(baseRequest.getAuditInfo().getTransactionStatus())) {
            // Set the Audit entry to Success if status is not set.

            if (baseResponse.getStatus() == null || baseResponse.getStatus().trim().length() == 0) {
                baseResponse.setStatus(TRANSACTION_SUCCESS);
            }
        }

        if (baseRequest.getAuditInfo().getAuditStartTime() != null && baseRequest.getAuditInfo().getAuditStartTime().intValue() == 0) {
            processingTime = 0;
        }

        try {
            if (doSyncAuditLog) {
                AuditingServiceWork auditingServiceWork = new AuditingServiceWork(baseRequest, baseResponse, startTime, processingTime);
                auditingServiceWork.run();
            } else {
                //workMgr.schedule( new AuditingServiceWork(baseRequest, baseResponse, startTime, processingTime));
            }
        } catch (Throwable ex) {
            logger.error("createAuditLog", "Error in AuditingService", ex); //Don't throw exception since application should still function normally
        }

    }


}