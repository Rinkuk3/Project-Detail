package com.td.api.mbcca.response.account;

import java.math.BigDecimal;

public class LoyaltyAccountMetrics {

    BigDecimal rewardPointsOutstandingBalanceAmt;

    public BigDecimal getRewardPointsOutstandingBalanceAmt() {
        return rewardPointsOutstandingBalanceAmt;
    }

    public void setRewardPointsOutstandingBalanceAmt(BigDecimal rewardPointsOutstandingBalanceAmt) {
        this.rewardPointsOutstandingBalanceAmt = rewardPointsOutstandingBalanceAmt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LoyaltyAccountMetrics.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("rewardPointsOutstandingBalanceAmt");
        sb.append('=');
        sb.append(((this.rewardPointsOutstandingBalanceAmt == null)?"<null>":this.rewardPointsOutstandingBalanceAmt));
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
        result = ((result* 31)+((this.rewardPointsOutstandingBalanceAmt == null)? 0 :this.rewardPointsOutstandingBalanceAmt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LoyaltyAccountMetrics) == false) {
            return false;
        }
        LoyaltyAccountMetrics rhs = ((LoyaltyAccountMetrics) other);
        return ((this.rewardPointsOutstandingBalanceAmt == rhs.rewardPointsOutstandingBalanceAmt)||((this.rewardPointsOutstandingBalanceAmt!= null)&&this.rewardPointsOutstandingBalanceAmt.equals(rhs.rewardPointsOutstandingBalanceAmt)));
    }

}
