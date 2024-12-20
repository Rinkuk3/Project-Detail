package com.td.api.ofm.request;

import com.td.api.ofm.common.TCCAAPIBalanceSegmentEventAdjustmentInfo;

public class TSvcAddCreditCardAgreementBalanceSegmentEventAdjustmentRq {

    private TCCAAPIBalanceSegmentEventAdjustmentInfo adjustmentEvent;

    public TCCAAPIBalanceSegmentEventAdjustmentInfo getAdjustmentEvent() {
        return adjustmentEvent;
    }

    public void setAdjustmentEvent(TCCAAPIBalanceSegmentEventAdjustmentInfo adjustmentEvent) {
        this.adjustmentEvent = adjustmentEvent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TSvcAddCreditCardAgreementBalanceSegmentEventAdjustmentRq.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("adjustmentEvent");
        sb.append('=');
        sb.append(((this.adjustmentEvent == null)?"<null>":this.adjustmentEvent));
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
        result = ((result* 31)+((this.adjustmentEvent == null)? 0 :this.adjustmentEvent.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TSvcAddCreditCardAgreementBalanceSegmentEventAdjustmentRq) == false) {
            return false;
        }
        TSvcAddCreditCardAgreementBalanceSegmentEventAdjustmentRq rhs = ((TSvcAddCreditCardAgreementBalanceSegmentEventAdjustmentRq) other);
        return ((this.adjustmentEvent == rhs.adjustmentEvent)||((this.adjustmentEvent!= null)&&this.adjustmentEvent.equals(rhs.adjustmentEvent)));
    }

}
