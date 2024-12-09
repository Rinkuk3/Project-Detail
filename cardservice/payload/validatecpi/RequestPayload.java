package com.td.mbna.msec.midtier.cardservice.payload.validatecpi;

public class RequestPayload {

    private String custId;
    private String acctId;
    private String cardNum;
    private String cvc;
    private Integer expiryMonth;
    private String expiryYear;
    private String realExpiryMonth;
    private String realExpiryYear;
    private String email;
    private Boolean emailRequired;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public Integer getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(Integer expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getRealExpiryMonth() {
        return realExpiryMonth;
    }

    public void setRealExpiryMonth(String realExpiryMonth) {
        this.realExpiryMonth = realExpiryMonth;
    }

    public String getRealExpiryYear() {
        return realExpiryYear;
    }

    public void setRealExpiryYear(String realExpiryYear) {
        this.realExpiryYear = realExpiryYear;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEmailRequired() {
        return emailRequired;
    }

    public void setEmailRequired(Boolean emailRequired) {
        this.emailRequired = emailRequired;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("custId");
        sb.append('=');
        sb.append(((this.custId == null)?"<null>":this.custId));
        sb.append(',');
        sb.append("acctId");
        sb.append('=');
        sb.append(((this.acctId == null)?"<null>":this.acctId));
        sb.append(',');
        sb.append("cardNum");
        sb.append('=');
        sb.append(((this.cardNum == null)?"<null>":this.cardNum));
        sb.append(',');
        sb.append("cvc");
        sb.append('=');
        sb.append(((this.cvc == null)?"<null>":this.cvc));
        sb.append(',');
        sb.append("expiryMonth");
        sb.append('=');
        sb.append(((this.expiryMonth == null)?"<null>":this.expiryMonth));
        sb.append(',');
        sb.append("expiryYear");
        sb.append('=');
        sb.append(((this.expiryYear == null)?"<null>":this.expiryYear));
        sb.append(',');
        sb.append("realExpiryMonth");
        sb.append('=');
        sb.append(((this.realExpiryMonth == null)?"<null>":this.realExpiryMonth));
        sb.append(',');
        sb.append("realExpiryYear");
        sb.append('=');
        sb.append(((this.realExpiryYear == null)?"<null>":this.realExpiryYear));
        sb.append(',');
        sb.append("email");
        sb.append('=');
        sb.append(((this.email == null)?"<null>":this.email));
        sb.append(',');
        sb.append("emailRequired");
        sb.append('=');
        sb.append(((this.emailRequired == null)?"<null>":this.emailRequired));
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
        result = ((result* 31)+((this.cvc == null)? 0 :this.cvc.hashCode()));
        result = ((result* 31)+((this.cardNum == null)? 0 :this.cardNum.hashCode()));
        result = ((result* 31)+((this.realExpiryMonth == null)? 0 :this.realExpiryMonth.hashCode()));
        result = ((result* 31)+((this.realExpiryYear == null)? 0 :this.realExpiryYear.hashCode()));
        result = ((result* 31)+((this.custId == null)? 0 :this.custId.hashCode()));
        result = ((result* 31)+((this.expiryMonth == null)? 0 :this.expiryMonth.hashCode()));
        result = ((result* 31)+((this.acctId == null)? 0 :this.acctId.hashCode()));
        result = ((result* 31)+((this.expiryYear == null)? 0 :this.expiryYear.hashCode()));
        result = ((result* 31)+((this.emailRequired == null)? 0 :this.emailRequired.hashCode()));
        result = ((result* 31)+((this.email == null)? 0 :this.email.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestPayload) == false) {
            return false;
        }
        RequestPayload rhs = ((RequestPayload) other);
        return (((((((((((this.cvc == rhs.cvc)||((this.cvc!= null)&&this.cvc.equals(rhs.cvc)))&&((this.cardNum == rhs.cardNum)||((this.cardNum!= null)&&this.cardNum.equals(rhs.cardNum))))&&((this.realExpiryMonth == rhs.realExpiryMonth)||((this.realExpiryMonth!= null)&&this.realExpiryMonth.equals(rhs.realExpiryMonth))))&&((this.realExpiryYear == rhs.realExpiryYear)||((this.realExpiryYear!= null)&&this.realExpiryYear.equals(rhs.realExpiryYear))))&&((this.custId == rhs.custId)||((this.custId!= null)&&this.custId.equals(rhs.custId))))&&((this.expiryMonth == rhs.expiryMonth)||((this.expiryMonth!= null)&&this.expiryMonth.equals(rhs.expiryMonth))))&&((this.acctId == rhs.acctId)||((this.acctId!= null)&&this.acctId.equals(rhs.acctId))))&&((this.expiryYear == rhs.expiryYear)||((this.expiryYear!= null)&&this.expiryYear.equals(rhs.expiryYear))))&&((this.emailRequired == rhs.emailRequired)||((this.emailRequired!= null)&&this.emailRequired.equals(rhs.emailRequired))))&&((this.email == rhs.email)||((this.email!= null)&&this.email.equals(rhs.email))));
    }

}
