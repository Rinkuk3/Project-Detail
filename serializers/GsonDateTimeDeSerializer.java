package com.td.mbna.msec.midtier.serializers;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class GsonDateTimeDeSerializer implements JsonDeserializer<Long> {

	@Override
	public Long deserialize(JsonElement jsonElement, Type type,
			JsonDeserializationContext contxt) throws JsonParseException {

		if (jsonElement == null) {
			return null;
		}

		String dateString = null;
		try {
			if (StringUtils.isNotBlank(jsonElement.getAsString())) {
				dateString = jsonElement.getAsString();
			}
		} catch (Exception e1) {
			JsonObject jo = jsonElement.getAsJsonObject().getAsJsonObject();
			if(jo != null && jo.get("value") != null){
				dateString = jo.get("value").toString();
			}
		}

		// check if date String is a number of string
		if (StringUtils.isNumeric(dateString)) {
			return Long.valueOf(dateString);
		}

		try {
			if(dateString == null || dateString.startsWith("-")){
				return null;
			}
			Date date = GsonDateTimeSerializer.FORMAT.get().parse(dateString);
			return date.getTime();
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

	}
}
