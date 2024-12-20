package com.td.mbna.msec.midtier.transfer.payload.updatebalancetransfertocreditorpayee;

import com.td.mbna.msec.midtier.transfer.payload.BalanceTransferToCreditorPayeeType;

public class RequestPayload {

    private String currentNickname;
    private BalanceTransferToCreditorPayeeType payee;

    public String getCurrentNickname() {
        return currentNickname;
    }

    public void setCurrentNickname(String currentNickname) {
        this.currentNickname = currentNickname;
    }

    public BalanceTransferToCreditorPayeeType getPayee() {
        return payee;
    }

    public void setPayee(BalanceTransferToCreditorPayeeType payee) {
        this.payee = payee;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("currentNickname");
        sb.append('=');
        sb.append(((this.currentNickname == null)?"<null>":this.currentNickname));
        sb.append(',');
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
        result = ((result* 31)+((this.currentNickname == null)? 0 :this.currentNickname.hashCode()));
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
        return (((this.payee == rhs.payee)||((this.payee!= null)&&this.payee.equals(rhs.payee)))&&((this.currentNickname == rhs.currentNickname)||((this.currentNickname!= null)&&this.currentNickname.equals(rhs.currentNickname))));
    }

}
