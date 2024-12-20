package com.td.mbna.msec.midtier.mbnaad;

import com.td.mbna.msec.midtier.cardreplacement.payload.replacecard.ReplaceCardRequest;
import com.td.mbna.msec.midtier.cardreplacement.payload.replacecard.ReplaceCardResponse;
import com.td.mbna.msec.midtier.cardservice.payload.activatecard.ActivateCardResponse;
import com.td.mbna.msec.midtier.cardservice.payload.validatecpi.ValidateCPIResponse;
import com.td.mbna.msec.midtier.mbnaad.exception.MBNAException;
import com.td.mbna.msec.midtier.mbnaad.request.response.RetrieveAccessCardListRs;
import com.td.mbna.msec.midtier.mbnaad.request.response.accesscard.RetrieveAccessCard;
import com.td.mbna.msec.midtier.pinmanagement.payload.changepin.ChangePinResponse;
import com.td.mbna.msec.midtier.pinmanagement.payload.getpin.GetPinResponse;
import com.td.mbna.msec.midtier.pinmanagement.payload.unlockpin.UnblockPinResponse;

public interface MbnaAd {

    public RetrieveAccessCardListRs retrieveChipCardInfo(String connectId, String cardNumber, String partyKey, String token);
    public RetrieveAccessCard retrieveAccessCardInfo(String connectId, String cardNumber, String token);
    public GetPinResponse viewPin(String connectId, String cardNumber, String partyKey, String token);
    public ChangePinResponse updatePin(String connectId, String cardNumber, String encryptedPin, String partyKey, String token);
    public UnblockPinResponse unblockPin(String connectId, String cardNumber, String partyKey, String token, String seqNumber, Boolean allowPinChangeInd);
    public ActivateCardResponse activateCard(String connectId, String cardNumber, String partyKey,String token);
    public Boolean issueCardForAU(com.mbnaweb.xsd.msgs.customerprofile.AddAuthorizedUserRequest addAuthorizedUserRequest, com.mbnaweb.xsd.msgs.customerprofile.AddAuthorizedUserResponse response, String carNumber, String token);
    public ValidateCPIResponse cardVerification(String connectId, String cardNumber, String cvv, String expiryYear, String expiryMonth, String token);
    public ReplaceCardResponse issueCard(String connectId, ReplaceCardRequest replaceCardRequest, String token) throws MBNAException;
    public ValidateCPIResponse cardCVCVerification(String connectId, String cardNumber, String cvv, String expiryMonthYear, String token);
    public RetrieveAccessCard retrieveAccessCard(String connectId, String cardNumber, String token);

}
