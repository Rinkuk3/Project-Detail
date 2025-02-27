package com.td.api.mbcca.response.account;

import java.util.ArrayList;
import java.util.List;

import com.td.api.mbcca.shared.Status;

public class RetrieveCreditCardAgreementBalanceDetails {

    private Status status;
    private List<CurrentBalanceInfo> currentBalanceInfo = new ArrayList<CurrentBalanceInfo>();
    private List<PromotionTransactionCategoryInfo> promotionTransactionCategoryInfo = new ArrayList<PromotionTransactionCategoryInfo>();
    private List<PreviousBalanceInfo> previousBalanceInfo = new ArrayList<PreviousBalanceInfo>();

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<CurrentBalanceInfo> getCurrentBalanceInfo() {
        return currentBalanceInfo;
    }

    public void setCurrentBalanceInfo(List<CurrentBalanceInfo> currentBalanceInfo) {
        this.currentBalanceInfo = currentBalanceInfo;
    }

    public List<PromotionTransactionCategoryInfo> getPromotionTransactionCategoryInfo() {
        return promotionTransactionCategoryInfo;
    }

    public void setPromotionTransactionCategoryInfo(List<PromotionTransactionCategoryInfo> promotionTransactionCategoryInfo) {
        this.promotionTransactionCategoryInfo = promotionTransactionCategoryInfo;
    }

    public List<PreviousBalanceInfo> getPreviousBalanceInfo() {
        return previousBalanceInfo;
    }

    public void setPreviousBalanceInfo(List<PreviousBalanceInfo> previousBalanceInfo) {
        this.previousBalanceInfo = previousBalanceInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RetrieveCreditCardAgreementBalanceDetails.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("currentBalanceInfo");
        sb.append('=');
        sb.append(((this.currentBalanceInfo == null)?"<null>":this.currentBalanceInfo));
        sb.append(',');
        sb.append("promotionTransactionCategoryInfo");
        sb.append('=');
        sb.append(((this.promotionTransactionCategoryInfo == null)?"<null>":this.promotionTransactionCategoryInfo));
        sb.append(',');
        sb.append("previousBalanceInfo");
        sb.append('=');
        sb.append(((this.previousBalanceInfo == null)?"<null>":this.previousBalanceInfo));
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
        result = ((result* 31)+((this.promotionTransactionCategoryInfo == null)? 0 :this.promotionTransactionCategoryInfo.hashCode()));
        result = ((result* 31)+((this.currentBalanceInfo == null)? 0 :this.currentBalanceInfo.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        result = ((result* 31)+((this.previousBalanceInfo == null)? 0 :this.previousBalanceInfo.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RetrieveCreditCardAgreementBalanceDetails) == false) {
            return false;
        }
        RetrieveCreditCardAgreementBalanceDetails rhs = ((RetrieveCreditCardAgreementBalanceDetails) other);
        return (((((this.promotionTransactionCategoryInfo == rhs.promotionTransactionCategoryInfo)||((this.promotionTransactionCategoryInfo!= null)&&this.promotionTransactionCategoryInfo.equals(rhs.promotionTransactionCategoryInfo)))&&((this.currentBalanceInfo == rhs.currentBalanceInfo)||((this.currentBalanceInfo!= null)&&this.currentBalanceInfo.equals(rhs.currentBalanceInfo))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))))&&((this.previousBalanceInfo == rhs.previousBalanceInfo)||((this.previousBalanceInfo!= null)&&this.previousBalanceInfo.equals(rhs.previousBalanceInfo))));
    }

}
