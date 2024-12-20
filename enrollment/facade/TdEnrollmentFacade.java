package com.td.mbna.msec.midtier.enrollment.facade;

import java.util.*;
import java.util.stream.Collectors;

import com.td.api.enrollment.retrieve.ProductCustomer;
import com.td.api.enrollment.retrieve.Relationship;
import com.td.mbna.msec.midtier.util.ConfigUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.td.api.enrollment.retrieve.RetrieveProductCustomer;
import com.td.mbna.msec.midtier.account.payload.deleteaccount.DeleteAccountResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.retrieveenrollment.RetrieveEnrollmentResponse;
import com.td.mbna.msec.midtier.enrollment.MbnaEnrollment;
import com.td.mbna.msec.midtier.enrollment.adaptor.TdEnrollmentAdaptor;
import com.td.mbna.msec.midtier.types.common.Error;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MSECConstants;

import com.td.mbna.msec.midtier.util.services.TDApiInterceptor;

import static com.td.mbna.msec.midtier.util.services.MSECConstants.MOCK_ENROLLMENT_API_ERROR;
import static java.lang.Boolean.TRUE;


@Component
public class TdEnrollmentFacade {

    private static final String QUERY_PARAM_CONNECTID = "connectId";
    private static final String QUERY_PARAM_ENROLMENTTYPE_CD = "enrolmentType";
    private static final String QUERY_PARAM_ENROLMENTTYPE_VALUE = "TDCT";
    private static final String TEST_SET_HEADER = "x-environment-id";
    private static final String MBNA_PRODUCT_CD = "WEBMBNA";
    private static final String SUCCESS = "Success";
    private static final String ERROR = "ERROR";
    private static final String FAILURE = "Failed";
    private static final String MS804 = "MS804";
    private static final String ENROLLMENT_API_ERROR_MESSAGE = "Enrolment API call returns error";
    private static final String ENROLLMENT_API_RETURNS_NULL = " Enrolment API returns null for connectId =";

    MbnaLogger logger = new MbnaLogger(TdEnrollmentAdaptor.class);

    @Autowired
    protected RestTemplate restTemplate;

    @Autowired
    private TdEnrollmentAdaptor tdEnrollmentAdaptor;

    public DeleteAccountResponse unEnroll(String connectId, String accountId, String token) {

        HttpHeaders httpHeaders = prepareHeaders(connectId, token);
        HttpEntity<?> requestEntity = new HttpEntity<>(null, httpHeaders);

        String enrollmentId = connectId+"+"+MBNA_PRODUCT_CD+"+"+accountId;
        UriComponentsBuilder builder = null;

        builder = UriComponentsBuilder.fromHttpUrl(MbnaEnrollment.ENROLLMENT_ENDPOINT).path("/"+enrollmentId);

        DeleteAccountResponse deleteAccountResponse = new DeleteAccountResponse();

        try {

            ResponseEntity<String> responseEntity = restTemplate.exchange(builder.build().toUri(), HttpMethod.DELETE, requestEntity, String.class);

            if (StringUtils.isBlank(responseEntity.getBody())) {
                deleteAccountResponse.setStatus(SUCCESS);
                return deleteAccountResponse;
            } 
            
            deleteAccountResponse.setStatus(FAILURE);

            Error anError = new Error();
            anError.setErrorCode(responseEntity.getBody());
            anError.setErrorDescription(responseEntity.getBody());
            anError.setSeverity(ERROR);

            deleteAccountResponse.getErrorMessages().add(anError);
        

        } catch (Exception e) {
            logger.error("Error in un-enrolling account with id="+accountId, e);
            deleteAccountResponse.setStatus(FAILURE);

            Error anError = new Error();
            anError.setErrorCode(e.getLocalizedMessage());
            anError.setErrorDescription(e.getLocalizedMessage());
            anError.setSeverity(ERROR);

            deleteAccountResponse.getErrorMessages().add(anError);
        }

        return deleteAccountResponse;
    }


    public RetrieveEnrollmentResponse retrieveEnrollments(String connectId, String token) {

        HttpHeaders httpHeaders = prepareHeaders(connectId, token);
        HttpEntity<?> requestEntity = new HttpEntity<>(null, httpHeaders);

        List<String> connectIdValue = new ArrayList<>();
        connectIdValue.add(connectId);

        List<String> enrolmentType = new ArrayList<>();
        enrolmentType.add(QUERY_PARAM_ENROLMENTTYPE_VALUE);

        MultiValueMap<String,String> queryParameters = new LinkedMultiValueMap<>();
        queryParameters.put(QUERY_PARAM_CONNECTID,connectIdValue);
        queryParameters.put(QUERY_PARAM_ENROLMENTTYPE_CD,enrolmentType);

        UriComponentsBuilder builder = null;

        builder = UriComponentsBuilder.fromHttpUrl(MbnaEnrollment.ENROLLMENT_ENDPOINT).queryParams(queryParameters);

        ResponseEntity<RetrieveProductCustomer> responseEntity = null;
		try {
			if(builder != null && builder.build() != null && builder.build().encode() != null && builder.build().encode().toUri() != null ){
				responseEntity = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET,requestEntity,RetrieveProductCustomer.class);
			}
		} catch (RestClientException e) {
			logger.error(ENROLLMENT_API_ERROR_MESSAGE, e);
			e.printStackTrace();
		}
		if(responseEntity ==  null){
			String msg = ENROLLMENT_API_RETURNS_NULL + connectId;
        	logger.error(msg);
        	throw ExceptionUtil.genBusinessException("MS601", msg);
		}
        return tdEnrollmentAdaptor.convertToEnrollmentResponse(responseEntity.getBody(),connectId);
    }

    public List<ProductCustomer> retrieveMbnaEnrollments(String connectId, String token) {

        if(MOCK_ENROLLMENT_API_ERROR){
            logger.error("Enrolment API call returns error", "mock error for api down");
            throw ExceptionUtil.genBusinessException("MS804", "mock error for api down");
        }

        List<ProductCustomer> mbnaEnrollmentAccounts = new ArrayList<>();

        HttpHeaders httpHeaders = prepareHeaders(connectId, token);
        HttpEntity<?> requestEntity = new HttpEntity<>(null, httpHeaders);

        List<String> connectIdValue = new ArrayList<>();
        connectIdValue.add(connectId);

        List<String> enrolmentType = new ArrayList<>();
        enrolmentType.add(QUERY_PARAM_ENROLMENTTYPE_VALUE);

        MultiValueMap<String,String> queryParameters = new LinkedMultiValueMap<>();
        queryParameters.put(QUERY_PARAM_CONNECTID,connectIdValue);
        queryParameters.put(QUERY_PARAM_ENROLMENTTYPE_CD,enrolmentType);

        UriComponentsBuilder builder = null;

        builder = UriComponentsBuilder.fromHttpUrl(MbnaEnrollment.ENROLLMENT_ENDPOINT).queryParams(queryParameters);

        ResponseEntity<RetrieveProductCustomer> responseEntity = null;
        try {
            if(builder != null && builder.build() != null && builder.build().encode() != null && builder.build().encode().toUri() != null ){
                responseEntity = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET,requestEntity,RetrieveProductCustomer.class);
            }
        } catch (RestClientException e) {
            logger.error(ENROLLMENT_API_ERROR_MESSAGE , e);
            throw ExceptionUtil.genBusinessException(MS804 , "Enrolment API call returns error " + e.getMessage());
        }
        if(responseEntity ==  null){
            String msg = ENROLLMENT_API_RETURNS_NULL + connectId;
            logger.error(msg);
            throw ExceptionUtil.genBusinessException(MS804, msg);
        }

        if(responseEntity.getBody()!=null) {
            List<ProductCustomer> productCustomerList = responseEntity.getBody().getProductCustomer();
            if ( productCustomerList == null || productCustomerList.isEmpty()) {
                String message = "no customer found in enrollments API with connectId="+connectId;
                logger.error("retrieveMbnaEnrollments ", message);
                throw ExceptionUtil.genBusinessException(MS804, message);
            }

            //check if enrolled in webmbna
            mbnaEnrollmentAccounts = productCustomerList.stream().filter( anEnrollment -> anEnrollment.getProductCd().equalsIgnoreCase(MBNA_PRODUCT_CD)).collect(Collectors.toList());
            logger.info("Enrollment response for connection Id : "+  connectId + "api response " + mbnaEnrollmentAccounts);
        }
        return mbnaEnrollmentAccounts;
    }

    public String enroll(String connectId, String partyId, String accountId, String token) {

        if(MOCK_ENROLLMENT_API_ERROR){
            logger.error("Enrolment API call returns error", "mock error for api down");
            throw ExceptionUtil.genBusinessException("MS804", "mock error for api down");
        }

       ProductCustomer productCustomer = new ProductCustomer();
       Relationship relation = new Relationship();
       List<Relationship> relationship = new ArrayList<>();
        relation.setRelationshipCd("mdmKey");
        relation.setRelationshipVal(partyId);
        relationship.add(relation);
       productCustomer.setConnectId(connectId);
       productCustomer.setProductCd(MBNA_PRODUCT_CD);
       productCustomer.setProductVal(accountId);
       productCustomer.setRelationship(relationship);
       Map<String , Object> requestBody = new LinkedHashMap<>();
       requestBody.put("productCustomer", productCustomer);

        HttpHeaders httpHeaders = prepareHeaders(connectId, token);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> requestEntity = new HttpEntity<>(requestBody, httpHeaders);

        List<String> connectIdValue = new ArrayList<>();
        connectIdValue.add(connectId);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(MbnaEnrollment.ENROLLMENT_ENDPOINT);

        ResponseEntity<String> responseEntity = null;
        try {
            if(builder != null && builder.build() != null && builder.build().encode() != null && builder.build().encode().toUri() != null ){
                responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.POST,requestEntity,String.class);
            }
        } catch (HttpStatusCodeException e) {
            logger.error(ENROLLMENT_API_ERROR_MESSAGE , e.getResponseBodyAsString());
            throw ExceptionUtil.genBusinessException(MS804 , "Enrolment API call returns error " + e.getResponseBodyAsString());
        }
        if(responseEntity ==  null){
            String msg = ENROLLMENT_API_RETURNS_NULL + connectId;
            logger.error(msg);
            throw ExceptionUtil.genBusinessException(MS804 , msg);
        }
        return responseEntity.getStatusCode().toString();

    }


    public String cleanApiCache(String connectId) {
    	String usersBefore = " ";
    	String usersAfter = " ";
    	for (ClientHttpRequestInterceptor interceptor : restTemplate.getInterceptors()){
    		if (interceptor instanceof TDApiInterceptor ){
    			usersBefore = ((TDApiInterceptor) interceptor).getCachedUsers();
    			logger.debug("Users before cleaning: " +  usersBefore);
    			((TDApiInterceptor) interceptor).cleanCachedResponse(connectId);
    			((TDApiInterceptor) interceptor).cleanExpiredCachedResponse(1*60L*1000);//1minutes = 1*60*1000
    			usersAfter = ((TDApiInterceptor) interceptor).getCachedUsers();
    			logger.debug("Users after cleaning: " + usersAfter);
    		}
    	}
    	return usersBefore.length() > usersAfter.length() ? SUCCESS : FAILURE ;
    }
    

    private HttpHeaders prepareHeaders(String connectId, String token) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(MSECConstants.CONNECT_ID, connectId);
        httpHeaders.add(HttpHeaders.AUTHORIZATION, token);

        String[] testSetEnvironmentDetails = MbnaEnrollment.ENROLLMENT_TEST_SET_ENV.split(":");
        httpHeaders.add(TEST_SET_HEADER,testSetEnvironmentDetails[2]+":"+testSetEnvironmentDetails[3]);

        return httpHeaders;
    }
}
