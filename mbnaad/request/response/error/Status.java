package com.td.mbna.msec.midtier.mbnaad.request.response.error;

import com.td.mbna.msec.midtier.mbnaad.request.response.accesscard.Additionalstatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Status {

    private String serverStatusCode;
    private Severity severity;
    private List<Additionalstatus> additionalStatus = new ArrayList<Additionalstatus>();

    public String getServerStatusCode() {
        return serverStatusCode;
    }

    public void setServerStatusCode(String serverStatusCode) {
        this.serverStatusCode = serverStatusCode;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
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
        sb.append("severity");
        sb.append('=');
        sb.append(((this.severity == null)?"<null>":this.severity));
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
        result = ((result* 31)+((this.severity == null)? 0 :this.severity.hashCode()));
        result = ((result* 31)+((this.serverStatusCode == null)? 0 :this.serverStatusCode.hashCode()));
        result = ((result* 31)+((this.additionalStatus == null)? 0 :this.additionalStatus.hashCode()));
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
        return ((((this.severity == rhs.severity)||((this.severity!= null)&&this.severity.equals(rhs.severity)))&&((this.serverStatusCode == rhs.serverStatusCode)||((this.serverStatusCode!= null)&&this.serverStatusCode.equals(rhs.serverStatusCode))))&&((this.additionalStatus == rhs.additionalStatus)||((this.additionalStatus!= null)&&this.additionalStatus.equals(rhs.additionalStatus))));
    }

    public enum Severity {

        WARNING("Warning"),
        ERROR("Error");
        private final String value;
        private final static Map<String, Severity> CONSTANTS = new HashMap<String, Severity>();

        static {
            for (Severity c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Severity(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static Severity fromValue(String value) {
            Severity constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
