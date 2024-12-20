package com.td.mbna.msec.midtier.configuration.beans;

import lombok.Data;

@Data
public class ExceptionInfoBeanForJson {
	private String originator;
	private String levelCode;
	private String auxCode;
	private String classification;
	private String errorCode;
	private String severity;
	private String description;
	private String beIssuer;
	private String beCodePattern;
}
