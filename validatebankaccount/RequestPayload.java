package com.td.mbna.msec.midtier.autopay.payload.validatebankaccount;

public class RequestPayload {

	private String bankNum;
	private String branchNum;
	private String bankAccount;

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
	
}

