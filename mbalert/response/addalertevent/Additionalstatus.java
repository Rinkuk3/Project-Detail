
package com.td.api.mbalert.response.addalertevent;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Additionalstatus {

    private Integer statusCode;
    private String serverStatusCode;
    private Additionalstatus.Severity severity;
    private String statusDesc;




    /**
     * API Status Severity Code.
     * Valid values:
     * Error – There was an error in the request severe enough that no response could be made. The requested transaction was not processed.
     * Warning – There was a problem with the request, but a valid response is still present. The requested transaction was processed.
     * Info – Information Only. The requested transaction was processed.
     * 
     */
    public enum Severity {

        INFO("Info"),
        WARNING("Warning"),
        ERROR("Error");
        private final String value;
        private final static Map<String, Additionalstatus.Severity> CONSTANTS = new HashMap<String, Additionalstatus.Severity>();

        static {
            for (Additionalstatus.Severity c: values()) {
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

        public static Additionalstatus.Severity fromValue(String value) {
            Additionalstatus.Severity constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
