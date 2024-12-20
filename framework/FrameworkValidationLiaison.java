package com.td.mbna.msec.midtier.framework;

/**
 * 
 * The operation should implement this interface to cause the framework to validate the request
 *
 */
public interface FrameworkValidationLiaison<ValidationException extends Exception> {
	/**
	 * enable/disable validation
	 * @return
	 */
	public String getValidatorBeanName();
	/**
	 * generate validation exception for testing purposes
	 * @param e
	 * @return
	 */
	public ValidationException genValidationException(com.mbnaweb.xsd.types.common.ValidationException e);
}
