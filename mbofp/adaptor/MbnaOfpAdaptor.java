package com.td.mbna.msec.midtier.mbofp.adaptor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MbnaOfpAdaptor {
	protected static final String TYPECD_SOLD = "SOLD";
	protected static final String STANDARD_RATE_BT = "STANDARD_RATE_BT";
	protected static final String TYPECD_ACCOUNT = "a";
	protected static final String TYPE_CHEQUING = "CHEQUING";
	protected static final String TYPE_PEFT = "PEFT";
	protected static final String TYPE_CEFT = "CEFT";
	
	protected static final String PARAM_ROLECD = "roleCD";
	protected static final String PARAM_CUSTOMER_ID = "customerId";
	protected static final String PARAM_CARD_NO = "cardNumber";
	protected static final String PARAM_ACCT_ID = "acctId";
	protected static final String PARAM_LANG_PREF = "langPref";
	protected static final String PARAM_SUBPRODUCT_ID = "subProductId";
	protected static final String PARAM_FEETYPE = "feeType";
	protected static final String PARAM_AMOUNT = "amount";
	protected static final String PARAM_CARDNUM = "cardNum";
	protected static final String PARAM_PAYEE_CARDNUM = "payeeCardNum";
	protected static final String PARAM_PAYEE_BANKID = "payeeBankId";
	protected static final String PARAM_PAYEE_BANKNAME = "payeeBankName";
	protected static final String PARAM_PAYEE_ACCTNUM = "payeeAcctNum";
	protected static final String PARAM_PAYEE_BANKTRANSIT = "payeeBankTransit";
	protected static final String PARAM_MERCHANTID = "merchantId";
	protected static final String PARAM_PAYEE_NAME = "payeeName";
	protected static final String PARAM_FIRST_NAME = "firstName";
	protected static final String PARAM_LAST_NAME = "lastName";
	protected static final String PARAM_ADDRESSLINE1 = "addressLine1";
	protected static final String PARAM_ADDRESSLINE2 = "addressLine2";
	protected static final String PARAM_CITY = "city";
	protected static final String PARAM_POSTALCODE = "postalCode";
	protected static final String PARAM_PROVINCE = "province";

	protected static final String EVENT_REASON_CODE_PC = "PRODUCT-CHANGE-OFFER";

	protected static final String OFP_OFFER_TYPE_CLI = "CREDIT-LINE-INCREASE";
	protected static final String OFP_OFFER_TYPE_BT = "BALANCE-TRANSFER";
	protected static final String OFP_OFFER_TYPE_PC = "PRODUCT-CHANGE";
	protected static final String OFP_OFFER_TYPE_CA = "CASH-ADVANCE";
	protected static final String OFP_OFFER_TYPE_RT = "RETAIL";
	protected static final String OFP_OFFER_TYPE_CI = "CREDIT-INSURANCE";
	protected static final String OFP_OFFER_TYPE_IP = "INSTALLMENT-PLAN";
	protected static final String OFP_OFFER_TYPE_MPD = "OFFER-MESSAGE";

	
	public static final Map<String, String> offerTypeMap = Collections
			.unmodifiableMap(new HashMap<String, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(OFP_OFFER_TYPE_BT, "BalanceTransfer");
					put(OFP_OFFER_TYPE_CLI, "CreditLineIncrease");
					put(OFP_OFFER_TYPE_PC, "ProductChange");
					put(OFP_OFFER_TYPE_CA, "CashAdvance");
					put(OFP_OFFER_TYPE_RT, "Retail");
					put(OFP_OFFER_TYPE_CI, "BalanceProtection");
					put(OFP_OFFER_TYPE_IP, "InstallmentPlan");
					put(OFP_OFFER_TYPE_MPD, "MIN-PAY-OFFER");
				}
			});

}
