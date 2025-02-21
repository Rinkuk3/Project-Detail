package com.td.api.mbcca.response.account;

import com.td.api.mbcca.shared.Cccyamt;

public class TransactionCategoryBalance {

    private String transactionCategoryCd;
    private String termBalanceCd;
    private String termBalanceDesc;
    private String financeChargeTypeCd;
    private Cccyamt outstandingBalancePaymentCccyamt;
    private Cccyamt previousPrincipleBalanceCccyamt;
    private Cccyamt outstandingBalanceCccyamt;
    private Cccyamt outstandingBalancePlusPreviousCycleCccyamt;
    private Cccyamt averageDailyBalanceCccyamt;
    private Cccyamt averageDailyBalancePlusPreviousCycleCccyamt;
    private Boolean averageDailyBalanceSubjectToChargeInd;
    private Boolean previousOutstandingBalanceSubjectToChargeInd;
    private Boolean outstandingFinanceChargesSubjectToChargeInd;
    private Boolean previousOutstandingFinanceChargesSubjectToChargeInd;
    private Cccyamt appliedDebitsCccyamt;
    private Cccyamt debitsCccyamt;
    private Cccyamt financeChargeDebitsCccyamt;
    private Cccyamt debitAdjustmentCccyamt;
    private Cccyamt appliedCreditsCccyamt;
    private Cccyamt creditsCccyamt;
    private Cccyamt financeChargeCreditsCccyamt;
    private Cccyamt creditAdjustmentCccyamt;
    private Cccyamt outstandingFinanceChargeCccyamt;
    private Cccyamt billedFinanceChargeCccyamt;
    private Cccyamt averageDailyBalanceFinanceChargeCccyamt;
    private Boolean introductoryRatePromotionExpirationInd;
    private String annualPercentageRatePromotionExpirationDt;

    public String getTransactionCategoryCd() {
        return transactionCategoryCd;
    }

    public void setTransactionCategoryCd(String transactionCategoryCd) {
        this.transactionCategoryCd = transactionCategoryCd;
    }

    public String getTermBalanceCd() {
        return termBalanceCd;
    }

    public void setTermBalanceCd(String termBalanceCd) {
        this.termBalanceCd = termBalanceCd;
    }

    public String getTermBalanceDesc() {
        return termBalanceDesc;
    }

    public void setTermBalanceDesc(String termBalanceDesc) {
        this.termBalanceDesc = termBalanceDesc;
    }

    public String getFinanceChargeTypeCd() {
        return financeChargeTypeCd;
    }

    public void setFinanceChargeTypeCd(String financeChargeTypeCd) {
        this.financeChargeTypeCd = financeChargeTypeCd;
    }

    public Cccyamt getOutstandingBalancePaymentCccyamt() {
        return outstandingBalancePaymentCccyamt;
    }

    public void setOutstandingBalancePaymentCccyamt(Cccyamt outstandingBalancePaymentCccyamt) {
        this.outstandingBalancePaymentCccyamt = outstandingBalancePaymentCccyamt;
    }

    public Cccyamt getPreviousPrincipleBalanceCccyamt() {
        return previousPrincipleBalanceCccyamt;
    }

    public void setPreviousPrincipleBalanceCccyamt(Cccyamt previousPrincipleBalanceCccyamt) {
        this.previousPrincipleBalanceCccyamt = previousPrincipleBalanceCccyamt;
    }

    public Cccyamt getOutstandingBalanceCccyamt() {
        return outstandingBalanceCccyamt;
    }

    public void setOutstandingBalanceCccyamt(Cccyamt outstandingBalanceCccyamt) {
        this.outstandingBalanceCccyamt = outstandingBalanceCccyamt;
    }

    public Cccyamt getOutstandingBalancePlusPreviousCycleCccyamt() {
        return outstandingBalancePlusPreviousCycleCccyamt;
    }

    public void setOutstandingBalancePlusPreviousCycleCccyamt(Cccyamt outstandingBalancePlusPreviousCycleCccyamt) {
        this.outstandingBalancePlusPreviousCycleCccyamt = outstandingBalancePlusPreviousCycleCccyamt;
    }

    public Cccyamt getAverageDailyBalanceCccyamt() {
        return averageDailyBalanceCccyamt;
    }

    public void setAverageDailyBalanceCccyamt(Cccyamt averageDailyBalanceCccyamt) {
        this.averageDailyBalanceCccyamt = averageDailyBalanceCccyamt;
    }

    public Cccyamt getAverageDailyBalancePlusPreviousCycleCccyamt() {
        return averageDailyBalancePlusPreviousCycleCccyamt;
    }

    public void setAverageDailyBalancePlusPreviousCycleCccyamt(Cccyamt averageDailyBalancePlusPreviousCycleCccyamt) {
        this.averageDailyBalancePlusPreviousCycleCccyamt = averageDailyBalancePlusPreviousCycleCccyamt;
    }

    public Boolean getAverageDailyBalanceSubjectToChargeInd() {
        return averageDailyBalanceSubjectToChargeInd;
    }

    public void setAverageDailyBalanceSubjectToChargeInd(Boolean averageDailyBalanceSubjectToChargeInd) {
        this.averageDailyBalanceSubjectToChargeInd = averageDailyBalanceSubjectToChargeInd;
    }

    public Boolean getPreviousOutstandingBalanceSubjectToChargeInd() {
        return previousOutstandingBalanceSubjectToChargeInd;
    }

    public void setPreviousOutstandingBalanceSubjectToChargeInd(Boolean previousOutstandingBalanceSubjectToChargeInd) {
        this.previousOutstandingBalanceSubjectToChargeInd = previousOutstandingBalanceSubjectToChargeInd;
    }

    public Boolean getOutstandingFinanceChargesSubjectToChargeInd() {
        return outstandingFinanceChargesSubjectToChargeInd;
    }

    public void setOutstandingFinanceChargesSubjectToChargeInd(Boolean outstandingFinanceChargesSubjectToChargeInd) {
        this.outstandingFinanceChargesSubjectToChargeInd = outstandingFinanceChargesSubjectToChargeInd;
    }

    public Boolean getPreviousOutstandingFinanceChargesSubjectToChargeInd() {
        return previousOutstandingFinanceChargesSubjectToChargeInd;
    }

    public void setPreviousOutstandingFinanceChargesSubjectToChargeInd(Boolean previousOutstandingFinanceChargesSubjectToChargeInd) {
        this.previousOutstandingFinanceChargesSubjectToChargeInd = previousOutstandingFinanceChargesSubjectToChargeInd;
    }

    public Cccyamt getAppliedDebitsCccyamt() {
        return appliedDebitsCccyamt;
    }

    public void setAppliedDebitsCccyamt(Cccyamt appliedDebitsCccyamt) {
        this.appliedDebitsCccyamt = appliedDebitsCccyamt;
    }

    public Cccyamt getDebitsCccyamt() {
        return debitsCccyamt;
    }

    public void setDebitsCccyamt(Cccyamt debitsCccyamt) {
        this.debitsCccyamt = debitsCccyamt;
    }

    public Cccyamt getFinanceChargeDebitsCccyamt() {
        return financeChargeDebitsCccyamt;
    }

    public void setFinanceChargeDebitsCccyamt(Cccyamt financeChargeDebitsCccyamt) {
        this.financeChargeDebitsCccyamt = financeChargeDebitsCccyamt;
    }

    public Cccyamt getDebitAdjustmentCccyamt() {
        return debitAdjustmentCccyamt;
    }

    public void setDebitAdjustmentCccyamt(Cccyamt debitAdjustmentCccyamt) {
        this.debitAdjustmentCccyamt = debitAdjustmentCccyamt;
    }

    public Cccyamt getAppliedCreditsCccyamt() {
        return appliedCreditsCccyamt;
    }

    public void setAppliedCreditsCccyamt(Cccyamt appliedCreditsCccyamt) {
        this.appliedCreditsCccyamt = appliedCreditsCccyamt;
    }

    public Cccyamt getCreditsCccyamt() {
        return creditsCccyamt;
    }

    public void setCreditsCccyamt(Cccyamt creditsCccyamt) {
        this.creditsCccyamt = creditsCccyamt;
    }

    public Cccyamt getFinanceChargeCreditsCccyamt() {
        return financeChargeCreditsCccyamt;
    }

    public void setFinanceChargeCreditsCccyamt(Cccyamt financeChargeCreditsCccyamt) {
        this.financeChargeCreditsCccyamt = financeChargeCreditsCccyamt;
    }

    public Cccyamt getCreditAdjustmentCccyamt() {
        return creditAdjustmentCccyamt;
    }

    public void setCreditAdjustmentCccyamt(Cccyamt creditAdjustmentCccyamt) {
        this.creditAdjustmentCccyamt = creditAdjustmentCccyamt;
    }

    public Cccyamt getOutstandingFinanceChargeCccyamt() {
        return outstandingFinanceChargeCccyamt;
    }

    public void setOutstandingFinanceChargeCccyamt(Cccyamt outstandingFinanceChargeCccyamt) {
        this.outstandingFinanceChargeCccyamt = outstandingFinanceChargeCccyamt;
    }

    public Cccyamt getBilledFinanceChargeCccyamt() {
        return billedFinanceChargeCccyamt;
    }

    public void setBilledFinanceChargeCccyamt(Cccyamt billedFinanceChargeCccyamt) {
        this.billedFinanceChargeCccyamt = billedFinanceChargeCccyamt;
    }

    public Cccyamt getAverageDailyBalanceFinanceChargeCccyamt() {
        return averageDailyBalanceFinanceChargeCccyamt;
    }

    public void setAverageDailyBalanceFinanceChargeCccyamt(Cccyamt averageDailyBalanceFinanceChargeCccyamt) {
        this.averageDailyBalanceFinanceChargeCccyamt = averageDailyBalanceFinanceChargeCccyamt;
    }

    public Boolean getIntroductoryRatePromotionExpirationInd() {
        return introductoryRatePromotionExpirationInd;
    }

    public void setIntroductoryRatePromotionExpirationInd(Boolean introductoryRatePromotionExpirationInd) {
        this.introductoryRatePromotionExpirationInd = introductoryRatePromotionExpirationInd;
    }

    public String getAnnualPercentageRatePromotionExpirationDt() {
        return annualPercentageRatePromotionExpirationDt;
    }

    public void setAnnualPercentageRatePromotionExpirationDt(String annualPercentageRatePromotionExpirationDt) {
        this.annualPercentageRatePromotionExpirationDt = annualPercentageRatePromotionExpirationDt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TransactionCategoryBalance.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("transactionCategoryCd");
        sb.append('=');
        sb.append(((this.transactionCategoryCd == null)?"<null>":this.transactionCategoryCd));
        sb.append(',');
        sb.append("termBalanceCd");
        sb.append('=');
        sb.append(((this.termBalanceCd == null)?"<null>":this.termBalanceCd));
        sb.append(',');
        sb.append("termBalanceDesc");
        sb.append('=');
        sb.append(((this.termBalanceDesc == null)?"<null>":this.termBalanceDesc));
        sb.append(',');
        sb.append("financeChargeTypeCd");
        sb.append('=');
        sb.append(((this.financeChargeTypeCd == null)?"<null>":this.financeChargeTypeCd));
        sb.append(',');
        sb.append("outstandingBalancePaymentCccyamt");
        sb.append('=');
        sb.append(((this.outstandingBalancePaymentCccyamt == null)?"<null>":this.outstandingBalancePaymentCccyamt));
        sb.append(',');
        sb.append("previousPrincipleBalanceCccyamt");
        sb.append('=');
        sb.append(((this.previousPrincipleBalanceCccyamt == null)?"<null>":this.previousPrincipleBalanceCccyamt));
        sb.append(',');
        sb.append("outstandingBalanceCccyamt");
        sb.append('=');
        sb.append(((this.outstandingBalanceCccyamt == null)?"<null>":this.outstandingBalanceCccyamt));
        sb.append(',');
        sb.append("outstandingBalancePlusPreviousCycleCccyamt");
        sb.append('=');
        sb.append(((this.outstandingBalancePlusPreviousCycleCccyamt == null)?"<null>":this.outstandingBalancePlusPreviousCycleCccyamt));
        sb.append(',');
        sb.append("averageDailyBalanceCccyamt");
        sb.append('=');
        sb.append(((this.averageDailyBalanceCccyamt == null)?"<null>":this.averageDailyBalanceCccyamt));
        sb.append(',');
        sb.append("averageDailyBalancePlusPreviousCycleCccyamt");
        sb.append('=');
        sb.append(((this.averageDailyBalancePlusPreviousCycleCccyamt == null)?"<null>":this.averageDailyBalancePlusPreviousCycleCccyamt));
        sb.append(',');
        sb.append("averageDailyBalanceSubjectToChargeInd");
        sb.append('=');
        sb.append(((this.averageDailyBalanceSubjectToChargeInd == null)?"<null>":this.averageDailyBalanceSubjectToChargeInd));
        sb.append(',');
        sb.append("previousOutstandingBalanceSubjectToChargeInd");
        sb.append('=');
        sb.append(((this.previousOutstandingBalanceSubjectToChargeInd == null)?"<null>":this.previousOutstandingBalanceSubjectToChargeInd));
        sb.append(',');
        sb.append("outstandingFinanceChargesSubjectToChargeInd");
        sb.append('=');
        sb.append(((this.outstandingFinanceChargesSubjectToChargeInd == null)?"<null>":this.outstandingFinanceChargesSubjectToChargeInd));
        sb.append(',');
        sb.append("previousOutstandingFinanceChargesSubjectToChargeInd");
        sb.append('=');
        sb.append(((this.previousOutstandingFinanceChargesSubjectToChargeInd == null)?"<null>":this.previousOutstandingFinanceChargesSubjectToChargeInd));
        sb.append(',');
        sb.append("appliedDebitsCccyamt");
        sb.append('=');
        sb.append(((this.appliedDebitsCccyamt == null)?"<null>":this.appliedDebitsCccyamt));
        sb.append(',');
        sb.append("debitsCccyamt");
        sb.append('=');
        sb.append(((this.debitsCccyamt == null)?"<null>":this.debitsCccyamt));
        sb.append(',');
        sb.append("financeChargeDebitsCccyamt");
        sb.append('=');
        sb.append(((this.financeChargeDebitsCccyamt == null)?"<null>":this.financeChargeDebitsCccyamt));
        sb.append(',');
        sb.append("debitAdjustmentCccyamt");
        sb.append('=');
        sb.append(((this.debitAdjustmentCccyamt == null)?"<null>":this.debitAdjustmentCccyamt));
        sb.append(',');
        sb.append("appliedCreditsCccyamt");
        sb.append('=');
        sb.append(((this.appliedCreditsCccyamt == null)?"<null>":this.appliedCreditsCccyamt));
        sb.append(',');
        sb.append("creditsCccyamt");
        sb.append('=');
        sb.append(((this.creditsCccyamt == null)?"<null>":this.creditsCccyamt));
        sb.append(',');
        sb.append("financeChargeCreditsCccyamt");
        sb.append('=');
        sb.append(((this.financeChargeCreditsCccyamt == null)?"<null>":this.financeChargeCreditsCccyamt));
        sb.append(',');
        sb.append("creditAdjustmentCccyamt");
        sb.append('=');
        sb.append(((this.creditAdjustmentCccyamt == null)?"<null>":this.creditAdjustmentCccyamt));
        sb.append(',');
        sb.append("outstandingFinanceChargeCccyamt");
        sb.append('=');
        sb.append(((this.outstandingFinanceChargeCccyamt == null)?"<null>":this.outstandingFinanceChargeCccyamt));
        sb.append(',');
        sb.append("billedFinanceChargeCccyamt");
        sb.append('=');
        sb.append(((this.billedFinanceChargeCccyamt == null)?"<null>":this.billedFinanceChargeCccyamt));
        sb.append(',');
        sb.append("averageDailyBalanceFinanceChargeCccyamt");
        sb.append('=');
        sb.append(((this.averageDailyBalanceFinanceChargeCccyamt == null)?"<null>":this.averageDailyBalanceFinanceChargeCccyamt));
        sb.append(',');
        sb.append("introductoryRatePromotionExpirationInd");
        sb.append('=');
        sb.append(((this.introductoryRatePromotionExpirationInd == null)?"<null>":this.introductoryRatePromotionExpirationInd));
        sb.append(',');
        sb.append("annualPercentageRatePromotionExpirationDt");
        sb.append('=');
        sb.append(((this.annualPercentageRatePromotionExpirationDt == null)?"<null>":this.annualPercentageRatePromotionExpirationDt));
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
        result = ((result* 31)+((this.averageDailyBalancePlusPreviousCycleCccyamt == null)? 0 :this.averageDailyBalancePlusPreviousCycleCccyamt.hashCode()));
        result = ((result* 31)+((this.financeChargeDebitsCccyamt == null)? 0 :this.financeChargeDebitsCccyamt.hashCode()));
        result = ((result* 31)+((this.averageDailyBalanceFinanceChargeCccyamt == null)? 0 :this.averageDailyBalanceFinanceChargeCccyamt.hashCode()));
        result = ((result* 31)+((this.introductoryRatePromotionExpirationInd == null)? 0 :this.introductoryRatePromotionExpirationInd.hashCode()));
        result = ((result* 31)+((this.creditAdjustmentCccyamt == null)? 0 :this.creditAdjustmentCccyamt.hashCode()));
        result = ((result* 31)+((this.transactionCategoryCd == null)? 0 :this.transactionCategoryCd.hashCode()));
        result = ((result* 31)+((this.annualPercentageRatePromotionExpirationDt == null)? 0 :this.annualPercentageRatePromotionExpirationDt.hashCode()));
        result = ((result* 31)+((this.creditsCccyamt == null)? 0 :this.creditsCccyamt.hashCode()));
        result = ((result* 31)+((this.outstandingBalancePlusPreviousCycleCccyamt == null)? 0 :this.outstandingBalancePlusPreviousCycleCccyamt.hashCode()));
        result = ((result* 31)+((this.financeChargeTypeCd == null)? 0 :this.financeChargeTypeCd.hashCode()));
        result = ((result* 31)+((this.appliedDebitsCccyamt == null)? 0 :this.appliedDebitsCccyamt.hashCode()));
        result = ((result* 31)+((this.financeChargeCreditsCccyamt == null)? 0 :this.financeChargeCreditsCccyamt.hashCode()));
        result = ((result* 31)+((this.outstandingFinanceChargeCccyamt == null)? 0 :this.outstandingFinanceChargeCccyamt.hashCode()));
        result = ((result* 31)+((this.outstandingBalancePaymentCccyamt == null)? 0 :this.outstandingBalancePaymentCccyamt.hashCode()));
        result = ((result* 31)+((this.debitsCccyamt == null)? 0 :this.debitsCccyamt.hashCode()));
        result = ((result* 31)+((this.previousPrincipleBalanceCccyamt == null)? 0 :this.previousPrincipleBalanceCccyamt.hashCode()));
        result = ((result* 31)+((this.debitAdjustmentCccyamt == null)? 0 :this.debitAdjustmentCccyamt.hashCode()));
        result = ((result* 31)+((this.appliedCreditsCccyamt == null)? 0 :this.appliedCreditsCccyamt.hashCode()));
        result = ((result* 31)+((this.averageDailyBalanceCccyamt == null)? 0 :this.averageDailyBalanceCccyamt.hashCode()));
        result = ((result* 31)+((this.averageDailyBalanceSubjectToChargeInd == null)? 0 :this.averageDailyBalanceSubjectToChargeInd.hashCode()));
        result = ((result* 31)+((this.previousOutstandingFinanceChargesSubjectToChargeInd == null)? 0 :this.previousOutstandingFinanceChargesSubjectToChargeInd.hashCode()));
        result = ((result* 31)+((this.termBalanceDesc == null)? 0 :this.termBalanceDesc.hashCode()));
        result = ((result* 31)+((this.billedFinanceChargeCccyamt == null)? 0 :this.billedFinanceChargeCccyamt.hashCode()));
        result = ((result* 31)+((this.outstandingFinanceChargesSubjectToChargeInd == null)? 0 :this.outstandingFinanceChargesSubjectToChargeInd.hashCode()));
        result = ((result* 31)+((this.previousOutstandingBalanceSubjectToChargeInd == null)? 0 :this.previousOutstandingBalanceSubjectToChargeInd.hashCode()));
        result = ((result* 31)+((this.termBalanceCd == null)? 0 :this.termBalanceCd.hashCode()));
        result = ((result* 31)+((this.outstandingBalanceCccyamt == null)? 0 :this.outstandingBalanceCccyamt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TransactionCategoryBalance) == false) {
            return false;
        }
        TransactionCategoryBalance rhs = ((TransactionCategoryBalance) other);
        return ((((((((((((((((((((((((((((this.averageDailyBalancePlusPreviousCycleCccyamt == rhs.averageDailyBalancePlusPreviousCycleCccyamt)||((this.averageDailyBalancePlusPreviousCycleCccyamt!= null)&&this.averageDailyBalancePlusPreviousCycleCccyamt.equals(rhs.averageDailyBalancePlusPreviousCycleCccyamt)))&&((this.financeChargeDebitsCccyamt == rhs.financeChargeDebitsCccyamt)||((this.financeChargeDebitsCccyamt!= null)&&this.financeChargeDebitsCccyamt.equals(rhs.financeChargeDebitsCccyamt))))&&((this.averageDailyBalanceFinanceChargeCccyamt == rhs.averageDailyBalanceFinanceChargeCccyamt)||((this.averageDailyBalanceFinanceChargeCccyamt!= null)&&this.averageDailyBalanceFinanceChargeCccyamt.equals(rhs.averageDailyBalanceFinanceChargeCccyamt))))&&((this.introductoryRatePromotionExpirationInd == rhs.introductoryRatePromotionExpirationInd)||((this.introductoryRatePromotionExpirationInd!= null)&&this.introductoryRatePromotionExpirationInd.equals(rhs.introductoryRatePromotionExpirationInd))))&&((this.creditAdjustmentCccyamt == rhs.creditAdjustmentCccyamt)||((this.creditAdjustmentCccyamt!= null)&&this.creditAdjustmentCccyamt.equals(rhs.creditAdjustmentCccyamt))))&&((this.transactionCategoryCd == rhs.transactionCategoryCd)||((this.transactionCategoryCd!= null)&&this.transactionCategoryCd.equals(rhs.transactionCategoryCd))))&&((this.annualPercentageRatePromotionExpirationDt == rhs.annualPercentageRatePromotionExpirationDt)||((this.annualPercentageRatePromotionExpirationDt!= null)&&this.annualPercentageRatePromotionExpirationDt.equals(rhs.annualPercentageRatePromotionExpirationDt))))&&((this.creditsCccyamt == rhs.creditsCccyamt)||((this.creditsCccyamt!= null)&&this.creditsCccyamt.equals(rhs.creditsCccyamt))))&&((this.outstandingBalancePlusPreviousCycleCccyamt == rhs.outstandingBalancePlusPreviousCycleCccyamt)||((this.outstandingBalancePlusPreviousCycleCccyamt!= null)&&this.outstandingBalancePlusPreviousCycleCccyamt.equals(rhs.outstandingBalancePlusPreviousCycleCccyamt))))&&((this.financeChargeTypeCd == rhs.financeChargeTypeCd)||((this.financeChargeTypeCd!= null)&&this.financeChargeTypeCd.equals(rhs.financeChargeTypeCd))))&&((this.appliedDebitsCccyamt == rhs.appliedDebitsCccyamt)||((this.appliedDebitsCccyamt!= null)&&this.appliedDebitsCccyamt.equals(rhs.appliedDebitsCccyamt))))&&((this.financeChargeCreditsCccyamt == rhs.financeChargeCreditsCccyamt)||((this.financeChargeCreditsCccyamt!= null)&&this.financeChargeCreditsCccyamt.equals(rhs.financeChargeCreditsCccyamt))))&&((this.outstandingFinanceChargeCccyamt == rhs.outstandingFinanceChargeCccyamt)||((this.outstandingFinanceChargeCccyamt!= null)&&this.outstandingFinanceChargeCccyamt.equals(rhs.outstandingFinanceChargeCccyamt))))&&((this.outstandingBalancePaymentCccyamt == rhs.outstandingBalancePaymentCccyamt)||((this.outstandingBalancePaymentCccyamt!= null)&&this.outstandingBalancePaymentCccyamt.equals(rhs.outstandingBalancePaymentCccyamt))))&&((this.debitsCccyamt == rhs.debitsCccyamt)||((this.debitsCccyamt!= null)&&this.debitsCccyamt.equals(rhs.debitsCccyamt))))&&((this.previousPrincipleBalanceCccyamt == rhs.previousPrincipleBalanceCccyamt)||((this.previousPrincipleBalanceCccyamt!= null)&&this.previousPrincipleBalanceCccyamt.equals(rhs.previousPrincipleBalanceCccyamt))))&&((this.debitAdjustmentCccyamt == rhs.debitAdjustmentCccyamt)||((this.debitAdjustmentCccyamt!= null)&&this.debitAdjustmentCccyamt.equals(rhs.debitAdjustmentCccyamt))))&&((this.appliedCreditsCccyamt == rhs.appliedCreditsCccyamt)||((this.appliedCreditsCccyamt!= null)&&this.appliedCreditsCccyamt.equals(rhs.appliedCreditsCccyamt))))&&((this.averageDailyBalanceCccyamt == rhs.averageDailyBalanceCccyamt)||((this.averageDailyBalanceCccyamt!= null)&&this.averageDailyBalanceCccyamt.equals(rhs.averageDailyBalanceCccyamt))))&&((this.averageDailyBalanceSubjectToChargeInd == rhs.averageDailyBalanceSubjectToChargeInd)||((this.averageDailyBalanceSubjectToChargeInd!= null)&&this.averageDailyBalanceSubjectToChargeInd.equals(rhs.averageDailyBalanceSubjectToChargeInd))))&&((this.previousOutstandingFinanceChargesSubjectToChargeInd == rhs.previousOutstandingFinanceChargesSubjectToChargeInd)||((this.previousOutstandingFinanceChargesSubjectToChargeInd!= null)&&this.previousOutstandingFinanceChargesSubjectToChargeInd.equals(rhs.previousOutstandingFinanceChargesSubjectToChargeInd))))&&((this.termBalanceDesc == rhs.termBalanceDesc)||((this.termBalanceDesc!= null)&&this.termBalanceDesc.equals(rhs.termBalanceDesc))))&&((this.billedFinanceChargeCccyamt == rhs.billedFinanceChargeCccyamt)||((this.billedFinanceChargeCccyamt!= null)&&this.billedFinanceChargeCccyamt.equals(rhs.billedFinanceChargeCccyamt))))&&((this.outstandingFinanceChargesSubjectToChargeInd == rhs.outstandingFinanceChargesSubjectToChargeInd)||((this.outstandingFinanceChargesSubjectToChargeInd!= null)&&this.outstandingFinanceChargesSubjectToChargeInd.equals(rhs.outstandingFinanceChargesSubjectToChargeInd))))&&((this.previousOutstandingBalanceSubjectToChargeInd == rhs.previousOutstandingBalanceSubjectToChargeInd)||((this.previousOutstandingBalanceSubjectToChargeInd!= null)&&this.previousOutstandingBalanceSubjectToChargeInd.equals(rhs.previousOutstandingBalanceSubjectToChargeInd))))&&((this.termBalanceCd == rhs.termBalanceCd)||((this.termBalanceCd!= null)&&this.termBalanceCd.equals(rhs.termBalanceCd))))&&((this.outstandingBalanceCccyamt == rhs.outstandingBalanceCccyamt)||((this.outstandingBalanceCccyamt!= null)&&this.outstandingBalanceCccyamt.equals(rhs.outstandingBalanceCccyamt))));
    }

}
