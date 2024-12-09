package com.td.mbna.msec.midtier.types.common;

import com.google.gson.annotations.JsonAdapter;
import com.td.mbna.msec.midtier.serializers.GsonDateDeSerializer;
import com.td.mbna.msec.midtier.serializers.GsonDateTimeDeSerializer;

import java.io.Serializable;

public class DisclosureInfoType implements Serializable
{
	private final static long serialVersionUID = -7464949980995308720L;

    private String disclosureDocTypeId;
    private String disclosureLangId;
    private String disclosureMimeTypeId;
    private String disclosureMetaData;

    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long disclosureDocPublishedDate;

    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long disclosureDocCreationDate;


    public String getDisclosureDocTypeId() {
        return disclosureDocTypeId;
    }

    public void setDisclosureDocTypeId(String disclosureDocTypeId) {
        this.disclosureDocTypeId = disclosureDocTypeId;
    }

    public Long getDisclosureDocPublishedDate() {
        return disclosureDocPublishedDate;
    }

    public void setDisclosureDocPublishedDate(Long disclosureDocPublishedDate) {
        this.disclosureDocPublishedDate = disclosureDocPublishedDate;
    }

    public Long getDisclosureDocCreationDate() {
        return disclosureDocCreationDate;
    }

    public void setDisclosureDocCreationDate(Long disclosureDocCreationDate) {
        this.disclosureDocCreationDate = disclosureDocCreationDate;
    }

    public String getDisclosureLangId() {
        return disclosureLangId;
    }

    public void setDisclosureLangId(String disclosureLangId) {
        this.disclosureLangId = disclosureLangId;
    }

    public String getDisclosureMimeTypeId() {
        return disclosureMimeTypeId;
    }

    public void setDisclosureMimeTypeId(String disclosureMimeTypeId) {
        this.disclosureMimeTypeId = disclosureMimeTypeId;
    }

    public String getDisclosureMetaData() {
        return disclosureMetaData;
    }

    public void setDisclosureMetaData(String disclosureMetaData) {
        this.disclosureMetaData = disclosureMetaData;
    }

}
