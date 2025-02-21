package com.td.api.mbcca.response.account;

import java.math.BigDecimal;
import java.util.Date;

import com.td.api.mbcca.shared.Cccyamt;

public class PostedEventDetail {

    private String paymentNetworkTransactionId;
    private ForeignExchangeInfo foreignExchangeInfo;
    BigDecimal conversionRate;
    BigDecimal inverseRate;
    private String cardNumMasked;
    private String applicationCryptogram;
    private String unpredictableNum;
    private Date retailEventStartDttm;
    private String retailEventTypeCd;
    private String retailEventCountryCd;
    private String terminalChannelTypeCd;
    private String cardSequenceNum;
    private String cardHolderVerificationMethodCd;
    private String cardHolderVerificationTransactionConditionCd;
    private String cardHolderTransactionVerificationStatusCd;
    private Cccyamt cryptogramCccyamt;
    private String chipCryptogramVerificationStatusCd;
    private String fallBackVerificationVal;
    private String statementDataDt;
    private Date postedDttm;
    private String retailEventId;
    private String cardAcceptorId;
    private Cccyamt originalTransactionCccyamt;
    private String activityTypeCd;
    private String transactionDetailAvailableTypeCd;
    private String accountingFunctionCd;
    private String transactionPaymentMethodTypeCd;
    private String terminalChannelTypeSourceCd;
    private String merchantPointOfServiceTerminalChannelInstanceId;
    private String merchantPointOfServiceTerminalCapabilitySourceCd;
    private String merchantPointOfServiceTerminalEntrySourceCd;
    private String chargeBackReferenceNum;
    private String authorizationSourceCd;
    private String authorizationEventDt;
    private Cccyamt authorizedCccyamt;
    private String paymentTokenNum;
    private String paymentTokenAssuranceLevelCd;
    private String paymentTokenRequesterId;
    private String digitalPaymentAccountTypeCd;
    private String transactionLevelProcessingTypeCd;
    private String transactionLevelProcessingFeatureId;
    private String transactionLevelProcessingExpiryDt;
    private String promotionOfferId;
    private String paymentSettlementDt;
    private AdjustmentInfo adjustmentInfo;
    private TsysExtension__3 tsysExtension;
    private String postedEventId;
    private String retailEventStartTm;
    private String activityTypeDesc;
    private String retailEventSubtypeCd;
    private String acquirerId;
    private String authorizationTypeCd;
    private String cardHolderPartyIdentificationTypeCd;
    private Boolean recurringPaymentInd;

    public String getPaymentNetworkTransactionId() {
        return paymentNetworkTransactionId;
    }

    public void setPaymentNetworkTransactionId(String paymentNetworkTransactionId) {
        this.paymentNetworkTransactionId = paymentNetworkTransactionId;
    }

    public ForeignExchangeInfo getForeignExchangeInfo() {
        return foreignExchangeInfo;
    }

    public void setForeignExchangeInfo(ForeignExchangeInfo foreignExchangeInfo) {
        this.foreignExchangeInfo = foreignExchangeInfo;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public BigDecimal getInverseRate() {
        return inverseRate;
    }

    public void setInverseRate(BigDecimal inverseRate) {
        this.inverseRate = inverseRate;
    }

    public String getCardNumMasked() {
        return cardNumMasked;
    }

    public void setCardNumMasked(String cardNumMasked) {
        this.cardNumMasked = cardNumMasked;
    }

    public String getApplicationCryptogram() {
        return applicationCryptogram;
    }

    public void setApplicationCryptogram(String applicationCryptogram) {
        this.applicationCryptogram = applicationCryptogram;
    }

    public String getUnpredictableNum() {
        return unpredictableNum;
    }

    public void setUnpredictableNum(String unpredictableNum) {
        this.unpredictableNum = unpredictableNum;
    }

    public Date getRetailEventStartDttm() {
        return retailEventStartDttm;
    }

    public void setRetailEventStartDttm(Date retailEventStartDttm) {
        this.retailEventStartDttm = retailEventStartDttm;
    }

    public String getRetailEventTypeCd() {
        return retailEventTypeCd;
    }

    public void setRetailEventTypeCd(String retailEventTypeCd) {
        this.retailEventTypeCd = retailEventTypeCd;
    }

    public String getRetailEventCountryCd() {
        return retailEventCountryCd;
    }

    public void setRetailEventCountryCd(String retailEventCountryCd) {
        this.retailEventCountryCd = retailEventCountryCd;
    }

    public String getTerminalChannelTypeCd() {
        return terminalChannelTypeCd;
    }

    public void setTerminalChannelTypeCd(String terminalChannelTypeCd) {
        this.terminalChannelTypeCd = terminalChannelTypeCd;
    }

    public String getCardSequenceNum() {
        return cardSequenceNum;
    }

    public void setCardSequenceNum(String cardSequenceNum) {
        this.cardSequenceNum = cardSequenceNum;
    }

    public String getCardHolderVerificationMethodCd() {
        return cardHolderVerificationMethodCd;
    }

    public void setCardHolderVerificationMethodCd(String cardHolderVerificationMethodCd) {
        this.cardHolderVerificationMethodCd = cardHolderVerificationMethodCd;
    }

    public String getCardHolderVerificationTransactionConditionCd() {
        return cardHolderVerificationTransactionConditionCd;
    }

    public void setCardHolderVerificationTransactionConditionCd(String cardHolderVerificationTransactionConditionCd) {
        this.cardHolderVerificationTransactionConditionCd = cardHolderVerificationTransactionConditionCd;
    }

    public String getCardHolderTransactionVerificationStatusCd() {
        return cardHolderTransactionVerificationStatusCd;
    }

    public void setCardHolderTransactionVerificationStatusCd(String cardHolderTransactionVerificationStatusCd) {
        this.cardHolderTransactionVerificationStatusCd = cardHolderTransactionVerificationStatusCd;
    }

    public Cccyamt getCryptogramCccyamt() {
        return cryptogramCccyamt;
    }

    public void setCryptogramCccyamt(Cccyamt cryptogramCccyamt) {
        this.cryptogramCccyamt = cryptogramCccyamt;
    }

    public String getChipCryptogramVerificationStatusCd() {
        return chipCryptogramVerificationStatusCd;
    }

    public void setChipCryptogramVerificationStatusCd(String chipCryptogramVerificationStatusCd) {
        this.chipCryptogramVerificationStatusCd = chipCryptogramVerificationStatusCd;
    }

    public String getFallBackVerificationVal() {
        return fallBackVerificationVal;
    }

    public void setFallBackVerificationVal(String fallBackVerificationVal) {
        this.fallBackVerificationVal = fallBackVerificationVal;
    }

    public String getStatementDataDt() {
        return statementDataDt;
    }

    public void setStatementDataDt(String statementDataDt) {
        this.statementDataDt = statementDataDt;
    }

    public Date getPostedDttm() {
        return postedDttm;
    }

    public void setPostedDttm(Date postedDttm) {
        this.postedDttm = postedDttm;
    }

    public String getRetailEventId() {
        return retailEventId;
    }

    public void setRetailEventId(String retailEventId) {
        this.retailEventId = retailEventId;
    }

    public String getCardAcceptorId() {
        return cardAcceptorId;
    }

    public void setCardAcceptorId(String cardAcceptorId) {
        this.cardAcceptorId = cardAcceptorId;
    }

    public Cccyamt getOriginalTransactionCccyamt() {
        return originalTransactionCccyamt;
    }

    public void setOriginalTransactionCccyamt(Cccyamt originalTransactionCccyamt) {
        this.originalTransactionCccyamt = originalTransactionCccyamt;
    }

    public String getActivityTypeCd() {
        return activityTypeCd;
    }

    public void setActivityTypeCd(String activityTypeCd) {
        this.activityTypeCd = activityTypeCd;
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

    public String getTransactionPaymentMethodTypeCd() {
        return transactionPaymentMethodTypeCd;
    }

    public void setTransactionPaymentMethodTypeCd(String transactionPaymentMethodTypeCd) {
        this.transactionPaymentMethodTypeCd = transactionPaymentMethodTypeCd;
    }

    public String getTerminalChannelTypeSourceCd() {
        return terminalChannelTypeSourceCd;
    }

    public void setTerminalChannelTypeSourceCd(String terminalChannelTypeSourceCd) {
        this.terminalChannelTypeSourceCd = terminalChannelTypeSourceCd;
    }

    public String getMerchantPointOfServiceTerminalChannelInstanceId() {
        return merchantPointOfServiceTerminalChannelInstanceId;
    }

    public void setMerchantPointOfServiceTerminalChannelInstanceId(String merchantPointOfServiceTerminalChannelInstanceId) {
        this.merchantPointOfServiceTerminalChannelInstanceId = merchantPointOfServiceTerminalChannelInstanceId;
    }

    public String getMerchantPointOfServiceTerminalCapabilitySourceCd() {
        return merchantPointOfServiceTerminalCapabilitySourceCd;
    }

    public void setMerchantPointOfServiceTerminalCapabilitySourceCd(String merchantPointOfServiceTerminalCapabilitySourceCd) {
        this.merchantPointOfServiceTerminalCapabilitySourceCd = merchantPointOfServiceTerminalCapabilitySourceCd;
    }

    public String getMerchantPointOfServiceTerminalEntrySourceCd() {
        return merchantPointOfServiceTerminalEntrySourceCd;
    }

    public void setMerchantPointOfServiceTerminalEntrySourceCd(String merchantPointOfServiceTerminalEntrySourceCd) {
        this.merchantPointOfServiceTerminalEntrySourceCd = merchantPointOfServiceTerminalEntrySourceCd;
    }

    public String getChargeBackReferenceNum() {
        return chargeBackReferenceNum;
    }

    public void setChargeBackReferenceNum(String chargeBackReferenceNum) {
        this.chargeBackReferenceNum = chargeBackReferenceNum;
    }

    public String getAuthorizationSourceCd() {
        return authorizationSourceCd;
    }

    public void setAuthorizationSourceCd(String authorizationSourceCd) {
        this.authorizationSourceCd = authorizationSourceCd;
    }

    public String getAuthorizationEventDt() {
        return authorizationEventDt;
    }

    public void setAuthorizationEventDt(String authorizationEventDt) {
        this.authorizationEventDt = authorizationEventDt;
    }

    public Cccyamt getAuthorizedCccyamt() {
        return authorizedCccyamt;
    }

    public void setAuthorizedCccyamt(Cccyamt authorizedCccyamt) {
        this.authorizedCccyamt = authorizedCccyamt;
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

    public String getDigitalPaymentAccountTypeCd() {
        return digitalPaymentAccountTypeCd;
    }

    public void setDigitalPaymentAccountTypeCd(String digitalPaymentAccountTypeCd) {
        this.digitalPaymentAccountTypeCd = digitalPaymentAccountTypeCd;
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

    public String getTransactionLevelProcessingExpiryDt() {
        return transactionLevelProcessingExpiryDt;
    }

    public void setTransactionLevelProcessingExpiryDt(String transactionLevelProcessingExpiryDt) {
        this.transactionLevelProcessingExpiryDt = transactionLevelProcessingExpiryDt;
    }

    public String getPromotionOfferId() {
        return promotionOfferId;
    }

    public void setPromotionOfferId(String promotionOfferId) {
        this.promotionOfferId = promotionOfferId;
    }

    public String getPaymentSettlementDt() {
        return paymentSettlementDt;
    }

    public void setPaymentSettlementDt(String paymentSettlementDt) {
        this.paymentSettlementDt = paymentSettlementDt;
    }

    public AdjustmentInfo getAdjustmentInfo() {
        return adjustmentInfo;
    }

    public void setAdjustmentInfo(AdjustmentInfo adjustmentInfo) {
        this.adjustmentInfo = adjustmentInfo;
    }

    public TsysExtension__3 getTsysExtension() {
        return tsysExtension;
    }

    public void setTsysExtension(TsysExtension__3 tsysExtension) {
        this.tsysExtension = tsysExtension;
    }

    public String getPostedEventId() {
        return postedEventId;
    }

    public void setPostedEventId(String postedEventId) {
        this.postedEventId = postedEventId;
    }

    public String getRetailEventStartTm() {
        return retailEventStartTm;
    }

    public void setRetailEventStartTm(String retailEventStartTm) {
        this.retailEventStartTm = retailEventStartTm;
    }

    public String getActivityTypeDesc() {
        return activityTypeDesc;
    }

    public void setActivityTypeDesc(String activityTypeDesc) {
        this.activityTypeDesc = activityTypeDesc;
    }

    public String getRetailEventSubtypeCd() {
        return retailEventSubtypeCd;
    }

    public void setRetailEventSubtypeCd(String retailEventSubtypeCd) {
        this.retailEventSubtypeCd = retailEventSubtypeCd;
    }

    public String getAcquirerId() {
        return acquirerId;
    }

    public void setAcquirerId(String acquirerId) {
        this.acquirerId = acquirerId;
    }

    public String getAuthorizationTypeCd() {
        return authorizationTypeCd;
    }

    public void setAuthorizationTypeCd(String authorizationTypeCd) {
        this.authorizationTypeCd = authorizationTypeCd;
    }

    public String getCardHolderPartyIdentificationTypeCd() {
        return cardHolderPartyIdentificationTypeCd;
    }

    public void setCardHolderPartyIdentificationTypeCd(String cardHolderPartyIdentificationTypeCd) {
        this.cardHolderPartyIdentificationTypeCd = cardHolderPartyIdentificationTypeCd;
    }

    public Boolean getRecurringPaymentInd() {
        return recurringPaymentInd;
    }

    public void setRecurringPaymentInd(Boolean recurringPaymentInd) {
        this.recurringPaymentInd = recurringPaymentInd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PostedEventDetail.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("paymentNetworkTransactionId");
        sb.append('=');
        sb.append(((this.paymentNetworkTransactionId == null)?"<null>":this.paymentNetworkTransactionId));
        sb.append(',');
        sb.append("foreignExchangeInfo");
        sb.append('=');
        sb.append(((this.foreignExchangeInfo == null)?"<null>":this.foreignExchangeInfo));
        sb.append(',');
        sb.append("conversionRate");
        sb.append('=');
        sb.append(((this.conversionRate == null)?"<null>":this.conversionRate));
        sb.append(',');
        sb.append("inverseRate");
        sb.append('=');
        sb.append(((this.inverseRate == null)?"<null>":this.inverseRate));
        sb.append(',');
        sb.append("cardNumMasked");
        sb.append('=');
        sb.append(((this.cardNumMasked == null)?"<null>":this.cardNumMasked));
        sb.append(',');
        sb.append("applicationCryptogram");
        sb.append('=');
        sb.append(((this.applicationCryptogram == null)?"<null>":this.applicationCryptogram));
        sb.append(',');
        sb.append("unpredictableNum");
        sb.append('=');
        sb.append(((this.unpredictableNum == null)?"<null>":this.unpredictableNum));
        sb.append(',');
        sb.append("retailEventStartDttm");
        sb.append('=');
        sb.append(((this.retailEventStartDttm == null)?"<null>":this.retailEventStartDttm));
        sb.append(',');
        sb.append("retailEventTypeCd");
        sb.append('=');
        sb.append(((this.retailEventTypeCd == null)?"<null>":this.retailEventTypeCd));
        sb.append(',');
        sb.append("retailEventCountryCd");
        sb.append('=');
        sb.append(((this.retailEventCountryCd == null)?"<null>":this.retailEventCountryCd));
        sb.append(',');
        sb.append("terminalChannelTypeCd");
        sb.append('=');
        sb.append(((this.terminalChannelTypeCd == null)?"<null>":this.terminalChannelTypeCd));
        sb.append(',');
        sb.append("cardSequenceNum");
        sb.append('=');
        sb.append(((this.cardSequenceNum == null)?"<null>":this.cardSequenceNum));
        sb.append(',');
        sb.append("cardHolderVerificationMethodCd");
        sb.append('=');
        sb.append(((this.cardHolderVerificationMethodCd == null)?"<null>":this.cardHolderVerificationMethodCd));
        sb.append(',');
        sb.append("cardHolderVerificationTransactionConditionCd");
        sb.append('=');
        sb.append(((this.cardHolderVerificationTransactionConditionCd == null)?"<null>":this.cardHolderVerificationTransactionConditionCd));
        sb.append(',');
        sb.append("cardHolderTransactionVerificationStatusCd");
        sb.append('=');
        sb.append(((this.cardHolderTransactionVerificationStatusCd == null)?"<null>":this.cardHolderTransactionVerificationStatusCd));
        sb.append(',');
        sb.append("cryptogramCccyamt");
        sb.append('=');
        sb.append(((this.cryptogramCccyamt == null)?"<null>":this.cryptogramCccyamt));
        sb.append(',');
        sb.append("chipCryptogramVerificationStatusCd");
        sb.append('=');
        sb.append(((this.chipCryptogramVerificationStatusCd == null)?"<null>":this.chipCryptogramVerificationStatusCd));
        sb.append(',');
        sb.append("fallBackVerificationVal");
        sb.append('=');
        sb.append(((this.fallBackVerificationVal == null)?"<null>":this.fallBackVerificationVal));
        sb.append(',');
        sb.append("statementDataDt");
        sb.append('=');
        sb.append(((this.statementDataDt == null)?"<null>":this.statementDataDt));
        sb.append(',');
        sb.append("postedDttm");
        sb.append('=');
        sb.append(((this.postedDttm == null)?"<null>":this.postedDttm));
        sb.append(',');
        sb.append("retailEventId");
        sb.append('=');
        sb.append(((this.retailEventId == null)?"<null>":this.retailEventId));
        sb.append(',');
        sb.append("cardAcceptorId");
        sb.append('=');
        sb.append(((this.cardAcceptorId == null)?"<null>":this.cardAcceptorId));
        sb.append(',');
        sb.append("originalTransactionCccyamt");
        sb.append('=');
        sb.append(((this.originalTransactionCccyamt == null)?"<null>":this.originalTransactionCccyamt));
        sb.append(',');
        sb.append("activityTypeCd");
        sb.append('=');
        sb.append(((this.activityTypeCd == null)?"<null>":this.activityTypeCd));
        sb.append(',');
        sb.append("transactionDetailAvailableTypeCd");
        sb.append('=');
        sb.append(((this.transactionDetailAvailableTypeCd == null)?"<null>":this.transactionDetailAvailableTypeCd));
        sb.append(',');
        sb.append("accountingFunctionCd");
        sb.append('=');
        sb.append(((this.accountingFunctionCd == null)?"<null>":this.accountingFunctionCd));
        sb.append(',');
        sb.append("transactionPaymentMethodTypeCd");
        sb.append('=');
        sb.append(((this.transactionPaymentMethodTypeCd == null)?"<null>":this.transactionPaymentMethodTypeCd));
        sb.append(',');
        sb.append("terminalChannelTypeSourceCd");
        sb.append('=');
        sb.append(((this.terminalChannelTypeSourceCd == null)?"<null>":this.terminalChannelTypeSourceCd));
        sb.append(',');
        sb.append("merchantPointOfServiceTerminalChannelInstanceId");
        sb.append('=');
        sb.append(((this.merchantPointOfServiceTerminalChannelInstanceId == null)?"<null>":this.merchantPointOfServiceTerminalChannelInstanceId));
        sb.append(',');
        sb.append("merchantPointOfServiceTerminalCapabilitySourceCd");
        sb.append('=');
        sb.append(((this.merchantPointOfServiceTerminalCapabilitySourceCd == null)?"<null>":this.merchantPointOfServiceTerminalCapabilitySourceCd));
        sb.append(',');
        sb.append("merchantPointOfServiceTerminalEntrySourceCd");
        sb.append('=');
        sb.append(((this.merchantPointOfServiceTerminalEntrySourceCd == null)?"<null>":this.merchantPointOfServiceTerminalEntrySourceCd));
        sb.append(',');
        sb.append("chargeBackReferenceNum");
        sb.append('=');
        sb.append(((this.chargeBackReferenceNum == null)?"<null>":this.chargeBackReferenceNum));
        sb.append(',');
        sb.append("authorizationSourceCd");
        sb.append('=');
        sb.append(((this.authorizationSourceCd == null)?"<null>":this.authorizationSourceCd));
        sb.append(',');
        sb.append("authorizationEventDt");
        sb.append('=');
        sb.append(((this.authorizationEventDt == null)?"<null>":this.authorizationEventDt));
        sb.append(',');
        sb.append("authorizedCccyamt");
        sb.append('=');
        sb.append(((this.authorizedCccyamt == null)?"<null>":this.authorizedCccyamt));
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
        sb.append("digitalPaymentAccountTypeCd");
        sb.append('=');
        sb.append(((this.digitalPaymentAccountTypeCd == null)?"<null>":this.digitalPaymentAccountTypeCd));
        sb.append(',');
        sb.append("transactionLevelProcessingTypeCd");
        sb.append('=');
        sb.append(((this.transactionLevelProcessingTypeCd == null)?"<null>":this.transactionLevelProcessingTypeCd));
        sb.append(',');
        sb.append("transactionLevelProcessingFeatureId");
        sb.append('=');
        sb.append(((this.transactionLevelProcessingFeatureId == null)?"<null>":this.transactionLevelProcessingFeatureId));
        sb.append(',');
        sb.append("transactionLevelProcessingExpiryDt");
        sb.append('=');
        sb.append(((this.transactionLevelProcessingExpiryDt == null)?"<null>":this.transactionLevelProcessingExpiryDt));
        sb.append(',');
        sb.append("promotionOfferId");
        sb.append('=');
        sb.append(((this.promotionOfferId == null)?"<null>":this.promotionOfferId));
        sb.append(',');
        sb.append("paymentSettlementDt");
        sb.append('=');
        sb.append(((this.paymentSettlementDt == null)?"<null>":this.paymentSettlementDt));
        sb.append(',');
        sb.append("adjustmentInfo");
        sb.append('=');
        sb.append(((this.adjustmentInfo == null)?"<null>":this.adjustmentInfo));
        sb.append(',');
        sb.append("tsysExtension");
        sb.append('=');
        sb.append(((this.tsysExtension == null)?"<null>":this.tsysExtension));
        sb.append(',');
        sb.append("postedEventId");
        sb.append('=');
        sb.append(((this.postedEventId == null)?"<null>":this.postedEventId));
        sb.append(',');
        sb.append("retailEventStartTm");
        sb.append('=');
        sb.append(((this.retailEventStartTm == null)?"<null>":this.retailEventStartTm));
        sb.append(',');
        sb.append("activityTypeDesc");
        sb.append('=');
        sb.append(((this.activityTypeDesc == null)?"<null>":this.activityTypeDesc));
        sb.append(',');
        sb.append("retailEventSubtypeCd");
        sb.append('=');
        sb.append(((this.retailEventSubtypeCd == null)?"<null>":this.retailEventSubtypeCd));
        sb.append(',');
        sb.append("acquirerId");
        sb.append('=');
        sb.append(((this.acquirerId == null)?"<null>":this.acquirerId));
        sb.append(',');
        sb.append("authorizationTypeCd");
        sb.append('=');
        sb.append(((this.authorizationTypeCd == null)?"<null>":this.authorizationTypeCd));
        sb.append(',');
        sb.append("cardHolderPartyIdentificationTypeCd");
        sb.append('=');
        sb.append(((this.cardHolderPartyIdentificationTypeCd == null)?"<null>":this.cardHolderPartyIdentificationTypeCd));
        sb.append(',');
        sb.append("recurringPaymentInd");
        sb.append('=');
        sb.append(((this.recurringPaymentInd == null)?"<null>":this.recurringPaymentInd));
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
        result = ((result* 31)+((this.digitalPaymentAccountTypeCd == null)? 0 :this.digitalPaymentAccountTypeCd.hashCode()));
        result = ((result* 31)+((this.retailEventStartDttm == null)? 0 :this.retailEventStartDttm.hashCode()));
        result = ((result* 31)+((this.cardAcceptorId == null)? 0 :this.cardAcceptorId.hashCode()));
        result = ((result* 31)+((this.transactionDetailAvailableTypeCd == null)? 0 :this.transactionDetailAvailableTypeCd.hashCode()));
        result = ((result* 31)+((this.inverseRate == null)? 0 :this.inverseRate.hashCode()));
        result = ((result* 31)+((this.retailEventCountryCd == null)? 0 :this.retailEventCountryCd.hashCode()));
        result = ((result* 31)+((this.paymentTokenNum == null)? 0 :this.paymentTokenNum.hashCode()));
        result = ((result* 31)+((this.adjustmentInfo == null)? 0 :this.adjustmentInfo.hashCode()));
        result = ((result* 31)+((this.paymentNetworkTransactionId == null)? 0 :this.paymentNetworkTransactionId.hashCode()));
        result = ((result* 31)+((this.authorizedCccyamt == null)? 0 :this.authorizedCccyamt.hashCode()));
        result = ((result* 31)+((this.paymentTokenRequesterId == null)? 0 :this.paymentTokenRequesterId.hashCode()));
        result = ((result* 31)+((this.merchantPointOfServiceTerminalCapabilitySourceCd == null)? 0 :this.merchantPointOfServiceTerminalCapabilitySourceCd.hashCode()));
        result = ((result* 31)+((this.chipCryptogramVerificationStatusCd == null)? 0 :this.chipCryptogramVerificationStatusCd.hashCode()));
        result = ((result* 31)+((this.originalTransactionCccyamt == null)? 0 :this.originalTransactionCccyamt.hashCode()));
        result = ((result* 31)+((this.paymentSettlementDt == null)? 0 :this.paymentSettlementDt.hashCode()));
        result = ((result* 31)+((this.acquirerId == null)? 0 :this.acquirerId.hashCode()));
        result = ((result* 31)+((this.authorizationTypeCd == null)? 0 :this.authorizationTypeCd.hashCode()));
        result = ((result* 31)+((this.cardHolderPartyIdentificationTypeCd == null)? 0 :this.cardHolderPartyIdentificationTypeCd.hashCode()));
        result = ((result* 31)+((this.transactionLevelProcessingTypeCd == null)? 0 :this.transactionLevelProcessingTypeCd.hashCode()));
        result = ((result* 31)+((this.terminalChannelTypeSourceCd == null)? 0 :this.terminalChannelTypeSourceCd.hashCode()));
        result = ((result* 31)+((this.authorizationSourceCd == null)? 0 :this.authorizationSourceCd.hashCode()));
        result = ((result* 31)+((this.postedDttm == null)? 0 :this.postedDttm.hashCode()));
        result = ((result* 31)+((this.accountingFunctionCd == null)? 0 :this.accountingFunctionCd.hashCode()));
        result = ((result* 31)+((this.activityTypeDesc == null)? 0 :this.activityTypeDesc.hashCode()));
        result = ((result* 31)+((this.applicationCryptogram == null)? 0 :this.applicationCryptogram.hashCode()));
        result = ((result* 31)+((this.cardNumMasked == null)? 0 :this.cardNumMasked.hashCode()));
        result = ((result* 31)+((this.foreignExchangeInfo == null)? 0 :this.foreignExchangeInfo.hashCode()));
        result = ((result* 31)+((this.authorizationEventDt == null)? 0 :this.authorizationEventDt.hashCode()));
        result = ((result* 31)+((this.activityTypeCd == null)? 0 :this.activityTypeCd.hashCode()));
        result = ((result* 31)+((this.cryptogramCccyamt == null)? 0 :this.cryptogramCccyamt.hashCode()));
        result = ((result* 31)+((this.tsysExtension == null)? 0 :this.tsysExtension.hashCode()));
        result = ((result* 31)+((this.transactionPaymentMethodTypeCd == null)? 0 :this.transactionPaymentMethodTypeCd.hashCode()));
        result = ((result* 31)+((this.cardHolderVerificationMethodCd == null)? 0 :this.cardHolderVerificationMethodCd.hashCode()));
        result = ((result* 31)+((this.unpredictableNum == null)? 0 :this.unpredictableNum.hashCode()));
        result = ((result* 31)+((this.cardSequenceNum == null)? 0 :this.cardSequenceNum.hashCode()));
        result = ((result* 31)+((this.promotionOfferId == null)? 0 :this.promotionOfferId.hashCode()));
        result = ((result* 31)+((this.transactionLevelProcessingFeatureId == null)? 0 :this.transactionLevelProcessingFeatureId.hashCode()));
        result = ((result* 31)+((this.retailEventSubtypeCd == null)? 0 :this.retailEventSubtypeCd.hashCode()));
        result = ((result* 31)+((this.postedEventId == null)? 0 :this.postedEventId.hashCode()));
        result = ((result* 31)+((this.retailEventStartTm == null)? 0 :this.retailEventStartTm.hashCode()));
        result = ((result* 31)+((this.cardHolderVerificationTransactionConditionCd == null)? 0 :this.cardHolderVerificationTransactionConditionCd.hashCode()));
        result = ((result* 31)+((this.cardHolderTransactionVerificationStatusCd == null)? 0 :this.cardHolderTransactionVerificationStatusCd.hashCode()));
        result = ((result* 31)+((this.conversionRate == null)? 0 :this.conversionRate.hashCode()));
        result = ((result* 31)+((this.merchantPointOfServiceTerminalEntrySourceCd == null)? 0 :this.merchantPointOfServiceTerminalEntrySourceCd.hashCode()));
        result = ((result* 31)+((this.retailEventTypeCd == null)? 0 :this.retailEventTypeCd.hashCode()));
        result = ((result* 31)+((this.terminalChannelTypeCd == null)? 0 :this.terminalChannelTypeCd.hashCode()));
        result = ((result* 31)+((this.retailEventId == null)? 0 :this.retailEventId.hashCode()));
        result = ((result* 31)+((this.statementDataDt == null)? 0 :this.statementDataDt.hashCode()));
        result = ((result* 31)+((this.chargeBackReferenceNum == null)? 0 :this.chargeBackReferenceNum.hashCode()));
        result = ((result* 31)+((this.merchantPointOfServiceTerminalChannelInstanceId == null)? 0 :this.merchantPointOfServiceTerminalChannelInstanceId.hashCode()));
        result = ((result* 31)+((this.recurringPaymentInd == null)? 0 :this.recurringPaymentInd.hashCode()));
        result = ((result* 31)+((this.paymentTokenAssuranceLevelCd == null)? 0 :this.paymentTokenAssuranceLevelCd.hashCode()));
        result = ((result* 31)+((this.transactionLevelProcessingExpiryDt == null)? 0 :this.transactionLevelProcessingExpiryDt.hashCode()));
        result = ((result* 31)+((this.fallBackVerificationVal == null)? 0 :this.fallBackVerificationVal.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PostedEventDetail) == false) {
            return false;
        }
        PostedEventDetail rhs = ((PostedEventDetail) other);
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((this.digitalPaymentAccountTypeCd == rhs.digitalPaymentAccountTypeCd)||((this.digitalPaymentAccountTypeCd!= null)&&this.digitalPaymentAccountTypeCd.equals(rhs.digitalPaymentAccountTypeCd)))&&((this.retailEventStartDttm == rhs.retailEventStartDttm)||((this.retailEventStartDttm!= null)&&this.retailEventStartDttm.equals(rhs.retailEventStartDttm))))&&((this.cardAcceptorId == rhs.cardAcceptorId)||((this.cardAcceptorId!= null)&&this.cardAcceptorId.equals(rhs.cardAcceptorId))))&&((this.transactionDetailAvailableTypeCd == rhs.transactionDetailAvailableTypeCd)||((this.transactionDetailAvailableTypeCd!= null)&&this.transactionDetailAvailableTypeCd.equals(rhs.transactionDetailAvailableTypeCd))))&&((this.inverseRate == rhs.inverseRate)||((this.inverseRate!= null)&&this.inverseRate.equals(rhs.inverseRate))))&&((this.retailEventCountryCd == rhs.retailEventCountryCd)||((this.retailEventCountryCd!= null)&&this.retailEventCountryCd.equals(rhs.retailEventCountryCd))))&&((this.paymentTokenNum == rhs.paymentTokenNum)||((this.paymentTokenNum!= null)&&this.paymentTokenNum.equals(rhs.paymentTokenNum))))&&((this.adjustmentInfo == rhs.adjustmentInfo)||((this.adjustmentInfo!= null)&&this.adjustmentInfo.equals(rhs.adjustmentInfo))))&&((this.paymentNetworkTransactionId == rhs.paymentNetworkTransactionId)||((this.paymentNetworkTransactionId!= null)&&this.paymentNetworkTransactionId.equals(rhs.paymentNetworkTransactionId))))&&((this.authorizedCccyamt == rhs.authorizedCccyamt)||((this.authorizedCccyamt!= null)&&this.authorizedCccyamt.equals(rhs.authorizedCccyamt))))&&((this.paymentTokenRequesterId == rhs.paymentTokenRequesterId)||((this.paymentTokenRequesterId!= null)&&this.paymentTokenRequesterId.equals(rhs.paymentTokenRequesterId))))&&((this.merchantPointOfServiceTerminalCapabilitySourceCd == rhs.merchantPointOfServiceTerminalCapabilitySourceCd)||((this.merchantPointOfServiceTerminalCapabilitySourceCd!= null)&&this.merchantPointOfServiceTerminalCapabilitySourceCd.equals(rhs.merchantPointOfServiceTerminalCapabilitySourceCd))))&&((this.chipCryptogramVerificationStatusCd == rhs.chipCryptogramVerificationStatusCd)||((this.chipCryptogramVerificationStatusCd!= null)&&this.chipCryptogramVerificationStatusCd.equals(rhs.chipCryptogramVerificationStatusCd))))&&((this.originalTransactionCccyamt == rhs.originalTransactionCccyamt)||((this.originalTransactionCccyamt!= null)&&this.originalTransactionCccyamt.equals(rhs.originalTransactionCccyamt))))&&((this.paymentSettlementDt == rhs.paymentSettlementDt)||((this.paymentSettlementDt!= null)&&this.paymentSettlementDt.equals(rhs.paymentSettlementDt))))&&((this.acquirerId == rhs.acquirerId)||((this.acquirerId!= null)&&this.acquirerId.equals(rhs.acquirerId))))&&((this.authorizationTypeCd == rhs.authorizationTypeCd)||((this.authorizationTypeCd!= null)&&this.authorizationTypeCd.equals(rhs.authorizationTypeCd))))&&((this.cardHolderPartyIdentificationTypeCd == rhs.cardHolderPartyIdentificationTypeCd)||((this.cardHolderPartyIdentificationTypeCd!= null)&&this.cardHolderPartyIdentificationTypeCd.equals(rhs.cardHolderPartyIdentificationTypeCd))))&&((this.transactionLevelProcessingTypeCd == rhs.transactionLevelProcessingTypeCd)||((this.transactionLevelProcessingTypeCd!= null)&&this.transactionLevelProcessingTypeCd.equals(rhs.transactionLevelProcessingTypeCd))))&&((this.terminalChannelTypeSourceCd == rhs.terminalChannelTypeSourceCd)||((this.terminalChannelTypeSourceCd!= null)&&this.terminalChannelTypeSourceCd.equals(rhs.terminalChannelTypeSourceCd))))&&((this.authorizationSourceCd == rhs.authorizationSourceCd)||((this.authorizationSourceCd!= null)&&this.authorizationSourceCd.equals(rhs.authorizationSourceCd))))&&((this.postedDttm == rhs.postedDttm)||((this.postedDttm!= null)&&this.postedDttm.equals(rhs.postedDttm))))&&((this.accountingFunctionCd == rhs.accountingFunctionCd)||((this.accountingFunctionCd!= null)&&this.accountingFunctionCd.equals(rhs.accountingFunctionCd))))&&((this.activityTypeDesc == rhs.activityTypeDesc)||((this.activityTypeDesc!= null)&&this.activityTypeDesc.equals(rhs.activityTypeDesc))))&&((this.applicationCryptogram == rhs.applicationCryptogram)||((this.applicationCryptogram!= null)&&this.applicationCryptogram.equals(rhs.applicationCryptogram))))&&((this.cardNumMasked == rhs.cardNumMasked)||((this.cardNumMasked!= null)&&this.cardNumMasked.equals(rhs.cardNumMasked))))&&((this.foreignExchangeInfo == rhs.foreignExchangeInfo)||((this.foreignExchangeInfo!= null)&&this.foreignExchangeInfo.equals(rhs.foreignExchangeInfo))))&&((this.authorizationEventDt == rhs.authorizationEventDt)||((this.authorizationEventDt!= null)&&this.authorizationEventDt.equals(rhs.authorizationEventDt))))&&((this.activityTypeCd == rhs.activityTypeCd)||((this.activityTypeCd!= null)&&this.activityTypeCd.equals(rhs.activityTypeCd))))&&((this.cryptogramCccyamt == rhs.cryptogramCccyamt)||((this.cryptogramCccyamt!= null)&&this.cryptogramCccyamt.equals(rhs.cryptogramCccyamt))))&&((this.tsysExtension == rhs.tsysExtension)||((this.tsysExtension!= null)&&this.tsysExtension.equals(rhs.tsysExtension))))&&((this.transactionPaymentMethodTypeCd == rhs.transactionPaymentMethodTypeCd)||((this.transactionPaymentMethodTypeCd!= null)&&this.transactionPaymentMethodTypeCd.equals(rhs.transactionPaymentMethodTypeCd))))&&((this.cardHolderVerificationMethodCd == rhs.cardHolderVerificationMethodCd)||((this.cardHolderVerificationMethodCd!= null)&&this.cardHolderVerificationMethodCd.equals(rhs.cardHolderVerificationMethodCd))))&&((this.unpredictableNum == rhs.unpredictableNum)||((this.unpredictableNum!= null)&&this.unpredictableNum.equals(rhs.unpredictableNum))))&&((this.cardSequenceNum == rhs.cardSequenceNum)||((this.cardSequenceNum!= null)&&this.cardSequenceNum.equals(rhs.cardSequenceNum))))&&((this.promotionOfferId == rhs.promotionOfferId)||((this.promotionOfferId!= null)&&this.promotionOfferId.equals(rhs.promotionOfferId))))&&((this.transactionLevelProcessingFeatureId == rhs.transactionLevelProcessingFeatureId)||((this.transactionLevelProcessingFeatureId!= null)&&this.transactionLevelProcessingFeatureId.equals(rhs.transactionLevelProcessingFeatureId))))&&((this.retailEventSubtypeCd == rhs.retailEventSubtypeCd)||((this.retailEventSubtypeCd!= null)&&this.retailEventSubtypeCd.equals(rhs.retailEventSubtypeCd))))&&((this.postedEventId == rhs.postedEventId)||((this.postedEventId!= null)&&this.postedEventId.equals(rhs.postedEventId))))&&((this.retailEventStartTm == rhs.retailEventStartTm)||((this.retailEventStartTm!= null)&&this.retailEventStartTm.equals(rhs.retailEventStartTm))))&&((this.cardHolderVerificationTransactionConditionCd == rhs.cardHolderVerificationTransactionConditionCd)||((this.cardHolderVerificationTransactionConditionCd!= null)&&this.cardHolderVerificationTransactionConditionCd.equals(rhs.cardHolderVerificationTransactionConditionCd))))&&((this.cardHolderTransactionVerificationStatusCd == rhs.cardHolderTransactionVerificationStatusCd)||((this.cardHolderTransactionVerificationStatusCd!= null)&&this.cardHolderTransactionVerificationStatusCd.equals(rhs.cardHolderTransactionVerificationStatusCd))))&&((this.conversionRate == rhs.conversionRate)||((this.conversionRate!= null)&&this.conversionRate.equals(rhs.conversionRate))))&&((this.merchantPointOfServiceTerminalEntrySourceCd == rhs.merchantPointOfServiceTerminalEntrySourceCd)||((this.merchantPointOfServiceTerminalEntrySourceCd!= null)&&this.merchantPointOfServiceTerminalEntrySourceCd.equals(rhs.merchantPointOfServiceTerminalEntrySourceCd))))&&((this.retailEventTypeCd == rhs.retailEventTypeCd)||((this.retailEventTypeCd!= null)&&this.retailEventTypeCd.equals(rhs.retailEventTypeCd))))&&((this.terminalChannelTypeCd == rhs.terminalChannelTypeCd)||((this.terminalChannelTypeCd!= null)&&this.terminalChannelTypeCd.equals(rhs.terminalChannelTypeCd))))&&((this.retailEventId == rhs.retailEventId)||((this.retailEventId!= null)&&this.retailEventId.equals(rhs.retailEventId))))&&((this.statementDataDt == rhs.statementDataDt)||((this.statementDataDt!= null)&&this.statementDataDt.equals(rhs.statementDataDt))))&&((this.chargeBackReferenceNum == rhs.chargeBackReferenceNum)||((this.chargeBackReferenceNum!= null)&&this.chargeBackReferenceNum.equals(rhs.chargeBackReferenceNum))))&&((this.merchantPointOfServiceTerminalChannelInstanceId == rhs.merchantPointOfServiceTerminalChannelInstanceId)||((this.merchantPointOfServiceTerminalChannelInstanceId!= null)&&this.merchantPointOfServiceTerminalChannelInstanceId.equals(rhs.merchantPointOfServiceTerminalChannelInstanceId))))&&((this.recurringPaymentInd == rhs.recurringPaymentInd)||((this.recurringPaymentInd!= null)&&this.recurringPaymentInd.equals(rhs.recurringPaymentInd))))&&((this.paymentTokenAssuranceLevelCd == rhs.paymentTokenAssuranceLevelCd)||((this.paymentTokenAssuranceLevelCd!= null)&&this.paymentTokenAssuranceLevelCd.equals(rhs.paymentTokenAssuranceLevelCd))))&&((this.transactionLevelProcessingExpiryDt == rhs.transactionLevelProcessingExpiryDt)||((this.transactionLevelProcessingExpiryDt!= null)&&this.transactionLevelProcessingExpiryDt.equals(rhs.transactionLevelProcessingExpiryDt))))&&((this.fallBackVerificationVal == rhs.fallBackVerificationVal)||((this.fallBackVerificationVal!= null)&&this.fallBackVerificationVal.equals(rhs.fallBackVerificationVal))));
    }

}
