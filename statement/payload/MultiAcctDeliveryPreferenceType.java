package com.td.mbna.msec.midtier.statement.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.types.common.AuditInfo;
import com.td.mbna.msec.midtier.types.common.DisclosureInfoType;
import com.td.mbna.msec.midtier.types.common.EmailNotificationInfoType;

public class MultiAcctDeliveryPreferenceType implements Serializable
{

	private final static long serialVersionUID = 1610712355289645635L;
    private String custId;
    private String aliasCustId;
    private AcctDeliveryPreferenceType acctDeliveryPreference;
    private List<DisclosureInfoType> disclosureInfo = null;
    private EmailNotificationInfoType emailNotificationInfo;
    private AuditInfo auditInfo;
    private Boolean status;
    private List<String> errorMsgs = new ArrayList<>();
    private String enrollmentStatus;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getAliasCustId() {
        return aliasCustId;
    }

    public void setAliasCustId(String aliasCustId) {
        this.aliasCustId = aliasCustId;
    }

    public AcctDeliveryPreferenceType getAcctDeliveryPreference() {
        return acctDeliveryPreference;
    }

    public void setAcctDeliveryPreference(AcctDeliveryPreferenceType acctDeliveryPreference) {
        this.acctDeliveryPreference = acctDeliveryPreference;
    }

    public List<DisclosureInfoType> getDisclosureInfo() {
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

    public AuditInfo getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(AuditInfo auditInfo) {
        this.auditInfo = auditInfo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<String> getErrorMsgs() {
        return errorMsgs;
    }

    public void setErrorMsgs(List<String> errorMsgs) {
        this.errorMsgs = errorMsgs;
    }

    public String getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(String enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

}
