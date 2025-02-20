package com.td.api.mbofp.shared;

import java.math.BigDecimal;

public class VariableRate {

    private BigDecimal interestIndexRate;
    private BigDecimal spreadRate;
    private BigDecimal upperLimitRate;
    private BigDecimal lowerLimitRate;

    public BigDecimal getInterestIndexRate() {
        return interestIndexRate;
    }

    public void setInterestIndexRate(BigDecimal interestIndexRate) {
        this.interestIndexRate = interestIndexRate;
    }

    public BigDecimal getSpreadRate() {
        return spreadRate;
    }

    public void setSpreadRate(BigDecimal spreadRate) {
        this.spreadRate = spreadRate;
    }

    public BigDecimal getUpperLimitRate() {
        return upperLimitRate;
    }

    public void setUpperLimitRate(BigDecimal upperLimitRate) {
        this.upperLimitRate = upperLimitRate;
    }

    public BigDecimal getLowerLimitRate() {
        return lowerLimitRate;
    }

    public void setLowerLimitRate(BigDecimal lowerLimitRate) {
        this.lowerLimitRate = lowerLimitRate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(VariableRate.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("interestIndexRate");
        sb.append('=');
        sb.append(((this.interestIndexRate == null)?"<null>":this.interestIndexRate));
        sb.append(',');
        sb.append("spreadRate");
        sb.append('=');
        sb.append(((this.spreadRate == null)?"<null>":this.spreadRate));
        sb.append(',');
        sb.append("upperLimitRate");
        sb.append('=');
        sb.append(((this.upperLimitRate == null)?"<null>":this.upperLimitRate));
        sb.append(',');
        sb.append("lowerLimitRate");
        sb.append('=');
        sb.append(((this.lowerLimitRate == null)?"<null>":this.lowerLimitRate));
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
        result = ((result* 31)+((this.interestIndexRate == null)? 0 :this.interestIndexRate.hashCode()));
        result = ((result* 31)+((this.upperLimitRate == null)? 0 :this.upperLimitRate.hashCode()));
        result = ((result* 31)+((this.spreadRate == null)? 0 :this.spreadRate.hashCode()));
        result = ((result* 31)+((this.lowerLimitRate == null)? 0 :this.lowerLimitRate.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof VariableRate) == false) {
            return false;
        }
        VariableRate rhs = ((VariableRate) other);
        return (((((this.interestIndexRate == rhs.interestIndexRate)||((this.interestIndexRate!= null)&&this.interestIndexRate.equals(rhs.interestIndexRate)))&&((this.upperLimitRate == rhs.upperLimitRate)||((this.upperLimitRate!= null)&&this.upperLimitRate.equals(rhs.upperLimitRate))))&&((this.spreadRate == rhs.spreadRate)||((this.spreadRate!= null)&&this.spreadRate.equals(rhs.spreadRate))))&&((this.lowerLimitRate == rhs.lowerLimitRate)||((this.lowerLimitRate!= null)&&this.lowerLimitRate.equals(rhs.lowerLimitRate))));
    }

}
