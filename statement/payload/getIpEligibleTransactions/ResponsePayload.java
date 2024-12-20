package com.td.mbna.msec.midtier.statement.payload.getIpEligibleTransactions;

import com.td.mbna.msec.midtier.types.common.StmtActivityType;

import java.io.Serializable;
import java.util.List;

public class ResponsePayload implements Serializable {

	private static final long serialVersionUID = -2113554979617403312L;
	private List<StmtActivityType> ipEligibleTransactions = null;

    public List<StmtActivityType> getIpEligibleTransactions() {
        return ipEligibleTransactions;
    }

    public void setIpEligibleTransactions(List<StmtActivityType> ipEligibleTransactions) {
        this.ipEligibleTransactions = ipEligibleTransactions;
    }

    @Override
    public String toString() {
        return "ResponsePayload{" +
                "ipEligibleTransactions=" + ipEligibleTransactions +
                '}';
    }
}
