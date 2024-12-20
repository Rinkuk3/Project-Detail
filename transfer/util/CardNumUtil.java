package com.td.mbna.msec.midtier.transfer.util;

import com.td.mbna.msec.midtier.transfer.payload.BalanceTransferToCreditorPayeeType;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MSECConstants;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;

import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.security.SecureRandom;

/**
 * PayeeUtil
 * 
 * This class provides utility methods to handle balance transfer payees 
 *  
 */
public class CardNumUtil {
	
	private static MbnaLogger logger = new MbnaLogger(CardNumUtil.class);
	
	private static final SecureRandom SECURE_RANDOM = createSecureRandom();
	
	//TDRestService.properties
	private static final String payeeEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_PAYEEMANAGEMENT_VALIDATE_PAYEE_ENDPT);
	private static final String testset = TDRestServiceUtil.getTDServiceParam("TD_PAYEEMANAGEMENT_VALIDATE_PAYEE_HEADER_x-environment-testset");
	private static final String testsystem = TDRestServiceUtil.getTDServiceParam("TD_PAYEEMANAGEMENT_VALIDATE_PAYEE_HEADER_x-environment-testsystem");
	private static final String RESPONSE_FORMAT = "%n==response BEGIN(%d)==%nStatus code: %s%nStatus text: %s%nHeaders: %s%nResponse body: %s%n==response END==";
	private static final String REQUEST_FORMAT = "%n==REQUEST begin(%d)==%nURI: %s%nMethod: %s%nHeaders: %s%nRequest body: %s%n==REQUEST end==";
	
	public static boolean isValidMerchantCardNum(BalanceTransferToCreditorPayeeType payee) {
		
		String methodName = "isValidMerchantCardNum()";
		
		HttpHeaders headers = generateHeader(payee);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		String url = payeeEndPoint + "?issuingMerchantPartyAccountNum="
				+ payee.getCardNum() + "&merchantPartyIdentificationNum="
				+ payee.getMerchantId();
		try {
			RestTemplate restTemplate = new RestTemplate();
			logger.debug(String.format(REQUEST_FORMAT, payee.hashCode(), url, HttpMethod.GET, headers, ""));
			//TODO: harry 2021-02-17 Server-Side Request Forgery (SSRF) CWE ID 918
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
			HttpStatus status = response.getStatusCode();
			logger.debug(String.format(RESPONSE_FORMAT, payee.hashCode(), status, status.toString(), response.getHeaders(), response.getBody()));
			return HttpStatus.NO_CONTENT.equals(status);
		} catch(HttpClientErrorException e){
			if (e.getStatusCode().toString().equals("400")) {
				// normal failure of the validation
				return false;
			}
			// Unexpected exception, log stack trace
			String desc = "BT Step 3::2 - BP API validation isValidMerchantCardNum failed "+String.valueOf(e.getRawStatusCode())+ e.getLocalizedMessage();
			logger.error(methodName, desc,e);
			throw ExceptionUtil.genRuntimeException(e);
		} catch (Exception e) {
			String desc = "BT Step 3::3 - BP API validation isValidMerchantCardNum failed "+ e.getLocalizedMessage();
			logger.error(methodName, desc, e);
			throw ExceptionUtil.genRuntimeException(e);
		}
		
	}
	private static SecureRandom createSecureRandom() {
		try {
			SecureRandom s = SecureRandom.getInstance("SHA1PRNG");
			byte[] bytes = new byte[512];
		    s.nextBytes(bytes);
		    return s;
		} catch (Exception e) { // this should not happen
			logger.error("createSecureRandom", e.getLocalizedMessage(), e);
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 
	 * @param payee
	 * @return
	 */
	private static HttpHeaders generateHeader(BalanceTransferToCreditorPayeeType payee) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content_type","application/json");
		headers.add("originating-channel-instance-id","WEB");
		headers.add("x-environment-testset",testset);
		headers.add("Accept-Language","En");
		headers.add("traceabilityid",Long.toString(SECURE_RANDOM.nextLong()));
		headers.add("x-environment-testsystem",testsystem);
		headers.add(MSECConstants.AUTHORIZATION,"Bearer "+ payee.getToken());
		return headers;
	}

}