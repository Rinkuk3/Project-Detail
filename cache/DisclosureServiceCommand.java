package com.td.mbna.msec.midtier.cache;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.xml.bind.JAXBContext;
import com.mbnaweb.xsd.msgs.disclosure.GetDisclosureResponse;
import com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil;
import com.td.mbna.msec.midtier.util.BackEndSrvcUtil;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.JaxbUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;

/**
 * Class used to get EAA disclosure published date.
 * 
 * This command is cacheable using DynaCache.
 */
public final class DisclosureServiceCommand extends ServiceCommand {
	
	private static MbnaLogger logger = new MbnaLogger(DisclosureServiceCommand.class);
	
	/**
	 *  serial for serialization
	 */
	private static final long serialVersionUID = 369575756531424890L;
	
	/** Name of the request template for assembling the disclosure */
	private final static String ASSEMBLE_DISCLOSURE = "assembleDisclosure";
	/** Name of the response template for assembling the disclosure */
    private final static String ASSEMBLE_DISCLOSURE_FOR_DISCLOSURE = "assembleDisclosure_getDisclosure";
    /** Name of the EAA response used for assembling the disclosure */
    private final static String ASSEMBLE_DISCLOSURE_EAA = "assembleDisclosure_eaa";
	
	
    /** For local cache in case DisclosureConfiguration is down for EAA */
    private static final ReentrantReadWriteLock sLock = new ReentrantReadWriteLock();
    private static Date saveEnEaaPublishedDT = null;
    private static Date saveFrEaaPublishedDT = null;
    
    
	/**
	 *  Instance variables kept in the cached object.  
	 */
	private String languageId = null;
	private String loginId = null;
	private Date eaaPublishedDT = null;

	/**
	 * returns true if the execute method is ready to call.  Ensures that the languageId is set.
	 **/
	@Override
	public boolean isReadyToCallExecute() {
		return languageId != null && super.isReadyToCallExecute();
	}

	/** 
	 * Performs the getDisclosure call to TD and retrieves published date of latest EAA.
	 **/
	@Override
	public void performExecute() {
		logger.debug("performExecute", "NO CACHE: eaaPublishedDT, " + languageId);
		String dsLang = null;		
		try {
			if (languageId == null)
				dsLang = "en";
			else if (languageId.toLowerCase(Locale.CANADA).startsWith("fr"))
				dsLang = "fr";
			else
				dsLang = "en";
			String mimeType = "HTML";
			
			Map<String, Object> paramValues = new HashMap<>();
			paramValues.put("languageID", dsLang); 
			paramValues.put("mimeType", mimeType);
			//documentType will be taken from a property file later.
			String documentTypeCD = TDwsServiceUtil.getTDServiceParam(TDwsServiceUtil.TD_DSCFG_EAA1);

			paramValues.put("documentType", documentTypeCD);
			paramValues.put("documentUsage", "Template");
			//temporarily use this text as metadata
			//otherwise the text should be read from the session.
			String metadata = "";
			paramValues.put("metadataContent", metadata);
			
			//String tdResName = ASSEMBLE_DISCLOSURE_EAA;
			JAXBContext mtJaxBContext = JaxbUtil.getJaxbContext("com.mbnaweb.xsd.msgs.disclosure");	
			GetDisclosureResponse response = (GetDisclosureResponse) BackEndSrvcUtil.invokeService(ASSEMBLE_DISCLOSURE, ASSEMBLE_DISCLOSURE, ASSEMBLE_DISCLOSURE_EAA, ASSEMBLE_DISCLOSURE_FOR_DISCLOSURE,
																			loginId, null, null,
																			paramValues, paramValues,
																			BackEndSrvcUtil.TDOperation.TdDisclosureCfgService_assembleDisclosure,
																			mtJaxBContext);
			if (response.getResponsePayload() != null && response.getResponsePayload().getDisclosureInfo() != null &&
					response.getResponsePayload().getDisclosureInfo().getDisclosureDocPublishedDate() != null)
			{
				eaaPublishedDT = response.getResponsePayload().getDisclosureInfo().getDisclosureDocPublishedDate().toGregorianCalendar().getTime();
				sLock.writeLock().lock(); 
				try {
					if (dsLang.equals("en"))
						saveEnEaaPublishedDT = eaaPublishedDT;
					else
						saveFrEaaPublishedDT = eaaPublishedDT;
				}
				finally {
					sLock.writeLock().unlock();
				}
			}
			logger.debug("performExecute", "CACHE LOADED: eaaPublishedDT, " + languageId + ":" + eaaPublishedDT);
    	} catch (Exception e) {
			if ("en".equals(dsLang) && saveEnEaaPublishedDT != null) {
				logger.info("DisclosureConfigurationService fails");		
				logger.info(e.getMessage(), e);
				sLock.readLock().lock();			
				eaaPublishedDT = saveEnEaaPublishedDT;
				sLock.readLock().unlock();
			}
			else if ("fr".equals(dsLang) && saveFrEaaPublishedDT != null) {
				logger.info("DisclosureConfigurationService fails");		
				logger.info(e.getMessage(), e);
				sLock.readLock().lock();			
				eaaPublishedDT = saveFrEaaPublishedDT;
				sLock.readLock().unlock();
			}
			else {
				logger.error(e.getMessage(), e);
				throw ExceptionUtil.genRuntimeException(e);
			}
		}
	}
	
	/**
	 * Static method to be called from getEntitlementFlagsOpreationRealImpl to retrieve latest published date.
	 * 
	 * The results of this method can be cached in DynaCache
	 * 
	 * @param languageId the language in which the EAA is requested (required)
	 * @param loginId  the user's id for the entitlement flags
	 * 
	 * @return Date - the published date for EAA  
	 * 
	 **/
	public static Date getPublishedDT (String languageId, String loginId) throws Exception {
		//try {
			DisclosureServiceCommand ds = new DisclosureServiceCommand();
			ds.setLanguageId(languageId);
			ds.loginId = loginId;
			//ds.execute();
			ds.performExecute();
	
			return ds.getEaaPublishedDT();
		//}
		//catch(CommandException e) {
			//logger.error(e.getMessage(), e);
		//	throw new Exception(e);
		//}
		
	}

	/**
	 * @return the language ID of the requested EAA disclosure.  This is required for caching purposes.
	 */
	public final String getLanguageId() {
		return languageId;
	}

	public void setLanguageId(String languageID) {
		this.languageId = languageID;
	}

	public final Date getEaaPublishedDT() {
		return eaaPublishedDT;
	}
}
