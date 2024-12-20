package com.td.mbna.msec.midtier.persistance.hibernate.dao;

//import java.util.Collection;
//
//import org.hibernate.Session;
//import org.springframework.stereotype.Repository;
//
//import com.td.mbna.msec.midtier.persistance.entity.TtcDestinations;
//import com.td.mbna.msec.midtier.util.MbnaLogger;

/**
* This class implements the interface to the TTCDESTINATIONS table.
*   
*/

//@Repository
public class TtcDestinationsDaoImpl extends AbstractDaoImpl implements TtcDestinationsDao {
	
//	private static MbnaLogger logger = new MbnaLogger(TtcDestinationsDaoImpl.class);
//	
//	/**
//	 * find TTC payees by customer ID
//	 */
//	@SuppressWarnings("unchecked")
//	@Override
//	public Collection<TtcDestinations> findByCustomer(String custId){
//		logger.debug("findByCustomer(String custId)::custId="+custId);
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        return session.createQuery("from TtcDestinations where customerId = :custId order by ttcdestinationid asc")
//	        		.setParameter("custId", custId)
//	        		.list();
//	    }catch(Exception e){
//	    	logger.error("findByCustomer(String custId)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//		return null;
//	}
//	
//	/**
//	 * find TTC payees by nickname
//	 */
//	@SuppressWarnings("unchecked")
//	@Override
//	public Collection<TtcDestinations> findByNickname(String custId, String nickname) {
//		logger.debug("findByNickname(String custId, String nickname)::custId="+custId+" nickname="+nickname);
//		
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        return session.createQuery("from TtcDestinations where customerId = :custId and nickname = :nickname")
//	        		.setParameter("custId", custId)
//	        		.setParameter("nickname", nickname)
//	        		.list();
//	    }catch(Exception e){
//	    	logger.error("findByNickname(String custId, String nickname)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//		return null;
//	}
//
//	/**
//	 * find TTC payees by nickname
//	 */
//	@SuppressWarnings("unchecked")
//	@Override
//	public TtcDestinations findLatestSavedPayee(String custId){	
//		
//		logger.debug("findLatestSavedPayee(String custId)::custId="+custId);
//		Collection<TtcDestinations> savedTTC = null;
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        savedTTC = session.createQuery("from TtcDestinations where customerId = :custId order by ttcdestinationid desc")
//	        		.setParameter("custId", custId)
//	        		.list();	
//	        
//	        logger.debug("findLatestSavedPayee(String custId)::result="+savedTTC);
//	        if(savedTTC !=null && savedTTC.size()>0){
//	        	return savedTTC.iterator().next();
//	        }
//	    }catch(Exception e){
//	    	logger.error("findLatestSavedPayee(String custId)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//		return null;
//	}
//	
//	/**
//	 * save TTC payee
//	 */
//	@Override
//	public void save(TtcDestinations payee) {
//		logger.debug("save(TtcDestinations payee)::newPayee="+payee);
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        session.save(payee);
//	        session.flush();
//	    }catch(Exception e){
//	    	logger.error("save(TtcDestinations payee)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//	}
//	
//	/**
//	 * update TTC payee
//	 */
//	@Override
//	public void update(TtcDestinations payee) {
//		logger.debug("update(TtcDestinations payee)::payee="+payee);
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        session.update(payee);
//	        session.flush();
//	    }catch(Exception e){
//	    	logger.error("update(TtcDestinations payee)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//	}
//
//	/**
//	 * delete TTC payee
//	 */
//	@Override
//	public void delete(TtcDestinations payee) {
//		logger.debug("delete(TtcDestinations payee)::payee="+payee);
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        session.delete(payee);
//	        session.flush();
//	    }catch(Exception e){
//	    	logger.error("delete(TtcDestinations payee)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//			
//	}
//	

}
