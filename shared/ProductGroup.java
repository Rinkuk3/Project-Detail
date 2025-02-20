package com.td.api.mbofp.shared;

public class ProductGroup {

    private String productGroupId;
    private String productGroupName;
    private String productGroupDesc;

    public String getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(String productGroupId) {
        this.productGroupId = productGroupId;
    }

    public String getProductGroupName() {
        return productGroupName;
    }

    public void setProductGroupName(String productGroupName) {
        this.productGroupName = productGroupName;
    }

    public String getProductGroupDesc() {
        return productGroupDesc;
    }

    public void setProductGroupDesc(String productGroupDesc) {
        this.productGroupDesc = productGroupDesc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ProductGroup.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("productGroupId");
        sb.append('=');
        sb.append(((this.productGroupId == null)?"<null>":this.productGroupId));
        sb.append(',');
        sb.append("productGroupName");
        sb.append('=');
        sb.append(((this.productGroupName == null)?"<null>":this.productGroupName));
        sb.append(',');
        sb.append("productGroupDesc");
        sb.append('=');
        sb.append(((this.productGroupDesc == null)?"<null>":this.productGroupDesc));
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
        result = ((result* 31)+((this.productGroupId == null)? 0 :this.productGroupId.hashCode()));
        result = ((result* 31)+((this.productGroupName == null)? 0 :this.productGroupName.hashCode()));
        result = ((result* 31)+((this.productGroupDesc == null)? 0 :this.productGroupDesc.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProductGroup) == false) {
            return false;
        }
        ProductGroup rhs = ((ProductGroup) other);
        return ((((this.productGroupId == rhs.productGroupId)||((this.productGroupId!= null)&&this.productGroupId.equals(rhs.productGroupId)))&&((this.productGroupName == rhs.productGroupName)||((this.productGroupName!= null)&&this.productGroupName.equals(rhs.productGroupName))))&&((this.productGroupDesc == rhs.productGroupDesc)||((this.productGroupDesc!= null)&&this.productGroupDesc.equals(rhs.productGroupDesc))));
    }

}
