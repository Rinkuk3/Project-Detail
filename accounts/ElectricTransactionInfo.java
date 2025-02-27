package com.td.api.mbcca.response.account;

public class ElectricTransactionInfo {

    private String electronicCommerceIndicatorCd;
    private String securityLevelIndicatorCd;
    private String securityProtocolCd;
    private String cardHolderAuthenticationCd;

    public String getElectronicCommerceIndicatorCd() {
        return electronicCommerceIndicatorCd;
    }

    public void setElectronicCommerceIndicatorCd(String electronicCommerceIndicatorCd) {
        this.electronicCommerceIndicatorCd = electronicCommerceIndicatorCd;
    }

    public String getSecurityLevelIndicatorCd() {
        return securityLevelIndicatorCd;
    }

    public void setSecurityLevelIndicatorCd(String securityLevelIndicatorCd) {
        this.securityLevelIndicatorCd = securityLevelIndicatorCd;
    }

    public String getSecurityProtocolCd() {
        return securityProtocolCd;
    }

    public void setSecurityProtocolCd(String securityProtocolCd) {
        this.securityProtocolCd = securityProtocolCd;
    }

    public String getCardHolderAuthenticationCd() {
        return cardHolderAuthenticationCd;
    }

    public void setCardHolderAuthenticationCd(String cardHolderAuthenticationCd) {
        this.cardHolderAuthenticationCd = cardHolderAuthenticationCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ElectricTransactionInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("electronicCommerceIndicatorCd");
        sb.append('=');
        sb.append(((this.electronicCommerceIndicatorCd == null)?"<null>":this.electronicCommerceIndicatorCd));
        sb.append(',');
        sb.append("securityLevelIndicatorCd");
        sb.append('=');
        sb.append(((this.securityLevelIndicatorCd == null)?"<null>":this.securityLevelIndicatorCd));
        sb.append(',');
        sb.append("securityProtocolCd");
        sb.append('=');
        sb.append(((this.securityProtocolCd == null)?"<null>":this.securityProtocolCd));
        sb.append(',');
        sb.append("cardHolderAuthenticationCd");
        sb.append('=');
        sb.append(((this.cardHolderAuthenticationCd == null)?"<null>":this.cardHolderAuthenticationCd));
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
        result = ((result* 31)+((this.securityProtocolCd == null)? 0 :this.securityProtocolCd.hashCode()));
        result = ((result* 31)+((this.cardHolderAuthenticationCd == null)? 0 :this.cardHolderAuthenticationCd.hashCode()));
        result = ((result* 31)+((this.electronicCommerceIndicatorCd == null)? 0 :this.electronicCommerceIndicatorCd.hashCode()));
        result = ((result* 31)+((this.securityLevelIndicatorCd == null)? 0 :this.securityLevelIndicatorCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ElectricTransactionInfo) == false) {
            return false;
        }
        ElectricTransactionInfo rhs = ((ElectricTransactionInfo) other);
        return (((((this.securityProtocolCd == rhs.securityProtocolCd)||((this.securityProtocolCd!= null)&&this.securityProtocolCd.equals(rhs.securityProtocolCd)))&&((this.cardHolderAuthenticationCd == rhs.cardHolderAuthenticationCd)||((this.cardHolderAuthenticationCd!= null)&&this.cardHolderAuthenticationCd.equals(rhs.cardHolderAuthenticationCd))))&&((this.electronicCommerceIndicatorCd == rhs.electronicCommerceIndicatorCd)||((this.electronicCommerceIndicatorCd!= null)&&this.electronicCommerceIndicatorCd.equals(rhs.electronicCommerceIndicatorCd))))&&((this.securityLevelIndicatorCd == rhs.securityLevelIndicatorCd)||((this.securityLevelIndicatorCd!= null)&&this.securityLevelIndicatorCd.equals(rhs.securityLevelIndicatorCd))));
    }

}
