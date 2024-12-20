package com.td.api.ofm.common;

public class TCCAAPIFeature {

    private String featureId;
    private String featureName;

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TCCAAPIFeature.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("featureId");
        sb.append('=');
        sb.append(((this.featureId == null)?"<null>":this.featureId));
        sb.append(',');
        sb.append("featureName");
        sb.append('=');
        sb.append(((this.featureName == null)?"<null>":this.featureName));
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
        result = ((result* 31)+((this.featureName == null)? 0 :this.featureName.hashCode()));
        result = ((result* 31)+((this.featureId == null)? 0 :this.featureId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TCCAAPIFeature) == false) {
            return false;
        }
        TCCAAPIFeature rhs = ((TCCAAPIFeature) other);
        return (((this.featureName == rhs.featureName)||((this.featureName!= null)&&this.featureName.equals(rhs.featureName)))&&((this.featureId == rhs.featureId)||((this.featureId!= null)&&this.featureId.equals(rhs.featureId))));
    }

}
