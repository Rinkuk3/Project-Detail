package com.td.api.mbofp.request.installmentplan;

public class Feature {

    private Boolean frontEndFeeInd;

    public Boolean getFrontEndFeeInd() {
        return frontEndFeeInd;
    }

    public void setFrontEndFeeInd(Boolean frontEndFeeInd) {
        this.frontEndFeeInd = frontEndFeeInd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Feature.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("frontEndFeeInd");
        sb.append('=');
        sb.append(((this.frontEndFeeInd == null)?"<null>":this.frontEndFeeInd));
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
        result = ((result* 31)+((this.frontEndFeeInd == null)? 0 :this.frontEndFeeInd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Feature) == false) {
            return false;
        }
        Feature rhs = ((Feature) other);
        return ((this.frontEndFeeInd == rhs.frontEndFeeInd)||((this.frontEndFeeInd!= null)&&this.frontEndFeeInd.equals(rhs.frontEndFeeInd)));
    }

}
