package com.td.mbna.msec.midtier.serializers;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GsonDateSerializer implements JsonSerializer<Long> {
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    protected static final ThreadLocal<SimpleDateFormat> FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DATE_FORMAT);
        }

    };


	@Override
	public JsonElement serialize(Long aLong, Type type, JsonSerializationContext jsonSerializationContext) {
		if(aLong ==  null){
			return null;
		}
		return new JsonPrimitive(Long.parseLong(FORMAT.get().format(new Date(aLong))));
	}
}
