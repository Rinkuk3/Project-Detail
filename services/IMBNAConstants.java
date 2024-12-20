/**
 * 
 */
package com.td.mbna.msec.midtier.services;

/**
 * @author Jasvinder Singh
 *
 */
public interface IMBNAConstants {
	
	// Values for language
	// English
	public static final String LANG_ENGLISH = "English";
	// French
	public static final String LANG_FRENCH = "French";
	
	// English locale
	public static final String ENGLISH_LOCALE ="en_CA";
	// French locale
	public static final String FRENCH_LOCALE ="fr_CA";
	
	// Values for statementDeliveryPreferenceSelected
	// paperless
	public static final String DELIVERY_ONLINE = "Opt-in of eStatements";
	
	public static final String ESTATEMENT_OPT_IN = "OptIneStatement";
	// paper
	public static final String DELIVERY_PAPER = "Opt-out of eStatements";
	
	public static final String ESTATEMENT_OPT_OUT = "OptOuteStatement";
	
	// Card holder types
	// principal English
	public static final String USER_PRINCIPAL = "Principal Card Holder";
	// principal French
	public static final String USER_PRINCIPAL_FRENCH = "Titulaire principal de la carte";
	// authorized English
	public static final String USER_AUTHORIZED = "Authorized User";
	// authorized French
	public static final String USER_AUTHORIZED_FRENCH = "Utilisateurs autoris�s";
			
	// Template ID's and Template Names for EmailNotification
	
	// id for card activated
	public static final String BUSINESSEVENT_ID_ACTIVATECARDREQUEST = "CardActivated";
	
	//id for authorized user added
	public static final String BUSINESSEVENT_ID_ADDAUTHORIZEDUSERREQUEST = "AuthorizedUserAdded";

	// id for request cheques
	public static final String BUSINESSEVENT_ID_REQUESTCHEQUEREQUEST = "AccessCheque";

	// id for replace card
	public static final String BUSINESSEVENT_ID_REPLACECARDREQUEST = "CardReplaceRequest";

	// id for cld
	public static final String BUSINESSEVENT_ID_DECREASECARDLIMITREQUEST = "CreditLimitDecrease";

	// id for cli
	public static final String BUSINESSEVENT_ID_INCREASECARDLIMITREQUEST = "CreditLimitIncrease";

	// id for cli approved
	public static final String BUSINESSEVENT_ID_INCREASECARDLIMITREQUEST_OFFER = "CLIApproved";

	// id for statement delivery update
	public static final String BUSINESSEVENT_ID_UPDATESTATEMENTDELIVERYPREFERENCESREQUEST = "StatementPreference";
	
	// id for order hard copy statements
	public static final String BUSINESSEVENT_ID_ORDERHARDCOPYSTATEMENTSREQUEST = "StatementReprint";
	
	// id for update address
	public static final String BUSINESSEVENT_ID_UPDATECUSTOMER_ADDRESS_REQUEST = "AddressUpdate";
	
	// id for update phone
	public static final String BUSINESSEVENT_ID_UPDATECUSTOMER_PHONE_REQUEST = "PhoneUpdate";

	// id for update email
	public static final String BUSINESSEVENT_ID_UPDATECUSTOMER_EMAIL_REQUEST = "EmailAddressIpdate";
	
	// id for BT
	public static final String BUSINESSEVENT_ID_BALANCETRANSFERTOCREDITORREQUEST = "BalanceTransfer";

	// id for TTC
	public static final String BUSINESSEVENT_ID_DEPOSITTOCHECKINGREQUEST = "TransferToChequing";

	public static final String BUSINESSEVENT_ID_KYC_UPDATE_PROFILE_REQUEST = "KycUpdateProfile";

	public static final String BUSINESSEVENT_ID_BALANCE_PROTECTION_INSURANCE = "BalanceProtectionInsurance";

	public static final String BUSINESSEVENT_ID_IP_ENROLLMENT = "IpEnrollment";
	
	// Alert Type Codes
	public static final String ALERT_TYPE_CD_BALANCETRANSFER = "MBNA_INTEG_BALANCETRANSFER";
	public static final String ALERT_TYPE_CD_ESTATEMENT = "MBNA_INTEG_ESTATEMENT";
	public static final String ALERT_TYPE_CD_IPENROLLMENT = "MBNA_INTEG_IPENROLLMENT";
	public static final String ALERT_TYPE_CD_PRODUCTCHANGE = "MBNA_INTEG_PRODUCTCHANGE";
	public static final String ALERT_TYPE_CD_SECUREGENERIC = "MBNA_INTEG_SECUREGENERIC";
}
