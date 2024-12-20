package com.td.mbna.msec.midtier.persistance.hibernate.dao;

//import java.util.Date;
//import java.util.List;
//
//import org.hibernate.Session;
//import org.springframework.stereotype.Repository;
//
//import com.td.mbna.msec.midtier.persistance.entity.OfferPreference;
//import com.td.mbna.msec.midtier.types.common.OfferPreferenceType;
//import com.td.mbna.msec.midtier.util.ExceptionUtil;
//import com.td.mbna.msec.midtier.util.MbnaLogger;

/**
 * This class implements @{OfferPreferenceDao} and map to OfferPreference table
 */
//@Repository
public class OfferPreferenceDaoImpl extends AbstractDaoImpl implements OfferPreferenceDao {

//	private static final MbnaLogger logger = new MbnaLogger(OfferPreferenceDaoImpl.class);
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<OfferPreference> findByUCID(String ucid) {
//		logger.debug("findByUCID(String ucid)::ucid=" + ucid);
//		Session session = null;
//		try {
//			session = this.getSession();
//			List<OfferPreference> offerPrefs = getSession()
//					.createQuery("from OfferPreference pref where pref.ucid = :ucid")
//					.setParameter("ucid", ucid).list();
//			logger.debug("findByUCID(String ucid)::result="	+ offerPrefs.toString());
//			return offerPrefs;
//		} catch (Exception e) {
//			logger.error("findByUCID(String ucid)::", e.getMessage(), e);
////			throw ExceptionUtil.genRuntimeException(e);
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		return null;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public OfferPreference findByUCIDandOfferType(String ucid, String offerType) {
//		logger.debug("findByUCIDandOfferType(String ucid, String offerType)::ucid="	+ ucid + " offerType=" + offerType);
//
//		Session session = null;
//		try {
//			session = this.getSession();
//			List<OfferPreference> offerPrefs = session
//					.createQuery("from OfferPreference pref where pref.ucid = :ucid and pref.offerType = :offerType")
//					.setParameter("ucid", ucid)
//					.setParameter("offerType", offerType).list();
//			return offerPrefs.size() > 0 ? offerPrefs.get(0) : null;
//		} catch (Exception e) {
//			logger.error("findByUCIDandOfferType(String ucid, String interceptName)::error::",	e.getMessage(), e);
////			throw ExceptionUtil.genRuntimeException(e);
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public void save(OfferPreference pref) {
//		logger.debug("save(OfferPreference offerPreference)::offerPreference="	+ pref);
//		if("true".equalsIgnoreCase(pref.getEnabled())){
//			pref.setEnabledTS(new Date());
//		}
//		if("true".equalsIgnoreCase(pref.getDisabled())){
//			pref.setDisabledTS(new Date());
//		}
//		Session session = null;
//		try {
//			session = this.getSession();
//			session.save(pref);
//			session.flush();
//		} catch (Exception e) {
//			logger.error("save(OfferPreference offerPreference)::",	e.getMessage(), e);
//			throw ExceptionUtil.genRuntimeException(e);
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		
//	}
//
//	@Override
//	public void saveOrUpdate(OfferPreferenceType type) {
//		OfferPreference pref = findByUCIDandOfferType(type.getUcid(),type.getOfferType());
//		if(pref == null){
//			pref = new OfferPreference();
//		}
//		processPref(pref, type);
//		
//		Session session = null;
//		try {
//			session = this.getSession();
//			session.saveOrUpdate(pref);
//			session.flush();
//		} catch (Exception e) {
//			logger.error("saveOrUpdate(OfferPreference type)::",	e.getMessage(), e);
//			throw ExceptionUtil.genRuntimeException(e);
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		
//	}
//
//
//	@Override
//	public void update(OfferPreferenceType type) {
//		OfferPreference pref = findByUCIDandOfferType(type.getUcid(),type.getOfferType());
//		if(pref == null){
//			pref = new OfferPreference();
//		}
//		processPref(pref, type);
//		
//		Session session = null;
//		try {
//			session = this.getSession();
//			session.update(pref);
//			session.flush();
//		} catch (Exception e) {
//			logger.error("update(OfferPreferenceType type) ::",	e.getMessage(), e);
//			throw ExceptionUtil.genRuntimeException(e);
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		
//	}
//
//
//	private void processPref(OfferPreference pref, OfferPreferenceType type) {
//		pref.setUcid(type.getUcid());
//		pref.setOfferType(type.getOfferType());
//		pref.setCardRole(type.getCardRole());
//		pref.setConnectId(type.getConnectId());
//		if("true".equalsIgnoreCase(type.getEnabled())){
//			pref.setEnabled("E");
//			pref.setEnabledTS(new Date());
//		}
//		if("true".equalsIgnoreCase(type.getDisabled())){
//			pref.setDisabled("D");
//			pref.setDisabledTS(new Date());
//		}
//		
//	}

}
