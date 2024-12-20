package com.td.mbna.msec.midtier.statement.payload;

import com.td.mbna.msec.midtier.types.common.DeliveryPreferenceType;

import java.io.Serializable;

public class AcctDeliveryPreferenceType implements Serializable
{
	
	private final static long serialVersionUID = 3117313109296454557L;

    private String acctId;
    private String cardStarting;
    private String acctEnding;
    private String acctDesc;
    private String enrollmentStatus;
    private DeliveryPreferenceType acctDeliveryPreference;

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public String getCardStarting() {
        return cardStarting;
    }

    public void setCardStarting(String cardStarting) {
        this.cardStarting = cardStarting;
    }

    public String getAcctEnding() {
        return acctEnding;
    }

    public void setAcctEnding(String acctEnding) {
        this.acctEnding = acctEnding;
    }

    public String getAcctDesc() {
        return acctDesc;
    }

    public void setAcctDesc(String acctDesc) {
        this.acctDesc = acctDesc;
    }

    public String getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(String enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    public DeliveryPreferenceType getAcctDeliveryPreference() {
        return acctDeliveryPreference;
    }

    public void setAcctDeliveryPreference(DeliveryPreferenceType acctDeliveryPreference) {
        this.acctDeliveryPreference = acctDeliveryPreference;
    }

}
