package com.td.api.mbna.msec.midtier.mbnaparty.payload;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Contact implements Serializable {
    public String key;
    public String usageCd;
    public String startDt;
    public String usageDesc;
    public Date lastModifiedDttm;
    public Locator locator;
}
