package com.td.mbna.msec.midtier.cardservice.payload.eligibility;

import java.util.List;

public class ResponsePayload {

    private String cardNumber = "";
    private Boolean eligible = false;
    private String messageId = "";
    private List<AuthorizedUser> authorizedUsers;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Boolean getEligible() {
        return eligible;
    }

    public void setEligible(Boolean eligible) {
        this.eligible = eligible;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }


    public List<AuthorizedUser> getAuthorizedUsers() {
        return authorizedUsers;
    }

    public void setAuthorizedUsers(List<AuthorizedUser> authorizedUsers) {
        this.authorizedUsers = authorizedUsers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ResponsePayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cardNumber");
        sb.append('=');
        sb.append(((this.cardNumber == null)?"<null>":this.cardNumber));
        sb.append(',');
        sb.append("eligible");
        sb.append('=');
        sb.append(((this.eligible == null)?"<null>":this.eligible));
        sb.append(',');
        sb.append("messageId");
        sb.append('=');
        sb.append(((this.messageId == null)?"<null>":this.messageId));
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
        result = ((result* 31)+((this.messageId == null)? 0 :this.messageId.hashCode()));
        result = ((result* 31)+((this.cardNumber == null)? 0 :this.cardNumber.hashCode()));
        result = ((result* 31)+((this.eligible == null)? 0 :this.eligible.hashCode()));
        result = ((result* 31)+((this.authorizedUsers == null)? 0 :this.authorizedUsers.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResponsePayload) == false) {
            return false;
        }
        ResponsePayload rhs = ((ResponsePayload) other);
        return ((((this.messageId == rhs.messageId)||((this.messageId!= null)&&this.messageId.equals(rhs.messageId)))&&((this.cardNumber == rhs.cardNumber)||((this.cardNumber!= null)&&this.cardNumber.equals(rhs.cardNumber))))&&((this.eligible == rhs.eligible)||((this.eligible!= null)&&this.eligible.equals(rhs.eligible))) && ((this.authorizedUsers == rhs.authorizedUsers)||((this.authorizedUsers!= null)&&this.authorizedUsers.equals(rhs.authorizedUsers))));
    }

}
