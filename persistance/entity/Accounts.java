package com.td.mbna.msec.midtier.persistance.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * This class corresponds to individual rows in the ACCOUNTS table in the local database.
 *   
 */
@Data
public class Accounts implements Serializable {

	private static final long serialVersionUID = -8945759681036044439L;

	private String customerId;
	private String emailPreference;
	private String accountNumber;
	
}
