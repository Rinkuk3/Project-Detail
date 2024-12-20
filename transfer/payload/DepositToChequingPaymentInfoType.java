package com.td.mbna.msec.midtier.transfer.payload;

import java.math.BigDecimal;

public class DepositToChequingPaymentInfoType {

    private DepositToChequingPayeeType payee;
    private BigDecimal amount;

    public DepositToChequingPayeeType getPayee() {
        return payee;
    }

    public void setPayee(DepositToChequingPayeeType payee) {
        this.payee = payee;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DepositToChequingPaymentInfoType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("payee");
        sb.append('=');
        sb.append(((this.payee == null)?"<null>":this.payee));
        sb.append(',');
        sb.append("amount");
        sb.append('=');
        sb.append(((this.amount == null)?"<null>":this.amount));
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
        result = ((result* 31)+((this.payee == null)? 0 :this.payee.hashCode()));
        result = ((result* 31)+((this.amount == null)? 0 :this.amount.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DepositToChequingPaymentInfoType) == false) {
            return false;
        }
        DepositToChequingPaymentInfoType rhs = ((DepositToChequingPaymentInfoType) other);
        return (((this.payee == rhs.payee)||((this.payee!= null)&&this.payee.equals(rhs.payee)))&&((this.amount == rhs.amount)||((this.amount!= null)&&this.amount.equals(rhs.amount))));
    }

}
