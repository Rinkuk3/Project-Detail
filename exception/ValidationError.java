package com.td.mbna.msec.midtier.exception;

import com.mbnaweb.xsd.types.common.ValidationException;

/**
 * This represents the common Validation Exception thrown by the Backend. 
 * Since different backends may thrown different exceptions, mid-tier will catch all validation errors and throw this common validation exception. 
 *
 * @author        Yick Kwan
 * @version       1.0
 * @copyright     IBM Technology Service
 * @security      IBM Confidential
 * @date          2012-09-12
 * @project       MBNA Secured Site
 * 
 * Version History
 * Date             Name                                        Comments
 * ---------------  ----------------------------------       -------------------------------------------------------------------
 * 2012-09-12  		Yick Kwan				                 Initial creation
 * 
 */
public final class ValidationError extends Exception {

	private static final long serialVersionUID = 1L;

	ValidationException faultInfo;

	/**
	 * Get fault information
	 * @return
	 */
	public ValidationException getFaultInfo() {
		return faultInfo;
	}

	/**
	 * Set fault information
	 * @param faultInfo
	 */
	public void setFaultInfo(ValidationException faultInfo) {
		this.faultInfo = faultInfo;
	}
}
