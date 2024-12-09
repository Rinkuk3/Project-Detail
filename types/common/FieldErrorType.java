package com.td.mbna.msec.midtier.types.common;

import java.util.HashMap;
import java.util.Map;

public class FieldErrorType extends ExceptionInfo{

    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FieldErrorType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("errorCode");
        sb.append('=');
        sb.append(((this.errorCode == null)?"<null>":this.errorCode));
        sb.append(',');
        sb.append("severity");
        sb.append('=');
        sb.append(((this.severity == null)?"<null>":this.severity));
        sb.append(',');
        sb.append("errorDescription");
        sb.append('=');
        sb.append(((this.errorDescription == null)?"<null>":this.errorDescription));
        sb.append(',');
        sb.append("soapFaultDescription");
        sb.append('=');
        sb.append(((this.soapFaultDescription == null)?"<null>":this.soapFaultDescription));
        sb.append(',');
        sb.append("field");
        sb.append('=');
        sb.append(((this.field == null)?"<null>":this.field));
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
        result = ((result* 31)+((this.errorCode == null)? 0 :this.errorCode.hashCode()));
        result = ((result* 31)+((this.errorDescription == null)? 0 :this.errorDescription.hashCode()));
        result = ((result* 31)+((this.field == null)? 0 :this.field.hashCode()));
        result = ((result* 31)+((this.soapFaultDescription == null)? 0 :this.soapFaultDescription.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FieldErrorType) == false) {
            return false;
        }
        FieldErrorType rhs = ((FieldErrorType) other);
        return ((((((this.severity == rhs.severity)||((this.severity!= null)&&this.severity.equals(rhs.severity)))&&((this.errorCode == rhs.errorCode)||((this.errorCode!= null)&&this.errorCode.equals(rhs.errorCode))))&&((this.errorDescription == rhs.errorDescription)||((this.errorDescription!= null)&&this.errorDescription.equals(rhs.errorDescription))))&&((this.field == rhs.field)||((this.field!= null)&&this.field.equals(rhs.field))))&&((this.soapFaultDescription == rhs.soapFaultDescription)||((this.soapFaultDescription!= null)&&this.soapFaultDescription.equals(rhs.soapFaultDescription))));
    }

    public enum Severity {

        INFO("INFO"),
        WARN("WARN"),
        ERROR("ERROR");
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
