package com.td.mbna.msec.midtier.eligibility.payload.getentitlementflags;

import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.types.common.CustAcctType;

public class RequestPayload {

    private String custId;
    private String connectId;
    private List<CustAcctType> enrolledAccts = new ArrayList<CustAcctType>();

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getConnectId() {
        return connectId;
    }

    public void setConnectId(String connectId) {
        this.connectId = connectId;
    }

    public List<CustAcctType> getEnrolledAccts() {
        return enrolledAccts;
    }

    public void setEnrolledAccts(List<CustAcctType> enrolledAccts) {
        this.enrolledAccts = enrolledAccts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("custId");
        sb.append('=');
        sb.append(((this.custId == null)?"<null>":this.custId));
        sb.append(',');
        sb.append("connectId");
        sb.append('=');
        sb.append(((this.connectId == null)?"<null>":this.connectId));
        sb.append(',');
        sb.append("enrolledAccts");
        sb.append('=');
        sb.append(((this.enrolledAccts == null)?"<null>":this.enrolledAccts));
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
        result = ((result* 31)+((this.enrolledAccts == null)? 0 :this.enrolledAccts.hashCode()));
        result = ((result* 31)+((this.connectId == null)? 0 :this.connectId.hashCode()));
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
        return ((((this.custId == rhs.custId)||((this.custId!= null)&&this.custId.equals(rhs.custId)))&&((this.enrolledAccts == rhs.enrolledAccts)||((this.enrolledAccts!= null)&&this.enrolledAccts.equals(rhs.enrolledAccts))))&&((this.connectId == rhs.connectId)||((this.connectId!= null)&&this.connectId.equals(rhs.connectId))));
    }

}
