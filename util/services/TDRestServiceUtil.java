package com.td.mbna.msec.midtier.util.services;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.Properties;

import javax.xml.soap.SOAPFault;

import com.td.coreapi.common.config.ApiConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.td.api.dms.request.DocumentRetrievalRequest;
import com.td.api.dms.request.DocumentSearchRequest;
import com.td.api.kms.request.AddDecryptionJobRq;
import com.td.api.kms.request.AddEncryptionJobRq;
import com.td.mbna.msec.midtier.util.BackEndSrvcUtil;
import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;

import static com.td.mbna.msec.midtier.util.ConfigUtil.SYSTEM_PROPERTY_TEST;

@Component
public class TDRestServiceUtil {

	private static MbnaLogger logger = new MbnaLogger(TDRestServiceUtil.class);
	
	private static Properties endPtProps = null;


	@Autowired
	private TdKeyManagementService tdKeyManagementService;

	@Autowired
	private TdDocumentManagementApi tdDocumentManagementApi;

    static{
    	try {
			endPtProps = new Properties();
			InputStream propsIn = null;
			if(Boolean.parseBoolean(System.getProperty(SYSTEM_PROPERTY_TEST, "false"))) {
				propsIn = TDRestServiceUtil.class.getResourceAsStream("/"+MSECConstants.TD_REST_PROPERTY_FILEName);
				endPtProps.load(propsIn);
				propsIn.close();
			}else {
				String path = ConfigUtil.getConfigDirectory() + MSECConstants.TD_REST_PROPERTY_FILEName;


				endPtProps.load(ApiConfig.getInstance().getInputStreamFromFile(MSECConstants.TD_REST_PROPERTY_FILEName));
			}

    	}
    	catch(Throwable ex) {
			logger.error("TDRestServiceUtil: static block",ex.getLocalizedMessage(),ex);
    	}
    }
	
	/**
     * This method returns a TD Service parameter
     * @param tdServiceParm
     * @return
     */
	public static String getTDServiceParam(String tdServiceParm) {
		String srvcParam = "";

		srvcParam = endPtProps.getProperty(tdServiceParm);
		
		if (srvcParam == null){
			return "";
		}
		return srvcParam.trim();
	}

	@SuppressWarnings("unchecked")
	public <Response> Response invokeRestService(BackEndSrvcUtil.TDOperation srvcOper, Object request, Class<Response> responseClass, String token) throws Exception {


		Response resp = null;

		switch (srvcOper) {

			case TdKeyManagementService_encrypt:
				resp = (Response) tdKeyManagementService.encrypt((AddEncryptionJobRq) request,token);
				break;
			case TdKeyManagementService_decrypt:
				resp = (Response) tdKeyManagementService.decrypt((AddDecryptionJobRq) request, token);
				break;
			case TdDocuManagementService_search:
				resp = (Response) tdDocumentManagementApi.searchDocuments((DocumentSearchRequest) request,token);
				break;
			case TdDocuManagementService_retrieve:
				resp = (Response) tdDocumentManagementApi.retrieveDocument((DocumentRetrievalRequest) request,token);
				break;
			default:
				break;
		}


		return resp;
	}

	public static String getSoapErrorMessage (String methodName, SOAPFault soapFault, String generalError) {
		String errorMessage = generalError;
		try {
			errorMessage = (String) soapFault.getDetail().getFirstChild().getTextContent();
		}
		catch (Exception e) {
			logger.error(methodName,"Unable to retrieve the error code from soap fault exception",e);
		}
		return errorMessage;
	}
	
	/**
	 * 
	 * @param filePath
	 * @return
	 */
	public static String readLineByLineJava8(String filePath) {
		
		File fileToRead = new File(filePath);
		try {
			List<String> fileLines = Files.readAllLines(new ClassPathResource(filePath).getFile().toPath());
			return StringUtils.join(fileLines, StringUtils.EMPTY);
		} catch (IOException e) {
			logger.error("readLineByLineJava8", "get file", e);
		}
		return null;
	}
}
