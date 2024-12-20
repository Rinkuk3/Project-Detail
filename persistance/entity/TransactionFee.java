package com.td.mbna.msec.midtier.persistance.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * This class corresponds to individual rows in the AFFINITYINFO table in the local database.
 *   
 */
public class TransactionFee implements Serializable {

	private static final long serialVersionUID = -1715806085870541261L;
	private String transaction_fee_no;
	private String subtype;
	private BigDecimal fixed_amount;
	private BigDecimal maximum_amount;
	private BigDecimal minimum_amount;
	private BigDecimal percentage;

	public TransactionFee() {
	}

	public TransactionFee(String transaction_fee_no, String subtype) {
		this.transaction_fee_no = transaction_fee_no;
		this.subtype = subtype;
	}

	/**
	 *  toString method
	 */
	@Override
	public String toString() {
		return transaction_fee_no + "|" + subtype;
	}

	/**
	 *  compare two AffinityInfo objects
	 */
	@Override
	public boolean equals(Object arg0) {
		if (arg0 == null) {
			return false;
		}
		
		if (!(arg0 instanceof TransactionFee)) {
			return false;
		}
		TransactionFee arg1 = (TransactionFee) arg0;
		return this.transaction_fee_no.equals(arg1.getTransaction_fee_no())
				&& this.subtype.equals(arg1.getSubtype());

	}

	/**
	 *  hashCode
	 */
	@Override
	public int hashCode() {
		int hsCode;
		hsCode = transaction_fee_no.hashCode();
		hsCode = 19 * hsCode + subtype.hashCode();
		return hsCode;
	}

	public String getTransaction_fee_no() {
		return transaction_fee_no;
	}

	public void setTransaction_fee_no(String transaction_fee_no) {
		this.transaction_fee_no = transaction_fee_no;
	}
	
	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public BigDecimal getFixed_amount() {
		return fixed_amount;
	}

	public void setFixed_amount(BigDecimal fixed_amount) {
		this.fixed_amount = fixed_amount;
	}

	public BigDecimal getMaximum_amount() {
		return maximum_amount;
	}

	public void setMaximum_amount(BigDecimal maximum_amount) {
		this.maximum_amount = maximum_amount;
	}

	public BigDecimal getMinimum_amount() {
		return minimum_amount;
	}

	public void setMinimum_amount(BigDecimal minimum_amount) {
		this.minimum_amount = minimum_amount;
	}

	public BigDecimal getPercentage() {
		return percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}
}
