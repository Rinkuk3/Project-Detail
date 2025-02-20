package com.td.api.mbofp.response.retrieveofferlist;

public class Offer {

    private String offerId;
    private String offerDesc;
    private String typeCd;
    private Promotion promotion;
    private FeatureGroup__3 featureGroup;
    private String promotionOfferDispositionCd;

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getOfferDesc() {
        return offerDesc;
    }

    public void setOfferDesc(String offerDesc) {
        this.offerDesc = offerDesc;
    }

    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public FeatureGroup__3 getFeatureGroup() {
        return featureGroup;
    }

    public void setFeatureGroup(FeatureGroup__3 featureGroup) {
        this.featureGroup = featureGroup;
    }

    public String getPromotionOfferDispositionCd() {
        return promotionOfferDispositionCd;
    }

    public void setPromotionOfferDispositionCd(String promotionOfferDispositionCd) {
        this.promotionOfferDispositionCd = promotionOfferDispositionCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Offer.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("offerId");
        sb.append('=');
        sb.append(((this.offerId == null)?"<null>":this.offerId));
        sb.append(',');
        sb.append("offerDesc");
        sb.append('=');
        sb.append(((this.offerDesc == null)?"<null>":this.offerDesc));
        sb.append(',');
        sb.append("typeCd");
        sb.append('=');
        sb.append(((this.typeCd == null)?"<null>":this.typeCd));
        sb.append(',');
        sb.append("promotion");
        sb.append('=');
        sb.append(((this.promotion == null)?"<null>":this.promotion));
        sb.append(',');
        sb.append("featureGroup");
        sb.append('=');
        sb.append(((this.featureGroup == null)?"<null>":this.featureGroup));
        sb.append(',');
        sb.append("promotionOfferDispositionCd");
        sb.append('=');
        sb.append(((this.promotionOfferDispositionCd == null)?"<null>":this.promotionOfferDispositionCd));
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
        result = ((result* 31)+((this.offerDesc == null)? 0 :this.offerDesc.hashCode()));
        result = ((result* 31)+((this.typeCd == null)? 0 :this.typeCd.hashCode()));
        result = ((result* 31)+((this.featureGroup == null)? 0 :this.featureGroup.hashCode()));
        result = ((result* 31)+((this.offerId == null)? 0 :this.offerId.hashCode()));
        result = ((result* 31)+((this.promotion == null)? 0 :this.promotion.hashCode()));
        result = ((result* 31)+((this.promotionOfferDispositionCd == null)? 0 :this.promotionOfferDispositionCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Offer) == false) {
            return false;
        }
        Offer rhs = ((Offer) other);
        return (((((((this.offerDesc == rhs.offerDesc)||((this.offerDesc!= null)&&this.offerDesc.equals(rhs.offerDesc)))&&((this.typeCd == rhs.typeCd)||((this.typeCd!= null)&&this.typeCd.equals(rhs.typeCd))))&&((this.featureGroup == rhs.featureGroup)||((this.featureGroup!= null)&&this.featureGroup.equals(rhs.featureGroup))))&&((this.offerId == rhs.offerId)||((this.offerId!= null)&&this.offerId.equals(rhs.offerId))))&&((this.promotion == rhs.promotion)||((this.promotion!= null)&&this.promotion.equals(rhs.promotion))))&&((this.promotionOfferDispositionCd == rhs.promotionOfferDispositionCd)||((this.promotionOfferDispositionCd!= null)&&this.promotionOfferDispositionCd.equals(rhs.promotionOfferDispositionCd))));
    }

}
