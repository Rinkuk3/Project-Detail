package com.td.mbna.msec.midtier.types.common;

import java.util.HashMap;
import java.util.Map;

public enum InsuredStatusType {

    NOT_INSURED("NOT_INSURED"),
    OTHER("OTHER");
    private final String value;
    private final static Map<String, InsuredStatusType> CONSTANTS = new HashMap<String, InsuredStatusType>();

    static {
        for (InsuredStatusType c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private InsuredStatusType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String value() {
        return this.value;
    }

    public static InsuredStatusType fromValue(String value) {
        InsuredStatusType constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
