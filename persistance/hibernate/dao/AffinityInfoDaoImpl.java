package com.td.mbna.msec.midtier.persistance.hibernate.dao;

//import java.util.Collection;
//
//import org.hibernate.Session;
//import org.springframework.stereotype.Repository;
//
//import com.td.mbna.msec.midtier.persistance.entity.AffinityInfo;
//import com.td.mbna.msec.midtier.util.ConfigUtil;
//import com.td.mbna.msec.midtier.util.MbnaLogger;

/**
 * This class implements the interface to the AFFINITYINFO table.
 *   
 */
//@Repository
public class AffinityInfoDaoImpl extends AbstractDaoImpl implements AffinityInfoDao {
	
//	private static MbnaLogger logger = new MbnaLogger(AffinityInfoDaoImpl.class);
//	
//	/**
//	 *  find all AffinityInfo by product codes
//	 */
//	@SuppressWarnings("unchecked")
//	@Override
//	public AffinityInfo findByProductCodes(String productCodes, String arqCode, String lang, String poCode) throws Exception {
//		final String DEFAULT = "DEFAULT";
//		final String DEFAULT_VISA = "VISA-DEFAULT";
//		final String VISA_CODE = ConfigUtil.getProperty("mbna.code.visa");
//		logger.info("Retrieving affinity info. Parameters: " + productCodes.trim() + " - "+ lang + "; arqCode: " + arqCode);
//		String arqInfo = "";
//		Collection<AffinityInfo> ais = null;
//		Session session = null;
//		try{
//			session = getSession();
//			if (arqCode != null && arqCode.trim().length() > 0) {
//				String fullProductCodes = productCodes.trim()+"-"+arqCode;
//				ais = session.createQuery("from AffinityInfo a where a.productCodes = :productCodes and a.language=:language and a.poCode=:poCode")
//					.setParameter("productCodes", fullProductCodes)
//					.setParameter("language", lang)
//					.setParameter("poCode", poCode)
//					.list();
//				arqInfo = " with ArqCode " + arqCode;
//			}
//			if (ais == null || ais.size() == 0) {
//				ais = session.createQuery("from AffinityInfo a where a.productCodes = :productCodes and a.language=:language and a.poCode=:poCode")
//						.setParameter("productCodes", productCodes)
//						.setParameter("language", lang)
//						.setParameter("poCode", poCode)
//						.list();
//			}
//			if (ais.size()==1) { 			
//				AffinityInfo ai = ais.iterator().next();
//	
//				//this should almost never happen, but if it does, log it 
//				if (ai.getLogoId()==null || ai.getLogoId().equals("")) {
//					logger.warning("SSMT004: missing logo Id for "+productCodes + arqInfo + ". Using default mbna logo");
//				}
//				
//				if (ai.getShortName()==null || ai.getShortName().equals("")) {
//					logger.warning("SSMT004: missing affinity name  for "+productCodes + arqInfo + ". Using default product name");
//				}
//				
//				return ai;
//			}else {
//				logger.debug("Getting default affinity info.");
//				
//				/*Default card for VISA is being added*/
//				String productType = productCodes.substring(0, 1);
//				String defaultCode="";
//				
//				if(productType.equalsIgnoreCase(VISA_CODE)){
//					defaultCode = DEFAULT_VISA;
//				}else{
//					defaultCode = DEFAULT;
//				}
//				ais = session.createQuery("from AffinityInfo a where a.productCodes = :productCodes and a.language=:language and a.poCode=:poCode")
//						.setParameter("productCodes", defaultCode)
//						.setParameter("language", lang)
//						.setParameter("poCode", poCode)
//						.list();
//				if (ais.size()==0) {
//					logger.warning("SSMT004: missing affinity name  for "+productCodes + arqInfo + ". Using default product name");
//				}else {
//					AffinityInfo ai = ais.iterator().next();
//					return ai;
//				}
//			}
//		}catch(Exception e){
//	    	logger.error("findByProductCodes(String productCodes, String arqCode, String lang, String poCode)::", e.getMessage(), e);
//		}finally {
//	        if (session != null){
//	        	session.close();
//	        }
//	    }
//		return null;
//	}

}
