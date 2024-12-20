package com.td.api.mbna.msec.midtier.mbnaparty;

import com.td.api.mbna.msec.midtier.mbnaparty.payload.ContactResponse;
import com.td.api.mbna.msec.midtier.mbnaparty.payload.PartyResponse;
import com.td.mbna.msec.midtier.account.payload.addaccount.VerifyCardRequest;

public interface MbnaParty {

    public PartyResponse verifyCreditCardDetails(VerifyCardRequest verifyCardRequest, String s);
    public ContactResponse getContactDetails(String roleId, String s);
}

