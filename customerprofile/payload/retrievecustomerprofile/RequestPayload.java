package com.td.mbna.msec.midtier.customerprofile.payload.retrievecustomerprofile;

import java.io.Serializable;

public class RequestPayload implements Serializable {

	private static final long serialVersionUID = 5231648932431736412L;
    private String custId;
    private String acctNum;
    private Boolean authorizedUser;
    private String callContext;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }

    public Boolean getAuthorizedUser() {
        return authorizedUser;
    }

    public void setAuthorizedUser(Boolean authorizedUser) {
        this.authorizedUser = authorizedUser;
    }

    public String getCallContext() {
        return callContext;
    }

    public void setCallContext(String callContext) {
        this.callContext = callContext;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("custId");
        sb.append('=');
        sb.append(((this.custId == null)?"<null>":this.custId));
        sb.append(',');
        sb.append("acctNum");
        sb.append('=');
        sb.append(((this.acctNum == null)?"<null>":this.acctNum));
        sb.append(',');
        sb.append("authorizedUser");
        sb.append('=');
        sb.append(((this.authorizedUser == null)?"<null>":this.authorizedUser));
        sb.append(',');
        sb.append("callContext");
        sb.append('=');
        sb.append(((this.callContext == null)?"<null>":this.callContext));
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
        result = ((result* 31)+((this.callContext == null)? 0 :this.callContext.hashCode()));
        result = ((result* 31)+((this.authorizedUser == null)? 0 :this.authorizedUser.hashCode()));
        result = ((result* 31)+((this.acctNum == null)? 0 :this.acctNum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestPayload) == false) {
            return false;
        }
        RequestPayload rhs = ((RequestPayload) other);
        return (((((this.custId == rhs.custId)||((this.custId!= null)&&this.custId.equals(rhs.custId)))&&((this.callContext == rhs.callContext)||((this.callContext!= null)&&this.callContext.equals(rhs.callContext))))&&((this.authorizedUser == rhs.authorizedUser)||((this.authorizedUser!= null)&&this.authorizedUser.equals(rhs.authorizedUser))))&&((this.acctNum == rhs.acctNum)||((this.acctNum!= null)&&this.acctNum.equals(rhs.acctNum))));
    }

}
