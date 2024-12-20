package com.td.api.mbcca.response.account.featureview;

public class ForeignExchangeFee {

    private Boolean waiveInd;
    private Boolean permanentWaiveInd;
    private Integer cycleToWaiveCnt;
    private String lastUpdateDt;

    public Boolean getWaiveInd() {
        return waiveInd;
    }

    public void setWaiveInd(Boolean waiveInd) {
        this.waiveInd = waiveInd;
    }

    public Boolean getPermanentWaiveInd() {
        return permanentWaiveInd;
    }

    public void setPermanentWaiveInd(Boolean permanentWaiveInd) {
        this.permanentWaiveInd = permanentWaiveInd;
    }

    public Integer getCycleToWaiveCnt() {
        return cycleToWaiveCnt;
    }

    public void setCycleToWaiveCnt(Integer cycleToWaiveCnt) {
        this.cycleToWaiveCnt = cycleToWaiveCnt;
    }

    public String getLastUpdateDt() {
        return lastUpdateDt;
    }

    public void setLastUpdateDt(String lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ForeignExchangeFee.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("waiveInd");
        sb.append('=');
        sb.append(((this.waiveInd == null)?"<null>":this.waiveInd));
        sb.append(',');
        sb.append("permanentWaiveInd");
        sb.append('=');
        sb.append(((this.permanentWaiveInd == null)?"<null>":this.permanentWaiveInd));
        sb.append(',');
        sb.append("cycleToWaiveCnt");
        sb.append('=');
        sb.append(((this.cycleToWaiveCnt == null)?"<null>":this.cycleToWaiveCnt));
        sb.append(',');
        sb.append("lastUpdateDt");
        sb.append('=');
        sb.append(((this.lastUpdateDt == null)?"<null>":this.lastUpdateDt));
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
        result = ((result* 31)+((this.waiveInd == null)? 0 :this.waiveInd.hashCode()));
        result = ((result* 31)+((this.permanentWaiveInd == null)? 0 :this.permanentWaiveInd.hashCode()));
        result = ((result* 31)+((this.cycleToWaiveCnt == null)? 0 :this.cycleToWaiveCnt.hashCode()));
        result = ((result* 31)+((this.lastUpdateDt == null)? 0 :this.lastUpdateDt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ForeignExchangeFee) == false) {
            return false;
        }
        ForeignExchangeFee rhs = ((ForeignExchangeFee) other);
        return (((((this.waiveInd == rhs.waiveInd)||((this.waiveInd!= null)&&this.waiveInd.equals(rhs.waiveInd)))&&((this.permanentWaiveInd == rhs.permanentWaiveInd)||((this.permanentWaiveInd!= null)&&this.permanentWaiveInd.equals(rhs.permanentWaiveInd))))&&((this.cycleToWaiveCnt == rhs.cycleToWaiveCnt)||((this.cycleToWaiveCnt!= null)&&this.cycleToWaiveCnt.equals(rhs.cycleToWaiveCnt))))&&((this.lastUpdateDt == rhs.lastUpdateDt)||((this.lastUpdateDt!= null)&&this.lastUpdateDt.equals(rhs.lastUpdateDt))));
    }

}
