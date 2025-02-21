package com.td.api.mbcca.response.account;

import com.td.api.mbcca.shared.Cccyamt;

public class BillingInfo {

    private Double aprRate;
    private String aprTimePeriodCd;
    private Double periodicRate;
    private Cccyamt balanceCccyamt;
    private Cccyamt financeChargeCccyamt;

    public Double getAprRate() {
        return aprRate;
    }

    public void setAprRate(Double aprRate) {
        this.aprRate = aprRate;
    }

    public String getAprTimePeriodCd() {
        return aprTimePeriodCd;
    }

    public void setAprTimePeriodCd(String aprTimePeriodCd) {
        this.aprTimePeriodCd = aprTimePeriodCd;
    }

    public Double getPeriodicRate() {
        return periodicRate;
    }

    public void setPeriodicRate(Double periodicRate) {
        this.periodicRate = periodicRate;
    }

    public Cccyamt getBalanceCccyamt() {
        return balanceCccyamt;
    }

    public void setBalanceCccyamt(Cccyamt balanceCccyamt) {
        this.balanceCccyamt = balanceCccyamt;
    }

    public Cccyamt getFinanceChargeCccyamt() {
        return financeChargeCccyamt;
    }

    public void setFinanceChargeCccyamt(Cccyamt financeChargeCccyamt) {
        this.financeChargeCccyamt = financeChargeCccyamt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BillingInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("aprRate");
        sb.append('=');
        sb.append(((this.aprRate == null)?"<null>":this.aprRate));
        sb.append(',');
        sb.append("aprTimePeriodCd");
        sb.append('=');
        sb.append(((this.aprTimePeriodCd == null)?"<null>":this.aprTimePeriodCd));
        sb.append(',');
        sb.append("periodicRate");
        sb.append('=');
        sb.append(((this.periodicRate == null)?"<null>":this.periodicRate));
        sb.append(',');
        sb.append("balanceCccyamt");
        sb.append('=');
        sb.append(((this.balanceCccyamt == null)?"<null>":this.balanceCccyamt));
        sb.append(',');
        sb.append("financeChargeCccyamt");
        sb.append('=');
        sb.append(((this.financeChargeCccyamt == null)?"<null>":this.financeChargeCccyamt));
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
        result = ((result* 31)+((this.balanceCccyamt == null)? 0 :this.balanceCccyamt.hashCode()));
        result = ((result* 31)+((this.aprTimePeriodCd == null)? 0 :this.aprTimePeriodCd.hashCode()));
        result = ((result* 31)+((this.periodicRate == null)? 0 :this.periodicRate.hashCode()));
        result = ((result* 31)+((this.aprRate == null)? 0 :this.aprRate.hashCode()));
        result = ((result* 31)+((this.financeChargeCccyamt == null)? 0 :this.financeChargeCccyamt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BillingInfo) == false) {
            return false;
        }
        BillingInfo rhs = ((BillingInfo) other);
        return ((((((this.balanceCccyamt == rhs.balanceCccyamt)||((this.balanceCccyamt!= null)&&this.balanceCccyamt.equals(rhs.balanceCccyamt)))&&((this.aprTimePeriodCd == rhs.aprTimePeriodCd)||((this.aprTimePeriodCd!= null)&&this.aprTimePeriodCd.equals(rhs.aprTimePeriodCd))))&&((this.periodicRate == rhs.periodicRate)||((this.periodicRate!= null)&&this.periodicRate.equals(rhs.periodicRate))))&&((this.aprRate == rhs.aprRate)||((this.aprRate!= null)&&this.aprRate.equals(rhs.aprRate))))&&((this.financeChargeCccyamt == rhs.financeChargeCccyamt)||((this.financeChargeCccyamt!= null)&&this.financeChargeCccyamt.equals(rhs.financeChargeCccyamt))));
    }

}
