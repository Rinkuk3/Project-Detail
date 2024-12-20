package com.td.api.mbcca.creditcard.request;

public class ReinstatementStatus {

    private Boolean reinstatementInd;

    public Boolean getReinstatementInd() {
        return reinstatementInd;
    }

    public void setReinstatementInd(Boolean reinstatementInd) {
        this.reinstatementInd = reinstatementInd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ReinstatementStatus.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("reinstatementInd");
        sb.append('=');
        sb.append(((this.reinstatementInd == null)?"<null>":this.reinstatementInd));
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
        result = ((result* 31)+((this.reinstatementInd == null)? 0 :this.reinstatementInd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ReinstatementStatus) == false) {
            return false;
        }
        ReinstatementStatus rhs = ((ReinstatementStatus) other);
        return ((this.reinstatementInd == rhs.reinstatementInd)||((this.reinstatementInd!= null)&&this.reinstatementInd.equals(rhs.reinstatementInd)));
    }

}
