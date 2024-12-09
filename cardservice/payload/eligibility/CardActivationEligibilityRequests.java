package com.td.mbna.msec.midtier.cardservice.payload.eligibility;

import com.td.mbna.msec.midtier.types.common.BaseRequest;

import java.util.List;

public class CardActivationEligibilityRequests  extends BaseRequest {

	private static final long serialVersionUID = -463730567388805770L;
    private List<CardActivationEligibilityRequest> cardActivationEligibilityRequests;

    public List<CardActivationEligibilityRequest> getCardActivationEligibilityRequests() {
        return cardActivationEligibilityRequests;
    }

    public void setCardActivationEligibilityRequests(List<CardActivationEligibilityRequest> cardActivationEligibilityRequests) {
        this.cardActivationEligibilityRequests = cardActivationEligibilityRequests;
    }
}
