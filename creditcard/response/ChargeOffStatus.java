package com.td.api.mbcca.creditcard.response;

public class ChargeOffStatus {

    private String statusCd;
    private String operatorPartyId;
    private String changeTypeCd;

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public String getOperatorPartyId() {
        return operatorPartyId;
    }

    public void setOperatorPartyId(String operatorPartyId) {
        this.operatorPartyId = operatorPartyId;
    }

    public String getChangeTypeCd() {
        return changeTypeCd;
    }

    public void setChangeTypeCd(String changeTypeCd) {
        this.changeTypeCd = changeTypeCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChargeOffStatus.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("statusCd");
        sb.append('=');
        sb.append(((this.statusCd == null)?"<null>":this.statusCd));
        sb.append(',');
        sb.append("operatorPartyId");
        sb.append('=');
        sb.append(((this.operatorPartyId == null)?"<null>":this.operatorPartyId));
        sb.append(',');
        sb.append("changeTypeCd");
        sb.append('=');
        sb.append(((this.changeTypeCd == null)?"<null>":this.changeTypeCd));
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
        result = ((result* 31)+((this.changeTypeCd == null)? 0 :this.changeTypeCd.hashCode()));
        result = ((result* 31)+((this.statusCd == null)? 0 :this.statusCd.hashCode()));
        result = ((result* 31)+((this.operatorPartyId == null)? 0 :this.operatorPartyId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChargeOffStatus) == false) {
            return false;
        }
        ChargeOffStatus rhs = ((ChargeOffStatus) other);
        return ((((this.changeTypeCd == rhs.changeTypeCd)||((this.changeTypeCd!= null)&&this.changeTypeCd.equals(rhs.changeTypeCd)))&&((this.statusCd == rhs.statusCd)||((this.statusCd!= null)&&this.statusCd.equals(rhs.statusCd))))&&((this.operatorPartyId == rhs.operatorPartyId)||((this.operatorPartyId!= null)&&this.operatorPartyId.equals(rhs.operatorPartyId))));
    }

}
