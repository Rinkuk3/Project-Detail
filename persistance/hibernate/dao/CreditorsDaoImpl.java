package com.td.mbna.msec.midtier.persistance.hibernate.dao;

//import java.util.Collection;
//
//import org.hibernate.Session;
//import org.springframework.stereotype.Repository;
//
//import com.td.mbna.msec.midtier.persistance.entity.Creditors;
//import com.td.mbna.msec.midtier.util.MbnaLogger;

/**
* This class implements the interface to the CREDITORS table.
*   
*/
//@Repository
public class CreditorsDaoImpl extends AbstractDaoImpl implements CreditorsDao {
	
//	private static MbnaLogger logger = new MbnaLogger(CreditorsDaoImpl.class);
//	
//	/**
//	 * get creditor by id
//	 */
//	@SuppressWarnings("unchecked")
//	public Creditors getCreditorById(String creditorId) {
//		logger.debug("getCreditorById(String creditorId)::creditorId="+creditorId);
//		if (creditorId == null) {
//			return null;
//		}
//		
//		Session session = null;
//		try{
//			session = getSession();
//			Collection<Creditors> rs = session.createQuery("from Creditors c where creditorId = :creditorId")
//					.setParameter("creditorId", creditorId)
//					.list();
//			logger.debug("getCreditorById(String creditorId)::result="+rs.toString());
//			if (rs.size() == 1) {
//				return rs.iterator().next();
//			}
//			else {
//				return null;
//			}
//		}catch(Exception e){
//	    	logger.error("getCreditorById(String creditorId)::", e.getMessage(), e);
//		}finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//		return null;
//	}
//	
//	/**
//	 * get creditor by merchant id
//	 */
//	@SuppressWarnings("unchecked")
//	public Creditors getCreditorByMerchantId(String merchantId) {
//		logger.debug("getCreditorByMerchantId(String merchantId)::merchantId="+merchantId);
//		if (merchantId == null) {
//			return null;
//		}
//		
//		Session session = null;
//		try{
//			session = getSession();
//			Collection<Creditors> rs = session.createQuery("from Creditors c where merchantId = :merchantId")
//					.setParameter("merchantId", merchantId)
//					.list();
//			logger.debug("getCreditorByMerchantId(String merchantId)::result="+rs.toString());
//			if (rs.size() == 1) {
//				return rs.iterator().next();
//			}
//			else {
//				return null;
//			}
//		}catch(Exception e){
//	    	logger.error("getCreditorByMerchantId(String merchantId)::", e.getMessage(), e);
//		}finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//		return null;
//	}
//	
//	/**
//	 * get credit by name in English
//	 */
//	@SuppressWarnings("unchecked")
//	public Creditors getCreditorByEnglishName(String creditorName) {
//		logger.debug("getCreditorByEnglishName(String creditorName)::creditorName="+creditorName);
//		Session session = null;
//		try{
//			session = getSession();
//			Collection<Creditors> creditors = session.createQuery("from Creditors where name_EN = :name_EN")
//					.setParameter("name_EN", creditorName)
//					.list();
//			if (creditors.size() == 1) {
//				return creditors.iterator().next();
//			}
//			else {
//				return null;
//			}
//		}catch(Exception e){
//	    	logger.error("getCreditorByEnglishName(String creditorName)::", e.getMessage(), e);
//		}finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//		return null;
//	}
//	
//	/**
//	 * get creditor by name in French
//	 */
//	@SuppressWarnings("unchecked")
//	public Creditors getCreditorByFrenchName(String creditorName) {
//		logger.debug("getCreditorByFrenchName(String creditorName)::creditorName="+creditorName);
//		
//		Session session = null;
//		try{
//			session = getSession();
//			Collection<Creditors> creditors = session.createQuery("from Creditors where name_FR = :name_FR")
//					.setParameter("name_FR", creditorName)
//					.list();
//			logger.debug("getCreditorByFrenchName(String creditorName)::result="+creditors.toString());
//			if (creditors.size() == 1) {
//				return creditors.iterator().next();
//			}
//			else {
//				return null;
//			}
//		}catch(Exception e){
//	    	logger.error("getCreditorByFrenchName(String creditorName)::", e.getMessage(), e);
//		}finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//		return null;
//	}
//
//	/**
//	 * get all creditors
//	 */
//	@SuppressWarnings("unchecked")
//	public Collection<Creditors> getAllCreditors() {
//		
//		Session session = null;
//		try{
//			session = getSession();
//			Collection<Creditors> creditors = session.createQuery("from Creditors")
//					.list();
//			return creditors;
//		}catch(Exception e){
//	    	logger.error("getAllCreditors()::", e.getMessage(), e);
//		}finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//		return null;
//	}
//	

}
