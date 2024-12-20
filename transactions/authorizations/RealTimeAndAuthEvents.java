package com.td.api.mbcca.response.transactions.authorizations;

import java.util.List;

import com.td.api.mbcca.response.account.CreditCardAgreement;
import com.td.api.mbcca.response.transactions.authorizations.summary.AuthorizationEvent;


public class RealTimeAndAuthEvents {

    private CreditCardAgreement creditCardAgreement;

    private List<AuthorizationEvent> authorizationEvent;

    public CreditCardAgreement getRetrieveCreditCardAgreement() {
        return creditCardAgreement;
    }

    public void setRetrieveCreditCardAgreement(CreditCardAgreement creditCardAgreement) {
        this.creditCardAgreement = creditCardAgreement;
    }

    public List<AuthorizationEvent> getAuthorizationEvent() {
        return authorizationEvent;
    }

    public void setAuthorizationEvent(List<AuthorizationEvent> authorizationEvent) {
        this.authorizationEvent = authorizationEvent;
    }

    @Override
    public String toString() {
        return "RealTimeAndAuthEvents{" +
                "creditCardAgreement=" + creditCardAgreement +
                ", authorizationEvent=" + authorizationEvent +
                '}';
    }
}
