package com.td.mbna.msec.midtier.tdwsservices;


import java.net.InetAddress;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;

/**
 * 
 * This class handles SOAP messages from TD.
 *
 */
public class TDSoapFilter implements SOAPHandler<SOAPMessageContext>{
	
	private static MbnaLogger logger = new MbnaLogger(TDSoapFilter.class);
	private static InetAddress localIp =  null;
	 
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
    	return filter(smc);
    }

    /**
     * handle SOAP message
     */
    public boolean handleFault(SOAPMessageContext smc) {
    	return true;
    }
    
    /**
     *  nothing to clean up
     */
    public void close(MessageContext messageContext) {
    }

   /* 
    * Make sure the call is from the UI layer on the same machine or the property uiIpAddr is specified.
    *  
    */
   private boolean filter(SOAPMessageContext smc) {
	   Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
	   boolean passThru = true;
	   try {
		   if (!outboundProperty.booleanValue()) {
			   HttpServletRequest request = (HttpServletRequest)smc.get(SOAPMessageContext.SERVLET_REQUEST);
			   String uiIpAddr = ConfigUtil.getProperty("uiIpAddr");
			   String ipAddress = request.getRemoteAddr();    
			   if (uiIpAddr != null) {
				   if (!uiIpAddr.trim().equals("*") && !uiIpAddr.trim().equals(ipAddress.trim())) {
					   logger.error("The request client IP " + ipAddress + " is different from uiIpAddr " + uiIpAddr );
					   passThru = false; 
				   }
			   }
			   else {
				   String localAddress = request.getLocalAddr();
				   if (!ipAddress.startsWith("127.") && !ipAddress.trim().equals(localAddress.trim())) {
					   String serverAddress = getServerAddress(); 
					   if (serverAddress == null || !serverAddress.equals(ipAddress.trim())) {
						   logger.error("The request remote IP " + ipAddress + " is different from request server IP " + localAddress);
						   logger.error("The local server IP " + serverAddress);
						   passThru = false;
					   }
				   }
			   }
		   }
	   }
	   catch (Throwable e) {
		   logger.error("Filter failed with: " + e);
		   passThru = false;
	   }
	   return passThru;
   }
   /*
    * Find the local IP address
    */
   static String getServerAddress() {
	   String serverAddress = null;
	   if (localIp == null) {
			try {
				// InetAddress.getHostAddress is thread-safe. Just make sure the initialization is done correctly.
				synchronized (logger) {
					localIp = InetAddress.getLocalHost();
				}
				if (localIp != null) {
					serverAddress = localIp.getHostAddress();
					logger.info("The host IP is " + serverAddress);
				}
			}
			catch (Exception ex) { logger.error(ex);}
	   }
	   if (localIp != null) {
			serverAddress = localIp.getHostAddress();
	   }
	   return serverAddress;
   }
}