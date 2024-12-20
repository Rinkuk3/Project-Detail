package com.td.api.mbnaap.common;

import com.td.api.mbnaap.common.CreditCardAgreementAltkey;

import lombok.Data;

@Data
public class ExternalDirectCredit {

    private CreditCardAgreementAltkey creditCardAgreementAltkey;
    private GenericAccountAltkey genericAccountAltkey;
    private String branchAddressTxt;
    private String timePeriodCd;
    private String timePeriodNum;
    private String paymentTypeName;
    private String frequencyCd;
    private String dueDayNum;
    private Double dueAmt;
    private Integer recurrenceCnt;
    private String recurrenceEndDt;
    
//    private CreditCardAgreementAltkey creditCardAgreementAltkey;
//    private GenericAccountAltkey genericAccountAltkey;
//    private String timePeriodCd;
//    private String timePeriodNum;
//    private String paymentTypeName;
//    private String frequencyCd;
//    private String dueDayNum;
//    private Double dueAmt;
//    private Integer recurrenceCnt;
    private Boolean arrangementHoldInd;
    private Boolean telephoneChannelInd;
    private String creditCardAgreementCycleDateNum;
//    private String recurrenceEndDt;
    
//    private CreditCardAgreementAltkey__1 creditCardAgreementAltkey;
//    private GenericAccountAltkey genericAccountAltkey;
//    private String timePeriodCd;
//    private String timePeriodNum;
//    private String paymentTypeName;
//    private String frequencyCd;
//    private String dueDayNum;
//    private Double dueAmt;
//    private Integer recurrenceCnt;
//    private Boolean arrangementHoldInd;
//    private Boolean telephoneChannelInd;
    private String arrangementStartDt;
    private Boolean confirmationLetterRequiredInd;
//    private String creditCardAgreementCycleDateNum;
//    private String recurrenceEndDt;
    private MbpdExtension mbpdExtension;
   
}