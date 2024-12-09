package com.td.mbna.msec.midtier.types.common;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class AuditInfo implements Serializable {

	private static final long serialVersionUID = -7589767871954922781L;
    private String connectId;
    @NotNull
    @NotBlank(message = "can not be null or blank")
    @Size(min=6,max=7,message = "must be between 6 to 7 characters")
    private String transactionCode;
    private String transactionStatus;
    private String paaSequence;
    private String groupAffinityCode;
    private String accountStatusCode;
    private String accountDelinquencyCode;
    private String operatingSystem;
    private String browser;
    private String url;
    private String serverID;
    private Boolean logLastLogin;
    private String description;
    private String cardEnding;
    private String cardStarting;
    private Long auditStartTime;
    private Long browserTime;
    private String browserLanguage;
    private String cardHolderRole;
    private String businessEventReason;

    public String getConnectId() {
        return connectId;
    }

    public void setConnectId(String connectId) {
        this.connectId = connectId;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getPaaSequence() {
        return paaSequence;
    }

    public void setPaaSequence(String paaSequence) {
        this.paaSequence = paaSequence;
    }

    public String getGroupAffinityCode() {
        return groupAffinityCode;
    }

    public void setGroupAffinityCode(String groupAffinityCode) {
        this.groupAffinityCode = groupAffinityCode;
    }

    public String getAccountStatusCode() {
        return accountStatusCode;
    }

    public void setAccountStatusCode(String accountStatusCode) {
        this.accountStatusCode = accountStatusCode;
    }

    public String getAccountDelinquencyCode() {
        return accountDelinquencyCode;
    }

    public void setAccountDelinquencyCode(String accountDelinquencyCode) {
        this.accountDelinquencyCode = accountDelinquencyCode;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServerID() {
        return serverID;
    }

    public void setServerID(String serverID) {
        this.serverID = serverID;
    }

    public Boolean getLogLastLogin() {
        return logLastLogin;
    }

    public void setLogLastLogin(Boolean logLastLogin) {
        this.logLastLogin = logLastLogin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCardEnding() {
        return cardEnding;
    }

    public void setCardEnding(String cardEnding) {
        this.cardEnding = cardEnding;
    }

    public String getCardStarting() {
        return cardStarting;
    }

    public void setCardStarting(String cardStarting) {
        this.cardStarting = cardStarting;
    }

    public Long getAuditStartTime() {
        return auditStartTime;
    }

    public void setAuditStartTime(long auditStartTime) {
        this.auditStartTime = auditStartTime;
    }

    public Long getBrowserTime() {
        return browserTime;
    }

    public void setBrowserTime(long browserTime) {
        this.browserTime = browserTime;
    }

    public String getBrowserLanguage() {
        return browserLanguage;
    }

    public void setBrowserLanguage(String browserLanguage) {
        this.browserLanguage = browserLanguage;
    }

    public String getCardHolderRole() {
        return cardHolderRole;
    }

    public void setCardHolderRole(String cardHolderRole) {
        this.cardHolderRole = cardHolderRole;
    }

    public String getBusinessEventReason() {
        return businessEventReason;
    }

    public void setBusinessEventReason(String businessEventReason) {
        this.businessEventReason = businessEventReason;
    }


}
