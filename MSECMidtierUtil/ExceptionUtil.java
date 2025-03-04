package com.td.mbna.msec.midtier.util;

import com.mbnaweb.xsd.types.common.ErrorType;
import com.mbnaweb.xsd.types.common.ExceptionInfo;
import com.td.mbna.msec.midtier.exception.BusinessError;
import com.td.mbna.msec.midtier.exception.SystemError;

import javax.xml.soap.Detail;
import javax.xml.soap.DetailEntry;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;
import java.util.Iterator;

/**
 * This call contains utility functions to map the exception caused by the web services.
 *
 */
public class ExceptionUtil {
	
	private static final String PREFERENCE_INFORMATION_ERROR_1 = "No Privacy Preference found for the given UCID";
	private static final String PREFERENCE_INFORMATION_ERROR_2 = "Preference information not found for a customer with the provided customer identifier";
	private static final String PREFERENCE_INFORMATION_CODE_1 = "<Name>7000602</Name>";
	private static final String MDM_GENERIC_PHONE_ERROR="Phone Number Standardization Failed";
	
	/**
	 * get runtime exception
	 * @param e
	 * @return
	 */
	public static RuntimeException genRuntimeException(Throwable e) {
		if (e instanceof RuntimeException) {
			return (RuntimeException) e;
		}
		return new RuntimeException(e);
	}
	
	
	public static com.td.mbna.msec.midtier.exceptions.BusinessException genBusinessException(String message) {
		return genBusinessException("MS601",message);
	}
	public static com.td.mbna.msec.midtier.exceptions.BusinessException genBusinessException(String errorCode, String message) {
		com.td.mbna.msec.midtier.types.common.BusinessException faultInfo = new com.td.mbna.msec.midtier.types.common.BusinessException();
		faultInfo.setErrorCode(errorCode == null ? "MS601" : errorCode);
		faultInfo.setErrorDescription(message);
		return new com.td.mbna.msec.midtier.exceptions.BusinessException("business exception:"+message, faultInfo); 
	}
	

	
	/**
	 * This will scan the hierarchy of the exception and return the BusinessError if it exists.
	 *
	 */
	public static ExceptionInfo getExceptionInfo(Exception ex) {
		if (ex.getCause() instanceof SOAPFaultException) {
			SOAPFaultException exc = (SOAPFaultException)ex.getCause();
			SOAPFault fault = exc.getFault();
			if (exc.getMessage().equals(BusinessError.class.getSimpleName())) {
				com.mbnaweb.xsd.types.common.BusinessException faultInfo = new com.mbnaweb.xsd.types.common.BusinessException();
				setExceptionInfo(fault, faultInfo);
				return faultInfo;
			}
			else if (exc.getMessage().equals(SystemError.class.getSimpleName())) {
				com.mbnaweb.xsd.types.common.SystemException faultInfo = new com.mbnaweb.xsd.types.common.SystemException();
				setExceptionInfo(fault, faultInfo);
				return faultInfo;
			}
		}
		return null;
	}
	
	/**
	 * ignore error for retrieve preferences
	 * @param e
	 * @return
	 */
	public static boolean ignoreError(Exception e) {
	   if (e instanceof org.springframework.remoting.jaxws.JaxWsSoapFaultException ){
		   String message = WebServiceInfoCallTracker.getErrorInfo();
		   if ((message!=null)&&(message.contains(PREFERENCE_INFORMATION_ERROR_1)
				   				|| message.contains(PREFERENCE_INFORMATION_ERROR_2)
				   				|| message.contains(PREFERENCE_INFORMATION_CODE_1))){
			   return true;
		   }
		}
	   return false;
	}
	
	/**
	 * Return true if the exception is thrown due to "Phone Number Standardization Failed"
	 * MDM is checking phone numbers for length, not all 1s, not all 9s, etc. We have to check if this exception is for an invalid number. 
	 * We can't meaningfully map this MDM fault in ExceptionMapping_MidTier.xml because if there's a soap fault from MDM, the code is always 'name' now. 
	 * Using the code, we can't distinguish if the fault is for "No Privacy Preference found for the given UCID" or "Phone Number Standardization Failed". 
	 * That's why we have to check the Exception object here.
	 */
	public static boolean isMDMPhoneException(SoapFaultTriggeredException e) {
		   if (e.getSoapFaultSrcResponse()!=null && (e.getSoapFaultSrcResponse().indexOf(MDM_GENERIC_PHONE_ERROR)>-1)){		 
			   return true;
			}
		   return false;
	}
	
	
	/**
	 * Extracts the error code from SoapFaultException
	 * @param ex
	 * @return
	 */
	public static String extractErrorCode(Exception ex) {		
		String errorCode = null;	
		try {
			// extract the error code from SoapFaultException to map it to a UI message for display
			SOAPFaultException soapEx = (SOAPFaultException)ex.getCause();
			//get the auxCode. for offers, 				
			Detail detail = soapEx.getFault().getDetail();					
			
			if (detail != null) {
			    Iterator<?> entries = detail.getDetailEntries();
			    while ( entries.hasNext() ) {
			        DetailEntry entry = (DetailEntry)entries.next();						        
			        if (entry.getLocalName().equalsIgnoreCase("errorCode")) {
			        	errorCode = entry.getValue();
			        	break;
			        }						        
			    }
			}
			return errorCode;
		}catch (Exception e) {
			return null;
		}
	}
	
	private static void setExceptionInfo(SOAPFault fault, ExceptionInfo faultInfo) {
		Detail detail = fault.getDetail();
		String errorCode = null;
		String errorDescription = null;
		for (Iterator<?> iter = detail.getDetailEntries(); iter.hasNext();  ) {
			DetailEntry dEntry = (DetailEntry)iter.next();
			if (dEntry.getLocalName().equals("errorCode")) {
				errorCode = dEntry.getTextContent(); 
			}
			else if (dEntry.getLocalName().equals("errorDescription")) {
				errorDescription = dEntry.getTextContent(); 
			}
		}
		faultInfo.setErrorCode(errorCode);
		faultInfo.setErrorDescription(errorDescription);
		faultInfo.setSeverity(ErrorType.ERROR);		
	}
	
	
}
