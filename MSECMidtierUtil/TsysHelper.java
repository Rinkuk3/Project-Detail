package com.td.mbna.msec.midtier.util.tsys;

import java.util.HashMap;
import java.util.Map;

import com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.TrackableRequest;
import com.td.mbna.msec.midtier.util.UuidUtil;

/**
 * 
 * Helper methods for TSYS integration.
 *
 */
public class TsysHelper {
	
	// account number
	public final static String TsysXslParam_accNum = "acctNum";
	// card number
	public final static String TsysXslParam_cardNum = "cardNum";
	// message ID 1
	public final static String TsysXslParam_msgId = "msgId";
	// message ID 2
	public final static String TsysXslParam_msgId2 = "msgId2";
	// statement date
	public final static String TsysXslParam_stmtDate = "stmtDate";
	// issuer ID
	public final static String TsysXslParam_issuerId = "issuerId";
	
	/**
	 * generate standard parameters for TSYS
	 * @param tsysReq
	 * @param mtReq
	 * @return
	 */
	public static Map<String, Object> genStandardParams(TsysRequest tsysReq, TrackableRequest mtReq) {
		Map<String,Object> params = new HashMap<String,Object>();
		if (mtReq instanceof BaseRequest) {
			String acctNum = ((BaseRequest)mtReq).getAcctNum();
			if (acctNum != null) {
				params.put(TsysXslParam_accNum, ((BaseRequest)mtReq).getAcctNum());
			}
		}
		if (tsysReq.requiresMsgId()) {
			String[] uuidPair = UuidUtil.genUuidPair();
			params.put(TsysXslParam_msgId, uuidPair[0]);
			params.put(TsysXslParam_msgId2, uuidPair[1]);
		}
		params.put(TsysXslParam_issuerId, TDwsServiceUtil.getTDServiceParam(TDwsServiceUtil.ISSUERID));
		return params;
	}

	/**
	 * generate standard parameters for TSYS
	 * @param tsysReq
	 * @param mtReq
	 * @return
	 */
	public static Map<String, Object> genStandardParams(TsysRequest tsysReq, com.td.mbna.msec.midtier.types.common.BaseRequest mtReq) {
		Map<String,Object> params = new HashMap<String,Object>();
		if (mtReq instanceof com.td.mbna.msec.midtier.types.common.BaseRequest) {
			String acctNum = (mtReq).getAcctNum();
			if (acctNum != null) {
				params.put(TsysXslParam_accNum, (mtReq).getAcctNum());
			}
		}
		if (tsysReq.requiresMsgId()) {
			String[] uuidPair = UuidUtil.genUuidPair();
			params.put(TsysXslParam_msgId, uuidPair[0]);
			params.put(TsysXslParam_msgId2, uuidPair[1]);
		}
		params.put(TsysXslParam_issuerId, TDwsServiceUtil.getTDServiceParam(TDwsServiceUtil.ISSUERID));
		return params;
	}
	
	
}