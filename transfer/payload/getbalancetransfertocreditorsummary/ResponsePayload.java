package com.td.mbna.msec.midtier.transfer.payload.getbalancetransfertocreditorsummary;

import com.td.mbna.msec.midtier.transfer.payload.BalanceTransferToCreditorSummaryType;

public class ResponsePayload {
    private BalanceTransferToCreditorSummaryType summary;

    public BalanceTransferToCreditorSummaryType getSummary() {
        return summary;
    }

    public void setSummary(BalanceTransferToCreditorSummaryType summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ResponsePayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("summary");
        sb.append('=');
        sb.append(((this.summary == null)?"<null>":this.summary));
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
        result = ((result* 31)+((this.summary == null)? 0 :this.summary.hashCode()));
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
        return ((this.summary == rhs.summary)||((this.summary!= null)&&this.summary.equals(rhs.summary)));
    }
}
