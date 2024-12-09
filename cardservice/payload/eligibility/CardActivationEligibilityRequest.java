package com.td.mbna.msec.midtier.cardservice.payload.eligibility;

import com.td.mbna.msec.midtier.types.common.BaseRequest;

public class CardActivationEligibilityRequest extends BaseRequest {

	private static final long serialVersionUID = -7148505375846830610L;
    private RequestPayload requestPayload;

    public RequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(RequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CardActivationEligibilityRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("requestPayload");
        sb.append('=');
        sb.append(((this.requestPayload == null)?"<null>":this.requestPayload));
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
        result = ((result* 31)+((this.requestPayload == null)? 0 :this.requestPayload.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CardActivationEligibilityRequest) == false) {
            return false;
        }
        CardActivationEligibilityRequest rhs = ((CardActivationEligibilityRequest) other);
        return ((this.requestPayload == rhs.requestPayload)||((this.requestPayload!= null)&&this.requestPayload.equals(rhs.requestPayload)));
    }

}
