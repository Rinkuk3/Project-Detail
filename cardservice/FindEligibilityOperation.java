package com.td.mbna.msec.midtier.cardservice;

import com.td.api.mbcca.response.card.Card;
import com.td.mbna.msec.midtier.cardservice.payload.eligibility.*;
import com.td.mbna.msec.midtier.mbcca.MbnaCCA;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FindEligibilityOperation extends CardActivationBaseOperations implements MsecMidtierCommonOperations<CardActivationEligibilityRequests, CardActivationEligibilityResponses> {

    private static MbnaLogger logger = new MbnaLogger(FindEligibilityOperation.class);

    private static final String GENERAL_ERROR = "MS601";

    @Autowired
    private ActivationUtil activationUtil;

    @Autowired
    private MbnaCCA mbnaCCA;

    @Override
    public CardActivationEligibilityResponses invokeService(CardActivationEligibilityRequests request, String... token) {

        String methodName = "findEligibility";
        CardActivationEligibilityResponses responses = new CardActivationEligibilityResponses();
        List<CardActivationEligibilityRequest> cardActivationEligibilityRequestList = request.getCardActivationEligibilityRequests();
        if(cardActivationEligibilityRequestList == null || cardActivationEligibilityRequestList.isEmpty()){
        	return responses;
        }
        try {

            List<CardActivationEligibilityResponse> cardActivationEligibilityResponseList = new ArrayList<>();
            responses.setCardActivationEligibilityResponses(cardActivationEligibilityResponseList);

            ActivationUtil.LastRequestReason  lastRequestReason = null ;
            boolean isCardActive = true,isPchActivated = true;
            List<AuthorizedUser> eligibleAuList = new ArrayList<>();
            CardActivationEligibilityResponse cardActivationEligibilityResponse;
            ResponsePayload responsePayload;

            boolean isMultiCard = false;

            for(CardActivationEligibilityRequest cardActivationEligibilityRequest : cardActivationEligibilityRequestList) {

                cardActivationEligibilityResponse = new CardActivationEligibilityResponse();
                responsePayload = new ResponsePayload();
                responsePayload.setCardNumber(cardActivationEligibilityRequest.getAcctNum());
                cardActivationEligibilityResponse.setResponsePayload(responsePayload);

                isMultiCard = cardActivationEligibilityRequest.isMultiCard();

                //if primary user
                if ( cardActivationEligibilityRequest.getIsPrimaryUser() != null && cardActivationEligibilityRequest.getIsPrimaryUser())
                {


                    Card card = mbnaCCA.retrieveCreditCardInfo(request.getSessionInfo().getConnectId(), isMultiCard,cardActivationEligibilityRequest.getCardNum(),cardActivationEligibilityRequest.getAliasCustId(),true,token[0]).getCard();
					if(card != null){
	                    lastRequestReason = ActivationUtil.LastRequestReason.getEnum(card.getLastCardRequestReasonCd());	
	                    isPchActivated  = card.getReceiptVerificationInd() != null ? card.getReceiptVerificationInd() : true;
					}
                    //PCH is eligible to activate card in all cases
                    responsePayload.setCardNumber(cardActivationEligibilityRequest.getCardNum());
                    responsePayload.setEligible(true);


                    for(AuthorizedUser anAuthorizedUser : cardActivationEligibilityRequest.getRequestPayload().getAuthorizedUsers()) {

                        try {
                            card = mbnaCCA.retrieveCreditCardInfo(request.getSessionInfo().getConnectId(), isMultiCard,anAuthorizedUser.getCardNumber(), anAuthorizedUser.getCustomerId(), false,token[0]).getCard();
                            if(card != null){
	                            lastRequestReason = ActivationUtil.LastRequestReason.getEnum(card.getLastCardRequestReasonCd());
	                            isCardActive = card.getReceiptVerificationInd() != null ? card.getReceiptVerificationInd() : true;
                            }
                            if (!isCardActive && (lastRequestReason.equals(ActivationUtil.LastRequestReason.NEW) || lastRequestReason.equals(ActivationUtil.LastRequestReason.REISSUE))) {
                                eligibleAuList.add(anAuthorizedUser);
                            }
                        } catch (Exception e) {
                            //PCH should be able to activate the card, so don't throw this error.
                            logger.error(methodName," in getting last request reason/activation status failed of AU "+e.getLocalizedMessage(),e);
                        }
                    }

                    //if pch activated and no AUs to be activated, no need to show the message
                    if (isPchActivated && eligibleAuList.size() == 0) {
                        responsePayload.setMessageId(null);
                    } else {
                        responsePayload.setMessageId(activationUtil.findMessageCode(lastRequestReason,true));
                    }



                    responsePayload.setAuthorizedUsers(eligibleAuList);

                }
                // if au user
                else if (!cardActivationEligibilityRequest.getIsPrimaryUser()){

                    Card card = mbnaCCA.retrieveCreditCardInfo(request.getSessionInfo().getConnectId() ,isMultiCard,cardActivationEligibilityRequest.getCardNum(), cardActivationEligibilityRequest.getAliasCustId(), false,token[0]).getCard();
                    if(card != null){
                    	lastRequestReason = ActivationUtil.LastRequestReason.getEnum(card.getLastCardRequestReasonCd());
                    }

                    responsePayload.setEligible(activationUtil.canAUActivate(lastRequestReason));
                    responsePayload.setMessageId(activationUtil.findMessageCode(lastRequestReason,false));
                    responsePayload.setCardNumber(cardActivationEligibilityRequest.getCardNum());

                }

                cardActivationEligibilityResponseList.add(cardActivationEligibilityResponse);
            }

            
            return responses;

        } catch (Exception e) {
            logger.error(methodName,e.getLocalizedMessage(),e);
            throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR, GENERAL_ERROR, e);
        }


    }

    @Override
    public boolean requiresDisclosureConsent() {
        return false;
    }

    @Override
    public String getConsentDisclosureFailedMsgCode() {
        return null;
    }

    @Override
    public boolean generateAutoComment() {
        return false;
    }

    @Override
    public List<String> createAutoComment(BaseRequest request, BaseResponse response) {
        return null;
    }

    @Override
    public EmailInfo getEmailInfoBean(BaseRequest request, BaseResponse response) {
        return null;
    }

    @Override
    public MsecValidator getValidator() {
        return null;
    }
}
