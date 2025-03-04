package com.td.mbna.msec.midtier.util;

import java.util.UUID;

/**
 * 
 * This class generates the random message ID needed in TD requests.
 *
 */
public class UuidUtil {
	
	/**
	 * Generate the random message ID
	 * @return
	 */
	public static synchronized String genUuid() {
		return UUID.randomUUID().toString();
	}

	public static synchronized String[] genUuidPair() {
		String[] rc = new String[2];
		rc[0] = UUID.randomUUID().toString();
		rc[1] = UUID.randomUUID().toString();
		return rc;
	}
}
