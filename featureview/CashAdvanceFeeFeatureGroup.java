package com.td.api.mbcca.response.account.featureview;

public class CashAdvanceFeeFeatureGroup {

    private String subjectToCashAdvanceFeeTransactionVal;
    private Feature feature;
    private AlternateFeature alternateFeature;

    public String getSubjectToCashAdvanceFeeTransactionVal() {
        return subjectToCashAdvanceFeeTransactionVal;
    }

    public void setSubjectToCashAdvanceFeeTransactionVal(String subjectToCashAdvanceFeeTransactionVal) {
        this.subjectToCashAdvanceFeeTransactionVal = subjectToCashAdvanceFeeTransactionVal;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public AlternateFeature getAlternateFeature() {
        return alternateFeature;
    }

    public void setAlternateFeature(AlternateFeature alternateFeature) {
        this.alternateFeature = alternateFeature;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CashAdvanceFeeFeatureGroup.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("subjectToCashAdvanceFeeTransactionVal");
        sb.append('=');
        sb.append(((this.subjectToCashAdvanceFeeTransactionVal == null)?"<null>":this.subjectToCashAdvanceFeeTransactionVal));
        sb.append(',');
        sb.append("feature");
        sb.append('=');
        sb.append(((this.feature == null)?"<null>":this.feature));
        sb.append(',');
        sb.append("alternateFeature");
        sb.append('=');
        sb.append(((this.alternateFeature == null)?"<null>":this.alternateFeature));
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
        result = ((result* 31)+((this.alternateFeature == null)? 0 :this.alternateFeature.hashCode()));
        result = ((result* 31)+((this.feature == null)? 0 :this.feature.hashCode()));
        result = ((result* 31)+((this.subjectToCashAdvanceFeeTransactionVal == null)? 0 :this.subjectToCashAdvanceFeeTransactionVal.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CashAdvanceFeeFeatureGroup) == false) {
            return false;
        }
        CashAdvanceFeeFeatureGroup rhs = ((CashAdvanceFeeFeatureGroup) other);
        return ((((this.alternateFeature == rhs.alternateFeature)||((this.alternateFeature!= null)&&this.alternateFeature.equals(rhs.alternateFeature)))&&((this.feature == rhs.feature)||((this.feature!= null)&&this.feature.equals(rhs.feature))))&&((this.subjectToCashAdvanceFeeTransactionVal == rhs.subjectToCashAdvanceFeeTransactionVal)||((this.subjectToCashAdvanceFeeTransactionVal!= null)&&this.subjectToCashAdvanceFeeTransactionVal.equals(rhs.subjectToCashAdvanceFeeTransactionVal))));
    }

}
