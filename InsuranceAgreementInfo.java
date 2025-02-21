package com.td.api.mbcca.response.account;

import java.util.ArrayList;
import java.util.List;

public class InsuranceAgreementInfo {

    private List<FeatureGroup> featureGroup = new ArrayList<FeatureGroup>();

    public List<FeatureGroup> getFeatureGroup() {
        return featureGroup;
    }

    public void setFeatureGroup(List<FeatureGroup> featureGroup) {
        this.featureGroup = featureGroup;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(InsuranceAgreementInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("featureGroup");
        sb.append('=');
        sb.append(((this.featureGroup == null)?"<null>":this.featureGroup));
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
        result = ((result* 31)+((this.featureGroup == null)? 0 :this.featureGroup.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof InsuranceAgreementInfo) == false) {
            return false;
        }
        InsuranceAgreementInfo rhs = ((InsuranceAgreementInfo) other);
        return ((this.featureGroup == rhs.featureGroup)||((this.featureGroup!= null)&&this.featureGroup.equals(rhs.featureGroup)));
    }

}
