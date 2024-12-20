package com.td.api.mbofp.request.insuranceenrolment;

import com.td.api.mbofp.shared.AgreementAltkey;

public class InsuranceEnrolmentEvent {

    private AgreementAltkey agreementAltkey;
    private String productId;
    private Individual individual;
    private String solicitationChannelTypeCd;
    private String accessChannelTypeCd;

    public AgreementAltkey getAgreementAltkey() {
        return agreementAltkey;
    }

    public void setAgreementAltkey(AgreementAltkey agreementAltkey) {
        this.agreementAltkey = agreementAltkey;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Individual getIndividual() {
        return individual;
    }

    public void setIndividual(Individual individual) {
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
        sb.append(InsuranceEnrolmentEvent.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        if ((other instanceof InsuranceEnrolmentEvent) == false) {
            return false;
        }
        InsuranceEnrolmentEvent rhs = ((InsuranceEnrolmentEvent) other);
        return ((((((this.solicitationChannelTypeCd == rhs.solicitationChannelTypeCd)||((this.solicitationChannelTypeCd!= null)&&this.solicitationChannelTypeCd.equals(rhs.solicitationChannelTypeCd)))&&((this.accessChannelTypeCd == rhs.accessChannelTypeCd)||((this.accessChannelTypeCd!= null)&&this.accessChannelTypeCd.equals(rhs.accessChannelTypeCd))))&&((this.productId == rhs.productId)||((this.productId!= null)&&this.productId.equals(rhs.productId))))&&((this.individual == rhs.individual)||((this.individual!= null)&&this.individual.equals(rhs.individual))))&&((this.agreementAltkey == rhs.agreementAltkey)||((this.agreementAltkey!= null)&&this.agreementAltkey.equals(rhs.agreementAltkey))));
    }

}
