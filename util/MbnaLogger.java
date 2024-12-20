package com.td.mbna.msec.midtier.util;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.td.mbna.msec.midtier.types.common.TrackableRequest;
import com.td.mbna.msec.midtier.types.common.TrackingInfoType;
import com.td.mbna.msec.midtier.util.services.MSECConstants;

import org.apache.logging.log4j.Level;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.ThreadContext;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.MDC;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;


public class MbnaLogger {
    public static final String REMOTE_IP = "remoteIp";
    public static final String CONNECT_ID = "connectId";
    public static final String SESSION_ID = "sessionID";
    public static final String OS_NAME = "osName";

    public static final String SUCCESS = "Success";
    public static final String FAILED = "Failed";
    
    private Logger logger;
	private Logger PERFLogger;
    private static final Logger AUDIT_LOGGER = LoggerFactory.getLogger("AuditLogger");
    /**
    
    OFF(0),

     MANDATORY(10)

    FATAL(100),
    ERROR(200),

     PERF(290)
    
    WARN(300),
    INFO(400),
    DEBUG(500),
    TRACE(600),
    ALL(Integer.MAX_VALUE);
    */
    // custom logger level
	private final static Level PERF = Level.forName("PERF", Level.WARN.intLevel() - 10 );

	private final static Level MANDATORY = Level.forName("MANDATORY", Level.OFF.intLevel() + 10);
    public MbnaLogger(Class<?> logOwnerClass) {
        logger = LoggerFactory.getLogger(logOwnerClass);
    }
    
    // ============ERROR(200) level==================
    public void error(String methodName, String message) {
        logger.error(" - in " + methodName + " -> : " + maskCardNumberAndPin(message));
    }

    public void error(String methodName, String message, Throwable exception) {
        logger.error(" - in " + methodName + " -> : " + maskCardNumberAndPin(message), exception);
    }
    public void error(String message, Throwable exception) {
    	logger.error(" --> : " + maskCardNumberAndPin(message), exception);
    }
    public void error(String message) {
    	logger.error(" --> : " + maskCardNumberAndPin(message));
    }
    public void error(Throwable exception) {
    	logger.error("" + exception);
    }
    
	public void error(HttpRequest request, ClientHttpResponse response) {
		String connectId = request.getHeaders().getFirst(MSECConstants.CONNECT_ID);
		String uri = request.getURI().toString();
		try {
			logger.error(" --> : Rest API Call failed: [ Request connectID = "
					+ connectId + " URI = " + uri +"] [Response = "
					+ StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
		} catch (IOException e) {
			logger.error(" ", "log respose failed", e);
		}	
	}
    
    // ==============PERF(290) level =================
    public final void enterMethod(String methodName) {
		logger.info(PERF.name() + " -->Entering: " + methodName);
    }
    
    public final void leaveMethod(String methodName) {
    	logger.info(PERF.name() + " -->Leaving: " + methodName);
    }
    
    public final void leaveMethod(String methodName, long startTime) {
    	logger.info(PERF.name() + " -->Leaving: " + methodName);
    	long endTime = System.currentTimeMillis();
    	logger.info(generatePerfMessage(startTime, endTime, methodName), PERF.name());
    }
    
    public final void leaveMethod(String methodName, long startTime, String resultMessage) {
    	logger.info(PERF.name() + " -->Leaving: " + methodName);
    	long endTime = System.currentTimeMillis();
    	logger.info(generatePerfMessage(startTime, endTime, methodName, resultMessage), PERF.name());
    }
    
    private static String generatePerfMessage(long startTime, long endTime, String methodName) {
    	return " -->#" + methodName + " - : TIME:<TIMESTAMP> " + startTime
    			+ " to " + endTime + "  " + (endTime - startTime) + " ms";
    }
    
    private static String generatePerfMessage(long startTime, long endTime,
    		String methodName, String resultMessage) {
    	return " -->#" + methodName + "[" + resultMessage + "] - : TIME:<TIMESTAMP> " + startTime
    			+ " to " + endTime + "  " + (endTime - startTime) + " ms";
    }
    
    // =======MANDATORY(280) level=================
    public void mandatory(String message) {
        AUDIT_LOGGER.info(maskCardNumberAndPin(message), MANDATORY.name());
    }
    // =========WARN(300) level====================
    public void warn(String message) {
        logger.warn(" -> : "+maskCardNumberAndPin(message));
    }
    public void warning(String message) {
    	logger.warn(" -> : "+maskCardNumberAndPin(message));
    }
    //============INFO(400) level==================
	public void info(String message, Exception e) {
		logger.info(" -> : " + maskCardNumberAndPin(message),e);		
	}
    public void info(String methodName, String message) {
        logger.info(methodName + " -> : " + maskCardNumberAndPin(message));
    }

    public void info(String message) {
        logger.info(maskCardNumberAndPin(" -> : "+message+" "));
    }

    // ==============DEBUG(500) level==============
    public void debug(String message) {
        logger.debug(" -> : "+message);
    }
	public void debug(String methodName, String message) {
		logger.debug(" -> Method: " + methodName + ", -> : " + message);
		
	}
	public boolean isEnabled(org.slf4j.event.Level level) {
        switch (level){
			case TRACE:
				return logger.isTraceEnabled();
			case DEBUG:
				return logger.isDebugEnabled();
			case INFO:
				return logger.isInfoEnabled();
			case WARN:
				return logger.isWarnEnabled();
			case ERROR:
				return logger.isErrorEnabled();
			default:
				return false;
		}
    }
	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}
    // ===========TRACE(600) level================
	public void trace(String message) {
		logger.trace(" -> : "+message);		
	}
	
    // ALL(Integer.MAX_VALUE) level

	// =====================
    public void setSessionInfo(final TrackableRequest request) {
    	if(request == null){
    		return;
    	}
        TrackingInfoType sessionInfo = request.getSessionInfo();
        if (sessionInfo == null) {
        	return;
        }
        String connectId = sessionInfo.getConnectId();
        setConnectId(connectId);
        String remoteIp = sessionInfo.getIpAddr();
        setIpAddress(remoteIp);
        String sessionId = sessionInfo.getSessionId();
        setSessionId(sessionId);

    }
    public void setSessionInfo(String connectId, String remoteIp) {
    	setConnectId(connectId);
        setIpAddress(remoteIp);
    }
    
	public void setMDC (HttpServletRequest request) {
		if(request == null){
			return;
		}
		// Truncate the sessionId to be logged in the logs
		String sid = request.getSession().getId();
		setSessionId(sid);
		
		String ipAddress = request.getHeader("X-FORWARDED-FOR");  
		if (ipAddress == null || ipAddress.isEmpty()) {  
			ipAddress = request.getRemoteAddr();  
		}
		setIpAddress(ipAddress);
		
		String connectId = (String) request.getSession().getAttribute("_mbna_session_connect_id");
		setConnectId(connectId);
		
		MDC.put(MbnaLogger.OS_NAME, getOS(request));
		
	}
	
	public void setConnectId(String cid){
		if( isEmpty(cid) ){
			return;
		}
		MDC.put(MbnaLogger.CONNECT_ID, cid);
	}
	
	public void setSessionId(String sid){
		if(isEmpty(sid)){
			return;
		}
		MDC.put(MbnaLogger.SESSION_ID, sid.substring(0, sid.length() > 18 ? 18 : sid.length()));
	}
	public void setIpAddress(String ipAddress){    	
		if(isEmpty(ipAddress)){
			return;
		}
		MDC.put(MbnaLogger.REMOTE_IP, ipAddress);
	}
    public void clearMDC() {
		MDC.remove(CONNECT_ID);
		MDC.remove(REMOTE_IP);
		MDC.remove(SESSION_ID);
		MDC.remove(OS_NAME);
    }
    
    
    private static String maskCardNumberAndPin(String message) {
        if (message == null){
        	return message;
        }

        String pinpatStr = "(pin|pinRetyped)>(.*?)</(pin|pinRetyped)";
        String patstr2 = "(CardNO|cardNum|cardNbr|CardNumber)>(\\d*)(\\d{4})<";
        String acctIdWithCardNbr = "(acctId)>\\s*(\\d{12})(\\d{4})\\s*<";
        return message.replaceAll(patstr2, "$1>**********$3<").replaceAll(acctIdWithCardNbr, "$1>**********$3<").replaceAll(pinpatStr, "$1>****</$1");
    }
    
    public void  toJson(Object jsonObj){
    	if (jsonObj ==  null || !logger.isDebugEnabled() ){
    		return;
    	}
    	try {
    		Gson gson = new GsonBuilder()
    		.serializeNulls()
    		.setPrettyPrinting()
    		//					.registerTypeAdapter(
    		//							XMLGregorianCalendar.class,
    		//							new XMLGregorianCalendarConverter.Deserializer())
    		.create();
    		logger.debug(" object "+jsonObj.getClass()+" = " + gson.toJson(jsonObj));
    	} catch (Exception e) {
    		logger.error(" toJson failure", "failed to print object to json", e);
    	}
    	return;
    }
    public void  toJson(String methodName,Object jsonObj){
    	if (jsonObj ==  null || !logger.isDebugEnabled() ){
    		return;
    	}
    	try {
    		Gson gson = new GsonBuilder()
    		.serializeNulls()
    		.setPrettyPrinting()
    		//					.registerTypeAdapter(
    		//							XMLGregorianCalendar.class,
    		//							new XMLGregorianCalendarConverter.Deserializer())
    		.create();
    		logger.debug(" -> Method: " + methodName + ", object "+jsonObj.getClass()+" = " + gson.toJson(jsonObj));
    	} catch (Exception e) {
    		logger.error(" toJson failure", "failed to print object to json", e);
    	}
    	return;
    }
    
	private  String getOS(HttpServletRequest request) {
//		String browser = sessionProvider.getHttpServletRequest().getHeader("User-Agent").split(" ")[0];
		final String userAgent = request.getHeader("User-Agent");
		final String toReturn;

		if (userAgent == null || userAgent.isEmpty()) {
			toReturn = "UNKNOWN";
		} else if (userAgent.toLowerCase().contains("windows")) {
			toReturn = "WINDOWS";
		} else if (userAgent.toLowerCase().contains("mac")) {
			toReturn = "MAC";
		} else if (userAgent.toLowerCase().contains("x11")) {
			toReturn = "LINUX";
		} else if (userAgent.toLowerCase().contains("android")) {
			toReturn = "ANDROID";
		} else if (userAgent.toLowerCase().contains("iphone")) {
			toReturn = "IPHONE";
		} else {
			toReturn = "UNKNOWN";
		}

		return toReturn;
	}
	
    private boolean isEmpty(String s) {

        int i = s == null ? 0
                          : s.length();

        while (i > 0) {
            if (s.charAt(--i) > ' ') {
                return false;
            }
        }

        return true;
    }
}


