package com.td.mbna.msec.midtier.transfer.payload.getbalancetransfertocreditorsummary;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.transfer.payload.BalanceTransferToCreditorPaymentInfoType;
import com.td.mbna.msec.midtier.types.common.PromotionOfferType;

public class RequestPayload {

    private List<BalanceTransferToCreditorPaymentInfoType> paymentInfo = new ArrayList<BalanceTransferToCreditorPaymentInfoType>();
    private BigDecimal currentCreditRemaining;
    private PromotionOfferType selectedOffer;

    public List<BalanceTransferToCreditorPaymentInfoType> getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(List<BalanceTransferToCreditorPaymentInfoType> paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public BigDecimal getCurrentCreditRemaining() {
        return currentCreditRemaining;
    }

    public void setCurrentCreditRemaining(BigDecimal currentCreditRemaining) {
        this.currentCreditRemaining = currentCreditRemaining;
    }

    public PromotionOfferType getSelectedOffer() {
        return selectedOffer;
    }

    public void setSelectedOffer(PromotionOfferType selectedOffer) {
        this.selectedOffer = selectedOffer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("paymentInfo");
        sb.append('=');
        sb.append(((this.paymentInfo == null)?"<null>":this.paymentInfo));
        sb.append(',');
        sb.append("currentCreditRemaining");
        sb.append('=');
        sb.append(((this.currentCreditRemaining == null)?"<null>":this.currentCreditRemaining));
        sb.append(',');
        sb.append("selectedOffer");
        sb.append('=');
        sb.append(((this.selectedOffer == null)?"<null>":this.selectedOffer));
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
        result = ((result* 31)+((this.selectedOffer == null)? 0 :this.selectedOffer.hashCode()));
        result = ((result* 31)+((this.paymentInfo == null)? 0 :this.paymentInfo.hashCode()));
        result = ((result* 31)+((this.currentCreditRemaining == null)? 0 :this.currentCreditRemaining.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestPayload) == false) {
            return false;
        }
        RequestPayload rhs = ((RequestPayload) other);
        return ((((this.selectedOffer == rhs.selectedOffer)||((this.selectedOffer!= null)&&this.selectedOffer.equals(rhs.selectedOffer)))&&((this.paymentInfo == rhs.paymentInfo)||((this.paymentInfo!= null)&&this.paymentInfo.equals(rhs.paymentInfo))))&&((this.currentCreditRemaining == rhs.currentCreditRemaining)||((this.currentCreditRemaining!= null)&&this.currentCreditRemaining.equals(rhs.currentCreditRemaining))));
    }

}
