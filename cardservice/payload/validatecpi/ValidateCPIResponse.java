package com.td.mbna.msec.midtier.cardservice.payload.validatecpi;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class ValidateCPIResponse extends BaseResponse {

	private static final long serialVersionUID = -2208848432892078799L;
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
        sb.append(ValidateCPIResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.getStatus() == null)?"<null>":this.getStatus()));
        sb.append(',');
        sb.append("errorMsgs");
        sb.append('=');
        sb.append(((this.getErrorMessages() == null)?"<null>":this.getErrorMessages()));
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
        result = ((result* 31)+((this.getErrorMessages() == null)? 0 :this.getErrorMessages().hashCode()));
        result = ((result* 31)+((this.responsePayload == null)? 0 :this.responsePayload.hashCode()));
        result = ((result* 31)+((this.getStatus() == null)? 0 :this.getStatus().hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ValidateCPIResponse) == false) {
            return false;
        }
        ValidateCPIResponse rhs = ((ValidateCPIResponse) other);
        return ((((this.getErrorMessages() == rhs.getErrorMessages())||((this.getErrorMessages()!= null)&&this.getErrorMessages().equals(rhs.getErrorMessages())))&&((this.responsePayload == rhs.responsePayload)||((this.responsePayload!= null)&&this.responsePayload.equals(rhs.responsePayload))))&&((this.getStatus() == rhs.getStatus())||((this.getStatus()!= null)&&this.getStatus().equals(rhs.getStatus()))));
    }

}
