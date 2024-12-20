package com.td.api.mbnaap.common;

import java.util.Date;

import lombok.Data;

/**
 * Allow deposit of money to an account from an account inside or outside of a financial institution.
 * 
 */
@Data
public class DirectCredit {
    
    private String statusCd;
    private Date statusStartDttm;
    private Date creationDttm;
    private InternalDirectCredit internalDirectCredit;
    
    private ExternalDirectCredit externalDirectCredit;
    
    private CreditCardAgreementAltkey creditCardAgreementAltkey;
    private String arrangementId;
    private String preAuthorizationTypeName;
    private String statusStartDt;  

}