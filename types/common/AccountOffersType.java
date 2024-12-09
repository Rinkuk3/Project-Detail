package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AccountOffersType implements Serializable {

	private static final long serialVersionUID = -5671358880245026724L;
    private String acctNum;
    private List<PromotionOfferType> promotionOffer = new ArrayList<PromotionOfferType>();

    public String getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }

    public List<PromotionOfferType> getPromotionOffer() {
        return promotionOffer;
    }

    public void setPromotionOffer(List<PromotionOfferType> promotionOffer) {
        this.promotionOffer = promotionOffer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AccountOffersType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("acctNum");
        sb.append('=');
        sb.append(((this.acctNum == null)?"<null>":this.acctNum));
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
        result = ((result* 31)+((this.acctNum == null)? 0 :this.acctNum.hashCode()));
        result = ((result* 31)+((this.promotionOffer == null)? 0 :this.promotionOffer.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AccountOffersType) == false) {
            return false;
        }
        AccountOffersType rhs = ((AccountOffersType) other);
        return (((this.acctNum == rhs.acctNum)||((this.acctNum!= null)&&this.acctNum.equals(rhs.acctNum)))&&((this.promotionOffer == rhs.promotionOffer)||((this.promotionOffer!= null)&&this.promotionOffer.equals(rhs.promotionOffer))));
    }

}
