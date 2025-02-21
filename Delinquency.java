package com.td.api.mbcca.response.account;

public class Delinquency {

    private String delinquencyLevelCd;
    private Integer delinquencyCnt;

    public String getDelinquencyLevelCd() {
        return delinquencyLevelCd;
    }

    public void setDelinquencyLevelCd(String delinquencyLevelCd) {
        this.delinquencyLevelCd = delinquencyLevelCd;
    }

    public Integer getDelinquencyCnt() {
        return delinquencyCnt;
    }

    public void setDelinquencyCnt(Integer delinquencyCnt) {
        this.delinquencyCnt = delinquencyCnt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Delinquency.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("delinquencyLevelCd");
        sb.append('=');
        sb.append(((this.delinquencyLevelCd == null)?"<null>":this.delinquencyLevelCd));
        sb.append(',');
        sb.append("delinquencyCnt");
        sb.append('=');
        sb.append(((this.delinquencyCnt == null)?"<null>":this.delinquencyCnt));
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
        result = ((result* 31)+((this.delinquencyCnt == null)? 0 :this.delinquencyCnt.hashCode()));
        result = ((result* 31)+((this.delinquencyLevelCd == null)? 0 :this.delinquencyLevelCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Delinquency) == false) {
            return false;
        }
        Delinquency rhs = ((Delinquency) other);
        return (((this.delinquencyCnt == rhs.delinquencyCnt)||((this.delinquencyCnt!= null)&&this.delinquencyCnt.equals(rhs.delinquencyCnt)))&&((this.delinquencyLevelCd == rhs.delinquencyLevelCd)||((this.delinquencyLevelCd!= null)&&this.delinquencyLevelCd.equals(rhs.delinquencyLevelCd))));
    }

}
