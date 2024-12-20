package com.td.api.ofm.common;

import java.util.ArrayList;
import java.util.List;

public class TCCAAPIAgreementPartyFeature {

    private TCCAAPIFeature feature;
    private Boolean eligibleInd;
    private List<TCCAAPIEligibilityReason> eligibilityReason = new ArrayList<TCCAAPIEligibilityReason>();

    public TCCAAPIFeature getFeature() {
        return feature;
    }

    public void setFeature(TCCAAPIFeature feature) {
        this.feature = feature;
    }

    public Boolean getEligibleInd() {
        return eligibleInd;
    }

    public void setEligibleInd(Boolean eligibleInd) {
        this.eligibleInd = eligibleInd;
    }

    public List<TCCAAPIEligibilityReason> getEligibilityReason() {
        return eligibilityReason;
    }

    public void setEligibilityReason(List<TCCAAPIEligibilityReason> eligibilityReason) {
        this.eligibilityReason = eligibilityReason;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TCCAAPIAgreementPartyFeature.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("feature");
        sb.append('=');
        sb.append(((this.feature == null)?"<null>":this.feature));
        sb.append(',');
        sb.append("eligibleInd");
        sb.append('=');
        sb.append(((this.eligibleInd == null)?"<null>":this.eligibleInd));
        sb.append(',');
        sb.append("eligibilityReason");
        sb.append('=');
        sb.append(((this.eligibilityReason == null)?"<null>":this.eligibilityReason));
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
        result = ((result* 31)+((this.eligibleInd == null)? 0 :this.eligibleInd.hashCode()));
        result = ((result* 31)+((this.feature == null)? 0 :this.feature.hashCode()));
        result = ((result* 31)+((this.eligibilityReason == null)? 0 :this.eligibilityReason.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TCCAAPIAgreementPartyFeature) == false) {
            return false;
        }
        TCCAAPIAgreementPartyFeature rhs = ((TCCAAPIAgreementPartyFeature) other);
        return ((((this.eligibleInd == rhs.eligibleInd)||((this.eligibleInd!= null)&&this.eligibleInd.equals(rhs.eligibleInd)))&&((this.feature == rhs.feature)||((this.feature!= null)&&this.feature.equals(rhs.feature))))&&((this.eligibilityReason == rhs.eligibilityReason)||((this.eligibilityReason!= null)&&this.eligibilityReason.equals(rhs.eligibilityReason))));
    }

}
