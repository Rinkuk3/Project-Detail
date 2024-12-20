package com.td.mbna.msec.midtier.statement;

import com.td.mbna.msec.midtier.statement.payload.getIpEligibleTransactions.GetIpEligibleTransactionsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.td.mbna.msec.midtier.statement.payload.getAvailableStatementList.GetAvailableStatementListRequest;
import com.td.mbna.msec.midtier.statement.payload.getIpEligibleTransactions.GetIpEligibleTransactionsResponse;
import com.td.mbna.msec.midtier.statement.payload.getStatementActivity.GetStatementActivityRequest;
import com.td.mbna.msec.midtier.statement.payload.getStatementFileFromId.GetStatementFileFromIdRequest;
import com.td.mbna.msec.midtier.statement.payload.getStatementFileFromId.GetStatementFileFromIdResponse;
import com.td.mbna.msec.midtier.statement.payload.getStatementListForYear.GetStatementListForYearRequest;
import com.td.mbna.msec.midtier.statement.payload.getStatementListForYear.GetStatementListForYearResponse;
import com.td.mbna.msec.midtier.statement.payload.getStatementWithActivity.GetStatementWithActivityRequest;
import com.td.mbna.msec.midtier.statement.payload.updateStatementDeliveryPreferences.UpdateStatementDeliveryPreferencesRequest;
import com.td.mbna.msec.midtier.statement.payload.updateStatementDeliveryPreferences.UpdateStatementDeliveryPreferencesResponse;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.perf.ProfileLog;

@Service
public class StatementServiceImpl implements StatementService {

	private final static MbnaLogger logger = new MbnaLogger(StatementServiceImpl.class);


    @Autowired
    private UpdateStatementDeliveryPreferencesOperation updateStatementDeliveryPreferencesOperation;

    @Autowired
    private GetStatementFileFromIdOperation getStatementFileFromIdOperation;

    @Autowired
    private GetStatementWithActivityOperation getStatementWithActivityOperation;

    @Autowired
    private GetStatementListForYearOperation getStatementListForYearOperation;

    @Autowired
    private GetAvailableStatementListOperation getAvailableStatementListOperation;

    @Autowired
    private GetStatementActivityOperation getStatementActivityOperation;

    @Autowired
    private GetIpEligibleTransactionsOperation getIpEligibleTransactionsOperation;


    @ProfileLog
    @Override
    public com.td.mbna.msec.midtier.statement.payload.getAvailableStatementList.GetAvailableStatementListResponse getAvailableStatementList(
            GetAvailableStatementListRequest request, String... token) {
        return getAvailableStatementListOperation.invokeService(request, token);
    }

    @ProfileLog
    @Override
    public com.td.mbna.msec.midtier.statement.payload.getStatementActivity.GetStatementActivityResponse getStatementActivity(
            GetStatementActivityRequest request, String... token) {
        return getStatementActivityOperation.invokeService(request, token);
    }


    @ProfileLog
    @Override
    public com.td.mbna.msec.midtier.statement.payload.getStatementWithActivity.GetStatementWithActivityResponse getStatementWithActivity(
            GetStatementWithActivityRequest request, String... token) {
        return getStatementWithActivityOperation.invokeService(request, token);

    }

    @Override
    @ProfileLog
    public GetStatementFileFromIdResponse getStatementFileFromId(
            GetStatementFileFromIdRequest request, String... token) {
        logger.info("Entering StatementService.GetStatementFileFromIdResponse()...");
        return getStatementFileFromIdOperation.invokeService(request, token);

    }

    @ProfileLog
    @Override
    public GetStatementListForYearResponse getStatementListForYear(
            GetStatementListForYearRequest request, String... token) {
        return getStatementListForYearOperation.invokeService(request, token);
    }

	@ProfileLog
	@Override
	public UpdateStatementDeliveryPreferencesResponse updateStatementDeliveryPreferences(
			UpdateStatementDeliveryPreferencesRequest request, String... token) {
		return updateStatementDeliveryPreferencesOperation.invokeService(request,token);
	}

	@ProfileLog
    @Override
    public GetIpEligibleTransactionsResponse getIpEligibleTransactions(GetIpEligibleTransactionsRequest request, String... token) {
        return getIpEligibleTransactionsOperation.invokeService(request,token);
    }


}
