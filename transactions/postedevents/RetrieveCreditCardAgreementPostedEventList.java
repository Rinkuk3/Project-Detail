package com.td.api.mbcca.response.transactions.postedevents;

import java.util.ArrayList;
import java.util.List;

import com.td.api.mbcca.shared.Pagination;
import com.td.api.mbcca.shared.Status;

public class RetrieveCreditCardAgreementPostedEventList {

    private Status status;
    private Pagination pagination;
    private List<PostedEvent> postedEvent = new ArrayList<PostedEvent>();

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<PostedEvent> getPostedEvent() {
        return postedEvent;
    }

    public void setPostedEvent(List<PostedEvent> postedEvent) {
        this.postedEvent = postedEvent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RetrieveCreditCardAgreementPostedEventList.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("pagination");
        sb.append('=');
        sb.append(((this.pagination == null)?"<null>":this.pagination));
        sb.append(',');
        sb.append("postedEvent");
        sb.append('=');
        sb.append(((this.postedEvent == null)?"<null>":this.postedEvent));
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
        result = ((result* 31)+((this.postedEvent == null)? 0 :this.postedEvent.hashCode()));
        result = ((result* 31)+((this.pagination == null)? 0 :this.pagination.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RetrieveCreditCardAgreementPostedEventList) == false) {
            return false;
        }
        RetrieveCreditCardAgreementPostedEventList rhs = ((RetrieveCreditCardAgreementPostedEventList) other);
        return ((((this.postedEvent == rhs.postedEvent)||((this.postedEvent!= null)&&this.postedEvent.equals(rhs.postedEvent)))&&((this.pagination == rhs.pagination)||((this.pagination!= null)&&this.pagination.equals(rhs.pagination))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

}
