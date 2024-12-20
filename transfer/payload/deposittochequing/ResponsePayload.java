package com.td.mbna.msec.midtier.transfer.payload.deposittochequing;

public class ResponsePayload {

    private Boolean status;
    private String refId;
    private String transferTo;
    private String transferToFr;
    private Integer minNumOfDays;
    private Integer maxNumOfDays;
    private Boolean allowBalanceTransfer;
    private Boolean allowTransferToChequing;
    private java.math.BigDecimal totalAmt;
    private java.math.BigDecimal transferFee;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getTransferTo() {
		return transferTo;
	}

	public void setTransferTo(String transferTo) {
		this.transferTo = transferTo;
	}

    public String getTransferToFr() {
    	return transferToFr;
    }
    
    public void setTransferToFr(String transferToFr) {
    	this.transferToFr = transferToFr;
    }
    
    public Integer getMinNumOfDays() {
        return minNumOfDays;
    }

    public void setMinNumOfDays(Integer minNumOfDays) {
        this.minNumOfDays = minNumOfDays;
    }

    public Integer getMaxNumOfDays() {
        return maxNumOfDays;
    }

    public void setMaxNumOfDays(Integer maxNumOfDays) {
        this.maxNumOfDays = maxNumOfDays;
    }

    public Boolean getAllowBalanceTransfer() {
        return allowBalanceTransfer;
    }

    public void setAllowBalanceTransfer(Boolean allowBalanceTransfer) {
        this.allowBalanceTransfer = allowBalanceTransfer;
    }

    public Boolean getAllowTransferToChequing() {
        return allowTransferToChequing;
    }

    public void setAllowTransferToChequing(Boolean allowTransferToChequing) {
        this.allowTransferToChequing = allowTransferToChequing;
    }

    public java.math.BigDecimal getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(java.math.BigDecimal totalAmt) {
        this.totalAmt = totalAmt;
    }

    public java.math.BigDecimal getTransferFee() {
        return transferFee;
    }

    public void setTransferFee(java.math.BigDecimal transferFee) {
        this.transferFee = transferFee;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ResponsePayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("refId");
        sb.append('=');
        sb.append(((this.refId == null)?"<null>":this.refId));
        sb.append(',');
        sb.append("transferTo");
        sb.append('=');
        sb.append(((this.transferTo == null)?"<null>":this.transferTo));
        sb.append(',');
        sb.append("transferToFr");
        sb.append('=');
        sb.append(((this.transferToFr == null)?"<null>":this.transferToFr));
        sb.append(',');
        sb.append("minNumOfDays");
        sb.append('=');
        sb.append(((this.minNumOfDays == null)?"<null>":this.minNumOfDays));
        sb.append(',');
        sb.append("maxNumOfDays");
        sb.append('=');
        sb.append(((this.maxNumOfDays == null)?"<null>":this.maxNumOfDays));
        sb.append(',');
        sb.append("allowBalanceTransfer");
        sb.append('=');
        sb.append(((this.allowBalanceTransfer == null)?"<null>":this.allowBalanceTransfer));
        sb.append(',');
        sb.append("allowTransferToChequing");
        sb.append('=');
        sb.append(((this.allowTransferToChequing == null)?"<null>":this.allowTransferToChequing));
        sb.append(',');
        sb.append("totalAmt");
        sb.append('=');
        sb.append(((this.totalAmt == null)?"<null>":this.totalAmt));
        sb.append(',');
        sb.append("transferFee");
        sb.append('=');
        sb.append(((this.transferFee == null)?"<null>":this.transferFee));
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
        result = ((result* 31)+((this.totalAmt == null)? 0 :this.totalAmt.hashCode()));
        result = ((result* 31)+((this.minNumOfDays == null)? 0 :this.minNumOfDays.hashCode()));
        result = ((result* 31)+((this.allowTransferToChequing == null)? 0 :this.allowTransferToChequing.hashCode()));
        result = ((result* 31)+((this.transferFee == null)? 0 :this.transferFee.hashCode()));
        result = ((result* 31)+((this.refId == null)? 0 :this.refId.hashCode()));
        result = ((result* 31)+((this.transferTo == null)? 0 :this.transferTo.hashCode()));
        result = ((result* 31)+((this.transferToFr == null)? 0 :this.transferToFr.hashCode()));
        result = ((result* 31)+((this.allowBalanceTransfer == null)? 0 :this.allowBalanceTransfer.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        result = ((result* 31)+((this.maxNumOfDays == null)? 0 :this.maxNumOfDays.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResponsePayload) == false) {
            return false;
        }
        ResponsePayload rhs = ((ResponsePayload) other);
        return (((((((((((this.totalAmt == rhs.totalAmt)||((this.totalAmt!= null)&&this.totalAmt.equals(rhs.totalAmt)))&&((this.minNumOfDays == rhs.minNumOfDays)||((this.minNumOfDays!= null)&&this.minNumOfDays.equals(rhs.minNumOfDays))))&&((this.allowTransferToChequing == rhs.allowTransferToChequing)||((this.allowTransferToChequing!= null)&&this.allowTransferToChequing.equals(rhs.allowTransferToChequing))))&&((this.transferFee == rhs.transferFee)||((this.transferFee!= null)&&this.transferFee.equals(rhs.transferFee))))&&((this.refId == rhs.refId)||((this.refId!= null)&&this.refId.equals(rhs.refId))))&&((this.allowBalanceTransfer == rhs.allowBalanceTransfer)||((this.allowBalanceTransfer!= null)&&this.allowBalanceTransfer.equals(rhs.allowBalanceTransfer))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))))&&((this.maxNumOfDays == rhs.maxNumOfDays)||((this.maxNumOfDays!= null)&&this.maxNumOfDays.equals(rhs.maxNumOfDays))))&&((this.transferTo == rhs.transferTo)||((this.transferTo!= null)&&this.transferTo.equals(rhs.transferTo))))&&((this.transferToFr == rhs.transferToFr)||((this.transferToFr!= null)&&this.transferToFr.equals(rhs.transferToFr))));
    }

}
