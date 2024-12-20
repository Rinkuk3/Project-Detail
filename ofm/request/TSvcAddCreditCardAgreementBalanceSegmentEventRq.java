package com.td.api.ofm.request;

import com.td.api.ofm.common.TCCAAPIBalanceSegmentEventInfo;

public class TSvcAddCreditCardAgreementBalanceSegmentEventRq {

    private TCCAAPIBalanceSegmentEventInfo balanceSegmentEvent;

    public TCCAAPIBalanceSegmentEventInfo getBalanceSegmentEvent() {
        return balanceSegmentEvent;
    }

    public void setBalanceSegmentEvent(TCCAAPIBalanceSegmentEventInfo balanceSegmentEvent) {
        this.balanceSegmentEvent = balanceSegmentEvent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TSvcAddCreditCardAgreementBalanceSegmentEventRq.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("balanceSegmentEvent");
        sb.append('=');
        sb.append(((this.balanceSegmentEvent == null)?"<null>":this.balanceSegmentEvent));
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
        result = ((result* 31)+((this.balanceSegmentEvent == null)? 0 :this.balanceSegmentEvent.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TSvcAddCreditCardAgreementBalanceSegmentEventRq) == false) {
            return false;
        }
        TSvcAddCreditCardAgreementBalanceSegmentEventRq rhs = ((TSvcAddCreditCardAgreementBalanceSegmentEventRq) other);
        return ((this.balanceSegmentEvent == rhs.balanceSegmentEvent)||((this.balanceSegmentEvent!= null)&&this.balanceSegmentEvent.equals(rhs.balanceSegmentEvent)));
    }

}
