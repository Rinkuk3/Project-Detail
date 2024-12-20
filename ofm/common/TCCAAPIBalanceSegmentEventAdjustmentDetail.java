package com.td.api.ofm.common;

import java.math.BigDecimal;

public class TCCAAPIBalanceSegmentEventAdjustmentDetail {

    private String eventId;
    private String typeCd;
    private String statusCd;
    private String reasonDesc;
    private String reasonTxt;
    BigDecimal transactionAmt;
    private String accountingFunctionCd;
    private String clientReferenceNum;
    private String requestTypeCd;
    private String requestReferenceNum;
    private String transmissionId;
    private String releaseDt;
    private TCCAAPICreditCardAgreementKey creditCardAgreement;
    private TCCAAPIBalanceSegmentDetail balanceSegment;
    private TCCAAPITransactionDetail originalTransaction;
    private String createdDt;
    private String createdByUserId;
    private String lastUpdatedDt;
    private String lastUpdatedByUserId;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public String getReasonDesc() {
        return reasonDesc;
    }

    public void setReasonDesc(String reasonDesc) {
        this.reasonDesc = reasonDesc;
    }

    public String getReasonTxt() {
        return reasonTxt;
    }

    public void setReasonTxt(String reasonTxt) {
        this.reasonTxt = reasonTxt;
    }

    public BigDecimal getTransactionAmt() {
        return transactionAmt;
    }

    public void setTransactionAmt(BigDecimal transactionAmt) {
        this.transactionAmt = transactionAmt;
    }

    public String getAccountingFunctionCd() {
        return accountingFunctionCd;
    }

    public void setAccountingFunctionCd(String accountingFunctionCd) {
        this.accountingFunctionCd = accountingFunctionCd;
    }

    public String getClientReferenceNum() {
        return clientReferenceNum;
    }

    public void setClientReferenceNum(String clientReferenceNum) {
        this.clientReferenceNum = clientReferenceNum;
    }

    public String getRequestTypeCd() {
        return requestTypeCd;
    }

    public void setRequestTypeCd(String requestTypeCd) {
        this.requestTypeCd = requestTypeCd;
    }

    public String getRequestReferenceNum() {
        return requestReferenceNum;
    }

    public void setRequestReferenceNum(String requestReferenceNum) {
        this.requestReferenceNum = requestReferenceNum;
    }

    public String getTransmissionId() {
        return transmissionId;
    }

    public void setTransmissionId(String transmissionId) {
        this.transmissionId = transmissionId;
    }

    public String getReleaseDt() {
        return releaseDt;
    }

    public void setReleaseDt(String releaseDt) {
        this.releaseDt = releaseDt;
    }

    public TCCAAPICreditCardAgreementKey getCreditCardAgreement() {
        return creditCardAgreement;
    }

    public void setCreditCardAgreement(TCCAAPICreditCardAgreementKey creditCardAgreement) {
        this.creditCardAgreement = creditCardAgreement;
    }

    public TCCAAPIBalanceSegmentDetail getBalanceSegment() {
        return balanceSegment;
    }

    public void setBalanceSegment(TCCAAPIBalanceSegmentDetail balanceSegment) {
        this.balanceSegment = balanceSegment;
    }

    public TCCAAPITransactionDetail getOriginalTransaction() {
        return originalTransaction;
    }

    public void setOriginalTransaction(TCCAAPITransactionDetail originalTransaction) {
        this.originalTransaction = originalTransaction;
    }

    public String getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(String createdDt) {
        this.createdDt = createdDt;
    }

    public String getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(String createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public String getLastUpdatedDt() {
        return lastUpdatedDt;
    }

    public void setLastUpdatedDt(String lastUpdatedDt) {
        this.lastUpdatedDt = lastUpdatedDt;
    }

    public String getLastUpdatedByUserId() {
        return lastUpdatedByUserId;
    }

    public void setLastUpdatedByUserId(String lastUpdatedByUserId) {
        this.lastUpdatedByUserId = lastUpdatedByUserId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TCCAAPIBalanceSegmentEventAdjustmentDetail.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("eventId");
        sb.append('=');
        sb.append(((this.eventId == null)?"<null>":this.eventId));
        sb.append(',');
        sb.append("typeCd");
        sb.append('=');
        sb.append(((this.typeCd == null)?"<null>":this.typeCd));
        sb.append(',');
        sb.append("statusCd");
        sb.append('=');
        sb.append(((this.statusCd == null)?"<null>":this.statusCd));
        sb.append(',');
        sb.append("reasonDesc");
        sb.append('=');
        sb.append(((this.reasonDesc == null)?"<null>":this.reasonDesc));
        sb.append(',');
        sb.append("reasonTxt");
        sb.append('=');
        sb.append(((this.reasonTxt == null)?"<null>":this.reasonTxt));
        sb.append(',');
        sb.append("transactionAmt");
        sb.append('=');
        sb.append(((this.transactionAmt == null)?"<null>":this.transactionAmt));
        sb.append(',');
        sb.append("accountingFunctionCd");
        sb.append('=');
        sb.append(((this.accountingFunctionCd == null)?"<null>":this.accountingFunctionCd));
        sb.append(',');
        sb.append("clientReferenceNum");
        sb.append('=');
        sb.append(((this.clientReferenceNum == null)?"<null>":this.clientReferenceNum));
        sb.append(',');
        sb.append("requestTypeCd");
        sb.append('=');
        sb.append(((this.requestTypeCd == null)?"<null>":this.requestTypeCd));
        sb.append(',');
        sb.append("requestReferenceNum");
        sb.append('=');
        sb.append(((this.requestReferenceNum == null)?"<null>":this.requestReferenceNum));
        sb.append(',');
        sb.append("transmissionId");
        sb.append('=');
        sb.append(((this.transmissionId == null)?"<null>":this.transmissionId));
        sb.append(',');
        sb.append("releaseDt");
        sb.append('=');
        sb.append(((this.releaseDt == null)?"<null>":this.releaseDt));
        sb.append(',');
        sb.append("creditCardAgreement");
        sb.append('=');
        sb.append(((this.creditCardAgreement == null)?"<null>":this.creditCardAgreement));
        sb.append(',');
        sb.append("balanceSegment");
        sb.append('=');
        sb.append(((this.balanceSegment == null)?"<null>":this.balanceSegment));
        sb.append(',');
        sb.append("originalTransaction");
        sb.append('=');
        sb.append(((this.originalTransaction == null)?"<null>":this.originalTransaction));
        sb.append(',');
        sb.append("createdDt");
        sb.append('=');
        sb.append(((this.createdDt == null)?"<null>":this.createdDt));
        sb.append(',');
        sb.append("createdByUserId");
        sb.append('=');
        sb.append(((this.createdByUserId == null)?"<null>":this.createdByUserId));
        sb.append(',');
        sb.append("lastUpdatedDt");
        sb.append('=');
        sb.append(((this.lastUpdatedDt == null)?"<null>":this.lastUpdatedDt));
        sb.append(',');
        sb.append("lastUpdatedByUserId");
        sb.append('=');
        sb.append(((this.lastUpdatedByUserId == null)?"<null>":this.lastUpdatedByUserId));
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
        result = ((result* 31)+((this.releaseDt == null)? 0 :this.releaseDt.hashCode()));
        result = ((result* 31)+((this.eventId == null)? 0 :this.eventId.hashCode()));
        result = ((result* 31)+((this.createdByUserId == null)? 0 :this.createdByUserId.hashCode()));
        result = ((result* 31)+((this.balanceSegment == null)? 0 :this.balanceSegment.hashCode()));
        result = ((result* 31)+((this.lastUpdatedDt == null)? 0 :this.lastUpdatedDt.hashCode()));
        result = ((result* 31)+((this.statusCd == null)? 0 :this.statusCd.hashCode()));
        result = ((result* 31)+((this.requestTypeCd == null)? 0 :this.requestTypeCd.hashCode()));
        result = ((result* 31)+((this.accountingFunctionCd == null)? 0 :this.accountingFunctionCd.hashCode()));
        result = ((result* 31)+((this.originalTransaction == null)? 0 :this.originalTransaction.hashCode()));
        result = ((result* 31)+((this.transactionAmt == null)? 0 :this.transactionAmt.hashCode()));
        result = ((result* 31)+((this.requestReferenceNum == null)? 0 :this.requestReferenceNum.hashCode()));
        result = ((result* 31)+((this.transmissionId == null)? 0 :this.transmissionId.hashCode()));
        result = ((result* 31)+((this.createdDt == null)? 0 :this.createdDt.hashCode()));
        result = ((result* 31)+((this.typeCd == null)? 0 :this.typeCd.hashCode()));
        result = ((result* 31)+((this.creditCardAgreement == null)? 0 :this.creditCardAgreement.hashCode()));
        result = ((result* 31)+((this.reasonTxt == null)? 0 :this.reasonTxt.hashCode()));
        result = ((result* 31)+((this.lastUpdatedByUserId == null)? 0 :this.lastUpdatedByUserId.hashCode()));
        result = ((result* 31)+((this.clientReferenceNum == null)? 0 :this.clientReferenceNum.hashCode()));
        result = ((result* 31)+((this.reasonDesc == null)? 0 :this.reasonDesc.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TCCAAPIBalanceSegmentEventAdjustmentDetail) == false) {
            return false;
        }
        TCCAAPIBalanceSegmentEventAdjustmentDetail rhs = ((TCCAAPIBalanceSegmentEventAdjustmentDetail) other);
        return ((((((((((((((((((((this.releaseDt == rhs.releaseDt)||((this.releaseDt!= null)&&this.releaseDt.equals(rhs.releaseDt)))&&((this.eventId == rhs.eventId)||((this.eventId!= null)&&this.eventId.equals(rhs.eventId))))&&((this.createdByUserId == rhs.createdByUserId)||((this.createdByUserId!= null)&&this.createdByUserId.equals(rhs.createdByUserId))))&&((this.balanceSegment == rhs.balanceSegment)||((this.balanceSegment!= null)&&this.balanceSegment.equals(rhs.balanceSegment))))&&((this.lastUpdatedDt == rhs.lastUpdatedDt)||((this.lastUpdatedDt!= null)&&this.lastUpdatedDt.equals(rhs.lastUpdatedDt))))&&((this.statusCd == rhs.statusCd)||((this.statusCd!= null)&&this.statusCd.equals(rhs.statusCd))))&&((this.requestTypeCd == rhs.requestTypeCd)||((this.requestTypeCd!= null)&&this.requestTypeCd.equals(rhs.requestTypeCd))))&&((this.accountingFunctionCd == rhs.accountingFunctionCd)||((this.accountingFunctionCd!= null)&&this.accountingFunctionCd.equals(rhs.accountingFunctionCd))))&&((this.originalTransaction == rhs.originalTransaction)||((this.originalTransaction!= null)&&this.originalTransaction.equals(rhs.originalTransaction))))&&((this.transactionAmt == rhs.transactionAmt)||((this.transactionAmt!= null)&&this.transactionAmt.equals(rhs.transactionAmt))))&&((this.requestReferenceNum == rhs.requestReferenceNum)||((this.requestReferenceNum!= null)&&this.requestReferenceNum.equals(rhs.requestReferenceNum))))&&((this.transmissionId == rhs.transmissionId)||((this.transmissionId!= null)&&this.transmissionId.equals(rhs.transmissionId))))&&((this.createdDt == rhs.createdDt)||((this.createdDt!= null)&&this.createdDt.equals(rhs.createdDt))))&&((this.typeCd == rhs.typeCd)||((this.typeCd!= null)&&this.typeCd.equals(rhs.typeCd))))&&((this.creditCardAgreement == rhs.creditCardAgreement)||((this.creditCardAgreement!= null)&&this.creditCardAgreement.equals(rhs.creditCardAgreement))))&&((this.reasonTxt == rhs.reasonTxt)||((this.reasonTxt!= null)&&this.reasonTxt.equals(rhs.reasonTxt))))&&((this.lastUpdatedByUserId == rhs.lastUpdatedByUserId)||((this.lastUpdatedByUserId!= null)&&this.lastUpdatedByUserId.equals(rhs.lastUpdatedByUserId))))&&((this.clientReferenceNum == rhs.clientReferenceNum)||((this.clientReferenceNum!= null)&&this.clientReferenceNum.equals(rhs.clientReferenceNum))))&&((this.reasonDesc == rhs.reasonDesc)||((this.reasonDesc!= null)&&this.reasonDesc.equals(rhs.reasonDesc))));
    }

}
