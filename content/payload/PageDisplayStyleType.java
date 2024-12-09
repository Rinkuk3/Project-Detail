package com.td.mbna.msec.midtier.content.payload;

import java.util.HashMap;
import java.util.Map;

public enum PageDisplayStyleType {

	REGULAR("REGULAR"), POPUP("POPUP");
	
	private final String value;
	private final static Map<String, PageDisplayStyleType> CONSTANTS = new HashMap<String, PageDisplayStyleType>();

	static {
		for (PageDisplayStyleType c : values()) {
			CONSTANTS.put(c.value, c);
		}
	}

	private PageDisplayStyleType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}

	public String value() {
		return this.value;
	}

	public static PageDisplayStyleType fromValue(String value) {
		PageDisplayStyleType constant = CONSTANTS.get(value);
		if (constant == null) {
			throw new IllegalArgumentException(value);
		} else {
			return constant;
		}
	}

}
