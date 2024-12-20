package com.td.mbna.msec.midtier.util;

import com.td.mbna.msec.midtier.exception.BusinessError;
import com.td.mbna.msec.midtier.exception.SystemError;
import com.td.mbna.msec.midtier.exception.ValidationError;
import com.td.mbna.msec.midtier.types.common.*;


/**
 * 
 * Utility methods for running JUnit test cases.
 *
 */
public class TestUtil {
	
	public static TrackingInfoType generateTrackingInfo() {
		
		TrackingInfoType trackingInfoType = new TrackingInfoType();
		trackingInfoType.setConnectId("1234");
		trackingInfoType.setClientAction("test");
		trackingInfoType.setIpAddr("127.0.0.1");
		trackingInfoType.setLoginId("testuser");
		trackingInfoType.setSessionId("testSessionId");
		trackingInfoType.setFirstName("Test");
		trackingInfoType.setLastName("User");
		
		return trackingInfoType;
	}

	public static com.mbnaweb.xsd.types.common.TrackingInfoType generateXsdTrackingInfo() {

		com.mbnaweb.xsd.types.common.TrackingInfoType trackingInfoType = new com.mbnaweb.xsd.types.common.TrackingInfoType();
		trackingInfoType.setConnectId("1234");
		trackingInfoType.setClientAction("test");
		trackingInfoType.setIpAddr("127.0.0.1");
		trackingInfoType.setLoginId("testuser");
		trackingInfoType.setSessionId("testSessionId");
		trackingInfoType.setFirstName("Test");
		trackingInfoType.setLastName("User");

		return trackingInfoType;
	}
	
	public static AuditInfo generateAuditLogInfo() {

		AuditInfo auditLogType = new AuditInfo();
		auditLogType.setTransactionCode("SS0402");
		auditLogType.setAccountDelinquencyCode("A1");
		auditLogType.setAccountStatusCode("ACTIVE");
		auditLogType.setBrowser("IE");
		auditLogType.setConnectId("1234");
		auditLogType.setGroupAffinityCode("A2");
		auditLogType.setOperatingSystem("windows");
		auditLogType.setPaaSequence("4");
		auditLogType.setServerID("test");
		auditLogType.setUrl("http://test");
		auditLogType.setCardEnding("123456");
		auditLogType.setLogLastLogin(false);
		
		return auditLogType;
	}
	
public static EmailNotificationInfoType generateEmailNotificationInfo() {
		
		EmailNotificationInfoType emailNotificationInfoType = new EmailNotificationInfoType();
		/**
		emailNotificationInfoType.setCardMemberEmailAddress("abc@xyz.com");
		emailNotificationInfoType.setCardName("MBNA Rewards Card");
		emailNotificationInfoType.setDeliveryPreferenceSelected("");
		emailNotificationInfoType.setInitiatedBy("P");
		emailNotificationInfoType.setMdmKeyForPrimary("1234567890");
		emailNotificationInfoType.setOldEmailAddressChange("pqr@xyz.com");
		**/
		
		emailNotificationInfoType.setPrimaryUserEmailAddress("abc@xyz.com");
		emailNotificationInfoType.setPrimaryUserLanguage("English");
		emailNotificationInfoType.setPrimaryUserFirstName("John");
		emailNotificationInfoType.setPrimaryUserMiddleName("D");
		emailNotificationInfoType.setPrimaryUserLastName("Doe");
		emailNotificationInfoType.setCardName("MBNA Rewards Card");
		emailNotificationInfoType.setCardEnding("1234");
		emailNotificationInfoType.setOldEmailAddressChange("def@xyz.com");
		return emailNotificationInfoType;
	}
	/*
	public static EmailInfoImpl generateEmailInfoBean() {
		
		EmailInfoImpl emailInfoBean = new EmailInfoImpl();
		emailInfoBean.setTriggerEmailNotification(true);

		emailInfoBean.setPrimaryEmailAddress("abc@xyz.com");
		emailInfoBean.setCardName("MBNA Rewards Card");
		emailInfoBean.setCardEnding("1234");
		emailInfoBean.setConfirmationNumber("78HYG");
		emailInfoBean.setStatementDeliveryPreferenceSelected("Opt-in to eStatements");
		emailInfoBean.setInitiatedBy("Authorized User");
		emailInfoBean.setPrimaryLanguagePref("English");

		emailInfoBean.setOldEmailAddress("pqr@xyz.com");
		PrimaryCardMemberInfo primaryCardMemberInfo = new PrimaryCardMemberInfo();
		primaryCardMemberInfo.setFirstName("JOHN");
		primaryCardMemberInfo.setMiddleName("D");
		primaryCardMemberInfo.setLastName("DOE");
		emailInfoBean.setPrimaryUserInfo(primaryCardMemberInfo);
		emailInfoBean.setBusinessEventID(IMBNAConstants.BUSINESSEVENT_ID_DEPOSITTOCHECKINGREQUEST);

		return emailInfoBean;

	}
	*/
	public static void init() {
		
		System.setProperty(com.td.mbna.msec.midtier.util.ConfigUtil.SYSTEM_PROPERTY_CONFIG_DIR, "./src/test/resources");
		System.setProperty(com.td.mbna.msec.midtier.util.ConfigUtil.SYSTEM_PROPERTY_TEST, "true");
		System.setProperty("javax.xml.soap.MetaFactory", "com.sun.xml.internal.messaging.saaj.soap.SAAJMetaFactoryImpl");
		ParallelServiceCaller.useGlobalSynchrousCall();
	}
	
	public static void generateTestException(TrackableRequest req) throws ValidationError, SystemError, BusinessError {
    	String sessionId = req.getSessionInfo().getSessionId();
    	if (sessionId.equalsIgnoreCase("ValidationException")) {
  			com.td.mbna.msec.midtier.types.common.ValidationException faultInfo = new com.td.mbna.msec.midtier.types.common.ValidationException();
    		FieldErrorType fldErr = new FieldErrorType();
    		fldErr.setField("sessionId");
    		fldErr.setErrorCode("MS502");
    		fldErr.setErrorDescription("MS502");
    		fldErr.setSeverity("ERROR");
    		faultInfo.getFieldError().add(fldErr);
    		throw faultInfo;
    	}
    	if (sessionId.equalsIgnoreCase("SystemException")) {
    		SystemError sErr = new SystemError();
    		com.mbnaweb.xsd.types.common.SystemException faultInfo = new com.mbnaweb.xsd.types.common.SystemException();
     		faultInfo.setErrorCode("MS502");
    		faultInfo.setErrorDescription("MS502");
    		sErr.setFaultInfo(faultInfo);
    		throw sErr;
    	}
    	if (sessionId.equalsIgnoreCase("BusinessException")) {
    		BusinessError bErr = new BusinessError();
    		com.mbnaweb.xsd.types.common.BusinessException faultInfo = new com.mbnaweb.xsd.types.common.BusinessException();
     		faultInfo.setErrorCode("MS502");
    		faultInfo.setErrorDescription("MS502");
    		bErr.setFaultInfo(faultInfo);
    		throw bErr;
    	}
	}
	
	public static boolean isTest() {
		 return Boolean.parseBoolean(System.getProperty(ConfigUtil.SYSTEM_PROPERTY_TEST, "false"));
	}
}
