package com.td.mbna.msec.midtier.persistance.hibernate.dao;

//import java.io.Serializable;
//import java.util.Collection;
//
//import org.hibernate.Session;
//import org.springframework.stereotype.Repository;
//
//import com.td.mbna.msec.midtier.persistance.entity.BusinessEventAudit;
//import com.td.mbna.msec.midtier.util.MbnaLogger;

/**
* This class implements the interface to the BUSINESSEVENTAUDIT table.
*   
*/
//@Repository
public class BusinessEventAuditDaoImpl extends AbstractDaoImpl implements BusinessEventAuditDao{
	
//	private static MbnaLogger logger = new MbnaLogger(BusinessEventAuditDaoImpl.class);
//	
//	/**
//	* Find all BusinessEventAudits.
//	*/	
//	@SuppressWarnings("unchecked")
//	public Collection<BusinessEventAudit> findBusinessEventAudits() {
//		Session session = null;
//		try {
//			session = this.getSession();
//			return session.createQuery("from BusinessEventAudit").list();
//		}catch(Exception e){
//	    	logger.error("findBusinessEventAudits()::", e.getMessage(), e);
//		} finally {
//			if (session != null){
//				session.close();
//			}
//		}
//		return null;
//	}
//	
//	/**
//	* Find BusinessEventAudits by last name.
//	*/
//	@SuppressWarnings("unchecked")
//	public Collection<BusinessEventAudit> findBusinessEventAuditsByAuditId(Integer auditID) {
//		logger.debug("findBusinessEventAuditsByAuditId(Integer auditID)::auditID="+auditID);
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        return session.createQuery("from BusinessEventAudit b where b.auditID = :auditId")
//	        		.setParameter("auditId", auditID)
//	        		.list();
//	    }catch(Exception e){
//	    	logger.error("findBusinessEventAuditsByAuditId(Integer auditID)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//		return null;
//	}
//	
//	/**
//	* Find BusinessEventAudits by MDM ID.
//	*/
//	@SuppressWarnings("unchecked")
//	public Collection<BusinessEventAudit> findBusinessEventByOperatingSystem(String os) {
//		logger.debug("findBusinessEventByOperatingSystem(String os)::os="+os);
//		
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        return session.createQuery("from BusinessEventAudit b where b.operatingSystem = :os")
//	        		.setParameter("os", os)
//	        		.list();
//	    }catch(Exception e){
//	    	logger.error("findBusinessEventByOperatingSystem(String os)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//		return null;
//	}
//	
//	/**
//	* Saves BusinessEventAudit.
//	*/
//	public void save(BusinessEventAudit businessEventAudit) {
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        Serializable s = session.save(businessEventAudit);
//	        logger.debug("save(BusinessEventAudit businessEventAudit)::result="+s.toString());
//	        session.flush();
//	    }catch(Exception e){
//	    	logger.error("save(BusinessEventAudit businessEventAudit)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//	}
//	
//	/**
//	* Deletes BusinessEventAudit.
//	*/
//	public void delete(BusinessEventAudit businessEventAudit) {
//		
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        session.delete(businessEventAudit);
//	        session.flush();
//	    }catch(Exception e){
//	    	logger.error("delete(BusinessEventAudit businessEventAudit)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//	}
	

}
