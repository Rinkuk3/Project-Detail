package com.td.mbna.msec.midtier.cardlock;

import com.td.mbna.msec.midtier.cardlock.payload.CardLockRequest;
import com.td.mbna.msec.midtier.cardlock.payload.CardLockResponse;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("midtierCardLockService")
public class CardLockServiceImpl implements CardLockService {

    @Autowired
    CardLockFacade cardLockFacade;

    @Override
    public CardLockResponse updateCardLockStatus(CardLockRequest cardLockRequest, String... token) {

        return cardLockFacade.updateCardStatus(cardLockRequest, token[0]);
    }

    @Override
    public CardLockResponse retrieveCardLockStatus(CardLockRequest cardLockRequest, String... token) {
        return cardLockFacade.getCardStatus(cardLockRequest, token[0]);
    }
}