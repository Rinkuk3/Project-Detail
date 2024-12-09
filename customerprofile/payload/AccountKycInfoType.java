package com.td.mbna.msec.midtier.customerprofile.payload;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.types.common.CustAcctType;

public class AccountKycInfoType implements Serializable {

	private static final long serialVersionUID = 7253925742234555931L;
    private CustAcctType kycAcct;
    private CustomerAcctInfoType kycCustAcctInfo;
    private List<AccountKycAuInfoType> kycAuthorizeUsers = new ArrayList<AccountKycAuInfoType>();

    public CustAcctType getKycAcct() {
        return kycAcct;
    }

    public void setKycAcct(CustAcctType kycAcct) {
        this.kycAcct = kycAcct;
    }

    public CustomerAcctInfoType getKycCustAcctInfo() {
        return kycCustAcctInfo;
    }

    public void setKycCustAcctInfo(CustomerAcctInfoType kycCustAcctInfo) {
        this.kycCustAcctInfo = kycCustAcctInfo;
    }

    public List<AccountKycAuInfoType> getKycAuthorizeUsers() {
        return kycAuthorizeUsers;
    }

    public void setKycAuthorizeUsers(List<AccountKycAuInfoType> kycAuthorizeUsers) {
        this.kycAuthorizeUsers = kycAuthorizeUsers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AccountKycInfoType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("kycAcct");
        sb.append('=');
        sb.append(((this.kycAcct == null)?"<null>":this.kycAcct));
        sb.append(',');
        sb.append("kycCustAcctInfo");
        sb.append('=');
        sb.append(((this.kycCustAcctInfo == null)?"<null>":this.kycCustAcctInfo));
        sb.append(',');
        sb.append("kycAuthorizeUsers");
        sb.append('=');
        sb.append(((this.kycAuthorizeUsers == null)?"<null>":this.kycAuthorizeUsers));
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
        result = ((result* 31)+((this.kycCustAcctInfo == null)? 0 :this.kycCustAcctInfo.hashCode()));
        result = ((result* 31)+((this.kycAuthorizeUsers == null)? 0 :this.kycAuthorizeUsers.hashCode()));
        result = ((result* 31)+((this.kycAcct == null)? 0 :this.kycAcct.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AccountKycInfoType) == false) {
            return false;
        }
        AccountKycInfoType rhs = ((AccountKycInfoType) other);
        return ((((this.kycCustAcctInfo == rhs.kycCustAcctInfo)||((this.kycCustAcctInfo!= null)&&this.kycCustAcctInfo.equals(rhs.kycCustAcctInfo)))&&((this.kycAuthorizeUsers == rhs.kycAuthorizeUsers)||((this.kycAuthorizeUsers!= null)&&this.kycAuthorizeUsers.equals(rhs.kycAuthorizeUsers))))&&((this.kycAcct == rhs.kycAcct)||((this.kycAcct!= null)&&this.kycAcct.equals(rhs.kycAcct))));
    }

}
