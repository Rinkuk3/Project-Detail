package com.td.mbna.msec.midtier.disclosure;

public class SystemException extends Exception {

	private static final long serialVersionUID = 3032836282990273733L;
	
	private com.td.mbna.msec.midtier.exceptions.SystemException faultInfo;
	
	public SystemException(String message, 	com.td.mbna.msec.midtier.exceptions.SystemException faultInfo) {
		super(message);
		this.faultInfo = faultInfo;
	}
	public SystemException(String message, 	com.td.mbna.msec.midtier.exceptions.SystemException faultInfo, Throwable cause) {
		super(message,cause);
		this.faultInfo = faultInfo;
	}
	
	public com.td.mbna.msec.midtier.exceptions.SystemException getFaultInfo() {
		return faultInfo;
	}
	

}
