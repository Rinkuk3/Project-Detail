package com.td.api.mbofp.request.updateofferdisposition;

public class PartyResponse {

    private String typeCd;
    private String reasonCd;
    private Party party;
    private String originatingUserId;
    private String originatingUserFunctionCd;
    private String solicitationChannelTypeCd;
    private String accessChannelTypeCd;
    private PromotionOfferToAgreement promotionOfferToAgreement;

    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    public String getReasonCd() {
        return reasonCd;
    }

    public void setReasonCd(String reasonCd) {
        this.reasonCd = reasonCd;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
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

    public PromotionOfferToAgreement getPromotionOfferToAgreement() {
        return promotionOfferToAgreement;
    }

    public void setPromotionOfferToAgreement(PromotionOfferToAgreement promotionOfferToAgreement) {
        this.promotionOfferToAgreement = promotionOfferToAgreement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PartyResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("typeCd");
        sb.append('=');
        sb.append(((this.typeCd == null)?"<null>":this.typeCd));
        sb.append(',');
        sb.append("reasonCd");
        sb.append('=');
        sb.append(((this.reasonCd == null)?"<null>":this.reasonCd));
        sb.append(',');
        sb.append("party");
        sb.append('=');
        sb.append(((this.party == null)?"<null>":this.party));
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
        sb.append("promotionOfferToAgreement");
        sb.append('=');
        sb.append(((this.promotionOfferToAgreement == null)?"<null>":this.promotionOfferToAgreement));
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
        result = ((result* 31)+((this.promotionOfferToAgreement == null)? 0 :this.promotionOfferToAgreement.hashCode()));
        result = ((result* 31)+((this.originatingUserId == null)? 0 :this.originatingUserId.hashCode()));
        result = ((result* 31)+((this.accessChannelTypeCd == null)? 0 :this.accessChannelTypeCd.hashCode()));
        result = ((result* 31)+((this.typeCd == null)? 0 :this.typeCd.hashCode()));
        result = ((result* 31)+((this.originatingUserFunctionCd == null)? 0 :this.originatingUserFunctionCd.hashCode()));
        result = ((result* 31)+((this.solicitationChannelTypeCd == null)? 0 :this.solicitationChannelTypeCd.hashCode()));
        result = ((result* 31)+((this.party == null)? 0 :this.party.hashCode()));
        result = ((result* 31)+((this.reasonCd == null)? 0 :this.reasonCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PartyResponse) == false) {
            return false;
        }
        PartyResponse rhs = ((PartyResponse) other);
        return (((((((((this.promotionOfferToAgreement == rhs.promotionOfferToAgreement)||((this.promotionOfferToAgreement!= null)&&this.promotionOfferToAgreement.equals(rhs.promotionOfferToAgreement)))&&((this.originatingUserId == rhs.originatingUserId)||((this.originatingUserId!= null)&&this.originatingUserId.equals(rhs.originatingUserId))))&&((this.accessChannelTypeCd == rhs.accessChannelTypeCd)||((this.accessChannelTypeCd!= null)&&this.accessChannelTypeCd.equals(rhs.accessChannelTypeCd))))&&((this.typeCd == rhs.typeCd)||((this.typeCd!= null)&&this.typeCd.equals(rhs.typeCd))))&&((this.originatingUserFunctionCd == rhs.originatingUserFunctionCd)||((this.originatingUserFunctionCd!= null)&&this.originatingUserFunctionCd.equals(rhs.originatingUserFunctionCd))))&&((this.solicitationChannelTypeCd == rhs.solicitationChannelTypeCd)||((this.solicitationChannelTypeCd!= null)&&this.solicitationChannelTypeCd.equals(rhs.solicitationChannelTypeCd))))&&((this.party == rhs.party)||((this.party!= null)&&this.party.equals(rhs.party))))&&((this.reasonCd == rhs.reasonCd)||((this.reasonCd!= null)&&this.reasonCd.equals(rhs.reasonCd))));
    }

}
