package com.td.mbna.msec.midtier.auditlog.payload.request;

import java.math.BigDecimal;

public class RequestPayload {

    private String status;
    private BigDecimal btAmt;
   

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getBtAmt() {
        return btAmt;
    }

    public void setBtAmt(BigDecimal btAmt) {
        this.btAmt = btAmt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("btAmt");
        sb.append('=');
        sb.append(((this.btAmt == null)?"<null>":this.btAmt));
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
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        result = ((result* 31)+((this.btAmt == null)? 0 :this.btAmt.hashCode()));
       
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
        return ((((((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status)))&&((this.btAmt == rhs.btAmt)||((this.btAmt!= null)&&this.btAmt.equals(rhs.btAmt)))))));
    }

}
