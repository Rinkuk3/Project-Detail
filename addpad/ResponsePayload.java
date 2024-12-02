package com.td.mbna.msec.midtier.autopay.payload.addpad;

public class ResponsePayload {

    private String arrangementId;
    private String bankNameEn;
    private String bankNameFr;
    
	public String getArrangementId() {
		return arrangementId;
	}

	public void setArrangementId(String arrangementId) {
		this.arrangementId = arrangementId;
	}

	public String getBankNameEn() {
		return bankNameEn;
	}

	public void setBankNameEn(String bankNameEn) {
		this.bankNameEn = bankNameEn;
	}

	public String getBankNameFr() {
		return bankNameFr;
	}

	public void setBankNameFr(String bankNameFr) {
		this.bankNameFr = bankNameFr;
	}


}

