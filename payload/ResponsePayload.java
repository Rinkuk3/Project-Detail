package com.td.mbna.msec.midtier.cardlock.payload;

import com.td.mbna.msec.midtier.types.common.BaseResponse;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

public class ResponsePayload extends BaseResponse {

    private CardAuthorizationStatus cardAuthorizationStatus;

    private String confirmationNumber;

    private String status;

    private String customerId;

    public CardAuthorizationStatus getCardAuthorizationStatus() {
        return cardAuthorizationStatus;
    }

    public void setCardAuthorizationStatus(CardAuthorizationStatus cardAuthorizationStatus) {
        this.cardAuthorizationStatus = cardAuthorizationStatus;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResponsePayload)) return false;
        ResponsePayload that = (ResponsePayload) o;
        return getCardAuthorizationStatus().equals(that.getCardAuthorizationStatus()) && getConfirmationNumber().equals(that.getConfirmationNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardAuthorizationStatus(), getConfirmationNumber());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("cardAuthorizationStatus", cardAuthorizationStatus)
                .append("confirmationNumber", confirmationNumber)
                .toString();
    }
}
