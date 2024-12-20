package com.td.api.mbofp.request.updateofferdisposition;

public class PromotionOfferToAgreement {

    private AgreementIdentification agreementIdentification;

    public AgreementIdentification getAgreementIdentification() {
        return agreementIdentification;
    }

    public void setAgreementIdentification(AgreementIdentification agreementIdentification) {
        this.agreementIdentification = agreementIdentification;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PromotionOfferToAgreement.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("agreementIdentification");
        sb.append('=');
        sb.append(((this.agreementIdentification == null)?"<null>":this.agreementIdentification));
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
        result = ((result* 31)+((this.agreementIdentification == null)? 0 :this.agreementIdentification.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PromotionOfferToAgreement) == false) {
            return false;
        }
        PromotionOfferToAgreement rhs = ((PromotionOfferToAgreement) other);
        return ((this.agreementIdentification == rhs.agreementIdentification)||((this.agreementIdentification!= null)&&this.agreementIdentification.equals(rhs.agreementIdentification)));
    }

}
