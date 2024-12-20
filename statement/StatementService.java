package com.td.mbna.msec.midtier.statement;

import com.td.mbna.msec.midtier.statement.payload.getAvailableStatementList.GetAvailableStatementListRequest;
import com.td.mbna.msec.midtier.statement.payload.getAvailableStatementList.GetAvailableStatementListResponse;
import com.td.mbna.msec.midtier.statement.payload.getIpEligibleTransactions.GetIpEligibleTransactionsRequest;
import com.td.mbna.msec.midtier.statement.payload.getIpEligibleTransactions.GetIpEligibleTransactionsResponse;
import com.td.mbna.msec.midtier.statement.payload.getStatementActivity.GetStatementActivityRequest;
import com.td.mbna.msec.midtier.statement.payload.getStatementActivity.GetStatementActivityResponse;
import com.td.mbna.msec.midtier.statement.payload.getStatementFileFromId.GetStatementFileFromIdRequest;
import com.td.mbna.msec.midtier.statement.payload.getStatementFileFromId.GetStatementFileFromIdResponse;
import com.td.mbna.msec.midtier.statement.payload.getStatementListForYear.GetStatementListForYearRequest;
import com.td.mbna.msec.midtier.statement.payload.getStatementListForYear.GetStatementListForYearResponse;
import com.td.mbna.msec.midtier.statement.payload.getStatementWithActivity.GetStatementWithActivityRequest;
import com.td.mbna.msec.midtier.statement.payload.getStatementWithActivity.GetStatementWithActivityResponse;
import com.td.mbna.msec.midtier.statement.payload.updateStatementDeliveryPreferences.UpdateStatementDeliveryPreferencesRequest;
import com.td.mbna.msec.midtier.statement.payload.updateStatementDeliveryPreferences.UpdateStatementDeliveryPreferencesResponse;

public interface StatementService {
    public GetAvailableStatementListResponse getAvailableStatementList(
            GetAvailableStatementListRequest request, String... token);

    public GetStatementActivityResponse getStatementActivity(
            GetStatementActivityRequest request, String... token);

    public GetStatementWithActivityResponse getStatementWithActivity(
            GetStatementWithActivityRequest request, String... token);

    public GetStatementFileFromIdResponse getStatementFileFromId(
            GetStatementFileFromIdRequest request, String... token);

    public GetStatementListForYearResponse getStatementListForYear(
            GetStatementListForYearRequest request, String... token);

	public UpdateStatementDeliveryPreferencesResponse updateStatementDeliveryPreferences(
			UpdateStatementDeliveryPreferencesRequest request, String... token);

	public GetIpEligibleTransactionsResponse getIpEligibleTransactions(GetIpEligibleTransactionsRequest request, String... token);

}
