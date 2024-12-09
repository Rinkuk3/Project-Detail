package com.td.mbna.msec.midtier.types.common;

import com.google.gson.annotations.JsonAdapter;
import com.td.mbna.msec.midtier.serializers.GsonDateDeSerializer;

import java.io.Serializable;
import java.math.BigDecimal;

public class PCOfferType implements Serializable {

	private static final long serialVersionUID = 1L;
    private String cardTemplateId;
    private String disclosureId;
    private String productOfferType;
    private String productNameEn;
    private String productNameFr;
    private String defaultRatePercentChangeType;
    private BigDecimal purchaseAIR;
    private BigDecimal balXferAccessChqDepAIR;
    private BigDecimal cashAdvanceAIR;
    private BigDecimal minimumPaymentDue2;
    private BigDecimal minimumPaymentPercent;
    private BigDecimal accountAnnualFee2;
    private BigDecimal atmAccountFee2;
    private BigDecimal fixedATMAccountFee2;
    private BigDecimal minimumATMAccountFee2;
    private BigDecimal maximumAtmAccountfee2;
    private BigDecimal otcAccountFee2;
    private BigDecimal fixedOTCaccountFee2;
    private BigDecimal minimumOTCAccountFee2;
    private BigDecimal maximumOTCAccountFee2;
    private BigDecimal cashEquivalentAccountFee2;
    private BigDecimal fixedCashEquivalentAccountFee2;
    private BigDecimal minimumCashEquivalentAccountFee2;
    private BigDecimal maximumCashEquivalentAccountFee2;
    private BigDecimal balanceTransferAccountfee2;
    private BigDecimal fixedBalanceTransferAccountFee2;
    private BigDecimal minimumBalanceTransferAccountFee2;
    private BigDecimal accessChequeDepositAccountFee2;
    private BigDecimal fixedAccessChequeDepositAccountFee2;
    private BigDecimal maximumBalanceTransferAccountFee2;
    private BigDecimal minimumAccessChequeDepositAccountFee2;
    private BigDecimal maximumAccessChequeDepositAccountFee2;
    private BigDecimal overCreditLimitFee2;
    private BigDecimal returnedPaymentFee2;
    private BigDecimal inactiveCreditBalanceFee2;
    private BigDecimal returnedAccessChequeFee2;
    private BigDecimal rewardAmount;
    private BigDecimal balXferAccessChqDepPromoAIR;
    private BigDecimal purchasePromoAIR;
    private Integer numberOfBillingcyclestoInactive;
    private String clientProductCode2;
    private String pointsProgramName;
    private String branchIdentifier2;
    private String accountGroupingCode;
    private Integer balXferAccessChqDepTOWDuration;
    private String balXferAccessChqDepTOWDurationTypeCode;
    private Integer balXferAccessChqDepPromoDuration;
    private String balXferAccessChqDepPromoID;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long balXferAccessChqDepPromoEndDate;
    private Boolean balancetransferpromoRateForLifeindicator;
    private Boolean balanceTransferAmountIndicator;
    private Boolean purchasePromoRateForLifeindicator;
    private String purchasePromoID;
    private String smallBannerEn;
    private String largeBannerEn;
    private String largeBannerMobileEn;
    private String smallBannerFr;
    private String largeBannerFr;
    private String largeBannerMobileFr;
    private String tsysproductCode2;

    public String getCardTemplateId() {
        return cardTemplateId;
    }

    public void setCardTemplateId(String cardTemplateId) {
        this.cardTemplateId = cardTemplateId;
    }

    public String getDisclosureId() {
        return disclosureId;
    }

    public void setDisclosureId(String disclosureId) {
        this.disclosureId = disclosureId;
    }

    public String getProductOfferType() {
        return productOfferType;
    }

    public void setProductOfferType(String productOfferType) {
        this.productOfferType = productOfferType;
    }

    public String getProductNameEn() {
        return productNameEn;
    }

    public void setProductNameEn(String productNameEn) {
        this.productNameEn = productNameEn;
    }

    public String getProductNameFr() {
        return productNameFr;
    }

    public void setProductNameFr(String productNameFr) {
        this.productNameFr = productNameFr;
    }

    public BigDecimal getPurchaseAIR() {
        return purchaseAIR;
    }

    public void setPurchaseAIR(BigDecimal purchaseAIR) {
        this.purchaseAIR = purchaseAIR;
    }

    public BigDecimal getBalXferAccessChqDepAIR() {
        return balXferAccessChqDepAIR;
    }

    public void setBalXferAccessChqDepAIR(BigDecimal balXferAccessChqDepAIR) {
        this.balXferAccessChqDepAIR = balXferAccessChqDepAIR;
    }

    public BigDecimal getCashAdvanceAIR() {
        return cashAdvanceAIR;
    }

    public void setCashAdvanceAIR(BigDecimal cashAdvanceAIR) {
        this.cashAdvanceAIR = cashAdvanceAIR;
    }

    public String getDefaultRatePercentChangeType() {
        return defaultRatePercentChangeType;
    }

    public void setDefaultRatePercentChangeType(String defaultRatePercentChangeType) {
        this.defaultRatePercentChangeType = defaultRatePercentChangeType;
    }

    public BigDecimal getMinimumPaymentDue2() {
        return minimumPaymentDue2;
    }

    public void setMinimumPaymentDue2(BigDecimal minimumPaymentDue2) {
        this.minimumPaymentDue2 = minimumPaymentDue2;
    }

    public BigDecimal getMinimumPaymentPercent() {
        return minimumPaymentPercent;
    }

    public void setMinimumPaymentPercent(BigDecimal minimumPaymentPercent) {
        this.minimumPaymentPercent = minimumPaymentPercent;
    }

    public BigDecimal getAccountAnnualFee2() {
        return accountAnnualFee2;
    }

    public void setAccountAnnualFee2(BigDecimal accountAnnualFee2) {
        this.accountAnnualFee2 = accountAnnualFee2;
    }

    public BigDecimal getAtmAccountFee2() {
        return atmAccountFee2;
    }

    public void setAtmAccountFee2(BigDecimal atmAccountFee2) {
        this.atmAccountFee2 = atmAccountFee2;
    }

    public BigDecimal getFixedATMAccountFee2() {
        return fixedATMAccountFee2;
    }

    public void setFixedATMAccountFee2(BigDecimal fixedATMAccountFee2) {
        this.fixedATMAccountFee2 = fixedATMAccountFee2;
    }

    public BigDecimal getMinimumATMAccountFee2() {
        return minimumATMAccountFee2;
    }

    public void setMinimumATMAccountFee2(BigDecimal minimumATMAccountFee2) {
        this.minimumATMAccountFee2 = minimumATMAccountFee2;
    }

    public BigDecimal getMaximumAtmAccountfee2() {
        return maximumAtmAccountfee2;
    }

    public void setMaximumAtmAccountfee2(BigDecimal maximumAtmAccountfee2) {
        this.maximumAtmAccountfee2 = maximumAtmAccountfee2;
    }

    public BigDecimal getOtcAccountFee2() {
        return otcAccountFee2;
    }

    public void setOtcAccountFee2(BigDecimal otcAccountFee2) {
        this.otcAccountFee2 = otcAccountFee2;
    }

    public BigDecimal getFixedOTCaccountFee2() {
        return fixedOTCaccountFee2;
    }

    public void setFixedOTCaccountFee2(BigDecimal fixedOTCaccountFee2) {
        this.fixedOTCaccountFee2 = fixedOTCaccountFee2;
    }

    public BigDecimal getMinimumOTCAccountFee2() {
        return minimumOTCAccountFee2;
    }

    public void setMinimumOTCAccountFee2(BigDecimal minimumOTCAccountFee2) {
        this.minimumOTCAccountFee2 = minimumOTCAccountFee2;
    }

    public BigDecimal getMaximumOTCAccountFee2() {
        return maximumOTCAccountFee2;
    }

    public void setMaximumOTCAccountFee2(BigDecimal maximumOTCAccountFee2) {
        this.maximumOTCAccountFee2 = maximumOTCAccountFee2;
    }

    public BigDecimal getCashEquivalentAccountFee2() {
        return cashEquivalentAccountFee2;
    }

    public void setCashEquivalentAccountFee2(BigDecimal cashEquivalentAccountFee2) {
        this.cashEquivalentAccountFee2 = cashEquivalentAccountFee2;
    }

    public BigDecimal getFixedCashEquivalentAccountFee2() {
        return fixedCashEquivalentAccountFee2;
    }

    public void setFixedCashEquivalentAccountFee2(BigDecimal fixedCashEquivalentAccountFee2) {
        this.fixedCashEquivalentAccountFee2 = fixedCashEquivalentAccountFee2;
    }

    public BigDecimal getMinimumCashEquivalentAccountFee2() {
        return minimumCashEquivalentAccountFee2;
    }

    public void setMinimumCashEquivalentAccountFee2(BigDecimal minimumCashEquivalentAccountFee2) {
        this.minimumCashEquivalentAccountFee2 = minimumCashEquivalentAccountFee2;
    }

    public BigDecimal getMaximumCashEquivalentAccountFee2() {
        return maximumCashEquivalentAccountFee2;
    }

    public void setMaximumCashEquivalentAccountFee2(BigDecimal maximumCashEquivalentAccountFee2) {
        this.maximumCashEquivalentAccountFee2 = maximumCashEquivalentAccountFee2;
    }

    public BigDecimal getBalanceTransferAccountfee2() {
        return balanceTransferAccountfee2;
    }

    public void setBalanceTransferAccountfee2(BigDecimal balanceTransferAccountfee2) {
        this.balanceTransferAccountfee2 = balanceTransferAccountfee2;
    }

    public BigDecimal getFixedBalanceTransferAccountFee2() {
        return fixedBalanceTransferAccountFee2;
    }

    public void setFixedBalanceTransferAccountFee2(BigDecimal fixedBalanceTransferAccountFee2) {
        this.fixedBalanceTransferAccountFee2 = fixedBalanceTransferAccountFee2;
    }

    public BigDecimal getMinimumBalanceTransferAccountFee2() {
        return minimumBalanceTransferAccountFee2;
    }

    public void setMinimumBalanceTransferAccountFee2(BigDecimal minimumBalanceTransferAccountFee2) {
        this.minimumBalanceTransferAccountFee2 = minimumBalanceTransferAccountFee2;
    }

    public BigDecimal getAccessChequeDepositAccountFee2() {
        return accessChequeDepositAccountFee2;
    }

    public void setAccessChequeDepositAccountFee2(BigDecimal accessChequeDepositAccountFee2) {
        this.accessChequeDepositAccountFee2 = accessChequeDepositAccountFee2;
    }

    public BigDecimal getFixedAccessChequeDepositAccountFee2() {
        return fixedAccessChequeDepositAccountFee2;
    }

    public void setFixedAccessChequeDepositAccountFee2(BigDecimal fixedAccessChequeDepositAccountFee2) {
        this.fixedAccessChequeDepositAccountFee2 = fixedAccessChequeDepositAccountFee2;
    }

    public BigDecimal getMaximumBalanceTransferAccountFee2() {
        return maximumBalanceTransferAccountFee2;
    }

    public void setMaximumBalanceTransferAccountFee2(BigDecimal maximumBalanceTransferAccountFee2) {
        this.maximumBalanceTransferAccountFee2 = maximumBalanceTransferAccountFee2;
    }

    public BigDecimal getMinimumAccessChequeDepositAccountFee2() {
        return minimumAccessChequeDepositAccountFee2;
    }

    public void setMinimumAccessChequeDepositAccountFee2(BigDecimal minimumAccessChequeDepositAccountFee2) {
        this.minimumAccessChequeDepositAccountFee2 = minimumAccessChequeDepositAccountFee2;
    }

    public BigDecimal getMaximumAccessChequeDepositAccountFee2() {
        return maximumAccessChequeDepositAccountFee2;
    }

    public void setMaximumAccessChequeDepositAccountFee2(BigDecimal maximumAccessChequeDepositAccountFee2) {
        this.maximumAccessChequeDepositAccountFee2 = maximumAccessChequeDepositAccountFee2;
    }

    public BigDecimal getOverCreditLimitFee2() {
        return overCreditLimitFee2;
    }

    public void setOverCreditLimitFee2(BigDecimal overCreditLimitFee2) {
        this.overCreditLimitFee2 = overCreditLimitFee2;
    }

    public BigDecimal getReturnedPaymentFee2() {
        return returnedPaymentFee2;
    }

    public void setReturnedPaymentFee2(BigDecimal returnedPaymentFee2) {
        this.returnedPaymentFee2 = returnedPaymentFee2;
    }

    public Integer getNumberOfBillingcyclestoInactive() {
        return numberOfBillingcyclestoInactive;
    }

    public void setNumberOfBillingcyclestoInactive(Integer numberOfBillingcyclestoInactive) {
        this.numberOfBillingcyclestoInactive = numberOfBillingcyclestoInactive;
    }

    public BigDecimal getInactiveCreditBalanceFee2() {
        return inactiveCreditBalanceFee2;
    }

    public void setInactiveCreditBalanceFee2(BigDecimal inactiveCreditBalanceFee2) {
        this.inactiveCreditBalanceFee2 = inactiveCreditBalanceFee2;
    }

    public BigDecimal getReturnedAccessChequeFee2() {
        return returnedAccessChequeFee2;
    }

    public void setReturnedAccessChequeFee2(BigDecimal returnedAccessChequeFee2) {
        this.returnedAccessChequeFee2 = returnedAccessChequeFee2;
    }

    public String getClientProductCode2() {
        return clientProductCode2;
    }

    public void setClientProductCode2(String clientProductCode2) {
        this.clientProductCode2 = clientProductCode2;
    }

    public String getPointsProgramName() {
        return pointsProgramName;
    }

    public void setPointsProgramName(String pointsProgramName) {
        this.pointsProgramName = pointsProgramName;
    }

    public String getBranchIdentifier2() {
        return branchIdentifier2;
    }

    public void setBranchIdentifier2(String branchIdentifier2) {
        this.branchIdentifier2 = branchIdentifier2;
    }

    public String getAccountGroupingCode() {
        return accountGroupingCode;
    }

    public void setAccountGroupingCode(String accountGroupingCode) {
        this.accountGroupingCode = accountGroupingCode;
    }

    public BigDecimal getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(BigDecimal rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    public BigDecimal getBalXferAccessChqDepPromoAIR() {
        return balXferAccessChqDepPromoAIR;
    }

    public void setBalXferAccessChqDepPromoAIR(BigDecimal balXferAccessChqDepPromoAIR) {
        this.balXferAccessChqDepPromoAIR = balXferAccessChqDepPromoAIR;
    }

    public Integer getBalXferAccessChqDepTOWDuration() {
        return balXferAccessChqDepTOWDuration;
    }

    public void setBalXferAccessChqDepTOWDuration(Integer balXferAccessChqDepTOWDuration) {
        this.balXferAccessChqDepTOWDuration = balXferAccessChqDepTOWDuration;
    }

    public String getBalXferAccessChqDepTOWDurationTypeCode() {
        return balXferAccessChqDepTOWDurationTypeCode;
    }

    public void setBalXferAccessChqDepTOWDurationTypeCode(String balXferAccessChqDepTOWDurationTypeCode) {
        this.balXferAccessChqDepTOWDurationTypeCode = balXferAccessChqDepTOWDurationTypeCode;
    }

    public Integer getBalXferAccessChqDepPromoDuration() {
        return balXferAccessChqDepPromoDuration;
    }

    public void setBalXferAccessChqDepPromoDuration(Integer balXferAccessChqDepPromoDuration) {
        this.balXferAccessChqDepPromoDuration = balXferAccessChqDepPromoDuration;
    }

    public String getBalXferAccessChqDepPromoID() {
        return balXferAccessChqDepPromoID;
    }

    public void setBalXferAccessChqDepPromoID(String balXferAccessChqDepPromoID) {
        this.balXferAccessChqDepPromoID = balXferAccessChqDepPromoID;
    }

    public Long getBalXferAccessChqDepPromoEndDate() {
        return balXferAccessChqDepPromoEndDate;
    }

    public void setBalXferAccessChqDepPromoEndDate(Long balXferAccessChqDepPromoEndDate) {
        this.balXferAccessChqDepPromoEndDate = balXferAccessChqDepPromoEndDate;
    }

    public Boolean getBalancetransferpromoRateForLifeindicator() {
        return balancetransferpromoRateForLifeindicator;
    }

    public void setBalancetransferpromoRateForLifeindicator(Boolean balancetransferpromoRateForLifeindicator) {
        this.balancetransferpromoRateForLifeindicator = balancetransferpromoRateForLifeindicator;
    }

    public Boolean getBalanceTransferAmountIndicator() {
        return balanceTransferAmountIndicator;
    }

    public void setBalanceTransferAmountIndicator(Boolean balanceTransferAmountIndicator) {
        this.balanceTransferAmountIndicator = balanceTransferAmountIndicator;
    }

    public Boolean getPurchasePromoRateForLifeindicator() {
        return purchasePromoRateForLifeindicator;
    }

    public void setPurchasePromoRateForLifeindicator(Boolean purchasePromoRateForLifeindicator) {
        this.purchasePromoRateForLifeindicator = purchasePromoRateForLifeindicator;
    }

    public BigDecimal getPurchasePromoAIR() {
        return purchasePromoAIR;
    }

    public void setPurchasePromoAIR(BigDecimal purchasePromoAIR) {
        this.purchasePromoAIR = purchasePromoAIR;
    }

    public String getPurchasePromoID() {
        return purchasePromoID;
    }

    public void setPurchasePromoID(String purchasePromoID) {
        this.purchasePromoID = purchasePromoID;
    }

    public String getSmallBannerEn() {
        return smallBannerEn;
    }

    public void setSmallBannerEn(String smallBannerEn) {
        this.smallBannerEn = smallBannerEn;
    }

    public String getLargeBannerEn() {
        return largeBannerEn;
    }

    public void setLargeBannerEn(String largeBannerEn) {
        this.largeBannerEn = largeBannerEn;
    }

    public String getLargeBannerMobileEn() {
        return largeBannerMobileEn;
    }

    public void setLargeBannerMobileEn(String largeBannerMobileEn) {
        this.largeBannerMobileEn = largeBannerMobileEn;
    }

    public String getSmallBannerFr() {
        return smallBannerFr;
    }

    public void setSmallBannerFr(String smallBannerFr) {
        this.smallBannerFr = smallBannerFr;
    }

    public String getLargeBannerFr() {
        return largeBannerFr;
    }

    public void setLargeBannerFr(String largeBannerFr) {
        this.largeBannerFr = largeBannerFr;
    }

    public String getLargeBannerMobileFr() {
        return largeBannerMobileFr;
    }

    public void setLargeBannerMobileFr(String largeBannerMobileFr) {
        this.largeBannerMobileFr = largeBannerMobileFr;
    }

    public String getTsysproductCode2() {
        return tsysproductCode2;
    }

    public void setTsysproductCode2(String tsysproductCode2) {
        this.tsysproductCode2 = tsysproductCode2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PCOfferType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cardTemplateId");
        sb.append('=');
        sb.append(((this.cardTemplateId == null)?"<null>":this.cardTemplateId));
        sb.append(',');
        sb.append("disclosureId");
        sb.append('=');
        sb.append(((this.disclosureId == null)?"<null>":this.disclosureId));
        sb.append(',');
        sb.append("productOfferType");
        sb.append('=');
        sb.append(((this.productOfferType == null)?"<null>":this.productOfferType));
        sb.append(',');
        sb.append("productNameEn");
        sb.append('=');
        sb.append(((this.productNameEn == null)?"<null>":this.productNameEn));
        sb.append(',');
        sb.append("productNameFr");
        sb.append('=');
        sb.append(((this.productNameFr == null)?"<null>":this.productNameFr));
        sb.append(',');
        sb.append("purchaseAIR");
        sb.append('=');
        sb.append(((this.purchaseAIR == null)?"<null>":this.purchaseAIR));
        sb.append(',');
        sb.append("balXferAccessChqDepAIR");
        sb.append('=');
        sb.append(((this.balXferAccessChqDepAIR == null)?"<null>":this.balXferAccessChqDepAIR));
        sb.append(',');
        sb.append("cashAdvanceAIR");
        sb.append('=');
        sb.append(((this.cashAdvanceAIR == null)?"<null>":this.cashAdvanceAIR));
        sb.append(',');
        sb.append("defaultRatePercentChangeType");
        sb.append('=');
        sb.append(((this.defaultRatePercentChangeType == null)?"<null>":this.defaultRatePercentChangeType));
        sb.append(',');
        sb.append("minimumPaymentDue2");
        sb.append('=');
        sb.append(((this.minimumPaymentDue2 == null)?"<null>":this.minimumPaymentDue2));
        sb.append(',');
        sb.append("minimumPaymentPercent");
        sb.append('=');
        sb.append(((this.minimumPaymentPercent == null)?"<null>":this.minimumPaymentPercent));
        sb.append(',');
        sb.append("accountAnnualFee2");
        sb.append('=');
        sb.append(((this.accountAnnualFee2 == null)?"<null>":this.accountAnnualFee2));
        sb.append(',');
        sb.append("atmAccountFee2");
        sb.append('=');
        sb.append(((this.atmAccountFee2 == null)?"<null>":this.atmAccountFee2));
        sb.append(',');
        sb.append("fixedATMAccountFee2");
        sb.append('=');
        sb.append(((this.fixedATMAccountFee2 == null)?"<null>":this.fixedATMAccountFee2));
        sb.append(',');
        sb.append("minimumATMAccountFee2");
        sb.append('=');
        sb.append(((this.minimumATMAccountFee2 == null)?"<null>":this.minimumATMAccountFee2));
        sb.append(',');
        sb.append("maximumAtmAccountfee2");
        sb.append('=');
        sb.append(((this.maximumAtmAccountfee2 == null)?"<null>":this.maximumAtmAccountfee2));
        sb.append(',');
        sb.append("otcAccountFee2");
        sb.append('=');
        sb.append(((this.otcAccountFee2 == null)?"<null>":this.otcAccountFee2));
        sb.append(',');
        sb.append("fixedOTCaccountFee2");
        sb.append('=');
        sb.append(((this.fixedOTCaccountFee2 == null)?"<null>":this.fixedOTCaccountFee2));
        sb.append(',');
        sb.append("minimumOTCAccountFee2");
        sb.append('=');
        sb.append(((this.minimumOTCAccountFee2 == null)?"<null>":this.minimumOTCAccountFee2));
        sb.append(',');
        sb.append("maximumOTCAccountFee2");
        sb.append('=');
        sb.append(((this.maximumOTCAccountFee2 == null)?"<null>":this.maximumOTCAccountFee2));
        sb.append(',');
        sb.append("cashEquivalentAccountFee2");
        sb.append('=');
        sb.append(((this.cashEquivalentAccountFee2 == null)?"<null>":this.cashEquivalentAccountFee2));
        sb.append(',');
        sb.append("fixedCashEquivalentAccountFee2");
        sb.append('=');
        sb.append(((this.fixedCashEquivalentAccountFee2 == null)?"<null>":this.fixedCashEquivalentAccountFee2));
        sb.append(',');
        sb.append("minimumCashEquivalentAccountFee2");
        sb.append('=');
        sb.append(((this.minimumCashEquivalentAccountFee2 == null)?"<null>":this.minimumCashEquivalentAccountFee2));
        sb.append(',');
        sb.append("maximumCashEquivalentAccountFee2");
        sb.append('=');
        sb.append(((this.maximumCashEquivalentAccountFee2 == null)?"<null>":this.maximumCashEquivalentAccountFee2));
        sb.append(',');
        sb.append("balanceTransferAccountfee2");
        sb.append('=');
        sb.append(((this.balanceTransferAccountfee2 == null)?"<null>":this.balanceTransferAccountfee2));
        sb.append(',');
        sb.append("fixedBalanceTransferAccountFee2");
        sb.append('=');
        sb.append(((this.fixedBalanceTransferAccountFee2 == null)?"<null>":this.fixedBalanceTransferAccountFee2));
        sb.append(',');
        sb.append("minimumBalanceTransferAccountFee2");
        sb.append('=');
        sb.append(((this.minimumBalanceTransferAccountFee2 == null)?"<null>":this.minimumBalanceTransferAccountFee2));
        sb.append(',');
        sb.append("accessChequeDepositAccountFee2");
        sb.append('=');
        sb.append(((this.accessChequeDepositAccountFee2 == null)?"<null>":this.accessChequeDepositAccountFee2));
        sb.append(',');
        sb.append("fixedAccessChequeDepositAccountFee2");
        sb.append('=');
        sb.append(((this.fixedAccessChequeDepositAccountFee2 == null)?"<null>":this.fixedAccessChequeDepositAccountFee2));
        sb.append(',');
        sb.append("maximumBalanceTransferAccountFee2");
        sb.append('=');
        sb.append(((this.maximumBalanceTransferAccountFee2 == null)?"<null>":this.maximumBalanceTransferAccountFee2));
        sb.append(',');
        sb.append("minimumAccessChequeDepositAccountFee2");
        sb.append('=');
        sb.append(((this.minimumAccessChequeDepositAccountFee2 == null)?"<null>":this.minimumAccessChequeDepositAccountFee2));
        sb.append(',');
        sb.append("maximumAccessChequeDepositAccountFee2");
        sb.append('=');
        sb.append(((this.maximumAccessChequeDepositAccountFee2 == null)?"<null>":this.maximumAccessChequeDepositAccountFee2));
        sb.append(',');
        sb.append("overCreditLimitFee2");
        sb.append('=');
        sb.append(((this.overCreditLimitFee2 == null)?"<null>":this.overCreditLimitFee2));
        sb.append(',');
        sb.append("returnedPaymentFee2");
        sb.append('=');
        sb.append(((this.returnedPaymentFee2 == null)?"<null>":this.returnedPaymentFee2));
        sb.append(',');
        sb.append("numberOfBillingcyclestoInactive");
        sb.append('=');
        sb.append(((this.numberOfBillingcyclestoInactive == null)?"<null>":this.numberOfBillingcyclestoInactive));
        sb.append(',');
        sb.append("inactiveCreditBalanceFee2");
        sb.append('=');
        sb.append(((this.inactiveCreditBalanceFee2 == null)?"<null>":this.inactiveCreditBalanceFee2));
        sb.append(',');
        sb.append("returnedAccessChequeFee2");
        sb.append('=');
        sb.append(((this.returnedAccessChequeFee2 == null)?"<null>":this.returnedAccessChequeFee2));
        sb.append(',');
        sb.append("clientProductCode2");
        sb.append('=');
        sb.append(((this.clientProductCode2 == null)?"<null>":this.clientProductCode2));
        sb.append(',');
        sb.append("pointsProgramName");
        sb.append('=');
        sb.append(((this.pointsProgramName == null)?"<null>":this.pointsProgramName));
        sb.append(',');
        sb.append("branchIdentifier2");
        sb.append('=');
        sb.append(((this.branchIdentifier2 == null)?"<null>":this.branchIdentifier2));
        sb.append(',');
        sb.append("accountGroupingCode");
        sb.append('=');
        sb.append(((this.accountGroupingCode == null)?"<null>":this.accountGroupingCode));
        sb.append(',');
        sb.append("rewardAmount");
        sb.append('=');
        sb.append(((this.rewardAmount == null)?"<null>":this.rewardAmount));
        sb.append(',');
        sb.append("balXferAccessChqDepPromoAIR");
        sb.append('=');
        sb.append(((this.balXferAccessChqDepPromoAIR == null)?"<null>":this.balXferAccessChqDepPromoAIR));
        sb.append(',');
        sb.append("balXferAccessChqDepTOWDuration");
        sb.append('=');
        sb.append(((this.balXferAccessChqDepTOWDuration == null)?"<null>":this.balXferAccessChqDepTOWDuration));
        sb.append(',');
        sb.append("balXferAccessChqDepTOWDurationTypeCode");
        sb.append('=');
        sb.append(((this.balXferAccessChqDepTOWDurationTypeCode == null)?"<null>":this.balXferAccessChqDepTOWDurationTypeCode));
        sb.append(',');
        sb.append("balXferAccessChqDepPromoDuration");
        sb.append('=');
        sb.append(((this.balXferAccessChqDepPromoDuration == null)?"<null>":this.balXferAccessChqDepPromoDuration));
        sb.append(',');
        sb.append("balXferAccessChqDepPromoID");
        sb.append('=');
        sb.append(((this.balXferAccessChqDepPromoID == null)?"<null>":this.balXferAccessChqDepPromoID));
        sb.append(',');
        sb.append("balXferAccessChqDepPromoEndDate");
        sb.append('=');
        sb.append(((this.balXferAccessChqDepPromoEndDate == null)?"<null>":this.balXferAccessChqDepPromoEndDate));
        sb.append(',');
        sb.append("balancetransferpromoRateForLifeindicator");
        sb.append('=');
        sb.append(((this.balancetransferpromoRateForLifeindicator == null)?"<null>":this.balancetransferpromoRateForLifeindicator));
        sb.append(',');
        sb.append("balanceTransferAmountIndicator");
        sb.append('=');
        sb.append(((this.balanceTransferAmountIndicator == null)?"<null>":this.balanceTransferAmountIndicator));
        sb.append(',');
        sb.append("purchasePromoRateForLifeindicator");
        sb.append('=');
        sb.append(((this.purchasePromoRateForLifeindicator == null)?"<null>":this.purchasePromoRateForLifeindicator));
        sb.append(',');
        sb.append("purchasePromoAIR");
        sb.append('=');
        sb.append(((this.purchasePromoAIR == null)?"<null>":this.purchasePromoAIR));
        sb.append(',');
        sb.append("purchasePromoID");
        sb.append('=');
        sb.append(((this.purchasePromoID == null)?"<null>":this.purchasePromoID));
        sb.append(',');
        sb.append("smallBannerEn");
        sb.append('=');
        sb.append(((this.smallBannerEn == null)?"<null>":this.smallBannerEn));
        sb.append(',');
        sb.append("largeBannerEn");
        sb.append('=');
        sb.append(((this.largeBannerEn == null)?"<null>":this.largeBannerEn));
        sb.append(',');
        sb.append("largeBannerMobileEn");
        sb.append('=');
        sb.append(((this.largeBannerMobileEn == null)?"<null>":this.largeBannerMobileEn));
        sb.append(',');
        sb.append("smallBannerFr");
        sb.append('=');
        sb.append(((this.smallBannerFr == null)?"<null>":this.smallBannerFr));
        sb.append(',');
        sb.append("largeBannerFr");
        sb.append('=');
        sb.append(((this.largeBannerFr == null)?"<null>":this.largeBannerFr));
        sb.append(',');
        sb.append("largeBannerMobileFr");
        sb.append('=');
        sb.append(((this.largeBannerMobileFr == null)?"<null>":this.largeBannerMobileFr));
        sb.append(',');
        sb.append("tsysproductCode2");
        sb.append('=');
        sb.append(((this.tsysproductCode2 == null)?"<null>":this.tsysproductCode2));
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
        result = ((result* 31)+((this.minimumOTCAccountFee2 == null)? 0 :this.minimumOTCAccountFee2 .hashCode()));
        result = ((result* 31)+((this.smallBannerFr == null)? 0 :this.smallBannerFr.hashCode()));
        result = ((result* 31)+((this.cardTemplateId == null)? 0 :this.cardTemplateId.hashCode()));
        result = ((result* 31)+((this.otcAccountFee2 == null)? 0 :this.otcAccountFee2 .hashCode()));
        result = ((result* 31)+((this.purchasePromoAIR == null)? 0 :this.purchasePromoAIR.hashCode()));
        result = ((result* 31)+((this.balXferAccessChqDepPromoID == null)? 0 :this.balXferAccessChqDepPromoID.hashCode()));
        result = ((result* 31)+((this.fixedATMAccountFee2 == null)? 0 :this.fixedATMAccountFee2 .hashCode()));
        result = ((result* 31)+((this.returnedAccessChequeFee2 == null)? 0 :this.returnedAccessChequeFee2 .hashCode()));
        result = ((result* 31)+((this.maximumCashEquivalentAccountFee2 == null)? 0 :this.maximumCashEquivalentAccountFee2 .hashCode()));
        result = ((result* 31)+((this.minimumPaymentDue2 == null)? 0 :this.minimumPaymentDue2 .hashCode()));
        result = ((result* 31)+((this.overCreditLimitFee2 == null)? 0 :this.overCreditLimitFee2 .hashCode()));
        result = ((result* 31)+((this.purchasePromoRateForLifeindicator == null)? 0 :this.purchasePromoRateForLifeindicator.hashCode()));
        result = ((result* 31)+((this.maximumAccessChequeDepositAccountFee2 == null)? 0 :this.maximumAccessChequeDepositAccountFee2 .hashCode()));
        result = ((result* 31)+((this.balanceTransferAccountfee2 == null)? 0 :this.balanceTransferAccountfee2 .hashCode()));
        result = ((result* 31)+((this.productNameFr == null)? 0 :this.productNameFr.hashCode()));
        result = ((result* 31)+((this.maximumBalanceTransferAccountFee2 == null)? 0 :this.maximumBalanceTransferAccountFee2 .hashCode()));
        result = ((result* 31)+((this.branchIdentifier2 == null)? 0 :this.branchIdentifier2 .hashCode()));
        result = ((result* 31)+((this.smallBannerEn == null)? 0 :this.smallBannerEn.hashCode()));
        result = ((result* 31)+((this.inactiveCreditBalanceFee2 == null)? 0 :this.inactiveCreditBalanceFee2 .hashCode()));
        result = ((result* 31)+((this.cashAdvanceAIR == null)? 0 :this.cashAdvanceAIR.hashCode()));
        result = ((result* 31)+((this.balXferAccessChqDepTOWDurationTypeCode == null)? 0 :this.balXferAccessChqDepTOWDurationTypeCode.hashCode()));
        result = ((result* 31)+((this.productOfferType == null)? 0 :this.productOfferType.hashCode()));
        result = ((result* 31)+((this.fixedAccessChequeDepositAccountFee2 == null)? 0 :this.fixedAccessChequeDepositAccountFee2 .hashCode()));
        result = ((result* 31)+((this.maximumAtmAccountfee2 == null)? 0 :this.maximumAtmAccountfee2 .hashCode()));
        result = ((result* 31)+((this.balanceTransferAmountIndicator == null)? 0 :this.balanceTransferAmountIndicator.hashCode()));
        result = ((result* 31)+((this.purchasePromoID == null)? 0 :this.purchasePromoID.hashCode()));
        result = ((result* 31)+((this.atmAccountFee2 == null)? 0 :this.atmAccountFee2 .hashCode()));
        result = ((result* 31)+((this.numberOfBillingcyclestoInactive == null)? 0 :this.numberOfBillingcyclestoInactive.hashCode()));
        result = ((result* 31)+((this.disclosureId == null)? 0 :this.disclosureId.hashCode()));
        result = ((result* 31)+((this.minimumCashEquivalentAccountFee2 == null)? 0 :this.minimumCashEquivalentAccountFee2 .hashCode()));
        result = ((result* 31)+((this.purchaseAIR == null)? 0 :this.purchaseAIR.hashCode()));
        result = ((result* 31)+((this.defaultRatePercentChangeType == null)? 0 :this.defaultRatePercentChangeType.hashCode()));
        result = ((result* 31)+((this.accountAnnualFee2 == null)? 0 :this.accountAnnualFee2 .hashCode()));
        result = ((result* 31)+((this.balancetransferpromoRateForLifeindicator == null)? 0 :this.balancetransferpromoRateForLifeindicator.hashCode()));
        result = ((result* 31)+((this.balXferAccessChqDepPromoAIR == null)? 0 :this.balXferAccessChqDepPromoAIR.hashCode()));
        result = ((result* 31)+((this.largeBannerFr == null)? 0 :this.largeBannerFr.hashCode()));
        result = ((result* 31)+((this.largeBannerMobileFr == null)? 0 :this.largeBannerMobileFr.hashCode()));
        result = ((result* 31)+((this.balXferAccessChqDepAIR == null)? 0 :this.balXferAccessChqDepAIR.hashCode()));
        result = ((result* 31)+((this.tsysproductCode2 == null)? 0 :this.tsysproductCode2 .hashCode()));
        result = ((result* 31)+((this.cashEquivalentAccountFee2 == null)? 0 :this.cashEquivalentAccountFee2 .hashCode()));
        result = ((result* 31)+((this.fixedOTCaccountFee2 == null)? 0 :this.fixedOTCaccountFee2 .hashCode()));
        result = ((result* 31)+((this.minimumATMAccountFee2 == null)? 0 :this.minimumATMAccountFee2 .hashCode()));
        result = ((result* 31)+((this.accessChequeDepositAccountFee2 == null)? 0 :this.accessChequeDepositAccountFee2 .hashCode()));
        result = ((result* 31)+((this.accountGroupingCode == null)? 0 :this.accountGroupingCode.hashCode()));
        result = ((result* 31)+((this.rewardAmount == null)? 0 :this.rewardAmount.hashCode()));
        result = ((result* 31)+((this.minimumPaymentPercent == null)? 0 :this.minimumPaymentPercent.hashCode()));
        result = ((result* 31)+((this.balXferAccessChqDepPromoDuration == null)? 0 :this.balXferAccessChqDepPromoDuration.hashCode()));
        result = ((result* 31)+((this.largeBannerMobileEn == null)? 0 :this.largeBannerMobileEn.hashCode()));
        result = ((result* 31)+((this.pointsProgramName == null)? 0 :this.pointsProgramName.hashCode()));
        result = ((result* 31)+((this.largeBannerEn == null)? 0 :this.largeBannerEn.hashCode()));
        result = ((result* 31)+((this.fixedBalanceTransferAccountFee2 == null)? 0 :this.fixedBalanceTransferAccountFee2 .hashCode()));
        result = ((result* 31)+((this.minimumBalanceTransferAccountFee2 == null)? 0 :this.minimumBalanceTransferAccountFee2 .hashCode()));
        result = ((result* 31)+((this.returnedPaymentFee2 == null)? 0 :this.returnedPaymentFee2 .hashCode()));
        result = ((result* 31)+((this.productNameEn == null)? 0 :this.productNameEn.hashCode()));
        result = ((result* 31)+((this.maximumOTCAccountFee2 == null)? 0 :this.maximumOTCAccountFee2 .hashCode()));
        result = ((result* 31)+((this.clientProductCode2 == null)? 0 :this.clientProductCode2 .hashCode()));
        result = ((result* 31)+((this.fixedCashEquivalentAccountFee2 == null)? 0 :this.fixedCashEquivalentAccountFee2 .hashCode()));
        result = ((result* 31)+((this.balXferAccessChqDepPromoEndDate == null)? 0 :this.balXferAccessChqDepPromoEndDate.hashCode()));
        result = ((result* 31)+((this.minimumAccessChequeDepositAccountFee2 == null)? 0 :this.minimumAccessChequeDepositAccountFee2 .hashCode()));
        result = ((result* 31)+((this.balXferAccessChqDepTOWDuration == null)? 0 :this.balXferAccessChqDepTOWDuration.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PCOfferType) == false) {
            return false;
        }
        PCOfferType rhs = ((PCOfferType) other);
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.minimumOTCAccountFee2 == rhs.minimumOTCAccountFee2)||((this.minimumOTCAccountFee2 != null)&&this.minimumOTCAccountFee2 .equals(rhs.minimumOTCAccountFee2)))&&((this.smallBannerFr == rhs.smallBannerFr)||((this.smallBannerFr!= null)&&this.smallBannerFr.equals(rhs.smallBannerFr))))&&((this.cardTemplateId == rhs.cardTemplateId)||((this.cardTemplateId!= null)&&this.cardTemplateId.equals(rhs.cardTemplateId))))&&((this.otcAccountFee2 == rhs.otcAccountFee2)||((this.otcAccountFee2 != null)&&this.otcAccountFee2 .equals(rhs.otcAccountFee2))))&&((this.purchasePromoAIR == rhs.purchasePromoAIR)||((this.purchasePromoAIR!= null)&&this.purchasePromoAIR.equals(rhs.purchasePromoAIR))))&&((this.balXferAccessChqDepPromoID == rhs.balXferAccessChqDepPromoID)||((this.balXferAccessChqDepPromoID!= null)&&this.balXferAccessChqDepPromoID.equals(rhs.balXferAccessChqDepPromoID))))&&((this.fixedATMAccountFee2 == rhs.fixedATMAccountFee2)||((this.fixedATMAccountFee2 != null)&&this.fixedATMAccountFee2 .equals(rhs.fixedATMAccountFee2))))&&((this.returnedAccessChequeFee2 == rhs.returnedAccessChequeFee2)||((this.returnedAccessChequeFee2 != null)&&this.returnedAccessChequeFee2 .equals(rhs.returnedAccessChequeFee2))))&&((this.maximumCashEquivalentAccountFee2 == rhs.maximumCashEquivalentAccountFee2)||((this.maximumCashEquivalentAccountFee2 != null)&&this.maximumCashEquivalentAccountFee2 .equals(rhs.maximumCashEquivalentAccountFee2))))&&((this.minimumPaymentDue2 == rhs.minimumPaymentDue2)||((this.minimumPaymentDue2 != null)&&this.minimumPaymentDue2 .equals(rhs.minimumPaymentDue2))))&&((this.overCreditLimitFee2 == rhs.overCreditLimitFee2)||((this.overCreditLimitFee2 != null)&&this.overCreditLimitFee2 .equals(rhs.overCreditLimitFee2))))&&((this.purchasePromoRateForLifeindicator == rhs.purchasePromoRateForLifeindicator)||((this.purchasePromoRateForLifeindicator!= null)&&this.purchasePromoRateForLifeindicator.equals(rhs.purchasePromoRateForLifeindicator))))&&((this.maximumAccessChequeDepositAccountFee2 == rhs.maximumAccessChequeDepositAccountFee2)||((this.maximumAccessChequeDepositAccountFee2 != null)&&this.maximumAccessChequeDepositAccountFee2 .equals(rhs.maximumAccessChequeDepositAccountFee2))))&&((this.balanceTransferAccountfee2 == rhs.balanceTransferAccountfee2)||((this.balanceTransferAccountfee2 != null)&&this.balanceTransferAccountfee2 .equals(rhs.balanceTransferAccountfee2))))&&((this.productNameFr == rhs.productNameFr)||((this.productNameFr!= null)&&this.productNameFr.equals(rhs.productNameFr))))&&((this.maximumBalanceTransferAccountFee2 == rhs.maximumBalanceTransferAccountFee2)||((this.maximumBalanceTransferAccountFee2 != null)&&this.maximumBalanceTransferAccountFee2 .equals(rhs.maximumBalanceTransferAccountFee2))))&&((this.branchIdentifier2 == rhs.branchIdentifier2)||((this.branchIdentifier2 != null)&&this.branchIdentifier2 .equals(rhs.branchIdentifier2))))&&((this.smallBannerEn == rhs.smallBannerEn)||((this.smallBannerEn!= null)&&this.smallBannerEn.equals(rhs.smallBannerEn))))&&((this.inactiveCreditBalanceFee2 == rhs.inactiveCreditBalanceFee2)||((this.inactiveCreditBalanceFee2 != null)&&this.inactiveCreditBalanceFee2 .equals(rhs.inactiveCreditBalanceFee2))))&&((this.cashAdvanceAIR == rhs.cashAdvanceAIR)||((this.cashAdvanceAIR!= null)&&this.cashAdvanceAIR.equals(rhs.cashAdvanceAIR))))&&((this.balXferAccessChqDepTOWDurationTypeCode == rhs.balXferAccessChqDepTOWDurationTypeCode)||((this.balXferAccessChqDepTOWDurationTypeCode!= null)&&this.balXferAccessChqDepTOWDurationTypeCode.equals(rhs.balXferAccessChqDepTOWDurationTypeCode))))&&((this.productOfferType == rhs.productOfferType)||((this.productOfferType!= null)&&this.productOfferType.equals(rhs.productOfferType))))&&((this.fixedAccessChequeDepositAccountFee2 == rhs.fixedAccessChequeDepositAccountFee2)||((this.fixedAccessChequeDepositAccountFee2 != null)&&this.fixedAccessChequeDepositAccountFee2 .equals(rhs.fixedAccessChequeDepositAccountFee2))))&&((this.maximumAtmAccountfee2 == rhs.maximumAtmAccountfee2)||((this.maximumAtmAccountfee2 != null)&&this.maximumAtmAccountfee2 .equals(rhs.maximumAtmAccountfee2))))&&((this.balanceTransferAmountIndicator == rhs.balanceTransferAmountIndicator)||((this.balanceTransferAmountIndicator!= null)&&this.balanceTransferAmountIndicator.equals(rhs.balanceTransferAmountIndicator))))&&((this.purchasePromoID == rhs.purchasePromoID)||((this.purchasePromoID!= null)&&this.purchasePromoID.equals(rhs.purchasePromoID))))&&((this.atmAccountFee2 == rhs.atmAccountFee2)||((this.atmAccountFee2 != null)&&this.atmAccountFee2 .equals(rhs.atmAccountFee2))))&&((this.numberOfBillingcyclestoInactive == rhs.numberOfBillingcyclestoInactive)||((this.numberOfBillingcyclestoInactive!= null)&&this.numberOfBillingcyclestoInactive.equals(rhs.numberOfBillingcyclestoInactive))))&&((this.disclosureId == rhs.disclosureId)||((this.disclosureId!= null)&&this.disclosureId.equals(rhs.disclosureId))))&&((this.minimumCashEquivalentAccountFee2 == rhs.minimumCashEquivalentAccountFee2)||((this.minimumCashEquivalentAccountFee2 != null)&&this.minimumCashEquivalentAccountFee2 .equals(rhs.minimumCashEquivalentAccountFee2))))&&((this.purchaseAIR == rhs.purchaseAIR)||((this.purchaseAIR!= null)&&this.purchaseAIR.equals(rhs.purchaseAIR))))&&((this.defaultRatePercentChangeType == rhs.defaultRatePercentChangeType)||((this.defaultRatePercentChangeType!= null)&&this.defaultRatePercentChangeType.equals(rhs.defaultRatePercentChangeType))))&&((this.accountAnnualFee2 == rhs.accountAnnualFee2)||((this.accountAnnualFee2 != null)&&this.accountAnnualFee2 .equals(rhs.accountAnnualFee2))))&&((this.balancetransferpromoRateForLifeindicator == rhs.balancetransferpromoRateForLifeindicator)||((this.balancetransferpromoRateForLifeindicator!= null)&&this.balancetransferpromoRateForLifeindicator.equals(rhs.balancetransferpromoRateForLifeindicator))))&&((this.balXferAccessChqDepPromoAIR == rhs.balXferAccessChqDepPromoAIR)||((this.balXferAccessChqDepPromoAIR!= null)&&this.balXferAccessChqDepPromoAIR.equals(rhs.balXferAccessChqDepPromoAIR))))&&((this.largeBannerFr == rhs.largeBannerFr)||((this.largeBannerFr!= null)&&this.largeBannerFr.equals(rhs.largeBannerFr))))&&((this.largeBannerMobileFr == rhs.largeBannerMobileFr)||((this.largeBannerMobileFr!= null)&&this.largeBannerMobileFr.equals(rhs.largeBannerMobileFr))))&&((this.balXferAccessChqDepAIR == rhs.balXferAccessChqDepAIR)||((this.balXferAccessChqDepAIR!= null)&&this.balXferAccessChqDepAIR.equals(rhs.balXferAccessChqDepAIR))))&&((this.tsysproductCode2 == rhs.tsysproductCode2)||((this.tsysproductCode2 != null)&&this.tsysproductCode2 .equals(rhs.tsysproductCode2))))&&((this.cashEquivalentAccountFee2 == rhs.cashEquivalentAccountFee2)||((this.cashEquivalentAccountFee2 != null)&&this.cashEquivalentAccountFee2 .equals(rhs.cashEquivalentAccountFee2))))&&((this.fixedOTCaccountFee2 == rhs.fixedOTCaccountFee2)||((this.fixedOTCaccountFee2 != null)&&this.fixedOTCaccountFee2 .equals(rhs.fixedOTCaccountFee2))))&&((this.minimumATMAccountFee2 == rhs.minimumATMAccountFee2)||((this.minimumATMAccountFee2 != null)&&this.minimumATMAccountFee2 .equals(rhs.minimumATMAccountFee2))))&&((this.accessChequeDepositAccountFee2 == rhs.accessChequeDepositAccountFee2)||((this.accessChequeDepositAccountFee2 != null)&&this.accessChequeDepositAccountFee2 .equals(rhs.accessChequeDepositAccountFee2))))&&((this.accountGroupingCode == rhs.accountGroupingCode)||((this.accountGroupingCode!= null)&&this.accountGroupingCode.equals(rhs.accountGroupingCode))))&&((this.rewardAmount == rhs.rewardAmount)||((this.rewardAmount!= null)&&this.rewardAmount.equals(rhs.rewardAmount))))&&((this.minimumPaymentPercent == rhs.minimumPaymentPercent)||((this.minimumPaymentPercent!= null)&&this.minimumPaymentPercent.equals(rhs.minimumPaymentPercent))))&&((this.balXferAccessChqDepPromoDuration == rhs.balXferAccessChqDepPromoDuration)||((this.balXferAccessChqDepPromoDuration!= null)&&this.balXferAccessChqDepPromoDuration.equals(rhs.balXferAccessChqDepPromoDuration))))&&((this.largeBannerMobileEn == rhs.largeBannerMobileEn)||((this.largeBannerMobileEn!= null)&&this.largeBannerMobileEn.equals(rhs.largeBannerMobileEn))))&&((this.pointsProgramName == rhs.pointsProgramName)||((this.pointsProgramName!= null)&&this.pointsProgramName.equals(rhs.pointsProgramName))))&&((this.largeBannerEn == rhs.largeBannerEn)||((this.largeBannerEn!= null)&&this.largeBannerEn.equals(rhs.largeBannerEn))))&&((this.fixedBalanceTransferAccountFee2 == rhs.fixedBalanceTransferAccountFee2)||((this.fixedBalanceTransferAccountFee2 != null)&&this.fixedBalanceTransferAccountFee2 .equals(rhs.fixedBalanceTransferAccountFee2))))&&((this.minimumBalanceTransferAccountFee2 == rhs.minimumBalanceTransferAccountFee2)||((this.minimumBalanceTransferAccountFee2 != null)&&this.minimumBalanceTransferAccountFee2 .equals(rhs.minimumBalanceTransferAccountFee2))))&&((this.returnedPaymentFee2 == rhs.returnedPaymentFee2)||((this.returnedPaymentFee2 != null)&&this.returnedPaymentFee2 .equals(rhs.returnedPaymentFee2))))&&((this.productNameEn == rhs.productNameEn)||((this.productNameEn!= null)&&this.productNameEn.equals(rhs.productNameEn))))&&((this.maximumOTCAccountFee2 == rhs.maximumOTCAccountFee2)||((this.maximumOTCAccountFee2 != null)&&this.maximumOTCAccountFee2 .equals(rhs.maximumOTCAccountFee2))))&&((this.clientProductCode2 == rhs.clientProductCode2)||((this.clientProductCode2 != null)&&this.clientProductCode2 .equals(rhs.clientProductCode2))))&&((this.fixedCashEquivalentAccountFee2 == rhs.fixedCashEquivalentAccountFee2)||((this.fixedCashEquivalentAccountFee2 != null)&&this.fixedCashEquivalentAccountFee2 .equals(rhs.fixedCashEquivalentAccountFee2))))&&((this.balXferAccessChqDepPromoEndDate == rhs.balXferAccessChqDepPromoEndDate)||((this.balXferAccessChqDepPromoEndDate!= null)&&this.balXferAccessChqDepPromoEndDate.equals(rhs.balXferAccessChqDepPromoEndDate))))&&((this.minimumAccessChequeDepositAccountFee2 == rhs.minimumAccessChequeDepositAccountFee2)||((this.minimumAccessChequeDepositAccountFee2 != null)&&this.minimumAccessChequeDepositAccountFee2 .equals(rhs.minimumAccessChequeDepositAccountFee2))))&&((this.balXferAccessChqDepTOWDuration == rhs.balXferAccessChqDepTOWDuration)||((this.balXferAccessChqDepTOWDuration!= null)&&this.balXferAccessChqDepTOWDuration.equals(rhs.balXferAccessChqDepTOWDuration))));
    }

}
