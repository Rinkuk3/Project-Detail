package com.td.api.mbcca.response.account;

import java.util.Date;

import com.td.api.mbcca.shared.Cccyamt;

public class RetailEvent {

    private String termBalanceCd;
    private CategoryInfo categoryInfo;
    private Cccyamt outstandingCccyamt;
    private Cccyamt financeChargeCccyamt;
    private String statementDataDt;
    private Date eventDttm;
    private String transactionLevelProcessingTypeCd;
    private String acquirerReferenceNum;
    private Cccyamt paidInFullPadCccyamt;
    private Cccyamt deferredOutstandingBalanceCccyamt;
    private Boolean disputedInd;
    private Cccyamt eventTransactionCccyamt;
    private String eventId;
    private CurrentCycleInfo currentCycleInfo;
    private PreviousCycleInfo previousCycleInfo;
    private Cccyamt billedFinanceChargeCccyamt;
    private String transactionLevelProcessingReferenceNum;
    private String transactionLevelProcessingPromotionId;
    private Boolean instalmentTransactionInd;
    private String merchantDoingBusinessAsName;
    private PaymentOption paymentOption;
    private Cccyamt paymentDueCccyamt;
    private Cccyamt specialProcessingExpiryPayOffCccyamt;
    private Integer paidInFullRemainingPaymentCnt;
    private String nextPaymentDueDt;
    private String eventEndDt;
    private Date postedDttm;
    private String postedDt;
    private String postedTimeVal;

    public String getTermBalanceCd() {
        return termBalanceCd;
    }

    public void setTermBalanceCd(String termBalanceCd) {
        this.termBalanceCd = termBalanceCd;
    }

    public CategoryInfo getCategoryInfo() {
        return categoryInfo;
    }

    public void setCategoryInfo(CategoryInfo categoryInfo) {
        this.categoryInfo = categoryInfo;
    }

    public Cccyamt getOutstandingCccyamt() {
        return outstandingCccyamt;
    }

    public void setOutstandingCccyamt(Cccyamt outstandingCccyamt) {
        this.outstandingCccyamt = outstandingCccyamt;
    }

    public Cccyamt getFinanceChargeCccyamt() {
        return financeChargeCccyamt;
    }

    public void setFinanceChargeCccyamt(Cccyamt financeChargeCccyamt) {
        this.financeChargeCccyamt = financeChargeCccyamt;
    }

    public String getStatementDataDt() {
        return statementDataDt;
    }

    public void setStatementDataDt(String statementDataDt) {
        this.statementDataDt = statementDataDt;
    }

    public Date getEventDttm() {
        return eventDttm;
    }

    public void setEventDttm(Date eventDttm) {
        this.eventDttm = eventDttm;
    }

    public String getTransactionLevelProcessingTypeCd() {
        return transactionLevelProcessingTypeCd;
    }

    public void setTransactionLevelProcessingTypeCd(String transactionLevelProcessingTypeCd) {
        this.transactionLevelProcessingTypeCd = transactionLevelProcessingTypeCd;
    }

    public String getAcquirerReferenceNum() {
        return acquirerReferenceNum;
    }

    public void setAcquirerReferenceNum(String acquirerReferenceNum) {
        this.acquirerReferenceNum = acquirerReferenceNum;
    }

    public Cccyamt getPaidInFullPadCccyamt() {
        return paidInFullPadCccyamt;
    }

    public void setPaidInFullPadCccyamt(Cccyamt paidInFullPadCccyamt) {
        this.paidInFullPadCccyamt = paidInFullPadCccyamt;
    }

    public Cccyamt getDeferredOutstandingBalanceCccyamt() {
        return deferredOutstandingBalanceCccyamt;
    }

    public void setDeferredOutstandingBalanceCccyamt(Cccyamt deferredOutstandingBalanceCccyamt) {
        this.deferredOutstandingBalanceCccyamt = deferredOutstandingBalanceCccyamt;
    }

    public Boolean getDisputedInd() {
        return disputedInd;
    }

    public void setDisputedInd(Boolean disputedInd) {
        this.disputedInd = disputedInd;
    }

    public Cccyamt getEventTransactionCccyamt() {
        return eventTransactionCccyamt;
    }

    public void setEventTransactionCccyamt(Cccyamt eventTransactionCccyamt) {
        this.eventTransactionCccyamt = eventTransactionCccyamt;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public CurrentCycleInfo getCurrentCycleInfo() {
        return currentCycleInfo;
    }

    public void setCurrentCycleInfo(CurrentCycleInfo currentCycleInfo) {
        this.currentCycleInfo = currentCycleInfo;
    }

    public PreviousCycleInfo getPreviousCycleInfo() {
        return previousCycleInfo;
    }

    public void setPreviousCycleInfo(PreviousCycleInfo previousCycleInfo) {
        this.previousCycleInfo = previousCycleInfo;
    }

    public Cccyamt getBilledFinanceChargeCccyamt() {
        return billedFinanceChargeCccyamt;
    }

    public void setBilledFinanceChargeCccyamt(Cccyamt billedFinanceChargeCccyamt) {
        this.billedFinanceChargeCccyamt = billedFinanceChargeCccyamt;
    }

    public String getTransactionLevelProcessingReferenceNum() {
        return transactionLevelProcessingReferenceNum;
    }

    public void setTransactionLevelProcessingReferenceNum(String transactionLevelProcessingReferenceNum) {
        this.transactionLevelProcessingReferenceNum = transactionLevelProcessingReferenceNum;
    }

    public String getTransactionLevelProcessingPromotionId() {
        return transactionLevelProcessingPromotionId;
    }

    public void setTransactionLevelProcessingPromotionId(String transactionLevelProcessingPromotionId) {
        this.transactionLevelProcessingPromotionId = transactionLevelProcessingPromotionId;
    }

    public Boolean getInstalmentTransactionInd() {
        return instalmentTransactionInd;
    }

    public void setInstalmentTransactionInd(Boolean instalmentTransactionInd) {
        this.instalmentTransactionInd = instalmentTransactionInd;
    }

    public String getMerchantDoingBusinessAsName() {
        return merchantDoingBusinessAsName;
    }

    public void setMerchantDoingBusinessAsName(String merchantDoingBusinessAsName) {
        this.merchantDoingBusinessAsName = merchantDoingBusinessAsName;
    }

    public PaymentOption getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(PaymentOption paymentOption) {
        this.paymentOption = paymentOption;
    }

    public Cccyamt getPaymentDueCccyamt() {
        return paymentDueCccyamt;
    }

    public void setPaymentDueCccyamt(Cccyamt paymentDueCccyamt) {
        this.paymentDueCccyamt = paymentDueCccyamt;
    }

    public Cccyamt getSpecialProcessingExpiryPayOffCccyamt() {
        return specialProcessingExpiryPayOffCccyamt;
    }

    public void setSpecialProcessingExpiryPayOffCccyamt(Cccyamt specialProcessingExpiryPayOffCccyamt) {
        this.specialProcessingExpiryPayOffCccyamt = specialProcessingExpiryPayOffCccyamt;
    }

    public Integer getPaidInFullRemainingPaymentCnt() {
        return paidInFullRemainingPaymentCnt;
    }

    public void setPaidInFullRemainingPaymentCnt(Integer paidInFullRemainingPaymentCnt) {
        this.paidInFullRemainingPaymentCnt = paidInFullRemainingPaymentCnt;
    }

    public String getNextPaymentDueDt() {
        return nextPaymentDueDt;
    }

    public void setNextPaymentDueDt(String nextPaymentDueDt) {
        this.nextPaymentDueDt = nextPaymentDueDt;
    }

    public String getEventEndDt() {
        return eventEndDt;
    }

    public void setEventEndDt(String eventEndDt) {
        this.eventEndDt = eventEndDt;
    }

    public Date getPostedDttm() {
        return postedDttm;
    }

    public void setPostedDttm(Date postedDttm) {
        this.postedDttm = postedDttm;
    }

    public String getPostedDt() {
        return postedDt;
    }

    public void setPostedDt(String postedDt) {
        this.postedDt = postedDt;
    }

    public String getPostedTimeVal() {
        return postedTimeVal;
    }

    public void setPostedTimeVal(String postedTimeVal) {
        this.postedTimeVal = postedTimeVal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RetailEvent.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("termBalanceCd");
        sb.append('=');
        sb.append(((this.termBalanceCd == null)?"<null>":this.termBalanceCd));
        sb.append(',');
        sb.append("categoryInfo");
        sb.append('=');
        sb.append(((this.categoryInfo == null)?"<null>":this.categoryInfo));
        sb.append(',');
        sb.append("outstandingCccyamt");
        sb.append('=');
        sb.append(((this.outstandingCccyamt == null)?"<null>":this.outstandingCccyamt));
        sb.append(',');
        sb.append("financeChargeCccyamt");
        sb.append('=');
        sb.append(((this.financeChargeCccyamt == null)?"<null>":this.financeChargeCccyamt));
        sb.append(',');
        sb.append("statementDataDt");
        sb.append('=');
        sb.append(((this.statementDataDt == null)?"<null>":this.statementDataDt));
        sb.append(',');
        sb.append("eventDttm");
        sb.append('=');
        sb.append(((this.eventDttm == null)?"<null>":this.eventDttm));
        sb.append(',');
        sb.append("transactionLevelProcessingTypeCd");
        sb.append('=');
        sb.append(((this.transactionLevelProcessingTypeCd == null)?"<null>":this.transactionLevelProcessingTypeCd));
        sb.append(',');
        sb.append("acquirerReferenceNum");
        sb.append('=');
        sb.append(((this.acquirerReferenceNum == null)?"<null>":this.acquirerReferenceNum));
        sb.append(',');
        sb.append("paidInFullPadCccyamt");
        sb.append('=');
        sb.append(((this.paidInFullPadCccyamt == null)?"<null>":this.paidInFullPadCccyamt));
        sb.append(',');
        sb.append("deferredOutstandingBalanceCccyamt");
        sb.append('=');
        sb.append(((this.deferredOutstandingBalanceCccyamt == null)?"<null>":this.deferredOutstandingBalanceCccyamt));
        sb.append(',');
        sb.append("disputedInd");
        sb.append('=');
        sb.append(((this.disputedInd == null)?"<null>":this.disputedInd));
        sb.append(',');
        sb.append("eventTransactionCccyamt");
        sb.append('=');
        sb.append(((this.eventTransactionCccyamt == null)?"<null>":this.eventTransactionCccyamt));
        sb.append(',');
        sb.append("eventId");
        sb.append('=');
        sb.append(((this.eventId == null)?"<null>":this.eventId));
        sb.append(',');
        sb.append("currentCycleInfo");
        sb.append('=');
        sb.append(((this.currentCycleInfo == null)?"<null>":this.currentCycleInfo));
        sb.append(',');
        sb.append("previousCycleInfo");
        sb.append('=');
        sb.append(((this.previousCycleInfo == null)?"<null>":this.previousCycleInfo));
        sb.append(',');
        sb.append("billedFinanceChargeCccyamt");
        sb.append('=');
        sb.append(((this.billedFinanceChargeCccyamt == null)?"<null>":this.billedFinanceChargeCccyamt));
        sb.append(',');
        sb.append("transactionLevelProcessingReferenceNum");
        sb.append('=');
        sb.append(((this.transactionLevelProcessingReferenceNum == null)?"<null>":this.transactionLevelProcessingReferenceNum));
        sb.append(',');
        sb.append("transactionLevelProcessingPromotionId");
        sb.append('=');
        sb.append(((this.transactionLevelProcessingPromotionId == null)?"<null>":this.transactionLevelProcessingPromotionId));
        sb.append(',');
        sb.append("instalmentTransactionInd");
        sb.append('=');
        sb.append(((this.instalmentTransactionInd == null)?"<null>":this.instalmentTransactionInd));
        sb.append(',');
        sb.append("merchantDoingBusinessAsName");
        sb.append('=');
        sb.append(((this.merchantDoingBusinessAsName == null)?"<null>":this.merchantDoingBusinessAsName));
        sb.append(',');
        sb.append("paymentOption");
        sb.append('=');
        sb.append(((this.paymentOption == null)?"<null>":this.paymentOption));
        sb.append(',');
        sb.append("paymentDueCccyamt");
        sb.append('=');
        sb.append(((this.paymentDueCccyamt == null)?"<null>":this.paymentDueCccyamt));
        sb.append(',');
        sb.append("specialProcessingExpiryPayOffCccyamt");
        sb.append('=');
        sb.append(((this.specialProcessingExpiryPayOffCccyamt == null)?"<null>":this.specialProcessingExpiryPayOffCccyamt));
        sb.append(',');
        sb.append("paidInFullRemainingPaymentCnt");
        sb.append('=');
        sb.append(((this.paidInFullRemainingPaymentCnt == null)?"<null>":this.paidInFullRemainingPaymentCnt));
        sb.append(',');
        sb.append("nextPaymentDueDt");
        sb.append('=');
        sb.append(((this.nextPaymentDueDt == null)?"<null>":this.nextPaymentDueDt));
        sb.append(',');
        sb.append("eventEndDt");
        sb.append('=');
        sb.append(((this.eventEndDt == null)?"<null>":this.eventEndDt));
        sb.append(',');
        sb.append("postedDttm");
        sb.append('=');
        sb.append(((this.postedDttm == null)?"<null>":this.postedDttm));
        sb.append(',');
        sb.append("postedDt");
        sb.append('=');
        sb.append(((this.postedDt == null)?"<null>":this.postedDt));
        sb.append(',');
        sb.append("postedTimeVal");
        sb.append('=');
        sb.append(((this.postedTimeVal == null)?"<null>":this.postedTimeVal));
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
        result = ((result* 31)+((this.disputedInd == null)? 0 :this.disputedInd.hashCode()));
        result = ((result* 31)+((this.postedDt == null)? 0 :this.postedDt.hashCode()));
        result = ((result* 31)+((this.previousCycleInfo == null)? 0 :this.previousCycleInfo.hashCode()));
        result = ((result* 31)+((this.transactionLevelProcessingPromotionId == null)? 0 :this.transactionLevelProcessingPromotionId.hashCode()));
        result = ((result* 31)+((this.eventTransactionCccyamt == null)? 0 :this.eventTransactionCccyamt.hashCode()));
        result = ((result* 31)+((this.specialProcessingExpiryPayOffCccyamt == null)? 0 :this.specialProcessingExpiryPayOffCccyamt.hashCode()));
        result = ((result* 31)+((this.transactionLevelProcessingReferenceNum == null)? 0 :this.transactionLevelProcessingReferenceNum.hashCode()));
        result = ((result* 31)+((this.nextPaymentDueDt == null)? 0 :this.nextPaymentDueDt.hashCode()));
        result = ((result* 31)+((this.instalmentTransactionInd == null)? 0 :this.instalmentTransactionInd.hashCode()));
        result = ((result* 31)+((this.paymentOption == null)? 0 :this.paymentOption.hashCode()));
        result = ((result* 31)+((this.paymentDueCccyamt == null)? 0 :this.paymentDueCccyamt.hashCode()));
        result = ((result* 31)+((this.financeChargeCccyamt == null)? 0 :this.financeChargeCccyamt.hashCode()));
        result = ((result* 31)+((this.eventDttm == null)? 0 :this.eventDttm.hashCode()));
        result = ((result* 31)+((this.transactionLevelProcessingTypeCd == null)? 0 :this.transactionLevelProcessingTypeCd.hashCode()));
        result = ((result* 31)+((this.outstandingCccyamt == null)? 0 :this.outstandingCccyamt.hashCode()));
        result = ((result* 31)+((this.eventId == null)? 0 :this.eventId.hashCode()));
        result = ((result* 31)+((this.paidInFullPadCccyamt == null)? 0 :this.paidInFullPadCccyamt.hashCode()));
        result = ((result* 31)+((this.postedDttm == null)? 0 :this.postedDttm.hashCode()));
        result = ((result* 31)+((this.eventEndDt == null)? 0 :this.eventEndDt.hashCode()));
        result = ((result* 31)+((this.postedTimeVal == null)? 0 :this.postedTimeVal.hashCode()));
        result = ((result* 31)+((this.deferredOutstandingBalanceCccyamt == null)? 0 :this.deferredOutstandingBalanceCccyamt.hashCode()));
        result = ((result* 31)+((this.categoryInfo == null)? 0 :this.categoryInfo.hashCode()));
        result = ((result* 31)+((this.paidInFullRemainingPaymentCnt == null)? 0 :this.paidInFullRemainingPaymentCnt.hashCode()));
        result = ((result* 31)+((this.billedFinanceChargeCccyamt == null)? 0 :this.billedFinanceChargeCccyamt.hashCode()));
        result = ((result* 31)+((this.currentCycleInfo == null)? 0 :this.currentCycleInfo.hashCode()));
        result = ((result* 31)+((this.statementDataDt == null)? 0 :this.statementDataDt.hashCode()));
        result = ((result* 31)+((this.merchantDoingBusinessAsName == null)? 0 :this.merchantDoingBusinessAsName.hashCode()));
        result = ((result* 31)+((this.termBalanceCd == null)? 0 :this.termBalanceCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RetailEvent) == false) {
            return false;
        }
        RetailEvent rhs = ((RetailEvent) other);
        return ((((((((((((((((((((((((((((((this.acquirerReferenceNum == rhs.acquirerReferenceNum)||((this.acquirerReferenceNum!= null)&&this.acquirerReferenceNum.equals(rhs.acquirerReferenceNum)))&&((this.disputedInd == rhs.disputedInd)||((this.disputedInd!= null)&&this.disputedInd.equals(rhs.disputedInd))))&&((this.postedDt == rhs.postedDt)||((this.postedDt!= null)&&this.postedDt.equals(rhs.postedDt))))&&((this.previousCycleInfo == rhs.previousCycleInfo)||((this.previousCycleInfo!= null)&&this.previousCycleInfo.equals(rhs.previousCycleInfo))))&&((this.transactionLevelProcessingPromotionId == rhs.transactionLevelProcessingPromotionId)||((this.transactionLevelProcessingPromotionId!= null)&&this.transactionLevelProcessingPromotionId.equals(rhs.transactionLevelProcessingPromotionId))))&&((this.eventTransactionCccyamt == rhs.eventTransactionCccyamt)||((this.eventTransactionCccyamt!= null)&&this.eventTransactionCccyamt.equals(rhs.eventTransactionCccyamt))))&&((this.specialProcessingExpiryPayOffCccyamt == rhs.specialProcessingExpiryPayOffCccyamt)||((this.specialProcessingExpiryPayOffCccyamt!= null)&&this.specialProcessingExpiryPayOffCccyamt.equals(rhs.specialProcessingExpiryPayOffCccyamt))))&&((this.transactionLevelProcessingReferenceNum == rhs.transactionLevelProcessingReferenceNum)||((this.transactionLevelProcessingReferenceNum!= null)&&this.transactionLevelProcessingReferenceNum.equals(rhs.transactionLevelProcessingReferenceNum))))&&((this.nextPaymentDueDt == rhs.nextPaymentDueDt)||((this.nextPaymentDueDt!= null)&&this.nextPaymentDueDt.equals(rhs.nextPaymentDueDt))))&&((this.instalmentTransactionInd == rhs.instalmentTransactionInd)||((this.instalmentTransactionInd!= null)&&this.instalmentTransactionInd.equals(rhs.instalmentTransactionInd))))&&((this.paymentOption == rhs.paymentOption)||((this.paymentOption!= null)&&this.paymentOption.equals(rhs.paymentOption))))&&((this.paymentDueCccyamt == rhs.paymentDueCccyamt)||((this.paymentDueCccyamt!= null)&&this.paymentDueCccyamt.equals(rhs.paymentDueCccyamt))))&&((this.financeChargeCccyamt == rhs.financeChargeCccyamt)||((this.financeChargeCccyamt!= null)&&this.financeChargeCccyamt.equals(rhs.financeChargeCccyamt))))&&((this.eventDttm == rhs.eventDttm)||((this.eventDttm!= null)&&this.eventDttm.equals(rhs.eventDttm))))&&((this.transactionLevelProcessingTypeCd == rhs.transactionLevelProcessingTypeCd)||((this.transactionLevelProcessingTypeCd!= null)&&this.transactionLevelProcessingTypeCd.equals(rhs.transactionLevelProcessingTypeCd))))&&((this.outstandingCccyamt == rhs.outstandingCccyamt)||((this.outstandingCccyamt!= null)&&this.outstandingCccyamt.equals(rhs.outstandingCccyamt))))&&((this.eventId == rhs.eventId)||((this.eventId!= null)&&this.eventId.equals(rhs.eventId))))&&((this.paidInFullPadCccyamt == rhs.paidInFullPadCccyamt)||((this.paidInFullPadCccyamt!= null)&&this.paidInFullPadCccyamt.equals(rhs.paidInFullPadCccyamt))))&&((this.postedDttm == rhs.postedDttm)||((this.postedDttm!= null)&&this.postedDttm.equals(rhs.postedDttm))))&&((this.eventEndDt == rhs.eventEndDt)||((this.eventEndDt!= null)&&this.eventEndDt.equals(rhs.eventEndDt))))&&((this.postedTimeVal == rhs.postedTimeVal)||((this.postedTimeVal!= null)&&this.postedTimeVal.equals(rhs.postedTimeVal))))&&((this.deferredOutstandingBalanceCccyamt == rhs.deferredOutstandingBalanceCccyamt)||((this.deferredOutstandingBalanceCccyamt!= null)&&this.deferredOutstandingBalanceCccyamt.equals(rhs.deferredOutstandingBalanceCccyamt))))&&((this.categoryInfo == rhs.categoryInfo)||((this.categoryInfo!= null)&&this.categoryInfo.equals(rhs.categoryInfo))))&&((this.paidInFullRemainingPaymentCnt == rhs.paidInFullRemainingPaymentCnt)||((this.paidInFullRemainingPaymentCnt!= null)&&this.paidInFullRemainingPaymentCnt.equals(rhs.paidInFullRemainingPaymentCnt))))&&((this.billedFinanceChargeCccyamt == rhs.billedFinanceChargeCccyamt)||((this.billedFinanceChargeCccyamt!= null)&&this.billedFinanceChargeCccyamt.equals(rhs.billedFinanceChargeCccyamt))))&&((this.currentCycleInfo == rhs.currentCycleInfo)||((this.currentCycleInfo!= null)&&this.currentCycleInfo.equals(rhs.currentCycleInfo))))&&((this.statementDataDt == rhs.statementDataDt)||((this.statementDataDt!= null)&&this.statementDataDt.equals(rhs.statementDataDt))))&&((this.merchantDoingBusinessAsName == rhs.merchantDoingBusinessAsName)||((this.merchantDoingBusinessAsName!= null)&&this.merchantDoingBusinessAsName.equals(rhs.merchantDoingBusinessAsName))))&&((this.termBalanceCd == rhs.termBalanceCd)||((this.termBalanceCd!= null)&&this.termBalanceCd.equals(rhs.termBalanceCd))));
    }

}
