package com.td.api.rewards.response.getrewardsbalances;

public class RewardsBalancesResponse {
	
	private String rewardsAccountStatus;
	private Boolean canRedeemRewards;
	private Boolean canEarnRewards;
	private RewardsBalance rewardsBalance;
	private AccountAttributes accountAttributes;
	
	public String getRewardsAccountStatus() {
		return rewardsAccountStatus;
	}
	public void setRewardsAccountStatus(String rewardsAccountStatus) {
		this.rewardsAccountStatus = rewardsAccountStatus;
	}
	
	public Boolean getCanRedeemRewards() {
		return canRedeemRewards;
	}
	public void setCanRedeemRewards(Boolean canRedeemRewards) {
		this.canRedeemRewards = canRedeemRewards;
	}
	
	public Boolean getCanEarnRewards() {
		return canEarnRewards;
	}
	public void setCanEarnRewards(Boolean canEarnRewards) {
		this.canEarnRewards = canEarnRewards;
	}
	
	public RewardsBalance getRewardsBalance() {
		return rewardsBalance;
	}
	public void setRewardsBalance(RewardsBalance rewardsBalance) {
		this.rewardsBalance = rewardsBalance;
	}
	
	public AccountAttributes getAccountAttributes() {
		return accountAttributes;
	}
	public void setAccountAttributes(AccountAttributes accountAttributes) {
		this.accountAttributes = accountAttributes;
	}

}
