package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class AcctSnapshotStatusType implements Serializable {

	private static final long serialVersionUID = -5365356325448800943L;
    private String accountStatusCode;
    private String accountStatusReason;

    public String getAccountStatusCode() {
        return accountStatusCode;
    }

    public void setAccountStatusCode(String accountStatusCode) {
        this.accountStatusCode = accountStatusCode;
    }

    public String getAccountStatusReason() {
        return accountStatusReason;
    }

    public void setAccountStatusReason(String accountStatusReason) {
        this.accountStatusReason = accountStatusReason;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AcctSnapshotStatusType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("accountStatusCode");
        sb.append('=');
        sb.append(((this.accountStatusCode == null)?"<null>":this.accountStatusCode));
        sb.append(',');
        sb.append("accountStatusReason");
        sb.append('=');
        sb.append(((this.accountStatusReason == null)?"<null>":this.accountStatusReason));
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
        result = ((result* 31)+((this.accountStatusCode == null)? 0 :this.accountStatusCode.hashCode()));
        result = ((result* 31)+((this.accountStatusReason == null)? 0 :this.accountStatusReason.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AcctSnapshotStatusType) == false) {
            return false;
        }
        AcctSnapshotStatusType rhs = ((AcctSnapshotStatusType) other);
        return (((this.accountStatusCode == rhs.accountStatusCode)||((this.accountStatusCode!= null)&&this.accountStatusCode.equals(rhs.accountStatusCode)))&&((this.accountStatusReason == rhs.accountStatusReason)||((this.accountStatusReason!= null)&&this.accountStatusReason.equals(rhs.accountStatusReason))));
    }

}
