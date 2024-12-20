package com.td.api.mbofp.response.retrievecampaign;

import java.util.ArrayList;
import java.util.List;

public class Campaign {

    private String campaignId;
    private String startDt;
    private String endDt;
    private String adjudicationMethodTypeCd;
    private String parentCampaignId;
    private List<Channel> channel = new ArrayList<Channel>();

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getStartDt() {
        return startDt;
    }

    public void setStartDt(String startDt) {
        this.startDt = startDt;
    }

    public String getEndDt() {
        return endDt;
    }

    public void setEndDt(String endDt) {
        this.endDt = endDt;
    }

    public String getAdjudicationMethodTypeCd() {
        return adjudicationMethodTypeCd;
    }

    public void setAdjudicationMethodTypeCd(String adjudicationMethodTypeCd) {
        this.adjudicationMethodTypeCd = adjudicationMethodTypeCd;
    }

    public String getParentCampaignId() {
        return parentCampaignId;
    }

    public void setParentCampaignId(String parentCampaignId) {
        this.parentCampaignId = parentCampaignId;
    }

    public List<Channel> getChannel() {
        return channel;
    }

    public void setChannel(List<Channel> channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Campaign.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("campaignId");
        sb.append('=');
        sb.append(((this.campaignId == null)?"<null>":this.campaignId));
        sb.append(',');
        sb.append("startDt");
        sb.append('=');
        sb.append(((this.startDt == null)?"<null>":this.startDt));
        sb.append(',');
        sb.append("endDt");
        sb.append('=');
        sb.append(((this.endDt == null)?"<null>":this.endDt));
        sb.append(',');
        sb.append("adjudicationMethodTypeCd");
        sb.append('=');
        sb.append(((this.adjudicationMethodTypeCd == null)?"<null>":this.adjudicationMethodTypeCd));
        sb.append(',');
        sb.append("parentCampaignId");
        sb.append('=');
        sb.append(((this.parentCampaignId == null)?"<null>":this.parentCampaignId));
        sb.append(',');
        sb.append("channel");
        sb.append('=');
        sb.append(((this.channel == null)?"<null>":this.channel));
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
        result = ((result* 31)+((this.adjudicationMethodTypeCd == null)? 0 :this.adjudicationMethodTypeCd.hashCode()));
        result = ((result* 31)+((this.campaignId == null)? 0 :this.campaignId.hashCode()));
        result = ((result* 31)+((this.channel == null)? 0 :this.channel.hashCode()));
        result = ((result* 31)+((this.startDt == null)? 0 :this.startDt.hashCode()));
        result = ((result* 31)+((this.endDt == null)? 0 :this.endDt.hashCode()));
        result = ((result* 31)+((this.parentCampaignId == null)? 0 :this.parentCampaignId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Campaign) == false) {
            return false;
        }
        Campaign rhs = ((Campaign) other);
        return (((((((this.adjudicationMethodTypeCd == rhs.adjudicationMethodTypeCd)||((this.adjudicationMethodTypeCd!= null)&&this.adjudicationMethodTypeCd.equals(rhs.adjudicationMethodTypeCd)))&&((this.campaignId == rhs.campaignId)||((this.campaignId!= null)&&this.campaignId.equals(rhs.campaignId))))&&((this.channel == rhs.channel)||((this.channel!= null)&&this.channel.equals(rhs.channel))))&&((this.startDt == rhs.startDt)||((this.startDt!= null)&&this.startDt.equals(rhs.startDt))))&&((this.endDt == rhs.endDt)||((this.endDt!= null)&&this.endDt.equals(rhs.endDt))))&&((this.parentCampaignId == rhs.parentCampaignId)||((this.parentCampaignId!= null)&&this.parentCampaignId.equals(rhs.parentCampaignId))));
    }

}
