package com.td.mbna.msec.midtier.transfer.payload;

import java.math.BigDecimal;

public class BalanceTransferToCreditorSummaryType {

    private BigDecimal transferAmt;
    private BigDecimal transferFee;
    private BigDecimal creditRemaining;

    public BigDecimal getTransferAmt() {
        return transferAmt;
    }

    public void setTransferAmt(BigDecimal transferAmt) {
        this.transferAmt = transferAmt;
    }

    public BigDecimal getTransferFee() {
        return transferFee;
    }

    public void setTransferFee(BigDecimal transferFee) {
        this.transferFee = transferFee;
    }

    public BigDecimal getCreditRemaining() {
        return creditRemaining;
    }

    public void setCreditRemaining(BigDecimal creditRemaining) {
        this.creditRemaining = creditRemaining;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BalanceTransferToCreditorSummaryType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("transferAmt");
        sb.append('=');
        sb.append(((this.transferAmt == null)?"<null>":this.transferAmt));
        sb.append(',');
        sb.append("transferFee");
        sb.append('=');
        sb.append(((this.transferFee == null)?"<null>":this.transferFee));
        sb.append(',');
        sb.append("creditRemaining");
        sb.append('=');
        sb.append(((this.creditRemaining == null)?"<null>":this.creditRemaining));
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
        result = ((result* 31)+((this.transferFee == null)? 0 :this.transferFee.hashCode()));
        result = ((result* 31)+((this.transferAmt == null)? 0 :this.transferAmt.hashCode()));
        result = ((result* 31)+((this.creditRemaining == null)? 0 :this.creditRemaining.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BalanceTransferToCreditorSummaryType) == false) {
            return false;
        }
        BalanceTransferToCreditorSummaryType rhs = ((BalanceTransferToCreditorSummaryType) other);
        return ((((this.transferFee == rhs.transferFee)||((this.transferFee!= null)&&this.transferFee.equals(rhs.transferFee)))&&((this.transferAmt == rhs.transferAmt)||((this.transferAmt!= null)&&this.transferAmt.equals(rhs.transferAmt))))&&((this.creditRemaining == rhs.creditRemaining)||((this.creditRemaining!= null)&&this.creditRemaining.equals(rhs.creditRemaining))));
    }

}
