package com.td.api.mbofp.response.retrievecampaign;

import java.util.ArrayList;
import java.util.List;

import com.td.api.mbofp.shared.CustomAttribute;
import com.td.api.mbofp.shared.ProductEligibility;
import com.td.api.mbofp.shared.ProductGroup;

public class CreditCardProduct {

    private List<Name> name = new ArrayList<Name>();
    private List<Name> longName = new ArrayList<Name>();
    private String productDesc;
    private CardAssociationType cardAssociationType;
    private List<ProductGroup> productGroup = new ArrayList<ProductGroup>();
    private RelatedLoyaltyProgram relatedLoyaltyProgram;
    private List<ProductEligibility> productEligibility = new ArrayList<ProductEligibility>();
    private List<CreditCardProductPackage> creditCardProductPackage = new ArrayList<CreditCardProductPackage>();
    private List<CustomAttribute> customAttribute = new ArrayList<CustomAttribute>();
    private FeatureGroup__1 featureGroup;

    public List<Name> getName() {
        return name;
    }

    public void setName(List<Name> name) {
        this.name = name;
    }

    public List<Name> getLongName() {
        return longName;
    }

    public void setLongName(List<Name> longName) {
        this.longName = longName;
    }

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

    public List<CreditCardProductPackage> getCreditCardProductPackage() {
        return creditCardProductPackage;
    }

    public void setCreditCardProductPackage(List<CreditCardProductPackage> creditCardProductPackage) {
        this.creditCardProductPackage = creditCardProductPackage;
    }

    public List<CustomAttribute> getCustomAttribute() {
        return customAttribute;
    }

    public void setCustomAttribute(List<CustomAttribute> customAttribute) {
        this.customAttribute = customAttribute;
    }

    public FeatureGroup__1 getFeatureGroup() {
        return featureGroup;
    }

    public void setFeatureGroup(FeatureGroup__1 featureGroup) {
        this.featureGroup = featureGroup;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CreditCardProduct.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("longName");
        sb.append('=');
        sb.append(((this.longName == null)?"<null>":this.longName));
        sb.append(',');
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
        sb.append("relatedLoyaltyProgram");
        sb.append('=');
        sb.append(((this.relatedLoyaltyProgram == null)?"<null>":this.relatedLoyaltyProgram));
        sb.append(',');
        sb.append("productEligibility");
        sb.append('=');
        sb.append(((this.productEligibility == null)?"<null>":this.productEligibility));
        sb.append(',');
        sb.append("creditCardProductPackage");
        sb.append('=');
        sb.append(((this.creditCardProductPackage == null)?"<null>":this.creditCardProductPackage));
        sb.append(',');
        sb.append("customAttribute");
        sb.append('=');
        sb.append(((this.customAttribute == null)?"<null>":this.customAttribute));
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
        result = ((result* 31)+((this.productDesc == null)? 0 :this.productDesc.hashCode()));
        result = ((result* 31)+((this.creditCardProductPackage == null)? 0 :this.creditCardProductPackage.hashCode()));
        result = ((result* 31)+((this.customAttribute == null)? 0 :this.customAttribute.hashCode()));
        result = ((result* 31)+((this.cardAssociationType == null)? 0 :this.cardAssociationType.hashCode()));
        result = ((result* 31)+((this.productGroup == null)? 0 :this.productGroup.hashCode()));
        result = ((result* 31)+((this.featureGroup == null)? 0 :this.featureGroup.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.relatedLoyaltyProgram == null)? 0 :this.relatedLoyaltyProgram.hashCode()));
        result = ((result* 31)+((this.productEligibility == null)? 0 :this.productEligibility.hashCode()));
        result = ((result* 31)+((this.longName == null)? 0 :this.longName.hashCode()));
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
        return (((((((((((this.productDesc == rhs.productDesc)||((this.productDesc!= null)&&this.productDesc.equals(rhs.productDesc)))&&((this.creditCardProductPackage == rhs.creditCardProductPackage)||((this.creditCardProductPackage!= null)&&this.creditCardProductPackage.equals(rhs.creditCardProductPackage))))&&((this.customAttribute == rhs.customAttribute)||((this.customAttribute!= null)&&this.customAttribute.equals(rhs.customAttribute))))&&((this.cardAssociationType == rhs.cardAssociationType)||((this.cardAssociationType!= null)&&this.cardAssociationType.equals(rhs.cardAssociationType))))&&((this.productGroup == rhs.productGroup)||((this.productGroup!= null)&&this.productGroup.equals(rhs.productGroup))))&&((this.featureGroup == rhs.featureGroup)||((this.featureGroup!= null)&&this.featureGroup.equals(rhs.featureGroup))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.relatedLoyaltyProgram == rhs.relatedLoyaltyProgram)||((this.relatedLoyaltyProgram!= null)&&this.relatedLoyaltyProgram.equals(rhs.relatedLoyaltyProgram))))&&((this.productEligibility == rhs.productEligibility)||((this.productEligibility!= null)&&this.productEligibility.equals(rhs.productEligibility))))&&((this.longName == rhs.longName)||((this.longName!= null)&&this.longName.equals(rhs.longName))));
    }

}
