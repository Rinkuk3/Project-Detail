package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum DelinquencyStatusType implements Serializable {

    NOT_DELINQUENT("Not Delinquent"),
    DELINQUENT("Delinquent");
    
    private final String value;
    private final static Map<String, DelinquencyStatusType> CONSTANTS = new HashMap<String, DelinquencyStatusType>();

    static {
        for (DelinquencyStatusType c: values()) {
            CONSTANTS.put(c.value, c);
            CONSTANTS.put(c.name(), c);
        }
    }

    private DelinquencyStatusType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String value() {
        return this.value;
    }

    public static DelinquencyStatusType fromValue(String value) {
        DelinquencyStatusType constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
