package com.td.mbna.msec.midtier.customerprofile.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomerProfileType implements Serializable {

	private static final long serialVersionUID = 7931764475224927985L;
    private CustomerInfoType custInfo;
    private List<CustomerAcctType> accounts = new ArrayList<>();

    public CustomerInfoType getCustInfo() {
        return custInfo;
    }

    public void setCustInfo(CustomerInfoType custInfo) {
        this.custInfo = custInfo;
    }

    public List<CustomerAcctType> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<CustomerAcctType> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CustomerProfileType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("custInfo");
        sb.append('=');
        sb.append(((this.custInfo == null)?"<null>":this.custInfo));
        sb.append(',');
        sb.append("accounts");
        sb.append('=');
        sb.append(((this.accounts == null)?"<null>":this.accounts));
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
        result = ((result* 31)+((this.accounts == null)? 0 :this.accounts.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerProfileType) == false) {
            return false;
        }
        CustomerProfileType rhs = ((CustomerProfileType) other);
        return (((this.custInfo == rhs.custInfo)||((this.custInfo!= null)&&this.custInfo.equals(rhs.custInfo)))&&((this.accounts == rhs.accounts)||((this.accounts!= null)&&this.accounts.equals(rhs.accounts))));
    }

}
