package com.td.mbna.msec.midtier.account.payload.getrewardssaml;

import java.io.Serializable;

public class ResponsePayload implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ssoSaml;

	public String getSsoSaml() {
		return ssoSaml;
	}

	public void setSsoSaml(String ssoSaml) {
		this.ssoSaml = ssoSaml;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ResponsePayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("ssoSaml");
        sb.append('=');
        sb.append(((this.ssoSaml == null)?"<null>":this.ssoSaml));
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
        result = ((result* 31)+((this.ssoSaml == null)? 0 :this.ssoSaml.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResponsePayload) == false) {
            return false;
        }
        ResponsePayload rhs = ((ResponsePayload) other);
        return ((this.ssoSaml == rhs.ssoSaml)||((this.ssoSaml!= null)&&this.ssoSaml.equals(rhs.ssoSaml)));
    }

}