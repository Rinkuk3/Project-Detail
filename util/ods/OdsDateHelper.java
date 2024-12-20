package com.td.mbna.msec.midtier.util.ods;

import com.td.mbna.msec.midtier.util.DateUtil;

public class OdsDateHelper {
	private final static String OdsTimestampFmt = "yyyy-MM-dd'T'HH:mm:ss.SSS";
	private final static String OdsDateFmt = "yyyy-MM-dd";

	/**
	 * DO NOT REMOVE IT, it is used in /resourecs/xsl/odsRetrieveCustomerProfileRs.xsl
	 * DO NOT REMOVE IT, it is used in /resourecs/xsl/odsSetKycAcctsInfoPrimaryRs.xsl
	 * @param odsStartTimestamp
	 * @return
	 * @throws Exception
	 */
	public final static boolean isCurrent(String odsStartTimestamp) throws Exception {
		boolean rc = DateUtil.beforeNow(odsStartTimestamp, OdsTimestampFmt);
		return rc;
	}
	/**
	 * DO NOT REMOVE IT, it is used in /resourecs/xsl/odsRetrieveCustomerProfileRs.xsl
	 * @param odsStartDate
	 * @param odsEndDate
	 * @return
	 * @throws Exception
	 */
	public final static boolean isCurrent(String odsStartDate, String odsEndDate) throws Exception {
		if (odsEndDate != null && odsEndDate.trim().length() == 0) { 
			odsEndDate = null;
		}
		boolean rc = odsEndDate == null && DateUtil.beforeNow(odsStartDate, OdsDateFmt); 
		return rc;
	}
	
	public final static String formatDate(String date) {
		int dashIndex = date.lastIndexOf('-');
		String rc = dashIndex == -1 ? date : date.substring(0, dashIndex);
		return rc;
	}

}
