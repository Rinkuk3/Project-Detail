package com.td.mbna.msec.midtier.persistance.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * This class corresponds to individual rows in the CREDITORS table in the local database.
 *   
 */
@Data
public class Creditors implements Serializable {
	
	private static final long serialVersionUID = -6376100452719835488L;
	private String creditorId;
	private String name_EN;
	private String name_FR;
	private String merchantId;
	
}
