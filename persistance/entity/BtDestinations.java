package com.td.mbna.msec.midtier.persistance.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * This class corresponds to individual rows in the BTDESTINATIONS table in the local database.
 *   
 */
@Data
public class BtDestinations implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3964671572970253587L;
	private Integer btDestinationId;
	private String customerId;
	private String nickname;
	private String creditorId;
	private String accountNumber;
	
}
