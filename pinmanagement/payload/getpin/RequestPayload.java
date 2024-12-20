package com.td.mbna.msec.midtier.pinmanagement.payload.getpin;

import com.td.mbna.msec.midtier.types.common.EmailNotificationInfoType;

public class RequestPayload {

    private String custId;
    private String acctId;
    private EmailNotificationInfoType emailNotificationInfo;
    private String zpkAlias;
    private String wtkAlias;
    private String partyKey;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public EmailNotificationInfoType getEmailNotificationInfo() {
        return emailNotificationInfo;
    }

    public void setEmailNotificationInfo(EmailNotificationInfoType emailNotificationInfo) {
        this.emailNotificationInfo = emailNotificationInfo;
    }

    public String getZpkAlias() {
        return zpkAlias;
    }

    public void setZpkAlias(String zpkAlias) {
        this.zpkAlias = zpkAlias;
    }

    public String getWtkAlias() {
        return wtkAlias;
    }

    public void setWtkAlias(String wtkAlias) {
        this.wtkAlias = wtkAlias;
    }

    public String getPartyKey() {
        return partyKey;
    }

    public void setPartyKey(String partyKey) {
        this.partyKey = partyKey;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("custId");
        sb.append('=');
        sb.append(((this.custId == null)?"<null>":this.custId));
        sb.append(',');
        sb.append("acctId");
        sb.append('=');
        sb.append(((this.acctId == null)?"<null>":this.acctId));
        sb.append(',');
        sb.append("emailNotificationInfo");
        sb.append('=');
        sb.append(((this.emailNotificationInfo == null)?"<null>":this.emailNotificationInfo));
        sb.append(',');
        sb.append("zpkAlias");
        sb.append('=');
        sb.append(((this.zpkAlias == null)?"<null>":this.zpkAlias));
        sb.append(',');
        sb.append("wtkAlias");
        sb.append('=');
        sb.append(((this.wtkAlias == null)?"<null>":this.wtkAlias));
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
        result = ((result* 31)+((this.custId == null)? 0 :this.custId.hashCode()));
        result = ((result* 31)+((this.acctId == null)? 0 :this.acctId.hashCode()));
        result = ((result* 31)+((this.emailNotificationInfo == null)? 0 :this.emailNotificationInfo.hashCode()));
        result = ((result* 31)+((this.wtkAlias == null)? 0 :this.wtkAlias.hashCode()));
        result = ((result* 31)+((this.zpkAlias == null)? 0 :this.zpkAlias.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestPayload) == false) {
            return false;
        }
        RequestPayload rhs = ((RequestPayload) other);
        return ((((((this.custId == rhs.custId)||((this.custId!= null)&&this.custId.equals(rhs.custId)))&&((this.acctId == rhs.acctId)||((this.acctId!= null)&&this.acctId.equals(rhs.acctId))))&&((this.emailNotificationInfo == rhs.emailNotificationInfo)||((this.emailNotificationInfo!= null)&&this.emailNotificationInfo.equals(rhs.emailNotificationInfo))))&&((this.wtkAlias == rhs.wtkAlias)||((this.wtkAlias!= null)&&this.wtkAlias.equals(rhs.wtkAlias))))&&((this.zpkAlias == rhs.zpkAlias)||((this.zpkAlias!= null)&&this.zpkAlias.equals(rhs.zpkAlias))));
    }

}
