package com.td.api.dms.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Status implements Serializable {

	private static final long serialVersionUID = 7429359462788791953L;
	private String serverStatusCode = "";
    private List<Additionalstatus> additionalStatus = new ArrayList<Additionalstatus>();

    public String getServerStatusCode() {
        return serverStatusCode;
    }

    public void setServerStatusCode(String serverStatusCode) {
        this.serverStatusCode = serverStatusCode;
    }

    public List<Additionalstatus> getAdditionalStatus() {
        return additionalStatus;
    }

    public void setAdditionalStatus(List<Additionalstatus> additionalStatus) {
        this.additionalStatus = additionalStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Status.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("serverStatusCode");
        sb.append('=');
        sb.append(((this.serverStatusCode == null)?"<null>":this.serverStatusCode));
        sb.append(',');
        sb.append("additionalStatus");
        sb.append('=');
        sb.append(((this.additionalStatus == null)?"<null>":this.additionalStatus));
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
        result = ((result* 31)+((this.additionalStatus == null)? 0 :this.additionalStatus.hashCode()));
        result = ((result* 31)+((this.serverStatusCode == null)? 0 :this.serverStatusCode.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Status) == false) {
            return false;
        }
        Status rhs = ((Status) other);
        return (((this.additionalStatus == rhs.additionalStatus)||((this.additionalStatus!= null)&&this.additionalStatus.equals(rhs.additionalStatus)))&&((this.serverStatusCode == rhs.serverStatusCode)||((this.serverStatusCode!= null)&&this.serverStatusCode.equals(rhs.serverStatusCode))));
    }

}
