package com.td.api.mbofp.request.installmentplan;

public class AddTargetPromotionAgreementFinancialEventRequest {

    private TargetPromotionAgreementFinancialEvent targetPromotionAgreementFinancialEvent;

    public TargetPromotionAgreementFinancialEvent getTargetPromotionAgreementFinancialEvent() {
        return targetPromotionAgreementFinancialEvent;
    }

    public void setTargetPromotionAgreementFinancialEvent(TargetPromotionAgreementFinancialEvent targetPromotionAgreementFinancialEvent) {
        this.targetPromotionAgreementFinancialEvent = targetPromotionAgreementFinancialEvent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AddTargetPromotionAgreementFinancialEventRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("targetPromotionAgreementFinancialEvent");
        sb.append('=');
        sb.append(((this.targetPromotionAgreementFinancialEvent == null)?"<null>":this.targetPromotionAgreementFinancialEvent));
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
        result = ((result* 31)+((this.targetPromotionAgreementFinancialEvent == null)? 0 :this.targetPromotionAgreementFinancialEvent.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddTargetPromotionAgreementFinancialEventRequest) == false) {
            return false;
        }
        AddTargetPromotionAgreementFinancialEventRequest rhs = ((AddTargetPromotionAgreementFinancialEventRequest) other);
        return ((this.targetPromotionAgreementFinancialEvent == rhs.targetPromotionAgreementFinancialEvent)||((this.targetPromotionAgreementFinancialEvent!= null)&&this.targetPromotionAgreementFinancialEvent.equals(rhs.targetPromotionAgreementFinancialEvent)));
    }

}
