package com.td.mbna.msec.midtier.util.services;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
//import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.UuidUtil;

import static com.td.mbna.msec.midtier.util.services.MSECConstants.IS_PIN_CACHE_DISABLED;

//@Service
public class TDApiInterceptor implements ClientHttpRequestInterceptor {
	
	private TDRestMockService tdRestMockService = new TDRestMockService();
	
	private static MbnaLogger logger = new MbnaLogger(TDApiInterceptor.class);
	
    private final static boolean IS_DEV_MODE = ConfigUtil.inDevMode();
    private final static boolean IS_CACHE_ENABLED = MSECConstants.API_CACHE_ENABLED;
    private static final long DURATION = MSECConstants.API_CACHE_EXPIRY;
    private static final int CAPACITY = MSECConstants.API_CACHE_INITIAL;
    private final static String MT_EXCEPTION_URI = ConfigUtil.getProperty("debug.MT.exception.URI", "blahblah");
    private final static String ENROLLMENT_ENDPOINT = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_ENROLLMENT_API_ENDPT);
    private static final String apiAlertEventEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_ALERT_EVENT_ENDPT);
    private static final String apiCapdEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_CAPD_ENDPT);
    private static final String apiOfmEventEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_OFM_API_ENDPT);
    private static final String apiMbccaEventEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_MBCCA_API_ENDPT);
    private static final String apiOfpEventEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_OFP_API_ENDPT);
	private static final String MBNA_ENDPOINT = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_MBADA_API_ENDPT);
    private ConcurrentMap<String, CachedResponses> cachedMap = new ConcurrentHashMap<>(CAPACITY);

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] body, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
    	String methodName = "TDApiInterceptor.intercept()";
    	logger.debug(methodName, " 0: entering "); 
    	String connectId = httpRequest.getHeaders().getFirst(MSECConstants.CONNECT_ID);
    	String apiUrl = httpRequest.getURI().toString();
//    	String key = uri+connectId;
//    	String keyCalled = uri+connectId+"_called_";
//    	if(sessionMidProvider == null){
//    		sessionMidProvider = new SessionMidProvider();
//    	}
//    	sessionMidProvider.getSessionAttribute(keyCalled);
    	ClientHttpResponse mockResponse = this.tdRestMockService.getMockResponse(apiUrl);
    	if (mockResponse != null){
    		return mockResponse;
    	}
    	
        try {
            addHeaders(httpRequest.getHeaders(), httpRequest.getURI().toString().startsWith(apiAlertEventEndPoint), httpRequest.getURI().toString().startsWith(apiCapdEndPoint));
            logger.debug(methodName, " 1: addHeaders httpRequest.getURI() ="+apiUrl);
        } catch (Exception e) {
            logger.error("intercept ", "Unable to add headers for outgoing request", e);
        }
    	logger.debug(methodName, " 2: starts: " + httpRequest.hashCode());

        try {
    		final Pattern MOCK_ENDPOINT_REGEX = Pattern.compile(MT_EXCEPTION_URI, Pattern.CASE_INSENSITIVE);
    		Matcher matcher = MOCK_ENDPOINT_REGEX.matcher(apiUrl.trim());

    		if (IS_DEV_MODE && matcher.find()) { //apiUrl.startsWith(MT_EXCEPTION_URI)) {
                throw new RuntimeException("throwing exception to test " + MT_EXCEPTION_URI);
            }
            ClientHttpResponse response =  null;
            MidtierClientHttpResponse mClientHttpResponse = null;
            
            

            logger.setConnectId(connectId);

            //check cache against uri for get

            if(IS_CACHE_ENABLED && connectId != null && httpRequest.getMethod().toString().equals("GET")){
            	logger.debug(methodName, " 3: cache enabled httpRequest.getURI() ="+apiUrl);
            	
                if (apiUrl.startsWith(ENROLLMENT_ENDPOINT)){
                	logger.debug(methodName, " 4: cache enabled - clear cache");
                	 cleanExpiredCachedResponse(DURATION * 60 * 1000);//1minutes = 60*1000
					 cleanCachedResponse(connectId);
                }

				// post update pin, clearing view pin cache response
				if (IS_PIN_CACHE_DISABLED && apiUrl.startsWith(MBNA_ENDPOINT)) {
					logger.debug(methodName, " View Pin cache disabled - remove view Pin mClientHttpResponse from cache.");
					cleanViewPinCachedResponse(connectId, apiUrl);
				}

	            //1 get response from cache
                mClientHttpResponse = getCachedResponse(connectId, apiUrl);
                logger.debug(methodName, " 5: cache enabled - get from cache mClientHttpResponse ");
                
	            //2:if response is null 
	            if(mClientHttpResponse == null){
	            	logger.debug(methodName, String.format("6: %n==GET response from downstream for user (%s), URL: %s", connectId, apiUrl));
	            	this.logRequest(httpRequest, body);
	            	response = clientHttpRequestExecution.execute(httpRequest, body);
	            	mClientHttpResponse = new MidtierClientHttpResponse(response);
	            	logResponse(httpRequest, mClientHttpResponse,	httpRequest.hashCode());

	            	//3: set response to cache
	            	if(response.getStatusCode().is2xxSuccessful()){
	            		logger.debug(methodName, " 7: cache enabled - get from API and put into cache ");
	            		putCachedResponse(connectId, apiUrl, mClientHttpResponse);
	            	}else{
	            		logger.error(httpRequest, response);
	            	}
	            	
	            } else {
	            	logger.debug(methodName, String.format(" 8: %n==GET response from cache for user (%s), URL: %s", connectId, apiUrl));
	            }
            }else{
            	
            	//  cache is off
            	logger.debug(methodName, " 9: cache disabled ");
            	this.logRequest(httpRequest, body);
            	response = clientHttpRequestExecution.execute(httpRequest, body);
            	mClientHttpResponse = new MidtierClientHttpResponse(response);
            	logResponse(httpRequest, mClientHttpResponse,	httpRequest.hashCode());
            	if (!response.getStatusCode().is2xxSuccessful()) {
            		logger.error(httpRequest, response);
            	}
            }
            
            //4 if not null the return it
            logger.debug(methodName, " 10: return  mClientHttpResponse");
            return mClientHttpResponse;
        }catch (java.net.SocketTimeoutException e) {
        	
        	ClientHttpResponse response = null;
        	if(apiUrl.startsWith(apiOfmEventEndPoint)||apiUrl.startsWith(apiMbccaEventEndPoint)||apiUrl.startsWith(apiOfpEventEndPoint)){
        		logger.warn("API Timeout, have a re-try! "+apiUrl);
        		response = clientHttpRequestExecution.execute(httpRequest, body);        	
        	}
        	return response;

        } catch (IOException | RuntimeException e ) {
        	logException(e, httpRequest.hashCode());
        	throw e;
        }
    }

    private boolean logFullResponse(HttpRequest httpRequest) {
        String apiUrl = httpRequest.getURI().toString();
        return (apiUrl.indexOf(TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_DM_API_ENDPT)) == -1); // no need to log the document
    }

    private static final String RESPONSE_FORMAT = "%n==response BEGIN(%d)==%nStatus code: %s%nStatus text: %s%nHeaders: %s%nResponse body: %s%n==response END==";
    private void logResponse(HttpRequest httpRequest, ClientHttpResponse response, int requestHashCode) {
        try {
            String body = logFullResponse(httpRequest)? StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()): "...skip...";
            logger.debug(String.format(RESPONSE_FORMAT, requestHashCode, response.getStatusCode(), response.getStatusText(), response.getHeaders(), body));
        } catch (Exception e) {
            logger.error("TDApiInterceptor ", "log respose failed", e);
        }

    }
    private static final String EXCEPTION_FORMAT = "%n==response BEGIN(%d)==%nStatus code: NA%nStatus text: NA%nHeaders: NA%nResponse body: %s%n==response END==";
    private void logException(Exception e, int requestHashCode) {
        logger.error(String.format(EXCEPTION_FORMAT, requestHashCode, ExceptionUtils.getStackTrace(e)));
    }

    private static final String REQUEST_FORMAT = "%n==REQUEST begin(%d)==%nURI: %s%nMethod: %s%nHeaders: %s%nRequest body: %s%n==REQUEST end==";
    private void logRequest(HttpRequest httpRequest, byte[] body) {
        try {
            logger.debug(String.format(REQUEST_FORMAT, httpRequest.hashCode(), httpRequest.getURI(), httpRequest.getMethod(), httpRequest.getHeaders(), new String(body)));
        } catch (Exception e) {
            logger.error("TDApiInterceptor ", "log request failed", e);
        }
  }

    private void addHeaders(HttpHeaders headers, boolean umpCall, boolean capdCall) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(MSECConstants.CLIENT_APPLICATION_PLATFORM_HEADER, MSECConstants.CLIENT_APPLICATION_MSEC);
        headers.add(MSECConstants.MESSAGE_ID_HEADER, UuidUtil.genUuid());
        headers.add(MSECConstants.FINANCIAL_INSTITUTION_INTERNAL_ORGANIZATION_ID_HEADER, MSECConstants.FINANCIAL_INSTITUTION_INTERNAL_ORGANIZATION_ID_VALUE);
        headers.add(MSECConstants.CONSUMER_REFERENCE_PARAMETER, TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_CS_HEADER_WSA_AddressValue));
        if (umpCall){
        	headers.add(MSECConstants.TRACEABILITY_ID_HEADER, MSECConstants.CLIENT_APPLICATION_MSEC + UuidUtil.genUuid());
        	headers.add(MSECConstants.ORIGINATING_CHANNEL_NAME, MSECConstants.CLIENT_APPLICATION_MSEC);
        	headers.add(MSECConstants.DELIVERY_MODE_CD, MSECConstants.UMP_DELIVERY_EXPRESS);
        } else {
        	headers.add(MSECConstants.TRACEABILITY_ID_HEADER, UuidUtil.genUuid());
        	if (capdCall) {
            	headers.add(MSECConstants.ORIGINATING_CHANNEL_NAME, MSECConstants.CLIENT_APPLICATION_MBNA);
            	headers.add(MSECConstants.ACCEPT_LANGUAGE_HEADER, MSECConstants.ACCEPT_LANGUAGE_EN);
            	headers.add(MSECConstants.CLEAR_SITE_DATA_HEADER, MSECConstants.CLEAR_CACHE);
            }
        }
    }
    
    
    private MidtierClientHttpResponse getCachedResponse(String connectId, String url){
    	if (cachedMap == null){
    		cachedMap = new ConcurrentHashMap<>();
    	}
    	
    	if (cachedMap.get(connectId) == null){
    		CachedResponses cachedResponses = new CachedResponses();
    		ConcurrentMap<String, MidtierClientHttpResponse> map = new ConcurrentHashMap<>();
    		cachedResponses.setResponsesMap(map);
    		cachedMap.put(connectId, cachedResponses);
    	}
    	
    	MidtierClientHttpResponse response = cachedMap.get(connectId).getResponsesMap().get(url);
    	
    	if (response != null){
    		cachedMap.get(connectId).increaseHitCount();
    		cachedMap.get(connectId).setLastVisitDate(new Date());
    	}
    	
    	return response;
    }
    
    private void putCachedResponse(String connectId, String url, MidtierClientHttpResponse response){
    	if (cachedMap == null){
    		cachedMap = new ConcurrentHashMap<>();
    	}
    	
    	if (cachedMap.get(connectId) == null){
    		CachedResponses cachedResponses = new CachedResponses();
    		ConcurrentMap<String, MidtierClientHttpResponse> map = new ConcurrentHashMap<>();
    		cachedResponses.setResponsesMap(map);
    		cachedResponses.setCacheHitCount(0);
    		cachedMap.put(connectId, cachedResponses);
    	}
    	
    	cachedMap.get(connectId).setLastVisitDate(new Date());
    	
    	cachedMap.get(connectId).getResponsesMap().put(url, response);
    }
    
    public void cleanCachedResponse(String connectId){
    	if (cachedMap == null || cachedMap.isEmpty() || connectId == null){
    		return;
    	} 
    	if(cachedMap.containsKey(connectId)){
    		cachedMap.remove(connectId);
    	}
    }

	public void cleanViewPinCachedResponse(String connectId, String apiUrl) {
		if (cachedMap == null || cachedMap.isEmpty() || connectId == null) {
			return;
		}
		if(cachedMap.containsKey(connectId)) {
			for (String id : cachedMap.keySet()) {
				CachedResponses cachedResponses = cachedMap.get(id);
				if (cachedResponses == null) {
					continue;
				}
				if ((cachedResponses.getResponsesMap().containsKey(apiUrl))) {
					cachedResponses.getResponsesMap().remove(apiUrl);
				}
			}
		}
	}

    public void cleanExpiredCachedResponse(long duration){
    	if (cachedMap == null || cachedMap.isEmpty() || cachedMap.size() % 5 > 0){
    		return;
    	}
    	
    	long now = new Date().getTime();
    	int count = 0;
    	for (String connectId : cachedMap.keySet()){
    		CachedResponses cachedResponses = cachedMap.get(connectId);
    		if(cachedResponses == null){
    			continue;
    		}
    		if ((cachedResponses.getLastVisitDate() ==  null ) || (now - cachedResponses.getLastVisitDate().getTime() > duration)){
    			cachedMap.remove(connectId);
    			count ++;
    		}
    	}
    	logger.debug("user data removed from API cache: " + count);
    }
    
    public int numberOfCachedUsers(){
    	if (cachedMap == null || cachedMap.isEmpty()){
    		return 0;
    	}
    	
    	return cachedMap.size();
    }

    public String getCachedUsers(){
    	if (cachedMap == null || cachedMap.isEmpty()){
    		return " ";
    	}
    	StringBuilder sb = new StringBuilder();
    	for (String connectId: cachedMap.keySet()){
    		sb.append(connectId);
    		sb.append(" ");
    	}
    	return sb.toString();
    }

}
