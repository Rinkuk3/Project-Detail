package com.td.api.mbcca.request.ebilling;

public class ElectronicBillingServiceEnrolmentRequest {

    private String serviceProviderPartyId;
    private EmailAddress emailAddress;

    public String getServiceProviderPartyId() {
        return serviceProviderPartyId;
    }

    public void setServiceProviderPartyId(String serviceProviderPartyId) {
        this.serviceProviderPartyId = serviceProviderPartyId;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ElectronicBillingServiceEnrolmentRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("serviceProviderPartyId");
        sb.append('=');
        sb.append(((this.serviceProviderPartyId == null)?"<null>":this.serviceProviderPartyId));
        sb.append(',');
        sb.append("emailAddress");
        sb.append('=');
        sb.append(((this.emailAddress == null)?"<null>":this.emailAddress));
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
        result = ((result* 31)+((this.serviceProviderPartyId == null)? 0 :this.serviceProviderPartyId.hashCode()));
        result = ((result* 31)+((this.emailAddress == null)? 0 :this.emailAddress.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ElectronicBillingServiceEnrolmentRequest) == false) {
            return false;
        }
        ElectronicBillingServiceEnrolmentRequest rhs = ((ElectronicBillingServiceEnrolmentRequest) other);
        return (((this.serviceProviderPartyId == rhs.serviceProviderPartyId)||((this.serviceProviderPartyId!= null)&&this.serviceProviderPartyId.equals(rhs.serviceProviderPartyId)))&&((this.emailAddress == rhs.emailAddress)||((this.emailAddress!= null)&&this.emailAddress.equals(rhs.emailAddress))));
    }

}
