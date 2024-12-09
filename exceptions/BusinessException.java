package com.td.mbna.msec.midtier.exceptions;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	/**
     * Java type that goes as soapenv:Fault detail element.
     *
     */
    private com.td.mbna.msec.midtier.types.common.BusinessException faultInfo;

    /**
     *
     * @param faultInfo
     * @param message
     */
    public BusinessException(String message, com.td.mbna.msec.midtier.types.common.BusinessException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     *
     * @param faultInfo
     * @param cause
     * @param message
     */
    public BusinessException(String message, com.td.mbna.msec.midtier.types.common.BusinessException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     *
     * @return
     *     returns fault bean: com.mbnaweb.xsd.types.common.BusinessException
     */
    public com.td.mbna.msec.midtier.types.common.BusinessException getFaultInfo() {
        return faultInfo;
    }

}
