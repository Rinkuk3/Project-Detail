package com.td.mbna.msec.midtier.mbnaad.request.response.accesscard;

import java.util.HashMap;
import java.util.Map;

public class Additionalstatus {

    private Integer statusCode;
    private String serverStatusCode;
    private Severity severity;
    private String statusDesc;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

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

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Additionalstatus.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("statusCode");
        sb.append('=');
        sb.append(((this.statusCode == null)?"<null>":this.statusCode));
        sb.append(',');
        sb.append("serverStatusCode");
        sb.append('=');
        sb.append(((this.serverStatusCode == null)?"<null>":this.serverStatusCode));
        sb.append(',');
        sb.append("severity");
        sb.append('=');
        sb.append(((this.severity == null)?"<null>":this.severity));
        sb.append(',');
        sb.append("statusDesc");
        sb.append('=');
        sb.append(((this.statusDesc == null)?"<null>":this.statusDesc));
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
        result = ((result* 31)+((this.statusDesc == null)? 0 :this.statusDesc.hashCode()));
        result = ((result* 31)+((this.statusCode == null)? 0 :this.statusCode.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Additionalstatus) == false) {
            return false;
        }
        Additionalstatus rhs = ((Additionalstatus) other);
        return (((((this.severity == rhs.severity)||((this.severity!= null)&&this.severity.equals(rhs.severity)))&&((this.serverStatusCode == rhs.serverStatusCode)||((this.serverStatusCode!= null)&&this.serverStatusCode.equals(rhs.serverStatusCode))))&&((this.statusDesc == rhs.statusDesc)||((this.statusDesc!= null)&&this.statusDesc.equals(rhs.statusDesc))))&&((this.statusCode == rhs.statusCode)||((this.statusCode!= null)&&this.statusCode.equals(rhs.statusCode))));
    }

    public enum Severity {

        INFO("Info"),
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
