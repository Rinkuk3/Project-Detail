package com.td.mbna.msec.midtier.customerprofile;

import static java.time.format.DateTimeFormatter.ISO_DATE;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.Templates;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.mutable.MutableBoolean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import com.mbnaweb.xsd.msgs.customerprofile.AccountKycAuInfoType;
import com.mbnaweb.xsd.msgs.customerprofile.AccountKycInfoType;
import com.mbnaweb.xsd.msgs.customerprofile.BusinessException;
import com.mbnaweb.xsd.msgs.customerprofile.CustomerAcctInfoType;
import com.mbnaweb.xsd.msgs.customerprofile.CustomerInfoType;
import com.mbnaweb.xsd.msgs.customerprofile.CustomerProfileType;
import com.mbnaweb.xsd.msgs.customerprofile.GetKycAcctsInfoResponse;
import com.mbnaweb.xsd.msgs.customerprofile.SetKycAcctsInfoRequest;
import com.mbnaweb.xsd.msgs.customerprofile.SetKycAcctsInfoRequest.RequestPayload;
import com.mbnaweb.xsd.msgs.customerprofile.SetKycAcctsInfoResponse;
import com.mbnaweb.xsd.msgs.customerprofile.UpdateCustomerProfileResponse;
import com.mbnaweb.xsd.types.common.CustAcctType;
import com.mbnaweb.xsd.types.common.TrackableRequest;
import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.mbalert.MbnaAlert;
import com.td.mbna.msec.midtier.mbcca.MbnaCCA;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.services.AuditService;
import com.td.mbna.msec.midtier.services.AuditServiceWork;
import com.td.mbna.msec.midtier.services.EmailInfoImpl;
import com.td.mbna.msec.midtier.services.IMBNAConstants;
import com.td.mbna.msec.midtier.tdwsservices.TdOdsCustomerProfileService;
import com.td.mbna.msec.midtier.types.common.AuditInfo;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.PrimaryCardMemberInfo;
import com.td.mbna.msec.midtier.types.common.ValidationException;
import com.td.mbna.msec.midtier.util.BackEndSrvcUtil;
import com.td.mbna.msec.midtier.util.CustomerNotesUtil;
import com.td.mbna.msec.midtier.util.CustomerProfileUtil;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.JaxbUtil;
import com.td.mbna.msec.midtier.util.MBNAPropertiesUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.ParallelServiceCaller;
import com.td.mbna.msec.midtier.util.ServiceCall;
import com.td.mbna.msec.midtier.util.TransformUtil;
import com.td.mbna.msec.midtier.util.UuidUtil;
import com.td.mbna.msec.midtier.util.services.JAXBJsonConverter;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;
import com.td.schemas.tdct.srm.customerprofile.service.v1.ObjectFactory;
import com.td.schemas.tdct.srm.customerprofile.service.v1.TAgreementGroup;
import com.td.schemas.tdct.srm.customerprofile.service.v1.TCreditCardAgreement;
import com.td.schemas.tdct.srm.customerprofile.service.v1.TEnvUpdateCustomerProfileRq;
import com.td.schemas.tdct.srm.customerprofile.service.v1.TEnvUpdateCustomerProfileRs;
import com.td.schemas.tdct.srm.customerprofile.service.v1.TPartyAgreement;
import com.td.schemas.tdct.srm.customerprofile.service.v1.TPartyAgreementLocator;
import com.td.schemas.tdct.srm.customerprofile.service.v1.TStreetAddress;
import com.td.schemas.tdct.srm.customerprofile.service.v1.TSvcUpdateCustomerProfileRq;
import com.td.schemas.tdct.srm.customerprofile.service.v1.TTelephoneNumber;

@Component
public class SetKycAcctsInfoOperation implements MsecMidtierCommonOperations<com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest, com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoResponse> {

    private static final String AU_DELIMITER = "AU";
    private static final String PCH_DELIMITER = "PCH";
    private static MbnaLogger logger = new MbnaLogger(SetKycAcctsInfoOperation.class);
    private static final String ErrorCode = "MS607";
    public static final String PHONE = "Phone";
    public static final String CUSTOMERNOTE_NO_CHANGE = "KYC confirmed (no changes)";

    private static final String GENERAL_ERROR = "MS601";

	private static final String CONTENT_CD = "contentCd";
	private static final String UPDATE_PROFILE = "KycUpdateProfile";
	private static final String UCP_FIRST_NAME = "firstName";
	private static final String UCP_APP_DATE = "appDate";
	private static final String UCP_PRODUCT_NAME = "productName";
	private static final String UCP_LAST_FOUR_DIGIT = "cardLastFourDigit";

	@Autowired
    GetKycAcctsInfoOperation getKycAcctsInfoOperation;

    @Autowired
    private ValangValidator setKycAcctsInfo_CustomerAcctInfoType_Validator;
    
    @Autowired
    private ValangValidator setKycAcctsInfo_CustomerInfoType_Validator;

    @Autowired 
    private MbnaCCA mbnaCCA;

    @Autowired
    private MbnaAlert mbnaAlert;

    @Autowired
    private Executor midtierExecutor;
    
    private MsecValidator msecSetKycAcctsInfoCustomerAcctInfoTypeValidator;
    private MsecValidator msecSetKycAcctsInfoCustomerInfoTypeValidator;

    @PostConstruct
    private void init() {
        msecSetKycAcctsInfoCustomerAcctInfoTypeValidator = new MsecVlangValidator(setKycAcctsInfo_CustomerAcctInfoType_Validator);
        msecSetKycAcctsInfoCustomerInfoTypeValidator = new MsecVlangValidator(setKycAcctsInfo_CustomerInfoType_Validator);
    }

    @Override
    public com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoResponse invokeService(com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest request, String... token) {
    	String methodName = "SetKycAcctsInfoOperation::invokeService";
    	com.mbnaweb.xsd.msgs.customerprofile.SetKycAcctsInfoRequest jaxbRequest = JAXBJsonConverter.convertJsonToJAXBInterface(request, com.mbnaweb.xsd.msgs.customerprofile.SetKycAcctsInfoRequest.class);
    	
    	SetKycAcctsInfoRequest.RequestPayload reqPayload = jaxbRequest.getRequestPayload();
    	
    	boolean isValid = false;
    	try {
			isValid = validateRequestPayload(reqPayload);
		} catch (Exception e) {
			String message = " validateRequestPayload(reqPayload) failed ";
			logger.error(methodName, message,e);
			throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,message, e);
		}
    	
    	SetKycAcctsInfoResponse response =  new SetKycAcctsInfoResponse();
    	
        try {
            if(isValid){
            	response = setKycAcctsInfo(jaxbRequest, request, token);
            }
        } catch (ValidationException ve) {
            throw ve;
        } catch (Exception e) {
        	String message = " updating kyc failed ";
        	logger.error(methodName, message,e);
            throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,message, e);
        }
        return JAXBJsonConverter.convertoJAXBToJsonInterface(response, com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoResponse.class);
    }

    private boolean validateRequestPayload(RequestPayload reqPayload) {
    	String methodName = "SetKycAcctsInfoOperation::validateRequestPayload";
    	 CustomerInfoType custInfoTp = reqPayload.getKycCustInfo();
         try {
			Validate.notNull(custInfoTp);
		} catch (Exception e) {
			String message = " reqPayload.getKycCustInfo() is null ";
        	logger.error(methodName, message,e);
        	throw ExceptionUtil.genBusinessException(message);
		}
         ValidationException faultInfo = null;
         
         try {
        	 faultInfo = msecSetKycAcctsInfoCustomerInfoTypeValidator.validate(custInfoTp);
		} catch (Exception e) {
			String message = " msecSetKycAcctsInfoCustomerInfoTypeValidator.validate(custInfoTp) failed ";
        	logger.error(methodName, message,e);
		}

         List<AccountKycInfoType> accountKycInfoTypeList = reqPayload.getKycAcctsInfo();

         if ((accountKycInfoTypeList != null) && (accountKycInfoTypeList.size() > 0)) {
             for (AccountKycInfoType actKycInfoTp : accountKycInfoTypeList) {

            	 if(actKycInfoTp == null){
            		 continue;
            	 }
                 CustomerAcctInfoType customerAcctInfoTp_L2 = actKycInfoTp.getKycCustAcctInfo();
                 ValidationException faultInfo_accountKycInfoType_customerAcctInfoType = null;
                 try {
                	 faultInfo_accountKycInfoType_customerAcctInfoType = msecSetKycAcctsInfoCustomerAcctInfoTypeValidator.validate(customerAcctInfoTp_L2);
				} catch (Exception e) {
					String message = " msecSetKycAcctsInfoCustomerAcctInfoTypeValidator.validate(customerAcctInfoTp_L2) failed ";
					logger.error(methodName, message,e);
				}

                 if (faultInfo != null) {
                     if (faultInfo_accountKycInfoType_customerAcctInfoType != null && !faultInfo_accountKycInfoType_customerAcctInfoType.getFieldError().isEmpty()) {
                         faultInfo.getFieldError().addAll(faultInfo_accountKycInfoType_customerAcctInfoType.getFieldError());
                     }
                 } else {
                     faultInfo = faultInfo_accountKycInfoType_customerAcctInfoType;
                 }

                 List<AccountKycAuInfoType> actKycAuInfoTpList = actKycInfoTp.getKycAuthorizeUsers();

                 if ((actKycAuInfoTpList != null) && (actKycAuInfoTpList.size() > 0)) {
                     for (AccountKycAuInfoType actKycAuInfoTp : actKycAuInfoTpList) {
                    	 if(actKycAuInfoTp == null){
                    		 continue;
                    	 }
                         CustomerAcctInfoType customerAcctInfoTp_L3 = actKycAuInfoTp.getKycAuCustAcctInfo();

                         ValidationException faultInfo_accountKycInfoType_accountKycAuInfoType_customerAcctInfoType = null;
                         try {
                        	 faultInfo_accountKycInfoType_accountKycAuInfoType_customerAcctInfoType = msecSetKycAcctsInfoCustomerAcctInfoTypeValidator.validate(customerAcctInfoTp_L3);
						} catch (Exception e) {
							String message = " msecSetKycAcctsInfoCustomerAcctInfoTypeValidator.validate(customerAcctInfoTp_L3) failed ";
							logger.error(methodName, message,e);
						}
                         if (faultInfo != null) {
                             if (faultInfo_accountKycInfoType_accountKycAuInfoType_customerAcctInfoType != null && !faultInfo_accountKycInfoType_accountKycAuInfoType_customerAcctInfoType.getFieldError().isEmpty()) {
                                 faultInfo.getFieldError().addAll(faultInfo_accountKycInfoType_accountKycAuInfoType_customerAcctInfoType.getFieldError());
                             }
                         } else {
                             faultInfo = faultInfo_accountKycInfoType_accountKycAuInfoType_customerAcctInfoType;
                         }
                     }
                 }
             }
         }

         if (faultInfo != null && !faultInfo.getFieldError().isEmpty()) {
             throw faultInfo;
         }
		return true;
		
	}

    private SetKycAcctsInfoResponse setKycAcctsInfo(com.mbnaweb.xsd.msgs.customerprofile.SetKycAcctsInfoRequest jaxbRequest, com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest request, String ...token) throws Exception{
		String methodName = "SetKycAcctsInfoOperation::setKycAcctsInfo";
		// Call GetKycAcctsInfoResponse
        com.td.mbna.msec.midtier.customerprofile.payload.getkycacctsinfo.GetKycAcctsInfoResponse currentKycInJson = null;
        try {
        	currentKycInJson = getCurrentKycAcctsInfo(request);
		} catch (Exception e) {
			String message = " getCurrentKycAcctsInfo(request) failed ";
			logger.error(methodName, message,e);
		}
        GetKycAcctsInfoResponse currentKyc = JAXBJsonConverter.convertJsonToJAXBInterface(currentKycInJson, com.mbnaweb.xsd.msgs.customerprofile.GetKycAcctsInfoResponse.class);
        // Compare the values and the timestamps

        final ChangeFlags changes = new ChangeFlags();
        final ParallelServiceCaller updateUserSvcCaller = new ParallelServiceCaller();
        CustNotesAndEmails custLevelNotesAndEmails = new CustNotesAndEmails();
        final List<CustNotesAndEmails> allCustAcctNotesAndEmails = new ArrayList<CustNotesAndEmails>();
        boolean isPrimaryUpdated = false;
		try {
			isPrimaryUpdated = updatePrimaryCardHolderInfo(updateUserSvcCaller, jaxbRequest, currentKyc, changes, custLevelNotesAndEmails, allCustAcctNotesAndEmails);
		} catch (Exception e) {
			String message = " updatePrimaryCardHolderInfo failed ";
			logger.error(methodName, message,e);
		}
        
		boolean kycChanged = false;
        if (isPrimaryUpdated) {
            kycChanged = true;
        }

        // This stores the CustomerNotes for changed AU by account.
        Map<String, CustNotesAndEmails> allAuNotesAndEmails = new HashMap<String, CustNotesAndEmails>();
        // Since CODS requires the LastUpdateTS at high level, the changes for authorized will be consolidated
        // in a HashMap, the Key of the HashMap will be the UCID of the authorized user
        Map<String, List<TEnvUpdateCustomerProfileRq>> authorizedUsersReq = new HashMap<String, List<TEnvUpdateCustomerProfileRq>>();
        for (AccountKycInfoType acctInfo : jaxbRequest.getRequestPayload().getKycAcctsInfo()) {
        	if(acctInfo == null){
        		continue;
        	}
            AccountKycInfoType currKycAcct = null;
            if(currentKyc != null && currentKyc.getResponsePayload() != null && currentKyc.getResponsePayload().getKycAcctsInfo() != null){
            	for (AccountKycInfoType currentKycAcct : currentKyc.getResponsePayload().getKycAcctsInfo()) {
            		if(currentKycAcct == null){
            			continue;
            		}
            		if (currentKycAcct.getKycAcct().getAcctNum().equals(acctInfo.getKycAcct().getAcctNum())) {
            			currKycAcct = currentKycAcct;
            		}
            	}
            }
            for (AccountKycAuInfoType auInfo : acctInfo.getKycAuthorizeUsers()) {
            	if(auInfo == null){
            		continue;
            	}
                for (AccountKycAuInfoType currAuInfo : currKycAcct.getKycAuthorizeUsers()) {
                	if(currAuInfo == null){
                		continue;
                	}
                    String auCustId = auInfo.getKycAuCustAcctInfo().getCustId();
                    if (auCustId.equals(currAuInfo.getKycAuCustAcctInfo().getCustId())) {
                        // Get the list of the AU customer notes for that account
                        CustNotesAndEmails auNotesAndEmails = null;
                        auNotesAndEmails = allAuNotesAndEmails.get(currAuInfo.getKycAuCustAcctInfo().getAcctNum());
                        if (auNotesAndEmails == null) {
                            auNotesAndEmails = new CustNotesAndEmails();
                        }
                        auNotesAndEmails.setAcctNum(currAuInfo.getKycAuCustAcctInfo().getAcctNum());
                        if (updateAuthorizedUserInfo(authorizedUsersReq, jaxbRequest, acctInfo, auInfo, currAuInfo, auNotesAndEmails, changes)) {
                            kycChanged = true;
                            allAuNotesAndEmails.put(currAuInfo.getKycAuCustAcctInfo().getAcctNum(), auNotesAndEmails);
                        }
                        break;
                    }
                }
            }
        }
        // Issue update for each authorized user

        if (authorizedUsersReq.size() > 0) {
            for (String custId : authorizedUsersReq.keySet()) {
                List<TEnvUpdateCustomerProfileRq> reqList = authorizedUsersReq.get(custId);
                final TEnvUpdateCustomerProfileRq consolidatedReq = combineRequest(reqList);
                final String auCustId = custId;
                ServiceCall<?> updAuthorizedCall = new ServiceCall<SetKycAcctsInfoResponse>() {
                    @Override
                    public SetKycAcctsInfoResponse invoke() throws Exception {
                        SetKycAcctsInfoResponse resp = null;
                        try {
                            resp = callUpdateAuWS(auCustId, consolidatedReq);
                            if (resp != null && !resp.getResponsePayload().isKycChanged()) {
                                genAuditLog(request, "SS2523", null, auCustId, null);
                            }
                        } catch (Exception e) {
                            genAuditLog(request, "SS2523", null, auCustId, null);
                            String message = " callUpdateAuWS(auCustId, consolidatedReq) failed ";
                			logger.error(methodName, message,e);
                            throw e;
                        }

                        return resp;
                    }
                };
                try {
                    updateUserSvcCaller.scheduleCall(auCustId, updAuthorizedCall);
                } catch (Exception e) {
                	String message = " updateUserSvcCaller.scheduleCall(auCustId, updAuthorizedCall) failed ";
					logger.error(methodName, message,e);
                    throw ExceptionUtil.genRuntimeException(e);

                }
            }
        }
        SetKycAcctsInfoResponse resp = new SetKycAcctsInfoResponse();
        SetKycAcctsInfoResponse.ResponsePayload resPayload = new SetKycAcctsInfoResponse.ResponsePayload();
        resp.setResponsePayload(resPayload);
        resPayload.setKycChanged(false);
        resPayload.setKycCustInfo(jaxbRequest.getRequestPayload().getKycCustInfo());
        resPayload.getKycAcctsInfo().addAll(jaxbRequest.getRequestPayload().getKycAcctsInfo());
        if (kycChanged) {
            try {
            	updateUserSvcCaller.sync();
            } catch (Exception e) {
            	String message = " updateUserSvcCaller.sync() failed ";
				logger.error(methodName, message,e);
	            throw ExceptionUtil.genRuntimeException(e);
            }
        	resPayload.setKycChanged(true);
        	// Get the response from updating the Primary User
        	SetKycAcctsInfoResponse pchResult = updateUserSvcCaller.getResponse(request.getSessionInfo().getLoginId(), SetKycAcctsInfoResponse.class);
        	if (pchResult != null) {
        		updatePrimaryFromResponse(resPayload, pchResult, changes);
        	}
        	if (authorizedUsersReq.size() > 0) {
        		for (String custId : authorizedUsersReq.keySet()) {
        			SetKycAcctsInfoResponse auResult = updateUserSvcCaller.getResponse(custId, SetKycAcctsInfoResponse.class);
        			updateAuFromResponse(resPayload, auResult, changes);
        		}
        	}
        }
        
        updateKycFlag(request, resPayload);
        
        createCustomerNotes(request, custLevelNotesAndEmails, allCustAcctNotesAndEmails, allAuNotesAndEmails, token);
        if (kycChanged) {
        	sendEmailNotifications(request, token);
        }
        
        createAuditInfo(request, changes, kycChanged);
//            try {
//            } catch (Exception e) {
//            	String message = " msecSetKycAcctsInfoCustomerAcctInfoTypeValidator.validate(customerAcctInfoTp_L2) failed ";
//				logger.error(methodName, message,e);
//                throw ExceptionUtil.genRuntimeException(e);
//            }

        return resp;


    }

    @Override
    public boolean requiresDisclosureConsent() {
        return false;
    }

    @Override
    public String getConsentDisclosureFailedMsgCode() {
        return null;
    }

    @Override
    public boolean generateAutoComment() {
        return false;
    }

    @Override
    public List<String> createAutoComment(BaseRequest request, com.td.mbna.msec.midtier.types.common.BaseResponse response) {
        return null;
    }

    @Override
    public EmailInfo getEmailInfoBean(BaseRequest request, com.td.mbna.msec.midtier.types.common.BaseResponse response) {
        return null;
    }

    @Override
    public MsecValidator getValidator() {
        return null;
    }

    private static class ChangeFlags {
        public boolean isPhysicalAddressChanged = false;
        public boolean isEmployementChanged = false;
        public List<String> mailingAddressChanged = new ArrayList<>();
        public List<String> businessPhoneChanged = new ArrayList<>();
        public List<String> mobilePhoneChanged = new ArrayList<>();
        public List<String> homePhoneChanged = new ArrayList<>();
        public List<String> employmentChanged = new ArrayList<>();
        public List<String> physicalAddressChanged = new ArrayList<>();
    }

    private final static String TdOp_setKycAcctsInfo = "odsSetKycAcctsInfo";
    private final static String TdOp_setKycAcctsInfoForAU = "odsSetKycAcctsInfoForAU";
    private final static String SET_KYC_PCH_ACCT = "odsSetKycAcctsInfoPrimary";
    private final static String SET_KYC_AU_ACCT = "odsSetKycAcctsInfoAu";
    private final static String UPDATE_KYC = "odsUpdateKyc";
    private final static String UPDATE_CUSTOMER_PROFILE_RS = "odsUpdateCustomerRs";
    private long auditStartTime = System.currentTimeMillis();


    private static class CustNotesAndEmails {
        private String acctNum;
        private List<String> custNotes = new ArrayList<>(5);
        private List<EmailInfoImpl> emails = new ArrayList<>(5);

        public String getAcctNum() {
            return acctNum;
        }

        public void setAcctNum(String acctNum) {
            this.acctNum = acctNum;
        }

        public List<String> getCustNotes() {
            return custNotes;
        }

        public void addCustNote(String custNote) {
            custNotes.add(custNote);
        }

        public List<EmailInfoImpl> getEmails() {
            return emails;
        }

        public void addEmail(EmailInfoImpl email) {
            emails.add(email);
        }
    }

    private void updateKycFlag(com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest request, SetKycAcctsInfoResponse.ResponsePayload resPayload) throws Exception {
    	String methodName = "SetKycAcctsInfoOperation::updateKycFlag";  
        Map<String, Object> updParamValues = new HashMap<String, Object>();
        updParamValues.put(CustomerProfileUtil.PARTY_ID, request.getRequestPayload().getKycCustInfo().getCustId());
        updParamValues.put(CustomerProfileUtil.USER_ROLE, CustomerProfileUtil.XSL_ROLE_CODE_PRIMARY);
        updParamValues.put(CustomerProfileUtil.XSL_PERSON_LASTUPDATEDTS, JAXBJsonConverter.convert(request.getRequestPayload().getKycCustInfo().getPersonLastUpdatedTS()));
        // The response should contain the up-to-date timestamp.
        updParamValues.put(CustomerProfileUtil.XSL_BOOK_OF_BUSINESS_LASTUPDATEDTS, resPayload.getKycCustInfo().getBookOfBusLastUpdatedTS());
        updParamValues.put("trackId", UuidUtil.genUuid());
        SimpleDateFormat dateFmt = new SimpleDateFormat(CustomerProfileUtil.KYC_DATE_FMT);
        updParamValues.put(CustomerProfileUtil.XSL_KYC_LAST_UPDATE_DATE, dateFmt.format(new Date()));
        JAXBContext mtJaxBContext = JaxbUtil.getJaxbContext("com.mbnaweb.xsd.msgs.customerprofile");

        JAXBElement<CustomerProfileType> result = null;
		try {
			result = (JAXBElement<CustomerProfileType>) BackEndSrvcUtil.invokeService(
			        (String) null,
			        UPDATE_KYC,
			        UPDATE_CUSTOMER_PROFILE_RS,
			        TdOdsCustomerProfileService.TdOp_odsRetrieveCustomerProfile,
			        request.getSessionInfo().getLoginId(),
			        null,
			        null,
			        updParamValues,
			        null,
			        BackEndSrvcUtil.TDOperation.TdOdsCustomerProfileService_updateCustomerProfile,
			        mtJaxBContext);
		} catch (Exception e) {
        	String message = " KYC in TdOdsCustomerProfileService_updateCustomerProfile failed ";
			logger.error(methodName, message,e);
            throw ExceptionUtil.genRuntimeException(e);
		}
        CustomerProfileType custProf = result.getValue();
        UpdateCustomerProfileResponse resp = CustomerProfileUtil.convertForUpdate(custProf);
        resPayload.getKycCustInfo().setBookOfBusLastUpdatedTS(resp.getResponsePayload().getBookOfBusLastUpdatedTS());
    }

    private void updatePrimaryFromResponse(SetKycAcctsInfoResponse.ResponsePayload resPayload, SetKycAcctsInfoResponse pchResult, ChangeFlags changes) {
        if (pchResult.getResponsePayload().getKycCustInfo().getPersonLastUpdatedTS() != null){
        	resPayload.getKycCustInfo().setPersonLastUpdatedTS(pchResult.getResponsePayload().getKycCustInfo().getPersonLastUpdatedTS());
        }
        if (pchResult.getResponsePayload().getKycCustInfo().getBookOfBusLastUpdatedTS() != null){
        	resPayload.getKycCustInfo().setBookOfBusLastUpdatedTS(pchResult.getResponsePayload().getKycCustInfo().getBookOfBusLastUpdatedTS());
        }
        if (changes.isPhysicalAddressChanged) {
            resPayload.getKycCustInfo().setPhysicalAddressLine1(pchResult.getResponsePayload().getKycCustInfo().getPhysicalAddressLine1());
            resPayload.getKycCustInfo().setPhysicalCity(pchResult.getResponsePayload().getKycCustInfo().getPhysicalCity());
            resPayload.getKycCustInfo().setPhysicalProvince(pchResult.getResponsePayload().getKycCustInfo().getPhysicalProvince());
            resPayload.getKycCustInfo().setPhysicalPostalCode(pchResult.getResponsePayload().getKycCustInfo().getPhysicalPostalCode());
            resPayload.getKycCustInfo().setPhysicalCountry(pchResult.getResponsePayload().getKycCustInfo().getPhysicalCountry());
            resPayload.getKycCustInfo().setPhysicalLastUpdatedTS(pchResult.getResponsePayload().getKycCustInfo().getPhysicalLastUpdatedTS());
        }
        for (AccountKycInfoType kycAcct : resPayload.getKycAcctsInfo()) {
        	if(kycAcct == null){
        		continue;
        	}
            AccountKycInfoType returnedAcct = null;
            // Find the account in the response
            for (AccountKycInfoType retAcct : pchResult.getResponsePayload().getKycAcctsInfo()) {
            	if(retAcct == null){
            		continue;
            	}
                if (retAcct.getKycAcct().getAcctNum().equals(kycAcct.getKycAcct().getAcctNum())) {
                    returnedAcct = retAcct;
                    break;
                }
            }
            if (returnedAcct == null){
            	continue;
            }
            if (changes.mailingAddressChanged.contains(kycAcct.getKycAcct().getAcctNum() + PCH_DELIMITER + kycAcct.getKycCustAcctInfo().getCustId() + PCH_DELIMITER + getCardEndingForAudit(kycAcct.getKycAcct().getCardNum()))) {
                if (returnedAcct.getKycCustAcctInfo().getMailingAddressLine1() != null &&
                        returnedAcct.getKycCustAcctInfo().getMailingAddressLine1().trim().length() > 0) {
                    kycAcct.getKycCustAcctInfo().setMailingAddressLine1(returnedAcct.getKycCustAcctInfo().getMailingAddressLine1());
                    kycAcct.getKycCustAcctInfo().setMailingCity(returnedAcct.getKycCustAcctInfo().getMailingCity());
                    kycAcct.getKycCustAcctInfo().setMailingProvince(returnedAcct.getKycCustAcctInfo().getMailingProvince());
                    kycAcct.getKycCustAcctInfo().setMailingPostalCode(returnedAcct.getKycCustAcctInfo().getMailingPostalCode());
                    kycAcct.getKycCustAcctInfo().setMailingLastUpdatedTS(returnedAcct.getKycCustAcctInfo().getMailingLastUpdatedTS());
                }
            }
            if (changes.businessPhoneChanged.contains(kycAcct.getKycAcct().getAcctNum() + PCH_DELIMITER + kycAcct.getKycCustAcctInfo().getCustId() + PCH_DELIMITER + getCardEndingForAudit(kycAcct.getKycAcct().getCardNum()))) {
                kycAcct.getKycCustAcctInfo().setBusinessPhone(returnedAcct.getKycCustAcctInfo().getBusinessPhone());
                kycAcct.getKycCustAcctInfo().setBusinessPhoneLastUpdatedTS(returnedAcct.getKycCustAcctInfo().getBusinessPhoneLastUpdatedTS());
            }
            if (changes.mobilePhoneChanged.contains(kycAcct.getKycAcct().getAcctNum() + PCH_DELIMITER + kycAcct.getKycCustAcctInfo().getCustId() + PCH_DELIMITER + getCardEndingForAudit(kycAcct.getKycAcct().getCardNum()))) {
                kycAcct.getKycCustAcctInfo().setMobilePhone(returnedAcct.getKycCustAcctInfo().getMobilePhone());
                kycAcct.getKycCustAcctInfo().setMobilePhoneLastUpdatedTS(returnedAcct.getKycCustAcctInfo().getMobilePhoneLastUpdatedTS());
            }
            if (changes.homePhoneChanged.contains(kycAcct.getKycAcct().getAcctNum() + PCH_DELIMITER + kycAcct.getKycCustAcctInfo().getCustId() + PCH_DELIMITER + getCardEndingForAudit(kycAcct.getKycAcct().getCardNum()))) {
                kycAcct.getKycCustAcctInfo().setHomePhone(returnedAcct.getKycCustAcctInfo().getHomePhone());
                kycAcct.getKycCustAcctInfo().setHomePhoneLastUpdatedTS(returnedAcct.getKycCustAcctInfo().getHomePhoneLastUpdatedTS());
            }
        }
    }
    private void updateAuFromResponse(SetKycAcctsInfoResponse.ResponsePayload resPayload, SetKycAcctsInfoResponse auResult, ChangeFlags changes) {
    	if(auResult == null || auResult.getResponsePayload() == null|| auResult.getResponsePayload().getKycAcctsInfo() == null){
    		return;
    	}
        for (AccountKycInfoType returnedAcct : auResult.getResponsePayload().getKycAcctsInfo()) {
        	if(returnedAcct == null){
        		continue;
        	}
            AccountKycInfoType kycAcct = null;
            // Find the account in the response
            for (AccountKycInfoType acct : resPayload.getKycAcctsInfo()) {
            	if(acct == null){
            		continue;
            	}
                if (returnedAcct.getKycAcct().getAcctNum().equals(acct.getKycAcct().getAcctNum())) {
                    kycAcct = acct;
                    break;
                }
            }

            // If there is no match in the original account list, skip it.
            if (kycAcct == null){
            	continue;
            }

            // If there is no address information returned, skip it.
            AccountKycAuInfoType returnedAu = returnedAcct.getKycAuthorizeUsers().get(0);
            if (returnedAu == null){
            	continue;
            }

            // Find the authorized user
            for (AccountKycAuInfoType au : kycAcct.getKycAuthorizeUsers()) {
            	if(au == null){
            		continue;
            	}
                if (au.getKycAuCustAcctInfo().getCustId().equals(returnedAu.getKycAuCustAcctInfo().getCustId())) {
                    if (changes.mailingAddressChanged.contains(kycAcct.getKycAcct().getAcctNum() + AU_DELIMITER + au.getKycAuCustAcctInfo().getCustId() + AU_DELIMITER + getCardEndingForAudit(au.getKycAuCustAcctInfo().getCardNum()))) {
                        au.getKycAuCustAcctInfo().setMailingAddressLine1(returnedAu.getKycAuCustAcctInfo().getMailingAddressLine1());
                        au.getKycAuCustAcctInfo().setMailingAddressLine2(returnedAu.getKycAuCustAcctInfo().getMailingAddressLine2());
                        au.getKycAuCustAcctInfo().setMailingCity(returnedAu.getKycAuCustAcctInfo().getMailingCity());
                        au.getKycAuCustAcctInfo().setMailingProvince(returnedAu.getKycAuCustAcctInfo().getMailingProvince());
                        au.getKycAuCustAcctInfo().setMailingPostalCode(returnedAu.getKycAuCustAcctInfo().getMailingPostalCode());
                        au.getKycAuCustAcctInfo().setMailingLastUpdatedTS(returnedAu.getKycAuCustAcctInfo().getMailingLastUpdatedTS());
                    }
                    if (changes.businessPhoneChanged.contains(kycAcct.getKycAcct().getAcctNum() + AU_DELIMITER + au.getKycAuCustAcctInfo().getCustId() + AU_DELIMITER + getCardEndingForAudit(au.getKycAuCustAcctInfo().getCardNum()))) {
                        au.getKycAuCustAcctInfo().setBusinessPhone(returnedAu.getKycAuCustAcctInfo().getBusinessPhone());
                        au.getKycAuCustAcctInfo().setBusinessPhoneLastUpdatedTS(returnedAu.getKycAuCustAcctInfo().getBusinessPhoneLastUpdatedTS());
                    }
                    if (changes.mobilePhoneChanged.contains(kycAcct.getKycAcct().getAcctNum() + AU_DELIMITER + au.getKycAuCustAcctInfo().getCustId() + AU_DELIMITER + getCardEndingForAudit(au.getKycAuCustAcctInfo().getCardNum()))) {
                        au.getKycAuCustAcctInfo().setMobilePhone(returnedAu.getKycAuCustAcctInfo().getMobilePhone());
                        au.getKycAuCustAcctInfo().setMobilePhoneLastUpdatedTS(returnedAu.getKycAuCustAcctInfo().getMobilePhoneLastUpdatedTS());
                    }
                    if (changes.homePhoneChanged.contains(kycAcct.getKycAcct().getAcctNum() + AU_DELIMITER + au.getKycAuCustAcctInfo().getCustId() + AU_DELIMITER + getCardEndingForAudit(au.getKycAuCustAcctInfo().getCardNum()))) {
                        au.getKycAuCustAcctInfo().setHomePhone(returnedAu.getKycAuCustAcctInfo().getHomePhone());
                        au.getKycAuCustAcctInfo().setHomePhoneLastUpdatedTS(returnedAu.getKycAuCustAcctInfo().getHomePhoneLastUpdatedTS());
                    }
                }

            }
        }

    }

    private TEnvUpdateCustomerProfileRq combineRequest(List<TEnvUpdateCustomerProfileRq> reqList) {
        TEnvUpdateCustomerProfileRq firstReq = reqList.get(0);
        if (reqList.size() <= 1){
        	return firstReq;
        }
        TSvcUpdateCustomerProfileRq req = (TSvcUpdateCustomerProfileRq) firstReq.getAbstractBusinessSvcRq().getValue();
        for (int i = 1; i < reqList.size(); i++) {
            TSvcUpdateCustomerProfileRq moreReq = (TSvcUpdateCustomerProfileRq) reqList.get(i).getAbstractBusinessSvcRq().getValue();
            req.getPerson().getPartyAgreement().addAll(moreReq.getPerson().getPartyAgreement());
        }
        return firstReq;
    }


    private com.td.mbna.msec.midtier.customerprofile.payload.getkycacctsinfo.GetKycAcctsInfoResponse getCurrentKycAcctsInfo(final com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest request) {
        com.td.mbna.msec.midtier.customerprofile.payload.getkycacctsinfo.GetKycAcctsInfoRequest getKycAcctsInfoRequest = new com.td.mbna.msec.midtier.customerprofile.payload.getkycacctsinfo.GetKycAcctsInfoRequest();
        String[] skipProperties = new String[1];
        skipProperties[0] = "requestPayload";
        BeanUtils.copyProperties(request, getKycAcctsInfoRequest, skipProperties);
        com.td.mbna.msec.midtier.customerprofile.payload.getkycacctsinfo.RequestPayload rcpPayload = new com.td.mbna.msec.midtier.customerprofile.payload.getkycacctsinfo.RequestPayload();
        getKycAcctsInfoRequest.setRequestPayload(rcpPayload);
        List<com.td.mbna.msec.midtier.types.common.CustAcctType> kycNeededAccts = rcpPayload.getKycNeededAccts();
        for (com.td.mbna.msec.midtier.customerprofile.payload.AccountKycInfoType acctInfo : request.getRequestPayload().getKycAcctsInfo()) {
        	if(acctInfo==null){
        		continue;
        	}
            kycNeededAccts.add(acctInfo.getKycAcct());
        }
        return getKycAcctsInfoOperation.invokeService(getKycAcctsInfoRequest);
    }

    private boolean updatePrimaryCardHolderInfo(ParallelServiceCaller updateUserSvcCaller, SetKycAcctsInfoRequest newUserInfo, GetKycAcctsInfoResponse currentKyc, ChangeFlags changes, CustNotesAndEmails custLevelNotesAndEmails, List<CustNotesAndEmails> allCustAcctNotesAndEmails) throws BusinessException {
        // Compare the login user Physical Address, Employment Info
    	String methodName = "SetKycAcctsInfoOperation::updatePrimaryCardHolderInfo"; 
    	if(currentKyc == null || currentKyc.getResponsePayload() == null || currentKyc.getResponsePayload().getKycCustInfo() == null){
    		return false;
    	}
    	if(newUserInfo == null || newUserInfo.getRequestPayload() == null || newUserInfo.getRequestPayload().getKycCustInfo() == null){
    		return false;
    	}
        boolean userInfoChanged = false;
        Map<String, Object> updParamValues = new HashMap<>();
        updParamValues.put(CustomerProfileUtil.PARTY_ID, newUserInfo.getCustId());
        updParamValues.put(CustomerProfileUtil.USER_ROLE, CustomerProfileUtil.XSL_ROLE_CODE_PRIMARY);
        updParamValues.put(CustomerProfileUtil.XSL_PERSON_LASTUPDATEDTS, currentKyc.getResponsePayload().getKycCustInfo().getPersonLastUpdatedTS());
        updParamValues.put(CustomerProfileUtil.XSL_BOOK_OF_BUSINESS_LASTUPDATEDTS, currentKyc.getResponsePayload().getKycCustInfo().getBookOfBusLastUpdatedTS());
        updParamValues.put("trackId", UuidUtil.genUuid());
        SimpleDateFormat dateFmt = new SimpleDateFormat(CustomerProfileUtil.START_DATE_FMT);
        updParamValues.put(CustomerProfileUtil.XSL_START_DATE, dateFmt.format(new Date()));

        CustomerInfoType userNewInfo = newUserInfo.getRequestPayload().getKycCustInfo();
        CustomerInfoType userCurInfo = currentKyc.getResponsePayload().getKycCustInfo();

        if (!CustomerProfileUtil.compareUpdateTS(userNewInfo.getPhysicalLastUpdatedTS(), userCurInfo.getPhysicalLastUpdatedTS()) ||
                !CustomerProfileUtil.compareUpdateTS(userNewInfo.getEmploymentLastUpdatedTS(), userCurInfo.getEmploymentLastUpdatedTS())) {
            com.mbnaweb.xsd.types.common.BusinessException faultInfo = new com.mbnaweb.xsd.types.common.BusinessException();
            faultInfo.setErrorDescription(ErrorCode);
            faultInfo.setErrorCode(ErrorCode);
            faultInfo.setErrorSource("SetKycAcctsInfoOperationRealImpl");
            String message = "SetKycAcctsInfo timestamp mismatch";
			logger.error(methodName, message);
            BusinessException businessError = new BusinessException(message, faultInfo);
            throw businessError;
        }

        // Physical Address
        if (!CustomerProfileUtil.compareField(userNewInfo.getPhysicalAddressLine1(), userCurInfo.getPhysicalAddressLine1()) ||
                !CustomerProfileUtil.compareField(userNewInfo.getPhysicalCity(), userCurInfo.getPhysicalCity()) ||
                !CustomerProfileUtil.compareField(userNewInfo.getPhysicalPostalCode(), userCurInfo.getPhysicalPostalCode()) ||
                !CustomerProfileUtil.compareField(userNewInfo.getPhysicalCountry(), userCurInfo.getPhysicalCountry()) ||
                !CustomerProfileUtil.compareField(userNewInfo.getPhysicalProvince(), userCurInfo.getPhysicalProvince())) {
            updParamValues.put(CustomerProfileUtil.XSL_IS_PHYSICALADDRESS_CHANGED, "true");
            setupPhysicalAddressParam(updParamValues, userNewInfo, userCurInfo);
            userInfoChanged = true;
            changes.isPhysicalAddressChanged = true;
            addCustomerNotes(CustomerProfileUtil.XSL_IS_PHYSICALADDRESS_CHANGED, userCurInfo, userNewInfo, custLevelNotesAndEmails);
        } else {
            updParamValues.put(CustomerProfileUtil.XSL_IS_PHYSICALADDRESS_CHANGED, "false");
        }

        // Employment Information
        if (!CustomerProfileUtil.compareField(userNewInfo.getEmploymentStatus(), userCurInfo.getEmploymentStatus()) ||
                !CustomerProfileUtil.compareField(userNewInfo.getOccupation(), userCurInfo.getOccupation()) ||
                !CustomerProfileUtil.compareField(userNewInfo.getNatureOfBusiness(), userCurInfo.getNatureOfBusiness()) ||
                !CustomerProfileUtil.compareField(userNewInfo.getPosition(), userCurInfo.getPosition())) {
            updParamValues.put(CustomerProfileUtil.XSL_IS_EMPLOYMENT_CHANGED, "true");
            setupEmploymentParam(updParamValues, userNewInfo, userCurInfo);
            userInfoChanged = true;
            changes.isEmployementChanged = true;
            addCustomerNotes(CustomerProfileUtil.XSL_IS_EMPLOYMENT_CHANGED, userCurInfo, userNewInfo, custLevelNotesAndEmails);
        } else {
            updParamValues.put(CustomerProfileUtil.XSL_IS_EMPLOYMENT_CHANGED, "false");
        }
        // Generate the CODS request and add the account change information.
        TEnvUpdateCustomerProfileRq generatedReq = null;
        TSvcUpdateCustomerProfileRq req = null;
        try {
            generatedReq = (TEnvUpdateCustomerProfileRq) BackEndSrvcUtil.genRequest2(null, TdOp_setKycAcctsInfo, updParamValues, null, BackEndSrvcUtil.TDOperation.TdOdsCustomerProfileService_updateCustomerProfile);
            req = (TSvcUpdateCustomerProfileRq) generatedReq.getAbstractBusinessSvcRq().getValue();
        } catch (Exception e) {
        	String message = "TdOdsCustomerProfileService_updateCustomerProfile::TdOp_setKycAcctsInfo failed";
			logger.error(methodName, message,e);
            throw ExceptionUtil.genRuntimeException(e);

        }

        int i = 0;

        // For each account, compare the mailing address,  and phones
        for (AccountKycInfoType newAcct : newUserInfo.getRequestPayload().getKycAcctsInfo()) {
        	if(newAcct == null){
        		continue;
        	}
            MutableBoolean addressChangeEmailAdded = new MutableBoolean(false);
            MutableBoolean phoneChangeEmailAdded = new MutableBoolean(false);
            CustNotesAndEmails acctNotesAndEmails = new CustNotesAndEmails();
            acctNotesAndEmails.setAcctNum(newAcct.getKycAcct().getAcctNum());
            allCustAcctNotesAndEmails.add(acctNotesAndEmails);
            if (i++ == 0) {    // only send email for physical address one time since it's a customer level data
                if (changes.isPhysicalAddressChanged) {
                    changes.physicalAddressChanged.add(newAcct.getKycAcct().getAcctNum() + PCH_DELIMITER + newAcct.getKycCustAcctInfo().getCustId() + PCH_DELIMITER + getCardEndingForAudit(newAcct.getKycAcct().getCardNum()));
                    addEmailNotification(newUserInfo, CustomerProfileUtil.XSL_IS_PHYSICALADDRESS_CHANGED, newAcct, acctNotesAndEmails, addressChangeEmailAdded);
                }
            }
            if (changes.isEmployementChanged) {
                changes.employmentChanged.add(newAcct.getKycAcct().getAcctNum() + PCH_DELIMITER + newAcct.getKycCustAcctInfo().getCustId() + PCH_DELIMITER + getCardEndingForAudit(newAcct.getKycAcct().getCardNum()));
            }
            // Find the corresponding account in the current state.
            AccountKycInfoType curAcct = null;
            for (AccountKycInfoType currentAcct : currentKyc.getResponsePayload().getKycAcctsInfo()) {
            	if(currentAcct == null){
            		continue;
            	}
                if (newAcct.getKycAcct().getAcctNum().equals(currentAcct.getKycAcct().getAcctNum())) {
                    curAcct = currentAcct;
                }
            }
            CustomerAcctInfoType curCustAcct = curAcct.getKycCustAcctInfo();
            CustomerAcctInfoType newCustAcct = newAcct.getKycCustAcctInfo();
            TPartyAgreement partyAgreement = null;

            // Compare the fields
            if (!CustomerProfileUtil.compareUpdateTS(curCustAcct.getMailingLastUpdatedTS(),
                    newCustAcct.getMailingLastUpdatedTS()) ||
                    !CustomerProfileUtil.compareUpdateTS(curCustAcct.getMailingArgLocLastUpdatedTS(),
                            newCustAcct.getMailingArgLocLastUpdatedTS()) ||
                    !CustomerProfileUtil.compareUpdateTS(curCustAcct.getBusinessPhoneLastUpdatedTS(),
                            newCustAcct.getBusinessPhoneLastUpdatedTS()) ||
                    !CustomerProfileUtil.compareUpdateTS(curCustAcct.getMobilePhoneLastUpdatedTS(),
                            newCustAcct.getMobilePhoneLastUpdatedTS()) ||
                    !CustomerProfileUtil.compareUpdateTS(curCustAcct.getHomePhoneLastUpdatedTS(),
                            newCustAcct.getHomePhoneLastUpdatedTS())
            ) {
                com.mbnaweb.xsd.types.common.BusinessException faultInfo = new com.mbnaweb.xsd.types.common.BusinessException();
                faultInfo.setErrorDescription(ErrorCode);
                faultInfo.setErrorCode(ErrorCode);
                faultInfo.setErrorSource("SetKycAcctsInfoOperationRealImpl");
            	String message = "SetKycAcctsInfo timestamp mismatch";
    			logger.error(methodName, message);
                BusinessException businessError = new BusinessException(message, faultInfo);
                throw businessError;
            }
            // Check account mailing address
            if (!CustomerProfileUtil.compareField(curCustAcct.getMailingAddressLine1(), newCustAcct.getMailingAddressLine1()) ||
                    !CustomerProfileUtil.compareField(curCustAcct.getMailingAddressLine2(), newCustAcct.getMailingAddressLine2()) ||
                    !CustomerProfileUtil.compareField(curCustAcct.getMailingCity(), newCustAcct.getMailingCity()) ||
                    !CustomerProfileUtil.compareField(curCustAcct.getMailingProvince(), newCustAcct.getMailingProvince()) ||
                    !CustomerProfileUtil.compareField(curCustAcct.getMailingPostalCode(), newCustAcct.getMailingPostalCode())
            ) {
                if (partyAgreement == null) {
                    partyAgreement = createPartyAgreement(newAcct);
                    req.getPerson().getPartyAgreement().add(partyAgreement);
                }
                userInfoChanged = true;
                changes.mailingAddressChanged.add(newAcct.getKycAcct().getAcctNum() + PCH_DELIMITER + newAcct.getKycCustAcctInfo().getCustId() + PCH_DELIMITER + getCardEndingForAudit(newAcct.getKycAcct().getCardNum()));
                // partyAgreement.
                setAccountMailingAddress(newAcct, partyAgreement);
                addCustomerNotes(CustomerProfileUtil.XSL_IS_MAILINGADDRESS_CHANGED, curCustAcct, newCustAcct, acctNotesAndEmails);
                addEmailNotification(newUserInfo, CustomerProfileUtil.XSL_IS_MAILINGADDRESS_CHANGED, newAcct, acctNotesAndEmails, addressChangeEmailAdded);
            }
            // Check the business phone
            if (!CustomerProfileUtil.compareUpdateTS(curCustAcct.getBusinessPhoneLastUpdatedTS(), newCustAcct.getBusinessPhoneLastUpdatedTS()) ||
                    !CustomerProfileUtil.compareUpdateTS(curCustAcct.getMobilePhoneLastUpdatedTS(), newCustAcct.getMobilePhoneLastUpdatedTS()) ||
                    !CustomerProfileUtil.compareUpdateTS(curCustAcct.getHomePhoneLastUpdatedTS(), newCustAcct.getHomePhoneLastUpdatedTS())) {
                com.mbnaweb.xsd.types.common.BusinessException faultInfo = new com.mbnaweb.xsd.types.common.BusinessException();
                faultInfo.setErrorDescription(ErrorCode);
                faultInfo.setErrorCode(ErrorCode);
                faultInfo.setErrorSource("SetKycAcctsInfoOperationRealImpl");
                String message = "SetKycAcctsInfo timestamp mismatch";
    			logger.error(methodName, message);
                BusinessException businessError = new BusinessException(message, faultInfo);
                throw businessError;
            }
            if (!CustomerProfileUtil.compareField(curCustAcct.getBusinessPhone(), newCustAcct.getBusinessPhone())) {
                if (partyAgreement == null) {
                    partyAgreement = createPartyAgreement(newAcct);
                    req.getPerson().getPartyAgreement().add(partyAgreement);
                }
                userInfoChanged = true;
                changes.businessPhoneChanged.add(newAcct.getKycAcct().getAcctNum() + PCH_DELIMITER + newAcct.getKycCustAcctInfo().getCustId() + PCH_DELIMITER + getCardEndingForAudit(newAcct.getKycAcct().getCardNum()));
                setAccountBusinessPhoneNumber(newAcct, partyAgreement);
                addCustomerNotes(CustomerProfileUtil.XSL_IS_BUSINESSPHONE_CHANGED, curCustAcct, newCustAcct, acctNotesAndEmails);
                addEmailNotification(newUserInfo, CustomerProfileUtil.XSL_IS_BUSINESSPHONE_CHANGED, newAcct, acctNotesAndEmails, phoneChangeEmailAdded);
            }
            if (!CustomerProfileUtil.compareField(curCustAcct.getMobilePhone(), newCustAcct.getMobilePhone())) {
                if (partyAgreement == null) {
                    partyAgreement = createPartyAgreement(newAcct);
                    req.getPerson().getPartyAgreement().add(partyAgreement);
                }
                userInfoChanged = true;
                changes.mobilePhoneChanged.add(newAcct.getKycAcct().getAcctNum() + PCH_DELIMITER + newAcct.getKycCustAcctInfo().getCustId() + PCH_DELIMITER + getCardEndingForAudit(newAcct.getKycAcct().getCardNum()));
                setAccountMobilePhoneNumber(newAcct, partyAgreement);
                addCustomerNotes(CustomerProfileUtil.XSL_IS_MOBILEPHONE_CHANGED, curCustAcct, newCustAcct, acctNotesAndEmails);
                addEmailNotification(newUserInfo, CustomerProfileUtil.XSL_IS_MOBILEPHONE_CHANGED, newAcct, acctNotesAndEmails, phoneChangeEmailAdded);
            }
            if (!CustomerProfileUtil.compareField(curCustAcct.getHomePhone(), newCustAcct.getHomePhone())) {
                if (partyAgreement == null) {
                    partyAgreement = createPartyAgreement(newAcct);
                    req.getPerson().getPartyAgreement().add(partyAgreement);
                }
                userInfoChanged = true;
                changes.homePhoneChanged.add(newAcct.getKycAcct().getAcctNum() + PCH_DELIMITER + newAcct.getKycCustAcctInfo().getCustId() + PCH_DELIMITER + getCardEndingForAudit(newAcct.getKycAcct().getCardNum()));
                setAccountHomePhoneNumber(newAcct, partyAgreement);
                addCustomerNotes(CustomerProfileUtil.XSL_IS_HOMEPHONE_CHANGED, curCustAcct, newCustAcct, acctNotesAndEmails);
                addEmailNotification(newUserInfo, CustomerProfileUtil.XSL_IS_HOMEPHONE_CHANGED, newAcct, acctNotesAndEmails, phoneChangeEmailAdded);
            }

        }
        final TEnvUpdateCustomerProfileRq reqObj = generatedReq;


        final com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest requestForAuditLog = JAXBJsonConverter.convertoJAXBToJsonInterface(newUserInfo,com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest.class);
        
        final String loginId = newUserInfo.getSessionInfo().getLoginId();
        
        ServiceCall<?> updPrimaryCall = new ServiceCall<SetKycAcctsInfoResponse>() {
        	@Override
        	public SetKycAcctsInfoResponse invoke() throws Exception {
        		SetKycAcctsInfoResponse resp = null;
        		try {
        			resp = callUpdateWS(loginId, reqObj);
        		} catch (Exception e) {
        			genAuditLog(requestForAuditLog, "SS2524", null, loginId, null);
        			String message = "callUpdateWS(loginId, reqObj) failed";
        			logger.error(methodName, message, e);
        			throw e;
        		}
        		return resp;
        	}
        };
        
        try {
        	if (userInfoChanged) {
        		updateUserSvcCaller.scheduleCall(loginId, updPrimaryCall);
        	}
        } catch (Exception e) {
        	String message = "updateUserSvcCaller.scheduleCall(loginId, updPrimaryCall) failed";
			logger.error(methodName, message, e);
        	throw ExceptionUtil.genRuntimeException(e);
        	
        }
//        try {
//
//
//        } catch (Exception e) {
//            logger.error("",e.getLocalizedMessage(),e);
//            MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,GENERAL_ERROR);
//        }

        return userInfoChanged;
    }

    private void setAccountBusinessPhoneNumber(AccountKycInfoType acct, TPartyAgreement partyAgreement) {
        TPartyAgreementLocator partyLoc = new TPartyAgreementLocator();
        partyAgreement.getPartyAgreementLocator().add(partyLoc);
        partyLoc.setLastUpdatedTS(acct.getKycCustAcctInfo().getBusinessPhoneLocLastUpdatedTS());
        partyLoc.setPartyAgreementLocatorUsageTypeCd("WORK");
        partyLoc.setAddressSubtypeCd("PHONE");
        ObjectFactory factory = new ObjectFactory();
        TTelephoneNumber phone = new TTelephoneNumber();
        partyLoc.setTelephoneNumber(phone);
        phone.setTelephoneNum(acct.getKycCustAcctInfo().getBusinessPhone());
        phone.setLastUpdatedTS(acct.getKycCustAcctInfo().getBusinessPhoneLastUpdatedTS());
        if (acct.getKycCustAcctInfo().getBusinessPhone() == null ||  acct.getKycCustAcctInfo().getBusinessPhone().trim().length() == 0) {
            phone.setTelephoneNum("");
            phone.setLastUpdatedTS(null);
            partyLoc.setLastUpdatedTS(null);
        }
        JAXBElement<XMLGregorianCalendar> startDt = factory.createTPartyAgreementLocatorPartyAgreementLocatorStartDt(CustomerProfileUtil.getXMLGregorianCalendarNowForDate());
        partyLoc.setPartyAgreementLocatorStartDt(startDt);
    }

    private void setAccountMobilePhoneNumber(AccountKycInfoType acct, TPartyAgreement partyAgreement) {
        TPartyAgreementLocator partyLoc = new TPartyAgreementLocator();
        partyAgreement.getPartyAgreementLocator().add(partyLoc);
        partyLoc.setLastUpdatedTS(acct.getKycCustAcctInfo().getMobilePhoneLocLastUpdatedTS());
        partyLoc.setPartyAgreementLocatorUsageTypeCd("MOBILE");
        partyLoc.setAddressSubtypeCd("PHONE");
        ObjectFactory factory = new ObjectFactory();

        TTelephoneNumber phone = new TTelephoneNumber();
        phone.setLastUpdatedTS(acct.getKycCustAcctInfo().getMobilePhoneLastUpdatedTS());
        partyLoc.setTelephoneNumber(phone);
        phone.setTelephoneNum(acct.getKycCustAcctInfo().getMobilePhone());
        if (acct.getKycCustAcctInfo().getMobilePhone() == null || acct.getKycCustAcctInfo().getMobilePhone().trim().length() == 0) {
            phone.setTelephoneNum("");
            phone.setLastUpdatedTS(null);
            partyLoc.setLastUpdatedTS(null);
        }
        JAXBElement<XMLGregorianCalendar> startDt = factory.createTPartyAgreementLocatorPartyAgreementLocatorStartDt(CustomerProfileUtil.getXMLGregorianCalendarNowForDate());
        partyLoc.setPartyAgreementLocatorStartDt(startDt);
    }

    private void setAccountHomePhoneNumber(AccountKycInfoType acct, TPartyAgreement partyAgreement) {
        TPartyAgreementLocator partyLoc = new TPartyAgreementLocator();
        partyAgreement.getPartyAgreementLocator().add(partyLoc);
        partyLoc.setLastUpdatedTS(acct.getKycCustAcctInfo().getHomePhoneLocLastUpdatedTS());
        partyLoc.setPartyAgreementLocatorUsageTypeCd("HOME");
        partyLoc.setAddressSubtypeCd("PHONE");
        ObjectFactory factory = new ObjectFactory();
        TTelephoneNumber phone = new TTelephoneNumber();
        partyLoc.setTelephoneNumber(phone);
        phone.setLastUpdatedTS(acct.getKycCustAcctInfo().getHomePhoneLastUpdatedTS());
        phone.setTelephoneNum(acct.getKycCustAcctInfo().getHomePhone());
        if (acct.getKycCustAcctInfo().getHomePhone() == null ||  acct.getKycCustAcctInfo().getHomePhone().trim().length() == 0) {
            phone.setTelephoneNum("");
            phone.setLastUpdatedTS(null);
            partyLoc.setLastUpdatedTS(null);
        }
        JAXBElement<XMLGregorianCalendar> startDt = factory.createTPartyAgreementLocatorPartyAgreementLocatorStartDt(CustomerProfileUtil.getXMLGregorianCalendarNowForDate());
        partyLoc.setPartyAgreementLocatorStartDt(startDt);
    }

    private void setAccountMailingAddress(AccountKycInfoType acct, TPartyAgreement partyAgreement) {
        TPartyAgreementLocator partyLoc = new TPartyAgreementLocator();
        partyAgreement.getPartyAgreementLocator().add(partyLoc);
        partyLoc.setLastUpdatedTS(acct.getKycCustAcctInfo().getMailingArgLocLastUpdatedTS());
        partyLoc.setPartyAgreementLocatorUsageTypeCd("BILLING");
        partyLoc.setAddressSubtypeCd("STREET-ADDRESS");
        TStreetAddress address = new TStreetAddress();
        partyLoc.setStreetAddress(address);
        address.setAddressLine1Txt(acct.getKycCustAcctInfo().getMailingAddressLine1());
        address.setAddressLine2Txt(acct.getKycCustAcctInfo().getMailingAddressLine2());
        address.setCityId(acct.getKycCustAcctInfo().getMailingCity());
        address.setTerritoryId(acct.getKycCustAcctInfo().getMailingProvince());
        address.setPostalCodeId(acct.getKycCustAcctInfo().getMailingPostalCode());
        address.setCountryId("CA");
        address.setLastUpdatedTS(acct.getKycCustAcctInfo().getMailingLastUpdatedTS());
        ObjectFactory factory = new ObjectFactory();
        JAXBElement<XMLGregorianCalendar> startDt = factory.createTPartyAgreementLocatorPartyAgreementLocatorStartDt(CustomerProfileUtil.getXMLGregorianCalendarNowForDate());
        partyLoc.setPartyAgreementLocatorStartDt(startDt);
    }

    private TPartyAgreement createPartyAgreement(AccountKycInfoType acct) {
        TPartyAgreement partyAgreement = new TPartyAgreement();
        partyAgreement.setPartyAgreementRoleCd(CustomerProfileUtil.XSL_ROLE_CODE_PRIMARY);
        partyAgreement.setPartyAgreementHostPartyId(acct.getKycAcct().getCardHolder().getAliasCustomerID());
        partyAgreement.setLastUpdatedTS(acct.getKycCustAcctInfo().getPartyAgreementLastUpdatedTS());
        TCreditCardAgreement creditCardAgreement = new TCreditCardAgreement();
        partyAgreement.setCreditCardAgreement(creditCardAgreement);
        creditCardAgreement.setHostAgreementNum(acct.getKycAcct().getAcctNum());
        creditCardAgreement.setSourceSystemTypeCd(CustomerProfileUtil.XSL_SOURCE_SYSTEM_TYPE_VALUE);
        TAgreementGroup agreementGroup = new TAgreementGroup();
        creditCardAgreement.setAgreementGroup(agreementGroup);
        agreementGroup.setAgreementGroupName(CustomerProfileUtil.XSL_GROUP_NAME);
        return partyAgreement;
    }

    private void setupPhysicalAddressParam(Map<String, Object> paramValues, CustomerInfoType userNewInfo, CustomerInfoType userCurrInfo) {
        //  physical address changes
        paramValues.put(CustomerProfileUtil.XSL_PHYSICALADDRESS_LINEONE, userNewInfo.getPhysicalAddressLine1());
        paramValues.put(CustomerProfileUtil.XSL_PHYSICALADDRESS_LOCALITY, userNewInfo.getPhysicalCity());
        paramValues.put(CustomerProfileUtil.XSL_PHYSICALADDRESS_AREA, userNewInfo.getPhysicalProvince());
        paramValues.put(CustomerProfileUtil.XSL_PHYSICALADDRESS_COUNTRY, "CA"); // It has to be a Canada address
        paramValues.put(CustomerProfileUtil.XSL_PHYSICALADDRESS_POSTALCODE, userNewInfo.getPhysicalPostalCode());
        if (userCurrInfo.getPrimaryResidenceEndTS() != null) {
            paramValues.put(CustomerProfileUtil.XSL_PHYSICALADDRESS_ENDTS_NEEDED, "true");
            paramValues.put(CustomerProfileUtil.XSL_PHYSICALADDRESS_ENDTS, userCurrInfo.getPrimaryResidenceEndTS());
        } else {
            paramValues.put(CustomerProfileUtil.XSL_PHYSICALADDRESS_ENDTS_NEEDED, "false");
        }
        if (userNewInfo.getPhysicalLastUpdatedTS() != null) {
            paramValues.put(CustomerProfileUtil.XSL_IS_PHYSICALADDRESS_PRESENT, "true");
            paramValues.put(CustomerProfileUtil.XSL_PHYSICALADDRESS_PARTYLOC_ADDR_LASTUPDATEDTS, userNewInfo.getPhysicalLastUpdatedTS());
            paramValues.put(CustomerProfileUtil.XSL_PHYSICALADDRESS_PARTYLOCID, userNewInfo.getPhysicalPartyLocationID());
            paramValues.put(CustomerProfileUtil.XSL_PHYSICALADDRESS_PARTYLOC_LASTUPDATEDTS, userNewInfo.getPhysicalPartyLocationLastUpdatedTS());
        } else {
            paramValues.put(CustomerProfileUtil.XSL_IS_PHYSICALADDRESS_PRESENT, "false");
        }
    }

    private void setupEmploymentParam(Map<String, Object> paramValues, CustomerInfoType userNewInfo, CustomerInfoType userCurrInfo) {
        //  Employment changes
        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_POSITION, userNewInfo.getPosition() == null ? "" : userNewInfo.getPosition());
        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_OCCUPATION, userNewInfo.getOccupation() == null ? "" : userNewInfo.getOccupation());
        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_NATUREOFBUSINESS, userNewInfo.getNatureOfBusiness() == null ? "" : userNewInfo.getNatureOfBusiness());
        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_STATUS, userNewInfo.getEmploymentStatus() == null ? "" : userNewInfo.getEmploymentStatus());
        if (MBNAPropertiesUtil.getMBNAPropertyValue("employmentStatus.student.key").equals(userNewInfo.getEmploymentStatus()) &&
                !MBNAPropertiesUtil.getMBNAPropertyValue("employmentStatus.student.key").equals(userCurrInfo.getEmploymentStatus())) {
            // If Employment Status has been changed to "Student" then clear the NatureOfBusinessCD, Employer Address and Employer Phone fields
            // NatureOfBusinessCD should already be set to blank
            paramValues.put(CustomerProfileUtil.XSL_IS_EMPLOYMENT_INFO_CHANGED, "true");
            blankEmploymentInfoParams(paramValues);
            userNewInfo.setNatureOfBusiness(null);
        } else {
            paramValues.put(CustomerProfileUtil.XSL_IS_EMPLOYMENT_INFO_CHANGED, "false");
        }
        if ((MBNAPropertiesUtil.getMBNAPropertyValue("employmentStatus.retired.key").equals(userNewInfo.getEmploymentStatus()) ||
                MBNAPropertiesUtil.getMBNAPropertyValue("employmentStatus.homemaker.key").equals(userNewInfo.getEmploymentStatus()) ||
                MBNAPropertiesUtil.getMBNAPropertyValue("employmentStatus.unemployed.key").equals(userNewInfo.getEmploymentStatus()) ||
                MBNAPropertiesUtil.getMBNAPropertyValue("employmentStatus.disabled.key").equals(userNewInfo.getEmploymentStatus())
        ) &&
                !userNewInfo.getEmploymentStatus().equals(userCurrInfo.getEmploymentStatus())) {
            paramValues.put(CustomerProfileUtil.XSL_IS_EMPLOYMENT_INFO_CHANGED, "true");
            blankEmploymentInfoParams(paramValues);
            paramValues.put(CustomerProfileUtil.XSL_IS_EMPLOYMENT_NAME_CHANGED, "true");
            blankEmploymentNameParams(paramValues);
            blankEmploymentInfo(userNewInfo);
        } else {
            paramValues.put(CustomerProfileUtil.XSL_IS_EMPLOYMENT_INFO_CHANGED, "false");
            paramValues.put(CustomerProfileUtil.XSL_IS_EMPLOYMENT_NAME_CHANGED, "false");
        }
        if (userCurrInfo.getEmploymentLastUpdatedTS() != null) {
            paramValues.put(CustomerProfileUtil.XSL_IS_EMPLOYMENT_PRESENT, "true");
            paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_LASTUPDATEDTS, userCurrInfo.getEmploymentLastUpdatedTS());
        } else {
            paramValues.put(CustomerProfileUtil.XSL_IS_EMPLOYMENT_PRESENT, "false");
        }
    }

    private void blankEmploymentInfo(CustomerInfoType userNewInfo) { 
        userNewInfo.setOccupation(null);
        userNewInfo.setNatureOfBusiness(null);
        userNewInfo.setPosition(null);
    }

    private void blankEmploymentInfoParams(Map<String, Object> paramValues) {
        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_ADDRESS_LINEONE, "");
        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_ADDRESS_LOCALITY, "");
        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_ADDRESS_AREA, "");
        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_ADDRESS_COUNTRY, "");
        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_ADDRESS_POSTALCODE, "");
        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_PHONE, "");
    }

    private void blankEmploymentNameParams(Map<String, Object> paramValues) {
        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_EMPLOYERNAME, "");
    }

    static private SetKycAcctsInfoResponse callUpdateWS(String loginId, TEnvUpdateCustomerProfileRq reqObj) throws Exception {
        Templates td2mtResTranformer = TransformUtil.getRsTemplate(SET_KYC_PCH_ACCT);
        TEnvUpdateCustomerProfileRs res = TdOdsCustomerProfileService.updateCustomer(reqObj);
        SetKycAcctsInfoResponse response = TransformUtil.transformRequest(td2mtResTranformer, res, null, SetKycAcctsInfoResponse.class);
        return response;
    }

    static private SetKycAcctsInfoResponse callUpdateAuWS(String loginId, TEnvUpdateCustomerProfileRq reqObj) throws Exception {
        Templates td2mtResTranformer = TransformUtil.getRsTemplate(SET_KYC_AU_ACCT);
        TEnvUpdateCustomerProfileRs res = TdOdsCustomerProfileService.updateCustomer(reqObj);
        SetKycAcctsInfoResponse response = TransformUtil.transformRequest(td2mtResTranformer, res, null, SetKycAcctsInfoResponse.class);
        return response;
    }

    private boolean updateAuthorizedUserInfo(Map<String, List<TEnvUpdateCustomerProfileRq>> authorizedUsersReq, SetKycAcctsInfoRequest newUserInfo, AccountKycInfoType acctInfo, AccountKycAuInfoType auInfo, AccountKycAuInfoType currAuInfo, CustNotesAndEmails custNotesAndEmails, ChangeFlags changes) throws BusinessException {
    	String methodName = "SetKycAcctsInfoOperation::updateAuthorizedUserInfo"; 
    	boolean userInfoChanged = false;
        MutableBoolean phoneChangeEmailAdded = new MutableBoolean(false);
        Map<String, Object> updParamValues = new HashMap<String, Object>();
        updParamValues.put(CustomerProfileUtil.PARTY_ID, auInfo.getKycAuCustAcctInfo().getCustId());
        updParamValues.put(CustomerProfileUtil.USER_ROLE, CustomerProfileUtil.XSL_ROLE_CODE_AUTHORIZED);
        updParamValues.put(CustomerProfileUtil.ACCOUNT_NUMBER, auInfo.getKycAuCustAcctInfo().getAcctNum());
        updParamValues.put(CustomerProfileUtil.ALIAS_CUSTOMER_ID, auInfo.getKycAliasCustomerID());
        updParamValues.put(CustomerProfileUtil.XSL_PERSON_LASTUPDATEDTS, currAuInfo.getKycPersonLastUpdatedTS());
        updParamValues.put(CustomerProfileUtil.XSL_BOOK_OF_BUSINESS_LASTUPDATEDTS, currAuInfo.getKycBookOfBusLastUpdatedTS());
        updParamValues.put(CustomerProfileUtil.XSL_PARTYAGREEMENT_LASTUPDATEDTS, currAuInfo.getKycAuCustAcctInfo().getPartyAgreementLastUpdatedTS());
        updParamValues.put("trackId", UuidUtil.genUuid());
        SimpleDateFormat dateFmt = new SimpleDateFormat(CustomerProfileUtil.START_DATE_FMT);
        updParamValues.put(CustomerProfileUtil.XSL_START_DATE, dateFmt.format(new Date()));

        // Making sure we have the correct time stamp before submitting.
        if (!CustomerProfileUtil.compareUpdateTS(currAuInfo.getKycAuCustAcctInfo().getMailingLastUpdatedTS(), auInfo.getKycAuCustAcctInfo().getMailingLastUpdatedTS()) ||
                !CustomerProfileUtil.compareUpdateTS(currAuInfo.getKycAuCustAcctInfo().getBusinessPhoneLastUpdatedTS(), auInfo.getKycAuCustAcctInfo().getBusinessPhoneLastUpdatedTS()) ||
                !CustomerProfileUtil.compareUpdateTS(currAuInfo.getKycAuCustAcctInfo().getMobilePhoneLastUpdatedTS(), auInfo.getKycAuCustAcctInfo().getMobilePhoneLastUpdatedTS()) ||
                !CustomerProfileUtil.compareUpdateTS(currAuInfo.getKycAuCustAcctInfo().getHomePhoneLastUpdatedTS(), auInfo.getKycAuCustAcctInfo().getHomePhoneLastUpdatedTS())) {
            com.mbnaweb.xsd.types.common.BusinessException faultInfo = new com.mbnaweb.xsd.types.common.BusinessException();
            faultInfo.setErrorDescription(ErrorCode);
            faultInfo.setErrorCode(ErrorCode);
            faultInfo.setErrorSource("SetKycAcctsInfoOperationRealImpl");
            BusinessException businessError = new BusinessException("SetKycAcctsInfo timestamp mismatch", faultInfo);
            throw businessError;
        }

        updParamValues.put(CustomerProfileUtil.XSL_IS_MAILINGADDRESS_CHANGED, "false");
        // Setup MAILING(BILLING) Address;
        if (!CustomerProfileUtil.compareField(currAuInfo.getKycAuCustAcctInfo().getMailingAddressLine1(), auInfo.getKycAuCustAcctInfo().getMailingAddressLine1()) ||
                !CustomerProfileUtil.compareField(currAuInfo.getKycAuCustAcctInfo().getMailingAddressLine2(), auInfo.getKycAuCustAcctInfo().getMailingAddressLine2()) ||
                !CustomerProfileUtil.compareField(currAuInfo.getKycAuCustAcctInfo().getMailingCity(), auInfo.getKycAuCustAcctInfo().getMailingCity()) ||
                !CustomerProfileUtil.compareField(currAuInfo.getKycAuCustAcctInfo().getMailingProvince(), auInfo.getKycAuCustAcctInfo().getMailingProvince()) ||
                !CustomerProfileUtil.compareField(currAuInfo.getKycAuCustAcctInfo().getMailingPostalCode(), auInfo.getKycAuCustAcctInfo().getMailingPostalCode())) {
            userInfoChanged = true;
            changes.mailingAddressChanged.add(acctInfo.getKycAcct().getAcctNum() + AU_DELIMITER + auInfo.getKycAuCustAcctInfo().getCustId() + AU_DELIMITER + getCardEndingForAudit(auInfo.getKycAuCustAcctInfo().getCardNum()));
            addCustomerNotes(CustomerProfileUtil.XSL_IS_MAILINGADDRESS_CHANGED, currAuInfo, auInfo, custNotesAndEmails);
            addEmailNotification(newUserInfo, CustomerProfileUtil.XSL_IS_MAILINGADDRESS_CHANGED, acctInfo, custNotesAndEmails, null);
            updParamValues.put(CustomerProfileUtil.XSL_IS_MAILINGADDRESS_CHANGED, "true");
            if (currAuInfo.getKycAuCustAcctInfo().getMailingLastUpdatedTS() != null) {
                updParamValues.put(CustomerProfileUtil.XSL_IS_MAILINGADDRESS_PRESENT, "true");
                updParamValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_LASTUPDATEDTS, auInfo.getKycAuCustAcctInfo().getMailingLastUpdatedTS());
                updParamValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_ARGLOC_LASTUPDATEDTS, auInfo.getKycAuCustAcctInfo().getMailingArgLocLastUpdatedTS());
            } else {
                updParamValues.put(CustomerProfileUtil.XSL_IS_MAILINGADDRESS_PRESENT, "false");

            }
            updParamValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_LINEONE, auInfo.getKycAuCustAcctInfo().getMailingAddressLine1());
            updParamValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_LINETWO, auInfo.getKycAuCustAcctInfo().getMailingAddressLine2());
            updParamValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_LOCALITY, auInfo.getKycAuCustAcctInfo().getMailingCity());
            updParamValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_AREA, auInfo.getKycAuCustAcctInfo().getMailingProvince());
            updParamValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_COUNTRY, "CA"); // It has to be a Canada address. It is not allowed to modify non-canadian address
            updParamValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_POSTALCODE, auInfo.getKycAuCustAcctInfo().getMailingPostalCode());
        }

        // Set up Business Phone:
        updParamValues.put(CustomerProfileUtil.XSL_IS_BUSINESSPHONE_CHANGED, "false");
        if (!CustomerProfileUtil.compareField(currAuInfo.getKycAuCustAcctInfo().getBusinessPhone(), auInfo.getKycAuCustAcctInfo().getBusinessPhone())) {
            userInfoChanged = true;
            changes.businessPhoneChanged.add(acctInfo.getKycAcct().getAcctNum() + AU_DELIMITER + auInfo.getKycAuCustAcctInfo().getCustId() + AU_DELIMITER + getCardEndingForAudit(auInfo.getKycAuCustAcctInfo().getCardNum()));
            addCustomerNotes(CustomerProfileUtil.XSL_IS_BUSINESSPHONE_CHANGED, currAuInfo, auInfo, custNotesAndEmails);
            addEmailNotification(newUserInfo, CustomerProfileUtil.XSL_IS_BUSINESSPHONE_CHANGED, acctInfo, custNotesAndEmails, phoneChangeEmailAdded);
            updParamValues.put(CustomerProfileUtil.XSL_IS_BUSINESSPHONE_CHANGED, "true");
            updParamValues.put(CustomerProfileUtil.XSL_BUSINESSPHONE_NUMBER, auInfo.getKycAuCustAcctInfo().getBusinessPhone());
            if (currAuInfo.getKycAuCustAcctInfo().getBusinessPhoneLastUpdatedTS() != null) {
                updParamValues.put(CustomerProfileUtil.XSL_IS_BUSINESSPHONE_PRESENT, "true");
                updParamValues.put(CustomerProfileUtil.XSL_BUSINESSPHONE_LASTUPDATEDTS, currAuInfo.getKycAuCustAcctInfo().getBusinessPhoneLastUpdatedTS());
                updParamValues.put(CustomerProfileUtil.XSL_BUSINESSPHONE_LOC_LASTUPDATEDTS, currAuInfo.getKycAuCustAcctInfo().getBusinessPhoneLocLastUpdatedTS());

                // To remove, set the endTS
                if (auInfo.getKycAuCustAcctInfo().getBusinessPhone() == null || auInfo.getKycAuCustAcctInfo().getBusinessPhone().trim().length() == 0) {
                    updParamValues.put(CustomerProfileUtil.XSL_BUSINESSPHONE_ENDTS, dateFmt.format(new Date()));
                    updParamValues.put(CustomerProfileUtil.XSL_BUSINESSPHONE_NUMBER, currAuInfo.getKycAuCustAcctInfo().getBusinessPhone());
                } else {
                    updParamValues.put(CustomerProfileUtil.XSL_BUSINESSPHONE_ENDTS, "");
                }
            } else {
                updParamValues.put(CustomerProfileUtil.XSL_IS_BUSINESSPHONE_PRESENT, "false");
            }
        }

        // Set up Mobile Phone:
        updParamValues.put(CustomerProfileUtil.XSL_IS_MOBILEPHONE_CHANGED, "false");
        if (!CustomerProfileUtil.compareField(currAuInfo.getKycAuCustAcctInfo().getMobilePhone(), auInfo.getKycAuCustAcctInfo().getMobilePhone())) {
            userInfoChanged = true;
            changes.mobilePhoneChanged.add(acctInfo.getKycAcct().getAcctNum() + AU_DELIMITER + auInfo.getKycAuCustAcctInfo().getCustId() + AU_DELIMITER + getCardEndingForAudit(auInfo.getKycAuCustAcctInfo().getCardNum()));
            addCustomerNotes(CustomerProfileUtil.XSL_IS_MOBILEPHONE_CHANGED, currAuInfo, auInfo, custNotesAndEmails);
            addEmailNotification(newUserInfo, CustomerProfileUtil.XSL_IS_MOBILEPHONE_CHANGED, acctInfo, custNotesAndEmails, phoneChangeEmailAdded);
            updParamValues.put(CustomerProfileUtil.XSL_IS_MOBILEPHONE_CHANGED, "true");
            updParamValues.put(CustomerProfileUtil.XSL_MOBILEPHONE_NUMBER, auInfo.getKycAuCustAcctInfo().getMobilePhone());
            if (currAuInfo.getKycAuCustAcctInfo().getMobilePhoneLastUpdatedTS() != null) {
                updParamValues.put(CustomerProfileUtil.XSL_IS_MOBILEPHONE_PRESENT, "true");
                updParamValues.put(CustomerProfileUtil.XSL_MOBILEPHONE_LASTUPDATEDTS, currAuInfo.getKycAuCustAcctInfo().getMobilePhoneLastUpdatedTS());
                updParamValues.put(CustomerProfileUtil.XSL_MOBILEPHONE_LOC_LASTUPDATEDTS, currAuInfo.getKycAuCustAcctInfo().getMobilePhoneLocLastUpdatedTS());

                // To remove, set the endTS
                if (auInfo.getKycAuCustAcctInfo().getMobilePhone() == null || auInfo.getKycAuCustAcctInfo().getMobilePhone().trim().length() == 0) {
                    updParamValues.put(CustomerProfileUtil.XSL_MOBILEPHONE_ENDTS, dateFmt.format(new Date()));
                    updParamValues.put(CustomerProfileUtil.XSL_MOBILEPHONE_NUMBER, currAuInfo.getKycAuCustAcctInfo().getMobilePhone());
                } else {
                    updParamValues.put(CustomerProfileUtil.XSL_MOBILEPHONE_ENDTS, "");
                }
            } else {
                updParamValues.put(CustomerProfileUtil.XSL_IS_MOBILEPHONE_PRESENT, "false");
            }
        }

        // Set up Home Phone:
        updParamValues.put(CustomerProfileUtil.XSL_IS_HOMEPHONE_CHANGED, "false");
        if (!CustomerProfileUtil.compareField(currAuInfo.getKycAuCustAcctInfo().getHomePhone(), auInfo.getKycAuCustAcctInfo().getHomePhone())) {
            userInfoChanged = true;
            changes.homePhoneChanged.add(acctInfo.getKycAcct().getAcctNum() + AU_DELIMITER + auInfo.getKycAuCustAcctInfo().getCustId() + AU_DELIMITER + getCardEndingForAudit(auInfo.getKycAuCustAcctInfo().getCardNum()));
            addCustomerNotes(CustomerProfileUtil.XSL_IS_HOMEPHONE_CHANGED, currAuInfo, auInfo, custNotesAndEmails);
            addEmailNotification(newUserInfo, CustomerProfileUtil.XSL_IS_HOMEPHONE_CHANGED, acctInfo, custNotesAndEmails, phoneChangeEmailAdded);
            updParamValues.put(CustomerProfileUtil.XSL_IS_HOMEPHONE_CHANGED, "true");
            updParamValues.put(CustomerProfileUtil.XSL_HOMEPHONE_NUMBER, auInfo.getKycAuCustAcctInfo().getHomePhone());
            if (currAuInfo.getKycAuCustAcctInfo().getHomePhoneLastUpdatedTS() != null) {
                updParamValues.put(CustomerProfileUtil.XSL_IS_HOMEPHONE_PRESENT, "true");
                updParamValues.put(CustomerProfileUtil.XSL_HOMEPHONE_LASTUPDATEDTS, currAuInfo.getKycAuCustAcctInfo().getHomePhoneLastUpdatedTS());
                updParamValues.put(CustomerProfileUtil.XSL_HOMEPHONE_LOC_LASTUPDATEDTS, currAuInfo.getKycAuCustAcctInfo().getHomePhoneLocLastUpdatedTS());

                // To remove, set the endTS
                if (auInfo.getKycAuCustAcctInfo().getHomePhone() == null || auInfo.getKycAuCustAcctInfo().getHomePhone().trim().length() == 0) {
                    updParamValues.put(CustomerProfileUtil.XSL_HOMEPHONE_ENDTS, dateFmt.format(new Date()));
                    updParamValues.put(CustomerProfileUtil.XSL_HOMEPHONE_NUMBER, currAuInfo.getKycAuCustAcctInfo().getHomePhone());
                } else {
                    updParamValues.put(CustomerProfileUtil.XSL_HOMEPHONE_ENDTS, "");
                }
            } else {
                updParamValues.put(CustomerProfileUtil.XSL_IS_HOMEPHONE_PRESENT, "false");
            }
        }
        // Generate the CODS request and add the account change information.
        TEnvUpdateCustomerProfileRq generatedReq = null;
        try {
            if (userInfoChanged) {
                generatedReq = (TEnvUpdateCustomerProfileRq) BackEndSrvcUtil.genRequest2(null, TdOp_setKycAcctsInfoForAU, updParamValues, null, BackEndSrvcUtil.TDOperation.TdOdsCustomerProfileService_updateCustomerProfile);
            }
        } catch (Exception e) {
        	String message = "TdOdsCustomerProfileService_updateCustomerProfile::TdOp_setKycAcctsInfoForAU failed";
			logger.error(methodName, message, e);
            throw ExceptionUtil.genRuntimeException(e);

        }

        // Add the new request to the list
        if (generatedReq != null) {
            List<TEnvUpdateCustomerProfileRq> auReqList = authorizedUsersReq.get(auInfo.getKycAuCustAcctInfo().getCustId());
            if (auReqList == null) {
                auReqList = new ArrayList<TEnvUpdateCustomerProfileRq>();
                authorizedUsersReq.put(auInfo.getKycAuCustAcctInfo().getCustId(), auReqList);
            }
            auReqList.add(generatedReq);
        }
        return userInfoChanged;
    }

    private void createCustomerNotes(final com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest request, CustNotesAndEmails custLevelNotes, List<CustNotesAndEmails> allAcctNotes, Map<String, CustNotesAndEmails> allAuNotesAndEmails, String ...token) {
        int numCustNotes = custLevelNotes.getCustNotes().size();
        for (CustNotesAndEmails acctNotes : allAcctNotes) {
        	if(acctNotes == null){
        		continue;
        	}
            int numAcctNotes = acctNotes.getCustNotes().size();
            CustNotesAndEmails auNotes = allAuNotesAndEmails.get(acctNotes.getAcctNum());
            int numAuNotes = 0;
            if (auNotes != null && auNotes.getCustNotes() != null) {
                numAuNotes = auNotes.getCustNotes().size();
            }
            if (numAcctNotes + numCustNotes + numAuNotes > 0) {
                List<String> custAndAcctNotes = new ArrayList<String>(numCustNotes + numAcctNotes + numAuNotes);
                custAndAcctNotes.addAll(custLevelNotes.getCustNotes());
                custAndAcctNotes.addAll(acctNotes.getCustNotes());
                if (numAuNotes > 0) {
                    custAndAcctNotes.addAll(auNotes.getCustNotes());
                }
                createCustomerNotes(request, custAndAcctNotes, acctNotes.getAcctNum(), token);
            } else {
                createCustomerNotesForNoChange(request, acctNotes.getAcctNum(), token);
            }
        }
    }

    private void createCustomerNotesForNoChange(final com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest request, String acctNum, String ...token) {
        com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest requestDup = new com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest();
        BeanUtils.copyProperties(request, requestDup);
        requestDup.setAcctNum(acctNum);
        String headerCaption = "Confirm KYC";
        String headerContent = CustomerNotesUtil.getHeaderContent(request, headerCaption);

        List<String> customerNotes = new ArrayList<String>();
        customerNotes.add(headerContent);
        customerNotes.add(CUSTOMERNOTE_NO_CHANGE);
        submitCustomerNote(requestDup, customerNotes, token);
    }

    private void submitCustomerNote(final com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest requestDup, List<String> customerNotes, String ...token) {
        try {
            midtierExecutor.execute(() -> {
                    mbnaCCA.creatCustomerNotes(customerNotes, requestDup, token);
            });
        } catch (Exception e) {
            logger.error("submitCustomerNote", e.getMessage(), e); //dont'throw the exception
        }

    }

	private void createCustomerNotes(final com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest request, List<String> notesContent, String acctNum, String ...token) {
        if (notesContent == null || notesContent.size() == 0) {
            return;
        }
        com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest requestDup = new com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest();
        BeanUtils.copyProperties(request, requestDup);
        requestDup.setAcctNum(acctNum);
        String customerNotesHeader = getCustomerNotesHeader(requestDup);

        List<String> customerNotes = new ArrayList<String>();
        customerNotes.add(customerNotesHeader);
        customerNotes.addAll(1, notesContent);
        submitCustomerNote(requestDup, customerNotes, token);
    }

    private String getCustomerNotesHeader(com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest request) {
        String headerCaption = "Update KYC";
        String headerContent = CustomerNotesUtil.getHeaderContent(request, headerCaption);
        return headerContent;
    }

    private void addCustomerNotes(String changeIndicator, CustomerInfoType curInfo, CustomerInfoType newInfo, CustNotesAndEmails custNotesAndEmails) {
        if (custNotesAndEmails == null) {
        	return;
        }
        StringBuilder sb = new StringBuilder();
        if (CustomerProfileUtil.XSL_IS_PHYSICALADDRESS_CHANGED.equalsIgnoreCase(changeIndicator)) {
        	sb.append("Physical Address: ");
        	sb.append(UpdateCustomerProfileOperation.PREVIOUS);
        	sb.append(CustomerProfileUtil.formatCustomerNoteCommon(curInfo.getPhysicalAddressLine1())).append(CustomerProfileUtil.SPACE);
        	sb.append(CustomerProfileUtil.formatCustomerNoteCommon(curInfo.getPhysicalCity())).append(CustomerProfileUtil.SPACE);
        	sb.append(curInfo.getPhysicalProvince()).append(CustomerProfileUtil.SPACE);
        	sb.append(CustomerProfileUtil.formatCustomerNotesPostalCode(curInfo.getPhysicalPostalCode())).append(CustomerProfileUtil.SPACE);
        	
        	sb.append(UpdateCustomerProfileOperation.NEW);
        	sb.append(CustomerProfileUtil.formatCustomerNoteCommon(newInfo.getPhysicalAddressLine1())).append(CustomerProfileUtil.SPACE);
        	sb.append(CustomerProfileUtil.formatCustomerNoteCommon(newInfo.getPhysicalCity())).append(CustomerProfileUtil.SPACE);
        	sb.append(newInfo.getPhysicalProvince()).append(CustomerProfileUtil.SPACE);
        	sb.append(CustomerProfileUtil.formatCustomerNotesPostalCode(newInfo.getPhysicalPostalCode()));
        }
        if (CustomerProfileUtil.XSL_IS_EMPLOYMENT_CHANGED.equalsIgnoreCase(changeIndicator)) {
        	sb.append("Employment: ");
        	sb.append(UpdateCustomerProfileOperation.PREVIOUS);
        	sb.append(CustomerProfileUtil.formatCustomerNoteCommon(curInfo.getEmploymentStatus())).append(CustomerProfileUtil.SPACE);
        	sb.append(CustomerProfileUtil.getOccupationDescription(curInfo.getOccupation())).append(CustomerProfileUtil.SPACE);
        	sb.append(CustomerProfileUtil.formatCustomerNoteCommon(curInfo.getNatureOfBusiness())).append(CustomerProfileUtil.SPACE);
        	sb.append(CustomerProfileUtil.formatCustomerNoteCommon(curInfo.getPosition()));
        	
        	sb.append(UpdateCustomerProfileOperation.NEW);
        	sb.append(CustomerProfileUtil.formatCustomerNoteCommon(newInfo.getEmploymentStatus())).append(CustomerProfileUtil.SPACE);
        	sb.append(CustomerProfileUtil.getOccupationDescription(newInfo.getOccupation())).append(CustomerProfileUtil.SPACE);
        	sb.append(CustomerProfileUtil.formatCustomerNoteCommon(newInfo.getNatureOfBusiness())).append(CustomerProfileUtil.SPACE);
        	sb.append(CustomerProfileUtil.formatCustomerNoteCommon(newInfo.getPosition()));
        }
        custNotesAndEmails.addCustNote(sb.toString());
    }

    private void addCustomerNotes(String changeIndicator, CustomerAcctInfoType curAcct, CustomerAcctInfoType newAcct, CustNotesAndEmails custNotesAndEmails) {
        if (custNotesAndEmails == null) {
        	return;
        }
        StringBuilder sb = new StringBuilder();
        if (CustomerProfileUtil.XSL_IS_MAILINGADDRESS_CHANGED.equalsIgnoreCase(changeIndicator)) {
        	sb.append("Mailing Address: ");
        	sb.append(UpdateCustomerProfileOperation.PREVIOUS);
        	sb.append(CustomerProfileUtil.formatCustomerNoteCommon(curAcct.getMailingAddressLine1())).append(CustomerProfileUtil.SPACE);
        	sb.append(CustomerProfileUtil.formatCustomerNoteCommon(curAcct.getMailingCity())).append(CustomerProfileUtil.SPACE);
        	sb.append(curAcct.getMailingProvince()).append(CustomerProfileUtil.SPACE);
        	sb.append(CustomerProfileUtil.formatCustomerNotesPostalCode(curAcct.getMailingPostalCode())).append(CustomerProfileUtil.SPACE);
        	
        	sb.append(UpdateCustomerProfileOperation.NEW);
        	sb.append(CustomerProfileUtil.formatCustomerNoteCommon(newAcct.getMailingAddressLine1())).append(CustomerProfileUtil.SPACE);
        	sb.append(CustomerProfileUtil.formatCustomerNoteCommon(newAcct.getMailingCity())).append(CustomerProfileUtil.SPACE);
        	sb.append(newAcct.getMailingProvince()).append(CustomerProfileUtil.SPACE);
        	sb.append(CustomerProfileUtil.formatCustomerNotesPostalCode(newAcct.getMailingPostalCode()));
        }
        if ((CustomerProfileUtil.XSL_IS_HOMEPHONE_CHANGED.equalsIgnoreCase(changeIndicator)) || (CustomerProfileUtil.XSL_IS_BUSINESSPHONE_CHANGED.equalsIgnoreCase(changeIndicator)) || (CustomerProfileUtil.XSL_IS_MOBILEPHONE_CHANGED.equalsIgnoreCase(changeIndicator))) {
        	sb.append(PHONE);
        	sb.append(CustomerProfileUtil.SPACE);
        }
        if (CustomerProfileUtil.XSL_IS_HOMEPHONE_CHANGED.equalsIgnoreCase(changeIndicator)) {
        	sb.append("Home:");
        	sb.append(UpdateCustomerProfileOperation.PREVIOUS);
        	sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(curAcct.getHomePhone())).append(CustomerProfileUtil.SPACE);
        	sb.append(UpdateCustomerProfileOperation.NEW);
        	sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(newAcct.getHomePhone()));
        }
        if (CustomerProfileUtil.XSL_IS_BUSINESSPHONE_CHANGED.equalsIgnoreCase(changeIndicator)) {
        	sb.append("Business:");
        	sb.append(UpdateCustomerProfileOperation.PREVIOUS);
        	sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(curAcct.getBusinessPhone())).append(CustomerProfileUtil.SPACE);
        	sb.append(UpdateCustomerProfileOperation.NEW);
        	sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(newAcct.getBusinessPhone()));
        }
        if (CustomerProfileUtil.XSL_IS_MOBILEPHONE_CHANGED.equalsIgnoreCase(changeIndicator)) {
        	sb.append("Mobile:");
        	sb.append(UpdateCustomerProfileOperation.PREVIOUS);
        	sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(curAcct.getMobilePhone())).append(CustomerProfileUtil.SPACE);
        	sb.append(UpdateCustomerProfileOperation.NEW);
        	sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(newAcct.getMobilePhone()));
        	
        }
        custNotesAndEmails.addCustNote(sb.toString());
    }

    private void addCustomerNotes(String changeIndicator, AccountKycAuInfoType curAu, AccountKycAuInfoType newAu, CustNotesAndEmails custNotes) {
        if (custNotes == null) {
        	return;
        }
        StringBuilder sb = new StringBuilder();
        if (CustomerProfileUtil.XSL_IS_MAILINGADDRESS_CHANGED.equalsIgnoreCase(changeIndicator)) {
        	sb.append("AU Update For :");
        	sb.append(curAu.getKycAuName().getFirstName()).append(CustomerProfileUtil.SPACE);
        	sb.append(curAu.getKycAuName().getLastName()).append(CustomerProfileUtil.SPACE);
        	sb.append("AU Address: ");
        	sb.append(UpdateCustomerProfileOperation.PREVIOUS);
        	sb.append(CustomerProfileUtil.formatCustomerNoteCommon(curAu.getKycAuCustAcctInfo().getMailingAddressLine1())).append(CustomerProfileUtil.SPACE);
        	sb.append(CustomerProfileUtil.formatCustomerNoteCommon(curAu.getKycAuCustAcctInfo().getMailingCity())).append(CustomerProfileUtil.SPACE);
        	sb.append(curAu.getKycAuCustAcctInfo().getMailingProvince()).append(CustomerProfileUtil.SPACE);
        	sb.append(CustomerProfileUtil.formatCustomerNotesPostalCode(curAu.getKycAuCustAcctInfo().getMailingPostalCode())).append(CustomerProfileUtil.SPACE);
        	
        	sb.append(UpdateCustomerProfileOperation.NEW);
        	sb.append(CustomerProfileUtil.formatCustomerNoteCommon(newAu.getKycAuCustAcctInfo().getMailingAddressLine1())).append(CustomerProfileUtil.SPACE);
        	sb.append(CustomerProfileUtil.formatCustomerNoteCommon(newAu.getKycAuCustAcctInfo().getMailingCity())).append(CustomerProfileUtil.SPACE);
        	sb.append(newAu.getKycAuCustAcctInfo().getMailingProvince()).append(CustomerProfileUtil.SPACE);
        	sb.append(CustomerProfileUtil.formatCustomerNotesPostalCode(newAu.getKycAuCustAcctInfo().getMailingPostalCode()));
        }
        if ((CustomerProfileUtil.XSL_IS_HOMEPHONE_CHANGED.equalsIgnoreCase(changeIndicator)) || (CustomerProfileUtil.XSL_IS_BUSINESSPHONE_CHANGED.equalsIgnoreCase(changeIndicator)) || (CustomerProfileUtil.XSL_IS_MOBILEPHONE_CHANGED.equalsIgnoreCase(changeIndicator))) {
        	sb.append("AU Phone:");
        	sb.append(CustomerProfileUtil.SPACE);
        }
        if (CustomerProfileUtil.XSL_IS_HOMEPHONE_CHANGED.equalsIgnoreCase(changeIndicator)) {
        	sb.append("Home: ");
        	sb.append(UpdateCustomerProfileOperation.PREVIOUS);
        	sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(curAu.getKycAuCustAcctInfo().getHomePhone())).append(CustomerProfileUtil.SPACE);
        	sb.append(UpdateCustomerProfileOperation.NEW);
        	sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(newAu.getKycAuCustAcctInfo().getHomePhone()));
        }
        if (CustomerProfileUtil.XSL_IS_BUSINESSPHONE_CHANGED.equalsIgnoreCase(changeIndicator)) {
        	sb.append("Business:");
        	sb.append(UpdateCustomerProfileOperation.PREVIOUS);
        	sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(curAu.getKycAuCustAcctInfo().getBusinessPhone())).append(CustomerProfileUtil.SPACE);
        	sb.append(UpdateCustomerProfileOperation.NEW);
        	sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(newAu.getKycAuCustAcctInfo().getBusinessPhone()));
        }
        if (CustomerProfileUtil.XSL_IS_MOBILEPHONE_CHANGED.equalsIgnoreCase(changeIndicator)) {
        	sb.append("Mobile:");
        	sb.append(UpdateCustomerProfileOperation.PREVIOUS);
        	sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(curAu.getKycAuCustAcctInfo().getMobilePhone())).append(CustomerProfileUtil.SPACE);
        	sb.append(UpdateCustomerProfileOperation.NEW);
        	sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(newAu.getKycAuCustAcctInfo().getMobilePhone()));
        }
        custNotes.addCustNote(sb.toString());
    }

    private void addEmailNotification(TrackableRequest request, String changeIndicator, AccountKycInfoType acctKycInfo, CustNotesAndEmails custNotes, MutableBoolean alreadyAdded) {
        logger.debug("adding email notification for: " + changeIndicator);
        if (alreadyAdded != null && alreadyAdded.booleanValue()) {
            return;
        }
        EmailInfoImpl emailInfoBean = getBaseEmailBeanPCH(acctKycInfo);
        emailInfoBean.setLogonId(request.getSessionInfo().getLoginId());
        custNotes.addEmail(emailInfoBean);
        if (alreadyAdded != null) {
            alreadyAdded.setValue(true);
        }
    }

    private void sendEmailNotifications(com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest request, String ...token) {

        List<EmailInfoImpl> emailInfoBeans = new ArrayList<>();
        for (com.td.mbna.msec.midtier.customerprofile.payload.AccountKycInfoType acctInfo : request.getRequestPayload().getKycAcctsInfo()) {
            EmailInfoImpl emailInfoBean = getBaseEmailBeanPCH(acctInfo);
            emailInfoBean.setLogonId(request.getSessionInfo().getLoginId());
			emailInfoBean.setToken(token != null && token.length > 0 ? token[0] : null);
            emailInfoBeans.add(emailInfoBean);
        }

        if (emailInfoBeans.size() == 0) {
            return;
        }
        
        for (EmailInfoImpl emailInfoBean : emailInfoBeans) {
        	if(emailInfoBean == null){
        		continue;
        	}
            if (emailInfoBean.isTriggerEmailNotification()) {
                midtierExecutor.execute(() -> {
                    try {
                    	mbnaAlert.addAlertEvent(emailInfoBean);
                    } catch (Exception e) {
                        logger.error("sendEmailNotifications", "sendEmail failed", e);
                    }
                });
        	} else {
        		logger.debug(" notification is explicitly set to false. Email not sent");
        	}
        }
    }

    private EmailInfoImpl getBaseEmailBeanPCH(AccountKycInfoType acctKycInfo) {
        EmailInfoImpl emailInfoBean = new EmailInfoImpl();
        CustAcctType kycAcct = acctKycInfo.getKycAcct();
        CustomerAcctInfoType kycCustAcctInfo = acctKycInfo.getKycCustAcctInfo();

        emailInfoBean.setBusinessEventID(IMBNAConstants.ALERT_TYPE_CD_SECUREGENERIC);

        emailInfoBean.setPrimaryEmailAddress(kycCustAcctInfo.getEmail());
        if ("en".equalsIgnoreCase(kycAcct.getCardHolder().getLanguageCode())) {
            emailInfoBean.setPrimaryLanguagePref(IMBNAConstants.LANG_ENGLISH);
        } else {
            emailInfoBean.setPrimaryLanguagePref(IMBNAConstants.LANG_FRENCH);
        }

        PrimaryCardMemberInfo primaryUserInfo = new PrimaryCardMemberInfo();
        primaryUserInfo.setFirstName(kycAcct.getCardHolder().getFirstName());
        primaryUserInfo.setMiddleName(kycAcct.getCardHolder().getMiddleName());
        primaryUserInfo.setLastName(kycAcct.getCardHolder().getLastName());
        emailInfoBean.setPrimaryUserInfo(primaryUserInfo);
        
        emailInfoBean.setAccountFirstName(kycAcct.getCardHolder().getFirstName());
        emailInfoBean.setAccountLastName(kycAcct.getCardHolder().getLastName());
        emailInfoBean.setCustId(kycCustAcctInfo.getCustId());
        emailInfoBean.setAcctNum(kycCustAcctInfo.getAcctNum());
        
        if (kycAcct.getAffinity() != null) {
            if ("en".equalsIgnoreCase(kycAcct.getCardHolder().getLanguageCode())) {
                if (kycAcct.getAffinity().getEnglishInfo() != null)
                    emailInfoBean.setCardName(kycAcct.getAffinity().getEnglishInfo().getShortDesc());
            } else {
                if (kycAcct.getAffinity().getFrenchInfo() != null)
                    emailInfoBean.setCardName(kycAcct.getAffinity().getFrenchInfo().getShortDesc());
            }
        }

        emailInfoBean.setCardEnding(getCardEndingForAudit(kycAcct.getCardNum()));
        emailInfoBean.setTriggerEmailNotification(kycCustAcctInfo.isConfirmationEmailWanted());

        return addEmailAttributes(emailInfoBean);
    }


    private EmailInfoImpl getBaseEmailBeanPCH(com.td.mbna.msec.midtier.customerprofile.payload.AccountKycInfoType acctKycInfo) {
        EmailInfoImpl emailInfoBean = new EmailInfoImpl();
        com.td.mbna.msec.midtier.types.common.CustAcctType kycAcct = acctKycInfo.getKycAcct();
        com.td.mbna.msec.midtier.customerprofile.payload.CustomerAcctInfoType kycCustAcctInfo = acctKycInfo.getKycCustAcctInfo();

        emailInfoBean.setBusinessEventID(IMBNAConstants.ALERT_TYPE_CD_SECUREGENERIC);

        emailInfoBean.setPrimaryEmailAddress(kycCustAcctInfo.getEmail());
        if ("en".equalsIgnoreCase(kycAcct.getCardHolder().getLanguageCode())) {
            emailInfoBean.setPrimaryLanguagePref(IMBNAConstants.LANG_ENGLISH);
        } else {
            emailInfoBean.setPrimaryLanguagePref(IMBNAConstants.LANG_FRENCH);
        }

        PrimaryCardMemberInfo primaryUserInfo = new PrimaryCardMemberInfo();
        primaryUserInfo.setFirstName(kycAcct.getCardHolder().getFirstName());
        primaryUserInfo.setMiddleName(kycAcct.getCardHolder().getMiddleName());
        primaryUserInfo.setLastName(kycAcct.getCardHolder().getLastName());
        emailInfoBean.setPrimaryUserInfo(primaryUserInfo);

        emailInfoBean.setAccountFirstName(kycAcct.getCardHolder().getFirstName());
        emailInfoBean.setAccountLastName(kycAcct.getCardHolder().getLastName());
        emailInfoBean.setCustId(kycCustAcctInfo.getCustId());
        emailInfoBean.setAcctNum(kycCustAcctInfo.getAcctNum());

        if (kycAcct.getAffinity() != null) {
            if ("en".equalsIgnoreCase(kycAcct.getCardHolder().getLanguageCode())) {
                if (kycAcct.getAffinity().getEnglishInfo() != null)
                    emailInfoBean.setCardName(kycAcct.getAffinity().getEnglishInfo().getShortDesc());
            } else {
                if (kycAcct.getAffinity().getFrenchInfo() != null)
                    emailInfoBean.setCardName(kycAcct.getAffinity().getFrenchInfo().getShortDesc());
            }
        }

        emailInfoBean.setCardEnding(getCardEndingForAudit(kycAcct.getCardNum()));
        emailInfoBean.setTriggerEmailNotification(kycCustAcctInfo.getConfirmationEmailWanted() == null ? false : kycCustAcctInfo.getConfirmationEmailWanted().booleanValue());

        return addEmailAttributes(emailInfoBean);
    }

    private EmailInfoImpl addEmailAttributes(EmailInfoImpl emailInfoBean) {
    	
        emailInfoBean.setInitiatedBy(IMBNAConstants.USER_PRINCIPAL);
        
        LocalDate now = LocalDate.now();
		emailInfoBean.addAttribute(CONTENT_CD, UPDATE_PROFILE);
		emailInfoBean.addAttribute(UCP_FIRST_NAME, emailInfoBean.getPrimaryUserInfo().getFirstName());
		emailInfoBean.addAttribute(UCP_APP_DATE, ISO_DATE.format(now));
		emailInfoBean.addAttribute(UCP_LAST_FOUR_DIGIT, emailInfoBean.getCardEnding());
		emailInfoBean.addAttribute(UCP_PRODUCT_NAME, emailInfoBean.getCardName());

		return emailInfoBean;
    }

	private String getCardEndingForAudit(String cardNum) {
        int cardNumLen = cardNum.length();
        String cardEnding = cardNumLen > 4 ? cardNum.substring(cardNumLen - 4, cardNumLen) : cardNum;
        return cardEnding;
    }

    private void createAuditInfo(com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest request, ChangeFlags changes, boolean kycChangedFlag) {
        if (!kycChangedFlag) {
            genAuditLog(request, "SS2520", null, AuditService.TRANSACTION_SUCCESS);
            return;
        } 

        if (changes.isPhysicalAddressChanged) {
            String auditInfo[] = null;
            String auditEntry = null;
    		if(changes.physicalAddressChanged != null && !changes.physicalAddressChanged.isEmpty()){
    			auditEntry = changes.physicalAddressChanged.get(0);
    		}
            if (auditEntry != null) {
                auditInfo = auditEntry.split(PCH_DELIMITER);
                genAuditLog(request, "SS2511", null, auditInfo[1], null);
            }
        }

        if (changes.mailingAddressChanged.size() > 0) {
            String auditInfo[] = null;

            for (int i = 0; i < changes.mailingAddressChanged.size(); i++) {
                String auditEntry = changes.mailingAddressChanged.get(i);

                if (auditEntry != null) {
                    if (auditEntry.contains(PCH_DELIMITER)) {
                        auditInfo = auditEntry.split(PCH_DELIMITER);
                        if (!changes.isPhysicalAddressChanged) {
                            genAuditLog(request, "SS2511", auditInfo[2], auditInfo[1], null);

                        }
                    } else {
                        auditInfo = auditEntry.split(AU_DELIMITER);
                        genAuditLog(request, "SS2525", auditInfo[2], auditInfo[1], null); // au address update

                    }
                }
            }
        }


        //using a hashset to remove duplicates. Only one phone update per person per account.
        HashSet<String> allPhoneUpdates = new HashSet<String>();
        allPhoneUpdates.addAll(changes.homePhoneChanged);
        allPhoneUpdates.addAll(changes.mobilePhoneChanged);
        allPhoneUpdates.addAll(changes.businessPhoneChanged);


        if (allPhoneUpdates.size() > 0) {
            String auditInfo[] = null;
            for (String auditEntry : allPhoneUpdates) {
            	if(auditEntry == null){
            		continue;
            	}
                if (auditEntry.contains(PCH_DELIMITER)) {
                    auditInfo = auditEntry.split(PCH_DELIMITER);
                    genAuditLog(request, "SS2521", auditInfo[2], auditInfo[1], null); // PCH phone(any phone)
                } else {
                    auditInfo = auditEntry.split(AU_DELIMITER);
                    genAuditLog(request, "SS2522", auditInfo[2], auditInfo[1], null); // AU phone (any phone)
                }
            }
        }

        if (changes.isEmployementChanged) {
			if(changes.employmentChanged != null && changes.employmentChanged.size()>0){
				
				String auditInfo[] = null;
				String auditEntry = changes.employmentChanged.get(0);
				if (auditEntry != null) {
					auditInfo = auditEntry.split(PCH_DELIMITER);
					genAuditLog(request, "SS2512", null, auditInfo[1], null);
				}
			}

        }

        genAuditLog(request, "SS2510", null, AuditService.TRANSACTION_SUCCESS);
    }

    /**
     * @param request
     * @param auditCode
     * @param cardEnding
     * @param auditStatus
     */
    private void genAuditLog(com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest request, String auditCode, String cardEnding, String auditStatus) {
        com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest requestDup = new com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest();
        BeanUtils.copyProperties(request, requestDup);
        if (requestDup.getAuditInfo() == null) {
            logger.error("genAuditLog", "AuditInfo NULL.");
            return;
        }
        // Create a new structure so that the auditInfo in the original request stay intact
        AuditInfo newAuditInfo = new AuditInfo();
        BeanUtils.copyProperties(requestDup.getAuditInfo(), newAuditInfo);
        requestDup.setAuditInfo(newAuditInfo);
        requestDup.getAuditInfo().setTransactionCode(auditCode);
        if (cardEnding != null) {
        	requestDup.getAuditInfo().setCardEnding(cardEnding);
        }
        com.td.mbna.msec.midtier.types.common.BaseResponse response = new com.td.mbna.msec.midtier.types.common.BaseResponse();
        if (auditStatus != null) {
        	response.setStatus(auditStatus);
        }
        long processingTime = System.currentTimeMillis() - auditStartTime;
        AuditServiceWork auditWork = new AuditServiceWork(requestDup, response, new Date(), processingTime);
        auditWork.run();
    }

    /**
     * @param request
     * @param auditCode
     * @param cardEnding
     * @param ucid
     * @param auditStatus
     */
    private void genAuditLog(com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest request, String auditCode, String cardEnding, String ucid, String auditStatus) {
        com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest requestDup = new com.td.mbna.msec.midtier.customerprofile.payload.setkycacctsinfo.SetKycAcctsInfoRequest();
        BeanUtils.copyProperties(request, requestDup);
        if (requestDup.getAuditInfo() == null) {
            logger.error("genAuditLog", "AuditInfo NULL.");
            return;
        }
        // Create a new structure so that the auditInfo in the original request stay intact
        AuditInfo newAuditInfo = new AuditInfo();
        BeanUtils.copyProperties(requestDup.getAuditInfo(), newAuditInfo);
        requestDup.setAuditInfo(newAuditInfo);
        requestDup.getAuditInfo().setTransactionCode(auditCode);
        requestDup.getAuditInfo().setDescription(ucid);
        if (cardEnding != null) {
        	requestDup.getAuditInfo().setCardEnding(cardEnding);
        }
        com.td.mbna.msec.midtier.types.common.BaseResponse response = new com.td.mbna.msec.midtier.types.common.BaseResponse();
        if (auditStatus != null) {
        	response.setStatus(auditStatus);
        }
        long processingTime = System.currentTimeMillis() - auditStartTime;
        AuditServiceWork auditWork = new AuditServiceWork(requestDup, response, new Date(), processingTime);
        auditWork.run();
    }

}	
