package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public enum DeliveryPreferenceType implements Serializable {

    ONLINE("Online"),
    PAPER("Paper");
    private final String value;
    private final static Map<String, DeliveryPreferenceType> CONSTANTS = new HashMap<>();

    static {
        for (DeliveryPreferenceType c: values()) {
            CONSTANTS.put(c.value, c);
            CONSTANTS.put(c.name(), c);
        }
    }

    DeliveryPreferenceType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String value() {
        return this.value;
    }

    public static DeliveryPreferenceType fromValue(String value) {
        DeliveryPreferenceType constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}