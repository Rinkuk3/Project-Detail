package com.td.api.ofm.common;

public class TCCAAPIBalanceSegmentEventAdjustmentInfo {

    private String originalAdjustmentEventId;
    private String requestReferenceNum;
    private TCCAAPITransaction originalTransaction;
    private TCCAAPIBalanceSegment balanceSegment;
    private String solicitationChannelTypeCd;
    private String accessChannelTypeCd;

    public String getOriginalAdjustmentEventId() {
        return originalAdjustmentEventId;
    }

    public void setOriginalAdjustmentEventId(String originalAdjustmentEventId) {
        this.originalAdjustmentEventId = originalAdjustmentEventId;
    }

    public String getRequestReferenceNum() {
        return requestReferenceNum;
    }

    public void setRequestReferenceNum(String requestReferenceNum) {
        this.requestReferenceNum = requestReferenceNum;
    }

    public TCCAAPIBalanceSegment getBalanceSegment() {
        return balanceSegment;
    }

    public void setBalanceSegment(TCCAAPIBalanceSegment balanceSegment) {
        this.balanceSegment = balanceSegment;
    }

    public TCCAAPITransaction getOriginalTransaction() {
        return originalTransaction;
    }

    public void setOriginalTransaction(TCCAAPITransaction originalTransaction) {
        this.originalTransaction = originalTransaction;
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
        sb.append(TCCAAPIBalanceSegmentEventAdjustmentInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("originalAdjustmentEventId");
        sb.append('=');
        sb.append(((this.originalAdjustmentEventId == null)?"<null>":this.originalAdjustmentEventId));
        sb.append(',');
        sb.append("requestReferenceNum");
        sb.append('=');
        sb.append(((this.requestReferenceNum == null)?"<null>":this.requestReferenceNum));
        sb.append(',');
        sb.append("balanceSegment");
        sb.append('=');
        sb.append(((this.balanceSegment == null)?"<null>":this.balanceSegment));
        sb.append(',');
        sb.append("originalTransaction");
        sb.append('=');
        sb.append(((this.originalTransaction == null)?"<null>":this.originalTransaction));
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
        result = ((result* 31)+((this.requestReferenceNum == null)? 0 :this.requestReferenceNum.hashCode()));
        result = ((result* 31)+((this.accessChannelTypeCd == null)? 0 :this.accessChannelTypeCd.hashCode()));
        result = ((result* 31)+((this.balanceSegment == null)? 0 :this.balanceSegment.hashCode()));
        result = ((result* 31)+((this.originalAdjustmentEventId == null)? 0 :this.originalAdjustmentEventId.hashCode()));
        result = ((result* 31)+((this.solicitationChannelTypeCd == null)? 0 :this.solicitationChannelTypeCd.hashCode()));
        result = ((result* 31)+((this.originalTransaction == null)? 0 :this.originalTransaction.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TCCAAPIBalanceSegmentEventAdjustmentInfo) == false) {
            return false;
        }
        TCCAAPIBalanceSegmentEventAdjustmentInfo rhs = ((TCCAAPIBalanceSegmentEventAdjustmentInfo) other);
        return (((((((this.requestReferenceNum == rhs.requestReferenceNum)||((this.requestReferenceNum!= null)&&this.requestReferenceNum.equals(rhs.requestReferenceNum)))&&((this.accessChannelTypeCd == rhs.accessChannelTypeCd)||((this.accessChannelTypeCd!= null)&&this.accessChannelTypeCd.equals(rhs.accessChannelTypeCd))))&&((this.balanceSegment == rhs.balanceSegment)||((this.balanceSegment!= null)&&this.balanceSegment.equals(rhs.balanceSegment))))&&((this.originalAdjustmentEventId == rhs.originalAdjustmentEventId)||((this.originalAdjustmentEventId!= null)&&this.originalAdjustmentEventId.equals(rhs.originalAdjustmentEventId))))&&((this.solicitationChannelTypeCd == rhs.solicitationChannelTypeCd)||((this.solicitationChannelTypeCd!= null)&&this.solicitationChannelTypeCd.equals(rhs.solicitationChannelTypeCd))))&&((this.originalTransaction == rhs.originalTransaction)||((this.originalTransaction!= null)&&this.originalTransaction.equals(rhs.originalTransaction))));
    }

}
