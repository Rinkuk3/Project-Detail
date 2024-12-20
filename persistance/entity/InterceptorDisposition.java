package com.td.mbna.msec.midtier.persistance.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class InterceptorDisposition implements Serializable {

	private static final long serialVersionUID = -8324111931147002262L;
	
	private String ucid;
	private String offerId;
	private String interceptorType;
	private String connectId;
	private String tsysAccountId;
	private String interceptorId;
	private String cardRole;
	private String dispositionStatus;
	private Date timestamp;
	
	public InterceptorDisposition() {
	}
	
	public InterceptorDisposition(String ucid, String connectId, String interceptorType,
			String dispositionStatus) {
		this.ucid = ucid;
		this.connectId = connectId;
		this.interceptorType = interceptorType;
		this.dispositionStatus = dispositionStatus;
	}

}
