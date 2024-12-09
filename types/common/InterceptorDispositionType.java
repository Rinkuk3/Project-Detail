package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class InterceptorDispositionType implements Serializable {

	private static final long serialVersionUID = -5859269290225605962L;
    
	private String ucid;
	private String interceptorType;
	private String connectId;
	private String tsysAccountId;
	private String interceptorId;
	private String cardRole;
	private String offerId;
	private String dispositionStatus;
	private Date timestamp;

}
