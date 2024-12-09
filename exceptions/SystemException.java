package com.td.mbna.msec.midtier.exceptions;

import java.io.Serializable;

import com.td.mbna.msec.midtier.types.common.ExceptionInfo;

public class SystemException extends ExceptionInfo implements Serializable {

	private static final long serialVersionUID = 1339051056122746362L;
	protected String errorSource;
	public String getErrorSource() {
		return errorSource;
	}
	public void setErrorSource(String errorSource) {
		this.errorSource = errorSource;
	}
	
}
