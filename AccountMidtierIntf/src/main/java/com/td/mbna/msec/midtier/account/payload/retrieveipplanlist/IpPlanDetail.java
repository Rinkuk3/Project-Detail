package com.td.mbna.msec.midtier.account.payload.retrieveipplanlist;

import java.math.BigDecimal;
import java.util.Objects;

public class IpPlanDetail {
	
	private String id = null;
	private String planName = null;
    private String createdOn = null;
	private String closedOn = null;
    private Integer timeRemaining;
    private BigDecimal monthlyPayment;
	private BigDecimal remainingBalance;
    private IpPlanStatus status = null;
    private String expirationDate = null;
    private BigDecimal balanceAtClosure; 
    private BigDecimal oneTimeTransactionFee;
    private BigDecimal ipInterest = BigDecimal.ZERO;
    private BigDecimal transactionAmt;
    private BigDecimal annualInterest;
    private String paymentDueOn;
	private String eventId;
	private String ipPaymentOptionFeatureDt;
	private String statementDataDt;
	private Integer postedTime;
	private String txLevelProcessingFeatureId;
	
	public String getId() {
		return id;
	}

    public void setId(String id) {
		this.id = id;
	}
	
    public String getPlanName() {
		return planName;
	}

    public void setPlanName(String planName) {
		this.planName = planName;
	}

    public String getCreatedOn() {
		return createdOn;
	}

    public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

    public String getClosedOn() {
		return closedOn;
	}

    public void setClosedOn(String closedOn) {
		this.closedOn = closedOn;
	}

    public Integer getTimeRemaining() {
		return timeRemaining;
	}

    public void setTimeRemaining(Integer timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

    public BigDecimal getMonthlyPayment() {
		return monthlyPayment;
	}

    public void setMonthlyPayment(BigDecimal monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

    public BigDecimal getRemainingBalance() {
		return remainingBalance;
	}

    public void setRemainingBalance(BigDecimal remainingBalance) {
		this.remainingBalance = remainingBalance;
	}

	public IpPlanStatus getStatus() {
		return status;
	}

	public void setStatus(IpPlanStatus status) {
		this.status = status;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public BigDecimal getBalanceAtClosure() {
		return balanceAtClosure;
	}

	public void setBalanceAtClosure(BigDecimal balanceAtClosure) {
		this.balanceAtClosure = balanceAtClosure;
	}

    public BigDecimal getOneTimeTransactionFee() {
		return oneTimeTransactionFee;
	}

	public void setOneTimeTransactionFee(BigDecimal oneTimeTransactionFee) {
		this.oneTimeTransactionFee = oneTimeTransactionFee;
	}

	public BigDecimal getIpInterest() {
		return ipInterest;
	}

	public void setIpInterest(BigDecimal ipInterest) {
		this.ipInterest = ipInterest;
	}

	public BigDecimal getTransactionAmt() {
		return transactionAmt;
	}

	public void setTransactionAmt(BigDecimal transactionAmt) {
		this.transactionAmt = transactionAmt;
	}

	public BigDecimal getAnnualInterest() {
		return annualInterest;
	}

	public void setAnnualInterest(BigDecimal annualInterest) {
		this.annualInterest = annualInterest;
	}

	public String getPaymentDueOn() {
		return paymentDueOn;
	}

	public void setPaymentDueOn(String paymentDueOn) {
		this.paymentDueOn = paymentDueOn;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getIpPaymentOptionFeatureDt() {
		return ipPaymentOptionFeatureDt;
	}

	public void setIpPaymentOptionFeatureDt(String ipPaymentOptionFeatureDt) {
		this.ipPaymentOptionFeatureDt = ipPaymentOptionFeatureDt;
	}

	public String getStatementDataDt() {
		return statementDataDt;
	}

	public void setStatementDataDt(String statementDataDt) {
		this.statementDataDt = statementDataDt;
	}

	public Integer getPostedTime() {
		return postedTime;
	}

	public void setPostedTime(Integer postedTime) {
		this.postedTime = postedTime;
	}

	public String getTxLevelProcessingFeatureId() {
		return txLevelProcessingFeatureId;
	}

	public void setTxLevelProcessingFeatureId(String txLevelProcessingFeatureId) {
		this.txLevelProcessingFeatureId = txLevelProcessingFeatureId;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		IpPlanDetail that = (IpPlanDetail) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(planName, that.planName) &&
				Objects.equals(createdOn, that.createdOn) &&
				Objects.equals(closedOn, that.closedOn) &&
				Objects.equals(timeRemaining, that.timeRemaining) &&
				Objects.equals(monthlyPayment, that.monthlyPayment) &&
				Objects.equals(remainingBalance, that.remainingBalance) &&
				status == that.status &&
				Objects.equals(expirationDate, that.expirationDate) &&
				Objects.equals(balanceAtClosure, that.balanceAtClosure) &&
				Objects.equals(oneTimeTransactionFee, that.oneTimeTransactionFee) &&
				Objects.equals(ipInterest, that.ipInterest) &&
				Objects.equals(transactionAmt, that.transactionAmt) &&
				Objects.equals(annualInterest, that.annualInterest) &&
				Objects.equals(paymentDueOn, that.paymentDueOn) &&
				Objects.equals(eventId, that.eventId) &&
				Objects.equals(ipPaymentOptionFeatureDt, that.ipPaymentOptionFeatureDt) &&
				Objects.equals(statementDataDt, that.statementDataDt) &&
				Objects.equals(postedTime, that.postedTime) &&
				Objects.equals(txLevelProcessingFeatureId, that.txLevelProcessingFeatureId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, planName, createdOn, closedOn, timeRemaining, monthlyPayment, remainingBalance, status, expirationDate, balanceAtClosure, oneTimeTransactionFee, ipInterest, transactionAmt, annualInterest, paymentDueOn, eventId, ipPaymentOptionFeatureDt, statementDataDt, postedTime, txLevelProcessingFeatureId);
	}

	@Override
	public String toString() {
		return "IpPlanDetail{" +
				"id='" + id + '\'' +
				", planName='" + planName + '\'' +
				", createdOn='" + createdOn + '\'' +
				", closedOn='" + closedOn + '\'' +
				", timeRemaining=" + timeRemaining +
				", monthlyPayment=" + monthlyPayment +
				", remainingBalance=" + remainingBalance +
				", status=" + status +
				", expirationDate='" + expirationDate + '\'' +
				", balanceAtClosure=" + balanceAtClosure +
				", oneTimeTransactionFee=" + oneTimeTransactionFee +
				", ipInterest=" + ipInterest +
				", transactionAmt=" + transactionAmt +
				", annualInterest=" + annualInterest +
				", paymentDueOn='" + paymentDueOn + '\'' +
				", eventId='" + eventId + '\'' +
				", ipPaymentOptionFeatureDt='" + ipPaymentOptionFeatureDt + '\'' +
				", statementDataDt='" + statementDataDt + '\'' +
				", postedTime=" + postedTime +
				", txLevelProcessingFeatureId='" + txLevelProcessingFeatureId + '\'' +
				'}';
	}
}
