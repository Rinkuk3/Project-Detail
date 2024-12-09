package com.td.mbna.msec.midtier.cardlock.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardControlResponse {

    @JsonProperty("cardAuthorizationStatus")
    private CardAuthorizationStatus cardAuthorizationStatus;

    public CardAuthorizationStatus getCardAuthorizationStatus() {
        return cardAuthorizationStatus;
    }

    public void setCardAuthorizationStatus(CardAuthorizationStatus cardAuthorizationStatus) {
        this.cardAuthorizationStatus = cardAuthorizationStatus;
    }
}
