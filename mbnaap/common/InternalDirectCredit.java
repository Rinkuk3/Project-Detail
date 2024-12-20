package com.td.api.mbnaap.common;

import lombok.Data;

/**
 * Allow deposit of money from an account inside of the financial institution to an account within the financial institution.
 * 
 */
@Data
public class InternalDirectCredit {


    private CreditCardAgreementAltkey creditCardAgreementAltkey;
    private GenericAgreementAltkey genericAgreementAltkey;
    private String timePeriodCd;
    private String timePeriodNum;
    private String paymentTypeName;
    private String cycleNum;
    private String frequencyCd;
    private String dueDayNum;
    private Double dueAmt;
    private Integer recurrenceCnt;
    private Boolean arrangementHoldInd;
    private Boolean telephoneChannelInd;
    private String arrangementStartDt;
    private Boolean confirmationLetterRequiredInd;
    private String creditCardAgreementCycleDateNum;
    private String recurrenceEndDt;
    private MbpdExtension mbpdExtension;

//    private CreditCardAgreementAltkey creditCardAgreementAltkey;
//    private GenericAgreementAltkey genericAgreementAltkey;
    private String branchAddressTxt;
//    private String timePeriodCd;
//    private String timePeriodNum;
//    private String paymentTypeName;
//    private String frequencyCd;
//    private String dueDayNum;
//    private Double dueAmt;
//    private Integer recurrenceCnt;
//    private String recurrenceEndDt;
    
//    private CreditCardAgreementAltkey creditCardAgreementAltkey;
//    private GenericAgreementAltkey genericAgreementAltkey;
//    private String timePeriodCd;
//    private String timePeriodNum;
//    private String paymentTypeName;
//    private String frequencyCd;
//    private String dueDayNum;
//    private Double dueAmt;
//    private Integer recurrenceCnt;
//    private Boolean arrangementHoldInd;
//    private Boolean telephoneChannelInd;
//    private String creditCardAgreementCycleDateNum;
//    private String recurrenceEndDt;
    
//    private CreditCardAgreementAltkey creditCardAgreementAltkey;
    private GenericAccountAltkey genericAccountAltkey;
//    private String timePeriodCd;
//    private String timePeriodNum;
//    private String paymentTypeName;
//    private String frequencyCd;
//    private String dueDayNum;
//    private Double dueAmt;
//    private Integer recurrenceCnt;
//    private Boolean arrangementHoldInd;
//    private Boolean telephoneChannelInd;
//    private String creditCardAgreementCycleDateNum;
//    private String recurrenceEndDt;
}