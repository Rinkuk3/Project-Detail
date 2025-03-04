package com.td.mbna.msec.midtier.util;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springmodules.validation.valang.functions.AbstractFunction;
import org.springmodules.validation.valang.functions.Function;

import com.td.mbna.msec.midtier.types.common.FieldErrorType;
import com.td.mbna.msec.midtier.types.common.ValidationException;

/**
 * 
 * This class contains helper methods to handle Validation Exceptions.
 *
 */
public class ValidateUtil {
	private static MbnaLogger logger = new MbnaLogger(ValidateUtil.class);
	
	// to be used when no specific error code applies
	public final static String SystemErrorCode = "MS502"; 
	
	/**
	 * validate request
	 * @param context
	 * @param request
	 * @return
	 */
	public static ValidationException validateRequest(ApplicationContext context, Object request) {
		// this method is for compatibility reason only. should remove when all operations
		// converted to the new framework integration pattern.
		String defaultBeanName = request.getClass().getSimpleName().concat("Validator");
		return validateRequest(context, defaultBeanName, request);
	}
	
	/**
	 * validate request
	 * @param context
	 * @param validatorBeanName
	 * @param request
	 * @return
	 */
	public static ValidationException validateRequest(ApplicationContext context, String validatorBeanName, Object request) {
        Validator validator = null;
        try {
        	validator = (Validator) context.getBean(validatorBeanName);
		} catch (Exception ex) {
        	logger.error("validateRequest", "getBean failed for " + validatorBeanName, ex);
        }
        if (validator == null){
        	return null;
        }
        return validateRequest(validator, request);
	}
	
	/**
	 * validate request
	 * @param validator
	 * @param request
	 * @return
	 */
	public static ValidationException validateRequest(Validator validator,  Object request) {
    	Errors vErrors = new BindException(request, "target");

    	validator.validate(request, vErrors); 
    	if (vErrors.hasErrors()) {
    		ValidationException faultInfo = new ValidationExceptionForDebug();
    		List<FieldErrorType> fieldErrors = faultInfo.getFieldError();
    		for (ObjectError objErr : vErrors.getAllErrors()) {
    			FieldErrorType fldErr = new FieldErrorType();
    			//fldErr.setField(objErr.getObjectName());
    			fldErr.setField(objErr.getCode());
    			fldErr.setErrorCode(objErr.getDefaultMessage());
    			fldErr.setErrorDescription(objErr.getCode());
    			fldErr.setSeverity("ERROR");
    			fieldErrors.add(fldErr);
    		}
    		return faultInfo;
    	}
   		return null;
	}



	/**
	 * 
	 * Validation Exeption for debug.
	 *
	 */
	private static class ValidationExceptionForDebug extends ValidationException {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public String toString() {
    		List<FieldErrorType> fieldErrors = getFieldError();
    		StringBuilder rc = new StringBuilder();
    		rc.append("fieldErrors:{");
    		int i = 0;
    		for (FieldErrorType fieldError : fieldErrors) {
    			if (i++ > 0) rc.append("|");
    			rc.append(fieldError.getErrorDescription()).append(",").append(fieldError.getField());
    		}
    		rc.append("}");
    		return rc.toString();
		}
	}

	/**
	 * 
	 * Validation exceptions for BigDecimal amounts.
	 *
	 */
    public static class ValidateBigDecimalAmount extends AbstractFunction {
    	
    	private static MbnaLogger logger = new MbnaLogger(ValidateBigDecimalAmount.class);
    	
    	/**
    	 * validate big decimal amount
    	 * @param arguments
    	 * @param line
    	 * @param column
    	 */
     	public ValidateBigDecimalAmount(Function[] arguments, int line, int column) {
	   		super(arguments, line, column);
	   		definedExactNumberOfArguments(1);
	   	}
   	
     	/**
     	 * get result
     	 */
		@Override
		protected Object doGetResult(Object target) throws Exception {

			boolean rc = true;
			BigDecimal amount =  (BigDecimal) getArguments()[0].getResult(target);
			if (amount != null) {
				try {
					amount.movePointRight(2).longValueExact();
				} catch (ArithmeticException e) {
					// fractional part is not empty
					logger.error("ValidateBigDecimalAmount.doGetResult", "Amount has incorrect precision:" + amount, e);
					rc = false;
				}
			} else {
				logger.error("ValidateBigDecimalAmount.doGetResult", "amount is null" + target);
				rc = false;
			}
			return rc;
		}
    }

    /**
	 * 
	 * Validation exceptions for Double amounts.
	 *
	 */
    public static class ValidateDoubleAmount extends AbstractFunction {
    	
    	private static MbnaLogger logger = new MbnaLogger(ValidateDoubleAmount.class);
    	
    	/**
    	 * validate big decimal amount
    	 * @param arguments
    	 * @param line
    	 * @param column
    	 */
     	public ValidateDoubleAmount(Function[] arguments, int line, int column) {
	   		super(arguments, line, column);
	   		definedExactNumberOfArguments(1);
	   	}
   	
     	/**
     	 * get result
     	 */
		@Override
		protected Object doGetResult(Object target) throws Exception {

			boolean rc = true;
			Double amount =  (Double) getArguments()[0].getResult(target);
			BigDecimal bigDecimalAmount = new BigDecimal(amount.toString());

			try {
				bigDecimalAmount.movePointRight(2).longValueExact();
			} catch (ArithmeticException e) {
				// fractional part is not empty
				logger.error("ValidateDoubleAmount.doGetResult", "Amount has incorrect precision:" + amount);
				rc = false;
			}
			return rc;
		}
    }

    /**
     * validate name
     * @author paigtran
     *
     */
    public static class ValidateName extends AbstractFunction {
    	
    	private static MbnaLogger logger = new MbnaLogger(ValidateName.class);

    	/**
    	 * validate name
    	 * @param arguments
    	 * @param line
    	 * @param column
    	 */
     	public ValidateName(Function[] arguments, int line, int column) {
	   		super(arguments, line, column);
	   		definedExactNumberOfArguments(1);
	   	}
   	
     	/**
     	 * get result
     	 */
		@Override
		protected Object doGetResult(Object target) throws Exception {
			boolean rc = true;
			String name =  (String) getArguments()[0].getResult(target);
			logger.debug(name);
			try {
				rc = name.matches("[-a-zA-Z\u2018-\u2019\u201c-\u201d:,. ~`'\"]+");
			} catch (Exception e) {
				rc = false;
			}
			return rc;
		}
    }

    /**
     * generate validation exception for testing purposes
     * @param errCode
     * @return
     */
	public static ValidationException genValidationException(String errCode) {
		String errC = SystemErrorCode;
		if (errCode != null){
			errC = errCode;
		}
   		ValidationException faultInfo = new ValidationExceptionForDebug();
   		List<FieldErrorType> fieldErrors = faultInfo.getFieldError();
   		FieldErrorType fldErr = new FieldErrorType();
   		fldErr.setField(errC);
   		fldErr.setErrorCode(errC);
 		fldErr.setErrorDescription(errC);
   		fldErr.setSeverity("ERROR");
   		fieldErrors.add(fldErr);
   		return faultInfo;
	}
}