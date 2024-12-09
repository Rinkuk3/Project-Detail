package com.td.mbna.msec.midtier.customerprofile.payload.retrievecapd;

import java.util.List;

public class ResponsePayload {

    private String partyId;
    private List<CapdAccount> capdAccounts;
    
	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public List<CapdAccount> getCapdAccounts() {
		return capdAccounts;
	}

	public void setCapdAccounts(List<CapdAccount> capdAccounts) {
		this.capdAccounts = capdAccounts;
	}

	public CapdAccount getCapdAccountById(String accountId){
		if (accountId == null || capdAccounts == null || capdAccounts.isEmpty()){
			return null;
		}
		
		for (CapdAccount o: capdAccounts){
			if (accountId.equalsIgnoreCase(o.getaccountId())){
				return o;
			}
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return "ResponsePayload [partyId=" + partyId + ", capdAccounts="
				+ capdAccounts + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((capdAccounts == null) ? 0 : capdAccounts.hashCode());
		result = prime * result + ((partyId == null) ? 0 : partyId.hashCode());
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
		ResponsePayload other = (ResponsePayload) obj;
		if (capdAccounts == null) {
			if (other.capdAccounts != null)
				return false;
		} else if (!capdAccounts.equals(other.capdAccounts))
			return false;
		if (partyId == null) {
			if (other.partyId != null)
				return false;
		} else if (!partyId.equals(other.partyId))
			return false;
		return true;
	}
 
    
}
