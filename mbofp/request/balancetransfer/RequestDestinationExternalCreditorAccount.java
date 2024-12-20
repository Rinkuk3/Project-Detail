package com.td.api.mbofp.request.balancetransfer;

public class RequestDestinationExternalCreditorAccount {

    private String accountNum;
    private String creditorPartyIdentificationNum;

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getCreditorPartyIdentificationNum() {
        return creditorPartyIdentificationNum;
    }

    public void setCreditorPartyIdentificationNum(String creditorPartyIdentificationNum) {
        this.creditorPartyIdentificationNum = creditorPartyIdentificationNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestDestinationExternalCreditorAccount.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("accountNum");
        sb.append('=');
        sb.append(((this.accountNum == null)?"<null>":this.accountNum));
        sb.append(',');
        sb.append("creditorPartyIdentificationNum");
        sb.append('=');
        sb.append(((this.creditorPartyIdentificationNum == null)?"<null>":this.creditorPartyIdentificationNum));
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
        result = ((result* 31)+((this.accountNum == null)? 0 :this.accountNum.hashCode()));
        result = ((result* 31)+((this.creditorPartyIdentificationNum == null)? 0 :this.creditorPartyIdentificationNum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestDestinationExternalCreditorAccount) == false) {
            return false;
        }
        RequestDestinationExternalCreditorAccount rhs = ((RequestDestinationExternalCreditorAccount) other);
        return (((this.accountNum == rhs.accountNum)||((this.accountNum!= null)&&this.accountNum.equals(rhs.accountNum)))&&((this.creditorPartyIdentificationNum == rhs.creditorPartyIdentificationNum)||((this.creditorPartyIdentificationNum!= null)&&this.creditorPartyIdentificationNum.equals(rhs.creditorPartyIdentificationNum))));
    }

}
