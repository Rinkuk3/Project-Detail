package com.td.mbna.msec.midtier.mbofp.adaptor;

import com.td.api.mbofp.request.balancetransfer.*;
import com.td.api.mbofp.request.common.TransactionCccyamt;
import com.td.api.mbofp.response.balancetransfer.BalanceTransferResponse;
import com.td.mbna.msec.midtier.transfer.payload.deposittochequing.DepositToChequingResponse;
import com.td.mbna.msec.midtier.util.services.MSECConstants;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class DepositToChequingAdaptor extends MbnaOfpAdaptor {

    public DepositToChequingResponse getResponse(BalanceTransferResponse btr) {
        DepositToChequingResponse response = new DepositToChequingResponse();
        com.td.mbna.msec.midtier.transfer.payload.deposittochequing.ResponsePayload responsePayload = new com.td.mbna.msec.midtier.transfer.payload.deposittochequing.ResponsePayload();
        
        // check btr status:  eventId
        if (btr != null && btr.getEventId() != null){
        	responsePayload.setStatus(true);
        	responsePayload.setRefId(btr.getEventId());
        } else {
        	responsePayload.setStatus(false);
        }

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

        BranchAddress branchAddress = new BranchAddress();
        branchAddress.setAddressLine1((String) params.get(PARAM_ADDRESSLINE1));
        branchAddress.setAddressLine2((String) params.get(PARAM_ADDRESSLINE2));
        branchAddress.setCity((String) params.get(PARAM_CITY));
        branchAddress.setPostalCode((String) params.get(PARAM_POSTALCODE));
        branchAddress.setTerritory((String) params.get(PARAM_PROVINCE));

        String bankId = (String) params.get(PARAM_PAYEE_BANKID);
        if (bankId != null && bankId.length() > 0) {
            RequestDestinationExternalBankAccount requestDestinationExternalBankAccount = new RequestDestinationExternalBankAccount();
            requestDestinationExternalBankAccount.setBankNum(bankId);
            requestDestinationExternalBankAccount.setBankName((String) params.get(PARAM_PAYEE_BANKNAME));
            requestDestinationExternalBankAccount.setBranchNum((String) params.get(PARAM_PAYEE_BANKTRANSIT));
            requestDestinationExternalBankAccount.setAccountNum((String) params.get(PARAM_PAYEE_ACCTNUM));
            requestDestinationExternalBankAccount.setAccountPurposeSubtypeCd(TYPE_CHEQUING);
            requestDestinationExternalBankAccount.setBranchAddress(branchAddress);

            requestFundsDestination.setRequestDestinationExternalBankAccount(requestDestinationExternalBankAccount);
        } else {
            RequestDestinationDepositTransactionAgreement requestDestinationDepositTransactionAgreement = new RequestDestinationDepositTransactionAgreement();
            requestDestinationDepositTransactionAgreement.setBranchNum((String) params.get(PARAM_PAYEE_BANKTRANSIT));
            requestDestinationDepositTransactionAgreement.setAccountNum((String) params.get(PARAM_PAYEE_ACCTNUM));
            requestDestinationDepositTransactionAgreement.setAgreementPurposeSubtypeCd(TYPE_CHEQUING);
            requestDestinationDepositTransactionAgreement.setBranchAddress(branchAddress);

            requestFundsDestination.setRequestDestinationDepositTransactionAgreement(requestDestinationDepositTransactionAgreement);
        }

        FundsTransfer fundsTransfer = new FundsTransfer();
        fundsTransfer.setRequestFundsSource(requestFundsSource);
        fundsTransfer.setRequestFundsDestination(requestFundsDestination);
        fundsTransfer.setFundsTransferMethodTypeCd(TYPE_PEFT);

        Recipient recipient = new Recipient();
        recipient.setFullName((String) params.get(PARAM_PAYEE_NAME));

        BalanceTransferRequest request = new BalanceTransferRequest();
        request.setBalanceTransfer(balanceTransfer);
        request.setFundsTransfer(fundsTransfer);
        request.setRecipient(recipient);

        return request;
    }

}
