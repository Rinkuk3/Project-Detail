package com.td.mbna.msec.midtier.tdwsservices;


import com.td.mbna.msec.midtier.util.SoapUtil;
import com.td.mbna.msec.midtier.util.UuidUtil;

import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 * This class inserts header info for common services calls
 *
 */
public class TDCommonServicesSoapHeader extends TDSysErrorHandler {
	
	/**
	 * handle SOAP message
	 */
    public boolean handleMessage(SOAPMessageContext smc) {
    	SoapUtil.SoapMsgInfo smi = new SoapUtil.SoapMsgInfo(smc);
    	insertCSHeader(smi);
    	super.handleMessage(smi);
		return true;
    }

   /** 
    * Insert additional SOAPHeader information for MDM outbound calls
    *  
    */
   private void insertCSHeader(SoapUtil.SoapMsgInfo smi) {
	   if (smi.isRequest()) {
		   SOAPMessageContext smc = smi.getSoapMsgContext();      
           try {
        	   String t_headerNS = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.getTDServiceParam(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_CS_HEADER_WSA_NS);
        	   String t_wsaFrom = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.getTDServiceParam(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_CS_HEADER_WSA_From);
        	   String t_wsaTo = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.getTDServiceParam(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_CS_HEADER_WSA_To);
        	   String t_wsaAction = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.getTDServiceParam(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_CS_HEADER_WSA_Action);
        	   String t_wsaMessage = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.getTDServiceParam(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_CS_HEADER_WSA_Message);
        	   String t_wsaAddress = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.getTDServiceParam(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_CS_HEADER_WSA_Address);
        	   String t_wsaAddressValue = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.getTDServiceParam(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_CS_HEADER_WSA_AddressValue);
        	   String t_traceabilityNS = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.getTDServiceParam(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_CS_HEADER_WSA_TR_NS);
        	   String t_traceabilityValue = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.getTDServiceParam(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_CS_HEADER_WSA_TR_value);
         	   String t_action = (String) smc.get(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_MESSAGE_HEADER_OPERATION);
         	   String t_endpoint = (String) smc.get(TDwsServiceUtil.TD_MESSAGE_HEADER_ENDPOINT);
        	   
          	   SOAPEnvelope envelope = smc.getMessage().getSOAPPart().getEnvelope();
//               SOAPHeader header = envelope.addHeader();
			   if (envelope.getHeader() != null) {
				   envelope.getHeader().detachNode();
			   }
			   SOAPHeader header = envelope.addHeader();
               
               SOAPElement wsaMessage = header.addChildElement(t_wsaMessage, "wsa", t_headerNS);
               wsaMessage.addTextNode(UuidUtil.genUuid());
               
               SOAPElement addressToHeader = header.addChildElement(t_wsaTo, "wsa", t_headerNS);
               addressToHeader.addTextNode(t_endpoint);               
               
               SOAPElement addressFromHeader = header.addChildElement(t_wsaFrom, "wsa", t_headerNS);

               SOAPElement address = addressFromHeader.addChildElement(t_wsaAddress, "wsa");
               address.addTextNode(t_wsaAddressValue);


               SOAPElement actionHeader = header.addChildElement(t_wsaAction, "wsa", t_headerNS);
               actionHeader.addTextNode(t_action);               
               
               SOAPElement traceHeader = header.addChildElement(t_traceabilityValue, "ns", t_traceabilityNS);               
               traceHeader.addTextNode(UuidUtil.genUuid());
               
           } catch (Exception e) {
        	   logger.error(e.getMessage(), e);
           }
	   	}
	}
}