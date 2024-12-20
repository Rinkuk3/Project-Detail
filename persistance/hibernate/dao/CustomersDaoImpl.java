package com.td.mbna.msec.midtier.persistance.hibernate.dao;

//import java.util.Date;
//import java.util.List;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.springframework.stereotype.Repository;
//
//import com.td.mbna.msec.midtier.persistance.entity.Customers;
//import com.td.mbna.msec.midtier.util.MbnaLogger;

/**
* This class implements the interface to the CUSTOMRES table.
*   
*/
//@Repository
public class CustomersDaoImpl extends AbstractDaoImpl implements CustomersDao{
	
//	private static final MbnaLogger logger = new MbnaLogger(CustomersDaoImpl.class);
//	
//	/**
//	* Find all Customers.
//	*/	
//	@SuppressWarnings("unchecked")
//	public List<Customers> findCustomers() {
//		
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        return session.createQuery("from Customers").list();
//	    }catch(Exception e){
//	    	logger.error("findCustomers()::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//		return null;
//	}
//	
//	/**
//	* Find Customers by last name.
//	*/
//	@SuppressWarnings("unchecked")
//	public List<Customers> findCustomersByCustomerId(String customerId) {
//		logger.debug("findCustomersByCustomerId(String customerId)::customerId="+customerId);
//		String hql = "from Customers where customerId=:customerId";
//		
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        Query query = session.createQuery(hql).setParameter("customerId", customerId);
//	        return query.list();
//	    }catch(Exception e){
//	    	logger.error("findCustomersByCustomerId(String customerId)::", e.getMessage(), e);
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
//	 * Updates EAA Published DT column.
//	 */
//	public void updateEAA(Customers customers) {
//		
//		// This is needed because if it's the user's first login attempt, they will not exist in the Customers table.
//		// If they do exist, we need their LastLogin.  It gets overwritten with NULL otherwise.
//		
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        List<Customers> cuss= findCustomersByCustomerId(customers.getCustomerId());
//	        Customers cus = null;
//	        if(cuss != null && cuss.size() > 0 ){
//	        	cus = cuss.get(0);
//	        }
//	        Date lastLogin = null;
//	        Date firstLogin = null;
//	        
//	        //Customer's first login, if the customers record is not available
//	        //Set first login date 
//	        if (cus== null /*|| cus.isEmpty()*/) {
//	        	customers.setFirstLogin(new Date());
//	        	customers.setLastLogin(customers.getFirstLogin());
//	        } else {
//	        	lastLogin = cus.getLastLogin();
//	        	firstLogin = cus.getFirstLogin();
//	        	
//	        	if (lastLogin != null) {
//	        		customers.setLastLogin(lastLogin);
//	        	} else {
//	        		customers.setLastLogin(firstLogin);
//	        	}
//	        	
//	        	if (firstLogin != null) {
//	        		customers.setFirstLogin(firstLogin);
//	        	} else{
//	        		logger.warning("first Login is somehow null, set it to last login:" + lastLogin + " for customer " + customers.getCustomerId());
//	        		customers.setFirstLogin(lastLogin);
//	        	}
//	        }
//        	session.merge(customers);
//	        session.flush();
//	    }catch(Exception e){
//	    	logger.error("updateEAA(Customers customers)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//	}
//	
//	/**
//	 * Updates Last Login column
//	 */
//	public void updateLastLogin(Customers customers) {
//		// This is needed because if it's the user's first login attempt, they will not exist in the Customers table.
//		// If they do exist, we need their EAAPublishedDateAccepted.  It gets overwritten with NULL otherwise.
//		
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        List<Customers> cuss= findCustomersByCustomerId(customers.getCustomerId());
//	        Customers cus = null;
//	        if(cuss != null && cuss.size() > 0 ){
//	        	cus = cuss.get(0);
//	        }
//	        Date eAAPublishedDateAccepted = null;
//	        Date firstLogin = null;
//	        
//	        //Customer's first login, if the customers record is not available
//	        //Set first login date 
//	        if(cus == null /*|| cus.isEmpty()*/) {
//	        	customers.setFirstLogin(new Date());
//	        	customers.setLastLogin(customers.getFirstLogin());
//	        } else {
//	        	eAAPublishedDateAccepted = cus.getEAAPublishedDateAccepted();
//	        	firstLogin = cus.getFirstLogin();
//	        	
//	        	if (eAAPublishedDateAccepted != null) {
//	        		customers.setEAAPublishedDateAccepted(eAAPublishedDateAccepted);
//	        	} else {
//	        		logger.warning("eAAPublishedDateAccepted is null: " + customers.getCustomerId());
//	        	}
//	        	
//	        	if (firstLogin != null) {
//	        		customers.setFirstLogin(firstLogin);
//	        	}else{
//	        		logger.warning("first Login is somehow null, set it to last login for customer " + customers.getCustomerId() + " ," + customers.getLastLogin());
//	        		customers.setFirstLogin(customers.getLastLogin());
//	        	}
//	        }
//	        
//        	session.merge(customers);
//
//	        session.flush();
//	    }catch(Exception e){
//	    	logger.error("updateLastLogin(Customers customers)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//	}
//
//	
//
//	
//	

}
