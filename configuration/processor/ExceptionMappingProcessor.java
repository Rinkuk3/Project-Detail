package com.td.mbna.msec.midtier.configuration.processor;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import com.td.coreapi.common.config.ApiConfig;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mbnaweb.xsd.types.common.BusinessException;
import com.mbnaweb.xsd.types.common.ErrorType;
import com.mbnaweb.xsd.types.common.SystemException;
import com.td.mbna.msec.midtier.configuration.beans.ExceptionInfoBean;
import com.td.mbna.msec.midtier.configuration.beans.ExceptionInfoBeanForJson;
import com.td.mbna.msec.midtier.exception.BusinessError;
import com.td.mbna.msec.midtier.exception.SystemError;
import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.XMLGregorianCalendarConverter;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;

/**
 * This class maps TD errors to MT errors.
 *
 */
public class ExceptionMappingProcessor{

	// originator TSYS
	public static final String TD_TSYS = "TSYS";
	// originator DDS
	public static final String TD_DDS  = "DDS";
	// originator MISC
	public static final String TD_MISC = "MISC";
	// originator DMS
	public static final String TD_DMS = "DMS";
	// originator EMAIL
	public static final String TD_EMAIL = "EMAIL";
	// originator OOMS - getOffers operation
	public static final String TD_OFFERS_GETOFFERS = "OFFERS_GETOFFERS";
	// originator OOMS - other non-getOffers operation
	public static final String TD_OFFERS_OTHER = "OFFERS_OTHER";
	// originator CUSTOMER NOTES
	public static final String TD_NOTES = "NOTES";
	// originator OFS
	public static final String TD_OFS = "OFS";
	//originator KeyManagementService(KMS)
	public static final String TD_KMS = "KMS";
	
	public static final String TD_ODS = "ODS";
	
	public static final String TD_ODS_CREATE_PROFILE = "ODS_CREATE_PROFILE";
	public static final String TD_ODS_RETRIEVE_PROFILE = "ODS_RETRIEVE_PROFILE";
	
	public static final String TD_ODS_RELATIONS = "ODS_RELATIONS";
	
	//Default error code per operation
	public static final String TSYS_RETRIEVETRANSACTION = "TSYS_RetrieveTX_DEFAULT";
	public static final String TSYS_REQUESTCHECQUE = "TSYS_RetrieveCheque_DEFAULT";
	
	// Default error code
	public static final String DEFAULT_CODE = "DEFAULT";
	// ERROR type
	public static final String ERROR  = "ERROR";
	// WARNING type
	public static final String WARNING = "WARNING";
	// INFO type
	public static final String INFO = "INFO"; 
	
	private static final String EXCEPTION_CLASSIFICATION = "Exception-Classification";
	//private static final String EXCEPTION_INFO = "Exception-Info";
	private static final String ERRORCODE = "ErrorCode";
	private static final String SEVERITY = "Severity";
	private static final String ERRORDESCRIPTION = "ErrorDescription";
	public static final String ATTR_ORIGINATOR = "originator";
	public static final String ATTR_CODE = "code";
	public static final String ATTR_AUX_CODE = "auxCode"; // auxiliary code
	public static final String ATTR_BE_ISSUER = "beIssuer";
	public static final String ATTR_BE_CODE_PATTERN = "beCodePattern";
	
	private static MbnaLogger logger = new MbnaLogger(ExceptionMappingProcessor.class);

	private static Map<String, Map<String, String>> codeMapList = populateMappingsForJson();
    
    public static void init() { //Used for initialization at server startup
		return;
	}
    
    private static Map<String, String> getExceptionInfoFromCode(String originator, String errorCode, String opDefaultErrorCode, String auxCode, String beIssuer, String beCode) {
    	Map<String, String> exceptionInfo = null;
    	if (errorCode == null || errorCode.trim().length() == 0) {
    		errorCode = opDefaultErrorCode;
    	}
    	String key = genTsysErrorInfoKey(originator, errorCode, auxCode, beIssuer);
    	exceptionInfo = codeMapList.get(key);
    	if (exceptionInfo != null && beCodePatternMatched(exceptionInfo, beCode)) {
    		return exceptionInfo;
    		}
        key = genTsysErrorInfoKey(originator, opDefaultErrorCode, auxCode, beIssuer);
        exceptionInfo = codeMapList.get(key);
    	if (exceptionInfo != null && beCodePatternMatched(exceptionInfo, beCode)) {return exceptionInfo;}
    	key = genTsysErrorInfoKey(originator, null, auxCode, beIssuer);
    	exceptionInfo = codeMapList.get(key);
    	if (exceptionInfo != null && beCodePatternMatched(exceptionInfo, beCode)) {return exceptionInfo;}
        key = genTsysErrorInfoKey(originator, errorCode, null, beIssuer);
        exceptionInfo = codeMapList.get(key);
    	if (exceptionInfo != null && beCodePatternMatched(exceptionInfo, beCode)) {return exceptionInfo;}
        key = genTsysErrorInfoKey(originator, errorCode, auxCode, null);
        exceptionInfo = codeMapList.get(key);
    	if (exceptionInfo != null && beCodePatternMatched(exceptionInfo, beCode)) {return exceptionInfo;}
        key = genTsysErrorInfoKey(originator, opDefaultErrorCode, null, beIssuer);
        exceptionInfo = codeMapList.get(key);
    	if (exceptionInfo != null && beCodePatternMatched(exceptionInfo, beCode)) {return exceptionInfo;}
        key = genTsysErrorInfoKey(originator, opDefaultErrorCode, auxCode, null);
        exceptionInfo = codeMapList.get(key);
    	if (exceptionInfo != null && beCodePatternMatched(exceptionInfo, beCode)) {return exceptionInfo;}
        key = genTsysErrorInfoKey(originator, null, null, beIssuer);
        exceptionInfo = codeMapList.get(key);
    	if (exceptionInfo != null && beCodePatternMatched(exceptionInfo, beCode)) {return exceptionInfo;}
        key = genTsysErrorInfoKey(originator, null, auxCode, null);
        exceptionInfo = codeMapList.get(key);
    	if (exceptionInfo != null && beCodePatternMatched(exceptionInfo, beCode)) {return exceptionInfo;}
        key = genTsysErrorInfoKey(originator, opDefaultErrorCode, null, null);
   		exceptionInfo = codeMapList.get(key);
    	if (exceptionInfo != null && beCodePatternMatched(exceptionInfo, beCode)) {return exceptionInfo;}
        key = genTsysErrorInfoKey(originator, errorCode, null, null);
   		exceptionInfo = codeMapList.get(key);
    	if (exceptionInfo != null && beCodePatternMatched(exceptionInfo, beCode)) {return exceptionInfo;}
    	key = genTsysErrorInfoKey(originator, "MIDTIER", null, null);	// use default for MidTier
   		exceptionInfo = codeMapList.get(key);
    	return exceptionInfo;
    }
    
    private static boolean beCodePatternMatched(Map<String, String> exceptionInfo, String beCode) {
    	String beCodePattern = exceptionInfo.get(ATTR_BE_CODE_PATTERN);
    	if (beCodePattern == null || beCodePattern.isEmpty()) return true;
    	if (beCode == null || beCode.isEmpty()) return false;
    	Pattern p = getBeCodePattern(beCodePattern);
     	Matcher m = p.matcher(beCode);
    	return m.matches();
    }
    
    private static ConcurrentHashMap<String, Pattern> beCodePatterns = new ConcurrentHashMap<String, Pattern>(); 

    private static Pattern getBeCodePattern(String strPattern) {
    	Pattern pattern = beCodePatterns.get(strPattern); // Pattern objects are thread-safe and could be cached and shared between threads
    	if (pattern == null) {
    		pattern = Pattern.compile(strPattern);
    		beCodePatterns.put(strPattern, pattern);
    	}
    	return pattern;
    }
    
    
    private static Map<String, Map<String, String>> populateMappingsForJson() {
    	
    	Map<String, Map<String, String>> codeMapList = new ConcurrentHashMap<String, Map<String, String>>();
    	
    	try {
            
			Gson gson = new GsonBuilder()
					.serializeNulls()
					.setPrettyPrinting()
					.registerTypeAdapter(XMLGregorianCalendar.class,
							new XMLGregorianCalendarConverter.Serializer())
					.create();
			
			String jsonFile = "ExceptionMappingMidTier.json";
			String filePath = ConfigUtil.getConfigDirectory() + jsonFile;

			//String jsonStr = TDRestServiceUtil.readLineByLineJava8(filePath);

			String jsonStr = ApiConfig.getInstance().getStringFromFile(jsonFile);
	    	List<ExceptionInfoBeanForJson> eJsons = gson.fromJson(jsonStr, new TypeToken<List<ExceptionInfoBeanForJson>>(){}.getType()); 
	    	
	    	for(ExceptionInfoBeanForJson e: eJsons){
	    		String beCodePattern = e.getBeCodePattern();
	    		Map<String, String> exceptionInfoBean = new  ConcurrentHashMap<String, String>();
	    		if (beCodePattern != null && !beCodePattern.isEmpty()) {
	    			exceptionInfoBean.put(ATTR_BE_CODE_PATTERN, beCodePattern);
	    		}
	    		exceptionInfoBean.put(EXCEPTION_CLASSIFICATION, e.getClassification());
	    		exceptionInfoBean.put(ERRORCODE, e.getErrorCode());
	    		exceptionInfoBean.put(ERRORDESCRIPTION, e.getDescription());
	    		exceptionInfoBean.put(SEVERITY, e.getSeverity());
	    		
	    		String originator = e.getOriginator();
	    		String code = e.getLevelCode();
	    		String auxCode = e.getAuxCode();
	    		String beIssuer = e.getBeIssuer();
	    		String key = genTsysErrorInfoKey(originator,code,auxCode,beIssuer);
	    		exceptionInfoBean.put("key", key);
		    	codeMapList.put(key, exceptionInfoBean);
	    	}
    	} catch (Exception e) {
			logger.error(e);
			ExceptionUtil.genRuntimeException(e);
		}
    	return codeMapList;
    }
    
    
    private static String genTsysErrorInfoKey(String originator, String code, String auxCode, String beIssuer) {
    	if (code == null || code.trim().length() == 0){
    		code = DEFAULT_CODE;
    	}
    	if (auxCode == null || auxCode.trim().length() == 0){
    		auxCode = DEFAULT_CODE;
    	}
    	
    	if (beIssuer == null || beIssuer.trim().length() == 0){
    		beIssuer = DEFAULT_CODE;
    	}
    	return (originator+"-"+code+"-"+auxCode+"-"+beIssuer).toUpperCase(Locale.CANADA);
    }
	
	/**
	 * This method returns the  ExceptionInfoBean based on the ExceptionMapping_MidTier.xml and the passed input parameters.
	 * of the ExceptionMappingProcessor
	 * 
	 */
	public ExceptionInfoBean getMappedException(String originator, String errorCode, String auxCode, String beIssuer, String beCode, String severity, String operationDefaultCode) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException 
	{
		return getMappedException(originator, errorCode, auxCode, beIssuer, beCode,
								  (severity == null? null : severity.trim().toUpperCase(Locale.CANADA)),
								  null, operationDefaultCode);
	}
	
	/**
	 * get mapped exception
	 * @param originator
	 * @param errorCode
	 * @param auxCode
	 * @param severity
	 * @param message
	 * @return
	 * @throws XPathExpressionException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public ExceptionInfoBean getMappedException(String originator, String errorCode, String auxCode, String beIssuer, String beCode, String severity, String message, String opDefaultCode) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException 
	{
		String errDesc = genErrDesc(originator, errorCode, auxCode, beIssuer, beCode);
		logger.debug("getMappedException entered: " + errDesc);
		ExceptionInfoBean exceptionInfoBean = new ExceptionInfoBean();
		boolean defaultCodeEntryUsed = false;

		Map<String, String> errMappingInfo = getExceptionInfoFromCode(originator, errorCode, opDefaultCode, auxCode, beIssuer, beCode);

	    if (errMappingInfo != null) { 
	    	defaultCodeEntryUsed = isDefaultCodeEntry(errMappingInfo.get("key"), opDefaultCode);
	    	exceptionInfoBean.setExceptionClassification(errMappingInfo.get(EXCEPTION_CLASSIFICATION));
	    	exceptionInfoBean.setErrorCode(errMappingInfo.get(ERRORCODE));		
	    	exceptionInfoBean.setErrorDescription(errMappingInfo.get(ERRORDESCRIPTION));		
	    	exceptionInfoBean.setSeverity(errMappingInfo.get(SEVERITY));		
	    } else { // nothing found even DEFAULT is not available
			exceptionInfoBean.setExceptionClassification("SYSTEM");		
			exceptionInfoBean.setErrorCode("MS502");		
			exceptionInfoBean.setErrorDescription("MS502");		
			exceptionInfoBean.setSeverity("ERROR");		
	    }
		
	    // Keep the severity if explicit error code is not found.
	    if (defaultCodeEntryUsed && severity != null && severity.trim().length() > 0) {
	    	exceptionInfoBean.setSeverity(severity);
	    }
	    if (message != null) {
	    	exceptionInfoBean.setSoapExceptionMessage(message);
	    }
		return exceptionInfoBean;
	}
	
	private static String genErrDesc(String originator, String errCode, String auxCode, String beIssuer, String beCode) {
		StringBuilder s = new StringBuilder("originator=" + originator);
		e4nv(s, ",errCode=", errCode);
		e4nv(s, ",auxCode=", auxCode);
		e4nv(s, ",beIssuer=", beIssuer);
		e4nv(s, ",beCode=", beCode);
		return s.toString();
	}
	
	// if input value is not null, append key=value; else do nothing
	private static void e4nv(StringBuilder s, String key, String value) {
		if (value != null && value.isEmpty() == false) {
			s.append(key).append(value);
		}
	}
	
	private static boolean isDefaultCodeEntry(String key, String opDefaultCode) {
		boolean rc = false;
		String[] keyParts = key.split("-");
		if (keyParts.length >= 2) {
			String code = keyParts[1];
			rc = code.equalsIgnoreCase(DEFAULT_CODE) || code.equalsIgnoreCase(opDefaultCode);
		}
		return rc;
	}

	/**
	 * generate business error
	 * @param error
	 * @return
	 */
	public BusinessError genBusinessError(ExceptionInfoBean error) {
		BusinessError bErr = new BusinessError();
		BusinessException faultInfo = new BusinessException();
		bErr.setFaultInfo(faultInfo);
		faultInfo.setErrorCode(error.getErrorCode());
		faultInfo.setErrorDescription(error.getErrorDescription());
		faultInfo.setSeverity(mapErrorType(error.getSeverity()));
		faultInfo.setSoapFaultDescription(error.getSoapExceptionMessage());
		return bErr;
	}
	
	/**
	 * generate system error
	 * @param error
	 * @return
	 */
	public SystemError genSystemError(ExceptionInfoBean error) {
		SystemError sErr = new SystemError();
		SystemException faultInfo = new SystemException();
		sErr.setFaultInfo(faultInfo);
		faultInfo.setErrorCode(error.getErrorCode());
		faultInfo.setErrorDescription(error.getErrorDescription());
		faultInfo.setSeverity(mapErrorType(error.getSeverity()));
		return sErr;
	}
	
	/**
	 * map error type
	 * @param errType
	 * @return
	 */
	public ErrorType mapErrorType(String errType) {
		ErrorType eType = ErrorType.ERROR;
		if (errType.equalsIgnoreCase(WARNING)) {
			eType = ErrorType.WARN;
		}
		else if (errType.equalsIgnoreCase(INFO)) {
			eType = ErrorType.INFO;
		}
		return eType;
	}
	
	/**
	 *  This is used by Offers - exceptions are ignored in the end, but we need enough information to log the error properly
	 * @param errorInfo
	 * @return
	 */
	public ExceptionInfoBean createExceptionInfoBeanFromDetails(Map<String,String> errorInfo) {
		ExceptionInfoBean exceptionInfoBean = new ExceptionInfoBean();
		exceptionInfoBean.setExceptionClassification("SYSTEM");		
		exceptionInfoBean.setErrorCode(errorInfo.get("code") + "/" + errorInfo.get("auxCode"));		
		exceptionInfoBean.setErrorDescription(errorInfo.get("desc"));		
		exceptionInfoBean.setSeverity(errorInfo.get("severity"));
		return exceptionInfoBean;
	}
}
