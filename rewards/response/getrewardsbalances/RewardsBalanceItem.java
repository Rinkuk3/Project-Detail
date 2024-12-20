package com.td.api.rewards.response.getrewardsbalances;

public class RewardsBalanceItem {
	private String loyaltyUnitOfMeasureCd;
	private Long availableBalanceQty;
	
	public String getLoyaltyUnitOfMeasureCd() {
		return loyaltyUnitOfMeasureCd;
	}

	public void setLoyaltyUnitOfMeasureCd(String loyaltyUnitOfMeasureCd) {
		this.loyaltyUnitOfMeasureCd = loyaltyUnitOfMeasureCd;
	}

	public Long getAvailableBalanceQty() {
		return availableBalanceQty;
	}

	public void setAvailableBalanceQty(Long availableBalanceQty) {
		this.availableBalanceQty = availableBalanceQty;
	}
}
