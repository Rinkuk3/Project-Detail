package com.td.mbna.msec.midtier.util;

import java.beans.PropertyDescriptor;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.XMLConstants;
import javax.xml.bind.util.JAXBResult;
import javax.xml.bind.util.JAXBSource;
import javax.xml.soap.SOAPException;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * Helper methods for XSL transformations.
 *
 */
public class TransformUtil {
	private static MbnaLogger logger = new MbnaLogger(TransformUtil.class);

	static private final Map<String, Templates> XslFn2TemplateMap = new ConcurrentHashMap<String, Templates>();


	/**
	 * get request template
	 * @param op
	 * @return
	 * @throws Exception
	 */
	static public Templates getRqTemplate(String op) throws Exception { // op is name of operation like retrieveCreditCardAccount
		return getTemplate(op + "Rq" + ".xsl");
	}


	/**
	 * get response template
	 * @param op
	 * @return
	 * @throws Exception
	 */
	static public Templates getRsTemplate(String op) throws Exception { // op is name of operation like retrieveCreditCardAccount
		return getTemplate(op + "Rs" + ".xsl");
	}

	private final static String XslResourcePath = "/xsl/";

	/**
	 * get template
	 * @param xslFn
	 * @return
	 * @throws Exception
	 */
	static public Templates getTemplate(String xslFn) throws Exception {
		Templates xslT = XslFn2TemplateMap.get(xslFn);
		if (xslT == null) {
			synchronized (xslFn.intern()) {
				xslT = XslFn2TemplateMap.get(xslFn);
				if (xslT == null) {
					String resourcePath = XslResourcePath + xslFn;
					InputStream xslStream = com.td.mbna.msec.midtier.util.TransformUtil.class.getResourceAsStream(resourcePath);
					TransformerFactory factory = getTransformerFactory();
					xslT = factory.newTemplates(new StreamSource(xslStream));
					xslStream.close();
					XslFn2TemplateMap.put(xslFn,  xslT);
				}
			}
		}
		return xslT;
	}


	private static TransformerFactory getTransformerFactory() throws TransformerConfigurationException {
		TransformerFactory factory = TransformerFactory.newInstance();
		factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
		factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
		factory.setURIResolver(new com.td.mbna.msec.midtier.util.TransformUtil.MyResolver());
		return factory;
	}



	/**
	 * transform request
	 * @param template
	 * @param source
	 * @param paramValues
	 * @param result
	 * @throws TransformerException
	 * @throws SOAPException
	 * @throws IOException
	 */
	static public void transformRequest(Templates template, Source source, Map<String,Object> paramValues, Result result) throws TransformerException, SOAPException, IOException {
		Transformer requestTransformer = template.newTransformer();
		requestTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
		if (source == null) { // sometimes you just want to insert values from input parameters but not from an input document.  Use a dummy document in this case.
			source = new StreamSource(new StringReader("<?xml version=\"1.0\"?><_r_/>"));
		}
		if (paramValues != null) {
			for (Map.Entry<String, Object> me : paramValues.entrySet()) {
				requestTransformer.setParameter(me.getKey(), me.getValue());
			}
		}
		//TODO: harryhan 2020-10-20 Improper Restriction of XML External Entity Reference CWE ID 611
		requestTransformer.transform(source, result);
		return;
	}

	static public <JaxbType> JaxbType transformRequest(Templates template, Source source, Map<String,Object> paramValues, Class<JaxbType> resultClass) throws Exception {
		JAXBResult result = new JAXBResult(com.td.mbna.msec.midtier.util.JaxbUtil.getJaxbContext(resultClass));
		transformRequest(template, source, paramValues, result);
		return com.td.mbna.msec.midtier.util.JaxbUtil.getResultValue(result, resultClass);
	}

	static public <JaxbType> JaxbType transformRequest(Templates template, Object sourceJaxbObject, Map<String,Object> paramValues, Class<JaxbType> resultClass) throws Exception {
		JAXBSource source = new JAXBSource(com.td.mbna.msec.midtier.util.JaxbUtil.getJaxbContext(sourceJaxbObject), com.td.mbna.msec.midtier.util.JaxbUtil.genJaxbElement(sourceJaxbObject));
		JAXBResult result = new JAXBResult(com.td.mbna.msec.midtier.util.JaxbUtil.getJaxbContext(resultClass));
		transformRequest(template, source, paramValues, result);
		return JaxbUtil.getResultValue(result, resultClass);
	}


	/**
	 * transform request
	 * @param template
	 * @param source
	 * @param paramValues
	 * @return
	 * @throws TransformerException
	 * @throws SOAPException
	 * @throws IOException
	 */
	static public String transformRequest(Templates template, Source source, Map<String,Object> paramValues) throws TransformerException, SOAPException, IOException {
		StringWriter resultWriter = new StringWriter(10000);
		transformRequest(template, source, paramValues, new StreamResult(resultWriter));
		resultWriter.flush();
		return resultWriter.toString();
	}

	/**
	 * retrieve String from parameters
	 * @param paramValues
	 * @param attribute
	 * @return
	 */
	@SuppressWarnings("unchecked")
	static public String retrieve(Object paramValues, String attribute) {
		
		if (attribute.indexOf(".") < 0) {
			return (String)((Map<String,Object>)paramValues).get(attribute);
		}
		
		String objName = attribute.substring(0, attribute.indexOf("."));
		Object obj = ((Map<String,Object>)paramValues).get(objName);
		return getFieldValue(obj, attribute.substring(attribute.indexOf(".")+1));
	}

	/**
	 * DO NOT REMOVE IT, it is used in /resourecs/xsl/retrieveEnrollmentRs.xsl
	 * set value in parameters
	 * @param outValues
	 * @param key
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String setValue(Object outValues, String key, String value) {
		((Map<String, String>)outValues).put(key, value);
		return value;
	}

	/**
	 * get field value
	 * @param obj
	 * @param fieldName
	 * @return
	 */
	static public String getFieldValue(Object obj, String fieldName) {
		try {
			if (fieldName.indexOf(".") < 0) {
				Method getter = new PropertyDescriptor(fieldName, obj.getClass()).getReadMethod();
				Object fldValue = getter.invoke(obj);
				return fldValue.toString();
			}
			String fldName = fieldName.substring(0, fieldName.indexOf("."));
			Method getter = new PropertyDescriptor(fldName, obj.getClass()).getReadMethod();
			Object fldValue = getter.invoke(obj);
			return getFieldValue(fldValue, fieldName.substring(fieldName.indexOf(".") + 1));
		}
		catch (Exception ex) {
			logger.error(ex);
			return null;
		}
	}

	/**
	 * read file
	 * @param userId
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	static public String readFile(String userId, String fileName) throws Exception {
		InputStream defaultInputStream = null;
		String defaultFile = getFileInConfig(userId, fileName);
		if ((new File(defaultFile)).exists()) {
			defaultInputStream = new FileInputStream(defaultFile);
		}
		else {
			defaultInputStream = com.td.mbna.msec.midtier.util.TransformUtil.class.getClassLoader().getResourceAsStream(fileName);
		}
		StringBuilder sampleInput = new StringBuilder(1000);
		BufferedInputStream sampleInputStream = new BufferedInputStream(defaultInputStream);
		byte[] contents  = new byte[1024];
		int bytesRead = 0;
		while ((bytesRead = sampleInputStream.read(contents)) != -1) {
			sampleInput.append(new String(contents, 0, bytesRead));
		}
		defaultInputStream.close();
		return sampleInput.toString();
	}

	/**
	 * get file in config
	 * @param userId
	 * @param inFileName
	 * @return
	 */
	static public String getFileInConfig(String userId, String inFileName) {
		String fileName = inFileName;
		String configDirName = com.td.mbna.msec.midtier.util.ConfigUtil.getConfigDirectory();
		if (userId != null) {
			String userDirName = configDirName + userId;
			File userDir = new File(userDirName);
			if (userDir.exists() && userDir.isDirectory()) {
				fileName = userDirName + ConfigUtil.FS + fileName;
			}
			else {
				fileName = configDirName + fileName;
			}
		}
		else {
			fileName = configDirName + fileName;
		}
		return fileName;
	}

	/**
	 * DO NOT REMOVE IT, it is used in /resourecs/xsl/assembleDisclosure_getDisclosureRs.xsl
	 * decode Base 64 encoded
	 * @param base64Binary
	 * @return
	 */
	public static String decodeBase64(String base64Binary) {
		String utfString = null;
		try {
			byte[] decoded = base64Binary.getBytes("UTF8");
			utfString = new String(Base64.getDecoder().decode(decoded), "UTF8");
		} catch (Exception e) {
			try{
				utfString = new String(Base64.getDecoder().decode(base64Binary.getBytes()),"UTF8");
			}catch(UnsupportedEncodingException u){
				logger.error(u);
			}
		}
		return utfString;
	}

	/**
	 * DO NOT REMOVE IT, it is used in /resourecs/xsl/assembleDisclosureRq.xsl
	 * DO NOT REMOVE IT, it is used in /resourecs/xsl/captureAgreementRq.xsl
	 * encode to base 64
	 * @param text
	 * @return
	 */
	public static String encodeBase64(String text) {
		String result = Base64.getEncoder().encodeToString(text.getBytes(Charset.forName("UTF-8")));
		return result;
	}

	/**
	 * DO NOT REMOVE IT, it is used in /resourecs/xsl/includes/mtAcctCommon.xsl
	 * get next date cycle
	 * @param day
	 * @return
	 * @throws ParseException
	 */
	public static String nextDateCycle(String day) throws ParseException{
		Calendar cal = Calendar.getInstance();
		NumberFormat numFormat = NumberFormat.getInstance(Locale.CANADA);
		int iDay = numFormat.parse(day).intValue();
		if (iDay < cal.get(Calendar.DAY_OF_MONTH)) {
			cal.add(Calendar.MONTH, 1);
			try {
				cal.set(Calendar.DAY_OF_MONTH, iDay);
			}
			catch (Exception ex) {
				// Ignore. Let the cal keep the old value
				logger.error(ex);
			}
		}
		else {
			cal.set(Calendar.DAY_OF_MONTH, iDay);
		}
		SimpleDateFormat df = new SimpleDateFormat();
		df.applyPattern("yyyy-MM-dd");
		synchronized(df){
			return df.format(cal.getTime());
		}
	}

	/**
	 * generate current XSD date/time string
	 * @return
	 */
	public static String genCurrentXsdDateTimeString() { // format the current time into a format specified by xsd:datetime type
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		synchronized(sdf){
			return sdf.format(calendar.getTime());
		}
	}

	private static class MyResolver implements URIResolver {

		private final static String MbnaXslIncludesPrefix = "includes/";

		/**
		 * resolve
		 */
		public Source resolve(String href, String base) {
			if (href.startsWith(MbnaXslIncludesPrefix)) {
				StringBuilder path = new StringBuilder(XslResourcePath);
				path.append(href);
				InputStream in = com.td.mbna.msec.midtier.util.TransformUtil.class.getResourceAsStream(path.toString());
				return new StreamSource(in);
			}
			else {
				File inFile = new File(href);
				if (inFile.exists() && inFile.isFile()) {
					return new StreamSource(inFile);
				}
				else {
					throw new RuntimeException("Cannot resolve XSL resource:"  + href);
				}
			}
		}
	}

	private final static String XmlResourcePath = "/xml/";
	private final static Map<String,byte[]> TdReqTemplateMap = new ConcurrentHashMap<String,byte[]>();

	/**
	 * get TD request stub XML
	 * @param op
	 * @return
	 * @throws Exception
	 */
	public static InputStream getTdRqStubXml(String op) throws Exception {
		byte[] reqBytes = TdReqTemplateMap.get(op);
		if (reqBytes == null) {
			synchronized (op.intern()) {
				reqBytes = TdReqTemplateMap.get(op);
				if (reqBytes == null) {
					String opFileName = genOpFileName(op, "Rq");
					InputStream fileIn = com.td.mbna.msec.midtier.util.TransformUtil.class.getResourceAsStream(XmlResourcePath + opFileName);
					reqBytes = IoUtil.readFully(fileIn);
					fileIn.close();
					TdReqTemplateMap.put(op, reqBytes);
				}
			}
		}
		return new ByteArrayInputStream(reqBytes);
	}

	private static String genOpFileName(String tdOp, String RqRes) {
		String fileName = tdOp + RqRes + ".xml";
		fileName = fileName.substring(0,1).toLowerCase(Locale.CANADA) + fileName.substring(1);
		return fileName;
	}
}