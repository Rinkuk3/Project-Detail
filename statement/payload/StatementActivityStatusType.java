package com.td.mbna.msec.midtier.statement.payload;

import java.io.Serializable;

public class StatementActivityStatusType implements Serializable
{

	private final static long serialVersionUID = -6826058552792919780L;
    private String statementEndDate;
    private String statementPaymentDueDate;
    private Boolean activityAvailable;
    private java.math.BigDecimal statementBalance;

    public String getStatementEndDate() {
        return statementEndDate;
    }

    public void setStatementEndDate(String statementEndDate) {
        this.statementEndDate = statementEndDate;
    }

    public Boolean getActivityAvailable() {
        return activityAvailable;
    }

    public void setActivityAvailable(Boolean activityAvailable) {
        this.activityAvailable = activityAvailable;
    }

    public java.math.BigDecimal getStatementBalance() {
        return statementBalance;
    }

    public void setStatementBalance(java.math.BigDecimal statementBalance) {
        this.statementBalance = statementBalance;
    }

    public String getStatementPaymentDueDate() {
        return statementPaymentDueDate;
    }

    public void setStatementPaymentDueDate(String statementPaymentDueDate) {
        this.statementPaymentDueDate = statementPaymentDueDate;
    }
}
