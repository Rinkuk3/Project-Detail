package com.td.api.ofm.common;

import java.util.ArrayList;
import java.util.List;

public class TCCAAPIBalanceSegmentEventInfo {

    private String typeCd;
    private String externalReferenceNum;
    private String cardNum;
    private String solicitationChannelTypeCd;
    private String accessChannelTypeCd;
    private List<TCCAAPIBalanceSegmentEventAdjustment> adjustmentEvent = new ArrayList<TCCAAPIBalanceSegmentEventAdjustment>();

    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    public String getExternalReferenceNum() {
        return externalReferenceNum;
    }

    public void setExternalReferenceNum(String externalReferenceNum) {
        this.externalReferenceNum = externalReferenceNum;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
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

    public List<TCCAAPIBalanceSegmentEventAdjustment> getAdjustmentEvent() {
        return adjustmentEvent;
    }

    public void setAdjustmentEvent(List<TCCAAPIBalanceSegmentEventAdjustment> adjustmentEvent) {
        this.adjustmentEvent = adjustmentEvent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TCCAAPIBalanceSegmentEventInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("typeCd");
        sb.append('=');
        sb.append(((this.typeCd == null)?"<null>":this.typeCd));
        sb.append(',');
        sb.append("externalReferenceNum");
        sb.append('=');
        sb.append(((this.externalReferenceNum == null)?"<null>":this.externalReferenceNum));
        sb.append(',');
        sb.append("cardNum");
        sb.append('=');
        sb.append(((this.cardNum == null)?"<null>":this.cardNum));
        sb.append(',');
        sb.append("solicitationChannelTypeCd");
        sb.append('=');
        sb.append(((this.solicitationChannelTypeCd == null)?"<null>":this.solicitationChannelTypeCd));
        sb.append(',');
        sb.append("accessChannelTypeCd");
        sb.append('=');
        sb.append(((this.accessChannelTypeCd == null)?"<null>":this.accessChannelTypeCd));
        sb.append(',');
        sb.append("adjustmentEvent");
        sb.append('=');
        sb.append(((this.adjustmentEvent == null)?"<null>":this.adjustmentEvent));
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
        result = ((result* 31)+((this.cardNum == null)? 0 :this.cardNum.hashCode()));
        result = ((result* 31)+((this.accessChannelTypeCd == null)? 0 :this.accessChannelTypeCd.hashCode()));
        result = ((result* 31)+((this.typeCd == null)? 0 :this.typeCd.hashCode()));
        result = ((result* 31)+((this.adjustmentEvent == null)? 0 :this.adjustmentEvent.hashCode()));
        result = ((result* 31)+((this.solicitationChannelTypeCd == null)? 0 :this.solicitationChannelTypeCd.hashCode()));
        result = ((result* 31)+((this.externalReferenceNum == null)? 0 :this.externalReferenceNum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TCCAAPIBalanceSegmentEventInfo) == false) {
            return false;
        }
        TCCAAPIBalanceSegmentEventInfo rhs = ((TCCAAPIBalanceSegmentEventInfo) other);
        return (((((((this.cardNum == rhs.cardNum)||((this.cardNum!= null)&&this.cardNum.equals(rhs.cardNum)))&&((this.accessChannelTypeCd == rhs.accessChannelTypeCd)||((this.accessChannelTypeCd!= null)&&this.accessChannelTypeCd.equals(rhs.accessChannelTypeCd))))&&((this.typeCd == rhs.typeCd)||((this.typeCd!= null)&&this.typeCd.equals(rhs.typeCd))))&&((this.adjustmentEvent == rhs.adjustmentEvent)||((this.adjustmentEvent!= null)&&this.adjustmentEvent.equals(rhs.adjustmentEvent))))&&((this.solicitationChannelTypeCd == rhs.solicitationChannelTypeCd)||((this.solicitationChannelTypeCd!= null)&&this.solicitationChannelTypeCd.equals(rhs.solicitationChannelTypeCd))))&&((this.externalReferenceNum == rhs.externalReferenceNum)||((this.externalReferenceNum!= null)&&this.externalReferenceNum.equals(rhs.externalReferenceNum))));
    }

}
