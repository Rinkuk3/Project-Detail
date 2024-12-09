package com.td.mbna.msec.midtier.types.eligibility;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AcctEligType implements Serializable {

	private static final long serialVersionUID = 1L;
    private String acctId;
    private List<EligType> acctElig = new ArrayList<EligType>();

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public List<EligType> getAcctElig() {
        return acctElig;
    }

    public void setAcctElig(List<EligType> acctElig) {
        this.acctElig = acctElig;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AcctEligType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("acctId");
        sb.append('=');
        sb.append(((this.acctId == null)?"<null>":this.acctId));
        sb.append(',');
        sb.append("acctElig");
        sb.append('=');
        sb.append(((this.acctElig == null)?"<null>":this.acctElig));
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
        result = ((result* 31)+((this.acctId == null)? 0 :this.acctId.hashCode()));
        result = ((result* 31)+((this.acctElig == null)? 0 :this.acctElig.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AcctEligType) == false) {
            return false;
        }
        AcctEligType rhs = ((AcctEligType) other);
        return (((this.acctId == rhs.acctId)||((this.acctId!= null)&&this.acctId.equals(rhs.acctId)))&&((this.acctElig == rhs.acctElig)||((this.acctElig!= null)&&this.acctElig.equals(rhs.acctElig))));
    }

}
