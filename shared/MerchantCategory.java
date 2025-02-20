package com.td.api.mbofp.shared;

public class MerchantCategory {

    private String featureDesc;
    private String fromMerchantCategoryCd;
    private String toMerchantCategoryCd;

    public String getFeatureDesc() {
        return featureDesc;
    }

    public void setFeatureDesc(String featureDesc) {
        this.featureDesc = featureDesc;
    }

    public String getFromMerchantCategoryCd() {
        return fromMerchantCategoryCd;
    }

    public void setFromMerchantCategoryCd(String fromMerchantCategoryCd) {
        this.fromMerchantCategoryCd = fromMerchantCategoryCd;
    }

    public String getToMerchantCategoryCd() {
        return toMerchantCategoryCd;
    }

    public void setToMerchantCategoryCd(String toMerchantCategoryCd) {
        this.toMerchantCategoryCd = toMerchantCategoryCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MerchantCategory.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("featureDesc");
        sb.append('=');
        sb.append(((this.featureDesc == null)?"<null>":this.featureDesc));
        sb.append(',');
        sb.append("fromMerchantCategoryCd");
        sb.append('=');
        sb.append(((this.fromMerchantCategoryCd == null)?"<null>":this.fromMerchantCategoryCd));
        sb.append(',');
        sb.append("toMerchantCategoryCd");
        sb.append('=');
        sb.append(((this.toMerchantCategoryCd == null)?"<null>":this.toMerchantCategoryCd));
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
        result = ((result* 31)+((this.fromMerchantCategoryCd == null)? 0 :this.fromMerchantCategoryCd.hashCode()));
        result = ((result* 31)+((this.toMerchantCategoryCd == null)? 0 :this.toMerchantCategoryCd.hashCode()));
        result = ((result* 31)+((this.featureDesc == null)? 0 :this.featureDesc.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MerchantCategory) == false) {
            return false;
        }
        MerchantCategory rhs = ((MerchantCategory) other);
        return ((((this.fromMerchantCategoryCd == rhs.fromMerchantCategoryCd)||((this.fromMerchantCategoryCd!= null)&&this.fromMerchantCategoryCd.equals(rhs.fromMerchantCategoryCd)))&&((this.toMerchantCategoryCd == rhs.toMerchantCategoryCd)||((this.toMerchantCategoryCd!= null)&&this.toMerchantCategoryCd.equals(rhs.toMerchantCategoryCd))))&&((this.featureDesc == rhs.featureDesc)||((this.featureDesc!= null)&&this.featureDesc.equals(rhs.featureDesc))));
    }

}
