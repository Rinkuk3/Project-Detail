package com.td.mbna.msec.midtier.statement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.td.mbna.msec.midtier.mbcca.MbnaCCA;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.statement.payload.getIpEligibleTransactions.GetIpEligibleTransactionsRequest;
import com.td.mbna.msec.midtier.statement.payload.getIpEligibleTransactions.GetIpEligibleTransactionsResponse;
import com.td.mbna.msec.midtier.statement.payload.getIpEligibleTransactions.ResponsePayload;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.types.common.CardHolderInfo;
import com.td.mbna.msec.midtier.types.common.StmtActivityType;

@Service
public class GetIpEligibleTransactionsOperation implements MsecMidtierCommonOperations<GetIpEligibleTransactionsRequest, GetIpEligibleTransactionsResponse> {

    @Autowired
    private MbnaCCA mbnaCCA;

    @Override
    public GetIpEligibleTransactionsResponse invokeService(GetIpEligibleTransactionsRequest request, String... token) {

        GetIpEligibleTransactionsResponse getIpEligibleTransactionsResponse = new GetIpEligibleTransactionsResponse();
        getIpEligibleTransactionsResponse.setResponsePayload(new ResponsePayload());

        List<StmtActivityType>  stmtActivityTypeList = mbnaCCA.retrieveIpEligibleTransactions(request.getSessionInfo().getConnectId(),request.getAcctNum(), token[0]);

        if(stmtActivityTypeList == null){
        	return null;
        }

        getIpEligibleTransactionsResponse.getResponsePayload().setIpEligibleTransactions(stmtActivityTypeList);

        CardHolderInfo aCardHolder;

        for(StmtActivityType aStmtActivity: stmtActivityTypeList) {
            aCardHolder = request.getRequestPayload().getCardHolderInfos().stream().filter( cardHolder -> cardHolder.getCardNumber().equalsIgnoreCase(aStmtActivity.getAcctId())).findAny().orElse(null);
            aStmtActivity.setCardHolderName(aCardHolder != null ? aCardHolder.getCardHolderName() : null);
        }

        return getIpEligibleTransactionsResponse;
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
