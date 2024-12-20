package com.td.api.mbofp.request.balancetransfer;

public class BalanceTransferRequest {

    private BalanceTransfer balanceTransfer;
    private FundsTransfer fundsTransfer;
    private Recipient recipient;

    public BalanceTransfer getBalanceTransfer() {
        return balanceTransfer;
    }

    public void setBalanceTransfer(BalanceTransfer balanceTransfer) {
        this.balanceTransfer = balanceTransfer;
    }

    public FundsTransfer getFundsTransfer() {
        return fundsTransfer;
    }

    public void setFundsTransfer(FundsTransfer fundsTransfer) {
        this.fundsTransfer = fundsTransfer;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BalanceTransferRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("balanceTransfer");
        sb.append('=');
        sb.append(((this.balanceTransfer == null)?"<null>":this.balanceTransfer));
        sb.append(',');
        sb.append("fundsTransfer");
        sb.append('=');
        sb.append(((this.fundsTransfer == null)?"<null>":this.fundsTransfer));
        sb.append(',');
        sb.append("recipient");
        sb.append('=');
        sb.append(((this.recipient == null)?"<null>":this.recipient));
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
        result = ((result* 31)+((this.recipient == null)? 0 :this.recipient.hashCode()));
        result = ((result* 31)+((this.fundsTransfer == null)? 0 :this.fundsTransfer.hashCode()));
        result = ((result* 31)+((this.balanceTransfer == null)? 0 :this.balanceTransfer.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BalanceTransferRequest) == false) {
            return false;
        }
        BalanceTransferRequest rhs = ((BalanceTransferRequest) other);
        return ((((this.recipient == rhs.recipient)||((this.recipient!= null)&&this.recipient.equals(rhs.recipient)))&&((this.fundsTransfer == rhs.fundsTransfer)||((this.fundsTransfer!= null)&&this.fundsTransfer.equals(rhs.fundsTransfer))))&&((this.balanceTransfer == rhs.balanceTransfer)||((this.balanceTransfer!= null)&&this.balanceTransfer.equals(rhs.balanceTransfer))));
    }

}
