package com.td.mbna.msec.midtier.persistance.hibernate.dao;

//import java.util.Date;
//import java.util.List;
//
//import org.hibernate.Session;
//
//import com.td.mbna.msec.midtier.persistance.entity.InterceptorDisposition;
//import com.td.mbna.msec.midtier.types.common.InterceptorDispositionType;
//import com.td.mbna.msec.midtier.util.ExceptionUtil;
//import com.td.mbna.msec.midtier.util.MbnaLogger;

public class InterceptorDispositionDaoImpl extends AbstractDaoImpl implements InterceptorDispositionDao{

//	private static final MbnaLogger logger = new MbnaLogger(InterceptorDispositionDaoImpl.class);
//			
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<InterceptorDisposition> findByUCID(String ucid) {
//		logger.debug("findByUCID(String ucid)::ucid=" + ucid);
//		Session session = null;
//		try {
//			session = this.getSession();
//			String qStr = "from InterceptorDisposition interc where interc.ucid = :ucid";
//			List<InterceptorDisposition> intercs = getSession().createQuery(qStr).setParameter("ucid", ucid).list();
//			return intercs;
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
//	@Override
//	public void saveOrUpdate(InterceptorDispositionType type) {
//		InterceptorDisposition interceptor = findByPrimayKeys(type.getUcid(),type.getInterceptorId(),type.getTsysAccountId(), type.getDispositionStatus());
//		if(interceptor == null){
//			interceptor = new InterceptorDisposition();
//		}
//		processInterceptor(interceptor,type);
//		
//		Session session = null;
//		try {
//			session = this.getSession();
//			session.saveOrUpdate(interceptor);
//			session.flush();
//		} catch (Exception e) {
//			logger.error("saveOrUpdate(InterceptorDisposition interceptor)::",	e.getMessage(), e);
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
//	public void update(InterceptorDispositionType type) {
//		InterceptorDisposition interceptor = findByPrimayKeys(type.getUcid(),type.getInterceptorId(),type.getTsysAccountId(), type.getDispositionStatus());
//		if(interceptor == null){
//			interceptor = new InterceptorDisposition();
//		}
//		processInterceptor(interceptor,type);
//		
//		Session session = null;
//		try {
//			session = this.getSession();
//			session.update(interceptor);
//			session.flush();
//		} catch (Exception e) {
//			logger.error("update(InterceptorDisposition interceptor) ::error::",	e.getMessage(), e);
//			throw ExceptionUtil.genRuntimeException(e);
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		
//	}
//	
//	@SuppressWarnings("unchecked")
//	private InterceptorDisposition findByPrimayKeys(String ucid, String interceptorId, String accountId, String dispositionStatus) {
//		logger.debug("findByPrimayKeys(String ucid, String interceptorId)::ucid="	+ ucid + " interceptorId=" + interceptorId+ " accountId=" + accountId+ " dispositionStatus=" + dispositionStatus);
//		
//		Session session = null;
//		try {
//			String sql = "from InterceptorDisposition where ucid = :ucid and interceptorId = :interceptorId and tsysAccountId = :accountId and dispositionStatus = :dispositionStatus";
//			session = this.getSession();
//			List<InterceptorDisposition> intercs = session
//					.createQuery(sql)
//					.setParameter("ucid", ucid)
//					.setParameter("interceptorId", interceptorId)
//					.setParameter("accountId", accountId)
//					.setParameter("dispositionStatus", dispositionStatus)
//					.list();
//			return intercs.size() > 0 ? intercs.get(0) : null;
//		} catch (Exception e) {
//			logger.error("findByPrimayKeys(String ucid, String interceptorId)::",	e.getMessage(), e);
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		return null;
//	}
//	
//	private void processInterceptor(InterceptorDisposition interceptor,	InterceptorDispositionType type) {
//		interceptor.setUcid(type.getUcid());
//		interceptor.setInterceptorId(type.getInterceptorId());
//		interceptor.setInterceptorType(type.getInterceptorType());
//		interceptor.setCardRole(type.getCardRole());
//		interceptor.setConnectId(type.getConnectId());
//		interceptor.setDispositionStatus(type.getDispositionStatus());
//		interceptor.setOfferId(type.getOfferId());
//		interceptor.setTimestamp(new Date());
//		interceptor.setTsysAccountId(type.getTsysAccountId());
//		
//	}

}
