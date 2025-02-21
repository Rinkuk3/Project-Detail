package com.td.api.mbcca.response.account;

public class ChipCard {

    private String sequenceNum;
    private CardVerificationStatus cardVerificationStatus;
    private TerminalVerificationStatus terminalVerificationStatus;

    public String getSequenceNum() {
        return sequenceNum;
    }

    public void setSequenceNum(String sequenceNum) {
        this.sequenceNum = sequenceNum;
    }

    public CardVerificationStatus getCardVerificationStatus() {
        return cardVerificationStatus;
    }

    public void setCardVerificationStatus(CardVerificationStatus cardVerificationStatus) {
        this.cardVerificationStatus = cardVerificationStatus;
    }

    public TerminalVerificationStatus getTerminalVerificationStatus() {
        return terminalVerificationStatus;
    }

    public void setTerminalVerificationStatus(TerminalVerificationStatus terminalVerificationStatus) {
        this.terminalVerificationStatus = terminalVerificationStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ChipCard.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("sequenceNum");
        sb.append('=');
        sb.append(((this.sequenceNum == null)?"<null>":this.sequenceNum));
        sb.append(',');
        sb.append("cardVerificationStatus");
        sb.append('=');
        sb.append(((this.cardVerificationStatus == null)?"<null>":this.cardVerificationStatus));
        sb.append(',');
        sb.append("terminalVerificationStatus");
        sb.append('=');
        sb.append(((this.terminalVerificationStatus == null)?"<null>":this.terminalVerificationStatus));
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
        result = ((result* 31)+((this.cardVerificationStatus == null)? 0 :this.cardVerificationStatus.hashCode()));
        result = ((result* 31)+((this.terminalVerificationStatus == null)? 0 :this.terminalVerificationStatus.hashCode()));
        result = ((result* 31)+((this.sequenceNum == null)? 0 :this.sequenceNum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChipCard) == false) {
            return false;
        }
        ChipCard rhs = ((ChipCard) other);
        return ((((this.cardVerificationStatus == rhs.cardVerificationStatus)||((this.cardVerificationStatus!= null)&&this.cardVerificationStatus.equals(rhs.cardVerificationStatus)))&&((this.terminalVerificationStatus == rhs.terminalVerificationStatus)||((this.terminalVerificationStatus!= null)&&this.terminalVerificationStatus.equals(rhs.terminalVerificationStatus))))&&((this.sequenceNum == rhs.sequenceNum)||((this.sequenceNum!= null)&&this.sequenceNum.equals(rhs.sequenceNum))));
    }

}
