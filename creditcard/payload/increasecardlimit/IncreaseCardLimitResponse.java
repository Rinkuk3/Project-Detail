package com.td.mbna.msec.midtier.creditcard.payload.increasecardlimit;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class IncreaseCardLimitResponse extends BaseResponse {

	private static final long serialVersionUID = -4239223024378743950L;
    private ResponsePayload responsePayload;

    public ResponsePayload getResponsePayload() {
    	if(responsePayload ==  null){
    		responsePayload = new ResponsePayload();
    	}
        return responsePayload;
    }

    public void setResponsePayload(ResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(IncreaseCardLimitResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("errorMsgs");
        sb.append('=');
        sb.append(((this.errorMessages == null)?"<null>":this.errorMessages));
        sb.append(',');
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
        result = ((result* 31)+((this.errorMessages == null)? 0 :this.errorMessages.hashCode()));
        result = ((result* 31)+((this.responsePayload == null)? 0 :this.responsePayload.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof IncreaseCardLimitResponse) == false) {
            return false;
        }
        IncreaseCardLimitResponse rhs = ((IncreaseCardLimitResponse) other);
        return ((((this.errorMessages == rhs.errorMessages)||((this.errorMessages!= null)&&this.errorMessages.equals(rhs.errorMessages)))&&((this.responsePayload == rhs.responsePayload)||((this.responsePayload!= null)&&this.responsePayload.equals(rhs.responsePayload))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

}
