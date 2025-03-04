package com.td.mbna.msec.midtier.util;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.w3c.dom.Document;

public class SoapUtil {

	private static MbnaLogger logger = new MbnaLogger(SoapUtil.class);
	/*
 	 *	returns the SOAP message as a string.
	 */
	public static String getMessageString(SOAPMessageContext smc) {
		String msgString = null;
		Object accessor = smc.get("jaxws.message.accessor"); 
		// WebSphere specific and only available after 7.0.0.15, for details see http://www-01.ibm.com/support/docview.wss?uid=swg1PM21151
		if (accessor != null) {	
			// this is possible if not using WebSphere, or is using WebSphere but older than 7.0.0.15
			msgString = accessor.toString();
			return msgString;
		}
		msgString = myGetMessageString(smc);
		return msgString;
	}

	/*
	 * myGetMessageString() returns the SOAP message as a string.
	 * It remembers the largest message for each service such that it uses
	 * an output buffer of the same size next time. From my measurement the performance
	 * is comparable to the WebSphere implementation
	 */
	private final static int DefaultMsgBufSize = 4096;
	private static ConcurrentHashMap<String,Integer> op2InMsgBufSizeMap = new ConcurrentHashMap<String,Integer>();
	private static ConcurrentHashMap<String,Integer> op2OutMsgBufSizeMap = new ConcurrentHashMap<String,Integer>();  
	public static String myGetMessageString(SOAPMessageContext smc) {
		String msgString = null;
		try {
			String service = smc.get(MessageContext.WSDL_SERVICE).toString();
			if (service != null) {
				boolean isOutboundMsg = isOutboundMessage(smc);
				ConcurrentHashMap<String,Integer> msgBufSizeMap = isOutboundMsg ? op2OutMsgBufSizeMap : op2InMsgBufSizeMap;
				Integer msgBufSizeInCache = msgBufSizeMap.get(service);
				if (msgBufSizeInCache == null) {
					msgBufSizeInCache = DefaultMsgBufSize;
				}
				int actualMsgSize;
				SOAPMessage message = smc.getMessage();
				ByteArrayOutputStream out = null;
				try {
					out = new ByteArrayOutputStream(msgBufSizeInCache);
					message.writeTo(out);
					actualMsgSize = out.size();
					msgString = out.toString("UTF-8");
				}
				finally {
					IoUtil.closeQuietly(out);
				}
				msgBufSizeMap.putIfAbsent(service, (actualMsgSize+msgBufSizeInCache)/2);
				// use average of current message size average and last message size as the next message buf size 
			}
		}
		catch (Exception e) {
			logger.error("Failed to convert SOAP message to string", e);
		}
		return msgString;
   }
	
	
	public static String getFaultString(SOAPMessageContext smc, String errMsg) {
		try {
			String rc = getFaultString(smc);
			return rc == null ? errMsg : rc;
		}
		catch (Exception e) {
			return errMsg;
		}
	}
	
	public static String getFaultString(SOAPMessageContext smc) throws Exception {
		SOAPMessage message = smc.getMessage();
		SOAPBody body = message.getSOAPBody();
		return body.getFault().getFaultString();
	}

	
	public static Document getBodyDocument(SOAPMessageContext smc) throws Exception {
      	SOAPMessage message = smc.getMessage();
      	SOAPBody body = message.getSOAPBody();
      	Document doc = body.getOwnerDocument();
      	return doc;
	}
	
	public static boolean isOutboundMessage(SOAPMessageContext smc) {
       Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
       return outboundProperty;
	}
	
	public static boolean isInboundMessage(SOAPMessageContext smc) {
	   return isOutboundMessage(smc) == false;
	}

	public static String getServiceNamespace(SOAPMessageContext smc) {
		QName srvObj = (QName) smc.get(MessageContext.WSDL_SERVICE);
		return srvObj == null ? null : srvObj.getNamespaceURI();
	}
	
	public static String getServiceName(SOAPMessageContext smc) {
		QName srvObj = (QName) smc.get(MessageContext.WSDL_SERVICE);
		return srvObj == null ? null : srvObj.getLocalPart();
	}
	
	public static String getServiceOperationString(SOAPMessageContext smc) {
		String opName = getOperationName(smc);
		if (opName == null) {
			opName = "N/A";
		}
		return getServiceName(smc) + "::" + opName; 
	}
	
	public static String getOperationName(SOAPMessageContext smc) {
		String opName = null;
		QName operation = (QName) smc.get(MessageContext.WSDL_OPERATION);
		if (operation == null) {
			// WebSphere jax-ws does not set this value
			// Found a TD-specific way using the debugger 
			// May not work in the future
			Object tdHdrOp = smc.get("TD_MESSAGE_HEADER_OPERATION");
			if (tdHdrOp instanceof String) {
				opName = (String) tdHdrOp; 
			}
			return opName;
		}
		opName = operation.getLocalPart();
		return opName;
	}

	// a class that lazy loads SOAP message attributes as needed, and persists the attributes. 
	// Persisting the attributes is important because, for example, getting the SOAP message
	// is a very intensive operation, so we don't want to do it more than once.
	public static class SoapMsgInfo {
		private final SOAPMessageContext soapMsgContext;
		private String msg;
		private Boolean isResponse;
		private String faultString;
		private String serviceOperation;
		public SoapMsgInfo(SOAPMessageContext smc) {
			soapMsgContext = smc;
		}
		public SOAPMessageContext getSoapMsgContext() {
			return soapMsgContext;
		}
		public String getMsg() {
			if (msg == null) {
				msg = getMessageString(soapMsgContext);
			}
			return msg;
		}
		public boolean isResponse() {
			if (isResponse == null) {
				isResponse = isInboundMessage(soapMsgContext); 
			}
			return isResponse;
		}
		public boolean isRequest() {
			return isResponse() == false;
		}
		public String getFaultString() {
			if (faultString == null) {
				faultString = SoapUtil.getFaultString(soapMsgContext, "N/A");
			}
			return faultString;
		}
		public String getServiceOperation() {
			if (serviceOperation == null) {
				serviceOperation = getServiceOperationString(soapMsgContext);
			}
			return serviceOperation;
		}
	}
}
