package com.td.mbna.msec.midtier.persistance.hibernate.dao;

//import java.util.List;
//
//import org.hibernate.Session;
//import org.springframework.stereotype.Repository;
//
//import com.td.mbna.msec.midtier.persistance.entity.CustomerActionItem;
//import com.td.mbna.msec.midtier.util.MbnaLogger;

//@Repository
public class CustomerActionItemsDaoImpl extends AbstractDaoImpl implements CustomerActionItemsDao {

//	private static MbnaLogger logger = new MbnaLogger(CustomerActionItemsDaoImpl.class);
//	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<CustomerActionItem> findByUCID(String ucid) {
//		logger.debug("findByUCID(String ucid)::ucid="+ucid);
//		
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        List<CustomerActionItem> customerActionItems = session.createQuery("from CustomerActionItem cai where cai.customerID = :ucid")
//	        		.setParameter("ucid", ucid)
//	        		.list();
//	        logger.toJson(customerActionItems);
//	        return customerActionItems;
//	    }catch(Exception e){
//	    	logger.error("findByUCID(String ucid)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//		return null;
//	}
//
//	@Override
//	public void saveOrUpdate(CustomerActionItem customerActionItem) {
//		logger.toJson(customerActionItem);
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        session.saveOrUpdate(customerActionItem);
//	        session.flush();
//	    }catch(Exception e){
//	    	logger.error("saveOrUpdate(CustomerActionItem customerActionItem)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//	}

}
