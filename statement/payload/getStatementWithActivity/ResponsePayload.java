package com.td.mbna.msec.midtier.statement.payload.getStatementWithActivity;

import java.io.Serializable;
import java.util.List;

import com.td.mbna.msec.midtier.statement.payload.StmtOnlineSummaryType;
import com.td.mbna.msec.midtier.statement.payload.getAvailableStatementList.AvailableStatementListType;
import com.td.mbna.msec.midtier.types.common.StmtActivityType;

public class ResponsePayload implements Serializable
{

	private final static long serialVersionUID = 4331506409857229441L;
    private AvailableStatementListType availableStatementList;
    private StmtOnlineSummaryType onlineSummary;
    private List<StmtActivityType> statementActivities = null;
    private Boolean numActivitiesExceedsMax;

    public AvailableStatementListType getAvailableStatementList() {
        return availableStatementList;
    }

    public void setAvailableStatementList(AvailableStatementListType availableStatementList) {
        this.availableStatementList = availableStatementList;
    }

    public StmtOnlineSummaryType getOnlineSummary() {
        return onlineSummary;
    }

    public void setOnlineSummary(StmtOnlineSummaryType onlineSummary) {
        this.onlineSummary = onlineSummary;
    }

    public List<StmtActivityType> getStatementActivities() {
        return statementActivities;
    }

    public void setStatementActivities(List<StmtActivityType> statementActivities) {
        this.statementActivities = statementActivities;
    }

    public Boolean getNumActivitiesExceedsMax() {
        return numActivitiesExceedsMax;
    }

    public void setNumActivitiesExceedsMax(Boolean numActivitiesExceedsMax) {
        this.numActivitiesExceedsMax = numActivitiesExceedsMax;
    }

}
