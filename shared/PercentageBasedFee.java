package com.td.api.mbofp.shared;

import java.math.BigDecimal;

public class PercentageBasedFee {

    private BigDecimal percentageRate;
    private BigDecimal upperLimitAmt;
    private BigDecimal lowerLimitAmt;

    public BigDecimal getPercentageRate() {
        return percentageRate;
    }

    public void setPercentageRate(BigDecimal percentageRate) {
        this.percentageRate = percentageRate;
    }

    public BigDecimal getUpperLimitAmt() {
        return upperLimitAmt;
    }

    public void setUpperLimitAmt(BigDecimal upperLimitAmt) {
        this.upperLimitAmt = upperLimitAmt;
    }

    public BigDecimal getLowerLimitAmt() {
        return lowerLimitAmt;
    }

    public void setLowerLimitAmt(BigDecimal lowerLimitAmt) {
        this.lowerLimitAmt = lowerLimitAmt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PercentageBasedFee.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("percentageRate");
        sb.append('=');
        sb.append(((this.percentageRate == null)?"<null>":this.percentageRate));
        sb.append(',');
        sb.append("upperLimitAmt");
        sb.append('=');
        sb.append(((this.upperLimitAmt == null)?"<null>":this.upperLimitAmt));
        sb.append(',');
        sb.append("lowerLimitAmt");
        sb.append('=');
        sb.append(((this.lowerLimitAmt == null)?"<null>":this.lowerLimitAmt));
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
        result = ((result* 31)+((this.lowerLimitAmt == null)? 0 :this.lowerLimitAmt.hashCode()));
        result = ((result* 31)+((this.percentageRate == null)? 0 :this.percentageRate.hashCode()));
        result = ((result* 31)+((this.upperLimitAmt == null)? 0 :this.upperLimitAmt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PercentageBasedFee) == false) {
            return false;
        }
        PercentageBasedFee rhs = ((PercentageBasedFee) other);
        return ((((this.lowerLimitAmt == rhs.lowerLimitAmt)||((this.lowerLimitAmt!= null)&&this.lowerLimitAmt.equals(rhs.lowerLimitAmt)))&&((this.percentageRate == rhs.percentageRate)||((this.percentageRate!= null)&&this.percentageRate.equals(rhs.percentageRate))))&&((this.upperLimitAmt == rhs.upperLimitAmt)||((this.upperLimitAmt!= null)&&this.upperLimitAmt.equals(rhs.upperLimitAmt))));
    }

}
