package com.td.api.ofm.request;

import com.td.api.ofm.common.TCCAEVAPIProductChangeEventAddInfo;

public class TSvcAddCreditCardAgreementProductChangeEventRq {

    private TCCAEVAPIProductChangeEventAddInfo productChangeEvent;

    public TCCAEVAPIProductChangeEventAddInfo getProductChangeEvent() {
        return productChangeEvent;
    }

    public void setProductChangeEvent(TCCAEVAPIProductChangeEventAddInfo productChangeEvent) {
        this.productChangeEvent = productChangeEvent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TSvcAddCreditCardAgreementProductChangeEventRq.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("productChangeEvent");
        sb.append('=');
        sb.append(((this.productChangeEvent == null)?"<null>":this.productChangeEvent));
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
        result = ((result* 31)+((this.productChangeEvent == null)? 0 :this.productChangeEvent.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TSvcAddCreditCardAgreementProductChangeEventRq) == false) {
            return false;
        }
        TSvcAddCreditCardAgreementProductChangeEventRq rhs = ((TSvcAddCreditCardAgreementProductChangeEventRq) other);
        return ((this.productChangeEvent == rhs.productChangeEvent)||((this.productChangeEvent!= null)&&this.productChangeEvent.equals(rhs.productChangeEvent)));
    }

}
