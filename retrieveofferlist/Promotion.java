package com.td.api.mbofp.response.retrieveofferlist;

import java.util.ArrayList;
import java.util.List;

import com.td.api.mbofp.shared.PromotionType;

public class Promotion {

    private String promotionId;
    private PromotionType promotionType;
    private String productChangeTypeCd;
    private List<String> disclosureTemplateId = new ArrayList<String>();
    private FeatureGroup featureGroup;
    private CreditCardProductPackage creditCardProductPackage;

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

    public String getProductChangeTypeCd() {
        return productChangeTypeCd;
    }

    public void setProductChangeTypeCd(String productChangeTypeCd) {
        this.productChangeTypeCd = productChangeTypeCd;
    }

    public List<String> getDisclosureTemplateId() {
        return disclosureTemplateId;
    }

    public void setDisclosureTemplateId(List<String> disclosureTemplateId) {
        this.disclosureTemplateId = disclosureTemplateId;
    }

    public FeatureGroup getFeatureGroup() {
        return featureGroup;
    }

    public void setFeatureGroup(FeatureGroup featureGroup) {
        this.featureGroup = featureGroup;
    }

    public CreditCardProductPackage getCreditCardProductPackage() {
        return creditCardProductPackage;
    }

    public void setCreditCardProductPackage(CreditCardProductPackage creditCardProductPackage) {
        this.creditCardProductPackage = creditCardProductPackage;
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
        sb.append("productChangeTypeCd");
        sb.append('=');
        sb.append(((this.productChangeTypeCd == null)?"<null>":this.productChangeTypeCd));
        sb.append(',');
        sb.append("disclosureTemplateId");
        sb.append('=');
        sb.append(((this.disclosureTemplateId == null)?"<null>":this.disclosureTemplateId));
        sb.append(',');
        sb.append("featureGroup");
        sb.append('=');
        sb.append(((this.featureGroup == null)?"<null>":this.featureGroup));
        sb.append(',');
        sb.append("creditCardProductPackage");
        sb.append('=');
        sb.append(((this.creditCardProductPackage == null)?"<null>":this.creditCardProductPackage));
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
        result = ((result* 31)+((this.creditCardProductPackage == null)? 0 :this.creditCardProductPackage.hashCode()));
        result = ((result* 31)+((this.promotionType == null)? 0 :this.promotionType.hashCode()));
        result = ((result* 31)+((this.featureGroup == null)? 0 :this.featureGroup.hashCode()));
        result = ((result* 31)+((this.disclosureTemplateId == null)? 0 :this.disclosureTemplateId.hashCode()));
        result = ((result* 31)+((this.promotionId == null)? 0 :this.promotionId.hashCode()));
        result = ((result* 31)+((this.productChangeTypeCd == null)? 0 :this.productChangeTypeCd.hashCode()));
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
        return (((((((this.creditCardProductPackage == rhs.creditCardProductPackage)||((this.creditCardProductPackage!= null)&&this.creditCardProductPackage.equals(rhs.creditCardProductPackage)))&&((this.promotionType == rhs.promotionType)||((this.promotionType!= null)&&this.promotionType.equals(rhs.promotionType))))&&((this.featureGroup == rhs.featureGroup)||((this.featureGroup!= null)&&this.featureGroup.equals(rhs.featureGroup))))&&((this.disclosureTemplateId == rhs.disclosureTemplateId)||((this.disclosureTemplateId!= null)&&this.disclosureTemplateId.equals(rhs.disclosureTemplateId))))&&((this.promotionId == rhs.promotionId)||((this.promotionId!= null)&&this.promotionId.equals(rhs.promotionId))))&&((this.productChangeTypeCd == rhs.productChangeTypeCd)||((this.productChangeTypeCd!= null)&&this.productChangeTypeCd.equals(rhs.productChangeTypeCd))));
    }

}
