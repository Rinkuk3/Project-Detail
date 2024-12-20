package com.td.api.ofm.common;

import java.util.ArrayList;
import java.util.List;

public class TCCAAPIBalanceSegmentEventDetail {

    private String eventId;
    private String typeCd;
    private String cardNum;
    private String originatingUserId;
    private String originatingUserFunctionCd;
    private String solicitationChannelTypeCd;
    private String accessChannelTypeCd;
    private List<TCCAAPIBalanceSegmentEventAdjustmentDetail> adjustmentEvent = new ArrayList<TCCAAPIBalanceSegmentEventAdjustmentDetail>();

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

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
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

    public List<TCCAAPIBalanceSegmentEventAdjustmentDetail> getAdjustmentEvent() {
        return adjustmentEvent;
    }

    public void setAdjustmentEvent(List<TCCAAPIBalanceSegmentEventAdjustmentDetail> adjustmentEvent) {
        this.adjustmentEvent = adjustmentEvent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TCCAAPIBalanceSegmentEventDetail.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("eventId");
        sb.append('=');
        sb.append(((this.eventId == null)?"<null>":this.eventId));
        sb.append(',');
        sb.append("typeCd");
        sb.append('=');
        sb.append(((this.typeCd == null)?"<null>":this.typeCd));
        sb.append(',');
        sb.append("cardNum");
        sb.append('=');
        sb.append(((this.cardNum == null)?"<null>":this.cardNum));
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
        result = ((result* 31)+((this.eventId == null)? 0 :this.eventId.hashCode()));
        result = ((result* 31)+((this.cardNum == null)? 0 :this.cardNum.hashCode()));
        result = ((result* 31)+((this.originatingUserId == null)? 0 :this.originatingUserId.hashCode()));
        result = ((result* 31)+((this.accessChannelTypeCd == null)? 0 :this.accessChannelTypeCd.hashCode()));
        result = ((result* 31)+((this.typeCd == null)? 0 :this.typeCd.hashCode()));
        result = ((result* 31)+((this.originatingUserFunctionCd == null)? 0 :this.originatingUserFunctionCd.hashCode()));
        result = ((result* 31)+((this.adjustmentEvent == null)? 0 :this.adjustmentEvent.hashCode()));
        result = ((result* 31)+((this.solicitationChannelTypeCd == null)? 0 :this.solicitationChannelTypeCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TCCAAPIBalanceSegmentEventDetail) == false) {
            return false;
        }
        TCCAAPIBalanceSegmentEventDetail rhs = ((TCCAAPIBalanceSegmentEventDetail) other);
        return (((((((((this.eventId == rhs.eventId)||((this.eventId!= null)&&this.eventId.equals(rhs.eventId)))&&((this.cardNum == rhs.cardNum)||((this.cardNum!= null)&&this.cardNum.equals(rhs.cardNum))))&&((this.originatingUserId == rhs.originatingUserId)||((this.originatingUserId!= null)&&this.originatingUserId.equals(rhs.originatingUserId))))&&((this.accessChannelTypeCd == rhs.accessChannelTypeCd)||((this.accessChannelTypeCd!= null)&&this.accessChannelTypeCd.equals(rhs.accessChannelTypeCd))))&&((this.typeCd == rhs.typeCd)||((this.typeCd!= null)&&this.typeCd.equals(rhs.typeCd))))&&((this.originatingUserFunctionCd == rhs.originatingUserFunctionCd)||((this.originatingUserFunctionCd!= null)&&this.originatingUserFunctionCd.equals(rhs.originatingUserFunctionCd))))&&((this.adjustmentEvent == rhs.adjustmentEvent)||((this.adjustmentEvent!= null)&&this.adjustmentEvent.equals(rhs.adjustmentEvent))))&&((this.solicitationChannelTypeCd == rhs.solicitationChannelTypeCd)||((this.solicitationChannelTypeCd!= null)&&this.solicitationChannelTypeCd.equals(rhs.solicitationChannelTypeCd))));
    }

}
