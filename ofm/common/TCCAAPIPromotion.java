package com.td.api.ofm.common;

public class TCCAAPIPromotion {

    private String promotionId;
    private String typeCd;
    private String promotionDesc;

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    public String getPromotionDesc() {
        return promotionDesc;
    }

    public void setPromotionDesc(String promotionDesc) {
        this.promotionDesc = promotionDesc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TCCAAPIPromotion.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("promotionId");
        sb.append('=');
        sb.append(((this.promotionId == null)?"<null>":this.promotionId));
        sb.append(',');
        sb.append("typeCd");
        sb.append('=');
        sb.append(((this.typeCd == null)?"<null>":this.typeCd));
        sb.append(',');
        sb.append("promotionDesc");
        sb.append('=');
        sb.append(((this.promotionDesc == null)?"<null>":this.promotionDesc));
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
        result = ((result* 31)+((this.typeCd == null)? 0 :this.typeCd.hashCode()));
        result = ((result* 31)+((this.promotionDesc == null)? 0 :this.promotionDesc.hashCode()));
        result = ((result* 31)+((this.promotionId == null)? 0 :this.promotionId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TCCAAPIPromotion) == false) {
            return false;
        }
        TCCAAPIPromotion rhs = ((TCCAAPIPromotion) other);
        return ((((this.typeCd == rhs.typeCd)||((this.typeCd!= null)&&this.typeCd.equals(rhs.typeCd)))&&((this.promotionDesc == rhs.promotionDesc)||((this.promotionDesc!= null)&&this.promotionDesc.equals(rhs.promotionDesc))))&&((this.promotionId == rhs.promotionId)||((this.promotionId!= null)&&this.promotionId.equals(rhs.promotionId))));
    }

}
