package com.td.mbna.msec.midtier.offers.payload.retrieveoffers;

import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.types.common.PromotionOfferType;

public class ResponsePayload {

    private List<PromotionOfferType> promotionOffer = new ArrayList<PromotionOfferType>();

    public List<PromotionOfferType> getPromotionOffer() {
        return promotionOffer;
    }

    public void setPromotionOffer(List<PromotionOfferType> promotionOffer) {
        this.promotionOffer = promotionOffer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ResponsePayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("promotionOffer");
        sb.append('=');
        sb.append(((this.promotionOffer == null)?"<null>":this.promotionOffer));
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
        result = ((result* 31)+((this.promotionOffer == null)? 0 :this.promotionOffer.hashCode()));
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
        return ((this.promotionOffer == rhs.promotionOffer)||((this.promotionOffer!= null)&&this.promotionOffer.equals(rhs.promotionOffer)));
    }

}
