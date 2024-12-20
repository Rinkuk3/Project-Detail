package com.td.mbna.msec.midtier.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.util.JAXBResult;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.stream.StreamSource;


import com.td.mbna.msec.midtier.tdwsservices.TdCustAgreementService;
import com.td.mbna.msec.midtier.tdwsservices.TdDisclosureCfgService;
import com.td.mbna.msec.midtier.tdwsservices.TdOdsCustomerProfileService;
//import com.td.schemas.tdct.srm.card.service.v1.TActivateCardRq;
//import com.td.schemas.tdct.srm.card.service.v1.TIssueCardRq;
//import com.td.schemas.tdct.srm.card.service.v1.TRetrieveCardAccountInfoRq;
//import com.td.schemas.tdct.srm.card.service.v1.TRetrievePINRq;
//import com.td.schemas.tdct.srm.card.service.v1.TUnblockPINRq;
//import com.td.schemas.tdct.srm.card.service.v1.TUpdateCardAccountInfoRq;
//import com.td.schemas.tdct.srm.card.service.v1.TUpdatePINRq;
import com.td.schemas.tdct.srm.customerprofile.service.v1.TEnvRetrieveCustomerProfileRq;
import com.td.schemas.tdct.srm.customerprofile.service.v1.TEnvUpdateCustomerProfileRq;
import com.td.wsc.cstagt._2010._07._14.CaptureAgreementRequestType;
import com.td.wsc.cstagt._2010._07._14.SearchAgreementRequestType;
import com.td.wsc.dscfg._2010._07._05.AssembleDisclosureRequestType;

/**
 * This call provides utility tools to integrate with TD's back end.
 */
public class BackEndSrvcUtil {
	private final static boolean IS_DEV_MODE = ConfigUtil.inDevMode();
	private final static String MT_EXCEPTION_OPERATION = ConfigUtil.getProperty("debug.MT.exception.operation", "");


	public enum TDOperation {

		TdCardService_retrieveCardAccountInfo,
		TdCardService_updateCardAccountInfo,
		TdCreditCardAcctService_updateCreditCardAccount,
		TdDisclosureCfgService_assembleDisclosure,
		TdOffersService_getOffers,
		TdOffersService_getAppliedSubProducts,
		TdDocuManagementService_search,
		TdDocuManagementService_retrieve,
		TdCustAgreementService_search,
		TdCustAgreementService_capture,
		TdOfferFulfillmentService_requestRetailRegistration,
		TdOfferFulfillmentService_requestCashAdvanceRegistration,
		TdKeyManagementService_encrypt,
		TdKeyManagementService_decrypt,
		TdOdsCustomerProfileService_retrieveCustomerProfile,
		TdOdsCustomerProfileService_updateCustomerProfile		
	};
	
	private static MbnaLogger logger = new MbnaLogger(BackEndSrvcUtil.class);
	
	/**
	 *  invoke TD service
	 * 
	 */
	public static Object invokeService(String tdOpRq, String tdOpRs, String loginId, String RqAcctNum, String RsAcctNum,
			   Map<String, Object> rqParmValues,
			   Map<String, Object> rsParmValues, 
			   TDOperation srvcOper,
			   JAXBContext mtJaxBContext) throws Exception 
	{
		if (IS_DEV_MODE && srvcOper.name().equalsIgnoreCase(MT_EXCEPTION_OPERATION)) {
			throw new RuntimeException("throwing exception to test " + MT_EXCEPTION_OPERATION);
		}
		return invokeService(tdOpRq, tdOpRq, tdOpRs, tdOpRs, loginId, RqAcctNum, RsAcctNum,rqParmValues,rsParmValues, srvcOper,mtJaxBContext);
    }

	/**
	 *  invoke TD service
	 * 
	 */
	public static Object invokeService(String tdOpRq, String tdOpRqtranslate, String tdOpRs, String tdOpRstranslate, String loginId, String RqAcctNum, String RsAcctNum,
			   Map<String, Object> rqParmValues,
			   Map<String, Object> rsParmValues, 
			   TDOperation srvcOper,
			   JAXBContext mtJaxBContext) throws Exception 
	{
		return invokeService(tdOpRq, tdOpRqtranslate, tdOpRs, tdOpRstranslate, loginId, RqAcctNum, RsAcctNum,rqParmValues,rsParmValues, srvcOper,mtJaxBContext, null, null);		
	}

	
	/**
	 *  invoke TD service
	 * 
	 */
	public static Object invokeService(String tdOpRq, String tdOpRqtranslate, String tdOpRs, String tdOpRstranslate, String loginId, String RqAcctNum, String RsAcctNum,
									   Map<String, Object> rqParmValues,
									   Map<String, Object> rsParmValues, 
									   TDOperation srvcOper,
									   JAXBContext mtJaxBContext,
									   Source tdOpRqSrc,
									   Map<String, Object> params) throws Exception 
	{
		String methodName = "invokeService()";
		Object generatedReq = genRequest2(tdOpRq, tdOpRqtranslate, rqParmValues,tdOpRqSrc,srvcOper);
		
		// invoke backend service
		Source xmlSource = null;
		byte[] res = invoke(srvcOper, generatedReq, params);
		if(tdOpRq!=null && tdOpRq.equalsIgnoreCase("searchCustAgreement")){
			return ConsentDetail.getDetailsOfDisclosureDocuments(new String(res));
		}

		if (res != null) {
			try {
				xmlSource = new StreamSource(new ByteArrayInputStream(res));

				if (tdOpRstranslate == null) return xmlSource;
				if (mtJaxBContext == null) return null;

			} catch (Exception e) {
				logger.error(methodName, e.getMessage(), e);
			}
		} else {
			logger.error(methodName, "res is null:" + params);
		}
		
		return buildResponse(tdOpRstranslate, rsParmValues, mtJaxBContext, xmlSource);
	}


	/**
	 *  invoke TD service. Use this method if you don't want to XSLT transform the WS response.
	 * 
	 */
	public static <Response> Response invokeService(String tdOpRq, String tdOpRqtranslate, 
													String tdOpRs, String loginId, String RqAcctNum, String RsAcctNum,
													Map<String, Object> rqParmValues,
													TDOperation srvcOper,
													Source tdOpRqSrc,
													Map<String, Object> params,
													Class<Response> responseClass) throws Exception 
	{

		Object generatedReq = null; 
		generatedReq = genRequest2(tdOpRq, tdOpRqtranslate, rqParmValues,tdOpRqSrc,srvcOper);	
		
		// invoke backend service
		return invoke(srvcOper, generatedReq, params, responseClass);
	}


	/**
	 * generate request
	 * @param tdOp
	 * @param tdOptranslate
	 * @param rqParmValues
	 * @param tdOpSrc
	 * @param srvcOper
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static Object genRequest2(String tdOp, String tdOptranslate, Map<String, Object> rqParmValues, Source tdOpSrc, TDOperation srvcOper) throws Exception 
	{

 		String methodName = "genRequest2()";
		Source inSrc = tdOpSrc;
		InputStream tdReqStubXml = null;
		try {
			if (tdOp != null) {
				tdReqStubXml = TransformUtil.getTdRqStubXml(tdOp);
				inSrc = new StreamSource(tdReqStubXml);
			}
			Templates mt2tdReqTranformer = TransformUtil.getRqTemplate(tdOptranslate);
			if (getTDserviceReqMsgClass(srvcOper) == null) {
				String generatedReq  = TransformUtil.transformRequest(mt2tdReqTranformer, inSrc, rqParmValues);
				return generatedReq;
			}
	        JAXBResult result0 = new JAXBResult(JaxbUtil.getJaxbContext(getTDserviceReqMsgClass(srvcOper)));
	        TransformUtil.transformRequest(mt2tdReqTranformer, inSrc, rqParmValues, result0);
	        JAXBElement req = (JAXBElement) result0.getResult();
	        Object req1 = req.getValue();
			return req1;
		} catch (Exception e) {
			logger.error(methodName,e.getMessage(),e);
			return null;
		}
		finally {
			if (tdReqStubXml != null) IoUtil.closeIgnoreException(tdReqStubXml);
		}
	}

	public static Object buildResponse(String tdOpRstranslate,
								Map<String, Object> rsParmValues, 
								JAXBContext mtJaxBContext,
								Source xmlSource) throws Exception {

		final JAXBResult result = new JAXBResult(mtJaxBContext);
		final Templates template = TransformUtil.getRsTemplate(tdOpRstranslate);
		
		TransformUtil.transformRequest(template, xmlSource, rsParmValues, result);

		return result.getResult();
	}

	@SuppressWarnings("unchecked")
	private static <Response> Response invoke(TDOperation tdOper, Object inReqObject, Map<String,Object> params, Class<Response> responseClass)
			throws Exception {

		Response resp = null;

		switch (tdOper) {
		case TdOdsCustomerProfileService_retrieveCustomerProfile:
			resp = (Response) TdOdsCustomerProfileService.retrieveCustomerProfile((TEnvRetrieveCustomerProfileRq) inReqObject);
			break;		
		case TdOdsCustomerProfileService_updateCustomerProfile:
			resp = (Response) TdOdsCustomerProfileService.updateCustomer((TEnvUpdateCustomerProfileRq) inReqObject);
			break;
		default:
			break;		
		}
		
		return resp;
	}
	
	public static byte[] invoke(TDOperation tdOper, Object inReqObject, Map<String,Object> params)
			throws Exception {

		byte[] resp = null;
		
		switch (tdOper) {
//		case TdCardService_issueCard:
//			resp = TdCardService.issueCard((TIssueCardRq) inReqObject);
//			break;
//		case TdCardService_activateCard:
//			resp = TdCardService.activateCard((TActivateCardRq) inReqObject);
//			break;
//		case TdCardService_retrieveCardAccountInfo:
//			resp = TdCardService.retrieveCardAccountInfo((TRetrieveCardAccountInfoRq) inReqObject);
//			break;
//		case TdCardService_updateCardAccountInfo:
//			resp = TdCardService.updateCardAccountInfo( (TUpdateCardAccountInfoRq) inReqObject);
//			break;
		case TdDisclosureCfgService_assembleDisclosure:
			resp = TdDisclosureCfgService.assembleDisclosure((AssembleDisclosureRequestType) inReqObject);
			break;
		/*case TdCardService_updatePIN:
			resp = TdCardService.updatePIN((TUpdatePINRq) inReqObject);
			break;
		case TdCardService_retrievePIN:
			resp = TdCardService.retrievePIN((TRetrievePINRq) inReqObject);
			break;
		case TdCardService_unblockPIN:
			resp = TdCardService.unblockPIN((TUnblockPINRq) inReqObject);
			break;*/
		case TdCustAgreementService_search:
			resp = TdCustAgreementService.searchAgreement((SearchAgreementRequestType) inReqObject);
			break;
		case TdCustAgreementService_capture:
			resp = TdCustAgreementService.captureAgreement((CaptureAgreementRequestType) inReqObject);
			break;
		case TdOdsCustomerProfileService_updateCustomerProfile:
			// when system loaded and kyc update
			resp = TdOdsCustomerProfileService.updateCustomer2((TEnvUpdateCustomerProfileRq) inReqObject);
			break;
		default:
			break;		
		}
		logger.debug(tdOper.toString(), resp.toString());
		return resp;
	}


	/**
	 *  get TD service request message class
	 * 
	 */
	public static Class<?> getTDserviceReqMsgClass(TDOperation tdOper) {
		Class<?> classObj = null;
		switch (tdOper) {
		/*case TdCardService_retrieveCardAccountInfo:
			classObj = TRetrieveCardAccountInfoRq.class;
			break;*/
		/*case TdCardService_updateCardAccountInfo:
			classObj = TUpdateCardAccountInfoRq.class;
			break;*/
		/*case TdCardService_activateCard:
			classObj = TActivateCardRq.class;
			break;
		case TdCardService_issueCard:
			classObj = TIssueCardRq.class;
			break;
		case TdCardService_retrievePIN:
			classObj = TRetrievePINRq.class;
			break;
		case TdCardService_unblockPIN:
			classObj = TUnblockPINRq.class;
			break;
		case TdCardService_updatePIN:
			classObj = TUpdatePINRq.class;
			break;*/
		case TdCustAgreementService_search:
			classObj = SearchAgreementRequestType.class;
			break;
		case TdCustAgreementService_capture:
			classObj = CaptureAgreementRequestType.class;
			break;
		case TdDisclosureCfgService_assembleDisclosure:
			classObj = AssembleDisclosureRequestType.class;
			break;
		case TdOdsCustomerProfileService_retrieveCustomerProfile:
			classObj = TEnvRetrieveCustomerProfileRq.class;
			break;
		case TdOdsCustomerProfileService_updateCustomerProfile:
			classObj = TEnvUpdateCustomerProfileRq.class;
			break;
		default:
			classObj = null;
			break;
		}
		logger.debug(tdOper.toString(), classObj.getName());
		return classObj;
	}
}
