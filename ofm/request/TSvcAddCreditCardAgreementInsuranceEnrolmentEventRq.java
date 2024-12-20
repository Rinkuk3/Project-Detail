package com.td.api.ofm.request;

import com.td.api.ofm.common.TCCAEVAPIInsuranceEnrolmentEventAddInfo;

public class TSvcAddCreditCardAgreementInsuranceEnrolmentEventRq {

    private TCCAEVAPIInsuranceEnrolmentEventAddInfo insuranceEnrolmentEvent;

    public TCCAEVAPIInsuranceEnrolmentEventAddInfo getInsuranceEnrolmentEvent() {
        return insuranceEnrolmentEvent;
    }

    public void setInsuranceEnrolmentEvent(TCCAEVAPIInsuranceEnrolmentEventAddInfo insuranceEnrolmentEvent) {
        this.insuranceEnrolmentEvent = insuranceEnrolmentEvent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TSvcAddCreditCardAgreementInsuranceEnrolmentEventRq.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("insuranceEnrolmentEvent");
        sb.append('=');
        sb.append(((this.insuranceEnrolmentEvent == null)?"<null>":this.insuranceEnrolmentEvent));
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
        result = ((result* 31)+((this.insuranceEnrolmentEvent == null)? 0 :this.insuranceEnrolmentEvent.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TSvcAddCreditCardAgreementInsuranceEnrolmentEventRq) == false) {
            return false;
        }
        TSvcAddCreditCardAgreementInsuranceEnrolmentEventRq rhs = ((TSvcAddCreditCardAgreementInsuranceEnrolmentEventRq) other);
        return ((this.insuranceEnrolmentEvent == rhs.insuranceEnrolmentEvent)||((this.insuranceEnrolmentEvent!= null)&&this.insuranceEnrolmentEvent.equals(rhs.insuranceEnrolmentEvent)));
    }

}
