package com.td.api.ofm.response;

import com.td.api.ofm.common.TCCAAPIBalanceSegmentEventDetail;

public class TSvcRetrieveCreditCardAgreementBalanceSegmentEventRs {

    private TCCAAPIBalanceSegmentEventDetail balanceSegmentEvent;

    public TCCAAPIBalanceSegmentEventDetail getBalanceSegmentEvent() {
        return balanceSegmentEvent;
    }

    public void setBalanceSegmentEvent(TCCAAPIBalanceSegmentEventDetail balanceSegmentEvent) {
        this.balanceSegmentEvent = balanceSegmentEvent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TSvcRetrieveCreditCardAgreementBalanceSegmentEventRs.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        if ((other instanceof TSvcRetrieveCreditCardAgreementBalanceSegmentEventRs) == false) {
            return false;
        }
        TSvcRetrieveCreditCardAgreementBalanceSegmentEventRs rhs = ((TSvcRetrieveCreditCardAgreementBalanceSegmentEventRs) other);
        return ((this.balanceSegmentEvent == rhs.balanceSegmentEvent)||((this.balanceSegmentEvent!= null)&&this.balanceSegmentEvent.equals(rhs.balanceSegmentEvent)));
    }

}
