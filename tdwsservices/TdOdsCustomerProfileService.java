package com.td.mbna.msec.midtier.tdwsservices;

import com.sun.xml.ws.client.BindingProviderProperties;
import com.td.mbna.msec.midtier.util.BackEndSrvcUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.UuidUtil;
import com.td.schemas.tdct.srm.cps.soap_service.v1.CustomerProfilePortType;
import com.td.schemas.tdct.srm.cps.soap_service.v1.CustomerProfileService;
import com.td.schemas.tdct.srm.customerprofile.service.v1.*;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This class contains actual invocation to TD WS.
 * 
 */
public class TdOdsCustomerProfileService extends com.td.mbna.msec.midtier.tdwsservices.TdBaseService {

	private static final String srvcEndPoint = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.getTDServiceParam(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_ODS_CUSTOMERPROFILE_ENDPT);
	private static final String SrvcNameSpace = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.getTDServiceParam(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_ODS_CUSTOMERPROFILE_NS);
	private static final String SrvcName  = com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.getTDServiceParam(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_ODS_CUSTOMERPROFILE_NAME);
	private static final String CONTEXT_PATH = "com.td.schemas.tdct.srm.customerprofile.service.v1";
	public final static String TdOp_odsCreateCustomerProfile = "odsCreateCustomerProfile";
	public final static String TdOp_odsRetrieveCustomerProfile = "odsRetrieveCustomerProfile";

	private static MbnaLogger logger = new MbnaLogger(TdOdsCustomerProfileService.class);

	public static String getNamespace() {return SrvcNameSpace;}

	private static CustomerProfilePortType getServicePort() throws Exception {
		logger.debug("getServicePort");
		if (isSpringSupported()) {
			return (CustomerProfilePortType) getServicePortFromSpring(TdBaseService.BEAN_TdOdsCustomerProfile);
		}
		URL asUrl = new URL(srvcEndPoint);
		QName qname = new QName(SrvcNameSpace, SrvcName);
		CustomerProfileService as = new CustomerProfileService(asUrl, qname);
		CustomerProfilePortType  port = as.getPort(CustomerProfilePortType.class);
		return port;
	}

	/**
	 * determines if service is enabled or not
	 *
	 * @return
	 */
	public static boolean isEnabled() {
		logger.debug("isEnabled");
		return isPropertyTrue(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_ODS_CUSTOMERPROFILE_SERVICE_ENABLED);
	}

	public static TEnvCreateCustomerProfileRs createCustomerProfile(TEnvCreateCustomerProfileRq input) throws Exception {
		logger.debug("createCustomerProfile");
		CustomerProfilePortType port = getServicePort();
		((BindingProvider) port).getRequestContext().put(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_MESSAGE_HEADER_OPERATION, "createCustomerProfile");
		((BindingProvider) port).getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT, 5000);
		((BindingProvider) port).getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT, 5000);
		return port.createCustomerProfile(input);
	}

	public static TEnvRetrieveCustomerProfileRs retrieveCustomerProfile(TEnvRetrieveCustomerProfileRq input) throws Exception {
		logger.debug("retrieveCustomerProfile");
		CustomerProfilePortType port = getServicePort();
		((BindingProvider) port).getRequestContext().put(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_MESSAGE_HEADER_OPERATION, "retrieveCustomerProfile");
		((BindingProvider) port).getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT, 5000);
		((BindingProvider) port).getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT, 5000);
		return port.retrieveCustomerProfile(input);
	}

	public static TEnvUpdateCustomerProfileRs updateCustomer(TEnvUpdateCustomerProfileRq input) throws Exception {
		logger.debug("updateCustomer");
		CustomerProfilePortType port = getServicePort();
		((BindingProvider) port).getRequestContext().put(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_MESSAGE_HEADER_OPERATION, "updateCustomerProfile");
		((BindingProvider) port).getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT, 5000);
		((BindingProvider) port).getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT, 5000);
		return port.updateCustomerProfile(input);
	}

	public static byte[] updateCustomer2(TEnvUpdateCustomerProfileRq input) throws Exception {
		logger.debug("updateCustomer2");
		byte[] resStr = null;
		CustomerProfilePortType port = getServicePort();
		((BindingProvider) port).getRequestContext().put(com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil.TD_MESSAGE_HEADER_OPERATION, "updateCustomerProfile");
		((BindingProvider) port).getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT, 5000);
		((BindingProvider) port).getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT, 5000);
		TEnvUpdateCustomerProfileRs res = port.updateCustomerProfile(input);
		resStr = TDwsServiceUtil.convertObjectToStream(CONTEXT_PATH, TEnvUpdateCustomerProfileRs.class,res,"EnvUpdateCustomerProfileRs");
		return resStr;
	}


	public static TEnvRetrieveCustomerProfileRs retrieveCustomerProfileViaPartyId(String partyId, RcpFilter filters) throws Exception {
		logger.debug("retrieveCustomerProfileViaPartyId");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idTypeCd", "PartyID");
		params.put("idNum", partyId);
		return retrieveCustomerProfileCommon(params, filters);

	}

	public static TEnvRetrieveCustomerProfileRs retrieveCustomerProfileViaAcctNum(
			String acctNum, RcpFilter filters) throws Exception {
		logger.debug("retrieveCustomerProfileViaAcctNum");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idTypeCd", "HostAgreementNum");
		params.put("idNum", acctNum);
		return retrieveCustomerProfileCommon(params, filters);
	}

	private static TEnvRetrieveCustomerProfileRs retrieveCustomerProfileCommon(Map<String, Object> params, RcpFilter filters) throws Exception {
		logger.debug("retrieveCustomerProfileCommon");
		params.put("trackId", UuidUtil.genUuid());
		params.putAll(filters);
		// Remove the PREFERENCES filter as ODS is not handling this now.

		Iterator<Map.Entry<String, Object>> itr = params.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String,Object> me = itr.next();
			if ("PREFERENCES".equals(me.getValue())) {
				itr.remove();
			}
		}

		TEnvRetrieveCustomerProfileRs odsRes = BackEndSrvcUtil
				.invokeService(
						null,
						TdOp_odsRetrieveCustomerProfile,
						TdOp_odsRetrieveCustomerProfile,
						null,
						null,
						null,
						params,
						BackEndSrvcUtil.TDOperation.TdOdsCustomerProfileService_retrieveCustomerProfile,
						null, null, TEnvRetrieveCustomerProfileRs.class);
		return odsRes;
	}
}
