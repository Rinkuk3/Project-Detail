package com.td.mbna.msec.midtier.statement.payload.getStatementListForYear;

import java.io.Serializable;

public class RequestPayload implements Serializable
{

	private final static long serialVersionUID = 1069258276619414214L;
    private String statementSearchYear;

    public String getStatementSearchYear() {
        return statementSearchYear;
    }

    public void setStatementSearchYear(String statementSearchYear) {
        this.statementSearchYear = statementSearchYear;
    }

}
