package com.td.mbna.msec.midtier.util;

/**
 * 
 * A wrapper to preserve the error info message generated by WebServiceErrorInfoCaller.
 *
 */
public final class WebServiceErrorInfoEnvelopeException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String errorInfo;
	
	WebServiceErrorInfoEnvelopeException(Exception e, String errorInfo) {
		super(e);
		this.errorInfo = errorInfo;
	}
	
	/**
	 * This method returns the soap fault response
	 * @return
	 */
	public String getErrorInfo() {
		return errorInfo;
	}
	
}
