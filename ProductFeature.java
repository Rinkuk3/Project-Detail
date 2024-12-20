package com.td.api.mbcca.response.account;

public class ProductFeature {

    private String featureDesc;
    private Boolean activeInd;
    private String insurableInterestCoverageTypeCd;

    public String getFeatureDesc() {
        return featureDesc;
    }

    public void setFeatureDesc(String featureDesc) {
        this.featureDesc = featureDesc;
    }

    public Boolean getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(Boolean activeInd) {
        this.activeInd = activeInd;
    }

    public String getInsurableInterestCoverageTypeCd() {
        return insurableInterestCoverageTypeCd;
    }

    public void setInsurableInterestCoverageTypeCd(String insurableInterestCoverageTypeCd) {
        this.insurableInterestCoverageTypeCd = insurableInterestCoverageTypeCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ProductFeature.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("featureDesc");
        sb.append('=');
        sb.append(((this.featureDesc == null)?"<null>":this.featureDesc));
        sb.append(',');
        sb.append("activeInd");
        sb.append('=');
        sb.append(((this.activeInd == null)?"<null>":this.activeInd));
        sb.append(',');
        sb.append("insurableInterestCoverageTypeCd");
        sb.append('=');
        sb.append(((this.insurableInterestCoverageTypeCd == null)?"<null>":this.insurableInterestCoverageTypeCd));
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
        result = ((result* 31)+((this.insurableInterestCoverageTypeCd == null)? 0 :this.insurableInterestCoverageTypeCd.hashCode()));
        result = ((result* 31)+((this.activeInd == null)? 0 :this.activeInd.hashCode()));
        result = ((result* 31)+((this.featureDesc == null)? 0 :this.featureDesc.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProductFeature) == false) {
            return false;
        }
        ProductFeature rhs = ((ProductFeature) other);
        return ((((this.insurableInterestCoverageTypeCd == rhs.insurableInterestCoverageTypeCd)||((this.insurableInterestCoverageTypeCd!= null)&&this.insurableInterestCoverageTypeCd.equals(rhs.insurableInterestCoverageTypeCd)))&&((this.activeInd == rhs.activeInd)||((this.activeInd!= null)&&this.activeInd.equals(rhs.activeInd))))&&((this.featureDesc == rhs.featureDesc)||((this.featureDesc!= null)&&this.featureDesc.equals(rhs.featureDesc))));
    }

}
