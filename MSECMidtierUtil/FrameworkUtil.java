package com.td.mbna.msec.midtier.framework;

import com.mbnaweb.xsd.types.common.ErrorType;
import com.mbnaweb.xsd.types.common.FieldErrorType;
import com.mbnaweb.xsd.types.common.TrackableRequest;
import com.td.mbna.msec.midtier.exception.BusinessError;
import com.td.mbna.msec.midtier.exception.SystemError;
import com.td.mbna.msec.midtier.exception.ValidationError;

import java.util.Locale;

/**
 * 
 * This class contains helper methods for the framework.
 *
 */
public class FrameworkUtil {
	
	/**
	 * get operation name
	 * @param op
	 * @return
	 */
	public static String getOpName(Class<?> op) {
		String opName = op.getSimpleName();
		if (opName.endsWith(FrameworkConstants.RealImplClassSuffix)) {
			opName = opName.substring(0, opName.lastIndexOf(FrameworkConstants.RealImplClassSuffix));
		} else if (opName.endsWith(FrameworkConstants.StubImplClassSuffix)) {
				opName = opName.substring(0, opName.lastIndexOf(FrameworkConstants.StubImplClassSuffix));
		} else if (opName.endsWith(FrameworkConstants.GeneratedImplClassSuffix)) {
			opName = opName.substring(0, opName.lastIndexOf(FrameworkConstants.GeneratedImplClassSuffix));
		} else if (opName.endsWith(FrameworkConstants.GeneratedClassSuffix)) {
			opName = opName.substring(0, opName.lastIndexOf(FrameworkConstants.GeneratedClassSuffix));
		}
		opName = opName.substring(0,1).toLowerCase(Locale.CANADA) + opName.substring(1);
		return opName;
	}
	
	/**
	 * get operation name
	 * @param request
	 * @return
	 */
	public static String getOpName(TrackableRequest request) {
		String opName = request.getClass().getSimpleName();
		opName = opName.substring(0,1).toLowerCase(Locale.CANADA) + opName.substring(1);
		if (opName.endsWith("Request")) {
			opName = opName.substring(0, opName.length()-"Request".length());
		}
		return opName;
	}
	
	private final static String BusinessExceptionTrigger = "businessException";
	private final static String SystemExceptionTrigger = "systemException";
	private final static String ValidationExceptionTrigger = "validationException";
	private final static String GenericSystemErrorCode = "MS502";
	
	/**
	 * insert business exception for testing purposes
	 * @param req
	 */
	public static void insertBusinessExceptionTrigger(TrackableRequest req) {
		req.getSessionInfo().setSessionId(BusinessExceptionTrigger);
	}
	
	/**
	 * insert system exceptions for testing purposes
	 * @param req
	 */
	public static void insertSystemExceptionTrigger(TrackableRequest req) {
		req.getSessionInfo().setSessionId(SystemExceptionTrigger);
	}
	
	/**
	 * insert validation exceptiosn for testing purposes
	 * @param req
	 */
	public static void insertValidationExceptionTrigger(TrackableRequest req) {
		req.getSessionInfo().setSessionId(ValidationExceptionTrigger);
	}
	
	/**
	 * has business exception trigger
	 * @param req
	 * @return
	 */
	public static boolean hasBusinessExceptionTrigger(TrackableRequest req) {
		return req.getSessionInfo().getSessionId().equals(BusinessExceptionTrigger);
	}

	/**
	 * has system exception trigger
	 * @param req
	 * @return
	 */
	public static boolean hasSystemExceptionTrigger(TrackableRequest req) {
		return req.getSessionInfo().getSessionId().equals(SystemExceptionTrigger);
	}

	/**
	 * has validation exception trigger
	 * @param req
	 * @return
	 */
	public static boolean hasValidationExceptionTrigger(TrackableRequest req) {
		return req.getSessionInfo().getSessionId().equals(ValidationExceptionTrigger);
	}
	
	/**
	 * simulate exceptions for testing purposes
	 * @param req
	 * @param frameworkInjection
	 * @param frameworkValidation
	 * @throws BusinessError
	 * @throws SystemError
	 * @throws ValidationError
	 */
	public static <BusinessException extends Exception, SystemException extends Exception, ValidationException extends Exception> void simulateTestException(TrackableRequest req, FrameworkInjectionLiaison<BusinessException, SystemException> frameworkInjection, FrameworkValidationLiaison<ValidationException> frameworkValidation)
			throws BusinessError, SystemError, ValidationError {
    	if (frameworkValidation != null && hasValidationExceptionTrigger(req)) {
    		com.mbnaweb.xsd.types.common.ValidationException faultInfo = new com.mbnaweb.xsd.types.common.ValidationException();
    		FieldErrorType fldErr = new FieldErrorType();
    		fldErr.setField("sessionId");
    		fldErr.setErrorCode(GenericSystemErrorCode);
    		fldErr.setErrorDescription(GenericSystemErrorCode);
    		fldErr.setSeverity(ErrorType.ERROR);
    		faultInfo.getFieldError().add(fldErr);
    		//throw frameworkValidation.genValidationException(faultInfo);
    		ValidationError error =  new ValidationError();
    		error.setFaultInfo(faultInfo);
    		throw error;    		
    	}
    	else
    	if (hasBusinessExceptionTrigger(req)) {
    		com.mbnaweb.xsd.types.common.BusinessException faultInfo = new com.mbnaweb.xsd.types.common.BusinessException();
     		faultInfo.setErrorCode(GenericSystemErrorCode);
    		faultInfo.setErrorDescription(GenericSystemErrorCode);
    		faultInfo.setSeverity(ErrorType.ERROR);
    		BusinessError error =  new BusinessError();
    		error.setFaultInfo(faultInfo);
    		throw error;    		
    	}
    	else
       	if (hasSystemExceptionTrigger(req)) {
    		com.mbnaweb.xsd.types.common.SystemException faultInfo = new com.mbnaweb.xsd.types.common.SystemException();
     		faultInfo.setErrorCode(GenericSystemErrorCode);
    		faultInfo.setErrorDescription(GenericSystemErrorCode);
    		faultInfo.setSeverity(ErrorType.ERROR);
       		SystemError error = new SystemError();
       		error.setFaultInfo(faultInfo);
       		throw error;  		
       	}	
	}
	
	/**
	 * generate generic system exception for testing purposes
	 * @return
	 */
	public static com.mbnaweb.xsd.types.common.SystemException genGenericSystemException() {
		com.mbnaweb.xsd.types.common.SystemException faultInfo = new com.mbnaweb.xsd.types.common.SystemException();
 		faultInfo.setErrorCode(GenericSystemErrorCode);
		faultInfo.setErrorDescription(GenericSystemErrorCode);
		faultInfo.setSeverity(ErrorType.ERROR);
		return faultInfo;
	}
}