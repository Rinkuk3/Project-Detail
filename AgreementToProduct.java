package com.td.api.mbcca.response.account;

public class AgreementToProduct {

    private String securitizationPoolId;

    public String getSecuritizationPoolId() {
        return securitizationPoolId;
    }

    public void setSecuritizationPoolId(String securitizationPoolId) {
        this.securitizationPoolId = securitizationPoolId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AgreementToProduct.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("securitizationPoolId");
        sb.append('=');
        sb.append(((this.securitizationPoolId == null)?"<null>":this.securitizationPoolId));
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
        result = ((result* 31)+((this.securitizationPoolId == null)? 0 :this.securitizationPoolId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AgreementToProduct) == false) {
            return false;
        }
        AgreementToProduct rhs = ((AgreementToProduct) other);
        return ((this.securitizationPoolId == rhs.securitizationPoolId)||((this.securitizationPoolId!= null)&&this.securitizationPoolId.equals(rhs.securitizationPoolId)));
    }

}
