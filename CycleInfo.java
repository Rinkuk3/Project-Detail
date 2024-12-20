package com.td.api.mbcca.response.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.td.api.mbcca.shared.Cccyamt;


public class CycleInfo {

    private String previousDt;
    private String cycleDt;
    private BigDecimal balanceAmt;
    private BigDecimal previousBalanceAmt;
    private BigDecimal creditLimitAmt;
    private String paymentDueDt;
    private BigDecimal minimumPaymentAmt;
    private BigDecimal availableCreditLimitAmt;
    private FinancialChargeInfo financialChargeInfo;
    private List<PastDueInfo> pastDueInfo = new ArrayList<PastDueInfo>();
    private Cccyamt purchaseCccyamt;
    private String statementStartDt;
    private Cccyamt totalFeeChargeCccyamt;
    private String cycleSequenceNum;
    private String paymentStatusTypeCd;
    private Integer cycleDaysCnt;
    private BigDecimal calculatedMinimumPaymentAmt;
    private Cccyamt latePaymentFeeCccyamt;
    private Cccyamt frontEndFeeCccyamt;
    private Cccyamt annualMembershipFeeCccyamt;
    private Cccyamt overLimitFeeCccyamt;
    private Cccyamt checkReturnFeeCccyamt;
    private String statementInvoiceIndicatorCd;
    private List<TransactionCategory> transactionCategory = new ArrayList<TransactionCategory>();

    public String getPreviousDt() {
        return previousDt;
    }

    public void setPreviousDt(String previousDt) {
        this.previousDt = previousDt;
    }

    public String getCycleDt() {
        return cycleDt;
    }

    public void setCycleDt(String cycleDt) {
        this.cycleDt = cycleDt;
    }

    public BigDecimal getBalanceAmt() {
        return balanceAmt;
    }

    public void setBalanceAmt(BigDecimal balanceAmt) {
        this.balanceAmt = balanceAmt;
    }

    public BigDecimal getPreviousBalanceAmt() {
        return previousBalanceAmt;
    }

    public void setPreviousBalanceAmt(BigDecimal previousBalanceAmt) {
        this.previousBalanceAmt = previousBalanceAmt;
    }

    public BigDecimal getCreditLimitAmt() {
        return creditLimitAmt;
    }

    public void setCreditLimitAmt(BigDecimal creditLimitAmt) {
        this.creditLimitAmt = creditLimitAmt;
    }

    public String getPaymentDueDt() {
        return paymentDueDt;
    }

    public void setPaymentDueDt(String paymentDueDt) {
        this.paymentDueDt = paymentDueDt;
    }

    public BigDecimal getMinimumPaymentAmt() {
        return minimumPaymentAmt;
    }

    public void setMinimumPaymentAmt(BigDecimal minimumPaymentAmt) {
        this.minimumPaymentAmt = minimumPaymentAmt;
    }

    public BigDecimal getAvailableCreditLimitAmt() {
        return availableCreditLimitAmt;
    }

    public void setAvailableCreditLimitAmt(BigDecimal availableCreditLimitAmt) {
        this.availableCreditLimitAmt = availableCreditLimitAmt;
    }

    public FinancialChargeInfo getFinancialChargeInfo() {
        return financialChargeInfo;
    }

    public void setFinancialChargeInfo(FinancialChargeInfo financialChargeInfo) {
        this.financialChargeInfo = financialChargeInfo;
    }

    public List<PastDueInfo> getPastDueInfo() {
        return pastDueInfo;
    }

    public void setPastDueInfo(List<PastDueInfo> pastDueInfo) {
        this.pastDueInfo = pastDueInfo;
    }

    public Cccyamt getPurchaseCccyamt() {
        return purchaseCccyamt;
    }

    public void Cccyamt(Cccyamt purchaseCccyamt) {
        this.purchaseCccyamt = purchaseCccyamt;
    }

    public String getStatementStartDt() {
        return statementStartDt;
    }

    public void setStatementStartDt(String statementStartDt) {
        this.statementStartDt = statementStartDt;
    }

    public Cccyamt getTotalFeeChargeCccyamt() {
        return totalFeeChargeCccyamt;
    }

    public void setTotalFeeChargeCccyamt(Cccyamt totalFeeChargeCccyamt) {
        this.totalFeeChargeCccyamt = totalFeeChargeCccyamt;
    }

    public String getCycleSequenceNum() {
        return cycleSequenceNum;
    }

    public void setCycleSequenceNum(String cycleSequenceNum) {
        this.cycleSequenceNum = cycleSequenceNum;
    }

    public String getPaymentStatusTypeCd() {
        return paymentStatusTypeCd;
    }

    public void setPaymentStatusTypeCd(String paymentStatusTypeCd) {
        this.paymentStatusTypeCd = paymentStatusTypeCd;
    }

    public Integer getCycleDaysCnt() {
        return cycleDaysCnt;
    }

    public void setCycleDaysCnt(Integer cycleDaysCnt) {
        this.cycleDaysCnt = cycleDaysCnt;
    }

    public BigDecimal getCalculatedMinimumPaymentAmt() {
        return calculatedMinimumPaymentAmt;
    }

    public void setCalculatedMinimumPaymentAmt(BigDecimal calculatedMinimumPaymentAmt) {
        this.calculatedMinimumPaymentAmt = calculatedMinimumPaymentAmt;
    }

    public Cccyamt getLatePaymentFeeCccyamt() {
        return latePaymentFeeCccyamt;
    }

    public void setLatePaymentFeeCccyamt(Cccyamt latePaymentFeeCccyamt) {
        this.latePaymentFeeCccyamt = latePaymentFeeCccyamt;
    }

    public Cccyamt getFrontEndFeeCccyamt() {
        return frontEndFeeCccyamt;
    }

    public void setFrontEndFeeCccyamt(Cccyamt frontEndFeeCccyamt) {
        this.frontEndFeeCccyamt = frontEndFeeCccyamt;
    }

    public Cccyamt getAnnualMembershipFeeCccyamt() {
        return annualMembershipFeeCccyamt;
    }

    public void setAnnualMembershipFeeCccyamt(Cccyamt annualMembershipFeeCccyamt) {
        this.annualMembershipFeeCccyamt = annualMembershipFeeCccyamt;
    }

    public Cccyamt getOverLimitFeeCccyamt() {
        return overLimitFeeCccyamt;
    }

    public void setOverLimitFeeCccyamt(Cccyamt overLimitFeeCccyamt) {
        this.overLimitFeeCccyamt = overLimitFeeCccyamt;
    }

    public Cccyamt getCheckReturnFeeCccyamt() {
        return checkReturnFeeCccyamt;
    }

    public void setCheckReturnFeeCccyamt(Cccyamt checkReturnFeeCccyamt) {
        this.checkReturnFeeCccyamt = checkReturnFeeCccyamt;
    }

    public String getStatementInvoiceIndicatorCd() {
        return statementInvoiceIndicatorCd;
    }

    public void setStatementInvoiceIndicatorCd(String statementInvoiceIndicatorCd) {
        this.statementInvoiceIndicatorCd = statementInvoiceIndicatorCd;
    }

    public List<TransactionCategory> getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(List<TransactionCategory> transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CycleInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("previousDt");
        sb.append('=');
        sb.append(((this.previousDt == null)?"<null>":this.previousDt));
        sb.append(',');
        sb.append("cycleDt");
        sb.append('=');
        sb.append(((this.cycleDt == null)?"<null>":this.cycleDt));
        sb.append(',');
        sb.append("balanceAmt");
        sb.append('=');
        sb.append(((this.balanceAmt == null)?"<null>":this.balanceAmt));
        sb.append(',');
        sb.append("previousBalanceAmt");
        sb.append('=');
        sb.append(((this.previousBalanceAmt == null)?"<null>":this.previousBalanceAmt));
        sb.append(',');
        sb.append("creditLimitAmt");
        sb.append('=');
        sb.append(((this.creditLimitAmt == null)?"<null>":this.creditLimitAmt));
        sb.append(',');
        sb.append("paymentDueDt");
        sb.append('=');
        sb.append(((this.paymentDueDt == null)?"<null>":this.paymentDueDt));
        sb.append(',');
        sb.append("minimumPaymentAmt");
        sb.append('=');
        sb.append(((this.minimumPaymentAmt == null)?"<null>":this.minimumPaymentAmt));
        sb.append(',');
        sb.append("availableCreditLimitAmt");
        sb.append('=');
        sb.append(((this.availableCreditLimitAmt == null)?"<null>":this.availableCreditLimitAmt));
        sb.append(',');
        sb.append("financialChargeInfo");
        sb.append('=');
        sb.append(((this.financialChargeInfo == null)?"<null>":this.financialChargeInfo));
        sb.append(',');
        sb.append("pastDueInfo");
        sb.append('=');
        sb.append(((this.pastDueInfo == null)?"<null>":this.pastDueInfo));
        sb.append(',');
        sb.append("purchaseCccyamt");
        sb.append('=');
        sb.append(((this.purchaseCccyamt == null)?"<null>":this.purchaseCccyamt));
        sb.append(',');
        sb.append("statementStartDt");
        sb.append('=');
        sb.append(((this.statementStartDt == null)?"<null>":this.statementStartDt));
        sb.append(',');
        sb.append("totalFeeChargeCccyamt");
        sb.append('=');
        sb.append(((this.totalFeeChargeCccyamt == null)?"<null>":this.totalFeeChargeCccyamt));
        sb.append(',');
        sb.append("cycleSequenceNum");
        sb.append('=');
        sb.append(((this.cycleSequenceNum == null)?"<null>":this.cycleSequenceNum));
        sb.append(',');
        sb.append("paymentStatusTypeCd");
        sb.append('=');
        sb.append(((this.paymentStatusTypeCd == null)?"<null>":this.paymentStatusTypeCd));
        sb.append(',');
        sb.append("cycleDaysCnt");
        sb.append('=');
        sb.append(((this.cycleDaysCnt == null)?"<null>":this.cycleDaysCnt));
        sb.append(',');
        sb.append("calculatedMinimumPaymentAmt");
        sb.append('=');
        sb.append(((this.calculatedMinimumPaymentAmt == null)?"<null>":this.calculatedMinimumPaymentAmt));
        sb.append(',');
        sb.append("latePaymentFeeCccyamt");
        sb.append('=');
        sb.append(((this.latePaymentFeeCccyamt == null)?"<null>":this.latePaymentFeeCccyamt));
        sb.append(',');
        sb.append("frontEndFeeCccyamt");
        sb.append('=');
        sb.append(((this.frontEndFeeCccyamt == null)?"<null>":this.frontEndFeeCccyamt));
        sb.append(',');
        sb.append("annualMembershipFeeCccyamt");
        sb.append('=');
        sb.append(((this.annualMembershipFeeCccyamt == null)?"<null>":this.annualMembershipFeeCccyamt));
        sb.append(',');
        sb.append("overLimitFeeCccyamt");
        sb.append('=');
        sb.append(((this.overLimitFeeCccyamt == null)?"<null>":this.overLimitFeeCccyamt));
        sb.append(',');
        sb.append("checkReturnFeeCccyamt");
        sb.append('=');
        sb.append(((this.checkReturnFeeCccyamt == null)?"<null>":this.checkReturnFeeCccyamt));
        sb.append(',');
        sb.append("statementInvoiceIndicatorCd");
        sb.append('=');
        sb.append(((this.statementInvoiceIndicatorCd == null)?"<null>":this.statementInvoiceIndicatorCd));
        sb.append(',');
        sb.append("transactionCategory");
        sb.append('=');
        sb.append(((this.transactionCategory == null)?"<null>":this.transactionCategory));
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
        result = ((result* 31)+((this.statementInvoiceIndicatorCd == null)? 0 :this.statementInvoiceIndicatorCd.hashCode()));
        result = ((result* 31)+((this.financialChargeInfo == null)? 0 :this.financialChargeInfo.hashCode()));
        result = ((result* 31)+((this.availableCreditLimitAmt == null)? 0 :this.availableCreditLimitAmt.hashCode()));
        result = ((result* 31)+((this.calculatedMinimumPaymentAmt == null)? 0 :this.calculatedMinimumPaymentAmt.hashCode()));
        result = ((result* 31)+((this.balanceAmt == null)? 0 :this.balanceAmt.hashCode()));
        result = ((result* 31)+((this.frontEndFeeCccyamt == null)? 0 :this.frontEndFeeCccyamt.hashCode()));
        result = ((result* 31)+((this.cycleSequenceNum == null)? 0 :this.cycleSequenceNum.hashCode()));
        result = ((result* 31)+((this.creditLimitAmt == null)? 0 :this.creditLimitAmt.hashCode()));
        result = ((result* 31)+((this.checkReturnFeeCccyamt == null)? 0 :this.checkReturnFeeCccyamt.hashCode()));
        result = ((result* 31)+((this.transactionCategory == null)? 0 :this.transactionCategory.hashCode()));
        result = ((result* 31)+((this.paymentDueDt == null)? 0 :this.paymentDueDt.hashCode()));
        result = ((result* 31)+((this.purchaseCccyamt == null)? 0 :this.purchaseCccyamt.hashCode()));
        result = ((result* 31)+((this.minimumPaymentAmt == null)? 0 :this.minimumPaymentAmt.hashCode()));
        result = ((result* 31)+((this.latePaymentFeeCccyamt == null)? 0 :this.latePaymentFeeCccyamt.hashCode()));
        result = ((result* 31)+((this.previousBalanceAmt == null)? 0 :this.previousBalanceAmt.hashCode()));
        result = ((result* 31)+((this.overLimitFeeCccyamt == null)? 0 :this.overLimitFeeCccyamt.hashCode()));
        result = ((result* 31)+((this.previousDt == null)? 0 :this.previousDt.hashCode()));
        result = ((result* 31)+((this.pastDueInfo == null)? 0 :this.pastDueInfo.hashCode()));
        result = ((result* 31)+((this.statementStartDt == null)? 0 :this.statementStartDt.hashCode()));
        result = ((result* 31)+((this.totalFeeChargeCccyamt == null)? 0 :this.totalFeeChargeCccyamt.hashCode()));
        result = ((result* 31)+((this.paymentStatusTypeCd == null)? 0 :this.paymentStatusTypeCd.hashCode()));
        result = ((result* 31)+((this.cycleDt == null)? 0 :this.cycleDt.hashCode()));
        result = ((result* 31)+((this.cycleDaysCnt == null)? 0 :this.cycleDaysCnt.hashCode()));
        result = ((result* 31)+((this.annualMembershipFeeCccyamt == null)? 0 :this.annualMembershipFeeCccyamt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CycleInfo) == false) {
            return false;
        }
        CycleInfo rhs = ((CycleInfo) other);
        return (((((((((((((((((((((((((this.statementInvoiceIndicatorCd == rhs.statementInvoiceIndicatorCd)||((this.statementInvoiceIndicatorCd!= null)&&this.statementInvoiceIndicatorCd.equals(rhs.statementInvoiceIndicatorCd)))&&((this.financialChargeInfo == rhs.financialChargeInfo)||((this.financialChargeInfo!= null)&&this.financialChargeInfo.equals(rhs.financialChargeInfo))))&&((this.availableCreditLimitAmt == rhs.availableCreditLimitAmt)||((this.availableCreditLimitAmt!= null)&&this.availableCreditLimitAmt.equals(rhs.availableCreditLimitAmt))))&&((this.calculatedMinimumPaymentAmt == rhs.calculatedMinimumPaymentAmt)||((this.calculatedMinimumPaymentAmt!= null)&&this.calculatedMinimumPaymentAmt.equals(rhs.calculatedMinimumPaymentAmt))))&&((this.balanceAmt == rhs.balanceAmt)||((this.balanceAmt!= null)&&this.balanceAmt.equals(rhs.balanceAmt))))&&((this.frontEndFeeCccyamt == rhs.frontEndFeeCccyamt)||((this.frontEndFeeCccyamt!= null)&&this.frontEndFeeCccyamt.equals(rhs.frontEndFeeCccyamt))))&&((this.cycleSequenceNum == rhs.cycleSequenceNum)||((this.cycleSequenceNum!= null)&&this.cycleSequenceNum.equals(rhs.cycleSequenceNum))))&&((this.creditLimitAmt == rhs.creditLimitAmt)||((this.creditLimitAmt!= null)&&this.creditLimitAmt.equals(rhs.creditLimitAmt))))&&((this.checkReturnFeeCccyamt == rhs.checkReturnFeeCccyamt)||((this.checkReturnFeeCccyamt!= null)&&this.checkReturnFeeCccyamt.equals(rhs.checkReturnFeeCccyamt))))&&((this.transactionCategory == rhs.transactionCategory)||((this.transactionCategory!= null)&&this.transactionCategory.equals(rhs.transactionCategory))))&&((this.paymentDueDt == rhs.paymentDueDt)||((this.paymentDueDt!= null)&&this.paymentDueDt.equals(rhs.paymentDueDt))))&&((this.purchaseCccyamt == rhs.purchaseCccyamt)||((this.purchaseCccyamt!= null)&&this.purchaseCccyamt.equals(rhs.purchaseCccyamt))))&&((this.minimumPaymentAmt == rhs.minimumPaymentAmt)||((this.minimumPaymentAmt!= null)&&this.minimumPaymentAmt.equals(rhs.minimumPaymentAmt))))&&((this.latePaymentFeeCccyamt == rhs.latePaymentFeeCccyamt)||((this.latePaymentFeeCccyamt!= null)&&this.latePaymentFeeCccyamt.equals(rhs.latePaymentFeeCccyamt))))&&((this.previousBalanceAmt == rhs.previousBalanceAmt)||((this.previousBalanceAmt!= null)&&this.previousBalanceAmt.equals(rhs.previousBalanceAmt))))&&((this.overLimitFeeCccyamt == rhs.overLimitFeeCccyamt)||((this.overLimitFeeCccyamt!= null)&&this.overLimitFeeCccyamt.equals(rhs.overLimitFeeCccyamt))))&&((this.previousDt == rhs.previousDt)||((this.previousDt!= null)&&this.previousDt.equals(rhs.previousDt))))&&((this.pastDueInfo == rhs.pastDueInfo)||((this.pastDueInfo!= null)&&this.pastDueInfo.equals(rhs.pastDueInfo))))&&((this.statementStartDt == rhs.statementStartDt)||((this.statementStartDt!= null)&&this.statementStartDt.equals(rhs.statementStartDt))))&&((this.totalFeeChargeCccyamt == rhs.totalFeeChargeCccyamt)||((this.totalFeeChargeCccyamt!= null)&&this.totalFeeChargeCccyamt.equals(rhs.totalFeeChargeCccyamt))))&&((this.paymentStatusTypeCd == rhs.paymentStatusTypeCd)||((this.paymentStatusTypeCd!= null)&&this.paymentStatusTypeCd.equals(rhs.paymentStatusTypeCd))))&&((this.cycleDt == rhs.cycleDt)||((this.cycleDt!= null)&&this.cycleDt.equals(rhs.cycleDt))))&&((this.cycleDaysCnt == rhs.cycleDaysCnt)||((this.cycleDaysCnt!= null)&&this.cycleDaysCnt.equals(rhs.cycleDaysCnt))))&&((this.annualMembershipFeeCccyamt == rhs.annualMembershipFeeCccyamt)||((this.annualMembershipFeeCccyamt!= null)&&this.annualMembershipFeeCccyamt.equals(rhs.annualMembershipFeeCccyamt))));
    }

}
