package com.td.mbna.msec.midtier.creditcard.payload.increasecardlimit;

public class ResponsePayload {

    private Boolean status;
    private String confirmationNumber;
    private Boolean emailSent;
    private String creditLimitPrevAmtCurrency;
    private java.math.BigDecimal creditLimitPrevAmt;
    private String creditLimitNewAmtCurrency;
    private java.math.BigDecimal creditLimitNewAmt;
    private String tempLimitIndicator;
    private String cashLimitPrevAmtCurrency;
    private java.math.BigDecimal cashLimitPrevAmt;
    private String cashLimitNewAmtCurrency;
    private java.math.BigDecimal cashLimitNewAmt;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public Boolean getEmailSent() {
        return emailSent;
    }

    public void setEmailSent(Boolean emailSent) {
        this.emailSent = emailSent;
    }

    public String getCreditLimitPrevAmtCurrency() {
        return creditLimitPrevAmtCurrency;
    }

    public void setCreditLimitPrevAmtCurrency(String creditLimitPrevAmtCurrency) {
        this.creditLimitPrevAmtCurrency = creditLimitPrevAmtCurrency;
    }

    public java.math.BigDecimal getCreditLimitPrevAmt() {
        return creditLimitPrevAmt;
    }

    public void setCreditLimitPrevAmt(java.math.BigDecimal creditLimitPrevAmt) {
        this.creditLimitPrevAmt = creditLimitPrevAmt;
    }

    public String getCreditLimitNewAmtCurrency() {
        return creditLimitNewAmtCurrency;
    }

    public void setCreditLimitNewAmtCurrency(String creditLimitNewAmtCurrency) {
        this.creditLimitNewAmtCurrency = creditLimitNewAmtCurrency;
    }

    public java.math.BigDecimal getCreditLimitNewAmt() {
        return creditLimitNewAmt;
    }

    public void setCreditLimitNewAmt(java.math.BigDecimal creditLimitNewAmt) {
        this.creditLimitNewAmt = creditLimitNewAmt;
    }

    public String getTempLimitIndicator() {
        return tempLimitIndicator;
    }

    public void setTempLimitIndicator(String tempLimitIndicator) {
        this.tempLimitIndicator = tempLimitIndicator;
    }

    public String getCashLimitPrevAmtCurrency() {
        return cashLimitPrevAmtCurrency;
    }

    public void setCashLimitPrevAmtCurrency(String cashLimitPrevAmtCurrency) {
        this.cashLimitPrevAmtCurrency = cashLimitPrevAmtCurrency;
    }

    public java.math.BigDecimal getCashLimitPrevAmt() {
        return cashLimitPrevAmt;
    }

    public void setCashLimitPrevAmt(java.math.BigDecimal cashLimitPrevAmt) {
        this.cashLimitPrevAmt = cashLimitPrevAmt;
    }

    public String getCashLimitNewAmtCurrency() {
        return cashLimitNewAmtCurrency;
    }

    public void setCashLimitNewAmtCurrency(String cashLimitNewAmtCurrency) {
        this.cashLimitNewAmtCurrency = cashLimitNewAmtCurrency;
    }

    public java.math.BigDecimal getCashLimitNewAmt() {
        return cashLimitNewAmt;
    }

    public void setCashLimitNewAmt(java.math.BigDecimal cashLimitNewAmt) {
        this.cashLimitNewAmt = cashLimitNewAmt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ResponsePayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("confirmationNumber");
        sb.append('=');
        sb.append(((this.confirmationNumber == null)?"<null>":this.confirmationNumber));
        sb.append(',');
        sb.append("emailSent");
        sb.append('=');
        sb.append(((this.emailSent == null)?"<null>":this.emailSent));
        sb.append(',');
        sb.append("creditLimitPrevAmtCurrency");
        sb.append('=');
        sb.append(((this.creditLimitPrevAmtCurrency == null)?"<null>":this.creditLimitPrevAmtCurrency));
        sb.append(',');
        sb.append("creditLimitPrevAmt");
        sb.append('=');
        sb.append(((this.creditLimitPrevAmt == null)?"<null>":this.creditLimitPrevAmt));
        sb.append(',');
        sb.append("creditLimitNewAmtCurrency");
        sb.append('=');
        sb.append(((this.creditLimitNewAmtCurrency == null)?"<null>":this.creditLimitNewAmtCurrency));
        sb.append(',');
        sb.append("creditLimitNewAmt");
        sb.append('=');
        sb.append(((this.creditLimitNewAmt == null)?"<null>":this.creditLimitNewAmt));
        sb.append(',');
        sb.append("tempLimitIndicator");
        sb.append('=');
        sb.append(((this.tempLimitIndicator == null)?"<null>":this.tempLimitIndicator));
        sb.append(',');
        sb.append("cashLimitPrevAmtCurrency");
        sb.append('=');
        sb.append(((this.cashLimitPrevAmtCurrency == null)?"<null>":this.cashLimitPrevAmtCurrency));
        sb.append(',');
        sb.append("cashLimitPrevAmt");
        sb.append('=');
        sb.append(((this.cashLimitPrevAmt == null)?"<null>":this.cashLimitPrevAmt));
        sb.append(',');
        sb.append("cashLimitNewAmtCurrency");
        sb.append('=');
        sb.append(((this.cashLimitNewAmtCurrency == null)?"<null>":this.cashLimitNewAmtCurrency));
        sb.append(',');
        sb.append("cashLimitNewAmt");
        sb.append('=');
        sb.append(((this.cashLimitNewAmt == null)?"<null>":this.cashLimitNewAmt));
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
        result = ((result* 31)+((this.tempLimitIndicator == null)? 0 :this.tempLimitIndicator.hashCode()));
        result = ((result* 31)+((this.creditLimitPrevAmt == null)? 0 :this.creditLimitPrevAmt.hashCode()));
        result = ((result* 31)+((this.cashLimitNewAmtCurrency == null)? 0 :this.cashLimitNewAmtCurrency.hashCode()));
        result = ((result* 31)+((this.creditLimitNewAmt == null)? 0 :this.creditLimitNewAmt.hashCode()));
        result = ((result* 31)+((this.creditLimitNewAmtCurrency == null)? 0 :this.creditLimitNewAmtCurrency.hashCode()));
        result = ((result* 31)+((this.cashLimitPrevAmtCurrency == null)? 0 :this.cashLimitPrevAmtCurrency.hashCode()));
        result = ((result* 31)+((this.creditLimitPrevAmtCurrency == null)? 0 :this.creditLimitPrevAmtCurrency.hashCode()));
        result = ((result* 31)+((this.cashLimitNewAmt == null)? 0 :this.cashLimitNewAmt.hashCode()));
        result = ((result* 31)+((this.confirmationNumber == null)? 0 :this.confirmationNumber.hashCode()));
        result = ((result* 31)+((this.emailSent == null)? 0 :this.emailSent.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        result = ((result* 31)+((this.cashLimitPrevAmt == null)? 0 :this.cashLimitPrevAmt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResponsePayload) == false) {
            return false;
        }
        ResponsePayload rhs = ((ResponsePayload) other);
        return (((((((((((((this.tempLimitIndicator == rhs.tempLimitIndicator)||((this.tempLimitIndicator!= null)&&this.tempLimitIndicator.equals(rhs.tempLimitIndicator)))&&((this.creditLimitPrevAmt == rhs.creditLimitPrevAmt)||((this.creditLimitPrevAmt!= null)&&this.creditLimitPrevAmt.equals(rhs.creditLimitPrevAmt))))&&((this.cashLimitNewAmtCurrency == rhs.cashLimitNewAmtCurrency)||((this.cashLimitNewAmtCurrency!= null)&&this.cashLimitNewAmtCurrency.equals(rhs.cashLimitNewAmtCurrency))))&&((this.creditLimitNewAmt == rhs.creditLimitNewAmt)||((this.creditLimitNewAmt!= null)&&this.creditLimitNewAmt.equals(rhs.creditLimitNewAmt))))&&((this.creditLimitNewAmtCurrency == rhs.creditLimitNewAmtCurrency)||((this.creditLimitNewAmtCurrency!= null)&&this.creditLimitNewAmtCurrency.equals(rhs.creditLimitNewAmtCurrency))))&&((this.cashLimitPrevAmtCurrency == rhs.cashLimitPrevAmtCurrency)||((this.cashLimitPrevAmtCurrency!= null)&&this.cashLimitPrevAmtCurrency.equals(rhs.cashLimitPrevAmtCurrency))))&&((this.creditLimitPrevAmtCurrency == rhs.creditLimitPrevAmtCurrency)||((this.creditLimitPrevAmtCurrency!= null)&&this.creditLimitPrevAmtCurrency.equals(rhs.creditLimitPrevAmtCurrency))))&&((this.cashLimitNewAmt == rhs.cashLimitNewAmt)||((this.cashLimitNewAmt!= null)&&this.cashLimitNewAmt.equals(rhs.cashLimitNewAmt))))&&((this.confirmationNumber == rhs.confirmationNumber)||((this.confirmationNumber!= null)&&this.confirmationNumber.equals(rhs.confirmationNumber))))&&((this.emailSent == rhs.emailSent)||((this.emailSent!= null)&&this.emailSent.equals(rhs.emailSent))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))))&&((this.cashLimitPrevAmt == rhs.cashLimitPrevAmt)||((this.cashLimitPrevAmt!= null)&&this.cashLimitPrevAmt.equals(rhs.cashLimitPrevAmt))));
    }

}
