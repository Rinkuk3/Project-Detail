package com.td.mbna.msec.midtier.types.common;

public enum CardType {

    VISA,
    MC;

    public String value() {
        return name();
    }

    public static CardType fromValue(String v) {
        return valueOf(v);
    }
}
