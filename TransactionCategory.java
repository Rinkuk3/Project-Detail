package com.td.api.mbcca.response.account;

import com.td.api.mbcca.shared.Cccyamt;

public class TransactionCategory {

    private String typeCd;
    private Cccyamt cycleToDateBalanceCccyamt;
    private Cccyamt averageDailyBalanceCccyamt;
    private Cccyamt outstandingFinanceChargeCccyamt;
    private String transactionSpecialProcessingExpiryDt;
    private TermBalance termBalance;

    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    public Cccyamt getCycleToDateBalanceCccyamt() {
        return cycleToDateBalanceCccyamt;
    }

    public void setCycleToDateBalanceCccyamt(Cccyamt cycleToDateBalanceCccyamt) {
        this.cycleToDateBalanceCccyamt = cycleToDateBalanceCccyamt;
    }

    public Cccyamt getAverageDailyBalanceCccyamt() {
        return averageDailyBalanceCccyamt;
    }

    public void setAverageDailyBalanceCccyamt(Cccyamt averageDailyBalanceCccyamt) {
        this.averageDailyBalanceCccyamt = averageDailyBalanceCccyamt;
    }

    public Cccyamt getOutstandingFinanceChargeCccyamt() {
        return outstandingFinanceChargeCccyamt;
    }

    public void setOutstandingFinanceChargeCccyamt(Cccyamt outstandingFinanceChargeCccyamt) {
        this.outstandingFinanceChargeCccyamt = outstandingFinanceChargeCccyamt;
    }

    public String getTransactionSpecialProcessingExpiryDt() {
        return transactionSpecialProcessingExpiryDt;
    }

    public void setTransactionSpecialProcessingExpiryDt(String transactionSpecialProcessingExpiryDt) {
        this.transactionSpecialProcessingExpiryDt = transactionSpecialProcessingExpiryDt;
    }

    public TermBalance getTermBalance() {
        return termBalance;
    }

    public void setTermBalance(TermBalance termBalance) {
        this.termBalance = termBalance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TransactionCategory.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("typeCd");
        sb.append('=');
        sb.append(((this.typeCd == null)?"<null>":this.typeCd));
        sb.append(',');
        sb.append("cycleToDateBalanceCccyamt");
        sb.append('=');
        sb.append(((this.cycleToDateBalanceCccyamt == null)?"<null>":this.cycleToDateBalanceCccyamt));
        sb.append(',');
        sb.append("averageDailyBalanceCccyamt");
        sb.append('=');
        sb.append(((this.averageDailyBalanceCccyamt == null)?"<null>":this.averageDailyBalanceCccyamt));
        sb.append(',');
        sb.append("outstandingFinanceChargeCccyamt");
        sb.append('=');
        sb.append(((this.outstandingFinanceChargeCccyamt == null)?"<null>":this.outstandingFinanceChargeCccyamt));
        sb.append(',');
        sb.append("transactionSpecialProcessingExpiryDt");
        sb.append('=');
        sb.append(((this.transactionSpecialProcessingExpiryDt == null)?"<null>":this.transactionSpecialProcessingExpiryDt));
        sb.append(',');
        sb.append("termBalance");
        sb.append('=');
        sb.append(((this.termBalance == null)?"<null>":this.termBalance));
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
        result = ((result* 31)+((this.transactionSpecialProcessingExpiryDt == null)? 0 :this.transactionSpecialProcessingExpiryDt.hashCode()));
        result = ((result* 31)+((this.typeCd == null)? 0 :this.typeCd.hashCode()));
        result = ((result* 31)+((this.termBalance == null)? 0 :this.termBalance.hashCode()));
        result = ((result* 31)+((this.cycleToDateBalanceCccyamt == null)? 0 :this.cycleToDateBalanceCccyamt.hashCode()));
        result = ((result* 31)+((this.averageDailyBalanceCccyamt == null)? 0 :this.averageDailyBalanceCccyamt.hashCode()));
        result = ((result* 31)+((this.outstandingFinanceChargeCccyamt == null)? 0 :this.outstandingFinanceChargeCccyamt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TransactionCategory) == false) {
            return false;
        }
        TransactionCategory rhs = ((TransactionCategory) other);
        return (((((((this.transactionSpecialProcessingExpiryDt == rhs.transactionSpecialProcessingExpiryDt)||((this.transactionSpecialProcessingExpiryDt!= null)&&this.transactionSpecialProcessingExpiryDt.equals(rhs.transactionSpecialProcessingExpiryDt)))&&((this.typeCd == rhs.typeCd)||((this.typeCd!= null)&&this.typeCd.equals(rhs.typeCd))))&&((this.termBalance == rhs.termBalance)||((this.termBalance!= null)&&this.termBalance.equals(rhs.termBalance))))&&((this.cycleToDateBalanceCccyamt == rhs.cycleToDateBalanceCccyamt)||((this.cycleToDateBalanceCccyamt!= null)&&this.cycleToDateBalanceCccyamt.equals(rhs.cycleToDateBalanceCccyamt))))&&((this.averageDailyBalanceCccyamt == rhs.averageDailyBalanceCccyamt)||((this.averageDailyBalanceCccyamt!= null)&&this.averageDailyBalanceCccyamt.equals(rhs.averageDailyBalanceCccyamt))))&&((this.outstandingFinanceChargeCccyamt == rhs.outstandingFinanceChargeCccyamt)||((this.outstandingFinanceChargeCccyamt!= null)&&this.outstandingFinanceChargeCccyamt.equals(rhs.outstandingFinanceChargeCccyamt))));
    }

}
