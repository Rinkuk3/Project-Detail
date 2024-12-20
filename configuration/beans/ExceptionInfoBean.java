package com.td.mbna.msec.midtier.configuration.beans;

/**
 * This class contains the data model for MT exceptions.
 *
 */
public class ExceptionInfoBean {

	private String exceptionClassification = "";
	public String getExceptionClassification() {
		return exceptionClassification;
	}
	public void setExceptionClassification(String exceptionClassification) {
		this.exceptionClassification = exceptionClassification;
	}

	private String errorCode = "";
	private String severity = "";
	private String errorDescription = "";
	private String soapExceptionMessage = "";

	
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the severity
	 */
	public String getSeverity() {
		return severity;
	}
	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	/**
	 * @return the soapExceptionMessage
	 */
	public String getSoapExceptionMessage() {
		return soapExceptionMessage;
	}
	/**
	 * @param message the errorDescription to set
	 */
	public void setSoapExceptionMessage(String message) {
		this.soapExceptionMessage = message;
	}

	/**
	 * @return the errorDescription
	 */
	public String getErrorDescription() {
		return errorDescription;
	}
	/**
	 * @param errorDescription the errorDescription to set
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExceptionInfoBean [errorCode=" + errorCode + ", severity="
				+ severity + ", errorDescription=" + errorDescription + ", soapExceptionMessage="+soapExceptionMessage+"]";
	}

}
