package com.td.mbna.msec.midtier.persistance.entity;

import java.io.Serializable;

/**
 * This class corresponds to an object used by the Audit service.
 *   
 */
 public class BusinessEvent  implements Serializable {
	
	private static final long serialVersionUID = 5557417867932975414L;
	private String transactionType;
	private String transactionSubType;
	private String businessEventDesc;
	private String eventCode;
	
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionSubType() {
		return transactionSubType;
	}
	public void setTransactionSubType(String transactionSubType) {
		this.transactionSubType = transactionSubType;
	}
	public String getBusinessEventDesc(String description) {
		if(description == null) {
			return businessEventDesc;
		}
		else {
			if(businessEventDesc.contains("*")) {
				return businessEventDesc.replace("*", description);
			}
			else {
				return businessEventDesc;
			}
		}
	}
	public void setBusinessEventDesc(String businessEventDesc) {
		this.businessEventDesc = businessEventDesc;
	}
	public String getEventCode() {
		return eventCode;
	}
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

}
