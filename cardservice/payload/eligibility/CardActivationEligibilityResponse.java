package com.td.mbna.msec.midtier.cardservice.payload.eligibility;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class CardActivationEligibilityResponse extends BaseResponse {

	private static final long serialVersionUID = 8783727395896935890L;
    private ResponsePayload responsePayload;

    public ResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(ResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CardActivationEligibilityResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("responsePayload");
        sb.append('=');
        sb.append(((this.responsePayload == null)?"<null>":this.responsePayload));
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
        result = ((result* 31)+((this.responsePayload == null)? 0 :this.responsePayload.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CardActivationEligibilityResponse) == false) {
            return false;
        }
        CardActivationEligibilityResponse rhs = ((CardActivationEligibilityResponse) other);
        return ((this.responsePayload == rhs.responsePayload)||((this.responsePayload!= null)&&this.responsePayload.equals(rhs.responsePayload)));
    }

}
