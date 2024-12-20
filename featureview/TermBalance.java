package com.td.api.mbcca.response.account.featureview;

public class TermBalance {

    private String termBalanceCd;
    private String termBalanceDesc;
    java.math.BigDecimal effectiveRate;
    private String rateDesc;
    private String rateCalculationMethodCd;
    java.math.BigDecimal disclosureGroupRate;
    java.math.BigDecimal disclosureGroupMinimumRate;
    java.math.BigDecimal disclosureGroupMaximumRate;
    private String disclosureGroupRateCalculationMethodCd;

    public String getTermBalanceCd() {
        return termBalanceCd;
    }

    public void setTermBalanceCd(String termBalanceCd) {
        this.termBalanceCd = termBalanceCd;
    }

    public String getTermBalanceDesc() {
        return termBalanceDesc;
    }

    public void setTermBalanceDesc(String termBalanceDesc) {
        this.termBalanceDesc = termBalanceDesc;
    }

    public java.math.BigDecimal getEffectiveRate() {
        return effectiveRate;
    }

    public void setEffectiveRate(java.math.BigDecimal effectiveRate) {
        this.effectiveRate = effectiveRate;
    }

    public String getRateDesc() {
        return rateDesc;
    }

    public void setRateDesc(String rateDesc) {
        this.rateDesc = rateDesc;
    }

    public String getRateCalculationMethodCd() {
        return rateCalculationMethodCd;
    }

    public void setRateCalculationMethodCd(String rateCalculationMethodCd) {
        this.rateCalculationMethodCd = rateCalculationMethodCd;
    }

    public java.math.BigDecimal getDisclosureGroupRate() {
        return disclosureGroupRate;
    }

    public void setDisclosureGroupRate(java.math.BigDecimal disclosureGroupRate) {
        this.disclosureGroupRate = disclosureGroupRate;
    }

    public java.math.BigDecimal getDisclosureGroupMinimumRate() {
        return disclosureGroupMinimumRate;
    }

    public void setDisclosureGroupMinimumRate(java.math.BigDecimal disclosureGroupMinimumRate) {
        this.disclosureGroupMinimumRate = disclosureGroupMinimumRate;
    }

    public java.math.BigDecimal getDisclosureGroupMaximumRate() {
        return disclosureGroupMaximumRate;
    }

    public void setDisclosureGroupMaximumRate(java.math.BigDecimal disclosureGroupMaximumRate) {
        this.disclosureGroupMaximumRate = disclosureGroupMaximumRate;
    }

    public String getDisclosureGroupRateCalculationMethodCd() {
        return disclosureGroupRateCalculationMethodCd;
    }

    public void setDisclosureGroupRateCalculationMethodCd(String disclosureGroupRateCalculationMethodCd) {
        this.disclosureGroupRateCalculationMethodCd = disclosureGroupRateCalculationMethodCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TermBalance.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("termBalanceCd");
        sb.append('=');
        sb.append(((this.termBalanceCd == null)?"<null>":this.termBalanceCd));
        sb.append(',');
        sb.append("termBalanceDesc");
        sb.append('=');
        sb.append(((this.termBalanceDesc == null)?"<null>":this.termBalanceDesc));
        sb.append(',');
        sb.append("effectiveRate");
        sb.append('=');
        sb.append(((this.effectiveRate == null)?"<null>":this.effectiveRate));
        sb.append(',');
        sb.append("rateDesc");
        sb.append('=');
        sb.append(((this.rateDesc == null)?"<null>":this.rateDesc));
        sb.append(',');
        sb.append("rateCalculationMethodCd");
        sb.append('=');
        sb.append(((this.rateCalculationMethodCd == null)?"<null>":this.rateCalculationMethodCd));
        sb.append(',');
        sb.append("disclosureGroupRate");
        sb.append('=');
        sb.append(((this.disclosureGroupRate == null)?"<null>":this.disclosureGroupRate));
        sb.append(',');
        sb.append("disclosureGroupMinimumRate");
        sb.append('=');
        sb.append(((this.disclosureGroupMinimumRate == null)?"<null>":this.disclosureGroupMinimumRate));
        sb.append(',');
        sb.append("disclosureGroupMaximumRate");
        sb.append('=');
        sb.append(((this.disclosureGroupMaximumRate == null)?"<null>":this.disclosureGroupMaximumRate));
        sb.append(',');
        sb.append("disclosureGroupRateCalculationMethodCd");
        sb.append('=');
        sb.append(((this.disclosureGroupRateCalculationMethodCd == null)?"<null>":this.disclosureGroupRateCalculationMethodCd));
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
        result = ((result* 31)+((this.termBalanceDesc == null)? 0 :this.termBalanceDesc.hashCode()));
        result = ((result* 31)+((this.disclosureGroupRate == null)? 0 :this.disclosureGroupRate.hashCode()));
        result = ((result* 31)+((this.disclosureGroupMinimumRate == null)? 0 :this.disclosureGroupMinimumRate.hashCode()));
        result = ((result* 31)+((this.rateDesc == null)? 0 :this.rateDesc.hashCode()));
        result = ((result* 31)+((this.effectiveRate == null)? 0 :this.effectiveRate.hashCode()));
        result = ((result* 31)+((this.disclosureGroupRateCalculationMethodCd == null)? 0 :this.disclosureGroupRateCalculationMethodCd.hashCode()));
        result = ((result* 31)+((this.termBalanceCd == null)? 0 :this.termBalanceCd.hashCode()));
        result = ((result* 31)+((this.rateCalculationMethodCd == null)? 0 :this.rateCalculationMethodCd.hashCode()));
        result = ((result* 31)+((this.disclosureGroupMaximumRate == null)? 0 :this.disclosureGroupMaximumRate.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TermBalance) == false) {
            return false;
        }
        TermBalance rhs = ((TermBalance) other);
        return ((((((((((this.termBalanceDesc == rhs.termBalanceDesc)||((this.termBalanceDesc!= null)&&this.termBalanceDesc.equals(rhs.termBalanceDesc)))&&((this.disclosureGroupRate == rhs.disclosureGroupRate)||((this.disclosureGroupRate!= null)&&this.disclosureGroupRate.equals(rhs.disclosureGroupRate))))&&((this.disclosureGroupMinimumRate == rhs.disclosureGroupMinimumRate)||((this.disclosureGroupMinimumRate!= null)&&this.disclosureGroupMinimumRate.equals(rhs.disclosureGroupMinimumRate))))&&((this.rateDesc == rhs.rateDesc)||((this.rateDesc!= null)&&this.rateDesc.equals(rhs.rateDesc))))&&((this.effectiveRate == rhs.effectiveRate)||((this.effectiveRate!= null)&&this.effectiveRate.equals(rhs.effectiveRate))))&&((this.disclosureGroupRateCalculationMethodCd == rhs.disclosureGroupRateCalculationMethodCd)||((this.disclosureGroupRateCalculationMethodCd!= null)&&this.disclosureGroupRateCalculationMethodCd.equals(rhs.disclosureGroupRateCalculationMethodCd))))&&((this.termBalanceCd == rhs.termBalanceCd)||((this.termBalanceCd!= null)&&this.termBalanceCd.equals(rhs.termBalanceCd))))&&((this.rateCalculationMethodCd == rhs.rateCalculationMethodCd)||((this.rateCalculationMethodCd!= null)&&this.rateCalculationMethodCd.equals(rhs.rateCalculationMethodCd))))&&((this.disclosureGroupMaximumRate == rhs.disclosureGroupMaximumRate)||((this.disclosureGroupMaximumRate!= null)&&this.disclosureGroupMaximumRate.equals(rhs.disclosureGroupMaximumRate))));
    }

}
