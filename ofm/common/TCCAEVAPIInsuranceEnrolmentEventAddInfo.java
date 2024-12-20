package com.td.api.ofm.common;

public class TCCAEVAPIInsuranceEnrolmentEventAddInfo {

    private TCCAEVAPIGenericAgreementAltkey agreementAltkey;
    private String productId;
    private TCCAEVAPIInsuranceEnrolmentEventToIndividual individual;
    private String solicitationChannelTypeCd;
    private String accessChannelTypeCd;

    public TCCAEVAPIGenericAgreementAltkey getAgreementAltkey() {
        return agreementAltkey;
    }

    public void setAgreementAltkey(TCCAEVAPIGenericAgreementAltkey agreementAltkey) {
        this.agreementAltkey = agreementAltkey;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public TCCAEVAPIInsuranceEnrolmentEventToIndividual getIndividual() {
        return individual;
    }

    public void setIndividual(TCCAEVAPIInsuranceEnrolmentEventToIndividual individual) {
        this.individual = individual;
    }

    public String getSolicitationChannelTypeCd() {
        return solicitationChannelTypeCd;
    }

    public void setSolicitationChannelTypeCd(String solicitationChannelTypeCd) {
        this.solicitationChannelTypeCd = solicitationChannelTypeCd;
    }

    public String getAccessChannelTypeCd() {
        return accessChannelTypeCd;
    }

    public void setAccessChannelTypeCd(String accessChannelTypeCd) {
        this.accessChannelTypeCd = accessChannelTypeCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TCCAEVAPIInsuranceEnrolmentEventAddInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("agreementAltkey");
        sb.append('=');
        sb.append(((this.agreementAltkey == null)?"<null>":this.agreementAltkey));
        sb.append(',');
        sb.append("productId");
        sb.append('=');
        sb.append(((this.productId == null)?"<null>":this.productId));
        sb.append(',');
        sb.append("individual");
        sb.append('=');
        sb.append(((this.individual == null)?"<null>":this.individual));
        sb.append(',');
        sb.append("solicitationChannelTypeCd");
        sb.append('=');
        sb.append(((this.solicitationChannelTypeCd == null)?"<null>":this.solicitationChannelTypeCd));
        sb.append(',');
        sb.append("accessChannelTypeCd");
        sb.append('=');
        sb.append(((this.accessChannelTypeCd == null)?"<null>":this.accessChannelTypeCd));
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
        result = ((result* 31)+((this.solicitationChannelTypeCd == null)? 0 :this.solicitationChannelTypeCd.hashCode()));
        result = ((result* 31)+((this.accessChannelTypeCd == null)? 0 :this.accessChannelTypeCd.hashCode()));
        result = ((result* 31)+((this.productId == null)? 0 :this.productId.hashCode()));
        result = ((result* 31)+((this.individual == null)? 0 :this.individual.hashCode()));
        result = ((result* 31)+((this.agreementAltkey == null)? 0 :this.agreementAltkey.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TCCAEVAPIInsuranceEnrolmentEventAddInfo) == false) {
            return false;
        }
        TCCAEVAPIInsuranceEnrolmentEventAddInfo rhs = ((TCCAEVAPIInsuranceEnrolmentEventAddInfo) other);
        return ((((((this.solicitationChannelTypeCd == rhs.solicitationChannelTypeCd)||((this.solicitationChannelTypeCd!= null)&&this.solicitationChannelTypeCd.equals(rhs.solicitationChannelTypeCd)))&&((this.accessChannelTypeCd == rhs.accessChannelTypeCd)||((this.accessChannelTypeCd!= null)&&this.accessChannelTypeCd.equals(rhs.accessChannelTypeCd))))&&((this.productId == rhs.productId)||((this.productId!= null)&&this.productId.equals(rhs.productId))))&&((this.individual == rhs.individual)||((this.individual!= null)&&this.individual.equals(rhs.individual))))&&((this.agreementAltkey == rhs.agreementAltkey)||((this.agreementAltkey!= null)&&this.agreementAltkey.equals(rhs.agreementAltkey))));
    }

}
