package com.td.api.mbcca.response.account.featureview;

import java.math.BigDecimal;

import com.td.api.mbcca.shared.Cccyamt;

public class Feature {

    private String featureId;
    private String featureDesc;
    BigDecimal feePercentageRate;
    private Cccyamt minimumFeeCccyamt;

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

    public BigDecimal getFeePercentageRate() {
        return feePercentageRate;
    }

    public void setFeePercentageRate(BigDecimal feePercentageRate) {
        this.feePercentageRate = feePercentageRate;
    }

    public Cccyamt getMinimumFeeCccyamt() {
        return minimumFeeCccyamt;
    }

    public void setMinimumFeeCccyamt(Cccyamt minimumFeeCccyamt) {
        this.minimumFeeCccyamt = minimumFeeCccyamt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Feature.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("featureId");
        sb.append('=');
        sb.append(((this.featureId == null)?"<null>":this.featureId));
        sb.append(',');
        sb.append("featureDesc");
        sb.append('=');
        sb.append(((this.featureDesc == null)?"<null>":this.featureDesc));
        sb.append(',');
        sb.append("feePercentageRate");
        sb.append('=');
        sb.append(((this.feePercentageRate == null)?"<null>":this.feePercentageRate));
        sb.append(',');
        sb.append("minimumFeeCccyamt");
        sb.append('=');
        sb.append(((this.minimumFeeCccyamt == null)?"<null>":this.minimumFeeCccyamt));
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
        result = ((result* 31)+((this.feePercentageRate == null)? 0 :this.feePercentageRate.hashCode()));
        result = ((result* 31)+((this.minimumFeeCccyamt == null)? 0 :this.minimumFeeCccyamt.hashCode()));
        result = ((result* 31)+((this.featureId == null)? 0 :this.featureId.hashCode()));
        result = ((result* 31)+((this.featureDesc == null)? 0 :this.featureDesc.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Feature) == false) {
            return false;
        }
        Feature rhs = ((Feature) other);
        return (((((this.feePercentageRate == rhs.feePercentageRate)||((this.feePercentageRate!= null)&&this.feePercentageRate.equals(rhs.feePercentageRate)))&&((this.minimumFeeCccyamt == rhs.minimumFeeCccyamt)||((this.minimumFeeCccyamt!= null)&&this.minimumFeeCccyamt.equals(rhs.minimumFeeCccyamt))))&&((this.featureId == rhs.featureId)||((this.featureId!= null)&&this.featureId.equals(rhs.featureId))))&&((this.featureDesc == rhs.featureDesc)||((this.featureDesc!= null)&&this.featureDesc.equals(rhs.featureDesc))));
    }

}
