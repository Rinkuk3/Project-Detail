package com.td.api.mbcca.response.account;

import com.td.api.mbcca.shared.Cccyamt;

public class DailyAuthorizationSummary {

    private String debitTypeCd;
    private Integer approvedCnt;
    private Cccyamt approvedCccyamt;
    private Cccyamt paymentCccyamt;

    public String getDebitTypeCd() {
        return debitTypeCd;
    }

    public void setDebitTypeCd(String debitTypeCd) {
        this.debitTypeCd = debitTypeCd;
    }

    public Integer getApprovedCnt() {
        return approvedCnt;
    }

    public void setApprovedCnt(Integer approvedCnt) {
        this.approvedCnt = approvedCnt;
    }

    public Cccyamt getApprovedCccyamt() {
        return approvedCccyamt;
    }

    public void setApprovedCccyamt(Cccyamt approvedCccyamt) {
        this.approvedCccyamt = approvedCccyamt;
    }

    public Cccyamt getPaymentCccyamt() {
        return paymentCccyamt;
    }

    public void setPaymentCccyamt(Cccyamt paymentCccyamt) {
        this.paymentCccyamt = paymentCccyamt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DailyAuthorizationSummary.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("debitTypeCd");
        sb.append('=');
        sb.append(((this.debitTypeCd == null)?"<null>":this.debitTypeCd));
        sb.append(',');
        sb.append("approvedCnt");
        sb.append('=');
        sb.append(((this.approvedCnt == null)?"<null>":this.approvedCnt));
        sb.append(',');
        sb.append("approvedCccyamt");
        sb.append('=');
        sb.append(((this.approvedCccyamt == null)?"<null>":this.approvedCccyamt));
        sb.append(',');
        sb.append("paymentCccyamt");
        sb.append('=');
        sb.append(((this.paymentCccyamt == null)?"<null>":this.paymentCccyamt));
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
        result = ((result* 31)+((this.debitTypeCd == null)? 0 :this.debitTypeCd.hashCode()));
        result = ((result* 31)+((this.approvedCccyamt == null)? 0 :this.approvedCccyamt.hashCode()));
        result = ((result* 31)+((this.approvedCnt == null)? 0 :this.approvedCnt.hashCode()));
        result = ((result* 31)+((this.paymentCccyamt == null)? 0 :this.paymentCccyamt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DailyAuthorizationSummary) == false) {
            return false;
        }
        DailyAuthorizationSummary rhs = ((DailyAuthorizationSummary) other);
        return (((((this.debitTypeCd == rhs.debitTypeCd)||((this.debitTypeCd!= null)&&this.debitTypeCd.equals(rhs.debitTypeCd)))&&((this.approvedCccyamt == rhs.approvedCccyamt)||((this.approvedCccyamt!= null)&&this.approvedCccyamt.equals(rhs.approvedCccyamt))))&&((this.approvedCnt == rhs.approvedCnt)||((this.approvedCnt!= null)&&this.approvedCnt.equals(rhs.approvedCnt))))&&((this.paymentCccyamt == rhs.paymentCccyamt)||((this.paymentCccyamt!= null)&&this.paymentCccyamt.equals(rhs.paymentCccyamt))));
    }

}
