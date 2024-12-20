package com.td.mbna.msec.midtier.services;

import com.td.api.dms.common.Additionalstatus;
import com.td.api.dms.common.Status;
import com.td.api.dms.request.*;
import com.td.api.dms.response.DocumentList;
import com.td.mbna.msec.midtier.util.BackEndSrvcUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class TdStatementServiceUtil {

    private static MbnaLogger logger = new MbnaLogger(TdStatementServiceUtil.class);

    public static DocumentList searchInserts(String insertId, String dmApiPortal, String insertsFolder, String token, TDRestServiceUtil tdRestServiceUtil) {

        String methodName = "TdStatementSericeUtil:searchInserts";

        DocumentSearchRequest documentSearchRequest = createDocumentSearchRequestForInsert(insertId,dmApiPortal,insertsFolder);

        try {
            return tdRestServiceUtil.invokeRestService(BackEndSrvcUtil.TDOperation.TdDocuManagementService_search,documentSearchRequest, DocumentList.class,token);

        } catch (Exception e) {
            logger.error(methodName + "Error in searching for Inserts with token="+token,e.getLocalizedMessage(),e);

            DocumentList aDocumentList = new DocumentList();
            Status status = new Status();
            List<Additionalstatus> additionalstatuses = new ArrayList<>();
            Additionalstatus anAdditionalStatus = new Additionalstatus();
            anAdditionalStatus.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            additionalstatuses.add(anAdditionalStatus);
            status.setAdditionalStatus(additionalstatuses);
            aDocumentList.setStatus(status);

            return aDocumentList;
        } finally {
        }
    }

    public static DocumentSearchRequest createDocumentSearchRequestForInsert(String insertId, String dmApiPortal, String insertsFolder) {

        DocumentSearchRequest documentSearchRequest = new DocumentSearchRequest();

        documentSearchRequest.setPortal(dmApiPortal);
        documentSearchRequest.setFolder(insertsFolder);

        //searchDocuments query
        List<Query> queryList = new ArrayList<>();
        List<String> values = new ArrayList<>();

        Query aQuery = new Query();
        aQuery.setAttribute(Attributes.FormNumber);
        aQuery.setOperator(Operators.EQUALS);
        values.add(insertId);
        aQuery.setValue(values);


        queryList.add(aQuery);

        documentSearchRequest.setQuery(queryList);


        //order by query
        List<OrderBy> orderByList = new ArrayList<>();

        OrderBy orderBy = new OrderBy();
        orderBy.setAttribute(Attributes.FormNumber);
        orderBy.setDirection(Direction.asc);

        orderByList.add(orderBy);

        orderBy = new OrderBy();
        orderBy.setAttribute(Attributes.LoadDate);
        orderBy.setDirection(Direction.des);

        orderByList.add(orderBy);

        documentSearchRequest.setOrderBy(orderByList);

        return documentSearchRequest;

    }

    public static DocumentSearchRequest createDocumentSearchRequest(String statementsFolder, String dmApiPortal, String cardNumbersList, String startDate, String endDate) {

        //if card numbers list is empty, search request will not be valid. thus return null instead of creating wrong search request.
        if (StringUtils.isBlank(cardNumbersList)) {
            return null;
        }

        //creating new document searchDocuments query
        DocumentSearchRequest documentSearchRequest = new DocumentSearchRequest();

        documentSearchRequest.setFolder(statementsFolder);
        documentSearchRequest.setPortal(dmApiPortal);

        //searchDocuments query
        List<Query> queryList = new ArrayList<>();
        List<String> values = new ArrayList<>();

        Query aQuery = new Query();
        aQuery.setAttribute(Attributes.AccountNumber);

        String[] cardNumbers;

        cardNumbers = cardNumbersList.split(",");

        if (cardNumbers.length > 1) {
            aQuery.setOperator(Operators.IN);
        } else {
            aQuery.setOperator(Operators.EQUALS);
        }

        for(String aCardNumber : cardNumbers) {
            values.add(aCardNumber);
        }

        aQuery.setValue(values);

        queryList.add(aQuery);

        aQuery = new Query();
        aQuery.setAttribute(Attributes.StatementDate);
        aQuery.setOperator(Operators.BETWEEN);

        values = new ArrayList<>();
        values.add(startDate);
        values.add(endDate);

        aQuery.setValue(values);

        queryList.add(aQuery);

        documentSearchRequest.setQuery(queryList);

        //order by query
        OrderBy orderBy = new OrderBy();
        orderBy.setAttribute(Attributes.AccountNumber);
        orderBy.setDirection(Direction.asc);

        List<OrderBy> orderByList = new ArrayList<>();
        orderByList.add(orderBy);

        documentSearchRequest.setOrderBy(orderByList);

        return documentSearchRequest;
    }
}
