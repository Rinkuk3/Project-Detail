package com.td.api.mbofp.response.retrievecampaign;

public class CreditCardProductPackage {

    private String productPackageNum;
    private String productPackageDesc;
    private FeatureGroup featureGroup;

    public String getProductPackageNum() {
        return productPackageNum;
    }

    public void setProductPackageNum(String productPackageNum) {
        this.productPackageNum = productPackageNum;
    }

    public String getProductPackageDesc() {
        return productPackageDesc;
    }

    public void setProductPackageDesc(String productPackageDesc) {
        this.productPackageDesc = productPackageDesc;
    }

    public FeatureGroup getFeatureGroup() {
        return featureGroup;
    }

    public void setFeatureGroup(FeatureGroup featureGroup) {
        this.featureGroup = featureGroup;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CreditCardProductPackage.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("productPackageNum");
        sb.append('=');
        sb.append(((this.productPackageNum == null)?"<null>":this.productPackageNum));
        sb.append(',');
        sb.append("productPackageDesc");
        sb.append('=');
        sb.append(((this.productPackageDesc == null)?"<null>":this.productPackageDesc));
        sb.append(',');
        sb.append("featureGroup");
        sb.append('=');
        sb.append(((this.featureGroup == null)?"<null>":this.featureGroup));
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
        result = ((result* 31)+((this.productPackageDesc == null)? 0 :this.productPackageDesc.hashCode()));
        result = ((result* 31)+((this.productPackageNum == null)? 0 :this.productPackageNum.hashCode()));
        result = ((result* 31)+((this.featureGroup == null)? 0 :this.featureGroup.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreditCardProductPackage) == false) {
            return false;
        }
        CreditCardProductPackage rhs = ((CreditCardProductPackage) other);
        return ((((this.productPackageDesc == rhs.productPackageDesc)||((this.productPackageDesc!= null)&&this.productPackageDesc.equals(rhs.productPackageDesc)))&&((this.productPackageNum == rhs.productPackageNum)||((this.productPackageNum!= null)&&this.productPackageNum.equals(rhs.productPackageNum))))&&((this.featureGroup == rhs.featureGroup)||((this.featureGroup!= null)&&this.featureGroup.equals(rhs.featureGroup))));
    }

}
