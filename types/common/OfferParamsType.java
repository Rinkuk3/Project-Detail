package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.JsonAdapter;
import com.td.mbna.msec.midtier.serializers.GsonDateDeSerializer;

public class OfferParamsType implements Serializable {

	private static final long serialVersionUID = 1L;
    private java.math.BigDecimal creditLimit;
    private Integer nextStatementClosingDay;
    private java.math.BigDecimal cashAdvanceLimit;
    private java.math.BigDecimal moneyPadAmount;
    private String groupCode;
    private String vipType;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long dateAccountOpened;
    private String clientProductCode;
    private Integer numberOfCards;
    private String tsysProductCode;
    private String mailCode;
    private List<AcctSnapshotStatusType> accountStatus = new ArrayList<AcctSnapshotStatusType>();
    private String paymentStatus;
    private java.math.BigDecimal availableCreditAmount;
    private java.math.BigDecimal cashAdvanceAvailable;
    private java.math.BigDecimal currentBalance;
    private java.math.BigDecimal totalMinimumPaymentDue;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long lastActivityPurchaseDate;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long totalMinPaymentDueDate;
    private java.math.BigDecimal outstandingMinPaymentDue;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long lastPaymentPostedDate;
    private String coverageType;
    private String optionSetId;
    private String policyStatus;
    private String ratesActive;
    private Integer consecutiveDaysPastDue;
    private String totalAmountPastDue;
    private java.math.BigDecimal pastDue30DaysAmount;
    private java.math.BigDecimal pastDue60DaysAmount;
    private java.math.BigDecimal pastDue90DaysAmount;
    private java.math.BigDecimal pastDue120DaysAmount;
    private java.math.BigDecimal pastDue150DaysAmount;
    private java.math.BigDecimal pastDue180DaysAmount;
    private java.math.BigDecimal pastDue210DaysAmount;
    private java.math.BigDecimal pastDue240DaysAmount;
    private java.math.BigDecimal overLimitAmount;
    private java.math.BigDecimal termsDisclosureMinPmtAmount;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long accountProductChangeDate;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long accountAccountClosedDate;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long accountCreditRevokedStatusDate;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long accountPotentialPurgeStatusDate;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long accountCollectionStatusDate;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long accountCredBureauStatusDate;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long accountSecureFraudStatusDate;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long accountClosedStatusDate;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long accountWatchStatusDate;
    private String disclosureGroup;

    public java.math.BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(java.math.BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Integer getNextStatementClosingDay() {
        return nextStatementClosingDay;
    }

    public void setNextStatementClosingDay(Integer nextStatementClosingDay) {
        this.nextStatementClosingDay = nextStatementClosingDay;
    }

    public java.math.BigDecimal getCashAdvanceLimit() {
        return cashAdvanceLimit;
    }

    public void setCashAdvanceLimit(java.math.BigDecimal cashAdvanceLimit) {
        this.cashAdvanceLimit = cashAdvanceLimit;
    }

    public java.math.BigDecimal getMoneyPadAmount() {
        return moneyPadAmount;
    }

    public void setMoneyPadAmount(java.math.BigDecimal moneyPadAmount) {
        this.moneyPadAmount = moneyPadAmount;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getVipType() {
        return vipType;
    }

    public void setVipType(String vipType) {
        this.vipType = vipType;
    }

    public Long getDateAccountOpened() {
        return dateAccountOpened;
    }

    public void setDateAccountOpened(Long dateAccountOpened) {
        this.dateAccountOpened = dateAccountOpened;
    }

    public String getClientProductCode() {
        return clientProductCode;
    }

    public void setClientProductCode(String clientProductCode) {
        this.clientProductCode = clientProductCode;
    }

    public Integer getNumberOfCards() {
        return numberOfCards;
    }

    public void setNumberOfCards(Integer numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

    public String getTsysProductCode() {
        return tsysProductCode;
    }

    public void setTsysProductCode(String tsysProductCode) {
        this.tsysProductCode = tsysProductCode;
    }

    public String getMailCode() {
        return mailCode;
    }

    public void setMailCode(String mailCode) {
        this.mailCode = mailCode;
    }

    public List<AcctSnapshotStatusType> getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(List<AcctSnapshotStatusType> accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public java.math.BigDecimal getAvailableCreditAmount() {
        return availableCreditAmount;
    }

    public void setAvailableCreditAmount(java.math.BigDecimal availableCreditAmount) {
        this.availableCreditAmount = availableCreditAmount;
    }

    public java.math.BigDecimal getCashAdvanceAvailable() {
        return cashAdvanceAvailable;
    }

    public void setCashAdvanceAvailable(java.math.BigDecimal cashAdvanceAvailable) {
        this.cashAdvanceAvailable = cashAdvanceAvailable;
    }

    public java.math.BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(java.math.BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public java.math.BigDecimal getTotalMinimumPaymentDue() {
        return totalMinimumPaymentDue;
    }

    public void setTotalMinimumPaymentDue(java.math.BigDecimal totalMinimumPaymentDue) {
        this.totalMinimumPaymentDue = totalMinimumPaymentDue;
    }

    public Long getLastActivityPurchaseDate() {
        return lastActivityPurchaseDate;
    }

    public void setLastActivityPurchaseDate(Long lastActivityPurchaseDate) {
        this.lastActivityPurchaseDate = lastActivityPurchaseDate;
    }

    public Long getTotalMinPaymentDueDate() {
        return totalMinPaymentDueDate;
    }

    public void setTotalMinPaymentDueDate(Long totalMinPaymentDueDate) {
        this.totalMinPaymentDueDate = totalMinPaymentDueDate;
    }

    public java.math.BigDecimal getOutstandingMinPaymentDue() {
        return outstandingMinPaymentDue;
    }

    public void setOutstandingMinPaymentDue(java.math.BigDecimal outstandingMinPaymentDue) {
        this.outstandingMinPaymentDue = outstandingMinPaymentDue;
    }

    public Long getLastPaymentPostedDate() {
        return lastPaymentPostedDate;
    }

    public void setLastPaymentPostedDate(Long lastPaymentPostedDate) {
        this.lastPaymentPostedDate = lastPaymentPostedDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(String coverageType) {
        this.coverageType = coverageType;
    }

    public String getOptionSetId() {
        return optionSetId;
    }

    public void setOptionSetId(String optionSetId) {
        this.optionSetId = optionSetId;
    }

    public String getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(String policyStatus) {
        this.policyStatus = policyStatus;
    }

    public String getRatesActive() {
        return ratesActive;
    }

    public void setRatesActive(String ratesActive) {
        this.ratesActive = ratesActive;
    }

    public Integer getConsecutiveDaysPastDue() {
        return consecutiveDaysPastDue;
    }

    public void setConsecutiveDaysPastDue(Integer consecutiveDaysPastDue) {
        this.consecutiveDaysPastDue = consecutiveDaysPastDue;
    }

    public String getTotalAmountPastDue() {
        return totalAmountPastDue;
    }

    public void setTotalAmountPastDue(String totalAmountPastDue) {
        this.totalAmountPastDue = totalAmountPastDue;
    }

    public java.math.BigDecimal getPastDue30DaysAmount() {
        return pastDue30DaysAmount;
    }

    public void setPastDue30DaysAmount(java.math.BigDecimal pastDue30DaysAmount) {
        this.pastDue30DaysAmount = pastDue30DaysAmount;
    }

    public java.math.BigDecimal getPastDue60DaysAmount() {
        return pastDue60DaysAmount;
    }

    public void setPastDue60DaysAmount(java.math.BigDecimal pastDue60DaysAmount) {
        this.pastDue60DaysAmount = pastDue60DaysAmount;
    }

    public java.math.BigDecimal getPastDue90DaysAmount() {
        return pastDue90DaysAmount;
    }

    public void setPastDue90DaysAmount(java.math.BigDecimal pastDue90DaysAmount) {
        this.pastDue90DaysAmount = pastDue90DaysAmount;
    }

    public java.math.BigDecimal getPastDue120DaysAmount() {
        return pastDue120DaysAmount;
    }

    public void setPastDue120DaysAmount(java.math.BigDecimal pastDue120DaysAmount) {
        this.pastDue120DaysAmount = pastDue120DaysAmount;
    }

    public java.math.BigDecimal getPastDue150DaysAmount() {
        return pastDue150DaysAmount;
    }

    public void setPastDue150DaysAmount(java.math.BigDecimal pastDue150DaysAmount) {
        this.pastDue150DaysAmount = pastDue150DaysAmount;
    }

    public java.math.BigDecimal getPastDue180DaysAmount() {
        return pastDue180DaysAmount;
    }

    public void setPastDue180DaysAmount(java.math.BigDecimal pastDue180DaysAmount) {
        this.pastDue180DaysAmount = pastDue180DaysAmount;
    }

    public java.math.BigDecimal getPastDue210DaysAmount() {
        return pastDue210DaysAmount;
    }

    public void setPastDue210DaysAmount(java.math.BigDecimal pastDue210DaysAmount) {
        this.pastDue210DaysAmount = pastDue210DaysAmount;
    }

    public java.math.BigDecimal getPastDue240DaysAmount() {
        return pastDue240DaysAmount;
    }

    public void setPastDue240DaysAmount(java.math.BigDecimal pastDue240DaysAmount) {
        this.pastDue240DaysAmount = pastDue240DaysAmount;
    }

    public java.math.BigDecimal getOverLimitAmount() {
        return overLimitAmount;
    }

    public void setOverLimitAmount(java.math.BigDecimal overLimitAmount) {
        this.overLimitAmount = overLimitAmount;
    }

    public java.math.BigDecimal getTermsDisclosureMinPmtAmount() {
        return termsDisclosureMinPmtAmount;
    }

    public void setTermsDisclosureMinPmtAmount(java.math.BigDecimal termsDisclosureMinPmtAmount) {
        this.termsDisclosureMinPmtAmount = termsDisclosureMinPmtAmount;
    }

    public Long getAccountProductChangeDate() {
        return accountProductChangeDate;
    }

    public void setAccountProductChangeDate(Long accountProductChangeDate) {
        this.accountProductChangeDate = accountProductChangeDate;
    }

    public Long getAccountAccountClosedDate() {
        return accountAccountClosedDate;
    }

    public void setAccountAccountClosedDate(Long accountAccountClosedDate) {
        this.accountAccountClosedDate = accountAccountClosedDate;
    }

    public Long getAccountCreditRevokedStatusDate() {
        return accountCreditRevokedStatusDate;
    }

    public void setAccountCreditRevokedStatusDate(Long accountCreditRevokedStatusDate) {
        this.accountCreditRevokedStatusDate = accountCreditRevokedStatusDate;
    }

    public Long getAccountPotentialPurgeStatusDate() {
        return accountPotentialPurgeStatusDate;
    }

    public void setAccountPotentialPurgeStatusDate(Long accountPotentialPurgeStatusDate) {
        this.accountPotentialPurgeStatusDate = accountPotentialPurgeStatusDate;
    }

    public Long getAccountCollectionStatusDate() {
        return accountCollectionStatusDate;
    }

    public void setAccountCollectionStatusDate(Long accountCollectionStatusDate) {
        this.accountCollectionStatusDate = accountCollectionStatusDate;
    }

    public Long getAccountCredBureauStatusDate() {
        return accountCredBureauStatusDate;
    }

    public void setAccountCredBureauStatusDate(Long accountCredBureauStatusDate) {
        this.accountCredBureauStatusDate = accountCredBureauStatusDate;
    }

    public Long getAccountSecureFraudStatusDate() {
        return accountSecureFraudStatusDate;
    }

    public void setAccountSecureFraudStatusDate(Long accountSecureFraudStatusDate) {
        this.accountSecureFraudStatusDate = accountSecureFraudStatusDate;
    }

    public Long getAccountClosedStatusDate() {
        return accountClosedStatusDate;
    }

    public void setAccountClosedStatusDate(Long accountClosedStatusDate) {
        this.accountClosedStatusDate = accountClosedStatusDate;
    }

    public Long getAccountWatchStatusDate() {
        return accountWatchStatusDate;
    }

    public void setAccountWatchStatusDate(Long accountWatchStatusDate) {
        this.accountWatchStatusDate = accountWatchStatusDate;
    }

    public String getDisclosureGroup() {
        return disclosureGroup;
    }

    public void setDisclosureGroup(String disclosureGroup) {
        this.disclosureGroup = disclosureGroup;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(OfferParamsType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("creditLimit");
        sb.append('=');
        sb.append(((this.creditLimit == null)?"<null>":this.creditLimit));
        sb.append(',');
        sb.append("nextStatementClosingDay");
        sb.append('=');
        sb.append(((this.nextStatementClosingDay == null)?"<null>":this.nextStatementClosingDay));
        sb.append(',');
        sb.append("cashAdvanceLimit");
        sb.append('=');
        sb.append(((this.cashAdvanceLimit == null)?"<null>":this.cashAdvanceLimit));
        sb.append(',');
        sb.append("moneyPadAmount");
        sb.append('=');
        sb.append(((this.moneyPadAmount == null)?"<null>":this.moneyPadAmount));
        sb.append(',');
        sb.append("groupCode");
        sb.append('=');
        sb.append(((this.groupCode == null)?"<null>":this.groupCode));
        sb.append(',');
        sb.append("vipType");
        sb.append('=');
        sb.append(((this.vipType == null)?"<null>":this.vipType));
        sb.append(',');
        sb.append("dateAccountOpened");
        sb.append('=');
        sb.append(((this.dateAccountOpened == null)?"<null>":this.dateAccountOpened));
        sb.append(',');
        sb.append("clientProductCode");
        sb.append('=');
        sb.append(((this.clientProductCode == null)?"<null>":this.clientProductCode));
        sb.append(',');
        sb.append("numberOfCards");
        sb.append('=');
        sb.append(((this.numberOfCards == null)?"<null>":this.numberOfCards));
        sb.append(',');
        sb.append("tsysProductCode");
        sb.append('=');
        sb.append(((this.tsysProductCode == null)?"<null>":this.tsysProductCode));
        sb.append(',');
        sb.append("mailCode");
        sb.append('=');
        sb.append(((this.mailCode == null)?"<null>":this.mailCode));
        sb.append(',');
        sb.append("accountStatus");
        sb.append('=');
        sb.append(((this.accountStatus == null)?"<null>":this.accountStatus));
        sb.append(',');
        sb.append("paymentStatus");
        sb.append('=');
        sb.append(((this.paymentStatus == null)?"<null>":this.paymentStatus));
        sb.append(',');
        sb.append("availableCreditAmount");
        sb.append('=');
        sb.append(((this.availableCreditAmount == null)?"<null>":this.availableCreditAmount));
        sb.append(',');
        sb.append("cashAdvanceAvailable");
        sb.append('=');
        sb.append(((this.cashAdvanceAvailable == null)?"<null>":this.cashAdvanceAvailable));
        sb.append(',');
        sb.append("currentBalance");
        sb.append('=');
        sb.append(((this.currentBalance == null)?"<null>":this.currentBalance));
        sb.append(',');
        sb.append("totalMinimumPaymentDue");
        sb.append('=');
        sb.append(((this.totalMinimumPaymentDue == null)?"<null>":this.totalMinimumPaymentDue));
        sb.append(',');
        sb.append("lastActivityPurchaseDate");
        sb.append('=');
        sb.append(((this.lastActivityPurchaseDate == null)?"<null>":this.lastActivityPurchaseDate));
        sb.append(',');
        sb.append("totalMinPaymentDueDate");
        sb.append('=');
        sb.append(((this.totalMinPaymentDueDate == null)?"<null>":this.totalMinPaymentDueDate));
        sb.append(',');
        sb.append("outstandingMinPaymentDue");
        sb.append('=');
        sb.append(((this.outstandingMinPaymentDue == null)?"<null>":this.outstandingMinPaymentDue));
        sb.append(',');
        sb.append("lastPaymentPostedDate");
        sb.append('=');
        sb.append(((this.lastPaymentPostedDate == null)?"<null>":this.lastPaymentPostedDate));
        sb.append(',');
        sb.append("coverageType");
        sb.append('=');
        sb.append(((this.coverageType == null)?"<null>":this.coverageType));
        sb.append(',');
        sb.append("optionSetId");
        sb.append('=');
        sb.append(((this.optionSetId == null)?"<null>":this.optionSetId));
        sb.append(',');
        sb.append("policyStatus");
        sb.append('=');
        sb.append(((this.policyStatus == null)?"<null>":this.policyStatus));
        sb.append(',');
        sb.append("ratesActive");
        sb.append('=');
        sb.append(((this.ratesActive == null)?"<null>":this.ratesActive));
        sb.append(',');
        sb.append("consecutiveDaysPastDue");
        sb.append('=');
        sb.append(((this.consecutiveDaysPastDue == null)?"<null>":this.consecutiveDaysPastDue));
        sb.append(',');
        sb.append("totalAmountPastDue");
        sb.append('=');
        sb.append(((this.totalAmountPastDue == null)?"<null>":this.totalAmountPastDue));
        sb.append(',');
        sb.append("pastDue30DaysAmount");
        sb.append('=');
        sb.append(((this.pastDue30DaysAmount == null)?"<null>":this.pastDue30DaysAmount));
        sb.append(',');
        sb.append("pastDue60DaysAmount");
        sb.append('=');
        sb.append(((this.pastDue60DaysAmount == null)?"<null>":this.pastDue60DaysAmount));
        sb.append(',');
        sb.append("pastDue90DaysAmount");
        sb.append('=');
        sb.append(((this.pastDue90DaysAmount == null)?"<null>":this.pastDue90DaysAmount));
        sb.append(',');
        sb.append("pastDue120DaysAmount");
        sb.append('=');
        sb.append(((this.pastDue120DaysAmount == null)?"<null>":this.pastDue120DaysAmount));
        sb.append(',');
        sb.append("pastDue150DaysAmount");
        sb.append('=');
        sb.append(((this.pastDue150DaysAmount == null)?"<null>":this.pastDue150DaysAmount));
        sb.append(',');
        sb.append("pastDue180DaysAmount");
        sb.append('=');
        sb.append(((this.pastDue180DaysAmount == null)?"<null>":this.pastDue180DaysAmount));
        sb.append(',');
        sb.append("pastDue210DaysAmount");
        sb.append('=');
        sb.append(((this.pastDue210DaysAmount == null)?"<null>":this.pastDue210DaysAmount));
        sb.append(',');
        sb.append("pastDue240DaysAmount");
        sb.append('=');
        sb.append(((this.pastDue240DaysAmount == null)?"<null>":this.pastDue240DaysAmount));
        sb.append(',');
        sb.append("overLimitAmount");
        sb.append('=');
        sb.append(((this.overLimitAmount == null)?"<null>":this.overLimitAmount));
        sb.append(',');
        sb.append("termsDisclosureMinPmtAmount");
        sb.append('=');
        sb.append(((this.termsDisclosureMinPmtAmount == null)?"<null>":this.termsDisclosureMinPmtAmount));
        sb.append(',');
        sb.append("accountProductChangeDate");
        sb.append('=');
        sb.append(((this.accountProductChangeDate == null)?"<null>":this.accountProductChangeDate));
        sb.append(',');
        sb.append("accountAccountClosedDate");
        sb.append('=');
        sb.append(((this.accountAccountClosedDate == null)?"<null>":this.accountAccountClosedDate));
        sb.append(',');
        sb.append("accountCreditRevokedStatusDate");
        sb.append('=');
        sb.append(((this.accountCreditRevokedStatusDate == null)?"<null>":this.accountCreditRevokedStatusDate));
        sb.append(',');
        sb.append("accountPotentialPurgeStatusDate");
        sb.append('=');
        sb.append(((this.accountPotentialPurgeStatusDate == null)?"<null>":this.accountPotentialPurgeStatusDate));
        sb.append(',');
        sb.append("accountCollectionStatusDate");
        sb.append('=');
        sb.append(((this.accountCollectionStatusDate == null)?"<null>":this.accountCollectionStatusDate));
        sb.append(',');
        sb.append("accountCredBureauStatusDate");
        sb.append('=');
        sb.append(((this.accountCredBureauStatusDate == null)?"<null>":this.accountCredBureauStatusDate));
        sb.append(',');
        sb.append("accountSecureFraudStatusDate");
        sb.append('=');
        sb.append(((this.accountSecureFraudStatusDate == null)?"<null>":this.accountSecureFraudStatusDate));
        sb.append(',');
        sb.append("accountClosedStatusDate");
        sb.append('=');
        sb.append(((this.accountClosedStatusDate == null)?"<null>":this.accountClosedStatusDate));
        sb.append(',');
        sb.append("accountWatchStatusDate");
        sb.append('=');
        sb.append(((this.accountWatchStatusDate == null)?"<null>":this.accountWatchStatusDate));
        sb.append(',');
        sb.append("disclosureGroup");
        sb.append('=');
        sb.append(((this.disclosureGroup == null)?"<null>":this.disclosureGroup));
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
        result = ((result* 31)+((this.accountAccountClosedDate == null)? 0 :this.accountAccountClosedDate.hashCode()));
        result = ((result* 31)+((this.lastPaymentPostedDate == null)? 0 :this.lastPaymentPostedDate.hashCode()));
        result = ((result* 31)+((this.totalAmountPastDue == null)? 0 :this.totalAmountPastDue.hashCode()));
        result = ((result* 31)+((this.pastDue240DaysAmount == null)? 0 :this.pastDue240DaysAmount.hashCode()));
        result = ((result* 31)+((this.accountClosedStatusDate == null)? 0 :this.accountClosedStatusDate.hashCode()));
        result = ((result* 31)+((this.cashAdvanceLimit == null)? 0 :this.cashAdvanceLimit.hashCode()));
        result = ((result* 31)+((this.accountCollectionStatusDate == null)? 0 :this.accountCollectionStatusDate.hashCode()));
        result = ((result* 31)+((this.totalMinimumPaymentDue == null)? 0 :this.totalMinimumPaymentDue.hashCode()));
        result = ((result* 31)+((this.policyStatus == null)? 0 :this.policyStatus.hashCode()));
        result = ((result* 31)+((this.clientProductCode == null)? 0 :this.clientProductCode.hashCode()));
        result = ((result* 31)+((this.accountStatus == null)? 0 :this.accountStatus.hashCode()));
        result = ((result* 31)+((this.accountPotentialPurgeStatusDate == null)? 0 :this.accountPotentialPurgeStatusDate.hashCode()));
        result = ((result* 31)+((this.creditLimit == null)? 0 :this.creditLimit.hashCode()));
        result = ((result* 31)+((this.optionSetId == null)? 0 :this.optionSetId.hashCode()));
        result = ((result* 31)+((this.consecutiveDaysPastDue == null)? 0 :this.consecutiveDaysPastDue.hashCode()));
        result = ((result* 31)+((this.paymentStatus == null)? 0 :this.paymentStatus.hashCode()));
        result = ((result* 31)+((this.groupCode == null)? 0 :this.groupCode.hashCode()));
        result = ((result* 31)+((this.mailCode == null)? 0 :this.mailCode.hashCode()));
        result = ((result* 31)+((this.overLimitAmount == null)? 0 :this.overLimitAmount.hashCode()));
        result = ((result* 31)+((this.tsysProductCode == null)? 0 :this.tsysProductCode.hashCode()));
        result = ((result* 31)+((this.availableCreditAmount == null)? 0 :this.availableCreditAmount.hashCode()));
        result = ((result* 31)+((this.pastDue90DaysAmount == null)? 0 :this.pastDue90DaysAmount.hashCode()));
        result = ((result* 31)+((this.nextStatementClosingDay == null)? 0 :this.nextStatementClosingDay.hashCode()));
        result = ((result* 31)+((this.lastActivityPurchaseDate == null)? 0 :this.lastActivityPurchaseDate.hashCode()));
        result = ((result* 31)+((this.accountCredBureauStatusDate == null)? 0 :this.accountCredBureauStatusDate.hashCode()));
        result = ((result* 31)+((this.disclosureGroup == null)? 0 :this.disclosureGroup.hashCode()));
        result = ((result* 31)+((this.currentBalance == null)? 0 :this.currentBalance.hashCode()));
        result = ((result* 31)+((this.vipType == null)? 0 :this.vipType.hashCode()));
        result = ((result* 31)+((this.accountCreditRevokedStatusDate == null)? 0 :this.accountCreditRevokedStatusDate.hashCode()));
        result = ((result* 31)+((this.totalMinPaymentDueDate == null)? 0 :this.totalMinPaymentDueDate.hashCode()));
        result = ((result* 31)+((this.pastDue120DaysAmount == null)? 0 :this.pastDue120DaysAmount.hashCode()));
        result = ((result* 31)+((this.moneyPadAmount == null)? 0 :this.moneyPadAmount.hashCode()));
        result = ((result* 31)+((this.outstandingMinPaymentDue == null)? 0 :this.outstandingMinPaymentDue.hashCode()));
        result = ((result* 31)+((this.termsDisclosureMinPmtAmount == null)? 0 :this.termsDisclosureMinPmtAmount.hashCode()));
        result = ((result* 31)+((this.coverageType == null)? 0 :this.coverageType.hashCode()));
        result = ((result* 31)+((this.pastDue30DaysAmount == null)? 0 :this.pastDue30DaysAmount.hashCode()));
        result = ((result* 31)+((this.accountWatchStatusDate == null)? 0 :this.accountWatchStatusDate.hashCode()));
        result = ((result* 31)+((this.accountProductChangeDate == null)? 0 :this.accountProductChangeDate.hashCode()));
        result = ((result* 31)+((this.pastDue150DaysAmount == null)? 0 :this.pastDue150DaysAmount.hashCode()));
        result = ((result* 31)+((this.pastDue210DaysAmount == null)? 0 :this.pastDue210DaysAmount.hashCode()));
        result = ((result* 31)+((this.pastDue180DaysAmount == null)? 0 :this.pastDue180DaysAmount.hashCode()));
        result = ((result* 31)+((this.dateAccountOpened == null)? 0 :this.dateAccountOpened.hashCode()));
        result = ((result* 31)+((this.cashAdvanceAvailable == null)? 0 :this.cashAdvanceAvailable.hashCode()));
        result = ((result* 31)+((this.numberOfCards == null)? 0 :this.numberOfCards.hashCode()));
        result = ((result* 31)+((this.ratesActive == null)? 0 :this.ratesActive.hashCode()));
        result = ((result* 31)+((this.accountSecureFraudStatusDate == null)? 0 :this.accountSecureFraudStatusDate.hashCode()));
        result = ((result* 31)+((this.pastDue60DaysAmount == null)? 0 :this.pastDue60DaysAmount.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OfferParamsType) == false) {
            return false;
        }
        OfferParamsType rhs = ((OfferParamsType) other);
        return ((((((((((((((((((((((((((((((((((((((((((((((((this.accountAccountClosedDate == rhs.accountAccountClosedDate)||((this.accountAccountClosedDate!= null)&&this.accountAccountClosedDate.equals(rhs.accountAccountClosedDate)))&&((this.lastPaymentPostedDate == rhs.lastPaymentPostedDate)||((this.lastPaymentPostedDate!= null)&&this.lastPaymentPostedDate.equals(rhs.lastPaymentPostedDate))))&&((this.totalAmountPastDue == rhs.totalAmountPastDue)||((this.totalAmountPastDue!= null)&&this.totalAmountPastDue.equals(rhs.totalAmountPastDue))))&&((this.pastDue240DaysAmount == rhs.pastDue240DaysAmount)||((this.pastDue240DaysAmount!= null)&&this.pastDue240DaysAmount.equals(rhs.pastDue240DaysAmount))))&&((this.accountClosedStatusDate == rhs.accountClosedStatusDate)||((this.accountClosedStatusDate!= null)&&this.accountClosedStatusDate.equals(rhs.accountClosedStatusDate))))&&((this.cashAdvanceLimit == rhs.cashAdvanceLimit)||((this.cashAdvanceLimit!= null)&&this.cashAdvanceLimit.equals(rhs.cashAdvanceLimit))))&&((this.accountCollectionStatusDate == rhs.accountCollectionStatusDate)||((this.accountCollectionStatusDate!= null)&&this.accountCollectionStatusDate.equals(rhs.accountCollectionStatusDate))))&&((this.totalMinimumPaymentDue == rhs.totalMinimumPaymentDue)||((this.totalMinimumPaymentDue!= null)&&this.totalMinimumPaymentDue.equals(rhs.totalMinimumPaymentDue))))&&((this.policyStatus == rhs.policyStatus)||((this.policyStatus!= null)&&this.policyStatus.equals(rhs.policyStatus))))&&((this.clientProductCode == rhs.clientProductCode)||((this.clientProductCode!= null)&&this.clientProductCode.equals(rhs.clientProductCode))))&&((this.accountStatus == rhs.accountStatus)||((this.accountStatus!= null)&&this.accountStatus.equals(rhs.accountStatus))))&&((this.accountPotentialPurgeStatusDate == rhs.accountPotentialPurgeStatusDate)||((this.accountPotentialPurgeStatusDate!= null)&&this.accountPotentialPurgeStatusDate.equals(rhs.accountPotentialPurgeStatusDate))))&&((this.creditLimit == rhs.creditLimit)||((this.creditLimit!= null)&&this.creditLimit.equals(rhs.creditLimit))))&&((this.optionSetId == rhs.optionSetId)||((this.optionSetId!= null)&&this.optionSetId.equals(rhs.optionSetId))))&&((this.consecutiveDaysPastDue == rhs.consecutiveDaysPastDue)||((this.consecutiveDaysPastDue!= null)&&this.consecutiveDaysPastDue.equals(rhs.consecutiveDaysPastDue))))&&((this.paymentStatus == rhs.paymentStatus)||((this.paymentStatus!= null)&&this.paymentStatus.equals(rhs.paymentStatus))))&&((this.groupCode == rhs.groupCode)||((this.groupCode!= null)&&this.groupCode.equals(rhs.groupCode))))&&((this.mailCode == rhs.mailCode)||((this.mailCode!= null)&&this.mailCode.equals(rhs.mailCode))))&&((this.overLimitAmount == rhs.overLimitAmount)||((this.overLimitAmount!= null)&&this.overLimitAmount.equals(rhs.overLimitAmount))))&&((this.tsysProductCode == rhs.tsysProductCode)||((this.tsysProductCode!= null)&&this.tsysProductCode.equals(rhs.tsysProductCode))))&&((this.availableCreditAmount == rhs.availableCreditAmount)||((this.availableCreditAmount!= null)&&this.availableCreditAmount.equals(rhs.availableCreditAmount))))&&((this.pastDue90DaysAmount == rhs.pastDue90DaysAmount)||((this.pastDue90DaysAmount!= null)&&this.pastDue90DaysAmount.equals(rhs.pastDue90DaysAmount))))&&((this.nextStatementClosingDay == rhs.nextStatementClosingDay)||((this.nextStatementClosingDay!= null)&&this.nextStatementClosingDay.equals(rhs.nextStatementClosingDay))))&&((this.lastActivityPurchaseDate == rhs.lastActivityPurchaseDate)||((this.lastActivityPurchaseDate!= null)&&this.lastActivityPurchaseDate.equals(rhs.lastActivityPurchaseDate))))&&((this.accountCredBureauStatusDate == rhs.accountCredBureauStatusDate)||((this.accountCredBureauStatusDate!= null)&&this.accountCredBureauStatusDate.equals(rhs.accountCredBureauStatusDate))))&&((this.disclosureGroup == rhs.disclosureGroup)||((this.disclosureGroup!= null)&&this.disclosureGroup.equals(rhs.disclosureGroup))))&&((this.currentBalance == rhs.currentBalance)||((this.currentBalance!= null)&&this.currentBalance.equals(rhs.currentBalance))))&&((this.vipType == rhs.vipType)||((this.vipType!= null)&&this.vipType.equals(rhs.vipType))))&&((this.accountCreditRevokedStatusDate == rhs.accountCreditRevokedStatusDate)||((this.accountCreditRevokedStatusDate!= null)&&this.accountCreditRevokedStatusDate.equals(rhs.accountCreditRevokedStatusDate))))&&((this.totalMinPaymentDueDate == rhs.totalMinPaymentDueDate)||((this.totalMinPaymentDueDate!= null)&&this.totalMinPaymentDueDate.equals(rhs.totalMinPaymentDueDate))))&&((this.pastDue120DaysAmount == rhs.pastDue120DaysAmount)||((this.pastDue120DaysAmount!= null)&&this.pastDue120DaysAmount.equals(rhs.pastDue120DaysAmount))))&&((this.moneyPadAmount == rhs.moneyPadAmount)||((this.moneyPadAmount!= null)&&this.moneyPadAmount.equals(rhs.moneyPadAmount))))&&((this.outstandingMinPaymentDue == rhs.outstandingMinPaymentDue)||((this.outstandingMinPaymentDue!= null)&&this.outstandingMinPaymentDue.equals(rhs.outstandingMinPaymentDue))))&&((this.termsDisclosureMinPmtAmount == rhs.termsDisclosureMinPmtAmount)||((this.termsDisclosureMinPmtAmount!= null)&&this.termsDisclosureMinPmtAmount.equals(rhs.termsDisclosureMinPmtAmount))))&&((this.coverageType == rhs.coverageType)||((this.coverageType!= null)&&this.coverageType.equals(rhs.coverageType))))&&((this.pastDue30DaysAmount == rhs.pastDue30DaysAmount)||((this.pastDue30DaysAmount!= null)&&this.pastDue30DaysAmount.equals(rhs.pastDue30DaysAmount))))&&((this.accountWatchStatusDate == rhs.accountWatchStatusDate)||((this.accountWatchStatusDate!= null)&&this.accountWatchStatusDate.equals(rhs.accountWatchStatusDate))))&&((this.accountProductChangeDate == rhs.accountProductChangeDate)||((this.accountProductChangeDate!= null)&&this.accountProductChangeDate.equals(rhs.accountProductChangeDate))))&&((this.pastDue150DaysAmount == rhs.pastDue150DaysAmount)||((this.pastDue150DaysAmount!= null)&&this.pastDue150DaysAmount.equals(rhs.pastDue150DaysAmount))))&&((this.pastDue210DaysAmount == rhs.pastDue210DaysAmount)||((this.pastDue210DaysAmount!= null)&&this.pastDue210DaysAmount.equals(rhs.pastDue210DaysAmount))))&&((this.pastDue180DaysAmount == rhs.pastDue180DaysAmount)||((this.pastDue180DaysAmount!= null)&&this.pastDue180DaysAmount.equals(rhs.pastDue180DaysAmount))))&&((this.dateAccountOpened == rhs.dateAccountOpened)||((this.dateAccountOpened!= null)&&this.dateAccountOpened.equals(rhs.dateAccountOpened))))&&((this.cashAdvanceAvailable == rhs.cashAdvanceAvailable)||((this.cashAdvanceAvailable!= null)&&this.cashAdvanceAvailable.equals(rhs.cashAdvanceAvailable))))&&((this.numberOfCards == rhs.numberOfCards)||((this.numberOfCards!= null)&&this.numberOfCards.equals(rhs.numberOfCards))))&&((this.ratesActive == rhs.ratesActive)||((this.ratesActive!= null)&&this.ratesActive.equals(rhs.ratesActive))))&&((this.accountSecureFraudStatusDate == rhs.accountSecureFraudStatusDate)||((this.accountSecureFraudStatusDate!= null)&&this.accountSecureFraudStatusDate.equals(rhs.accountSecureFraudStatusDate))))&&((this.pastDue60DaysAmount == rhs.pastDue60DaysAmount)||((this.pastDue60DaysAmount!= null)&&this.pastDue60DaysAmount.equals(rhs.pastDue60DaysAmount))));
    }

}
