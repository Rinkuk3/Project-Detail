package com.td.mbna.msec.midtier.customerprofile.payload;

import java.io.Serializable;

public class CustomerAcctProfileType implements Serializable {

	private static final long serialVersionUID = -5122110403609771233L;
	
    private CustomerInfoType custInfo;
    private CustomerAcctInfoType acctInfo;

    public CustomerInfoType getCustInfo() {
        return custInfo;
    }

    public void setCustInfo(CustomerInfoType custInfo) {
        this.custInfo = custInfo;
    }

    public CustomerAcctInfoType getAcctInfo() {
        return acctInfo;
    }

    public void setAcctInfo(CustomerAcctInfoType acctInfo) {
        this.acctInfo = acctInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CustomerAcctProfileType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("custInfo");
        sb.append('=');
        sb.append(((this.custInfo == null)?"<null>":this.custInfo));
        sb.append(',');
        sb.append("acctInfo");
        sb.append('=');
        sb.append(((this.acctInfo == null)?"<null>":this.acctInfo));
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
        result = ((result* 31)+((this.custInfo == null)? 0 :this.custInfo.hashCode()));
        result = ((result* 31)+((this.acctInfo == null)? 0 :this.acctInfo.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerAcctProfileType) == false) {
            return false;
        }
        CustomerAcctProfileType rhs = ((CustomerAcctProfileType) other);
        return (((this.custInfo == rhs.custInfo)||((this.custInfo!= null)&&this.custInfo.equals(rhs.custInfo)))&&((this.acctInfo == rhs.acctInfo)||((this.acctInfo!= null)&&this.acctInfo.equals(rhs.acctInfo))));
    }

}
