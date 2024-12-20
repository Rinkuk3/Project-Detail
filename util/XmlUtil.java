package com.td.mbna.msec.midtier.util;

import java.text.MessageFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 
 * Helper XML methods.
 *
 */
public class XmlUtil {
	
	private static MbnaLogger logger = new MbnaLogger(XmlUtil.class);

	/**
	 * generate document builder
	 * @return
	 * @throws Exception
	 */
	public static DocumentBuilder genDocumentBuilder() throws Exception {
		return genSafeDocumentFactory().newDocumentBuilder();
	}
	
	
	/**
	 * generate document builder which excludes external dtd files
	 * @return
	 * @throws Exception
	 */
	public static DocumentBuilder genDocumentBuilderWithoutExternalDTD(String schemaPath) throws Exception {		
				DocumentBuilder builder = GenericContentUtil.getDocumentBuilder(schemaPath);
				return builder;
	}
	
	private static DocumentBuilderFactory genSafeDocumentFactory() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		// entity expansion is often exploited by hackers. Turn it off since we shouldn't need it.
		factory.setExpandEntityReferences(false);
		// Following two properties prevent XML External Entity Injection
		factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
		factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
		// Following property prevents XML Entity Expansion injection (turned on by default since JAXP 1.4 but do it explicitly for safety) 
		factory.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
		// Following line turns off inline DOCTYPE declaration, which XXE and XML Entity Expansion injections make use of
		// So this line really supercedes the 3 properties above. But also set those properties as well just to be safe.
		factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
		return factory;
	}
	
	static class SchemaErrorHandler extends DefaultHandler
	{
		   private MessageFormat message = new MessageFormat("({0}: {1}, {2}): {3}");
		      
		   private void print(SAXParseException x)
		   {
		      String msg = message.format(new Object[]
		                                  {
		                                     x.getSystemId(),
		                                     new Integer(x.getLineNumber()),
		                                     new Integer(x.getColumnNumber()),
		                                     x.getMessage()
		                                  });
		      logger.warn("SchemaErrorHandler.print(SAXParseException x)::"+msg);
		   }
		      
		   public void warning(SAXParseException x)
		   {
		      print(x);
		   }

		   public void error(SAXParseException x)
		   {
		      print(x);
		   }
		         
		   public void fatalError(SAXParseException x)
		      throws SAXParseException
		   {
		      print(x);
		      throw x;
		   }
		}
}

