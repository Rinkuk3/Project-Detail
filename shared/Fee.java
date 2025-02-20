package com.td.api.mbofp.shared;

import java.math.BigDecimal;

public class Fee {

    private String typeCd;
    private String feeClassificationCd;
    private String featureClassificationCd;
    private String featureSubClassificationCd;
    private String transactionCategoryCd;
    private BigDecimal fixedFeeAmt;
    private PercentageBasedFee percentageBasedFee;

    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    public String getFeeClassificationCd() {
        return feeClassificationCd;
    }

    public void setFeeClassificationCd(String feeClassificationCd) {
        this.feeClassificationCd = feeClassificationCd;
    }

    public String getFeatureClassificationCd() {
        return featureClassificationCd;
    }

    public void setFeatureClassificationCd(String featureClassificationCd) {
        this.featureClassificationCd = featureClassificationCd;
    }

    public String getFeatureSubClassificationCd() {
        return featureSubClassificationCd;
    }

    public void setFeatureSubClassificationCd(String featureSubClassificationCd) {
        this.featureSubClassificationCd = featureSubClassificationCd;
    }

    public String getTransactionCategoryCd() {
        return transactionCategoryCd;
    }

    public void setTransactionCategoryCd(String transactionCategoryCd) {
        this.transactionCategoryCd = transactionCategoryCd;
    }

    public BigDecimal getFixedFeeAmt() {
        return fixedFeeAmt;
    }

    public void setFixedFeeAmt(BigDecimal fixedFeeAmt) {
        this.fixedFeeAmt = fixedFeeAmt;
    }

    public PercentageBasedFee getPercentageBasedFee() {
        return percentageBasedFee;
    }

    public void setPercentageBasedFee(PercentageBasedFee percentageBasedFee) {
        this.percentageBasedFee = percentageBasedFee;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Fee.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("typeCd");
        sb.append('=');
        sb.append(((this.typeCd == null)?"<null>":this.typeCd));
        sb.append(',');
        sb.append("feeClassificationCd");
        sb.append('=');
        sb.append(((this.feeClassificationCd == null)?"<null>":this.feeClassificationCd));
        sb.append(',');
        sb.append("featureClassificationCd");
        sb.append('=');
        sb.append(((this.featureClassificationCd == null)?"<null>":this.featureClassificationCd));
        sb.append(',');
        sb.append("featureSubClassificationCd");
        sb.append('=');
        sb.append(((this.featureSubClassificationCd == null)?"<null>":this.featureSubClassificationCd));
        sb.append(',');
        sb.append("transactionCategoryCd");
        sb.append('=');
        sb.append(((this.transactionCategoryCd == null)?"<null>":this.transactionCategoryCd));
        sb.append(',');
        sb.append("fixedFeeAmt");
        sb.append('=');
        sb.append(((this.fixedFeeAmt == null)?"<null>":this.fixedFeeAmt));
        sb.append(',');
        sb.append("percentageBasedFee");
        sb.append('=');
        sb.append(((this.percentageBasedFee == null)?"<null>":this.percentageBasedFee));
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
        result = ((result* 31)+((this.transactionCategoryCd == null)? 0 :this.transactionCategoryCd.hashCode()));
        result = ((result* 31)+((this.typeCd == null)? 0 :this.typeCd.hashCode()));
        result = ((result* 31)+((this.percentageBasedFee == null)? 0 :this.percentageBasedFee.hashCode()));
        result = ((result* 31)+((this.featureClassificationCd == null)? 0 :this.featureClassificationCd.hashCode()));
        result = ((result* 31)+((this.feeClassificationCd == null)? 0 :this.feeClassificationCd.hashCode()));
        result = ((result* 31)+((this.featureSubClassificationCd == null)? 0 :this.featureSubClassificationCd.hashCode()));
        result = ((result* 31)+((this.fixedFeeAmt == null)? 0 :this.fixedFeeAmt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Fee) == false) {
            return false;
        }
        Fee rhs = ((Fee) other);
        return ((((((((this.transactionCategoryCd == rhs.transactionCategoryCd)||((this.transactionCategoryCd!= null)&&this.transactionCategoryCd.equals(rhs.transactionCategoryCd)))&&((this.typeCd == rhs.typeCd)||((this.typeCd!= null)&&this.typeCd.equals(rhs.typeCd))))&&((this.percentageBasedFee == rhs.percentageBasedFee)||((this.percentageBasedFee!= null)&&this.percentageBasedFee.equals(rhs.percentageBasedFee))))&&((this.featureClassificationCd == rhs.featureClassificationCd)||((this.featureClassificationCd!= null)&&this.featureClassificationCd.equals(rhs.featureClassificationCd))))&&((this.feeClassificationCd == rhs.feeClassificationCd)||((this.feeClassificationCd!= null)&&this.feeClassificationCd.equals(rhs.feeClassificationCd))))&&((this.featureSubClassificationCd == rhs.featureSubClassificationCd)||((this.featureSubClassificationCd!= null)&&this.featureSubClassificationCd.equals(rhs.featureSubClassificationCd))))&&((this.fixedFeeAmt == rhs.fixedFeeAmt)||((this.fixedFeeAmt!= null)&&this.fixedFeeAmt.equals(rhs.fixedFeeAmt))));
    }

}
