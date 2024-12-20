package com.td.mbna.msec.midtier.util.services;

import com.td.mbna.msec.midtier.util.ConfigUtil;

public final class MSECConstants {

	public static final long API_CACHE_EXPIRY = Long.parseLong(ConfigUtil.getProperty("mbna.api.cache.expiry", "30"));;
	public static final Boolean API_CACHE_ENABLED = Boolean.parseBoolean(ConfigUtil.getProperty("mbna.api.cache.enabled", "true"));
	public static final int API_CACHE_INITIAL = Integer.parseInt(ConfigUtil.getProperty("mbna.api.cache.initial", "1000"));
	public static final boolean CPAF_JSON_MOCK = Boolean.valueOf(ConfigUtil.getProperty("mbna.api.cache.enabled", "false"));
			
    public static final String CONSUMER_REFERENCE_PARAMETER = "ConsumerApplication.From.ReferenceParameters.wsOriginalConsumer";
    public static final String TD_CS_HEADER_WSA_AddressValue = "TD_CS_HEADER_WSA_AddressValue";
    public static final String CLIENT_APPLICATION_PLATFORM_HEADER = "client-application-platform-cd";
    public static final String CLIENT_APPLICATION_MSEC = "MSEC";
    public static final String CLIENT_APPLICATION_MBNA = "MBNA";
    public static final String UMP_DELIVERY_EXPRESS = "EXPRESS";
    public static final String ACCEPT_LANGUAGE_EN = "en-CA";
    public static final String CLEAR_CACHE = "cache";
    public static final String MESSAGE_ID_HEADER = "messageid";
    public static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
    public static final String CLEAR_SITE_DATA_HEADER = "Clear-Site-Data";
    public static final String TRACEABILITY_ID_HEADER = "traceabilityid";
    public static final String ORIGINATING_CHANNEL_NAME = "Originating-Channel-Name";
    public static final String DELIVERY_MODE_CD = "Delivery-Mode-Cd";
    public static final String FINANCIAL_INSTITUTION_INTERNAL_ORGANIZATION_ID_HEADER = "financial-institution-internal-organization-id";
    public static final String FINANCIAL_INSTITUTION_INTERNAL_ORGANIZATION_ID_VALUE = "MBNA";

    public static final String TD_REST_PROPERTY_FILEName = "TDRestServices.properties";
    public static final String TD_KEYMANAGEMENT_ENCRYPT_ENDPT = "TD_KEYMANAGEMENT_ENCRYPT_ENDPT";
    public static final String TD_KEYMANAGEMENT_DECRYPT_ENDPT = "TD_KEYMANAGEMENT_DECRYPT_ENDPT";
    public static final String TD_PAYEEMANAGEMENT_VALIDATE_PAYEE_ENDPT = "TD_PAYEEMANAGEMENT_VALIDATE_PAYEE_ENDPT";
    public static final String TD_VALET_API_ENDPT = "TD_VALET_API_ENDPT";
    public static final String TD_VALET_API_TRASH_ENDPT = "TD_VALET_API_TRASH_ENDPT";

    public static final String AUTHORIZATION = "Authorization";
    public static final String CONNECT_ID = "connectId";
    public static final String ENCODINGS_SCHEMA_TYPE= "HexBinary";

    public static final String ZPK_ALIAS = "zpkAlias";
    public static final String WTK_ALIAS = "wtkAlias";
    public static final String TSYSPinBlock = "TSYSPinBlock";

    public static final String PIN_Encryption_Key= "PIN Encryption Key";
    public static final String Zone_PIN_Key = "Zone PIN Key";
    public static final String Web_Transport_Key= "Web Transport Key";
    public static final String Hex_Binary = "HexBinary";

    public static final String SINGLE_USER_KEY = "singleUseKey";
    public static final String CDV = "cdv";
    public static final String PIN_BLOCK = "pinblock";
    public static final String STATUS_FAILED = "FAILED";
    public static final String STATUS_SUCCEED = "SUCCEED";

    public static final String TD_DM_API_ENDPT = "TD_DM_API_ENDPT";
    public static final String TD_DM_API_STATEMENT_FOLDER = "TD_DM_API_ENDPT_STATEMENT_FOLDER";
    public static final String TD_DM_API_INSERT_FOLDER = "TD_DM_API_ENDPT_INSERT_FOLDER";
    public static final String TD_DM_API_DOCUMENTS = "documents";
    public static final String TD_DM_API_QUERY = "query";
    public static final String TD_DM_API_ORDERBY = "orderBy";
    public static final String TD_DM_API_MAX_RESULTS = "maxResults";
    public static final String TD_DM_API_PORTAL = "portal";
    public static final String TD_DM_API_PORTAL_VALUE = "TD_DM_API_PORTAL";

    public static final String TD_REWARDS_BAL_API_ENDPT = "TD_REWARDS_BAL_API_ENDPT";
    public static final String TD_REWARDS_SAML_API_ENDPT = "TD_REWARDS_SAML_API_ENDPT";
    public static final String TD_REWARDS_SAML_BASE_AUTH = "TD_REWARDS_SAML_BASE_AUTH";
    
    public static final String TD_OFP_API_AGREEMENT_ID = "agreementId";
    public static final String TD_OFP_API_PARTY_ID = "partyId";
    public static final String TD_OFP_API_CREDIT_LIMIT = "creditLimit";
    public static final String TD_OFP_API_SOLICITATION_CHANNEL = "solicitationChannelTypeCd";
    public static final String TD_OFP_API_ACCESS_CHANNEL = "accessChannelTypeCd";
    
	public static final String INTERNET_SECURE = "INTERNET-SECURE";
    public static final String ONLINE_SECURE_SITE = "ONLINE-SECURE-SITE";

    public static final String TD_ALERT_EVENT_ENDPT = "TD_ALERT_EVENT_ENDPT";

    public static final String TD_OFP_API_ENDPT = "TD_OFP_API_ENDPT";
    public static final String TD_OFP_OFFERS_ENDPT = "TD_OFP_OFFERS_ENDPT";
    public static final String TD_OFP_CCA_ENDPT = "TD_OFP_CCA_ENDPT";
    public static final String TD_OFP_BT_ENDPT = "TD_OFP_BT_ENDPT";
    
    public static final String TD_OFM_API_ENDPT = "TD_OFM_API_ENDPT";
    public static final String TD_OFM_API_KEYTYPE = "c";
    public static final String TD_OFM_API_PARTIES = "parties";
    public static final String TD_OFM_API_FEATURES = "features";
    public static final String TD_OFM_API_SOLICIATIONCHANNELTYPECD = "solicitationChannelTypeCd";
    public static final String TD_OFM_API_ACCESSCHANNELTYPECD = "accessChannelTypeCd";

    public static final String TD_CAPD_ENDPT = "TD_CAPD_ENDPT";
    
    public static final String TD_MBADA_API_ENDPT = "TD_MBADA_API_ENDPT";
    public static final String TD_MBCCA_API_ENDPT = "TD_MBCCA_API_ENDPT";
    public static final String TD_ENROLLMENT_API_ENDPT = "TD_ENROLLMENT_API_ENDPT";
    public static final String MBCCA_CREDITAGREEMENT_ENDPOINT = TDRestServiceUtil.getTDServiceParam(TD_MBCCA_API_ENDPT)+"/creditcardagreements";
    public static final String MBCCA_INSURANCE_ENDPOINT = TDRestServiceUtil.getTDServiceParam(TD_MBCCA_API_ENDPT)+ "/insuranceagreements";

    public static final String TD_AP_API_ENDPT = "TD_AP_API_ENDPT";
    public static final String TD_AP_BRANCHES_ENDPT = "TD_AP_BRANCHES_ENDPT";
    public static final String TD_AP_API_CONSENT_ENDPT = "TD_AP_API_CONSENT_ENDPT";
    public static Boolean IS_PIN_CACHE_DISABLED = false;
    public static final int APAPI_VERIFYPAD_TIMEOUT = Integer.parseInt(ConfigUtil.getProperty("apapi.verifypad.timeout", "5000"));
    public static final String TD_CARD_CONTROL_API_ENDPT = "TD_CARD_CONTROL_API_ENDPT";
    public static final String TD_PARTY_API_ENDPT = "TD_PARTY_API_ENDPT";
    public static final boolean MOCK_PARTY_API_ERROR = Boolean.valueOf(ConfigUtil.getProperty("addaccount.mock.party.api.error", "false"));
    public static final boolean MOCK_MBCCA_API_ERROR = Boolean.valueOf(ConfigUtil.getProperty("addaccount.mock.mbcca.api.error", "false"));
    public static final boolean MOCK_ENROLLMENT_API_ERROR = Boolean.valueOf(ConfigUtil.getProperty("addaccount.mock.enrollment.api.error", "false"));
    public static final boolean MOCK_OFM_API_ERROR = Boolean.valueOf(ConfigUtil.getProperty("addaccount.mock.ofm.api.error", "false"));
    public static final boolean MOCK_MBADA_API_ERROR = Boolean.valueOf(ConfigUtil.getProperty("addaccount.mock.mbada.api.error", "false"));
}

