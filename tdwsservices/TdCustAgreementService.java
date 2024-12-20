package com.td.mbna.msec.midtier.tdwsservices;

import com.sun.xml.ws.client.BindingProviderProperties;
import com.td.wsc.cstagt._2010._07._14.CaptureAgreementRequestType;
import com.td.wsc.cstagt._2010._07._14.CaptureAgreementResponseType;
import com.td.wsc.cstagt._2010._07._14.SearchAgreementRequestType;
import com.td.wsc.cstagt._2010._07._14.SearchAgreementResponseType;
import com.td.wsc.cstagt.wsdl.CustomerAgreement;
import com.td.wsc.cstagt.wsdl.CustomerAgreementService;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.net.URL;

/**
 * This class contains actual invocation to TD WS.
 *
 */
public class TdCustAgreementService extends com.td.mbna.msec.midtier.tdwsservices.TdBaseService {
	private static final String srvcEndPoint = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.getTDServiceParam(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_CUSTAGREEMENT_ENDPT);
	private static final String SrvcNameSpace = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.getTDServiceParam(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_CUSTAGREEMENT_NS);
	private static final String SrvcName  = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.getTDServiceParam(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_CUSTAGREEMENT_NAME);
	private static final String CONTEXT_PATH = "com.td.wsc.cstagt._2010._07._14:com.td.wsc.cstagt.fault._2010._07._14:com.td.wsc.fault._2004._05._01";

	public static String getNamespace() {return SrvcNameSpace;}
	
	private static CustomerAgreement  getServicePort() throws Exception {
		if (isSpringSupported()) {
			return (CustomerAgreement) getServicePortFromSpring(TdBaseService.BEAN_TdCustAgreementService);
		}

		URL asUrl = new URL(srvcEndPoint);
		QName qname = new QName(SrvcNameSpace, SrvcName);
		CustomerAgreementService  as = new CustomerAgreementService(asUrl,qname);
		CustomerAgreement  port = as.getPort(CustomerAgreement.class); // as.getSoapPort20100714();
		return port;
		
	}

	/**
	 * determines whether the service is enabled or not
	 * @return
	 */
	public static boolean isEnabled() {
		return isPropertyTrue(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_CUSTAGREEMENT_SERVICE_ENABLED);
	}
	
	/**
	 * captureAgreement request to TD
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public static byte[]  captureAgreement(CaptureAgreementRequestType  req) throws Exception {
		byte[] resStr = null;
				
		// unmarshall the input
		CustomerAgreement  port = getServicePort();
		((BindingProvider) port).getRequestContext().put(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_MESSAGE_HEADER_OPERATION, "CaptureAgreement");
		((BindingProvider) port).getRequestContext().put(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_MESSAGE_HEADER_ENDPOINT,((BindingProvider)port).getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY));
		((BindingProvider) port).getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT, 5000);
		((BindingProvider) port).getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT, 5000);
		CaptureAgreementResponseType  res = port.captureAgreement(req);
		resStr = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.convertObjectToStream(CONTEXT_PATH, CaptureAgreementResponseType.class,res,"CaptureAgreementResponse");
		return resStr;
	}


	/**
	 * searchAgreement request to TD
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public static byte[]  searchAgreement(SearchAgreementRequestType  req) throws Exception {
		byte[] resStr = null;
				
		// unmarshall the input
		CustomerAgreement  port = getServicePort();
		((BindingProvider) port).getRequestContext().put(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_MESSAGE_HEADER_OPERATION, "SearchAgreement");
		((BindingProvider) port).getRequestContext().put(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_MESSAGE_HEADER_ENDPOINT,((BindingProvider)port).getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY));
		((BindingProvider) port).getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT, 5000);
		((BindingProvider) port).getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT, 5000);
		SearchAgreementResponseType  res = port.searchAgreement(req);
		resStr = TDwsServiceUtil.convertObjectToStream(CONTEXT_PATH, SearchAgreementResponseType.class,res,"SearchAgreementResponse");
		return resStr;
	}

}
