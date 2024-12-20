package com.td.api.mbcca.response.account.electronicbilling;

import com.td.api.mbcca.shared.Status;

public class RetrieveCreditCardAgreementElectronicBillingServiceRs {

    private Status status;
    private ElectronicBillingService electronicBillingService;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ElectronicBillingService getElectronicBillingService() {
        return electronicBillingService;
    }

    public void setElectronicBillingService(ElectronicBillingService electronicBillingService) {
        this.electronicBillingService = electronicBillingService;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RetrieveCreditCardAgreementElectronicBillingServiceRs.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("electronicBillingService");
        sb.append('=');
        sb.append(((this.electronicBillingService == null)?"<null>":this.electronicBillingService));
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
        result = ((result* 31)+((this.electronicBillingService == null)? 0 :this.electronicBillingService.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RetrieveCreditCardAgreementElectronicBillingServiceRs) == false) {
            return false;
        }
        RetrieveCreditCardAgreementElectronicBillingServiceRs rhs = ((RetrieveCreditCardAgreementElectronicBillingServiceRs) other);
        return (((this.electronicBillingService == rhs.electronicBillingService)||((this.electronicBillingService!= null)&&this.electronicBillingService.equals(rhs.electronicBillingService)))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

}
