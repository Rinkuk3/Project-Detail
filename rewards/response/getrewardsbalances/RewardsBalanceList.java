package com.td.api.rewards.response.getrewardsbalances;

import java.util.Collections;
import java.util.List;

public class RewardsBalanceList {
	private List<RewardsBalanceItem> availableBalance = Collections.emptyList();

	public List<RewardsBalanceItem> getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(List<RewardsBalanceItem> availableBalance) {
		this.availableBalance = availableBalance;
	}
	
}
