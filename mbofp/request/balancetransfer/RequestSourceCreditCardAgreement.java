package com.td.api.mbofp.request.balancetransfer;

public class RequestSourceCreditCardAgreement {

    private String cardNum;
    private String agreementId;

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestSourceCreditCardAgreement.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cardNum");
        sb.append('=');
        sb.append(((this.cardNum == null)?"<null>":this.cardNum));
        sb.append(',');
        sb.append("agreementId");
        sb.append('=');
        sb.append(((this.agreementId == null)?"<null>":this.agreementId));
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
        result = ((result* 31)+((this.cardNum == null)? 0 :this.cardNum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestSourceCreditCardAgreement) == false) {
            return false;
        }
        RequestSourceCreditCardAgreement rhs = ((RequestSourceCreditCardAgreement) other);
        return (((this.agreementId == rhs.agreementId)||((this.agreementId!= null)&&this.agreementId.equals(rhs.agreementId)))&&((this.cardNum == rhs.cardNum)||((this.cardNum!= null)&&this.cardNum.equals(rhs.cardNum))));
    }

}
