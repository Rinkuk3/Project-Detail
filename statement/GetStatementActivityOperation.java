package com.td.mbna.msec.midtier.statement;

import com.td.mbna.msec.midtier.mbcca.MbnaCCA;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.statement.payload.getStatementActivity.GetStatementActivityRequest;
import com.td.mbna.msec.midtier.statement.payload.getStatementActivity.GetStatementActivityResponse;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.types.common.CardHolderInfo;
import com.td.mbna.msec.midtier.types.common.StmtActivityType;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetStatementActivityOperation implements MsecMidtierCommonOperations<GetStatementActivityRequest, GetStatementActivityResponse> {

    private static MbnaLogger logger = new MbnaLogger(GetStatementActivityOperation.class);

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    @Autowired
    private MbnaCCA mbnaCCA;

    @Override
    public GetStatementActivityResponse invokeService(GetStatementActivityRequest request, String... token) {

        logger.info("Entering StatementService.getStatementActivity()...");

        GetStatementActivityResponse getStatementActivityResponse = mbnaCCA.retrieveStatementActivities(request.getSessionInfo().getConnectId(),request.getAcctNum(),request.getRequestPayload().getStatementClosingDate(),request.getRequestPayload().getStatementPaymentDueDate(),token[0]);

        com.td.mbna.msec.midtier.statement.payload.getStatementActivity.ResponsePayload statementResponsePayload = new com.td.mbna.msec.midtier.statement.payload.getStatementActivity.ResponsePayload();

        //if getSTatementActivityResponse is null, there are no activities, thus no need to update card holder
        if (getStatementActivityResponse != null) {
            updatePayloadWithCardHolderName(request, statementResponsePayload);
        } else {
            logger.debug("GetStatementActivityResponse:invokeService - there are no statement activities/transactions.");
        }

        return getStatementActivityResponse;

    }

    private void updatePayloadWithCardHolderName(
            GetStatementActivityRequest request,
			com.td.mbna.msec.midtier.statement.payload.getStatementActivity.ResponsePayload payload) {
    	
		List<StmtActivityType> stmtActivities = payload.getStatementActivities();
		com.td.mbna.msec.midtier.statement.payload.getStatementActivity.RequestPayload requestPl = request.getRequestPayload();
		if (requestPl == null) {
			return;
		}
		List<CardHolderInfo> cardHoderInfos = requestPl.getCardHolderInfos();
		if (cardHoderInfos == null || cardHoderInfos.isEmpty()) {
			return;
		}
		for (CardHolderInfo cardHolderInfo : cardHoderInfos) {
			String cardHoderName = cardHolderInfo.getCardHolderName();
			String cardNumber = cardHolderInfo.getCardNumber();
			for (StmtActivityType stmtActivity : stmtActivities) {
				String accId = stmtActivity.getAcctId();
				if (accId.trim().equals(cardNumber.trim())) {
					stmtActivity.setCardHolderName(cardHoderName);
				}
			}
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
