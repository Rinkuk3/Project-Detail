package com.td.mbna.msec.midtier.statement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbnaweb.xsd.msgs.statement.GetStatementActivityRequest;
import com.mbnaweb.xsd.msgs.statement.GetStatementResponse;
import com.mbnaweb.xsd.msgs.statement.GetStatementWithActivityRequest;
import com.mbnaweb.xsd.msgs.statement.GetStatementWithActivityResponse;
import com.mbnaweb.xsd.types.common.CardNumHistoryType;
import com.mbnaweb.xsd.types.statement.AvailableStatementListType;
import com.mbnaweb.xsd.types.statement.HistoryStatementListType;
import com.mbnaweb.xsd.types.statement.InsertListType;
import com.mbnaweb.xsd.types.statement.InsertType;
import com.mbnaweb.xsd.types.statement.StatementActivityStatusType;
import com.mbnaweb.xsd.types.statement.StmtActivityType;
import com.mbnaweb.xsd.types.statement.StmtOnlineSummaryType;
import com.td.api.dms.common.Additionalstatus;
import com.td.api.dms.request.DocumentSearchRequest;
import com.td.api.dms.response.Document;
import com.td.api.dms.response.DocumentList;
import com.td.api.dms.response.MetadataItem;
import com.td.mbna.msec.midtier.mbcca.MbnaCCA;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.services.TdStatementServiceUtil;
import com.td.mbna.msec.midtier.session.SessionMidProvider;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.types.common.CardHolderInfo;
import com.td.mbna.msec.midtier.util.BackEndSrvcUtil;
import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.JaxbUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.ParallelServiceCaller;
import com.td.mbna.msec.midtier.util.RequestUtil;
import com.td.mbna.msec.midtier.util.ServiceCall;
import com.td.mbna.msec.midtier.util.StatementUtil;
import com.td.mbna.msec.midtier.util.cache.DMApiCacheService;
import com.td.mbna.msec.midtier.util.ods.OdsHelper;
import com.td.mbna.msec.midtier.util.services.JAXBJsonConverter;
import com.td.mbna.msec.midtier.util.services.MSECConstants;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;


@Service
public class GetStatementWithActivityOperation implements MsecMidtierCommonOperations<com.td.mbna.msec.midtier.statement.payload.getStatementWithActivity.GetStatementWithActivityRequest,com.td.mbna.msec.midtier.statement.payload.getStatementWithActivity.GetStatementWithActivityResponse > {

	@Autowired
	private TDRestServiceUtil tdRestServiceUtil;
	
	@Autowired
	private SessionMidProvider sessionMidProvider;
	
	@Autowired
	private OdsHelper odsHelper;	
	
	@Autowired
	private MbnaCCA mbnaCCA;
	
	private static MbnaLogger logger = new MbnaLogger(GetStatementWithActivityOperation.class);
	
    private static final String STATEMENT_SUMMARY = "STMT_SUMMARY";
    private static final String STATEMENT_DOCUMENT = "STMT_DOCUMENT";
    private static final String STATEMENT_TRANSACTION = "STMT_TRANSACTION";

    // date format
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String DATE_FORMAT_DMSsearch = "MM/dd/yy";
    private static final String DATE_FORMAT_DMSresult = "yyyyMMdd";
    
    private static final String TdOp_getMainStatementList = "getMainStatementList";

    private static final String statementsFolder = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_DM_API_STATEMENT_FOLDER);
    private static final String insertsFolder = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_DM_API_INSERT_FOLDER);
    private static final String dmApiPortal = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_DM_API_PORTAL_VALUE);
    

    @Override
    public com.td.mbna.msec.midtier.statement.payload.getStatementWithActivity.GetStatementWithActivityResponse invokeService(com.td.mbna.msec.midtier.statement.payload.getStatementWithActivity.GetStatementWithActivityRequest request, String... token) {
    	String methodName = "GetStatementWithActivityOperation.invokeService()";
        logger.info("1-Entering "+methodName+" ...");

        try {

            // first convert json intf to JAXB intf
        	logger.debug(methodName, " 2-convert json intf to JAXB intf ... ");
            GetStatementWithActivityRequest xRequest = JAXBJsonConverter.convertJsonToJAXBInterface(request, GetStatementWithActivityRequest.class);

            //work around to convert date
            if (request.getRequestPayload().getStatementClosingDate() != null) {
            	logger.debug(methodName, " 3-convert Long closingDate to XMLGregorianCalendar closingDate ... ");
            	Long closingDate = Long.parseLong(request.getRequestPayload().getStatementClosingDate());
            	XMLGregorianCalendar gdate= JAXBJsonConverter.convert(closingDate);
            	xRequest.getRequestPayload().setStatementClosingDate(gdate);
            }

            // There are 3 situations that getStatementWithActivity will be called.
            // 1. call to get the statement legal insert.
            // 2. call when a closing date is picked.
            // 3. call when the statement tab is clicked, i.e. pick the first cycle date.
            GetStatementWithActivityResponse xResponse;
            if (xRequest.getRequestPayload().getInsertIdList() != null) {
                // get the statement legal insert.
            	logger.debug(methodName, " 4-get the statement legal insert ... ");
                xResponse = getStatementInsert(xRequest,token[0]);
            }
            else if (xRequest.getRequestPayload().getStatementClosingDate() != null) {
                // get the statement summary and the activities for a particular cycle date
            	logger.debug(methodName, " 5-get the statement summary and the activities for a particular cycle date ... ");
                xResponse = getStatementWithActivityForCycleDate(xRequest,token[0]);
            }
            else {
                // get the statement summary of the first cycle date and its activities. It also return a list of the
                // statements for all the cycles if asked.
            	logger.debug(methodName, " 6-get the statement summary of the first cycle date and its activities ... ");
                xResponse = getStatementWithActivityForFirstCycle(xRequest,token[0]);
            }

            // convert jaxb intf to json intf
            logger.debug(methodName, " 7-convert JAXB response to  json response ... ");
            com.td.mbna.msec.midtier.statement.payload.getStatementWithActivity.GetStatementWithActivityResponse response = JAXBJsonConverter.convertoJAXBToJsonInterface(xResponse, com.td.mbna.msec.midtier.statement.payload.getStatementWithActivity.GetStatementWithActivityResponse.class,DATE_FORMAT);
            com.td.mbna.msec.midtier.statement.payload.getStatementWithActivity.ResponsePayload responsePayload = response.getResponsePayload();
            logger.debug(methodName, " 8-updateStatementWithActivityPayloadWithCardHolderName(request, responsePayload) ... ");
            updateStatementWithActivityPayloadWithCardHolderName(request, responsePayload);
            logger.debug(methodName, " 9-return response ");
            return response;

        }  catch (Exception e) {
        	String message = "getStatementWithActivity failed ! ";
            logger.error( methodName, message+e.getLocalizedMessage(), e);

            throw ExceptionUtil.genRuntimeException(e);

        }

    }

    

    /**
     * Returns the statement insert
     *
     * @param xRequest - request containing the account number
     * @return response containing the statement insert information
     */
    private GetStatementWithActivityResponse getStatementInsert(final GetStatementWithActivityRequest xRequest,String token) throws   Exception
    {
    	String methodName = "getStatementInsert";
    	logger.debug(methodName, " 1-entering ... ");
    	
    	GetStatementWithActivityResponse xResponse = new GetStatementWithActivityResponse();
    	
    	// check request
    	if(xRequest == null || xRequest.getRequestPayload() == null || xRequest.getRequestPayload().getInsertIdList()== null){
    		return xResponse;
    	}

        final String connectId = xRequest.getSessionInfo().getConnectId();
        
        try {
        	// initiailize response
        	logger.debug(methodName, "  2-initiailize response ... ");
            GetStatementWithActivityResponse.ResponsePayload xRespLoad = new GetStatementWithActivityResponse.ResponsePayload();
            xResponse.setResponsePayload(xRespLoad);
            AvailableStatementListType xAvailStmtList = new AvailableStatementListType();
            xRespLoad.setAvailableStatementList(xAvailStmtList);
            List<HistoryStatementListType> xStmtInfoList = xAvailStmtList.getStatementInfo();
            
            InsertListType xInstLstTp = xRequest.getRequestPayload().getInsertIdList();
            if (xInstLstTp == null) {
            	return xResponse;
            }
            
            List<InsertType> xInstLst = xInstLstTp.getInsert();
            if ((xInstLst == null) || (xInstLst.size()<=0))  {
            	return xResponse;
            }
            
            
            // prepare parallel
            logger.debug(methodName, "  3-prepare parallel calls... ");
            ParallelServiceCaller insertCaller = new ParallelServiceCaller();
            
            if (xInstLst.size() == 1) { 
            	logger.debug(methodName, "  4-prepare single call ... ");
            	insertCaller.useSynchrousCall(); 
            }
            
            final JAXBContext mtJaxBContext = JaxbUtil.getJaxbContext("com.mbnaweb.xsd.msgs.statement");
            for (int n=0; n<xInstLst.size(); n++) {
            	final String insertId = xInstLst.get(n).getInsertId();
            	final Map<String, Object> paramValuesDMSInsert = new ConcurrentHashMap<String, Object>();
            	paramValuesDMSInsert.put(StatementUtil.DMS_formNumber, StatementUtil.getFormId(insertId));
            	paramValuesDMSInsert.put(StatementUtil.DMS_folderName, ConfigUtil.getProperty(StatementUtil.DMS_MainStatementInsert_Folder_External_Property_Key, StatementUtil.DMS_MainStatementInsert_Folder_Default));
            	logger.debug(methodName, "  5-starting parallel calls ... " + n);
            	ServiceCall<?> searchInsertCall = new ServiceCall<GetStatementResponse>() {
            		@Override
            		public GetStatementResponse invoke() throws Exception {
            			return (GetStatementResponse)invokeServiceSearchStmt(StatementUtil.TdOp_getMainStatementInsertInfo, StatementUtil.TdOp_getMainStatementInsertInfo, StatementUtil.TdOp_getMainStatementInsertInfo, connectId,  paramValuesDMSInsert, mtJaxBContext, null,token);
            		}
            	};
            	logger.debug(methodName, "  6-scheduleCall ... " + n);
            	insertCaller.scheduleCall(insertId, searchInsertCall);
            }//end of for()
            insertCaller.sync();
            
            List<HistoryStatementListType> xStmtInfoListDMSInsert = new ArrayList<HistoryStatementListType>();
            HistoryStatementListType xHistStmtItem = new HistoryStatementListType();
            InsertListType xInsertListTpFrDMS = new InsertListType();
            // process parallel calls responses
            logger.debug(methodName, "  7-process parallel calls responses ... " );
            for (int s=0; s<xInstLst.size(); s++) {
            	String insertId = xInstLst.get(s).getInsertId();
            	InsertType xInsertFrDMS = new InsertType();
            	logger.debug(methodName, "  8-process parallel calls responses ... " + s );
            	GetStatementResponse xRespDMSInsert = insertCaller.getResponse(insertId, GetStatementResponse.class);
            	if (xRespDMSInsert.getResponsePayload().getAvailableStatementList().getStatementInfo().size() == 0 ||
            			xRespDMSInsert.getResponsePayload().getAvailableStatementList().getStatementInfo().get(0).getInsertList().getInsert().size() == 0) {
            		logger.debug(methodName, " 9- process parallel calls responses ... " + s +" no insert");
            		String errorMsg = "InsertId :" + insertId + " not found ";
            		logger.error(methodName,errorMsg);
            		continue;
            	}
            	xInsertFrDMS.setInsertTitle(xRespDMSInsert.getResponsePayload().getAvailableStatementList().getStatementInfo().get(0).getInsertList().getInsert().get(0).getInsertTitle());
            	xInsertFrDMS.setInsertId(xRespDMSInsert.getResponsePayload().getAvailableStatementList().getStatementInfo().get(0).getInsertList().getInsert().get(0).getInsertId());
            	xInsertFrDMS.setDocumentId(xRespDMSInsert.getResponsePayload().getAvailableStatementList().getStatementInfo().get(0).getInsertList().getInsert().get(0).getDocumentId());
            	xInsertListTpFrDMS.getInsert().add(xInsertFrDMS);
            }
            xHistStmtItem.setInsertList(xInsertListTpFrDMS);
            xStmtInfoListDMSInsert.add(xHistStmtItem);
            
            if (xStmtInfoList != null) {
            	int stmtInfoListSize = xStmtInfoList.size();
            	for (int p=stmtInfoListSize-1; p>=0; p--) { xStmtInfoList.remove(p); }
            	for (int q=0; q<xStmtInfoListDMSInsert.size(); q++) {
            		xStmtInfoList.add(xStmtInfoListDMSInsert.get(q));
            	}
            }
            logger.debug(methodName, "  10-return responses ... " );
            return xResponse;
            //DMS Search Insert END
        }
        catch (Exception e) {
            logger.error(methodName,e.getLocalizedMessage(),e);
            throw ExceptionUtil.genRuntimeException(e);
        }
    }

    /**
     * Returns the statement summary and transactions for a closing date
     *
     * @param xRequest - request containing the account number
     * @return response containing the statement summary and trnasactions
     */
    private GetStatementWithActivityResponse getStatementWithActivityForCycleDate(final GetStatementWithActivityRequest xRequest, String token) throws   Exception
    {
    	if(xRequest == null){
    		return null;
    	}
    	String methodName = "getStatementWithActivityForCycleDate()";
        // If cycle date is given, we call parallel the call for retrieveCreditCardAccount and retrieveTransaction
        // Note: When the cycle date is given, it should never ask for "AvailableList"

        String statementClosingDate = JAXBJsonConverter.convertXmlGregorianToString(xRequest.getRequestPayload().getStatementClosingDate(),DATE_FORMAT);

        ParallelServiceCaller stmtInfoCaller = new ParallelServiceCaller();
        try {
        	logger.debug(methodName, " 1-prepare parallel calls ...");
            ServiceCall<?> stmtSummaryCall = new ServiceCall<GetStatementResponse>() {
                @Override
                public GetStatementResponse invoke() throws Exception {
                    return getStatementSummary(xRequest,token);
                }
            };
            stmtInfoCaller.scheduleCall(STATEMENT_SUMMARY, stmtSummaryCall);

            stmtInfoCaller.sync();

            GetStatementWithActivityResponse xResponse = new GetStatementWithActivityResponse();
            com.mbnaweb.xsd.msgs.statement.GetStatementWithActivityResponse.ResponsePayload xRespPL = new com.mbnaweb.xsd.msgs.statement.GetStatementWithActivityResponse.ResponsePayload();
            xResponse.setResponsePayload(xRespPL);

            // Get the result from retrieveCreditCardAccount
            logger.debug(methodName, " 2-process parallel calls response ...");
            GetStatementResponse xRespStmtSummary = stmtInfoCaller.getResponse(STATEMENT_SUMMARY, GetStatementResponse.class);
            xRespPL.setOnlineSummary(xRespStmtSummary.getResponsePayload().getOnlineSummary());
            if(xRequest != null){
            	if(xRespPL.getOnlineSummary() == null){
            		xRespPL.setOnlineSummary(new StmtOnlineSummaryType());
            	}
            	xRespPL.getOnlineSummary().setAcctEnding(xRequest.getAcctNum());
            }
            xRespPL.setAvailableStatementList(xRespStmtSummary.getResponsePayload().getAvailableStatementList());
            String statementPaymentDueDate = "";
			if(xRespStmtSummary.getResponsePayload().getOnlineSummary() != null && xRespStmtSummary.getResponsePayload().getOnlineSummary().getTotalMinimumPaymentDueDate() != null){
				statementPaymentDueDate = JAXBJsonConverter.convertXmlGregorianToString(xRespStmtSummary.getResponsePayload().getOnlineSummary().getTotalMinimumPaymentDueDate(),DATE_FORMAT);
			}
			final String dueDate = statementPaymentDueDate;

            // Use the current thread to get the transactions.
            logger.debug(methodName, " 3-prepare parallel calls to get the transactions ...");
            stmtInfoCaller.useSynchrousCall();
            ServiceCall<?> stmtTransactionCall = new ServiceCall<com.td.mbna.msec.midtier.statement.payload.getStatementActivity.GetStatementActivityResponse>() {
                @Override
                public com.td.mbna.msec.midtier.statement.payload.getStatementActivity.GetStatementActivityResponse invoke() throws Exception {
                	if(xRequest == null || xRequest.getSessionInfo() == null){
                		return null;
                	}
                	return mbnaCCA.retrieveStatementActivities(xRequest.getSessionInfo().getConnectId(),xRequest.getAcctNum(),statementClosingDate,dueDate,token);
                }
            };

            stmtInfoCaller.scheduleCall(STATEMENT_TRANSACTION, stmtTransactionCall);

            stmtInfoCaller.sync();


            // Get the result from retrieveTransaction
            logger.debug(methodName, " 4-process get the transactions parallel response  ...");
            com.td.mbna.msec.midtier.statement.payload.getStatementActivity.GetStatementActivityResponse respStmtTransaction = stmtInfoCaller.getResponse(STATEMENT_TRANSACTION, com.td.mbna.msec.midtier.statement.payload.getStatementActivity.GetStatementActivityResponse.class);
            xRespPL.getStatementActivities().addAll(convertJsonToJaxb(respStmtTransaction.getResponsePayload().getStatementActivities()));
            xRespPL.setNumActivitiesExceedsMax(respStmtTransaction.getResponsePayload().getNumActivitiesExceedsMax() == null ? false : respStmtTransaction.getResponsePayload().getNumActivitiesExceedsMax().booleanValue());
            logger.debug(methodName, " 5-return response  ...");
            return xResponse;
        }
        catch (Exception e) {
            logger.error(methodName,e.getLocalizedMessage(),e);
            throw ExceptionUtil.genRuntimeException(e);
        }
    }

    private List<StmtActivityType> convertJsonToJaxb(List<com.td.mbna.msec.midtier.types.common.StmtActivityType> stmtActivityTypeList) throws Exception {

        List<StmtActivityType> stmtActivityTypes = new ArrayList<>();
        
        if( stmtActivityTypeList == null || stmtActivityTypeList.isEmpty()){
        	return stmtActivityTypes;
        }
        
        StmtActivityType stmtActivityType;
        
        for(com.td.mbna.msec.midtier.types.common.StmtActivityType stmtActivityTypeJson : stmtActivityTypeList) {

            stmtActivityType = JAXBJsonConverter.convertJsonToJAXBInterface(stmtActivityTypeJson, StmtActivityType.class);
            stmtActivityTypes.add(stmtActivityType);

        }

        return stmtActivityTypes;
    }

    /**
     * Returns the statement summary for first cycle and its transactions
     */
    private GetStatementWithActivityResponse getStatementSummaryWithTransaction(final GetStatementWithActivityRequest xRequest, String token) throws Exception {
        GetStatementWithActivityResponse xResponse = new GetStatementWithActivityResponse();
        GetStatementWithActivityResponse.ResponsePayload xRespPL = new GetStatementWithActivityResponse.ResponsePayload();
        xResponse.setResponsePayload(xRespPL);

        // Get the summary
        GetStatementResponse xSummaryResponse = getStatementSummary(xRequest,token);
        xRespPL.setOnlineSummary(xSummaryResponse.getResponsePayload().getOnlineSummary());
        xRespPL.setAvailableStatementList(xSummaryResponse.getResponsePayload().getAvailableStatementList());

        // Check if there is any transaction. if yes, call retrieveTransactions
        List<StatementActivityStatusType> xStatementActivityStatusList = null;
        if (xResponse.getResponsePayload().getAvailableStatementList() != null) {
            xStatementActivityStatusList = xResponse.getResponsePayload().getAvailableStatementList().getStatementActivityStatus();
        }

        if (xStatementActivityStatusList == null || xStatementActivityStatusList.size() <= 0 || xStatementActivityStatusList.get(0) == null || !xStatementActivityStatusList.get(0).isActivityAvailable()) {
        	return xResponse;
        }
        StatementActivityStatusType xStatementActivityStatus = xStatementActivityStatusList.get(0);
        GetStatementActivityRequest xActivityRequest = new GetStatementActivityRequest();
        RequestUtil.copyHeader(xRequest, xActivityRequest);
        GetStatementActivityRequest.RequestPayload xGetStmtActivityReqPL = new GetStatementActivityRequest.RequestPayload();
        xActivityRequest.setRequestPayload(xGetStmtActivityReqPL);
        
        populateCardHolderInfo(xRequest,xActivityRequest);
        
        xGetStmtActivityReqPL.setStatementClosingDate(xStatementActivityStatus.getStatementEndDate());
        xGetStmtActivityReqPL.setStatementPaymentDueDate(xStatementActivityStatus.getStatementPaymentDueDate());
        
        com.td.mbna.msec.midtier.statement.payload.getStatementActivity.GetStatementActivityResponse getStatementActivityResponse = mbnaCCA.retrieveStatementActivities(xActivityRequest.getSessionInfo().getConnectId(),xActivityRequest.getAcctNum(), JAXBJsonConverter.convertXmlGregorianToString(xActivityRequest.getRequestPayload().getStatementClosingDate(),DATE_FORMAT),
        		JAXBJsonConverter.convertXmlGregorianToString(xActivityRequest.getRequestPayload().getStatementPaymentDueDate(),DATE_FORMAT),token);
        
        
        if (getStatementActivityResponse != null && getStatementActivityResponse.getResponsePayload() != null) {
        	xRespPL.getStatementActivities().addAll(convertJsonToJaxb(getStatementActivityResponse.getResponsePayload().getStatementActivities()));
        	xRespPL.setNumActivitiesExceedsMax(getStatementActivityResponse.getResponsePayload().getNumActivitiesExceedsMax() == null ? false : getStatementActivityResponse.getResponsePayload().getNumActivitiesExceedsMax().booleanValue());
        }
        return xResponse;
    }

    /**
     * Returns the statement summary
     */
    private GetStatementResponse getStatementSummary(final GetStatementWithActivityRequest request,String token) throws Exception {

        String statementEndDate = null;

        if(request.getRequestPayload().getStatementClosingDate() != null) {
            Date statementDate = request.getRequestPayload().getStatementClosingDate().toGregorianCalendar().getTime();
            DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
            statementEndDate = dateFormat.format(statementDate);
        }


        GetStatementResponse response = mbnaCCA.retrieveStatementResponse(request.getSessionInfo().getConnectId(), request.getAcctNum(),statementEndDate,token);

        if (response.getResponsePayload().getAvailableStatementList() != null
                && response.getResponsePayload().getAvailableStatementList().getStatementEndDate() != null
                && response.getResponsePayload().getAvailableStatementList().getStatementEndDate().size() > 0) {
            StatementUtil.limitCycles(response.getResponsePayload().getAvailableStatementList());
        }

        return response;
    }


    /**
     * Returns the statement summary, available cycles with their statement info and transactions for a closing date
     *
     * @param xRequest - request containing the account number
     * @return response containing the statement summary, available cycles with their statement info and transactions
     */
    private GetStatementWithActivityResponse getStatementWithActivityForFirstCycle(final GetStatementWithActivityRequest xRequest,String token) throws  Exception
    {
        // Since the cycle date is empty, we have to call the retrieveCreditCard first before we call retrieveTransaction
        // If list of cycle dates is request, we have to call DMS searchDocuments
        ParallelServiceCaller firstStmtInfoCaller = new ParallelServiceCaller();
        String methodName = "getStatementWithActivityForFirstCycle";

        try {
        	logger.debug(methodName, " prepare parrallel calls for GetStatementWithActivityResponse ...");
            ServiceCall<?> firstStmtInfoCall = new ServiceCall<GetStatementWithActivityResponse>() {
                @Override
                public GetStatementWithActivityResponse invoke() throws Exception {
                    return (GetStatementWithActivityResponse)getStatementSummaryWithTransaction(xRequest,token);
                }
            };
            logger.debug(methodName, " schedule parrallel calls for GetStatementWithActivityResponse ...");
            firstStmtInfoCaller.scheduleCall(STATEMENT_SUMMARY, firstStmtInfoCall);

            // Use the current thread to get the statement
            logger.debug(methodName, " fire parrallel calls for GetStatementWithActivityResponse ...");
            firstStmtInfoCaller.useSynchrousCall();

            logger.debug(methodName, " prepare parrallel calls for GetStatementResponse ...");
            ServiceCall<?> availableInfoCall = new ServiceCall<GetStatementResponse>() {
                @Override
                public GetStatementResponse invoke() throws Exception {
                    return (GetStatementResponse)getStatementAvailableList(xRequest,token);
                }
            };
            logger.debug(methodName, " schedule parrallel calls for GetStatementResponse ...");
            firstStmtInfoCaller.scheduleCall(STATEMENT_DOCUMENT, availableInfoCall);

            logger.debug(methodName, " fire parrallel calls for GetStatementResponse ...");
            firstStmtInfoCaller.sync();

            logger.debug(methodName, " process parallel calls response ...");
            GetStatementWithActivityResponse xResponse = firstStmtInfoCaller.getResponse(STATEMENT_SUMMARY, GetStatementWithActivityResponse.class);
            logger.toJson(xResponse);
            GetStatementResponse respDMS = firstStmtInfoCaller.getResponse(STATEMENT_DOCUMENT, GetStatementResponse.class);
            logger.toJson(respDMS);
            
            AvailableStatementListType availStmtList = xResponse.getResponsePayload().getAvailableStatementList();
            logger.toJson(availStmtList);
            
            List<HistoryStatementListType> stmtInfoList = null;
            List<XMLGregorianCalendar> dtList = null;
            
            if (availStmtList != null) {
                dtList = availStmtList.getStatementEndDate();
                stmtInfoList = availStmtList.getStatementInfo();
            }

            logger.debug(methodName, " start process StatementInfo ");
            if (dtList != null && dtList.size() > 0 && (respDMS != null && respDMS.getResponsePayload() != null)) {

                    AvailableStatementListType availStmtListDMS = respDMS.getResponsePayload().getAvailableStatementList();
                    if (availStmtListDMS != null) {
                        List<HistoryStatementListType> stmtInfoListDMS = availStmtListDMS.getStatementInfo();
                        if (stmtInfoListDMS != null) {
                            // Only include the number of the list of statements in the cycle
                            stmtInfoListDMS = checkRange(stmtInfoListDMS, dtList);
                            for (int i=0; i<stmtInfoListDMS.size(); i++) {
                                InsertListType insertListTypeDMS = stmtInfoListDMS.get(i).getInsertList();
                                if (insertListTypeDMS != null) {
                                    List<InsertType> insertListDMS = insertListTypeDMS.getInsert();
                                    if (insertListDMS != null) {
                                        List<InsertType> insertListNEW = new ArrayList<InsertType>();
                                        for (int t=0; t<insertListDMS.size(); t++) {
                                            String insertId=insertListDMS.get(t).getInsertId();
                                            if (StatementUtil.isValidLegalInsertId(insertId)) {
                                                InsertType insert = new InsertType();
                                                insert.setInsertId(insertId);
                                                insertListNEW.add(insert);
                                            }else {
                                                logger.debug(insertId + " is not a valid insert - skipped.");
                                            }
                                        }
                                        for (int p=insertListDMS.size()-1; p>=0; p--) { insertListDMS.remove(p); }
                                        if (insertListNEW.size() > 0) {
                                            for (int u=0; u<insertListNEW.size(); u++) { insertListDMS.add(insertListNEW.get(u)); }
                                        }
                                    }
                                }

                                stmtInfoList.add(stmtInfoListDMS.get(i));
                            }
                        }
                    }

            }else{
                if(stmtInfoList != null){
                	stmtInfoList.clear();
                }else{
                	 stmtInfoList = new ArrayList<HistoryStatementListType>();
                }
                HistoryStatementListType DMSdownFlag = new HistoryStatementListType();
                DMSdownFlag.setAccountNumber("DMSDOWN");
                stmtInfoList.add(DMSdownFlag);
            }
            logger.debug(methodName, " finished process StatementInfo ");
            
			if (xResponse.getResponsePayload().getOnlineSummary() != null) {
				xResponse.getResponsePayload().getOnlineSummary().setAcctEnding(xRequest.getAcctNum());
			} else {
				logger.debug("Null value obtained for OnlineSummary due to absence of cycles for account="	+ xRequest.getAcctNum());
			}
             
            
            return xResponse;

        } catch (Exception e) {
            logger.error(methodName,e.getLocalizedMessage(),e);
            throw ExceptionUtil.genRuntimeException(e);
        }
    }

    private void updateStatementWithActivityPayloadWithCardHolderName( com.td.mbna.msec.midtier.statement.payload.getStatementWithActivity.GetStatementWithActivityRequest request, com.td.mbna.msec.midtier.statement.payload.getStatementWithActivity.ResponsePayload snapshotPayload) {
   
    	List<com.td.mbna.msec.midtier.types.common.StmtActivityType> stmtActivities = snapshotPayload.getStatementActivities();
        if(stmtActivities == null || stmtActivities.isEmpty()){
        	return;
        }

        com.td.mbna.msec.midtier.statement.payload.getStatementWithActivity.RequestPayload requestPl = request.getRequestPayload();
        if(requestPl == null){
        	return;
        }

        List<CardHolderInfo> cardHoderInfos = requestPl.getCardHolderInfos();
        if(cardHoderInfos == null || cardHoderInfos.isEmpty()){
        	return;
        }

        for(CardHolderInfo cardHolderInfo : cardHoderInfos ){
        	if(cardHolderInfo == null){
        		continue;
        	}
            String cardHoderName = cardHolderInfo.getCardHolderName();
            String cardNumber = cardHolderInfo.getCardNumber();
            for(com.td.mbna.msec.midtier.types.common.StmtActivityType stmtActivity : stmtActivities){
                String accId = stmtActivity.getAcctId();
                if(accId.trim().equals(cardNumber.trim())){
                    stmtActivity.setCardHolderName(cardHoderName);
                }
            }
        }

    }



    /**
     * Returns the statement summary for first cycle and its transactions
     */
    private GetStatementResponse getStatementAvailableList(final GetStatementWithActivityRequest request,String token) throws Exception {

        String methodName = "getStatementAvailableList";

        //DMS Search Closing Dates BEGIN
        //String cardNumber;
        if (request == null || request.getRequestPayload() == null || !request.getRequestPayload().isWithAvailableList()) {
        	return null;
        }
        
        GetStatementResponse response = null;
        String custId = request.getCustId();
        String acctId = request.getAcctNum();
        
        logger.debug(methodName, " starting OdsHelper.getCardHistory("+custId+", "+acctId+") call ...");
        // TODO: improve here for testing, it is better to implement in the SOAP service and REST API interceptor
//        String sKey = SESSION_XHISTORY_CARDS+custId+acctId;
//        String sCalledKey = SESSION_XHISTORY_CARDS+custId+acctId+"_called_";
//        List<CardNumHistoryType> xHistoryCards = (List<CardNumHistoryType>) sessionMidProvider.getSessionAttribute(sKey);
//        String sCalledValue = (String) sessionMidProvider.getSessionAttribute(sCalledKey);
//        // 1. check cache if historyCards is already in cache then get it from cache
//        if(!"true".equalsIgnoreCase(sCalledValue)){
//        	// 2. if not, then call bellow
        List<CardNumHistoryType> xHistoryCards = odsHelper.getCardHistory(custId, acctId);
//        	// 3. add to cache
//        	sessionMidProvider.setSessionAttribute(sKey, xHistoryCards);
//        	sessionMidProvider.setSessionAttribute(sCalledKey, "true");
//        }
        
        Map<String, Object> paramValuesDMS = new HashMap<String, Object>();
        paramValuesDMS.put("AccountNumber", DMSStatementFilterUtil.buildDMSCardList(xHistoryCards));
        
        // Get all the possible statements
        
        GregorianCalendar closingDateEnd = new GregorianCalendar();
        GregorianCalendar closingDateStart = new GregorianCalendar();
        closingDateStart.add(Calendar.MONTH, -1 * StatementUtil.MAX_NUMBER_OF_CYCLES_DISPLAYED - 1);
        
        SimpleDateFormat dateFmt = new SimpleDateFormat(DATE_FORMAT_DMSsearch);
        String startDate = dateFmt.format(closingDateStart.getTime());
        String endDate = dateFmt.format(closingDateEnd.getTime());
        
        paramValuesDMS.put("StartDate", startDate);
        paramValuesDMS.put("EndDate", endDate);
        
        logger.debug("Statement Query: " + startDate + ", " + endDate);
        
        final String connectId = request.getSessionInfo().getConnectId();
        final JAXBContext mtJaxBContext = JaxbUtil.getJaxbContext("com.mbnaweb.xsd.msgs.statement");
        try{
        	response = (GetStatementResponse)invokeServiceSearchStmt(TdOp_getMainStatementList, TdOp_getMainStatementList, TdOp_getMainStatementList, connectId,  paramValuesDMS, mtJaxBContext, xHistoryCards,token);
        }catch(Exception exp){
        	logger.error(methodName,"Statements page2: - Document Management Service failure with token ="+token, exp);
        }
        logger.debug(methodName, "returns response.");
        logger.toJson(response);
        return response;
        
    }


    private List<HistoryStatementListType> checkRange(List<HistoryStatementListType> stmtInfoListDMS, List<XMLGregorianCalendar> dtList) throws Exception {
    	
    	String methodName = "checkRange";
    	
    	logger.debug(methodName, " starting with ");
    	logger.toJson(stmtInfoListDMS);
    	logger.toJson(dtList);
    	
        List<HistoryStatementListType> filteredList = new ArrayList<HistoryStatementListType>();
        if(stmtInfoListDMS == null || stmtInfoListDMS.isEmpty()){
        	return filteredList;
        }
        GregorianCalendar closingDateStart = dtList.get(dtList.size()-1).toGregorianCalendar();
        GregorianCalendar closingDateEnd   = dtList.get(0).toGregorianCalendar();

        logger.debug(methodName, "closingDateStart = " + closingDateStart );
        logger.debug(methodName, "closingDateEnd = " + closingDateEnd );
        GregorianCalendar stmtSearchStartDate = new GregorianCalendar();
        GregorianCalendar stmtSearchEndDate = new GregorianCalendar();
        logger.debug(methodName, "stmtSearchStartDate = " + stmtSearchStartDate );
        logger.debug(methodName, "stmtSearchEndDate = " + stmtSearchEndDate );

        int futureDaysOffset = Integer.parseInt(ConfigUtil.getProperty("statement.search.futureDays.offset"));
        logger.debug(methodName, "futureDaysOffset = " + futureDaysOffset );

        stmtSearchStartDate.set(Calendar.YEAR,         	closingDateStart.get(Calendar.YEAR));
        stmtSearchStartDate.set(Calendar.MONTH,        	closingDateStart.get(Calendar.MONTH));
        stmtSearchStartDate.set(Calendar.DAY_OF_MONTH, 	closingDateStart.get(Calendar.DAY_OF_MONTH));
        stmtSearchStartDate.add(Calendar.DAY_OF_MONTH, -1);
        logger.debug(methodName, " after re-assign value from closingDateStart "+closingDateStart+" to stmtSearchStartDate = " + stmtSearchStartDate );

        stmtSearchEndDate.set(Calendar.YEAR,         	closingDateEnd.get(Calendar.YEAR));
        stmtSearchEndDate.set(Calendar.MONTH,        	closingDateEnd.get(Calendar.MONTH));
        stmtSearchEndDate.set(Calendar.DAY_OF_MONTH, 	closingDateEnd.get(Calendar.DAY_OF_MONTH));
        stmtSearchEndDate.add(Calendar.DAY_OF_MONTH, futureDaysOffset);
        logger.debug(methodName, " after re-assign value from closingDateEnd "+closingDateEnd+" to stmtSearchEndDate = " + stmtSearchEndDate );

        Date stmtStart = stmtSearchStartDate.getTime();
        Date stmtEnd = stmtSearchEndDate.getTime();
        logger.debug(methodName, " stmtStart " + stmtStart  );
        logger.debug(methodName, " stmtEnd = " + stmtEnd );

        SimpleDateFormat dateFmt = new SimpleDateFormat(DATE_FORMAT_DMSresult);
        for (HistoryStatementListType historyStmt: stmtInfoListDMS) {

            Date stmtDate = dateFmt.parse(historyStmt.getStatementDate());
            logger.debug(methodName, " stmtDate = " + stmtDate);
            if (stmtDate.after(stmtStart) && stmtDate.before(stmtEnd)) {
            	logger.debug(methodName, " stmtDate = " + stmtDate + " is between stmtStart : " + stmtStart + " and stmtEnd : " + stmtEnd);
                filteredList.add(historyStmt);
            }
        }
        logger.toJson(filteredList);
        return filteredList;
    }


    private Object invokeServiceSearchStmt(String tdOpRq, String tdOpRqtranslate, String tdOpRstranslate, String connectId, Map<String, Object> rqParmValues,  JAXBContext mtJaxBContext, List<CardNumHistoryType> xCardList,String token) throws Exception {

        GetStatementResponse resp;
        DocumentSearchRequest documentSearchRequest = null;
        DocumentList documentList;

        if (TdOp_getMainStatementList.equalsIgnoreCase(tdOpRq)) {

            String cardNumbersList = DMSStatementFilterUtil.buildDMSCardList(xCardList);
            documentSearchRequest = TdStatementServiceUtil.createDocumentSearchRequest(statementsFolder,dmApiPortal,cardNumbersList,(String) rqParmValues.get("StartDate"),(String) rqParmValues.get("EndDate"));

            if ( documentSearchRequest != null) {
                documentList = tdRestServiceUtil.invokeRestService(BackEndSrvcUtil.TDOperation.TdDocuManagementService_search, documentSearchRequest, DocumentList.class, token);
            }
            //in case of AU, where search is not needed
            else {
                //set empty list
                documentList = new DocumentList();
                documentList.setDocument(new ArrayList<>());
            }

            resp  = convertJsonToXml(documentList);
        } else {
        	documentList = DMApiCacheService.getInsertInfo((String)rqParmValues.get(StatementUtil.DMS_formNumber),token,dmApiPortal,insertsFolder,tdRestServiceUtil);
            resp  = convertJsonToXmlForInsert(documentList);
        }


        if ((resp == null) || (! TdOp_getMainStatementList.equalsIgnoreCase(tdOpRq))){
            return resp;
        }
        GetStatementResponse.ResponsePayload respLoad = resp.getResponsePayload();
        if (respLoad == null) {
        	return resp;
        }
        AvailableStatementListType availStmtList = respLoad.getAvailableStatementList();
        if (availStmtList == null) {
        	return resp;
        }
        List<HistoryStatementListType> stmtInfoList = availStmtList.getStatementInfo();
        List<HistoryStatementListType> stmtInfoListUI = null;
        if ((stmtInfoList == null) || (stmtInfoList.size()<=0)) {
        	return resp;
        }
        stmtInfoListUI = DMSStatementFilterUtil.filterStatements(stmtInfoList, xCardList);
        
        for (int p=stmtInfoList.size()-1; p>=0; p--) { 
        	stmtInfoList.remove(p); 
        }
        for (int k=0; k<stmtInfoListUI.size(); k++) { 
        	stmtInfoList.add(stmtInfoListUI.get(k)); 
        }

        return resp;

    }//end of invokeServiceSearchStmt()

    private GetStatementResponse convertJsonToXmlForInsert(DocumentList documentList) {

        GetStatementResponse xGetStatementResponse = new GetStatementResponse();


        //check if there is error
        if (documentList != null && documentList.getDocument() == null || documentList.getDocument().size() <= 0) {
        	List<Additionalstatus> aStatus = null;
        	if(documentList.getStatus() != null){
        		xGetStatementResponse.setStatus(documentList.getStatus().getServerStatusCode());
        		aStatus = documentList.getStatus().getAdditionalStatus();
        	}
            if(aStatus != null){
            	for (Additionalstatus anAditionalStatus : aStatus) {
            		if(anAditionalStatus == null){
            			continue;
            		}
            		xGetStatementResponse.getErrorMsgs().add(anAditionalStatus.getStatusDesc());
            	}
            }
            return xGetStatementResponse;
        } 

        AvailableStatementListType availableStatementListType = new AvailableStatementListType();

        HistoryStatementListType aStatementInfo;

        aStatementInfo = new HistoryStatementListType();
        availableStatementListType.getStatementInfo().add(aStatementInfo);

        Document aDocument = documentList.getDocument().get(0);

        aStatementInfo.setDocumentId(aDocument.getDocumentId());

        InsertListType insertListType = new InsertListType();
        aStatementInfo.setInsertList(insertListType);
        InsertType insertType = new InsertType();
        insertListType.getInsert().add(insertType);

        insertType.setDocumentId(aDocument.getDocumentId());

        for(MetadataItem aMetaDataItem : aDocument.getMetadataItem()) {
        	if(aMetaDataItem == null){
        		continue;
        	}
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

        }


        com.mbnaweb.xsd.msgs.statement.GetStatementResponse.ResponsePayload xResponsePayload = new com.mbnaweb.xsd.msgs.statement.GetStatementResponse.ResponsePayload();
        xResponsePayload.setAvailableStatementList(availableStatementListType);

        xGetStatementResponse.setResponsePayload(xResponsePayload);


        return xGetStatementResponse;
    }


    private GetStatementResponse convertJsonToXml(DocumentList documentList) {

        GetStatementResponse getStatementListForYearResponse = new GetStatementResponse();


        //check if there is error
        if (documentList.getDocument() == null) {
        	List<Additionalstatus> aStatus = null;
        	if(documentList.getStatus() != null){
        		getStatementListForYearResponse.setStatus(documentList.getStatus().getServerStatusCode());
        		aStatus = documentList.getStatus().getAdditionalStatus();
        	}
        	if(aStatus != null){
        		for (Additionalstatus anAditionalStatus : aStatus) {
        			getStatementListForYearResponse.getErrorMsgs().add(anAditionalStatus.getStatusDesc());
        		}
        	}
            return getStatementListForYearResponse;
        } 

        AvailableStatementListType availableStatementListType = new AvailableStatementListType();

        HistoryStatementListType aStatementInfo;

        for(Document aDocument :  documentList.getDocument()) {

        	if(aDocument == null){
        		continue;
        	}
            aStatementInfo = new HistoryStatementListType();
            availableStatementListType.getStatementInfo().add(aStatementInfo);

            aStatementInfo.setDocumentId(aDocument.getDocumentId());

            InsertListType insertListType = new InsertListType();
            aStatementInfo.setInsertList(insertListType);

            for(MetadataItem aMetaDataItem : aDocument.getMetadataItem()) {
            	switch (aMetaDataItem.getKeyName().toUpperCase()) {
				case "ACCOUNTNUMBER":
					aStatementInfo.setAccountNumber(aMetaDataItem.getValue());
					break;
				case "LOADDATE":
					aStatementInfo.setLoadDate(aMetaDataItem.getValue());
					break;
				case "STATEMENTDATE":
					aStatementInfo.setStatementDate(aMetaDataItem.getValue());
					break;
				case "INSERT":
					InsertType insertType = new InsertType();
                    insertType.setInsertId(aMetaDataItem.getValue());
                    insertListType.getInsert().add(insertType);
					break;

				default:
					break;
				}

            }

        }

        com.mbnaweb.xsd.msgs.statement.GetStatementResponse.ResponsePayload responsePayload = new com.mbnaweb.xsd.msgs.statement.GetStatementResponse.ResponsePayload();
        responsePayload.setAvailableStatementList(availableStatementListType);
        getStatementListForYearResponse.setResponsePayload(responsePayload);

        return getStatementListForYearResponse;
    }

    private void populateCardHolderInfo(GetStatementWithActivityRequest request, GetStatementActivityRequest activityRequest ) {

    	if(request == null || request.getRequestPayload() == null || request.getRequestPayload().getCardHolderInfo().isEmpty()){
    		return;
    	}
        GetStatementActivityRequest.RequestPayload.CardHolderInfo cardHolderInfo ;

        for(com.mbnaweb.xsd.msgs.statement.GetStatementWithActivityRequest.RequestPayload.CardHolderInfo cardHolderInfo1 : request.getRequestPayload().getCardHolderInfo() ) {
        	if(cardHolderInfo1 == null){
        		continue;
        	}
            cardHolderInfo = new GetStatementActivityRequest.RequestPayload.CardHolderInfo();
            cardHolderInfo.setCardNumber(cardHolderInfo1.getCardNumber());
            cardHolderInfo.setCardHolderName(cardHolderInfo1.getCardHolderName());

            activityRequest.getRequestPayload().getCardHolderInfo().add(cardHolderInfo);
        }
    }

//  private GetStatementWithActivityResponse prepareErrorStatementWithActivityResponse(
//  List<String> errorMessage) {
//GetStatementWithActivityResponse getStatementResponse = new GetStatementWithActivityResponse();
//getStatementResponse.setErrorMsgs(errorMessage);
//return getStatementResponse;
//}
    
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
