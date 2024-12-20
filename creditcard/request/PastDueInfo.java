package com.td.api.mbcca.creditcard.request;

public class PastDueInfo {

    private String cycleYm;
    private String pastDue84CycleDelinquencyLevelCd;
    private String pastDue12CycleDelinquencyLevelCd;
    private Boolean pastDue12CycleOverLimitFeeInd;
    private Boolean pastDue12CycleLateFeeInd;

    public String getCycleYm() {
        return cycleYm;
    }

    public void setCycleYm(String cycleYm) {
        this.cycleYm = cycleYm;
    }

    public String getPastDue84CycleDelinquencyLevelCd() {
        return pastDue84CycleDelinquencyLevelCd;
    }

    public void setPastDue84CycleDelinquencyLevelCd(String pastDue84CycleDelinquencyLevelCd) {
        this.pastDue84CycleDelinquencyLevelCd = pastDue84CycleDelinquencyLevelCd;
    }

    public String getPastDue12CycleDelinquencyLevelCd() {
        return pastDue12CycleDelinquencyLevelCd;
    }

    public void setPastDue12CycleDelinquencyLevelCd(String pastDue12CycleDelinquencyLevelCd) {
        this.pastDue12CycleDelinquencyLevelCd = pastDue12CycleDelinquencyLevelCd;
    }

    public Boolean getPastDue12CycleOverLimitFeeInd() {
        return pastDue12CycleOverLimitFeeInd;
    }

    public void setPastDue12CycleOverLimitFeeInd(Boolean pastDue12CycleOverLimitFeeInd) {
        this.pastDue12CycleOverLimitFeeInd = pastDue12CycleOverLimitFeeInd;
    }

    public Boolean getPastDue12CycleLateFeeInd() {
        return pastDue12CycleLateFeeInd;
    }

    public void setPastDue12CycleLateFeeInd(Boolean pastDue12CycleLateFeeInd) {
        this.pastDue12CycleLateFeeInd = pastDue12CycleLateFeeInd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PastDueInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cycleYm");
        sb.append('=');
        sb.append(((this.cycleYm == null)?"<null>":this.cycleYm));
        sb.append(',');
        sb.append("pastDue84CycleDelinquencyLevelCd");
        sb.append('=');
        sb.append(((this.pastDue84CycleDelinquencyLevelCd == null)?"<null>":this.pastDue84CycleDelinquencyLevelCd));
        sb.append(',');
        sb.append("pastDue12CycleDelinquencyLevelCd");
        sb.append('=');
        sb.append(((this.pastDue12CycleDelinquencyLevelCd == null)?"<null>":this.pastDue12CycleDelinquencyLevelCd));
        sb.append(',');
        sb.append("pastDue12CycleOverLimitFeeInd");
        sb.append('=');
        sb.append(((this.pastDue12CycleOverLimitFeeInd == null)?"<null>":this.pastDue12CycleOverLimitFeeInd));
        sb.append(',');
        sb.append("pastDue12CycleLateFeeInd");
        sb.append('=');
        sb.append(((this.pastDue12CycleLateFeeInd == null)?"<null>":this.pastDue12CycleLateFeeInd));
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
        result = ((result* 31)+((this.pastDue12CycleLateFeeInd == null)? 0 :this.pastDue12CycleLateFeeInd.hashCode()));
        result = ((result* 31)+((this.pastDue12CycleDelinquencyLevelCd == null)? 0 :this.pastDue12CycleDelinquencyLevelCd.hashCode()));
        result = ((result* 31)+((this.cycleYm == null)? 0 :this.cycleYm.hashCode()));
        result = ((result* 31)+((this.pastDue84CycleDelinquencyLevelCd == null)? 0 :this.pastDue84CycleDelinquencyLevelCd.hashCode()));
        result = ((result* 31)+((this.pastDue12CycleOverLimitFeeInd == null)? 0 :this.pastDue12CycleOverLimitFeeInd.hashCode()));
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
        return ((((((this.pastDue12CycleLateFeeInd == rhs.pastDue12CycleLateFeeInd)||((this.pastDue12CycleLateFeeInd!= null)&&this.pastDue12CycleLateFeeInd.equals(rhs.pastDue12CycleLateFeeInd)))&&((this.pastDue12CycleDelinquencyLevelCd == rhs.pastDue12CycleDelinquencyLevelCd)||((this.pastDue12CycleDelinquencyLevelCd!= null)&&this.pastDue12CycleDelinquencyLevelCd.equals(rhs.pastDue12CycleDelinquencyLevelCd))))&&((this.cycleYm == rhs.cycleYm)||((this.cycleYm!= null)&&this.cycleYm.equals(rhs.cycleYm))))&&((this.pastDue84CycleDelinquencyLevelCd == rhs.pastDue84CycleDelinquencyLevelCd)||((this.pastDue84CycleDelinquencyLevelCd!= null)&&this.pastDue84CycleDelinquencyLevelCd.equals(rhs.pastDue84CycleDelinquencyLevelCd))))&&((this.pastDue12CycleOverLimitFeeInd == rhs.pastDue12CycleOverLimitFeeInd)||((this.pastDue12CycleOverLimitFeeInd!= null)&&this.pastDue12CycleOverLimitFeeInd.equals(rhs.pastDue12CycleOverLimitFeeInd))));
    }

}
