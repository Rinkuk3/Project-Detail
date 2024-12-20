package com.td.mbna.msec.midtier.statement.payload;

import java.io.Serializable;

public class HistoryStatementListType implements Serializable
{
	private final static long serialVersionUID = -3992150087671425884L;

    private String documentId;
    private String statementDate;
    private String loadDate;
    private InsertListType insertList;
    private String accountNumber;
    private Boolean valid;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(String statementDate) {
        this.statementDate = statementDate;
    }

    public String getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(String loadDate) {
        this.loadDate = loadDate;
    }

    public InsertListType getInsertList() {
        return insertList;
    }

    public void setInsertList(InsertListType insertList) {
        this.insertList = insertList;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

}
