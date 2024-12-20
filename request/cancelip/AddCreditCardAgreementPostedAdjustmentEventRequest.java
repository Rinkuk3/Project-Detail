package com.td.api.mbcca.request.cancelip;

public class AddCreditCardAgreementPostedAdjustmentEventRequest {

    private PostedAdjustmentEvent postedAdjustmentEvent;

    public PostedAdjustmentEvent getPostedAdjustmentEvent() {
        return postedAdjustmentEvent;
    }

    public void setPostedAdjustmentEvent(PostedAdjustmentEvent postedAdjustmentEvent) {
        this.postedAdjustmentEvent = postedAdjustmentEvent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AddCreditCardAgreementPostedAdjustmentEventRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("postedAdjustmentEvent");
        sb.append('=');
        sb.append(((this.postedAdjustmentEvent == null)?"<null>":this.postedAdjustmentEvent));
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
        result = ((result* 31)+((this.postedAdjustmentEvent == null)? 0 :this.postedAdjustmentEvent.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddCreditCardAgreementPostedAdjustmentEventRequest) == false) {
            return false;
        }
        AddCreditCardAgreementPostedAdjustmentEventRequest rhs = ((AddCreditCardAgreementPostedAdjustmentEventRequest) other);
        return ((this.postedAdjustmentEvent == rhs.postedAdjustmentEvent)||((this.postedAdjustmentEvent!= null)&&this.postedAdjustmentEvent.equals(rhs.postedAdjustmentEvent)));
    }

}
