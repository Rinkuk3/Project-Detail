package com.td.api.mbcca.response.transactions.authorizations.summary;

import java.util.ArrayList;
import java.util.List;

import com.td.api.mbcca.shared.Status;

public class RetrieveCreditCardAgreementAuthorizationEventList {

    private Status status;
    private List<AuthorizationEvent> authorizationEvent = new ArrayList<AuthorizationEvent>();

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<AuthorizationEvent> getAuthorizationEvent() {
        return authorizationEvent;
    }

    public void setAuthorizationEvent(List<AuthorizationEvent> authorizationEvent) {
        this.authorizationEvent = authorizationEvent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RetrieveCreditCardAgreementAuthorizationEventList.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("authorizationEvent");
        sb.append('=');
        sb.append(((this.authorizationEvent == null)?"<null>":this.authorizationEvent));
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
        result = ((result* 31)+((this.authorizationEvent == null)? 0 :this.authorizationEvent.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RetrieveCreditCardAgreementAuthorizationEventList) == false) {
            return false;
        }
        RetrieveCreditCardAgreementAuthorizationEventList rhs = ((RetrieveCreditCardAgreementAuthorizationEventList) other);
        return (((this.authorizationEvent == rhs.authorizationEvent)||((this.authorizationEvent!= null)&&this.authorizationEvent.equals(rhs.authorizationEvent)))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

}
