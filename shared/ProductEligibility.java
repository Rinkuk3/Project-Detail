package com.td.api.mbofp.shared;

public class ProductEligibility {

    private String productFeatureEligibilityTypeCd;
    private String productEligibilityVal;

    public String getProductFeatureEligibilityTypeCd() {
        return productFeatureEligibilityTypeCd;
    }

    public void setProductFeatureEligibilityTypeCd(String productFeatureEligibilityTypeCd) {
        this.productFeatureEligibilityTypeCd = productFeatureEligibilityTypeCd;
    }

    public String getProductEligibilityVal() {
        return productEligibilityVal;
    }

    public void setProductEligibilityVal(String productEligibilityVal) {
        this.productEligibilityVal = productEligibilityVal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ProductEligibility.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("productFeatureEligibilityTypeCd");
        sb.append('=');
        sb.append(((this.productFeatureEligibilityTypeCd == null)?"<null>":this.productFeatureEligibilityTypeCd));
        sb.append(',');
        sb.append("productEligibilityVal");
        sb.append('=');
        sb.append(((this.productEligibilityVal == null)?"<null>":this.productEligibilityVal));
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
        result = ((result* 31)+((this.productFeatureEligibilityTypeCd == null)? 0 :this.productFeatureEligibilityTypeCd.hashCode()));
        result = ((result* 31)+((this.productEligibilityVal == null)? 0 :this.productEligibilityVal.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProductEligibility) == false) {
            return false;
        }
        ProductEligibility rhs = ((ProductEligibility) other);
        return (((this.productFeatureEligibilityTypeCd == rhs.productFeatureEligibilityTypeCd)||((this.productFeatureEligibilityTypeCd!= null)&&this.productFeatureEligibilityTypeCd.equals(rhs.productFeatureEligibilityTypeCd)))&&((this.productEligibilityVal == rhs.productEligibilityVal)||((this.productEligibilityVal!= null)&&this.productEligibilityVal.equals(rhs.productEligibilityVal))));
    }

}
