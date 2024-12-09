package com.td.mbna.msec.midtier.types.eligibility;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustEligType implements Serializable {

	private static final long serialVersionUID = 122034523489117652L;
    private String custId;
    private List<EligType> custElig = new ArrayList<EligType>();

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public List<EligType> getCustElig() {
        return custElig;
    }

    public void setCustElig(List<EligType> custElig) {
        this.custElig = custElig;
    }
    
    private List<AcctEligType> acctsElig = new ArrayList<AcctEligType>();

    public List<AcctEligType> getAcctsElig() {
        return acctsElig;
    }

    public void setAcctsElig(List<AcctEligType> acctsElig) {
        this.acctsElig = acctsElig;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CustEligType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("custId");
        sb.append('=');
        sb.append(((this.custId == null)?"<null>":this.custId));
        sb.append(',');
        sb.append("custElig");
        sb.append('=');
        sb.append(((this.custElig == null)?"<null>":this.custElig));
        sb.append(',');
        sb.append("acctsElig");
        sb.append('=');
        sb.append(((this.acctsElig == null)?"<null>":this.acctsElig));
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
        int result = 1;
        result = ((result* 31)+((this.custId == null)? 0 :this.custId.hashCode()));
        result = ((result* 31)+((this.custElig == null)? 0 :this.custElig.hashCode()));
        result = ((result* 31)+((this.acctsElig == null)? 0 :this.acctsElig.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustEligType) == false) {
            return false;
        }
        CustEligType rhs = ((CustEligType) other);
		return (((this.custId == rhs.custId) || ((this.custId != null) && this.custId
				.equals(rhs.custId))) && ((this.custElig == rhs.custElig) || ((this.custElig != null) && this.custElig
				.equals(rhs.custElig))) && 
				((this.acctsElig == rhs.acctsElig) || ((this.acctsElig != null) && this.acctsElig
						.equals(rhs.acctsElig)))
				);
    }

}
