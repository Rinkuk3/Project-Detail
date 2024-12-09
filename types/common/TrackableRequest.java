package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class TrackableRequest implements Serializable {

	private static final long serialVersionUID = -7966645233713308896L;
    protected TrackingInfoType sessionInfo;

    public TrackingInfoType getSessionInfo() {
    	if (sessionInfo == null){
    		sessionInfo = new TrackingInfoType();
    	}
        return sessionInfo;
    }

    public void setSessionInfo(TrackingInfoType sessionInfo) {
        this.sessionInfo = sessionInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TrackableRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("sessionInfo");
        sb.append('=');
        sb.append(((this.sessionInfo == null)?"<null>":this.sessionInfo));
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
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TrackableRequest) == false) {
            return false;
        }
        TrackableRequest rhs = ((TrackableRequest) other);
        return ((this.sessionInfo == rhs.sessionInfo)||((this.sessionInfo!= null)&&this.sessionInfo.equals(rhs.sessionInfo)));
    }

}
