package com.td.api.mbcca.response.account;

import java.util.ArrayList;
import java.util.List;

import com.td.api.mbcca.shared.Cccyamt;

public class TermBalance {

    private String termBalanceCd;
    private Cccyamt averageDailyBalanceCccyamt;
    private Cccyamt outstandingFinanceChargeCccyamt;
    private String financeChargeMethodTypeCd;
    private List<BillingInfo> billingInfo = new ArrayList<BillingInfo>();

    public String getTermBalanceCd() {
        return termBalanceCd;
    }

    public void setTermBalanceCd(String termBalanceCd) {
        this.termBalanceCd = termBalanceCd;
    }

    public Cccyamt getAverageDailyBalanceCccyamt() {
        return averageDailyBalanceCccyamt;
    }

    public void setAverageDailyBalanceCccyamt(Cccyamt averageDailyBalanceCccyamt) {
        this.averageDailyBalanceCccyamt = averageDailyBalanceCccyamt;
    }

    public Cccyamt getOutstandingFinanceChargeCccyamt() {
        return outstandingFinanceChargeCccyamt;
    }

    public void setOutstandingFinanceChargeCccyamt(Cccyamt outstandingFinanceChargeCccyamt) {
        this.outstandingFinanceChargeCccyamt = outstandingFinanceChargeCccyamt;
    }

    public String getFinanceChargeMethodTypeCd() {
        return financeChargeMethodTypeCd;
    }

    public void setFinanceChargeMethodTypeCd(String financeChargeMethodTypeCd) {
        this.financeChargeMethodTypeCd = financeChargeMethodTypeCd;
    }

    public List<BillingInfo> getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(List<BillingInfo> billingInfo) {
        this.billingInfo = billingInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TermBalance.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("termBalanceCd");
        sb.append('=');
        sb.append(((this.termBalanceCd == null)?"<null>":this.termBalanceCd));
        sb.append(',');
        sb.append("averageDailyBalanceCccyamt");
        sb.append('=');
        sb.append(((this.averageDailyBalanceCccyamt == null)?"<null>":this.averageDailyBalanceCccyamt));
        sb.append(',');
        sb.append("outstandingFinanceChargeCccyamt");
        sb.append('=');
        sb.append(((this.outstandingFinanceChargeCccyamt == null)?"<null>":this.outstandingFinanceChargeCccyamt));
        sb.append(',');
        sb.append("financeChargeMethodTypeCd");
        sb.append('=');
        sb.append(((this.financeChargeMethodTypeCd == null)?"<null>":this.financeChargeMethodTypeCd));
        sb.append(',');
        sb.append("billingInfo");
        sb.append('=');
        sb.append(((this.billingInfo == null)?"<null>":this.billingInfo));
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
        result = ((result* 31)+((this.financeChargeMethodTypeCd == null)? 0 :this.financeChargeMethodTypeCd.hashCode()));
        result = ((result* 31)+((this.billingInfo == null)? 0 :this.billingInfo.hashCode()));
        result = ((result* 31)+((this.averageDailyBalanceCccyamt == null)? 0 :this.averageDailyBalanceCccyamt.hashCode()));
        result = ((result* 31)+((this.outstandingFinanceChargeCccyamt == null)? 0 :this.outstandingFinanceChargeCccyamt.hashCode()));
        result = ((result* 31)+((this.termBalanceCd == null)? 0 :this.termBalanceCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TermBalance) == false) {
            return false;
        }
        TermBalance rhs = ((TermBalance) other);
        return ((((((this.financeChargeMethodTypeCd == rhs.financeChargeMethodTypeCd)||((this.financeChargeMethodTypeCd!= null)&&this.financeChargeMethodTypeCd.equals(rhs.financeChargeMethodTypeCd)))&&((this.billingInfo == rhs.billingInfo)||((this.billingInfo!= null)&&this.billingInfo.equals(rhs.billingInfo))))&&((this.averageDailyBalanceCccyamt == rhs.averageDailyBalanceCccyamt)||((this.averageDailyBalanceCccyamt!= null)&&this.averageDailyBalanceCccyamt.equals(rhs.averageDailyBalanceCccyamt))))&&((this.outstandingFinanceChargeCccyamt == rhs.outstandingFinanceChargeCccyamt)||((this.outstandingFinanceChargeCccyamt!= null)&&this.outstandingFinanceChargeCccyamt.equals(rhs.outstandingFinanceChargeCccyamt))))&&((this.termBalanceCd == rhs.termBalanceCd)||((this.termBalanceCd!= null)&&this.termBalanceCd.equals(rhs.termBalanceCd))));
    }

}
