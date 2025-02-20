package com.td.api.mbofp.response.retrievecampaign;

import com.td.api.mbofp.shared.PromotionType;

public class Promotion {

    private String promotionId;
    private PromotionType promotionType;
    private FeatureGroup__3 featureGroup;

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public PromotionType getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(PromotionType promotionType) {
        this.promotionType = promotionType;
    }

    public FeatureGroup__3 getFeatureGroup() {
        return featureGroup;
    }

    public void setFeatureGroup(FeatureGroup__3 featureGroup) {
        this.featureGroup = featureGroup;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Promotion.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("promotionId");
        sb.append('=');
        sb.append(((this.promotionId == null)?"<null>":this.promotionId));
        sb.append(',');
        sb.append("promotionType");
        sb.append('=');
        sb.append(((this.promotionType == null)?"<null>":this.promotionType));
        sb.append(',');
        sb.append("featureGroup");
        sb.append('=');
        sb.append(((this.featureGroup == null)?"<null>":this.featureGroup));
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
        result = ((result* 31)+((this.promotionType == null)? 0 :this.promotionType.hashCode()));
        result = ((result* 31)+((this.promotionId == null)? 0 :this.promotionId.hashCode()));
        result = ((result* 31)+((this.featureGroup == null)? 0 :this.featureGroup.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Promotion) == false) {
            return false;
        }
        Promotion rhs = ((Promotion) other);
        return ((((this.promotionType == rhs.promotionType)||((this.promotionType!= null)&&this.promotionType.equals(rhs.promotionType)))&&((this.promotionId == rhs.promotionId)||((this.promotionId!= null)&&this.promotionId.equals(rhs.promotionId))))&&((this.featureGroup == rhs.featureGroup)||((this.featureGroup!= null)&&this.featureGroup.equals(rhs.featureGroup))));
    }

}
