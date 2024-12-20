package com.td.api.mbcca.request.cancelip;

import com.td.api.mbcca.shared.Cccyamt;
import com.td.api.mbcca.shared.MerchantInfo;

public class AdjustmentEvent {

    private String activityTypeCd;
    private String adjustmentTypeCd;
    private String eventTypeCd;
    private String transactionCategoryCd;
    private String retailEventDt;
    private String cardNum;
    private String acquirerReferenceNum;
    private Cccyamt transactionCccyamt;
    private String textTypeCd;
    private MerchantInfo merchantInfo;
    private String trackingNum;
    private Boolean forcePostInd;
    private String accountingFunctionCd;
    private String paymentTokenNum;
    private String paymentTokenAssuranceLevelCd;
    private String paymentTokenRequesterId;
    private TsysExtension tsysExtension;
    private String transactionLevelProcessingTypeCd;
    private String transactionLevelProcessingFeatureId;

    public String getActivityTypeCd() {
        return activityTypeCd;
    }

    public void setActivityTypeCd(String activityTypeCd) {
        this.activityTypeCd = activityTypeCd;
    }

    public String getAdjustmentTypeCd() {
        return adjustmentTypeCd;
    }

    public void setAdjustmentTypeCd(String adjustmentTypeCd) {
        this.adjustmentTypeCd = adjustmentTypeCd;
    }

    public String getEventTypeCd() {
        return eventTypeCd;
    }

    public void setEventTypeCd(String eventTypeCd) {
        this.eventTypeCd = eventTypeCd;
    }

    public String getTransactionCategoryCd() {
        return transactionCategoryCd;
    }

    public void setTransactionCategoryCd(String transactionCategoryCd) {
        this.transactionCategoryCd = transactionCategoryCd;
    }

    public String getRetailEventDt() {
        return retailEventDt;
    }

    public void setRetailEventDt(String retailEventDt) {
        this.retailEventDt = retailEventDt;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getAcquirerReferenceNum() {
        return acquirerReferenceNum;
    }

    public void setAcquirerReferenceNum(String acquirerReferenceNum) {
        this.acquirerReferenceNum = acquirerReferenceNum;
    }

    public Cccyamt getTransactionCccyamt() {
        return transactionCccyamt;
    }

    public void setTransactionCccyamt(Cccyamt transactionCccyamt) {
        this.transactionCccyamt = transactionCccyamt;
    }

    public String getTextTypeCd() {
        return textTypeCd;
    }

    public void setTextTypeCd(String textTypeCd) {
        this.textTypeCd = textTypeCd;
    }

    public MerchantInfo getMerchantInfo() {
        return merchantInfo;
    }

    public void setMerchantInfo(MerchantInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    public String getTrackingNum() {
        return trackingNum;
    }

    public void setTrackingNum(String trackingNum) {
        this.trackingNum = trackingNum;
    }

    public Boolean getForcePostInd() {
        return forcePostInd;
    }

    public void setForcePostInd(Boolean forcePostInd) {
        this.forcePostInd = forcePostInd;
    }

    public String getAccountingFunctionCd() {
        return accountingFunctionCd;
    }

    public void setAccountingFunctionCd(String accountingFunctionCd) {
        this.accountingFunctionCd = accountingFunctionCd;
    }

    public String getPaymentTokenNum() {
        return paymentTokenNum;
    }

    public void setPaymentTokenNum(String paymentTokenNum) {
        this.paymentTokenNum = paymentTokenNum;
    }

    public String getPaymentTokenAssuranceLevelCd() {
        return paymentTokenAssuranceLevelCd;
    }

    public void setPaymentTokenAssuranceLevelCd(String paymentTokenAssuranceLevelCd) {
        this.paymentTokenAssuranceLevelCd = paymentTokenAssuranceLevelCd;
    }

    public String getPaymentTokenRequesterId() {
        return paymentTokenRequesterId;
    }

    public void setPaymentTokenRequesterId(String paymentTokenRequesterId) {
        this.paymentTokenRequesterId = paymentTokenRequesterId;
    }

    public TsysExtension getTsysExtension() {
        return tsysExtension;
    }

    public void setTsysExtension(TsysExtension tsysExtension) {
        this.tsysExtension = tsysExtension;
    }

    public String getTransactionLevelProcessingTypeCd() {
        return transactionLevelProcessingTypeCd;
    }

    public void setTransactionLevelProcessingTypeCd(String transactionLevelProcessingTypeCd) {
        this.transactionLevelProcessingTypeCd = transactionLevelProcessingTypeCd;
    }

    public String getTransactionLevelProcessingFeatureId() {
        return transactionLevelProcessingFeatureId;
    }

    public void setTransactionLevelProcessingFeatureId(String transactionLevelProcessingFeatureId) {
        this.transactionLevelProcessingFeatureId = transactionLevelProcessingFeatureId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AdjustmentEvent.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("activityTypeCd");
        sb.append('=');
        sb.append(((this.activityTypeCd == null)?"<null>":this.activityTypeCd));
        sb.append(',');
        sb.append("adjustmentTypeCd");
        sb.append('=');
        sb.append(((this.adjustmentTypeCd == null)?"<null>":this.adjustmentTypeCd));
        sb.append(',');
        sb.append("eventTypeCd");
        sb.append('=');
        sb.append(((this.eventTypeCd == null)?"<null>":this.eventTypeCd));
        sb.append(',');
        sb.append("transactionCategoryCd");
        sb.append('=');
        sb.append(((this.transactionCategoryCd == null)?"<null>":this.transactionCategoryCd));
        sb.append(',');
        sb.append("retailEventDt");
        sb.append('=');
        sb.append(((this.retailEventDt == null)?"<null>":this.retailEventDt));
        sb.append(',');
        sb.append("cardNum");
        sb.append('=');
        sb.append(((this.cardNum == null)?"<null>":this.cardNum));
        sb.append(',');
        sb.append("acquirerReferenceNum");
        sb.append('=');
        sb.append(((this.acquirerReferenceNum == null)?"<null>":this.acquirerReferenceNum));
        sb.append(',');
        sb.append("transactionCccyamt");
        sb.append('=');
        sb.append(((this.transactionCccyamt == null)?"<null>":this.transactionCccyamt));
        sb.append(',');
        sb.append("textTypeCd");
        sb.append('=');
        sb.append(((this.textTypeCd == null)?"<null>":this.textTypeCd));
        sb.append(',');
        sb.append("merchantInfo");
        sb.append('=');
        sb.append(((this.merchantInfo == null)?"<null>":this.merchantInfo));
        sb.append(',');
        sb.append("trackingNum");
        sb.append('=');
        sb.append(((this.trackingNum == null)?"<null>":this.trackingNum));
        sb.append(',');
        sb.append("forcePostInd");
        sb.append('=');
        sb.append(((this.forcePostInd == null)?"<null>":this.forcePostInd));
        sb.append(',');
        sb.append("accountingFunctionCd");
        sb.append('=');
        sb.append(((this.accountingFunctionCd == null)?"<null>":this.accountingFunctionCd));
        sb.append(',');
        sb.append("paymentTokenNum");
        sb.append('=');
        sb.append(((this.paymentTokenNum == null)?"<null>":this.paymentTokenNum));
        sb.append(',');
        sb.append("paymentTokenAssuranceLevelCd");
        sb.append('=');
        sb.append(((this.paymentTokenAssuranceLevelCd == null)?"<null>":this.paymentTokenAssuranceLevelCd));
        sb.append(',');
        sb.append("paymentTokenRequesterId");
        sb.append('=');
        sb.append(((this.paymentTokenRequesterId == null)?"<null>":this.paymentTokenRequesterId));
        sb.append(',');
        sb.append("tsysExtension");
        sb.append('=');
        sb.append(((this.tsysExtension == null)?"<null>":this.tsysExtension));
        sb.append(',');
        sb.append("transactionLevelProcessingTypeCd");
        sb.append('=');
        sb.append(((this.transactionLevelProcessingTypeCd == null)?"<null>":this.transactionLevelProcessingTypeCd));
        sb.append(',');
        sb.append("transactionLevelProcessingFeatureId");
        sb.append('=');
        sb.append(((this.transactionLevelProcessingFeatureId == null)?"<null>":this.transactionLevelProcessingFeatureId));
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
        result = ((result* 31)+((this.acquirerReferenceNum == null)? 0 :this.acquirerReferenceNum.hashCode()));
        result = ((result* 31)+((this.transactionCccyamt == null)? 0 :this.transactionCccyamt.hashCode()));
        result = ((result* 31)+((this.transactionLevelProcessingFeatureId == null)? 0 :this.transactionLevelProcessingFeatureId.hashCode()));
        result = ((result* 31)+((this.adjustmentTypeCd == null)? 0 :this.adjustmentTypeCd.hashCode()));
        result = ((result* 31)+((this.retailEventDt == null)? 0 :this.retailEventDt.hashCode()));
        result = ((result* 31)+((this.paymentTokenNum == null)? 0 :this.paymentTokenNum.hashCode()));
        result = ((result* 31)+((this.eventTypeCd == null)? 0 :this.eventTypeCd.hashCode()));
        result = ((result* 31)+((this.merchantInfo == null)? 0 :this.merchantInfo.hashCode()));
        result = ((result* 31)+((this.accountingFunctionCd == null)? 0 :this.accountingFunctionCd.hashCode()));
        result = ((result* 31)+((this.forcePostInd == null)? 0 :this.forcePostInd.hashCode()));
        result = ((result* 31)+((this.paymentTokenRequesterId == null)? 0 :this.paymentTokenRequesterId.hashCode()));
        result = ((result* 31)+((this.activityTypeCd == null)? 0 :this.activityTypeCd.hashCode()));
        result = ((result* 31)+((this.cardNum == null)? 0 :this.cardNum.hashCode()));
        result = ((result* 31)+((this.trackingNum == null)? 0 :this.trackingNum.hashCode()));
        result = ((result* 31)+((this.transactionCategoryCd == null)? 0 :this.transactionCategoryCd.hashCode()));
        result = ((result* 31)+((this.textTypeCd == null)? 0 :this.textTypeCd.hashCode()));
        result = ((result* 31)+((this.tsysExtension == null)? 0 :this.tsysExtension.hashCode()));
        result = ((result* 31)+((this.paymentTokenAssuranceLevelCd == null)? 0 :this.paymentTokenAssuranceLevelCd.hashCode()));
        result = ((result* 31)+((this.transactionLevelProcessingTypeCd == null)? 0 :this.transactionLevelProcessingTypeCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AdjustmentEvent) == false) {
            return false;
        }
        AdjustmentEvent rhs = ((AdjustmentEvent) other);
        return ((((((((((((((((((((this.acquirerReferenceNum == rhs.acquirerReferenceNum)||((this.acquirerReferenceNum!= null)&&this.acquirerReferenceNum.equals(rhs.acquirerReferenceNum)))&&((this.transactionCccyamt == rhs.transactionCccyamt)||((this.transactionCccyamt!= null)&&this.transactionCccyamt.equals(rhs.transactionCccyamt))))&&((this.transactionLevelProcessingFeatureId == rhs.transactionLevelProcessingFeatureId)||((this.transactionLevelProcessingFeatureId!= null)&&this.transactionLevelProcessingFeatureId.equals(rhs.transactionLevelProcessingFeatureId))))&&((this.adjustmentTypeCd == rhs.adjustmentTypeCd)||((this.adjustmentTypeCd!= null)&&this.adjustmentTypeCd.equals(rhs.adjustmentTypeCd))))&&((this.retailEventDt == rhs.retailEventDt)||((this.retailEventDt!= null)&&this.retailEventDt.equals(rhs.retailEventDt))))&&((this.paymentTokenNum == rhs.paymentTokenNum)||((this.paymentTokenNum!= null)&&this.paymentTokenNum.equals(rhs.paymentTokenNum))))&&((this.eventTypeCd == rhs.eventTypeCd)||((this.eventTypeCd!= null)&&this.eventTypeCd.equals(rhs.eventTypeCd))))&&((this.merchantInfo == rhs.merchantInfo)||((this.merchantInfo!= null)&&this.merchantInfo.equals(rhs.merchantInfo))))&&((this.accountingFunctionCd == rhs.accountingFunctionCd)||((this.accountingFunctionCd!= null)&&this.accountingFunctionCd.equals(rhs.accountingFunctionCd))))&&((this.forcePostInd == rhs.forcePostInd)||((this.forcePostInd!= null)&&this.forcePostInd.equals(rhs.forcePostInd))))&&((this.paymentTokenRequesterId == rhs.paymentTokenRequesterId)||((this.paymentTokenRequesterId!= null)&&this.paymentTokenRequesterId.equals(rhs.paymentTokenRequesterId))))&&((this.activityTypeCd == rhs.activityTypeCd)||((this.activityTypeCd!= null)&&this.activityTypeCd.equals(rhs.activityTypeCd))))&&((this.cardNum == rhs.cardNum)||((this.cardNum!= null)&&this.cardNum.equals(rhs.cardNum))))&&((this.trackingNum == rhs.trackingNum)||((this.trackingNum!= null)&&this.trackingNum.equals(rhs.trackingNum))))&&((this.transactionCategoryCd == rhs.transactionCategoryCd)||((this.transactionCategoryCd!= null)&&this.transactionCategoryCd.equals(rhs.transactionCategoryCd))))&&((this.textTypeCd == rhs.textTypeCd)||((this.textTypeCd!= null)&&this.textTypeCd.equals(rhs.textTypeCd))))&&((this.tsysExtension == rhs.tsysExtension)||((this.tsysExtension!= null)&&this.tsysExtension.equals(rhs.tsysExtension))))&&((this.paymentTokenAssuranceLevelCd == rhs.paymentTokenAssuranceLevelCd)||((this.paymentTokenAssuranceLevelCd!= null)&&this.paymentTokenAssuranceLevelCd.equals(rhs.paymentTokenAssuranceLevelCd))))&&((this.transactionLevelProcessingTypeCd == rhs.transactionLevelProcessingTypeCd)||((this.transactionLevelProcessingTypeCd!= null)&&this.transactionLevelProcessingTypeCd.equals(rhs.transactionLevelProcessingTypeCd))));
    }

}
