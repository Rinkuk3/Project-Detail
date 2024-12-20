package com.td.api.mbcapd.request.retrievecapd;

import java.util.ArrayList;
import java.util.List;

public class AgreementInquiryRequest {

    private String partyKey;
    private List<String> agreementKey = new ArrayList<String>();

    public String getPartyKey() {
        return partyKey;
    }

    public void setPartyKey(String partyKey) {
        this.partyKey = partyKey;
    }

    public List<String> getAgreementKey() {
        return agreementKey;
    }

    public void setAgreementKey(List<String> agreementKey) {
        this.agreementKey = agreementKey;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AgreementInquiryRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("partyKey");
        sb.append('=');
        sb.append(((this.partyKey == null)?"<null>":this.partyKey));
        sb.append(',');
        sb.append("agreementKey");
        sb.append('=');
        sb.append(((this.agreementKey == null)?"<null>":this.agreementKey));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agreementKey == null) ? 0 : agreementKey.hashCode());
		result = prime * result + ((partyKey == null) ? 0 : partyKey.hashCode());
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
		AgreementInquiryRequest other = (AgreementInquiryRequest) obj;
		if (agreementKey == null) {
			if (other.agreementKey != null)
				return false;
		} else if (!agreementKey.equals(other.agreementKey))
			return false;
		if (partyKey == null) {
			if (other.partyKey != null)
				return false;
		} else if (!partyKey.equals(other.partyKey))
			return false;
		return true;
	}
}
