package com.td.api.mbcca.request.ebilling;

public class AddCreditCardAgreementEBillingEnrolmentRequest {

    private ElectronicBillingServiceEnrolmentRequest electronicBillingServiceEnrolmentRequest;

    public ElectronicBillingServiceEnrolmentRequest getElectronicBillingServiceEnrolmentRequest() {
        return electronicBillingServiceEnrolmentRequest;
    }

    public void setElectronicBillingServiceEnrolmentRequest(ElectronicBillingServiceEnrolmentRequest electronicBillingServiceEnrolmentRequest) {
        this.electronicBillingServiceEnrolmentRequest = electronicBillingServiceEnrolmentRequest;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AddCreditCardAgreementEBillingEnrolmentRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("electronicBillingServiceEnrolmentRequest");
        sb.append('=');
        sb.append(((this.electronicBillingServiceEnrolmentRequest == null)?"<null>":this.electronicBillingServiceEnrolmentRequest));
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
        result = ((result* 31)+((this.electronicBillingServiceEnrolmentRequest == null)? 0 :this.electronicBillingServiceEnrolmentRequest.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddCreditCardAgreementEBillingEnrolmentRequest) == false) {
            return false;
        }
        AddCreditCardAgreementEBillingEnrolmentRequest rhs = ((AddCreditCardAgreementEBillingEnrolmentRequest) other);
        return ((this.electronicBillingServiceEnrolmentRequest == rhs.electronicBillingServiceEnrolmentRequest)||((this.electronicBillingServiceEnrolmentRequest!= null)&&this.electronicBillingServiceEnrolmentRequest.equals(rhs.electronicBillingServiceEnrolmentRequest)));
    }

}
