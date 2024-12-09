package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class CustOfferInfoType implements Serializable {

	private static final long serialVersionUID = -3356062705636916301L;
    private String offerId;
    private java.math.BigDecimal offerRate;

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public java.math.BigDecimal getOfferRate() {
        return offerRate;
    }

    public void setOfferRate(java.math.BigDecimal offerRate) {
        this.offerRate = offerRate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CustOfferInfoType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("offerId");
        sb.append('=');
        sb.append(((this.offerId == null)?"<null>":this.offerId));
        sb.append(',');
        sb.append("offerRate");
        sb.append('=');
        sb.append(((this.offerRate == null)?"<null>":this.offerRate));
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
        result = ((result* 31)+((this.offerId == null)? 0 :this.offerId.hashCode()));
        result = ((result* 31)+((this.offerRate == null)? 0 :this.offerRate.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustOfferInfoType) == false) {
            return false;
        }
        CustOfferInfoType rhs = ((CustOfferInfoType) other);
        return (((this.offerId == rhs.offerId)||((this.offerId!= null)&&this.offerId.equals(rhs.offerId)))&&((this.offerRate == rhs.offerRate)||((this.offerRate!= null)&&this.offerRate.equals(rhs.offerRate))));
    }

}
