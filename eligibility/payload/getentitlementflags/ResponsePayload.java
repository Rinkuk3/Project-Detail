package com.td.mbna.msec.midtier.eligibility.payload.getentitlementflags;

import com.td.mbna.msec.midtier.types.eligibility.CustEligType;

public class ResponsePayload {

    private CustEligType custElig;

    public CustEligType getCustElig() {
    	if(custElig == null){
    		custElig = new CustEligType();
    	}
        return custElig;
    }

    public void setCustElig(CustEligType custElig) {
        this.custElig = custElig;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ResponsePayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("custElig");
        sb.append('=');
        sb.append(((this.custElig == null)?"<null>":this.custElig));
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
        result = ((result* 31)+((this.custElig == null)? 0 :this.custElig.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResponsePayload) == false) {
            return false;
        }
        ResponsePayload rhs = ((ResponsePayload) other);
        return ((this.custElig == rhs.custElig)||((this.custElig!= null)&&this.custElig.equals(rhs.custElig)));
    }

}
