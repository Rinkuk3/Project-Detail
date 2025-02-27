package com.td.api.mbcca.response.account;

public class Locator {

    private EmailAddress emailAddress;
    private InternetProtocolAddress internetProtocolAddress;
    private StreetAddress streetAddress;
    private TelephoneNumber telephoneNumber;

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }

    public InternetProtocolAddress getInternetProtocolAddress() {
        return internetProtocolAddress;
    }

    public void setInternetProtocolAddress(InternetProtocolAddress internetProtocolAddress) {
        this.internetProtocolAddress = internetProtocolAddress;
    }

    public StreetAddress getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(StreetAddress streetAddress) {
        this.streetAddress = streetAddress;
    }

    public TelephoneNumber getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(TelephoneNumber telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Locator.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("emailAddress");
        sb.append('=');
        sb.append(((this.emailAddress == null)?"<null>":this.emailAddress));
        sb.append(',');
        sb.append("internetProtocolAddress");
        sb.append('=');
        sb.append(((this.internetProtocolAddress == null)?"<null>":this.internetProtocolAddress));
        sb.append(',');
        sb.append("streetAddress");
        sb.append('=');
        sb.append(((this.streetAddress == null)?"<null>":this.streetAddress));
        sb.append(',');
        sb.append("telephoneNumber");
        sb.append('=');
        sb.append(((this.telephoneNumber == null)?"<null>":this.telephoneNumber));
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
        result = ((result* 31)+((this.emailAddress == null)? 0 :this.emailAddress.hashCode()));
        result = ((result* 31)+((this.internetProtocolAddress == null)? 0 :this.internetProtocolAddress.hashCode()));
        result = ((result* 31)+((this.telephoneNumber == null)? 0 :this.telephoneNumber.hashCode()));
        result = ((result* 31)+((this.streetAddress == null)? 0 :this.streetAddress.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Locator) == false) {
            return false;
        }
        Locator rhs = ((Locator) other);
        return (((((this.emailAddress == rhs.emailAddress)||((this.emailAddress!= null)&&this.emailAddress.equals(rhs.emailAddress)))&&((this.internetProtocolAddress == rhs.internetProtocolAddress)||((this.internetProtocolAddress!= null)&&this.internetProtocolAddress.equals(rhs.internetProtocolAddress))))&&((this.telephoneNumber == rhs.telephoneNumber)||((this.telephoneNumber!= null)&&this.telephoneNumber.equals(rhs.telephoneNumber))))&&((this.streetAddress == rhs.streetAddress)||((this.streetAddress!= null)&&this.streetAddress.equals(rhs.streetAddress))));
    }

}
