package com.td.api.mbcca.response.account;

import com.td.api.mbcca.shared.Cccyamt;

public class PastDueInfo {

    private String categoryCd;
    private Cccyamt cccyamt;
    private Integer timesCnt;

    public String getCategoryCd() {
        return categoryCd;
    }

    public void setCategoryCd(String categoryCd) {
        this.categoryCd = categoryCd;
    }

    public Cccyamt getCccyamt() {
        return cccyamt;
    }

    public void setCccyamt(Cccyamt cccyamt) {
        this.cccyamt = cccyamt;
    }

    public Integer getTimesCnt() {
        return timesCnt;
    }

    public void setTimesCnt(Integer timesCnt) {
        this.timesCnt = timesCnt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PastDueInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("categoryCd");
        sb.append('=');
        sb.append(((this.categoryCd == null)?"<null>":this.categoryCd));
        sb.append(',');
        sb.append("cccyamt");
        sb.append('=');
        sb.append(((this.cccyamt == null)?"<null>":this.cccyamt));
        sb.append(',');
        sb.append("timesCnt");
        sb.append('=');
        sb.append(((this.timesCnt == null)?"<null>":this.timesCnt));
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
        result = ((result* 31)+((this.categoryCd == null)? 0 :this.categoryCd.hashCode()));
        result = ((result* 31)+((this.timesCnt == null)? 0 :this.timesCnt.hashCode()));
        result = ((result* 31)+((this.cccyamt == null)? 0 :this.cccyamt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PastDueInfo) == false) {
            return false;
        }
        PastDueInfo rhs = ((PastDueInfo) other);
        return ((((this.categoryCd == rhs.categoryCd)||((this.categoryCd!= null)&&this.categoryCd.equals(rhs.categoryCd)))&&((this.timesCnt == rhs.timesCnt)||((this.timesCnt!= null)&&this.timesCnt.equals(rhs.timesCnt))))&&((this.cccyamt == rhs.cccyamt)||((this.cccyamt!= null)&&this.cccyamt.equals(rhs.cccyamt))));
    }

}
