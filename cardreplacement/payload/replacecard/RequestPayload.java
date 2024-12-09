package com.td.mbna.msec.midtier.cardreplacement.payload.replacecard;

import com.td.mbna.msec.midtier.types.common.EmailNotificationInfoType;
import com.td.mbna.msec.midtier.types.common.UnformattedAddress;

public class RequestPayload {

    private String aliasCustID;
    private String requestedAccountHolderName;
    private String reasonForRequest;
    private Boolean confirmed;
    private EmailNotificationInfoType emailNotificationInfo;
    private UnformattedAddress address;
    private String cardNumber;
    private String partyKey;

    public String getAliasCustID() {
        return aliasCustID;
    }

    public void setAliasCustID(String aliasCustID) {
        this.aliasCustID = aliasCustID;
    }

    public String getRequestedAccountHolderName() {
        return requestedAccountHolderName;
    }

    public void setRequestedAccountHolderName(String requestedAccountHolderName) {
        this.requestedAccountHolderName = requestedAccountHolderName;
    }

    public String getReasonForRequest() {
        return reasonForRequest;
    }

    public void setReasonForRequest(String reasonForRequest) {
        this.reasonForRequest = reasonForRequest;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public EmailNotificationInfoType getEmailNotificationInfo() {
        return emailNotificationInfo;
    }

    public void setEmailNotificationInfo(EmailNotificationInfoType emailNotificationInfo) {
        this.emailNotificationInfo = emailNotificationInfo;
    }

    public UnformattedAddress getAddress() {
        return address;
    }

    public void setAddress(UnformattedAddress address) {
        this.address = address;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
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
        sb.append("aliasCustID");
        sb.append('=');
        sb.append(((this.aliasCustID == null)?"<null>":this.aliasCustID));
        sb.append(',');
        sb.append("requestedAccountHolderName");
        sb.append('=');
        sb.append(((this.requestedAccountHolderName == null)?"<null>":this.requestedAccountHolderName));
        sb.append(',');
        sb.append("reasonForRequest");
        sb.append('=');
        sb.append(((this.reasonForRequest == null)?"<null>":this.reasonForRequest));
        sb.append(',');
        sb.append("confirmed");
        sb.append('=');
        sb.append(((this.confirmed == null)?"<null>":this.confirmed));
        sb.append(',');
        sb.append("emailNotificationInfo");
        sb.append('=');
        sb.append(((this.emailNotificationInfo == null)?"<null>":this.emailNotificationInfo));
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        sb.append("cardNumber");
        sb.append('=');
        sb.append(((this.cardNumber == null)?"<null>":this.cardNumber));
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
        result = ((result* 31)+((this.aliasCustID == null)? 0 :this.aliasCustID.hashCode()));
        result = ((result* 31)+((this.address == null)? 0 :this.address.hashCode()));
        result = ((result* 31)+((this.requestedAccountHolderName == null)? 0 :this.requestedAccountHolderName.hashCode()));
        result = ((result* 31)+((this.emailNotificationInfo == null)? 0 :this.emailNotificationInfo.hashCode()));
        result = ((result* 31)+((this.confirmed == null)? 0 :this.confirmed.hashCode()));
        result = ((result* 31)+((this.reasonForRequest == null)? 0 :this.reasonForRequest.hashCode()));
        result = ((result* 31)+((this.cardNumber == null)? 0 :this.cardNumber.hashCode()));
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
        return (((((((this.aliasCustID == rhs.aliasCustID)||((this.aliasCustID!= null)&&this.aliasCustID.equals(rhs.aliasCustID)))&&((this.address == rhs.address)||((this.address!= null)&&this.address.equals(rhs.address))))&&((this.requestedAccountHolderName == rhs.requestedAccountHolderName)||((this.requestedAccountHolderName!= null)&&this.requestedAccountHolderName.equals(rhs.requestedAccountHolderName))))&&((this.emailNotificationInfo == rhs.emailNotificationInfo)||((this.emailNotificationInfo!= null)&&this.emailNotificationInfo.equals(rhs.emailNotificationInfo))))&&((this.confirmed == rhs.confirmed)||((this.confirmed!= null)&&this.confirmed.equals(rhs.confirmed))))&&((this.reasonForRequest == rhs.reasonForRequest)||((this.reasonForRequest!= null)&&this.reasonForRequest.equals(rhs.reasonForRequest)&&this.cardNumber.equals(rhs.cardNumber))));
    }

}
