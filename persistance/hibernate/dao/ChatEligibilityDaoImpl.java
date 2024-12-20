package com.td.mbna.msec.midtier.persistance.hibernate.dao;

//import java.util.Collection;
//
//import org.hibernate.Session;
//import org.springframework.stereotype.Repository;
//
//import com.td.mbna.msec.midtier.persistance.entity.ChatEligibility;
//import com.td.mbna.msec.midtier.util.MbnaLogger;

/**
* This class implements the interface to the CHATELIGIBILITY table.
*   
*/
//@Repository
public class ChatEligibilityDaoImpl extends AbstractDaoImpl implements ChatEligibilityDao {

//	private static MbnaLogger logger = new MbnaLogger(ChatEligibilityDaoImpl.class);
//	
//	/**
//	 * get chat eligibility by product codes
//	 */
//	@Override
//	@SuppressWarnings("unchecked")
//	public ChatEligibility getChatEligiblityByProductCodes(String pc, String arqCode) {
//		logger.info("getChatEligiblityByProductCodes(String pc, String arqCode)::pc="+pc+" arqCode="+arqCode);
//		final String DEFAULT = "DEFAULT";
//		Collection<ChatEligibility> ce = null;
//		String arqInfo = "";
//
//		Session session = null;
//		try {
//			session = this.getSession();
//		} catch (Exception e) {
//			logger.error("getChatEligiblityByProductCodes(String pc, String arqCode)::this.getSession() failed::", e.getMessage(), e);
//		}
//		if(session == null){
//			return null;
//		}
//	    try {
//	        if (arqCode != null && arqCode.trim().length() > 0) {
//	        	String fullProductCode = pc+"-"+arqCode;
//	        	ce = session.createQuery("from ChatEligibility c where c.productCodes = :productCodes")
//	        			.setParameter("productCodes", fullProductCode)
//	        			.list();
//	        	arqInfo = " with ArqCode " + arqCode;
//	        }
//	        if (ce == null || ce.size() == 0) {
//	        	ce = session.createQuery("from ChatEligibility c where c.productCodes = :productCodes")
//	        			.setParameter("productCodes", pc)
//	        			.list();
//	        }
//	        if (ce.size()==1) { 
//	        	return ce.iterator().next();
//	        }else{
//	        	//get the default
//	        	logger.warning("Getting default chat eligibility for productCodes " + pc + arqInfo + ".");
//	        	ce = session.createQuery("from ChatEligibility c where c.productCodes = :productCodes")
//	        			.setParameter("productCodes", DEFAULT)
//	        			.list();
//	        	if (ce.size()==0) {
//	        		throw new RuntimeException("no default");
//	        	}else {
//	        		return ce.iterator().next();
//	        	}
//	        }
//	    }catch(Exception e){
//	    	logger.error("getChatEligiblityByProductCodes(String pc, String arqCode)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//		return null;
//	}
	

}
