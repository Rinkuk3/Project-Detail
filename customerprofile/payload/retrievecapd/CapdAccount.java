package com.td.mbna.msec.midtier.customerprofile.payload.retrievecapd;

public class CapdAccount {

	private String accountId;
	private String overLimitPref;
	private String thresholdValue;
	private String thresholdPref;

	private String spendValue;

	private String spendPref;

	public String getaccountId() {
		return accountId;
	}
	public void setaccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getOverLimitPref() {
		return overLimitPref;
	}
	public void setOverLimitPref(String overLimitPref) {
		this.overLimitPref = overLimitPref;
	}
	public String getThresholdValue() {
		return thresholdValue;
	}
	public void setThresholdValue(String thresholdValue) {
		this.thresholdValue = thresholdValue;
	}
	public String getThresholdPref() {
		return thresholdPref;
	}
	public void setThresholdPref(String thresholdPref) {
		this.thresholdPref = thresholdPref;
	}

	public String getSpendValue() {
		return spendValue;
	}

	public void setSpendValue(String spendValue) {
		this.spendValue = spendValue;
	}

	public String getSpendPref() {
		return spendPref;
	}

	public void setSpendPref(String spendPref) {
		this.spendPref = spendPref;
	}

	@Override
	public String toString() {
		return "CapdAccount [accountId=" + accountId + ", overLimitPref="
				+ overLimitPref + ", thresholdValue=" + thresholdValue + ", spendValue=" + spendValue + ", spendPref=" + spendPref
				+ ", thresholdPref=" + thresholdPref + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result
				+ ((overLimitPref == null) ? 0 : overLimitPref.hashCode());
		result = prime * result
				+ ((thresholdPref == null) ? 0 : thresholdPref.hashCode());
		result = prime * result
				+ ((thresholdValue == null) ? 0 : thresholdValue.hashCode());
		result = prime * result
				+ ((spendValue == null) ? 0 : spendValue.hashCode());
		result = prime * result
				+ ((spendPref == null) ? 0 : spendPref.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CapdAccount other = (CapdAccount) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (overLimitPref == null) {
			if (other.overLimitPref != null)
				return false;
		} else if (!overLimitPref.equals(other.overLimitPref))
			return false;
		if (thresholdPref == null) {
			if (other.thresholdPref != null)
				return false;
		} else if (!thresholdPref.equals(other.thresholdPref))
			return false;
		if (thresholdValue == null) {
			if (other.thresholdValue != null)
				return false;
		} else if (!thresholdValue.equals(other.thresholdValue))
			return false;
		if (spendValue == null) {
			if (other.spendValue != null)
				return false;
		} else if (!spendValue.equals(other.spendValue))
			return false;
		if (spendPref == null) {
			if (other.spendPref != null)
				return false;
		} else if (!spendPref.equals(other.spendPref))
			return false;
		return true;
	}


}