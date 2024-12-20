package com.td.api.mbcca.request.cancelip;

import java.util.Date;

import com.td.api.mbcca.shared.Cccyamt;

public class OriginalAuthorizationEvent__1 {

    private String eventId;
    private Date eventDttm;
    private Cccyamt transactionCccyamt;
    private String terminalChannelTypeCd;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Date getEventDttm() {
        return eventDttm;
    }

    public void setEventDttm(Date eventDttm) {
        this.eventDttm = eventDttm;
    }

    public Cccyamt getTransactionCccyamt() {
        return transactionCccyamt;
    }

    public void setTransactionCccyamt(Cccyamt transactionCccyamt) {
        this.transactionCccyamt = transactionCccyamt;
    }

    public String getTerminalChannelTypeCd() {
        return terminalChannelTypeCd;
    }

    public void setTerminalChannelTypeCd(String terminalChannelTypeCd) {
        this.terminalChannelTypeCd = terminalChannelTypeCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(OriginalAuthorizationEvent__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("eventId");
        sb.append('=');
        sb.append(((this.eventId == null)?"<null>":this.eventId));
        sb.append(',');
        sb.append("eventDttm");
        sb.append('=');
        sb.append(((this.eventDttm == null)?"<null>":this.eventDttm));
        sb.append(',');
        sb.append("transactionCccyamt");
        sb.append('=');
        sb.append(((this.transactionCccyamt == null)?"<null>":this.transactionCccyamt));
        sb.append(',');
        sb.append("terminalChannelTypeCd");
        sb.append('=');
        sb.append(((this.terminalChannelTypeCd == null)?"<null>":this.terminalChannelTypeCd));
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
        result = ((result* 31)+((this.eventId == null)? 0 :this.eventId.hashCode()));
        result = ((result* 31)+((this.terminalChannelTypeCd == null)? 0 :this.terminalChannelTypeCd.hashCode()));
        result = ((result* 31)+((this.eventDttm == null)? 0 :this.eventDttm.hashCode()));
        result = ((result* 31)+((this.transactionCccyamt == null)? 0 :this.transactionCccyamt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OriginalAuthorizationEvent__1) == false) {
            return false;
        }
        OriginalAuthorizationEvent__1 rhs = ((OriginalAuthorizationEvent__1) other);
        return (((((this.eventId == rhs.eventId)||((this.eventId!= null)&&this.eventId.equals(rhs.eventId)))&&((this.terminalChannelTypeCd == rhs.terminalChannelTypeCd)||((this.terminalChannelTypeCd!= null)&&this.terminalChannelTypeCd.equals(rhs.terminalChannelTypeCd))))&&((this.eventDttm == rhs.eventDttm)||((this.eventDttm!= null)&&this.eventDttm.equals(rhs.eventDttm))))&&((this.transactionCccyamt == rhs.transactionCccyamt)||((this.transactionCccyamt!= null)&&this.transactionCccyamt.equals(rhs.transactionCccyamt))));
    }

}
