package com.td.mbna.msec.midtier.framework;

import org.springframework.context.ApplicationContext;

/**
 * All operations must implement this interface in order to be injected into the framework
 *
 */
public interface FrameworkInjectionLiaison<BusinessException extends Exception, SystemException extends Exception> {
	
	/**
	 * get sprint context
	 * @return
	 */
	public ApplicationContext getSpringContext();
	/**
	 * get real implementation bean
	 * @return
	 */
	public String getRealImplBeanName();
	/**
	 * get stub implementation bean
	 * @return
	 */
	public String getStubImplBeanName();
	/**
	 * generate business exception
	 * @param e
	 * @return
	 */
	public BusinessException genBusinessException(com.mbnaweb.xsd.types.common.BusinessException e);
	/**
	 * generate system exception
	 * @param e
	 * @return
	 */
	public SystemException genSystemException(com.mbnaweb.xsd.types.common.SystemException e);
	/**
	 * determines whether exception is declared
	 * @param e
	 * @return
	 */
	public boolean isDeclaredException(Exception e);
}
