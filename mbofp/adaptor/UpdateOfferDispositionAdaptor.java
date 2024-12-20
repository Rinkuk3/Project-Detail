package com.td.mbna.msec.midtier.mbofp.adaptor;

import com.td.api.mbofp.request.updateofferdisposition.*;
import com.td.mbna.msec.midtier.util.services.MSECConstants;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UpdateOfferDispositionAdaptor extends MbnaOfpAdaptor {

    public UpdateOfferDispositionRequest getRequest(Map<String, Object> params) {
        Party party = new Party();
        party.setRoleCd((String) params.get(PARAM_ROLECD));

        AgreementIdentification agreementIdentification = new AgreementIdentification();
        agreementIdentification.setTypeCd(TYPECD_ACCOUNT);
        agreementIdentification.setIdentifierVal((String) params.get(PARAM_ACCT_ID));

        PromotionOfferToAgreement promotionOfferToAgreement = new PromotionOfferToAgreement();
        promotionOfferToAgreement.setAgreementIdentification(agreementIdentification);

        PartyResponse partyResponse = new PartyResponse();
        partyResponse.setParty(party);
        partyResponse.setPromotionOfferToAgreement(promotionOfferToAgreement);
        partyResponse.setTypeCd(TYPECD_SOLD);
        partyResponse.setSolicitationChannelTypeCd(MSECConstants.INTERNET_SECURE);
        partyResponse.setAccessChannelTypeCd(MSECConstants.ONLINE_SECURE_SITE);

        UpdateOfferDispositionRequest request = new UpdateOfferDispositionRequest();
        request.setPartyResponse(partyResponse);
        return request;
    }
	
}
