package com.td.api.ofm.response;

import java.util.ArrayList;
import java.util.List;

import com.td.api.ofm.common.TCCAAPIAgreementPartyFeature;

public class TSvcRetrieveCreditCardAgreementPartyFeatureListRs {

    private List<TCCAAPIAgreementPartyFeature> agreementPartyFeature = new ArrayList<TCCAAPIAgreementPartyFeature>();

    public List<TCCAAPIAgreementPartyFeature> getAgreementPartyFeature() {
        return agreementPartyFeature;
    }

    public void setAgreementPartyFeature(List<TCCAAPIAgreementPartyFeature> agreementPartyFeature) {
        this.agreementPartyFeature = agreementPartyFeature;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TSvcRetrieveCreditCardAgreementPartyFeatureListRs.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("agreementPartyFeature");
        sb.append('=');
        sb.append(((this.agreementPartyFeature == null)?"<null>":this.agreementPartyFeature));
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
        result = ((result* 31)+((this.agreementPartyFeature == null)? 0 :this.agreementPartyFeature.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TSvcRetrieveCreditCardAgreementPartyFeatureListRs) == false) {
            return false;
        }
        TSvcRetrieveCreditCardAgreementPartyFeatureListRs rhs = ((TSvcRetrieveCreditCardAgreementPartyFeatureListRs) other);
        return ((this.agreementPartyFeature == rhs.agreementPartyFeature)||((this.agreementPartyFeature!= null)&&this.agreementPartyFeature.equals(rhs.agreementPartyFeature)));
    }

}
