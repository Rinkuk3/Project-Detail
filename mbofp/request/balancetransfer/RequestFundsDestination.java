package com.td.api.mbofp.request.balancetransfer;

public class RequestFundsDestination {

    private RequestDestinationDepositTransactionAgreement requestDestinationDepositTransactionAgreement;
    private RequestDestinationExternalBankAccount requestDestinationExternalBankAccount;
    private RequestDestinationExternalCreditorAccount requestDestinationExternalCreditorAccount;

    public RequestDestinationDepositTransactionAgreement getRequestDestinationDepositTransactionAgreement() {
        return requestDestinationDepositTransactionAgreement;
    }

    public void setRequestDestinationDepositTransactionAgreement(RequestDestinationDepositTransactionAgreement requestDestinationDepositTransactionAgreement) {
        this.requestDestinationDepositTransactionAgreement = requestDestinationDepositTransactionAgreement;
    }

    public RequestDestinationExternalBankAccount getRequestDestinationExternalBankAccount() {
        return requestDestinationExternalBankAccount;
    }

    public void setRequestDestinationExternalBankAccount(RequestDestinationExternalBankAccount requestDestinationExternalBankAccount) {
        this.requestDestinationExternalBankAccount = requestDestinationExternalBankAccount;
    }

    public RequestDestinationExternalCreditorAccount getRequestDestinationExternalCreditorAccount() {
        return requestDestinationExternalCreditorAccount;
    }

    public void setRequestDestinationExternalCreditorAccount(RequestDestinationExternalCreditorAccount requestDestinationExternalCreditorAccount) {
        this.requestDestinationExternalCreditorAccount = requestDestinationExternalCreditorAccount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestFundsDestination.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("requestDestinationDepositTransactionAgreement");
        sb.append('=');
        sb.append(((this.requestDestinationDepositTransactionAgreement == null)?"<null>":this.requestDestinationDepositTransactionAgreement));
        sb.append(',');
        sb.append("requestDestinationExternalBankAccount");
        sb.append('=');
        sb.append(((this.requestDestinationExternalBankAccount == null)?"<null>":this.requestDestinationExternalBankAccount));
        sb.append(',');
        sb.append("requestDestinationExternalCreditorAccount");
        sb.append('=');
        sb.append(((this.requestDestinationExternalCreditorAccount == null)?"<null>":this.requestDestinationExternalCreditorAccount));
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
        result = ((result* 31)+((this.requestDestinationExternalCreditorAccount == null)? 0 :this.requestDestinationExternalCreditorAccount.hashCode()));
        result = ((result* 31)+((this.requestDestinationDepositTransactionAgreement == null)? 0 :this.requestDestinationDepositTransactionAgreement.hashCode()));
        result = ((result* 31)+((this.requestDestinationExternalBankAccount == null)? 0 :this.requestDestinationExternalBankAccount.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestFundsDestination) == false) {
            return false;
        }
        RequestFundsDestination rhs = ((RequestFundsDestination) other);
        return ((((this.requestDestinationExternalCreditorAccount == rhs.requestDestinationExternalCreditorAccount)||((this.requestDestinationExternalCreditorAccount!= null)&&this.requestDestinationExternalCreditorAccount.equals(rhs.requestDestinationExternalCreditorAccount)))&&((this.requestDestinationDepositTransactionAgreement == rhs.requestDestinationDepositTransactionAgreement)||((this.requestDestinationDepositTransactionAgreement!= null)&&this.requestDestinationDepositTransactionAgreement.equals(rhs.requestDestinationDepositTransactionAgreement))))&&((this.requestDestinationExternalBankAccount == rhs.requestDestinationExternalBankAccount)||((this.requestDestinationExternalBankAccount!= null)&&this.requestDestinationExternalBankAccount.equals(rhs.requestDestinationExternalBankAccount))));
    }

}
