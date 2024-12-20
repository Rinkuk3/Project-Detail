package com.td.api.mbcca.response.account;

import com.td.api.mbcca.shared.Cccyamt;

public class FinancialChargeInfo {

    private Cccyamt purchaseChargeCccyamt;
    private Cccyamt cashAdvanceChargeCccyamt;
    private Cccyamt otherChargeCccyamt;

    public Cccyamt getPurchaseChargeCccyamt() {
        return purchaseChargeCccyamt;
    }

    public void setPurchaseChargeCccyamt(Cccyamt purchaseChargeCccyamt) {
        this.purchaseChargeCccyamt = purchaseChargeCccyamt;
    }

    public Cccyamt getCashAdvanceChargeCccyamt() {
        return cashAdvanceChargeCccyamt;
    }

    public void setCashAdvanceChargeCccyamt(Cccyamt cashAdvanceChargeCccyamt) {
        this.cashAdvanceChargeCccyamt = cashAdvanceChargeCccyamt;
    }

    public Cccyamt getOtherChargeCccyamt() {
        return otherChargeCccyamt;
    }

    public void setOtherChargeCccyamt(Cccyamt otherChargeCccyamt) {
        this.otherChargeCccyamt = otherChargeCccyamt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FinancialChargeInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("purchaseChargeCccyamt");
        sb.append('=');
        sb.append(((this.purchaseChargeCccyamt == null)?"<null>":this.purchaseChargeCccyamt));
        sb.append(',');
        sb.append("cashAdvanceChargeCccyamt");
        sb.append('=');
        sb.append(((this.cashAdvanceChargeCccyamt == null)?"<null>":this.cashAdvanceChargeCccyamt));
        sb.append(',');
        sb.append("otherChargeCccyamt");
        sb.append('=');
        sb.append(((this.otherChargeCccyamt == null)?"<null>":this.otherChargeCccyamt));
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
        result = ((result* 31)+((this.otherChargeCccyamt == null)? 0 :this.otherChargeCccyamt.hashCode()));
        result = ((result* 31)+((this.cashAdvanceChargeCccyamt == null)? 0 :this.cashAdvanceChargeCccyamt.hashCode()));
        result = ((result* 31)+((this.purchaseChargeCccyamt == null)? 0 :this.purchaseChargeCccyamt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FinancialChargeInfo) == false) {
            return false;
        }
        FinancialChargeInfo rhs = ((FinancialChargeInfo) other);
        return ((((this.otherChargeCccyamt == rhs.otherChargeCccyamt)||((this.otherChargeCccyamt!= null)&&this.otherChargeCccyamt.equals(rhs.otherChargeCccyamt)))&&((this.cashAdvanceChargeCccyamt == rhs.cashAdvanceChargeCccyamt)||((this.cashAdvanceChargeCccyamt!= null)&&this.cashAdvanceChargeCccyamt.equals(rhs.cashAdvanceChargeCccyamt))))&&((this.purchaseChargeCccyamt == rhs.purchaseChargeCccyamt)||((this.purchaseChargeCccyamt!= null)&&this.purchaseChargeCccyamt.equals(rhs.purchaseChargeCccyamt))));
    }

}
