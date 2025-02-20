package com.td.api.mbofp.response.retrieveofferlist;

import java.util.ArrayList;
import java.util.List;

public class RetrieveOfferListRs {

    private List<Offer> offer = new ArrayList<Offer>();

    public List<Offer> getOffer() {
        return offer;
    }

    public void setOffer(List<Offer> offer) {
        this.offer = offer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RetrieveOfferListRs.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("offer");
        sb.append('=');
        sb.append(((this.offer == null)?"<null>":this.offer));
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
        result = ((result* 31)+((this.offer == null)? 0 :this.offer.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RetrieveOfferListRs) == false) {
            return false;
        }
        RetrieveOfferListRs rhs = ((RetrieveOfferListRs) other);
        return ((this.offer == rhs.offer)||((this.offer!= null)&&this.offer.equals(rhs.offer)));
    }

}
