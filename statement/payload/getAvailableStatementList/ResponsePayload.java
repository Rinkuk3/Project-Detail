package com.td.mbna.msec.midtier.statement.payload.getAvailableStatementList;

import java.io.Serializable;

public class ResponsePayload implements Serializable
{

    private AvailableStatementListType availableStatementList;
    private final static long serialVersionUID = 2781660945439164295L;

    public AvailableStatementListType getAvailableStatementList() {
        return availableStatementList;
    }

    public void setAvailableStatementList(AvailableStatementListType availableStatementList) {
        this.availableStatementList = availableStatementList;
    }

}
