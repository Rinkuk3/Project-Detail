package com.td.mbna.msec.midtier.util;

import java.lang.reflect.Type;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class XMLGregorianCalendarConverter {
	private static final MbnaLogger logger = new MbnaLogger(XMLGregorianCalendarConverter.class);
			
    public static class Serializer implements JsonSerializer<XMLGregorianCalendar> {
        @Override
        public JsonElement serialize(XMLGregorianCalendar xmlGregorianCalendar, Type type, JsonSerializationContext jsonSerializationContext) {
        	// convert to Long -- toJson
        	try {
//        		logger.debug("XMLGregorianCalendarConverter.Serializer: JsonPrimitive = "+xmlGregorianCalendar.toGregorianCalendar().getTimeInMillis());
				return new JsonPrimitive(xmlGregorianCalendar.toGregorianCalendar().getTimeInMillis());
			} catch (Exception e) {
				logger.error("XMLGregorianCalendarConverter.Serializer", "failure " + e.getLocalizedMessage(), e);
			}
			return null;
        }
    }

    public static class Deserializer implements JsonDeserializer<XMLGregorianCalendar> {
        @Override
        public XMLGregorianCalendar deserialize(JsonElement jsonElement, Type type,
                JsonDeserializationContext jsonDeserializationContext) {
        	
        	// convert from Long  -- fromJson
        	if(jsonElement ==  null){
        		return null;
        	}
        	
        	Long dateLong = null;
        	try {
    			if (StringUtils.isNotBlank(jsonElement.getAsString())) {
    				dateLong = jsonElement.getAsLong();
    			}
    		} catch (Exception e1) {
    			JsonObject jo = jsonElement.getAsJsonObject().getAsJsonObject();
    			dateLong = Long.parseLong(jo.get("value").toString());
    		}
            try {
            	final GregorianCalendar calendar = new GregorianCalendar();
                calendar.setTimeInMillis(dateLong);
                XMLGregorianCalendar xmlGCal= DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
                xmlGCal.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
//                logger.debug("XMLGregorianCalendarConverter.Deserializer: xmlGCal = "+xmlGCal);
                return xmlGCal;
            } catch (Exception e) {
                logger.error("XMLGregorianCalendarConverter.Deserializer", "failure " + e.getLocalizedMessage(), e);
                return null;
            }
        }
    }

}

