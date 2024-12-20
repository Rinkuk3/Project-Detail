package com.td.api.mbofp.request.balancetransfer;

public class RequestFundsSource {

    private RequestSourceCreditCardAgreement requestSourceCreditCardAgreement;

    public RequestSourceCreditCardAgreement getRequestSourceCreditCardAgreement() {
        return requestSourceCreditCardAgreement;
    }

    public void setRequestSourceCreditCardAgreement(RequestSourceCreditCardAgreement requestSourceCreditCardAgreement) {
        this.requestSourceCreditCardAgreement = requestSourceCreditCardAgreement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestFundsSource.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("requestSourceCreditCardAgreement");
        sb.append('=');
        sb.append(((this.requestSourceCreditCardAgreement == null)?"<null>":this.requestSourceCreditCardAgreement));
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
        result = ((result* 31)+((this.requestSourceCreditCardAgreement == null)? 0 :this.requestSourceCreditCardAgreement.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestFundsSource) == false) {
            return false;
        }
        RequestFundsSource rhs = ((RequestFundsSource) other);
        return ((this.requestSourceCreditCardAgreement == rhs.requestSourceCreditCardAgreement)||((this.requestSourceCreditCardAgreement!= null)&&this.requestSourceCreditCardAgreement.equals(rhs.requestSourceCreditCardAgreement)));
    }

}
