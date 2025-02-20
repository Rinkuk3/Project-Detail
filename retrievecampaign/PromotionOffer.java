package com.td.api.mbofp.response.retrievecampaign;

public class PromotionOffer {

    private Offer offer;
    private Promotion promotion;

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PromotionOffer.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("offer");
        sb.append('=');
        sb.append(((this.offer == null)?"<null>":this.offer));
        sb.append(',');
        sb.append("promotion");
        sb.append('=');
        sb.append(((this.promotion == null)?"<null>":this.promotion));
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
        result = ((result* 31)+((this.promotion == null)? 0 :this.promotion.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PromotionOffer) == false) {
            return false;
        }
        PromotionOffer rhs = ((PromotionOffer) other);
        return (((this.offer == rhs.offer)||((this.offer!= null)&&this.offer.equals(rhs.offer)))&&((this.promotion == rhs.promotion)||((this.promotion!= null)&&this.promotion.equals(rhs.promotion))));
    }

}
