package com.td.mbna.msec.midtier.transfer.payload;

public class BTConfirmationType {

    private Boolean status;
    private String refId;
    private String errorCode;
    private BalanceTransferToCreditorPaymentInfoType paymentInfo;

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

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public BalanceTransferToCreditorPaymentInfoType getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(BalanceTransferToCreditorPaymentInfoType paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BTConfirmationType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("refId");
        sb.append('=');
        sb.append(((this.refId == null)?"<null>":this.refId));
        sb.append(',');
        sb.append("errorCode");
        sb.append('=');
        sb.append(((this.errorCode == null)?"<null>":this.errorCode));
        sb.append(',');
        sb.append("paymentInfo");
        sb.append('=');
        sb.append(((this.paymentInfo == null)?"<null>":this.paymentInfo));
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
        result = ((result* 31)+((this.errorCode == null)? 0 :this.errorCode.hashCode()));
        result = ((result* 31)+((this.refId == null)? 0 :this.refId.hashCode()));
        result = ((result* 31)+((this.paymentInfo == null)? 0 :this.paymentInfo.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BTConfirmationType) == false) {
            return false;
        }
        BTConfirmationType rhs = ((BTConfirmationType) other);
        return (((((this.errorCode == rhs.errorCode)||((this.errorCode!= null)&&this.errorCode.equals(rhs.errorCode)))&&((this.refId == rhs.refId)||((this.refId!= null)&&this.refId.equals(rhs.refId))))&&((this.paymentInfo == rhs.paymentInfo)||((this.paymentInfo!= null)&&this.paymentInfo.equals(rhs.paymentInfo))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

}
