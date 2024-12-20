package com.td.api.mbcca.creditcard.response;

import com.td.api.mbcca.shared.Status;

public class PartialUpdateCreditCardAgreementRs {

    private Status status;
    private CreditCardAgreement creditCardAgreement;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public CreditCardAgreement getCreditCardAgreement() {
        return creditCardAgreement;
    }

    public void setCreditCardAgreement(CreditCardAgreement creditCardAgreement) {
        this.creditCardAgreement = creditCardAgreement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PartialUpdateCreditCardAgreementRs.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
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
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PartialUpdateCreditCardAgreementRs) == false) {
            return false;
        }
        PartialUpdateCreditCardAgreementRs rhs = ((PartialUpdateCreditCardAgreementRs) other);
        return (((this.creditCardAgreement == rhs.creditCardAgreement)||((this.creditCardAgreement!= null)&&this.creditCardAgreement.equals(rhs.creditCardAgreement)))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

}
