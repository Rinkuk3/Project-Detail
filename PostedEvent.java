package com.td.api.mbcca.response.account;

import java.math.BigDecimal;
import java.util.Date;

import com.td.api.mbcca.shared.MerchantInfo;
import com.td.api.mbcca.shared.TsysExtensionCurrencyNumericCd;

public class PostedEvent {

    private String eventId;
    private String eventDescriptionTxt;
    private String statusCd;
    private Date eventDttm;
    private String debitCreditCd;
    BigDecimal amt;
    private MerchantInfo merchantInfo;
    private String activityTypeCd;
    private String activityTypeDesc;
    private String originalCardNum;
    private String transactionSourceCd;
    private String transactionSourceDesc;
    private String approvalCd;
    private String categoryCd;
    private Date postedDttm;
    private Boolean fraudInd;
    private Boolean foreignTransactionInd;
    private String cardNum;
    private String transactionDetailAvailableTypeCd;
    private String accountingFunctionCd;
    private String classificationCd;
    private String acquirerReferenceNum;
    BigDecimal runningBalanceAmt;
    private PostedEventDetail postedEventDetail;
    private Boolean disputedInd;
    private String statementDt;
    private String transactionDt;
    private Boolean softPostedPaymentInd;
    private String cardNumMasked;
    private TsysExtensionCurrencyNumericCd tdCardsExtension;
    private String hostCategoryCd;
    private String authorizationReferenceNum;
    private String termBalanceCd;
    private String statementDataDt;
    private String centralProcessingDt;
    private Boolean authorizationReceivedInd;
    private Boolean postedAsMemoTransactionInd;
    private Boolean forcePostedInd;
    private Boolean transferredInd;
    private Boolean translatedInd;
    private Boolean nonSufficientFundPostedInd;
    private Boolean printedOnStatementInd;
    private String acquirerInterbankCardAssociationNum;
    private Integer adjustmentCnt;
    private String chargeBackIndicatorCd;
    private TsysExtension__4 tsysExtension;
    private Boolean targetedPromotionInd;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventDescriptionTxt() {
        return eventDescriptionTxt;
    }

    public void setEventDescriptionTxt(String eventDescriptionTxt) {
        this.eventDescriptionTxt = eventDescriptionTxt;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public Date getEventDttm() {
        return eventDttm;
    }

    public void setEventDttm(Date eventDttm) {
        this.eventDttm = eventDttm;
    }

    public String getDebitCreditCd() {
        return debitCreditCd;
    }

    public void setDebitCreditCd(String debitCreditCd) {
        this.debitCreditCd = debitCreditCd;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public MerchantInfo getMerchantInfo() {
        return merchantInfo;
    }

    public void setMerchantInfo(MerchantInfo merchantInfo) {
        this.merchantInfo = merchantInfo;
    }

    public String getActivityTypeCd() {
        return activityTypeCd;
    }

    public void setActivityTypeCd(String activityTypeCd) {
        this.activityTypeCd = activityTypeCd;
    }

    public String getActivityTypeDesc() {
        return activityTypeDesc;
    }

    public void setActivityTypeDesc(String activityTypeDesc) {
        this.activityTypeDesc = activityTypeDesc;
    }

    public String getOriginalCardNum() {
        return originalCardNum;
    }

    public void setOriginalCardNum(String originalCardNum) {
        this.originalCardNum = originalCardNum;
    }

    public String getTransactionSourceCd() {
        return transactionSourceCd;
    }

    public void setTransactionSourceCd(String transactionSourceCd) {
        this.transactionSourceCd = transactionSourceCd;
    }

    public String getTransactionSourceDesc() {
        return transactionSourceDesc;
    }

    public void setTransactionSourceDesc(String transactionSourceDesc) {
        this.transactionSourceDesc = transactionSourceDesc;
    }

    public String getApprovalCd() {
        return approvalCd;
    }

    public void setApprovalCd(String approvalCd) {
        this.approvalCd = approvalCd;
    }

    public String getCategoryCd() {
        return categoryCd;
    }

    public void setCategoryCd(String categoryCd) {
        this.categoryCd = categoryCd;
    }

    public Date getPostedDttm() {
        return postedDttm;
    }

    public void setPostedDttm(Date postedDttm) {
        this.postedDttm = postedDttm;
    }

    public Boolean getFraudInd() {
        return fraudInd;
    }

    public void setFraudInd(Boolean fraudInd) {
        this.fraudInd = fraudInd;
    }

    public Boolean getForeignTransactionInd() {
        return foreignTransactionInd;
    }

    public void setForeignTransactionInd(Boolean foreignTransactionInd) {
        this.foreignTransactionInd = foreignTransactionInd;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getTransactionDetailAvailableTypeCd() {
        return transactionDetailAvailableTypeCd;
    }

    public void setTransactionDetailAvailableTypeCd(String transactionDetailAvailableTypeCd) {
        this.transactionDetailAvailableTypeCd = transactionDetailAvailableTypeCd;
    }

    public String getAccountingFunctionCd() {
        return accountingFunctionCd;
    }

    public void setAccountingFunctionCd(String accountingFunctionCd) {
        this.accountingFunctionCd = accountingFunctionCd;
    }

    public String getClassificationCd() {
        return classificationCd;
    }

    public void setClassificationCd(String classificationCd) {
        this.classificationCd = classificationCd;
    }

    public String getAcquirerReferenceNum() {
        return acquirerReferenceNum;
    }

    public void setAcquirerReferenceNum(String acquirerReferenceNum) {
        this.acquirerReferenceNum = acquirerReferenceNum;
    }

    public BigDecimal getRunningBalanceAmt() {
        return runningBalanceAmt;
    }

    public void setRunningBalanceAmt(BigDecimal runningBalanceAmt) {
        this.runningBalanceAmt = runningBalanceAmt;
    }

    public PostedEventDetail getPostedEventDetail() {
        return postedEventDetail;
    }

    public void setPostedEventDetail(PostedEventDetail postedEventDetail) {
        this.postedEventDetail = postedEventDetail;
    }

    public Boolean getDisputedInd() {
        return disputedInd;
    }

    public void setDisputedInd(Boolean disputedInd) {
        this.disputedInd = disputedInd;
    }

    public String getStatementDt() {
        return statementDt;
    }

    public void setStatementDt(String statementDt) {
        this.statementDt = statementDt;
    }

    public String getTransactionDt() {
        return transactionDt;
    }

    public void setTransactionDt(String transactionDt) {
        this.transactionDt = transactionDt;
    }

    public Boolean getSoftPostedPaymentInd() {
        return softPostedPaymentInd;
    }

    public void setSoftPostedPaymentInd(Boolean softPostedPaymentInd) {
        this.softPostedPaymentInd = softPostedPaymentInd;
    }

    public String getCardNumMasked() {
        return cardNumMasked;
    }

    public void setCardNumMasked(String cardNumMasked) {
        this.cardNumMasked = cardNumMasked;
    }

    public TsysExtensionCurrencyNumericCd getTdCardsExtension() {
        return tdCardsExtension;
    }

    public void setTdCardsExtension(TsysExtensionCurrencyNumericCd tdCardsExtension) {
        this.tdCardsExtension = tdCardsExtension;
    }

    public String getHostCategoryCd() {
        return hostCategoryCd;
    }

    public void setHostCategoryCd(String hostCategoryCd) {
        this.hostCategoryCd = hostCategoryCd;
    }

    public String getAuthorizationReferenceNum() {
        return authorizationReferenceNum;
    }

    public void setAuthorizationReferenceNum(String authorizationReferenceNum) {
        this.authorizationReferenceNum = authorizationReferenceNum;
    }

    public String getTermBalanceCd() {
        return termBalanceCd;
    }

    public void setTermBalanceCd(String termBalanceCd) {
        this.termBalanceCd = termBalanceCd;
    }

    public String getStatementDataDt() {
        return statementDataDt;
    }

    public void setStatementDataDt(String statementDataDt) {
        this.statementDataDt = statementDataDt;
    }

    public String getCentralProcessingDt() {
        return centralProcessingDt;
    }

    public void setCentralProcessingDt(String centralProcessingDt) {
        this.centralProcessingDt = centralProcessingDt;
    }

    public Boolean getAuthorizationReceivedInd() {
        return authorizationReceivedInd;
    }

    public void setAuthorizationReceivedInd(Boolean authorizationReceivedInd) {
        this.authorizationReceivedInd = authorizationReceivedInd;
    }

    public Boolean getPostedAsMemoTransactionInd() {
        return postedAsMemoTransactionInd;
    }

    public void setPostedAsMemoTransactionInd(Boolean postedAsMemoTransactionInd) {
        this.postedAsMemoTransactionInd = postedAsMemoTransactionInd;
    }

    public Boolean getForcePostedInd() {
        return forcePostedInd;
    }

    public void setForcePostedInd(Boolean forcePostedInd) {
        this.forcePostedInd = forcePostedInd;
    }

    public Boolean getTransferredInd() {
        return transferredInd;
    }

    public void setTransferredInd(Boolean transferredInd) {
        this.transferredInd = transferredInd;
    }

    public Boolean getTranslatedInd() {
        return translatedInd;
    }

    public void setTranslatedInd(Boolean translatedInd) {
        this.translatedInd = translatedInd;
    }

    public Boolean getNonSufficientFundPostedInd() {
        return nonSufficientFundPostedInd;
    }

    public void setNonSufficientFundPostedInd(Boolean nonSufficientFundPostedInd) {
        this.nonSufficientFundPostedInd = nonSufficientFundPostedInd;
    }

    public Boolean getPrintedOnStatementInd() {
        return printedOnStatementInd;
    }

    public void setPrintedOnStatementInd(Boolean printedOnStatementInd) {
        this.printedOnStatementInd = printedOnStatementInd;
    }

    public String getAcquirerInterbankCardAssociationNum() {
        return acquirerInterbankCardAssociationNum;
    }

    public void setAcquirerInterbankCardAssociationNum(String acquirerInterbankCardAssociationNum) {
        this.acquirerInterbankCardAssociationNum = acquirerInterbankCardAssociationNum;
    }

    public Integer getAdjustmentCnt() {
        return adjustmentCnt;
    }

    public void setAdjustmentCnt(Integer adjustmentCnt) {
        this.adjustmentCnt = adjustmentCnt;
    }

    public String getChargeBackIndicatorCd() {
        return chargeBackIndicatorCd;
    }

    public void setChargeBackIndicatorCd(String chargeBackIndicatorCd) {
        this.chargeBackIndicatorCd = chargeBackIndicatorCd;
    }

    public TsysExtension__4 getTsysExtension() {
        return tsysExtension;
    }

    public void setTsysExtension(TsysExtension__4 tsysExtension) {
        this.tsysExtension = tsysExtension;
    }

    public Boolean getTargetedPromotionInd() {
        return targetedPromotionInd;
    }

    public void setTargetedPromotionInd(Boolean targetedPromotionInd) {
        this.targetedPromotionInd = targetedPromotionInd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PostedEvent.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("eventId");
        sb.append('=');
        sb.append(((this.eventId == null)?"<null>":this.eventId));
        sb.append(',');
        sb.append("eventDescriptionTxt");
        sb.append('=');
        sb.append(((this.eventDescriptionTxt == null)?"<null>":this.eventDescriptionTxt));
        sb.append(',');
        sb.append("statusCd");
        sb.append('=');
        sb.append(((this.statusCd == null)?"<null>":this.statusCd));
        sb.append(',');
        sb.append("eventDttm");
        sb.append('=');
        sb.append(((this.eventDttm == null)?"<null>":this.eventDttm));
        sb.append(',');
        sb.append("debitCreditCd");
        sb.append('=');
        sb.append(((this.debitCreditCd == null)?"<null>":this.debitCreditCd));
        sb.append(',');
        sb.append("amt");
        sb.append('=');
        sb.append(((this.amt == null)?"<null>":this.amt));
        sb.append(',');
        sb.append("merchantInfo");
        sb.append('=');
        sb.append(((this.merchantInfo == null)?"<null>":this.merchantInfo));
        sb.append(',');
        sb.append("activityTypeCd");
        sb.append('=');
        sb.append(((this.activityTypeCd == null)?"<null>":this.activityTypeCd));
        sb.append(',');
        sb.append("activityTypeDesc");
        sb.append('=');
        sb.append(((this.activityTypeDesc == null)?"<null>":this.activityTypeDesc));
        sb.append(',');
        sb.append("originalCardNum");
        sb.append('=');
        sb.append(((this.originalCardNum == null)?"<null>":this.originalCardNum));
        sb.append(',');
        sb.append("transactionSourceCd");
        sb.append('=');
        sb.append(((this.transactionSourceCd == null)?"<null>":this.transactionSourceCd));
        sb.append(',');
        sb.append("transactionSourceDesc");
        sb.append('=');
        sb.append(((this.transactionSourceDesc == null)?"<null>":this.transactionSourceDesc));
        sb.append(',');
        sb.append("approvalCd");
        sb.append('=');
        sb.append(((this.approvalCd == null)?"<null>":this.approvalCd));
        sb.append(',');
        sb.append("categoryCd");
        sb.append('=');
        sb.append(((this.categoryCd == null)?"<null>":this.categoryCd));
        sb.append(',');
        sb.append("postedDttm");
        sb.append('=');
        sb.append(((this.postedDttm == null)?"<null>":this.postedDttm));
        sb.append(',');
        sb.append("fraudInd");
        sb.append('=');
        sb.append(((this.fraudInd == null)?"<null>":this.fraudInd));
        sb.append(',');
        sb.append("foreignTransactionInd");
        sb.append('=');
        sb.append(((this.foreignTransactionInd == null)?"<null>":this.foreignTransactionInd));
        sb.append(',');
        sb.append("cardNum");
        sb.append('=');
        sb.append(((this.cardNum == null)?"<null>":this.cardNum));
        sb.append(',');
        sb.append("transactionDetailAvailableTypeCd");
        sb.append('=');
        sb.append(((this.transactionDetailAvailableTypeCd == null)?"<null>":this.transactionDetailAvailableTypeCd));
        sb.append(',');
        sb.append("accountingFunctionCd");
        sb.append('=');
        sb.append(((this.accountingFunctionCd == null)?"<null>":this.accountingFunctionCd));
        sb.append(',');
        sb.append("classificationCd");
        sb.append('=');
        sb.append(((this.classificationCd == null)?"<null>":this.classificationCd));
        sb.append(',');
        sb.append("acquirerReferenceNum");
        sb.append('=');
        sb.append(((this.acquirerReferenceNum == null)?"<null>":this.acquirerReferenceNum));
        sb.append(',');
        sb.append("runningBalanceAmt");
        sb.append('=');
        sb.append(((this.runningBalanceAmt == null)?"<null>":this.runningBalanceAmt));
        sb.append(',');
        sb.append("postedEventDetail");
        sb.append('=');
        sb.append(((this.postedEventDetail == null)?"<null>":this.postedEventDetail));
        sb.append(',');
        sb.append("disputedInd");
        sb.append('=');
        sb.append(((this.disputedInd == null)?"<null>":this.disputedInd));
        sb.append(',');
        sb.append("statementDt");
        sb.append('=');
        sb.append(((this.statementDt == null)?"<null>":this.statementDt));
        sb.append(',');
        sb.append("transactionDt");
        sb.append('=');
        sb.append(((this.transactionDt == null)?"<null>":this.transactionDt));
        sb.append(',');
        sb.append("softPostedPaymentInd");
        sb.append('=');
        sb.append(((this.softPostedPaymentInd == null)?"<null>":this.softPostedPaymentInd));
        sb.append(',');
        sb.append("cardNumMasked");
        sb.append('=');
        sb.append(((this.cardNumMasked == null)?"<null>":this.cardNumMasked));
        sb.append(',');
        sb.append("tdCardsExtension");
        sb.append('=');
        sb.append(((this.tdCardsExtension == null)?"<null>":this.tdCardsExtension));
        sb.append(',');
        sb.append("hostCategoryCd");
        sb.append('=');
        sb.append(((this.hostCategoryCd == null)?"<null>":this.hostCategoryCd));
        sb.append(',');
        sb.append("authorizationReferenceNum");
        sb.append('=');
        sb.append(((this.authorizationReferenceNum == null)?"<null>":this.authorizationReferenceNum));
        sb.append(',');
        sb.append("termBalanceCd");
        sb.append('=');
        sb.append(((this.termBalanceCd == null)?"<null>":this.termBalanceCd));
        sb.append(',');
        sb.append("statementDataDt");
        sb.append('=');
        sb.append(((this.statementDataDt == null)?"<null>":this.statementDataDt));
        sb.append(',');
        sb.append("centralProcessingDt");
        sb.append('=');
        sb.append(((this.centralProcessingDt == null)?"<null>":this.centralProcessingDt));
        sb.append(',');
        sb.append("authorizationReceivedInd");
        sb.append('=');
        sb.append(((this.authorizationReceivedInd == null)?"<null>":this.authorizationReceivedInd));
        sb.append(',');
        sb.append("postedAsMemoTransactionInd");
        sb.append('=');
        sb.append(((this.postedAsMemoTransactionInd == null)?"<null>":this.postedAsMemoTransactionInd));
        sb.append(',');
        sb.append("forcePostedInd");
        sb.append('=');
        sb.append(((this.forcePostedInd == null)?"<null>":this.forcePostedInd));
        sb.append(',');
        sb.append("transferredInd");
        sb.append('=');
        sb.append(((this.transferredInd == null)?"<null>":this.transferredInd));
        sb.append(',');
        sb.append("translatedInd");
        sb.append('=');
        sb.append(((this.translatedInd == null)?"<null>":this.translatedInd));
        sb.append(',');
        sb.append("nonSufficientFundPostedInd");
        sb.append('=');
        sb.append(((this.nonSufficientFundPostedInd == null)?"<null>":this.nonSufficientFundPostedInd));
        sb.append(',');
        sb.append("printedOnStatementInd");
        sb.append('=');
        sb.append(((this.printedOnStatementInd == null)?"<null>":this.printedOnStatementInd));
        sb.append(',');
        sb.append("acquirerInterbankCardAssociationNum");
        sb.append('=');
        sb.append(((this.acquirerInterbankCardAssociationNum == null)?"<null>":this.acquirerInterbankCardAssociationNum));
        sb.append(',');
        sb.append("adjustmentCnt");
        sb.append('=');
        sb.append(((this.adjustmentCnt == null)?"<null>":this.adjustmentCnt));
        sb.append(',');
        sb.append("chargeBackIndicatorCd");
        sb.append('=');
        sb.append(((this.chargeBackIndicatorCd == null)?"<null>":this.chargeBackIndicatorCd));
        sb.append(',');
        sb.append("tsysExtension");
        sb.append('=');
        sb.append(((this.tsysExtension == null)?"<null>":this.tsysExtension));
        sb.append(',');
        sb.append("targetedPromotionInd");
        sb.append('=');
        sb.append(((this.targetedPromotionInd == null)?"<null>":this.targetedPromotionInd));
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
        result = ((result* 31)+((this.transactionDetailAvailableTypeCd == null)? 0 :this.transactionDetailAvailableTypeCd.hashCode()));
        result = ((result* 31)+((this.runningBalanceAmt == null)? 0 :this.runningBalanceAmt.hashCode()));
        result = ((result* 31)+((this.eventDescriptionTxt == null)? 0 :this.eventDescriptionTxt.hashCode()));
        result = ((result* 31)+((this.amt == null)? 0 :this.amt.hashCode()));
        result = ((result* 31)+((this.authorizationReferenceNum == null)? 0 :this.authorizationReferenceNum.hashCode()));
        result = ((result* 31)+((this.printedOnStatementInd == null)? 0 :this.printedOnStatementInd.hashCode()));
        result = ((result* 31)+((this.adjustmentCnt == null)? 0 :this.adjustmentCnt.hashCode()));
        result = ((result* 31)+((this.chargeBackIndicatorCd == null)? 0 :this.chargeBackIndicatorCd.hashCode()));
        result = ((result* 31)+((this.statementDt == null)? 0 :this.statementDt.hashCode()));
        result = ((result* 31)+((this.activityTypeCd == null)? 0 :this.activityTypeCd.hashCode()));
        result = ((result* 31)+((this.postedAsMemoTransactionInd == null)? 0 :this.postedAsMemoTransactionInd.hashCode()));
        result = ((result* 31)+((this.cardNum == null)? 0 :this.cardNum.hashCode()));
        result = ((result* 31)+((this.nonSufficientFundPostedInd == null)? 0 :this.nonSufficientFundPostedInd.hashCode()));
        result = ((result* 31)+((this.tsysExtension == null)? 0 :this.tsysExtension.hashCode()));
        result = ((result* 31)+((this.eventDttm == null)? 0 :this.eventDttm.hashCode()));
        result = ((result* 31)+((this.postedEventDetail == null)? 0 :this.postedEventDetail.hashCode()));
        result = ((result* 31)+((this.approvalCd == null)? 0 :this.approvalCd.hashCode()));
        result = ((result* 31)+((this.eventId == null)? 0 :this.eventId.hashCode()));
        result = ((result* 31)+((this.transactionSourceCd == null)? 0 :this.transactionSourceCd.hashCode()));
        result = ((result* 31)+((this.forcePostedInd == null)? 0 :this.forcePostedInd.hashCode()));
        result = ((result* 31)+((this.originalCardNum == null)? 0 :this.originalCardNum.hashCode()));
        result = ((result* 31)+((this.foreignTransactionInd == null)? 0 :this.foreignTransactionInd.hashCode()));
        result = ((result* 31)+((this.softPostedPaymentInd == null)? 0 :this.softPostedPaymentInd.hashCode()));
        result = ((result* 31)+((this.acquirerInterbankCardAssociationNum == null)? 0 :this.acquirerInterbankCardAssociationNum.hashCode()));
        result = ((result* 31)+((this.statusCd == null)? 0 :this.statusCd.hashCode()));
        result = ((result* 31)+((this.transactionSourceDesc == null)? 0 :this.transactionSourceDesc.hashCode()));
        result = ((result* 31)+((this.postedDttm == null)? 0 :this.postedDttm.hashCode()));
        result = ((result* 31)+((this.classificationCd == null)? 0 :this.classificationCd.hashCode()));
        result = ((result* 31)+((this.centralProcessingDt == null)? 0 :this.centralProcessingDt.hashCode()));
        result = ((result* 31)+((this.transferredInd == null)? 0 :this.transferredInd.hashCode()));
        result = ((result* 31)+((this.merchantInfo == null)? 0 :this.merchantInfo.hashCode()));
        result = ((result* 31)+((this.accountingFunctionCd == null)? 0 :this.accountingFunctionCd.hashCode()));
        result = ((result* 31)+((this.targetedPromotionInd == null)? 0 :this.targetedPromotionInd.hashCode()));
        result = ((result* 31)+((this.tdCardsExtension == null)? 0 :this.tdCardsExtension.hashCode()));
        result = ((result* 31)+((this.debitCreditCd == null)? 0 :this.debitCreditCd.hashCode()));
        result = ((result* 31)+((this.translatedInd == null)? 0 :this.translatedInd.hashCode()));
        result = ((result* 31)+((this.activityTypeDesc == null)? 0 :this.activityTypeDesc.hashCode()));
        result = ((result* 31)+((this.authorizationReceivedInd == null)? 0 :this.authorizationReceivedInd.hashCode()));
        result = ((result* 31)+((this.hostCategoryCd == null)? 0 :this.hostCategoryCd.hashCode()));
        result = ((result* 31)+((this.statementDataDt == null)? 0 :this.statementDataDt.hashCode()));
        result = ((result* 31)+((this.categoryCd == null)? 0 :this.categoryCd.hashCode()));
        result = ((result* 31)+((this.fraudInd == null)? 0 :this.fraudInd.hashCode()));
        result = ((result* 31)+((this.transactionDt == null)? 0 :this.transactionDt.hashCode()));
        result = ((result* 31)+((this.termBalanceCd == null)? 0 :this.termBalanceCd.hashCode()));
        result = ((result* 31)+((this.cardNumMasked == null)? 0 :this.cardNumMasked.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PostedEvent) == false) {
            return false;
        }
        PostedEvent rhs = ((PostedEvent) other);
        return ((((((((((((((((((((((((((((((((((((((((((((((((this.acquirerReferenceNum == rhs.acquirerReferenceNum)||((this.acquirerReferenceNum!= null)&&this.acquirerReferenceNum.equals(rhs.acquirerReferenceNum)))&&((this.disputedInd == rhs.disputedInd)||((this.disputedInd!= null)&&this.disputedInd.equals(rhs.disputedInd))))&&((this.transactionDetailAvailableTypeCd == rhs.transactionDetailAvailableTypeCd)||((this.transactionDetailAvailableTypeCd!= null)&&this.transactionDetailAvailableTypeCd.equals(rhs.transactionDetailAvailableTypeCd))))&&((this.runningBalanceAmt == rhs.runningBalanceAmt)||((this.runningBalanceAmt!= null)&&this.runningBalanceAmt.equals(rhs.runningBalanceAmt))))&&((this.eventDescriptionTxt == rhs.eventDescriptionTxt)||((this.eventDescriptionTxt!= null)&&this.eventDescriptionTxt.equals(rhs.eventDescriptionTxt))))&&((this.amt == rhs.amt)||((this.amt!= null)&&this.amt.equals(rhs.amt))))&&((this.authorizationReferenceNum == rhs.authorizationReferenceNum)||((this.authorizationReferenceNum!= null)&&this.authorizationReferenceNum.equals(rhs.authorizationReferenceNum))))&&((this.printedOnStatementInd == rhs.printedOnStatementInd)||((this.printedOnStatementInd!= null)&&this.printedOnStatementInd.equals(rhs.printedOnStatementInd))))&&((this.adjustmentCnt == rhs.adjustmentCnt)||((this.adjustmentCnt!= null)&&this.adjustmentCnt.equals(rhs.adjustmentCnt))))&&((this.chargeBackIndicatorCd == rhs.chargeBackIndicatorCd)||((this.chargeBackIndicatorCd!= null)&&this.chargeBackIndicatorCd.equals(rhs.chargeBackIndicatorCd))))&&((this.statementDt == rhs.statementDt)||((this.statementDt!= null)&&this.statementDt.equals(rhs.statementDt))))&&((this.activityTypeCd == rhs.activityTypeCd)||((this.activityTypeCd!= null)&&this.activityTypeCd.equals(rhs.activityTypeCd))))&&((this.postedAsMemoTransactionInd == rhs.postedAsMemoTransactionInd)||((this.postedAsMemoTransactionInd!= null)&&this.postedAsMemoTransactionInd.equals(rhs.postedAsMemoTransactionInd))))&&((this.cardNum == rhs.cardNum)||((this.cardNum!= null)&&this.cardNum.equals(rhs.cardNum))))&&((this.nonSufficientFundPostedInd == rhs.nonSufficientFundPostedInd)||((this.nonSufficientFundPostedInd!= null)&&this.nonSufficientFundPostedInd.equals(rhs.nonSufficientFundPostedInd))))&&((this.tsysExtension == rhs.tsysExtension)||((this.tsysExtension!= null)&&this.tsysExtension.equals(rhs.tsysExtension))))&&((this.eventDttm == rhs.eventDttm)||((this.eventDttm!= null)&&this.eventDttm.equals(rhs.eventDttm))))&&((this.postedEventDetail == rhs.postedEventDetail)||((this.postedEventDetail!= null)&&this.postedEventDetail.equals(rhs.postedEventDetail))))&&((this.approvalCd == rhs.approvalCd)||((this.approvalCd!= null)&&this.approvalCd.equals(rhs.approvalCd))))&&((this.eventId == rhs.eventId)||((this.eventId!= null)&&this.eventId.equals(rhs.eventId))))&&((this.transactionSourceCd == rhs.transactionSourceCd)||((this.transactionSourceCd!= null)&&this.transactionSourceCd.equals(rhs.transactionSourceCd))))&&((this.forcePostedInd == rhs.forcePostedInd)||((this.forcePostedInd!= null)&&this.forcePostedInd.equals(rhs.forcePostedInd))))&&((this.originalCardNum == rhs.originalCardNum)||((this.originalCardNum!= null)&&this.originalCardNum.equals(rhs.originalCardNum))))&&((this.foreignTransactionInd == rhs.foreignTransactionInd)||((this.foreignTransactionInd!= null)&&this.foreignTransactionInd.equals(rhs.foreignTransactionInd))))&&((this.softPostedPaymentInd == rhs.softPostedPaymentInd)||((this.softPostedPaymentInd!= null)&&this.softPostedPaymentInd.equals(rhs.softPostedPaymentInd))))&&((this.acquirerInterbankCardAssociationNum == rhs.acquirerInterbankCardAssociationNum)||((this.acquirerInterbankCardAssociationNum!= null)&&this.acquirerInterbankCardAssociationNum.equals(rhs.acquirerInterbankCardAssociationNum))))&&((this.statusCd == rhs.statusCd)||((this.statusCd!= null)&&this.statusCd.equals(rhs.statusCd))))&&((this.transactionSourceDesc == rhs.transactionSourceDesc)||((this.transactionSourceDesc!= null)&&this.transactionSourceDesc.equals(rhs.transactionSourceDesc))))&&((this.postedDttm == rhs.postedDttm)||((this.postedDttm!= null)&&this.postedDttm.equals(rhs.postedDttm))))&&((this.classificationCd == rhs.classificationCd)||((this.classificationCd!= null)&&this.classificationCd.equals(rhs.classificationCd))))&&((this.centralProcessingDt == rhs.centralProcessingDt)||((this.centralProcessingDt!= null)&&this.centralProcessingDt.equals(rhs.centralProcessingDt))))&&((this.transferredInd == rhs.transferredInd)||((this.transferredInd!= null)&&this.transferredInd.equals(rhs.transferredInd))))&&((this.merchantInfo == rhs.merchantInfo)||((this.merchantInfo!= null)&&this.merchantInfo.equals(rhs.merchantInfo))))&&((this.accountingFunctionCd == rhs.accountingFunctionCd)||((this.accountingFunctionCd!= null)&&this.accountingFunctionCd.equals(rhs.accountingFunctionCd))))&&((this.targetedPromotionInd == rhs.targetedPromotionInd)||((this.targetedPromotionInd!= null)&&this.targetedPromotionInd.equals(rhs.targetedPromotionInd))))&&((this.tdCardsExtension == rhs.tdCardsExtension)||((this.tdCardsExtension!= null)&&this.tdCardsExtension.equals(rhs.tdCardsExtension))))&&((this.debitCreditCd == rhs.debitCreditCd)||((this.debitCreditCd!= null)&&this.debitCreditCd.equals(rhs.debitCreditCd))))&&((this.translatedInd == rhs.translatedInd)||((this.translatedInd!= null)&&this.translatedInd.equals(rhs.translatedInd))))&&((this.activityTypeDesc == rhs.activityTypeDesc)||((this.activityTypeDesc!= null)&&this.activityTypeDesc.equals(rhs.activityTypeDesc))))&&((this.authorizationReceivedInd == rhs.authorizationReceivedInd)||((this.authorizationReceivedInd!= null)&&this.authorizationReceivedInd.equals(rhs.authorizationReceivedInd))))&&((this.hostCategoryCd == rhs.hostCategoryCd)||((this.hostCategoryCd!= null)&&this.hostCategoryCd.equals(rhs.hostCategoryCd))))&&((this.statementDataDt == rhs.statementDataDt)||((this.statementDataDt!= null)&&this.statementDataDt.equals(rhs.statementDataDt))))&&((this.categoryCd == rhs.categoryCd)||((this.categoryCd!= null)&&this.categoryCd.equals(rhs.categoryCd))))&&((this.fraudInd == rhs.fraudInd)||((this.fraudInd!= null)&&this.fraudInd.equals(rhs.fraudInd))))&&((this.transactionDt == rhs.transactionDt)||((this.transactionDt!= null)&&this.transactionDt.equals(rhs.transactionDt))))&&((this.termBalanceCd == rhs.termBalanceCd)||((this.termBalanceCd!= null)&&this.termBalanceCd.equals(rhs.termBalanceCd))))&&((this.cardNumMasked == rhs.cardNumMasked)||((this.cardNumMasked!= null)&&this.cardNumMasked.equals(rhs.cardNumMasked))));
    }

}
