package com.td.mbna.msec.midtier.statement.payload.getStatementListForYear;

import java.io.Serializable;
import java.util.List;

import com.td.mbna.msec.midtier.statement.payload.HistoryStatementListType;

public class ResponsePayload implements Serializable
{

	private final static long serialVersionUID = -6349142383707213829L;
    private List<HistoryStatementListType> historyStatementList = null;

    public List<HistoryStatementListType> getHistoryStatementList() {
        return historyStatementList;
    }

    public void setHistoryStatementList(List<HistoryStatementListType> historyStatementList) {
        this.historyStatementList = historyStatementList;
    }

}
