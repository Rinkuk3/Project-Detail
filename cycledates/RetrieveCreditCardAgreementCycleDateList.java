package com.td.api.mbcca.response.account.cycledates;

import java.util.ArrayList;
import java.util.List;

import com.td.api.mbcca.shared.Status;

public class RetrieveCreditCardAgreementCycleDateList {

    private Status status;
    private List<String> billingCycleDt = new ArrayList<String>();

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<String> getBillingCycleDt() {
        return billingCycleDt;
    }

    public void setBillingCycleDt(List<String> billingCycleDt) {
        this.billingCycleDt = billingCycleDt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RetrieveCreditCardAgreementCycleDateList.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("billingCycleDt");
        sb.append('=');
        sb.append(((this.billingCycleDt == null)?"<null>":this.billingCycleDt));
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
        result = ((result* 31)+((this.billingCycleDt == null)? 0 :this.billingCycleDt.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RetrieveCreditCardAgreementCycleDateList) == false) {
            return false;
        }
        RetrieveCreditCardAgreementCycleDateList rhs = ((RetrieveCreditCardAgreementCycleDateList) other);
        return (((this.billingCycleDt == rhs.billingCycleDt)||((this.billingCycleDt!= null)&&this.billingCycleDt.equals(rhs.billingCycleDt)))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

}
