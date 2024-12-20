package com.td.mbna.msec.midtier.util;

/**
 * 
 * A wrapper for an exception triggered as a result of a SOAP fault
 * The raw SOAP response with the SOAP fault is included for debugging purpose.
 *
 */
public final class SoapFaultTriggeredException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String soapFaultSrcResponse;
	
	SoapFaultTriggeredException(Exception e, String soapFaultSrcResponse) {
		super(e);
		this.soapFaultSrcResponse = soapFaultSrcResponse;
	}
	
	/**
	 * This method returns the soap fault response
	 * @return
	 */
	public String getSoapFaultSrcResponse() {
		return soapFaultSrcResponse;
	}
	
}
