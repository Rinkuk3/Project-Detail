package com.td.mbna.msec.midtier.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.td.mbna.msec.midtier.util.services.JAXBJsonConverter;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.SuppressPropertiesBeanIntrospector;

import com.mbnaweb.xsd.msgs.customerprofile.CustomerAcctInfoType;
import com.mbnaweb.xsd.msgs.customerprofile.CustomerAcctProfileType;
import com.mbnaweb.xsd.msgs.customerprofile.CustomerAcctType;
import com.mbnaweb.xsd.msgs.customerprofile.CustomerInfoType;
import com.mbnaweb.xsd.msgs.customerprofile.CustomerProfileType;
import com.mbnaweb.xsd.msgs.customerprofile.RetrieveCustomerProfileResponse;
import com.mbnaweb.xsd.msgs.customerprofile.UpdateCustomerProfileResponse;
import com.mbnaweb.xsd.types.common.AcctContactInfoType;
import com.mbnaweb.xsd.types.common.CardHolderType;
import com.mbnaweb.xsd.types.common.CustAcctType;
import com.mbnaweb.xsd.types.common.EligIdType;
import com.mbnaweb.xsd.types.common.PhoneNumber;
import com.mbnaweb.xsd.types.common.UnformattedAddress;
import com.mbnaweb.xsd.types.common.UserNameType;
import com.mbnaweb.xsd.types.eligibility.AcctEligType;
import com.mbnaweb.xsd.types.eligibility.CustEligType;

public class CustomerProfileUtil {
	
	private static MbnaLogger logger = new MbnaLogger(CustomerProfileUtil.class);
	
	public final static String CATEGORY_CD = "CategoryCD";
	public final static String PARTY_ID = "PartyID";
	public final static String USER_ROLE = "UserRole";
	public final static String ACCOUNT_NUMBER = "AcctNum";
	public final static String ALIAS_CUSTOMER_ID = "AliasCustomerID";

	// Preference
	public static final String XSL_IS_PREF_CHANGED = "isPrefChanged";
	public static final String XSL_IS_PREF_PRESENT = "isPrefPresent";
	
	// Business Phone
	public static final String XSL_IS_BUSINESSPHONE_CHANGED = "isBusinessPhoneChanged";
	public static final String XSL_IS_BUSINESSPHONE_PRESENT = "isBusinessPhonePresent";
	public static final String XSL_BUSINESSPHONE_ENDTS = "businessPhoneEndTS";
	public static final String XSL_BUSINESSPHONE_LASTUPDATEDTS = "businessPhoneLastUpdatedTS";
	public static final String XSL_BUSINESSPHONE_LOC_LASTUPDATEDTS = "businessPhoneLocLastUpdatedTS";
	public static final String XSL_BUSINESSPHONE_NUMBER = "businessPhoneNumber";
	
	// HOME Phone
	public static final String XSL_IS_HOMEPHONE_CHANGED = "isHomePhoneChanged";
	public static final String XSL_IS_HOMEPHONE_PRESENT = "isHomePhonePresent";
	public static final String XSL_HOMEPHONE_ENDTS = "homePhoneEndTS";
	public static final String XSL_HOMEPHONE_LASTUPDATEDTS = "homePhoneLastUpdatedTS";
	public static final String XSL_HOMEPHONE_LOC_LASTUPDATEDTS = "homePhoneLocLastUpdatedTS";
	public static final String XSL_HOMEPHONE_NUMBER = "homePhoneNumber";

	// Mobile Phone
	public static final String XSL_IS_MOBILEPHONE_CHANGED = "isMobilePhoneChanged";
	public static final String XSL_IS_MOBILEPHONE_PRESENT = "isMobilePhonePresent";
	public static final String XSL_MOBILEPHONE_ENDTS = "mobilePhoneEndTS";
	public static final String XSL_MOBILEPHONE_LASTUPDATEDTS = "mobilePhoneLastUpdatedTS";
	public static final String XSL_MOBILEPHONE_LOC_LASTUPDATEDTS = "mobilePhoneLocLastUpdatedTS";
	public static final String XSL_MOBILEPHONE_NUMBER = "mobilePhoneNumber";
	
	// Email Address
	public static final String XSL_IS_EMAIL_CHANGED = "isEmailChanged";
	public static final String XSL_IS_EMAIL_PRESENT = "isEmailPresent";
	public static final String XSL_EMAIL_ENDTS = "emailEndTS";
	public static final String XSL_EMAIL_LASTUPDATEDTS = "emailLastUpdatedTS";
	public static final String XSL_EMAILADDRESS_LASTUPDATEDTS = "emailAddressLastUpdatedTS";
	public static final String XSL_EMAIL_ADDRESS = "emailAddress";

	// Mailing Address
	public static final String XSL_IS_MAILINGADDRESS_CHANGED = "isMailingAddressChanged";
	public static final String XSL_IS_MAILINGADDRESS_PRESENT = "isMailingAddressPresent";
	public static final String XSL_MAILINGADDRESS_PARTYLOC = "mailingAddressPartyLocationID";
	public static final String XSL_MAILINGADDRESS_LASTUPDATEDTS = "mailingAddressLastUpdatedTS";
	public static final String XSL_MAILINGADDRESS_ARGLOC_LASTUPDATEDTS = "mailingAddressLocLastUpdatedTS";
	public static final String XSL_MAILINGADDRESS_LINEONE = "mailingAddressLineOne";
	public static final String XSL_MAILINGADDRESS_LINETWO = "mailingAddressLineTwo";
	public static final String XSL_MAILINGADDRESS_LOCALITY = "mailingAddressLocality";
	public static final String XSL_MAILINGADDRESS_AREA = "mailingAddressArea";
	public static final String XSL_MAILINGADDRESS_COUNTRY = "mailingAddressCountry";
	public static final String XSL_MAILINGADDRESS_POSTALCODE = "mailingAddressPostalCode";
	
	// Physical Address
	public static final String XSL_IS_PHYSICALADDRESS_CHANGED = "isPhysicalAddressChanged";
	public static final String XSL_IS_PHYSICALADDRESS_PRESENT = "isPhysicalAddressPresent";
	public static final String XSL_PHYSICALADDRESS_PARTYLOCID = "physicalAddressPartyLocationID";
	public static final String XSL_PHYSICALADDRESS_PARTYLOC_LASTUPDATEDTS = "physicalAddressPartyLocationLastUpdatedTS";
	public static final String XSL_PHYSICALADDRESS_PARTYLOC_ADDR_LASTUPDATEDTS = "physicalAddressPartyLocationAddrLastUpdatedTS";
	public static final String XSL_PHYSICALADDRESS_ENDTS = "physicalAddressEndTS";
	public static final String XSL_PHYSICALADDRESS_ENDTS_NEEDED = "isPhysicalAddressEndTSNeeded";
	public static final String XSL_PHYSICALADDRESS_LINEONE = "physicalAddressLineOne";
	public static final String XSL_PHYSICALADDRESS_LOCALITY = "physicalAddressLocality";
	public static final String XSL_PHYSICALADDRESS_AREA = "physicalAddressArea";
	public static final String XSL_PHYSICALADDRESS_COUNTRY = "physicalAddressCountry";
	public static final String XSL_PHYSICALADDRESS_POSTALCODE = "physicalAddressPostalCode";
	
	// Employment
	public static final String XSL_IS_EMPLOYMENT_CHANGED = "isEmploymentChanged";
	public static final String XSL_IS_EMPLOYMENT_PRESENT = "isEmploymentPresent";
	public static final String XSL_EMPLOYMENT_PRIMARYINCOME_ID = "employmentPrimaryIncomeId";
	public static final String XSL_EMPLOYMENT_PRIMARYINCOME = "employmentPrimaryIncome";
	public static final String XSL_EMPLOYMENT_POSITION = "employmentPosition";
	public static final String XSL_EMPLOYMENT_OCCUPATION = "employmentOccupation";
	public static final String XSL_EMPLOYMENT_NATUREOFBUSINESS = "employmentNatureOfBusiness";
	public static final String XSL_EMPLOYMENT_ID = "employmentId";
	public static final String XSL_EMPLOYMENT_STATUS = "employmentStatus";
	public static final String XSL_EMPLOYMENT_EMPLOYERNAME = "employmentEmployerName";
	public static final String XSL_EMPLOYMENT_ADDRESS_LINEONE = "employmentAddressLineOne";
	public static final String XSL_EMPLOYMENT_ADDRESS_LOCALITY = "employmentAddressLocality";
	public static final String XSL_EMPLOYMENT_ADDRESS_AREA = "employmentAddressArea";
	public static final String XSL_EMPLOYMENT_ADDRESS_COUNTRY = "employmentAddressCountry";
	public static final String XSL_EMPLOYMENT_ADDRESS_POSTALCODE = "employmentAddressPostalCode";
	public static final String XSL_EMPLOYMENT_PHONE = "employmentPhone";
	public static final String XSL_EMPLOYMENT_PHONE_CHANGED = "employmentPhoneChanged";
	public static final String XSL_EMPLOYMENT_STARTTS = "employmentStartTS";
	public static final String XSL_EMPLOYMENT_LASTUPDATEDTS = "employmentLastUpdatedTS";
	public static final String XSL_EMPLOYMENT_PRIMARYINCOME_LASTUPDATEDTS = "employmentPrimaryIncomeLastUpdatedTS";
	public static final String XSL_IS_PRIMARYINCOME_CHANGED = "isPrimaryIncomeChanged";
	public static final String XSL_IS_PRIMARYINCOME_PRESENT = "isPrimaryIncomePresent";

	// Other Income
	public static final String XSL_IS_OTHERINCOME_CHANGED = "isOtherIncomeChanged";
	public static final String XSL_IS_OTHERINCOME_PRESENT = "isOtherIncomePresent";
	public static final String XSL_OTHERINCOME_LASTUPDATEDTS = "otherIncomeLastUpdatedTS";
	public static final String XSL_OTHERINCOME_ID = "otherIncomeId";
	public static final String XSL_OTHERINCOME_VALUE = "otherIncomeValue";
	public static final String XSL_OTHERINCOME_SOURCE = "otherIncomeSource";
	public static final String XSL_OTHERINCOME_ENDTS = "otherIncomeEndTS";
	
	// Gross Income
	public static final String XSL_IS_GROSSINCOME_CHANGED = "isGrossIncomeChanged";
	public static final String XSL_IS_GROSSINCOME_PRESENT = "isGrossIncomePresent";
	public static final String XSL_GROSSINCOME_LASTUPDATEDTS = "grossIncomeLastUpdatedTS";
	public static final String XSL_GROSSINCOME_ID = "grossIncomeId";
	public static final String XSL_GROSSINCOME_VALUE = "grossIncomeValue";

	
	public static final String DATE_FMT = "yyyy-MM-dd'T'HH:mm:ss";
	
	public static final String XSL_ROLE_CODE_PRIMARY = "PRIMARY-ACCOUNT-HOLDER";
	public static final String XSL_ROLE_CODE_AUTHORIZED = "AUTHORIZED-USER"; 
	public static final String XSL_SOURCE_SYSTEM_TYPE_VALUE = "TS2M";
	public static final String XSL_GROUP_NAME = "MBNA";
	
	public final static String MARKETING_OFFERS = "MARKETING-SOLICITATION";
	public static final String ACTION_TYPE_CD = "ActionTypeCD";
	public static final String ACTION_TYPE_DESC = "ActionTypeDesc";
	public static final String PREFERENCE_TYPE_CD = "PreferenceTypeCD";
	public static final String PREFERENCE_TYPE_DESC = "PreferenceTypeDesc";
	public static final String PREFERENCE_TYPE_DESC_VALUE = "email";
	public static final String REASON_CD = "ReasonTypeCD";
	public static final String REASON_CD_VALUE_ON = "OPTED-IN";
	public static final String REASON_CD_VALUE_OFF = "CUSTOMER-REQUEST-NO-SOLICITATION";
	public static final String APPLICATION_PLATFOMR_CD = "InitiatingApplicationPlatformCD";
	public static final String APPLICATION_PLATFORM_CD_VALUE = "LOYALTY";	
	public final static String EMAIL = "Email";
	public final static String EMPTY = "";
	public static final String SPACE = " ";
	public static final String CONFIRM_KYC = "Confirm KYC";  
	public static final String ERROR_UPDATE_CONFLICT = "The field value has been changed by another program";
	public final static String XSL_PERSON_LASTUPDATEDTS = "personLastUpdatedTS";
	public final static String XSL_BOOK_OF_BUSINESS_LASTUPDATEDTS = "bookOfBusinessLastUpdatedTS";
	public final static String XSL_PARTYAGREEMENT_LASTUPDATEDTS = "partyAgreementLastUpdatedTS";

	public static final String XSL_IS_EMPLOYMENT_INFO_CHANGED = "isEmploymentInfoChanged";
	public static final String XSL_IS_EMPLOYMENT_NAME_CHANGED = "isEmploymentNameChanged";
	public final static String XSL_START_DATE = "startDt";
	public static final String START_DATE_FMT = "yyyy-MM-dd";
	
	// KYC date
	public final static String XSL_KYC_LAST_UPDATE_DATE = "kycDate";
	public static final String KYC_DATE_FMT = "yyyy-MM-dd";

	public static void setValues(CustAcctType src, CustAcctType tgt) {
		copyValues(src, tgt);
	}
	
	public static void setValues(CustomerAcctType src, CustAcctType tgt) {
		copyValues(src, tgt);
	}
	public static void setValues(CardHolderType src, CardHolderType tgt) {
		copyValues(src, tgt);
	}

	
	public static List<CustAcctType> downConvert(List<CustomerAcctType> acctsWithDetails) {
		// CustomerAcctType is used in our converted ODS retrieved response;
		// however, UI only needs info in CustAcctType (CustomerAcctType's base class)
		// so convert to this base class to reduce traffic between UI and MT
		List<CustAcctType> rc = new ArrayList<CustAcctType>(acctsWithDetails.size());
		for (CustomerAcctType acctWithDetails : acctsWithDetails) {
			CustAcctType acct = new CustAcctType();
			copyValues(acctWithDetails, acct);
			rc.add(acct);
		}
		return rc;
	}
	
	public static void setCardHolderDetails(CustomerInfoType src, CardHolderType tgt) {
		UserNameType custName = null;
		if(src != null){
			tgt.setLanguageCode(src.getLanguagePref());
			tgt.setBirthDate(src.getBirthDate());
			tgt.setLegalNameLastUpdatedTS(src.getLegalNameLastUpdatedTS());
			custName = src.getName();
		}
		if (custName != null) {
			tgt.setFirstName(custName.getFirstName());
			tgt.setMiddleName(custName.getMiddleName());
			tgt.setLastName(custName.getLastName());
			tgt.setSuffixCd(custName.getSuffix());
		}
	}

    public static void formatForUI(CustomerAcctInfoType payload) {
    	if(payload == null){
    		return;
    	}
    	payload.setBusinessPhone(payload.getBusinessPhone());
    	payload.setHomePhone(payload.getHomePhone());
    	payload.setMobilePhone(payload.getMobilePhone());
    }
	
    public static void formatForUI(RetrieveCustomerProfileResponse res) {
    	if(res == null){
    		return;
    	}
    	RetrieveCustomerProfileResponse.ResponsePayload payload = res.getResponsePayload();
    	if(payload == null){
    		return;
    	}
    	payload.setBusinessPhone(payload.getBusinessPhone());
    	payload.setHomePhone(payload.getHomePhone());
    	payload.setMobilePhone(payload.getMobilePhone());
    }
    
    
    public static CustomerAcctProfileType convert(RetrieveCustomerProfileResponse src)  {
		formatForUI(src);
    	CustomerAcctProfileType rc = new CustomerAcctProfileType();
    	rc.setCustInfo(new CustomerInfoType());
    	rc.setAcctInfo(new CustomerAcctInfoType());
    	if(src != null){
    		RetrieveCustomerProfileResponse.ResponsePayload flatPayload = src.getResponsePayload();
    		copyValues(flatPayload, rc.getCustInfo());
    		copyValues(flatPayload, rc.getAcctInfo());
    	}
    	return rc;
    }

    /**
     * converting CustomerAcctProfileType(Midtier type) to RetrieveCustomerProfileResponse
     * @param src CustomerAcctProfileType
     * @return
     */
    public static RetrieveCustomerProfileResponse convert(CustomerAcctProfileType src) {
    	RetrieveCustomerProfileResponse rc = new RetrieveCustomerProfileResponse();
    	RetrieveCustomerProfileResponse.ResponsePayload rcPL = new RetrieveCustomerProfileResponse.ResponsePayload();
    	rc.setResponsePayload(rcPL);
    	if(src != null){
    		copyValues(src.getCustInfo(), rcPL);
    		copyValues(src.getAcctInfo(), rcPL);
    	}
		formatForUI(rc);
		return rc;
    }

	public static UpdateCustomerProfileResponse convertForUpdate(CustomerProfileType src) {
    	UpdateCustomerProfileResponse rc = new UpdateCustomerProfileResponse();
    	UpdateCustomerProfileResponse.ResponsePayload rcPL = new UpdateCustomerProfileResponse.ResponsePayload();
    	if(src != null){
    		copyValues(src.getCustInfo(), rcPL);
    		if (src.getAccounts().size() > 0) {
    			formatForUI(src.getAccounts().get(0).getCardHolderAcctInfo());
    			copyValues(src.getAccounts().get(0).getCardHolderAcctInfo(), rcPL);
    		}
    	}
    	rc.setResponsePayload(rcPL);
		return rc;
    }

    public static CustomerAcctProfileType genCustAcctProfile(CustomerProfileType custProf, String acctNum) {
    	CustomerAcctProfileType rc = new CustomerAcctProfileType();
    	if(custProf != null){
    		rc.setCustInfo(custProf.getCustInfo());
    	}
    	rc.setAcctInfo(findCustAcctInfoFromProfile(custProf, acctNum));
    	formatForUI(rc.getAcctInfo());
    	return rc;
    }

    public static CustomerAcctType findCustAcctFromProfile(CustomerProfileType custProf, String acctNum) {
    	CustomerAcctType rc = null;
    	if(custProf  == null || acctNum == null){
    		return rc;
    	}
    	List<CustomerAcctType> accounts = custProf.getAccounts();
    	if(accounts == null){
    		return rc;
    	}
    	for (CustomerAcctType account : accounts) {
    		if(account == null || account.getAcctNum() == null){
    			continue;
    		}
    		if (account.getAcctNum().equals(acctNum)) {
    			rc = account;   			    			
    			break;
    		}
    	}
    	return rc;
    }
    
    public static CustomerAcctInfoType findCustAcctInfoFromProfile(CustomerProfileType custProf, String acctNum) {
    	CustomerAcctInfoType rc = null;
    	if(custProf  == null || acctNum == null){
    		return rc;
    	}
    	List<CustomerAcctType> accounts = custProf.getAccounts();
    	if(accounts == null){
    		return rc;
    	}
    	for (CustomerAcctType account : accounts) {
    		if(account == null || account.getAcctNum() == null){
    			continue;
    		}
    		if (account.getAcctNum().equals(acctNum)) {
    			rc = account.getCardHolderAcctInfo();
    			break;
    		}
    	}
    	return rc;
    }
    
	public static CustomerAcctProfileType findOtherUserAcctProfile(CustomerAcctType custAcct, String custId) {
		CustomerAcctProfileType rc = null;
		
		if(custAcct  == null || custId == null || custAcct.getOtherAcctProfiles() == null){
			return rc;
		}
		
		for (CustomerAcctProfileType custAcctProf : custAcct.getOtherAcctProfiles()) {
			if(custAcctProf == null || custAcctProf.getAcctInfo() == null || custAcctProf.getAcctInfo().getCustId() == null){
				continue;
			}
			if (custAcctProf.getAcctInfo().getCustId().equals(custId)) {
				rc = custAcctProf;								
				break;
			}
		}
		return rc;
	}

	public static void marshalAddresses(CustomerInfoType custProf, CustomerAcctInfoType custAcctInfo) {
		// Note: this function assumes XSL normalize-space have been applied to all physical & mailing address fields
		if(custProf == null || custAcctInfo == null){
			return;
		}
		String physicalAddrLine1 = custProf.getPhysicalAddressLine1();
		boolean physicalAddrExists = physicalAddrLine1 != null 
										&& physicalAddrLine1.length() > 0 
										&& custProf.getPhysicalCity() != null 
										&& custProf.getPhysicalProvince() != null 
										&& custProf.getPhysicalPostalCode() != null ;
		if (physicalAddrExists) {
			String mailingAddrLine1 = custAcctInfo.getMailingAddressLine1();
			boolean mailingAddrExists = mailingAddrLine1 != null 
											&& mailingAddrLine1.length() > 0 
											&& custAcctInfo.getMailingCity() != null 
											&& custAcctInfo.getMailingProvince() != null 
											&& custAcctInfo.getMailingPostalCode() != null;
			if (mailingAddrExists) {
				if (normalizeSpace(mailingAddrLine1).equalsIgnoreCase(normalizeSpace(physicalAddrLine1)) == false
				 || normalizeSpace(custAcctInfo.getMailingCity()).equalsIgnoreCase(normalizeSpace(custProf.getPhysicalCity())) == false
				 || normalizeSpace(custAcctInfo.getMailingProvince()).equalsIgnoreCase(normalizeSpace(custProf.getPhysicalProvince())) == false
				 || normalizeSpace(custAcctInfo.getMailingPostalCode()).equalsIgnoreCase(normalizeSpace(custProf.getPhysicalPostalCode())) == false){
					
					custAcctInfo.setDifferentPhysicalAddress(true);
				}
			}
		}
	}
    
	public static AcctContactInfoType mapToContactInfoType(CustomerAcctProfileType response) {
		return mapToContactInfoType(convert(response));
	}
    
	public static AcctContactInfoType mapToContactInfoType(RetrieveCustomerProfileResponse response) {
		AcctContactInfoType rc = new AcctContactInfoType();
		if(response == null){
			return rc;
		}
		RetrieveCustomerProfileResponse.ResponsePayload payload = response.getResponsePayload();
		if(payload == null){
			return rc;
		}
		rc.setEmailAddr(payload.getEmail());
		
		if (payload.getBusinessPhone() != null && payload.getBusinessPhone().trim().length() > 0) {
			PhoneNumber phoneNum = new PhoneNumber();
			String mdmPhoneNum = payload.getBusinessPhone().trim();
			phoneNum.setPhoneNumber(mdmPhoneNum);
			phoneNum.setPhoneType("Business");
			rc.setBusinessPhoneNum(phoneNum);
		}
		if (payload.getHomePhone() != null && payload.getHomePhone().trim().length() > 0) {
			PhoneNumber phoneNum2 = new PhoneNumber();
			String mdmPhoneNum = payload.getHomePhone().trim();;
			phoneNum2.setPhoneNumber(mdmPhoneNum);
			phoneNum2.setPhoneType("Home");
			rc.setHomePhoneNum(phoneNum2);
		}
		if (payload.getMobilePhone() != null && payload.getMobilePhone().trim().length() > 0) {
			PhoneNumber phoneNum3 = new PhoneNumber();
			String mdmPhoneNum = payload.getMobilePhone().trim();;
			phoneNum3.setPhoneNumber(mdmPhoneNum);
			phoneNum3.setPhoneType("Mobile");
			rc.setMobilePhoneNum(phoneNum3);
		}
		if (payload.getMailingAddressLine1() != null && payload.getMailingAddressLine1().trim().length() > 0) {
			UnformattedAddress mAddr = new UnformattedAddress();
			rc.setMailingAddress(mAddr);
			mAddr.setAddrLine1(payload.getMailingAddressLine1());
			mAddr.setAddrLine2(payload.getMailingAddressLine2());
			mAddr.setCity(payload.getMailingCity());
			mAddr.setProvince(payload.getMailingProvince());
			mAddr.setPostalCode(payload.getMailingPostalCode());
			mAddr.setLastUpdatedTS(payload.getMailingLastUpdatedTS());
		}
		if (payload.getPhysicalAddressLine1() != null && payload.getPhysicalAddressLine1().trim().length() > 0) {
			UnformattedAddress pAddr = new UnformattedAddress();
			rc.setPhysicalAddress(pAddr);
			pAddr.setAddrLine1(payload.getPhysicalAddressLine1());
			pAddr.setCity(payload.getPhysicalCity());
			pAddr.setProvince(payload.getPhysicalProvince());
			pAddr.setPostalCode(payload.getPhysicalPostalCode());
			pAddr.setLastUpdatedTS(payload.getPhysicalLastUpdatedTS());
		}
		
		// if both mailing address & physical address exist, check if they are the same
		// if yes, set the sameas flag on
		rc.setPhysicalAddressSameAsMailing(payload.isDifferentPhysicalAddress() == false);
		return rc;
	}

//    private static String formatPhoneNumberForUI(String mdmPhoneNum) {
//    	/*
//    	String uiPhoneNum = mdmPhoneNum;    	
//    	if (mdmPhoneNum != null && mdmPhoneNum.startsWith("1-")) {
//    		uiPhoneNum = mdmPhoneNum.substring(2);
//    	}
//    	
//    	return uiPhoneNum;
//    	*/
//    	// Since UI requires the "1-" to determine whether it is international number, mid-tier will not format phone anymore.
//    	return mdmPhoneNum;
//    }
    
	private static void copyValues(Object src, Object tgt) {
		try {
			BeanUtilsBean bub = new BeanUtilsBean();
			bub.getPropertyUtils().addBeanIntrospector(SuppressPropertiesBeanIntrospector.SUPPRESS_CLASS);
			bub.copyProperties(tgt, src);
		}
		catch (Exception e) {
			throw com.td.mbna.msec.midtier.util.ExceptionUtil.genRuntimeException(e);
		}
	}

	
	static public boolean compareUpdateTS(XMLGregorianCalendar oriUpdateTS, XMLGregorianCalendar curUpdateTS) {
		
    	if (oriUpdateTS == null && curUpdateTS == null) {
    		return true;    			
    	}
    	if (oriUpdateTS == null && curUpdateTS != null) {
    		return false;
    	}
    	if (oriUpdateTS != null && curUpdateTS == null) {
    		return false;
    	}
    	
    	return (oriUpdateTS.compare(curUpdateTS) == 0);
    }

	static public boolean compareUpdateTS(Long oriUpdateTS, XMLGregorianCalendar curUpdateTS) {
		if (oriUpdateTS == null && curUpdateTS == null) {
			return true;
		}
		if (oriUpdateTS == null && curUpdateTS != null) {
			return false;
		}
		if (oriUpdateTS != null && curUpdateTS == null) {
			return false;
		}
		return (JAXBJsonConverter.convert(oriUpdateTS).compare(curUpdateTS) == 0);
	}

	
	static public boolean compareField(String str1, String str2)
    {
    	// null and empty string is the same.
    	String trimStr1 = (str1 == null) ? null : (str1.trim().length() == 0) ? null : str1.trim();
    	String trimStr2 = (str2 == null) ? null : (str2.trim().length() == 0) ? null : str2.trim();
    	
    	if(trimStr1 == null && trimStr2 == null){
    		return true;
    	}
    	if(trimStr1 == null && trimStr2 != null){
    		return false;
    	}
    	if(trimStr1 != null && trimStr2 == null){
    		return false;
    	}
    	
    	return trimStr1.equalsIgnoreCase(trimStr2);
    }

    static public boolean compareField(BigDecimal arg1, BigDecimal arg2) 
    {	 
    	
    	String str1 = (arg1 == null) ? null :  arg1.setScale(2, RoundingMode.DOWN).toPlainString();
    	String str2 = (arg2 == null) ? null :  arg2.setScale(2, RoundingMode.DOWN).toPlainString();
    	return compareField(str1, str2);
    } 
    
	/**
	 * Create an XMLGregorianCalendar for the current Date/Time
	 * @return XMLGregorianCalendar
	 * @throws DatatypeConfigurationException
	 */
	public static XMLGregorianCalendar getXMLGregorianCalendarNow(){
		GregorianCalendar gcal = new GregorianCalendar();
		XMLGregorianCalendar xgcal = null;
		try {
			xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
		} catch (DatatypeConfigurationException e) {
			throw com.td.mbna.msec.midtier.util.ExceptionUtil.genRuntimeException(e);
		}
		return xgcal;
	}
	
	/**
	 * Create an XMLGregorianCalendar for the current Date/Time
	 * @return XMLGregorianCalendar
	 * @throws DatatypeConfigurationException
	 */
	public static XMLGregorianCalendar getXMLGregorianCalendarNowForDate(){
		GregorianCalendar gcal = new GregorianCalendar();
		XMLGregorianCalendar xgcal = null;
		try {
			xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(gcal.get(Calendar.YEAR), gcal.get(Calendar.MONTH) + 1, gcal.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
		} catch (DatatypeConfigurationException e) {
			throw ExceptionUtil.genRuntimeException(e);
		}
		return xgcal;
	}
	
	public static BigDecimal getYearlyIncome(BigDecimal income, String incomeFrequency) {
		if(income != null){
			income = IncomeUtil.convertIncome(incomeFrequency, income);
		} else {
			income = BigDecimal.valueOf(0.0);
		}
		return income;
	}
	
	public static List<CustAcctType> getLogonKycList(CustomerProfileType custProf, List<CustAcctType> allAccts, CustEligType custElig, boolean enforceKYC) {
		List<CustAcctType> logonKycList = new ArrayList<CustAcctType>(allAccts.size());
		if(custElig == null || allAccts == null){
			return logonKycList;
		}
		List<AcctEligType> acctsElig = custElig.getAcctsElig();
		for (CustAcctType acct : allAccts) {
			if(acct == null 
					|| acct.getCardHolder() == null 
					|| !acct.getCardHolder().isPrimaryUser() 
					|| acctsElig == null){
				continue;
			}

			String acctNum = acct.getAcctNum();
			for (AcctEligType acctElig : acctsElig) {
				if(acctElig == null || acctNum == null){
					continue;
				}
				boolean isKycRefresh = EligibilityUtil.isAllowed(acctElig.getAcctElig(),EligIdType.KYC_REFRESH);
				boolean  isEform = EligibilityUtil.isAllowed(acctElig.getAcctElig(),EligIdType.STANDARD_E_FORMS);
				if (acctElig.getAcctId().equals(acctNum) && (isKycRefresh || (enforceKYC && isEform))) {
					logonKycList.add(acct);
				}
			}
		}
		return logonKycList;
	}

	public final static int KYC_UPDATE_PERIOD = ConfigUtil.getKycUpdatePeriod(); // number of days before KYC has to be done again.
	public static List<CustAcctType> getCliKycList(CustomerProfileType custProf, List<CustAcctType> allAccts, CustEligType custElig) {
		if(custProf == null || custProf.getCustInfo() == null || custElig == null || allAccts == null){
			return null;
		}
		XMLGregorianCalendar lastKycDate = custProf.getCustInfo().getLastKYCUpdate();
		
		List<AcctEligType> acctsElig = custElig.getAcctsElig();
		List<CustAcctType> cliKycList = new ArrayList<CustAcctType>(allAccts.size());
		for (CustAcctType acct : allAccts) {
			if(acct == null 
					|| acct.getCardHolder() == null 
					|| !acct.getCardHolder().isPrimaryUser()
					|| acctsElig == null){
				continue;
			}
	
			String acctNum = acct.getAcctNum();
			for (AcctEligType acctElig : acctsElig) {
				if (acctElig.getAcctId().equals(acctNum) && EligibilityUtil.isAllowed(acctElig.getAcctElig(), EligIdType.CREDIT_LINE_INCREASE)
						&& DateUtil.isDateWithinDays(lastKycDate, KYC_UPDATE_PERIOD, false) == false) {
					cliKycList.add(acct);
				}
			}
		}
		return cliKycList;
	}
	
	public static String formatCustomerNotesPhoneNum(String inPhoneNum) {
    	if (inPhoneNum == null){
    		return "";
    	}
    	String notesPhoneNum = inPhoneNum;    	
    	if (inPhoneNum.startsWith("1-")) {
    		notesPhoneNum = inPhoneNum.substring(2);
    	}
    	return notesPhoneNum;
    }
    
    public static String formatCustomerNotesPostalCode(String inPostalCode) {
    	if (inPostalCode == null){
    		return "";
    	}
    	String outPostalCode = inPostalCode;
    	if (inPostalCode.length() == 6) {
    		StringBuilder sb = new StringBuilder(7);
    		sb.append(inPostalCode.substring(0,3)).append(SPACE).append(inPostalCode.substring(3));
    		outPostalCode = sb.toString();
    	}
    	return outPostalCode;
    }
     
    public static String formatCustomerNotesIncome(BigDecimal income) {
    	if (income == null || income.equals(BigDecimal.ZERO)){
    		return "";
    	}
		NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
		return moneyFormatter.format(income);
    }
    
    public static String getOccupationDescription(String occKey) {
    	if (occKey == null) {
    		return "";
    	}
    	return MBNAPropertiesUtil.getMBNADescriptionForMDMKey(occKey,"occupation.", ".key");
    }
    
    public static String formatCustomerNoteCommon(String inCustomerNoteCommon){
    	if(inCustomerNoteCommon == null){
    		return "";
    	}
    	return inCustomerNoteCommon;
    }
    

    	
	private final static int OdsAddressLineLimit = 40;

	/**
	 * DO NOT REMOVE IT, it is used in /resourecs/xsl/odsCreateCustomerAccountRelationshipRq.xsl
	 * @param addrLine
	 * @return
	 */
	public static String[] splitAddressLine(String addrLine) {
		if (addrLine == null) {
			return new String[2];
		}
		String[] rc;
		if ((rc = splitAddressLineRaw(addrLine)) == null) { // try to split the original, unaltered address line
			addrLine = normalizeSpace(addrLine); // remove leading &trailing blanks, and collapse multiple spaces into one, and try again
			if ((rc = splitAddressLineRaw(addrLine)) == null) {
				addrLine = removeSpaceBeforeComma(addrLine); // remove space before comma and try again.
				if ((rc = splitAddressLineRaw(addrLine)) == null) {
					addrLine = removeSpaceAfterComma(addrLine); // remove space after comma and try again.
					if ((rc = splitAddressLineRaw(addrLine)) == null) {
						rc = new String[2];
						rc[0] = addrLine.substring(0, OdsAddressLineLimit);
						rc[1] = addrLine.substring(OdsAddressLineLimit, addrLine.length());

					}
				}
			}
		}
		return rc;
	}
	
	private static String[] splitAddressLineRaw(String addrLine) {
		final int addrLineLen = addrLine.length(); 
		if (addrLineLen > OdsAddressLineLimit*2) { // impossible to split into two address lines <= 40 chars in length
			log("Address line \"" + addrLine + "\" is longer than " + (OdsAddressLineLimit*2) + " characters");
			return null;
		}
		String addrLine1 = null, addrLine2 = null;
		if (addrLineLen > OdsAddressLineLimit) {
			for (int i = OdsAddressLineLimit-1; i >= 0; i--) {
				char c = addrLine.charAt(i);
				if (c == ' ' || c == ',') {	// Found logical delimiter ' ' or ',' char. Split the lines here.
					int addrLine1Len = i+1;
					int addrLine2Len = addrLineLen - addrLine1Len; 
					if (addrLine2Len > OdsAddressLineLimit) {
						log("Failed to split address line \"" + addrLine + "\" into two lines each with " + OdsAddressLineLimit + " chars or less.");
						return null;
					}
					addrLine1 = addrLine.substring(0, addrLine1Len);
					addrLine2 = addrLine.substring(addrLine1Len);
					break;
				}
			}
			if (addrLine1 == null) {
				log("Failed to split address line \"" + addrLine + "\" into two lines because delimiter ' ' or ',' not found.");
				return null;
			}
		}
		else {
			addrLine1 = addrLine;
		}
		return new String[] {addrLine1, addrLine2};
	}
	
	/**
	 * Returns the argument string with the leading, trailing, and repeating white spaces stripped.
	 * Essentially same functionality as XSL normalize-space() method
	 * @param s
	 * @return
	 */
	public static String normalizeSpace(String s) {
		if (s!=null) {
			return s.trim().replaceAll(" +", " ");
		}
		
		return s;
	}

	// Returns the argument string with all spaces before a comma removed.
	private static String removeSpaceBeforeComma(String s) {
		return s.replaceAll(" +,", ",").replaceAll(", +", ",");
	}
	
	// Returns the argument string with all spaces after a comma removed.
	private static String removeSpaceAfterComma(String s) {
		return s.replaceAll(", +", ",");
	}
	
	private static void log(String s) {
		logger.info(s);
	}
	/**
	 * DO NOT REMOVE IT, it is used in /resourecs/xsl/odsCreateCustomerAccountRelationshipRq.xsl
	 * @param splitAddrLines
	 * @return
	 */
	public static String getSplitAddressLine1(String[] splitAddrLines) {
		return normalizeSpace(splitAddrLines[0]);
	}

	/**
	 * DO NOT REMOVE IT, it is used in /resourecs/xsl/odsCreateCustomerAccountRelationshipRq.xsl
	 * @param splitAddrLines
	 * @return
	 */
	public static String getSplitAddressLine2(String[] splitAddrLines) {
		return normalizeSpace(splitAddrLines[1]);
	}
}
