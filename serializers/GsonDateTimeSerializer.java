package com.td.mbna.msec.midtier.serializers;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GsonDateTimeSerializer implements JsonSerializer<Long> {
    private static final String DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";

    protected static final ThreadLocal<SimpleDateFormat> FORMAT = ThreadLocal.withInitial( () -> new SimpleDateFormat(DATETIME_FORMAT));

	@Override
	public JsonElement serialize(Long aLong, Type type,
			JsonSerializationContext jsonSerializationContext) {
		if (aLong == null) {
			return null;
		} 
		return new JsonPrimitive(Long.parseLong(FORMAT.get().format(new Date(aLong))));
	}
}
