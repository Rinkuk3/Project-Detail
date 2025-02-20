package com.td.api.mbofp.shared;

public class LoyaltyProgram {

    private String loyaltyProductId;
    private String loyaltyProductName;
    private String loyaltyProductDesc;

    public String getLoyaltyProductId() {
        return loyaltyProductId;
    }

    public void setLoyaltyProductId(String loyaltyProductId) {
        this.loyaltyProductId = loyaltyProductId;
    }

    public String getLoyaltyProductName() {
        return loyaltyProductName;
    }

    public void setLoyaltyProductName(String loyaltyProductName) {
        this.loyaltyProductName = loyaltyProductName;
    }

    public String getLoyaltyProductDesc() {
        return loyaltyProductDesc;
    }

    public void setLoyaltyProductDesc(String loyaltyProductDesc) {
        this.loyaltyProductDesc = loyaltyProductDesc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LoyaltyProgram.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("loyaltyProductId");
        sb.append('=');
        sb.append(((this.loyaltyProductId == null)?"<null>":this.loyaltyProductId));
        sb.append(',');
        sb.append("loyaltyProductName");
        sb.append('=');
        sb.append(((this.loyaltyProductName == null)?"<null>":this.loyaltyProductName));
        sb.append(',');
        sb.append("loyaltyProductDesc");
        sb.append('=');
        sb.append(((this.loyaltyProductDesc == null)?"<null>":this.loyaltyProductDesc));
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
        result = ((result* 31)+((this.loyaltyProductName == null)? 0 :this.loyaltyProductName.hashCode()));
        result = ((result* 31)+((this.loyaltyProductDesc == null)? 0 :this.loyaltyProductDesc.hashCode()));
        result = ((result* 31)+((this.loyaltyProductId == null)? 0 :this.loyaltyProductId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LoyaltyProgram) == false) {
            return false;
        }
        LoyaltyProgram rhs = ((LoyaltyProgram) other);
        return ((((this.loyaltyProductName == rhs.loyaltyProductName)||((this.loyaltyProductName!= null)&&this.loyaltyProductName.equals(rhs.loyaltyProductName)))&&((this.loyaltyProductDesc == rhs.loyaltyProductDesc)||((this.loyaltyProductDesc!= null)&&this.loyaltyProductDesc.equals(rhs.loyaltyProductDesc))))&&((this.loyaltyProductId == rhs.loyaltyProductId)||((this.loyaltyProductId!= null)&&this.loyaltyProductId.equals(rhs.loyaltyProductId))));
    }

}
