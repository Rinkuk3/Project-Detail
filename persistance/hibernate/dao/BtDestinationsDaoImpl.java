package com.td.mbna.msec.midtier.persistance.hibernate.dao;

//import java.util.Collection;
//
//import org.hibernate.Session;
//import org.springframework.stereotype.Repository;
//
//import com.td.mbna.msec.midtier.persistance.entity.BtDestinations;
import com.td.mbna.msec.midtier.util.MbnaLogger;

/**
* This class implements the interface to the BTDESTINATIONS table.
*   
*/
//@Repository
public class BtDestinationsDaoImpl extends AbstractDaoImpl implements BtDestinationsDao {
	
//	private static MbnaLogger logger = new MbnaLogger(BtDestinationsDaoImpl.class);
//	
//	/**
//	 *  find all payees for a user
//	 */
//	@SuppressWarnings("unchecked")
//	@Override
//	public Collection<BtDestinations> findByCustomer(String custId) {
//		logger.debug("findByCustomer(String custId)::custId="+custId);
//		Session session = null;
//		try{
//			session = getSession();
//			return session.createQuery("from BtDestinations where customerId = :customerId")
//					.setParameter("customerId", custId)
//					.list();
//		}catch(Exception e){
//	    	logger.error("findByCustomer(String custId)::", e.getMessage(), e);
//		}finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//		return null;
//	}
//
//	/**
//	 *  find all payees (there should really be one) by nickname
//	 */
//	@SuppressWarnings("unchecked")
//	@Override
//	public Collection<BtDestinations> findByNickname(String custId, String nickname) {
//		logger.debug("findByNickname(String custId, String nickname)::custId="+custId+" nickname="+nickname);
//		Session session = null;
//		try{
//			session = getSession();
//			return session.createQuery("from BtDestinations where customerId = :customerId and nickname = :nickname")
//					.setParameter("customerId", custId)
//					.setParameter("nickname", nickname)
//					.list();
//		}catch(Exception e){
//	    	logger.error("findByNickname(String custId, String nickname)::", e.getMessage(), e);
//		}finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//		return null;
//	}
//
//	/**
//	 *  add a payee
//	 */
//	@Override
//	public void save(BtDestinations newPayee) {
//		logger.debug("save(BtDestinations newPayee)::newPayee="+newPayee.toString());
//		Session session = null;
//		try{
//			session = getSession();
//			session.save(newPayee);
//			session.flush();
//		}catch(Exception e){
//	    	logger.error("save(BtDestinations newPayee)::", e.getMessage(), e);
//		}finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//	}
//	
//	/**
//	 *  update a payee
//	 */
//	@Override
//	public void update(BtDestinations existingPayee)  {
//		logger.debug("update(BtDestinations existingPayee)::existingPayee="+existingPayee.toString());
//		Session session = null;
//		try{
//			session = getSession();
//			session.update(existingPayee);
//			session.flush();
//		}catch(Exception e){
//	    	logger.error("update(BtDestinations existingPayee)::", e.getMessage(), e);
//		}finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//	}
//
//	/**
//	 *  delete a payee
//	 */
//	@Override
//	public void delete(BtDestinations payee) {
//		logger.debug("delete(BtDestinations payee)::payee="+payee.toString());
//		Session session = null;
//		try{
//			session = getSession();
//			session.delete(payee);
//			session.flush();
//		}catch(Exception e){
//	    	logger.error("delete(BtDestinations payee)::", e.getMessage(), e);
//		}finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//			
//	}
	

}
