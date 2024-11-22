package com.td.mbna.msec.midtier.account.payload.getaccountsnapshot;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.Expose;

public class SequenceNumber {

    private String name;
    private String declaredType;
    private String scope;
    private Integer value;
    private Boolean nil;
    private Boolean globalScope;
    private Boolean typeSubstituted;
    
    @Expose
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeclaredType() {
        return declaredType;
    }

    public void setDeclaredType(String declaredType) {
        this.declaredType = declaredType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    public Boolean getNil() {
        return nil;
    }

    public void setNil(Boolean nil) {
        this.nil = nil;
    }

    public Boolean getGlobalScope() {
        return globalScope;
    }

    public void setGlobalScope(Boolean globalScope) {
        this.globalScope = globalScope;
    }

    public Boolean getTypeSubstituted() {
        return typeSubstituted;
    }
    public void setTypeSubstituted(Boolean typeSubstituted) {
        this.typeSubstituted = typeSubstituted;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
