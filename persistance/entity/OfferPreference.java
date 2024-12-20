package com.td.mbna.msec.midtier.persistance.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class OfferPreference implements Serializable {

	private static final long serialVersionUID = 8617155239688965136L;
	
	private String ucid;
	private String connectId;
	private String cardRole;
	private String offerType;
	private String enabled;
	private Date enabledTS;
	private String disabled;
	private Date disabledTS;

}
