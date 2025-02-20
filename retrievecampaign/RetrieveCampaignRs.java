package com.td.api.mbofp.response.retrievecampaign;

import java.util.ArrayList;
import java.util.List;

public class RetrieveCampaignRs {

    private Campaign campaign;
    private List<PromotionProductOffer> promotionProductOffer = new ArrayList<PromotionProductOffer>();

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public List<PromotionProductOffer> getPromotionProductOffer() {
        return promotionProductOffer;
    }

    public void setPromotionProductOffer(List<PromotionProductOffer> promotionProductOffer) {
        this.promotionProductOffer = promotionProductOffer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RetrieveCampaignRs.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("campaign");
        sb.append('=');
        sb.append(((this.campaign == null)?"<null>":this.campaign));
        sb.append(',');
        sb.append("promotionProductOffer");
        sb.append('=');
        sb.append(((this.promotionProductOffer == null)?"<null>":this.promotionProductOffer));
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
        result = ((result* 31)+((this.promotionProductOffer == null)? 0 :this.promotionProductOffer.hashCode()));
        result = ((result* 31)+((this.campaign == null)? 0 :this.campaign.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RetrieveCampaignRs) == false) {
            return false;
        }
        RetrieveCampaignRs rhs = ((RetrieveCampaignRs) other);
        return (((this.promotionProductOffer == rhs.promotionProductOffer)||((this.promotionProductOffer!= null)&&this.promotionProductOffer.equals(rhs.promotionProductOffer)))&&((this.campaign == rhs.campaign)||((this.campaign!= null)&&this.campaign.equals(rhs.campaign))));
    }

}
