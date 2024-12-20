package com.td.api.mbcca.response.account;

import java.math.BigDecimal;

public class AnnualFeeInfo {

    BigDecimal lastAnnualMembershipFeeAmt;
    private String lastAnnualMembershipFeeDt;

    public BigDecimal getLastAnnualMembershipFeeAmt() {
        return lastAnnualMembershipFeeAmt;
    }

    public void setLastAnnualMembershipFeeAmt(BigDecimal lastAnnualMembershipFeeAmt) {
        this.lastAnnualMembershipFeeAmt = lastAnnualMembershipFeeAmt;
    }

    public String getLastAnnualMembershipFeeDt() {
        return lastAnnualMembershipFeeDt;
    }

    public void setLastAnnualMembershipFeeDt(String lastAnnualMembershipFeeDt) {
        this.lastAnnualMembershipFeeDt = lastAnnualMembershipFeeDt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AnnualFeeInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("lastAnnualMembershipFeeAmt");
        sb.append('=');
        sb.append(((this.lastAnnualMembershipFeeAmt == null)?"<null>":this.lastAnnualMembershipFeeAmt));
        sb.append(',');
        sb.append("lastAnnualMembershipFeeDt");
        sb.append('=');
        sb.append(((this.lastAnnualMembershipFeeDt == null)?"<null>":this.lastAnnualMembershipFeeDt));
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
        result = ((result* 31)+((this.lastAnnualMembershipFeeDt == null)? 0 :this.lastAnnualMembershipFeeDt.hashCode()));
        result = ((result* 31)+((this.lastAnnualMembershipFeeAmt == null)? 0 :this.lastAnnualMembershipFeeAmt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AnnualFeeInfo) == false) {
            return false;
        }
        AnnualFeeInfo rhs = ((AnnualFeeInfo) other);
        return (((this.lastAnnualMembershipFeeDt == rhs.lastAnnualMembershipFeeDt)||((this.lastAnnualMembershipFeeDt!= null)&&this.lastAnnualMembershipFeeDt.equals(rhs.lastAnnualMembershipFeeDt)))&&((this.lastAnnualMembershipFeeAmt == rhs.lastAnnualMembershipFeeAmt)||((this.lastAnnualMembershipFeeAmt!= null)&&this.lastAnnualMembershipFeeAmt.equals(rhs.lastAnnualMembershipFeeAmt))));
    }

}
