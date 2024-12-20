package com.td.mbna.msec.midtier.transfer.payload.getbalancetransfertocreditorsummary;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class GetBalanceTransferToCreditorSummaryResponse extends BaseResponse {

	private static final long serialVersionUID = -1673380447196531628L;
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
        sb.append(GetBalanceTransferToCreditorSummaryResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("errorMsgs");
        sb.append('=');
        sb.append(((this.errorMsgs == null)?"<null>":this.errorMsgs));
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
        result = ((result* 31)+((this.errorMsgs == null)? 0 :this.errorMsgs.hashCode()));
        result = ((result* 31)+((this.responsePayload == null)? 0 :this.responsePayload.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetBalanceTransferToCreditorSummaryResponse) == false) {
            return false;
        }
        GetBalanceTransferToCreditorSummaryResponse rhs = ((GetBalanceTransferToCreditorSummaryResponse) other);
        return ((((this.errorMsgs == rhs.errorMsgs)||((this.errorMsgs!= null)&&this.errorMsgs.equals(rhs.errorMsgs)))&&((this.responsePayload == rhs.responsePayload)||((this.responsePayload!= null)&&this.responsePayload.equals(rhs.responsePayload))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

}
