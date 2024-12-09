package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class InstallmentPlanDetails implements Serializable {

	private static final long serialVersionUID = -3629943934941893680L;

    private String minPayOptionSetID = "";
    private BigDecimal annualInterestRate;
    private BigDecimal promotionFeatureAmt;
    private Long promotionFeatureStartDt;
    private BigDecimal promotionFeatureAnnualInterestRate;
    private String promotionFeatureDurationTypeCd = "";
    private Integer promotionFeatureDuration;
    private Long promotionFeatureEarlyExpiryDt;
    private Long promotionFeatureEndDate;
    private String promotionOfferId = "";
    private BigDecimal percentageFee;
    private BigDecimal fixedAmtFee;
    private BigDecimal minAmtFee;
    private BigDecimal maxAmtFee;
    private BigDecimal purchaseAmt;
    private String nickName = "";
    private BigDecimal totalEstimatedInterestAmt;
    private BigDecimal totalPaymentPlanAmt;
    private BigDecimal costOfBorrowingAmt;
    private BigDecimal monthlyPaymentAmt;


    public String getMinPayOptionSetID() {
        return minPayOptionSetID;
    }


    public void setMinPayOptionSetID(String minPayOptionSetID) {
        this.minPayOptionSetID = minPayOptionSetID;
    }


    public BigDecimal getAnnualInterestRate() {
        return annualInterestRate;
    }


    public void setAnnualInterestRate(BigDecimal annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }


    public BigDecimal getPromotionFeatureAmt() {
        return promotionFeatureAmt;
    }


    public void setPromotionFeatureAmt(BigDecimal promotionFeatureAmt) {
        this.promotionFeatureAmt = promotionFeatureAmt;
    }

    public Long getPromotionFeatureStartDt() {
        return promotionFeatureStartDt;
    }


    public void setPromotionFeatureStartDt(Long promotionFeatureStartDt) {
        this.promotionFeatureStartDt = promotionFeatureStartDt;
    }


    public BigDecimal getPromotionFeatureAnnualInterestRate() {
        return promotionFeatureAnnualInterestRate;
    }


    public void setPromotionFeatureAnnualInterestRate(BigDecimal promotionFeatureAnnualInterestRate) {
        this.promotionFeatureAnnualInterestRate = promotionFeatureAnnualInterestRate;
    }


    public String getPromotionFeatureDurationTypeCd() {
        return promotionFeatureDurationTypeCd;
    }


    public void setPromotionFeatureDurationTypeCd(String promotionFeatureDurationTypeCd) {
        this.promotionFeatureDurationTypeCd = promotionFeatureDurationTypeCd;
    }


    public Long getPromotionFeatureEarlyExpiryDt() {
        return promotionFeatureEarlyExpiryDt;
    }


    public void setPromotionFeatureEarlyExpiryDt(Long promotionFeatureEarlyExpiryDt) {
        this.promotionFeatureEarlyExpiryDt = promotionFeatureEarlyExpiryDt;
    }


    public Long getPromotionFeatureEndDate() {
        return promotionFeatureEndDate;
    }


    public void setPromotionFeatureEndDate(Long promotionFeatureEndDate) {
        this.promotionFeatureEndDate = promotionFeatureEndDate;
    }


    public String getPromotionOfferId() {
        return promotionOfferId;
    }


    public void setPromotionOfferId(String promotionOfferId) {
        this.promotionOfferId = promotionOfferId;
    }


    public BigDecimal getPercentageFee() {
        return percentageFee;
    }


    public void setPercentageFee(BigDecimal percentageFee) {
        this.percentageFee = percentageFee;
    }


    public BigDecimal getFixedAmtFee() {
        return fixedAmtFee;
    }


    public void setFixedAmtFee(BigDecimal fixedAmtFee) {
        this.fixedAmtFee = fixedAmtFee;
    }


    public BigDecimal getMinAmtFee() {
        return minAmtFee;
    }


    public void setMinAmtFee(BigDecimal minAmtFee) {
        this.minAmtFee = minAmtFee;
    }


    public BigDecimal getMaxAmtFee() {
        return maxAmtFee;
    }

    public void setMaxAmtFee(BigDecimal maxAmtFee) {
        this.maxAmtFee = maxAmtFee;
    }

    public BigDecimal getPurchaseAmt() {
        return purchaseAmt;
    }

    public void setPurchaseAmt(BigDecimal purchaseAmt) {
        this.purchaseAmt = purchaseAmt;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public BigDecimal getTotalEstimatedInterestAmt() {
        return totalEstimatedInterestAmt;
    }

    public void setTotalEstimatedInterestAmt(BigDecimal totalEstimatedInterestAmt) {
        this.totalEstimatedInterestAmt = totalEstimatedInterestAmt;
    }

    public BigDecimal getTotalPaymentPlanAmt() {
        return totalPaymentPlanAmt;
    }

    public void setTotalPaymentPlanAmt(BigDecimal totalPaymentPlanAmt) {
        this.totalPaymentPlanAmt = totalPaymentPlanAmt;
    }

    public BigDecimal getCostOfBorrowingAmt() {
        return costOfBorrowingAmt;
    }

    public void setCostOfBorrowingAmt(BigDecimal costOfBorrowingAmt) {
        this.costOfBorrowingAmt = costOfBorrowingAmt;
    }

    public BigDecimal getMonthlyPaymentAmt() {
        return monthlyPaymentAmt;
    }

    public void setMonthlyPaymentAmt(BigDecimal monthlyPaymentAmt) {
        this.monthlyPaymentAmt = monthlyPaymentAmt;
    }

    public Integer getPromotionFeatureDuration() {
        return promotionFeatureDuration;
    }

    public void setPromotionFeatureDuration(Integer promotionFeatureDuration) {
        this.promotionFeatureDuration = promotionFeatureDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstallmentPlanDetails that = (InstallmentPlanDetails) o;
        return Objects.equals(minPayOptionSetID, that.minPayOptionSetID) &&
                Objects.equals(annualInterestRate, that.annualInterestRate) &&
                Objects.equals(promotionFeatureAmt, that.promotionFeatureAmt) &&
                Objects.equals(promotionFeatureStartDt, that.promotionFeatureStartDt) &&
                Objects.equals(promotionFeatureAnnualInterestRate, that.promotionFeatureAnnualInterestRate) &&
                Objects.equals(promotionFeatureDurationTypeCd, that.promotionFeatureDurationTypeCd) &&
                Objects.equals(promotionFeatureDuration, that.promotionFeatureDuration) &&
                Objects.equals(promotionFeatureEarlyExpiryDt, that.promotionFeatureEarlyExpiryDt) &&
                Objects.equals(promotionFeatureEndDate, that.promotionFeatureEndDate) &&
                Objects.equals(promotionOfferId, that.promotionOfferId) &&
                Objects.equals(percentageFee, that.percentageFee) &&
                Objects.equals(fixedAmtFee, that.fixedAmtFee) &&
                Objects.equals(minAmtFee, that.minAmtFee) &&
                Objects.equals(maxAmtFee, that.maxAmtFee) &&
                Objects.equals(purchaseAmt, that.purchaseAmt) &&
                Objects.equals(nickName, that.nickName) &&
                Objects.equals(totalEstimatedInterestAmt, that.totalEstimatedInterestAmt) &&
                Objects.equals(totalPaymentPlanAmt, that.totalPaymentPlanAmt) &&
                Objects.equals(costOfBorrowingAmt, that.costOfBorrowingAmt) &&
                Objects.equals(monthlyPaymentAmt, that.monthlyPaymentAmt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minPayOptionSetID, annualInterestRate, promotionFeatureAmt, promotionFeatureStartDt, promotionFeatureAnnualInterestRate, promotionFeatureDurationTypeCd, promotionFeatureDuration, promotionFeatureEarlyExpiryDt, promotionFeatureEndDate, promotionOfferId, percentageFee, fixedAmtFee, minAmtFee, maxAmtFee, purchaseAmt, nickName, totalEstimatedInterestAmt, totalPaymentPlanAmt, costOfBorrowingAmt, monthlyPaymentAmt);
    }

    @Override
    public String toString() {
        return "InstallmentPlanDetails{" +
                "minPayOptionSetID='" + minPayOptionSetID + '\'' +
                ", annualInterestRate=" + annualInterestRate +
                ", promotionFeatureAmt=" + promotionFeatureAmt +
                ", promotionFeatureStartDt=" + promotionFeatureStartDt +
                ", promotionFeatureAnnualInterestRate=" + promotionFeatureAnnualInterestRate +
                ", promotionFeatureDurationTypeCd='" + promotionFeatureDurationTypeCd + '\'' +
                ", promotionFeatureDuration=" + promotionFeatureDuration +
                ", promotionFeatureEarlyExpiryDt=" + promotionFeatureEarlyExpiryDt +
                ", promotionFeatureEndDate=" + promotionFeatureEndDate +
                ", promotionOfferId='" + promotionOfferId + '\'' +
                ", percentageFee=" + percentageFee +
                ", fixedAmtFee=" + fixedAmtFee +
                ", minAmtFee=" + minAmtFee +
                ", maxAmtFee=" + maxAmtFee +
                ", purchaseAmt=" + purchaseAmt +
                ", nickName='" + nickName + '\'' +
                ", totalEstimatedInterestAmt=" + totalEstimatedInterestAmt +
                ", totalPaymentPlanAmt=" + totalPaymentPlanAmt +
                ", costOfBorrowingAmt=" + costOfBorrowingAmt +
                ", monthlyPaymentAmt=" + monthlyPaymentAmt +
                '}';
    }
}
