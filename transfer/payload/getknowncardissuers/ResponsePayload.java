package com.td.mbna.msec.midtier.transfer.payload.getknowncardissuers;

import java.util.ArrayList;
import java.util.List;

public class ResponsePayload {

    private List<String> cardIssuer = new ArrayList<String>();

    public List<String> getCardIssuer() {
        return cardIssuer;
    }

    public void setCardIssuer(List<String> cardIssuer) {
        this.cardIssuer = cardIssuer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ResponsePayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cardIssuer");
        sb.append('=');
        sb.append(((this.cardIssuer == null)?"<null>":this.cardIssuer));
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
        result = ((result* 31)+((this.cardIssuer == null)? 0 :this.cardIssuer.hashCode()));
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
        return ((this.cardIssuer == rhs.cardIssuer)||((this.cardIssuer!= null)&&this.cardIssuer.equals(rhs.cardIssuer)));
    }

}
