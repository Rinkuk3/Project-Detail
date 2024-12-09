package com.td.mbna.msec.midtier.content.payload.getlinkcontent;

import com.td.mbna.msec.midtier.types.common.TrackableRequest;

public class GetLinkContentRequest extends TrackableRequest {

	private static final long serialVersionUID = -5400749574675040247L;
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
        sb.append(GetLinkContentRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("sessionInfo");
        sb.append('=');
        sb.append(((this.sessionInfo == null)?"<null>":this.sessionInfo));
        sb.append(',');
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
        result = ((result* 31)+((this.sessionInfo == null)? 0 :this.sessionInfo.hashCode()));
        result = ((result* 31)+((this.requestPayload == null)? 0 :this.requestPayload.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetLinkContentRequest) == false) {
            return false;
        }
        GetLinkContentRequest rhs = ((GetLinkContentRequest) other);
        return (((this.sessionInfo == rhs.sessionInfo)||((this.sessionInfo!= null)&&this.sessionInfo.equals(rhs.sessionInfo)))&&((this.requestPayload == rhs.requestPayload)||((this.requestPayload!= null)&&this.requestPayload.equals(rhs.requestPayload))));
    }

}
