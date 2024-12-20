package com.td.api.ofm.request;

import java.util.Objects;

public class TSvcRetrieveCreditCardAgreementPartyFeatureListRq {

    private String cardNum;

    private String partyId;

    private String solicitationChannelTypeCd;

    private String accessChannelTypeCd;


    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getSolicitationChannelTypeCd() {
        return solicitationChannelTypeCd;
    }

    public void setSolicitationChannelTypeCd(String solicitationChannelTypeCd) {
        this.solicitationChannelTypeCd = solicitationChannelTypeCd;
    }

    public String getAccessChannelTypeCd() {
        return accessChannelTypeCd;
    }

    public void setAccessChannelTypeCd(String accessChannelTypeCd) {
        this.accessChannelTypeCd = accessChannelTypeCd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TSvcRetrieveCreditCardAgreementPartyFeatureListRq that = (TSvcRetrieveCreditCardAgreementPartyFeatureListRq) o;
        return Objects.equals(cardNum, that.cardNum) &&
                Objects.equals(partyId, that.partyId) &&
                Objects.equals(solicitationChannelTypeCd, that.solicitationChannelTypeCd) &&
                Objects.equals(accessChannelTypeCd, that.accessChannelTypeCd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNum, partyId, solicitationChannelTypeCd, accessChannelTypeCd);
    }

    @Override
    public String toString() {
        return "TSvcRetrieveCreditCardAgreementPartyFeatureListRq{" +
                "cardNum='" + cardNum + '\'' +
                ", partyId='" + partyId + '\'' +
                ", solicitationChannelTypeCd='" + solicitationChannelTypeCd + '\'' +
                ", accessChannelTypeCd='" + accessChannelTypeCd + '\'' +
                '}';
    }
}
