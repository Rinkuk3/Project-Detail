package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class AcctSnapshotType implements Serializable
{
	private final static long serialVersionUID = -6756030283204872296L;

    private AcctOverviewType acctOverview;
    private java.math.BigDecimal currentBalance;
    private java.math.BigDecimal temporaryAuthorizationsToday;
    private java.math.BigDecimal temporaryAuthorizationsPrior;
    private java.math.BigDecimal creditLimit;
    private String minPaymentDueDate;
    private java.math.BigDecimal pastDueAmount;
    private java.math.BigDecimal lastStatementBalance;
    private String lastStatementBalanceDate;
    private java.math.BigDecimal lastPaymentPosted;
    private String lastPaymentPostedDate;
    private String acctId;
    private java.math.BigDecimal cashAdvanceLimit;
    private Integer pointsAvailable;
    private String nextStatementClosingDate;

    public AcctOverviewType getAcctOverview() {
        return acctOverview;
    }

    public void setAcctOverview(AcctOverviewType acctOverview) {
        this.acctOverview = acctOverview;
    }

    public java.math.BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(java.math.BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public java.math.BigDecimal getTemporaryAuthorizationsToday() {
        return temporaryAuthorizationsToday;
    }

    public void setTemporaryAuthorizationsToday(java.math.BigDecimal temporaryAuthorizationsToday) {
        this.temporaryAuthorizationsToday = temporaryAuthorizationsToday;
    }

    public java.math.BigDecimal getTemporaryAuthorizationsPrior() {
        return temporaryAuthorizationsPrior;
    }

    public void setTemporaryAuthorizationsPrior(java.math.BigDecimal temporaryAuthorizationsPrior) {
        this.temporaryAuthorizationsPrior = temporaryAuthorizationsPrior;
    }

    public java.math.BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(java.math.BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getMinPaymentDueDate() {
        return minPaymentDueDate;
    }

    public void setMinPaymentDueDate(String minPaymentDueDate) {
        this.minPaymentDueDate = minPaymentDueDate;
    }

    public java.math.BigDecimal getPastDueAmount() {
        return pastDueAmount;
    }

    public void setPastDueAmount(java.math.BigDecimal pastDueAmount) {
        this.pastDueAmount = pastDueAmount;
    }

    public java.math.BigDecimal getLastStatementBalance() {
        return lastStatementBalance;
    }

    public void setLastStatementBalance(java.math.BigDecimal lastStatementBalance) {
        this.lastStatementBalance = lastStatementBalance;
    }

    public String getLastStatementBalanceDate() {
        return lastStatementBalanceDate;
    }

    public void setLastStatementBalanceDate(String lastStatementBalanceDate) {
        this.lastStatementBalanceDate = lastStatementBalanceDate;
    }

    public java.math.BigDecimal getLastPaymentPosted() {
        return lastPaymentPosted;
    }

    public void setLastPaymentPosted(java.math.BigDecimal lastPaymentPosted) {
        this.lastPaymentPosted = lastPaymentPosted;
    }

    public String getLastPaymentPostedDate() {
        return lastPaymentPostedDate;
    }

    public void setLastPaymentPostedDate(String lastPaymentPostedDate) {
        this.lastPaymentPostedDate = lastPaymentPostedDate;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public java.math.BigDecimal getCashAdvanceLimit() {
        return cashAdvanceLimit;
    }

    public void setCashAdvanceLimit(java.math.BigDecimal cashAdvanceLimit) {
        this.cashAdvanceLimit = cashAdvanceLimit;
    }

    public Integer getPointsAvailable() {
        return pointsAvailable;
    }

    public void setPointsAvailable(Integer pointsAvailable) {
        this.pointsAvailable = pointsAvailable;
    }

    public String getNextStatementClosingDate() {
        return nextStatementClosingDate;
    }

    public void setNextStatementClosingDate(String nextStatementClosingDate) {
        this.nextStatementClosingDate = nextStatementClosingDate;
    }


}
