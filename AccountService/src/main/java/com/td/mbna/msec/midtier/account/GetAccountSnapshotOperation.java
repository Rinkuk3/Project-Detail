package com.td.mbna.msec.midtier.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import com.td.mbna.msec.midtier.account.payload.getaccountsnapshot.GetAccountSnapshotRequest;
import com.td.mbna.msec.midtier.account.payload.getaccountsnapshot.GetAccountSnapshotResponse;
import com.td.mbna.msec.midtier.account.payload.getaccountsnapshot.ResponsePayload;
import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.mbcca.MbnaCCA;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.types.common.CardHolderInfo;
import com.td.mbna.msec.midtier.types.common.StmtActivityType;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;

@Component
public class GetAccountSnapshotOperation implements MsecMidtierCommonOperations<GetAccountSnapshotRequest, GetAccountSnapshotResponse> {

    private final static MbnaLogger logger = new MbnaLogger(GetAccountSnapshotOperation.class);

    private static final String GENERAL_ERROR = "MS601";

    @Autowired
    private ValangValidator getAccountSnapshotRequestValidator;

    @Autowired
    private MbnaCCA mbnaCCA;

    private MsecValidator msecGetAccountSnapshotRequestValidator;

    @PostConstruct
    private void init() {
        msecGetAccountSnapshotRequestValidator = new MsecVlangValidator(getAccountSnapshotRequestValidator);
    }

    @Override
    public GetAccountSnapshotResponse invokeService(GetAccountSnapshotRequest request, String... token) {
        logger.info("Entering AccountService.getAccountSnapshot()...");

        try {

            GetAccountSnapshotResponse response = mbnaCCA.retrieveTransaction(request,token[0]);
            // populate with card holdername
            ResponsePayload snapshotPayload = response.getResponsePayload();

            if (snapshotPayload != null) {
                populateCardHolderInfoForSnapshot(request, response);

            } else {
                logger.debug("GetAccountSnapshotResponse:invokeService snapshotPayload is null, which means no activities");
            }

            return response;

        } catch (Exception e) {
            logger.error(
                    "AccountService:getAccountSnapshot",
                    e.getLocalizedMessage(), e);
            throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR," getAccountSnapshot failed from AccountService", e);

        }
    }

    private void populateCardHolderInfoForSnapshot(GetAccountSnapshotRequest getAccountSnapshotRequest, GetAccountSnapshotResponse getAccountSnapshotResponse) {
        Map<String,String> cardHolderInfo = new HashMap<>();

        for(CardHolderInfo aCardHOlderInfo : getAccountSnapshotRequest.getCardHolderInfos()) {
            cardHolderInfo.put(aCardHOlderInfo.getCardNumber(),aCardHOlderInfo.getCardHolderName());
        }

        for(StmtActivityType anStmtActivity : getAccountSnapshotResponse.getResponsePayload().getStatementActivities()) {
            anStmtActivity.setCardHolderName(cardHolderInfo.get(anStmtActivity.getAcctId()));
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
        return msecGetAccountSnapshotRequestValidator;
    }
}
