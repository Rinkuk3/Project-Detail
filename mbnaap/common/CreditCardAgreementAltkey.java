package com.td.api.mbnaap.common;
import lombok.Data;

/**
 * Credit card agreement alternate key.
 * 
 */
@Data
public class CreditCardAgreementAltkey {

    private String cardNum;
    private String cardNumMasked;
    private String accountNum;
    private String accountNumMasked;
    private String key;   
}