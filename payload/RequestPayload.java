package com.td.mbna.msec.midtier.cardlock.payload;

import com.td.mbna.msec.midtier.types.common.BaseRequest;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

public class RequestPayload extends BaseRequest {

    private CardAuthorizationStatus cardAuthorizationStatus;

    private String accountId;


    public CardAuthorizationStatus getCardAuthorizationStatus() {
        return cardAuthorizationStatus;
    }

    public void setCardAuthorizationStatus(CardAuthorizationStatus cardAuthorizationStatus) {
        this.cardAuthorizationStatus = cardAuthorizationStatus;
    }


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestPayload)) return false;
        if (!super.equals(o)) return false;
        RequestPayload that = (RequestPayload) o;
        return Objects.equals(getCardAuthorizationStatus(), that.getCardAuthorizationStatus()) && Objects.equals(getAccountId(), that.getAccountId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCardAuthorizationStatus(), getAccountId());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("cardAuthorizationStatus", cardAuthorizationStatus)
                .append("accountId", accountId)
                .append("custId", custId)
                .append("auditInfo", auditInfo)
                .append("aliasCustId", aliasCustId)
                .append("acctNum", acctNum)
                .append("acctType", acctType)
                .append("languagePref", languagePref)
                .append("reserved1", reserved1)
                .append("custInterface", custInterface)
                .append("isPrimaryUser", isPrimaryUser)
                .append("isMultiCard", isMultiCard)
                .append("cardNum", cardNum)
                .append("sessionInfo", sessionInfo)
                .toString();
    }
}
