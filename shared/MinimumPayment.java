package com.td.api.mbofp.shared;

import java.math.BigDecimal;

public class MinimumPayment {

    private BigDecimal minimumPaymentAmt;
    private BigDecimal calculationPercentageRate;

    public BigDecimal getMinimumPaymentAmt() {
        return minimumPaymentAmt;
    }

    public void setMinimumPaymentAmt(BigDecimal minimumPaymentAmt) {
        this.minimumPaymentAmt = minimumPaymentAmt;
    }

    public BigDecimal getCalculationPercentageRate() {
        return calculationPercentageRate;
    }

    public void setCalculationPercentageRate(BigDecimal calculationPercentageRate) {
        this.calculationPercentageRate = calculationPercentageRate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MinimumPayment.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("minimumPaymentAmt");
        sb.append('=');
        sb.append(((this.minimumPaymentAmt == null)?"<null>":this.minimumPaymentAmt));
        sb.append(',');
        sb.append("calculationPercentageRate");
        sb.append('=');
        sb.append(((this.calculationPercentageRate == null)?"<null>":this.calculationPercentageRate));
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
        result = ((result* 31)+((this.minimumPaymentAmt == null)? 0 :this.minimumPaymentAmt.hashCode()));
        result = ((result* 31)+((this.calculationPercentageRate == null)? 0 :this.calculationPercentageRate.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MinimumPayment) == false) {
            return false;
        }
        MinimumPayment rhs = ((MinimumPayment) other);
        return (((this.minimumPaymentAmt == rhs.minimumPaymentAmt)||((this.minimumPaymentAmt!= null)&&this.minimumPaymentAmt.equals(rhs.minimumPaymentAmt)))&&((this.calculationPercentageRate == rhs.calculationPercentageRate)||((this.calculationPercentageRate!= null)&&this.calculationPercentageRate.equals(rhs.calculationPercentageRate))));
    }

}
