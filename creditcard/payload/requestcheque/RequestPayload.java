package com.td.mbna.msec.midtier.creditcard.payload.requestcheque;

import com.td.mbna.msec.midtier.types.common.EmailNotificationInfoType;
import com.td.mbna.msec.midtier.types.common.SimpleAddress;

public class RequestPayload {

    private String custId;
    private String acctId;
    private Boolean emailRequired;
    private EmailNotificationInfoType emailNotificationInfo;
    private SimpleAddress mailingAddress;

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

    public Boolean getEmailRequired() {
        return emailRequired;
    }

    public void setEmailRequired(Boolean emailRequired) {
        this.emailRequired = emailRequired;
    }

    public EmailNotificationInfoType getEmailNotificationInfo() {
        return emailNotificationInfo;
    }

    public void setEmailNotificationInfo(EmailNotificationInfoType emailNotificationInfo) {
        this.emailNotificationInfo = emailNotificationInfo;
    }

    public SimpleAddress getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(SimpleAddress mailingAddress) {
        this.mailingAddress = mailingAddress;
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
        sb.append("emailRequired");
        sb.append('=');
        sb.append(((this.emailRequired == null)?"<null>":this.emailRequired));
        sb.append(',');
        sb.append("emailNotificationInfo");
        sb.append('=');
        sb.append(((this.emailNotificationInfo == null)?"<null>":this.emailNotificationInfo));
        sb.append(',');
        sb.append("mailingAddress");
        sb.append('=');
        sb.append(((this.mailingAddress == null)?"<null>":this.mailingAddress));
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
        result = ((result* 31)+((this.emailRequired == null)? 0 :this.emailRequired.hashCode()));
        result = ((result* 31)+((this.mailingAddress == null)? 0 :this.mailingAddress.hashCode()));
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
        return ((((((this.custId == rhs.custId)||((this.custId!= null)&&this.custId.equals(rhs.custId)))&&((this.acctId == rhs.acctId)||((this.acctId!= null)&&this.acctId.equals(rhs.acctId))))&&((this.emailNotificationInfo == rhs.emailNotificationInfo)||((this.emailNotificationInfo!= null)&&this.emailNotificationInfo.equals(rhs.emailNotificationInfo))))&&((this.emailRequired == rhs.emailRequired)||((this.emailRequired!= null)&&this.emailRequired.equals(rhs.emailRequired))))&&((this.mailingAddress == rhs.mailingAddress)||((this.mailingAddress!= null)&&this.mailingAddress.equals(rhs.mailingAddress))));
    }

}
