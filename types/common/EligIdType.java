package com.td.mbna.msec.midtier.types.common;

import java.util.HashMap;
import java.util.Map;
public enum EligIdType {
	
    BALANCE_TRANSFER("Balance Transfer"), // map this to the XML definition
    TRANSFER_TO_CHEQUING("Transfer to Chequing"),
    ORDER_ACCESS_CHEQUE("Order Access Cheque"),
    CREDIT_LINE_INCREASE("Credit Line Increase"),
    CREDIT_LINE_DECREASE("Credit Line Decrease"),
    PIN_MANAGEMENT("PIN Management"),
    CARD_ACTIVATION("Card Activation"),
    ACCOUNT_SUMMARY("Account Summary"),
    E_STATEMENT_DISPLAY("E-statement Display"),
    ENROLLMENT("Enrollment"),
    INSTALLMENT_PLAN("Installment Plan"), // new for IP. Not defined in the XML/SOAP ones
    VALUE_ADDED_OFFER("Value Added Offer"),
    PAPER_SUPPRESSION("Paper Suppression"),
    STANDARD_E_FORMS("Standard E-Forms"),
    ORDER_REPLACEMENT_CARD("Order Replacement Card"),
    KYC_REFRESH("KYC Refresh"),
    RE_OPEN_REQUEST("Re-Open Request"),
    CHAT("Chat"),
    PAPER_STATEMENTS("Paper Statements"),
    HARDCOPY_STATEMENTS("Hardcopy Statements"),
    ELECTRONIC_ACCESS_AGREEMENT("Electronic Access Agreement"),
    ELECTRONIC_ACCESS_AGREEMENT_FIRST_TIME("Electronic Access Agreement First Time");
    
    private final String value;
    private final static Map<String, EligIdType> CONSTANTS = new HashMap<String, EligIdType>();

    static {
        for (EligIdType c: values()) {
            CONSTANTS.put(c.value, c);
            CONSTANTS.put(c.name(), c); // this is required by json --> jaxb convertion
        }
    }

    private EligIdType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String value() {
        return this.value;
    }

    public static EligIdType fromValue(String value) {
        EligIdType constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
