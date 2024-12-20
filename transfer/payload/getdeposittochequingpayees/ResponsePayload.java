package com.td.mbna.msec.midtier.transfer.payload.getdeposittochequingpayees;

import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.transfer.payload.DepositToChequingPayeeType;

public class ResponsePayload {

    private List<DepositToChequingPayeeType> payee = new ArrayList<DepositToChequingPayeeType>();

    public List<DepositToChequingPayeeType> getPayee() {
        return payee;
    }

    public void setPayee(List<DepositToChequingPayeeType> payee) {
        this.payee = payee;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ResponsePayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("payee");
        sb.append('=');
        sb.append(((this.payee == null)?"<null>":this.payee));
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
        result = ((result* 31)+((this.payee == null)? 0 :this.payee.hashCode()));
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
        return ((this.payee == rhs.payee)||((this.payee!= null)&&this.payee.equals(rhs.payee)));
    }

}
