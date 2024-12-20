package com.td.api.ofm.common;

import java.math.BigDecimal;

public class TCCAAPIBalanceSegmentEventAdjustment {

    private String typeCd;
    BigDecimal transactionAmt;
    private TCCAAPICreditCardAgreementKey creditCardAgreement;
    private TCCAAPIBalanceSegment balanceSegment;
    private TCCAAPITransaction originalTransaction;

    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    public BigDecimal getTransactionAmt() {
        return transactionAmt;
    }

    public void setTransactionAmt(BigDecimal transactionAmt) {
        this.transactionAmt = transactionAmt;
    }

    public TCCAAPICreditCardAgreementKey getCreditCardAgreement() {
        return creditCardAgreement;
    }

    public void setCreditCardAgreement(TCCAAPICreditCardAgreementKey creditCardAgreement) {
        this.creditCardAgreement = creditCardAgreement;
    }

    public TCCAAPIBalanceSegment getBalanceSegment() {
        return balanceSegment;
    }

    public void setBalanceSegment(TCCAAPIBalanceSegment balanceSegment) {
        this.balanceSegment = balanceSegment;
    }

    public TCCAAPITransaction getOriginalTransaction() {
        return originalTransaction;
    }

    public void setOriginalTransaction(TCCAAPITransaction originalTransaction) {
        this.originalTransaction = originalTransaction;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TCCAAPIBalanceSegmentEventAdjustment.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("typeCd");
        sb.append('=');
        sb.append(((this.typeCd == null)?"<null>":this.typeCd));
        sb.append(',');
        sb.append("transactionAmt");
        sb.append('=');
        sb.append(((this.transactionAmt == null)?"<null>":this.transactionAmt));
        sb.append(',');
        sb.append("creditCardAgreement");
        sb.append('=');
        sb.append(((this.creditCardAgreement == null)?"<null>":this.creditCardAgreement));
        sb.append(',');
        sb.append("balanceSegment");
        sb.append('=');
        sb.append(((this.balanceSegment == null)?"<null>":this.balanceSegment));
        sb.append(',');
        sb.append("originalTransaction");
        sb.append('=');
        sb.append(((this.originalTransaction == null)?"<null>":this.originalTransaction));
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
        result = ((result* 31)+((this.balanceSegment == null)? 0 :this.balanceSegment.hashCode()));
        result = ((result* 31)+((this.transactionAmt == null)? 0 :this.transactionAmt.hashCode()));
        result = ((result* 31)+((this.typeCd == null)? 0 :this.typeCd.hashCode()));
        result = ((result* 31)+((this.creditCardAgreement == null)? 0 :this.creditCardAgreement.hashCode()));
        result = ((result* 31)+((this.originalTransaction == null)? 0 :this.originalTransaction.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TCCAAPIBalanceSegmentEventAdjustment) == false) {
            return false;
        }
        TCCAAPIBalanceSegmentEventAdjustment rhs = ((TCCAAPIBalanceSegmentEventAdjustment) other);
        return ((((((this.balanceSegment == rhs.balanceSegment)||((this.balanceSegment!= null)&&this.balanceSegment.equals(rhs.balanceSegment)))&&((this.transactionAmt == rhs.transactionAmt)||((this.transactionAmt!= null)&&this.transactionAmt.equals(rhs.transactionAmt))))&&((this.typeCd == rhs.typeCd)||((this.typeCd!= null)&&this.typeCd.equals(rhs.typeCd))))&&((this.creditCardAgreement == rhs.creditCardAgreement)||((this.creditCardAgreement!= null)&&this.creditCardAgreement.equals(rhs.creditCardAgreement))))&&((this.originalTransaction == rhs.originalTransaction)||((this.originalTransaction!= null)&&this.originalTransaction.equals(rhs.originalTransaction))));
    }

}
