package com.td.api.mbcca.response.card;

import java.util.ArrayList;
import java.util.List;

import com.td.api.mbcca.shared.Pagination;
import com.td.api.mbcca.shared.Status;

public class RetrieveCreditCardAgreementCardListRs {

    private Status status;
    private List<Card> card = new ArrayList<Card>();
    private Pagination pagination;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Card> getCard() {
        return card;
    }

    public void setCard(List<Card> card) {
        this.card = card;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RetrieveCreditCardAgreementCardListRs.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("card");
        sb.append('=');
        sb.append(((this.card == null)?"<null>":this.card));
        sb.append(',');
        sb.append("pagination");
        sb.append('=');
        sb.append(((this.pagination == null)?"<null>":this.pagination));
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
        result = ((result* 31)+((this.pagination == null)? 0 :this.pagination.hashCode()));
        result = ((result* 31)+((this.card == null)? 0 :this.card.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RetrieveCreditCardAgreementCardListRs) == false) {
            return false;
        }
        RetrieveCreditCardAgreementCardListRs rhs = ((RetrieveCreditCardAgreementCardListRs) other);
        return ((((this.pagination == rhs.pagination)||((this.pagination!= null)&&this.pagination.equals(rhs.pagination)))&&((this.card == rhs.card)||((this.card!= null)&&this.card.equals(rhs.card))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

}
