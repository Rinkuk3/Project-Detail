package com.td.api.mbcca.creditcard.request;

public class PartialUpdateCreditCardAgreementRq {

    private CreditCardAgreement creditCardAgreement;

    public CreditCardAgreement getCreditCardAgreement() {
        return creditCardAgreement;
    }

    public void setCreditCardAgreement(CreditCardAgreement creditCardAgreement) {
        this.creditCardAgreement = creditCardAgreement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PartialUpdateCreditCardAgreementRq.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("creditCardAgreement");
        sb.append('=');
        sb.append(((this.creditCardAgreement == null)?"<null>":this.creditCardAgreement));
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
        result = ((result* 31)+((this.creditCardAgreement == null)? 0 :this.creditCardAgreement.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PartialUpdateCreditCardAgreementRq) == false) {
            return false;
        }
        PartialUpdateCreditCardAgreementRq rhs = ((PartialUpdateCreditCardAgreementRq) other);
        return ((this.creditCardAgreement == rhs.creditCardAgreement)||((this.creditCardAgreement!= null)&&this.creditCardAgreement.equals(rhs.creditCardAgreement)));
    }

}
