package com.td.mbna.msec.midtier.util;

import com.mbnaweb.xsd.types.common.BaseRequest;

/**
 * 
 * Utility class for manipulating requests.
 *
 */
public class RequestUtil {
	
	public static final String TD_ODS_SERVICE = "ODS";
	public static final String TD_MDM_SERVICE = "MDM";
	
	
	/**
	 * copy header information
	 * @param srcReq
	 * @param tgtReq
	 */
	public static void copyHeader(BaseRequest srcReq, BaseRequest tgtReq) {
		tgtReq.setSessionInfo(srcReq.getSessionInfo());
		tgtReq.setAuditInfo(srcReq.getAuditInfo());
		tgtReq.setCustId(srcReq.getCustId());
		tgtReq.setIsPrimaryUser(srcReq.isIsPrimaryUser());
		tgtReq.setLanguagePref(srcReq.getLanguagePref());
		tgtReq.setAcctNum(srcReq.getAcctNum());
		tgtReq.setAcctType(srcReq.getAcctType());
		tgtReq.setCustInterface(srcReq.getCustInterface());
	}

	public static void copyHeader(com.td.mbna.msec.midtier.types.common.BaseRequest srcReq, com.td.mbna.msec.midtier.types.common.BaseRequest tgtReq) {
		tgtReq.setSessionInfo(srcReq.getSessionInfo());
		tgtReq.setAuditInfo(srcReq.getAuditInfo());
		tgtReq.setCustId(srcReq.getCustId());
		tgtReq.setIsPrimaryUser(srcReq.getIsPrimaryUser());
		tgtReq.setLanguagePref(srcReq.getLanguagePref());
		tgtReq.setAcctNum(srcReq.getAcctNum());
		tgtReq.setAcctType(srcReq.getAcctType());
		tgtReq.setCustInterface(srcReq.getCustInterface());
	}


}
