package com.td.api.mbcca.response.account.featureview;

import java.util.ArrayList;
import java.util.List;

public class FeatureView {

    private String chargeOffFeatureId;
    private String chargeOffFeatureDesc;
    private String changeInTermFeatureId;
    private String changeInTermFeatureDesc;
    private String minimumPaymentFeatureId;
    private String minimumPaymentFeatureDesc;
    private String collectionFeatureId;
    private String collectionFeatureDesc;
    private String convenienceCheckFeatureId;
    private String convenienceCheckFeatureDesc;
    private String performancePricingFeatureId;
    private String performancePricingFeatureDesc;
    private String miscellaneousProcessingFeatureId;
    private String miscellaneousProcessingFeatureDesc;
    private String agreementCloseFeatureId;
    private String agreementCloseFeatureDesc;
    private String authorizationFeatureId;
    private String authorizationFeatureDesc;
    private String creditBalanceRefundFeatureId;
    private String creditBalanceRefundFeatureDesc;
    private String cardReceiptVerificationFeatureId;
    private String cardReceiptVerificationFeatureDesc;
    private String skipAPaymentFeatureId;
    private String skipAPaymentFeatureDesc;
    private String serviceFeeFeatureId;
    private String serviceFeeFeatureDesc;
    private String statementFeatureId;
    private String statementFeatureDesc;
    private String agreementFeeFeatureId;
    private String agreementFeeFeatureDesc;
    private String transactionFeeFeatureId;
    private String transactionFeeFeatureDesc;
    private String membershipFeeFeatureId;
    private String membershipFeeFeatureDesc;
    private String securityFeatureId;
    private String securityFeatureDesc;
    private String creditBureauReportFeatureId;
    private String creditBureauReportFeatureDesc;
    private String creditLineFeatureId;
    private String cycleAssignmentFeatureId;
    private String cycleAssignmentFeatureDesc;
    private String promotionalTermFeatureId;
    private String promotionalTermFeatureDesc;
    private String insuranceFeatureId;
    private String insuranceFeatureDesc;
    private String membershipFeeRebateFeatureId;
    private String membershipFeeRebateFeatureDesc;
    private String transactionRebateFeatureId;
    private String transactionRebateFeatureDesc;
    private String productChangeFeatureId;
    private String productChangeFeatureDesc;
    private String membershipNumberFeatureId;
    private String membershipNumberFeatureDesc;
    private String multipleProductInsuranceFeatureId;
    private String multipleProductInsuranceFeatureDesc;
    private String agreementAnnualPercentageRateFeatureId;
    private String agreementAnnualPercentageRateFeatureDesc;
    private String lateFeeFeatureId;
    private String lateFeeFeatureDesc;
    private String lateFeeFeatureSourceVal;
    private String cashAdvanceFeeFeatureSourceVal;
    private TermsFeature termsFeature;
    private FeeWaiver feeWaiver;
    private List<CashAdvanceFeeFeatureGroup> cashAdvanceFeeFeatureGroup = new ArrayList<CashAdvanceFeeFeatureGroup>();

    public String getChargeOffFeatureId() {
        return chargeOffFeatureId;
    }

    public void setChargeOffFeatureId(String chargeOffFeatureId) {
        this.chargeOffFeatureId = chargeOffFeatureId;
    }

    public String getChargeOffFeatureDesc() {
        return chargeOffFeatureDesc;
    }

    public void setChargeOffFeatureDesc(String chargeOffFeatureDesc) {
        this.chargeOffFeatureDesc = chargeOffFeatureDesc;
    }

    public String getChangeInTermFeatureId() {
        return changeInTermFeatureId;
    }

    public void setChangeInTermFeatureId(String changeInTermFeatureId) {
        this.changeInTermFeatureId = changeInTermFeatureId;
    }

    public String getChangeInTermFeatureDesc() {
        return changeInTermFeatureDesc;
    }

    public void setChangeInTermFeatureDesc(String changeInTermFeatureDesc) {
        this.changeInTermFeatureDesc = changeInTermFeatureDesc;
    }

    public String getMinimumPaymentFeatureId() {
        return minimumPaymentFeatureId;
    }

    public void setMinimumPaymentFeatureId(String minimumPaymentFeatureId) {
        this.minimumPaymentFeatureId = minimumPaymentFeatureId;
    }

    public String getMinimumPaymentFeatureDesc() {
        return minimumPaymentFeatureDesc;
    }

    public void setMinimumPaymentFeatureDesc(String minimumPaymentFeatureDesc) {
        this.minimumPaymentFeatureDesc = minimumPaymentFeatureDesc;
    }

    public String getCollectionFeatureId() {
        return collectionFeatureId;
    }

    public void setCollectionFeatureId(String collectionFeatureId) {
        this.collectionFeatureId = collectionFeatureId;
    }

    public String getCollectionFeatureDesc() {
        return collectionFeatureDesc;
    }

    public void setCollectionFeatureDesc(String collectionFeatureDesc) {
        this.collectionFeatureDesc = collectionFeatureDesc;
    }

    public String getConvenienceCheckFeatureId() {
        return convenienceCheckFeatureId;
    }

    public void setConvenienceCheckFeatureId(String convenienceCheckFeatureId) {
        this.convenienceCheckFeatureId = convenienceCheckFeatureId;
    }

    public String getConvenienceCheckFeatureDesc() {
        return convenienceCheckFeatureDesc;
    }

    public void setConvenienceCheckFeatureDesc(String convenienceCheckFeatureDesc) {
        this.convenienceCheckFeatureDesc = convenienceCheckFeatureDesc;
    }

    public String getPerformancePricingFeatureId() {
        return performancePricingFeatureId;
    }

    public void setPerformancePricingFeatureId(String performancePricingFeatureId) {
        this.performancePricingFeatureId = performancePricingFeatureId;
    }

    public String getPerformancePricingFeatureDesc() {
        return performancePricingFeatureDesc;
    }

    public void setPerformancePricingFeatureDesc(String performancePricingFeatureDesc) {
        this.performancePricingFeatureDesc = performancePricingFeatureDesc;
    }

    public String getMiscellaneousProcessingFeatureId() {
        return miscellaneousProcessingFeatureId;
    }

    public void setMiscellaneousProcessingFeatureId(String miscellaneousProcessingFeatureId) {
        this.miscellaneousProcessingFeatureId = miscellaneousProcessingFeatureId;
    }

    public String getMiscellaneousProcessingFeatureDesc() {
        return miscellaneousProcessingFeatureDesc;
    }

    public void setMiscellaneousProcessingFeatureDesc(String miscellaneousProcessingFeatureDesc) {
        this.miscellaneousProcessingFeatureDesc = miscellaneousProcessingFeatureDesc;
    }

    public String getAgreementCloseFeatureId() {
        return agreementCloseFeatureId;
    }

    public void setAgreementCloseFeatureId(String agreementCloseFeatureId) {
        this.agreementCloseFeatureId = agreementCloseFeatureId;
    }

    public String getAgreementCloseFeatureDesc() {
        return agreementCloseFeatureDesc;
    }

    public void setAgreementCloseFeatureDesc(String agreementCloseFeatureDesc) {
        this.agreementCloseFeatureDesc = agreementCloseFeatureDesc;
    }

    public String getAuthorizationFeatureId() {
        return authorizationFeatureId;
    }

    public void setAuthorizationFeatureId(String authorizationFeatureId) {
        this.authorizationFeatureId = authorizationFeatureId;
    }

    public String getAuthorizationFeatureDesc() {
        return authorizationFeatureDesc;
    }

    public void setAuthorizationFeatureDesc(String authorizationFeatureDesc) {
        this.authorizationFeatureDesc = authorizationFeatureDesc;
    }

    public String getCreditBalanceRefundFeatureId() {
        return creditBalanceRefundFeatureId;
    }

    public void setCreditBalanceRefundFeatureId(String creditBalanceRefundFeatureId) {
        this.creditBalanceRefundFeatureId = creditBalanceRefundFeatureId;
    }

    public String getCreditBalanceRefundFeatureDesc() {
        return creditBalanceRefundFeatureDesc;
    }

    public void setCreditBalanceRefundFeatureDesc(String creditBalanceRefundFeatureDesc) {
        this.creditBalanceRefundFeatureDesc = creditBalanceRefundFeatureDesc;
    }

    public String getCardReceiptVerificationFeatureId() {
        return cardReceiptVerificationFeatureId;
    }

    public void setCardReceiptVerificationFeatureId(String cardReceiptVerificationFeatureId) {
        this.cardReceiptVerificationFeatureId = cardReceiptVerificationFeatureId;
    }

    public String getCardReceiptVerificationFeatureDesc() {
        return cardReceiptVerificationFeatureDesc;
    }

    public void setCardReceiptVerificationFeatureDesc(String cardReceiptVerificationFeatureDesc) {
        this.cardReceiptVerificationFeatureDesc = cardReceiptVerificationFeatureDesc;
    }

    public String getSkipAPaymentFeatureId() {
        return skipAPaymentFeatureId;
    }

    public void setSkipAPaymentFeatureId(String skipAPaymentFeatureId) {
        this.skipAPaymentFeatureId = skipAPaymentFeatureId;
    }

    public String getSkipAPaymentFeatureDesc() {
        return skipAPaymentFeatureDesc;
    }

    public void setSkipAPaymentFeatureDesc(String skipAPaymentFeatureDesc) {
        this.skipAPaymentFeatureDesc = skipAPaymentFeatureDesc;
    }

    public String getServiceFeeFeatureId() {
        return serviceFeeFeatureId;
    }

    public void setServiceFeeFeatureId(String serviceFeeFeatureId) {
        this.serviceFeeFeatureId = serviceFeeFeatureId;
    }

    public String getServiceFeeFeatureDesc() {
        return serviceFeeFeatureDesc;
    }

    public void setServiceFeeFeatureDesc(String serviceFeeFeatureDesc) {
        this.serviceFeeFeatureDesc = serviceFeeFeatureDesc;
    }

    public String getStatementFeatureId() {
        return statementFeatureId;
    }

    public void setStatementFeatureId(String statementFeatureId) {
        this.statementFeatureId = statementFeatureId;
    }

    public String getStatementFeatureDesc() {
        return statementFeatureDesc;
    }

    public void setStatementFeatureDesc(String statementFeatureDesc) {
        this.statementFeatureDesc = statementFeatureDesc;
    }

    public String getAgreementFeeFeatureId() {
        return agreementFeeFeatureId;
    }

    public void setAgreementFeeFeatureId(String agreementFeeFeatureId) {
        this.agreementFeeFeatureId = agreementFeeFeatureId;
    }

    public String getAgreementFeeFeatureDesc() {
        return agreementFeeFeatureDesc;
    }

    public void setAgreementFeeFeatureDesc(String agreementFeeFeatureDesc) {
        this.agreementFeeFeatureDesc = agreementFeeFeatureDesc;
    }

    public String getTransactionFeeFeatureId() {
        return transactionFeeFeatureId;
    }

    public void setTransactionFeeFeatureId(String transactionFeeFeatureId) {
        this.transactionFeeFeatureId = transactionFeeFeatureId;
    }

    public String getTransactionFeeFeatureDesc() {
        return transactionFeeFeatureDesc;
    }

    public void setTransactionFeeFeatureDesc(String transactionFeeFeatureDesc) {
        this.transactionFeeFeatureDesc = transactionFeeFeatureDesc;
    }

    public String getMembershipFeeFeatureId() {
        return membershipFeeFeatureId;
    }

    public void setMembershipFeeFeatureId(String membershipFeeFeatureId) {
        this.membershipFeeFeatureId = membershipFeeFeatureId;
    }

    public String getMembershipFeeFeatureDesc() {
        return membershipFeeFeatureDesc;
    }

    public void setMembershipFeeFeatureDesc(String membershipFeeFeatureDesc) {
        this.membershipFeeFeatureDesc = membershipFeeFeatureDesc;
    }

    public String getSecurityFeatureId() {
        return securityFeatureId;
    }

    public void setSecurityFeatureId(String securityFeatureId) {
        this.securityFeatureId = securityFeatureId;
    }

    public String getSecurityFeatureDesc() {
        return securityFeatureDesc;
    }

    public void setSecurityFeatureDesc(String securityFeatureDesc) {
        this.securityFeatureDesc = securityFeatureDesc;
    }

    public String getCreditBureauReportFeatureId() {
        return creditBureauReportFeatureId;
    }

    public void setCreditBureauReportFeatureId(String creditBureauReportFeatureId) {
        this.creditBureauReportFeatureId = creditBureauReportFeatureId;
    }

    public String getCreditBureauReportFeatureDesc() {
        return creditBureauReportFeatureDesc;
    }

    public void setCreditBureauReportFeatureDesc(String creditBureauReportFeatureDesc) {
        this.creditBureauReportFeatureDesc = creditBureauReportFeatureDesc;
    }

    public String getCreditLineFeatureId() {
        return creditLineFeatureId;
    }

    public void setCreditLineFeatureId(String creditLineFeatureId) {
        this.creditLineFeatureId = creditLineFeatureId;
    }

    public String getCycleAssignmentFeatureId() {
        return cycleAssignmentFeatureId;
    }

    public void setCycleAssignmentFeatureId(String cycleAssignmentFeatureId) {
        this.cycleAssignmentFeatureId = cycleAssignmentFeatureId;
    }

    public String getCycleAssignmentFeatureDesc() {
        return cycleAssignmentFeatureDesc;
    }

    public void setCycleAssignmentFeatureDesc(String cycleAssignmentFeatureDesc) {
        this.cycleAssignmentFeatureDesc = cycleAssignmentFeatureDesc;
    }

    public String getPromotionalTermFeatureId() {
        return promotionalTermFeatureId;
    }

    public void setPromotionalTermFeatureId(String promotionalTermFeatureId) {
        this.promotionalTermFeatureId = promotionalTermFeatureId;
    }

    public String getPromotionalTermFeatureDesc() {
        return promotionalTermFeatureDesc;
    }

    public void setPromotionalTermFeatureDesc(String promotionalTermFeatureDesc) {
        this.promotionalTermFeatureDesc = promotionalTermFeatureDesc;
    }

    public String getInsuranceFeatureId() {
        return insuranceFeatureId;
    }

    public void setInsuranceFeatureId(String insuranceFeatureId) {
        this.insuranceFeatureId = insuranceFeatureId;
    }

    public String getInsuranceFeatureDesc() {
        return insuranceFeatureDesc;
    }

    public void setInsuranceFeatureDesc(String insuranceFeatureDesc) {
        this.insuranceFeatureDesc = insuranceFeatureDesc;
    }

    public String getMembershipFeeRebateFeatureId() {
        return membershipFeeRebateFeatureId;
    }

    public void setMembershipFeeRebateFeatureId(String membershipFeeRebateFeatureId) {
        this.membershipFeeRebateFeatureId = membershipFeeRebateFeatureId;
    }

    public String getMembershipFeeRebateFeatureDesc() {
        return membershipFeeRebateFeatureDesc;
    }

    public void setMembershipFeeRebateFeatureDesc(String membershipFeeRebateFeatureDesc) {
        this.membershipFeeRebateFeatureDesc = membershipFeeRebateFeatureDesc;
    }

    public String getTransactionRebateFeatureId() {
        return transactionRebateFeatureId;
    }

    public void setTransactionRebateFeatureId(String transactionRebateFeatureId) {
        this.transactionRebateFeatureId = transactionRebateFeatureId;
    }

    public String getTransactionRebateFeatureDesc() {
        return transactionRebateFeatureDesc;
    }

    public void setTransactionRebateFeatureDesc(String transactionRebateFeatureDesc) {
        this.transactionRebateFeatureDesc = transactionRebateFeatureDesc;
    }

    public String getProductChangeFeatureId() {
        return productChangeFeatureId;
    }

    public void setProductChangeFeatureId(String productChangeFeatureId) {
        this.productChangeFeatureId = productChangeFeatureId;
    }

    public String getProductChangeFeatureDesc() {
        return productChangeFeatureDesc;
    }

    public void setProductChangeFeatureDesc(String productChangeFeatureDesc) {
        this.productChangeFeatureDesc = productChangeFeatureDesc;
    }

    public String getMembershipNumberFeatureId() {
        return membershipNumberFeatureId;
    }

    public void setMembershipNumberFeatureId(String membershipNumberFeatureId) {
        this.membershipNumberFeatureId = membershipNumberFeatureId;
    }

    public String getMembershipNumberFeatureDesc() {
        return membershipNumberFeatureDesc;
    }

    public void setMembershipNumberFeatureDesc(String membershipNumberFeatureDesc) {
        this.membershipNumberFeatureDesc = membershipNumberFeatureDesc;
    }

    public String getMultipleProductInsuranceFeatureId() {
        return multipleProductInsuranceFeatureId;
    }

    public void setMultipleProductInsuranceFeatureId(String multipleProductInsuranceFeatureId) {
        this.multipleProductInsuranceFeatureId = multipleProductInsuranceFeatureId;
    }

    public String getMultipleProductInsuranceFeatureDesc() {
        return multipleProductInsuranceFeatureDesc;
    }

    public void setMultipleProductInsuranceFeatureDesc(String multipleProductInsuranceFeatureDesc) {
        this.multipleProductInsuranceFeatureDesc = multipleProductInsuranceFeatureDesc;
    }

    public String getAgreementAnnualPercentageRateFeatureId() {
        return agreementAnnualPercentageRateFeatureId;
    }

    public void setAgreementAnnualPercentageRateFeatureId(String agreementAnnualPercentageRateFeatureId) {
        this.agreementAnnualPercentageRateFeatureId = agreementAnnualPercentageRateFeatureId;
    }

    public String getAgreementAnnualPercentageRateFeatureDesc() {
        return agreementAnnualPercentageRateFeatureDesc;
    }

    public void setAgreementAnnualPercentageRateFeatureDesc(String agreementAnnualPercentageRateFeatureDesc) {
        this.agreementAnnualPercentageRateFeatureDesc = agreementAnnualPercentageRateFeatureDesc;
    }

    public String getLateFeeFeatureId() {
        return lateFeeFeatureId;
    }

    public void setLateFeeFeatureId(String lateFeeFeatureId) {
        this.lateFeeFeatureId = lateFeeFeatureId;
    }

    public String getLateFeeFeatureDesc() {
        return lateFeeFeatureDesc;
    }

    public void setLateFeeFeatureDesc(String lateFeeFeatureDesc) {
        this.lateFeeFeatureDesc = lateFeeFeatureDesc;
    }

    public String getLateFeeFeatureSourceVal() {
        return lateFeeFeatureSourceVal;
    }

    public void setLateFeeFeatureSourceVal(String lateFeeFeatureSourceVal) {
        this.lateFeeFeatureSourceVal = lateFeeFeatureSourceVal;
    }

    public String getCashAdvanceFeeFeatureSourceVal() {
        return cashAdvanceFeeFeatureSourceVal;
    }

    public void setCashAdvanceFeeFeatureSourceVal(String cashAdvanceFeeFeatureSourceVal) {
        this.cashAdvanceFeeFeatureSourceVal = cashAdvanceFeeFeatureSourceVal;
    }

    public TermsFeature getTermsFeature() {
        return termsFeature;
    }

    public void setTermsFeature(TermsFeature termsFeature) {
        this.termsFeature = termsFeature;
    }

    public FeeWaiver getFeeWaiver() {
        return feeWaiver;
    }

    public void setFeeWaiver(FeeWaiver feeWaiver) {
        this.feeWaiver = feeWaiver;
    }

    public List<CashAdvanceFeeFeatureGroup> getCashAdvanceFeeFeatureGroup() {
        return cashAdvanceFeeFeatureGroup;
    }

    public void setCashAdvanceFeeFeatureGroup(List<CashAdvanceFeeFeatureGroup> cashAdvanceFeeFeatureGroup) {
        this.cashAdvanceFeeFeatureGroup = cashAdvanceFeeFeatureGroup;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FeatureView.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("chargeOffFeatureId");
        sb.append('=');
        sb.append(((this.chargeOffFeatureId == null)?"<null>":this.chargeOffFeatureId));
        sb.append(',');
        sb.append("chargeOffFeatureDesc");
        sb.append('=');
        sb.append(((this.chargeOffFeatureDesc == null)?"<null>":this.chargeOffFeatureDesc));
        sb.append(',');
        sb.append("changeInTermFeatureId");
        sb.append('=');
        sb.append(((this.changeInTermFeatureId == null)?"<null>":this.changeInTermFeatureId));
        sb.append(',');
        sb.append("changeInTermFeatureDesc");
        sb.append('=');
        sb.append(((this.changeInTermFeatureDesc == null)?"<null>":this.changeInTermFeatureDesc));
        sb.append(',');
        sb.append("minimumPaymentFeatureId");
        sb.append('=');
        sb.append(((this.minimumPaymentFeatureId == null)?"<null>":this.minimumPaymentFeatureId));
        sb.append(',');
        sb.append("minimumPaymentFeatureDesc");
        sb.append('=');
        sb.append(((this.minimumPaymentFeatureDesc == null)?"<null>":this.minimumPaymentFeatureDesc));
        sb.append(',');
        sb.append("collectionFeatureId");
        sb.append('=');
        sb.append(((this.collectionFeatureId == null)?"<null>":this.collectionFeatureId));
        sb.append(',');
        sb.append("collectionFeatureDesc");
        sb.append('=');
        sb.append(((this.collectionFeatureDesc == null)?"<null>":this.collectionFeatureDesc));
        sb.append(',');
        sb.append("convenienceCheckFeatureId");
        sb.append('=');
        sb.append(((this.convenienceCheckFeatureId == null)?"<null>":this.convenienceCheckFeatureId));
        sb.append(',');
        sb.append("convenienceCheckFeatureDesc");
        sb.append('=');
        sb.append(((this.convenienceCheckFeatureDesc == null)?"<null>":this.convenienceCheckFeatureDesc));
        sb.append(',');
        sb.append("performancePricingFeatureId");
        sb.append('=');
        sb.append(((this.performancePricingFeatureId == null)?"<null>":this.performancePricingFeatureId));
        sb.append(',');
        sb.append("performancePricingFeatureDesc");
        sb.append('=');
        sb.append(((this.performancePricingFeatureDesc == null)?"<null>":this.performancePricingFeatureDesc));
        sb.append(',');
        sb.append("miscellaneousProcessingFeatureId");
        sb.append('=');
        sb.append(((this.miscellaneousProcessingFeatureId == null)?"<null>":this.miscellaneousProcessingFeatureId));
        sb.append(',');
        sb.append("miscellaneousProcessingFeatureDesc");
        sb.append('=');
        sb.append(((this.miscellaneousProcessingFeatureDesc == null)?"<null>":this.miscellaneousProcessingFeatureDesc));
        sb.append(',');
        sb.append("agreementCloseFeatureId");
        sb.append('=');
        sb.append(((this.agreementCloseFeatureId == null)?"<null>":this.agreementCloseFeatureId));
        sb.append(',');
        sb.append("agreementCloseFeatureDesc");
        sb.append('=');
        sb.append(((this.agreementCloseFeatureDesc == null)?"<null>":this.agreementCloseFeatureDesc));
        sb.append(',');
        sb.append("authorizationFeatureId");
        sb.append('=');
        sb.append(((this.authorizationFeatureId == null)?"<null>":this.authorizationFeatureId));
        sb.append(',');
        sb.append("authorizationFeatureDesc");
        sb.append('=');
        sb.append(((this.authorizationFeatureDesc == null)?"<null>":this.authorizationFeatureDesc));
        sb.append(',');
        sb.append("creditBalanceRefundFeatureId");
        sb.append('=');
        sb.append(((this.creditBalanceRefundFeatureId == null)?"<null>":this.creditBalanceRefundFeatureId));
        sb.append(',');
        sb.append("creditBalanceRefundFeatureDesc");
        sb.append('=');
        sb.append(((this.creditBalanceRefundFeatureDesc == null)?"<null>":this.creditBalanceRefundFeatureDesc));
        sb.append(',');
        sb.append("cardReceiptVerificationFeatureId");
        sb.append('=');
        sb.append(((this.cardReceiptVerificationFeatureId == null)?"<null>":this.cardReceiptVerificationFeatureId));
        sb.append(',');
        sb.append("cardReceiptVerificationFeatureDesc");
        sb.append('=');
        sb.append(((this.cardReceiptVerificationFeatureDesc == null)?"<null>":this.cardReceiptVerificationFeatureDesc));
        sb.append(',');
        sb.append("skipAPaymentFeatureId");
        sb.append('=');
        sb.append(((this.skipAPaymentFeatureId == null)?"<null>":this.skipAPaymentFeatureId));
        sb.append(',');
        sb.append("skipAPaymentFeatureDesc");
        sb.append('=');
        sb.append(((this.skipAPaymentFeatureDesc == null)?"<null>":this.skipAPaymentFeatureDesc));
        sb.append(',');
        sb.append("serviceFeeFeatureId");
        sb.append('=');
        sb.append(((this.serviceFeeFeatureId == null)?"<null>":this.serviceFeeFeatureId));
        sb.append(',');
        sb.append("serviceFeeFeatureDesc");
        sb.append('=');
        sb.append(((this.serviceFeeFeatureDesc == null)?"<null>":this.serviceFeeFeatureDesc));
        sb.append(',');
        sb.append("statementFeatureId");
        sb.append('=');
        sb.append(((this.statementFeatureId == null)?"<null>":this.statementFeatureId));
        sb.append(',');
        sb.append("statementFeatureDesc");
        sb.append('=');
        sb.append(((this.statementFeatureDesc == null)?"<null>":this.statementFeatureDesc));
        sb.append(',');
        sb.append("agreementFeeFeatureId");
        sb.append('=');
        sb.append(((this.agreementFeeFeatureId == null)?"<null>":this.agreementFeeFeatureId));
        sb.append(',');
        sb.append("agreementFeeFeatureDesc");
        sb.append('=');
        sb.append(((this.agreementFeeFeatureDesc == null)?"<null>":this.agreementFeeFeatureDesc));
        sb.append(',');
        sb.append("transactionFeeFeatureId");
        sb.append('=');
        sb.append(((this.transactionFeeFeatureId == null)?"<null>":this.transactionFeeFeatureId));
        sb.append(',');
        sb.append("transactionFeeFeatureDesc");
        sb.append('=');
        sb.append(((this.transactionFeeFeatureDesc == null)?"<null>":this.transactionFeeFeatureDesc));
        sb.append(',');
        sb.append("membershipFeeFeatureId");
        sb.append('=');
        sb.append(((this.membershipFeeFeatureId == null)?"<null>":this.membershipFeeFeatureId));
        sb.append(',');
        sb.append("membershipFeeFeatureDesc");
        sb.append('=');
        sb.append(((this.membershipFeeFeatureDesc == null)?"<null>":this.membershipFeeFeatureDesc));
        sb.append(',');
        sb.append("securityFeatureId");
        sb.append('=');
        sb.append(((this.securityFeatureId == null)?"<null>":this.securityFeatureId));
        sb.append(',');
        sb.append("securityFeatureDesc");
        sb.append('=');
        sb.append(((this.securityFeatureDesc == null)?"<null>":this.securityFeatureDesc));
        sb.append(',');
        sb.append("creditBureauReportFeatureId");
        sb.append('=');
        sb.append(((this.creditBureauReportFeatureId == null)?"<null>":this.creditBureauReportFeatureId));
        sb.append(',');
        sb.append("creditBureauReportFeatureDesc");
        sb.append('=');
        sb.append(((this.creditBureauReportFeatureDesc == null)?"<null>":this.creditBureauReportFeatureDesc));
        sb.append(',');
        sb.append("creditLineFeatureId");
        sb.append('=');
        sb.append(((this.creditLineFeatureId == null)?"<null>":this.creditLineFeatureId));
        sb.append(',');
        sb.append("cycleAssignmentFeatureId");
        sb.append('=');
        sb.append(((this.cycleAssignmentFeatureId == null)?"<null>":this.cycleAssignmentFeatureId));
        sb.append(',');
        sb.append("cycleAssignmentFeatureDesc");
        sb.append('=');
        sb.append(((this.cycleAssignmentFeatureDesc == null)?"<null>":this.cycleAssignmentFeatureDesc));
        sb.append(',');
        sb.append("promotionalTermFeatureId");
        sb.append('=');
        sb.append(((this.promotionalTermFeatureId == null)?"<null>":this.promotionalTermFeatureId));
        sb.append(',');
        sb.append("promotionalTermFeatureDesc");
        sb.append('=');
        sb.append(((this.promotionalTermFeatureDesc == null)?"<null>":this.promotionalTermFeatureDesc));
        sb.append(',');
        sb.append("insuranceFeatureId");
        sb.append('=');
        sb.append(((this.insuranceFeatureId == null)?"<null>":this.insuranceFeatureId));
        sb.append(',');
        sb.append("insuranceFeatureDesc");
        sb.append('=');
        sb.append(((this.insuranceFeatureDesc == null)?"<null>":this.insuranceFeatureDesc));
        sb.append(',');
        sb.append("membershipFeeRebateFeatureId");
        sb.append('=');
        sb.append(((this.membershipFeeRebateFeatureId == null)?"<null>":this.membershipFeeRebateFeatureId));
        sb.append(',');
        sb.append("membershipFeeRebateFeatureDesc");
        sb.append('=');
        sb.append(((this.membershipFeeRebateFeatureDesc == null)?"<null>":this.membershipFeeRebateFeatureDesc));
        sb.append(',');
        sb.append("transactionRebateFeatureId");
        sb.append('=');
        sb.append(((this.transactionRebateFeatureId == null)?"<null>":this.transactionRebateFeatureId));
        sb.append(',');
        sb.append("transactionRebateFeatureDesc");
        sb.append('=');
        sb.append(((this.transactionRebateFeatureDesc == null)?"<null>":this.transactionRebateFeatureDesc));
        sb.append(',');
        sb.append("productChangeFeatureId");
        sb.append('=');
        sb.append(((this.productChangeFeatureId == null)?"<null>":this.productChangeFeatureId));
        sb.append(',');
        sb.append("productChangeFeatureDesc");
        sb.append('=');
        sb.append(((this.productChangeFeatureDesc == null)?"<null>":this.productChangeFeatureDesc));
        sb.append(',');
        sb.append("membershipNumberFeatureId");
        sb.append('=');
        sb.append(((this.membershipNumberFeatureId == null)?"<null>":this.membershipNumberFeatureId));
        sb.append(',');
        sb.append("membershipNumberFeatureDesc");
        sb.append('=');
        sb.append(((this.membershipNumberFeatureDesc == null)?"<null>":this.membershipNumberFeatureDesc));
        sb.append(',');
        sb.append("multipleProductInsuranceFeatureId");
        sb.append('=');
        sb.append(((this.multipleProductInsuranceFeatureId == null)?"<null>":this.multipleProductInsuranceFeatureId));
        sb.append(',');
        sb.append("multipleProductInsuranceFeatureDesc");
        sb.append('=');
        sb.append(((this.multipleProductInsuranceFeatureDesc == null)?"<null>":this.multipleProductInsuranceFeatureDesc));
        sb.append(',');
        sb.append("agreementAnnualPercentageRateFeatureId");
        sb.append('=');
        sb.append(((this.agreementAnnualPercentageRateFeatureId == null)?"<null>":this.agreementAnnualPercentageRateFeatureId));
        sb.append(',');
        sb.append("agreementAnnualPercentageRateFeatureDesc");
        sb.append('=');
        sb.append(((this.agreementAnnualPercentageRateFeatureDesc == null)?"<null>":this.agreementAnnualPercentageRateFeatureDesc));
        sb.append(',');
        sb.append("lateFeeFeatureId");
        sb.append('=');
        sb.append(((this.lateFeeFeatureId == null)?"<null>":this.lateFeeFeatureId));
        sb.append(',');
        sb.append("lateFeeFeatureDesc");
        sb.append('=');
        sb.append(((this.lateFeeFeatureDesc == null)?"<null>":this.lateFeeFeatureDesc));
        sb.append(',');
        sb.append("lateFeeFeatureSourceVal");
        sb.append('=');
        sb.append(((this.lateFeeFeatureSourceVal == null)?"<null>":this.lateFeeFeatureSourceVal));
        sb.append(',');
        sb.append("cashAdvanceFeeFeatureSourceVal");
        sb.append('=');
        sb.append(((this.cashAdvanceFeeFeatureSourceVal == null)?"<null>":this.cashAdvanceFeeFeatureSourceVal));
        sb.append(',');
        sb.append("termsFeature");
        sb.append('=');
        sb.append(((this.termsFeature == null)?"<null>":this.termsFeature));
        sb.append(',');
        sb.append("feeWaiver");
        sb.append('=');
        sb.append(((this.feeWaiver == null)?"<null>":this.feeWaiver));
        sb.append(',');
        sb.append("cashAdvanceFeeFeatureGroup");
        sb.append('=');
        sb.append(((this.cashAdvanceFeeFeatureGroup == null)?"<null>":this.cashAdvanceFeeFeatureGroup));
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
        result = ((result* 31)+((this.minimumPaymentFeatureId == null)? 0 :this.minimumPaymentFeatureId.hashCode()));
        result = ((result* 31)+((this.skipAPaymentFeatureDesc == null)? 0 :this.skipAPaymentFeatureDesc.hashCode()));
        result = ((result* 31)+((this.statementFeatureId == null)? 0 :this.statementFeatureId.hashCode()));
        result = ((result* 31)+((this.promotionalTermFeatureId == null)? 0 :this.promotionalTermFeatureId.hashCode()));
        result = ((result* 31)+((this.skipAPaymentFeatureId == null)? 0 :this.skipAPaymentFeatureId.hashCode()));
        result = ((result* 31)+((this.transactionRebateFeatureId == null)? 0 :this.transactionRebateFeatureId.hashCode()));
        result = ((result* 31)+((this.membershipFeeFeatureDesc == null)? 0 :this.membershipFeeFeatureDesc.hashCode()));
        result = ((result* 31)+((this.agreementCloseFeatureDesc == null)? 0 :this.agreementCloseFeatureDesc.hashCode()));
        result = ((result* 31)+((this.lateFeeFeatureId == null)? 0 :this.lateFeeFeatureId.hashCode()));
        result = ((result* 31)+((this.creditBureauReportFeatureDesc == null)? 0 :this.creditBureauReportFeatureDesc.hashCode()));
        result = ((result* 31)+((this.convenienceCheckFeatureId == null)? 0 :this.convenienceCheckFeatureId.hashCode()));
        result = ((result* 31)+((this.creditLineFeatureId == null)? 0 :this.creditLineFeatureId.hashCode()));
        result = ((result* 31)+((this.multipleProductInsuranceFeatureDesc == null)? 0 :this.multipleProductInsuranceFeatureDesc.hashCode()));
        result = ((result* 31)+((this.performancePricingFeatureId == null)? 0 :this.performancePricingFeatureId.hashCode()));
        result = ((result* 31)+((this.cashAdvanceFeeFeatureSourceVal == null)? 0 :this.cashAdvanceFeeFeatureSourceVal.hashCode()));
        result = ((result* 31)+((this.securityFeatureDesc == null)? 0 :this.securityFeatureDesc.hashCode()));
        result = ((result* 31)+((this.creditBalanceRefundFeatureId == null)? 0 :this.creditBalanceRefundFeatureId.hashCode()));
        result = ((result* 31)+((this.lateFeeFeatureSourceVal == null)? 0 :this.lateFeeFeatureSourceVal.hashCode()));
        result = ((result* 31)+((this.collectionFeatureId == null)? 0 :this.collectionFeatureId.hashCode()));
        result = ((result* 31)+((this.agreementFeeFeatureDesc == null)? 0 :this.agreementFeeFeatureDesc.hashCode()));
        result = ((result* 31)+((this.agreementAnnualPercentageRateFeatureDesc == null)? 0 :this.agreementAnnualPercentageRateFeatureDesc.hashCode()));
        result = ((result* 31)+((this.creditBureauReportFeatureId == null)? 0 :this.creditBureauReportFeatureId.hashCode()));
        result = ((result* 31)+((this.membershipNumberFeatureId == null)? 0 :this.membershipNumberFeatureId.hashCode()));
        result = ((result* 31)+((this.cardReceiptVerificationFeatureId == null)? 0 :this.cardReceiptVerificationFeatureId.hashCode()));
        result = ((result* 31)+((this.collectionFeatureDesc == null)? 0 :this.collectionFeatureDesc.hashCode()));
        result = ((result* 31)+((this.cashAdvanceFeeFeatureGroup == null)? 0 :this.cashAdvanceFeeFeatureGroup.hashCode()));
        result = ((result* 31)+((this.agreementCloseFeatureId == null)? 0 :this.agreementCloseFeatureId.hashCode()));
        result = ((result* 31)+((this.serviceFeeFeatureId == null)? 0 :this.serviceFeeFeatureId.hashCode()));
        result = ((result* 31)+((this.multipleProductInsuranceFeatureId == null)? 0 :this.multipleProductInsuranceFeatureId.hashCode()));
        result = ((result* 31)+((this.chargeOffFeatureId == null)? 0 :this.chargeOffFeatureId.hashCode()));
        result = ((result* 31)+((this.insuranceFeatureDesc == null)? 0 :this.insuranceFeatureDesc.hashCode()));
        result = ((result* 31)+((this.membershipFeeRebateFeatureDesc == null)? 0 :this.membershipFeeRebateFeatureDesc.hashCode()));
        result = ((result* 31)+((this.membershipNumberFeatureDesc == null)? 0 :this.membershipNumberFeatureDesc.hashCode()));
        result = ((result* 31)+((this.changeInTermFeatureDesc == null)? 0 :this.changeInTermFeatureDesc.hashCode()));
        result = ((result* 31)+((this.creditBalanceRefundFeatureDesc == null)? 0 :this.creditBalanceRefundFeatureDesc.hashCode()));
        result = ((result* 31)+((this.promotionalTermFeatureDesc == null)? 0 :this.promotionalTermFeatureDesc.hashCode()));
        result = ((result* 31)+((this.changeInTermFeatureId == null)? 0 :this.changeInTermFeatureId.hashCode()));
        result = ((result* 31)+((this.miscellaneousProcessingFeatureId == null)? 0 :this.miscellaneousProcessingFeatureId.hashCode()));
        result = ((result* 31)+((this.securityFeatureId == null)? 0 :this.securityFeatureId.hashCode()));
        result = ((result* 31)+((this.membershipFeeRebateFeatureId == null)? 0 :this.membershipFeeRebateFeatureId.hashCode()));
        result = ((result* 31)+((this.transactionFeeFeatureDesc == null)? 0 :this.transactionFeeFeatureDesc.hashCode()));
        result = ((result* 31)+((this.insuranceFeatureId == null)? 0 :this.insuranceFeatureId.hashCode()));
        result = ((result* 31)+((this.productChangeFeatureId == null)? 0 :this.productChangeFeatureId.hashCode()));
        result = ((result* 31)+((this.chargeOffFeatureDesc == null)? 0 :this.chargeOffFeatureDesc.hashCode()));
        result = ((result* 31)+((this.agreementAnnualPercentageRateFeatureId == null)? 0 :this.agreementAnnualPercentageRateFeatureId.hashCode()));
        result = ((result* 31)+((this.convenienceCheckFeatureDesc == null)? 0 :this.convenienceCheckFeatureDesc.hashCode()));
        result = ((result* 31)+((this.feeWaiver == null)? 0 :this.feeWaiver.hashCode()));
        result = ((result* 31)+((this.authorizationFeatureDesc == null)? 0 :this.authorizationFeatureDesc.hashCode()));
        result = ((result* 31)+((this.minimumPaymentFeatureDesc == null)? 0 :this.minimumPaymentFeatureDesc.hashCode()));
        result = ((result* 31)+((this.cycleAssignmentFeatureId == null)? 0 :this.cycleAssignmentFeatureId.hashCode()));
        result = ((result* 31)+((this.statementFeatureDesc == null)? 0 :this.statementFeatureDesc.hashCode()));
        result = ((result* 31)+((this.cycleAssignmentFeatureDesc == null)? 0 :this.cycleAssignmentFeatureDesc.hashCode()));
        result = ((result* 31)+((this.lateFeeFeatureDesc == null)? 0 :this.lateFeeFeatureDesc.hashCode()));
        result = ((result* 31)+((this.agreementFeeFeatureId == null)? 0 :this.agreementFeeFeatureId.hashCode()));
        result = ((result* 31)+((this.miscellaneousProcessingFeatureDesc == null)? 0 :this.miscellaneousProcessingFeatureDesc.hashCode()));
        result = ((result* 31)+((this.performancePricingFeatureDesc == null)? 0 :this.performancePricingFeatureDesc.hashCode()));
        result = ((result* 31)+((this.authorizationFeatureId == null)? 0 :this.authorizationFeatureId.hashCode()));
        result = ((result* 31)+((this.transactionFeeFeatureId == null)? 0 :this.transactionFeeFeatureId.hashCode()));
        result = ((result* 31)+((this.cardReceiptVerificationFeatureDesc == null)? 0 :this.cardReceiptVerificationFeatureDesc.hashCode()));
        result = ((result* 31)+((this.membershipFeeFeatureId == null)? 0 :this.membershipFeeFeatureId.hashCode()));
        result = ((result* 31)+((this.transactionRebateFeatureDesc == null)? 0 :this.transactionRebateFeatureDesc.hashCode()));
        result = ((result* 31)+((this.serviceFeeFeatureDesc == null)? 0 :this.serviceFeeFeatureDesc.hashCode()));
        result = ((result* 31)+((this.productChangeFeatureDesc == null)? 0 :this.productChangeFeatureDesc.hashCode()));
        result = ((result* 31)+((this.termsFeature == null)? 0 :this.termsFeature.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FeatureView) == false) {
            return false;
        }
        FeatureView rhs = ((FeatureView) other);
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.minimumPaymentFeatureId == rhs.minimumPaymentFeatureId)||((this.minimumPaymentFeatureId!= null)&&this.minimumPaymentFeatureId.equals(rhs.minimumPaymentFeatureId)))&&((this.skipAPaymentFeatureDesc == rhs.skipAPaymentFeatureDesc)||((this.skipAPaymentFeatureDesc!= null)&&this.skipAPaymentFeatureDesc.equals(rhs.skipAPaymentFeatureDesc))))&&((this.statementFeatureId == rhs.statementFeatureId)||((this.statementFeatureId!= null)&&this.statementFeatureId.equals(rhs.statementFeatureId))))&&((this.promotionalTermFeatureId == rhs.promotionalTermFeatureId)||((this.promotionalTermFeatureId!= null)&&this.promotionalTermFeatureId.equals(rhs.promotionalTermFeatureId))))&&((this.skipAPaymentFeatureId == rhs.skipAPaymentFeatureId)||((this.skipAPaymentFeatureId!= null)&&this.skipAPaymentFeatureId.equals(rhs.skipAPaymentFeatureId))))&&((this.transactionRebateFeatureId == rhs.transactionRebateFeatureId)||((this.transactionRebateFeatureId!= null)&&this.transactionRebateFeatureId.equals(rhs.transactionRebateFeatureId))))&&((this.membershipFeeFeatureDesc == rhs.membershipFeeFeatureDesc)||((this.membershipFeeFeatureDesc!= null)&&this.membershipFeeFeatureDesc.equals(rhs.membershipFeeFeatureDesc))))&&((this.agreementCloseFeatureDesc == rhs.agreementCloseFeatureDesc)||((this.agreementCloseFeatureDesc!= null)&&this.agreementCloseFeatureDesc.equals(rhs.agreementCloseFeatureDesc))))&&((this.lateFeeFeatureId == rhs.lateFeeFeatureId)||((this.lateFeeFeatureId!= null)&&this.lateFeeFeatureId.equals(rhs.lateFeeFeatureId))))&&((this.creditBureauReportFeatureDesc == rhs.creditBureauReportFeatureDesc)||((this.creditBureauReportFeatureDesc!= null)&&this.creditBureauReportFeatureDesc.equals(rhs.creditBureauReportFeatureDesc))))&&((this.convenienceCheckFeatureId == rhs.convenienceCheckFeatureId)||((this.convenienceCheckFeatureId!= null)&&this.convenienceCheckFeatureId.equals(rhs.convenienceCheckFeatureId))))&&((this.creditLineFeatureId == rhs.creditLineFeatureId)||((this.creditLineFeatureId!= null)&&this.creditLineFeatureId.equals(rhs.creditLineFeatureId))))&&((this.multipleProductInsuranceFeatureDesc == rhs.multipleProductInsuranceFeatureDesc)||((this.multipleProductInsuranceFeatureDesc!= null)&&this.multipleProductInsuranceFeatureDesc.equals(rhs.multipleProductInsuranceFeatureDesc))))&&((this.performancePricingFeatureId == rhs.performancePricingFeatureId)||((this.performancePricingFeatureId!= null)&&this.performancePricingFeatureId.equals(rhs.performancePricingFeatureId))))&&((this.cashAdvanceFeeFeatureSourceVal == rhs.cashAdvanceFeeFeatureSourceVal)||((this.cashAdvanceFeeFeatureSourceVal!= null)&&this.cashAdvanceFeeFeatureSourceVal.equals(rhs.cashAdvanceFeeFeatureSourceVal))))&&((this.securityFeatureDesc == rhs.securityFeatureDesc)||((this.securityFeatureDesc!= null)&&this.securityFeatureDesc.equals(rhs.securityFeatureDesc))))&&((this.creditBalanceRefundFeatureId == rhs.creditBalanceRefundFeatureId)||((this.creditBalanceRefundFeatureId!= null)&&this.creditBalanceRefundFeatureId.equals(rhs.creditBalanceRefundFeatureId))))&&((this.lateFeeFeatureSourceVal == rhs.lateFeeFeatureSourceVal)||((this.lateFeeFeatureSourceVal!= null)&&this.lateFeeFeatureSourceVal.equals(rhs.lateFeeFeatureSourceVal))))&&((this.collectionFeatureId == rhs.collectionFeatureId)||((this.collectionFeatureId!= null)&&this.collectionFeatureId.equals(rhs.collectionFeatureId))))&&((this.agreementFeeFeatureDesc == rhs.agreementFeeFeatureDesc)||((this.agreementFeeFeatureDesc!= null)&&this.agreementFeeFeatureDesc.equals(rhs.agreementFeeFeatureDesc))))&&((this.agreementAnnualPercentageRateFeatureDesc == rhs.agreementAnnualPercentageRateFeatureDesc)||((this.agreementAnnualPercentageRateFeatureDesc!= null)&&this.agreementAnnualPercentageRateFeatureDesc.equals(rhs.agreementAnnualPercentageRateFeatureDesc))))&&((this.creditBureauReportFeatureId == rhs.creditBureauReportFeatureId)||((this.creditBureauReportFeatureId!= null)&&this.creditBureauReportFeatureId.equals(rhs.creditBureauReportFeatureId))))&&((this.membershipNumberFeatureId == rhs.membershipNumberFeatureId)||((this.membershipNumberFeatureId!= null)&&this.membershipNumberFeatureId.equals(rhs.membershipNumberFeatureId))))&&((this.cardReceiptVerificationFeatureId == rhs.cardReceiptVerificationFeatureId)||((this.cardReceiptVerificationFeatureId!= null)&&this.cardReceiptVerificationFeatureId.equals(rhs.cardReceiptVerificationFeatureId))))&&((this.collectionFeatureDesc == rhs.collectionFeatureDesc)||((this.collectionFeatureDesc!= null)&&this.collectionFeatureDesc.equals(rhs.collectionFeatureDesc))))&&((this.cashAdvanceFeeFeatureGroup == rhs.cashAdvanceFeeFeatureGroup)||((this.cashAdvanceFeeFeatureGroup!= null)&&this.cashAdvanceFeeFeatureGroup.equals(rhs.cashAdvanceFeeFeatureGroup))))&&((this.agreementCloseFeatureId == rhs.agreementCloseFeatureId)||((this.agreementCloseFeatureId!= null)&&this.agreementCloseFeatureId.equals(rhs.agreementCloseFeatureId))))&&((this.serviceFeeFeatureId == rhs.serviceFeeFeatureId)||((this.serviceFeeFeatureId!= null)&&this.serviceFeeFeatureId.equals(rhs.serviceFeeFeatureId))))&&((this.multipleProductInsuranceFeatureId == rhs.multipleProductInsuranceFeatureId)||((this.multipleProductInsuranceFeatureId!= null)&&this.multipleProductInsuranceFeatureId.equals(rhs.multipleProductInsuranceFeatureId))))&&((this.chargeOffFeatureId == rhs.chargeOffFeatureId)||((this.chargeOffFeatureId!= null)&&this.chargeOffFeatureId.equals(rhs.chargeOffFeatureId))))&&((this.insuranceFeatureDesc == rhs.insuranceFeatureDesc)||((this.insuranceFeatureDesc!= null)&&this.insuranceFeatureDesc.equals(rhs.insuranceFeatureDesc))))&&((this.membershipFeeRebateFeatureDesc == rhs.membershipFeeRebateFeatureDesc)||((this.membershipFeeRebateFeatureDesc!= null)&&this.membershipFeeRebateFeatureDesc.equals(rhs.membershipFeeRebateFeatureDesc))))&&((this.membershipNumberFeatureDesc == rhs.membershipNumberFeatureDesc)||((this.membershipNumberFeatureDesc!= null)&&this.membershipNumberFeatureDesc.equals(rhs.membershipNumberFeatureDesc))))&&((this.changeInTermFeatureDesc == rhs.changeInTermFeatureDesc)||((this.changeInTermFeatureDesc!= null)&&this.changeInTermFeatureDesc.equals(rhs.changeInTermFeatureDesc))))&&((this.creditBalanceRefundFeatureDesc == rhs.creditBalanceRefundFeatureDesc)||((this.creditBalanceRefundFeatureDesc!= null)&&this.creditBalanceRefundFeatureDesc.equals(rhs.creditBalanceRefundFeatureDesc))))&&((this.promotionalTermFeatureDesc == rhs.promotionalTermFeatureDesc)||((this.promotionalTermFeatureDesc!= null)&&this.promotionalTermFeatureDesc.equals(rhs.promotionalTermFeatureDesc))))&&((this.changeInTermFeatureId == rhs.changeInTermFeatureId)||((this.changeInTermFeatureId!= null)&&this.changeInTermFeatureId.equals(rhs.changeInTermFeatureId))))&&((this.miscellaneousProcessingFeatureId == rhs.miscellaneousProcessingFeatureId)||((this.miscellaneousProcessingFeatureId!= null)&&this.miscellaneousProcessingFeatureId.equals(rhs.miscellaneousProcessingFeatureId))))&&((this.securityFeatureId == rhs.securityFeatureId)||((this.securityFeatureId!= null)&&this.securityFeatureId.equals(rhs.securityFeatureId))))&&((this.membershipFeeRebateFeatureId == rhs.membershipFeeRebateFeatureId)||((this.membershipFeeRebateFeatureId!= null)&&this.membershipFeeRebateFeatureId.equals(rhs.membershipFeeRebateFeatureId))))&&((this.transactionFeeFeatureDesc == rhs.transactionFeeFeatureDesc)||((this.transactionFeeFeatureDesc!= null)&&this.transactionFeeFeatureDesc.equals(rhs.transactionFeeFeatureDesc))))&&((this.insuranceFeatureId == rhs.insuranceFeatureId)||((this.insuranceFeatureId!= null)&&this.insuranceFeatureId.equals(rhs.insuranceFeatureId))))&&((this.productChangeFeatureId == rhs.productChangeFeatureId)||((this.productChangeFeatureId!= null)&&this.productChangeFeatureId.equals(rhs.productChangeFeatureId))))&&((this.chargeOffFeatureDesc == rhs.chargeOffFeatureDesc)||((this.chargeOffFeatureDesc!= null)&&this.chargeOffFeatureDesc.equals(rhs.chargeOffFeatureDesc))))&&((this.agreementAnnualPercentageRateFeatureId == rhs.agreementAnnualPercentageRateFeatureId)||((this.agreementAnnualPercentageRateFeatureId!= null)&&this.agreementAnnualPercentageRateFeatureId.equals(rhs.agreementAnnualPercentageRateFeatureId))))&&((this.convenienceCheckFeatureDesc == rhs.convenienceCheckFeatureDesc)||((this.convenienceCheckFeatureDesc!= null)&&this.convenienceCheckFeatureDesc.equals(rhs.convenienceCheckFeatureDesc))))&&((this.feeWaiver == rhs.feeWaiver)||((this.feeWaiver!= null)&&this.feeWaiver.equals(rhs.feeWaiver))))&&((this.authorizationFeatureDesc == rhs.authorizationFeatureDesc)||((this.authorizationFeatureDesc!= null)&&this.authorizationFeatureDesc.equals(rhs.authorizationFeatureDesc))))&&((this.minimumPaymentFeatureDesc == rhs.minimumPaymentFeatureDesc)||((this.minimumPaymentFeatureDesc!= null)&&this.minimumPaymentFeatureDesc.equals(rhs.minimumPaymentFeatureDesc))))&&((this.cycleAssignmentFeatureId == rhs.cycleAssignmentFeatureId)||((this.cycleAssignmentFeatureId!= null)&&this.cycleAssignmentFeatureId.equals(rhs.cycleAssignmentFeatureId))))&&((this.statementFeatureDesc == rhs.statementFeatureDesc)||((this.statementFeatureDesc!= null)&&this.statementFeatureDesc.equals(rhs.statementFeatureDesc))))&&((this.cycleAssignmentFeatureDesc == rhs.cycleAssignmentFeatureDesc)||((this.cycleAssignmentFeatureDesc!= null)&&this.cycleAssignmentFeatureDesc.equals(rhs.cycleAssignmentFeatureDesc))))&&((this.lateFeeFeatureDesc == rhs.lateFeeFeatureDesc)||((this.lateFeeFeatureDesc!= null)&&this.lateFeeFeatureDesc.equals(rhs.lateFeeFeatureDesc))))&&((this.agreementFeeFeatureId == rhs.agreementFeeFeatureId)||((this.agreementFeeFeatureId!= null)&&this.agreementFeeFeatureId.equals(rhs.agreementFeeFeatureId))))&&((this.miscellaneousProcessingFeatureDesc == rhs.miscellaneousProcessingFeatureDesc)||((this.miscellaneousProcessingFeatureDesc!= null)&&this.miscellaneousProcessingFeatureDesc.equals(rhs.miscellaneousProcessingFeatureDesc))))&&((this.performancePricingFeatureDesc == rhs.performancePricingFeatureDesc)||((this.performancePricingFeatureDesc!= null)&&this.performancePricingFeatureDesc.equals(rhs.performancePricingFeatureDesc))))&&((this.authorizationFeatureId == rhs.authorizationFeatureId)||((this.authorizationFeatureId!= null)&&this.authorizationFeatureId.equals(rhs.authorizationFeatureId))))&&((this.transactionFeeFeatureId == rhs.transactionFeeFeatureId)||((this.transactionFeeFeatureId!= null)&&this.transactionFeeFeatureId.equals(rhs.transactionFeeFeatureId))))&&((this.cardReceiptVerificationFeatureDesc == rhs.cardReceiptVerificationFeatureDesc)||((this.cardReceiptVerificationFeatureDesc!= null)&&this.cardReceiptVerificationFeatureDesc.equals(rhs.cardReceiptVerificationFeatureDesc))))&&((this.membershipFeeFeatureId == rhs.membershipFeeFeatureId)||((this.membershipFeeFeatureId!= null)&&this.membershipFeeFeatureId.equals(rhs.membershipFeeFeatureId))))&&((this.transactionRebateFeatureDesc == rhs.transactionRebateFeatureDesc)||((this.transactionRebateFeatureDesc!= null)&&this.transactionRebateFeatureDesc.equals(rhs.transactionRebateFeatureDesc))))&&((this.serviceFeeFeatureDesc == rhs.serviceFeeFeatureDesc)||((this.serviceFeeFeatureDesc!= null)&&this.serviceFeeFeatureDesc.equals(rhs.serviceFeeFeatureDesc))))&&((this.productChangeFeatureDesc == rhs.productChangeFeatureDesc)||((this.productChangeFeatureDesc!= null)&&this.productChangeFeatureDesc.equals(rhs.productChangeFeatureDesc))))&&((this.termsFeature == rhs.termsFeature)||((this.termsFeature!= null)&&this.termsFeature.equals(rhs.termsFeature))));
    }

}
