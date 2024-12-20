package com.td.mbna.msec.midtier.util;

/**
 * 
 * Web Service Info Call Tracker
 *
 */
public class WebServiceInfoCallTracker {
	
	private static ThreadLocal<String> Thread2ErrorInfoMap = new ThreadLocal<String>();
	private static ThreadLocal<Boolean> ThreadEncounteredSoapFaultMap = new ThreadLocal<Boolean>();
	private final static boolean InDevMode = ConfigUtil.inDevMode(); // false means we are in production mode.  All class operations will become no-op in production mode.
	

	public static String getErrorInfo() {
		if (!InDevMode) return null;
		String soapFaultResponse = Thread2ErrorInfoMap.get();
		return soapFaultResponse;
	}
	
	/**
	 * setSoapFaultResponse
	 * @param errorInfo
	 */
	public static void setErrorInfo(String errorInfo) {
		if (!InDevMode) return;
		Thread2ErrorInfoMap.set("[" + Thread.currentThread().getName() + "] " + errorInfo);
	}
	
	
	public static void setSoapFaultEncountered(boolean v) {
		if (!InDevMode) return;
		ThreadEncounteredSoapFaultMap.set(v);
	}

	public static boolean getSoapFaultEncountered() {
		if (!InDevMode) return false;
		Boolean rc = ThreadEncounteredSoapFaultMap.get(); 
		return rc == null ? false : rc;
	}
	
	public static boolean inDevMode() {
		return InDevMode;
	}
	
	/**
	 * clearSoapFaultResponse
	 */
	public static void clear() {
		if (!InDevMode) return;
		Thread2ErrorInfoMap.remove();
		ThreadEncounteredSoapFaultMap.remove();
	}
}
