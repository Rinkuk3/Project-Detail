package com.td.mbna.msec.midtier.types.common;

public enum ErrorType {

	INFO,
    WARN,
    ERROR;

    public String value() {
        return name();
    }

    public static ErrorType fromValue(String v) {
        return valueOf(v);
    }

}
