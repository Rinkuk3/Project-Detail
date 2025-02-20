package com.td.api.mbofp.response.retrievecampaign;

import java.util.ArrayList;
import java.util.List;

public class PromotionProductOffer {

    private CreditCardProduct creditCardProduct;
    private List<PromotionOffer> promotionOffer = new ArrayList<PromotionOffer>();

    public CreditCardProduct getCreditCardProduct() {
        return creditCardProduct;
    }

    public void setCreditCardProduct(CreditCardProduct creditCardProduct) {
        this.creditCardProduct = creditCardProduct;
    }

    public List<PromotionOffer> getPromotionOffer() {
        return promotionOffer;
    }

    public void setPromotionOffer(List<PromotionOffer> promotionOffer) {
        this.promotionOffer = promotionOffer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PromotionProductOffer.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("creditCardProduct");
        sb.append('=');
        sb.append(((this.creditCardProduct == null)?"<null>":this.creditCardProduct));
        sb.append(',');
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
        result = ((result* 31)+((this.creditCardProduct == null)? 0 :this.creditCardProduct.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PromotionProductOffer) == false) {
            return false;
        }
        PromotionProductOffer rhs = ((PromotionProductOffer) other);
        return (((this.promotionOffer == rhs.promotionOffer)||((this.promotionOffer!= null)&&this.promotionOffer.equals(rhs.promotionOffer)))&&((this.creditCardProduct == rhs.creditCardProduct)||((this.creditCardProduct!= null)&&this.creditCardProduct.equals(rhs.creditCardProduct))));
    }

}
