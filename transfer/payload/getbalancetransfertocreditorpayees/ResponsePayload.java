package com.td.mbna.msec.midtier.transfer.payload.getbalancetransfertocreditorpayees;

import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.transfer.payload.BalanceTransferToCreditorPayeeType;

public class ResponsePayload {

    private List<BalanceTransferToCreditorPayeeType> payee = new ArrayList<BalanceTransferToCreditorPayeeType>();

    public List<BalanceTransferToCreditorPayeeType> getPayee() {
        return payee;
    }

    public void setPayee(List<BalanceTransferToCreditorPayeeType> payee) {
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
