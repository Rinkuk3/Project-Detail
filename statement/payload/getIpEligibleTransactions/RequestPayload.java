package com.td.mbna.msec.midtier.statement.payload.getIpEligibleTransactions;

import com.td.mbna.msec.midtier.types.common.CardHolderInfo;

import java.util.ArrayList;
import java.util.List;

public class RequestPayload {

    private List<CardHolderInfo> cardHolderInfos = new ArrayList<>();

    public List<CardHolderInfo> getCardHolderInfos() {
        return cardHolderInfos;
    }

    public void setCardHolderInfos(List<CardHolderInfo> cardHolderInfos) {
        this.cardHolderInfos = cardHolderInfos;
    }

}
