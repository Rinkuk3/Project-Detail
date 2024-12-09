package com.td.mbna.msec.midtier.types.common;

import com.google.gson.annotations.JsonAdapter;
import com.td.mbna.msec.midtier.serializers.GsonDateTimeDeSerializer;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class OfferPreferenceType implements Serializable {

	private static final long serialVersionUID = -5859269290225605962L;
	
	private String ucid;
	private String connectId;
	private String cardRole;
	private String offerType;
	private String enabled;
	@JsonAdapter(value = GsonDateTimeDeSerializer.class)
	private Date enabledTS;
	private String disabled;
	@JsonAdapter(value = GsonDateTimeDeSerializer.class)
	private Date disabledTS;

}
