package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

import com.google.gson.annotations.JsonAdapter;
import com.td.mbna.msec.midtier.serializers.GsonDateDeSerializer;

public class AcctOverviewType implements Serializable {

	private static final long serialVersionUID = 1L;
    private String acctNum;
    private Boolean isMultiCard;
    private BigDecimal creditAvail;
    private BigDecimal cashAdvanceAvail;
    private BigDecimal minPayment;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long minPaymentDueDate;
    private Boolean cardActivated;
    private Boolean isRewardCard;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long acctOpenDate;
    private String hardCopyStatementCount;
    private String enrollmentStatus;
    private List<CustOfferInfoType> custOffers = new ArrayList<CustOfferInfoType>();
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long cardDeliveredDate;
    private String delinquencyStatus;
    private BigInteger sequenceNumber;
    private List<AcctSnapshotStatusType> accountStatus = new ArrayList<AcctSnapshotStatusType>();
    private OfferParamsType offersParams;
    private BigDecimal contractRate;
    private String btFeeLookupCode;
    private BTOfferType btContractOffer;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long expirationDate;
    private BigDecimal currentBalance;
    private BigDecimal temporaryAuthorizationsToday;
    private BigDecimal temporaryAuthorizationsPrior;
    private BigDecimal creditLimit;
    private BigDecimal pastDueAmount;
    private BigDecimal lastStatementBalance;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long lastStatementBalanceDate;
    private BigDecimal lastPaymentPosted;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long lastPaymentPostedDate;
    private BigDecimal cashAdvanceLimit;
    private Integer pointsAvailable;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long nextStatementClosingDate;
    private TtcDestinationsInfoType ttcLastSavedPayee;
    private String insuredStatus;
    private String eBillingStatus;
    private String membershipFeeFeatureId;
    private String membershipFeeDesc;
    private BigDecimal auFee;
    private String productCodes;
    private String poCode;
    private String arqCode;
    private BigDecimal purchaseRate;

    public String getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }

    public Boolean isMultiCard() {
        return isMultiCard;
    }

    public void setMultiCard(Boolean multiCard) {
        isMultiCard = multiCard;
    }

    public BigDecimal getCreditAvail() {
        return creditAvail;
    }

    public void setCreditAvail(BigDecimal creditAvail) {
        this.creditAvail = creditAvail;
    }

    public BigDecimal getCashAdvanceAvail() {
        return cashAdvanceAvail;
    }

    public void setCashAdvanceAvail(BigDecimal cashAdvanceAvail) {
        this.cashAdvanceAvail = cashAdvanceAvail;
    }

    public BigDecimal getMinPayment() {
        return minPayment;
    }

    public void setMinPayment(BigDecimal minPayment) {
        this.minPayment = minPayment;
    }

    public Long getMinPaymentDueDate() {
        return minPaymentDueDate;
    }

    public void setMinPaymentDueDate(Long minPaymentDueDate) {
        this.minPaymentDueDate = minPaymentDueDate;
    }

    public Boolean getCardActivated() {
        return cardActivated;
    }

    public void setCardActivated(Boolean cardActivated) {
        this.cardActivated = cardActivated;
    }

    public Boolean getIsRewardCard() {
        return isRewardCard;
    }

    public void setIsRewardCard(Boolean isRewardCard) {
        this.isRewardCard = isRewardCard;
    }

    public Long getAcctOpenDate() {
        return acctOpenDate;
    }

    public void setAcctOpenDate(Long acctOpenDate) {
        this.acctOpenDate = acctOpenDate;
    }

    public String getHardCopyStatementCount() {
        return hardCopyStatementCount;
    }

    public void setHardCopyStatementCount(String hardCopyStatementCount) {
        this.hardCopyStatementCount = hardCopyStatementCount;
    }

    public String getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(String enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    public List<CustOfferInfoType> getCustOffers() {
        return custOffers;
    }

    public void setCustOffers(List<CustOfferInfoType> custOffers) {
        this.custOffers = custOffers;
    }

    public Long getCardDeliveredDate() {
        return cardDeliveredDate;
    }

    public void setCardDeliveredDate(Long cardDeliveredDate) {
        this.cardDeliveredDate = cardDeliveredDate;
    }


    public BigInteger getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(BigInteger sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public List<AcctSnapshotStatusType> getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(List<AcctSnapshotStatusType> accountStatus) {
        this.accountStatus = accountStatus;
    }

    public OfferParamsType getOffersParams() {
        return offersParams;
    }

    public void setOffersParams(OfferParamsType offersParams) {
        this.offersParams = offersParams;
    }

    public BigDecimal getContractRate() {
        return contractRate;
    }

    public void setContractRate(BigDecimal contractRate) {
        this.contractRate = contractRate;
    }

    public String getBtFeeLookupCode() {
        return btFeeLookupCode;
    }

    public void setBtFeeLookupCode(String btFeeLookupCode) {
        this.btFeeLookupCode = btFeeLookupCode;
    }

    public BTOfferType getBtContractOffer() {
        return btContractOffer;
    }

    public void setBtContractOffer(BTOfferType btContractOffer) {
        this.btContractOffer = btContractOffer;
    }

    public Long getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Long expirationDate) {
        this.expirationDate = expirationDate;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public BigDecimal getTemporaryAuthorizationsToday() {
        return temporaryAuthorizationsToday;
    }

    public void setTemporaryAuthorizationsToday(BigDecimal temporaryAuthorizationsToday) {
        this.temporaryAuthorizationsToday = temporaryAuthorizationsToday;
    }

    public BigDecimal getTemporaryAuthorizationsPrior() {
        return temporaryAuthorizationsPrior;
    }

    public void setTemporaryAuthorizationsPrior(BigDecimal temporaryAuthorizationsPrior) {
        this.temporaryAuthorizationsPrior = temporaryAuthorizationsPrior;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getPastDueAmount() {
        return pastDueAmount;
    }

    public void setPastDueAmount(BigDecimal pastDueAmount) {
        this.pastDueAmount = pastDueAmount;
    }

    public BigDecimal getLastStatementBalance() {
        return lastStatementBalance;
    }

    public void setLastStatementBalance(BigDecimal lastStatementBalance) {
        this.lastStatementBalance = lastStatementBalance;
    }

    public Long getLastStatementBalanceDate() {
        return lastStatementBalanceDate;
    }

    public void setLastStatementBalanceDate(Long lastStatementBalanceDate) {
        this.lastStatementBalanceDate = lastStatementBalanceDate;
    }

    public BigDecimal getLastPaymentPosted() {
        return lastPaymentPosted;
    }

    public void setLastPaymentPosted(BigDecimal lastPaymentPosted) {
        this.lastPaymentPosted = lastPaymentPosted;
    }

    public Long getLastPaymentPostedDate() {
        return lastPaymentPostedDate;
    }

    public void setLastPaymentPostedDate(Long lastPaymentPostedDate) {
        this.lastPaymentPostedDate = lastPaymentPostedDate;
    }

    public BigDecimal getCashAdvanceLimit() {
        return cashAdvanceLimit;
    }

    public void setCashAdvanceLimit(BigDecimal cashAdvanceLimit) {
        this.cashAdvanceLimit = cashAdvanceLimit;
    }

    public Integer getPointsAvailable() {
        return pointsAvailable;
    }

    public void setPointsAvailable(Integer pointsAvailable) {
        this.pointsAvailable = pointsAvailable;
    }

    public Long getNextStatementClosingDate() {
        return nextStatementClosingDate;
    }

    public void setNextStatementClosingDate(Long nextStatementClosingDate) {
        this.nextStatementClosingDate = nextStatementClosingDate;
    }

    public TtcDestinationsInfoType getTtcLastSavedPayee() {
        return ttcLastSavedPayee;
    }

    public void setTtcLastSavedPayee(TtcDestinationsInfoType ttcLastSavedPayee) {
        this.ttcLastSavedPayee = ttcLastSavedPayee;
    }

    public String getMembershipFeeFeatureId() {
		return membershipFeeFeatureId;
	}

	public void setMembershipFeeFeatureId(String membershipFeeFeatureId) {
		this.membershipFeeFeatureId = membershipFeeFeatureId;
	}

    public String getMembershipFeeDesc() {
        return membershipFeeDesc;
    }

    public void setMembershipFeeDesc(String membershipFeeDesc) {
        this.membershipFeeDesc = membershipFeeDesc;
    }

    public BigDecimal getAuFee() {
        return auFee;
    }

    public void setAuFee(BigDecimal auFee) {
        this.auFee = auFee;
    }

    public String getProductCodes() {
        return productCodes;
    }

    public void setProductCodes(String productCodes) {
        this.productCodes = productCodes;
    }

    public String getPoCode() {
        return poCode;
    }

    public void setPoCode(String poCode) {
        this.poCode = poCode;
    }

    public String getArqCode() {
        return arqCode;
    }

    public void setArqCode(String arqCode) {
        this.arqCode = arqCode;
    }

    public BigDecimal getPurchaseRate() {
        return purchaseRate;
    }

    public void setPurchaseRate(BigDecimal purchaseRate) {
        this.purchaseRate = purchaseRate;
    }

    public String getDelinquencyStatus() {
		return delinquencyStatus;
	}

	public void setDelinquencyStatus(String delinquencyStatus) {
		this.delinquencyStatus = delinquencyStatus;
	}

	public String getInsuredStatus() {
		return insuredStatus;
	}

	public void setInsuredStatus(String insuredStatus) {
		this.insuredStatus = insuredStatus;
	}

	public String geteBillingStatus() {
		return eBillingStatus;
	}

	public void seteBillingStatus(String eBillingStatus) {
		this.eBillingStatus = eBillingStatus;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcctOverviewType that = (AcctOverviewType) o;
        return Objects.equals(acctNum, that.acctNum) &&
                Objects.equals(isMultiCard, that.isMultiCard) &&
                Objects.equals(creditAvail, that.creditAvail) &&
                Objects.equals(cashAdvanceAvail, that.cashAdvanceAvail) &&
                Objects.equals(minPayment, that.minPayment) &&
                Objects.equals(minPaymentDueDate, that.minPaymentDueDate) &&
                Objects.equals(cardActivated, that.cardActivated) &&
                Objects.equals(isRewardCard, that.isRewardCard) &&
                Objects.equals(acctOpenDate, that.acctOpenDate) &&
                Objects.equals(hardCopyStatementCount, that.hardCopyStatementCount) &&
                Objects.equals(enrollmentStatus, that.enrollmentStatus) &&
                Objects.equals(custOffers, that.custOffers) &&
                Objects.equals(cardDeliveredDate, that.cardDeliveredDate) &&
                Objects.equals(delinquencyStatus, that.delinquencyStatus) &&
                Objects.equals(sequenceNumber, that.sequenceNumber) &&
                Objects.equals(accountStatus, that.accountStatus) &&
                Objects.equals(offersParams, that.offersParams) &&
                Objects.equals(contractRate, that.contractRate) &&
                Objects.equals(btFeeLookupCode, that.btFeeLookupCode) &&
                Objects.equals(btContractOffer, that.btContractOffer) &&
                Objects.equals(expirationDate, that.expirationDate) &&
                Objects.equals(currentBalance, that.currentBalance) &&
                Objects.equals(temporaryAuthorizationsToday, that.temporaryAuthorizationsToday) &&
                Objects.equals(temporaryAuthorizationsPrior, that.temporaryAuthorizationsPrior) &&
                Objects.equals(creditLimit, that.creditLimit) &&
                Objects.equals(pastDueAmount, that.pastDueAmount) &&
                Objects.equals(lastStatementBalance, that.lastStatementBalance) &&
                Objects.equals(lastStatementBalanceDate, that.lastStatementBalanceDate) &&
                Objects.equals(lastPaymentPosted, that.lastPaymentPosted) &&
                Objects.equals(lastPaymentPostedDate, that.lastPaymentPostedDate) &&
                Objects.equals(cashAdvanceLimit, that.cashAdvanceLimit) &&
                Objects.equals(pointsAvailable, that.pointsAvailable) &&
                Objects.equals(nextStatementClosingDate, that.nextStatementClosingDate) &&
                Objects.equals(ttcLastSavedPayee, that.ttcLastSavedPayee) &&
                Objects.equals(insuredStatus, that.insuredStatus) &&
                Objects.equals(eBillingStatus, that.eBillingStatus) &&
                Objects.equals(membershipFeeDesc, that.membershipFeeDesc) &&
                Objects.equals(auFee, that.auFee) &&
                Objects.equals(productCodes, that.productCodes) &&
                Objects.equals(poCode, that.poCode) &&
                Objects.equals(arqCode, that.arqCode) &&
                Objects.equals(purchaseRate, that.purchaseRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acctNum, isMultiCard, creditAvail, cashAdvanceAvail, minPayment, minPaymentDueDate, cardActivated, isRewardCard, acctOpenDate, hardCopyStatementCount, enrollmentStatus, custOffers, cardDeliveredDate, delinquencyStatus, sequenceNumber, accountStatus, offersParams, contractRate, btFeeLookupCode, btContractOffer, expirationDate, currentBalance, temporaryAuthorizationsToday, temporaryAuthorizationsPrior, creditLimit, pastDueAmount, lastStatementBalance, lastStatementBalanceDate, lastPaymentPosted, lastPaymentPostedDate, cashAdvanceLimit, pointsAvailable, nextStatementClosingDate, ttcLastSavedPayee, insuredStatus, eBillingStatus, membershipFeeDesc, auFee, productCodes, poCode, arqCode, purchaseRate);
    }

    @Override
    public String toString() {
        return "AcctOverviewType{" +
                "acctNum='" + acctNum + '\'' +
                ", isMultiCard=" + isMultiCard +
                ", creditAvail=" + creditAvail +
                ", cashAdvanceAvail=" + cashAdvanceAvail +
                ", minPayment=" + minPayment +
                ", minPaymentDueDate=" + minPaymentDueDate +
                ", cardActivated=" + cardActivated +
                ", isRewardCard=" + isRewardCard +
                ", acctOpenDate=" + acctOpenDate +
                ", hardCopyStatementCount='" + hardCopyStatementCount + '\'' +
                ", enrollmentStatus='" + enrollmentStatus + '\'' +
                ", custOffers=" + custOffers +
                ", cardDeliveredDate=" + cardDeliveredDate +
                ", delinquencyStatus=" + delinquencyStatus +
                ", sequenceNumber=" + sequenceNumber +
                ", accountStatus=" + accountStatus +
                ", offersParams=" + offersParams +
                ", contractRate=" + contractRate +
                ", btFeeLookupCode='" + btFeeLookupCode + '\'' +
                ", btContractOffer=" + btContractOffer +
                ", expirationDate=" + expirationDate +
                ", currentBalance=" + currentBalance +
                ", temporaryAuthorizationsToday=" + temporaryAuthorizationsToday +
                ", temporaryAuthorizationsPrior=" + temporaryAuthorizationsPrior +
                ", creditLimit=" + creditLimit +
                ", pastDueAmount=" + pastDueAmount +
                ", lastStatementBalance=" + lastStatementBalance +
                ", lastStatementBalanceDate=" + lastStatementBalanceDate +
                ", lastPaymentPosted=" + lastPaymentPosted +
                ", lastPaymentPostedDate=" + lastPaymentPostedDate +
                ", cashAdvanceLimit=" + cashAdvanceLimit +
                ", pointsAvailable=" + pointsAvailable +
                ", nextStatementClosingDate=" + nextStatementClosingDate +
                ", ttcLastSavedPayee=" + ttcLastSavedPayee +
                ", insuredStatus=" + insuredStatus +
                ", eBillingStatus=" + eBillingStatus +
                ", membershipFeeDesc='" + membershipFeeDesc + '\'' +
                ", auFee=" + auFee +
                ", productCodes='" + productCodes + '\'' +
                ", poCode='" + poCode + '\'' +
                ", arqCode='" + arqCode + '\'' +
                ", purchaseRate=" + purchaseRate +
                '}';
    }
}
