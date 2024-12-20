package com.td.mbna.msec.midtier.offers.payload.retrieveoffers;

import com.td.mbna.msec.midtier.types.common.OfferInputPerAccountType;

public class RequestPayload {

    private OfferInputPerAccountType offerInput;

    public OfferInputPerAccountType getOfferInput() {
        return offerInput;
    }

    public void setOfferInput(OfferInputPerAccountType offerInput) {
        this.offerInput = offerInput;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("offerInput");
        sb.append('=');
        sb.append(((this.offerInput == null)?"<null>":this.offerInput));
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
        result = ((result* 31)+((this.offerInput == null)? 0 :this.offerInput.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestPayload) == false) {
            return false;
        }
        RequestPayload rhs = ((RequestPayload) other);
        return ((this.offerInput == rhs.offerInput)||((this.offerInput!= null)&&this.offerInput.equals(rhs.offerInput)));
    }

}
