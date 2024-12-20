package com.td.api.mbcca.response.insurance;

import com.td.api.mbcca.shared.Cccyamt;

public class ProductFeature {

    private String featureId;
    private String featureDesc;
    private Boolean activeInd;
    private String cancellationAgeNum;
    private String insurableInterestCoverageTypeCd;
    private String insurableInterestCoveragePartyTypeCd;
    private Cccyamt policyInsurableMaxCoverageCccyamt;

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

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

    public String getCancellationAgeNum() {
        return cancellationAgeNum;
    }

    public void setCancellationAgeNum(String cancellationAgeNum) {
        this.cancellationAgeNum = cancellationAgeNum;
    }

    public String getInsurableInterestCoverageTypeCd() {
        return insurableInterestCoverageTypeCd;
    }

    public void setInsurableInterestCoverageTypeCd(String insurableInterestCoverageTypeCd) {
        this.insurableInterestCoverageTypeCd = insurableInterestCoverageTypeCd;
    }

    public String getInsurableInterestCoveragePartyTypeCd() {
        return insurableInterestCoveragePartyTypeCd;
    }

    public void setInsurableInterestCoveragePartyTypeCd(String insurableInterestCoveragePartyTypeCd) {
        this.insurableInterestCoveragePartyTypeCd = insurableInterestCoveragePartyTypeCd;
    }

    public Cccyamt getPolicyInsurableMaxCoverageCccyamt() {
        return policyInsurableMaxCoverageCccyamt;
    }

    public void setPolicyInsurableMaxCoverageCccyamt(Cccyamt policyInsurableMaxCoverageCccyamt) {
        this.policyInsurableMaxCoverageCccyamt = policyInsurableMaxCoverageCccyamt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ProductFeature.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("featureId");
        sb.append('=');
        sb.append(((this.featureId == null)?"<null>":this.featureId));
        sb.append(',');
        sb.append("featureDesc");
        sb.append('=');
        sb.append(((this.featureDesc == null)?"<null>":this.featureDesc));
        sb.append(',');
        sb.append("activeInd");
        sb.append('=');
        sb.append(((this.activeInd == null)?"<null>":this.activeInd));
        sb.append(',');
        sb.append("cancellationAgeNum");
        sb.append('=');
        sb.append(((this.cancellationAgeNum == null)?"<null>":this.cancellationAgeNum));
        sb.append(',');
        sb.append("insurableInterestCoverageTypeCd");
        sb.append('=');
        sb.append(((this.insurableInterestCoverageTypeCd == null)?"<null>":this.insurableInterestCoverageTypeCd));
        sb.append(',');
        sb.append("insurableInterestCoveragePartyTypeCd");
        sb.append('=');
        sb.append(((this.insurableInterestCoveragePartyTypeCd == null)?"<null>":this.insurableInterestCoveragePartyTypeCd));
        sb.append(',');
        sb.append("policyInsurableMaxCoverageCccyamt");
        sb.append('=');
        sb.append(((this.policyInsurableMaxCoverageCccyamt == null)?"<null>":this.policyInsurableMaxCoverageCccyamt));
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
        result = ((result* 31)+((this.insurableInterestCoveragePartyTypeCd == null)? 0 :this.insurableInterestCoveragePartyTypeCd.hashCode()));
        result = ((result* 31)+((this.cancellationAgeNum == null)? 0 :this.cancellationAgeNum.hashCode()));
        result = ((result* 31)+((this.insurableInterestCoverageTypeCd == null)? 0 :this.insurableInterestCoverageTypeCd.hashCode()));
        result = ((result* 31)+((this.activeInd == null)? 0 :this.activeInd.hashCode()));
        result = ((result* 31)+((this.featureDesc == null)? 0 :this.featureDesc.hashCode()));
        result = ((result* 31)+((this.featureId == null)? 0 :this.featureId.hashCode()));
        result = ((result* 31)+((this.policyInsurableMaxCoverageCccyamt == null)? 0 :this.policyInsurableMaxCoverageCccyamt.hashCode()));
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
        return ((((((((this.insurableInterestCoveragePartyTypeCd == rhs.insurableInterestCoveragePartyTypeCd)||((this.insurableInterestCoveragePartyTypeCd!= null)&&this.insurableInterestCoveragePartyTypeCd.equals(rhs.insurableInterestCoveragePartyTypeCd)))&&((this.cancellationAgeNum == rhs.cancellationAgeNum)||((this.cancellationAgeNum!= null)&&this.cancellationAgeNum.equals(rhs.cancellationAgeNum))))&&((this.insurableInterestCoverageTypeCd == rhs.insurableInterestCoverageTypeCd)||((this.insurableInterestCoverageTypeCd!= null)&&this.insurableInterestCoverageTypeCd.equals(rhs.insurableInterestCoverageTypeCd))))&&((this.activeInd == rhs.activeInd)||((this.activeInd!= null)&&this.activeInd.equals(rhs.activeInd))))&&((this.featureDesc == rhs.featureDesc)||((this.featureDesc!= null)&&this.featureDesc.equals(rhs.featureDesc))))&&((this.featureId == rhs.featureId)||((this.featureId!= null)&&this.featureId.equals(rhs.featureId))))&&((this.policyInsurableMaxCoverageCccyamt == rhs.policyInsurableMaxCoverageCccyamt)||((this.policyInsurableMaxCoverageCccyamt!= null)&&this.policyInsurableMaxCoverageCccyamt.equals(rhs.policyInsurableMaxCoverageCccyamt))));
    }

}
