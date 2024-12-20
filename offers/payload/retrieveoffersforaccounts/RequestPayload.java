package com.td.mbna.msec.midtier.offers.payload.retrieveoffersforaccounts;

import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.types.common.AccountOfferInputType;

public class RequestPayload {

    private List<AccountOfferInputType> accountOfferInput = new ArrayList<AccountOfferInputType>();

    public List<AccountOfferInputType> getAccountOfferInput() {
        return accountOfferInput;
    }

    public void setAccountOfferInput(List<AccountOfferInputType> accountOfferInput) {
        this.accountOfferInput = accountOfferInput;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("accountOfferInput");
        sb.append('=');
        sb.append(((this.accountOfferInput == null)?"<null>":this.accountOfferInput));
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
        result = ((result* 31)+((this.accountOfferInput == null)? 0 :this.accountOfferInput.hashCode()));
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
        return ((this.accountOfferInput == rhs.accountOfferInput)||((this.accountOfferInput!= null)&&this.accountOfferInput.equals(rhs.accountOfferInput)));
    }

}
