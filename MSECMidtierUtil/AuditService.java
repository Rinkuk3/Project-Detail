
package com.td.mbna.msec.midtier.services;

import java.util.Date;

import javax.naming.InitialContext;

import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
//import commonj.work.WorkManager;

/**
 * This class submits the work of creating AuditLog to the WorkManager
 *
 */
public class AuditService {
	
	// boolean indicating whether creation of AuditLog directly is enabled or not
	private static final String MBNA_AUDITLOG_SYNC = "mbna.auditlog.sync";
	public static final String TRANSACTION_SUCCESS = "Success";
	public static final String TRANSACTION_FAILURE = "Failure";
	
	private static MbnaLogger logger;
	
	//private final static WorkManager workMgr;
	
	private final static boolean doSyncAuditLog = "true".equals(ConfigUtil.getProperty(MBNA_AUDITLOG_SYNC));
	
	static {
		//WorkManager tmpWorkMgr = null;
		if (!ConfigUtil.isTest()) {	// skip initialization under unit test flow.
			logger = new MbnaLogger(AuditService.class);
			try {
				InitialContext ctx  = new InitialContext();
				//tmpWorkMgr  = (WorkManager)ctx.lookup("java:comp/env/wm/auditlog");
			}
			catch (Exception e) {
				logger.error("Failed to initialize auditlog work manager", e);
			}
		}
		//workMgr = tmpWorkMgr;
	}
	
	/**
	 * Looks up the WorkManager and schedules the work of creating AuditLog.
	 * In case property mbna.auditlog.sync is true, calls the creation of AuditLog directly. 
	 * 
	 * @param baseResponse - this is the application response that needs to be logged to AuditLog
	 * @param startTime - this is the start time of the request to backend
	 * @param processingTime - this is the time taken by the backend to process the request
	 */
	public static void createAuditLog(com.td.mbna.msec.midtier.types.common.BaseRequest baseRequest, com.td.mbna.msec.midtier.types.common.BaseResponse baseResponse, Date startTime, long processingTime) {
		
		
		if (!ConfigUtil.auditActive()) {
			return;
		}
		
		if(baseRequest.getAuditInfo() == null) {
			return;
		}
		

		// Only do the Audit Log when there is an error
		if (TRANSACTION_FAILURE.equals(baseRequest.getAuditInfo().getTransactionStatus())) {
			return;
		}
		else if (TRANSACTION_SUCCESS.equals(baseRequest.getAuditInfo().getTransactionStatus())) {
			// Set the Audit entry to Success if status is not set.
			if (baseResponse == null)
				baseResponse = new com.td.mbna.msec.midtier.types.common.BaseResponse();
			if (baseResponse.getStatus() == null || baseResponse.getStatus().trim().length() == 0) {
				baseResponse.setStatus(TRANSACTION_SUCCESS);
			}
		}
		
		if (baseRequest.getAuditInfo().getAuditStartTime() != null && baseRequest.getAuditInfo().getAuditStartTime().intValue() == 0) {
			processingTime = 0;
		}
				
		try {
			if (doSyncAuditLog) {
				AuditServiceWork auditServiceWork = new AuditServiceWork(baseRequest, baseResponse, startTime, processingTime);
				auditServiceWork.run();
			}
			else {
				//workMgr.schedule(new AuditServiceWork(baseRequest, baseResponse, startTime, processingTime));
			}
		}
		catch(Throwable ex) {
			logger.error("Error in AuditService", ex); //Don't throw exception since application should still function normally
		}

	}
}