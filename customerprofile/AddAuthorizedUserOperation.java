package com.td.mbna.msec.midtier.customerprofile;

import static java.time.format.DateTimeFormatter.ISO_DATE;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.transform.Templates;

import com.td.mbna.msec.midtier.mbnaad.MbnaAd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import com.mbnaweb.xsd.msgs.customerprofile.AddAuthorizedUserRequest;
import com.mbnaweb.xsd.msgs.customerprofile.AddAuthorizedUserResponse;
import com.td.api.mbcca.response.account.CreditCardAgreementToParty;
import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.mbcca.MbnaCCA;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.services.EmailInfoImpl;
import com.td.mbna.msec.midtier.services.IMBNAConstants;
import com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil;
import com.td.mbna.msec.midtier.tdwsservices.TdOdsCustomerAccountRelationshipService;
import com.td.mbna.msec.midtier.tdwsservices.TdOdsCustomerProfileService;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.types.common.EmailNotificationInfoType;
import com.td.mbna.msec.midtier.types.common.UnformattedAddress;
import com.td.mbna.msec.midtier.types.common.UserNameType;
import com.td.mbna.msec.midtier.util.BackEndSrvcUtil;
import com.td.mbna.msec.midtier.util.CustomerNotesUtil;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.IoUtil;
import com.td.mbna.msec.midtier.util.JaxbUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.TransformUtil;
import com.td.mbna.msec.midtier.util.UuidUtil;
import com.td.mbna.msec.midtier.util.services.JAXBJsonConverter;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;
import com.td.schemas.tdct.srm.card.service.v1.TIssueCardRq;
import com.td.schemas.tdct.srm.card.service.v1.TIssueCardRs;
import com.td.schemas.tdct.srm.card.service.v1.TSvcIssueCardRs;
import com.td.schemas.tdct.srm.cars.service.v2.TEnvCreateCustomerAccountRelationshipRq;
import com.td.schemas.tdct.srm.cars.service.v2.TEnvCreateCustomerAccountRelationshipRs;
import com.td.schemas.tdct.srm.cars.service.v2.TEnvUpdateCustomerAccountRelationshipRq;
import com.td.schemas.tdct.srm.cars.service.v2.TEnvUpdateCustomerAccountRelationshipRs;
import com.td.schemas.tdct.srm.cars.service.v2.TSvcUpdateCustomerAccountRelationshipRs;
import com.td.schemas.tdct.srm.customerprofile.service.v1.TEnvCreateCustomerProfileRq;
import com.td.schemas.tdct.srm.customerprofile.service.v1.TEnvCreateCustomerProfileRs;

@Component
public class AddAuthorizedUserOperation implements MsecMidtierCommonOperations<com.td.mbna.msec.midtier.customerprofile.payload.addauthorizeduser.AddAuthorizedUserRequest, com.td.mbna.msec.midtier.customerprofile.payload.addauthorizeduser.AddAuthorizedUserResponse>
{
    @Autowired
    private ValangValidator addAuthorizedUserRequestValidator;

    private MsecValidator msecAddAuthorizedUserRequestValidator;

    private static MbnaLogger logger = new MbnaLogger(AddAuthorizedUserOperation.class);

	private static final String GENERAL_ERROR = "MS601";
	private final static String TD_ISSUECARD_PREFIX = "issueCard_AddAU";

	private static final String CONTENT_CD = "contentCd";
	private static final String ADDAU_FIRST_NAME = "firstName";
	private static final String ADDAU_APP_DATE = "appDate";
	private static final String ADDAU_PRODUCT_NAME = "productName";
	private static final String ADDAU_LAST_FOUR_DIGIT = "cardLastFourDigit";

	@Autowired
	private MbnaCCA mbnaCCA;

	@Autowired
	private MbnaAd mbnaAd;

    private final static Templates CreateCustProfRq, CreateCustAcctRelationRq, MtAddAuthorizedUser1Rs, MtAddAuthorizedUser2Rs, UpdateCustAcctRelationRq;

    static {
        try {
            CreateCustProfRq = TransformUtil.getRqTemplate(TdOdsCustomerProfileService.TdOp_odsCreateCustomerProfile);
            CreateCustAcctRelationRq = TransformUtil.getRqTemplate(TdOdsCustomerAccountRelationshipService.TdOp_odsCreateCustomerAccountRelationship);
            UpdateCustAcctRelationRq = TransformUtil.getRqTemplate(TdOdsCustomerAccountRelationshipService.TdOp_odsUpdateCustomerAccountRelationship);
            MtAddAuthorizedUser1Rs = TransformUtil.getRsTemplate("MtAddAuthorizedUser1");
            MtAddAuthorizedUser2Rs = TransformUtil.getRsTemplate("MtAddAuthorizedUser2");
        } catch (Exception e) {
        	String message = " static block init failed ";
			logger.error("AddAuthorizedUserOperation:static", message,e);
            throw ExceptionUtil.genRuntimeException(e);
        }
    }


	@Override
	public com.td.mbna.msec.midtier.customerprofile.payload.addauthorizeduser.AddAuthorizedUserResponse invokeService(
			com.td.mbna.msec.midtier.customerprofile.payload.addauthorizeduser.AddAuthorizedUserRequest jsonRequest,
			String... token) {
		String methodName ="AddAuthorizedUserOperation::invokeService";
        if (jsonRequest.getRequestPayload().getConfirmed() == null || !jsonRequest.getRequestPayload().getConfirmed()) {
            return new com.td.mbna.msec.midtier.customerprofile.payload.addauthorizeduser.AddAuthorizedUserResponse();
        }

        AddAuthorizedUserRequest request = convert(jsonRequest);
        AddAuthorizedUserResponse jaxbResponse = null;
        try {
        	jaxbResponse = doAddAuthorizedUser(request,token[0]);
        } catch (com.td.mbna.msec.midtier.exceptions.BusinessException e) {
        	String message = " doAddAuthorizedUser with businessException failed ";
        	logger.error(methodName, message,e);
            throw e;
        } catch (Exception e) {
        	String message = " doAddAuthorizedUser with Exception failed ";
        	logger.error(methodName, message,e);
			throw ExceptionUtil.genRuntimeException(e);
		}
        return JAXBJsonConverter.convertoJAXBToJsonInterface(jaxbResponse, com.td.mbna.msec.midtier.customerprofile.payload.addauthorizeduser.AddAuthorizedUserResponse.class);
	}

    private AddAuthorizedUserResponse doAddAuthorizedUser(AddAuthorizedUserRequest request, String token) throws Exception {
    	String methodName ="AddAuthorizedUserOperation::doAddAuthorizedUser";
        Map<String, Object> params = new HashMap<>(2);
        params.put("trackId", UuidUtil.genUuid());
        TEnvCreateCustomerProfileRq createCustProfRq = TransformUtil.transformRequest(CreateCustProfRq, request, params, TEnvCreateCustomerProfileRq.class);
        TEnvCreateCustomerProfileRs createCustProfRs = TdOdsCustomerProfileService.createCustomerProfile(createCustProfRq);
        params.put("trackId", UuidUtil.genUuid());
        params.put("acctNum", request.getAcctNum());
        params.put("relationToPrimaryUser", request.getRequestPayload().getRelationToPrimaryUser());

        //if the business phone number has an extension, the MDM spec requires a 'x' in it.
        //But during the CARS call, that same number is passed in the PartyAgreementLocator field.
        //CODS will pass that number to TSYS, and TSYS will fail because there's a 'x' in it.
        //We'll need to replace the X with a dash again.
        String bizPhoneInPartyAgreementLocator = request.getRequestPayload().getBusinessPhone();
        logger.info("replacing the 'x' in business # " + bizPhoneInPartyAgreementLocator + " with '-' before calling createAccountRelationship");
        bizPhoneInPartyAgreementLocator = bizPhoneInPartyAgreementLocator.replaceAll("x", "-");
        logger.debug("after replace: " + bizPhoneInPartyAgreementLocator);

        params.put("bizPhoneInPartyAgreementLocator", bizPhoneInPartyAgreementLocator);
		params.put("issueCard",!request.isIsMultiCard());

        TEnvCreateCustomerAccountRelationshipRq createCustAcctRelationRq = TransformUtil.transformRequest(CreateCustAcctRelationRq, createCustProfRs, params, TEnvCreateCustomerAccountRelationshipRq.class);


        TEnvCreateCustomerAccountRelationshipRs createCustAcctRelationRs = TdOdsCustomerAccountRelationshipService.createAccountRelationship(createCustAcctRelationRq);
        AddAuthorizedUserResponse responseFromProfile, responseFromRelationship;
        responseFromRelationship = TransformUtil.transformRequest(MtAddAuthorizedUser2Rs, createCustAcctRelationRs, null, AddAuthorizedUserResponse.class);
        responseFromProfile = TransformUtil.transformRequest(MtAddAuthorizedUser1Rs, createCustProfRs, null, AddAuthorizedUserResponse.class);
        AddAuthorizedUserResponse response = responseFromProfile; // use response from profile as the final response as it contains most required fields
        response.getResponsePayload().setNewAliasCustId(responseFromRelationship.getResponsePayload().getNewAliasCustId());
        response.getResponsePayload().setRelationToPrimaryUser(responseFromRelationship.getResponsePayload().getRelationToPrimaryUser());

		//if multi-card issue card as well
		if (request.isIsMultiCard() && (response.getErrorMsgs() == null || response.getErrorMsgs().size() == 0 )) {
			if (!issueCard(response,request,token)) {
				String message = " Unable to Issue Card for AU. Thus Add AU failed. ";
	        	logger.error(methodName, message);
				removeAu(UpdateCustAcctRelationRq,createCustAcctRelationRs);
				throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,message);


			}
		}

		return response;
    }

    private boolean removeAu(Templates templates,TEnvCreateCustomerAccountRelationshipRs tEnvCreateCustomerAccountRelationshipRs) {

		String DATE_FORMAT = "yyyy-MM-dd";

    	SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    	String endDate = dateFormat.format(new Date());

		Map<String, Object> params = new HashMap<>(2);
		params.put("trackId", UuidUtil.genUuid());
		params.put("endDate", endDate);

		try {
			TEnvUpdateCustomerAccountRelationshipRq tEnvUpdateCustomerAccountRelationshipRq = TransformUtil.transformRequest(UpdateCustAcctRelationRq, tEnvCreateCustomerAccountRelationshipRs, params, TEnvUpdateCustomerAccountRelationshipRq.class);
			TEnvUpdateCustomerAccountRelationshipRs removedAuResponse = TdOdsCustomerAccountRelationshipService.updateAccountRelationship(tEnvUpdateCustomerAccountRelationshipRq);

			if (((TSvcUpdateCustomerAccountRelationshipRs) (removedAuResponse.getAbstractBusinessSvcRs().getValue())).getStatus().getStatusCode() == 0) {
				return true;
			}

			String errorDescripton = ((TSvcUpdateCustomerAccountRelationshipRs) (removedAuResponse.getAbstractBusinessSvcRs().getValue())).getStatus().getServerStatusDesc();
			logger.error("Failed to remove AU",errorDescripton);
			return false;

		} catch (Exception e) {
			logger.error("Failed to remove AU.",e.getLocalizedMessage(),e);
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	private  boolean issueCard(AddAuthorizedUserResponse response,AddAuthorizedUserRequest request, String token)  {

		String methodName = "issueCard";

		try {

			logger.debug("calling CreditCardAccountService to get the newly added CardNumber");
			//1. call retrieveCreditCardAccount
			String newlyAddedCardNumber = retrieveCardNumberOfNewlyAddedAU(request,response,token);

			if (newlyAddedCardNumber == null) {
				logger.error(methodName,"unable to retrive newly added customer id");
				return false;
			}

			//2. issue card using newly added card number

			Map<String, Object> paramValues = new HashMap<String, Object>();
			paramValues.put("acctNum", request.getAcctNum());
			paramValues.put("msgId", UuidUtil.genUuid());
			paramValues.put("msgId2", UuidUtil.genUuid());
			//paramValues.put("CustomerID", request.getAliasCustId());
			paramValues.put("CustomerID", response.getResponsePayload().getNewAliasCustId());
			String issuerId = TDwsServiceUtil.getTDServiceParam(TDwsServiceUtil.ISSUERID);
			paramValues.put("issuerId", issuerId);
			paramValues.put("CardType", "Primary");
			paramValues.put("NumberOfCardsRequired", "1");
			paramValues.put("CardRequestReason", "New");
			paramValues.put("ChargeDeliveryFeeInd", "false");
			paramValues.put("ForceReissueIndicator", "false");
			paramValues.put("acctId", request.getAcctNum());
			paramValues.put("allCards",false);
			paramValues.put("cardNum",newlyAddedCardNumber);

			com.mbnaweb.xsd.types.common.UnformattedAddress auAddress = request.getRequestPayload().getAuthorizedUserAddress();

			paramValues.put("AddressLine1",auAddress.getAddrLine1());
			paramValues.put("City",auAddress.getCity());
			paramValues.put("StateProvince",auAddress.getProvince());
			paramValues.put("PostalCode",auAddress.getPostalCode());
			paramValues.put("CountryCode","CAN");

			paramValues.put("OverrideAddressIndicator",true);


			/*InputStream tdReqStubXml = TransformUtil.getTdRqStubXml(TD_ISSUECARD_PREFIX);
			Templates mt2tdReqTranformer = TransformUtil.getRqTemplate(TD_ISSUECARD_PREFIX);

			JAXBResult result0 = new JAXBResult(JaxbUtil.getJaxbContext(BackEndSrvcUtil.getTDserviceReqMsgClass(BackEndSrvcUtil.TDOperation.TdCardService_issueCard)));
			TransformUtil.transformRequest(mt2tdReqTranformer, new StreamSource(tdReqStubXml), paramValues, result0);
			IoUtil.closeIgnoreException(tdReqStubXml);

			JAXBElement<TIssueCardRq> issueResponseJaxb = (JAXBElement<TIssueCardRq>) result0.getResult();

			final TIssueCardRq issueCardRq = issueResponseJaxb.getValue();

			TIssueCardRs tIssueCardRs = TdCardService.issueCard2(issueCardRq);*/

			logger.debug("calling IssueCard service");

			return mbnaAd.issueCardForAU(request, response, newlyAddedCardNumber, token);

			/*TSvcIssueCardRs tSvcIssueCardRs =  (TSvcIssueCardRs) tIssueCardRs.getAbstractBusinessSvcMsg().getValue();*/

			/*if (tSvcIssueCardRs.getStatus().getServerStatusCode().equalsIgnoreCase("000")) {
				logger.debug("succesfully issued card.");
				return true;
			} else {
				logger.error(methodName,"Issue Card failed."+tSvcIssueCardRs.getStatus().getStatusDesc());
				return false;
			}*/

		} catch (Exception e) {
			logger.error(methodName,e.getLocalizedMessage(),e);
			return false;

		}

	}

	private String retrieveCardNumberOfNewlyAddedAU(AddAuthorizedUserRequest request,AddAuthorizedUserResponse response, String token) throws Exception {

		String acctNum = request.getAcctNum();
		String newlyAddedCustomerId = response.getResponsePayload().getNewAliasCustId();
		String newlyAddedCardNumber = null;
		
		//use null for connectId, so that cache won't be used for TDApiInterceptor
		List<CreditCardAgreementToParty> creditCardAgreementToPartyList = mbnaCCA.retrieveCustomerInformation(null, acctNum,token);

		for(CreditCardAgreementToParty creditCardAgreementToParty : creditCardAgreementToPartyList) {
			if(creditCardAgreementToParty == null){
				continue;
			}
			if (creditCardAgreementToParty.getTsysExtension().getCustomerId().equalsIgnoreCase(newlyAddedCustomerId)) {
				newlyAddedCardNumber = creditCardAgreementToParty.getTsysExtension().getCardNum();
				break;
			}
		}

		return newlyAddedCardNumber;
	}


	@Override
	public boolean requiresDisclosureConsent() {
		return true;
	}

	@Override
	public String getConsentDisclosureFailedMsgCode() {
		return null;
	}

	@Override
	public boolean generateAutoComment() {
		return true;
	}

	@Override
	public List<String> createAutoComment(BaseRequest request, BaseResponse response) {
		SimpleDateFormat dateFmt = new SimpleDateFormat("MM/dd/yyyy");
		List<String> comment = new ArrayList<String>();
		com.td.mbna.msec.midtier.customerprofile.payload.addauthorizeduser.AddAuthorizedUserRequest req = (com.td.mbna.msec.midtier.customerprofile.payload.addauthorizeduser.AddAuthorizedUserRequest) request;
		com.td.mbna.msec.midtier.customerprofile.payload.addauthorizeduser.RequestPayload payload = req.getRequestPayload();
		if (payload.getConfirmed() == null || !payload.getConfirmed()) {
			return null;
		}
		String header = CustomerNotesUtil.getHeaderContent(request,	"Add Authorized User");
		StringBuilder strBuffer = new StringBuilder();
		strBuffer.append(header);

		if (payload != null) {
			strBuffer.append("Added: ");
			appendUserName(payload.getUserName(), strBuffer);
			strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
			strBuffer.append("Address: ");
			UnformattedAddress auAddr = payload.getAuthorizedUserAddress();
			appendAddress(auAddr, strBuffer);
			strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
			strBuffer.append("DOB: ").append(dateFmt.format(new Date(payload.getDateOfBirth())));
			strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
			strBuffer.append("Relationship: ").append(payload.getRelationToPrimaryUser());
			
			if (payload.getHomePhone() != null && payload.getHomePhone().isEmpty() == false) {
				strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
				strBuffer.append("Home Phone: ").append(payload.getHomePhone());
			}
			if (payload.getBusinessPhone() != null && payload.getBusinessPhone().isEmpty() == false) {
				strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
				strBuffer.append("Business Phone: ").append(payload.getBusinessPhone());
			}
			if (payload.getMobilePhone() != null && payload.getMobilePhone().isEmpty() == false) {
				strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
				strBuffer.append("Mobile Phone: ").append(payload.getMobilePhone());
			}
			strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
			strBuffer.append("Sent to address: ");
			UnformattedAddress pchAddr = payload.getPrimaryUserAddress();
			appendAddress(pchAddr, strBuffer);
		}

		comment.add(strBuffer.toString());

		return comment;
	}

	private void appendUserName(UserNameType au, StringBuilder strBuffer) {
		strBuffer.append(au.getFirstName());
		String mn = au.getMiddleName();
		if (mn != null && mn.isEmpty() == false) {
			strBuffer.append(" ").append(mn);
		}
		strBuffer.append(" ").append(au.getLastName());
		String suffix = au.getSuffixText();
		if (suffix != null && suffix.isEmpty() == false) {
			strBuffer.append(" ").append(suffix);
		}
	}

	private void appendAddress(UnformattedAddress addr, StringBuilder strBuffer) {
		strBuffer.append(addr.getAddrLine1());
		strBuffer.append(" ");
		strBuffer.append(addr.getCity());
		strBuffer.append(", ");
		strBuffer.append(addr.getProvince());
		strBuffer.append(" ");
		strBuffer.append(addr.getPostalCode());
	}

	@Override
	public EmailInfo getEmailInfoBean(BaseRequest baseRequest, BaseResponse response) {
		EmailInfoImpl emailInfoBean = new EmailInfoImpl();
		emailInfoBean.setLogonId(baseRequest.getSessionInfo().getLoginId());

		com.td.mbna.msec.midtier.customerprofile.payload.addauthorizeduser.AddAuthorizedUserRequest request = ((com.td.mbna.msec.midtier.customerprofile.payload.addauthorizeduser.AddAuthorizedUserRequest) baseRequest);
		EmailNotificationInfoType emailNotificationInfo = request.getRequestPayload().getEmailNotificationInfo();
		if (request.getRequestPayload().getConfirmed() == null || !request.getRequestPayload().getConfirmed() ) {
			emailInfoBean.setTriggerEmailNotification(false);
			return emailInfoBean;
		}
		
		emailInfoBean = new EmailInfoImpl(emailNotificationInfo, baseRequest.getSessionInfo().getLoginId(), IMBNAConstants.ALERT_TYPE_CD_SECUREGENERIC, request.getIsPrimaryUser() == null ? false : request.getIsPrimaryUser().booleanValue());
		emailInfoBean.setConnectId(baseRequest.getSessionInfo().getConnectId());
		if (emailNotificationInfo == null){
			return null;
		}

		emailInfoBean.setAcctNum(request.getAcctNum());

        LocalDate now = LocalDate.now();
		emailInfoBean.addAttribute(CONTENT_CD, IMBNAConstants.BUSINESSEVENT_ID_ADDAUTHORIZEDUSERREQUEST);
		emailInfoBean.addAttribute(ADDAU_FIRST_NAME, emailNotificationInfo.getPrimaryUserFirstName());
		emailInfoBean.addAttribute(ADDAU_APP_DATE, ISO_DATE.format(now));
		emailInfoBean.addAttribute(ADDAU_LAST_FOUR_DIGIT, emailNotificationInfo.getPrimaryUserCardEnding());  
		emailInfoBean.addAttribute(ADDAU_PRODUCT_NAME, emailNotificationInfo.getCardName());
		
        return emailInfoBean;
	}

  private static com.mbnaweb.xsd.msgs.customerprofile.AddAuthorizedUserRequest convert(com.td.mbna.msec.midtier.customerprofile.payload.addauthorizeduser.AddAuthorizedUserRequest p){
	com.mbnaweb.xsd.msgs.customerprofile.AddAuthorizedUserRequest px = null;
	try {
		px = JAXBJsonConverter.convertJsonToJAXBInterface(p, com.mbnaweb.xsd.msgs.customerprofile.AddAuthorizedUserRequest.class);
		if (px != null) {
			if (p.getRequestPayload() != null){
				px.getRequestPayload().setDateOfBirth(JAXBJsonConverter.convert(p.getRequestPayload().getDateOfBirth()));
				px.getRequestPayload().setPrimaryUserAddress(JAXBJsonConverter.convert(p.getRequestPayload().getPrimaryUserAddress()));
				px.getRequestPayload().setAuthorizedUserAddress(JAXBJsonConverter.convert(p.getRequestPayload().getAuthorizedUserAddress()));
			}
		}
	} catch (Exception e) {
		logger.error("convert", "failure " + p, e);
	}
	return px;
}
	@PostConstruct
	private void init() {
		msecAddAuthorizedUserRequestValidator = new MsecVlangValidator(addAuthorizedUserRequestValidator);
	}

	@Override
	public MsecValidator getValidator() {
		return msecAddAuthorizedUserRequestValidator;
	}

}