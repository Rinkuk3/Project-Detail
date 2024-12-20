package com.td.mbna.msec.midtier.mbnaad.exception;

public class MBNAException extends Exception {
    private String errorCode;

    public MBNAException(String message) {
        super(message);
    }

    public MBNAException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
