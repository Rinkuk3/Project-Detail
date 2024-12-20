package com.td.api.mbofp.request.installmentplan;

import com.td.api.mbofp.request.common.TransactionCccyamt;

public class FinancialEvent {

    private String eventId;
    private String eventDesc;
    private String debitTxt;
    private String termBalanceCd;
    private TransactionCccyamt transactionCccyamt;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getDebitTxt() {
        return debitTxt;
    }

    public void setDebitTxt(String debitTxt) {
        this.debitTxt = debitTxt;
    }

    public String getTermBalanceCd() {
        return termBalanceCd;
    }

    public void setTermBalanceCd(String termBalanceCd) {
        this.termBalanceCd = termBalanceCd;
    }

    public TransactionCccyamt getTransactionCccyamt() {
        return transactionCccyamt;
    }

    public void setTransactionCccyamt(TransactionCccyamt transactionCccyamt) {
        this.transactionCccyamt = transactionCccyamt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FinancialEvent.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("eventId");
        sb.append('=');
        sb.append(((this.eventId == null)?"<null>":this.eventId));
        sb.append(',');
        sb.append("eventDesc");
        sb.append('=');
        sb.append(((this.eventDesc == null)?"<null>":this.eventDesc));
        sb.append(',');
        sb.append("debitTxt");
        sb.append('=');
        sb.append(((this.debitTxt == null)?"<null>":this.debitTxt));
        sb.append(',');
        sb.append("termBalanceCd");
        sb.append('=');
        sb.append(((this.termBalanceCd == null)?"<null>":this.termBalanceCd));
        sb.append(',');
        sb.append("transactionCccyamt");
        sb.append('=');
        sb.append(((this.transactionCccyamt == null)?"<null>":this.transactionCccyamt));
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
        result = ((result* 31)+((this.eventDesc == null)? 0 :this.eventDesc.hashCode()));
        result = ((result* 31)+((this.transactionCccyamt == null)? 0 :this.transactionCccyamt.hashCode()));
        result = ((result* 31)+((this.termBalanceCd == null)? 0 :this.termBalanceCd.hashCode()));
        result = ((result* 31)+((this.debitTxt == null)? 0 :this.debitTxt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FinancialEvent) == false) {
            return false;
        }
        FinancialEvent rhs = ((FinancialEvent) other);
        return ((((((this.eventId == rhs.eventId)||((this.eventId!= null)&&this.eventId.equals(rhs.eventId)))&&((this.eventDesc == rhs.eventDesc)||((this.eventDesc!= null)&&this.eventDesc.equals(rhs.eventDesc))))&&((this.transactionCccyamt == rhs.transactionCccyamt)||((this.transactionCccyamt!= null)&&this.transactionCccyamt.equals(rhs.transactionCccyamt))))&&((this.termBalanceCd == rhs.termBalanceCd)||((this.termBalanceCd!= null)&&this.termBalanceCd.equals(rhs.termBalanceCd))))&&((this.debitTxt == rhs.debitTxt)||((this.debitTxt!= null)&&this.debitTxt.equals(rhs.debitTxt))));
    }

}
