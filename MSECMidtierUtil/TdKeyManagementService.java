package com.td.mbna.msec.midtier.util.services;


import com.td.mbna.msec.midtier.util.MbnaLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.td.api.kms.request.AddDecryptionJobRq;
import com.td.api.kms.request.AddEncryptionJobRq;
import com.td.api.kms.response.AddDecryptionJobRs;
import com.td.api.kms.response.AddEncryptionJobRs;


@Service
public class TdKeyManagementService {
	
	private static MbnaLogger logger = new MbnaLogger(TdKeyManagementService.class);
	
	private static final String apiDecryptEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_KEYMANAGEMENT_DECRYPT_ENDPT);
	private static final String apiEncryptEndPoint = TDRestServiceUtil.getTDServiceParam(MSECConstants.TD_KEYMANAGEMENT_ENCRYPT_ENDPT);

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * encrypt the PIN block before we send it to TSYS
	 * @param addEncryptionJobRq
	 * @param token
	 * @return
	 * @throws Exception 
	 */
	public  AddEncryptionJobRs encrypt(AddEncryptionJobRq addEncryptionJobRq,String token) throws Exception {
		
		try {

			HttpEntity<?> requestEntity = new HttpEntity<AddEncryptionJobRq>(addEncryptionJobRq,addAuthorizationHeader(token));
			
			ResponseEntity<AddEncryptionJobRs> responseEntity = restTemplate.exchange(apiEncryptEndPoint,HttpMethod.POST,requestEntity, AddEncryptionJobRs.class);
			return responseEntity.getBody();
			
		} catch(Exception e) {
			logger.error("TdKeyManagementService:encrypt", e.getLocalizedMessage(), e);
		}

		return null;
	}	


	/**
	 * decrypt the PIN block from TSYS 
	 * @param addDecryptionJobRq
	 * @param token
	 * @return the DecryptResponse
	 */
	public  AddDecryptionJobRs decrypt(AddDecryptionJobRq addDecryptionJobRq,String token) throws Exception  {
		
		try {
			HttpEntity<?> requestEntity = new HttpEntity<AddDecryptionJobRq>(addDecryptionJobRq,addAuthorizationHeader(token));
			ResponseEntity<AddDecryptionJobRs> responseEntity = restTemplate.exchange(apiDecryptEndPoint,HttpMethod.POST,requestEntity,AddDecryptionJobRs.class);
			
			return responseEntity.getBody();
		} catch (Exception e) {
		    logger.error("TdKeyManagementService:decrypt", e.getLocalizedMessage(), e);
		}
		
		return null;
	}

	private static HttpHeaders addAuthorizationHeader(String token) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(MSECConstants.AUTHORIZATION,token);
	
		return headers;
	}


}
