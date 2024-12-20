package com.td.mbna.msec.midtier.statement;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.td.api.dms.request.DocumentRetrievalRequest;
import com.td.api.dms.response.retrieval.DocumentRetrievalResponse;
import com.td.mbna.msec.midtier.exception.SystemError;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.statement.payload.getStatementFileFromId.GetStatementFileFromIdRequest;
import com.td.mbna.msec.midtier.statement.payload.getStatementFileFromId.GetStatementFileFromIdResponse;
import com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.BackEndSrvcUtil;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.StatementUtil;
import com.td.mbna.msec.midtier.util.services.JAXBJsonConverter;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;

@Service
public class GetStatementFileFromIdOperation implements MsecMidtierCommonOperations<GetStatementFileFromIdRequest,GetStatementFileFromIdResponse> {

    private static MbnaLogger logger = new MbnaLogger(GetStatementFileFromIdOperation.class);

    private static final String GENERAL_ERROR = "MS601";

    @Autowired
    private TDRestServiceUtil tdRestServiceUtil;

    @Override
    public GetStatementFileFromIdResponse invokeService(GetStatementFileFromIdRequest request, String... token) {

        String methodName = "getStatementFileFromId";

        com.mbnaweb.xsd.msgs.statement.GetStatementFileFromIdResponse xJaxbResponse = null;
        
        String docId = request.getRequestPayload().getDocumentId();
        
        try {
        	if(docId == null || docId.isEmpty()){
        		logger.error(methodName,"Document ID is null");
        		
        		com.mbnaweb.xsd.types.common.SystemException se = new com.mbnaweb.xsd.types.common.SystemException();
        		se.setErrorDescription("Document ID is null");
        		se.setErrorSource("GetStatementFileFromIdOperationRealImpl");
        		
        		SystemError systemError = new SystemError();
        		systemError.setFaultInfo(se);
        		throw systemError;
        	}
        	
            String folderName = null;
			switch (request.getRequestPayload().getFolder().toUpperCase()) {
				case StatementUtil.DMS_MainStatement_Folder_Indicator:
					folderName = "".equals(TDwsServiceUtil.getTDServiceParam("TD_DOCUMANAGEMENT_SERVLET_FOLDER")) ? StatementUtil.DMS_MainStatement_Folder_Default
							: TDwsServiceUtil.getTDServiceParam("TD_DOCUMANAGEMENT_SERVLET_FOLDER");
					break;
				case StatementUtil.DMS_MainStatementInsert_Folder_Indicator:
					folderName = "".equals(TDwsServiceUtil.getTDServiceParam("TD_DOCUMANAGEMENT_SERVLET_FOLDER_MAININSRT")) ? StatementUtil.DMS_MainStatementInsert_Folder_Default
							: TDwsServiceUtil.getTDServiceParam("TD_DOCUMANAGEMENT_SERVLET_FOLDER_MAININSRT");
					break;
				case StatementUtil.DMS_HistStatement_Folder_Indicator:
					folderName = "".equals(TDwsServiceUtil.getTDServiceParam("TD_DOCUMANAGEMENT_SERVLET_FOLDER_HISTSTMT")) ? StatementUtil.DMS_HistStatement_Folder_Default
							: TDwsServiceUtil.getTDServiceParam("TD_DOCUMANAGEMENT_SERVLET_FOLDER_HISTSTMT");
					break;
				case StatementUtil.DMS_HistStatementOngoingInsert_Folder_Indicator:
					folderName = "".equals(TDwsServiceUtil.getTDServiceParam("TD_DOCUMANAGEMENT_SERVLET_FOLDER_HISTONGINSRT")) ? StatementUtil.DMS_HistStatementOngoingInsert_Folder_Default
							: TDwsServiceUtil.getTDServiceParam("TD_DOCUMANAGEMENT_SERVLET_FOLDER_HISTONGINSRT");
					break;
				default:
					break;
			}
//            if (StatementUtil.DMS_MainStatement_Folder_Indicator.equalsIgnoreCase(request.getRequestPayload().getFolder())) {
//                folderName = "".equals(TDwsServiceUtil.getTDServiceParam("TD_DOCUMANAGEMENT_SERVLET_FOLDER")) ? StatementUtil.DMS_MainStatement_Folder_Default
//                        : TDwsServiceUtil.getTDServiceParam("TD_DOCUMANAGEMENT_SERVLET_FOLDER");
//            } else if (StatementUtil.DMS_MainStatementInsert_Folder_Indicator.equalsIgnoreCase(request.getRequestPayload().getFolder())) {
//                folderName = "".equals(TDwsServiceUtil.getTDServiceParam("TD_DOCUMANAGEMENT_SERVLET_FOLDER_MAININSRT")) ? StatementUtil.DMS_MainStatementInsert_Folder_Default
//                        : TDwsServiceUtil.getTDServiceParam("TD_DOCUMANAGEMENT_SERVLET_FOLDER_MAININSRT");
//            } else if (StatementUtil.DMS_HistStatement_Folder_Indicator.equalsIgnoreCase(request.getRequestPayload().getFolder())) {
//                folderName = "".equals(TDwsServiceUtil.getTDServiceParam("TD_DOCUMANAGEMENT_SERVLET_FOLDER_HISTSTMT")) ? StatementUtil.DMS_HistStatement_Folder_Default
//                        : TDwsServiceUtil.getTDServiceParam("TD_DOCUMANAGEMENT_SERVLET_FOLDER_HISTSTMT");
//            } else if (StatementUtil.DMS_HistStatementOngoingInsert_Folder_Indicator.equalsIgnoreCase(request.getRequestPayload().getFolder())) {
//                folderName = "".equals(TDwsServiceUtil.getTDServiceParam("TD_DOCUMANAGEMENT_SERVLET_FOLDER_HISTONGINSRT")) ? StatementUtil.DMS_HistStatementOngoingInsert_Folder_Default
//                        : TDwsServiceUtil.getTDServiceParam("TD_DOCUMANAGEMENT_SERVLET_FOLDER_HISTONGINSRT");
//            }

            String userId = request.getSessionInfo().getConnectId();
            if (userId == null || userId.isEmpty()) {
                userId = TDwsServiceUtil.getTDServiceParam("TD_DOCUMANAGEMENT_SERVLET_USERID");
            }
            Map<String, String> parameters = new HashMap<String, String>();
            parameters.put("userId", userId);
            parameters.put("portal", TDwsServiceUtil.getTDServiceParam("TD_DOCUMANAGEMENT_SERVLET_PORTAL"));
            parameters.put("folder", folderName);
            parameters.put("documentId", docId);

            com.mbnaweb.xsd.msgs.statement.GetStatementFileFromIdResponse.ResponsePayload xJaxbResponsePayload = new com.mbnaweb.xsd.msgs.statement.GetStatementFileFromIdResponse.ResponsePayload();

            DocumentRetrievalRequest documentRetrievalRequest = new DocumentRetrievalRequest();
            documentRetrievalRequest.setDocumentId(docId);
            documentRetrievalRequest.setDocumentFolder(folderName);

            //need to call DM Api to retrieve file
            DocumentRetrievalResponse documentRetrievalResponse = tdRestServiceUtil.invokeRestService(BackEndSrvcUtil.TDOperation.TdDocuManagementService_retrieve,documentRetrievalRequest, DocumentRetrievalResponse.class,token[0]);
            xJaxbResponse = new com.mbnaweb.xsd.msgs.statement.GetStatementFileFromIdResponse();

            if (documentRetrievalResponse != null && documentRetrievalResponse.getDocument() != null) {

                byte[] documentInBytes = Base64.getDecoder().decode(documentRetrievalResponse.getDocument().getContent());

                xJaxbResponsePayload.setFileData(documentInBytes);
                xJaxbResponse.setResponsePayload(xJaxbResponsePayload);

            } else {
                xJaxbResponse.getErrorMsgs().add(GENERAL_ERROR);
            }

            // convert jaxb intf to json intf
            GetStatementFileFromIdResponse jsonResponse;
            jsonResponse = JAXBJsonConverter.convertoJAXBToJsonInterface(xJaxbResponse,GetStatementFileFromIdResponse.class);

            return jsonResponse;



        } catch (Exception e) {
            logger.error("GetStatementFileFromIdResponse:invokeService", e.getLocalizedMessage(), e);

            throw ExceptionUtil.genRuntimeException(e);

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
