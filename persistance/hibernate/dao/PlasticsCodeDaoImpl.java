package com.td.mbna.msec.midtier.persistance.hibernate.dao;

//import java.util.Collection;
//
//import org.hibernate.Session;
//import org.springframework.stereotype.Repository;
//
//import com.td.mbna.msec.midtier.persistance.entity.PlasticsCode;
//import com.td.mbna.msec.midtier.util.MbnaLogger;

/**
* This class implements the interface to the PLASTICSCODE table.
*   
*/

//@Repository
public class PlasticsCodeDaoImpl extends AbstractDaoImpl  implements PlasticsCodeDao {

//	private static MbnaLogger logger = new MbnaLogger(PlasticsCodeDaoImpl.class);
//
//	
//	/**
//	 * find plastics code by product code
//	 */
//	@Override
//	@SuppressWarnings("unchecked")
//	public PlasticsCode findByProductCodes(String productCodes, String arqCode, String lang,String poCode) {
//		final String DEFAULT = "--"; //this is the default. Two minus signs.
//		Collection<PlasticsCode> poc = null;
//		String arqInfo = "";
//		logger.info("Retrieving card image. Parameters: " + productCodes + " - "+lang + " - "+ poCode + "; arqCode: " + arqCode);			
//		
//		
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        if (arqCode != null && arqCode.trim().length() > 0) {
//	        	String fullProductCodes = productCodes.trim()+"-"+arqCode;
//	        	poc = session.createQuery("from PlasticsCode a where a.productCodes = :productCodes and a.language=:language and a.poCode=:poCode")
//	        			.setParameter("productCodes", fullProductCodes.trim())
//	        			.setParameter("language", lang.trim())
//	        			.setParameter("poCode", poCode.trim())
//	        			.list();
//	        	arqInfo = " with ArqCode " + arqCode;
//	        }
//	        if (poc == null || poc.size() == 0) {
//	        	poc = session.createQuery("from PlasticsCode a where a.productCodes = :productCodes and a.language=:language and a.poCode=:poCode")
//	        			.setParameter("productCodes", productCodes.trim())
//	        			.setParameter("language", lang.trim())
//	        			.setParameter("poCode", poCode.trim())
//	        			.list();
//	        }
//	        if (poc.size()==1) { 
//	        	return poc.iterator().next();
//	        }else {				
//	        	logger.debug("no card image found. Parameters: " + productCodes + " - "+lang + " - "+ poCode +". Will query for the default.");			
//	        	// no PO code, now querying for the default
//	        	poc = session.createQuery("from PlasticsCode a where a.productCodes = :productCodes and a.language=:language and a.poCode=:poCode")
//	        			.setParameter("productCodes", productCodes.trim())
//	        			.setParameter("language", lang.trim())
//	        			.setParameter("poCode", DEFAULT)
//	        			.list();
//	        	//if no default, then return null
//	        	if (poc.size()==1) {
//	        		return poc.iterator().next();
//	        	}else {				
//	        		logger.warning("SSMT004: missing card image Id for "+productCodes+" with POCode " + poCode + arqInfo+". using no image");			
//	        		return null;
//	        	}
//	        	
//	        }
//	    }catch(Exception e){
//	    	logger.error("findByProductCodes(String productCodes, String arqCode, String lang,String poCode)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//		return null;
//	}
//	
//
//	/**
//	 * update plastics code
//	 */
//	@Override
//	public void update(PlasticsCode po) {
//		logger.toJson(po);
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        session.saveOrUpdate(po);
//	        session.flush();
//	    }catch(Exception e){
//	    	logger.error("update(PlasticsCode po)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//	}
//
//	/**
//	 * delete plastics code
//	 */
//	@Override
//	public void delete(PlasticsCode po) {
//		logger.toJson(po);
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        session.delete(po);
//	        session.flush();
//	    }catch(Exception e){
//	    	logger.error("delete(PlasticsCode po)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//
//	}
//
//	/**
//	 * save plastics code
//	 */
//	@Override
//	public void save(PlasticsCode po) {
//		logger.toJson(po);
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        session.saveOrUpdate(po);
//	        session.flush();
//	    }catch(Exception e){
//	    	logger.error("save(PlasticsCode po)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//	}
	
}
