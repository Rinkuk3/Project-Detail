package com.td.mbna.msec.midtier.statement.payload.getStatementActivity;

import java.util.List;

import com.td.mbna.msec.midtier.types.common.CardHolderInfo;

public class RequestPayload {

    private String statementClosingDate;

    private String statementPaymentDueDate;
    
    private List<CardHolderInfo> cardHolderInfos = null;

    public String getStatementClosingDate() {
        return statementClosingDate;
    }

    public void setStatementClosingDate(String statementClosingDate) {
        this.statementClosingDate = statementClosingDate;
    }

    public List<CardHolderInfo> getCardHolderInfos() {
        return cardHolderInfos;
    }

    public void setCardHolderInfos(List<CardHolderInfo> cardHolderInfos) {
        this.cardHolderInfos = cardHolderInfos;
    }

    public String getStatementPaymentDueDate() {
        return statementPaymentDueDate;
    }

    public void setStatementPaymentDueDate(String statementPaymentDueDate) {
        this.statementPaymentDueDate = statementPaymentDueDate;
    }
}
