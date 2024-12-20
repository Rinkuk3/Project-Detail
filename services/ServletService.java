package com.td.mbna.msec.midtier.services;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;

import com.mbnaweb.xsd.types.common.SystemException;
import com.td.mbna.msec.midtier.exception.SystemError;
import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;

/**
 * 
 * This class calls the DMS servlet to retrieve the statement PDF.
 *
 */
@Deprecated
public class ServletService {
		
	// char encoding
	public static final String CHARSET_UTF8 = "UTF-8";
	
	private static MbnaLogger logger = new MbnaLogger(ServletService.class);
	
	private static int connectTimeout;
	private static int connectReadTimeout;
	
	static {
		String connectTimeoutStr = ConfigUtil.getProperty("tdservice.documanagement.connect.timeout");
		if (connectTimeoutStr == null) {
			connectTimeoutStr = ConfigUtil.getProperty("tdservice.connect.timeout");			
		}
		Integer connectTimeoutSecs = new Integer(connectTimeoutStr);
		String readTimeoutStr = ConfigUtil.getProperty("tdservice.documanagement.request.timeout");
		if (readTimeoutStr == null) {
			readTimeoutStr = ConfigUtil.getProperty("tdservice.request.timeout");			
		}
		Integer readTimeoutSecs = new Integer(readTimeoutStr);
		connectTimeout = connectTimeoutSecs.intValue() * 1000;
		connectReadTimeout = readTimeoutSecs.intValue() * 1000;
	}
	
	/**
	 * this method calls the servlet
	 * @param urlString
	 * @param parameters
	 * @return
	 * @throws SystemError
	 */
	public static byte[] callServlet(String urlString, Map<String, String> parameters) throws SystemError{
		
		try {
			
			//String urlWithQueryString = getUrlWithQueryString(urlString, parameters);
			
			String queryString = getQueryString(parameters);
			
			logger.info("QueryString: " + queryString);
			
			URL url = new URL(urlString);
			
			URLConnection connection;
			
			connection = url.openConnection();
			
			connection.setRequestProperty("Accept-Charset", CHARSET_UTF8);
			
			if (connection instanceof HttpURLConnection) {
				((HttpURLConnection)connection).setRequestMethod("POST");
			}
			
			connection.setDoOutput(true);			
			
			connection.setConnectTimeout(connectTimeout);
			connection.setReadTimeout(connectReadTimeout);
			
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF8");

			if(queryString != null) {
// commenting out this block of code as it is causing exception error 500.
//				String escapeString = StringEscapeUtils.escapeHtml(queryString);
//				writer.write(escapeString);
			    writer.write(queryString);
			}
            writer.flush();
            writer.close();
			
			InputStream response = connection.getInputStream();
			
			byte[] responseBytes = new byte[4096];
			int byteLength;
			
			
			int responseLength = connection.getContentLength(); // use the content length in response header, if available
			if (responseLength < 0 || responseLength > 1048576) {	// use a reasonable size buffer if content length is too big
				responseLength = 1048576;
			}
			
			ByteArrayOutputStream bos = new ByteArrayOutputStream(responseLength);
			
			while ((byteLength = response.read(responseBytes)) != -1) {
              bos.write(responseBytes, 0, byteLength);
	        }
			
			bos.flush();
			bos.close();
			
			
			response.close();
			
			
			return bos.toByteArray();
			
		}
		catch(Exception ex) {
			
			logger.error("Exception in ServletService.callServlet", ex);
			
			SystemException se = new SystemException();
			se.setErrorDescription(ex.getMessage());
			se.setErrorSource("ServletService");	
			
			SystemError systemError = new SystemError();
			systemError.setFaultInfo(se);
			throw systemError;			
		}
	}
	
	private static String getQueryString(Map<String, String> parameters) throws UnsupportedEncodingException{
		
		if(parameters == null || parameters.isEmpty() || parameters.keySet().isEmpty()) {
			return null;
		}
		StringBuilder queryStringBuilder = new StringBuilder();
		
		for(String key : parameters.keySet()) {
			
			String encodedValue = URLEncoder.encode(parameters.get(key), CHARSET_UTF8);
			
			queryStringBuilder.append(key).append("=").append(encodedValue).append("&");
		}
		
		String queryString = queryStringBuilder.substring(0, queryStringBuilder.lastIndexOf("&"));
		
		return queryString;
	}

}
