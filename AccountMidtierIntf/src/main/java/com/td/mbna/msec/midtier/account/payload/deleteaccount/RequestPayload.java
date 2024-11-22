package com.td.mbna.msec.midtier.account.payload.deleteaccount;

import com.td.mbna.msec.midtier.types.common.DeliveryPreferenceType;

import java.util.HashMap;
import java.util.Map;

public class RequestPayload {

    private String connectId;
    private DeliveryPreferenceType acctDeliveryPreference;
    
//    @Expose
    private Map<String, Object> additionalProperties = new HashMap<>();

    public String getConnectId() {
        return connectId;
    }

    public void setConnectId(String connectId) {
        this.connectId = connectId;
    }

    public DeliveryPreferenceType getAcctDeliveryPreference() {
        return acctDeliveryPreference;
    }

    public void setAcctDeliveryPreference(DeliveryPreferenceType acctDeliveryPreferenceType) {
        this.acctDeliveryPreference = acctDeliveryPreferenceType;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }



}

