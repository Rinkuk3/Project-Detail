package com.td.mbna.msec.midtier.statement;

import com.td.mbna.msec.midtier.mbcca.MbnaCCA;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.statement.payload.getAvailableStatementList.GetAvailableStatementListRequest;
import com.td.mbna.msec.midtier.statement.payload.getAvailableStatementList.GetAvailableStatementListResponse;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.*;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAvailableStatementListOperation implements MsecMidtierCommonOperations<GetAvailableStatementListRequest, GetAvailableStatementListResponse>
{

    private static MbnaLogger logger = new MbnaLogger(GetAvailableStatementListOperation.class);

    private static final String GENERAL_ERROR = "MS601";

    @Autowired
    private MbnaCCA mbnaCCA;

    @Override
    public GetAvailableStatementListResponse invokeService(GetAvailableStatementListRequest request, String... token) {

        logger.info("Entering StatementService.getAvailableStatementList()...");

        try {

            GetAvailableStatementListResponse getAvailableStatementListResponse = mbnaCCA.retrieveAvailableStatementList(request.getSessionInfo().getConnectId(), request.getAcctNum(),token[0]);

            getAvailableStatementListResponse.getResponsePayload().getAvailableStatementList().setHardCopyRate(FeeUtil.getStatementFee());
            StatementUtil.limitCycles(getAvailableStatementListResponse.getResponsePayload().getAvailableStatementList());


            return getAvailableStatementListResponse;

        }  catch (Exception e) {
            logger.error(
                    "StatementService:getAvailableStatementList",
                    e.getLocalizedMessage(), e);
            throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,GENERAL_ERROR, e);

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
