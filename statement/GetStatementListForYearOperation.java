package com.td.mbna.msec.midtier.statement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbnaweb.xsd.types.common.CardNumHistoryType;
import com.mbnaweb.xsd.types.statement.HistoryStatementListType;
import com.mbnaweb.xsd.types.statement.InsertListType;
import com.mbnaweb.xsd.types.statement.InsertType;
import com.td.api.dms.common.Additionalstatus;
import com.td.api.dms.request.DocumentSearchRequest;
import com.td.api.dms.response.Document;
import com.td.api.dms.response.DocumentList;
import com.td.api.dms.response.MetadataItem;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.services.TdStatementServiceUtil;
import com.td.mbna.msec.midtier.statement.payload.getStatementListForYear.GetStatementListForYearRequest;
import com.td.mbna.msec.midtier.statement.payload.getStatementListForYear.GetStatementListForYearResponse;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.BackEndSrvcUtil;
import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.ParallelServiceCaller;
import com.td.mbna.msec.midtier.util.ServiceCall;
import com.td.mbna.msec.midtier.util.StatementUtil;
import com.td.mbna.msec.midtier.util.cache.DMApiCacheService;
import com.td.mbna.msec.midtier.util.ods.OdsHelper;
import com.td.mbna.msec.midtier.util.services.JAXBJsonConverter;
import com.td.mbna.msec.midtier.util.services.MSECConstants;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;

@Service
public class GetStatementListForYearOperation implements MsecMidtierCommonOperations<GetStatementListForYearRequest, GetStatementListForYearResponse> {

    private static MbnaLogger logger = new MbnaLogger(GetStatementListForYearOperation.class);

    private static final String statementsFolder = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_DM_API_STATEMENT_FOLDER);
    private static final String insertsFolder = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_DM_API_INSERT_FOLDER);
    private static final String dmApiPortal = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_DM_API_PORTAL_VALUE);

    @Autowired
    private TDRestServiceUtil tdRestServiceUtil;
    
	@Autowired
	private OdsHelper odsHelper;

    @Override
    public GetStatementListForYearResponse invokeService(GetStatementListForYearRequest request, String... token) {
        
        try {
        	// 1.prepare request
        	// 1.1. card number list
            String custId = request.getCustId();
            String acctId = request.getAcctNum();
            final List<CardNumHistoryType> cardList = odsHelper.getCardHistory(custId, acctId);
            String cardNumbersList = DMSStatementFilterUtil.buildDMSCardList(cardList);

			// 1.2. start date of the year and end date of th year
			// private static final String DATE_FORMAT_DMSsearch = "MM/dd/yy";
            String year = request.getRequestPayload().getStatementSearchYear().substring(2, 4);
            String startDate ="01/01/"+year; 
            String endDate = "12/31/"+year;

            //creating new document searchDocuments query

            DocumentSearchRequest documentSearchRequest  = TdStatementServiceUtil.createDocumentSearchRequest(statementsFolder,dmApiPortal,cardNumbersList,startDate,endDate);

            DocumentList documentList = null;
            // 	2.call back end service
            if (documentSearchRequest != null) {
                documentList = tdRestServiceUtil.invokeRestService(BackEndSrvcUtil.TDOperation.TdDocuManagementService_search, documentSearchRequest, DocumentList.class, token[0]);
            } 
            if(documentList == null){
            	//search request can be null in case of AU.
                documentList = new DocumentList();
            }
            if(documentList.getDocument() == null){
            	documentList.setDocument(new ArrayList<>());            	
            }

            logger.debug("Statement Query for year: " + startDate + ", " + endDate);

            // 3. convert DocumentList to XGetStatementListForYearResponse
            com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse xJaxbResponse = convertJsonToXml(documentList);
            logger.debug(" in::");
            logger.toJson(xJaxbResponse);

            // 3.1 do the filter
            validateStatements(xJaxbResponse,cardList);
            // 3.2.
            processInsertList(xJaxbResponse, token);

            // 4. convert jaxb intf to json intf
            GetStatementListForYearResponse jsonResponse = JAXBJsonConverter.convertoJAXBToJsonInterface(xJaxbResponse, GetStatementListForYearResponse.class);
            logger.debug(" out::");
            logger.toJson(jsonResponse);
            return jsonResponse;

        } catch (Exception e) {
            logger.error("StatementService:getStatementListForYear", e.getLocalizedMessage(), e);
            throw ExceptionUtil.genRuntimeException(e);
        }
    }

	private void processInsertList(	com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse xJaxbResponse, String... token) throws Exception {
		if (xJaxbResponse == null || xJaxbResponse.getResponsePayload() == null) {
		    return;
		}
		//Search Process Inserts BEGIN
		com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse.ResponsePayload xJaxbRespLoad = xJaxbResponse.getResponsePayload();
		List<HistoryStatementListType> histList = xJaxbRespLoad.getHistoryStatementList();
		if (histList == null || histList.isEmpty()) {
			return;
		}
		
		//Step 1: Get all the ongoing insertId
		Map<String, List<InsertType>> stmtInsertTable = new HashMap<String, List<InsertType>>();
		for (int i=0; i<histList.size(); i++) {
			com.mbnaweb.xsd.types.statement.HistoryStatementListType histItem = histList.get(i);
			String stmtDate = histItem.getStatementDate();
			com.mbnaweb.xsd.types.statement.InsertListType insertListTp = histItem.getInsertList();
			if (insertListTp == null) {
				stmtInsertTable.put(stmtDate, null);
				logger.debug("no insert from DMS response");
				continue;
			}
			List<InsertType> insertList = insertListTp.getInsert();
			if (insertList == null) {
				stmtInsertTable.put(stmtDate, null);
				logger.debug("no insert list");
				continue;
			}
			List<InsertType> insertListNEW = new ArrayList<InsertType>();
			for (int j=0; j<insertList.size(); j++) {
				String insertId = insertList.get(j).getInsertId();
				if (StatementUtil.isValidLegalInsertId(insertId)) {
					com.mbnaweb.xsd.types.statement.InsertType insertItem = new com.mbnaweb.xsd.types.statement.InsertType();
					insertItem.setInsertId(insertId);
					insertListNEW.add(insertItem);
				}else {
					logger.debug(insertId + " is not a valid insert - skipped.");
				}
			}//end of insertList for()
			if (insertListNEW.size() > 0) {
				stmtInsertTable.put(stmtDate, insertListNEW);
				logger.debug("Inserts List object created, key="+stmtDate);
			} else {
				stmtInsertTable.put(stmtDate, null);
				logger.debug("no Inserts List object created created");
			}
		}//end of histList for()
		
		//Step 2: Search each ongoing insertId
		if ((stmtInsertTable != null) && (stmtInsertTable.size() > 0)) {
			ParallelServiceCaller insertCaller = new ParallelServiceCaller();
			// Since each statement can have multiple inserts, don't use synchronous even there is only 1 statement.
			Iterator<?> iter = stmtInsertTable.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry<String, List<InsertType>> me = (Map.Entry<String, List<InsertType>>)iter.next();
				String stmtDate = me.getKey();
				List<InsertType> instLst = me.getValue();
				if (instLst != null ) {
					for (int m=0; m<instLst.size(); m++) {
						final String insertId=instLst.get(m).getInsertId();
						final Map<String, Object> paramValuesDMSInsert = new ConcurrentHashMap<String, Object>();
						paramValuesDMSInsert.put(StatementUtil.DMS_formNumber, StatementUtil.getFormId(insertId));
						paramValuesDMSInsert.put(StatementUtil.DMS_folderName, ConfigUtil.getProperty(StatementUtil.DMS_HistStatementOngoingInsert_Folder_External_Property_Key, StatementUtil.DMS_HistStatementOngoingInsert_Folder_Default));
						ServiceCall<?> searchInsertCall = new ServiceCall<com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse>() {
							@Override
							public com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse invoke() throws Exception {
								
								//call api instead of soap.
								DocumentList insertsDocumentList = DMApiCacheService.getInsertInfo(StatementUtil.getFormId(insertId),token[0],dmApiPortal,insertsFolder,tdRestServiceUtil);
								return convertJsonToXmlForInsert(insertsDocumentList);
								
							}
						};
						insertCaller.scheduleCall(stmtDate + "_" + insertId, searchInsertCall);
					}//end of for(m)
				}
			}//end of while(iter)
			insertCaller.sync();
			Iterator<?> iter2 = stmtInsertTable.entrySet().iterator();
			while (iter2.hasNext()) {
				Map.Entry<String, List<InsertType>> me2 = (Map.Entry<String, List<InsertType>>)iter2.next();
				String stmtDate2 = me2.getKey();
				List<InsertType> instLst2 = me2.getValue();
				if (instLst2 != null ) {
					for (int n=0; n<instLst2.size(); n++) {
						String insertId2=instLst2.get(n).getInsertId();
						com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse respDMSInsert = insertCaller.getResponse(stmtDate2 + "_" + insertId2, com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse.class);
						
						//update with insert document id
						
						if (respDMSInsert != null) {
							if (respDMSInsert.getResponsePayload() != null) {
								com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse.ResponsePayload respDMSInsertLoad = respDMSInsert.getResponsePayload();
								List<HistoryStatementListType> dmsInsertHistList = respDMSInsertLoad.getHistoryStatementList();  //list contains only one element, or ordered by load date
								if (dmsInsertHistList != null && dmsInsertHistList.size() > 0) {
									com.mbnaweb.xsd.types.statement.InsertListType insertListTp = dmsInsertHistList.get(0).getInsertList(); //pick up only the first one
									if (insertListTp != null) {
										List<InsertType> insertList = insertListTp.getInsert();   //list contains only one element
										instLst2.get(n).setInsertTitle(insertList.get(0).getInsertTitle());
										instLst2.get(n).setInsertId(insertList.get(0).getInsertId());
										instLst2.get(n).setDocumentId(insertList.get(0).getDocumentId());
									}
								}
							}
						}
					}//end of for(n)
				}
			}//end of while(iter2)
		}//end of stmtInsertTable != null,size>0
		
		//Step 3:
		for (int r=0; r<histList.size(); r++) {
			String stmtDate3 = histList.get(r).getStatementDate();
			List<InsertType> instLst3 = histList.get(r).getInsertList().getInsert();
			List<InsertType> instLstFrMap = stmtInsertTable.get(stmtDate3);
			for (int p=instLst3.size()-1; p>=0; p--) { instLst3.remove(p); }
			if ((instLstFrMap != null) && (instLstFrMap.size()>0)) {
				for (int q=0; q<instLstFrMap.size(); q++) { instLst3.add(instLstFrMap.get(q)); }
			}
		}
		//Search Process Inserts END
	}

    private com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse convertJsonToXml(DocumentList documentList) {

        com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse getStatementListForYearResponse = new com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse();
        
		if(documentList == null){
			getStatementListForYearResponse.setResponsePayload(new com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse.ResponsePayload());
			return getStatementListForYearResponse;
		}

        //check if there is error
        if (documentList.getDocument() == null || documentList.getDocument().isEmpty()) {
        	if(documentList.getStatus() == null){
        		getStatementListForYearResponse.setResponsePayload(new com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse.ResponsePayload());
        		return getStatementListForYearResponse;        		
        	}
            getStatementListForYearResponse.setStatus(documentList.getStatus().getServerStatusCode());
            
            for (Additionalstatus anAditionalStatus : documentList.getStatus().getAdditionalStatus()) {
                getStatementListForYearResponse.getErrorMsgs().add(anAditionalStatus.getStatusDesc());
            }
            return getStatementListForYearResponse;
        } 

        List<HistoryStatementListType> historyStatementListTypeList = new ArrayList<>();

        for(Document aDocument :  documentList.getDocument()) {

        	HistoryStatementListType historyStatementListType = new HistoryStatementListType();
            historyStatementListType.setDocumentId(aDocument.getDocumentId());

            InsertListType insertListType = new InsertListType();
            historyStatementListType.setInsertList(insertListType);

            for(MetadataItem aMetaDataItem : aDocument.getMetadataItem()) {

                if ( "ACCOUNTNUMBER".equalsIgnoreCase(aMetaDataItem.getKeyName())) {
                    historyStatementListType.setAccountNumber(aMetaDataItem.getValue());
                }

                if ( "LoadDate".equalsIgnoreCase(aMetaDataItem.getKeyName())) {
                    historyStatementListType.setLoadDate(aMetaDataItem.getValue());
                }

                if ( "StatementDate".equalsIgnoreCase(aMetaDataItem.getKeyName())) {
                    historyStatementListType.setStatementDate(aMetaDataItem.getValue());
                }

                if (aMetaDataItem.getKeyName().toUpperCase().contains("INSERT")) {
                    InsertType insertType = new InsertType();
                    insertType.setInsertId(aMetaDataItem.getValue());
                    insertListType.getInsert().add(insertType);
                }
            }
            historyStatementListTypeList.add(historyStatementListType);
        }

        com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse.ResponsePayload responsePayload = new com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse.ResponsePayload();
        responsePayload.getHistoryStatementList().addAll(historyStatementListTypeList);
        getStatementListForYearResponse.setResponsePayload(responsePayload);

        return getStatementListForYearResponse;
    }


    private com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse convertJsonToXmlForInsert(DocumentList documentList) {

        com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse getStatementListForYearResponse = new com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse();

        //check if there is error
        if (documentList != null && documentList.getDocument() == null || documentList.getDocument().isEmpty()) {
        	if(documentList.getStatus() != null){
        		getStatementListForYearResponse.setStatus(documentList.getStatus().getServerStatusCode());
        		for (Additionalstatus anAditionalStatus : documentList.getStatus().getAdditionalStatus()) {
        			getStatementListForYearResponse.getErrorMsgs().add(anAditionalStatus.getStatusDesc());
        		}
        	}
            return getStatementListForYearResponse;
        } 

        List<HistoryStatementListType> historyStatementListTypeList = new ArrayList<>();
        HistoryStatementListType historyStatementListType;

        Document aDocument = documentList.getDocument().get(0);

        historyStatementListType = new HistoryStatementListType();
        historyStatementListType.setDocumentId(aDocument.getDocumentId());

        InsertListType insertListType = new InsertListType();
        historyStatementListType.setInsertList(insertListType);
        InsertType insertType = new InsertType();
        insertListType.getInsert().add(insertType);

        insertType.setDocumentId(aDocument.getDocumentId());

        for(MetadataItem aMetaDataItem : aDocument.getMetadataItem()) {
			switch (aMetaDataItem.getKeyName().toUpperCase()) {
				case "DESCRIPTION":
					insertType.setInsertTitle(aMetaDataItem.getValue());
					break;
				case "FORMNUMBER":
					insertType.setInsertId(aMetaDataItem.getValue());
					break;
				
				default:
					break;
			}
//            if ( aMetaDataItem.getKeyName().equalsIgnoreCase("Description")) {
//                insertType.setInsertTitle(aMetaDataItem.getValue());
//            }
//
//            if ( aMetaDataItem.getKeyName().equalsIgnoreCase("FormNumber")) {
//                insertType.setInsertId(aMetaDataItem.getValue());
//            }

        }
        historyStatementListTypeList.add(historyStatementListType);

        com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse.ResponsePayload responsePayload = new com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse.ResponsePayload();

        responsePayload.getHistoryStatementList().addAll(historyStatementListTypeList);

        getStatementListForYearResponse.setResponsePayload(responsePayload);

        return getStatementListForYearResponse;
    }

    private void validateStatements(com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse resp, List<CardNumHistoryType> cardList) {

        if (resp == null) {
        	return;
        }
        
        com.mbnaweb.xsd.msgs.statement.GetStatementListForYearResponse.ResponsePayload respLoad = resp.getResponsePayload();
        if (respLoad == null) {
        	return;
        }
        
        List<HistoryStatementListType> histList = respLoad.getHistoryStatementList();
        if ( histList == null || histList.size() <= 0 ) {
        	return;
        }
        List<HistoryStatementListType> histListUI  =  DMSStatementFilterUtil.filterStatements(histList, cardList);
        
        for (int p = histList.size() - 1; p >= 0; p--) {
        	histList.remove(p);
        }
        for (int k = 0; k < histListUI.size(); k++) {
        	histList.add(histListUI.get(k));
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
