package com.td.api.mbcca.response.account;

import com.td.api.mbcca.shared.Cccyamt;

public class MembershipSingleFee {

    private Cccyamt annualMembershipFeeCccyamt;
    private Cccyamt maximumAnnualMembershipFeeCccyamt;
    private Cccyamt additionalCardAnnualMembershipFeeCccyamt;
    private Integer numberOfFreeChargeCardsCnt;

    public Cccyamt getAnnualMembershipFeeCccyamt() {
        return annualMembershipFeeCccyamt;
    }

    public void setAnnualMembershipFeeCccyamt(Cccyamt annualMembershipFeeCccyamt) {
        this.annualMembershipFeeCccyamt = annualMembershipFeeCccyamt;
    }

    public Cccyamt getMaximumAnnualMembershipFeeCccyamt() {
        return maximumAnnualMembershipFeeCccyamt;
    }

    public void setMaximumAnnualMembershipFeeCccyamt(Cccyamt maximumAnnualMembershipFeeCccyamt) {
        this.maximumAnnualMembershipFeeCccyamt = maximumAnnualMembershipFeeCccyamt;
    }

    public Cccyamt getAdditionalCardAnnualMembershipFeeCccyamt() {
        return additionalCardAnnualMembershipFeeCccyamt;
    }

    public void setAdditionalCardAnnualMembershipFeeCccyamt(Cccyamt additionalCardAnnualMembershipFeeCccyamt) {
        this.additionalCardAnnualMembershipFeeCccyamt = additionalCardAnnualMembershipFeeCccyamt;
    }

    public Integer getNumberOfFreeChargeCardsCnt() {
        return numberOfFreeChargeCardsCnt;
    }

    public void setNumberOfFreeChargeCardsCnt(Integer numberOfFreeChargeCardsCnt) {
        this.numberOfFreeChargeCardsCnt = numberOfFreeChargeCardsCnt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MembershipSingleFee.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("annualMembershipFeeCccyamt");
        sb.append('=');
        sb.append(((this.annualMembershipFeeCccyamt == null)?"<null>":this.annualMembershipFeeCccyamt));
        sb.append(',');
        sb.append("maximumAnnualMembershipFeeCccyamt");
        sb.append('=');
        sb.append(((this.maximumAnnualMembershipFeeCccyamt == null)?"<null>":this.maximumAnnualMembershipFeeCccyamt));
        sb.append(',');
        sb.append("additionalCardAnnualMembershipFeeCccyamt");
        sb.append('=');
        sb.append(((this.additionalCardAnnualMembershipFeeCccyamt == null)?"<null>":this.additionalCardAnnualMembershipFeeCccyamt));
        sb.append(',');
        sb.append("numberOfFreeChargeCardsCnt");
        sb.append('=');
        sb.append(((this.numberOfFreeChargeCardsCnt == null)?"<null>":this.numberOfFreeChargeCardsCnt));
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
        result = ((result* 31)+((this.additionalCardAnnualMembershipFeeCccyamt == null)? 0 :this.additionalCardAnnualMembershipFeeCccyamt.hashCode()));
        result = ((result* 31)+((this.maximumAnnualMembershipFeeCccyamt == null)? 0 :this.maximumAnnualMembershipFeeCccyamt.hashCode()));
        result = ((result* 31)+((this.annualMembershipFeeCccyamt == null)? 0 :this.annualMembershipFeeCccyamt.hashCode()));
        result = ((result* 31)+((this.numberOfFreeChargeCardsCnt == null)? 0 :this.numberOfFreeChargeCardsCnt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MembershipSingleFee) == false) {
            return false;
        }
        MembershipSingleFee rhs = ((MembershipSingleFee) other);
        return (((((this.additionalCardAnnualMembershipFeeCccyamt == rhs.additionalCardAnnualMembershipFeeCccyamt)||((this.additionalCardAnnualMembershipFeeCccyamt!= null)&&this.additionalCardAnnualMembershipFeeCccyamt.equals(rhs.additionalCardAnnualMembershipFeeCccyamt)))&&((this.maximumAnnualMembershipFeeCccyamt == rhs.maximumAnnualMembershipFeeCccyamt)||((this.maximumAnnualMembershipFeeCccyamt!= null)&&this.maximumAnnualMembershipFeeCccyamt.equals(rhs.maximumAnnualMembershipFeeCccyamt))))&&((this.annualMembershipFeeCccyamt == rhs.annualMembershipFeeCccyamt)||((this.annualMembershipFeeCccyamt!= null)&&this.annualMembershipFeeCccyamt.equals(rhs.annualMembershipFeeCccyamt))))&&((this.numberOfFreeChargeCardsCnt == rhs.numberOfFreeChargeCardsCnt)||((this.numberOfFreeChargeCardsCnt!= null)&&this.numberOfFreeChargeCardsCnt.equals(rhs.numberOfFreeChargeCardsCnt))));
    }

}
