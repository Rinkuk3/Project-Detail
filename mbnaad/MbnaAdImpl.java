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
import com.td.mbna.msec.midtier.util.perf.ProfileLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MbnaAdImpl implements MbnaAd {

    @Autowired
    private ChipCardInfoSrv chipCardInfoSrv;

    @Autowired
    private CardActivationSrv cardActivationSrv;

    @Autowired
    private UserInfoSrv userInfoSrv;

    @Autowired
    private CardVerificationSrv cardVerificationSrv;

    @Override
    @ProfileLog
    public RetrieveAccessCardListRs retrieveChipCardInfo(String connectId, String cardNumber, String partyKey, String token) {
        return chipCardInfoSrv.retrieveChipCardInfo(connectId, cardNumber,partyKey,token);
    }

    @Override
    @ProfileLog
    public RetrieveAccessCard retrieveAccessCardInfo(String connectId, String cardNumber, String token) {
        return chipCardInfoSrv.retrieveAccessCardList(connectId,cardNumber,token);
    }

    @Override
    @ProfileLog
    public GetPinResponse viewPin(String connectId, String cardNumber, String partyKey, String token){
        return chipCardInfoSrv.viewPin(connectId, cardNumber, partyKey, token);
    }

    @Override
    @ProfileLog
    public ChangePinResponse updatePin(String connectId, String cardNumber,String encryptedPin, String partyKey, String token){
        return chipCardInfoSrv.updatePin(connectId, cardNumber, encryptedPin, partyKey, token);
    }

    @Override
    @ProfileLog
    public UnblockPinResponse unblockPin(String connectId, String cardNumber, String partyKey, String token, String seqNumber, Boolean allowPinChangeInd) {
        return chipCardInfoSrv.unblockPin(connectId, cardNumber, partyKey, token, seqNumber, allowPinChangeInd);
    }

    @Override
    @ProfileLog
    public ActivateCardResponse activateCard(String connectId, String cardNumber, String partyKey, String token) {
        return cardActivationSrv.activateCard(connectId, cardNumber, partyKey, token);
    }

    @Override
    @ProfileLog
    public Boolean issueCardForAU(com.mbnaweb.xsd.msgs.customerprofile.AddAuthorizedUserRequest addAuthorizedUserRequest, com.mbnaweb.xsd.msgs.customerprofile.AddAuthorizedUserResponse response, String cardNumber, String token){
        return userInfoSrv.issueCardForAU(addAuthorizedUserRequest, response, cardNumber, token);
    }

    @Override
    public ValidateCPIResponse cardVerification(String connectId, String cardNumber, String cvv, String expiryYear, String expiryMonth, String token) {
        return cardVerificationSrv.cardVerification(connectId, cardNumber, cvv, expiryYear, expiryMonth, token);
    }

    @Override
    public ReplaceCardResponse issueCard(String connectId,ReplaceCardRequest replaceCardRequest, String token) throws MBNAException {
        return userInfoSrv.issueCard(connectId, replaceCardRequest, token );
    }
    @Override
    public ValidateCPIResponse cardCVCVerification(String connectId, String cardNumber, String cvv, String expiryMonthYear, String token) {
        return cardVerificationSrv.cardCVCVerification(connectId, cardNumber, cvv, expiryMonthYear, token);
    }

    @Override
    @ProfileLog
    public RetrieveAccessCard retrieveAccessCard(String connectId, String cardNumber, String token) {
        return chipCardInfoSrv.verifyCardExpiry(connectId,cardNumber,token);
    }
}
