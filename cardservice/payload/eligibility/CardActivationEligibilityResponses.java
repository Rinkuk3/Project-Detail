package com.td.mbna.msec.midtier.cardservice.payload.eligibility;

import java.util.List;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class CardActivationEligibilityResponses extends BaseResponse {

	private static final long serialVersionUID = -8013877067737444049L;
    private List<CardActivationEligibilityResponse> cardActivationEligibilityResponses;

    public List<CardActivationEligibilityResponse> getCardActivationEligibilityResponses() {
        return cardActivationEligibilityResponses;
    }

    public void setCardActivationEligibilityResponses(List<CardActivationEligibilityResponse> cardActivationEligibilityResponses) {
        this.cardActivationEligibilityResponses = cardActivationEligibilityResponses;
    }
}
