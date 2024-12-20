package com.td.mbna.msec.midtier.statement.payload.getAvailableStatementList;

import java.io.Serializable;
import java.util.List;

import com.td.mbna.msec.midtier.statement.payload.HistoryStatementListType;
import com.td.mbna.msec.midtier.statement.payload.StatementActivityStatusType;

public class AvailableStatementListType implements Serializable
{

	private final static long serialVersionUID = 9085788228235215182L;
    private List<String> statementEndDate = null;
    private List<HistoryStatementListType> statementInfo = null;
    private List<StatementActivityStatusType> statementActivityStatus = null;
    private java.math.BigDecimal hardCopyRate;

    public List<String> getStatementEndDate() {
        return statementEndDate;
    }

    public void setStatementEndDate(List<String> statementEndDate) {
        this.statementEndDate = statementEndDate;
    }

    public List<HistoryStatementListType> getStatementInfo() {
        return statementInfo;
    }

    public void setStatementInfo(List<HistoryStatementListType> statementInfo) {
        this.statementInfo = statementInfo;
    }

    public List<StatementActivityStatusType> getStatementActivityStatus() {
        return statementActivityStatus;
    }

    public void setStatementActivityStatus(List<StatementActivityStatusType> statementActivityStatus) {
        this.statementActivityStatus = statementActivityStatus;
    }

    public java.math.BigDecimal getHardCopyRate() {
        return hardCopyRate;
    }

    public void setHardCopyRate(java.math.BigDecimal hardCopyRate) {
        this.hardCopyRate = hardCopyRate;
    }

}
