package com.td.api.mbcca.response.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.td.api.mbcca.shared.Cccyamt;

public class CreditCardAgreement {

    private Altkey altkey;
    private String hostAgreementNum;
    private String name;
    private String alternativeName;
    private String statusCd;
    private String statusDt;
    private String statusReasonCd;
    private String openDt;
    private String closeDt;
    private String statementCycleCd;
    private String currencyCd;
    private BigDecimal weightedAvgAPRRate;
    private BigDecimal balanceAmt;
    private BigDecimal previousBalanceAmt;
    private BigDecimal lastPaymentAmt;
    private String lastPaymentDt;
    private String lastTransactionDt;
    private BigDecimal ctdPaymentAmt;
    private BigDecimal pastDueAmt;
    private Integer pastDueDaysCnt;
    private BigDecimal currentChargesAmt;
    private BigDecimal totalDueAmt;
    private BigDecimal minimumPaymentAmt;
    private BigDecimal creditLimitAmt;
    private BigDecimal availableCreditLimitAmt;
    private BigDecimal cashAdvanceLimitAmt;
    private BigDecimal purchasesAnnualInterestRate;
    private BigDecimal cashAnnualInterestRate;
    private Boolean securedInd;
    private String liabilityCd;
    private String chargeOffDt;
    private String servicingBranchNum;
    private String agreementTypeCd;
    private Boolean vipInd;
    private String employeeTypeCd;
    private String expiryDt;
    private String productTypeCd;
    private List<Contact> contact = new ArrayList<Contact>();
    private String statementDt;
    private String paymentDueDt;
    private BigDecimal currentMinimumDueAmt;
    private List<DisclosureGroup> disclosureGroup = new ArrayList<DisclosureGroup>();
    private BigDecimal realTimeBalanceAmt;
    private Boolean returnMailInd;
    private BigDecimal chargeOffAmt;
    private String networkCd;
    private BigDecimal lastCreditLimitAmt;
    private BigDecimal ctdPurchaseBalanceAmt;
    private BigDecimal ctdCashBalanceAmt;
    private Boolean autoPayInd;
    private AgreementTSYSExtension agreementTSYSExtension;
    private String agreementClassificationCd;
    private TermsInfo termsInfo;
    private String lastMaintenanceDt;
    private String lastCashAdvanceDt;
    private BigDecimal statementPaymentDueAmt;
    private Integer outstandingAuthorizationCnt;
    private BigDecimal outstandingAuthorizationAmt;
    private BigDecimal lastCashAdvanceAmt;
    private BigDecimal lastPurchaseAmt;
    private String lastPurchaseDt;
    private BigDecimal lastCreditAdjustmentAmt;
    private String lastCreditAdjustmentDt;
    private String billingCycleDayOfMonthNum;
    private LoyaltyAccountMetrics loyaltyAccountMetrics;
    private String privacyEffectiveDt;
    private BigDecimal lastBilledAnnualFeeAmt;
    private String balanceProtectionInsuranceCd;
    private String statementDestinationCd;
    private String automaticPaymentCd;
    private Boolean expressConsentInd;
    private String expressConsentDt;
    private String routeNum;
    private String transitNum;
    private String expressConsentFormatCd;
    private BigDecimal lastCreditLimitChangeAmt;
    private String lastCreditLimitChangeDt;
    private AnnualFeeInfo annualFeeInfo;
    private InsuranceAgreementInfo insuranceAgreementInfo;
    private BigDecimal pendingBalanceAmt;
    private String ctdPaymentStatusCd;
    private String ctdPaymentTimingVal;
    private Integer issuedCardsCnt;
    private BigDecimal balanceTransferIntroductoryAnnualInterestRate;
    private BigDecimal balanceTransferPostIntroductoryAnnualInterestRate;
    private BigDecimal annualMembershipFeeAmt;
    private BigDecimal latePaymentFeeAmt;
    private BigDecimal purchasesMarginAnnualPercentageRate;
    private BigDecimal balanceTransferMarginAnnualPercentageRate;
    private BigDecimal cashAdvanceMarginAnnualPercentageRate;
    private BigDecimal cashAdvanceDailyPeriodicRate;
    private BigDecimal purchasesDailyPeriodicRate;
    private BigDecimal balanceTransferDailyPeriodicRate;
    private BigDecimal primePercentageRate;
    private BigDecimal foreignTransactionPct;
    private String mostSeverePayDueRangeVal;
    private AgreementFDRExtension agreementFDRExtension;
    private BigDecimal totalAuthorizationAmt;
    private BigDecimal cashBalanceAmt;
    private String lastCreditDt;
    private String firstTransactionDt;
    private BigDecimal overLimitAmt;
    private BigDecimal realTimeCashBalanceAmt;
    private BigDecimal realTimeAvailableCreditAmt;
    private BigDecimal availableCashAmt;
    private BigDecimal realTimeAvailableCashAmt;
    private String plasticStockTypeCd;
    private String statementStartDt;
    private BigDecimal lastCreditAmt;
    private BigDecimal penaltyAnnualPercentageRate;
    private BigDecimal overLimitFeeAmt;
    private BigDecimal marginPenaltyAnnualPercentageRate;
    private BigDecimal dishonouredConvenienceChequeFeeAmt;
    private BigDecimal returnedPaymentFeeAmt;
    private BigDecimal dailyPeriodicPenaltyAnnualPercentageRate;
    private String vipTypeCd;
    private String latePaymentFeeDesc;
    private String overLimitFeeDesc;
    private Cccyamt minimumOverLimitFeeCccyamt;
    private Cccyamt maximumOverLimitFeeCccyamt;
    private String lastCreditReportRequestedDt;
    private Cccyamt ctdHighestOverLimitCccyamt;
    private Cccyamt originalCreditLimitCccyamt;
    private Cccyamt futureCreditLimitCccyamt;
    private String futureCreditLimitChangedByUserId;
    private Boolean cashAdvanceLimitOverriddenInd;
    private Cccyamt cashAdvanceLimitOverrideCccyamt;
    private StatusChangesInfo statusChangesInfo;
    private String lastOverLimitDt;
    private Integer overLimitDaysCnt;
    private Integer overLimitCyclesCnt;
    private String ctdHighestOverLimitDt;
    private Cccyamt ytdOverLimitFeeCccyamt;
    private Integer ltdOverLimitTimesCnt;
    private List<PastDueInfo> pastDueInfo = new ArrayList<PastDueInfo>();
    private Cccyamt principleBalanceCccyamt;
    private String currencyDesc;
    private String automaticMailingHoldCd;
    private Integer numberOfOutstandingCardsCnt;
    private Cccyamt availableBeyondCreditLimitCccyamt;
    private Cccyamt availableBeyondCashLimitCccyamt;
    private String loyaltyProgramMembershipNum;
    private String cardFirstUseDt;
    private String lastBilledAnnualFeeDt;
    private String productTypeDesc;
    private String agreementTypeDesc;
    private List<AgreementToProduct> agreementToProduct = new ArrayList<AgreementToProduct>();
    private String authorizationStatusCd;
    private String authorizationReasonCd;
    private List<DailyAuthorizationSummary> dailyAuthorizationSummary = new ArrayList<DailyAuthorizationSummary>();
    private String statementHoldCd;
    private Boolean multipleCardsInd;
    private AgreementLoyaltyInfo agreementLoyaltyInfo;
    private String originatingTerritoryCd;
    private BigDecimal totalAvailableCreditAmt;
    private String financialInstitutionBankNum;
    private BigDecimal cashAdvanceBalanceAmt;
    private BigDecimal highestBalanceAmt;
    private Cccyamt ytdChargeCccyamt;
    private Cccyamt previousYearChargeCccyamt;
    private Cccyamt agreedPaymentCccyamt;
    private String correspondenceHoldCd;
    private Boolean availableBeyondCreditLimitDisplayInd;
    private Integer consecutivePastDueDaysCnt;
    private String lastPastDueDt;
    private String lastBillingCycleDt;
    private Cccyamt minimumTotalPaymentCccyamt;

    public Altkey getAltkey() {
        return altkey;
    }

    public void setAltkey(Altkey altkey) {
        this.altkey = altkey;
    }

    public String getHostAgreementNum() {
        return hostAgreementNum;
    }

    public void setHostAgreementNum(String hostAgreementNum) {
        this.hostAgreementNum = hostAgreementNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlternativeName() {
        return alternativeName;
    }

    public void setAlternativeName(String alternativeName) {
        this.alternativeName = alternativeName;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public String getStatusDt() {
        return statusDt;
    }

    public void setStatusDt(String statusDt) {
        this.statusDt = statusDt;
    }

    public String getStatusReasonCd() {
        return statusReasonCd;
    }

    public void setStatusReasonCd(String statusReasonCd) {
        this.statusReasonCd = statusReasonCd;
    }

    public String getOpenDt() {
        return openDt;
    }

    public void setOpenDt(String openDt) {
        this.openDt = openDt;
    }

    public String getCloseDt() {
        return closeDt;
    }

    public void setCloseDt(String closeDt) {
        this.closeDt = closeDt;
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd;
    }

    public String getStatementCycleCd() {
        return statementCycleCd;
    }

    public void setStatementCycleCd(String statementCycleCd) {
        this.statementCycleCd = statementCycleCd;
    }

    public BigDecimal getBalanceAmt() {
        return balanceAmt;
    }

    public void setBalanceAmt(BigDecimal balanceAmt) {
        this.balanceAmt = balanceAmt;
    }

    public BigDecimal getPreviousBalanceAmt() {
        return previousBalanceAmt;
    }

    public void setPreviousBalanceAmt(BigDecimal previousBalanceAmt) {
        this.previousBalanceAmt = previousBalanceAmt;
    }

    public BigDecimal getLastPaymentAmt() {
        return lastPaymentAmt;
    }

    public void setLastPaymentAmt(BigDecimal lastPaymentAmt) {
        this.lastPaymentAmt = lastPaymentAmt;
    }

    public String getLastPaymentDt() {
        return lastPaymentDt;
    }

    public void setLastPaymentDt(String lastPaymentDt) {
        this.lastPaymentDt = lastPaymentDt;
    }

    public String getLastTransactionDt() {
        return lastTransactionDt;
    }

    public void setLastTransactionDt(String lastTransactionDt) {
        this.lastTransactionDt = lastTransactionDt;
    }

    public BigDecimal getCtdPaymentAmt() {
        return ctdPaymentAmt;
    }

    public void setCtdPaymentAmt(BigDecimal ctdPaymentAmt) {
        this.ctdPaymentAmt = ctdPaymentAmt;
    }

    public BigDecimal getPastDueAmt() {
        return pastDueAmt;
    }

    public void setPastDueAmt(BigDecimal pastDueAmt) {
        this.pastDueAmt = pastDueAmt;
    }

    public Integer getPastDueDaysCnt() {
        return pastDueDaysCnt;
    }

    public void setPastDueDaysCnt(Integer pastDueDaysCnt) {
        this.pastDueDaysCnt = pastDueDaysCnt;
    }

    public BigDecimal getCurrentChargesAmt() {
        return currentChargesAmt;
    }

    public void setCurrentChargesAmt(BigDecimal currentChargesAmt) {
        this.currentChargesAmt = currentChargesAmt;
    }

    public BigDecimal getTotalDueAmt() {
        return totalDueAmt;
    }

    public void setTotalDueAmt(BigDecimal totalDueAmt) {
        this.totalDueAmt = totalDueAmt;
    }

    public BigDecimal getMinimumPaymentAmt() {
        return minimumPaymentAmt;
    }

    public void setMinimumPaymentAmt(BigDecimal minimumPaymentAmt) {
        this.minimumPaymentAmt = minimumPaymentAmt;
    }

    public BigDecimal getCreditLimitAmt() {
        return creditLimitAmt;
    }

    public void setCreditLimitAmt(BigDecimal creditLimitAmt) {
        this.creditLimitAmt = creditLimitAmt;
    }

    public BigDecimal getAvailableCreditLimitAmt() {
        return availableCreditLimitAmt;
    }

    public void setAvailableCreditLimitAmt(BigDecimal availableCreditLimitAmt) {
        this.availableCreditLimitAmt = availableCreditLimitAmt;
    }

    public BigDecimal getCashAdvanceLimitAmt() {
        return cashAdvanceLimitAmt;
    }

    public void setCashAdvanceLimitAmt(BigDecimal cashAdvanceLimitAmt) {
        this.cashAdvanceLimitAmt = cashAdvanceLimitAmt;
    }

    public BigDecimal getPurchasesAnnualInterestRate() {
        return purchasesAnnualInterestRate;
    }

    public void setPurchasesAnnualInterestRate(BigDecimal purchasesAnnualInterestRate) {
        this.purchasesAnnualInterestRate = purchasesAnnualInterestRate;
    }

    public BigDecimal getCashAnnualInterestRate() {
        return cashAnnualInterestRate;
    }

    public void setCashAnnualInterestRate(BigDecimal cashAnnualInterestRate) {
        this.cashAnnualInterestRate = cashAnnualInterestRate;
    }

    public Boolean getSecuredInd() {
        return securedInd;
    }

    public void setSecuredInd(Boolean securedInd) {
        this.securedInd = securedInd;
    }

    public String getLiabilityCd() {
        return liabilityCd;
    }

    public void setLiabilityCd(String liabilityCd) {
        this.liabilityCd = liabilityCd;
    }

    public String getChargeOffDt() {
        return chargeOffDt;
    }

    public void setChargeOffDt(String chargeOffDt) {
        this.chargeOffDt = chargeOffDt;
    }

    public String getServicingBranchNum() {
        return servicingBranchNum;
    }

    public void setServicingBranchNum(String servicingBranchNum) {
        this.servicingBranchNum = servicingBranchNum;
    }

    public String getAgreementTypeCd() {
        return agreementTypeCd;
    }

    public void setAgreementTypeCd(String agreementTypeCd) {
        this.agreementTypeCd = agreementTypeCd;
    }

    public Boolean getVipInd() {
        return vipInd;
    }

    public void setVipInd(Boolean vipInd) {
        this.vipInd = vipInd;
    }

    public String getEmployeeTypeCd() {
        return employeeTypeCd;
    }

    public void setEmployeeTypeCd(String employeeTypeCd) {
        this.employeeTypeCd = employeeTypeCd;
    }

    public String getExpiryDt() {
        return expiryDt;
    }

    public void setExpiryDt(String expiryDt) {
        this.expiryDt = expiryDt;
    }

    public String getProductTypeCd() {
        return productTypeCd;
    }

    public void setProductTypeCd(String productTypeCd) {
        this.productTypeCd = productTypeCd;
    }

    public List<Contact> getContact() {
        return contact;
    }

    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }

    public String getStatementDt() {
        return statementDt;
    }

    public void setStatementDt(String statementDt) {
        this.statementDt = statementDt;
    }

    public String getPaymentDueDt() {
        return paymentDueDt;
    }

    public void setPaymentDueDt(String paymentDueDt) {
        this.paymentDueDt = paymentDueDt;
    }

    public BigDecimal getCurrentMinimumDueAmt() {
        return currentMinimumDueAmt;
    }

    public void setCurrentMinimumDueAmt(BigDecimal currentMinimumDueAmt) {
        this.currentMinimumDueAmt = currentMinimumDueAmt;
    }

    public List<DisclosureGroup> getDisclosureGroup() {
        return disclosureGroup;
    }

    public void setDisclosureGroup(List<DisclosureGroup> disclosureGroup) {
        this.disclosureGroup = disclosureGroup;
    }

    public BigDecimal getRealTimeBalanceAmt() {
        return realTimeBalanceAmt;
    }

    public void setRealTimeBalanceAmt(BigDecimal realTimeBalanceAmt) {
        this.realTimeBalanceAmt = realTimeBalanceAmt;
    }

    public Boolean getReturnMailInd() {
        return returnMailInd;
    }

    public void setReturnMailInd(Boolean returnMailInd) {
        this.returnMailInd = returnMailInd;
    }

    public BigDecimal getChargeOffAmt() {
        return chargeOffAmt;
    }

    public void setChargeOffAmt(BigDecimal chargeOffAmt) {
        this.chargeOffAmt = chargeOffAmt;
    }

    public String getNetworkCd() {
        return networkCd;
    }

    public void setNetworkCd(String networkCd) {
        this.networkCd = networkCd;
    }

    public BigDecimal getLastCreditLimitAmt() {
        return lastCreditLimitAmt;
    }

    public void setLastCreditLimitAmt(BigDecimal lastCreditLimitAmt) {
        this.lastCreditLimitAmt = lastCreditLimitAmt;
    }

    public BigDecimal getCtdPurchaseBalanceAmt() {
        return ctdPurchaseBalanceAmt;
    }

    public void setCtdPurchaseBalanceAmt(BigDecimal ctdPurchaseBalanceAmt) {
        this.ctdPurchaseBalanceAmt = ctdPurchaseBalanceAmt;
    }

    public BigDecimal getCtdCashBalanceAmt() {
        return ctdCashBalanceAmt;
    }

    public void setCtdCashBalanceAmt(BigDecimal ctdCashBalanceAmt) {
        this.ctdCashBalanceAmt = ctdCashBalanceAmt;
    }

    public BigDecimal getWeightedAvgAPRRate() {
        return weightedAvgAPRRate;
    }

    public void setWeightedAvgAPRRate(BigDecimal weightedAvgAPRRate) {
        this.weightedAvgAPRRate = weightedAvgAPRRate;
    }

    public Boolean getAutoPayInd() {
        return autoPayInd;
    }

    public void setAutoPayInd(Boolean autoPayInd) {
        this.autoPayInd = autoPayInd;
    }

    public AgreementTSYSExtension getAgreementTSYSExtension() {
        return agreementTSYSExtension;
    }

    public void setAgreementTSYSExtension(AgreementTSYSExtension agreementTSYSExtension) {
        this.agreementTSYSExtension = agreementTSYSExtension;
    }

    public String getAgreementClassificationCd() {
        return agreementClassificationCd;
    }

    public void setAgreementClassificationCd(String agreementClassificationCd) {
        this.agreementClassificationCd = agreementClassificationCd;
    }

    public TermsInfo getTermsInfo() {
        return termsInfo;
    }

    public void setTermsInfo(TermsInfo termsInfo) {
        this.termsInfo = termsInfo;
    }

    public String getLastMaintenanceDt() {
        return lastMaintenanceDt;
    }

    public void setLastMaintenanceDt(String lastMaintenanceDt) {
        this.lastMaintenanceDt = lastMaintenanceDt;
    }

    public String getLastCashAdvanceDt() {
        return lastCashAdvanceDt;
    }

    public void setLastCashAdvanceDt(String lastCashAdvanceDt) {
        this.lastCashAdvanceDt = lastCashAdvanceDt;
    }

    public BigDecimal getStatementPaymentDueAmt() {
        return statementPaymentDueAmt;
    }

    public void setStatementPaymentDueAmt(BigDecimal statementPaymentDueAmt) {
        this.statementPaymentDueAmt = statementPaymentDueAmt;
    }

    public Integer getOutstandingAuthorizationCnt() {
        return outstandingAuthorizationCnt;
    }

    public void setOutstandingAuthorizationCnt(Integer outstandingAuthorizationCnt) {
        this.outstandingAuthorizationCnt = outstandingAuthorizationCnt;
    }

    public BigDecimal getOutstandingAuthorizationAmt() {
        return outstandingAuthorizationAmt;
    }

    public void setOutstandingAuthorizationAmt(BigDecimal outstandingAuthorizationAmt) {
        this.outstandingAuthorizationAmt = outstandingAuthorizationAmt;
    }

    public BigDecimal getLastCashAdvanceAmt() {
        return lastCashAdvanceAmt;
    }

    public void setLastCashAdvanceAmt(BigDecimal lastCashAdvanceAmt) {
        this.lastCashAdvanceAmt = lastCashAdvanceAmt;
    }

    public BigDecimal getLastPurchaseAmt() {
        return lastPurchaseAmt;
    }

    public void setLastPurchaseAmt(BigDecimal lastPurchaseAmt) {
        this.lastPurchaseAmt = lastPurchaseAmt;
    }

    public String getLastPurchaseDt() {
        return lastPurchaseDt;
    }

    public void setLastPurchaseDt(String lastPurchaseDt) {
        this.lastPurchaseDt = lastPurchaseDt;
    }

    public BigDecimal getLastCreditAdjustmentAmt() {
        return lastCreditAdjustmentAmt;
    }

    public void setLastCreditAdjustmentAmt(BigDecimal lastCreditAdjustmentAmt) {
        this.lastCreditAdjustmentAmt = lastCreditAdjustmentAmt;
    }

    public String getLastCreditAdjustmentDt() {
        return lastCreditAdjustmentDt;
    }

    public void setLastCreditAdjustmentDt(String lastCreditAdjustmentDt) {
        this.lastCreditAdjustmentDt = lastCreditAdjustmentDt;
    }

    public String getBillingCycleDayOfMonthNum() {
        return billingCycleDayOfMonthNum;
    }

    public void setBillingCycleDayOfMonthNum(String billingCycleDayOfMonthNum) {
        this.billingCycleDayOfMonthNum = billingCycleDayOfMonthNum;
    }

    public LoyaltyAccountMetrics getLoyaltyAccountMetrics() {
        return loyaltyAccountMetrics;
    }

    public void setLoyaltyAccountMetrics(LoyaltyAccountMetrics loyaltyAccountMetrics) {
        this.loyaltyAccountMetrics = loyaltyAccountMetrics;
    }

    public String getPrivacyEffectiveDt() {
        return privacyEffectiveDt;
    }

    public void setPrivacyEffectiveDt(String privacyEffectiveDt) {
        this.privacyEffectiveDt = privacyEffectiveDt;
    }

    public BigDecimal getLastBilledAnnualFeeAmt() {
        return lastBilledAnnualFeeAmt;
    }

    public void setLastBilledAnnualFeeAmt(BigDecimal lastBilledAnnualFeeAmt) {
        this.lastBilledAnnualFeeAmt = lastBilledAnnualFeeAmt;
    }

    public String getBalanceProtectionInsuranceCd() {
        return balanceProtectionInsuranceCd;
    }

    public void setBalanceProtectionInsuranceCd(String balanceProtectionInsuranceCd) {
        this.balanceProtectionInsuranceCd = balanceProtectionInsuranceCd;
    }

    public String getStatementDestinationCd() {
        return statementDestinationCd;
    }

    public void setStatementDestinationCd(String statementDestinationCd) {
        this.statementDestinationCd = statementDestinationCd;
    }

    public String getAutomaticPaymentCd() {
        return automaticPaymentCd;
    }

    public void setAutomaticPaymentCd(String automaticPaymentCd) {
        this.automaticPaymentCd = automaticPaymentCd;
    }

    public Boolean getExpressConsentInd() {
        return expressConsentInd;
    }

    public void setExpressConsentInd(Boolean expressConsentInd) {
        this.expressConsentInd = expressConsentInd;
    }

    public String getExpressConsentDt() {
        return expressConsentDt;
    }

    public void setExpressConsentDt(String expressConsentDt) {
        this.expressConsentDt = expressConsentDt;
    }

    public String getRouteNum() {
        return routeNum;
    }

    public void setRouteNum(String routeNum) {
        this.routeNum = routeNum;
    }

    public String getTransitNum() {
        return transitNum;
    }

    public void setTransitNum(String transitNum) {
        this.transitNum = transitNum;
    }

    public String getExpressConsentFormatCd() {
        return expressConsentFormatCd;
    }

    public void setExpressConsentFormatCd(String expressConsentFormatCd) {
        this.expressConsentFormatCd = expressConsentFormatCd;
    }

    public BigDecimal getLastCreditLimitChangeAmt() {
        return lastCreditLimitChangeAmt;
    }

    public void setLastCreditLimitChangeAmt(BigDecimal lastCreditLimitChangeAmt) {
        this.lastCreditLimitChangeAmt = lastCreditLimitChangeAmt;
    }

    public String getLastCreditLimitChangeDt() {
        return lastCreditLimitChangeDt;
    }

    public void setLastCreditLimitChangeDt(String lastCreditLimitChangeDt) {
        this.lastCreditLimitChangeDt = lastCreditLimitChangeDt;
    }

    public AnnualFeeInfo getAnnualFeeInfo() {
        return annualFeeInfo;
    }

    public void setAnnualFeeInfo(AnnualFeeInfo annualFeeInfo) {
        this.annualFeeInfo = annualFeeInfo;
    }

    public InsuranceAgreementInfo getInsuranceAgreementInfo() {
        return insuranceAgreementInfo;
    }

    public void setInsuranceAgreementInfo(InsuranceAgreementInfo insuranceAgreementInfo) {
        this.insuranceAgreementInfo = insuranceAgreementInfo;
    }

    public BigDecimal getPendingBalanceAmt() {
        return pendingBalanceAmt;
    }

    public void setPendingBalanceAmt(BigDecimal pendingBalanceAmt) {
        this.pendingBalanceAmt = pendingBalanceAmt;
    }

    public String getCtdPaymentStatusCd() {
        return ctdPaymentStatusCd;
    }

    public void setCtdPaymentStatusCd(String ctdPaymentStatusCd) {
        this.ctdPaymentStatusCd = ctdPaymentStatusCd;
    }

    public String getCtdPaymentTimingVal() {
        return ctdPaymentTimingVal;
    }

    public void setCtdPaymentTimingVal(String ctdPaymentTimingVal) {
        this.ctdPaymentTimingVal = ctdPaymentTimingVal;
    }

    public Integer getIssuedCardsCnt() {
        return issuedCardsCnt;
    }

    public void setIssuedCardsCnt(Integer issuedCardsCnt) {
        this.issuedCardsCnt = issuedCardsCnt;
    }

    public BigDecimal getBalanceTransferIntroductoryAnnualInterestRate() {
        return balanceTransferIntroductoryAnnualInterestRate;
    }

    public void setBalanceTransferIntroductoryAnnualInterestRate(BigDecimal balanceTransferIntroductoryAnnualInterestRate) {
        this.balanceTransferIntroductoryAnnualInterestRate = balanceTransferIntroductoryAnnualInterestRate;
    }

    public BigDecimal getBalanceTransferPostIntroductoryAnnualInterestRate() {
        return balanceTransferPostIntroductoryAnnualInterestRate;
    }

    public void setBalanceTransferPostIntroductoryAnnualInterestRate(BigDecimal balanceTransferPostIntroductoryAnnualInterestRate) {
        this.balanceTransferPostIntroductoryAnnualInterestRate = balanceTransferPostIntroductoryAnnualInterestRate;
    }

    public BigDecimal getAnnualMembershipFeeAmt() {
        return annualMembershipFeeAmt;
    }

    public void setAnnualMembershipFeeAmt(BigDecimal annualMembershipFeeAmt) {
        this.annualMembershipFeeAmt = annualMembershipFeeAmt;
    }

    public BigDecimal getLatePaymentFeeAmt() {
        return latePaymentFeeAmt;
    }

    public void setLatePaymentFeeAmt(BigDecimal latePaymentFeeAmt) {
        this.latePaymentFeeAmt = latePaymentFeeAmt;
    }

    public BigDecimal getPurchasesMarginAnnualPercentageRate() {
        return purchasesMarginAnnualPercentageRate;
    }

    public void setPurchasesMarginAnnualPercentageRate(BigDecimal purchasesMarginAnnualPercentageRate) {
        this.purchasesMarginAnnualPercentageRate = purchasesMarginAnnualPercentageRate;
    }

    public BigDecimal getBalanceTransferMarginAnnualPercentageRate() {
        return balanceTransferMarginAnnualPercentageRate;
    }

    public void setBalanceTransferMarginAnnualPercentageRate(BigDecimal balanceTransferMarginAnnualPercentageRate) {
        this.balanceTransferMarginAnnualPercentageRate = balanceTransferMarginAnnualPercentageRate;
    }

    public BigDecimal getCashAdvanceMarginAnnualPercentageRate() {
        return cashAdvanceMarginAnnualPercentageRate;
    }

    public void setCashAdvanceMarginAnnualPercentageRate(BigDecimal cashAdvanceMarginAnnualPercentageRate) {
        this.cashAdvanceMarginAnnualPercentageRate = cashAdvanceMarginAnnualPercentageRate;
    }

    public BigDecimal getCashAdvanceDailyPeriodicRate() {
        return cashAdvanceDailyPeriodicRate;
    }

    public void setCashAdvanceDailyPeriodicRate(BigDecimal cashAdvanceDailyPeriodicRate) {
        this.cashAdvanceDailyPeriodicRate = cashAdvanceDailyPeriodicRate;
    }

    public BigDecimal getPurchasesDailyPeriodicRate() {
        return purchasesDailyPeriodicRate;
    }

    public void setPurchasesDailyPeriodicRate(BigDecimal purchasesDailyPeriodicRate) {
        this.purchasesDailyPeriodicRate = purchasesDailyPeriodicRate;
    }

    public BigDecimal getBalanceTransferDailyPeriodicRate() {
        return balanceTransferDailyPeriodicRate;
    }

    public void setBalanceTransferDailyPeriodicRate(BigDecimal balanceTransferDailyPeriodicRate) {
        this.balanceTransferDailyPeriodicRate = balanceTransferDailyPeriodicRate;
    }

    public BigDecimal getPrimePercentageRate() {
        return primePercentageRate;
    }

    public void setPrimePercentageRate(BigDecimal primePercentageRate) {
        this.primePercentageRate = primePercentageRate;
    }

    public BigDecimal getForeignTransactionPct() {
        return foreignTransactionPct;
    }

    public void setForeignTransactionPct(BigDecimal foreignTransactionPct) {
        this.foreignTransactionPct = foreignTransactionPct;
    }

    public String getMostSeverePayDueRangeVal() {
        return mostSeverePayDueRangeVal;
    }

    public void setMostSeverePayDueRangeVal(String mostSeverePayDueRangeVal) {
        this.mostSeverePayDueRangeVal = mostSeverePayDueRangeVal;
    }

    public AgreementFDRExtension getAgreementFDRExtension() {
        return agreementFDRExtension;
    }

    public void setAgreementFDRExtension(AgreementFDRExtension agreementFDRExtension) {
        this.agreementFDRExtension = agreementFDRExtension;
    }

    public BigDecimal getTotalAuthorizationAmt() {
        return totalAuthorizationAmt;
    }

    public void setTotalAuthorizationAmt(BigDecimal totalAuthorizationAmt) {
        this.totalAuthorizationAmt = totalAuthorizationAmt;
    }

    public BigDecimal getCashBalanceAmt() {
        return cashBalanceAmt;
    }

    public void setCashBalanceAmt(BigDecimal cashBalanceAmt) {
        this.cashBalanceAmt = cashBalanceAmt;
    }

    public String getLastCreditDt() {
        return lastCreditDt;
    }

    public void setLastCreditDt(String lastCreditDt) {
        this.lastCreditDt = lastCreditDt;
    }

    public String getFirstTransactionDt() {
        return firstTransactionDt;
    }

    public void setFirstTransactionDt(String firstTransactionDt) {
        this.firstTransactionDt = firstTransactionDt;
    }

    public BigDecimal getOverLimitAmt() {
        return overLimitAmt;
    }

    public void setOverLimitAmt(BigDecimal overLimitAmt) {
        this.overLimitAmt = overLimitAmt;
    }

    public BigDecimal getRealTimeCashBalanceAmt() {
        return realTimeCashBalanceAmt;
    }

    public void setRealTimeCashBalanceAmt(BigDecimal realTimeCashBalanceAmt) {
        this.realTimeCashBalanceAmt = realTimeCashBalanceAmt;
    }

    public BigDecimal getRealTimeAvailableCreditAmt() {
        return realTimeAvailableCreditAmt;
    }

    public void setRealTimeAvailableCreditAmt(BigDecimal realTimeAvailableCreditAmt) {
        this.realTimeAvailableCreditAmt = realTimeAvailableCreditAmt;
    }

    public BigDecimal getAvailableCashAmt() {
        return availableCashAmt;
    }

    public void setAvailableCashAmt(BigDecimal availableCashAmt) {
        this.availableCashAmt = availableCashAmt;
    }

    public BigDecimal getRealTimeAvailableCashAmt() {
        return realTimeAvailableCashAmt;
    }

    public void setRealTimeAvailableCashAmt(BigDecimal realTimeAvailableCashAmt) {
        this.realTimeAvailableCashAmt = realTimeAvailableCashAmt;
    }

    public String getPlasticStockTypeCd() {
        return plasticStockTypeCd;
    }

    public void setPlasticStockTypeCd(String plasticStockTypeCd) {
        this.plasticStockTypeCd = plasticStockTypeCd;
    }

    public String getStatementStartDt() {
        return statementStartDt;
    }

    public void setStatementStartDt(String statementStartDt) {
        this.statementStartDt = statementStartDt;
    }

    public BigDecimal getLastCreditAmt() {
        return lastCreditAmt;
    }

    public void setLastCreditAmt(BigDecimal lastCreditAmt) {
        this.lastCreditAmt = lastCreditAmt;
    }

    public BigDecimal getPenaltyAnnualPercentageRate() {
        return penaltyAnnualPercentageRate;
    }

    public void setPenaltyAnnualPercentageRate(BigDecimal penaltyAnnualPercentageRate) {
        this.penaltyAnnualPercentageRate = penaltyAnnualPercentageRate;
    }

    public BigDecimal getOverLimitFeeAmt() {
        return overLimitFeeAmt;
    }

    public void setOverLimitFeeAmt(BigDecimal overLimitFeeAmt) {
        this.overLimitFeeAmt = overLimitFeeAmt;
    }

    public BigDecimal getMarginPenaltyAnnualPercentageRate() {
        return marginPenaltyAnnualPercentageRate;
    }

    public void setMarginPenaltyAnnualPercentageRate(BigDecimal marginPenaltyAnnualPercentageRate) {
        this.marginPenaltyAnnualPercentageRate = marginPenaltyAnnualPercentageRate;
    }

    public BigDecimal getDishonouredConvenienceChequeFeeAmt() {
        return dishonouredConvenienceChequeFeeAmt;
    }

    public void setDishonouredConvenienceChequeFeeAmt(BigDecimal dishonouredConvenienceChequeFeeAmt) {
        this.dishonouredConvenienceChequeFeeAmt = dishonouredConvenienceChequeFeeAmt;
    }

    public BigDecimal getReturnedPaymentFeeAmt() {
        return returnedPaymentFeeAmt;
    }

    public void setReturnedPaymentFeeAmt(BigDecimal returnedPaymentFeeAmt) {
        this.returnedPaymentFeeAmt = returnedPaymentFeeAmt;
    }

    public BigDecimal getDailyPeriodicPenaltyAnnualPercentageRate() {
        return dailyPeriodicPenaltyAnnualPercentageRate;
    }

    public void setDailyPeriodicPenaltyAnnualPercentageRate(BigDecimal dailyPeriodicPenaltyAnnualPercentageRate) {
        this.dailyPeriodicPenaltyAnnualPercentageRate = dailyPeriodicPenaltyAnnualPercentageRate;
    }

    public String getVipTypeCd() {
        return vipTypeCd;
    }

    public void setVipTypeCd(String vipTypeCd) {
        this.vipTypeCd = vipTypeCd;
    }

    public String getLatePaymentFeeDesc() {
        return latePaymentFeeDesc;
    }

    public void setLatePaymentFeeDesc(String latePaymentFeeDesc) {
        this.latePaymentFeeDesc = latePaymentFeeDesc;
    }

    public String getOverLimitFeeDesc() {
        return overLimitFeeDesc;
    }

    public void setOverLimitFeeDesc(String overLimitFeeDesc) {
        this.overLimitFeeDesc = overLimitFeeDesc;
    }

    public Cccyamt getMinimumOverLimitFeeCccyamt() {
        return minimumOverLimitFeeCccyamt;
    }

    public void setMinimumOverLimitFeeCccyamt(Cccyamt minimumOverLimitFeeCccyamt) {
        this.minimumOverLimitFeeCccyamt = minimumOverLimitFeeCccyamt;
    }

    public Cccyamt getMaximumOverLimitFeeCccyamt() {
        return maximumOverLimitFeeCccyamt;
    }

    public void setMaximumOverLimitFeeCccyamt(Cccyamt maximumOverLimitFeeCccyamt) {
        this.maximumOverLimitFeeCccyamt = maximumOverLimitFeeCccyamt;
    }

    public String getLastCreditReportRequestedDt() {
        return lastCreditReportRequestedDt;
    }

    public void setLastCreditReportRequestedDt(String lastCreditReportRequestedDt) {
        this.lastCreditReportRequestedDt = lastCreditReportRequestedDt;
    }

    public Cccyamt getCtdHighestOverLimitCccyamt() {
        return ctdHighestOverLimitCccyamt;
    }

    public void setCtdHighestOverLimitCccyamt(Cccyamt ctdHighestOverLimitCccyamt) {
        this.ctdHighestOverLimitCccyamt = ctdHighestOverLimitCccyamt;
    }

    public Cccyamt getOriginalCreditLimitCccyamt() {
        return originalCreditLimitCccyamt;
    }

    public void setOriginalCreditLimitCccyamt(Cccyamt originalCreditLimitCccyamt) {
        this.originalCreditLimitCccyamt = originalCreditLimitCccyamt;
    }

    public Cccyamt getFutureCreditLimitCccyamt() {
        return futureCreditLimitCccyamt;
    }

    public void setFutureCreditLimitCccyamt(Cccyamt futureCreditLimitCccyamt) {
        this.futureCreditLimitCccyamt = futureCreditLimitCccyamt;
    }

    public String getFutureCreditLimitChangedByUserId() {
        return futureCreditLimitChangedByUserId;
    }

    public void setFutureCreditLimitChangedByUserId(String futureCreditLimitChangedByUserId) {
        this.futureCreditLimitChangedByUserId = futureCreditLimitChangedByUserId;
    }

    public Boolean getCashAdvanceLimitOverriddenInd() {
        return cashAdvanceLimitOverriddenInd;
    }

    public void setCashAdvanceLimitOverriddenInd(Boolean cashAdvanceLimitOverriddenInd) {
        this.cashAdvanceLimitOverriddenInd = cashAdvanceLimitOverriddenInd;
    }

    public Cccyamt getCashAdvanceLimitOverrideCccyamt() {
        return cashAdvanceLimitOverrideCccyamt;
    }

    public void setCashAdvanceLimitOverrideCccyamt(Cccyamt cashAdvanceLimitOverrideCccyamt) {
        this.cashAdvanceLimitOverrideCccyamt = cashAdvanceLimitOverrideCccyamt;
    }

    public StatusChangesInfo getStatusChangesInfo() {
        return statusChangesInfo;
    }

    public void setStatusChangesInfo(StatusChangesInfo statusChangesInfo) {
        this.statusChangesInfo = statusChangesInfo;
    }

    public String getLastOverLimitDt() {
        return lastOverLimitDt;
    }

    public void setLastOverLimitDt(String lastOverLimitDt) {
        this.lastOverLimitDt = lastOverLimitDt;
    }

    public Integer getOverLimitDaysCnt() {
        return overLimitDaysCnt;
    }

    public void setOverLimitDaysCnt(Integer overLimitDaysCnt) {
        this.overLimitDaysCnt = overLimitDaysCnt;
    }

    public Integer getOverLimitCyclesCnt() {
        return overLimitCyclesCnt;
    }

    public void setOverLimitCyclesCnt(Integer overLimitCyclesCnt) {
        this.overLimitCyclesCnt = overLimitCyclesCnt;
    }

    public String getCtdHighestOverLimitDt() {
        return ctdHighestOverLimitDt;
    }

    public void setCtdHighestOverLimitDt(String ctdHighestOverLimitDt) {
        this.ctdHighestOverLimitDt = ctdHighestOverLimitDt;
    }

    public Cccyamt getYtdOverLimitFeeCccyamt() {
        return ytdOverLimitFeeCccyamt;
    }

    public void setYtdOverLimitFeeCccyamt(Cccyamt ytdOverLimitFeeCccyamt) {
        this.ytdOverLimitFeeCccyamt = ytdOverLimitFeeCccyamt;
    }

    public Integer getLtdOverLimitTimesCnt() {
        return ltdOverLimitTimesCnt;
    }

    public void setLtdOverLimitTimesCnt(Integer ltdOverLimitTimesCnt) {
        this.ltdOverLimitTimesCnt = ltdOverLimitTimesCnt;
    }

    public List<PastDueInfo> getPastDueInfo() {
        return pastDueInfo;
    }

    public void setPastDueInfo(List<PastDueInfo> pastDueInfo) {
        this.pastDueInfo = pastDueInfo;
    }

    public Cccyamt getPrincipleBalanceCccyamt() {
        return principleBalanceCccyamt;
    }

    public void setPrincipleBalanceCccyamt(Cccyamt principleBalanceCccyamt) {
        this.principleBalanceCccyamt = principleBalanceCccyamt;
    }

    public String getCurrencyDesc() {
        return currencyDesc;
    }

    public void setCurrencyDesc(String currencyDesc) {
        this.currencyDesc = currencyDesc;
    }

    public String getAutomaticMailingHoldCd() {
        return automaticMailingHoldCd;
    }

    public void setAutomaticMailingHoldCd(String automaticMailingHoldCd) {
        this.automaticMailingHoldCd = automaticMailingHoldCd;
    }

    public Integer getNumberOfOutstandingCardsCnt() {
        return numberOfOutstandingCardsCnt;
    }

    public void setNumberOfOutstandingCardsCnt(Integer numberOfOutstandingCardsCnt) {
        this.numberOfOutstandingCardsCnt = numberOfOutstandingCardsCnt;
    }

    public Cccyamt getAvailableBeyondCreditLimitCccyamt() {
        return availableBeyondCreditLimitCccyamt;
    }

    public void setAvailableBeyondCreditLimitCccyamt(Cccyamt availableBeyondCreditLimitCccyamt) {
        this.availableBeyondCreditLimitCccyamt = availableBeyondCreditLimitCccyamt;
    }

    public Cccyamt getAvailableBeyondCashLimitCccyamt() {
        return availableBeyondCashLimitCccyamt;
    }

    public void setAvailableBeyondCashLimitCccyamt(Cccyamt availableBeyondCashLimitCccyamt) {
        this.availableBeyondCashLimitCccyamt = availableBeyondCashLimitCccyamt;
    }

    public String getLoyaltyProgramMembershipNum() {
        return loyaltyProgramMembershipNum;
    }

    public void setLoyaltyProgramMembershipNum(String loyaltyProgramMembershipNum) {
        this.loyaltyProgramMembershipNum = loyaltyProgramMembershipNum;
    }

    public String getCardFirstUseDt() {
        return cardFirstUseDt;
    }

    public void setCardFirstUseDt(String cardFirstUseDt) {
        this.cardFirstUseDt = cardFirstUseDt;
    }

    public String getLastBilledAnnualFeeDt() {
        return lastBilledAnnualFeeDt;
    }

    public void setLastBilledAnnualFeeDt(String lastBilledAnnualFeeDt) {
        this.lastBilledAnnualFeeDt = lastBilledAnnualFeeDt;
    }

    public String getProductTypeDesc() {
        return productTypeDesc;
    }

    public void setProductTypeDesc(String productTypeDesc) {
        this.productTypeDesc = productTypeDesc;
    }

    public String getAgreementTypeDesc() {
        return agreementTypeDesc;
    }

    public void setAgreementTypeDesc(String agreementTypeDesc) {
        this.agreementTypeDesc = agreementTypeDesc;
    }

    public List<AgreementToProduct> getAgreementToProduct() {
        return agreementToProduct;
    }

    public void setAgreementToProduct(List<AgreementToProduct> agreementToProduct) {
        this.agreementToProduct = agreementToProduct;
    }

    public String getAuthorizationStatusCd() {
        return authorizationStatusCd;
    }

    public void setAuthorizationStatusCd(String authorizationStatusCd) {
        this.authorizationStatusCd = authorizationStatusCd;
    }

    public String getAuthorizationReasonCd() {
        return authorizationReasonCd;
    }

    public void setAuthorizationReasonCd(String authorizationReasonCd) {
        this.authorizationReasonCd = authorizationReasonCd;
    }

    public List<DailyAuthorizationSummary> getDailyAuthorizationSummary() {
        return dailyAuthorizationSummary;
    }

    public void setDailyAuthorizationSummary(List<DailyAuthorizationSummary> dailyAuthorizationSummary) {
        this.dailyAuthorizationSummary = dailyAuthorizationSummary;
    }

    public String getStatementHoldCd() {
        return statementHoldCd;
    }

    public void setStatementHoldCd(String statementHoldCd) {
        this.statementHoldCd = statementHoldCd;
    }

    public Boolean getMultipleCardsInd() {
        return multipleCardsInd;
    }

    public void setMultipleCardsInd(Boolean multipleCardsInd) {
        this.multipleCardsInd = multipleCardsInd;
    }

    public AgreementLoyaltyInfo getAgreementLoyaltyInfo() {
        return agreementLoyaltyInfo;
    }

    public void setAgreementLoyaltyInfo(AgreementLoyaltyInfo agreementLoyaltyInfo) {
        this.agreementLoyaltyInfo = agreementLoyaltyInfo;
    }

    public String getOriginatingTerritoryCd() {
        return originatingTerritoryCd;
    }

    public void setOriginatingTerritoryCd(String originatingTerritoryCd) {
        this.originatingTerritoryCd = originatingTerritoryCd;
    }

    public BigDecimal getTotalAvailableCreditAmt() {
        return totalAvailableCreditAmt;
    }

    public void setTotalAvailableCreditAmt(BigDecimal totalAvailableCreditAmt) {
        this.totalAvailableCreditAmt = totalAvailableCreditAmt;
    }

    public String getFinancialInstitutionBankNum() {
        return financialInstitutionBankNum;
    }

    public void setFinancialInstitutionBankNum(String financialInstitutionBankNum) {
        this.financialInstitutionBankNum = financialInstitutionBankNum;
    }

    public BigDecimal getCashAdvanceBalanceAmt() {
        return cashAdvanceBalanceAmt;
    }

    public void setCashAdvanceBalanceAmt(BigDecimal cashAdvanceBalanceAmt) {
        this.cashAdvanceBalanceAmt = cashAdvanceBalanceAmt;
    }

    public BigDecimal getHighestBalanceAmt() {
        return highestBalanceAmt;
    }

    public void setHighestBalanceAmt(BigDecimal highestBalanceAmt) {
        this.highestBalanceAmt = highestBalanceAmt;
    }

    public Cccyamt getYtdChargeCccyamt() {
        return ytdChargeCccyamt;
    }

    public void setYtdChargeCccyamt(Cccyamt ytdChargeCccyamt) {
        this.ytdChargeCccyamt = ytdChargeCccyamt;
    }

    public Cccyamt getPreviousYearChargeCccyamt() {
        return previousYearChargeCccyamt;
    }

    public void setPreviousYearChargeCccyamt(Cccyamt previousYearChargeCccyamt) {
        this.previousYearChargeCccyamt = previousYearChargeCccyamt;
    }

    public Cccyamt getAgreedPaymentCccyamt() {
        return agreedPaymentCccyamt;
    }

    public void setAgreedPaymentCccyamt(Cccyamt agreedPaymentCccyamt) {
        this.agreedPaymentCccyamt = agreedPaymentCccyamt;
    }

    public String getCorrespondenceHoldCd() {
        return correspondenceHoldCd;
    }

    public void setCorrespondenceHoldCd(String correspondenceHoldCd) {
        this.correspondenceHoldCd = correspondenceHoldCd;
    }

    public Boolean getAvailableBeyondCreditLimitDisplayInd() {
        return availableBeyondCreditLimitDisplayInd;
    }

    public void setAvailableBeyondCreditLimitDisplayInd(Boolean availableBeyondCreditLimitDisplayInd) {
        this.availableBeyondCreditLimitDisplayInd = availableBeyondCreditLimitDisplayInd;
    }

    public Integer getConsecutivePastDueDaysCnt() {
        return consecutivePastDueDaysCnt;
    }

    public void setConsecutivePastDueDaysCnt(Integer consecutivePastDueDaysCnt) {
        this.consecutivePastDueDaysCnt = consecutivePastDueDaysCnt;
    }

    public String getLastPastDueDt() {
        return lastPastDueDt;
    }

    public void setLastPastDueDt(String lastPastDueDt) {
        this.lastPastDueDt = lastPastDueDt;
    }

    public String getLastBillingCycleDt() {
        return lastBillingCycleDt;
    }

    public void setLastBillingCycleDt(String lastBillingCycleDt) {
        this.lastBillingCycleDt = lastBillingCycleDt;
    }

    public Cccyamt getMinimumTotalPaymentCccyamt() {
        return minimumTotalPaymentCccyamt;
    }

    public void setMinimumTotalPaymentCccyamt(Cccyamt minimumTotalPaymentCccyamt) {
        this.minimumTotalPaymentCccyamt = minimumTotalPaymentCccyamt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CreditCardAgreement.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("altkey");
        sb.append('=');
        sb.append(((this.altkey == null)?"<null>":this.altkey));
        sb.append(',');
        sb.append("hostAgreementNum");
        sb.append('=');
        sb.append(((this.hostAgreementNum == null)?"<null>":this.hostAgreementNum));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("alternativeName");
        sb.append('=');
        sb.append(((this.alternativeName == null)?"<null>":this.alternativeName));
        sb.append(',');
        sb.append("statusCd");
        sb.append('=');
        sb.append(((this.statusCd == null)?"<null>":this.statusCd));
        sb.append(',');
        sb.append("statusDt");
        sb.append('=');
        sb.append(((this.statusDt == null)?"<null>":this.statusDt));
        sb.append(',');
        sb.append("statusReasonCd");
        sb.append('=');
        sb.append(((this.statusReasonCd == null)?"<null>":this.statusReasonCd));
        sb.append(',');
        sb.append("openDt");
        sb.append('=');
        sb.append(((this.openDt == null)?"<null>":this.openDt));
        sb.append(',');
        sb.append("closeDt");
        sb.append('=');
        sb.append(((this.closeDt == null)?"<null>":this.closeDt));
        sb.append(',');
        sb.append("currencyCd");
        sb.append('=');
        sb.append(((this.currencyCd == null)?"<null>":this.currencyCd));
        sb.append(',');
        sb.append("statementCycleCd");
        sb.append('=');
        sb.append(((this.statementCycleCd == null)?"<null>":this.statementCycleCd));
        sb.append(',');
        sb.append("balanceAmt");
        sb.append('=');
        sb.append(((this.balanceAmt == null)?"<null>":this.balanceAmt));
        sb.append(',');
        sb.append("previousBalanceAmt");
        sb.append('=');
        sb.append(((this.previousBalanceAmt == null)?"<null>":this.previousBalanceAmt));
        sb.append(',');
        sb.append("lastPaymentAmt");
        sb.append('=');
        sb.append(((this.lastPaymentAmt == null)?"<null>":this.lastPaymentAmt));
        sb.append(',');
        sb.append("lastPaymentDt");
        sb.append('=');
        sb.append(((this.lastPaymentDt == null)?"<null>":this.lastPaymentDt));
        sb.append(',');
        sb.append("lastTransactionDt");
        sb.append('=');
        sb.append(((this.lastTransactionDt == null)?"<null>":this.lastTransactionDt));
        sb.append(',');
        sb.append("ctdPaymentAmt");
        sb.append('=');
        sb.append(((this.ctdPaymentAmt == null)?"<null>":this.ctdPaymentAmt));
        sb.append(',');
        sb.append("pastDueAmt");
        sb.append('=');
        sb.append(((this.pastDueAmt == null)?"<null>":this.pastDueAmt));
        sb.append(',');
        sb.append("pastDueDaysCnt");
        sb.append('=');
        sb.append(((this.pastDueDaysCnt == null)?"<null>":this.pastDueDaysCnt));
        sb.append(',');
        sb.append("currentChargesAmt");
        sb.append('=');
        sb.append(((this.currentChargesAmt == null)?"<null>":this.currentChargesAmt));
        sb.append(',');
        sb.append("totalDueAmt");
        sb.append('=');
        sb.append(((this.totalDueAmt == null)?"<null>":this.totalDueAmt));
        sb.append(',');
        sb.append("minimumPaymentAmt");
        sb.append('=');
        sb.append(((this.minimumPaymentAmt == null)?"<null>":this.minimumPaymentAmt));
        sb.append(',');
        sb.append("creditLimitAmt");
        sb.append('=');
        sb.append(((this.creditLimitAmt == null)?"<null>":this.creditLimitAmt));
        sb.append(',');
        sb.append("availableCreditLimitAmt");
        sb.append('=');
        sb.append(((this.availableCreditLimitAmt == null)?"<null>":this.availableCreditLimitAmt));
        sb.append(',');
        sb.append("cashAdvanceLimitAmt");
        sb.append('=');
        sb.append(((this.cashAdvanceLimitAmt == null)?"<null>":this.cashAdvanceLimitAmt));
        sb.append(',');
        sb.append("purchasesAnnualInterestRate");
        sb.append('=');
        sb.append(((this.purchasesAnnualInterestRate == null)?"<null>":this.purchasesAnnualInterestRate));
        sb.append(',');
        sb.append("cashAnnualInterestRate");
        sb.append('=');
        sb.append(((this.cashAnnualInterestRate == null)?"<null>":this.cashAnnualInterestRate));
        sb.append(',');
        sb.append("securedInd");
        sb.append('=');
        sb.append(((this.securedInd == null)?"<null>":this.securedInd));
        sb.append(',');
        sb.append("liabilityCd");
        sb.append('=');
        sb.append(((this.liabilityCd == null)?"<null>":this.liabilityCd));
        sb.append(',');
        sb.append("chargeOffDt");
        sb.append('=');
        sb.append(((this.chargeOffDt == null)?"<null>":this.chargeOffDt));
        sb.append(',');
        sb.append("servicingBranchNum");
        sb.append('=');
        sb.append(((this.servicingBranchNum == null)?"<null>":this.servicingBranchNum));
        sb.append(',');
        sb.append("agreementTypeCd");
        sb.append('=');
        sb.append(((this.agreementTypeCd == null)?"<null>":this.agreementTypeCd));
        sb.append(',');
        sb.append("vipInd");
        sb.append('=');
        sb.append(((this.vipInd == null)?"<null>":this.vipInd));
        sb.append(',');
        sb.append("employeeTypeCd");
        sb.append('=');
        sb.append(((this.employeeTypeCd == null)?"<null>":this.employeeTypeCd));
        sb.append(',');
        sb.append("expiryDt");
        sb.append('=');
        sb.append(((this.expiryDt == null)?"<null>":this.expiryDt));
        sb.append(',');
        sb.append("productTypeCd");
        sb.append('=');
        sb.append(((this.productTypeCd == null)?"<null>":this.productTypeCd));
        sb.append(',');
        sb.append("contact");
        sb.append('=');
        sb.append(((this.contact == null)?"<null>":this.contact));
        sb.append(',');
        sb.append("statementDt");
        sb.append('=');
        sb.append(((this.statementDt == null)?"<null>":this.statementDt));
        sb.append(',');
        sb.append("paymentDueDt");
        sb.append('=');
        sb.append(((this.paymentDueDt == null)?"<null>":this.paymentDueDt));
        sb.append(',');
        sb.append("currentMinimumDueAmt");
        sb.append('=');
        sb.append(((this.currentMinimumDueAmt == null)?"<null>":this.currentMinimumDueAmt));
        sb.append(',');
        sb.append("disclosureGroup");
        sb.append('=');
        sb.append(((this.disclosureGroup == null)?"<null>":this.disclosureGroup));
        sb.append(',');
        sb.append("realTimeBalanceAmt");
        sb.append('=');
        sb.append(((this.realTimeBalanceAmt == null)?"<null>":this.realTimeBalanceAmt));
        sb.append(',');
        sb.append("returnMailInd");
        sb.append('=');
        sb.append(((this.returnMailInd == null)?"<null>":this.returnMailInd));
        sb.append(',');
        sb.append("chargeOffAmt");
        sb.append('=');
        sb.append(((this.chargeOffAmt == null)?"<null>":this.chargeOffAmt));
        sb.append(',');
        sb.append("networkCd");
        sb.append('=');
        sb.append(((this.networkCd == null)?"<null>":this.networkCd));
        sb.append(',');
        sb.append("lastCreditLimitAmt");
        sb.append('=');
        sb.append(((this.lastCreditLimitAmt == null)?"<null>":this.lastCreditLimitAmt));
        sb.append(',');
        sb.append("ctdPurchaseBalanceAmt");
        sb.append('=');
        sb.append(((this.ctdPurchaseBalanceAmt == null)?"<null>":this.ctdPurchaseBalanceAmt));
        sb.append(',');
        sb.append("ctdCashBalanceAmt");
        sb.append('=');
        sb.append(((this.ctdCashBalanceAmt == null)?"<null>":this.ctdCashBalanceAmt));
        sb.append(',');
        sb.append("weightedAvgAPRRate");
        sb.append('=');
        sb.append(((this.weightedAvgAPRRate == null)?"<null>":this.weightedAvgAPRRate));
        sb.append(',');
        sb.append("autoPayInd");
        sb.append('=');
        sb.append(((this.autoPayInd == null)?"<null>":this.autoPayInd));
        sb.append(',');
        sb.append("agreementTSYSExtension");
        sb.append('=');
        sb.append(((this.agreementTSYSExtension == null)?"<null>":this.agreementTSYSExtension));
        sb.append(',');
        sb.append("agreementClassificationCd");
        sb.append('=');
        sb.append(((this.agreementClassificationCd == null)?"<null>":this.agreementClassificationCd));
        sb.append(',');
        sb.append("termsInfo");
        sb.append('=');
        sb.append(((this.termsInfo == null)?"<null>":this.termsInfo));
        sb.append(',');
        sb.append("lastMaintenanceDt");
        sb.append('=');
        sb.append(((this.lastMaintenanceDt == null)?"<null>":this.lastMaintenanceDt));
        sb.append(',');
        sb.append("lastCashAdvanceDt");
        sb.append('=');
        sb.append(((this.lastCashAdvanceDt == null)?"<null>":this.lastCashAdvanceDt));
        sb.append(',');
        sb.append("statementPaymentDueAmt");
        sb.append('=');
        sb.append(((this.statementPaymentDueAmt == null)?"<null>":this.statementPaymentDueAmt));
        sb.append(',');
        sb.append("outstandingAuthorizationCnt");
        sb.append('=');
        sb.append(((this.outstandingAuthorizationCnt == null)?"<null>":this.outstandingAuthorizationCnt));
        sb.append(',');
        sb.append("outstandingAuthorizationAmt");
        sb.append('=');
        sb.append(((this.outstandingAuthorizationAmt == null)?"<null>":this.outstandingAuthorizationAmt));
        sb.append(',');
        sb.append("lastCashAdvanceAmt");
        sb.append('=');
        sb.append(((this.lastCashAdvanceAmt == null)?"<null>":this.lastCashAdvanceAmt));
        sb.append(',');
        sb.append("lastPurchaseAmt");
        sb.append('=');
        sb.append(((this.lastPurchaseAmt == null)?"<null>":this.lastPurchaseAmt));
        sb.append(',');
        sb.append("lastPurchaseDt");
        sb.append('=');
        sb.append(((this.lastPurchaseDt == null)?"<null>":this.lastPurchaseDt));
        sb.append(',');
        sb.append("lastCreditAdjustmentAmt");
        sb.append('=');
        sb.append(((this.lastCreditAdjustmentAmt == null)?"<null>":this.lastCreditAdjustmentAmt));
        sb.append(',');
        sb.append("lastCreditAdjustmentDt");
        sb.append('=');
        sb.append(((this.lastCreditAdjustmentDt == null)?"<null>":this.lastCreditAdjustmentDt));
        sb.append(',');
        sb.append("billingCycleDayOfMonthNum");
        sb.append('=');
        sb.append(((this.billingCycleDayOfMonthNum == null)?"<null>":this.billingCycleDayOfMonthNum));
        sb.append(',');
        sb.append("loyaltyAccountMetrics");
        sb.append('=');
        sb.append(((this.loyaltyAccountMetrics == null)?"<null>":this.loyaltyAccountMetrics));
        sb.append(',');
        sb.append("privacyEffectiveDt");
        sb.append('=');
        sb.append(((this.privacyEffectiveDt == null)?"<null>":this.privacyEffectiveDt));
        sb.append(',');
        sb.append("lastBilledAnnualFeeAmt");
        sb.append('=');
        sb.append(((this.lastBilledAnnualFeeAmt == null)?"<null>":this.lastBilledAnnualFeeAmt));
        sb.append(',');
        sb.append("balanceProtectionInsuranceCd");
        sb.append('=');
        sb.append(((this.balanceProtectionInsuranceCd == null)?"<null>":this.balanceProtectionInsuranceCd));
        sb.append(',');
        sb.append("statementDestinationCd");
        sb.append('=');
        sb.append(((this.statementDestinationCd == null)?"<null>":this.statementDestinationCd));
        sb.append(',');
        sb.append("automaticPaymentCd");
        sb.append('=');
        sb.append(((this.automaticPaymentCd == null)?"<null>":this.automaticPaymentCd));
        sb.append(',');
        sb.append("expressConsentInd");
        sb.append('=');
        sb.append(((this.expressConsentInd == null)?"<null>":this.expressConsentInd));
        sb.append(',');
        sb.append("expressConsentDt");
        sb.append('=');
        sb.append(((this.expressConsentDt == null)?"<null>":this.expressConsentDt));
        sb.append(',');
        sb.append("routeNum");
        sb.append('=');
        sb.append(((this.routeNum == null)?"<null>":this.routeNum));
        sb.append(',');
        sb.append("transitNum");
        sb.append('=');
        sb.append(((this.transitNum == null)?"<null>":this.transitNum));
        sb.append(',');
        sb.append("expressConsentFormatCd");
        sb.append('=');
        sb.append(((this.expressConsentFormatCd == null)?"<null>":this.expressConsentFormatCd));
        sb.append(',');
        sb.append("lastCreditLimitChangeAmt");
        sb.append('=');
        sb.append(((this.lastCreditLimitChangeAmt == null)?"<null>":this.lastCreditLimitChangeAmt));
        sb.append(',');
        sb.append("lastCreditLimitChangeDt");
        sb.append('=');
        sb.append(((this.lastCreditLimitChangeDt == null)?"<null>":this.lastCreditLimitChangeDt));
        sb.append(',');
        sb.append("annualFeeInfo");
        sb.append('=');
        sb.append(((this.annualFeeInfo == null)?"<null>":this.annualFeeInfo));
        sb.append(',');
        sb.append("insuranceAgreementInfo");
        sb.append('=');
        sb.append(((this.insuranceAgreementInfo == null)?"<null>":this.insuranceAgreementInfo));
        sb.append(',');
        sb.append("pendingBalanceAmt");
        sb.append('=');
        sb.append(((this.pendingBalanceAmt == null)?"<null>":this.pendingBalanceAmt));
        sb.append(',');
        sb.append("ctdPaymentStatusCd");
        sb.append('=');
        sb.append(((this.ctdPaymentStatusCd == null)?"<null>":this.ctdPaymentStatusCd));
        sb.append(',');
        sb.append("ctdPaymentTimingVal");
        sb.append('=');
        sb.append(((this.ctdPaymentTimingVal == null)?"<null>":this.ctdPaymentTimingVal));
        sb.append(',');
        sb.append("issuedCardsCnt");
        sb.append('=');
        sb.append(((this.issuedCardsCnt == null)?"<null>":this.issuedCardsCnt));
        sb.append(',');
        sb.append("balanceTransferIntroductoryAnnualInterestRate");
        sb.append('=');
        sb.append(((this.balanceTransferIntroductoryAnnualInterestRate == null)?"<null>":this.balanceTransferIntroductoryAnnualInterestRate));
        sb.append(',');
        sb.append("balanceTransferPostIntroductoryAnnualInterestRate");
        sb.append('=');
        sb.append(((this.balanceTransferPostIntroductoryAnnualInterestRate == null)?"<null>":this.balanceTransferPostIntroductoryAnnualInterestRate));
        sb.append(',');
        sb.append("annualMembershipFeeAmt");
        sb.append('=');
        sb.append(((this.annualMembershipFeeAmt == null)?"<null>":this.annualMembershipFeeAmt));
        sb.append(',');
        sb.append("latePaymentFeeAmt");
        sb.append('=');
        sb.append(((this.latePaymentFeeAmt == null)?"<null>":this.latePaymentFeeAmt));
        sb.append(',');
        sb.append("purchasesMarginAnnualPercentageRate");
        sb.append('=');
        sb.append(((this.purchasesMarginAnnualPercentageRate == null)?"<null>":this.purchasesMarginAnnualPercentageRate));
        sb.append(',');
        sb.append("balanceTransferMarginAnnualPercentageRate");
        sb.append('=');
        sb.append(((this.balanceTransferMarginAnnualPercentageRate == null)?"<null>":this.balanceTransferMarginAnnualPercentageRate));
        sb.append(',');
        sb.append("cashAdvanceMarginAnnualPercentageRate");
        sb.append('=');
        sb.append(((this.cashAdvanceMarginAnnualPercentageRate == null)?"<null>":this.cashAdvanceMarginAnnualPercentageRate));
        sb.append(',');
        sb.append("cashAdvanceDailyPeriodicRate");
        sb.append('=');
        sb.append(((this.cashAdvanceDailyPeriodicRate == null)?"<null>":this.cashAdvanceDailyPeriodicRate));
        sb.append(',');
        sb.append("purchasesDailyPeriodicRate");
        sb.append('=');
        sb.append(((this.purchasesDailyPeriodicRate == null)?"<null>":this.purchasesDailyPeriodicRate));
        sb.append(',');
        sb.append("balanceTransferDailyPeriodicRate");
        sb.append('=');
        sb.append(((this.balanceTransferDailyPeriodicRate == null)?"<null>":this.balanceTransferDailyPeriodicRate));
        sb.append(',');
        sb.append("primePercentageRate");
        sb.append('=');
        sb.append(((this.primePercentageRate == null)?"<null>":this.primePercentageRate));
        sb.append(',');
        sb.append("foreignTransactionPct");
        sb.append('=');
        sb.append(((this.foreignTransactionPct == null)?"<null>":this.foreignTransactionPct));
        sb.append(',');
        sb.append("mostSeverePayDueRangeVal");
        sb.append('=');
        sb.append(((this.mostSeverePayDueRangeVal == null)?"<null>":this.mostSeverePayDueRangeVal));
        sb.append(',');
        sb.append("agreementFDRExtension");
        sb.append('=');
        sb.append(((this.agreementFDRExtension == null)?"<null>":this.agreementFDRExtension));
        sb.append(',');
        sb.append("totalAuthorizationAmt");
        sb.append('=');
        sb.append(((this.totalAuthorizationAmt == null)?"<null>":this.totalAuthorizationAmt));
        sb.append(',');
        sb.append("cashBalanceAmt");
        sb.append('=');
        sb.append(((this.cashBalanceAmt == null)?"<null>":this.cashBalanceAmt));
        sb.append(',');
        sb.append("lastCreditDt");
        sb.append('=');
        sb.append(((this.lastCreditDt == null)?"<null>":this.lastCreditDt));
        sb.append(',');
        sb.append("firstTransactionDt");
        sb.append('=');
        sb.append(((this.firstTransactionDt == null)?"<null>":this.firstTransactionDt));
        sb.append(',');
        sb.append("overLimitAmt");
        sb.append('=');
        sb.append(((this.overLimitAmt == null)?"<null>":this.overLimitAmt));
        sb.append(',');
        sb.append("realTimeCashBalanceAmt");
        sb.append('=');
        sb.append(((this.realTimeCashBalanceAmt == null)?"<null>":this.realTimeCashBalanceAmt));
        sb.append(',');
        sb.append("realTimeAvailableCreditAmt");
        sb.append('=');
        sb.append(((this.realTimeAvailableCreditAmt == null)?"<null>":this.realTimeAvailableCreditAmt));
        sb.append(',');
        sb.append("availableCashAmt");
        sb.append('=');
        sb.append(((this.availableCashAmt == null)?"<null>":this.availableCashAmt));
        sb.append(',');
        sb.append("realTimeAvailableCashAmt");
        sb.append('=');
        sb.append(((this.realTimeAvailableCashAmt == null)?"<null>":this.realTimeAvailableCashAmt));
        sb.append(',');
        sb.append("plasticStockTypeCd");
        sb.append('=');
        sb.append(((this.plasticStockTypeCd == null)?"<null>":this.plasticStockTypeCd));
        sb.append(',');
        sb.append("statementStartDt");
        sb.append('=');
        sb.append(((this.statementStartDt == null)?"<null>":this.statementStartDt));
        sb.append(',');
        sb.append("lastCreditAmt");
        sb.append('=');
        sb.append(((this.lastCreditAmt == null)?"<null>":this.lastCreditAmt));
        sb.append(',');
        sb.append("penaltyAnnualPercentageRate");
        sb.append('=');
        sb.append(((this.penaltyAnnualPercentageRate == null)?"<null>":this.penaltyAnnualPercentageRate));
        sb.append(',');
        sb.append("overLimitFeeAmt");
        sb.append('=');
        sb.append(((this.overLimitFeeAmt == null)?"<null>":this.overLimitFeeAmt));
        sb.append(',');
        sb.append("marginPenaltyAnnualPercentageRate");
        sb.append('=');
        sb.append(((this.marginPenaltyAnnualPercentageRate == null)?"<null>":this.marginPenaltyAnnualPercentageRate));
        sb.append(',');
        sb.append("dishonouredConvenienceChequeFeeAmt");
        sb.append('=');
        sb.append(((this.dishonouredConvenienceChequeFeeAmt == null)?"<null>":this.dishonouredConvenienceChequeFeeAmt));
        sb.append(',');
        sb.append("returnedPaymentFeeAmt");
        sb.append('=');
        sb.append(((this.returnedPaymentFeeAmt == null)?"<null>":this.returnedPaymentFeeAmt));
        sb.append(',');
        sb.append("dailyPeriodicPenaltyAnnualPercentageRate");
        sb.append('=');
        sb.append(((this.dailyPeriodicPenaltyAnnualPercentageRate == null)?"<null>":this.dailyPeriodicPenaltyAnnualPercentageRate));
        sb.append(',');
        sb.append("vipTypeCd");
        sb.append('=');
        sb.append(((this.vipTypeCd == null)?"<null>":this.vipTypeCd));
        sb.append(',');
        sb.append("latePaymentFeeDesc");
        sb.append('=');
        sb.append(((this.latePaymentFeeDesc == null)?"<null>":this.latePaymentFeeDesc));
        sb.append(',');
        sb.append("overLimitFeeDesc");
        sb.append('=');
        sb.append(((this.overLimitFeeDesc == null)?"<null>":this.overLimitFeeDesc));
        sb.append(',');
        sb.append("minimumOverLimitFeeCccyamt");
        sb.append('=');
        sb.append(((this.minimumOverLimitFeeCccyamt == null)?"<null>":this.minimumOverLimitFeeCccyamt));
        sb.append(',');
        sb.append("maximumOverLimitFeeCccyamt");
        sb.append('=');
        sb.append(((this.maximumOverLimitFeeCccyamt == null)?"<null>":this.maximumOverLimitFeeCccyamt));
        sb.append(',');
        sb.append("lastCreditReportRequestedDt");
        sb.append('=');
        sb.append(((this.lastCreditReportRequestedDt == null)?"<null>":this.lastCreditReportRequestedDt));
        sb.append(',');
        sb.append("ctdHighestOverLimitCccyamt");
        sb.append('=');
        sb.append(((this.ctdHighestOverLimitCccyamt == null)?"<null>":this.ctdHighestOverLimitCccyamt));
        sb.append(',');
        sb.append("originalCreditLimitCccyamt");
        sb.append('=');
        sb.append(((this.originalCreditLimitCccyamt == null)?"<null>":this.originalCreditLimitCccyamt));
        sb.append(',');
        sb.append("futureCreditLimitCccyamt");
        sb.append('=');
        sb.append(((this.futureCreditLimitCccyamt == null)?"<null>":this.futureCreditLimitCccyamt));
        sb.append(',');
        sb.append("futureCreditLimitChangedByUserId");
        sb.append('=');
        sb.append(((this.futureCreditLimitChangedByUserId == null)?"<null>":this.futureCreditLimitChangedByUserId));
        sb.append(',');
        sb.append("cashAdvanceLimitOverriddenInd");
        sb.append('=');
        sb.append(((this.cashAdvanceLimitOverriddenInd == null)?"<null>":this.cashAdvanceLimitOverriddenInd));
        sb.append(',');
        sb.append("cashAdvanceLimitOverrideCccyamt");
        sb.append('=');
        sb.append(((this.cashAdvanceLimitOverrideCccyamt == null)?"<null>":this.cashAdvanceLimitOverrideCccyamt));
        sb.append(',');
        sb.append("statusChangesInfo");
        sb.append('=');
        sb.append(((this.statusChangesInfo == null)?"<null>":this.statusChangesInfo));
        sb.append(',');
        sb.append("lastOverLimitDt");
        sb.append('=');
        sb.append(((this.lastOverLimitDt == null)?"<null>":this.lastOverLimitDt));
        sb.append(',');
        sb.append("overLimitDaysCnt");
        sb.append('=');
        sb.append(((this.overLimitDaysCnt == null)?"<null>":this.overLimitDaysCnt));
        sb.append(',');
        sb.append("overLimitCyclesCnt");
        sb.append('=');
        sb.append(((this.overLimitCyclesCnt == null)?"<null>":this.overLimitCyclesCnt));
        sb.append(',');
        sb.append("ctdHighestOverLimitDt");
        sb.append('=');
        sb.append(((this.ctdHighestOverLimitDt == null)?"<null>":this.ctdHighestOverLimitDt));
        sb.append(',');
        sb.append("ytdOverLimitFeeCccyamt");
        sb.append('=');
        sb.append(((this.ytdOverLimitFeeCccyamt == null)?"<null>":this.ytdOverLimitFeeCccyamt));
        sb.append(',');
        sb.append("ltdOverLimitTimesCnt");
        sb.append('=');
        sb.append(((this.ltdOverLimitTimesCnt == null)?"<null>":this.ltdOverLimitTimesCnt));
        sb.append(',');
        sb.append("pastDueInfo");
        sb.append('=');
        sb.append(((this.pastDueInfo == null)?"<null>":this.pastDueInfo));
        sb.append(',');
        sb.append("principleBalanceCccyamt");
        sb.append('=');
        sb.append(((this.principleBalanceCccyamt == null)?"<null>":this.principleBalanceCccyamt));
        sb.append(',');
        sb.append("currencyDesc");
        sb.append('=');
        sb.append(((this.currencyDesc == null)?"<null>":this.currencyDesc));
        sb.append(',');
        sb.append("automaticMailingHoldCd");
        sb.append('=');
        sb.append(((this.automaticMailingHoldCd == null)?"<null>":this.automaticMailingHoldCd));
        sb.append(',');
        sb.append("numberOfOutstandingCardsCnt");
        sb.append('=');
        sb.append(((this.numberOfOutstandingCardsCnt == null)?"<null>":this.numberOfOutstandingCardsCnt));
        sb.append(',');
        sb.append("availableBeyondCreditLimitCccyamt");
        sb.append('=');
        sb.append(((this.availableBeyondCreditLimitCccyamt == null)?"<null>":this.availableBeyondCreditLimitCccyamt));
        sb.append(',');
        sb.append("availableBeyondCashLimitCccyamt");
        sb.append('=');
        sb.append(((this.availableBeyondCashLimitCccyamt == null)?"<null>":this.availableBeyondCashLimitCccyamt));
        sb.append(',');
        sb.append("loyaltyProgramMembershipNum");
        sb.append('=');
        sb.append(((this.loyaltyProgramMembershipNum == null)?"<null>":this.loyaltyProgramMembershipNum));
        sb.append(',');
        sb.append("cardFirstUseDt");
        sb.append('=');
        sb.append(((this.cardFirstUseDt == null)?"<null>":this.cardFirstUseDt));
        sb.append(',');
        sb.append("lastBilledAnnualFeeDt");
        sb.append('=');
        sb.append(((this.lastBilledAnnualFeeDt == null)?"<null>":this.lastBilledAnnualFeeDt));
        sb.append(',');
        sb.append("productTypeDesc");
        sb.append('=');
        sb.append(((this.productTypeDesc == null)?"<null>":this.productTypeDesc));
        sb.append(',');
        sb.append("agreementTypeDesc");
        sb.append('=');
        sb.append(((this.agreementTypeDesc == null)?"<null>":this.agreementTypeDesc));
        sb.append(',');
        sb.append("agreementToProduct");
        sb.append('=');
        sb.append(((this.agreementToProduct == null)?"<null>":this.agreementToProduct));
        sb.append(',');
        sb.append("authorizationStatusCd");
        sb.append('=');
        sb.append(((this.authorizationStatusCd == null)?"<null>":this.authorizationStatusCd));
        sb.append(',');
        sb.append("authorizationReasonCd");
        sb.append('=');
        sb.append(((this.authorizationReasonCd == null)?"<null>":this.authorizationReasonCd));
        sb.append(',');
        sb.append("dailyAuthorizationSummary");
        sb.append('=');
        sb.append(((this.dailyAuthorizationSummary == null)?"<null>":this.dailyAuthorizationSummary));
        sb.append(',');
        sb.append("statementHoldCd");
        sb.append('=');
        sb.append(((this.statementHoldCd == null)?"<null>":this.statementHoldCd));
        sb.append(',');
        sb.append("multipleCardsInd");
        sb.append('=');
        sb.append(((this.multipleCardsInd == null)?"<null>":this.multipleCardsInd));
        sb.append(',');
        sb.append("agreementLoyaltyInfo");
        sb.append('=');
        sb.append(((this.agreementLoyaltyInfo == null)?"<null>":this.agreementLoyaltyInfo));
        sb.append(',');
        sb.append("originatingTerritoryCd");
        sb.append('=');
        sb.append(((this.originatingTerritoryCd == null)?"<null>":this.originatingTerritoryCd));
        sb.append(',');
        sb.append("totalAvailableCreditAmt");
        sb.append('=');
        sb.append(((this.totalAvailableCreditAmt == null)?"<null>":this.totalAvailableCreditAmt));
        sb.append(',');
        sb.append("financialInstitutionBankNum");
        sb.append('=');
        sb.append(((this.financialInstitutionBankNum == null)?"<null>":this.financialInstitutionBankNum));
        sb.append(',');
        sb.append("cashAdvanceBalanceAmt");
        sb.append('=');
        sb.append(((this.cashAdvanceBalanceAmt == null)?"<null>":this.cashAdvanceBalanceAmt));
        sb.append(',');
        sb.append("highestBalanceAmt");
        sb.append('=');
        sb.append(((this.highestBalanceAmt == null)?"<null>":this.highestBalanceAmt));
        sb.append(',');
        sb.append("ytdChargeCccyamt");
        sb.append('=');
        sb.append(((this.ytdChargeCccyamt == null)?"<null>":this.ytdChargeCccyamt));
        sb.append(',');
        sb.append("previousYearChargeCccyamt");
        sb.append('=');
        sb.append(((this.previousYearChargeCccyamt == null)?"<null>":this.previousYearChargeCccyamt));
        sb.append(',');
        sb.append("agreedPaymentCccyamt");
        sb.append('=');
        sb.append(((this.agreedPaymentCccyamt == null)?"<null>":this.agreedPaymentCccyamt));
        sb.append(',');
        sb.append("correspondenceHoldCd");
        sb.append('=');
        sb.append(((this.correspondenceHoldCd == null)?"<null>":this.correspondenceHoldCd));
        sb.append(',');
        sb.append("availableBeyondCreditLimitDisplayInd");
        sb.append('=');
        sb.append(((this.availableBeyondCreditLimitDisplayInd == null)?"<null>":this.availableBeyondCreditLimitDisplayInd));
        sb.append(',');
        sb.append("consecutivePastDueDaysCnt");
        sb.append('=');
        sb.append(((this.consecutivePastDueDaysCnt == null)?"<null>":this.consecutivePastDueDaysCnt));
        sb.append(',');
        sb.append("lastPastDueDt");
        sb.append('=');
        sb.append(((this.lastPastDueDt == null)?"<null>":this.lastPastDueDt));
        sb.append(',');
        sb.append("lastBillingCycleDt");
        sb.append('=');
        sb.append(((this.lastBillingCycleDt == null)?"<null>":this.lastBillingCycleDt));
        sb.append(',');
        sb.append("minimumTotalPaymentCccyamt");
        sb.append('=');
        sb.append(((this.minimumTotalPaymentCccyamt == null)?"<null>":this.minimumTotalPaymentCccyamt));
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
        result = ((result* 31)+((this.termsInfo == null)? 0 :this.termsInfo.hashCode()));
        result = ((result* 31)+((this.penaltyAnnualPercentageRate == null)? 0 :this.penaltyAnnualPercentageRate.hashCode()));
        result = ((result* 31)+((this.cashAdvanceLimitOverriddenInd == null)? 0 :this.cashAdvanceLimitOverriddenInd.hashCode()));
        result = ((result* 31)+((this.servicingBranchNum == null)? 0 :this.servicingBranchNum.hashCode()));
        result = ((result* 31)+((this.lastCreditDt == null)? 0 :this.lastCreditDt.hashCode()));
        result = ((result* 31)+((this.employeeTypeCd == null)? 0 :this.employeeTypeCd.hashCode()));
        result = ((result* 31)+((this.availableCreditLimitAmt == null)? 0 :this.availableCreditLimitAmt.hashCode()));
        result = ((result* 31)+((this.agreedPaymentCccyamt == null)? 0 :this.agreedPaymentCccyamt.hashCode()));
        result = ((result* 31)+((this.pendingBalanceAmt == null)? 0 :this.pendingBalanceAmt.hashCode()));
        result = ((result* 31)+((this.closeDt == null)? 0 :this.closeDt.hashCode()));
        result = ((result* 31)+((this.totalDueAmt == null)? 0 :this.totalDueAmt.hashCode()));
        result = ((result* 31)+((this.originalCreditLimitCccyamt == null)? 0 :this.originalCreditLimitCccyamt.hashCode()));
        result = ((result* 31)+((this.multipleCardsInd == null)? 0 :this.multipleCardsInd.hashCode()));
        result = ((result* 31)+((this.agreementTSYSExtension == null)? 0 :this.agreementTSYSExtension.hashCode()));
        result = ((result* 31)+((this.annualMembershipFeeAmt == null)? 0 :this.annualMembershipFeeAmt.hashCode()));
        result = ((result* 31)+((this.cashAdvanceLimitOverrideCccyamt == null)? 0 :this.cashAdvanceLimitOverrideCccyamt.hashCode()));
        result = ((result* 31)+((this.dailyPeriodicPenaltyAnnualPercentageRate == null)? 0 :this.dailyPeriodicPenaltyAnnualPercentageRate.hashCode()));
        result = ((result* 31)+((this.billingCycleDayOfMonthNum == null)? 0 :this.billingCycleDayOfMonthNum.hashCode()));
        result = ((result* 31)+((this.firstTransactionDt == null)? 0 :this.firstTransactionDt.hashCode()));
        result = ((result* 31)+((this.insuranceAgreementInfo == null)? 0 :this.insuranceAgreementInfo.hashCode()));
        result = ((result* 31)+((this.lastPastDueDt == null)? 0 :this.lastPastDueDt.hashCode()));
        result = ((result* 31)+((this.balanceProtectionInsuranceCd == null)? 0 :this.balanceProtectionInsuranceCd.hashCode()));
        result = ((result* 31)+((this.availableBeyondCashLimitCccyamt == null)? 0 :this.availableBeyondCashLimitCccyamt.hashCode()));
        result = ((result* 31)+((this.productTypeCd == null)? 0 :this.productTypeCd.hashCode()));
        result = ((result* 31)+((this.cashAdvanceDailyPeriodicRate == null)? 0 :this.cashAdvanceDailyPeriodicRate.hashCode()));
        result = ((result* 31)+((this.ctdPaymentAmt == null)? 0 :this.ctdPaymentAmt.hashCode()));
        result = ((result* 31)+((this.currentMinimumDueAmt == null)? 0 :this.currentMinimumDueAmt.hashCode()));
        result = ((result* 31)+((this.financialInstitutionBankNum == null)? 0 :this.financialInstitutionBankNum.hashCode()));
        result = ((result* 31)+((this.minimumPaymentAmt == null)? 0 :this.minimumPaymentAmt.hashCode()));
        result = ((result* 31)+((this.overLimitAmt == null)? 0 :this.overLimitAmt.hashCode()));
        result = ((result* 31)+((this.lastCreditAdjustmentAmt == null)? 0 :this.lastCreditAdjustmentAmt.hashCode()));
        result = ((result* 31)+((this.automaticPaymentCd == null)? 0 :this.automaticPaymentCd.hashCode()));
        result = ((result* 31)+((this.routeNum == null)? 0 :this.routeNum.hashCode()));
        result = ((result* 31)+((this.balanceTransferDailyPeriodicRate == null)? 0 :this.balanceTransferDailyPeriodicRate.hashCode()));
        result = ((result* 31)+((this.realTimeAvailableCreditAmt == null)? 0 :this.realTimeAvailableCreditAmt.hashCode()));
        result = ((result* 31)+((this.statusChangesInfo == null)? 0 :this.statusChangesInfo.hashCode()));
        result = ((result* 31)+((this.lastCreditLimitChangeAmt == null)? 0 :this.lastCreditLimitChangeAmt.hashCode()));
        result = ((result* 31)+((this.returnedPaymentFeeAmt == null)? 0 :this.returnedPaymentFeeAmt.hashCode()));
        result = ((result* 31)+((this.ctdHighestOverLimitCccyamt == null)? 0 :this.ctdHighestOverLimitCccyamt.hashCode()));
        result = ((result* 31)+((this.statementHoldCd == null)? 0 :this.statementHoldCd.hashCode()));
        result = ((result* 31)+((this.liabilityCd == null)? 0 :this.liabilityCd.hashCode()));
        result = ((result* 31)+((this.outstandingAuthorizationCnt == null)? 0 :this.outstandingAuthorizationCnt.hashCode()));
        result = ((result* 31)+((this.currencyCd == null)? 0 :this.currencyCd.hashCode()));
        result = ((result* 31)+((this.cashAdvanceBalanceAmt == null)? 0 :this.cashAdvanceBalanceAmt.hashCode()));
        result = ((result* 31)+((this.securedInd == null)? 0 :this.securedInd.hashCode()));
        result = ((result* 31)+((this.cashAdvanceLimitAmt == null)? 0 :this.cashAdvanceLimitAmt.hashCode()));
        result = ((result* 31)+((this.lastTransactionDt == null)? 0 :this.lastTransactionDt.hashCode()));
        result = ((result* 31)+((this.originatingTerritoryCd == null)? 0 :this.originatingTerritoryCd.hashCode()));
        result = ((result* 31)+((this.lastCreditLimitAmt == null)? 0 :this.lastCreditLimitAmt.hashCode()));
        result = ((result* 31)+((this.ctdPaymentStatusCd == null)? 0 :this.ctdPaymentStatusCd.hashCode()));
        result = ((result* 31)+((this.cashBalanceAmt == null)? 0 :this.cashBalanceAmt.hashCode()));
        result = ((result* 31)+((this.totalAvailableCreditAmt == null)? 0 :this.totalAvailableCreditAmt.hashCode()));
        result = ((result* 31)+((this.hostAgreementNum == null)? 0 :this.hostAgreementNum.hashCode()));
        result = ((result* 31)+((this.balanceTransferMarginAnnualPercentageRate == null)? 0 :this.balanceTransferMarginAnnualPercentageRate.hashCode()));
        result = ((result* 31)+((this.dailyAuthorizationSummary == null)? 0 :this.dailyAuthorizationSummary.hashCode()));
        result = ((result* 31)+((this.consecutivePastDueDaysCnt == null)? 0 :this.consecutivePastDueDaysCnt.hashCode()));
        result = ((result* 31)+((this.lastCreditAmt == null)? 0 :this.lastCreditAmt.hashCode()));
        result = ((result* 31)+((this.cardFirstUseDt == null)? 0 :this.cardFirstUseDt.hashCode()));
        result = ((result* 31)+((this.chargeOffAmt == null)? 0 :this.chargeOffAmt.hashCode()));
        result = ((result* 31)+((this.lastCreditLimitChangeDt == null)? 0 :this.lastCreditLimitChangeDt.hashCode()));
        result = ((result* 31)+((this.balanceTransferIntroductoryAnnualInterestRate == null)? 0 :this.balanceTransferIntroductoryAnnualInterestRate.hashCode()));
        result = ((result* 31)+((this.minimumTotalPaymentCccyamt == null)? 0 :this.minimumTotalPaymentCccyamt.hashCode()));
        result = ((result* 31)+((this.statusCd == null)? 0 :this.statusCd.hashCode()));
        result = ((result* 31)+((this.availableCashAmt == null)? 0 :this.availableCashAmt.hashCode()));
        result = ((result* 31)+((this.realTimeCashBalanceAmt == null)? 0 :this.realTimeCashBalanceAmt.hashCode()));
        result = ((result* 31)+((this.vipTypeCd == null)? 0 :this.vipTypeCd.hashCode()));
        result = ((result* 31)+((this.lastBilledAnnualFeeAmt == null)? 0 :this.lastBilledAnnualFeeAmt.hashCode()));
        result = ((result* 31)+((this.loyaltyProgramMembershipNum == null)? 0 :this.loyaltyProgramMembershipNum.hashCode()));
        result = ((result* 31)+((this.agreementTypeCd == null)? 0 :this.agreementTypeCd.hashCode()));
        result = ((result* 31)+((this.realTimeAvailableCashAmt == null)? 0 :this.realTimeAvailableCashAmt.hashCode()));
        result = ((result* 31)+((this.pastDueInfo == null)? 0 :this.pastDueInfo.hashCode()));
        result = ((result* 31)+((this.statementStartDt == null)? 0 :this.statementStartDt.hashCode()));
        result = ((result* 31)+((this.expressConsentFormatCd == null)? 0 :this.expressConsentFormatCd.hashCode()));
        result = ((result* 31)+((this.primePercentageRate == null)? 0 :this.primePercentageRate.hashCode()));
        result = ((result* 31)+((this.lastPaymentAmt == null)? 0 :this.lastPaymentAmt.hashCode()));
        result = ((result* 31)+((this.principleBalanceCccyamt == null)? 0 :this.principleBalanceCccyamt.hashCode()));
        result = ((result* 31)+((this.automaticMailingHoldCd == null)? 0 :this.automaticMailingHoldCd.hashCode()));
        result = ((result* 31)+((this.previousYearChargeCccyamt == null)? 0 :this.previousYearChargeCccyamt.hashCode()));
        result = ((result* 31)+((this.currentChargesAmt == null)? 0 :this.currentChargesAmt.hashCode()));
        result = ((result* 31)+((this.lastBilledAnnualFeeDt == null)? 0 :this.lastBilledAnnualFeeDt.hashCode()));
        result = ((result* 31)+((this.purchasesMarginAnnualPercentageRate == null)? 0 :this.purchasesMarginAnnualPercentageRate.hashCode()));
        result = ((result* 31)+((this.ctdCashBalanceAmt == null)? 0 :this.ctdCashBalanceAmt.hashCode()));
        result = ((result* 31)+((this.transitNum == null)? 0 :this.transitNum.hashCode()));
        result = ((result* 31)+((this.mostSeverePayDueRangeVal == null)? 0 :this.mostSeverePayDueRangeVal.hashCode()));
        result = ((result* 31)+((this.lastPurchaseAmt == null)? 0 :this.lastPurchaseAmt.hashCode()));
        result = ((result* 31)+((this.lastMaintenanceDt == null)? 0 :this.lastMaintenanceDt.hashCode()));
        result = ((result* 31)+((this.availableBeyondCreditLimitCccyamt == null)? 0 :this.availableBeyondCreditLimitCccyamt.hashCode()));
        result = ((result* 31)+((this.productTypeDesc == null)? 0 :this.productTypeDesc.hashCode()));
        result = ((result* 31)+((this.correspondenceHoldCd == null)? 0 :this.correspondenceHoldCd.hashCode()));
        result = ((result* 31)+((this.statusReasonCd == null)? 0 :this.statusReasonCd.hashCode()));
        result = ((result* 31)+((this.maximumOverLimitFeeCccyamt == null)? 0 :this.maximumOverLimitFeeCccyamt.hashCode()));
        result = ((result* 31)+((this.issuedCardsCnt == null)? 0 :this.issuedCardsCnt.hashCode()));
        result = ((result* 31)+((this.realTimeBalanceAmt == null)? 0 :this.realTimeBalanceAmt.hashCode()));
        result = ((result* 31)+((this.lastPurchaseDt == null)? 0 :this.lastPurchaseDt.hashCode()));
        result = ((result* 31)+((this.totalAuthorizationAmt == null)? 0 :this.totalAuthorizationAmt.hashCode()));
        result = ((result* 31)+((this.minimumOverLimitFeeCccyamt == null)? 0 :this.minimumOverLimitFeeCccyamt.hashCode()));
        result = ((result* 31)+((this.contact == null)? 0 :this.contact.hashCode()));
        result = ((result* 31)+((this.outstandingAuthorizationAmt == null)? 0 :this.outstandingAuthorizationAmt.hashCode()));
        result = ((result* 31)+((this.lastOverLimitDt == null)? 0 :this.lastOverLimitDt.hashCode()));
        result = ((result* 31)+((this.currencyDesc == null)? 0 :this.currencyDesc.hashCode()));
        result = ((result* 31)+((this.lastPaymentDt == null)? 0 :this.lastPaymentDt.hashCode()));
        result = ((result* 31)+((this.futureCreditLimitChangedByUserId == null)? 0 :this.futureCreditLimitChangedByUserId.hashCode()));
        result = ((result* 31)+((this.foreignTransactionPct == null)? 0 :this.foreignTransactionPct.hashCode()));
        result = ((result* 31)+((this.disclosureGroup == null)? 0 :this.disclosureGroup.hashCode()));
        result = ((result* 31)+((this.lastCreditReportRequestedDt == null)? 0 :this.lastCreditReportRequestedDt.hashCode()));
        result = ((result* 31)+((this.agreementClassificationCd == null)? 0 :this.agreementClassificationCd.hashCode()));
        result = ((result* 31)+((this.weightedAvgAPRRate == null)? 0 :this.weightedAvgAPRRate.hashCode()));
        result = ((result* 31)+((this.lastCashAdvanceDt == null)? 0 :this.lastCashAdvanceDt.hashCode()));
        result = ((result* 31)+((this.expressConsentDt == null)? 0 :this.expressConsentDt.hashCode()));
        result = ((result* 31)+((this.dishonouredConvenienceChequeFeeAmt == null)? 0 :this.dishonouredConvenienceChequeFeeAmt.hashCode()));
        result = ((result* 31)+((this.lastCashAdvanceAmt == null)? 0 :this.lastCashAdvanceAmt.hashCode()));
        result = ((result* 31)+((this.autoPayInd == null)? 0 :this.autoPayInd.hashCode()));
        result = ((result* 31)+((this.ctdHighestOverLimitDt == null)? 0 :this.ctdHighestOverLimitDt.hashCode()));
        result = ((result* 31)+((this.altkey == null)? 0 :this.altkey.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.loyaltyAccountMetrics == null)? 0 :this.loyaltyAccountMetrics.hashCode()));
        result = ((result* 31)+((this.authorizationReasonCd == null)? 0 :this.authorizationReasonCd.hashCode()));
        result = ((result* 31)+((this.openDt == null)? 0 :this.openDt.hashCode()));
        result = ((result* 31)+((this.ytdOverLimitFeeCccyamt == null)? 0 :this.ytdOverLimitFeeCccyamt.hashCode()));
        result = ((result* 31)+((this.statusDt == null)? 0 :this.statusDt.hashCode()));
        result = ((result* 31)+((this.overLimitFeeAmt == null)? 0 :this.overLimitFeeAmt.hashCode()));
        result = ((result* 31)+((this.ytdChargeCccyamt == null)? 0 :this.ytdChargeCccyamt.hashCode()));
        result = ((result* 31)+((this.lastCreditAdjustmentDt == null)? 0 :this.lastCreditAdjustmentDt.hashCode()));
        result = ((result* 31)+((this.latePaymentFeeAmt == null)? 0 :this.latePaymentFeeAmt.hashCode()));
        result = ((result* 31)+((this.returnMailInd == null)? 0 :this.returnMailInd.hashCode()));
        result = ((result* 31)+((this.cashAnnualInterestRate == null)? 0 :this.cashAnnualInterestRate.hashCode()));
        result = ((result* 31)+((this.annualFeeInfo == null)? 0 :this.annualFeeInfo.hashCode()));
        result = ((result* 31)+((this.agreementLoyaltyInfo == null)? 0 :this.agreementLoyaltyInfo.hashCode()));
        result = ((result* 31)+((this.statementDt == null)? 0 :this.statementDt.hashCode()));
        result = ((result* 31)+((this.marginPenaltyAnnualPercentageRate == null)? 0 :this.marginPenaltyAnnualPercentageRate.hashCode()));
        result = ((result* 31)+((this.ctdPaymentTimingVal == null)? 0 :this.ctdPaymentTimingVal.hashCode()));
        result = ((result* 31)+((this.balanceAmt == null)? 0 :this.balanceAmt.hashCode()));
        result = ((result* 31)+((this.statementPaymentDueAmt == null)? 0 :this.statementPaymentDueAmt.hashCode()));
        result = ((result* 31)+((this.overLimitFeeDesc == null)? 0 :this.overLimitFeeDesc.hashCode()));
        result = ((result* 31)+((this.latePaymentFeeDesc == null)? 0 :this.latePaymentFeeDesc.hashCode()));
        result = ((result* 31)+((this.pastDueAmt == null)? 0 :this.pastDueAmt.hashCode()));
        result = ((result* 31)+((this.vipInd == null)? 0 :this.vipInd.hashCode()));
        result = ((result* 31)+((this.creditLimitAmt == null)? 0 :this.creditLimitAmt.hashCode()));
        result = ((result* 31)+((this.highestBalanceAmt == null)? 0 :this.highestBalanceAmt.hashCode()));
        result = ((result* 31)+((this.overLimitCyclesCnt == null)? 0 :this.overLimitCyclesCnt.hashCode()));
        result = ((result* 31)+((this.authorizationStatusCd == null)? 0 :this.authorizationStatusCd.hashCode()));
        result = ((result* 31)+((this.paymentDueDt == null)? 0 :this.paymentDueDt.hashCode()));
        result = ((result* 31)+((this.alternativeName == null)? 0 :this.alternativeName.hashCode()));
        result = ((result* 31)+((this.networkCd == null)? 0 :this.networkCd.hashCode()));
        result = ((result* 31)+((this.purchasesDailyPeriodicRate == null)? 0 :this.purchasesDailyPeriodicRate.hashCode()));
        result = ((result* 31)+((this.statementDestinationCd == null)? 0 :this.statementDestinationCd.hashCode()));
        result = ((result* 31)+((this.ltdOverLimitTimesCnt == null)? 0 :this.ltdOverLimitTimesCnt.hashCode()));
        result = ((result* 31)+((this.statementCycleCd == null)? 0 :this.statementCycleCd.hashCode()));
        result = ((result* 31)+((this.balanceTransferPostIntroductoryAnnualInterestRate == null)? 0 :this.balanceTransferPostIntroductoryAnnualInterestRate.hashCode()));
        result = ((result* 31)+((this.agreementToProduct == null)? 0 :this.agreementToProduct.hashCode()));
        result = ((result* 31)+((this.lastBillingCycleDt == null)? 0 :this.lastBillingCycleDt.hashCode()));
        result = ((result* 31)+((this.expressConsentInd == null)? 0 :this.expressConsentInd.hashCode()));
        result = ((result* 31)+((this.previousBalanceAmt == null)? 0 :this.previousBalanceAmt.hashCode()));
        result = ((result* 31)+((this.ctdPurchaseBalanceAmt == null)? 0 :this.ctdPurchaseBalanceAmt.hashCode()));
        result = ((result* 31)+((this.availableBeyondCreditLimitDisplayInd == null)? 0 :this.availableBeyondCreditLimitDisplayInd.hashCode()));
        result = ((result* 31)+((this.purchasesAnnualInterestRate == null)? 0 :this.purchasesAnnualInterestRate.hashCode()));
        result = ((result* 31)+((this.plasticStockTypeCd == null)? 0 :this.plasticStockTypeCd.hashCode()));
        result = ((result* 31)+((this.agreementFDRExtension == null)? 0 :this.agreementFDRExtension.hashCode()));
        result = ((result* 31)+((this.cashAdvanceMarginAnnualPercentageRate == null)? 0 :this.cashAdvanceMarginAnnualPercentageRate.hashCode()));
        result = ((result* 31)+((this.agreementTypeDesc == null)? 0 :this.agreementTypeDesc.hashCode()));
        result = ((result* 31)+((this.chargeOffDt == null)? 0 :this.chargeOffDt.hashCode()));
        result = ((result* 31)+((this.numberOfOutstandingCardsCnt == null)? 0 :this.numberOfOutstandingCardsCnt.hashCode()));
        result = ((result* 31)+((this.futureCreditLimitCccyamt == null)? 0 :this.futureCreditLimitCccyamt.hashCode()));
        result = ((result* 31)+((this.pastDueDaysCnt == null)? 0 :this.pastDueDaysCnt.hashCode()));
        result = ((result* 31)+((this.privacyEffectiveDt == null)? 0 :this.privacyEffectiveDt.hashCode()));
        result = ((result* 31)+((this.overLimitDaysCnt == null)? 0 :this.overLimitDaysCnt.hashCode()));
        result = ((result* 31)+((this.expiryDt == null)? 0 :this.expiryDt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreditCardAgreement) == false) {
            return false;
        }
        CreditCardAgreement rhs = ((CreditCardAgreement) other);
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.termsInfo == rhs.termsInfo)||((this.termsInfo!= null)&&this.termsInfo.equals(rhs.termsInfo)))&&((this.penaltyAnnualPercentageRate == rhs.penaltyAnnualPercentageRate)||((this.penaltyAnnualPercentageRate!= null)&&this.penaltyAnnualPercentageRate.equals(rhs.penaltyAnnualPercentageRate))))&&((this.cashAdvanceLimitOverriddenInd == rhs.cashAdvanceLimitOverriddenInd)||((this.cashAdvanceLimitOverriddenInd!= null)&&this.cashAdvanceLimitOverriddenInd.equals(rhs.cashAdvanceLimitOverriddenInd))))&&((this.servicingBranchNum == rhs.servicingBranchNum)||((this.servicingBranchNum!= null)&&this.servicingBranchNum.equals(rhs.servicingBranchNum))))&&((this.lastCreditDt == rhs.lastCreditDt)||((this.lastCreditDt!= null)&&this.lastCreditDt.equals(rhs.lastCreditDt))))&&((this.employeeTypeCd == rhs.employeeTypeCd)||((this.employeeTypeCd!= null)&&this.employeeTypeCd.equals(rhs.employeeTypeCd))))&&((this.availableCreditLimitAmt == rhs.availableCreditLimitAmt)||((this.availableCreditLimitAmt!= null)&&this.availableCreditLimitAmt.equals(rhs.availableCreditLimitAmt))))&&((this.agreedPaymentCccyamt == rhs.agreedPaymentCccyamt)||((this.agreedPaymentCccyamt!= null)&&this.agreedPaymentCccyamt.equals(rhs.agreedPaymentCccyamt))))&&((this.pendingBalanceAmt == rhs.pendingBalanceAmt)||((this.pendingBalanceAmt!= null)&&this.pendingBalanceAmt.equals(rhs.pendingBalanceAmt))))&&((this.closeDt == rhs.closeDt)||((this.closeDt!= null)&&this.closeDt.equals(rhs.closeDt))))&&((this.totalDueAmt == rhs.totalDueAmt)||((this.totalDueAmt!= null)&&this.totalDueAmt.equals(rhs.totalDueAmt))))&&((this.originalCreditLimitCccyamt == rhs.originalCreditLimitCccyamt)||((this.originalCreditLimitCccyamt!= null)&&this.originalCreditLimitCccyamt.equals(rhs.originalCreditLimitCccyamt))))&&((this.multipleCardsInd == rhs.multipleCardsInd)||((this.multipleCardsInd!= null)&&this.multipleCardsInd.equals(rhs.multipleCardsInd))))&&((this.agreementTSYSExtension == rhs.agreementTSYSExtension)||((this.agreementTSYSExtension!= null)&&this.agreementTSYSExtension.equals(rhs.agreementTSYSExtension))))&&((this.annualMembershipFeeAmt == rhs.annualMembershipFeeAmt)||((this.annualMembershipFeeAmt!= null)&&this.annualMembershipFeeAmt.equals(rhs.annualMembershipFeeAmt))))&&((this.cashAdvanceLimitOverrideCccyamt == rhs.cashAdvanceLimitOverrideCccyamt)||((this.cashAdvanceLimitOverrideCccyamt!= null)&&this.cashAdvanceLimitOverrideCccyamt.equals(rhs.cashAdvanceLimitOverrideCccyamt))))&&((this.dailyPeriodicPenaltyAnnualPercentageRate == rhs.dailyPeriodicPenaltyAnnualPercentageRate)||((this.dailyPeriodicPenaltyAnnualPercentageRate!= null)&&this.dailyPeriodicPenaltyAnnualPercentageRate.equals(rhs.dailyPeriodicPenaltyAnnualPercentageRate))))&&((this.billingCycleDayOfMonthNum == rhs.billingCycleDayOfMonthNum)||((this.billingCycleDayOfMonthNum!= null)&&this.billingCycleDayOfMonthNum.equals(rhs.billingCycleDayOfMonthNum))))&&((this.firstTransactionDt == rhs.firstTransactionDt)||((this.firstTransactionDt!= null)&&this.firstTransactionDt.equals(rhs.firstTransactionDt))))&&((this.insuranceAgreementInfo == rhs.insuranceAgreementInfo)||((this.insuranceAgreementInfo!= null)&&this.insuranceAgreementInfo.equals(rhs.insuranceAgreementInfo))))&&((this.lastPastDueDt == rhs.lastPastDueDt)||((this.lastPastDueDt!= null)&&this.lastPastDueDt.equals(rhs.lastPastDueDt))))&&((this.balanceProtectionInsuranceCd == rhs.balanceProtectionInsuranceCd)||((this.balanceProtectionInsuranceCd!= null)&&this.balanceProtectionInsuranceCd.equals(rhs.balanceProtectionInsuranceCd))))&&((this.availableBeyondCashLimitCccyamt == rhs.availableBeyondCashLimitCccyamt)||((this.availableBeyondCashLimitCccyamt!= null)&&this.availableBeyondCashLimitCccyamt.equals(rhs.availableBeyondCashLimitCccyamt))))&&((this.productTypeCd == rhs.productTypeCd)||((this.productTypeCd!= null)&&this.productTypeCd.equals(rhs.productTypeCd))))&&((this.cashAdvanceDailyPeriodicRate == rhs.cashAdvanceDailyPeriodicRate)||((this.cashAdvanceDailyPeriodicRate!= null)&&this.cashAdvanceDailyPeriodicRate.equals(rhs.cashAdvanceDailyPeriodicRate))))&&((this.ctdPaymentAmt == rhs.ctdPaymentAmt)||((this.ctdPaymentAmt!= null)&&this.ctdPaymentAmt.equals(rhs.ctdPaymentAmt))))&&((this.currentMinimumDueAmt == rhs.currentMinimumDueAmt)||((this.currentMinimumDueAmt!= null)&&this.currentMinimumDueAmt.equals(rhs.currentMinimumDueAmt))))&&((this.financialInstitutionBankNum == rhs.financialInstitutionBankNum)||((this.financialInstitutionBankNum!= null)&&this.financialInstitutionBankNum.equals(rhs.financialInstitutionBankNum))))&&((this.minimumPaymentAmt == rhs.minimumPaymentAmt)||((this.minimumPaymentAmt!= null)&&this.minimumPaymentAmt.equals(rhs.minimumPaymentAmt))))&&((this.overLimitAmt == rhs.overLimitAmt)||((this.overLimitAmt!= null)&&this.overLimitAmt.equals(rhs.overLimitAmt))))&&((this.lastCreditAdjustmentAmt == rhs.lastCreditAdjustmentAmt)||((this.lastCreditAdjustmentAmt!= null)&&this.lastCreditAdjustmentAmt.equals(rhs.lastCreditAdjustmentAmt))))&&((this.automaticPaymentCd == rhs.automaticPaymentCd)||((this.automaticPaymentCd!= null)&&this.automaticPaymentCd.equals(rhs.automaticPaymentCd))))&&((this.routeNum == rhs.routeNum)||((this.routeNum!= null)&&this.routeNum.equals(rhs.routeNum))))&&((this.balanceTransferDailyPeriodicRate == rhs.balanceTransferDailyPeriodicRate)||((this.balanceTransferDailyPeriodicRate!= null)&&this.balanceTransferDailyPeriodicRate.equals(rhs.balanceTransferDailyPeriodicRate))))&&((this.realTimeAvailableCreditAmt == rhs.realTimeAvailableCreditAmt)||((this.realTimeAvailableCreditAmt!= null)&&this.realTimeAvailableCreditAmt.equals(rhs.realTimeAvailableCreditAmt))))&&((this.statusChangesInfo == rhs.statusChangesInfo)||((this.statusChangesInfo!= null)&&this.statusChangesInfo.equals(rhs.statusChangesInfo))))&&((this.lastCreditLimitChangeAmt == rhs.lastCreditLimitChangeAmt)||((this.lastCreditLimitChangeAmt!= null)&&this.lastCreditLimitChangeAmt.equals(rhs.lastCreditLimitChangeAmt))))&&((this.returnedPaymentFeeAmt == rhs.returnedPaymentFeeAmt)||((this.returnedPaymentFeeAmt!= null)&&this.returnedPaymentFeeAmt.equals(rhs.returnedPaymentFeeAmt))))&&((this.ctdHighestOverLimitCccyamt == rhs.ctdHighestOverLimitCccyamt)||((this.ctdHighestOverLimitCccyamt!= null)&&this.ctdHighestOverLimitCccyamt.equals(rhs.ctdHighestOverLimitCccyamt))))&&((this.statementHoldCd == rhs.statementHoldCd)||((this.statementHoldCd!= null)&&this.statementHoldCd.equals(rhs.statementHoldCd))))&&((this.liabilityCd == rhs.liabilityCd)||((this.liabilityCd!= null)&&this.liabilityCd.equals(rhs.liabilityCd))))&&((this.outstandingAuthorizationCnt == rhs.outstandingAuthorizationCnt)||((this.outstandingAuthorizationCnt!= null)&&this.outstandingAuthorizationCnt.equals(rhs.outstandingAuthorizationCnt))))&&((this.currencyCd == rhs.currencyCd)||((this.currencyCd!= null)&&this.currencyCd.equals(rhs.currencyCd))))&&((this.cashAdvanceBalanceAmt == rhs.cashAdvanceBalanceAmt)||((this.cashAdvanceBalanceAmt!= null)&&this.cashAdvanceBalanceAmt.equals(rhs.cashAdvanceBalanceAmt))))&&((this.securedInd == rhs.securedInd)||((this.securedInd!= null)&&this.securedInd.equals(rhs.securedInd))))&&((this.cashAdvanceLimitAmt == rhs.cashAdvanceLimitAmt)||((this.cashAdvanceLimitAmt!= null)&&this.cashAdvanceLimitAmt.equals(rhs.cashAdvanceLimitAmt))))&&((this.lastTransactionDt == rhs.lastTransactionDt)||((this.lastTransactionDt!= null)&&this.lastTransactionDt.equals(rhs.lastTransactionDt))))&&((this.originatingTerritoryCd == rhs.originatingTerritoryCd)||((this.originatingTerritoryCd!= null)&&this.originatingTerritoryCd.equals(rhs.originatingTerritoryCd))))&&((this.lastCreditLimitAmt == rhs.lastCreditLimitAmt)||((this.lastCreditLimitAmt!= null)&&this.lastCreditLimitAmt.equals(rhs.lastCreditLimitAmt))))&&((this.ctdPaymentStatusCd == rhs.ctdPaymentStatusCd)||((this.ctdPaymentStatusCd!= null)&&this.ctdPaymentStatusCd.equals(rhs.ctdPaymentStatusCd))))&&((this.cashBalanceAmt == rhs.cashBalanceAmt)||((this.cashBalanceAmt!= null)&&this.cashBalanceAmt.equals(rhs.cashBalanceAmt))))&&((this.totalAvailableCreditAmt == rhs.totalAvailableCreditAmt)||((this.totalAvailableCreditAmt!= null)&&this.totalAvailableCreditAmt.equals(rhs.totalAvailableCreditAmt))))&&((this.hostAgreementNum == rhs.hostAgreementNum)||((this.hostAgreementNum!= null)&&this.hostAgreementNum.equals(rhs.hostAgreementNum))))&&((this.balanceTransferMarginAnnualPercentageRate == rhs.balanceTransferMarginAnnualPercentageRate)||((this.balanceTransferMarginAnnualPercentageRate!= null)&&this.balanceTransferMarginAnnualPercentageRate.equals(rhs.balanceTransferMarginAnnualPercentageRate))))&&((this.dailyAuthorizationSummary == rhs.dailyAuthorizationSummary)||((this.dailyAuthorizationSummary!= null)&&this.dailyAuthorizationSummary.equals(rhs.dailyAuthorizationSummary))))&&((this.consecutivePastDueDaysCnt == rhs.consecutivePastDueDaysCnt)||((this.consecutivePastDueDaysCnt!= null)&&this.consecutivePastDueDaysCnt.equals(rhs.consecutivePastDueDaysCnt))))&&((this.lastCreditAmt == rhs.lastCreditAmt)||((this.lastCreditAmt!= null)&&this.lastCreditAmt.equals(rhs.lastCreditAmt))))&&((this.cardFirstUseDt == rhs.cardFirstUseDt)||((this.cardFirstUseDt!= null)&&this.cardFirstUseDt.equals(rhs.cardFirstUseDt))))&&((this.chargeOffAmt == rhs.chargeOffAmt)||((this.chargeOffAmt!= null)&&this.chargeOffAmt.equals(rhs.chargeOffAmt))))&&((this.lastCreditLimitChangeDt == rhs.lastCreditLimitChangeDt)||((this.lastCreditLimitChangeDt!= null)&&this.lastCreditLimitChangeDt.equals(rhs.lastCreditLimitChangeDt))))&&((this.balanceTransferIntroductoryAnnualInterestRate == rhs.balanceTransferIntroductoryAnnualInterestRate)||((this.balanceTransferIntroductoryAnnualInterestRate!= null)&&this.balanceTransferIntroductoryAnnualInterestRate.equals(rhs.balanceTransferIntroductoryAnnualInterestRate))))&&((this.minimumTotalPaymentCccyamt == rhs.minimumTotalPaymentCccyamt)||((this.minimumTotalPaymentCccyamt!= null)&&this.minimumTotalPaymentCccyamt.equals(rhs.minimumTotalPaymentCccyamt))))&&((this.statusCd == rhs.statusCd)||((this.statusCd!= null)&&this.statusCd.equals(rhs.statusCd))))&&((this.availableCashAmt == rhs.availableCashAmt)||((this.availableCashAmt!= null)&&this.availableCashAmt.equals(rhs.availableCashAmt))))&&((this.realTimeCashBalanceAmt == rhs.realTimeCashBalanceAmt)||((this.realTimeCashBalanceAmt!= null)&&this.realTimeCashBalanceAmt.equals(rhs.realTimeCashBalanceAmt))))&&((this.vipTypeCd == rhs.vipTypeCd)||((this.vipTypeCd!= null)&&this.vipTypeCd.equals(rhs.vipTypeCd))))&&((this.lastBilledAnnualFeeAmt == rhs.lastBilledAnnualFeeAmt)||((this.lastBilledAnnualFeeAmt!= null)&&this.lastBilledAnnualFeeAmt.equals(rhs.lastBilledAnnualFeeAmt))))&&((this.loyaltyProgramMembershipNum == rhs.loyaltyProgramMembershipNum)||((this.loyaltyProgramMembershipNum!= null)&&this.loyaltyProgramMembershipNum.equals(rhs.loyaltyProgramMembershipNum))))&&((this.agreementTypeCd == rhs.agreementTypeCd)||((this.agreementTypeCd!= null)&&this.agreementTypeCd.equals(rhs.agreementTypeCd))))&&((this.realTimeAvailableCashAmt == rhs.realTimeAvailableCashAmt)||((this.realTimeAvailableCashAmt!= null)&&this.realTimeAvailableCashAmt.equals(rhs.realTimeAvailableCashAmt))))&&((this.pastDueInfo == rhs.pastDueInfo)||((this.pastDueInfo!= null)&&this.pastDueInfo.equals(rhs.pastDueInfo))))&&((this.statementStartDt == rhs.statementStartDt)||((this.statementStartDt!= null)&&this.statementStartDt.equals(rhs.statementStartDt))))&&((this.expressConsentFormatCd == rhs.expressConsentFormatCd)||((this.expressConsentFormatCd!= null)&&this.expressConsentFormatCd.equals(rhs.expressConsentFormatCd))))&&((this.primePercentageRate == rhs.primePercentageRate)||((this.primePercentageRate!= null)&&this.primePercentageRate.equals(rhs.primePercentageRate))))&&((this.lastPaymentAmt == rhs.lastPaymentAmt)||((this.lastPaymentAmt!= null)&&this.lastPaymentAmt.equals(rhs.lastPaymentAmt))))&&((this.principleBalanceCccyamt == rhs.principleBalanceCccyamt)||((this.principleBalanceCccyamt!= null)&&this.principleBalanceCccyamt.equals(rhs.principleBalanceCccyamt))))&&((this.automaticMailingHoldCd == rhs.automaticMailingHoldCd)||((this.automaticMailingHoldCd!= null)&&this.automaticMailingHoldCd.equals(rhs.automaticMailingHoldCd))))&&((this.previousYearChargeCccyamt == rhs.previousYearChargeCccyamt)||((this.previousYearChargeCccyamt!= null)&&this.previousYearChargeCccyamt.equals(rhs.previousYearChargeCccyamt))))&&((this.currentChargesAmt == rhs.currentChargesAmt)||((this.currentChargesAmt!= null)&&this.currentChargesAmt.equals(rhs.currentChargesAmt))))&&((this.lastBilledAnnualFeeDt == rhs.lastBilledAnnualFeeDt)||((this.lastBilledAnnualFeeDt!= null)&&this.lastBilledAnnualFeeDt.equals(rhs.lastBilledAnnualFeeDt))))&&((this.purchasesMarginAnnualPercentageRate == rhs.purchasesMarginAnnualPercentageRate)||((this.purchasesMarginAnnualPercentageRate!= null)&&this.purchasesMarginAnnualPercentageRate.equals(rhs.purchasesMarginAnnualPercentageRate))))&&((this.ctdCashBalanceAmt == rhs.ctdCashBalanceAmt)||((this.ctdCashBalanceAmt!= null)&&this.ctdCashBalanceAmt.equals(rhs.ctdCashBalanceAmt))))&&((this.transitNum == rhs.transitNum)||((this.transitNum!= null)&&this.transitNum.equals(rhs.transitNum))))&&((this.mostSeverePayDueRangeVal == rhs.mostSeverePayDueRangeVal)||((this.mostSeverePayDueRangeVal!= null)&&this.mostSeverePayDueRangeVal.equals(rhs.mostSeverePayDueRangeVal))))&&((this.lastPurchaseAmt == rhs.lastPurchaseAmt)||((this.lastPurchaseAmt!= null)&&this.lastPurchaseAmt.equals(rhs.lastPurchaseAmt))))&&((this.lastMaintenanceDt == rhs.lastMaintenanceDt)||((this.lastMaintenanceDt!= null)&&this.lastMaintenanceDt.equals(rhs.lastMaintenanceDt))))&&((this.availableBeyondCreditLimitCccyamt == rhs.availableBeyondCreditLimitCccyamt)||((this.availableBeyondCreditLimitCccyamt!= null)&&this.availableBeyondCreditLimitCccyamt.equals(rhs.availableBeyondCreditLimitCccyamt))))&&((this.productTypeDesc == rhs.productTypeDesc)||((this.productTypeDesc!= null)&&this.productTypeDesc.equals(rhs.productTypeDesc))))&&((this.correspondenceHoldCd == rhs.correspondenceHoldCd)||((this.correspondenceHoldCd!= null)&&this.correspondenceHoldCd.equals(rhs.correspondenceHoldCd))))&&((this.statusReasonCd == rhs.statusReasonCd)||((this.statusReasonCd!= null)&&this.statusReasonCd.equals(rhs.statusReasonCd))))&&((this.maximumOverLimitFeeCccyamt == rhs.maximumOverLimitFeeCccyamt)||((this.maximumOverLimitFeeCccyamt!= null)&&this.maximumOverLimitFeeCccyamt.equals(rhs.maximumOverLimitFeeCccyamt))))&&((this.issuedCardsCnt == rhs.issuedCardsCnt)||((this.issuedCardsCnt!= null)&&this.issuedCardsCnt.equals(rhs.issuedCardsCnt))))&&((this.realTimeBalanceAmt == rhs.realTimeBalanceAmt)||((this.realTimeBalanceAmt!= null)&&this.realTimeBalanceAmt.equals(rhs.realTimeBalanceAmt))))&&((this.lastPurchaseDt == rhs.lastPurchaseDt)||((this.lastPurchaseDt!= null)&&this.lastPurchaseDt.equals(rhs.lastPurchaseDt))))&&((this.totalAuthorizationAmt == rhs.totalAuthorizationAmt)||((this.totalAuthorizationAmt!= null)&&this.totalAuthorizationAmt.equals(rhs.totalAuthorizationAmt))))&&((this.minimumOverLimitFeeCccyamt == rhs.minimumOverLimitFeeCccyamt)||((this.minimumOverLimitFeeCccyamt!= null)&&this.minimumOverLimitFeeCccyamt.equals(rhs.minimumOverLimitFeeCccyamt))))&&((this.contact == rhs.contact)||((this.contact!= null)&&this.contact.equals(rhs.contact))))&&((this.outstandingAuthorizationAmt == rhs.outstandingAuthorizationAmt)||((this.outstandingAuthorizationAmt!= null)&&this.outstandingAuthorizationAmt.equals(rhs.outstandingAuthorizationAmt))))&&((this.lastOverLimitDt == rhs.lastOverLimitDt)||((this.lastOverLimitDt!= null)&&this.lastOverLimitDt.equals(rhs.lastOverLimitDt))))&&((this.currencyDesc == rhs.currencyDesc)||((this.currencyDesc!= null)&&this.currencyDesc.equals(rhs.currencyDesc))))&&((this.lastPaymentDt == rhs.lastPaymentDt)||((this.lastPaymentDt!= null)&&this.lastPaymentDt.equals(rhs.lastPaymentDt))))&&((this.futureCreditLimitChangedByUserId == rhs.futureCreditLimitChangedByUserId)||((this.futureCreditLimitChangedByUserId!= null)&&this.futureCreditLimitChangedByUserId.equals(rhs.futureCreditLimitChangedByUserId))))&&((this.foreignTransactionPct == rhs.foreignTransactionPct)||((this.foreignTransactionPct!= null)&&this.foreignTransactionPct.equals(rhs.foreignTransactionPct))))&&((this.disclosureGroup == rhs.disclosureGroup)||((this.disclosureGroup!= null)&&this.disclosureGroup.equals(rhs.disclosureGroup))))&&((this.lastCreditReportRequestedDt == rhs.lastCreditReportRequestedDt)||((this.lastCreditReportRequestedDt!= null)&&this.lastCreditReportRequestedDt.equals(rhs.lastCreditReportRequestedDt))))&&((this.agreementClassificationCd == rhs.agreementClassificationCd)||((this.agreementClassificationCd!= null)&&this.agreementClassificationCd.equals(rhs.agreementClassificationCd))))&&((this.weightedAvgAPRRate == rhs.weightedAvgAPRRate)||((this.weightedAvgAPRRate!= null)&&this.weightedAvgAPRRate.equals(rhs.weightedAvgAPRRate))))&&((this.lastCashAdvanceDt == rhs.lastCashAdvanceDt)||((this.lastCashAdvanceDt!= null)&&this.lastCashAdvanceDt.equals(rhs.lastCashAdvanceDt))))&&((this.expressConsentDt == rhs.expressConsentDt)||((this.expressConsentDt!= null)&&this.expressConsentDt.equals(rhs.expressConsentDt))))&&((this.dishonouredConvenienceChequeFeeAmt == rhs.dishonouredConvenienceChequeFeeAmt)||((this.dishonouredConvenienceChequeFeeAmt!= null)&&this.dishonouredConvenienceChequeFeeAmt.equals(rhs.dishonouredConvenienceChequeFeeAmt))))&&((this.lastCashAdvanceAmt == rhs.lastCashAdvanceAmt)||((this.lastCashAdvanceAmt!= null)&&this.lastCashAdvanceAmt.equals(rhs.lastCashAdvanceAmt))))&&((this.autoPayInd == rhs.autoPayInd)||((this.autoPayInd!= null)&&this.autoPayInd.equals(rhs.autoPayInd))))&&((this.ctdHighestOverLimitDt == rhs.ctdHighestOverLimitDt)||((this.ctdHighestOverLimitDt!= null)&&this.ctdHighestOverLimitDt.equals(rhs.ctdHighestOverLimitDt))))&&((this.altkey == rhs.altkey)||((this.altkey!= null)&&this.altkey.equals(rhs.altkey))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.loyaltyAccountMetrics == rhs.loyaltyAccountMetrics)||((this.loyaltyAccountMetrics!= null)&&this.loyaltyAccountMetrics.equals(rhs.loyaltyAccountMetrics))))&&((this.authorizationReasonCd == rhs.authorizationReasonCd)||((this.authorizationReasonCd!= null)&&this.authorizationReasonCd.equals(rhs.authorizationReasonCd))))&&((this.openDt == rhs.openDt)||((this.openDt!= null)&&this.openDt.equals(rhs.openDt))))&&((this.ytdOverLimitFeeCccyamt == rhs.ytdOverLimitFeeCccyamt)||((this.ytdOverLimitFeeCccyamt!= null)&&this.ytdOverLimitFeeCccyamt.equals(rhs.ytdOverLimitFeeCccyamt))))&&((this.statusDt == rhs.statusDt)||((this.statusDt!= null)&&this.statusDt.equals(rhs.statusDt))))&&((this.overLimitFeeAmt == rhs.overLimitFeeAmt)||((this.overLimitFeeAmt!= null)&&this.overLimitFeeAmt.equals(rhs.overLimitFeeAmt))))&&((this.ytdChargeCccyamt == rhs.ytdChargeCccyamt)||((this.ytdChargeCccyamt!= null)&&this.ytdChargeCccyamt.equals(rhs.ytdChargeCccyamt))))&&((this.lastCreditAdjustmentDt == rhs.lastCreditAdjustmentDt)||((this.lastCreditAdjustmentDt!= null)&&this.lastCreditAdjustmentDt.equals(rhs.lastCreditAdjustmentDt))))&&((this.latePaymentFeeAmt == rhs.latePaymentFeeAmt)||((this.latePaymentFeeAmt!= null)&&this.latePaymentFeeAmt.equals(rhs.latePaymentFeeAmt))))&&((this.returnMailInd == rhs.returnMailInd)||((this.returnMailInd!= null)&&this.returnMailInd.equals(rhs.returnMailInd))))&&((this.cashAnnualInterestRate == rhs.cashAnnualInterestRate)||((this.cashAnnualInterestRate!= null)&&this.cashAnnualInterestRate.equals(rhs.cashAnnualInterestRate))))&&((this.annualFeeInfo == rhs.annualFeeInfo)||((this.annualFeeInfo!= null)&&this.annualFeeInfo.equals(rhs.annualFeeInfo))))&&((this.agreementLoyaltyInfo == rhs.agreementLoyaltyInfo)||((this.agreementLoyaltyInfo!= null)&&this.agreementLoyaltyInfo.equals(rhs.agreementLoyaltyInfo))))&&((this.statementDt == rhs.statementDt)||((this.statementDt!= null)&&this.statementDt.equals(rhs.statementDt))))&&((this.marginPenaltyAnnualPercentageRate == rhs.marginPenaltyAnnualPercentageRate)||((this.marginPenaltyAnnualPercentageRate!= null)&&this.marginPenaltyAnnualPercentageRate.equals(rhs.marginPenaltyAnnualPercentageRate))))&&((this.ctdPaymentTimingVal == rhs.ctdPaymentTimingVal)||((this.ctdPaymentTimingVal!= null)&&this.ctdPaymentTimingVal.equals(rhs.ctdPaymentTimingVal))))&&((this.balanceAmt == rhs.balanceAmt)||((this.balanceAmt!= null)&&this.balanceAmt.equals(rhs.balanceAmt))))&&((this.statementPaymentDueAmt == rhs.statementPaymentDueAmt)||((this.statementPaymentDueAmt!= null)&&this.statementPaymentDueAmt.equals(rhs.statementPaymentDueAmt))))&&((this.overLimitFeeDesc == rhs.overLimitFeeDesc)||((this.overLimitFeeDesc!= null)&&this.overLimitFeeDesc.equals(rhs.overLimitFeeDesc))))&&((this.latePaymentFeeDesc == rhs.latePaymentFeeDesc)||((this.latePaymentFeeDesc!= null)&&this.latePaymentFeeDesc.equals(rhs.latePaymentFeeDesc))))&&((this.pastDueAmt == rhs.pastDueAmt)||((this.pastDueAmt!= null)&&this.pastDueAmt.equals(rhs.pastDueAmt))))&&((this.vipInd == rhs.vipInd)||((this.vipInd!= null)&&this.vipInd.equals(rhs.vipInd))))&&((this.creditLimitAmt == rhs.creditLimitAmt)||((this.creditLimitAmt!= null)&&this.creditLimitAmt.equals(rhs.creditLimitAmt))))&&((this.highestBalanceAmt == rhs.highestBalanceAmt)||((this.highestBalanceAmt!= null)&&this.highestBalanceAmt.equals(rhs.highestBalanceAmt))))&&((this.overLimitCyclesCnt == rhs.overLimitCyclesCnt)||((this.overLimitCyclesCnt!= null)&&this.overLimitCyclesCnt.equals(rhs.overLimitCyclesCnt))))&&((this.authorizationStatusCd == rhs.authorizationStatusCd)||((this.authorizationStatusCd!= null)&&this.authorizationStatusCd.equals(rhs.authorizationStatusCd))))&&((this.paymentDueDt == rhs.paymentDueDt)||((this.paymentDueDt!= null)&&this.paymentDueDt.equals(rhs.paymentDueDt))))&&((this.alternativeName == rhs.alternativeName)||((this.alternativeName!= null)&&this.alternativeName.equals(rhs.alternativeName))))&&((this.networkCd == rhs.networkCd)||((this.networkCd!= null)&&this.networkCd.equals(rhs.networkCd))))&&((this.purchasesDailyPeriodicRate == rhs.purchasesDailyPeriodicRate)||((this.purchasesDailyPeriodicRate!= null)&&this.purchasesDailyPeriodicRate.equals(rhs.purchasesDailyPeriodicRate))))&&((this.statementDestinationCd == rhs.statementDestinationCd)||((this.statementDestinationCd!= null)&&this.statementDestinationCd.equals(rhs.statementDestinationCd))))&&((this.ltdOverLimitTimesCnt == rhs.ltdOverLimitTimesCnt)||((this.ltdOverLimitTimesCnt!= null)&&this.ltdOverLimitTimesCnt.equals(rhs.ltdOverLimitTimesCnt))))&&((this.statementCycleCd == rhs.statementCycleCd)||((this.statementCycleCd!= null)&&this.statementCycleCd.equals(rhs.statementCycleCd))))&&((this.balanceTransferPostIntroductoryAnnualInterestRate == rhs.balanceTransferPostIntroductoryAnnualInterestRate)||((this.balanceTransferPostIntroductoryAnnualInterestRate!= null)&&this.balanceTransferPostIntroductoryAnnualInterestRate.equals(rhs.balanceTransferPostIntroductoryAnnualInterestRate))))&&((this.agreementToProduct == rhs.agreementToProduct)||((this.agreementToProduct!= null)&&this.agreementToProduct.equals(rhs.agreementToProduct))))&&((this.lastBillingCycleDt == rhs.lastBillingCycleDt)||((this.lastBillingCycleDt!= null)&&this.lastBillingCycleDt.equals(rhs.lastBillingCycleDt))))&&((this.expressConsentInd == rhs.expressConsentInd)||((this.expressConsentInd!= null)&&this.expressConsentInd.equals(rhs.expressConsentInd))))&&((this.previousBalanceAmt == rhs.previousBalanceAmt)||((this.previousBalanceAmt!= null)&&this.previousBalanceAmt.equals(rhs.previousBalanceAmt))))&&((this.ctdPurchaseBalanceAmt == rhs.ctdPurchaseBalanceAmt)||((this.ctdPurchaseBalanceAmt!= null)&&this.ctdPurchaseBalanceAmt.equals(rhs.ctdPurchaseBalanceAmt))))&&((this.availableBeyondCreditLimitDisplayInd == rhs.availableBeyondCreditLimitDisplayInd)||((this.availableBeyondCreditLimitDisplayInd!= null)&&this.availableBeyondCreditLimitDisplayInd.equals(rhs.availableBeyondCreditLimitDisplayInd))))&&((this.purchasesAnnualInterestRate == rhs.purchasesAnnualInterestRate)||((this.purchasesAnnualInterestRate!= null)&&this.purchasesAnnualInterestRate.equals(rhs.purchasesAnnualInterestRate))))&&((this.plasticStockTypeCd == rhs.plasticStockTypeCd)||((this.plasticStockTypeCd!= null)&&this.plasticStockTypeCd.equals(rhs.plasticStockTypeCd))))&&((this.agreementFDRExtension == rhs.agreementFDRExtension)||((this.agreementFDRExtension!= null)&&this.agreementFDRExtension.equals(rhs.agreementFDRExtension))))&&((this.cashAdvanceMarginAnnualPercentageRate == rhs.cashAdvanceMarginAnnualPercentageRate)||((this.cashAdvanceMarginAnnualPercentageRate!= null)&&this.cashAdvanceMarginAnnualPercentageRate.equals(rhs.cashAdvanceMarginAnnualPercentageRate))))&&((this.agreementTypeDesc == rhs.agreementTypeDesc)||((this.agreementTypeDesc!= null)&&this.agreementTypeDesc.equals(rhs.agreementTypeDesc))))&&((this.chargeOffDt == rhs.chargeOffDt)||((this.chargeOffDt!= null)&&this.chargeOffDt.equals(rhs.chargeOffDt))))&&((this.numberOfOutstandingCardsCnt == rhs.numberOfOutstandingCardsCnt)||((this.numberOfOutstandingCardsCnt!= null)&&this.numberOfOutstandingCardsCnt.equals(rhs.numberOfOutstandingCardsCnt))))&&((this.futureCreditLimitCccyamt == rhs.futureCreditLimitCccyamt)||((this.futureCreditLimitCccyamt!= null)&&this.futureCreditLimitCccyamt.equals(rhs.futureCreditLimitCccyamt))))&&((this.pastDueDaysCnt == rhs.pastDueDaysCnt)||((this.pastDueDaysCnt!= null)&&this.pastDueDaysCnt.equals(rhs.pastDueDaysCnt))))&&((this.privacyEffectiveDt == rhs.privacyEffectiveDt)||((this.privacyEffectiveDt!= null)&&this.privacyEffectiveDt.equals(rhs.privacyEffectiveDt))))&&((this.overLimitDaysCnt == rhs.overLimitDaysCnt)||((this.overLimitDaysCnt!= null)&&this.overLimitDaysCnt.equals(rhs.overLimitDaysCnt))))&&((this.expiryDt == rhs.expiryDt)||((this.expiryDt!= null)&&this.expiryDt.equals(rhs.expiryDt))));
    }

}
