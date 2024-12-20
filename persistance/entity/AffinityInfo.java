package com.td.mbna.msec.midtier.persistance.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * This class corresponds to individual rows in the AFFINITYINFO table in the local database.
 *   
 */
@Data
public class AffinityInfo implements Serializable {

	private static final long serialVersionUID = 1533209340823404260L;
	
	private String productCodes;
	private String language;
	private String shortName;
	private String longName;
	private String logoId;
	private String cptDescription;
	private String poCode;

}
