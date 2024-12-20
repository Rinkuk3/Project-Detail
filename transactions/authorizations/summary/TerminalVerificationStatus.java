package com.td.api.mbcca.response.transactions.authorizations.summary;

public class TerminalVerificationStatus {

    private Boolean pinPadNotPresentInd;

    public Boolean getPinPadNotPresentInd() {
        return pinPadNotPresentInd;
    }

    public void setPinPadNotPresentInd(Boolean pinPadNotPresentInd) {
        this.pinPadNotPresentInd = pinPadNotPresentInd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TerminalVerificationStatus.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("pinPadNotPresentInd");
        sb.append('=');
        sb.append(((this.pinPadNotPresentInd == null)?"<null>":this.pinPadNotPresentInd));
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
        result = ((result* 31)+((this.pinPadNotPresentInd == null)? 0 :this.pinPadNotPresentInd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TerminalVerificationStatus) == false) {
            return false;
        }
        TerminalVerificationStatus rhs = ((TerminalVerificationStatus) other);
        return ((this.pinPadNotPresentInd == rhs.pinPadNotPresentInd)||((this.pinPadNotPresentInd!= null)&&this.pinPadNotPresentInd.equals(rhs.pinPadNotPresentInd)));
    }

}
