package com.td.api.mbofp.response.retrieveofferlist;

import com.td.api.mbofp.shared.LoyaltyProgram;

public class RelatedLoyaltyProgram {

    private LoyaltyProgram loyaltyProgram;
    private String productRelationshipTypeCd;
    private Boolean membershipRequiredInd;

    public LoyaltyProgram getLoyaltyProgram() {
        return loyaltyProgram;
    }

    public void setLoyaltyProgram(LoyaltyProgram loyaltyProgram) {
        this.loyaltyProgram = loyaltyProgram;
    }

    public String getProductRelationshipTypeCd() {
        return productRelationshipTypeCd;
    }

    public void setProductRelationshipTypeCd(String productRelationshipTypeCd) {
        this.productRelationshipTypeCd = productRelationshipTypeCd;
    }

    public Boolean getMembershipRequiredInd() {
        return membershipRequiredInd;
    }

    public void setMembershipRequiredInd(Boolean membershipRequiredInd) {
        this.membershipRequiredInd = membershipRequiredInd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RelatedLoyaltyProgram.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("loyaltyProgram");
        sb.append('=');
        sb.append(((this.loyaltyProgram == null)?"<null>":this.loyaltyProgram));
        sb.append(',');
        sb.append("productRelationshipTypeCd");
        sb.append('=');
        sb.append(((this.productRelationshipTypeCd == null)?"<null>":this.productRelationshipTypeCd));
        sb.append(',');
        sb.append("membershipRequiredInd");
        sb.append('=');
        sb.append(((this.membershipRequiredInd == null)?"<null>":this.membershipRequiredInd));
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
        result = ((result* 31)+((this.membershipRequiredInd == null)? 0 :this.membershipRequiredInd.hashCode()));
        result = ((result* 31)+((this.loyaltyProgram == null)? 0 :this.loyaltyProgram.hashCode()));
        result = ((result* 31)+((this.productRelationshipTypeCd == null)? 0 :this.productRelationshipTypeCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RelatedLoyaltyProgram) == false) {
            return false;
        }
        RelatedLoyaltyProgram rhs = ((RelatedLoyaltyProgram) other);
        return ((((this.membershipRequiredInd == rhs.membershipRequiredInd)||((this.membershipRequiredInd!= null)&&this.membershipRequiredInd.equals(rhs.membershipRequiredInd)))&&((this.loyaltyProgram == rhs.loyaltyProgram)||((this.loyaltyProgram!= null)&&this.loyaltyProgram.equals(rhs.loyaltyProgram))))&&((this.productRelationshipTypeCd == rhs.productRelationshipTypeCd)||((this.productRelationshipTypeCd!= null)&&this.productRelationshipTypeCd.equals(rhs.productRelationshipTypeCd))));
    }

}
