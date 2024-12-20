package com.td.mbna.msec.midtier.exception;

import com.mbnaweb.xsd.types.common.SystemException;

/**
 * This represents the common System Exception thrown by the Backend. 
 * Since different backends may thrown different exceptions, mid-tier will catch all system errors and throw this common system exception. 
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
public final class SystemError extends Exception {

	private static final long serialVersionUID = 1L;

	SystemException faultInfo;

	/**
	 * Get fault information
	 * @return
	 */
	public SystemException getFaultInfo() {
		return faultInfo;
	}

	/**
	 * Set fault information
	 * @param faultInfo
	 */
	public void setFaultInfo(SystemException faultInfo) {
		this.faultInfo = faultInfo;
	}

}
