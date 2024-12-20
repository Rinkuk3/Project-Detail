package com.td.mbna.msec.midtier.offers.payload.requestInstallmentPlan;

import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.types.common.DisclosureInfoType;
import com.td.mbna.msec.midtier.types.common.EmailNotificationInfoType;
import com.td.mbna.msec.midtier.types.common.InstallmentPlanDetails;

import java.math.BigDecimal;
import java.util.Objects;

public class RequestPayload {

    private List<DisclosureInfoType> disclosureInfo = new ArrayList<DisclosureInfoType>();
    private String languagePref;
    private String offerId;
    private String referenceNumber;
    private String nickName;
    private BigDecimal setupFees;
    private BigDecimal interestRate;
    private BigDecimal contractAnnualRate;
    private BigDecimal transactionAmt;
    private Integer duration;
    private Boolean confirmed = false;
    private String eventId;
    private String productId;
    private String statementDataDt;
    private EmailNotificationInfoType emailNotificationInfo;
    private InstallmentPlanDetails installmentPlanDetails;

    public void setSetupFees(BigDecimal setupFees) {
        this.setupFees = setupFees;
    }

    public BigDecimal getSetupFees() {
        return setupFees;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getTransactionAmt() {
        return transactionAmt;
    }

    public void setTransactionAmt(BigDecimal transactionAmt) {
        this.transactionAmt = transactionAmt;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public List<DisclosureInfoType> getDisclosureInfo() {
        return disclosureInfo;
    }

    public void setDisclosureInfo(List<DisclosureInfoType> disclosureInfo) {
        this.disclosureInfo = disclosureInfo;
    }

    public String getLanguagePref() {
        return languagePref;
    }

    public void setLanguagePref(String languagePref) {
        this.languagePref = languagePref;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getNickName() {
		return nickName;
	}
    
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

    public BigDecimal getContractAnnualRate() {
        return contractAnnualRate;
    }

    public void setContractAnnualRate(BigDecimal contractAnnualRate) {
        this.contractAnnualRate = contractAnnualRate;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getStatementDataDt() {
        return statementDataDt;
    }

    public void setStatementDataDt(String statementDataDt) {
        this.statementDataDt = statementDataDt;
    }

    public EmailNotificationInfoType getEmailNotificationInfo() {
        return emailNotificationInfo;
    }

    public void setEmailNotificationInfo(EmailNotificationInfoType emailNotificationInfo) {
        this.emailNotificationInfo = emailNotificationInfo;
    }

    public InstallmentPlanDetails getInstallmentPlanDetails() {
        return installmentPlanDetails;
    }

    public void setInstallmentPlanDetails(InstallmentPlanDetails installmentPlanDetails) {
        this.installmentPlanDetails = installmentPlanDetails;
    }

    @Override
    public String toString() {
        return "RequestPayload{" +
                "disclosureInfo=" + disclosureInfo +
                ", languagePref='" + languagePref + '\'' +
                ", offerId='" + offerId + '\'' +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", nickName='" + nickName + '\'' +
                ", setupFees=" + setupFees +
                ", interestRate=" + interestRate +
                ", contractAnnualRate=" + contractAnnualRate +
                ", transactionAmt=" + transactionAmt +
                ", duration=" + duration +
                ", confirmed=" + confirmed +
                ", eventId='" + eventId + '\'' +
                ", productId='" + productId + '\'' +
                ", statementDataDt='" + statementDataDt + '\'' +
                ", emailNotificationInfo=" + emailNotificationInfo +
                ", installmentPlanDetails=" + installmentPlanDetails +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestPayload that = (RequestPayload) o;
        return Objects.equals(disclosureInfo, that.disclosureInfo) &&
                Objects.equals(languagePref, that.languagePref) &&
                Objects.equals(offerId, that.offerId) &&
                Objects.equals(referenceNumber, that.referenceNumber) &&
                Objects.equals(nickName, that.nickName) &&
                Objects.equals(setupFees, that.setupFees) &&
                Objects.equals(interestRate, that.interestRate) &&
                Objects.equals(contractAnnualRate, that.contractAnnualRate) &&
                Objects.equals(transactionAmt, that.transactionAmt) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(confirmed, that.confirmed) &&
                Objects.equals(eventId, that.eventId) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(statementDataDt, that.statementDataDt) &&
                Objects.equals(emailNotificationInfo, that.emailNotificationInfo) &&
                Objects.equals(installmentPlanDetails, that.installmentPlanDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disclosureInfo, languagePref, offerId, referenceNumber, nickName, setupFees, interestRate, contractAnnualRate, transactionAmt, duration, confirmed, eventId, productId, statementDataDt, emailNotificationInfo, installmentPlanDetails);
    }
}
