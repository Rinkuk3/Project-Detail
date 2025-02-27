package com.td.api.mbcca.shared;

import com.td.api.mbcca.response.account.OriginalAuthorizationEvent;

public class Visa {

    private String interchangeFeeFeatureGroupId;
    private String mailTelephoneOrderTransactionCd;
    private String firstSpecialConditionCd;
    private String secondSpecialConditionCd;
    private String reimbursementFeeCd;
    private String multipleClearingTransactionsReferenceNum;
    private OriginalAuthorizationEvent originalAuthorizationEvent;
    private String customPaymentServiceInterchangeCategoryCd;
    private Boolean chipConditionInd;
    private String chargeBackRightsTypeCd;
    private Boolean adjustmentMadeInd;

    public String getInterchangeFeeFeatureGroupId() {
        return interchangeFeeFeatureGroupId;
    }

    public void setInterchangeFeeFeatureGroupId(String interchangeFeeFeatureGroupId) {
        this.interchangeFeeFeatureGroupId = interchangeFeeFeatureGroupId;
    }

    public String getMailTelephoneOrderTransactionCd() {
        return mailTelephoneOrderTransactionCd;
    }

    public void setMailTelephoneOrderTransactionCd(String mailTelephoneOrderTransactionCd) {
        this.mailTelephoneOrderTransactionCd = mailTelephoneOrderTransactionCd;
    }

    public String getFirstSpecialConditionCd() {
        return firstSpecialConditionCd;
    }

    public void setFirstSpecialConditionCd(String firstSpecialConditionCd) {
        this.firstSpecialConditionCd = firstSpecialConditionCd;
    }

    public String getSecondSpecialConditionCd() {
        return secondSpecialConditionCd;
    }

    public void setSecondSpecialConditionCd(String secondSpecialConditionCd) {
        this.secondSpecialConditionCd = secondSpecialConditionCd;
    }

    public String getReimbursementFeeCd() {
        return reimbursementFeeCd;
    }

    public void setReimbursementFeeCd(String reimbursementFeeCd) {
        this.reimbursementFeeCd = reimbursementFeeCd;
    }

    public String getMultipleClearingTransactionsReferenceNum() {
        return multipleClearingTransactionsReferenceNum;
    }

    public void setMultipleClearingTransactionsReferenceNum(String multipleClearingTransactionsReferenceNum) {
        this.multipleClearingTransactionsReferenceNum = multipleClearingTransactionsReferenceNum;
    }

    public OriginalAuthorizationEvent getOriginalAuthorizationEvent() {
        return originalAuthorizationEvent;
    }

    public void setOriginalAuthorizationEvent(OriginalAuthorizationEvent originalAuthorizationEvent) {
        this.originalAuthorizationEvent = originalAuthorizationEvent;
    }

    public String getCustomPaymentServiceInterchangeCategoryCd() {
        return customPaymentServiceInterchangeCategoryCd;
    }

    public void setCustomPaymentServiceInterchangeCategoryCd(String customPaymentServiceInterchangeCategoryCd) {
        this.customPaymentServiceInterchangeCategoryCd = customPaymentServiceInterchangeCategoryCd;
    }

    public Boolean getChipConditionInd() {
        return chipConditionInd;
    }

    public void setChipConditionInd(Boolean chipConditionInd) {
        this.chipConditionInd = chipConditionInd;
    }

    public String getChargeBackRightsTypeCd() {
        return chargeBackRightsTypeCd;
    }

    public void setChargeBackRightsTypeCd(String chargeBackRightsTypeCd) {
        this.chargeBackRightsTypeCd = chargeBackRightsTypeCd;
    }

    public Boolean getAdjustmentMadeInd() {
        return adjustmentMadeInd;
    }

    public void setAdjustmentMadeInd(Boolean adjustmentMadeInd) {
        this.adjustmentMadeInd = adjustmentMadeInd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Visa.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("interchangeFeeFeatureGroupId");
        sb.append('=');
        sb.append(((this.interchangeFeeFeatureGroupId == null)?"<null>":this.interchangeFeeFeatureGroupId));
        sb.append(',');
        sb.append("mailTelephoneOrderTransactionCd");
        sb.append('=');
        sb.append(((this.mailTelephoneOrderTransactionCd == null)?"<null>":this.mailTelephoneOrderTransactionCd));
        sb.append(',');
        sb.append("firstSpecialConditionCd");
        sb.append('=');
        sb.append(((this.firstSpecialConditionCd == null)?"<null>":this.firstSpecialConditionCd));
        sb.append(',');
        sb.append("secondSpecialConditionCd");
        sb.append('=');
        sb.append(((this.secondSpecialConditionCd == null)?"<null>":this.secondSpecialConditionCd));
        sb.append(',');
        sb.append("reimbursementFeeCd");
        sb.append('=');
        sb.append(((this.reimbursementFeeCd == null)?"<null>":this.reimbursementFeeCd));
        sb.append(',');
        sb.append("multipleClearingTransactionsReferenceNum");
        sb.append('=');
        sb.append(((this.multipleClearingTransactionsReferenceNum == null)?"<null>":this.multipleClearingTransactionsReferenceNum));
        sb.append(',');
        sb.append("originalAuthorizationEvent");
        sb.append('=');
        sb.append(((this.originalAuthorizationEvent == null)?"<null>":this.originalAuthorizationEvent));
        sb.append(',');
        sb.append("customPaymentServiceInterchangeCategoryCd");
        sb.append('=');
        sb.append(((this.customPaymentServiceInterchangeCategoryCd == null)?"<null>":this.customPaymentServiceInterchangeCategoryCd));
        sb.append(',');
        sb.append("chipConditionInd");
        sb.append('=');
        sb.append(((this.chipConditionInd == null)?"<null>":this.chipConditionInd));
        sb.append(',');
        sb.append("chargeBackRightsTypeCd");
        sb.append('=');
        sb.append(((this.chargeBackRightsTypeCd == null)?"<null>":this.chargeBackRightsTypeCd));
        sb.append(',');
        sb.append("adjustmentMadeInd");
        sb.append('=');
        sb.append(((this.adjustmentMadeInd == null)?"<null>":this.adjustmentMadeInd));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.mailTelephoneOrderTransactionCd == null)? 0 :this.mailTelephoneOrderTransactionCd.hashCode()));
        result = ((result* 31)+((this.secondSpecialConditionCd == null)? 0 :this.secondSpecialConditionCd.hashCode()));
        result = ((result* 31)+((this.multipleClearingTransactionsReferenceNum == null)? 0 :this.multipleClearingTransactionsReferenceNum.hashCode()));
        result = ((result* 31)+((this.chipConditionInd == null)? 0 :this.chipConditionInd.hashCode()));
        result = ((result* 31)+((this.firstSpecialConditionCd == null)? 0 :this.firstSpecialConditionCd.hashCode()));
        result = ((result* 31)+((this.adjustmentMadeInd == null)? 0 :this.adjustmentMadeInd.hashCode()));
        result = ((result* 31)+((this.reimbursementFeeCd == null)? 0 :this.reimbursementFeeCd.hashCode()));
        result = ((result* 31)+((this.customPaymentServiceInterchangeCategoryCd == null)? 0 :this.customPaymentServiceInterchangeCategoryCd.hashCode()));
        result = ((result* 31)+((this.interchangeFeeFeatureGroupId == null)? 0 :this.interchangeFeeFeatureGroupId.hashCode()));
        result = ((result* 31)+((this.chargeBackRightsTypeCd == null)? 0 :this.chargeBackRightsTypeCd.hashCode()));
        result = ((result* 31)+((this.originalAuthorizationEvent == null)? 0 :this.originalAuthorizationEvent.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Visa) == false) {
            return false;
        }
        Visa rhs = ((Visa) other);
        return ((((((((((((this.mailTelephoneOrderTransactionCd == rhs.mailTelephoneOrderTransactionCd)||((this.mailTelephoneOrderTransactionCd!= null)&&this.mailTelephoneOrderTransactionCd.equals(rhs.mailTelephoneOrderTransactionCd)))&&((this.secondSpecialConditionCd == rhs.secondSpecialConditionCd)||((this.secondSpecialConditionCd!= null)&&this.secondSpecialConditionCd.equals(rhs.secondSpecialConditionCd))))&&((this.multipleClearingTransactionsReferenceNum == rhs.multipleClearingTransactionsReferenceNum)||((this.multipleClearingTransactionsReferenceNum!= null)&&this.multipleClearingTransactionsReferenceNum.equals(rhs.multipleClearingTransactionsReferenceNum))))&&((this.chipConditionInd == rhs.chipConditionInd)||((this.chipConditionInd!= null)&&this.chipConditionInd.equals(rhs.chipConditionInd))))&&((this.firstSpecialConditionCd == rhs.firstSpecialConditionCd)||((this.firstSpecialConditionCd!= null)&&this.firstSpecialConditionCd.equals(rhs.firstSpecialConditionCd))))&&((this.adjustmentMadeInd == rhs.adjustmentMadeInd)||((this.adjustmentMadeInd!= null)&&this.adjustmentMadeInd.equals(rhs.adjustmentMadeInd))))&&((this.reimbursementFeeCd == rhs.reimbursementFeeCd)||((this.reimbursementFeeCd!= null)&&this.reimbursementFeeCd.equals(rhs.reimbursementFeeCd))))&&((this.customPaymentServiceInterchangeCategoryCd == rhs.customPaymentServiceInterchangeCategoryCd)||((this.customPaymentServiceInterchangeCategoryCd!= null)&&this.customPaymentServiceInterchangeCategoryCd.equals(rhs.customPaymentServiceInterchangeCategoryCd))))&&((this.interchangeFeeFeatureGroupId == rhs.interchangeFeeFeatureGroupId)||((this.interchangeFeeFeatureGroupId!= null)&&this.interchangeFeeFeatureGroupId.equals(rhs.interchangeFeeFeatureGroupId))))&&((this.chargeBackRightsTypeCd == rhs.chargeBackRightsTypeCd)||((this.chargeBackRightsTypeCd!= null)&&this.chargeBackRightsTypeCd.equals(rhs.chargeBackRightsTypeCd))))&&((this.originalAuthorizationEvent == rhs.originalAuthorizationEvent)||((this.originalAuthorizationEvent!= null)&&this.originalAuthorizationEvent.equals(rhs.originalAuthorizationEvent))));
    }

}
