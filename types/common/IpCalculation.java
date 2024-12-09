
package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;
import java.math.BigDecimal;


public class IpCalculation implements Serializable {

	private static final long serialVersionUID = 111L;

	private String offerId;// IP56100002
	private Integer duration;// 3
	private BigDecimal interest;
	private BigDecimal setupFees;
	private BigDecimal monthlyPayment;
	private BigDecimal totalSaving;
	private BigDecimal totalInterestPaid;
	private BigDecimal oldCost;
	private BigDecimal oneTimeTransactionFee;
	private BigDecimal totalCost;
	
	public String getOfferId() {
		return offerId;
	}

    public void setOfferId(String offerId) {
		this.offerId = offerId;
	}
	
    public Integer getDuration() {
		return duration;
	}

    public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public BigDecimal getInterest() {
		return interest;
	}
    
	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public BigDecimal getSetupFees() {
		return setupFees;
	}
    
	public void setSetupFees(BigDecimal setupFees) {
		this.setupFees = setupFees;
	}

    public BigDecimal getMonthlyPayment() {
		return monthlyPayment;
	}

    public void setMonthlyPayment(BigDecimal monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
    
	public BigDecimal getTotalSaving() {
		return totalSaving;
	}
	
	public void setTotalSaving(BigDecimal totalSaving) {
		this.totalSaving = totalSaving;
	}
    
    public BigDecimal getTotalInterestPaid() {
		return totalInterestPaid;
	}
    
	public void setTotalInterestPaid(BigDecimal totalInterestPaid) {
		this.totalInterestPaid = totalInterestPaid;
	}
    
	public BigDecimal getOldCost() {
		return oldCost;
	}
    
	public void setOldCost(BigDecimal oldCost) {
		this.oldCost = oldCost;
	}
    
	public BigDecimal getOneTimeTransactionFee() {
		return oneTimeTransactionFee;
	}
    
	public void setOneTimeTransactionFee(BigDecimal oneTimeTransactionFee) {
		this.oneTimeTransactionFee = oneTimeTransactionFee;
	}
    
	public BigDecimal getTotalCost() {
		return totalCost;
	}
    
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}
}
