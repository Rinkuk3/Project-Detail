package com.td.mbna.msec.midtier.creditcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.td.mbna.msec.midtier.creditcard.payload.decreasecardlimit.DecreaseCardLimitRequest;
import com.td.mbna.msec.midtier.creditcard.payload.decreasecardlimit.DecreaseCardLimitResponse;
import com.td.mbna.msec.midtier.creditcard.payload.increasecardlimit.IncreaseCardLimitRequest;
import com.td.mbna.msec.midtier.creditcard.payload.increasecardlimit.IncreaseCardLimitResponse;
import com.td.mbna.msec.midtier.creditcard.payload.requestcheque.RequestChequeRequest;
import com.td.mbna.msec.midtier.creditcard.payload.requestcheque.RequestChequeResponse;
import com.td.mbna.msec.midtier.util.perf.ProfileLog;

@Component("creditCardServiceImpl")
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private DecreaseCardLimitOperation decreaseCardLimitOperation;

    @Autowired
    private IncreaseCardLimitOperation increaseCardLimitOperation;

    @Override
    public RequestChequeResponse requestCheque(RequestChequeRequest requestChequeRequest) {
        return null;
    }

    @Override
    @ProfileLog
    public IncreaseCardLimitResponse increaseCardLimit(IncreaseCardLimitRequest request, String... token) {
        IncreaseCardLimitResponse response = increaseCardLimitOperation.invokeService(request, token);
        return response;
    }

    @Override
    @ProfileLog
    public DecreaseCardLimitResponse decreaseCardLimit(DecreaseCardLimitRequest request, String... token) {
        DecreaseCardLimitResponse response = decreaseCardLimitOperation.invokeService(request, token);
        return response;
    }
}