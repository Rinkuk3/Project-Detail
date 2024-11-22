package com.td.mbna.msec.midtier.account;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import com.td.mbna.msec.midtier.account.payload.deleteaccount.DeleteAccountRequest;
import com.td.mbna.msec.midtier.account.payload.deleteaccount.DeleteAccountResponse;
import com.td.mbna.msec.midtier.enrollment.MbnaEnrollment;
import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.mbcca.MbnaCCA;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.types.common.DeliveryPreferenceType;
import com.td.mbna.msec.midtier.util.services.AuditingService;

@Component
public class DeleteAccountOperation implements MsecMidtierCommonOperations<DeleteAccountRequest, DeleteAccountResponse> {

    @Autowired
    private ValangValidator deleteAccountRequestValidator;

    @Autowired
    private MbnaCCA mbnaCCA;

    @Autowired
    private MbnaEnrollment mbnaEnrollment;

    private MsecValidator msecDeleteAccountRequestValidator;

    @PostConstruct
    private void init() {
        msecDeleteAccountRequestValidator = new MsecVlangValidator(deleteAccountRequestValidator);
    }

    @Override
    public DeleteAccountResponse invokeService(DeleteAccountRequest deleteAccountRequest, String... token) {

        Date stopTime = new Date();


        //first call retrieve relationship to get the list of card numbers.
        // Form the request for AdministerRelationship.retrieveRelationship

        //if the user is primary and statement preference is online, need to change to paper first
        if (deleteAccountRequest.getIsPrimaryUser() != null && deleteAccountRequest.getIsPrimaryUser() && deleteAccountRequest.getRequestPayload().getAcctDeliveryPreference().value().equalsIgnoreCase(DeliveryPreferenceType.ONLINE.value())) {
            // call updateCreditCardAccount
            mbnaCCA.updateElectronicBilling(deleteAccountRequest.getAcctNum(), deleteAccountRequest.isMultiCard(), deleteAccountRequest.isMultiCard() ? deleteAccountRequest.getCardNum() : null, true, token[0]);
        }

        //lastly build the remove request from the response of retrieve relationship
        DeleteAccountResponse deleteAccountResponse = mbnaEnrollment.unEnroll(deleteAccountRequest.getRequestPayload().getConnectId(), deleteAccountRequest.getAcctNum(), token[0]);

        //MBNA-11565, we do this because the current standard operation thingy creates auditlog.
        if (deleteAccountRequest != null) {
            Date startTime = new Date();
            AuditingService.createAuditLog(deleteAccountRequest, deleteAccountResponse, startTime, stopTime.getTime() - startTime.getTime());
        }

        return deleteAccountResponse;


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
        return msecDeleteAccountRequestValidator;
    }
}
