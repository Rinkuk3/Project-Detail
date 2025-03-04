package com.td.mbna.msec.midtier.tdwsservices;


import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Detail;
import javax.xml.soap.DetailEntry;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import com.td.mbna.msec.midtier.configuration.beans.ExceptionInfoBean;
import com.td.mbna.msec.midtier.configuration.processor.ExceptionMappingProcessor;
import com.td.mbna.msec.midtier.exception.SystemError;
import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.SoapUtil;
import com.td.mbna.msec.midtier.util.WebServiceInfoCallTracker;

/**
 * 
 * TSYS message handler.
 *
 */
public class TDSysErrorHandler implements SOAPHandler<SOAPMessageContext>{
	 
    // change this to redirect output if desired
	static MbnaLogger logger = new MbnaLogger(TDSysErrorHandler.class);
	
	private final static boolean isDebugEnabled = logger.isDebugEnabled();
	
	private final static boolean InDevMode = ConfigUtil.inDevMode();

	private final static boolean LOG_AssembleDisclosureResponse = "true".equalsIgnoreCase(ConfigUtil.getProperty("debug.AssembleDisclosureResponse", "false"));

	/**
	 * get header information
	 */
    public Set<QName> getHeaders() {
        return null;
    }

    /**
     * handle SOAP message
     */
    public boolean handleMessage(SOAPMessageContext smc) {
    	WebServiceInfoCallTracker.clear();
		handleMessage(new SoapUtil.SoapMsgInfo(smc));
        return true;
    }
    
    boolean handleMessage(SoapUtil.SoapMsgInfo smi) {
        logMessage(smi);
        return true;
    }

    /**
     * handle SOAP fault
     */
    public boolean handleFault(SOAPMessageContext smc) {
		handleFault(new SoapUtil.SoapMsgInfo(smc));
		return true;
    }
    
    void handleFault(SoapUtil.SoapMsgInfo smi) {
        logMessage(smi);
        if (smi.isResponse()) {
        	if (InDevMode) {
        		WebServiceInfoCallTracker.setSoapFaultEncountered(true);
        	}
        	SOAPMessageContext smc = smi.getSoapMsgContext();
        	String originator = getOriginator(smc);
    		String op = smi.getServiceOperation();
    		if (InDevMode) {
    			WebServiceInfoCallTracker.setErrorInfo(originator + "::" + op + " failed: " + smi.getMsg());
    		}
			logger.error(" -BACKEND SERVICE FAILURE IN: " + originator + "::"+op+ getSoapFaultCodeAndMessage(smc));
        	checkInboundFault(smi);
        }
    }

    /**
     *  nothing to clean up
     */
    public void close(MessageContext messageContext) {
    }

    /*
     * For inbound message, check the status and throws appropriate error
     */
    void checkInboundFault(SoapUtil.SoapMsgInfo smi) {
        try {
			String faultString = smi.getFaultString();
			if (faultString.contains("SocketTimeoutException")) {
				throw createSOAPFaultException(SystemError.class.getSimpleName(), "MS502", faultString);    			
			}
        } catch (SOAPFaultException exc) {
        	throw exc;
        } catch (Exception exc) {
        	logger.error(exc);
        	throw ExceptionUtil.genRuntimeException(exc);
        }
    }
    
    /**
     * create soap fault exception
     * @param faultString
     * @param errorCode
     * @param errorDescription
     * @return
     * @throws SOAPException
     */
    static SOAPFaultException createSOAPFaultException(String faultString, String errorCode, String errorDescription) throws SOAPException {
        SOAPFault fault = SOAPFactory.newInstance().createFault();
        fault.setFaultString(faultString);
        Detail detail = fault.addDetail();
        QName entryName = new QName("http://mbnaweb/", "errorCode", "mbna");
        DetailEntry entry = detail.addDetailEntry(entryName);
        entry.addTextNode(errorCode);
        entryName = new QName("http://mbnaweb/", "severity", "mbna");
        entry = detail.addDetailEntry(entryName);
        entry.addTextNode("ERROR");
        entryName = new QName("http://mbnaweb/", "errorDescription", "mbna");
        entry = detail.addDetailEntry(entryName);
        entry.addTextNode(errorDescription);
        
        return new SOAPFaultException(fault);
    }
    
    /**
     * create SOAP Fault exception
     * @param faultString
     * @param faultInfo
     * @return
     * @throws SOAPException
     */
    static SOAPFaultException createSOAPFaultException(String faultString, ExceptionInfoBean faultInfo) throws SOAPException {
        SOAPFault fault = SOAPFactory.newInstance().createFault();
        fault.setFaultString(faultString);
        Detail detail = fault.addDetail();
        QName entryName = new QName("http://mbnaweb/", "errorCode", "mbna");
        DetailEntry entry = detail.addDetailEntry(entryName);
        entry.addTextNode(faultInfo.getErrorCode());
        entryName = new QName("http://mbnaweb/", "severity", "mbna");
        entry = detail.addDetailEntry(entryName);
        entry.addTextNode(faultInfo.getSeverity());
        entryName = new QName("http://mbnaweb/", "errorDescription", "mbna");
        entry = detail.addDetailEntry(entryName);
        entry.addTextNode(faultInfo.getErrorDescription());
        entryName = new QName("http://mbnaweb/", "soapExceptionMessage", "mbna");
        entry = detail.addDetailEntry(entryName);
        entry.addTextNode(faultInfo.getSoapExceptionMessage());
        
        return new SOAPFaultException(fault);
    }
    
    static void logMessage(SoapUtil.SoapMsgInfo smi) {

       if (isDebugEnabled == false) {
    	   return;	// Do not perform the expension SOAP message creation if debug is not enabled.
       }
 	   try {
 		   String msg = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.suppressCardNoAndPin(smi.getMsg());

 		   if (LOG_AssembleDisclosureResponse || msg.length() < 42768 || msg.indexOf("AssembleDisclosureResponse") == -1) {
			   StringBuilder msgBuf = new StringBuilder(msg.length() + 32);

			   msgBuf.append(smi.isResponse() ? " -Response from backend: " : " -Request to backend: ");

			   msgBuf.append(msg);

			   logger.debug(msgBuf.toString());
		   } else {
			   logger.debug(msg.substring(0, 500) + "...");
		   }
 	   }
 	   catch(Exception ex) {
 		   logger.error("Error while printing the SOAP message: ", ex);
 	   }
    }
    
   static String getOriginator(SOAPMessageContext smc) {
 	   String originator = ExceptionMappingProcessor.TD_MISC;
        try {
        	String serviceNs = SoapUtil.getServiceNamespace(smc);
        	if (serviceNs.equals(TdOdsCustomerProfileService.getNamespace())) {
        		String op = SoapUtil.getOperationName(smc);
        		if (op.equals("createCustomerProfile")) {
        			originator = ExceptionMappingProcessor.TD_ODS_CREATE_PROFILE;
        		}
        		if (op.equals("retrieveCustomerProfile")) {
        			originator = ExceptionMappingProcessor.TD_ODS_RETRIEVE_PROFILE;
        		}
        		else {
        			originator = ExceptionMappingProcessor.TD_ODS;
        		}
        	}
        	else if (serviceNs.equals(TdOdsCustomerAccountRelationshipService.getNamespace())) {
        		originator = ExceptionMappingProcessor.TD_ODS_RELATIONS;
        	}
        	/*else if (serviceNs.equals(TdCardService.getNamespace())) {
         	   	originator = ExceptionMappingProcessor.TD_TSYS;*/
//            }  else if (serviceNs.equals(TdDirectDebitService.getNamespace())) {
//         	   	originator = ExceptionMappingProcessor.TD_DDS;
             else if (serviceNs.contains("/mdm/")) {
            	throw new RuntimeException("MDM should not be invoked directly");
            }
        } catch (Exception e) { 
     	   logger.error(e.getMessage(), e);
        }
        return originator;
    }
   
   protected static String getSoapFaultCodeAndMessage(SOAPMessageContext smc) {
	   String code = getTdFaultCode(smc);
	   String msg = getTdFaultMessage(smc);
	   String faultstring = getSoapFaultString(smc);
	   StringBuilder s = new StringBuilder();
	   if (code != null && !code.isEmpty()) {
		   s.append("; code=" + code);
	   }
	   if (msg != null && !msg.isEmpty()) {
		   s.append(s.length() > 0 ? ", " : "; ");
		   s.append("message=" + msg);
	   }
	   if (faultstring != null && !faultstring.isEmpty()) {
		   s.append(s.length() > 0 ? ", " : "; ");
		   s.append("faultstring=" + faultstring);
	   }
	   return s.toString();
   }
   
    protected static String getTdFaultMessage(SOAPMessageContext smc) {
    	try {
			Document doc = SoapUtil.getBodyDocument(smc);
			XPathFactory factory = XPathFactory.newInstance();
			XPath xpath = factory.newXPath();
			XPathExpression msgExpr = xpath.compile("//*[local-name()='message']"); // TD-specific fault message
			String msg = msgExpr.evaluate(doc);
			return msg;
    	}
    	catch (Exception e) {
    		return null;
    	}
    }
    
    protected static String getTdFaultCode(SOAPMessageContext smc) {
    	try {
			Document doc = SoapUtil.getBodyDocument(smc);
			XPathFactory factory = XPathFactory.newInstance();
			XPath xpath = factory.newXPath();
			XPathExpression msgExpr = xpath.compile("//*[local-name()='code']"); // TD-specific fault code
			String msg = msgExpr.evaluate(doc);
			return msg;
    	}
    	catch (Exception e) {
    		return null;
    	}
    }

    protected static String getSoapFaultString(SOAPMessageContext smc) {
    	try {
			Document doc = SoapUtil.getBodyDocument(smc);
			XPathFactory factory = XPathFactory.newInstance();
			XPath xpath = factory.newXPath();
			XPathExpression msgExpr = xpath.compile("//*[local-name()='faultstring']");
			String msg = msgExpr.evaluate(doc);
			return msg;
    	}
    	catch (Exception e) {
    		return null;
    	}
    }

    
}