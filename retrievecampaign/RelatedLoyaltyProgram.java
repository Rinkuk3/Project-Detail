package com.td.api.mbofp.response.retrievecampaign;

import com.td.api.mbofp.shared.LoyaltyProgram;

public class RelatedLoyaltyProgram {

    private LoyaltyProgram loyaltyProgram;

    public LoyaltyProgram getLoyaltyProgram() {
        return loyaltyProgram;
    }

    public void setLoyaltyProgram(LoyaltyProgram loyaltyProgram) {
        this.loyaltyProgram = loyaltyProgram;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RelatedLoyaltyProgram.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("loyaltyProgram");
        sb.append('=');
        sb.append(((this.loyaltyProgram == null)?"<null>":this.loyaltyProgram));
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
        result = ((result* 31)+((this.loyaltyProgram == null)? 0 :this.loyaltyProgram.hashCode()));
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
        return ((this.loyaltyProgram == rhs.loyaltyProgram)||((this.loyaltyProgram!= null)&&this.loyaltyProgram.equals(rhs.loyaltyProgram)));
    }

}
