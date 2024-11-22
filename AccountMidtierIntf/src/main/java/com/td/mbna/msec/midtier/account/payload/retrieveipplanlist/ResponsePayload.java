package com.td.mbna.msec.midtier.account.payload.retrieveipplanlist;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ResponsePayload implements Serializable
{
	private static final long serialVersionUID = 3197170174548022775L;

	public ResponsePayload() {
    	totalRemainingBalance = BigDecimal.ZERO;
    	activePlans = new ArrayList<IpPlanDetail>();
    	inactivePlans = new ArrayList<IpPlanDetail>();
    }

	private BigDecimal totalRemainingBalance;
    private List<IpPlanDetail> activePlans;
    private List<IpPlanDetail> inactivePlans;
    
	public BigDecimal getTotalRemainingBalance() {
		return totalRemainingBalance;
	}

	public void setTotalRemainingBalance(BigDecimal totalRemainingBalance) {
		this.totalRemainingBalance = totalRemainingBalance;
	}

	public List<IpPlanDetail> getActivePlans() {
		return activePlans;
	}

	public void setActivePlans(List<IpPlanDetail> activePlans) {
		this.activePlans = activePlans;
	}

	public List<IpPlanDetail> getInactivePlans() {
		return inactivePlans;
	}

	public void setInactivePlans(List<IpPlanDetail> inactivePlans) {
		this.inactivePlans = inactivePlans;
	}

}
