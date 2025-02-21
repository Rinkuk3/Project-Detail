package com.td.api.mbcca.response.account;

import java.util.ArrayList;
import java.util.List;

import com.td.api.mbcca.shared.Pagination;
import com.td.api.mbcca.shared.Status;

public class RetrieveCreditCardAgreement {

    private Status status;
    private Pagination pagination;
    private CreditCardAgreement creditCardAgreement;
    private List<Card> card = new ArrayList<Card>();
    private List<CreditCardAgreementToParty> creditCardAgreementToParty = new ArrayList<CreditCardAgreementToParty>();
    private List<AuthorizationEvent> authorizationEvent = new ArrayList<AuthorizationEvent>();
    private List<PostedEvent> postedEvent = new ArrayList<PostedEvent>();
    private List<CycleInfo> cycleInfo = new ArrayList<CycleInfo>();
    private List<Score> score = new ArrayList<Score>();
    private List<Delinquency> delinquency = new ArrayList<Delinquency>();
    private List<RetailEvent> retailEvent = new ArrayList<RetailEvent>();
    private List<Accountstatus> accountStatus = new ArrayList<Accountstatus>();
    private List<CurrentBalanceInfo> currentBalanceInfo = new ArrayList<CurrentBalanceInfo>();
    private List<PromotionTransactionCategoryInfo> promotionTransactionCategoryInfo = new ArrayList<PromotionTransactionCategoryInfo>();
    private List<PreviousBalanceInfo> previousBalanceInfo = new ArrayList<PreviousBalanceInfo>();
    private List<InsuranceAgreement> insuranceAgreement = new ArrayList<InsuranceAgreement>();
    private List<AlertSetup> alertSetup = new ArrayList<AlertSetup>();

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public CreditCardAgreement getCreditCardAgreement() {
        return creditCardAgreement;
    }

    public void setCreditCardAgreement(CreditCardAgreement creditCardAgreement) {
        this.creditCardAgreement = creditCardAgreement;
    }

    public List<Card> getCard() {
        return card;
    }

    public void setCard(List<Card> card) {
        this.card = card;
    }

    public List<CreditCardAgreementToParty> getCreditCardAgreementToParty() {
        return creditCardAgreementToParty;
    }

    public void setCreditCardAgreementToParty(List<CreditCardAgreementToParty> creditCardAgreementToParty) {
        this.creditCardAgreementToParty = creditCardAgreementToParty;
    }

    public List<AuthorizationEvent> getAuthorizationEvent() {
        return authorizationEvent;
    }

    public void setAuthorizationEvent(List<AuthorizationEvent> authorizationEvent) {
        this.authorizationEvent = authorizationEvent;
    }

    public List<PostedEvent> getPostedEvent() {
        return postedEvent;
    }

    public void setPostedEvent(List<PostedEvent> postedEvent) {
        this.postedEvent = postedEvent;
    }

    public List<CycleInfo> getCycleInfo() {
        return cycleInfo;
    }

    public void setCycleInfo(List<CycleInfo> cycleInfo) {
        this.cycleInfo = cycleInfo;
    }

    public List<Score> getScore() {
        return score;
    }

    public void setScore(List<Score> score) {
        this.score = score;
    }

    public List<Delinquency> getDelinquency() {
        return delinquency;
    }

    public void setDelinquency(List<Delinquency> delinquency) {
        this.delinquency = delinquency;
    }

    public List<RetailEvent> getRetailEvent() {
        return retailEvent;
    }

    public void setRetailEvent(List<RetailEvent> retailEvent) {
        this.retailEvent = retailEvent;
    }

    public List<Accountstatus> getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(List<Accountstatus> accountStatus) {
        this.accountStatus = accountStatus;
    }

    public List<CurrentBalanceInfo> getCurrentBalanceInfo() {
        return currentBalanceInfo;
    }

    public void setCurrentBalanceInfo(List<CurrentBalanceInfo> currentBalanceInfo) {
        this.currentBalanceInfo = currentBalanceInfo;
    }

    public List<PromotionTransactionCategoryInfo> getPromotionTransactionCategoryInfo() {
        return promotionTransactionCategoryInfo;
    }

    public void setPromotionTransactionCategoryInfo(List<PromotionTransactionCategoryInfo> promotionTransactionCategoryInfo) {
        this.promotionTransactionCategoryInfo = promotionTransactionCategoryInfo;
    }

    public List<PreviousBalanceInfo> getPreviousBalanceInfo() {
        return previousBalanceInfo;
    }

    public void setPreviousBalanceInfo(List<PreviousBalanceInfo> previousBalanceInfo) {
        this.previousBalanceInfo = previousBalanceInfo;
    }

    public List<InsuranceAgreement> getInsuranceAgreement() {
        return insuranceAgreement;
    }

    public void setInsuranceAgreement(List<InsuranceAgreement> insuranceAgreement) {
        this.insuranceAgreement = insuranceAgreement;
    }

    public List<AlertSetup> getAlertSetup() {
        return alertSetup;
    }

    public void setAlertSetup(List<AlertSetup> alertSetup) {
        this.alertSetup = alertSetup;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RetrieveCreditCardAgreement.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("pagination");
        sb.append('=');
        sb.append(((this.pagination == null)?"<null>":this.pagination));
        sb.append(',');
        sb.append("creditCardAgreement");
        sb.append('=');
        sb.append(((this.creditCardAgreement == null)?"<null>":this.creditCardAgreement));
        sb.append(',');
        sb.append("card");
        sb.append('=');
        sb.append(((this.card == null)?"<null>":this.card));
        sb.append(',');
        sb.append("creditCardAgreementToParty");
        sb.append('=');
        sb.append(((this.creditCardAgreementToParty == null)?"<null>":this.creditCardAgreementToParty));
        sb.append(',');
        sb.append("authorizationEvent");
        sb.append('=');
        sb.append(((this.authorizationEvent == null)?"<null>":this.authorizationEvent));
        sb.append(',');
        sb.append("postedEvent");
        sb.append('=');
        sb.append(((this.postedEvent == null)?"<null>":this.postedEvent));
        sb.append(',');
        sb.append("cycleInfo");
        sb.append('=');
        sb.append(((this.cycleInfo == null)?"<null>":this.cycleInfo));
        sb.append(',');
        sb.append("score");
        sb.append('=');
        sb.append(((this.score == null)?"<null>":this.score));
        sb.append(',');
        sb.append("delinquency");
        sb.append('=');
        sb.append(((this.delinquency == null)?"<null>":this.delinquency));
        sb.append(',');
        sb.append("retailEvent");
        sb.append('=');
        sb.append(((this.retailEvent == null)?"<null>":this.retailEvent));
        sb.append(',');
        sb.append("accountStatus");
        sb.append('=');
        sb.append(((this.accountStatus == null)?"<null>":this.accountStatus));
        sb.append(',');
        sb.append("currentBalanceInfo");
        sb.append('=');
        sb.append(((this.currentBalanceInfo == null)?"<null>":this.currentBalanceInfo));
        sb.append(',');
        sb.append("promotionTransactionCategoryInfo");
        sb.append('=');
        sb.append(((this.promotionTransactionCategoryInfo == null)?"<null>":this.promotionTransactionCategoryInfo));
        sb.append(',');
        sb.append("previousBalanceInfo");
        sb.append('=');
        sb.append(((this.previousBalanceInfo == null)?"<null>":this.previousBalanceInfo));
        sb.append(',');
        sb.append("insuranceAgreement");
        sb.append('=');
        sb.append(((this.insuranceAgreement == null)?"<null>":this.insuranceAgreement));
        sb.append(',');
        sb.append("alertSetup");
        sb.append('=');
        sb.append(((this.alertSetup == null)?"<null>":this.alertSetup));
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
        result = ((result* 31)+((this.authorizationEvent == null)? 0 :this.authorizationEvent.hashCode()));
        result = ((result* 31)+((this.alertSetup == null)? 0 :this.alertSetup.hashCode()));
        result = ((result* 31)+((this.pagination == null)? 0 :this.pagination.hashCode()));
        result = ((result* 31)+((this.accountStatus == null)? 0 :this.accountStatus.hashCode()));
        result = ((result* 31)+((this.score == null)? 0 :this.score.hashCode()));
        result = ((result* 31)+((this.promotionTransactionCategoryInfo == null)? 0 :this.promotionTransactionCategoryInfo.hashCode()));
        result = ((result* 31)+((this.postedEvent == null)? 0 :this.postedEvent.hashCode()));
        result = ((result* 31)+((this.creditCardAgreement == null)? 0 :this.creditCardAgreement.hashCode()));
        result = ((result* 31)+((this.creditCardAgreementToParty == null)? 0 :this.creditCardAgreementToParty.hashCode()));
        result = ((result* 31)+((this.retailEvent == null)? 0 :this.retailEvent.hashCode()));
        result = ((result* 31)+((this.insuranceAgreement == null)? 0 :this.insuranceAgreement.hashCode()));
        result = ((result* 31)+((this.previousBalanceInfo == null)? 0 :this.previousBalanceInfo.hashCode()));
        result = ((result* 31)+((this.delinquency == null)? 0 :this.delinquency.hashCode()));
        result = ((result* 31)+((this.currentBalanceInfo == null)? 0 :this.currentBalanceInfo.hashCode()));
        result = ((result* 31)+((this.card == null)? 0 :this.card.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        result = ((result* 31)+((this.cycleInfo == null)? 0 :this.cycleInfo.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RetrieveCreditCardAgreement) == false) {
            return false;
        }
        RetrieveCreditCardAgreement rhs = ((RetrieveCreditCardAgreement) other);
        return ((((((((((((((((((this.authorizationEvent == rhs.authorizationEvent)||((this.authorizationEvent!= null)&&this.authorizationEvent.equals(rhs.authorizationEvent)))&&((this.alertSetup == rhs.alertSetup)||((this.alertSetup!= null)&&this.alertSetup.equals(rhs.alertSetup))))&&((this.pagination == rhs.pagination)||((this.pagination!= null)&&this.pagination.equals(rhs.pagination))))&&((this.accountStatus == rhs.accountStatus)||((this.accountStatus!= null)&&this.accountStatus.equals(rhs.accountStatus))))&&((this.score == rhs.score)||((this.score!= null)&&this.score.equals(rhs.score))))&&((this.promotionTransactionCategoryInfo == rhs.promotionTransactionCategoryInfo)||((this.promotionTransactionCategoryInfo!= null)&&this.promotionTransactionCategoryInfo.equals(rhs.promotionTransactionCategoryInfo))))&&((this.postedEvent == rhs.postedEvent)||((this.postedEvent!= null)&&this.postedEvent.equals(rhs.postedEvent))))&&((this.creditCardAgreement == rhs.creditCardAgreement)||((this.creditCardAgreement!= null)&&this.creditCardAgreement.equals(rhs.creditCardAgreement))))&&((this.creditCardAgreementToParty == rhs.creditCardAgreementToParty)||((this.creditCardAgreementToParty!= null)&&this.creditCardAgreementToParty.equals(rhs.creditCardAgreementToParty))))&&((this.retailEvent == rhs.retailEvent)||((this.retailEvent!= null)&&this.retailEvent.equals(rhs.retailEvent))))&&((this.insuranceAgreement == rhs.insuranceAgreement)||((this.insuranceAgreement!= null)&&this.insuranceAgreement.equals(rhs.insuranceAgreement))))&&((this.previousBalanceInfo == rhs.previousBalanceInfo)||((this.previousBalanceInfo!= null)&&this.previousBalanceInfo.equals(rhs.previousBalanceInfo))))&&((this.delinquency == rhs.delinquency)||((this.delinquency!= null)&&this.delinquency.equals(rhs.delinquency))))&&((this.currentBalanceInfo == rhs.currentBalanceInfo)||((this.currentBalanceInfo!= null)&&this.currentBalanceInfo.equals(rhs.currentBalanceInfo))))&&((this.card == rhs.card)||((this.card!= null)&&this.card.equals(rhs.card))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))))&&((this.cycleInfo == rhs.cycleInfo)||((this.cycleInfo!= null)&&this.cycleInfo.equals(rhs.cycleInfo))));
    }

}
