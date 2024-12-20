package com.td.mbna.msec.midtier.tdwsservices;

import java.io.ByteArrayOutputStream;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import com.td.coreapi.common.config.ApiConfig;
import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.IoUtil;
import com.td.mbna.msec.midtier.util.JaxbUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import org.springframework.core.io.ClassPathResource;

/**
 * 
 * This class contains helper methods to integrate with TD backend.
 *
 */
public class TDwsServiceUtil {
	
	private static MbnaLogger logger = new MbnaLogger(TDwsServiceUtil.class);
	
	private static Properties endPtProps = null;
	private static final String TD_WS_PROPERTY_FILEName = "TDwsServices.properties"; 	

	// Service enabled name
	//public static final String TD_CARD_SERVICE_ENABLED = "TD_CARD_SERVICE_ENABLED";
	public static final String TD_CUSTAGREEMENT_SERVICE_ENABLED = "TD_CUSTAGREEMENT_SERVICE_ENABLED";
	public static final String TD_DISCLOSURECFG_SERVICE_ENABLED = "TD_DISCLOSURECFG_SERVICE_ENABLED";
	public static final String TD_ODS_CUSTOMERPROFILE_SERVICE_ENABLED = "TD_ODS_CUSTOMERPROFILE_SERVICE_ENABLED";
	public static final String TD_ODS_CUSTOMERACCOUNTRELATIONSHIP_SERVICE_ENABLED = "TD_ODS_CUSTOMERACCOUNTRELATIONSHIP_SERVICE_ENABLED";
	
	// Service Endpoint 
	public static final String TD_CARD_ENDPT = "TD_CARD_ENDPT";
	public static final String TD_CUSTAGREEMENT_ENDPT = "TD_CUSTAGREEMENT_ENDPT";
	public static final String TD_DISCLOSURECFG_ENDPT = "TD_DISCLOSURECFG_ENDPT";
	public static final String TD_ODS_CUSTOMERPROFILE_ENDPT = "TD_ODS_CUSTOMERPROFILE_ENDPT";
	public static final String TD_ODS_CUSTOMERACCOUNTRELATIONSHIP_ENDPT = "TD_ODS_CUSTOMERACCOUNTRELATIONSHIP_ENDPT";


	// Service Target NameSpace
    //public static final String TD_CARD_NS = "TD_CARD_NS";
    public static final String TD_CUSTAGREEMENT_NS = "TD_CUSTAGREEMENT_NS";
    public static final String TD_DISCLOSURECFG_NS = "TD_DISCLOSURECFG_NS";	
    public static final String TD_ODS_CUSTOMERPROFILE_NS = "TD_ODS_CUSTOMERPROFILE_NS";
    public static final String TD_ODS_CUSTOMERACCOUNTRELATIONSHIP_NS = "TD_ODS_CUSTOMERACCOUNTRELATIONSHIP_NS";

    // Service Name
   // public static final String TD_CARD_NAME = "TD_CARD_NAME";
    public static final String TD_CUSTAGREEMENT_NAME = "TD_CUSTAGREEMENT_NAME";
    public static final String TD_DISCLOSURECFG_NAME = "TD_DISCLOSURECFG_NAME";	
    public static final String TD_ODS_CUSTOMERPROFILE_NAME = "TD_ODS_CUSTOMERPROFILE_NAME";
    public static final String TD_ODS_CUSTOMERACCOUNTRELATIONSHIP_NAME = "TD_ODS_CUSTOMERACCOUNTRELATIONSHIP_NAME";
    
    // MDM Customer Header Information
    public static final String TD_MESSAGE_HEADER_OPERATION = "TD_MESSAGE_HEADER_OPERATION";
    public static final String TD_MESSAGE_HEADER_ENDPOINT = "TD_MESSAGE_HEADER_ENDPOINT";
    public static final String TD_CS_HEADER_WSA_NS = "TD_CS_HEADER_WSA_NS";
    public static final String TD_CS_HEADER_WSA_From = "TD_CS_HEADER_WSA_From";
    public static final String TD_CS_HEADER_WSA_To = "TD_CS_HEADER_WSA_To";
    public static final String TD_CS_HEADER_WSA_Action = "TD_CS_HEADER_WSA_Action";
    public static final String TD_CS_HEADER_WSA_Message = "TD_CS_HEADER_WSA_Message";
    public static final String TD_CS_HEADER_WSA_Address = "TD_CS_HEADER_WSA_Address";
    public static final String TD_CS_HEADER_WSA_ReferenceParameters = "TD_CS_HEADER_WSA_ReferenceParameters";
    public static final String TD_CS_HEADER_WSA_AddressValue = "TD_CS_HEADER_WSA_AddressValue";
    public static final String TD_CS_HEADER_WSA_TR_NS = "TD_CS_HEADER_WSA_TR_NS";
    public static final String TD_CS_HEADER_WSA_TR_value = "TD_CS_HEADER_WSA_TR_value";
    public static final String TD_CS_HEADER_CONS_NS = "TD_CS_HEADER_CONS_NS";
    public static final String TD_CS_HEADER_CONS_AppIdentifier = "TD_CS_HEADER_CONS_AppIdentifier";
    
    // Common Services CUSTOMER AGREEMENT Information
    public static final String TD_CS_CSTAGT_ARRANGEMENT_TYPE_CD = "TD_CS_CSTAGT_ARRANGEMENT_TYPE_CD";
    public static final String TD_CS_CSTAGT_PRODUCT_TYPE_CD = "TD_CS_CSTAGT_PRODUCT_TYPE_CD";
    public static final String TD_CS_CSTAGT_ARRANGEMENT_TYPE_CD_CUSTOMER = "TD_CS_CSTAGT_ARRANGEMENT_TYPE_CD_CUSTOMER";
    public static final String TD_CS_CSTAGT_PRODUCT_TYPE_CD_CUSTOMER = "TD_CS_CSTAGT_PRODUCT_TYPE_CD_CUSTOMER";
    public static final String TD_CS_CSTAGT_MIME_TYPE_CD = "TD_CS_CSTAGT_MIME_TYPE_CD";
    public static final String TD_CS_CSTAGT_DOCUMENT_META_DATA_USAGE = "TD_CS_CSTAGT_DOCUMENT_META_DATA_USAGE";
    public static final String TD_CS_CSTAGT_FINANCIAL_INSTITUTION_TYPE_CD = "TD_CS_CSTAGT_FINANCIAL_INSTITUTION_TYPE_CD";
    public static final String TD_CS_CSTAGT_INITIATING_LOCATION_ID = "TD_CS_CSTAGT_INITIATING_LOCATION_ID";
    public static final String TD_CS_CSTAGT_LOCATION_USAGE_CD = "TD_CS_CSTAGT_LOCATION_USAGE_CD";
    public static final String TD_CS_CSTAGT_SOURCE_APPLICATION_CODE = "TD_CS_CSTAGT_SOURCE_APPLICATION_CODE";

    // Common Services DISCLOSURE_CONFIGURATION Information
    public static final String TD_DSCFG_EAA1 = "TD_DSCFG_EAA1";

	// Identity Verification Service

	public static final String ID_IDENTITY_SERVICE_ENDPT = "ID_IDENTITY_SERVICE_ENDPT";
	public static final String TD_IDENTITY_SERVICE_NS = "TD_IDENTITY_SERVICE_NS";
	public static final String TD_IDENTITY_SERVICE_NAME = "TD_IDENTITY_SERVICE_NAME";


    // DirectDebitService Information
    public static final String TD_DDS_APPID_TYPECD = "TD_DDS_APPID_TYPECD";
    public static final String TD_DDS_APPID_TXT = "TD_DDS_APPID_TXT";
    public static final String TD_DDS_USERID_TYPECD = "TD_DDS_USERID_TYPECD";
    public static final String TD_DDS_USERID_TXT = "TD_DDS_USERID_TXT";
    
    // IssuerID
    public static final String ISSUERID = "ISSUERID";
       
    private static final String CARDPATTERNSTR = "(CardNO|CardNumber|AccountNumber|CardNum)>(\\d*)(\\d{4})<";
    private static final String ArrgnbrWithCardPATTERNSTR = "(ArrangementNO)>\\s*(\\d{12})(\\d{4})\\s*<";
    private static final String ValueWithCardPATTERNSTR = "(value)>\\s*(\\d{12})(\\d{4})\\s*<";
    private static Pattern maskCardNoPat = null;
    private static Pattern maskArrgNoPat = null;
    private static Pattern maskValuePat = null;
    
    static{
    	try {
	    	String path = ConfigUtil.getConfigDirectory()+TD_WS_PROPERTY_FILEName;
	    	endPtProps = new Properties();
			endPtProps.load(ApiConfig.getInstance().getInputStreamFromFile(TD_WS_PROPERTY_FILEName));
			maskCardNoPat = Pattern.compile(CARDPATTERNSTR);
			maskArrgNoPat = Pattern.compile(ArrgnbrWithCardPATTERNSTR);
			maskValuePat = Pattern.compile(ValueWithCardPATTERNSTR);
    	}
    	catch(Throwable ex) {
    		logger.error(ex);
    	}
    }
    

	
    /**
     * Used for initialization at server startup
     */
    public static void init() {
		return;
	}
    
    /**
     * This method returns a TD Service parameter
     * @param tdServiceParm
     * @return
     */
	public static String getTDServiceParam(String tdServiceParm) {
		//	harry han 2020-10-20 called
		String srvcParam = "";

		srvcParam = endPtProps.getProperty(tdServiceParm);
		if (srvcParam == null)
			srvcParam = "";
		else
			srvcParam = srvcParam.trim();
		return srvcParam;
	}
	
	
	/**
	 * this method converts Object to String
	 * @param context_path
	 * @param type
	 * @param inObj
	 * @param tagname
	 * @return
	 * @throws Exception
	 */
	public static byte[] convertObjectToStream(String context_path, Class<?> type, Object inObj, String tagname) throws Exception {
		// harry han 2020-10-20 called
		return convertObjectToStream(context_path,  type, inObj, tagname, null);
	}
	
	/**
	 * This method converts object to String
	 * @param context_path
	 * @param type
	 * @param inObj
	 * @param tagname
	 * @param namespace
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static byte[] convertObjectToStream(String context_path, Class<?> type, Object inObj, String tagname, String namespace) throws Exception {
		// harry han 2020-10-20 called
		ByteArrayOutputStream reswriter = null;
		try {
			JAXBContext jaxbContext = JaxbUtil.getJaxbContext(context_path);
			int bufferSize = 1024;
			// Use bigger buffer for transactions that typically have long response
			if (tagname != null) {
				if (tagname.equals("RetrieveCreditCardAccountRs") || 
					tagname.equals("EnvTransactionRetrieveRs") || 
					tagname.equals("EnvGetOffersRs") ||
					tagname.equals("EnvGetAppliedSubproductsRs") ) {
					bufferSize = 32768;
				}
				else if (tagname.equals("searchResponse")) {
					bufferSize = 16384;
				}
				else if (tagname.equals("eligibilityResponse") || tagname.equals("EnvUpdateCustomerProfileRs")) {
					bufferSize = 8192;
				}
				else if (tagname.equals("AssembleDisclosureResponse")) {
					bufferSize = 65536;
				}
			}
			reswriter = new ByteArrayOutputStream(bufferSize);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.marshal( new JAXBElement(new QName(namespace,tagname), type, inObj ), reswriter);
			return reswriter.toByteArray();
		}
		finally {
			IoUtil.closeQuietly(reswriter);
		}
	}


	/**
	 * This method suppresses the card number and PIN
	 * @param msgstr
	 * @return
	 */
	public static String suppressCardNoAndPin(String msgstr) {
		// harryhan 2020-10-20 called
		try {
		String maskedStr = msgstr;
		maskedStr = maskCardNoPat.matcher(msgstr).replaceAll("$1>************$3<");
		maskedStr = maskArrgNoPat.matcher(maskedStr).replaceAll("$1>************$3<");
		maskedStr = maskValuePat.matcher(maskedStr).replaceAll("$1>************$3<");
		return maskedStr;
		} catch (Exception e) {
			logger.error(e);
			return msgstr;
		}
	}
}
