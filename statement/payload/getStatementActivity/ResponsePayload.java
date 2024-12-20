package com.td.mbna.msec.midtier.statement.payload.getStatementActivity;

import java.util.List;

import com.td.mbna.msec.midtier.types.common.StmtActivityType;

public class ResponsePayload {

    private List<StmtActivityType> statementActivities = null;
    private Boolean numActivitiesExceedsMax;

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
