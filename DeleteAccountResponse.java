package com.td.mbna.msec.midtier.account.payload.deleteaccount;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.td.mbna.msec.midtier.types.common.BaseResponse;

public class DeleteAccountResponse extends BaseResponse implements Serializable
{

	private final static long serialVersionUID = -1201028720771550283L;

//	@SerializedName("ResponsePayload")
    private Object responsePayload;
	
//	@Expose
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public Object getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(Object responsePayload) {
        this.responsePayload = responsePayload;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}
