package com.td.api.ofm.common;

public class TCCAAPICreditCardAgreementKey {

    private String agreementId;
    private String creditCardNum;

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public String getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(String creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TCCAAPICreditCardAgreementKey.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("agreementId");
        sb.append('=');
        sb.append(((this.agreementId == null)?"<null>":this.agreementId));
        sb.append(',');
        sb.append("creditCardNum");
        sb.append('=');
        sb.append(((this.creditCardNum == null)?"<null>":this.creditCardNum));
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
        result = ((result* 31)+((this.agreementId == null)? 0 :this.agreementId.hashCode()));
        result = ((result* 31)+((this.creditCardNum == null)? 0 :this.creditCardNum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TCCAAPICreditCardAgreementKey) == false) {
            return false;
        }
        TCCAAPICreditCardAgreementKey rhs = ((TCCAAPICreditCardAgreementKey) other);
        return (((this.agreementId == rhs.agreementId)||((this.agreementId!= null)&&this.agreementId.equals(rhs.agreementId)))&&((this.creditCardNum == rhs.creditCardNum)||((this.creditCardNum!= null)&&this.creditCardNum.equals(rhs.creditCardNum))));
    }

}
