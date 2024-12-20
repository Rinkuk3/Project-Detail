package com.td.api.ofm.common;

public class TCCAAPITransactionDetail {

    private String transactionDt;
    private String referenceNum;
    private String receiptNum;
    private String transactionCd;
    private String cashOptionCd;

    public String getTransactionDt() {
        return transactionDt;
    }

    public void setTransactionDt(String transactionDt) {
        this.transactionDt = transactionDt;
    }

    public String getReferenceNum() {
        return referenceNum;
    }

    public void setReferenceNum(String referenceNum) {
        this.referenceNum = referenceNum;
    }

    public String getReceiptNum() {
        return receiptNum;
    }

    public void setReceiptNum(String receiptNum) {
        this.receiptNum = receiptNum;
    }

    public String getTransactionCd() {
        return transactionCd;
    }

    public void setTransactionCd(String transactionCd) {
        this.transactionCd = transactionCd;
    }

    public String getCashOptionCd() {
        return cashOptionCd;
    }

    public void setCashOptionCd(String cashOptionCd) {
        this.cashOptionCd = cashOptionCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TCCAAPITransactionDetail.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("transactionDt");
        sb.append('=');
        sb.append(((this.transactionDt == null)?"<null>":this.transactionDt));
        sb.append(',');
        sb.append("referenceNum");
        sb.append('=');
        sb.append(((this.referenceNum == null)?"<null>":this.referenceNum));
        sb.append(',');
        sb.append("receiptNum");
        sb.append('=');
        sb.append(((this.receiptNum == null)?"<null>":this.receiptNum));
        sb.append(',');
        sb.append("transactionCd");
        sb.append('=');
        sb.append(((this.transactionCd == null)?"<null>":this.transactionCd));
        sb.append(',');
        sb.append("cashOptionCd");
        sb.append('=');
        sb.append(((this.cashOptionCd == null)?"<null>":this.cashOptionCd));
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
        result = ((result* 31)+((this.referenceNum == null)? 0 :this.referenceNum.hashCode()));
        result = ((result* 31)+((this.transactionCd == null)? 0 :this.transactionCd.hashCode()));
        result = ((result* 31)+((this.transactionDt == null)? 0 :this.transactionDt.hashCode()));
        result = ((result* 31)+((this.cashOptionCd == null)? 0 :this.cashOptionCd.hashCode()));
        result = ((result* 31)+((this.receiptNum == null)? 0 :this.receiptNum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TCCAAPITransactionDetail) == false) {
            return false;
        }
        TCCAAPITransactionDetail rhs = ((TCCAAPITransactionDetail) other);
        return ((((((this.referenceNum == rhs.referenceNum)||((this.referenceNum!= null)&&this.referenceNum.equals(rhs.referenceNum)))&&((this.transactionCd == rhs.transactionCd)||((this.transactionCd!= null)&&this.transactionCd.equals(rhs.transactionCd))))&&((this.transactionDt == rhs.transactionDt)||((this.transactionDt!= null)&&this.transactionDt.equals(rhs.transactionDt))))&&((this.cashOptionCd == rhs.cashOptionCd)||((this.cashOptionCd!= null)&&this.cashOptionCd.equals(rhs.cashOptionCd))))&&((this.receiptNum == rhs.receiptNum)||((this.receiptNum!= null)&&this.receiptNum.equals(rhs.receiptNum))));
    }

}
