package com.td.mbna.msec.midtier.persistance.hibernate.dao;

//import java.util.Collection;
//
//import org.hibernate.Session;
//import org.springframework.stereotype.Repository;
//
//import com.td.mbna.msec.midtier.persistance.entity.TransactionFee;
//import com.td.mbna.msec.midtier.util.MbnaLogger;

/**
 * This class implements the interface to the TRANSACTION_FEE table.
 *   
 */

//@Repository
public class TransactionFeeDaoImpl extends AbstractDaoImpl implements TransactionFeeDao {
	
//	private static MbnaLogger logger = new MbnaLogger(TransactionFeeDaoImpl.class);
//
//	/**
//	 *  find all AffinityInfo by product codes
//	 */
//	@SuppressWarnings("unchecked")
//	@Override
//	public TransactionFee getTransactionFee(String txnFeeNum, String subType){
//		logger.debug("getTransactionFee(String txnFeeNum, String subType)::txnFeeNum=" + txnFeeNum + ",subType=" + subType);
//		
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        Collection<TransactionFee> rs = session.createQuery("from TransactionFee a where transaction_fee_no = :feeNo and subtype = :subType")
//	        		.setParameter("feeNo", txnFeeNum)
//	        		.setParameter("subType", subType)
//	        		.list();
//	        logger.debug("getTransactionFee(String txnFeeNum, String subType)::result=" + rs.toString());
//	        if (rs.size() == 1) {
//	        	return rs.iterator().next();
//	        }
//	        else {
//	        	return null;
//	        }
//	    }catch(Exception e){
//	    	logger.error("getTransactionFee(String txnFeeNum, String subType)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//		return null;
//	}
//
//	

}
