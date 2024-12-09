package com.td.mbna.msec.midtier.customerprofile.payload.retrievecapd;

import java.util.ArrayList;
import java.util.List;

public class RequestPayload {

	private String custId;
    private List<String> acctIds;
    
    public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public List<String> getAcctIds() {
		if (acctIds == null){
			acctIds = new ArrayList<>();
		}
		return acctIds;
	}

	public void setAcctIds(List<String> acctIds) {
		this.acctIds = acctIds;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestPayload other = (RequestPayload) obj;
		if (acctIds == null) {
			if (other.acctIds != null)
				return false;
		} else if (!acctIds.equals(other.acctIds))
			return false;
		if (custId == null) {
			if (other.custId != null)
				return false;
		} else if (!custId.equals(other.custId))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acctIds == null) ? 0 : acctIds.hashCode());
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "RequestPayload [custId=" + custId + ", acctIds=" + acctIds
				+ "]";
	}
    
    
}
