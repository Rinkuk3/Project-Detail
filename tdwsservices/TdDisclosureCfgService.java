package com.td.mbna.msec.midtier.tdwsservices;

import com.sun.xml.ws.client.BindingProviderProperties;
import com.td.wsc.dscfg._2010._07._05.AssembleDisclosureRequestType;
import com.td.wsc.dscfg._2010._07._05.AssembleDisclosureResponseType;
import com.td.wsc.dscfg.wsdl.DisclosureConfiguration;
import com.td.wsc.dscfg.wsdl.DisclosureConfigurationService;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.net.URL;

/**
 * This class contains actual invocation to TD WS.
 *
 */
public class TdDisclosureCfgService extends com.td.mbna.msec.midtier.tdwsservices.TdBaseService {
	private static final String srvcEndPoint = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.getTDServiceParam(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_DISCLOSURECFG_ENDPT);
	private static final String SrvcNameSpace = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.getTDServiceParam(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_DISCLOSURECFG_NS);
	private static final String SrvcName  = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.getTDServiceParam(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_DISCLOSURECFG_NAME);
	private static final String CONTEXT_PATH = "com.td.wsc.dscfg._2010._07._05:com.td.wsc.dscfg.fault._2010._07._05:com.td.wsc.fault._2004._05._01";

	public static String getNamespace() {return SrvcNameSpace;}
	
	private static DisclosureConfiguration   getServicePort() throws Exception {
		if (isSpringSupported()) {
			return (DisclosureConfiguration) getServicePortFromSpring(TdBaseService.BEAN_TdDisclosureCfgService);
		}

		URL asUrl = new URL(srvcEndPoint);
		QName qname = new QName(SrvcNameSpace, SrvcName);
		DisclosureConfigurationService as = new DisclosureConfigurationService(asUrl,qname);
		DisclosureConfiguration   port = as.getPort(DisclosureConfiguration .class);   
		return port;
		
	}

	/**
	 * determines if the service is enabled or not
	 * @return
	 */
	public static boolean isEnabled() {
		return isPropertyTrue(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_DISCLOSURECFG_SERVICE_ENABLED);
	}

	/**
	 * assembleDisclosure request to TD
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public static byte[]  assembleDisclosure(AssembleDisclosureRequestType  req) throws Exception {
		byte[] resStr = null;
				
		// unmarshall the input
		// AssembleDisclosureRequestType req = (AssembleDisclosureRequestType) TDwsServiceUtil.convertToObject(CONTEXT_PATH, reqStr);
		DisclosureConfiguration port = getServicePort();
		((BindingProvider) port).getRequestContext().put(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_MESSAGE_HEADER_OPERATION, "AssembleDisclosure");
		((BindingProvider) port).getRequestContext().put(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_MESSAGE_HEADER_ENDPOINT,((BindingProvider)port).getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY));
		((BindingProvider) port).getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT, 5000);
		((BindingProvider) port).getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT, 5000);
		AssembleDisclosureResponseType  res = port.assembleDisclosure(req);
		resStr = TDwsServiceUtil.convertObjectToStream(CONTEXT_PATH, AssembleDisclosureResponseType.class,res,"AssembleDisclosureResponse");
		return resStr;
	}

}
