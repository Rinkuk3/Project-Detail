
package com.td.api.mbalert.response.addalertevent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Status {

    private String serverStatusCode;
    private Status.Severity severity;
    private List<Additionalstatus> additionalStatus = new ArrayList<Additionalstatus>();

    public enum Severity {

        WARNING("Warning"),
        ERROR("Error");
        private final String value;
        private final static Map<String, Status.Severity> CONSTANTS = new HashMap<String, Status.Severity>();

        static {
            for (Status.Severity c: values()) {
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

        public static Status.Severity fromValue(String value) {
            Status.Severity constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
