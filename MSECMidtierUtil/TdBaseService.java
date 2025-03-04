package com.td.mbna.msec.midtier.tdwsservices;

import com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil;
import com.td.mbna.msec.midtier.util.SpringBeanProvider;

/**
 * This class contains actual invocation to TD WS.
 *
 */
public class TdBaseService {
	
	// ACES bean
	public static final String BEAN_TdAccessControlEligibilityService = "TdAccessControlEligibilityService";
	// Card Service bean
	public static final String BEAN_TdCardService = "TdCardService";
	// Card Transaction Service bean
	public static final String BEAN_TdCardTxService = "TdCardTxService";
	// Credit Card Account Service bean
	public static final String BEAN_TdCreditCardAcctService = "TdCreditCardAcctService";
	// Credit Card Service bean
	public static final String BEAN_TdCreditCardService = "TdCreditCardService";
	// Customer Agreement Service bean
	public static final String BEAN_TdCustAgreementService = "TdCustAgreementService";
	// Customer Notes Service bean
	public static final String BEAN_TdCustNotesService = "TdCustNotesService";
	// DDS bean
//	public static final String BEAN_TdDirectDebitService = "TdDirectDebitService";
	// Disclosure Service bean
	public static final String BEAN_TdDisclosureCfgService = "TdDisclosureCfgService";
	// DMS bean
	public static final String BEAN_TdDocuManagementService = "TdDocuManagementService";
	// Enrollment Service bean
	public static final String BEAN_TdEnrolmentService = "TdEnrolmentService";
	// OFS bean
	public static final String BEAN_TdOfferFulfillmentService = "TdOfferFulfillmentService";
	// Offers Service bean
	public static final String BEAN_TdOffersService = "TdOffersService";
	// Payee Management Service bean
	public static final String BEAN_TdPayeeManagement = "TdPayeeManagement"; 
	// Email Notification bean
	public static final String BEAN_TdEmailNotificationService = "TdEmailNotificationService";
	//Key Management Service bean
	public static final String BEAN_TdKeyManagementService = "TdKeyManagementService";
	// Customer Profile Service (aka ODS) bean
	public static final String BEAN_TdOdsCustomerProfile = "TdOdsCustomerProfile"; 
	
	public static final String BEAN_TdOdsCustomerAccountRelationship = "TdOdsCustomerAccountRelationship";

	
	/**
	 * Get service port from Spring
	 * @param serviceName
	 * @return
	 */
	public static Object getServicePortFromSpring(String serviceName) {
		SpringBeanProvider.getApplicationContext();
		return SpringBeanProvider.getApplicationContext().getBean(serviceName);
	}

	/**
	 * determines if Spring is supported or not
	 * @return
	 */
	protected static boolean isSpringSupported() {
		return true;
	}
	
	/**
	 * Determines if property is true
	 * @param key
	 * @return
	 */
	protected static boolean isPropertyTrue(String key) {
		boolean rc = false;
		String result = TDwsServiceUtil.getTDServiceParam(key);
		if (result != null) {
	    	rc = Boolean.parseBoolean(result.trim());
		}
	    return rc;
	}
	
	/**
	 * disable service by default
	 * @return
	 */
	public static boolean isEnabled() {
		return false;
	}
	
}
