package com.td.mbna.msec.midtier.types.common;

import com.google.gson.annotations.JsonAdapter;
import com.td.mbna.msec.midtier.serializers.GsonDateDeSerializer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class DisclosureInputType implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private String offerId;
    private String customerPhysicalProvince;
    private Integer duration;
    private BigDecimal transactionFeeRate;
    private BigDecimal fixedFee;
    private BigDecimal minimumFee;
    private BigDecimal maximumFee;
    private BigDecimal interestRate;
    private BigDecimal promoInterestRate;
    private BigDecimal auFee;
    private Boolean isEarlyExpired;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long transactionEndDate;
    private ProductChangeDisclosureType productChangeVariables;
    private EmailNotificationInfoType emailNotificationInfo;
    private InstallmentPlanDetails installmentPlanDetails;


    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getCustomerPhysicalProvince() {
        return customerPhysicalProvince;
    }

    public void setCustomerPhysicalProvince(String customerPhysicalProvince) {
        this.customerPhysicalProvince = customerPhysicalProvince;
    }

    public java.math.BigDecimal getTransactionFeeRate() {
        return transactionFeeRate;
    }

    public void setTransactionFeeRate(java.math.BigDecimal transactionFeeRate) {
        this.transactionFeeRate = transactionFeeRate;
    }

    public java.math.BigDecimal getFixedFee() {
        return fixedFee;
    }

    public void setFixedFee(java.math.BigDecimal fixedFee) {
        this.fixedFee = fixedFee;
    }

    public java.math.BigDecimal getMinimumFee() {
        return minimumFee;
    }

    public void setMinimumFee(java.math.BigDecimal minimumFee) {
        this.minimumFee = minimumFee;
    }

    public java.math.BigDecimal getMaximumFee() {
        return maximumFee;
    }

    public void setMaximumFee(java.math.BigDecimal maximumFee) {
        this.maximumFee = maximumFee;
    }

    public java.math.BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(java.math.BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public java.math.BigDecimal getPromoInterestRate() {
        return promoInterestRate;
    }

    public void setPromoInterestRate(java.math.BigDecimal promoInterestRate) {
        this.promoInterestRate = promoInterestRate;
    }

    public Boolean getIsEarlyExpired() {
        return isEarlyExpired;
    }

    public void setIsEarlyExpired(Boolean isEarlyExpired) {
        this.isEarlyExpired = isEarlyExpired;
    }

    public Long getTransactionEndDate() {
        return transactionEndDate;
    }

    public void setTransactionEndDate(Long transactionEndDate) {
        this.transactionEndDate = transactionEndDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public ProductChangeDisclosureType getProductChangeVariables() {
        return productChangeVariables;
    }

    public void setProductChangeVariables(ProductChangeDisclosureType productChangeVariables) {
        this.productChangeVariables = productChangeVariables;
    }

    public EmailNotificationInfoType getEmailNotificationInfo() {
        return emailNotificationInfo;
    }

    public void setEmailNotificationInfo(EmailNotificationInfoType emailNotificationInfo) {
        this.emailNotificationInfo = emailNotificationInfo;
    }

    public BigDecimal getAuFee() {
        return auFee;
    }

    public void setAuFee(BigDecimal auFee) {
        this.auFee = auFee;
    }

    public InstallmentPlanDetails getInstallmentPlanDetails() {
        return installmentPlanDetails;
    }

    public void setInstallmentPlanDetails(InstallmentPlanDetails installmentPlanDetails) {
        this.installmentPlanDetails = installmentPlanDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisclosureInputType that = (DisclosureInputType) o;
        return Objects.equals(offerId, that.offerId) &&
                Objects.equals(customerPhysicalProvince, that.customerPhysicalProvince) &&
                Objects.equals(transactionFeeRate, that.transactionFeeRate) &&
                Objects.equals(fixedFee, that.fixedFee) &&
                Objects.equals(minimumFee, that.minimumFee) &&
                Objects.equals(maximumFee, that.maximumFee) &&
                Objects.equals(interestRate, that.interestRate) &&
                Objects.equals(promoInterestRate, that.promoInterestRate) &&
                Objects.equals(isEarlyExpired, that.isEarlyExpired) &&
                Objects.equals(transactionEndDate, that.transactionEndDate) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(productChangeVariables, that.productChangeVariables) &&
                Objects.equals(emailNotificationInfo, that.emailNotificationInfo) &&
                Objects.equals(auFee, that.auFee) &&
                Objects.equals(installmentPlanDetails, that.installmentPlanDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerId, customerPhysicalProvince, transactionFeeRate, fixedFee, minimumFee, maximumFee, interestRate, promoInterestRate, isEarlyExpired, transactionEndDate, duration, productChangeVariables, emailNotificationInfo, auFee, installmentPlanDetails);
    }

    @Override
    public String toString() {
        return "DisclosureInputType{" +
                "offerId='" + offerId + '\'' +
                ", customerPhysicalProvince='" + customerPhysicalProvince + '\'' +
                ", transactionFeeRate=" + transactionFeeRate +
                ", fixedFee=" + fixedFee +
                ", minimumFee=" + minimumFee +
                ", maximumFee=" + maximumFee +
                ", interestRate=" + interestRate +
                ", promoInterestRate=" + promoInterestRate +
                ", isEarlyExpired=" + isEarlyExpired +
                ", transactionEndDate=" + transactionEndDate +
                ", duration=" + duration +
                ", productChangeVariables=" + productChangeVariables +
                ", emailNotificationInfo=" + emailNotificationInfo +
                ", auFee=" + auFee +
                ", installmentPlanDetails=" + installmentPlanDetails +
                '}';
    }
}
