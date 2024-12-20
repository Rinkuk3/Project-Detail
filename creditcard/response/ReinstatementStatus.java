package com.td.api.mbcca.creditcard.response;

public class ReinstatementStatus {

    private String previousChargeOffReasonCd;
    private String reinstatedDt;

    public String getPreviousChargeOffReasonCd() {
        return previousChargeOffReasonCd;
    }

    public void setPreviousChargeOffReasonCd(String previousChargeOffReasonCd) {
        this.previousChargeOffReasonCd = previousChargeOffReasonCd;
    }

    public String getReinstatedDt() {
        return reinstatedDt;
    }

    public void setReinstatedDt(String reinstatedDt) {
        this.reinstatedDt = reinstatedDt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ReinstatementStatus.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("previousChargeOffReasonCd");
        sb.append('=');
        sb.append(((this.previousChargeOffReasonCd == null)?"<null>":this.previousChargeOffReasonCd));
        sb.append(',');
        sb.append("reinstatedDt");
        sb.append('=');
        sb.append(((this.reinstatedDt == null)?"<null>":this.reinstatedDt));
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
        result = ((result* 31)+((this.reinstatedDt == null)? 0 :this.reinstatedDt.hashCode()));
        result = ((result* 31)+((this.previousChargeOffReasonCd == null)? 0 :this.previousChargeOffReasonCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ReinstatementStatus) == false) {
            return false;
        }
        ReinstatementStatus rhs = ((ReinstatementStatus) other);
        return (((this.reinstatedDt == rhs.reinstatedDt)||((this.reinstatedDt!= null)&&this.reinstatedDt.equals(rhs.reinstatedDt)))&&((this.previousChargeOffReasonCd == rhs.previousChargeOffReasonCd)||((this.previousChargeOffReasonCd!= null)&&this.previousChargeOffReasonCd.equals(rhs.previousChargeOffReasonCd))));
    }

}
