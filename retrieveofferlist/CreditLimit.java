package com.td.api.mbofp.response.retrieveofferlist;

import java.math.BigDecimal;

public class CreditLimit {

    private String featureClassificationCd;
    private BigDecimal creditLimitAmt;

    public String getFeatureClassificationCd() {
        return featureClassificationCd;
    }

    public void setFeatureClassificationCd(String featureClassificationCd) {
        this.featureClassificationCd = featureClassificationCd;
    }

    public BigDecimal getCreditLimitAmt() {
        return creditLimitAmt;
    }

    public void setCreditLimitAmt(BigDecimal creditLimitAmt) {
        this.creditLimitAmt = creditLimitAmt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CreditLimit.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("featureClassificationCd");
        sb.append('=');
        sb.append(((this.featureClassificationCd == null)?"<null>":this.featureClassificationCd));
        sb.append(',');
        sb.append("creditLimitAmt");
        sb.append('=');
        sb.append(((this.creditLimitAmt == null)?"<null>":this.creditLimitAmt));
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
        result = ((result* 31)+((this.creditLimitAmt == null)? 0 :this.creditLimitAmt.hashCode()));
        result = ((result* 31)+((this.featureClassificationCd == null)? 0 :this.featureClassificationCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreditLimit) == false) {
            return false;
        }
        CreditLimit rhs = ((CreditLimit) other);
        return (((this.creditLimitAmt == rhs.creditLimitAmt)||((this.creditLimitAmt!= null)&&this.creditLimitAmt.equals(rhs.creditLimitAmt)))&&((this.featureClassificationCd == rhs.featureClassificationCd)||((this.featureClassificationCd!= null)&&this.featureClassificationCd.equals(rhs.featureClassificationCd))));
    }

}
