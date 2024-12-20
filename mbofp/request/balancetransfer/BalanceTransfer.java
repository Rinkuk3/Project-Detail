package com.td.api.mbofp.request.balancetransfer;

import com.td.api.mbofp.request.common.TransactionCccyamt;

public class BalanceTransfer {

    private String productId;
    private String productGroupId;
    private TransactionCccyamt transactionCccyamt;
    private String negotiatedFeeTypeCd;
    private String originatingUserId;
    private String originatingUserFunctionCd;
    private String solicitationChannelTypeCd;
    private String accessChannelTypeCd;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(String productGroupId) {
        this.productGroupId = productGroupId;
    }

    public TransactionCccyamt getTransactionCccyamt() {
        return transactionCccyamt;
    }

    public void setTransactionCccyamt(TransactionCccyamt transactionCccyamt) {
        this.transactionCccyamt = transactionCccyamt;
    }

    public String getNegotiatedFeeTypeCd() {
        return negotiatedFeeTypeCd;
    }

    public void setNegotiatedFeeTypeCd(String negotiatedFeeTypeCd) {
        this.negotiatedFeeTypeCd = negotiatedFeeTypeCd;
    }

    public String getOriginatingUserId() {
        return originatingUserId;
    }

    public void setOriginatingUserId(String originatingUserId) {
        this.originatingUserId = originatingUserId;
    }

    public String getOriginatingUserFunctionCd() {
        return originatingUserFunctionCd;
    }

    public void setOriginatingUserFunctionCd(String originatingUserFunctionCd) {
        this.originatingUserFunctionCd = originatingUserFunctionCd;
    }

    public String getSolicitationChannelTypeCd() {
        return solicitationChannelTypeCd;
    }

    public void setSolicitationChannelTypeCd(String solicitationChannelTypeCd) {
        this.solicitationChannelTypeCd = solicitationChannelTypeCd;
    }

    public String getAccessChannelTypeCd() {
        return accessChannelTypeCd;
    }

    public void setAccessChannelTypeCd(String accessChannelTypeCd) {
        this.accessChannelTypeCd = accessChannelTypeCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BalanceTransfer.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("productId");
        sb.append('=');
        sb.append(((this.productId == null)?"<null>":this.productId));
        sb.append(',');
        sb.append("productGroupId");
        sb.append('=');
        sb.append(((this.productGroupId == null)?"<null>":this.productGroupId));
        sb.append(',');
        sb.append("transactionCccyamt");
        sb.append('=');
        sb.append(((this.transactionCccyamt == null)?"<null>":this.transactionCccyamt));
        sb.append(',');
        sb.append("negotiatedFeeTypeCd");
        sb.append('=');
        sb.append(((this.negotiatedFeeTypeCd == null)?"<null>":this.negotiatedFeeTypeCd));
        sb.append(',');
        sb.append("originatingUserId");
        sb.append('=');
        sb.append(((this.originatingUserId == null)?"<null>":this.originatingUserId));
        sb.append(',');
        sb.append("originatingUserFunctionCd");
        sb.append('=');
        sb.append(((this.originatingUserFunctionCd == null)?"<null>":this.originatingUserFunctionCd));
        sb.append(',');
        sb.append("solicitationChannelTypeCd");
        sb.append('=');
        sb.append(((this.solicitationChannelTypeCd == null)?"<null>":this.solicitationChannelTypeCd));
        sb.append(',');
        sb.append("accessChannelTypeCd");
        sb.append('=');
        sb.append(((this.accessChannelTypeCd == null)?"<null>":this.accessChannelTypeCd));
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
        result = ((result* 31)+((this.originatingUserId == null)? 0 :this.originatingUserId.hashCode()));
        result = ((result* 31)+((this.accessChannelTypeCd == null)? 0 :this.accessChannelTypeCd.hashCode()));
        result = ((result* 31)+((this.productId == null)? 0 :this.productId.hashCode()));
        result = ((result* 31)+((this.transactionCccyamt == null)? 0 :this.transactionCccyamt.hashCode()));
        result = ((result* 31)+((this.originatingUserFunctionCd == null)? 0 :this.originatingUserFunctionCd.hashCode()));
        result = ((result* 31)+((this.productGroupId == null)? 0 :this.productGroupId.hashCode()));
        result = ((result* 31)+((this.solicitationChannelTypeCd == null)? 0 :this.solicitationChannelTypeCd.hashCode()));
        result = ((result* 31)+((this.negotiatedFeeTypeCd == null)? 0 :this.negotiatedFeeTypeCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BalanceTransfer) == false) {
            return false;
        }
        BalanceTransfer rhs = ((BalanceTransfer) other);
        return (((((((((this.originatingUserId == rhs.originatingUserId)||((this.originatingUserId!= null)&&this.originatingUserId.equals(rhs.originatingUserId)))&&((this.accessChannelTypeCd == rhs.accessChannelTypeCd)||((this.accessChannelTypeCd!= null)&&this.accessChannelTypeCd.equals(rhs.accessChannelTypeCd))))&&((this.productId == rhs.productId)||((this.productId!= null)&&this.productId.equals(rhs.productId))))&&((this.transactionCccyamt == rhs.transactionCccyamt)||((this.transactionCccyamt!= null)&&this.transactionCccyamt.equals(rhs.transactionCccyamt))))&&((this.originatingUserFunctionCd == rhs.originatingUserFunctionCd)||((this.originatingUserFunctionCd!= null)&&this.originatingUserFunctionCd.equals(rhs.originatingUserFunctionCd))))&&((this.productGroupId == rhs.productGroupId)||((this.productGroupId!= null)&&this.productGroupId.equals(rhs.productGroupId))))&&((this.solicitationChannelTypeCd == rhs.solicitationChannelTypeCd)||((this.solicitationChannelTypeCd!= null)&&this.solicitationChannelTypeCd.equals(rhs.solicitationChannelTypeCd))))&&((this.negotiatedFeeTypeCd == rhs.negotiatedFeeTypeCd)||((this.negotiatedFeeTypeCd!= null)&&this.negotiatedFeeTypeCd.equals(rhs.negotiatedFeeTypeCd))));
    }

}
