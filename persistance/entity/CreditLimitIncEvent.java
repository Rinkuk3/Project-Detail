package com.td.mbna.msec.midtier.persistance.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * This class corresponds to individual rows in the CREDITLIMITINCEVENT table in the local database.
 *   
 */
@Data
public class CreditLimitIncEvent implements Serializable {

	private static final long serialVersionUID = 3414765398153727797L;
	
	private String offerId;
	private String custId;					// MDM id
	private String aliasCustId;				// TSYS id
	private BigDecimal currentCreditLimit;
	private BigDecimal preApprovalLimit; 	
	private BigDecimal preApprovalPercent;
	private BigDecimal reqCreditLimit;		// increase to amount
	private String housingStatus;
	private BigDecimal housingPayment;
	private String accountNumber;
	private String lengthOfService;
	private Integer eventID;
	
	
	
}
