package com.td.mbna.msec.midtier.tdwsservices;

import com.sun.xml.ws.client.BindingProviderProperties;
import com.td.schemas.tdct.srm.cars.service.v2.TEnvCreateCustomerAccountRelationshipRq;
import com.td.schemas.tdct.srm.cars.service.v2.TEnvCreateCustomerAccountRelationshipRs;
import com.td.schemas.tdct.srm.cars.service.v2.TEnvUpdateCustomerAccountRelationshipRq;
import com.td.schemas.tdct.srm.cars.service.v2.TEnvUpdateCustomerAccountRelationshipRs;
import com.td.schemas.tdct.srm.cars.soap_service.v2.CustomerAccountRelationshipPortType;
import com.td.schemas.tdct.srm.cars.soap_service.v2.CustomerAccountRelationshipService;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.net.URL;

/**
 * This class contains actual invocation to TD WS.
 * 
 */
public class TdOdsCustomerAccountRelationshipService extends com.td.mbna.msec.midtier.tdwsservices.TdBaseService {

	private static final String srvcEndPoint = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.getTDServiceParam(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_ODS_CUSTOMERACCOUNTRELATIONSHIP_ENDPT);
	private static final String SrvcNameSpace = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.getTDServiceParam(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_ODS_CUSTOMERACCOUNTRELATIONSHIP_NS);
	private static final String SrvcName  = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.getTDServiceParam(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_ODS_CUSTOMERACCOUNTRELATIONSHIP_NAME);

	public static String getNamespace() {return SrvcNameSpace;}
	
	public static final String TdOp_odsCreateCustomerAccountRelationship = "odsCreateCustomerAccountRelationship";

	public static final String TdOp_odsUpdateCustomerAccountRelationship = "odsUpdateCustomerAccountRelationship";

	private static CustomerAccountRelationshipPortType getServicePort() throws Exception {
		if (isSpringSupported()) {
			return (CustomerAccountRelationshipPortType) getServicePortFromSpring(TdBaseService.BEAN_TdOdsCustomerAccountRelationship);
		}
		URL asUrl = new URL(srvcEndPoint);
		QName qname = new QName(SrvcNameSpace, SrvcName);
		CustomerAccountRelationshipService as = new CustomerAccountRelationshipService(asUrl, qname);
		CustomerAccountRelationshipPortType  port = as.getPort(CustomerAccountRelationshipPortType.class);  
		return port;
	}

	/**
	 * determines if service is enabled or not
	 * 
	 * @return
	 */
	public static boolean isEnabled() {
		return isPropertyTrue(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_ODS_CUSTOMERACCOUNTRELATIONSHIP_SERVICE_ENABLED);
	}

	public static TEnvCreateCustomerAccountRelationshipRs createAccountRelationship(TEnvCreateCustomerAccountRelationshipRq input) throws Exception {
		CustomerAccountRelationshipPortType port = getServicePort();
		((BindingProvider) port).getRequestContext().put(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_MESSAGE_HEADER_OPERATION, "createAccountRelationship");
		((BindingProvider) port).getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT, 5000);
		((BindingProvider) port).getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT, 5000);
		return port.createAccountRelationship(input);
	}

    public static TEnvUpdateCustomerAccountRelationshipRs updateAccountRelationship(TEnvUpdateCustomerAccountRelationshipRq input) throws Exception {
		CustomerAccountRelationshipPortType port = getServicePort();
		((BindingProvider) port).getRequestContext().put(TDwsServiceUtil.TD_MESSAGE_HEADER_OPERATION, "updateAccountRelationship");
		((BindingProvider) port).getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT, 5000);
		((BindingProvider) port).getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT, 5000);
		return port.updateAccountRelationship(input);

    }
}
