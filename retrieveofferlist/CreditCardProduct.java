package com.td.api.mbofp.response.retrieveofferlist;

import java.util.ArrayList;
import java.util.List;

import com.td.api.mbofp.shared.CustomAttribute;
import com.td.api.mbofp.shared.ProductEligibility;
import com.td.api.mbofp.shared.ProductGroup;

public class CreditCardProduct {

    private String productDesc;
    private CardAssociationType cardAssociationType;
    private List<ProductGroup> productGroup = new ArrayList<ProductGroup>();
    private FeatureGroup__2 featureGroup;
    private RelatedLoyaltyProgram relatedLoyaltyProgram;
    private List<ProductEligibility> productEligibility = new ArrayList<ProductEligibility>();
    private List<CustomAttribute> customAttribute = new ArrayList<CustomAttribute>();

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public CardAssociationType getCardAssociationType() {
        return cardAssociationType;
    }

    public void setCardAssociationType(CardAssociationType cardAssociationType) {
        this.cardAssociationType = cardAssociationType;
    }

    public List<ProductGroup> getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(List<ProductGroup> productGroup) {
        this.productGroup = productGroup;
    }

    public FeatureGroup__2 getFeatureGroup() {
        return featureGroup;
    }

    public void setFeatureGroup(FeatureGroup__2 featureGroup) {
        this.featureGroup = featureGroup;
    }

    public RelatedLoyaltyProgram getRelatedLoyaltyProgram() {
        return relatedLoyaltyProgram;
    }

    public void setRelatedLoyaltyProgram(RelatedLoyaltyProgram relatedLoyaltyProgram) {
        this.relatedLoyaltyProgram = relatedLoyaltyProgram;
    }

    public List<ProductEligibility> getProductEligibility() {
        return productEligibility;
    }

    public void setProductEligibility(List<ProductEligibility> productEligibility) {
        this.productEligibility = productEligibility;
    }

    public List<CustomAttribute> getCustomAttribute() {
        return customAttribute;
    }

    public void setCustomAttribute(List<CustomAttribute> customAttribute) {
        this.customAttribute = customAttribute;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CreditCardProduct.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("productDesc");
        sb.append('=');
        sb.append(((this.productDesc == null)?"<null>":this.productDesc));
        sb.append(',');
        sb.append("cardAssociationType");
        sb.append('=');
        sb.append(((this.cardAssociationType == null)?"<null>":this.cardAssociationType));
        sb.append(',');
        sb.append("productGroup");
        sb.append('=');
        sb.append(((this.productGroup == null)?"<null>":this.productGroup));
        sb.append(',');
        sb.append("featureGroup");
        sb.append('=');
        sb.append(((this.featureGroup == null)?"<null>":this.featureGroup));
        sb.append(',');
        sb.append("relatedLoyaltyProgram");
        sb.append('=');
        sb.append(((this.relatedLoyaltyProgram == null)?"<null>":this.relatedLoyaltyProgram));
        sb.append(',');
        sb.append("productEligibility");
        sb.append('=');
        sb.append(((this.productEligibility == null)?"<null>":this.productEligibility));
        sb.append(',');
        sb.append("customAttribute");
        sb.append('=');
        sb.append(((this.customAttribute == null)?"<null>":this.customAttribute));
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
        result = ((result* 31)+((this.productDesc == null)? 0 :this.productDesc.hashCode()));
        result = ((result* 31)+((this.customAttribute == null)? 0 :this.customAttribute.hashCode()));
        result = ((result* 31)+((this.cardAssociationType == null)? 0 :this.cardAssociationType.hashCode()));
        result = ((result* 31)+((this.productGroup == null)? 0 :this.productGroup.hashCode()));
        result = ((result* 31)+((this.featureGroup == null)? 0 :this.featureGroup.hashCode()));
        result = ((result* 31)+((this.relatedLoyaltyProgram == null)? 0 :this.relatedLoyaltyProgram.hashCode()));
        result = ((result* 31)+((this.productEligibility == null)? 0 :this.productEligibility.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreditCardProduct) == false) {
            return false;
        }
        CreditCardProduct rhs = ((CreditCardProduct) other);
        return ((((((((this.productDesc == rhs.productDesc)||((this.productDesc!= null)&&this.productDesc.equals(rhs.productDesc)))&&((this.customAttribute == rhs.customAttribute)||((this.customAttribute!= null)&&this.customAttribute.equals(rhs.customAttribute))))&&((this.cardAssociationType == rhs.cardAssociationType)||((this.cardAssociationType!= null)&&this.cardAssociationType.equals(rhs.cardAssociationType))))&&((this.productGroup == rhs.productGroup)||((this.productGroup!= null)&&this.productGroup.equals(rhs.productGroup))))&&((this.featureGroup == rhs.featureGroup)||((this.featureGroup!= null)&&this.featureGroup.equals(rhs.featureGroup))))&&((this.relatedLoyaltyProgram == rhs.relatedLoyaltyProgram)||((this.relatedLoyaltyProgram!= null)&&this.relatedLoyaltyProgram.equals(rhs.relatedLoyaltyProgram))))&&((this.productEligibility == rhs.productEligibility)||((this.productEligibility!= null)&&this.productEligibility.equals(rhs.productEligibility))));
    }

}
