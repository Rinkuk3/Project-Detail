package com.td.mbna.msec.midtier.framework;

/**
 * 
 * This class contains the operation proxy factory.
 *
 * @param <Operation>
 * @param <BusinessError>
 * @param <SystemError>
 * @param <ValidationError>
 */
public interface OperationProxyFactory<Operation, BusinessError, SystemError, ValidationError> {
	
	/**
	 * Get proxy
	 * @param operationInterface
	 * @param operation
	 * @return
	 */
	public Operation getProxy(Class<Operation> operationInterface, final Operation operation);
}
