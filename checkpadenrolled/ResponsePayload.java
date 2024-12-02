package com.td.mbna.msec.midtier.autopay.payload.checkpadenrolled;

public class ResponsePayload {
	private boolean enrolledForPad;
	private boolean within90Days;
    private String arrangementId;
    private String statusCd;
    private String accountNum;
    
	public boolean isEnrolledForPad() {
		return enrolledForPad;
	}

	public void setEnrolledForPad(boolean enrolledForPad) {
		this.enrolledForPad = enrolledForPad;
	}

	public boolean isWithin90Days() {
		return within90Days;
	}

	public void setWithin90Days(boolean within90Days) {
		this.within90Days = within90Days;
	}

	public String getArrangementId() {
		return arrangementId;
	}

	public void setArrangementId(String arrangementId) {
		this.arrangementId = arrangementId;
	}

	public String getStatusCd() {
		return statusCd;
	}

	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

}

