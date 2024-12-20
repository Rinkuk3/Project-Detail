package com.td.mbna.msec.midtier.util.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.td.api.dms.common.Additionalstatus;
import com.td.api.dms.common.Status;
import com.td.api.dms.request.DocumentRetrievalRequest;
import com.td.api.dms.request.DocumentSearchRequest;
import com.td.api.dms.response.DocumentList;
import com.td.api.dms.response.retrieval.DocumentRetrievalResponse;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.XMLGregorianCalendarConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

@Service
public class TdDocumentManagementApi {

    private static MbnaLogger logger = new MbnaLogger(TdDocumentManagementApi.class);

    private static final String dmApiEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_DM_API_ENDPT);


    @Autowired
    private RestTemplate restTemplate;


    public DocumentList searchDocuments(DocumentSearchRequest documentSearchRequest, String token) {

		Gson gson = new GsonBuilder()
				.serializeNulls()
				.registerTypeAdapter(XMLGregorianCalendar.class,
						new XMLGregorianCalendarConverter.Serializer())
				.create();
		
        String query;

        try {
            UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(dmApiEndPoint + "/"+ documentSearchRequest.getFolder()+ "/" + MSECConstants.TD_DM_API_DOCUMENTS);

            try {
                //set portal
                uriComponentsBuilder.queryParam(MSECConstants.TD_DM_API_PORTAL, documentSearchRequest.getPortal());

                //set the query
                query = gson.toJson(documentSearchRequest.getQuery());
                uriComponentsBuilder.queryParam(MSECConstants.TD_DM_API_QUERY, query);

                //set the orderBy
                query = gson.toJson(documentSearchRequest.getOrderBy());
                uriComponentsBuilder.queryParam(MSECConstants.TD_DM_API_ORDERBY, query);

                //set max results
                uriComponentsBuilder.queryParam(MSECConstants.TD_DM_API_MAX_RESULTS, documentSearchRequest.getMaxResults());

            } catch (Exception e) {
                logger.error("Error converting query into json", e.getMessage(),e);
                throw ExceptionUtil.genRuntimeException(e);
            }

            HttpEntity<?> requestEntity = new HttpEntity(addAuthorizationHeader(token));
            if(uriComponentsBuilder.build() ==  null || uriComponentsBuilder.build().toUri() == null){
				return null;
			}
            HttpEntity<DocumentList> httpResponseEntity = restTemplate.exchange(uriComponentsBuilder.build().toUri(), HttpMethod.GET, requestEntity, DocumentList.class);

            if (httpResponseEntity.getBody() == null) {

                return new DocumentList();
            }

            return httpResponseEntity.getBody();

        } catch (Exception e) {
            logger.error("Error in searching documents with token="+token,e.getLocalizedMessage(),e);

            DocumentList documentList = new DocumentList();
            documentList.setDocument(null);

            Status status  = new Status();
            status.setServerStatusCode(Integer.toString(HttpStatus.INTERNAL_SERVER_ERROR.value()));

            List<Additionalstatus> additionalstatusList = new ArrayList<>();

            Additionalstatus anAdditionalStatus = new Additionalstatus();
            anAdditionalStatus.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            anAdditionalStatus.setStatusDesc(e.getLocalizedMessage());

            additionalstatusList.add(anAdditionalStatus);

            status.setAdditionalStatus(additionalstatusList);

            documentList.setStatus(status);

            return documentList;
        }

    }

    public DocumentRetrievalResponse retrieveDocument(DocumentRetrievalRequest documentRetrievalRequest, String token) {

        try {
            UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(dmApiEndPoint + "/" + documentRetrievalRequest.getDocumentFolder() + "/" + MSECConstants.TD_DM_API_DOCUMENTS+"/");

            uriComponentsBuilder.path(documentRetrievalRequest.getDocumentId());

            HttpEntity<?> requestEntity = new HttpEntity(addAuthorizationHeader(token));
			if(uriComponentsBuilder.build() ==  null || uriComponentsBuilder.build().toUri() == null){
				return null;
			}
            HttpEntity<DocumentRetrievalResponse> httpResponseEntity = restTemplate.exchange(uriComponentsBuilder.build().toUri(), HttpMethod.GET, requestEntity, DocumentRetrievalResponse.class);

            return httpResponseEntity.getBody();

        } catch (Exception e) {
            logger.error("Error in retreiving document with id="+documentRetrievalRequest.getDocumentId(),e.getLocalizedMessage(),e);

            DocumentRetrievalResponse documentRetrievalResponse = new DocumentRetrievalResponse();

            Status status  = new Status();
            status.setServerStatusCode(Integer.toString(HttpStatus.INTERNAL_SERVER_ERROR.value()));

            List<Additionalstatus> additionalstatusList = new ArrayList<>();

            Additionalstatus anAdditionalStatus = new Additionalstatus();
            anAdditionalStatus.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            anAdditionalStatus.setStatusDesc(e.getLocalizedMessage());

            additionalstatusList.add(anAdditionalStatus);
            status.setAdditionalStatus(additionalstatusList);
            documentRetrievalResponse.setStatus(status);

            return documentRetrievalResponse;

        }

    }

    private static HttpHeaders addAuthorizationHeader(String token) {

        HttpHeaders headers = new HttpHeaders();
        headers.add(MSECConstants.AUTHORIZATION,token);

        return headers;
    }

}
