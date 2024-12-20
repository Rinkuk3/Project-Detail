package com.td.mbna.msec.midtier.mbofp.adaptor;

import com.td.api.mbofp.request.balancetransfer.*;
import com.td.api.mbofp.request.common.TransactionCccyamt;
import com.td.api.mbofp.response.balancetransfer.BalanceTransferResponse;
import com.td.mbna.msec.midtier.transfer.payload.BTConfirmationType;
import com.td.mbna.msec.midtier.transfer.payload.balancetransfertocreditor.BalanceTransferToCreditorResponse;
import com.td.mbna.msec.midtier.util.services.MSECConstants;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class BalanceTransferAdaptor extends MbnaOfpAdaptor {

    public BalanceTransferToCreditorResponse getResponse(BalanceTransferResponse btr) {
        BTConfirmationType btConfirmation = new BTConfirmationType();

        // check btr status:  eventId
        if (btr != null && btr.getEventId() != null){
            btConfirmation.setStatus(true);
            btConfirmation.setRefId(btr.getEventId());
        } else {
            btConfirmation.setStatus(false);
        }
        
        com.td.mbna.msec.midtier.transfer.payload.balancetransfertocreditor.ResponsePayload responsePayload = new com.td.mbna.msec.midtier.transfer.payload.balancetransfertocreditor.ResponsePayload();
        responsePayload.getConfirmation().add(btConfirmation);
        BalanceTransferToCreditorResponse response = new BalanceTransferToCreditorResponse();
        response.setResponsePayload(responsePayload);

        return response;
    }

    public BalanceTransferRequest getRequest(Map<String, Object> params) {

        TransactionCccyamt transactionCccyamt = new TransactionCccyamt();
        transactionCccyamt.setAmount((BigDecimal) params.get(PARAM_AMOUNT));

        BalanceTransfer balanceTransfer = new BalanceTransfer();
        if (!STANDARD_RATE_BT.equalsIgnoreCase((String)params.get(PARAM_SUBPRODUCT_ID))){
            balanceTransfer.setProductId((String)params.get(PARAM_SUBPRODUCT_ID));
        }
        balanceTransfer.setTransactionCccyamt(transactionCccyamt);
        balanceTransfer.setNegotiatedFeeTypeCd((String) params.get(PARAM_FEETYPE));
        balanceTransfer.setSolicitationChannelTypeCd(MSECConstants.INTERNET_SECURE);
        balanceTransfer.setAccessChannelTypeCd(MSECConstants.ONLINE_SECURE_SITE);

        RequestSourceCreditCardAgreement requestSourceCreditCardAgreement = new RequestSourceCreditCardAgreement();
        requestSourceCreditCardAgreement.setAgreementId((String) params.get(PARAM_ACCT_ID));
        requestSourceCreditCardAgreement.setCardNum((String) params.get(PARAM_CARDNUM));

        RequestFundsSource requestFundsSource = new RequestFundsSource();
        requestFundsSource.setRequestSourceCreditCardAgreement(requestSourceCreditCardAgreement);

        RequestFundsDestination requestFundsDestination = new RequestFundsDestination();

        RequestDestinationExternalCreditorAccount requestDestinationExternalCreditorAccount = new RequestDestinationExternalCreditorAccount();
        requestDestinationExternalCreditorAccount.setCreditorPartyIdentificationNum((String) params.get(PARAM_MERCHANTID));
        requestDestinationExternalCreditorAccount.setAccountNum((String) params.get(PARAM_PAYEE_CARDNUM));

        requestFundsDestination.setRequestDestinationExternalCreditorAccount(requestDestinationExternalCreditorAccount);

        FundsTransfer fundsTransfer = new FundsTransfer();
        fundsTransfer.setRequestFundsSource(requestFundsSource);
        fundsTransfer.setRequestFundsDestination(requestFundsDestination);
        fundsTransfer.setFundsTransferMethodTypeCd(TYPE_CEFT);

        Recipient recipient = new Recipient();
        recipient.setIndividualFirstName((String) params.get(PARAM_FIRST_NAME));
        recipient.setIndividualLastName((String) params.get(PARAM_LAST_NAME));

        BalanceTransferRequest request = new BalanceTransferRequest();
        request.setBalanceTransfer(balanceTransfer);
        request.setFundsTransfer(fundsTransfer);
        request.setRecipient(recipient);

        return request;
    }

}
