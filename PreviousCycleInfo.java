package com.td.api.mbcca.response.account;

import com.td.api.mbcca.shared.Cccyamt;

public class PreviousCycleInfo {

    private Cccyamt billedFinanceChargeCccyamt;
    private Cccyamt appliedPaymentCccyamt;

    public Cccyamt getBilledFinanceChargeCccyamt() {
        return billedFinanceChargeCccyamt;
    }

    public void setBilledFinanceChargeCccyamt(Cccyamt billedFinanceChargeCccyamt) {
        this.billedFinanceChargeCccyamt = billedFinanceChargeCccyamt;
    }

    public Cccyamt getAppliedPaymentCccyamt() {
        return appliedPaymentCccyamt;
    }

    public void setAppliedPaymentCccyamt(Cccyamt appliedPaymentCccyamt) {
        this.appliedPaymentCccyamt = appliedPaymentCccyamt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PreviousCycleInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("billedFinanceChargeCccyamt");
        sb.append('=');
        sb.append(((this.billedFinanceChargeCccyamt == null)?"<null>":this.billedFinanceChargeCccyamt));
        sb.append(',');
        sb.append("appliedPaymentCccyamt");
        sb.append('=');
        sb.append(((this.appliedPaymentCccyamt == null)?"<null>":this.appliedPaymentCccyamt));
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
        result = ((result* 31)+((this.billedFinanceChargeCccyamt == null)? 0 :this.billedFinanceChargeCccyamt.hashCode()));
        result = ((result* 31)+((this.appliedPaymentCccyamt == null)? 0 :this.appliedPaymentCccyamt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PreviousCycleInfo) == false) {
            return false;
        }
        PreviousCycleInfo rhs = ((PreviousCycleInfo) other);
        return (((this.billedFinanceChargeCccyamt == rhs.billedFinanceChargeCccyamt)||((this.billedFinanceChargeCccyamt!= null)&&this.billedFinanceChargeCccyamt.equals(rhs.billedFinanceChargeCccyamt)))&&((this.appliedPaymentCccyamt == rhs.appliedPaymentCccyamt)||((this.appliedPaymentCccyamt!= null)&&this.appliedPaymentCccyamt.equals(rhs.appliedPaymentCccyamt))));
    }

}
