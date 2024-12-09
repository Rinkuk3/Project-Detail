package com.td.mbna.msec.midtier.customerprofile.payload.retrieveenrollment;

import java.io.Serializable;

import lombok.Data;

@Data
public class RequestPayload implements Serializable {

	private static final long serialVersionUID = -1524880109275942517L;
	private String connectId;

}
