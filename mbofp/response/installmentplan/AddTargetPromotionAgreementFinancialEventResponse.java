package com.td.api.mbofp.response.installmentplan;

import com.td.api.mbofp.shared.Status;

public class AddTargetPromotionAgreementFinancialEventResponse {

    private Status status;
    private String promotionAgreementFinancialEventId;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPromotionAgreementFinancialEventId() {
        return promotionAgreementFinancialEventId;
    }

    public void setPromotionAgreementFinancialEventId(String promotionAgreementFinancialEventId) {
        this.promotionAgreementFinancialEventId = promotionAgreementFinancialEventId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AddTargetPromotionAgreementFinancialEventResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("promotionAgreementFinancialEventId");
        sb.append('=');
        sb.append(((this.promotionAgreementFinancialEventId == null)?"<null>":this.promotionAgreementFinancialEventId));
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
        result = ((result* 31)+((this.promotionAgreementFinancialEventId == null)? 0 :this.promotionAgreementFinancialEventId.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddTargetPromotionAgreementFinancialEventResponse) == false) {
            return false;
        }
        AddTargetPromotionAgreementFinancialEventResponse rhs = ((AddTargetPromotionAgreementFinancialEventResponse) other);
        return (((this.promotionAgreementFinancialEventId == rhs.promotionAgreementFinancialEventId)||((this.promotionAgreementFinancialEventId!= null)&&this.promotionAgreementFinancialEventId.equals(rhs.promotionAgreementFinancialEventId)))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

}
