package com.td.mbna.msec.midtier.statement.payload;

import java.io.Serializable;

public class StmtOnlineSummaryType implements Serializable
{

	private final static long serialVersionUID = 4130496990659384221L;
    private String acctEnding;
    private String statementClosingDate;
    private java.math.BigDecimal creditLimit;
    private java.math.BigDecimal cacheAdvanceLimit;
    private java.math.BigDecimal creditAvailable;
    private java.math.BigDecimal creditAdvanceAvailable;
    private Integer daysInBillingCycle;
    private java.math.BigDecimal totalMinimumPaymentDue;
    private String totalMinimumPaymentDueDate;

    public String getAcctEnding() {
        return acctEnding;
    }

    public void setAcctEnding(String acctEnding) {
        this.acctEnding = acctEnding;
    }

    public String getStatementClosingDate() {
        return statementClosingDate;
    }

    public void setStatementClosingDate(String statementClosingDate) {
        this.statementClosingDate = statementClosingDate;
    }

    public java.math.BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(java.math.BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public java.math.BigDecimal getCacheAdvanceLimit() {
        return cacheAdvanceLimit;
    }

    public void setCacheAdvanceLimit(java.math.BigDecimal cacheAdvanceLimit) {
        this.cacheAdvanceLimit = cacheAdvanceLimit;
    }

    public java.math.BigDecimal getCreditAvailable() {
        return creditAvailable;
    }

    public void setCreditAvailable(java.math.BigDecimal creditAvailable) {
        this.creditAvailable = creditAvailable;
    }

    public java.math.BigDecimal getCreditAdvanceAvailable() {
        return creditAdvanceAvailable;
    }

    public void setCreditAdvanceAvailable(java.math.BigDecimal creditAdvanceAvailable) {
        this.creditAdvanceAvailable = creditAdvanceAvailable;
    }

    public Integer getDaysInBillingCycle() {
        return daysInBillingCycle;
    }

    public void setDaysInBillingCycle(Integer daysInBillingCycle) {
        this.daysInBillingCycle = daysInBillingCycle;
    }

    public java.math.BigDecimal getTotalMinimumPaymentDue() {
        return totalMinimumPaymentDue;
    }

    public void setTotalMinimumPaymentDue(java.math.BigDecimal totalMinimumPaymentDue) {
        this.totalMinimumPaymentDue = totalMinimumPaymentDue;
    }

    public String getTotalMinimumPaymentDueDate() {
        return totalMinimumPaymentDueDate;
    }

    public void setTotalMinimumPaymentDueDate(String totalMinimumPaymentDueDate) {
        this.totalMinimumPaymentDueDate = totalMinimumPaymentDueDate;
    }

}
