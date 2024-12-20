package com.td.api.rewards.response.getrewardsbalances;

public class RewardsBalanceDTO {
	private Long value;
	private String rewardscurrency;

	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	
	public String getRewardscurrency() {
		return rewardscurrency;
	}
	public void setRewardscurrency(String rewardscurrency) {
		this.rewardscurrency = rewardscurrency;
	}
	
	@Override
	public String toString() {
		return "RewardsBalanceDTO [value=" + value + ", rewardscurrency="
				+ rewardscurrency + "]";
	}
}
