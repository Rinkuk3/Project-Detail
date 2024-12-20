package com.td.api.rewards.response.getrewardsbalances;

public class RewardsBalance {
	private RewardsBalanceDTO pending;
	private RewardsBalanceDTO available;
	
	public RewardsBalanceDTO getPending() {
		return pending;
	}
	public void setPending(RewardsBalanceDTO pending) {
		this.pending = pending;
	}
	
	public RewardsBalanceDTO getAvailable() {
		return available;
	}
	public void setAvailable(RewardsBalanceDTO available) {
		this.available = available;
	}
	
}
