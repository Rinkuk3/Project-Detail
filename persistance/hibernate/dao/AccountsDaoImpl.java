package com.td.mbna.msec.midtier.persistance.hibernate.dao;

//import java.util.List;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.springframework.stereotype.Repository;
//
//import com.td.mbna.msec.midtier.persistance.entity.Accounts;
//import com.td.mbna.msec.midtier.util.MbnaLogger;


/**
 * This class implements the interface to the ACCOUNTS table.
 *
 */

//@Repository
public class AccountsDaoImpl extends AbstractDaoImpl implements AccountsDao {

//	private static MbnaLogger logger = new MbnaLogger(AccountsDaoImpl.class);
//	
//
//	/**
//	 *  get accounts by customer ID
//	 */
//	@SuppressWarnings("unchecked")
//	public Accounts getAccount(String customerId, String acctNum) {
//
//		logger.debug(" getAccount(String customerId, String acctNum)::customerId = "+customerId+" ::acctNum= "+acctNum);
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        String sqlStr = "SELECT * FROM Accounts a where customerId = :customerId and accountNumber = :accountNumber";
////	        Query q = session.createSQLQuery(sqlStr).addEntity(Accounts.class);
////	        q.setParameter("customerId", customerId);
////	        q.setParameter("accountNumber", acctNum);
//	        Query query = session.createSQLQuery(sqlStr) 
//	        .addEntity(Accounts.class).setParameter("customerId", customerId).setParameter("accountNumber", acctNum); 
//
//	        List<Accounts> results = query.list();
//	        logger.toJson(results);
//			if (results.size() == 1) {
//				return results.get(0); 
//			} else {
//				return null;
//			}
//	    }catch(Exception e){
//	    	logger.error("getAccount(String customerId, String acctNum)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.flush();
//	        	session.close();
//	        }
//	    }
//		return null;
//
//	}
//
//	/**
//	 *  save Accounts
//	 *  saveConfirmEmailOption
//	 */
//	public void saveOrUpdate(Accounts accounts) {
//		logger.toJson("saveOrUpdate(Accounts accounts)",accounts);
//		if(accounts == null){
//			logger.debug(" saveOrUpdate(Accounts accounts) ::accounts is null ");
//			return;
//		}
//		logger.toJson(accounts);
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        session.saveOrUpdate(accounts);
//	        session.flush();
//	    }catch(Exception e){
//	    	logger.error("saveOrUpdate(Accounts accounts)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.flush();
//	        	session.close();
//	        }
//	    }
//	}

}
