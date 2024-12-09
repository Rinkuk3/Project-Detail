package com.td.mbna.msec.midtier.cardservice;

import com.td.mbna.msec.midtier.cardservice.payload.activatecard.ActivateCardRequest;
import com.td.mbna.msec.midtier.cardservice.payload.activatecard.ActivateCardResponse;
import com.td.mbna.msec.midtier.cardservice.payload.eligibility.CardActivationEligibilityRequests;
import com.td.mbna.msec.midtier.cardservice.payload.eligibility.CardActivationEligibilityResponses;
import com.td.mbna.msec.midtier.cardservice.payload.validatecpi.ValidateCPIRequest;
import com.td.mbna.msec.midtier.cardservice.payload.validatecpi.ValidateCPIResponse;

public interface CardService {
    ActivateCardResponse activateCard(ActivateCardRequest activateCardRequest,String... token);
    ValidateCPIResponse validateCPI(ValidateCPIRequest request,String... token);
    CardActivationEligibilityResponses findEligibility(CardActivationEligibilityRequests cardActivationEligibilityRequests,String... token);
}
