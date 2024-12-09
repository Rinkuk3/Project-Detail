package com.td.mbna.msec.midtier.cardservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.td.mbna.msec.midtier.cardservice.payload.activatecard.ActivateCardRequest;
import com.td.mbna.msec.midtier.cardservice.payload.activatecard.ActivateCardResponse;
import com.td.mbna.msec.midtier.cardservice.payload.eligibility.CardActivationEligibilityRequests;
import com.td.mbna.msec.midtier.cardservice.payload.eligibility.CardActivationEligibilityResponses;
import com.td.mbna.msec.midtier.cardservice.payload.validatecpi.ValidateCPIRequest;
import com.td.mbna.msec.midtier.cardservice.payload.validatecpi.ValidateCPIResponse;
import com.td.mbna.msec.midtier.util.perf.ProfileLog;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private ActivateCardOperation activationCardOperation;

    @Autowired
    private ValidateCPIOperation validateCPI;

    @Autowired
    private FindEligibilityOperation findEligibilityOperation;

    @Override
    @ProfileLog
    public ActivateCardResponse activateCard(ActivateCardRequest activateCardRequest, String... token)  {
        return activationCardOperation.invokeService(activateCardRequest, token);
    }

    @ProfileLog
    public ValidateCPIResponse validateCPI(final ValidateCPIRequest request, String... token)
    {
        return validateCPI.invokeService(request, token);
    }

    @Override
    @ProfileLog
    public CardActivationEligibilityResponses findEligibility(CardActivationEligibilityRequests cardActivationEligibilityRequests, String... token) {
        return findEligibilityOperation.invokeService(cardActivationEligibilityRequests, token);
    }


}
