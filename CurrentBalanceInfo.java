package com.td.api.mbcca.response.account;

import com.td.api.mbcca.shared.Cccyamt;

public class CurrentBalanceInfo {

    private String transactionCategoryCd;
    private String termBalanceCd;
    private Cccyamt outstandingBalanceCccyamt;
    private Cccyamt previousCycleUnpaidBalanceCccyamt;
    private Cccyamt financeChargeOutstandingCccyamt;
    private String financeChargeTypeCd;
    private Boolean minimumPaymentDeferredInd;
    private Boolean financeChargeDeferredInd;
    private Boolean billedBalanceOutstandingInd;
    private Boolean balanceSubjectToFinanceChargeInd;
    private Cccyamt principlePaymentDueCccyamt;
    private Cccyamt previousPrincipleBalanceCccyamt;
    private Cccyamt previousFinanceChargeBalanceCccyamt;
    private Cccyamt deferredFinanceChargeCccyamt;
    private Cccyamt balanceSegmentInDisputeCccyamt;
    private Cccyamt cycleToDateAppliedCreditsCccyamt;
    private Cccyamt cycleToDateAppliedDebitsCccyamt;
    private Cccyamt cycleToDateAppliedPaymentsCccyamt;
    private Cccyamt cycleToDatePostedDebitsCccyamt;
    private Integer cycleToDatePostedDebitsCnt;
    private Cccyamt cycleToDatePostedCreditsCccyamt;
    private Integer cycleToDatePostedCreditsCnt;
    private Cccyamt cycleToDatePostedDebitAdjustmentCccyamt;
    private Integer cycleToDatePostedDebitAdjustmentCnt;
    private Cccyamt cycleToDatePostedCreditAdjustmentCccyamt;
    private Integer cycleToDatePostedCreditAdjustmentCnt;
    private Cccyamt cycleToDatePostedFinanceChargeCreditsCccyamt;
    private Cccyamt cycleToDatePostedFinanceChargeDebitsCccyamt;
    private String transactionCategorySpecialProcessingExpiryDt;
    private Cccyamt foreignExchangeFeeCccyamt;
    private String transactionCategoryDesc;
    private String newTransactionCategoryCd;
    private String newTermBalanceCd;
    private String newTransactionCategoryDesc;
    private String promotionId;
    private String termCodeDesc;
    private Boolean retailTransactionInd;
    private Cccyamt totalOutstandingBalanceCccyamt;
    private Cccyamt previousCycleOutstandingBalanceCccyamt;
    private Cccyamt currentDayPendingTermTransferCccyamt;

    public String getTransactionCategoryCd() {
        return transactionCategoryCd;
    }

    public void setTransactionCategoryCd(String transactionCategoryCd) {
        this.transactionCategoryCd = transactionCategoryCd;
    }

    public String getTermBalanceCd() {
        return termBalanceCd;
    }

    public void setTermBalanceCd(String termBalanceCd) {
        this.termBalanceCd = termBalanceCd;
    }

    public Cccyamt getOutstandingBalanceCccyamt() {
        return outstandingBalanceCccyamt;
    }

    public void setOutstandingBalanceCccyamt(Cccyamt outstandingBalanceCccyamt) {
        this.outstandingBalanceCccyamt = outstandingBalanceCccyamt;
    }

    public Cccyamt getPreviousCycleUnpaidBalanceCccyamt() {
        return previousCycleUnpaidBalanceCccyamt;
    }

    public void setPreviousCycleUnpaidBalanceCccyamt(Cccyamt previousCycleUnpaidBalanceCccyamt) {
        this.previousCycleUnpaidBalanceCccyamt = previousCycleUnpaidBalanceCccyamt;
    }

    public Cccyamt getFinanceChargeOutstandingCccyamt() {
        return financeChargeOutstandingCccyamt;
    }

    public void setFinanceChargeOutstandingCccyamt(Cccyamt financeChargeOutstandingCccyamt) {
        this.financeChargeOutstandingCccyamt = financeChargeOutstandingCccyamt;
    }

    public String getFinanceChargeTypeCd() {
        return financeChargeTypeCd;
    }

    public void setFinanceChargeTypeCd(String financeChargeTypeCd) {
        this.financeChargeTypeCd = financeChargeTypeCd;
    }

    public Boolean getMinimumPaymentDeferredInd() {
        return minimumPaymentDeferredInd;
    }

    public void setMinimumPaymentDeferredInd(Boolean minimumPaymentDeferredInd) {
        this.minimumPaymentDeferredInd = minimumPaymentDeferredInd;
    }

    public Boolean getFinanceChargeDeferredInd() {
        return financeChargeDeferredInd;
    }

    public void setFinanceChargeDeferredInd(Boolean financeChargeDeferredInd) {
        this.financeChargeDeferredInd = financeChargeDeferredInd;
    }

    public Boolean getBilledBalanceOutstandingInd() {
        return billedBalanceOutstandingInd;
    }

    public void setBilledBalanceOutstandingInd(Boolean billedBalanceOutstandingInd) {
        this.billedBalanceOutstandingInd = billedBalanceOutstandingInd;
    }

    public Boolean getBalanceSubjectToFinanceChargeInd() {
        return balanceSubjectToFinanceChargeInd;
    }

    public void setBalanceSubjectToFinanceChargeInd(Boolean balanceSubjectToFinanceChargeInd) {
        this.balanceSubjectToFinanceChargeInd = balanceSubjectToFinanceChargeInd;
    }

    public Cccyamt getPrinciplePaymentDueCccyamt() {
        return principlePaymentDueCccyamt;
    }

    public void setPrinciplePaymentDueCccyamt(Cccyamt principlePaymentDueCccyamt) {
        this.principlePaymentDueCccyamt = principlePaymentDueCccyamt;
    }

    public Cccyamt getPreviousPrincipleBalanceCccyamt() {
        return previousPrincipleBalanceCccyamt;
    }

    public void setPreviousPrincipleBalanceCccyamt(Cccyamt previousPrincipleBalanceCccyamt) {
        this.previousPrincipleBalanceCccyamt = previousPrincipleBalanceCccyamt;
    }

    public Cccyamt getPreviousFinanceChargeBalanceCccyamt() {
        return previousFinanceChargeBalanceCccyamt;
    }

    public void setPreviousFinanceChargeBalanceCccyamt(Cccyamt previousFinanceChargeBalanceCccyamt) {
        this.previousFinanceChargeBalanceCccyamt = previousFinanceChargeBalanceCccyamt;
    }

    public Cccyamt getDeferredFinanceChargeCccyamt() {
        return deferredFinanceChargeCccyamt;
    }

    public void setDeferredFinanceChargeCccyamt(Cccyamt deferredFinanceChargeCccyamt) {
        this.deferredFinanceChargeCccyamt = deferredFinanceChargeCccyamt;
    }

    public Cccyamt getBalanceSegmentInDisputeCccyamt() {
        return balanceSegmentInDisputeCccyamt;
    }

    public void setBalanceSegmentInDisputeCccyamt(Cccyamt balanceSegmentInDisputeCccyamt) {
        this.balanceSegmentInDisputeCccyamt = balanceSegmentInDisputeCccyamt;
    }

    public Cccyamt getCycleToDateAppliedCreditsCccyamt() {
        return cycleToDateAppliedCreditsCccyamt;
    }

    public void setCycleToDateAppliedCreditsCccyamt(Cccyamt cycleToDateAppliedCreditsCccyamt) {
        this.cycleToDateAppliedCreditsCccyamt = cycleToDateAppliedCreditsCccyamt;
    }

    public Cccyamt getCycleToDateAppliedDebitsCccyamt() {
        return cycleToDateAppliedDebitsCccyamt;
    }

    public void setCycleToDateAppliedDebitsCccyamt(Cccyamt cycleToDateAppliedDebitsCccyamt) {
        this.cycleToDateAppliedDebitsCccyamt = cycleToDateAppliedDebitsCccyamt;
    }

    public Cccyamt getCycleToDateAppliedPaymentsCccyamt() {
        return cycleToDateAppliedPaymentsCccyamt;
    }

    public void setCycleToDateAppliedPaymentsCccyamt(Cccyamt cycleToDateAppliedPaymentsCccyamt) {
        this.cycleToDateAppliedPaymentsCccyamt = cycleToDateAppliedPaymentsCccyamt;
    }

    public Cccyamt getCycleToDatePostedDebitsCccyamt() {
        return cycleToDatePostedDebitsCccyamt;
    }

    public void setCycleToDatePostedDebitsCccyamt(Cccyamt cycleToDatePostedDebitsCccyamt) {
        this.cycleToDatePostedDebitsCccyamt = cycleToDatePostedDebitsCccyamt;
    }

    public Integer getCycleToDatePostedDebitsCnt() {
        return cycleToDatePostedDebitsCnt;
    }

    public void setCycleToDatePostedDebitsCnt(Integer cycleToDatePostedDebitsCnt) {
        this.cycleToDatePostedDebitsCnt = cycleToDatePostedDebitsCnt;
    }

    public Cccyamt getCycleToDatePostedCreditsCccyamt() {
        return cycleToDatePostedCreditsCccyamt;
    }

    public void setCycleToDatePostedCreditsCccyamt(Cccyamt cycleToDatePostedCreditsCccyamt) {
        this.cycleToDatePostedCreditsCccyamt = cycleToDatePostedCreditsCccyamt;
    }

    public Integer getCycleToDatePostedCreditsCnt() {
        return cycleToDatePostedCreditsCnt;
    }

    public void setCycleToDatePostedCreditsCnt(Integer cycleToDatePostedCreditsCnt) {
        this.cycleToDatePostedCreditsCnt = cycleToDatePostedCreditsCnt;
    }

    public Cccyamt getCycleToDatePostedDebitAdjustmentCccyamt() {
        return cycleToDatePostedDebitAdjustmentCccyamt;
    }

    public void setCycleToDatePostedDebitAdjustmentCccyamt(Cccyamt cycleToDatePostedDebitAdjustmentCccyamt) {
        this.cycleToDatePostedDebitAdjustmentCccyamt = cycleToDatePostedDebitAdjustmentCccyamt;
    }

    public Integer getCycleToDatePostedDebitAdjustmentCnt() {
        return cycleToDatePostedDebitAdjustmentCnt;
    }

    public void setCycleToDatePostedDebitAdjustmentCnt(Integer cycleToDatePostedDebitAdjustmentCnt) {
        this.cycleToDatePostedDebitAdjustmentCnt = cycleToDatePostedDebitAdjustmentCnt;
    }

    public Cccyamt getCycleToDatePostedCreditAdjustmentCccyamt() {
        return cycleToDatePostedCreditAdjustmentCccyamt;
    }

    public void setCycleToDatePostedCreditAdjustmentCccyamt(Cccyamt cycleToDatePostedCreditAdjustmentCccyamt) {
        this.cycleToDatePostedCreditAdjustmentCccyamt = cycleToDatePostedCreditAdjustmentCccyamt;
    }

    public Integer getCycleToDatePostedCreditAdjustmentCnt() {
        return cycleToDatePostedCreditAdjustmentCnt;
    }

    public void setCycleToDatePostedCreditAdjustmentCnt(Integer cycleToDatePostedCreditAdjustmentCnt) {
        this.cycleToDatePostedCreditAdjustmentCnt = cycleToDatePostedCreditAdjustmentCnt;
    }

    public Cccyamt getCycleToDatePostedFinanceChargeCreditsCccyamt() {
        return cycleToDatePostedFinanceChargeCreditsCccyamt;
    }

    public void setCycleToDatePostedFinanceChargeCreditsCccyamt(Cccyamt cycleToDatePostedFinanceChargeCreditsCccyamt) {
        this.cycleToDatePostedFinanceChargeCreditsCccyamt = cycleToDatePostedFinanceChargeCreditsCccyamt;
    }

    public Cccyamt getCycleToDatePostedFinanceChargeDebitsCccyamt() {
        return cycleToDatePostedFinanceChargeDebitsCccyamt;
    }

    public void setCycleToDatePostedFinanceChargeDebitsCccyamt(Cccyamt cycleToDatePostedFinanceChargeDebitsCccyamt) {
        this.cycleToDatePostedFinanceChargeDebitsCccyamt = cycleToDatePostedFinanceChargeDebitsCccyamt;
    }

    public String getTransactionCategorySpecialProcessingExpiryDt() {
        return transactionCategorySpecialProcessingExpiryDt;
    }

    public void setTransactionCategorySpecialProcessingExpiryDt(String transactionCategorySpecialProcessingExpiryDt) {
        this.transactionCategorySpecialProcessingExpiryDt = transactionCategorySpecialProcessingExpiryDt;
    }

    public Cccyamt getForeignExchangeFeeCccyamt() {
        return foreignExchangeFeeCccyamt;
    }

    public void setForeignExchangeFeeCccyamt(Cccyamt foreignExchangeFeeCccyamt) {
        this.foreignExchangeFeeCccyamt = foreignExchangeFeeCccyamt;
    }

    public String getTransactionCategoryDesc() {
        return transactionCategoryDesc;
    }

    public void setTransactionCategoryDesc(String transactionCategoryDesc) {
        this.transactionCategoryDesc = transactionCategoryDesc;
    }

    public String getNewTransactionCategoryCd() {
        return newTransactionCategoryCd;
    }

    public void setNewTransactionCategoryCd(String newTransactionCategoryCd) {
        this.newTransactionCategoryCd = newTransactionCategoryCd;
    }

    public String getNewTermBalanceCd() {
        return newTermBalanceCd;
    }

    public void setNewTermBalanceCd(String newTermBalanceCd) {
        this.newTermBalanceCd = newTermBalanceCd;
    }

    public String getNewTransactionCategoryDesc() {
        return newTransactionCategoryDesc;
    }

    public void setNewTransactionCategoryDesc(String newTransactionCategoryDesc) {
        this.newTransactionCategoryDesc = newTransactionCategoryDesc;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }
    public String getTermCodeDesc() {
        return termCodeDesc;
    }

    public void setTermCodeDesc(String termCodeDesc) {
        this.termCodeDesc = termCodeDesc;
    }

    public Boolean getRetailTransactionInd() {
        return retailTransactionInd;
    }

    public void setRetailTransactionInd(Boolean retailTransactionInd) {
        this.retailTransactionInd = retailTransactionInd;
    }

    public Cccyamt getTotalOutstandingBalanceCccyamt() {
        return totalOutstandingBalanceCccyamt;
    }
    public void setTotalOutstandingBalanceCccyamt(Cccyamt totalOutstandingBalanceCccyamt) {
        this.totalOutstandingBalanceCccyamt = totalOutstandingBalanceCccyamt;
    }

    public Cccyamt getPreviousCycleOutstandingBalanceCccyamt() {
        return previousCycleOutstandingBalanceCccyamt;
    }

    public void setPreviousCycleOutstandingBalanceCccyamt(Cccyamt previousCycleOutstandingBalanceCccyamt) {
        this.previousCycleOutstandingBalanceCccyamt = previousCycleOutstandingBalanceCccyamt;
    }

    public Cccyamt getCurrentDayPendingTermTransferCccyamt() {
        return currentDayPendingTermTransferCccyamt;
    }

    public void setCurrentDayPendingTermTransferCccyamt(Cccyamt currentDayPendingTermTransferCccyamt) {
        this.currentDayPendingTermTransferCccyamt = currentDayPendingTermTransferCccyamt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CurrentBalanceInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("transactionCategoryCd");
        sb.append('=');
        sb.append(((this.transactionCategoryCd == null)?"<null>":this.transactionCategoryCd));
        sb.append(',');
        sb.append("termBalanceCd");
        sb.append('=');
        sb.append(((this.termBalanceCd == null)?"<null>":this.termBalanceCd));
        sb.append(',');
        sb.append("outstandingBalanceCccyamt");
        sb.append('=');
        sb.append(((this.outstandingBalanceCccyamt == null)?"<null>":this.outstandingBalanceCccyamt));
        sb.append(',');
        sb.append("previousCycleUnpaidBalanceCccyamt");
        sb.append('=');
        sb.append(((this.previousCycleUnpaidBalanceCccyamt == null)?"<null>":this.previousCycleUnpaidBalanceCccyamt));
        sb.append(',');
        sb.append("financeChargeOutstandingCccyamt");
        sb.append('=');
        sb.append(((this.financeChargeOutstandingCccyamt == null)?"<null>":this.financeChargeOutstandingCccyamt));
        sb.append(',');
        sb.append("financeChargeTypeCd");
        sb.append('=');
        sb.append(((this.financeChargeTypeCd == null)?"<null>":this.financeChargeTypeCd));
        sb.append(',');
        sb.append("minimumPaymentDeferredInd");
        sb.append('=');
        sb.append(((this.minimumPaymentDeferredInd == null)?"<null>":this.minimumPaymentDeferredInd));
        sb.append(',');
        sb.append("financeChargeDeferredInd");
        sb.append('=');
        sb.append(((this.financeChargeDeferredInd == null)?"<null>":this.financeChargeDeferredInd));
        sb.append(',');
        sb.append("billedBalanceOutstandingInd");
        sb.append('=');
        sb.append(((this.billedBalanceOutstandingInd == null)?"<null>":this.billedBalanceOutstandingInd));
        sb.append(',');
        sb.append("balanceSubjectToFinanceChargeInd");
        sb.append('=');
        sb.append(((this.balanceSubjectToFinanceChargeInd == null)?"<null>":this.balanceSubjectToFinanceChargeInd));
        sb.append(',');
        sb.append("principlePaymentDueCccyamt");
        sb.append('=');
        sb.append(((this.principlePaymentDueCccyamt == null)?"<null>":this.principlePaymentDueCccyamt));
        sb.append(',');
        sb.append("previousPrincipleBalanceCccyamt");
        sb.append('=');
        sb.append(((this.previousPrincipleBalanceCccyamt == null)?"<null>":this.previousPrincipleBalanceCccyamt));
        sb.append(',');
        sb.append("previousFinanceChargeBalanceCccyamt");
        sb.append('=');
        sb.append(((this.previousFinanceChargeBalanceCccyamt == null)?"<null>":this.previousFinanceChargeBalanceCccyamt));
        sb.append(',');
        sb.append("deferredFinanceChargeCccyamt");
        sb.append('=');
        sb.append(((this.deferredFinanceChargeCccyamt == null)?"<null>":this.deferredFinanceChargeCccyamt));
        sb.append(',');
        sb.append("balanceSegmentInDisputeCccyamt");
        sb.append('=');
        sb.append(((this.balanceSegmentInDisputeCccyamt == null)?"<null>":this.balanceSegmentInDisputeCccyamt));
        sb.append(',');
        sb.append("cycleToDateAppliedCreditsCccyamt");
        sb.append('=');
        sb.append(((this.cycleToDateAppliedCreditsCccyamt == null)?"<null>":this.cycleToDateAppliedCreditsCccyamt));
        sb.append(',');
        sb.append("cycleToDateAppliedDebitsCccyamt");
        sb.append('=');
        sb.append(((this.cycleToDateAppliedDebitsCccyamt == null)?"<null>":this.cycleToDateAppliedDebitsCccyamt));
        sb.append(',');
        sb.append("cycleToDateAppliedPaymentsCccyamt");
        sb.append('=');
        sb.append(((this.cycleToDateAppliedPaymentsCccyamt == null)?"<null>":this.cycleToDateAppliedPaymentsCccyamt));
        sb.append(',');
        sb.append("cycleToDatePostedDebitsCccyamt");
        sb.append('=');
        sb.append(((this.cycleToDatePostedDebitsCccyamt == null)?"<null>":this.cycleToDatePostedDebitsCccyamt));
        sb.append(',');
        sb.append("cycleToDatePostedDebitsCnt");
        sb.append('=');
        sb.append(((this.cycleToDatePostedDebitsCnt == null)?"<null>":this.cycleToDatePostedDebitsCnt));
        sb.append(',');
        sb.append("cycleToDatePostedCreditsCccyamt");
        sb.append('=');
        sb.append(((this.cycleToDatePostedCreditsCccyamt == null)?"<null>":this.cycleToDatePostedCreditsCccyamt));
        sb.append(',');
        sb.append("cycleToDatePostedCreditsCnt");
        sb.append('=');
        sb.append(((this.cycleToDatePostedCreditsCnt == null)?"<null>":this.cycleToDatePostedCreditsCnt));
        sb.append(',');
        sb.append("cycleToDatePostedDebitAdjustmentCccyamt");
        sb.append('=');
        sb.append(((this.cycleToDatePostedDebitAdjustmentCccyamt == null)?"<null>":this.cycleToDatePostedDebitAdjustmentCccyamt));
        sb.append(',');
        sb.append("cycleToDatePostedDebitAdjustmentCnt");
        sb.append('=');
        sb.append(((this.cycleToDatePostedDebitAdjustmentCnt == null)?"<null>":this.cycleToDatePostedDebitAdjustmentCnt));
        sb.append(',');
        sb.append("cycleToDatePostedCreditAdjustmentCccyamt");
        sb.append('=');
        sb.append(((this.cycleToDatePostedCreditAdjustmentCccyamt == null)?"<null>":this.cycleToDatePostedCreditAdjustmentCccyamt));
        sb.append(',');
        sb.append("cycleToDatePostedCreditAdjustmentCnt");
        sb.append('=');
        sb.append(((this.cycleToDatePostedCreditAdjustmentCnt == null)?"<null>":this.cycleToDatePostedCreditAdjustmentCnt));
        sb.append(',');
        sb.append("cycleToDatePostedFinanceChargeCreditsCccyamt");
        sb.append('=');
        sb.append(((this.cycleToDatePostedFinanceChargeCreditsCccyamt == null)?"<null>":this.cycleToDatePostedFinanceChargeCreditsCccyamt));
        sb.append(',');
        sb.append("cycleToDatePostedFinanceChargeDebitsCccyamt");
        sb.append('=');
        sb.append(((this.cycleToDatePostedFinanceChargeDebitsCccyamt == null)?"<null>":this.cycleToDatePostedFinanceChargeDebitsCccyamt));
        sb.append(',');
        sb.append("transactionCategorySpecialProcessingExpiryDt");
        sb.append('=');
        sb.append(((this.transactionCategorySpecialProcessingExpiryDt == null)?"<null>":this.transactionCategorySpecialProcessingExpiryDt));
        sb.append(',');
        sb.append("foreignExchangeFeeCccyamt");
        sb.append('=');
        sb.append(((this.foreignExchangeFeeCccyamt == null)?"<null>":this.foreignExchangeFeeCccyamt));
        sb.append(',');
        sb.append("transactionCategoryDesc");
        sb.append('=');
        sb.append(((this.transactionCategoryDesc == null)?"<null>":this.transactionCategoryDesc));
        sb.append(',');
        sb.append("newTransactionCategoryCd");
        sb.append('=');
        sb.append(((this.newTransactionCategoryCd == null)?"<null>":this.newTransactionCategoryCd));
        sb.append(',');
        sb.append("newTermBalanceCd");
        sb.append('=');
        sb.append(((this.newTermBalanceCd == null)?"<null>":this.newTermBalanceCd));
        sb.append(',');
        sb.append("newTransactionCategoryDesc");
        sb.append('=');
        sb.append(((this.newTransactionCategoryDesc == null)?"<null>":this.newTransactionCategoryDesc));
        sb.append(',');
        sb.append("promotionId");
        sb.append('=');
        sb.append(((this.promotionId == null)?"<null>":this.promotionId));
        sb.append(',');
        sb.append("termCodeDesc");
        sb.append('=');
        sb.append(((this.termCodeDesc == null)?"<null>":this.termCodeDesc));
        sb.append(',');
        sb.append("retailTransactionInd");
        sb.append('=');
        sb.append(((this.retailTransactionInd == null)?"<null>":this.retailTransactionInd));
        sb.append(',');
        sb.append("totalOutstandingBalanceCccyamt");
        sb.append('=');
        sb.append(((this.totalOutstandingBalanceCccyamt == null)?"<null>":this.totalOutstandingBalanceCccyamt));
        sb.append(',');
        sb.append("previousCycleOutstandingBalanceCccyamt");
        sb.append('=');
        sb.append(((this.previousCycleOutstandingBalanceCccyamt == null)?"<null>":this.previousCycleOutstandingBalanceCccyamt));
        sb.append(',');
        sb.append("currentDayPendingTermTransferCccyamt");
        sb.append('=');
        sb.append(((this.currentDayPendingTermTransferCccyamt == null)?"<null>":this.currentDayPendingTermTransferCccyamt));
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
        result = ((result* 31)+((this.cycleToDatePostedCreditsCccyamt == null)? 0 :this.cycleToDatePostedCreditsCccyamt.hashCode()));
        result = ((result* 31)+((this.cycleToDatePostedDebitAdjustmentCnt == null)? 0 :this.cycleToDatePostedDebitAdjustmentCnt.hashCode()));
        result = ((result* 31)+((this.cycleToDatePostedCreditsCnt == null)? 0 :this.cycleToDatePostedCreditsCnt.hashCode()));
        result = ((result* 31)+((this.totalOutstandingBalanceCccyamt == null)? 0 :this.totalOutstandingBalanceCccyamt.hashCode()));
        result = ((result* 31)+((this.cycleToDateAppliedDebitsCccyamt == null)? 0 :this.cycleToDateAppliedDebitsCccyamt.hashCode()));
        result = ((result* 31)+((this.newTransactionCategoryCd == null)? 0 :this.newTransactionCategoryCd.hashCode()));
        result = ((result* 31)+((this.previousFinanceChargeBalanceCccyamt == null)? 0 :this.previousFinanceChargeBalanceCccyamt.hashCode()));
        result = ((result* 31)+((this.cycleToDatePostedCreditAdjustmentCnt == null)? 0 :this.cycleToDatePostedCreditAdjustmentCnt.hashCode()));
        result = ((result* 31)+((this.termCodeDesc == null)? 0 :this.termCodeDesc.hashCode()));
        result = ((result* 31)+((this.promotionId == null)? 0 :this.promotionId.hashCode()));
        result = ((result* 31)+((this.previousCycleUnpaidBalanceCccyamt == null)? 0 :this.previousCycleUnpaidBalanceCccyamt.hashCode()));
        result = ((result* 31)+((this.balanceSubjectToFinanceChargeInd == null)? 0 :this.balanceSubjectToFinanceChargeInd.hashCode()));
        result = ((result* 31)+((this.transactionCategoryCd == null)? 0 :this.transactionCategoryCd.hashCode()));
        result = ((result* 31)+((this.cycleToDatePostedDebitsCnt == null)? 0 :this.cycleToDatePostedDebitsCnt.hashCode()));
        result = ((result* 31)+((this.financeChargeOutstandingCccyamt == null)? 0 :this.financeChargeOutstandingCccyamt.hashCode()));
        result = ((result* 31)+((this.cycleToDatePostedDebitsCccyamt == null)? 0 :this.cycleToDatePostedDebitsCccyamt.hashCode()));
        result = ((result* 31)+((this.financeChargeTypeCd == null)? 0 :this.financeChargeTypeCd.hashCode()));
        result = ((result* 31)+((this.financeChargeDeferredInd == null)? 0 :this.financeChargeDeferredInd.hashCode()));
        result = ((result* 31)+((this.billedBalanceOutstandingInd == null)? 0 :this.billedBalanceOutstandingInd.hashCode()));
        result = ((result* 31)+((this.cycleToDatePostedDebitAdjustmentCccyamt == null)? 0 :this.cycleToDatePostedDebitAdjustmentCccyamt.hashCode()));
        result = ((result* 31)+((this.newTransactionCategoryDesc == null)? 0 :this.newTransactionCategoryDesc.hashCode()));
        result = ((result* 31)+((this.cycleToDatePostedCreditAdjustmentCccyamt == null)? 0 :this.cycleToDatePostedCreditAdjustmentCccyamt.hashCode()));
        result = ((result* 31)+((this.cycleToDatePostedFinanceChargeCreditsCccyamt == null)? 0 :this.cycleToDatePostedFinanceChargeCreditsCccyamt.hashCode()));
        result = ((result* 31)+((this.previousPrincipleBalanceCccyamt == null)? 0 :this.previousPrincipleBalanceCccyamt.hashCode()));
        result = ((result* 31)+((this.foreignExchangeFeeCccyamt == null)? 0 :this.foreignExchangeFeeCccyamt.hashCode()));
        result = ((result* 31)+((this.previousCycleOutstandingBalanceCccyamt == null)? 0 :this.previousCycleOutstandingBalanceCccyamt.hashCode()));
        result = ((result* 31)+((this.currentDayPendingTermTransferCccyamt == null)? 0 :this.currentDayPendingTermTransferCccyamt.hashCode()));
        result = ((result* 31)+((this.balanceSegmentInDisputeCccyamt == null)? 0 :this.balanceSegmentInDisputeCccyamt.hashCode()));
        result = ((result* 31)+((this.transactionCategoryDesc == null)? 0 :this.transactionCategoryDesc.hashCode()));
        result = ((result* 31)+((this.retailTransactionInd == null)? 0 :this.retailTransactionInd.hashCode()));
        result = ((result* 31)+((this.cycleToDatePostedFinanceChargeDebitsCccyamt == null)? 0 :this.cycleToDatePostedFinanceChargeDebitsCccyamt.hashCode()));
        result = ((result* 31)+((this.newTermBalanceCd == null)? 0 :this.newTermBalanceCd.hashCode()));
        result = ((result* 31)+((this.deferredFinanceChargeCccyamt == null)? 0 :this.deferredFinanceChargeCccyamt.hashCode()));
        result = ((result* 31)+((this.principlePaymentDueCccyamt == null)? 0 :this.principlePaymentDueCccyamt.hashCode()));
        result = ((result* 31)+((this.minimumPaymentDeferredInd == null)? 0 :this.minimumPaymentDeferredInd.hashCode()));
        result = ((result* 31)+((this.transactionCategorySpecialProcessingExpiryDt == null)? 0 :this.transactionCategorySpecialProcessingExpiryDt.hashCode()));
        result = ((result* 31)+((this.cycleToDateAppliedCreditsCccyamt == null)? 0 :this.cycleToDateAppliedCreditsCccyamt.hashCode()));
        result = ((result* 31)+((this.termBalanceCd == null)? 0 :this.termBalanceCd.hashCode()));
        result = ((result* 31)+((this.outstandingBalanceCccyamt == null)? 0 :this.outstandingBalanceCccyamt.hashCode()));
        result = ((result* 31)+((this.cycleToDateAppliedPaymentsCccyamt == null)? 0 :this.cycleToDateAppliedPaymentsCccyamt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CurrentBalanceInfo) == false) {
            return false;
        }
        CurrentBalanceInfo rhs = ((CurrentBalanceInfo) other);
        return (((((((((((((((((((((((((((((((((((((((((this.cycleToDatePostedCreditsCccyamt == rhs.cycleToDatePostedCreditsCccyamt)||((this.cycleToDatePostedCreditsCccyamt!= null)&&this.cycleToDatePostedCreditsCccyamt.equals(rhs.cycleToDatePostedCreditsCccyamt)))&&((this.cycleToDatePostedDebitAdjustmentCnt == rhs.cycleToDatePostedDebitAdjustmentCnt)||((this.cycleToDatePostedDebitAdjustmentCnt!= null)&&this.cycleToDatePostedDebitAdjustmentCnt.equals(rhs.cycleToDatePostedDebitAdjustmentCnt))))&&((this.cycleToDatePostedCreditsCnt == rhs.cycleToDatePostedCreditsCnt)||((this.cycleToDatePostedCreditsCnt!= null)&&this.cycleToDatePostedCreditsCnt.equals(rhs.cycleToDatePostedCreditsCnt))))&&((this.totalOutstandingBalanceCccyamt == rhs.totalOutstandingBalanceCccyamt)||((this.totalOutstandingBalanceCccyamt!= null)&&this.totalOutstandingBalanceCccyamt.equals(rhs.totalOutstandingBalanceCccyamt))))&&((this.cycleToDateAppliedDebitsCccyamt == rhs.cycleToDateAppliedDebitsCccyamt)||((this.cycleToDateAppliedDebitsCccyamt!= null)&&this.cycleToDateAppliedDebitsCccyamt.equals(rhs.cycleToDateAppliedDebitsCccyamt))))&&((this.newTransactionCategoryCd == rhs.newTransactionCategoryCd)||((this.newTransactionCategoryCd!= null)&&this.newTransactionCategoryCd.equals(rhs.newTransactionCategoryCd))))&&((this.previousFinanceChargeBalanceCccyamt == rhs.previousFinanceChargeBalanceCccyamt)||((this.previousFinanceChargeBalanceCccyamt!= null)&&this.previousFinanceChargeBalanceCccyamt.equals(rhs.previousFinanceChargeBalanceCccyamt))))&&((this.cycleToDatePostedCreditAdjustmentCnt == rhs.cycleToDatePostedCreditAdjustmentCnt)||((this.cycleToDatePostedCreditAdjustmentCnt!= null)&&this.cycleToDatePostedCreditAdjustmentCnt.equals(rhs.cycleToDatePostedCreditAdjustmentCnt))))&&((this.termCodeDesc == rhs.termCodeDesc)||((this.termCodeDesc!= null)&&this.termCodeDesc.equals(rhs.termCodeDesc))))&&((this.promotionId == rhs.promotionId)||((this.promotionId!= null)&&this.promotionId.equals(rhs.promotionId))))&&((this.previousCycleUnpaidBalanceCccyamt == rhs.previousCycleUnpaidBalanceCccyamt)||((this.previousCycleUnpaidBalanceCccyamt!= null)&&this.previousCycleUnpaidBalanceCccyamt.equals(rhs.previousCycleUnpaidBalanceCccyamt))))&&((this.balanceSubjectToFinanceChargeInd == rhs.balanceSubjectToFinanceChargeInd)||((this.balanceSubjectToFinanceChargeInd!= null)&&this.balanceSubjectToFinanceChargeInd.equals(rhs.balanceSubjectToFinanceChargeInd))))&&((this.transactionCategoryCd == rhs.transactionCategoryCd)||((this.transactionCategoryCd!= null)&&this.transactionCategoryCd.equals(rhs.transactionCategoryCd))))&&((this.cycleToDatePostedDebitsCnt == rhs.cycleToDatePostedDebitsCnt)||((this.cycleToDatePostedDebitsCnt!= null)&&this.cycleToDatePostedDebitsCnt.equals(rhs.cycleToDatePostedDebitsCnt))))&&((this.financeChargeOutstandingCccyamt == rhs.financeChargeOutstandingCccyamt)||((this.financeChargeOutstandingCccyamt!= null)&&this.financeChargeOutstandingCccyamt.equals(rhs.financeChargeOutstandingCccyamt))))&&((this.cycleToDatePostedDebitsCccyamt == rhs.cycleToDatePostedDebitsCccyamt)||((this.cycleToDatePostedDebitsCccyamt!= null)&&this.cycleToDatePostedDebitsCccyamt.equals(rhs.cycleToDatePostedDebitsCccyamt))))&&((this.financeChargeTypeCd == rhs.financeChargeTypeCd)||((this.financeChargeTypeCd!= null)&&this.financeChargeTypeCd.equals(rhs.financeChargeTypeCd))))&&((this.financeChargeDeferredInd == rhs.financeChargeDeferredInd)||((this.financeChargeDeferredInd!= null)&&this.financeChargeDeferredInd.equals(rhs.financeChargeDeferredInd))))&&((this.billedBalanceOutstandingInd == rhs.billedBalanceOutstandingInd)||((this.billedBalanceOutstandingInd!= null)&&this.billedBalanceOutstandingInd.equals(rhs.billedBalanceOutstandingInd))))&&((this.cycleToDatePostedDebitAdjustmentCccyamt == rhs.cycleToDatePostedDebitAdjustmentCccyamt)||((this.cycleToDatePostedDebitAdjustmentCccyamt!= null)&&this.cycleToDatePostedDebitAdjustmentCccyamt.equals(rhs.cycleToDatePostedDebitAdjustmentCccyamt))))&&((this.newTransactionCategoryDesc == rhs.newTransactionCategoryDesc)||((this.newTransactionCategoryDesc!= null)&&this.newTransactionCategoryDesc.equals(rhs.newTransactionCategoryDesc))))&&((this.cycleToDatePostedCreditAdjustmentCccyamt == rhs.cycleToDatePostedCreditAdjustmentCccyamt)||((this.cycleToDatePostedCreditAdjustmentCccyamt!= null)&&this.cycleToDatePostedCreditAdjustmentCccyamt.equals(rhs.cycleToDatePostedCreditAdjustmentCccyamt))))&&((this.cycleToDatePostedFinanceChargeCreditsCccyamt == rhs.cycleToDatePostedFinanceChargeCreditsCccyamt)||((this.cycleToDatePostedFinanceChargeCreditsCccyamt!= null)&&this.cycleToDatePostedFinanceChargeCreditsCccyamt.equals(rhs.cycleToDatePostedFinanceChargeCreditsCccyamt))))&&((this.previousPrincipleBalanceCccyamt == rhs.previousPrincipleBalanceCccyamt)||((this.previousPrincipleBalanceCccyamt!= null)&&this.previousPrincipleBalanceCccyamt.equals(rhs.previousPrincipleBalanceCccyamt))))&&((this.foreignExchangeFeeCccyamt == rhs.foreignExchangeFeeCccyamt)||((this.foreignExchangeFeeCccyamt!= null)&&this.foreignExchangeFeeCccyamt.equals(rhs.foreignExchangeFeeCccyamt))))&&((this.previousCycleOutstandingBalanceCccyamt == rhs.previousCycleOutstandingBalanceCccyamt)||((this.previousCycleOutstandingBalanceCccyamt!= null)&&this.previousCycleOutstandingBalanceCccyamt.equals(rhs.previousCycleOutstandingBalanceCccyamt))))&&((this.currentDayPendingTermTransferCccyamt == rhs.currentDayPendingTermTransferCccyamt)||((this.currentDayPendingTermTransferCccyamt!= null)&&this.currentDayPendingTermTransferCccyamt.equals(rhs.currentDayPendingTermTransferCccyamt))))&&((this.balanceSegmentInDisputeCccyamt == rhs.balanceSegmentInDisputeCccyamt)||((this.balanceSegmentInDisputeCccyamt!= null)&&this.balanceSegmentInDisputeCccyamt.equals(rhs.balanceSegmentInDisputeCccyamt))))&&((this.transactionCategoryDesc == rhs.transactionCategoryDesc)||((this.transactionCategoryDesc!= null)&&this.transactionCategoryDesc.equals(rhs.transactionCategoryDesc))))&&((this.retailTransactionInd == rhs.retailTransactionInd)||((this.retailTransactionInd!= null)&&this.retailTransactionInd.equals(rhs.retailTransactionInd))))&&((this.cycleToDatePostedFinanceChargeDebitsCccyamt == rhs.cycleToDatePostedFinanceChargeDebitsCccyamt)||((this.cycleToDatePostedFinanceChargeDebitsCccyamt!= null)&&this.cycleToDatePostedFinanceChargeDebitsCccyamt.equals(rhs.cycleToDatePostedFinanceChargeDebitsCccyamt))))&&((this.newTermBalanceCd == rhs.newTermBalanceCd)||((this.newTermBalanceCd!= null)&&this.newTermBalanceCd.equals(rhs.newTermBalanceCd))))&&((this.deferredFinanceChargeCccyamt == rhs.deferredFinanceChargeCccyamt)||((this.deferredFinanceChargeCccyamt!= null)&&this.deferredFinanceChargeCccyamt.equals(rhs.deferredFinanceChargeCccyamt))))&&((this.principlePaymentDueCccyamt == rhs.principlePaymentDueCccyamt)||((this.principlePaymentDueCccyamt!= null)&&this.principlePaymentDueCccyamt.equals(rhs.principlePaymentDueCccyamt))))&&((this.minimumPaymentDeferredInd == rhs.minimumPaymentDeferredInd)||((this.minimumPaymentDeferredInd!= null)&&this.minimumPaymentDeferredInd.equals(rhs.minimumPaymentDeferredInd))))&&((this.transactionCategorySpecialProcessingExpiryDt == rhs.transactionCategorySpecialProcessingExpiryDt)||((this.transactionCategorySpecialProcessingExpiryDt!= null)&&this.transactionCategorySpecialProcessingExpiryDt.equals(rhs.transactionCategorySpecialProcessingExpiryDt))))&&((this.cycleToDateAppliedCreditsCccyamt == rhs.cycleToDateAppliedCreditsCccyamt)||((this.cycleToDateAppliedCreditsCccyamt!= null)&&this.cycleToDateAppliedCreditsCccyamt.equals(rhs.cycleToDateAppliedCreditsCccyamt))))&&((this.termBalanceCd == rhs.termBalanceCd)||((this.termBalanceCd!= null)&&this.termBalanceCd.equals(rhs.termBalanceCd))))&&((this.outstandingBalanceCccyamt == rhs.outstandingBalanceCccyamt)||((this.outstandingBalanceCccyamt!= null)&&this.outstandingBalanceCccyamt.equals(rhs.outstandingBalanceCccyamt))))&&((this.cycleToDateAppliedPaymentsCccyamt == rhs.cycleToDateAppliedPaymentsCccyamt)||((this.cycleToDateAppliedPaymentsCccyamt!= null)&&this.cycleToDateAppliedPaymentsCccyamt.equals(rhs.cycleToDateAppliedPaymentsCccyamt))));
    }

}
