/*
package com.td.mbna.msec.midtier.tdwsservices;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.schemas.tdct.srm.card.service.v1.*;
import com.td.schemas.tdct.srm.card.soap_service.v1.*;

*/
/**
 * This class contains actual invocation to TD WS.
 *
 *//*

public class TdCardService   extends com.td.mbna.msec.midtier.tdwsservices.TdBaseService {
	private static final String srvcEndPoint = TDwsServiceUtil.getTDServiceParam(TDwsServiceUtil.TD_CARD_ENDPT);
	private static final String SrvcNameSpace = TDwsServiceUtil.getTDServiceParam(TDwsServiceUtil.TD_CARD_NS);
	private static final String SrvcName  = TDwsServiceUtil.getTDServiceParam(TDwsServiceUtil.TD_CARD_NAME);
	private static final String CONTEXT_PATH = "com.td.schemas.tdct.messaging.v1:com.td.schemas.tdct.srm.card.service.v1";
	private static MbnaLogger logger = new MbnaLogger(TdCardService.class);
	
	public static String getNamespace() {return SrvcNameSpace;}

	private static CardPortType  getServicePort() throws Exception {
//		ThrottlingTimer.delay();
		if (isSpringSupported()) {
			return (CardPortType) getServicePortFromSpring(TdBaseService.BEAN_TdCardService);
		}
		
		URL asUrl = new URL(srvcEndPoint);
		QName qname = new QName(SrvcNameSpace, SrvcName);
		Card as = new Card(asUrl,qname);
		CardPortType  port = as.getPort(CardPortType.class); // as.getCardSoap();
		return port;
	}

	*/
/**
	 * Determines if the service should be enabled or not
	 * @return
	 *//*

	public static boolean isEnabled() {
		return isPropertyTrue(TDwsServiceUtil.TD_CARD_SERVICE_ENABLED);
	}

	public static byte[]  activateCard(TActivateCardRq  req) throws Exception {
		byte[] resStr = null;
		// unmarshall the input
		CardPortType port =  getServicePort();
		((BindingProvider) port).getRequestContext().put(TDwsServiceUtil.TD_MESSAGE_HEADER_OPERATION, "activateCard");
		TActivateCardRs  res = port.activateCard(req);
 		resStr = TDwsServiceUtil.convertObjectToStream(CONTEXT_PATH, TActivateCardRs.class,res,"ActivateCardRs");
		return resStr;
	}
	
	public static byte[] issueCard(TIssueCardRq  req) throws Exception {
		byte[] resStr = null;
		// unmarshall the input
		// TIssueCardRq req = (TIssueCardRq) TDwsServiceUtil.convertToObject(CONTEXT_PATH, reqStr);
		CardPortType port =  getServicePort();
		((BindingProvider) port).getRequestContext().put(TDwsServiceUtil.TD_MESSAGE_HEADER_OPERATION, "issueCard");
		TIssueCardRs  res = port.issueCard(req);
		resStr = TDwsServiceUtil.convertObjectToStream(CONTEXT_PATH, TIssueCardRs.class,res,"IssueCardRs");
		return resStr;
	}

	public static TIssueCardRs issueCard2(TIssueCardRq  req) throws Exception {
//		byte[] resStr = null;
		// unmarshall the input
		CardPortType port =  getServicePort();
		((BindingProvider) port).getRequestContext().put(TDwsServiceUtil.TD_MESSAGE_HEADER_OPERATION, "issueCard");
		TIssueCardRs  res = port.issueCard(req);
		return res;
	}

	public static byte[] retrieveCardAccountInfo(TRetrieveCardAccountInfoRq req) throws Exception {
		byte[] resStr = null;
		// unmarshall the input
		CardPortType port =  getServicePort();
		((BindingProvider) port).getRequestContext().put(TDwsServiceUtil.TD_MESSAGE_HEADER_OPERATION, "retrieveCardAccountInfo");
		TRetrieveCardAccountInfoRs  res = port.retrieveCardAccountInfo(req);
		resStr = TDwsServiceUtil.convertObjectToStream(CONTEXT_PATH, TRetrieveCardAccountInfoRs.class,res,"RetrieveCardAccountInfoRs");
		return resStr;
	}
	
	public static TRetrieveCardAccountInfoRs retrieveCardAccountInfo2(TRetrieveCardAccountInfoRq req) throws Exception {
		try{
			CardPortType port =  getServicePort();
			((BindingProvider) port).getRequestContext().put(TDwsServiceUtil.TD_MESSAGE_HEADER_OPERATION, "retrieveCardAccountInfo");
			TRetrieveCardAccountInfoRs  res = port.retrieveCardAccountInfo(req);
			return res;
		}catch (RuntimeException ex) {
			//log the error and return null response to GetCustomerAccountsOperation
			logger.error("retrieveCardAccountInfo2", ex.getMessage(), ex);
			return null;
		}
	}
	
	public static byte[] retrievePIN(TRetrievePINRq  req) throws Exception {
		byte[] resStr = null;
		// unmarshall the input
		CardPortType port =  getServicePort();
		((BindingProvider) port).getRequestContext().put(TDwsServiceUtil.TD_MESSAGE_HEADER_OPERATION, "retrievePIN");
		TRetrievePINRs  res = port.retrievePIN(req);
		resStr = TDwsServiceUtil.convertObjectToStream(CONTEXT_PATH, TRetrievePINRs.class,res,"RetrievePINRs");
		return resStr;
	}

	public static byte[] unblockPIN(TUnblockPINRq  req) throws Exception {
		byte[] resStr = null;
		// unmarshall the input
		CardPortType port =  getServicePort();
		((BindingProvider) port).getRequestContext().put(TDwsServiceUtil.TD_MESSAGE_HEADER_OPERATION, "unblockPIN");
		TUnblockPINRs  res = port.unblockPIN(req);
		resStr = TDwsServiceUtil.convertObjectToStream(CONTEXT_PATH, TUnblockPINRs.class,res,"UnblockPINRs");
		return resStr;
	}

	public static byte[]  updateCardAccountInfo(TUpdateCardAccountInfoRq  req ) throws Exception {
		byte[] resStr = null;
		// unmarshall the input
		CardPortType port =  getServicePort();
		((BindingProvider) port).getRequestContext().put(TDwsServiceUtil.TD_MESSAGE_HEADER_OPERATION, "updateCardAccountInfo");
		TUpdateCardAccountInfoRs  res = port.updateCardAccountInfo(req);
		resStr = TDwsServiceUtil.convertObjectToStream(CONTEXT_PATH, TUpdateCardAccountInfoRs.class,res,"UpdateCardAccountInfoRs");
		return resStr;
	}

	public static byte[] updatePIN(TUpdatePINRq  req ) throws Exception {
		byte[] resStr = null;
		// unmarshall the input
		CardPortType port =  getServicePort();
		((BindingProvider) port).getRequestContext().put(TDwsServiceUtil.TD_MESSAGE_HEADER_OPERATION, "updatePIN");
		TUpdatePINRs  res = port.updatePIN(req);
		resStr = TDwsServiceUtil.convertObjectToStream(CONTEXT_PATH, TUpdatePINRs.class,res,"UpdatePINRs");
		return resStr;
	}

}
*/
