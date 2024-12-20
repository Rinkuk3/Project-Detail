package com.td.api.mbcca.response.transactions.authorizations.summary;

public class CardVerificationStatus {

    private Boolean offlinePINVerificationDoneInd;
    private Boolean offlinePINVerificationFailedInd;
    private Boolean pinTryLimitExceededInd;

    public Boolean getOfflinePINVerificationDoneInd() {
        return offlinePINVerificationDoneInd;
    }

    public void setOfflinePINVerificationDoneInd(Boolean offlinePINVerificationDoneInd) {
        this.offlinePINVerificationDoneInd = offlinePINVerificationDoneInd;
    }

    public Boolean getOfflinePINVerificationFailedInd() {
        return offlinePINVerificationFailedInd;
    }

    public void setOfflinePINVerificationFailedInd(Boolean offlinePINVerificationFailedInd) {
        this.offlinePINVerificationFailedInd = offlinePINVerificationFailedInd;
    }

    public Boolean getPinTryLimitExceededInd() {
        return pinTryLimitExceededInd;
    }

    public void setPinTryLimitExceededInd(Boolean pinTryLimitExceededInd) {
        this.pinTryLimitExceededInd = pinTryLimitExceededInd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CardVerificationStatus.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("offlinePINVerificationDoneInd");
        sb.append('=');
        sb.append(((this.offlinePINVerificationDoneInd == null)?"<null>":this.offlinePINVerificationDoneInd));
        sb.append(',');
        sb.append("offlinePINVerificationFailedInd");
        sb.append('=');
        sb.append(((this.offlinePINVerificationFailedInd == null)?"<null>":this.offlinePINVerificationFailedInd));
        sb.append(',');
        sb.append("pinTryLimitExceededInd");
        sb.append('=');
        sb.append(((this.pinTryLimitExceededInd == null)?"<null>":this.pinTryLimitExceededInd));
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
        result = ((result* 31)+((this.pinTryLimitExceededInd == null)? 0 :this.pinTryLimitExceededInd.hashCode()));
        result = ((result* 31)+((this.offlinePINVerificationDoneInd == null)? 0 :this.offlinePINVerificationDoneInd.hashCode()));
        result = ((result* 31)+((this.offlinePINVerificationFailedInd == null)? 0 :this.offlinePINVerificationFailedInd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CardVerificationStatus) == false) {
            return false;
        }
        CardVerificationStatus rhs = ((CardVerificationStatus) other);
        return ((((this.pinTryLimitExceededInd == rhs.pinTryLimitExceededInd)||((this.pinTryLimitExceededInd!= null)&&this.pinTryLimitExceededInd.equals(rhs.pinTryLimitExceededInd)))&&((this.offlinePINVerificationDoneInd == rhs.offlinePINVerificationDoneInd)||((this.offlinePINVerificationDoneInd!= null)&&this.offlinePINVerificationDoneInd.equals(rhs.offlinePINVerificationDoneInd))))&&((this.offlinePINVerificationFailedInd == rhs.offlinePINVerificationFailedInd)||((this.offlinePINVerificationFailedInd!= null)&&this.offlinePINVerificationFailedInd.equals(rhs.offlinePINVerificationFailedInd))));
    }

}
