package com.td.api.mbcca.response.account;

public class PartyToTransferEvent {

    private String eventStartDt;
    private String sourceAccountNum;
    private String destinationAccountNum;

    public String getEventStartDt() {
        return eventStartDt;
    }

    public void setEventStartDt(String eventStartDt) {
        this.eventStartDt = eventStartDt;
    }

    public String getSourceAccountNum() {
        return sourceAccountNum;
    }

    public void setSourceAccountNum(String sourceAccountNum) {
        this.sourceAccountNum = sourceAccountNum;
    }

    public String getDestinationAccountNum() {
        return destinationAccountNum;
    }

    public void setDestinationAccountNum(String destinationAccountNum) {
        this.destinationAccountNum = destinationAccountNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PartyToTransferEvent.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("eventStartDt");
        sb.append('=');
        sb.append(((this.eventStartDt == null)?"<null>":this.eventStartDt));
        sb.append(',');
        sb.append("sourceAccountNum");
        sb.append('=');
        sb.append(((this.sourceAccountNum == null)?"<null>":this.sourceAccountNum));
        sb.append(',');
        sb.append("destinationAccountNum");
        sb.append('=');
        sb.append(((this.destinationAccountNum == null)?"<null>":this.destinationAccountNum));
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
        result = ((result* 31)+((this.sourceAccountNum == null)? 0 :this.sourceAccountNum.hashCode()));
        result = ((result* 31)+((this.destinationAccountNum == null)? 0 :this.destinationAccountNum.hashCode()));
        result = ((result* 31)+((this.eventStartDt == null)? 0 :this.eventStartDt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PartyToTransferEvent) == false) {
            return false;
        }
        PartyToTransferEvent rhs = ((PartyToTransferEvent) other);
        return ((((this.sourceAccountNum == rhs.sourceAccountNum)||((this.sourceAccountNum!= null)&&this.sourceAccountNum.equals(rhs.sourceAccountNum)))&&((this.destinationAccountNum == rhs.destinationAccountNum)||((this.destinationAccountNum!= null)&&this.destinationAccountNum.equals(rhs.destinationAccountNum))))&&((this.eventStartDt == rhs.eventStartDt)||((this.eventStartDt!= null)&&this.eventStartDt.equals(rhs.eventStartDt))));
    }

}
