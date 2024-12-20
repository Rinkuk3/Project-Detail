package com.td.mbna.msec.midtier.services;

import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.types.common.PrimaryCardMemberInfo;
import com.td.mbna.msec.midtier.util.MbnaLogger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class EmailInfoImpl implements EmailInfo {
	
	private static MbnaLogger logger = new MbnaLogger(EmailInfoImpl.class);
	// By default the trigger is set to 'false'. Any operation that will implement this will have to set the trigger to true and populate other fields for EmailInfoImpl.
	private boolean triggerEmailNotification = false;
	private String businessEventID = "";
	private String primaryEmailAddress = "";
	private String primaryLanguagePref = "";
	private String accountFirstName = "";
	private String accountLastName = "";
	private PrimaryCardMemberInfo primaryUserInfo = null;
	private String cardName = "";
	private String cardEnding = "";
	private String confirmationNumber = "";
	private List<String> confirmationNumbers = null;
	private String initiatedBy = "";
	private String oldEmailAddress = "";
	private String statementDeliveryPreferenceSelected = "";
	private Map<String, Object> attributes = new HashMap<>();
	private String logonId = "";
	private String connectId = "";
	
	private String custId = "";
	private String acctNum = "";
	private String token = "";
	private Consumer retryLogic;
	
	

	public EmailInfoImpl(){
	}

	public EmailInfoImpl(com.td.mbna.msec.midtier.types.common.EmailNotificationInfoType notificationInfo, String logonId, String businessEventID, boolean isPrimaryUser){
		if (notificationInfo == null){
			logEmailInfo(logonId, businessEventID);
			return;
		}
		
		logger.toJson(notificationInfo);
		this.logonId = logonId;
		setTriggerEmailNotification(notificationInfo.getSendEmail() == null ? false : notificationInfo.getSendEmail().booleanValue());
		setBusinessEventID(businessEventID);
		setPrimaryEmailAddress(notificationInfo.getPrimaryUserEmailAddress());
		setPrimaryLanguagePref(notificationInfo.getPrimaryUserLanguage());
		
		if (notificationInfo.getCurrentUserFirstName() != null && notificationInfo.getCurrentUserLastName() != null){
			setAccountFirstName(notificationInfo.getCurrentUserFirstName());
			setAccountLastName(notificationInfo.getCurrentUserLastName());
		} else {
			setAccountFirstName(notificationInfo.getPrimaryUserFirstName());
			setAccountLastName(notificationInfo.getPrimaryUserMiddleName());
		}
		
		PrimaryCardMemberInfo primaryUserInfo = new PrimaryCardMemberInfo();
		primaryUserInfo.setFirstName(notificationInfo.getPrimaryUserFirstName());
		primaryUserInfo.setMiddleName(notificationInfo.getPrimaryUserMiddleName());
		primaryUserInfo.setLastName(notificationInfo.getPrimaryUserLastName());
		setPrimaryUserInfo(primaryUserInfo);

		setCardName(notificationInfo.getCardName());
		setCardEnding(notificationInfo.getCardEnding());
		
		setCustId(notificationInfo.getPrimaryCustId());

		if (isPrimaryUser){
			if(getPrimaryLanguagePref().equals(IMBNAConstants.LANG_ENGLISH)){
				setInitiatedBy(IMBNAConstants.USER_PRINCIPAL);
			}else{
				setInitiatedBy(IMBNAConstants.USER_PRINCIPAL_FRENCH);
			}
			return;
		}
		
		if(getPrimaryLanguagePref()!=null && getPrimaryLanguagePref().equals(IMBNAConstants.LANG_ENGLISH)){
			setInitiatedBy(IMBNAConstants.USER_AUTHORIZED);
		}else{
			setInitiatedBy(IMBNAConstants.USER_AUTHORIZED_FRENCH);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmailInfoImpl [triggerEmailNotification=" + triggerEmailNotification
				+ ", businessEventID=" + businessEventID
				+ ", logonId=" + logonId
				+ ", primaryEmailAddress=" + primaryEmailAddress
				+ ", primaryLanguagePref=" + primaryLanguagePref
				+ ", primaryUserInfo=" + primaryUserInfo
				+ ", cardName=" + cardName
				+ ", cardEnding=" + cardEnding
				+ ", confirmationNumbers=" + this.getConfirmationNumbersString()
				+ ", initiatedBy=" + initiatedBy
				+ ", oldEmailAddress=" + oldEmailAddress
				+ ", statementDeliveryPreferenceSelected=" + statementDeliveryPreferenceSelected
				+ ", attributes=" + attributes
				+ "]";
	}

	@Override
	public String getLogonId() {
		return logonId;
	}

	public void setLogonId(String logonId) {
		this.logonId = logonId;
	}

	
	@Override
	public String getConnectId() {
		return connectId;
	}

	public void setConnectId(String connectId) {
		this.connectId = connectId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}

	@Override
	public String getToken() {
		return token;
	}

	@Override
	public void setToken(String token) {
		this.token = token;
	}

	public boolean isTriggerEmailNotification() {
		return triggerEmailNotification;
	}

	public void setTriggerEmailNotification(boolean triggerEmailNotification) {
		this.triggerEmailNotification = triggerEmailNotification;
	}

	public String getBusinessEventID() {
		return businessEventID;
	}

	public void setBusinessEventID(String businessEventID) {
		this.businessEventID = businessEventID;
	}

	public String getPrimaryEmailAddress() {
		return primaryEmailAddress;
	}

	public void setPrimaryEmailAddress(String primaryEmailAddress) {
		this.primaryEmailAddress = primaryEmailAddress;
	}

	public String getPrimaryLanguagePref() {
		return primaryLanguagePref;
	}

	public void setPrimaryLanguagePref(String primaryLanguagePref) {
		this.primaryLanguagePref = primaryLanguagePref;
	}

	public String getAccountFirstName() {
		return accountFirstName;
	}

	public void setAccountFirstName(String accountFirstName) {
		this.accountFirstName = accountFirstName;
	}

	public String getAccountLastName() {
		return accountLastName;
	}

	public void setAccountLastName(String accountLastName) {
		this.accountLastName = accountLastName;
	}

	public PrimaryCardMemberInfo getPrimaryUserInfo() {
		return primaryUserInfo;
	}

	public void setPrimaryUserInfo(PrimaryCardMemberInfo primaryUserInfo) {
		this.primaryUserInfo = primaryUserInfo;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardEnding() {
		return cardEnding;
	}

	public void setCardEnding(String cardEnding) {
		this.cardEnding = cardEnding;
	}
	
	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	public List<String> getConfirmationNumbers() {
		return confirmationNumbers;
	}

	public void setConfirmationNumbers(List<String> confirmationNumbers) {
		this.confirmationNumbers = confirmationNumbers;
	}

	public String getInitiatedBy() {
		return initiatedBy;
	}

	public void setInitiatedBy(String initiatedBy) {
		this.initiatedBy = initiatedBy;
	}

	public String getOldEmailAddress() {
		return oldEmailAddress;
	}

	public void setOldEmailAddress(String oldEmailAddress) {
		this.oldEmailAddress = oldEmailAddress;
	}

	public String getStatementDeliveryPreferenceSelected() {
		return statementDeliveryPreferenceSelected;
	}

	@Override
	public Object getAttribute(String key) {
		return attributes.get(key);
	}

	@Override
	public void addAttribute(String key, Object value) {
		attributes.put(key, value);
	}

	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	@Override
	public <T> Consumer<T> getRetryLogic() {
		return retryLogic;
	}

	@Override
	public <T> void setRetryLogic(Consumer<T> retry) {
		retryLogic = retry;
	}

	public void setStatementDeliveryPreferenceSelected(
			String statementDeliveryPreferenceSelected) {
		this.statementDeliveryPreferenceSelected = statementDeliveryPreferenceSelected;
	}
	
	private String getConfirmationNumbersString() {
		
		if(this.getConfirmationNumbers() != null && this.getConfirmationNumbers().size() > 0) {
			
			String confirmationNumbersString = "";
			
			for(String confirmationNumber : this.getConfirmationNumbers()) {
				confirmationNumbersString = confirmationNumbersString.concat(confirmationNumber + "-");
			}
			
			confirmationNumbersString = confirmationNumbersString.substring(0, confirmationNumbersString.lastIndexOf("-"));
			
			return confirmationNumbersString;
		}
		return this.getConfirmationNumber();
				
	}

    private static final String EMAIL_INFO_LOG_FORMAT = "%n==SEND EMAIL FAILED INFO START==%nloginId: %s%nbusinessEventId: %s%n==SEND EMAIL FAILED INFO END==";
    private static void logEmailInfo(String loginId, String businessEventID) {
        logger.error(String.format(EMAIL_INFO_LOG_FORMAT, loginId, businessEventID));
    }

}
