package com.td.mbna.msec.midtier.account.payload.getaccountsnapshot;

import java.io.Serializable;
import java.util.List;

import com.td.mbna.msec.midtier.types.common.AcctSnapshotType;
import com.td.mbna.msec.midtier.types.common.StmtActivityType;

public class ResponsePayload implements Serializable
{
	private final static long serialVersionUID = 7449954318069745871L;

    private AcctSnapshotType accountSnapshot;
    private List<StmtActivityType> statementActivities = null;
    private Boolean numActivitiesExceedsMax;

    public AcctSnapshotType getAccountSnapshot() {
        return accountSnapshot;
    }

    public void setAccountSnapshot(AcctSnapshotType accountSnapshot) {
        this.accountSnapshot = accountSnapshot;
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
