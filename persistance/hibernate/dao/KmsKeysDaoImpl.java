package com.td.mbna.msec.midtier.persistance.hibernate.dao;

//import java.util.Collection;
//import java.util.Date;
//
//import org.hibernate.Session;
//import org.springframework.stereotype.Repository;
//
//import com.td.mbna.msec.midtier.persistance.entity.KmsKeys;
//import com.td.mbna.msec.midtier.util.MbnaLogger;
//
//@Repository
public class KmsKeysDaoImpl extends AbstractDaoImpl implements KmsKeysDao {

//	private static final MbnaLogger logger = new MbnaLogger(KmsKeysDaoImpl.class);
//	
//	@Override
//	@SuppressWarnings("unchecked")
//	public KmsKeys getWtkByDate(Date date) throws Exception {
//		
//		logger.debug("getWtkByDate(Date date)::date="+date);
//		Collection<KmsKeys> keys = null;
//		
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        keys = session.createQuery("from KmsKeys a where a.effectiveDate <= :effdate and a.lookupKey='WTK' order by effectiveDate desc")
//	        .setParameter("effdate", date)
//	        .list();
//	        
//	        logger.debug("getWtkByDate(Date date)::result="+keys);
//	        if (keys == null || keys.size()==0) {
//	        	throw new Exception("WTK aliases not found");
//	        }
//	        
//	        if (keys.size()>=1) {
//	        	return keys.iterator().next();
//	        }
//	    }catch(Exception e){
//	    	logger.error("getWtkByDate(Date date)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//		return null;
//	}
//
//	@Override
//	@SuppressWarnings("unchecked")
//	public KmsKeys getZpkImporterByDate(Date date) throws Exception {
//		logger.debug("getZpkImporterByDate(Date date)::date="+date);
//		Collection<KmsKeys> keys = null;
//		
////		keys = template.find("from KmsKeys a where a.effectiveDate <= ? and a.lookupKey like 'ZPKIMPORTER' order by effectiveDate desc", date);
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        keys = session.createQuery("from KmsKeys a where a.effectiveDate <= :effdate and a.lookupKey like 'ZPKIMPORTER' order by effectiveDate desc")
//	        		.setParameter("effdate", date)
//	        		.list();
//	        logger.debug("getZpkImporterByDate(Date date)::result="+keys.toString());
//	        
//	        if (keys == null || keys.size()==0) {
//	        	throw new Exception("ZPK aliases not found");
//	        }
//	        
//	        if (keys.size()>=1) {
//	        	return keys.iterator().next();
//	        }
//	    }catch(Exception e){
//	    	logger.error("getZpkImporterByDate(Date date)::", e.getMessage(), e);
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//		return null;
//
//	}
//	
//	@Override
//	@SuppressWarnings("unchecked")
//	public KmsKeys getZpkExporterByDate(Date date) throws Exception {
//		logger.debug("getZpkExporterByDate(Date date)::date="+date);
//		Collection<KmsKeys> keys = null;
//		
//		Session session = null;
//	    try {
//	        session = this.getSession();
//	        keys = session.createQuery("from KmsKeys a where a.effectiveDate <= :effdate and a.lookupKey like 'ZPKEXPORTER' order by effectiveDate desc")
//	        		.setParameter("effdate", date)
//	        		.list();
//	        logger.debug("getZpkExporterByDate(Date date)::result="+keys.toString());
//	        
//	        if (keys == null || keys.size()==0) {
//	        	throw new Exception("ZPK aliases not found");
//	        }
//	        
//	        if (keys.size()>=1) {
//	        	return keys.iterator().next();
//	        }
//	    }catch(Exception e){
//	    	logger.error("getZpkExporterByDate(Date date)::", e.getMessage(), e);	        
//	    } finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//	    return null;
//
//	}
//	


}
