package com.td.mbna.msec.midtier.tdwsservices;

import java.util.HashMap;
import java.util.Map;
import java.io.StringReader;

import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import com.td.mbna.msec.midtier.configuration.beans.ExceptionInfoBean;
import com.td.mbna.msec.midtier.configuration.processor.ExceptionMappingProcessor;
import com.td.mbna.msec.midtier.exception.BusinessError;
import com.td.mbna.msec.midtier.exception.SystemError;
import com.td.mbna.msec.midtier.tdwsservices.TDSysErrorHandler;
//import com.td.mbna.msec.midtier.tdwsservices.TdCardTxService;
//import com.td.mbna.msec.midtier.tdwsservices.TdCreditCardService;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.SoapUtil;
import com.td.mbna.msec.midtier.util.WebServiceInfoCallTracker;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import com.mbnaweb.xsd.types.common.ErrorType;

/**
 * 
 * This class handles SOAP faults from TD.
 *
 */
public class TDErrorHandler extends TDSysErrorHandler {
	
	/**
	 * Handle SOAP message
	 */
    public boolean handleMessage(SOAPMessageContext smc) {
    	SoapUtil.SoapMsgInfo smi = new SoapUtil.SoapMsgInfo(smc);
       	if (smi.isRequest()) {
       		super.handleMessage(smi);
       	}
       	else {
       		super.handleMessage(smi);
       		checkInboundError(smi);
       	}
        return true;
    }

    @Override
    void checkInboundFault(SoapUtil.SoapMsgInfo smi) {
    	super.checkInboundFault(smi);
	    try {
	    	Map<String,String> errorInfo = getErrorInfoFromFault(smi.getSoapMsgContext(), smi.getMsg());
	    	if (errorInfo == null) {  // if error is not supposed to be handled here, just return.
	    		return;
	    	}
	    	
	    	String originator = errorInfo.get("originator");
	    	String sev = errorInfo.get("severity");
	    	String code = errorInfo.get("code");
	    	String message = errorInfo.get("message");
        	String operationDefultCode = errorInfo.get("operDefaultCode");
	    	        		
			ExceptionMappingProcessor exceptionMappingProcessor = new ExceptionMappingProcessor() ;
	
			ExceptionInfoBean exceptionInfobean = exceptionMappingProcessor.getMappedException(originator, code, ExceptionMappingProcessor.DEFAULT_CODE, null, null, sev,  message, operationDefultCode); 
	
			if (exceptionInfobean.getExceptionClassification().equalsIgnoreCase("BUSINESS")) {
				BusinessError bErr = exceptionMappingProcessor.genBusinessError(exceptionInfobean);
				if (bErr.getFaultInfo().getSeverity() == ErrorType.ERROR) {
					throw createSOAPFaultException(BusinessError.class.getSimpleName(), exceptionInfobean);    			
				}
			}
			else {
				SystemError sErr = exceptionMappingProcessor.genSystemError(exceptionInfobean);
				if (sErr.getFaultInfo().getSeverity() == ErrorType.ERROR) {
					throw createSOAPFaultException(SystemError.class.getSimpleName(), exceptionInfobean);
				}
			}
	    } catch (Exception exc) {
	   		throw ExceptionUtil.genRuntimeException(exc);
	    }
    }

     /*
     * For incoming TSYS message, check the status and throws appropriate exception
     */
    private void checkInboundError(SoapUtil.SoapMsgInfo smi) {
        try {
        	Map<String,String> errorInfo = getErrorInfo(smi.getSoapMsgContext());
        	if (errorInfo == null) {  // if error is not supposed to be handled here, just return.
        		return;
        	}
        	
        	String code = errorInfo.get("code");
        	if (code != null) {
        		code = code.trim();
        		if (code.length() == 0) {
        			code = null;
        		}
        	}
        	String auxCode = errorInfo.get("auxCode");
        	if (auxCode != null) { 
        		auxCode = auxCode.trim();
        		if (auxCode.length() == 0) {
        			auxCode = null;
        		}
        	}
        	if ((code == null || code.replace("0", "").length() == 0) && (auxCode == null || auxCode.length() == 0 || auxCode.replace("0", "").length() == 0)) { // if code is all zeros and no auxCode present, assume no error
        		return;
        	}
        	
        	String codeAuxCode = code == null || code.length() == 0 ? null : code;
        	if (auxCode != null && auxCode.length() > 0) {
        		if (codeAuxCode == null) codeAuxCode = auxCode;
        		else codeAuxCode += "," + auxCode;
        	}
        	String originator = errorInfo.get("originator");
        	String sev = errorInfo.get("severity");
        	String operDefaultCode = errorInfo.get("operDefaultCode");
        	String beIssuer = errorInfo.get("beIssuer");
        	String beCode = errorInfo.get("beCode");
			String tdMsgId = errorInfo.get("tdMsgId");
			String relatesToId = errorInfo.get("tdRelatesToId");
        	
        	ExceptionMappingProcessor exceptionMappingProcessor = new ExceptionMappingProcessor() ;
        	
        	// For Offers / getOffers, exceptions are to be ignored, but need logging, so let's throw something with meaning
        	if (originator.equals(ExceptionMappingProcessor.TD_OFFERS_GETOFFERS)) {
        		ExceptionInfoBean exceptionInfobean = exceptionMappingProcessor.createExceptionInfoBeanFromDetails(errorInfo);
        		throw createSOAPFaultException(SystemError.class.getSimpleName(), exceptionInfobean);
        	}
        	
			ExceptionInfoBean exceptionInfobean = exceptionMappingProcessor.getMappedException(originator, code, auxCode, beIssuer, beCode, sev, operDefaultCode);
			if (exceptionInfobean.getExceptionClassification().equals("IGNORE")) {
				logger.debug("Error ignored for " + originator + "::" + smi.getServiceOperation());
				return;
			}
			
			String errMsgHdr = originator + "::" + smi.getServiceOperation() + " failed with " + codeAuxCode +": ";
			
			if (exceptionInfobean.getExceptionClassification().equalsIgnoreCase("BUSINESS")) {
				BusinessError bErr = exceptionMappingProcessor.genBusinessError(exceptionInfobean);
				if (bErr.getFaultInfo().getSeverity() == ErrorType.ERROR) {
					if (WebServiceInfoCallTracker.inDevMode()) { // avoid expensive SOAP message creation in production
						WebServiceInfoCallTracker.setErrorInfo(errMsgHdr + smi.getMsg());
					}
					logger.error(errMsgHdr + "TD msgId=" + tdMsgId + ",relatesTo=" + relatesToId);
					throw createSOAPFaultException(BusinessError.class.getSimpleName(), exceptionInfobean);    			
				}
			}
			else {
				SystemError sErr = exceptionMappingProcessor.genSystemError(exceptionInfobean);
				// New: Warnings from Offers for updateOfferDisposition and OFS must be treated like errors
				if (sErr.getFaultInfo().getSeverity() == ErrorType.ERROR || 
						(originator.equals(ExceptionMappingProcessor.TD_OFFERS_OTHER) && sErr.getFaultInfo().getSeverity() == ErrorType.WARN) ||
						(originator.equals(ExceptionMappingProcessor.TD_OFS) && sErr.getFaultInfo().getSeverity() == ErrorType.WARN)) {
	        		WebServiceInfoCallTracker.setErrorInfo(errMsgHdr + smi.getMsg());
					logger.error(errMsgHdr + "TD msgId=" + tdMsgId + ",relatesTo=" + relatesToId);
					throw createSOAPFaultException(SystemError.class.getSimpleName(), exceptionInfobean);
				}
			}

        } catch (Exception exc) {
       		throw ExceptionUtil.genRuntimeException(exc);
        }
    }


   private String getOperationDefaultCode(SOAPMessageContext smc) {
	   String defaultCode = "DEFAULT";
       try {
    	   defaultCode = ExceptionMappingProcessor.TSYS_RETRIEVETRANSACTION ;
       } catch (Exception e) { 
    	   logger.error(e.getMessage(), e);
       }
       return defaultCode;
   }

   
   private Map<String,String> getErrorInfo(SOAPMessageContext smc) throws Exception {
	   
	   Map<String, String> errInfo = null;
	   String originator = getOriginator(smc);
	   String severity = "INFO";
	   String code = "DEFAULT";
	   String operDefaultCode = getOperationDefaultCode(smc);
	   
	   if (originator.equals(ExceptionMappingProcessor.TD_TSYS)
	    || originator.equals(ExceptionMappingProcessor.TD_ODS)
	    || originator.equals(ExceptionMappingProcessor.TD_ODS_CREATE_PROFILE)
	    || originator.equals(ExceptionMappingProcessor.TD_ODS_RETRIEVE_PROFILE)
	    || originator.equals(ExceptionMappingProcessor.TD_ODS_RELATIONS)) { // ODS and TSYS both use TD DXM structures, so can share the same handler  
		   errInfo = getTSYSError(smc);
	   } else if (originator.equals(ExceptionMappingProcessor.TD_DDS)) {
		   errInfo = getDDSError(smc);
	   } else if (originator.equals(ExceptionMappingProcessor.TD_DMS)) {
		   errInfo = getDMSError(smc);
	   } else if (originator.equals(ExceptionMappingProcessor.TD_OFFERS_GETOFFERS) || originator.equals(ExceptionMappingProcessor.TD_OFFERS_OTHER)) {
		   errInfo = getOffersError(smc);
	   } else if(originator.equals(ExceptionMappingProcessor.TD_NOTES)) {
		   //can use getOfferError for notes because the response xml have the same schema
		   errInfo = getOffersError(smc);		   
	   } else if (originator.equals(ExceptionMappingProcessor.TD_OFS)) {
		   errInfo = getOffersError(smc);
	   } else if (originator.equals(ExceptionMappingProcessor.TD_EMAIL)) {
		   errInfo = getEmailError(smc); 
	   } else {
		   errInfo = new HashMap<String,String>();
		   errInfo.put("severity", severity);
		   errInfo.put("code", code);
		   errInfo.put("auxCode", code);
	   }
	   if (errInfo != null) {
		   errInfo.put("originator", originator);
		   errInfo.put("operDefaultCode", operDefaultCode);
	   }

	   return errInfo;
   }

   private Map<String,String> getTSYSError(SOAPMessageContext smc) throws Exception {
	    Map<String, String> errInfo = new HashMap<String,String>(); 
       	Document doc = SoapUtil.getBodyDocument(smc); 
		XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        NodeList nl = doc.getElementsByTagNameNS("*", "Status");
        if (nl.getLength() > 0) {
        	Node statusNode = nl.item(0);
        	setMsgIds(statusNode, xpath, errInfo);
			XPathExpression sevExpr = xpath.compile("*[local-name()='Severity']");
			String sev = sevExpr.evaluate(statusNode);
			boolean isErrResponse = sev != null && (sev.equalsIgnoreCase("FATAL") || sev.equalsIgnoreCase("ERROR"));
			//XPathExpression codeExpr = xpath.compile("//Status/ServerStatusCode");
			XPathExpression codeExpr = xpath.compile("*[local-name()='AdditionalStatus']/*[local-name()='ServerStatusCode']");
			String code = codeExpr.evaluate(statusNode);
			XPathExpression auxCodeExpr = xpath.compile("*[local-name()='AdditionalStatus']/*[local-name()='StatusCode']");
			String auxCode = auxCodeExpr.evaluate(statusNode);
			if (isErrResponse && (code == null || code.trim().length() == 0) && (auxCode == null || auxCode.trim().length() == 0)) {
				// Look at top-level status code if additional status not available
				codeExpr = xpath.compile("*[local-name()='ServerStatusCode']");
				code = codeExpr.evaluate(statusNode);
				auxCodeExpr = xpath.compile("*[local-name()='StatusCode']");
				auxCode = auxCodeExpr.evaluate(statusNode);
			}
			XPathExpression beIssuerExpr = xpath.compile("//*[local-name()='RefInfo']/*[local-name()='IssuerId']");
			String beIssuer = beIssuerExpr.evaluate(statusNode);
			XPathExpression beCodeExpr = xpath.compile("//*[local-name()='RefInfo']/*[local-name()='KeyName'][.='ServerStatusCode']/../*[local-name()='KeyValue']");
			String beCode = beCodeExpr.evaluate(statusNode);
			// When a PIN mailer request is sent and one is already pending, TD returns a fatal exception. To map this appropriately, the serverstatuscode is not sufficient.
			// We need to look in the description to see if it contains the word "DUPLICATE".
			if (code.equalsIgnoreCase("RPM-034")) {
				XPathExpression addStatusDescExpr = xpath.compile("*[local-name()='AdditionalStatus']/*[local-name()='StatusDesc']");
				String addStatusDesc = addStatusDescExpr.evaluate(statusNode);
				if (addStatusDesc.contains("DUPLICATE")) {
					code = code + "-DUPLICATE";
				}
			}
			if (isErrResponse) { // no doubt this is an error response
				if (code == null || code.trim().length() == 0) {	              // but we couldn't find a code, just use the default code such that a fault will be thrown
					code = ExceptionMappingProcessor.DEFAULT_CODE;
				}
			}
			errInfo.put("severity", sev);
			errInfo.put("code", code);
			errInfo.put("auxCode", auxCode);
			errInfo.put("beIssuer", beIssuer);
			errInfo.put("beCode", beCode);
		}
		return errInfo;
   }

   
   private Map<String,String> getDDSError(SOAPMessageContext smc) throws Exception {
	    Map<String, String> errInfo = new HashMap<String,String>(); 
       	Document doc = SoapUtil.getBodyDocument(smc);
		XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        NodeList nl = doc.getElementsByTagNameNS("*", "Status");
        if (nl.getLength() > 0) {
        	Node statusNode = nl.item(0);
        	setMsgIds(statusNode, xpath, errInfo);
			XPathExpression sevExpr = xpath.compile("*[local-name()='Severity']");
			String sev = sevExpr.evaluate(statusNode);
			//XPathExpression codeExpr = xpath.compile("//Status/ServerStatusCode");
			XPathExpression codeExpr = xpath.compile("*[local-name()='StatusCode']");
			String code = codeExpr.evaluate(statusNode);
	 	    errInfo.put("severity", sev);
			errInfo.put("code", code);
        }
		return errInfo;
  }
   
  // DMS errors is only to be handled in the handleFault()
   private Map<String,String> getDMSError(SOAPMessageContext smc) throws Exception {
		  return null;
   }
   
  private Map<String,String> getDMSFault(SOAPMessageContext smc, String content) throws Exception {
	  XPathFactory factory = XPathFactory.newInstance(  );
	  XPath xPath = factory.newXPath(  );
	  String code = xPath.evaluate("//*[local-name()='code']", new InputSource(new StringReader(content)));
	  String faultcode = xPath.evaluate("//*[local-name()='faultcode']", new InputSource(new StringReader(content)));
	  
	  String codeMapped = null;
	  if ("DOCM.003".equalsIgnoreCase(code) || "DOCM.003".equalsIgnoreCase(faultcode)) {
		  codeMapped = "DOCM.003";
	  } else if ("NIL_ERR".equalsIgnoreCase(code) || "NIL_ERR".equalsIgnoreCase(faultcode)) {
		  codeMapped = "NIL_ERR";
	  } else if ("COM_ERR".equalsIgnoreCase(code) || "COM_ERR".equalsIgnoreCase(faultcode)) {
		  codeMapped = "COM_ERR";
	  } else if ("GEN_ERR".equalsIgnoreCase(code) || "GEN_ERR".equalsIgnoreCase(faultcode)) {
		  codeMapped = "GEN_ERR";
	  } else if (code.startsWith("INVDA_") || faultcode.startsWith("INVDA_")) {
		  codeMapped = "INVDA";
	  } else if ("ACSDN".equalsIgnoreCase(code) || "ACSDN".equalsIgnoreCase(faultcode)) {
		  codeMapped = "ACSDN";
	  } else if ("TIMEOUT".equalsIgnoreCase(code) || "TIMEOUT".equalsIgnoreCase(faultcode)) {
		  codeMapped = "TIMEOUT";
	  }
	  
	  String sev = ExceptionMappingProcessor.ERROR;
	  Map<String, String> errInfo = new HashMap<String,String>();
	  errInfo.put("severity", sev);
	  errInfo.put("code", codeMapped);
	  errInfo.put("originator", ExceptionMappingProcessor.TD_DMS);
	  	  
	  return errInfo;
  }

  //*****************************************************************************************************************
   // faults to be handled
   //   1.TechnicalExceptionMessage xmlns="http://ServiceDesignBuildingBlocks/ManageCustomerInterfaces/"
   //     TechnicalException        xmlns="http://Common/"
   //   2. BusinessExceptionMessage xmlns="http://ServiceDesignBuildingBlocks/ManageCustomerInterfaces/"
   //   3. ServiceFault 			xmlns="urn:wsc.td.com/fault/2004/05/01"
   //*****************************************************************************************************************
   private Map<String,String> getErrorInfoFromFault(SOAPMessageContext smc, String content) throws Exception {
       
	   Map<String, String> errInfo = null;
	   String originator = ExceptionMappingProcessor.TD_MISC;
	   String severity = "ERROR";
	   String code = "DEFAULT";
	   String operDefaultCode = getOperationDefaultCode(smc);
	   if (operDefaultCode == null){
		   operDefaultCode = "DEFAULT";
	   }
	   
 
    	   
       if (content.contains("ServiceFault")) {
		   errInfo = getServiceFaultError(smc);
	   } else if (content.contains("DocumentManagementFault")) {
		   errInfo = getDMSFault(smc, content);
	   } else {
		   errInfo = new HashMap<String,String>();
		   errInfo.put("severity", severity);
		   errInfo.put("code", code);
		   errInfo.put("originator", originator);
		   errInfo.put("operDefaultCode", operDefaultCode);
	   }
	   return errInfo;
   }
   
   private Map<String,String> getOffersError(SOAPMessageContext smc) throws Exception {
		Map<String, String> errInfo = new HashMap<String,String>();
       	Document doc = SoapUtil.getBodyDocument(smc);
		XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        NodeList nl = doc.getElementsByTagNameNS("*", "Status");
        if (nl.getLength() > 0) {
        	Node statusNode = nl.item(0);
        	setMsgIds(statusNode, xpath, errInfo);
			XPathExpression sevExpr = xpath.compile("*[local-name()='Severity']");
			String sev = sevExpr.evaluate(statusNode);
			XPathExpression codeExpr = xpath.compile("*[local-name()='StatusCode']");
			String code = codeExpr.evaluate(statusNode);
			XPathExpression descExpr = xpath.compile("*[local-name()='StatusDesc']");
			String desc = descExpr.evaluate(statusNode);
			XPathExpression serverStatusCodeExpr = xpath.compile("*[local-name()='ServerStatusCode']");
			String serverStatusCode = serverStatusCodeExpr.evaluate(statusNode);
			
			errInfo.put("severity", sev);
			errInfo.put("code", code);
			errInfo.put("desc", desc);
			errInfo.put("auxCode", serverStatusCode);
		}
		return errInfo;
   }
   
   private Map<String,String> getEmailError(SOAPMessageContext smc) throws Exception {
 		Map<String, String> errInfo = new HashMap<String,String>();
        Document doc = SoapUtil.getBodyDocument(smc);
        Element docElem = doc.getDocumentElement();
 		XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
		XPathExpression codeExpr = xpath.compile("//ResponseCD");
		String code = codeExpr.evaluate(docElem);
		if (code == null || code.isEmpty() || code.equalsIgnoreCase("OK")) {
			code = "0";
		}
		XPathExpression auxCodeExpr = xpath.compile("*[local-name()='ErrorCode']");
		String auxCode = auxCodeExpr.evaluate(docElem);
		errInfo.put("severity", code.equals("0") ? "INFO" : "ERROR");
		errInfo.put("code", code);
		errInfo.put("auxCode", auxCode);
 		return errInfo;
   }
   
   private static Map<String,String> getServiceFaultError(SOAPMessageContext smc) throws Exception {
	    Map<String, String> errInfo = new HashMap<String,String>(); 
	    errInfo.put("severity", ExceptionMappingProcessor.ERROR);
		errInfo.put("code", ExceptionMappingProcessor.DEFAULT_CODE );
	    errInfo.put("originator", getOriginator(smc));

      	Document doc = SoapUtil.getBodyDocument(smc);
		XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
	    XPathExpression msgExpr = xpath.compile("//*[local-name()='message']");
		String msg = msgExpr.evaluate(doc);
		errInfo.put("message", msg);

	    return errInfo;
   }
   
   private static void setMsgIds(Node statusNode, XPath xpath, Map<String, String> out) throws Exception {
	   	XPathExpression msgIdExpr = xpath.compile("../*[local-name()='MessageID']");
	   	String msgId = msgIdExpr.evaluate(statusNode);
	   	if (msgId == null || msgId.isEmpty()) { msgId = "N/A";}
	   	XPathExpression relatesToIdExpr = xpath.compile("../*[local-name()='CorrelationID' or local-name()='RelatesTo']");
	   	String relatesToId = relatesToIdExpr.evaluate(statusNode);
	   	if (relatesToId == null || relatesToId.isEmpty()) {relatesToId = "N/A";}
	   	out.put("tdMsgId", msgId);
	   	out.put("tdRelatesToId", relatesToId);
   }
}
   
