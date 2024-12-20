package com.td.mbna.msec.midtier.configuration.beans;

import lombok.Data;

import javax.xml.datatype.XMLGregorianCalendar;
@Data
public class ConsentDocBaseDetail {
    private XMLGregorianCalendar date;
    private String docTypeCode;
}
