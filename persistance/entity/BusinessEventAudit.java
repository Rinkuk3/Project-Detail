package com.td.mbna.msec.midtier.persistance.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * This class corresponds to individual rows in the BUSINESSEVENTAUDIT table in the local database.
 *   
 */
public class BusinessEventAudit  implements Serializable {

	private static final long serialVersionUID = -282539079037011636L;
	private Integer auditID;
	private String connectId;
	private String mdmCifId;
	private Date startDateTime;
	private String deliveryChannelCode;
	private String sessionID;
	private String transactionType;
	private String transactionSubType;
	private String businessEvent;
	private String eventCode;
	private String applicationLogonID;
	private Long processingTime;
	private String applicationResponseCode;
	private String redactedCardNumber;
	private String paaTsysSequence;
	private String groupAffinityCode;
	private String accountStatusCode;
	private String accountDelinquencyCode;
	private BigDecimal balanceTransferAmount;
	private String operatingSystem;
	private String browser;
	private String customerIPAddress;
	private String url;
	private String serverID;
	private String language;
	private String browserLanguage;
	private Date browserTime;
	private String cardRole;
	private String tsysAccountId;
	private String businessEventReason;
	
	public Integer getAuditID() {
		return auditID;
	}
	public void setAuditID(Integer auditID) {
		this.auditID = auditID;
	}
	public String getConnectId() {
		return connectId;
	}
	public void setConnectId(String connectId) {
		this.connectId = connectId;
	}
	public String getMdmCifId() {
		return mdmCifId;
	}
	public void setMdmCifId(String mdmCifId) {
		this.mdmCifId = mdmCifId;
	}
	public Date getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}
	public String getDeliveryChannelCode() {
		return deliveryChannelCode;
	}
	public void setDeliveryChannelCode(String deliveryChannelCode) {
		this.deliveryChannelCode = this.truncate(deliveryChannelCode, 5);
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = this.truncate(transactionType, 5);
	}
	public String getTransactionSubType() {
		return transactionSubType;
	}
	public void setTransactionSubType(String transactionSubType) {
		this.transactionSubType = this.truncate(transactionSubType, 5);
	}
	public String getBusinessEvent() {
		return businessEvent;
	}
	public void setBusinessEvent(String businessEvent) {
		this.businessEvent = businessEvent;
	}
	public String getEventCode() {
		return eventCode;
	}
	public void setEventCode(String eventCode) {
		this.eventCode = this.truncate(eventCode, 10);
	}
	public String getApplicationLogonID() {
		return applicationLogonID;
	}
	public void setApplicationLogonID(String applicationLogonID) {
		this.applicationLogonID = applicationLogonID;
	}
	public Long getProcessingTime() {
		return processingTime;
	}
	public void setProcessingTime(Long processingTime) {
		this.processingTime = processingTime;
	}
	public String getApplicationResponseCode() {
		return applicationResponseCode;
	}
	public void setApplicationResponseCode(String applicationResponseCode) {
		this.applicationResponseCode = this.truncate(applicationResponseCode, 10);
	}
	public String getRedactedCardNumber() {
		return redactedCardNumber;
	}
	public void setRedactedCardNumber(String redactedCardNumber) {
		this.redactedCardNumber = redactedCardNumber;
	}
	public String getPaaTsysSequence() {
		return paaTsysSequence;
	}
	public void setPaaTsysSequence(String paaTsysSequence) {
		this.paaTsysSequence = paaTsysSequence;
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
	public BigDecimal getBalanceTransferAmount() {
		return balanceTransferAmount;
	}
	public void setBalanceTransferAmount(BigDecimal balanceTransferAmount) {
		this.balanceTransferAmount = balanceTransferAmount;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = this.truncate(this.replacePipe(operatingSystem),200);
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		browser = this.truncate(browser, 200);
		this.browser = this.replacePipe(browser);
	}
	public String getCustomerIPAddress() {
		return customerIPAddress;
	}
	public void setCustomerIPAddress(String customerIPAddress) {
		this.customerIPAddress = this.truncate(customerIPAddress, 15);
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = this.replacePipe(url);
	}
	public String getServerID() {
		return serverID;
	}
	public void setServerID(String serverID) {
		this.serverID = this.replacePipe(serverID);
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = this.truncate(language, 5);
	}
	public String getBrowserLanguage() {
		return browserLanguage;
	}
	public void setBrowserLanguage(String browserLanguage) {
		this.browserLanguage = this.truncate(browserLanguage, 5);
	}
	public Date getBrowserTime() {
		return browserTime;
	}
	public void setBrowserTime(Date browserTime) {
		this.browserTime = browserTime;
	}
	public String getCardRole() {
		return cardRole;
	}
	public void setCardRole(String cardRole) {
		this.cardRole = this.truncate(cardRole, 10);
	}
	
	public String getTsysAccountId() {
		return tsysAccountId;
	}
	
	public void setTsysAccountId(String tsysAccountId) {
		this.tsysAccountId = tsysAccountId;
	}
		
	public String getBusinessEventReason() {
		return businessEventReason;
	}
	
	public void setBusinessEventReason(String businessEventReason) {
		this.businessEventReason = this.truncate(businessEventReason, 30);
	}
	
	private String truncate(String value, int length) {
		if (value != null && value.length() > length) {
		    value = value.substring(0, length);
		}
		return value;
	}
	
	private String replacePipe(String value) {
		if(value != null && !value.isEmpty() && value.contains("|")) {
			value = value.replace("|", "-");
		}
		return value;
	}

	@Override
	public String toString() {
		return "BusinessEventAudit{" +
				"auditID=" + auditID +
				", connectId='" + connectId + '\'' +
				", mdmCifId='" + mdmCifId + '\'' +
				", startDateTime=" + startDateTime +
				", deliveryChannelCode='" + deliveryChannelCode + '\'' +
				", sessionID='" + sessionID + '\'' +
				", transactionType='" + transactionType + '\'' +
				", transactionSubType='" + transactionSubType + '\'' +
				", businessEvent='" + businessEvent + '\'' +
				", eventCode='" + eventCode + '\'' +
				", applicationLogonID='" + applicationLogonID + '\'' +
				", processingTime=" + processingTime +
				", applicationResponseCode='" + applicationResponseCode + '\'' +
				", redactedCardNumber='" + redactedCardNumber + '\'' +
				", paaTsysSequence='" + paaTsysSequence + '\'' +
				", groupAffinityCode='" + groupAffinityCode + '\'' +
				", accountStatusCode='" + accountStatusCode + '\'' +
				", accountDelinquencyCode='" + accountDelinquencyCode + '\'' +
				", balanceTransferAmount=" + balanceTransferAmount +
				", operatingSystem='" + operatingSystem + '\'' +
				", browser='" + browser + '\'' +
				", customerIPAddress='" + customerIPAddress + '\'' +
				", url='" + url + '\'' +
				", serverID='" + serverID + '\'' +
				", language='" + language + '\'' +
				", browserLanguage='" + browserLanguage + '\'' +
				", browserTime=" + browserTime +
				", cardRole='" + cardRole + '\'' +
				", tsysAccountId='" + tsysAccountId + '\'' +
				", businessEventReason='" + businessEventReason + '\'' +
				'}';
	}
}
