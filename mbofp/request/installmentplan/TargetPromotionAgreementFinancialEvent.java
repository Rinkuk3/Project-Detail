package com.td.api.mbofp.request.installmentplan;

public class TargetPromotionAgreementFinancialEvent {

    private PromotionProductOffer promotionProductOffer;
    private FinancialEvent financialEvent;
    private Agreement agreement;
    private PromotionChannel promotionChannel;

    public PromotionProductOffer getPromotionProductOffer() {
        return promotionProductOffer;
    }

    public void setPromotionProductOffer(PromotionProductOffer promotionProductOffer) {
        this.promotionProductOffer = promotionProductOffer;
    }

    public FinancialEvent getFinancialEvent() {
        return financialEvent;
    }

    public void setFinancialEvent(FinancialEvent financialEvent) {
        this.financialEvent = financialEvent;
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }

    public PromotionChannel getPromotionChannel() {
        return promotionChannel;
    }

    public void setPromotionChannel(PromotionChannel promotionChannel) {
        this.promotionChannel = promotionChannel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TargetPromotionAgreementFinancialEvent.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("promotionProductOffer");
        sb.append('=');
        sb.append(((this.promotionProductOffer == null)?"<null>":this.promotionProductOffer));
        sb.append(',');
        sb.append("financialEvent");
        sb.append('=');
        sb.append(((this.financialEvent == null)?"<null>":this.financialEvent));
        sb.append(',');
        sb.append("agreement");
        sb.append('=');
        sb.append(((this.agreement == null)?"<null>":this.agreement));
        sb.append(',');
        sb.append("promotionChannel");
        sb.append('=');
        sb.append(((this.promotionChannel == null)?"<null>":this.promotionChannel));
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
        result = ((result* 31)+((this.agreement == null)? 0 :this.agreement.hashCode()));
        result = ((result* 31)+((this.promotionChannel == null)? 0 :this.promotionChannel.hashCode()));
        result = ((result* 31)+((this.promotionProductOffer == null)? 0 :this.promotionProductOffer.hashCode()));
        result = ((result* 31)+((this.financialEvent == null)? 0 :this.financialEvent.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TargetPromotionAgreementFinancialEvent) == false) {
            return false;
        }
        TargetPromotionAgreementFinancialEvent rhs = ((TargetPromotionAgreementFinancialEvent) other);
        return (((((this.agreement == rhs.agreement)||((this.agreement!= null)&&this.agreement.equals(rhs.agreement)))&&((this.promotionChannel == rhs.promotionChannel)||((this.promotionChannel!= null)&&this.promotionChannel.equals(rhs.promotionChannel))))&&((this.promotionProductOffer == rhs.promotionProductOffer)||((this.promotionProductOffer!= null)&&this.promotionProductOffer.equals(rhs.promotionProductOffer))))&&((this.financialEvent == rhs.financialEvent)||((this.financialEvent!= null)&&this.financialEvent.equals(rhs.financialEvent))));
    }

}
