package com.td.api.mbofp.response.retrievecampaign;

public class TowTerm {

    private String untilAgeCd;
    private String untilAgeNum;
    private String fixedEndDt;

    public String getUntilAgeCd() {
        return untilAgeCd;
    }

    public void setUntilAgeCd(String untilAgeCd) {
        this.untilAgeCd = untilAgeCd;
    }

    public String getUntilAgeNum() {
        return untilAgeNum;
    }

    public void setUntilAgeNum(String untilAgeNum) {
        this.untilAgeNum = untilAgeNum;
    }

    public String getFixedEndDt() {
        return fixedEndDt;
    }

    public void setFixedEndDt(String fixedEndDt) {
        this.fixedEndDt = fixedEndDt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TowTerm.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("untilAgeCd");
        sb.append('=');
        sb.append(((this.untilAgeCd == null)?"<null>":this.untilAgeCd));
        sb.append(',');
        sb.append("untilAgeNum");
        sb.append('=');
        sb.append(((this.untilAgeNum == null)?"<null>":this.untilAgeNum));
        sb.append(',');
        sb.append("fixedEndDt");
        sb.append('=');
        sb.append(((this.fixedEndDt == null)?"<null>":this.fixedEndDt));
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
        result = ((result* 31)+((this.untilAgeCd == null)? 0 :this.untilAgeCd.hashCode()));
        result = ((result* 31)+((this.fixedEndDt == null)? 0 :this.fixedEndDt.hashCode()));
        result = ((result* 31)+((this.untilAgeNum == null)? 0 :this.untilAgeNum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TowTerm) == false) {
            return false;
        }
        TowTerm rhs = ((TowTerm) other);
        return ((((this.untilAgeCd == rhs.untilAgeCd)||((this.untilAgeCd!= null)&&this.untilAgeCd.equals(rhs.untilAgeCd)))&&((this.fixedEndDt == rhs.fixedEndDt)||((this.fixedEndDt!= null)&&this.fixedEndDt.equals(rhs.fixedEndDt))))&&((this.untilAgeNum == rhs.untilAgeNum)||((this.untilAgeNum!= null)&&this.untilAgeNum.equals(rhs.untilAgeNum))));
    }

}
