package com.td.mbna.msec.midtier.util;

/**
 * 
 * TD Reqeust Info interface.
 *
 */
public interface TdRequestInfo {
	/**
	 * name of the request
	 * @return
	 */
	public String name();
	/**
	 * does request requires a unique message ID
	 * @return
	 */
	public boolean requiresMsgId();
}
