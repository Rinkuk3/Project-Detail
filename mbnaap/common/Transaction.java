package com.td.api.mbnaap.common;

import lombok.Data;

@Data
public class Transaction {

    private CreditCardAgreementAltkey creditCardAgreementAltkey;
    private String transactionId;
    private String statusCd;
    private String transactionDt;
    private Double transactionAmt; 

}