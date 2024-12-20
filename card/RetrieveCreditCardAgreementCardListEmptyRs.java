package com.td.api.mbcca.response.card;

import java.util.ArrayList;
import java.util.List;

import com.td.api.mbcca.shared.Pagination;

public class RetrieveCreditCardAgreementCardListEmptyRs {

    private Pagination pagination;
    private List<Card> card = new ArrayList<Card>();

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Card> getCard() {
        return card;
    }

    public void setCard(List<Card> card) {
        this.card = card;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RetrieveCreditCardAgreementCardListEmptyRs.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("pagination");
        sb.append('=');
        sb.append(((this.pagination == null)?"<null>":this.pagination));
        sb.append(',');
        sb.append("card");
        sb.append('=');
        sb.append(((this.card == null)?"<null>":this.card));
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
        result = ((result* 31)+((this.card == null)? 0 :this.card.hashCode()));
        result = ((result* 31)+((this.pagination == null)? 0 :this.pagination.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RetrieveCreditCardAgreementCardListEmptyRs) == false) {
            return false;
        }
        RetrieveCreditCardAgreementCardListEmptyRs rhs = ((RetrieveCreditCardAgreementCardListEmptyRs) other);
        return (((this.card == rhs.card)||((this.card!= null)&&this.card.equals(rhs.card)))&&((this.pagination == rhs.pagination)||((this.pagination!= null)&&this.pagination.equals(rhs.pagination))));
    }

}
