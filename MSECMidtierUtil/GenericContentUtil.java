package com.td.mbna.msec.midtier.util;

import com.td.mbna.msec.midtier.util.XmlUtil.SchemaErrorHandler;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.InputStream;

/**
 * This class contains helper methods to help in DOM manipulation.
 *
 */
public abstract class GenericContentUtil {


	private final static String SchemaPath = "/schema/MSECURE-WCM.xsd";

	/**
     * Utility function to return the DOM representation of an XML file  
     * 
     * @param xmlFileName fully-qualified path the of the XML file
     * @return DOM representation of the XML file
     */
	protected static Document parse(String xmlFileName) throws Exception {
		DocumentBuilder builder = getDocumentBuilder(SchemaPath);
		return builder.parse(xmlFileName);
	}
	
	/**
     * Utility function to return the DOM representation of an XML inputStream  
     * 
     * @param xml fully-qualified path the of the XML file
     * @return DOM representation of the XML file
     */
	protected static Document parse(InputStream xml) throws Exception {
		DocumentBuilder builder = getDocumentBuilder(SchemaPath);
		return builder.parse(xml);
	}
	
	public static DocumentBuilder getDocumentBuilder(String tSchemaPath)throws Exception {
		
		final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
		final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
		final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    String FEATURE = null;
        FEATURE = "http://apache.org/xml/features/disallow-doctype-decl";
        dbf.setFeature(FEATURE, true);
        FEATURE = "http://xml.org/sax/features/external-general-entities";
        dbf.setFeature(FEATURE, false); 
        FEATURE = "http://xml.org/sax/features/external-parameter-entities";
        dbf.setFeature(FEATURE, false);
        FEATURE = "http://apache.org/xml/features/nonvalidating/load-external-dtd";
        dbf.setFeature(FEATURE, false);
        dbf.setXIncludeAware(false);
        dbf.setExpandEntityReferences(false);
        dbf.setValidating(true);
        dbf.setNamespaceAware(true);
        dbf.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
        InputStream schemaStream = XmlUtil.class.getResourceAsStream(tSchemaPath);
		dbf.setAttribute(JAXP_SCHEMA_SOURCE, schemaStream);
		DocumentBuilder builder = dbf.newDocumentBuilder();
		builder.setErrorHandler(new SchemaErrorHandler());
		return builder;
		
	}
}
