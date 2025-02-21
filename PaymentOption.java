package com.td.api.mbcca.response.account;

import com.td.api.mbcca.shared.Cccyamt;

public class PaymentOption {

    private Cccyamt instalmentFeeCccyamt;
    private InstalmentFeeAssessmentFrequencyCd instalmentFeeAssessmentFrequencyCd;

    public Cccyamt getInstalmentFeeCccyamt() {
        return instalmentFeeCccyamt;
    }

    public void setInstalmentFeeCccyamt(Cccyamt instalmentFeeCccyamt) {
        this.instalmentFeeCccyamt = instalmentFeeCccyamt;
    }

    public InstalmentFeeAssessmentFrequencyCd getInstalmentFeeAssessmentFrequencyCd() {
        return instalmentFeeAssessmentFrequencyCd;
    }

    public void setInstalmentFeeAssessmentFrequencyCd(InstalmentFeeAssessmentFrequencyCd instalmentFeeAssessmentFrequencyCd) {
        this.instalmentFeeAssessmentFrequencyCd = instalmentFeeAssessmentFrequencyCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PaymentOption.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("instalmentFeeCccyamt");
        sb.append('=');
        sb.append(((this.instalmentFeeCccyamt == null)?"<null>":this.instalmentFeeCccyamt));
        sb.append(',');
        sb.append("instalmentFeeAssessmentFrequencyCd");
        sb.append('=');
        sb.append(((this.instalmentFeeAssessmentFrequencyCd == null)?"<null>":this.instalmentFeeAssessmentFrequencyCd));
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
        result = ((result* 31)+((this.instalmentFeeAssessmentFrequencyCd == null)? 0 :this.instalmentFeeAssessmentFrequencyCd.hashCode()));
        result = ((result* 31)+((this.instalmentFeeCccyamt == null)? 0 :this.instalmentFeeCccyamt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PaymentOption) == false) {
            return false;
        }
        PaymentOption rhs = ((PaymentOption) other);
        return (((this.instalmentFeeAssessmentFrequencyCd == rhs.instalmentFeeAssessmentFrequencyCd)||((this.instalmentFeeAssessmentFrequencyCd!= null)&&this.instalmentFeeAssessmentFrequencyCd.equals(rhs.instalmentFeeAssessmentFrequencyCd)))&&((this.instalmentFeeCccyamt == rhs.instalmentFeeCccyamt)||((this.instalmentFeeCccyamt!= null)&&this.instalmentFeeCccyamt.equals(rhs.instalmentFeeCccyamt))));
    }

}
