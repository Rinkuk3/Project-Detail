package com.td.mbna.msec.midtier.autopay.payload.retrievepad;

public class ResponsePayload {

	private String cardNum;
	private String accountNum;
	private String bankNum;
	private String branchNum;
	private String bankAccount;
	private String timePeriodCd;
	private String paymentTypeName;
	private String chequingAgreementHolderFullName;
	private String branchAddressTxt;
	private String statusCd;
	
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

	public String getBranchAddressTxt() {
		return branchAddressTxt;
	}

	public void setBranchAddressTxt(String branchAddressTxt) {
		this.branchAddressTxt = branchAddressTxt;
	}

	public String getStatusCd() {
		return statusCd;
	}

	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}

}
