package com.td.api.mbcca.creditcard.response;

import com.td.api.mbcca.shared.Cccyamt;

public class CreditCardAgreement {

    java.math.BigDecimal creditLimitAmt;
    private AlternateDisclosureGroup alternateDisclosureGroup;
    private String highBalanceDt;
    private Cccyamt previousCreditLimitCccyamt;
    private String creditLimitStartDt;
    private String creditDeclinedCorrespondenceId;
    private String creditDeclinedReasonCd;
    private String creditDeclinedReasonDesc;
    private String creditLimitChangeCd;
    private Cccyamt previousCashAdvanceLimitCccyamt;
    private Cccyamt cashAdvanceLimitCccyamt;
    private Cccyamt cashAdvanceLimitEffectiveCccyamt;
    private String cashAdvanceLimitStartDt;
    private String lastCheckRejectionFeePostedDt;
    private String lastNotSufficientFundsFeePostedDt;
    private ChargeOffStatus chargeOffStatus;
    private ReinstatementStatus reinstatementStatus;

    public java.math.BigDecimal getCreditLimitAmt() {
        return creditLimitAmt;
    }

    public void setCreditLimitAmt(java.math.BigDecimal creditLimitAmt) {
        this.creditLimitAmt = creditLimitAmt;
    }

    public AlternateDisclosureGroup getAlternateDisclosureGroup() {
        return alternateDisclosureGroup;
    }

    public void setAlternateDisclosureGroup(AlternateDisclosureGroup alternateDisclosureGroup) {
        this.alternateDisclosureGroup = alternateDisclosureGroup;
    }

    public String getHighBalanceDt() {
        return highBalanceDt;
    }

    public void setHighBalanceDt(String highBalanceDt) {
        this.highBalanceDt = highBalanceDt;
    }

    public Cccyamt getPreviousCreditLimitCccyamt() {
        return previousCreditLimitCccyamt;
    }

    public void setPreviousCreditLimitCccyamt(Cccyamt previousCreditLimitCccyamt) {
        this.previousCreditLimitCccyamt = previousCreditLimitCccyamt;
    }

    public String getCreditLimitStartDt() {
        return creditLimitStartDt;
    }

    public void setCreditLimitStartDt(String creditLimitStartDt) {
        this.creditLimitStartDt = creditLimitStartDt;
    }

    public String getCreditDeclinedCorrespondenceId() {
        return creditDeclinedCorrespondenceId;
    }

    public void setCreditDeclinedCorrespondenceId(String creditDeclinedCorrespondenceId) {
        this.creditDeclinedCorrespondenceId = creditDeclinedCorrespondenceId;
    }

    public String getCreditDeclinedReasonCd() {
        return creditDeclinedReasonCd;
    }

    public void setCreditDeclinedReasonCd(String creditDeclinedReasonCd) {
        this.creditDeclinedReasonCd = creditDeclinedReasonCd;
    }

    public String getCreditDeclinedReasonDesc() {
        return creditDeclinedReasonDesc;
    }

    public void setCreditDeclinedReasonDesc(String creditDeclinedReasonDesc) {
        this.creditDeclinedReasonDesc = creditDeclinedReasonDesc;
    }

    public String getCreditLimitChangeCd() {
        return creditLimitChangeCd;
    }

    public void setCreditLimitChangeCd(String creditLimitChangeCd) {
        this.creditLimitChangeCd = creditLimitChangeCd;
    }

    public Cccyamt getPreviousCashAdvanceLimitCccyamt() {
        return previousCashAdvanceLimitCccyamt;
    }

    public void setPreviousCashAdvanceLimitCccyamt(Cccyamt previousCashAdvanceLimitCccyamt) {
        this.previousCashAdvanceLimitCccyamt = previousCashAdvanceLimitCccyamt;
    }

    public Cccyamt getCashAdvanceLimitCccyamt() {
        return cashAdvanceLimitCccyamt;
    }

    public void setCashAdvanceLimitCccyamt(Cccyamt cashAdvanceLimitCccyamt) {
        this.cashAdvanceLimitCccyamt = cashAdvanceLimitCccyamt;
    }

    public Cccyamt getCashAdvanceLimitEffectiveCccyamt() {
        return cashAdvanceLimitEffectiveCccyamt;
    }

    public void setCashAdvanceLimitEffectiveCccyamt(Cccyamt cashAdvanceLimitEffectiveCccyamt) {
        this.cashAdvanceLimitEffectiveCccyamt = cashAdvanceLimitEffectiveCccyamt;
    }

    public String getCashAdvanceLimitStartDt() {
        return cashAdvanceLimitStartDt;
    }

    public void setCashAdvanceLimitStartDt(String cashAdvanceLimitStartDt) {
        this.cashAdvanceLimitStartDt = cashAdvanceLimitStartDt;
    }

    public String getLastCheckRejectionFeePostedDt() {
        return lastCheckRejectionFeePostedDt;
    }

    public void setLastCheckRejectionFeePostedDt(String lastCheckRejectionFeePostedDt) {
        this.lastCheckRejectionFeePostedDt = lastCheckRejectionFeePostedDt;
    }

    public String getLastNotSufficientFundsFeePostedDt() {
        return lastNotSufficientFundsFeePostedDt;
    }

    public void setLastNotSufficientFundsFeePostedDt(String lastNotSufficientFundsFeePostedDt) {
        this.lastNotSufficientFundsFeePostedDt = lastNotSufficientFundsFeePostedDt;
    }

    public ChargeOffStatus getChargeOffStatus() {
        return chargeOffStatus;
    }

    public void setChargeOffStatus(ChargeOffStatus chargeOffStatus) {
        this.chargeOffStatus = chargeOffStatus;
    }

    public ReinstatementStatus getReinstatementStatus() {
        return reinstatementStatus;
    }

    public void setReinstatementStatus(ReinstatementStatus reinstatementStatus) {
        this.reinstatementStatus = reinstatementStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CreditCardAgreement.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("creditLimitAmt");
        sb.append('=');
        sb.append(((this.creditLimitAmt == null)?"<null>":this.creditLimitAmt));
        sb.append(',');
        sb.append("alternateDisclosureGroup");
        sb.append('=');
        sb.append(((this.alternateDisclosureGroup == null)?"<null>":this.alternateDisclosureGroup));
        sb.append(',');
        sb.append("highBalanceDt");
        sb.append('=');
        sb.append(((this.highBalanceDt == null)?"<null>":this.highBalanceDt));
        sb.append(',');
        sb.append("previousCreditLimitCccyamt");
        sb.append('=');
        sb.append(((this.previousCreditLimitCccyamt == null)?"<null>":this.previousCreditLimitCccyamt));
        sb.append(',');
        sb.append("creditLimitStartDt");
        sb.append('=');
        sb.append(((this.creditLimitStartDt == null)?"<null>":this.creditLimitStartDt));
        sb.append(',');
        sb.append("creditDeclinedCorrespondenceId");
        sb.append('=');
        sb.append(((this.creditDeclinedCorrespondenceId == null)?"<null>":this.creditDeclinedCorrespondenceId));
        sb.append(',');
        sb.append("creditDeclinedReasonCd");
        sb.append('=');
        sb.append(((this.creditDeclinedReasonCd == null)?"<null>":this.creditDeclinedReasonCd));
        sb.append(',');
        sb.append("creditDeclinedReasonDesc");
        sb.append('=');
        sb.append(((this.creditDeclinedReasonDesc == null)?"<null>":this.creditDeclinedReasonDesc));
        sb.append(',');
        sb.append("creditLimitChangeCd");
        sb.append('=');
        sb.append(((this.creditLimitChangeCd == null)?"<null>":this.creditLimitChangeCd));
        sb.append(',');
        sb.append("previousCashAdvanceLimitCccyamt");
        sb.append('=');
        sb.append(((this.previousCashAdvanceLimitCccyamt == null)?"<null>":this.previousCashAdvanceLimitCccyamt));
        sb.append(',');
        sb.append("cashAdvanceLimitCccyamt");
        sb.append('=');
        sb.append(((this.cashAdvanceLimitCccyamt == null)?"<null>":this.cashAdvanceLimitCccyamt));
        sb.append(',');
        sb.append("cashAdvanceLimitEffectiveCccyamt");
        sb.append('=');
        sb.append(((this.cashAdvanceLimitEffectiveCccyamt == null)?"<null>":this.cashAdvanceLimitEffectiveCccyamt));
        sb.append(',');
        sb.append("cashAdvanceLimitStartDt");
        sb.append('=');
        sb.append(((this.cashAdvanceLimitStartDt == null)?"<null>":this.cashAdvanceLimitStartDt));
        sb.append(',');
        sb.append("lastCheckRejectionFeePostedDt");
        sb.append('=');
        sb.append(((this.lastCheckRejectionFeePostedDt == null)?"<null>":this.lastCheckRejectionFeePostedDt));
        sb.append(',');
        sb.append("lastNotSufficientFundsFeePostedDt");
        sb.append('=');
        sb.append(((this.lastNotSufficientFundsFeePostedDt == null)?"<null>":this.lastNotSufficientFundsFeePostedDt));
        sb.append(',');
        sb.append("chargeOffStatus");
        sb.append('=');
        sb.append(((this.chargeOffStatus == null)?"<null>":this.chargeOffStatus));
        sb.append(',');
        sb.append("reinstatementStatus");
        sb.append('=');
        sb.append(((this.reinstatementStatus == null)?"<null>":this.reinstatementStatus));
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
        result = ((result* 31)+((this.highBalanceDt == null)? 0 :this.highBalanceDt.hashCode()));
        result = ((result* 31)+((this.previousCashAdvanceLimitCccyamt == null)? 0 :this.previousCashAdvanceLimitCccyamt.hashCode()));
        result = ((result* 31)+((this.cashAdvanceLimitCccyamt == null)? 0 :this.cashAdvanceLimitCccyamt.hashCode()));
        result = ((result* 31)+((this.creditLimitChangeCd == null)? 0 :this.creditLimitChangeCd.hashCode()));
        result = ((result* 31)+((this.lastCheckRejectionFeePostedDt == null)? 0 :this.lastCheckRejectionFeePostedDt.hashCode()));
        result = ((result* 31)+((this.creditLimitStartDt == null)? 0 :this.creditLimitStartDt.hashCode()));
        result = ((result* 31)+((this.previousCreditLimitCccyamt == null)? 0 :this.previousCreditLimitCccyamt.hashCode()));
        result = ((result* 31)+((this.creditDeclinedReasonDesc == null)? 0 :this.creditDeclinedReasonDesc.hashCode()));
        result = ((result* 31)+((this.reinstatementStatus == null)? 0 :this.reinstatementStatus.hashCode()));
        result = ((result* 31)+((this.creditDeclinedCorrespondenceId == null)? 0 :this.creditDeclinedCorrespondenceId.hashCode()));
        result = ((result* 31)+((this.creditDeclinedReasonCd == null)? 0 :this.creditDeclinedReasonCd.hashCode()));
        result = ((result* 31)+((this.cashAdvanceLimitStartDt == null)? 0 :this.cashAdvanceLimitStartDt.hashCode()));
        result = ((result* 31)+((this.cashAdvanceLimitEffectiveCccyamt == null)? 0 :this.cashAdvanceLimitEffectiveCccyamt.hashCode()));
        result = ((result* 31)+((this.lastNotSufficientFundsFeePostedDt == null)? 0 :this.lastNotSufficientFundsFeePostedDt.hashCode()));
        result = ((result* 31)+((this.creditLimitAmt == null)? 0 :this.creditLimitAmt.hashCode()));
        result = ((result* 31)+((this.alternateDisclosureGroup == null)? 0 :this.alternateDisclosureGroup.hashCode()));
        result = ((result* 31)+((this.chargeOffStatus == null)? 0 :this.chargeOffStatus.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreditCardAgreement) == false) {
            return false;
        }
        CreditCardAgreement rhs = ((CreditCardAgreement) other);
        return ((((((((((((((((((this.highBalanceDt == rhs.highBalanceDt)||((this.highBalanceDt!= null)&&this.highBalanceDt.equals(rhs.highBalanceDt)))&&((this.previousCashAdvanceLimitCccyamt == rhs.previousCashAdvanceLimitCccyamt)||((this.previousCashAdvanceLimitCccyamt!= null)&&this.previousCashAdvanceLimitCccyamt.equals(rhs.previousCashAdvanceLimitCccyamt))))&&((this.cashAdvanceLimitCccyamt == rhs.cashAdvanceLimitCccyamt)||((this.cashAdvanceLimitCccyamt!= null)&&this.cashAdvanceLimitCccyamt.equals(rhs.cashAdvanceLimitCccyamt))))&&((this.creditLimitChangeCd == rhs.creditLimitChangeCd)||((this.creditLimitChangeCd!= null)&&this.creditLimitChangeCd.equals(rhs.creditLimitChangeCd))))&&((this.lastCheckRejectionFeePostedDt == rhs.lastCheckRejectionFeePostedDt)||((this.lastCheckRejectionFeePostedDt!= null)&&this.lastCheckRejectionFeePostedDt.equals(rhs.lastCheckRejectionFeePostedDt))))&&((this.creditLimitStartDt == rhs.creditLimitStartDt)||((this.creditLimitStartDt!= null)&&this.creditLimitStartDt.equals(rhs.creditLimitStartDt))))&&((this.previousCreditLimitCccyamt == rhs.previousCreditLimitCccyamt)||((this.previousCreditLimitCccyamt!= null)&&this.previousCreditLimitCccyamt.equals(rhs.previousCreditLimitCccyamt))))&&((this.creditDeclinedReasonDesc == rhs.creditDeclinedReasonDesc)||((this.creditDeclinedReasonDesc!= null)&&this.creditDeclinedReasonDesc.equals(rhs.creditDeclinedReasonDesc))))&&((this.reinstatementStatus == rhs.reinstatementStatus)||((this.reinstatementStatus!= null)&&this.reinstatementStatus.equals(rhs.reinstatementStatus))))&&((this.creditDeclinedCorrespondenceId == rhs.creditDeclinedCorrespondenceId)||((this.creditDeclinedCorrespondenceId!= null)&&this.creditDeclinedCorrespondenceId.equals(rhs.creditDeclinedCorrespondenceId))))&&((this.creditDeclinedReasonCd == rhs.creditDeclinedReasonCd)||((this.creditDeclinedReasonCd!= null)&&this.creditDeclinedReasonCd.equals(rhs.creditDeclinedReasonCd))))&&((this.cashAdvanceLimitStartDt == rhs.cashAdvanceLimitStartDt)||((this.cashAdvanceLimitStartDt!= null)&&this.cashAdvanceLimitStartDt.equals(rhs.cashAdvanceLimitStartDt))))&&((this.cashAdvanceLimitEffectiveCccyamt == rhs.cashAdvanceLimitEffectiveCccyamt)||((this.cashAdvanceLimitEffectiveCccyamt!= null)&&this.cashAdvanceLimitEffectiveCccyamt.equals(rhs.cashAdvanceLimitEffectiveCccyamt))))&&((this.lastNotSufficientFundsFeePostedDt == rhs.lastNotSufficientFundsFeePostedDt)||((this.lastNotSufficientFundsFeePostedDt!= null)&&this.lastNotSufficientFundsFeePostedDt.equals(rhs.lastNotSufficientFundsFeePostedDt))))&&((this.creditLimitAmt == rhs.creditLimitAmt)||((this.creditLimitAmt!= null)&&this.creditLimitAmt.equals(rhs.creditLimitAmt))))&&((this.alternateDisclosureGroup == rhs.alternateDisclosureGroup)||((this.alternateDisclosureGroup!= null)&&this.alternateDisclosureGroup.equals(rhs.alternateDisclosureGroup))))&&((this.chargeOffStatus == rhs.chargeOffStatus)||((this.chargeOffStatus!= null)&&this.chargeOffStatus.equals(rhs.chargeOffStatus))));
    }

}
