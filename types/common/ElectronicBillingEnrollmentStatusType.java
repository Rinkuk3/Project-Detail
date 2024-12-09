package com.td.mbna.msec.midtier.types.common;

import java.util.HashMap;
import java.util.Map;

public enum ElectronicBillingEnrollmentStatusType {

    ENROLLED("ENROLLED"),
    OTHERS("OTHERS");
    private final String value;
    private final static Map<String, ElectronicBillingEnrollmentStatusType> CONSTANTS = new HashMap<String, ElectronicBillingEnrollmentStatusType>();

    static {
        for (ElectronicBillingEnrollmentStatusType c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private ElectronicBillingEnrollmentStatusType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String value() {
        return this.value;
    }

    public static ElectronicBillingEnrollmentStatusType fromValue(String value) {
        ElectronicBillingEnrollmentStatusType constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
