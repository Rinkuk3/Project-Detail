package com.td.mbna.msec.midtier.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBResult;
import javax.xml.namespace.QName;

/**
 * 
 * This class contains JAXB helper methods.
 *
 */
public class JaxbUtil {

	private final static Map<String, JAXBContext> JaxbContextCache = new ConcurrentHashMap<String, JAXBContext>(128);
	
	
	/**
	 * get Jaxb context
	 * @param jaxbObj
	 * @return
	 * @throws JAXBException
	 */
	public static <JaxbType> JAXBContext getJaxbContext(JaxbType jaxbObj) throws JAXBException {
		return getJaxbContext(jaxbObj.getClass());
	}
	
	/**
	 * get Jaxb context
	 * @param jaxbClass
	 * @return
	 * @throws JAXBException
	 */
	public static synchronized <JaxbType> JAXBContext getJaxbContext(Class<JaxbType> jaxbClass) throws JAXBException {
		String jaxbContextPath = jaxbClass.getPackage().getName();
		return getJaxbContext(jaxbContextPath);
	}
	
	/**
	 * get Jaxb context
	 * @param jaxbContextPath
	 * @return
	 * @throws JAXBException
	 */
	public static <JaxbType> JAXBContext getJaxbContext(String jaxbContextPath) throws JAXBException {
		JAXBContext jaxbCtx =  JaxbContextCache.get(jaxbContextPath);
		if (jaxbCtx == null) {
			synchronized (jaxbContextPath.intern()) {
				jaxbCtx =  JaxbContextCache.get(jaxbContextPath);
				if (jaxbCtx == null) {
					jaxbCtx = JAXBContext.newInstance(jaxbContextPath);
					JaxbContextCache.put(jaxbContextPath, jaxbCtx);
				}
			}
		}
		return jaxbCtx;
	}
	

	/**
	 * generate Jaxb element
	 * @param jaxbObj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <JaxbType> JAXBElement<JaxbType> genJaxbElement(JaxbType jaxbObj) {
		Class<JaxbType> jaxbClass = (Class<JaxbType>) jaxbObj.getClass();
		String tagName = jaxbClass.getSimpleName(); // Use the class name as the root tag name
		return  new JAXBElement<JaxbType>(new QName(tagName), jaxbClass, jaxbObj);
	}
	

	@SuppressWarnings("unchecked")
	public static <JaxbType> JaxbType getResultValue(JAXBResult jaxbResult, Class<JaxbType> jaxbClass) throws Exception {
		Object res = jaxbResult.getResult();
		if (jaxbClass.isInstance(res)) {
			return (JaxbType) res;
		}
		else {
			JAXBElement<JaxbType> jbe = (JAXBElement<JaxbType>) jaxbResult.getResult();
			return (JaxbType) jbe.getValue();
		}
	}
	

}
