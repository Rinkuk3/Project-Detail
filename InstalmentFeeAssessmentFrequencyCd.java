package com.td.api.mbcca.response.account;

import java.math.BigDecimal;

public class InstalmentFeeAssessmentFrequencyCd {

    BigDecimal amount;
    private String currencyCd;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(InstalmentFeeAssessmentFrequencyCd.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("amount");
        sb.append('=');
        sb.append(((this.amount == null)?"<null>":this.amount));
        sb.append(',');
        sb.append("currencyCd");
        sb.append('=');
        sb.append(((this.currencyCd == null)?"<null>":this.currencyCd));
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
        result = ((result* 31)+((this.amount == null)? 0 :this.amount.hashCode()));
        result = ((result* 31)+((this.currencyCd == null)? 0 :this.currencyCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof InstalmentFeeAssessmentFrequencyCd) == false) {
            return false;
        }
        InstalmentFeeAssessmentFrequencyCd rhs = ((InstalmentFeeAssessmentFrequencyCd) other);
        return (((this.amount == rhs.amount)||((this.amount!= null)&&this.amount.equals(rhs.amount)))&&((this.currencyCd == rhs.currencyCd)||((this.currencyCd!= null)&&this.currencyCd.equals(rhs.currencyCd))));
    }

}
