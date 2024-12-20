package com.td.api.mbofp.request.balancetransfer;

public class FundsTransfer {

    private RequestFundsSource requestFundsSource;
    private RequestFundsDestination requestFundsDestination;
    private String fundsTransferMethodTypeCd;
    private String fundsTransferTypeCd;

    public RequestFundsSource getRequestFundsSource() {
        return requestFundsSource;
    }

    public void setRequestFundsSource(RequestFundsSource requestFundsSource) {
        this.requestFundsSource = requestFundsSource;
    }

    public RequestFundsDestination getRequestFundsDestination() {
        return requestFundsDestination;
    }

    public void setRequestFundsDestination(RequestFundsDestination requestFundsDestination) {
        this.requestFundsDestination = requestFundsDestination;
    }

    public String getFundsTransferMethodTypeCd() {
        return fundsTransferMethodTypeCd;
    }

    public void setFundsTransferMethodTypeCd(String fundsTransferMethodTypeCd) {
        this.fundsTransferMethodTypeCd = fundsTransferMethodTypeCd;
    }

    public String getFundsTransferTypeCd() {
        return fundsTransferTypeCd;
    }

    public void setFundsTransferTypeCd(String fundsTransferTypeCd) {
        this.fundsTransferTypeCd = fundsTransferTypeCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FundsTransfer.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("requestFundsSource");
        sb.append('=');
        sb.append(((this.requestFundsSource == null)?"<null>":this.requestFundsSource));
        sb.append(',');
        sb.append("requestFundsDestination");
        sb.append('=');
        sb.append(((this.requestFundsDestination == null)?"<null>":this.requestFundsDestination));
        sb.append(',');
        sb.append("fundsTransferMethodTypeCd");
        sb.append('=');
        sb.append(((this.fundsTransferMethodTypeCd == null)?"<null>":this.fundsTransferMethodTypeCd));
        sb.append(',');
        sb.append("fundsTransferTypeCd");
        sb.append('=');
        sb.append(((this.fundsTransferTypeCd == null)?"<null>":this.fundsTransferTypeCd));
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
        result = ((result* 31)+((this.requestFundsSource == null)? 0 :this.requestFundsSource.hashCode()));
        result = ((result* 31)+((this.fundsTransferMethodTypeCd == null)? 0 :this.fundsTransferMethodTypeCd.hashCode()));
        result = ((result* 31)+((this.fundsTransferTypeCd == null)? 0 :this.fundsTransferTypeCd.hashCode()));
        result = ((result* 31)+((this.requestFundsDestination == null)? 0 :this.requestFundsDestination.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FundsTransfer) == false) {
            return false;
        }
        FundsTransfer rhs = ((FundsTransfer) other);
        return (((((this.requestFundsSource == rhs.requestFundsSource)||((this.requestFundsSource!= null)&&this.requestFundsSource.equals(rhs.requestFundsSource)))&&((this.fundsTransferMethodTypeCd == rhs.fundsTransferMethodTypeCd)||((this.fundsTransferMethodTypeCd!= null)&&this.fundsTransferMethodTypeCd.equals(rhs.fundsTransferMethodTypeCd))))&&((this.fundsTransferTypeCd == rhs.fundsTransferTypeCd)||((this.fundsTransferTypeCd!= null)&&this.fundsTransferTypeCd.equals(rhs.fundsTransferTypeCd))))&&((this.requestFundsDestination == rhs.requestFundsDestination)||((this.requestFundsDestination!= null)&&this.requestFundsDestination.equals(rhs.requestFundsDestination))));
    }

}
