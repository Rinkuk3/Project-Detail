package com.td.api.mbcca.response.insurance;

import com.td.api.mbcca.shared.Status;

public class RetrieveInsuranceAgreement {

    private Status status;
    private InsuranceAgreement insuranceAgreement;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public InsuranceAgreement getInsuranceAgreement() {
        return insuranceAgreement;
    }

    public void setInsuranceAgreement(InsuranceAgreement insuranceAgreement) {
        this.insuranceAgreement = insuranceAgreement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RetrieveInsuranceAgreement.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("insuranceAgreement");
        sb.append('=');
        sb.append(((this.insuranceAgreement == null)?"<null>":this.insuranceAgreement));
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
        result = ((result* 31)+((this.insuranceAgreement == null)? 0 :this.insuranceAgreement.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RetrieveInsuranceAgreement) == false) {
            return false;
        }
        RetrieveInsuranceAgreement rhs = ((RetrieveInsuranceAgreement) other);
        return (((this.insuranceAgreement == rhs.insuranceAgreement)||((this.insuranceAgreement!= null)&&this.insuranceAgreement.equals(rhs.insuranceAgreement)))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

}
