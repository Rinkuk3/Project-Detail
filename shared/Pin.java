package com.td.api.mbcca.shared;

public class Pin {

    private String lastRequestDt;
    private String lastIssueDt;
    private String lastRequestReasonCd;
    private String lastRequestOperatorPartyId;
    private String requestStatusCd;
    private String partyIdentificationNum;

    public String getLastRequestDt() {
        return lastRequestDt;
    }

    public void setLastRequestDt(String lastRequestDt) {
        this.lastRequestDt = lastRequestDt;
    }

    public String getLastIssueDt() {
        return lastIssueDt;
    }

    public void setLastIssueDt(String lastIssueDt) {
        this.lastIssueDt = lastIssueDt;
    }

    public String getLastRequestReasonCd() {
        return lastRequestReasonCd;
    }

    public void setLastRequestReasonCd(String lastRequestReasonCd) {
        this.lastRequestReasonCd = lastRequestReasonCd;
    }

    public String getLastRequestOperatorPartyId() {
        return lastRequestOperatorPartyId;
    }

    public void setLastRequestOperatorPartyId(String lastRequestOperatorPartyId) {
        this.lastRequestOperatorPartyId = lastRequestOperatorPartyId;
    }

    public String getRequestStatusCd() {
        return requestStatusCd;
    }

    public void setRequestStatusCd(String requestStatusCd) {
        this.requestStatusCd = requestStatusCd;
    }

    public String getPartyIdentificationNum() {
        return partyIdentificationNum;
    }

    public void setPartyIdentificationNum(String partyIdentificationNum) {
        this.partyIdentificationNum = partyIdentificationNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Pin.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("lastRequestDt");
        sb.append('=');
        sb.append(((this.lastRequestDt == null)?"<null>":this.lastRequestDt));
        sb.append(',');
        sb.append("lastIssueDt");
        sb.append('=');
        sb.append(((this.lastIssueDt == null)?"<null>":this.lastIssueDt));
        sb.append(',');
        sb.append("lastRequestReasonCd");
        sb.append('=');
        sb.append(((this.lastRequestReasonCd == null)?"<null>":this.lastRequestReasonCd));
        sb.append(',');
        sb.append("lastRequestOperatorPartyId");
        sb.append('=');
        sb.append(((this.lastRequestOperatorPartyId == null)?"<null>":this.lastRequestOperatorPartyId));
        sb.append(',');
        sb.append("requestStatusCd");
        sb.append('=');
        sb.append(((this.requestStatusCd == null)?"<null>":this.requestStatusCd));
        sb.append(',');
        sb.append("partyIdentificationNum");
        sb.append('=');
        sb.append(((this.partyIdentificationNum == null)?"<null>":this.partyIdentificationNum));
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
        result = ((result* 31)+((this.lastRequestDt == null)? 0 :this.lastRequestDt.hashCode()));
        result = ((result* 31)+((this.lastRequestReasonCd == null)? 0 :this.lastRequestReasonCd.hashCode()));
        result = ((result* 31)+((this.lastIssueDt == null)? 0 :this.lastIssueDt.hashCode()));
        result = ((result* 31)+((this.requestStatusCd == null)? 0 :this.requestStatusCd.hashCode()));
        result = ((result* 31)+((this.lastRequestOperatorPartyId == null)? 0 :this.lastRequestOperatorPartyId.hashCode()));
        result = ((result* 31)+((this.partyIdentificationNum == null)? 0 :this.partyIdentificationNum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Pin) == false) {
            return false;
        }
        Pin rhs = ((Pin) other);
        return (((((((this.lastRequestDt == rhs.lastRequestDt)||((this.lastRequestDt!= null)&&this.lastRequestDt.equals(rhs.lastRequestDt)))&&((this.lastRequestReasonCd == rhs.lastRequestReasonCd)||((this.lastRequestReasonCd!= null)&&this.lastRequestReasonCd.equals(rhs.lastRequestReasonCd))))&&((this.lastIssueDt == rhs.lastIssueDt)||((this.lastIssueDt!= null)&&this.lastIssueDt.equals(rhs.lastIssueDt))))&&((this.requestStatusCd == rhs.requestStatusCd)||((this.requestStatusCd!= null)&&this.requestStatusCd.equals(rhs.requestStatusCd))))&&((this.lastRequestOperatorPartyId == rhs.lastRequestOperatorPartyId)||((this.lastRequestOperatorPartyId!= null)&&this.lastRequestOperatorPartyId.equals(rhs.lastRequestOperatorPartyId))))&&((this.partyIdentificationNum == rhs.partyIdentificationNum)||((this.partyIdentificationNum!= null)&&this.partyIdentificationNum.equals(rhs.partyIdentificationNum))));
    }

}
