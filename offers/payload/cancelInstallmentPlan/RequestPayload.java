package com.td.mbna.msec.midtier.offers.payload.cancelInstallmentPlan;

import com.td.mbna.msec.midtier.types.common.CardType;

import java.math.BigDecimal;
import java.util.Objects;

public class RequestPayload {

    private String eventId = "";
    private String ipPaymentOptionFeatureDate = "";
    private String nickName = "";
    private BigDecimal amount;
    private BigDecimal interestRate;
    private BigDecimal fee;
    private BigDecimal balanceOfIp;
    private String statementDataDt = "";
    private String postedDate = "";
    private Integer postedTime = 0;
    private String txLevelProcessingFeatureId = "";
    private CardType cardType;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getIpPaymentOptionFeatureDate() {
        return ipPaymentOptionFeatureDate;
    }

    public void setIpPaymentOptionFeatureDate(String ipPaymentOptionFeatureDate) {
        this.ipPaymentOptionFeatureDate = ipPaymentOptionFeatureDate;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getBalanceOfIp() {
        return balanceOfIp;
    }

    public void setBalanceOfIp(BigDecimal balanceOfIp) {
        this.balanceOfIp = balanceOfIp;
    }

    public String getStatementDataDt() {
        return statementDataDt;
    }

    public void setStatementDataDt(String statementDataDt) {
        this.statementDataDt = statementDataDt;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public Integer getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(Integer postedTime) {
        this.postedTime = postedTime;
    }

    public String getTxLevelProcessingFeatureId() {
        return txLevelProcessingFeatureId;
    }

    public void setTxLevelProcessingFeatureId(String txLevelProcessingFeatureId) {
        this.txLevelProcessingFeatureId = txLevelProcessingFeatureId;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return "RequestPayload{" +
                "eventId='" + eventId + '\'' +
                ", ipPaymentOptionFeatureDate='" + ipPaymentOptionFeatureDate + '\'' +
                ", nickName='" + nickName + '\'' +
                ", amount=" + amount +
                ", interestRate=" + interestRate +
                ", fee=" + fee +
                ", balanceOfIp=" + balanceOfIp +
                ", statementDataDt='" + statementDataDt + '\'' +
                ", postedDate='" + postedDate + '\'' +
                ", postedTime=" + postedTime +
                ", txLevelProcessingFeatureId='" + txLevelProcessingFeatureId + '\'' +
                ", cardType=" + cardType +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestPayload that = (RequestPayload) o;
        return Objects.equals(eventId, that.eventId) &&
                Objects.equals(ipPaymentOptionFeatureDate, that.ipPaymentOptionFeatureDate) &&
                Objects.equals(nickName, that.nickName) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(interestRate, that.interestRate) &&
                Objects.equals(fee, that.fee) &&
                Objects.equals(balanceOfIp, that.balanceOfIp) &&
                Objects.equals(statementDataDt, that.statementDataDt) &&
                Objects.equals(postedDate, that.postedDate) &&
                Objects.equals(postedTime, that.postedTime) &&
                Objects.equals(txLevelProcessingFeatureId, that.txLevelProcessingFeatureId) &&
                cardType == that.cardType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, ipPaymentOptionFeatureDate, nickName, amount, interestRate, fee, balanceOfIp, statementDataDt, postedDate, postedTime, txLevelProcessingFeatureId, cardType);
    }
}
