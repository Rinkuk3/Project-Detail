package com.td.mbna.msec.midtier.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mbnaweb.xsd.types.common.SystemException;
import com.td.mbna.msec.midtier.autopay.payload.addpad.AddPadRequest;
import com.td.mbna.msec.midtier.creditcard.payload.increasecardlimit.IncreaseCardLimitRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.addauthorizeduser.AddAuthorizedUserRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.customeragreement.CaptureAgreementRequest;
import com.td.mbna.msec.midtier.disclosure.payload.consentdisclosure.ConsentDisclosureRequest;
import com.td.mbna.msec.midtier.exception.BusinessError;
import com.td.mbna.msec.midtier.exception.SystemError;
import com.td.mbna.msec.midtier.offers.payload.requestInstallmentPlan.RequestInstallmentPlanRequest;
import com.td.mbna.msec.midtier.offers.payload.requestcashadvanceregistration.RequestCashAdvanceRegistrationRequest;
import com.td.mbna.msec.midtier.offers.payload.requestinsurance.RequestInsuranceRequest;
import com.td.mbna.msec.midtier.offers.payload.requestminpaymentdeferral.RequestMinPaymentDeferralRequest;
import com.td.mbna.msec.midtier.offers.payload.requestproductchange.RequestProductChangeRequest;
import com.td.mbna.msec.midtier.offers.payload.requestretailregistration.RequestRetailRegistrationRequest;
import com.td.mbna.msec.midtier.offers.payload.updatebalanceprotectioninsurance.UpdateBalanceProtectionInsuranceRequest;
import com.td.mbna.msec.midtier.statement.payload.updateStatementDeliveryPreferences.UpdateStatementDeliveryPreferencesRequest;
import com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil;
import com.td.mbna.msec.midtier.transfer.payload.balancetransfertocreditor.BalanceTransferToCreditorRequest;
import com.td.mbna.msec.midtier.transfer.payload.deposittochequing.DepositToChequingRequest;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.DisclosureInfoType;
import com.td.mbna.msec.midtier.types.common.TrackableRequest;
import com.td.mbna.msec.midtier.util.BackEndSrvcUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;

/**
 * This class contains the implementation for capturing the user's agreement by calling captureAgreement.
 *
 */
public class DisclosureService {
	private static final MbnaLogger logger = new MbnaLogger(DisclosureService.class);

	// request payload
	public static final String REQUEST_PAYLOAD = "requestPayload";
	// disclosure info
	public static final String DISCLOSUR_INFO_FLDNAME = "disclosureInfo";

	private final static String CAPTURE_AGREEMENT = "captureAgreement";
	// create date format
	public static final String CREATE_DATE_FMT = "yyyy-MM-dd'T'HH:mm:ssZ";
	// published date format
	public static final String PUBLISH_DATE_FMT = "yyyy-MM-dd";


	/**
	 * consent disclosure
	 * @param req
	 * @throws BusinessError
	 * @throws SystemError
	 */
	static public void consentDisclosure(TrackableRequest req) throws BusinessError, SystemError {

		// If the consent can not be capture, throws exception and stop the process.

		try {
			String arrangementId = null;
			String connectId = null;

			List<DisclosureInfoType> disclosureInfoList = new ArrayList<DisclosureInfoType>();

			if (req instanceof ConsentDisclosureRequest) {
				//This is for EAA
				ConsentDisclosureRequest request = ((ConsentDisclosureRequest) req);
				connectId = request.getRequestPayload().getConnectId();
				//For customer level consent, arrangement id equals the connect id
				arrangementId = connectId;

				disclosureInfoList = request.getRequestPayload().getDisclosureInfo();
			} else if (req instanceof BalanceTransferToCreditorRequest) {
				BalanceTransferToCreditorRequest request = ((BalanceTransferToCreditorRequest) req);
				if (request.getRequestPayload().getConfirmed() == null || !request.getRequestPayload().getConfirmed()) {
					logger.warning("BalanceTransferToCreditorRequest payload confirmed is false");
					return;
				}
				
				if (null == request.getRequestPayload().getDisclosureInfo()){
					logger.warning("BalanceTransferToCreditorRequest payload dislosureInfo is null");
					return;
				}
				
				arrangementId = request.getAcctNum();
				disclosureInfoList.add(request.getRequestPayload().getDisclosureInfo());

			} else if (req instanceof AddAuthorizedUserRequest) {
				AddAuthorizedUserRequest request = (AddAuthorizedUserRequest) req;
				if (null == request.getRequestPayload().getDisclosureInfo()) {
					logger.warning("AddAuthorizedUserRequest payload dislosureInfo is null");
					return;
				}
				arrangementId = request.getAcctNum();
				disclosureInfoList.add(request.getRequestPayload().getDisclosureInfo());
			} else if (req instanceof DepositToChequingRequest) {
				DepositToChequingRequest request = (DepositToChequingRequest) req;
				if (request.getRequestPayload().getConfirmed() == null || !request.getRequestPayload().getConfirmed()) {
					logger.warning("DepositToChequingRequest payload confirmed is false");
					return;
				}
				if (null == request.getRequestPayload().getDisclosureInfo()) {
					logger.warning("DepositToChequingRequest payload dislosureInfo is null");
					return;
				}
				arrangementId = request.getAcctNum();
				disclosureInfoList.add(request.getRequestPayload().getDisclosureInfo());

			} else if (req instanceof IncreaseCardLimitRequest) {
				IncreaseCardLimitRequest request = (IncreaseCardLimitRequest) req;
				arrangementId = request.getAcctNum();
				disclosureInfoList.add(request.getRequestPayload().getDisclosureInfo());
			} else if (req instanceof UpdateStatementDeliveryPreferencesRequest) {
				UpdateStatementDeliveryPreferencesRequest request = (UpdateStatementDeliveryPreferencesRequest) req;
				if (null == request.getRequestPayload().getDisclosureInfo() || request.getRequestPayload().getDisclosureInfo().size() == 0) {
					logger.warning("UpdateStatementDeliveryPreferencesRequest payload dislosureInfo is empty");
					return;
				}
				arrangementId = request.getAcctNum();

				disclosureInfoList = request.getRequestPayload().getDisclosureInfo();
			} else if (req instanceof RequestInsuranceRequest) {
				RequestInsuranceRequest request = (RequestInsuranceRequest) req;
				if (null == request.getRequestPayload().getDisclosureInfo()) {
					logger.warning("RequestInsuranceRequest payload dislosureInfo is null");
					return;
				}
				arrangementId = request.getAcctNum();

				disclosureInfoList.add(request.getRequestPayload().getDisclosureInfo());
			} else if (req instanceof RequestProductChangeRequest) {
				RequestProductChangeRequest request = (RequestProductChangeRequest) req;
				if (null == request.getRequestPayload().getDisclosureInfo() || request.getRequestPayload().getDisclosureInfo().size() == 0) {
					logger.warning("RequestProductChangeRequest payload dislosureInfo is empty");
					return;
				}
				arrangementId = request.getAcctNum();
				
				disclosureInfoList = request.getRequestPayload().getDisclosureInfo();
			} else if (req instanceof RequestCashAdvanceRegistrationRequest) {
				RequestCashAdvanceRegistrationRequest request = (RequestCashAdvanceRegistrationRequest) req;
				if (null == request.getRequestPayload().getDisclosureInfo()) {
					logger.warning("RequestCashAdvanceRegistrationRequest payload dislosureInfo is null");
					return;
				}
				arrangementId = request.getAcctNum();

				disclosureInfoList = request.getRequestPayload().getDisclosureInfo();
			} else if (req instanceof RequestRetailRegistrationRequest) {
				RequestRetailRegistrationRequest request = (RequestRetailRegistrationRequest) req;
				if (null == request.getRequestPayload().getDisclosureInfo() || request.getRequestPayload().getDisclosureInfo().size() == 0) {
					logger.warning("RequestRetailRegistrationRequest payload dislosureInfo is empty");
					return;
				}
				arrangementId = request.getAcctNum();

				disclosureInfoList = request.getRequestPayload().getDisclosureInfo();
			} else if (req instanceof UpdateBalanceProtectionInsuranceRequest){
				UpdateBalanceProtectionInsuranceRequest request = (UpdateBalanceProtectionInsuranceRequest) req;
				if(null == request.getRequestPayload().getDisclosureInfo() || request.getRequestPayload().getDisclosureInfo().size() == 0) {
					logger.warning("UpdateBalanceProtectionInsuranceRequest payload dislosureInfo is empty");
					return;
				}
				arrangementId = request.getAcctNum();

				disclosureInfoList = request.getRequestPayload().getDisclosureInfo();
			} else if (req instanceof RequestMinPaymentDeferralRequest) {
				RequestMinPaymentDeferralRequest request = (RequestMinPaymentDeferralRequest) req;
				if (null == request.getRequestPayload().getDisclosureInfo()) {
					return;
				}
				arrangementId = request.getAcctNum();
				disclosureInfoList = request.getRequestPayload().getDisclosureInfo();

			} else if (req instanceof RequestInstallmentPlanRequest) {
				RequestInstallmentPlanRequest request = (RequestInstallmentPlanRequest) req;
				if (null == request.getRequestPayload().getDisclosureInfo()) {
					return;
				}
				arrangementId = request.getAcctNum();
				disclosureInfoList = request.getRequestPayload().getDisclosureInfo();
			} else if (req instanceof CaptureAgreementRequest) {
				CaptureAgreementRequest request = (CaptureAgreementRequest) req;
				if (null == request.getRequestPayload().getDisclosureInfo()) {
					logger.warning("CaptureAgreementRequest payload disclosureInfo is empty");
					return;
				}
				arrangementId = request.getRequestPayload().getAccountNo();
				logger.info("request.getAcctNum(): " + request.getAcctNum() + "request.getRequestPayload().getAccountNo():" + request.getRequestPayload().getAccountNo());
				disclosureInfoList.add(request.getRequestPayload().getDisclosureInfo());
			} else if (req instanceof AddPadRequest) {
				AddPadRequest request = ((AddPadRequest) req);
				if (request.getRequestPayload().getConfirmed() == null || !request.getRequestPayload().getConfirmed()) {
					logger.warning("AddPadRequest payload confirmed is false");
					return;
				}
				
				if (null == request.getRequestPayload().getDisclosureInfo()){
					logger.warning("AddPadRequest payload dislosureInfo is null");
					return;
				}
				
				arrangementId = request.getAcctNum();
				disclosureInfoList.add(request.getRequestPayload().getDisclosureInfo());

			} 

			// verification only.
			if (disclosureInfoList == null || disclosureInfoList.size()<1){
				logger.warning("disclosureInfoList is empty");
				return;
			}

			for(DisclosureInfoType info: disclosureInfoList) {
				if (info == null ) {
					logger.warning("disclosure Info is null");
					break;
				}
				generateRequest((BaseRequest)req, arrangementId, info, connectId);
			}

			/*
			 * at that level, we need to call CustomerAgreement.captureAgreement(request);
			 * we do not need the response because no information is needed to be extracted from it.
			 * We only care about the service fault If no fault is sent
			 * back, this means that the operation is successful.
			 */

		}
		catch (Exception ex) {
			logger.error("consentDisclosure",ex.getMessage(), ex);
			SystemError sysError = new SystemError();
			SystemException sysExcp = new SystemException();
			sysExcp.setErrorDescription(ex.getMessage());
			sysError.setFaultInfo(sysExcp);
			throw sysError;
		}

	}

	// Generate the request for captureAgreement and call the TD Web Service.
	static private void generateRequest(BaseRequest req, String arrangementId, DisclosureInfoType disclosureInfo, String connectId)  throws Exception {

		String loginId = req.getSessionInfo().getLoginId();


		String xmldate = null;
		if (disclosureInfo.getDisclosureDocPublishedDate() != null) {
			SimpleDateFormat pubDateFmt = new SimpleDateFormat(PUBLISH_DATE_FMT);
			synchronized(pubDateFmt){
				xmldate = pubDateFmt.format(disclosureInfo.getDisclosureDocPublishedDate());
			}
		}
		String metadata = disclosureInfo.getDisclosureMetaData();
		String documentTypeCD = disclosureInfo.getDisclosureDocTypeId();
		logger.info("documentTypeCD: " + documentTypeCD);
		// Generate captureAgreement request
		Map<String, Object> paramValues = new HashMap<String, Object>();
		// ArrangementID could be Customer.customerID or
		// Account.accountNumber
		paramValues.put("arrangementID", arrangementId);
		logger.info("arrangementId: " + arrangementId);
		//When the arrangement id is equal to the connect id for the "customer" related consents,
		//'ArrangementTypeCD' should equal 'FINSRV' and ProductTypeCD must equal 'TDW'.
		if (arrangementId.equalsIgnoreCase(connectId)) {
			paramValues.put("arrangementType", TDwsServiceUtil.getTDServiceParam(TDwsServiceUtil.TD_CS_CSTAGT_ARRANGEMENT_TYPE_CD_CUSTOMER));
			paramValues.put("productType", TDwsServiceUtil.getTDServiceParam(TDwsServiceUtil.TD_CS_CSTAGT_PRODUCT_TYPE_CD_CUSTOMER));
		}else{
			paramValues.put("arrangementType", TDwsServiceUtil.getTDServiceParam(TDwsServiceUtil.TD_CS_CSTAGT_ARRANGEMENT_TYPE_CD));
			paramValues.put("productType", TDwsServiceUtil.getTDServiceParam(TDwsServiceUtil.TD_CS_CSTAGT_PRODUCT_TYPE_CD));
		}

		if (null != xmldate) {
			paramValues.put("publishedDocDate", xmldate);
		}

		// task 5849
		String creationDate = null;
		SimpleDateFormat createDateFmt = new SimpleDateFormat(CREATE_DATE_FMT);
		synchronized(createDateFmt){
			if (disclosureInfo.getDisclosureDocCreationDate() != null) {
				creationDate = createDateFmt.format(disclosureInfo.getDisclosureDocCreationDate());
			}
			else {
				creationDate = createDateFmt.format(new Date());
			}
		}
		paramValues.put("docCreationDate", creationDate);
		//language will be read from request later
		paramValues.put("docLanguageID", req.getLanguagePref().equalsIgnoreCase("en_CA") ? "en" : "fr");
		paramValues.put("mimeType", TDwsServiceUtil.getTDServiceParam(TDwsServiceUtil.TD_CS_CSTAGT_MIME_TYPE_CD));
		//document type will be read from a property file later
		paramValues.put("documentType", documentTypeCD);
		paramValues.put("documentUsage", "");
		if (null != metadata) {
			paramValues.put("metadataUsage", TDwsServiceUtil.getTDServiceParam(TDwsServiceUtil.TD_CS_CSTAGT_DOCUMENT_META_DATA_USAGE));
			paramValues.put("metadataContent", metadata);
		}

		paramValues.put("lastName", req.getSessionInfo().getLastName());
		paramValues.put("givenNames", req.getSessionInfo().getFirstName());
		//initipartyID will be request.getCustId());
		paramValues.put("initPartyID", req.getCustId());
		paramValues.put("financialInstitution",  TDwsServiceUtil.getTDServiceParam(TDwsServiceUtil.TD_CS_CSTAGT_FINANCIAL_INSTITUTION_TYPE_CD));
		paramValues.put("sessionRefNumber", req.getSessionInfo().getSessionId());
		String initiatingLoginID = req.getSessionInfo().getConnectId();
		logger.info("initiatingLoginID: " + initiatingLoginID);

		// CustomerAgreement only allows 8 characters of login.
		if (initiatingLoginID.length() > 8)
			initiatingLoginID = initiatingLoginID.substring(0,8);
		paramValues.put("initiatingLoginID", initiatingLoginID);
		paramValues.put("initiatingLocationID", TDwsServiceUtil.getTDServiceParam(TDwsServiceUtil.TD_CS_CSTAGT_INITIATING_LOCATION_ID));
		paramValues.put("locationUsage", TDwsServiceUtil.getTDServiceParam(TDwsServiceUtil.TD_CS_CSTAGT_LOCATION_USAGE_CD));
		paramValues.put("ipAddress", req.getSessionInfo().getIpAddr());
		paramValues.put("sourceAppCode",TDwsServiceUtil.getTDServiceParam(TDwsServiceUtil.TD_CS_CSTAGT_SOURCE_APPLICATION_CODE));

		// invoke TD Customer Agreement Service CaptureAgreement operation
		try {
			BackEndSrvcUtil.invokeService(CAPTURE_AGREEMENT, CAPTURE_AGREEMENT,
					loginId, null, null,
					paramValues, null,
					BackEndSrvcUtil.TDOperation.TdCustAgreementService_capture,
					null);
			logger.info("consent captured for documentTypeCD: " + documentTypeCD + ", user: " + initiatingLoginID);
		} catch (Exception ex) {
			// no exception thrown, just log it
			logger.error("Error in captureAgreement::generateRequest TD service call", ex.getMessage(), ex);
			throw ex;
		}

	}


}
