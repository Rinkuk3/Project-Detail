package com.td.mbna.msec.midtier.statement.payload.updateStatementDeliveryPreferences;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.statement.payload.AcctDeliveryPreferenceType;
import com.td.mbna.msec.midtier.types.common.DisclosureInfoType;
import com.td.mbna.msec.midtier.statement.payload.MultiAcctDeliveryPreferenceType;
import com.td.mbna.msec.midtier.types.common.EmailNotificationInfoType;

public class RequestPayload implements Serializable
{

	private final static long serialVersionUID = -1342373712529263088L;
    private AcctDeliveryPreferenceType acctDeliveryPreference;
    private List<DisclosureInfoType> disclosureInfo = null;
    private EmailNotificationInfoType emailNotificationInfo;
    private List<MultiAcctDeliveryPreferenceType> multiAcctDiveryPrefRq = null;

    public AcctDeliveryPreferenceType getAcctDeliveryPreference() {
        return acctDeliveryPreference;
    }

    public void setAcctDeliveryPreference(AcctDeliveryPreferenceType acctDeliveryPreference) {
        this.acctDeliveryPreference = acctDeliveryPreference;
    }

    public List<DisclosureInfoType> getDisclosureInfo() {
        if (disclosureInfo == null) {
            disclosureInfo = new ArrayList<DisclosureInfoType>();
        }
        return disclosureInfo;
    }

    public void setDisclosureInfo(List<DisclosureInfoType> disclosureInfo) {
        this.disclosureInfo = disclosureInfo;
    }

    public EmailNotificationInfoType getEmailNotificationInfo() {
        return emailNotificationInfo;
    }

    public void setEmailNotificationInfo(EmailNotificationInfoType emailNotificationInfo) {
        this.emailNotificationInfo = emailNotificationInfo;
    }

    public List<MultiAcctDeliveryPreferenceType> getMultiAcctDiveryPrefRq() {
        if (multiAcctDiveryPrefRq == null) {
            multiAcctDiveryPrefRq = new ArrayList<MultiAcctDeliveryPreferenceType>();
        }
        return multiAcctDiveryPrefRq;
    }

    public void setMultiAcctDiveryPrefRq(List<MultiAcctDeliveryPreferenceType> multiAcctDiveryPrefRq) {
        this.multiAcctDiveryPrefRq = multiAcctDiveryPrefRq;
    }

}
