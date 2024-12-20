package com.td.mbna.msec.midtier.offers.payload.retrieveoffersforaccounts;

import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.types.common.AccountOffersType;

public class ResponsePayload {

    private List<AccountOffersType> accountOffers = new ArrayList<AccountOffersType>();

    public List<AccountOffersType> getAccountOffers() {
        return accountOffers;
    }

    public void setAccountOffers(List<AccountOffersType> accountOffers) {
        this.accountOffers = accountOffers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ResponsePayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("accountOffers");
        sb.append('=');
        sb.append(((this.accountOffers == null)?"<null>":this.accountOffers));
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
        result = ((result* 31)+((this.accountOffers == null)? 0 :this.accountOffers.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResponsePayload) == false) {
            return false;
        }
        ResponsePayload rhs = ((ResponsePayload) other);
        return ((this.accountOffers == rhs.accountOffers)||((this.accountOffers!= null)&&this.accountOffers.equals(rhs.accountOffers)));
    }

}
