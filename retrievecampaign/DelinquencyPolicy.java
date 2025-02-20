package com.td.api.mbofp.response.retrievecampaign;

import java.math.BigDecimal;

public class DelinquencyPolicy {

    private String policyTypeCd;
    private String featureClassificationCd;
    private String repricingTypeCd;
    BigDecimal repricingRate;
    private Integer triggerCycleCnt;
    private String delinquencyLevelCd;
    private Integer minimumDelinquencyCnt;

    public String getPolicyTypeCd() {
        return policyTypeCd;
    }

    public void setPolicyTypeCd(String policyTypeCd) {
        this.policyTypeCd = policyTypeCd;
    }

    public String getFeatureClassificationCd() {
        return featureClassificationCd;
    }

    public void setFeatureClassificationCd(String featureClassificationCd) {
        this.featureClassificationCd = featureClassificationCd;
    }

    public String getRepricingTypeCd() {
        return repricingTypeCd;
    }

    public void setRepricingTypeCd(String repricingTypeCd) {
        this.repricingTypeCd = repricingTypeCd;
    }

    public BigDecimal getRepricingRate() {
        return repricingRate;
    }

    public void setRepricingRate(BigDecimal repricingRate) {
        this.repricingRate = repricingRate;
    }

    public Integer getTriggerCycleCnt() {
        return triggerCycleCnt;
    }

    public void setTriggerCycleCnt(Integer triggerCycleCnt) {
        this.triggerCycleCnt = triggerCycleCnt;
    }

    public String getDelinquencyLevelCd() {
        return delinquencyLevelCd;
    }

    public void setDelinquencyLevelCd(String delinquencyLevelCd) {
        this.delinquencyLevelCd = delinquencyLevelCd;
    }

    public Integer getMinimumDelinquencyCnt() {
        return minimumDelinquencyCnt;
    }

    public void setMinimumDelinquencyCnt(Integer minimumDelinquencyCnt) {
        this.minimumDelinquencyCnt = minimumDelinquencyCnt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DelinquencyPolicy.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("policyTypeCd");
        sb.append('=');
        sb.append(((this.policyTypeCd == null)?"<null>":this.policyTypeCd));
        sb.append(',');
        sb.append("featureClassificationCd");
        sb.append('=');
        sb.append(((this.featureClassificationCd == null)?"<null>":this.featureClassificationCd));
        sb.append(',');
        sb.append("repricingTypeCd");
        sb.append('=');
        sb.append(((this.repricingTypeCd == null)?"<null>":this.repricingTypeCd));
        sb.append(',');
        sb.append("repricingRate");
        sb.append('=');
        sb.append(((this.repricingRate == null)?"<null>":this.repricingRate));
        sb.append(',');
        sb.append("triggerCycleCnt");
        sb.append('=');
        sb.append(((this.triggerCycleCnt == null)?"<null>":this.triggerCycleCnt));
        sb.append(',');
        sb.append("delinquencyLevelCd");
        sb.append('=');
        sb.append(((this.delinquencyLevelCd == null)?"<null>":this.delinquencyLevelCd));
        sb.append(',');
        sb.append("minimumDelinquencyCnt");
        sb.append('=');
        sb.append(((this.minimumDelinquencyCnt == null)?"<null>":this.minimumDelinquencyCnt));
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
        result = ((result* 31)+((this.minimumDelinquencyCnt == null)? 0 :this.minimumDelinquencyCnt.hashCode()));
        result = ((result* 31)+((this.triggerCycleCnt == null)? 0 :this.triggerCycleCnt.hashCode()));
        result = ((result* 31)+((this.policyTypeCd == null)? 0 :this.policyTypeCd.hashCode()));
        result = ((result* 31)+((this.featureClassificationCd == null)? 0 :this.featureClassificationCd.hashCode()));
        result = ((result* 31)+((this.delinquencyLevelCd == null)? 0 :this.delinquencyLevelCd.hashCode()));
        result = ((result* 31)+((this.repricingRate == null)? 0 :this.repricingRate.hashCode()));
        result = ((result* 31)+((this.repricingTypeCd == null)? 0 :this.repricingTypeCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DelinquencyPolicy) == false) {
            return false;
        }
        DelinquencyPolicy rhs = ((DelinquencyPolicy) other);
        return ((((((((this.minimumDelinquencyCnt == rhs.minimumDelinquencyCnt)||((this.minimumDelinquencyCnt!= null)&&this.minimumDelinquencyCnt.equals(rhs.minimumDelinquencyCnt)))&&((this.triggerCycleCnt == rhs.triggerCycleCnt)||((this.triggerCycleCnt!= null)&&this.triggerCycleCnt.equals(rhs.triggerCycleCnt))))&&((this.policyTypeCd == rhs.policyTypeCd)||((this.policyTypeCd!= null)&&this.policyTypeCd.equals(rhs.policyTypeCd))))&&((this.featureClassificationCd == rhs.featureClassificationCd)||((this.featureClassificationCd!= null)&&this.featureClassificationCd.equals(rhs.featureClassificationCd))))&&((this.delinquencyLevelCd == rhs.delinquencyLevelCd)||((this.delinquencyLevelCd!= null)&&this.delinquencyLevelCd.equals(rhs.delinquencyLevelCd))))&&((this.repricingRate == rhs.repricingRate)||((this.repricingRate!= null)&&this.repricingRate.equals(rhs.repricingRate))))&&((this.repricingTypeCd == rhs.repricingTypeCd)||((this.repricingTypeCd!= null)&&this.repricingTypeCd.equals(rhs.repricingTypeCd))));
    }

}
