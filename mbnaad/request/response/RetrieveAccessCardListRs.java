package com.td.mbna.msec.midtier.mbnaad.request.response;

import java.util.ArrayList;
import java.util.List;

public class RetrieveAccessCardListRs {

    private List<Card> card = new ArrayList<Card>();

    public List<Card> getCard() {
        return card;
    }

    public void setCard(List<Card> card) {
        this.card = card;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RetrieveAccessCardListRs.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RetrieveAccessCardListRs) == false) {
            return false;
        }
        RetrieveAccessCardListRs rhs = ((RetrieveAccessCardListRs) other);
        return ((this.card == rhs.card)||((this.card!= null)&&this.card.equals(rhs.card)));
    }

}
