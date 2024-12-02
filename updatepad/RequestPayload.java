package com.td.mbna.msec.midtier.autopay.payload.updatepad;

public class RequestPayload {

    private String arrangementId;
	private String cardNum;
	private String accountNum;
	private String bankNum;
	private String branchNum;
	private String bankAccount;
	private String timePeriodCd;
	private String paymentTypeName;
	private String chequingAgreementHolderFullName;

	public String getArrangementId() {
		return arrangementId;
	}

	public void setArrangementId(String arrangementId) {
		this.arrangementId = arrangementId;
	}

	public String getCardNum() {
		return cardNum;
	}
	
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	
	public String getAccountNum() {
		return accountNum;
	}
	
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	public String getBankNum() {
		return bankNum;
	}
	
	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}
	
	public String getBranchNum() {
		return branchNum;
	}
	
	public void setBranchNum(String branchNum) {
		this.branchNum = branchNum;
	}
	
	public String getBankAccount() {
		return bankAccount;
	}
	
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	public String getTimePeriodCd() {
		return timePeriodCd;
	}
	
	public void setTimePeriodCd(String timePeriodCd) {
		this.timePeriodCd = timePeriodCd;
	}
	
	public String getPaymentTypeName() {
		return paymentTypeName;
	}
	
	public void setPaymentTypeName(String paymentTypeName) {
		this.paymentTypeName = paymentTypeName;
	}
	
	public String getChequingAgreementHolderFullName() {
		return chequingAgreementHolderFullName;
	}
	
	public void setChequingAgreementHolderFullName(String chequingAgreementHolderFullName) {
		this.chequingAgreementHolderFullName = chequingAgreementHolderFullName;
	}


}

