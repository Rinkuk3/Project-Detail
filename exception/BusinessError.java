package com.td.mbna.msec.midtier.exception;

import com.mbnaweb.xsd.types.common.BusinessException;

/**
 * This represents the common Business Exception thrown by the Backend. 
 * Since different backends may thrown different exceptions, mid-tier will catch specific business errors and throw this common business exception. 
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
public final class BusinessError extends Exception {

	private static final long serialVersionUID = 1L;

	BusinessException faultInfo;

	public BusinessException getFaultInfo() {
		return faultInfo;
	}

	public void setFaultInfo(BusinessException faultInfo) {
		this.faultInfo = faultInfo;
	}
	

}
