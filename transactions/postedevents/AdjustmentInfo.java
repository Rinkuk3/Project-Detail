package com.td.api.mbcca.response.transactions.postedevents;

public class AdjustmentInfo {

    private String accountingFunctionCd;
    private String activityTypeCd;
    private String glMainAccountVal;
    private String eventTxt;

    public String getAccountingFunctionCd() {
        return accountingFunctionCd;
    }

    public void setAccountingFunctionCd(String accountingFunctionCd) {
        this.accountingFunctionCd = accountingFunctionCd;
    }

    public String getActivityTypeCd() {
        return activityTypeCd;
    }

    public void setActivityTypeCd(String activityTypeCd) {
        this.activityTypeCd = activityTypeCd;
    }

    public String getGlMainAccountVal() {
        return glMainAccountVal;
    }

    public void setGlMainAccountVal(String glMainAccountVal) {
        this.glMainAccountVal = glMainAccountVal;
    }

    public String getEventTxt() {
        return eventTxt;
    }

    public void setEventTxt(String eventTxt) {
        this.eventTxt = eventTxt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AdjustmentInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("accountingFunctionCd");
        sb.append('=');
        sb.append(((this.accountingFunctionCd == null)?"<null>":this.accountingFunctionCd));
        sb.append(',');
        sb.append("activityTypeCd");
        sb.append('=');
        sb.append(((this.activityTypeCd == null)?"<null>":this.activityTypeCd));
        sb.append(',');
        sb.append("glMainAccountVal");
        sb.append('=');
        sb.append(((this.glMainAccountVal == null)?"<null>":this.glMainAccountVal));
        sb.append(',');
        sb.append("eventTxt");
        sb.append('=');
        sb.append(((this.eventTxt == null)?"<null>":this.eventTxt));
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
        result = ((result* 31)+((this.activityTypeCd == null)? 0 :this.activityTypeCd.hashCode()));
        result = ((result* 31)+((this.accountingFunctionCd == null)? 0 :this.accountingFunctionCd.hashCode()));
        result = ((result* 31)+((this.eventTxt == null)? 0 :this.eventTxt.hashCode()));
        result = ((result* 31)+((this.glMainAccountVal == null)? 0 :this.glMainAccountVal.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AdjustmentInfo) == false) {
            return false;
        }
        AdjustmentInfo rhs = ((AdjustmentInfo) other);
        return (((((this.activityTypeCd == rhs.activityTypeCd)||((this.activityTypeCd!= null)&&this.activityTypeCd.equals(rhs.activityTypeCd)))&&((this.accountingFunctionCd == rhs.accountingFunctionCd)||((this.accountingFunctionCd!= null)&&this.accountingFunctionCd.equals(rhs.accountingFunctionCd))))&&((this.eventTxt == rhs.eventTxt)||((this.eventTxt!= null)&&this.eventTxt.equals(rhs.eventTxt))))&&((this.glMainAccountVal == rhs.glMainAccountVal)||((this.glMainAccountVal!= null)&&this.glMainAccountVal.equals(rhs.glMainAccountVal))));
    }

}
