package com.td.mbna.msec.midtier.persistance.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * This class corresponds to individual rows in the CUSTOMERS table in the local database.
 *   
 */
@Data
public class Customers implements Serializable {

	private static final long serialVersionUID = 2322908270586806688L;
	private String customerId;
	private Date lastLogin;
	private Date eAAPublishedDateAccepted;
	private Date firstLogin;
	private int count;
		
}
