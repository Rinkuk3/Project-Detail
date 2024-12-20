package com.td.mbna.msec.midtier.statement.payload.updateStatementDeliveryPreferences;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.statement.payload.AcctDeliveryPreferenceType;
import com.td.mbna.msec.midtier.statement.payload.MultiAcctDeliveryPreferenceType;

public class ResponsePayload implements Serializable
{

	private final static long serialVersionUID = -6933215099578320995L;
    private AcctDeliveryPreferenceType acctDeliveryPreference;
    private List<MultiAcctDeliveryPreferenceType> multiAcctDiveryPrefRs = new ArrayList<>();

    public AcctDeliveryPreferenceType getAcctDeliveryPreference() {
        return acctDeliveryPreference;
    }

    public void setAcctDeliveryPreference(AcctDeliveryPreferenceType acctDeliveryPreference) {
        this.acctDeliveryPreference = acctDeliveryPreference;
    }

    public List<MultiAcctDeliveryPreferenceType> getMultiAcctDiveryPrefRs() {
        return multiAcctDiveryPrefRs;
    }

    public void setMultiAcctDiveryPrefRs(List<MultiAcctDeliveryPreferenceType> multiAcctDiveryPrefRs) {
        this.multiAcctDiveryPrefRs = multiAcctDiveryPrefRs;
    }

}
