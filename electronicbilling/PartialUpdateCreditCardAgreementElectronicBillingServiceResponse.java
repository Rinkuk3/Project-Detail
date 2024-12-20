package com.td.api.mbcca.response.account.electronicbilling;

import com.td.api.mbcca.shared.Status;

public class PartialUpdateCreditCardAgreementElectronicBillingServiceResponse {

    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PartialUpdateCreditCardAgreementElectronicBillingServiceResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
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
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PartialUpdateCreditCardAgreementElectronicBillingServiceResponse) == false) {
            return false;
        }
        PartialUpdateCreditCardAgreementElectronicBillingServiceResponse rhs = ((PartialUpdateCreditCardAgreementElectronicBillingServiceResponse) other);
        return ((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status)));
    }

}
