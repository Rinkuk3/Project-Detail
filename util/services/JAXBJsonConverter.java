package com.td.mbna.msec.midtier.util.services;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.XMLGregorianCalendarConverter;

public class JAXBJsonConverter {
    private static final MbnaLogger logger = new MbnaLogger(JAXBJsonConverter.class);

    public static <T> T convertJsonToJAXBInterface(Object jsonObj, Class<T> jaxbInterface) {
    	if (jsonObj == null) {
    		return null;
    	}
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.registerTypeAdapter(XMLGregorianCalendar.class,
						new XMLGregorianCalendarConverter.Serializer())
				.create();
    	String fromIntfInJson=gson.toJson(jsonObj);
    	T t = null;
//    	if(fromIntfInJson.length() < 42768 && !(t instanceof com.td.mbna.msec.midtier.statement.payload.getStatementFileFromId.GetStatementFileFromIdResponse)){
//    		logger.debug("in:: convertJsonToJAXBInterface(Object jsonObj, Class<T> jaxbInterface)::" +jsonObj.getClass()+"::"+ fromIntfInJson);
//    	}
		gson = new GsonBuilder()
				.setPrettyPrinting()
				.registerTypeAdapter(XMLGregorianCalendar.class,
						new XMLGregorianCalendarConverter.Deserializer())
				.create();
		try {
			t = gson.fromJson(fromIntfInJson, jaxbInterface);
//			if(fromIntfInJson.length() < 42768 && !(t instanceof com.td.mbna.msec.midtier.statement.payload.getStatementFileFromId.GetStatementFileFromIdResponse)){
//				logger.debug("out:: convertJsonToJAXBInterface(Object jsonObj, Class<T> jaxbInterface)::" + t.getClass()+"::"+gson.toJson(t));
//			}
		} catch (Exception e) {
			logger.error("convertJsonToJAXBInterface(Object jsonObj, Class<T> jaxbInterface) deserializer is failed,", e.getMessage(), e);
		}
        return t;
    }
    

    public static <T> T convertoJAXBToJsonInterface(Object jaxbObj, Class<T> jsonInterface)/* throws Exception*/ {
    	if (jaxbObj == null) {
    		return null;
    	}
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.registerTypeAdapter(XMLGregorianCalendar.class,
						new XMLGregorianCalendarConverter.Serializer())
				.create();
		String fromIntfInJson = gson.toJson(jaxbObj);
		T t = null;
//		if(fromIntfInJson.length() < 42768 &&  !(t instanceof com.td.mbna.msec.midtier.statement.payload.getStatementFileFromId.GetStatementFileFromIdResponse)){
//			logger.debug("in:: convertoJAXBToJsonInterface(Object jaxbObj, Class<T> jsonInterface)::" +jaxbObj.getClass()+"::"+ fromIntfInJson);
//		}

		gson = new GsonBuilder()
				.setPrettyPrinting()
				.registerTypeAdapter(XMLGregorianCalendar.class,
						new XMLGregorianCalendarConverter.Deserializer())
				.create();
		try {
			t = gson.fromJson(fromIntfInJson, jsonInterface);
//			if(fromIntfInJson.length() < 42768 &&  !(t instanceof com.td.mbna.msec.midtier.statement.payload.getStatementFileFromId.GetStatementFileFromIdResponse)){
//				logger.debug("out:: convertoJAXBToJsonInterface(Object jaxbObj, Class<T> jsonInterface)::" + t.getClass()+"::"+gson.toJson(t));
//			}
		} catch (Exception e) {
			logger.error("convertoJAXBToJsonInterface() deserializer", e.getMessage(), e);
		}
	 	 return t;
        
    }
	
    public static <T> T convertoJAXBToJsonInterface(Object jaxbObj, Class<T> jsonInterface, String dateFormat) throws IOException {
    	if (jaxbObj == null) {
    		return null;
    	}
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.registerTypeAdapter(XMLGregorianCalendar.class,
						new XMLGregorianCalendarConverter.Serializer())
				.create();
		String fromIntfInJson = gson.toJson(jaxbObj);
//		logger.debug("in::convertoJAXBToJsonInterface(Object jaxbObj, Class<T> jsonInterface, String dateFormat)::" +jaxbObj.getClass()+"::"+ fromIntfInJson);
		
//		if (logger.isEnabled(Level.INFO) && fromIntfInJson.length() < 42768) {
//			 logger.info("jaxb2Json:" + fromIntfInJson);
//		}
		
		gson = new GsonBuilder()
				.setPrettyPrinting()
				.registerTypeAdapter(XMLGregorianCalendar.class,
						new XMLGregorianCalendarConverter.Deserializer())
				.create();
		return gson.fromJson(fromIntfInJson, jsonInterface);
    }
    
    public static XMLGregorianCalendar convert(Long l) {
    	XMLGregorianCalendar xCal = null;
    	if (l != null) {
    		GregorianCalendar gc = new GregorianCalendar();
    		gc.setTimeInMillis(l);
    		try {
    			xCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
				xCal.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
			} catch (DatatypeConfigurationException e) {
				// it should not happen
				logger.error("convert", "failure " + l, e);
			}
    	}
    	return xCal;
    }

    public static com.mbnaweb.xsd.types.common.UnformattedAddress convert(com.td.mbna.msec.midtier.types.common.UnformattedAddress p) {
    	com.mbnaweb.xsd.types.common.UnformattedAddress px = null;
    	try {
			px = JAXBJsonConverter.convertJsonToJAXBInterface(p, com.mbnaweb.xsd.types.common.UnformattedAddress.class);
			if (px != null) {
				px.setLastUpdatedTS(convert(p.getLastUpdatedTS()));
			}
		} catch (Exception e) {
			logger.error("convert", "failure " + p, e);
		}
    	return px;
    }
    
    private static final String PREFIX_GET = "get";
	private static final String PREFIX_IS = "is";
	private static final String PREFIX_SET = "set";
	private static Object[] getGetter(Method[] methods, Field f) {
		for (Method m: methods) {
			if (m.getName().equalsIgnoreCase(PREFIX_GET + f.getName())) {
				return new Object[] {PREFIX_GET, m};
			} else if (m.getName().equalsIgnoreCase(PREFIX_IS + f.getName())) {
				return new Object[] {PREFIX_IS, m};
			}
		}
		return null;
	}
	private static Method getTargetMethod(Object target, String methodName, Class<?> type) {
		try {
			return target.getClass().getMethod(methodName, type);
		} catch (NoSuchMethodException | SecurityException e) {
			logger.info("ignored missing targetMethod");
			return null;
		}
	}
	public static void copyBeanProperties(Object target, Object source) {
		try {
			Method[] declaredMethods = source.getClass().getDeclaredMethods();
			for (Field f: source.getClass().getDeclaredFields()) {
				Object[] getter = getGetter(declaredMethods, f);
				if (getter != null) {
					Method method = (Method)getter[1];
					String prefix = (String)getter[0];
					Method aMethod = getTargetMethod(target, PREFIX_SET + method.getName().substring(prefix.length()), method.getReturnType());
					if (aMethod != null) {
						aMethod.invoke(target, method.invoke(source));
					} else if (method.getReturnType() == Long.class) {
						aMethod = getTargetMethod(target, PREFIX_SET + method.getName().substring(prefix.length()), XMLGregorianCalendar.class);
						if (aMethod != null) {
							aMethod.invoke(target, convert((Long)(method.invoke(source))));
						}
					}
				}
			}
		
		} catch (Exception e) {
			logger.error("copyProfileProperties", e.getMessage(), e);
		}
	}


	public static String convertXmlGregorianToString(XMLGregorianCalendar xmlGregorianCalendar,String dateFormatInString) {
		if(xmlGregorianCalendar == null){
			return null;
		}
		Date date = xmlGregorianCalendar.toGregorianCalendar().getTime();
		DateFormat dateFormat = new SimpleDateFormat(dateFormatInString);
		return dateFormat.format(date);
	}

	public static XMLGregorianCalendar convert(String date, String dateFormat) {

        DateFormat dateFormatter = new SimpleDateFormat(dateFormat);

        try {
            return convert(dateFormatter.parse(date).getTime());
        } catch (ParseException e) {
            logger.error("JAXBJsonConverter:convert",e.getMessage(),e);
            throw ExceptionUtil.genRuntimeException(e);
        }

    }

    public static Long convertToLong(String date, String dateFormat) {
		DateFormat dateFormatter = new SimpleDateFormat(dateFormat);

		try {
			return dateFormatter.parse(date).getTime();
		} catch (ParseException e) {
			logger.error("JAXBJsonConverter:convert",e.getMessage(),e);
			throw ExceptionUtil.genRuntimeException(e);
		}
	}

	public static String convertDateToString(Date date, String dateFormat) {

		DateFormat dateFormatter = new SimpleDateFormat(dateFormat);
		return dateFormatter.format(date);


	}

	public static Date convertFromStringToDate(String date, String dateFormat) {

		DateFormat dateFormatter = new SimpleDateFormat(dateFormat);

		try {
			return dateFormatter.parse(date);
		} catch (ParseException e) {
			logger.error("JAXBJsonConverter:convert",e.getMessage(),e);
			throw ExceptionUtil.genRuntimeException(e);
		}
	}

}
