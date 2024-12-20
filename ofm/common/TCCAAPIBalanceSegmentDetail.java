package com.td.api.ofm.common;

public class TCCAAPIBalanceSegmentDetail {

    private String balanceSegmentTypeCd;
    private String balanceCategoryTypeCd;
    private String rateTypeCd;
    private String transactionCategoryCd;
    private TCCAAPIPromotion promotion;
    private String expiryDt;

    public String getBalanceSegmentTypeCd() {
        return balanceSegmentTypeCd;
    }

    public void setBalanceSegmentTypeCd(String balanceSegmentTypeCd) {
        this.balanceSegmentTypeCd = balanceSegmentTypeCd;
    }

    public String getBalanceCategoryTypeCd() {
        return balanceCategoryTypeCd;
    }

    public void setBalanceCategoryTypeCd(String balanceCategoryTypeCd) {
        this.balanceCategoryTypeCd = balanceCategoryTypeCd;
    }

    public String getRateTypeCd() {
        return rateTypeCd;
    }

    public void setRateTypeCd(String rateTypeCd) {
        this.rateTypeCd = rateTypeCd;
    }

    public String getTransactionCategoryCd() {
        return transactionCategoryCd;
    }

    public void setTransactionCategoryCd(String transactionCategoryCd) {
        this.transactionCategoryCd = transactionCategoryCd;
    }

    public TCCAAPIPromotion getPromotion() {
        return promotion;
    }

    public void setPromotion(TCCAAPIPromotion promotion) {
        this.promotion = promotion;
    }

    public String getExpiryDt() {
        return expiryDt;
    }

    public void setExpiryDt(String expiryDt) {
        this.expiryDt = expiryDt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TCCAAPIBalanceSegmentDetail.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("balanceSegmentTypeCd");
        sb.append('=');
        sb.append(((this.balanceSegmentTypeCd == null)?"<null>":this.balanceSegmentTypeCd));
        sb.append(',');
        sb.append("balanceCategoryTypeCd");
        sb.append('=');
        sb.append(((this.balanceCategoryTypeCd == null)?"<null>":this.balanceCategoryTypeCd));
        sb.append(',');
        sb.append("rateTypeCd");
        sb.append('=');
        sb.append(((this.rateTypeCd == null)?"<null>":this.rateTypeCd));
        sb.append(',');
        sb.append("transactionCategoryCd");
        sb.append('=');
        sb.append(((this.transactionCategoryCd == null)?"<null>":this.transactionCategoryCd));
        sb.append(',');
        sb.append("promotion");
        sb.append('=');
        sb.append(((this.promotion == null)?"<null>":this.promotion));
        sb.append(',');
        sb.append("expiryDt");
        sb.append('=');
        sb.append(((this.expiryDt == null)?"<null>":this.expiryDt));
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
        result = ((result* 31)+((this.balanceSegmentTypeCd == null)? 0 :this.balanceSegmentTypeCd.hashCode()));
        result = ((result* 31)+((this.balanceCategoryTypeCd == null)? 0 :this.balanceCategoryTypeCd.hashCode()));
        result = ((result* 31)+((this.expiryDt == null)? 0 :this.expiryDt.hashCode()));
        result = ((result* 31)+((this.rateTypeCd == null)? 0 :this.rateTypeCd.hashCode()));
        result = ((result* 31)+((this.promotion == null)? 0 :this.promotion.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TCCAAPIBalanceSegmentDetail) == false) {
            return false;
        }
        TCCAAPIBalanceSegmentDetail rhs = ((TCCAAPIBalanceSegmentDetail) other);
        return (((((((this.transactionCategoryCd == rhs.transactionCategoryCd)||((this.transactionCategoryCd!= null)&&this.transactionCategoryCd.equals(rhs.transactionCategoryCd)))&&((this.balanceSegmentTypeCd == rhs.balanceSegmentTypeCd)||((this.balanceSegmentTypeCd!= null)&&this.balanceSegmentTypeCd.equals(rhs.balanceSegmentTypeCd))))&&((this.balanceCategoryTypeCd == rhs.balanceCategoryTypeCd)||((this.balanceCategoryTypeCd!= null)&&this.balanceCategoryTypeCd.equals(rhs.balanceCategoryTypeCd))))&&((this.expiryDt == rhs.expiryDt)||((this.expiryDt!= null)&&this.expiryDt.equals(rhs.expiryDt))))&&((this.rateTypeCd == rhs.rateTypeCd)||((this.rateTypeCd!= null)&&this.rateTypeCd.equals(rhs.rateTypeCd))))&&((this.promotion == rhs.promotion)||((this.promotion!= null)&&this.promotion.equals(rhs.promotion))));
    }

}
