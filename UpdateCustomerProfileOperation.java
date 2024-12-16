package com.td.mbna.msec.midtier.customerprofile;

import static java.time.format.DateTimeFormatter.ISO_DATE;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.transform.Templates;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import com.mbnaweb.xsd.msgs.customerprofile.AccountKycAuInfoType;
import com.mbnaweb.xsd.msgs.customerprofile.BusinessException;
import com.mbnaweb.xsd.msgs.customerprofile.CustomerAcctInfoType;
import com.mbnaweb.xsd.msgs.customerprofile.CustomerProfileType;
import com.mbnaweb.xsd.msgs.customerprofile.ProfileUpdateType;
import com.mbnaweb.xsd.msgs.customerprofile.RetrieveCustomerProfileRequest;
import com.mbnaweb.xsd.msgs.customerprofile.RetrieveCustomerProfileResponse;
import com.mbnaweb.xsd.msgs.customerprofile.RetrieveCustomerProfileResponse.ResponsePayload;
import com.mbnaweb.xsd.msgs.customerprofile.SetKycAcctsInfoResponse;
import com.mbnaweb.xsd.msgs.customerprofile.UpdateCustomerProfileResponse;
import com.mbnaweb.xsd.types.common.AuditLogType;
import com.mbnaweb.xsd.types.common.TrackingInfoType;
import com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest;
import com.td.mbna.msec.midtier.exception.BusinessError;
import com.td.mbna.msec.midtier.exception.SystemError;
import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.mbalert.MbnaAlert;
import com.td.mbna.msec.midtier.mbcca.MbnaCCA;
import com.td.mbna.msec.midtier.persistance.entity.Accounts;
//import com.td.mbna.msec.midtier.persistance.hibernate.DBService;
import com.td.mbna.msec.midtier.persistance.mybatis.DBMybatisService;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.services.AuditService;
import com.td.mbna.msec.midtier.services.AuditServiceWork;
import com.td.mbna.msec.midtier.services.EmailInfoImpl;
import com.td.mbna.msec.midtier.services.IMBNAConstants;
import com.td.mbna.msec.midtier.tdwsservices.TdOdsCustomerProfileService;
import com.td.mbna.msec.midtier.tdwsservices.RcpFilter;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.ValidationException;
import com.td.mbna.msec.midtier.util.BackEndSrvcUtil;
import com.td.mbna.msec.midtier.util.CustomerProfileUtil;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.IncomeUtil;
import com.td.mbna.msec.midtier.util.JaxbUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.ParallelServiceCaller;
import com.td.mbna.msec.midtier.util.ServiceCall;
import com.td.mbna.msec.midtier.util.TransformUtil;
import com.td.mbna.msec.midtier.util.UuidUtil;
import com.td.mbna.msec.midtier.util.services.JAXBJsonConverter;
import com.td.schemas.tdct.srm.customerprofile.service.v1.TEnvUpdateCustomerProfileRq;
import com.td.schemas.tdct.srm.customerprofile.service.v1.TEnvUpdateCustomerProfileRs;

@Component
public class UpdateCustomerProfileOperation implements MsecMidtierCommonOperations<com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest, com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileResponse> {

    private final static String SPACE = CustomerProfileUtil.SPACE;
    private final static String COMMA_SPACE = ", ";
    private final static String COMMA = ",";
    private static final String GENERAL_ERROR = "MS601";
    public final static String PREVIOUS = "Previous - ";
    public final static String NEW = "New - ";
    private final static String ErrorCode = "MS607";
    private static final String MISSING_FULL_EMPLOYER_ADDRESS = "MS609";

    private final static String UPDATE_CUSTOMER_PROFILE = "odsUpdateCustomer";
    private final static String UPDATE_CUSTOMER_PROFILE_RS = "odsUpdateCustomerRs";
    private final static String TdOp_setKycAcctsInfoForAU = "odsSetKycAcctsInfoForAU";
    private final static String MILTI_ACCOUNT_SELECTION = "Multi-Account Selection";

	private static final String CONTENT_CD = "contentCd";
	private static final String UPDATE_PROFILE = "KycUpdateProfile";
	private static final String UCP_FIRST_NAME = "firstName";
	private static final String UCP_APP_DATE = "appDate";
	private static final String UCP_PRODUCT_NAME = "productName";
	private static final String UCP_LAST_FOUR_DIGIT = "cardLastFourDigit";

    private final static MbnaLogger logger = new MbnaLogger(UpdateCustomerProfileOperation.class);

    @Autowired
    private ValangValidator customerProfileValidator;
    @Autowired
    private ValangValidator authorizedUserValidator;
    @Autowired
    private ValangValidator customerProfile_OtherIncome_Validator;
    @Autowired
    private ValangValidator customerProfile_PhisicalAddress_Validator;
    @Autowired
    private ValangValidator multiProfileValidator;
    
    @Autowired 
    private MbnaCCA mbnaCCA;

    @Autowired
    private MbnaAlert mbnaAlert;

    @Autowired
    private Executor midtierExecutor;
    
    private MsecValidator msecCustomerProfileValidator;
    private MsecValidator msecAuthorizedUserValidator;
    private MsecValidator msecCustomerProfileOtherIncomeValidator;
    private MsecValidator msecCustomerProfilePhisicalAddressValidator;
    private MsecValidator msecMultiProfileValidator;

    @PostConstruct
    private void init() {
        msecCustomerProfileValidator = new MsecVlangValidator(customerProfileValidator);
        msecAuthorizedUserValidator = new MsecVlangValidator(authorizedUserValidator);
        msecCustomerProfileOtherIncomeValidator = new MsecVlangValidator(customerProfile_OtherIncome_Validator);
        msecCustomerProfilePhisicalAddressValidator = new MsecVlangValidator(customerProfile_PhisicalAddress_Validator);
        msecMultiProfileValidator = new MsecVlangValidator(multiProfileValidator);
    }

    @Override
    public com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileResponse invokeService(com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest requestInJson, String... token) {
    	
    	String methodName = "UpdateCustomerProfileOperation::invokeService";
    	UpdateCustomerProfileResponse xResponse = new UpdateCustomerProfileResponse();
    	if(requestInJson == null){
    		String message = " the request is empaty !";
			logger.error(methodName, message);
			throw ExceptionUtil.genBusinessException(message);
    	}
    	
    	try {
			if (requestInJson.getRequestPayload().getMultiProfilesRq() == null || requestInJson.getRequestPayload().getMultiProfilesRq().isEmpty()) {
				// Call to update Single profile
				boolean isRequestValid = validateSingleProfileRequest(requestInJson);
				if(isRequestValid){
					xResponse = updateCustomerProfile(requestInJson, token);
				}
				return JAXBJsonConverter.convertoJAXBToJsonInterface(xResponse, com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileResponse.class);
			}
    	}catch(com.td.mbna.msec.midtier.exceptions.BusinessException e){
    		String message = " CODS SOAP service update single profile failed(1.1)!";
    		logger.error(methodName, message, e);
    		throw e;
    	}catch(ValidationException ve){
    		String message = " CODS SOAP service update single profile failed(1.2)!";
    		logger.error(methodName, message, ve);
    		throw ve;
		} catch (Exception e) {
			String message = " CODS SOAP service update single profile failed(1.3)!";
			logger.error(methodName, message, e);
			throw ExceptionUtil.genBusinessException(message); 
		}

		// Call to update multiple profiles
		try {
			boolean isRequestValid = validateMultiProfileRequest(requestInJson);
			if(isRequestValid){
				xResponse = updateMultiProfiles(requestInJson, token);
			}
		} catch(com.td.mbna.msec.midtier.exceptions.BusinessException e){
			String message = " CODS SOAP service update multi profiles failed(m.1)!";
			logger.error(methodName, message, e);
			throw e;
		}catch(ValidationException ve){
			String message = " CODS SOAP service update multi profiles failed(m.2)!";
			logger.error(methodName, message, ve);
			throw ve;
		} catch (Exception e) {
			String message = " CODS SOAP service update multi profiles failed(m.3)!";
			logger.error(methodName, message, e);
			throw ExceptionUtil.genBusinessException(message); 
		}
		return JAXBJsonConverter.convertoJAXBToJsonInterface(xResponse, com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileResponse.class);
    	
    }


	private boolean validateSingleProfileRequest(UpdateCustomerProfileRequest jsonRequest) {
    	String methodName = "UpdateCustomerProfileOperation::validateSingleProfileRequest";
    	com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.RequestPayload payload = jsonRequest.getRequestPayload();
    	
    	// validating the primary customer information
    	ValidationException faultInfo = null;
    	try {
    		faultInfo = msecCustomerProfileValidator.validate(jsonRequest);
    	} catch (Exception e) {
    		String message = " msecCustomerProfileValidator.validate(jsonRequest) validate request for customer single profile failed!";
    		logger.error(methodName, message, e);
    		throw ExceptionUtil.genBusinessException(message); 
    	}
    	
    	if (!payload.getAuthorizedUser() && payload.getHasOtherIncome() != null && payload.getHasOtherIncome()) {
    		com.td.mbna.msec.midtier.types.common.ValidationException faultInfo_additional = null;
    		try {
    			faultInfo_additional = msecCustomerProfileOtherIncomeValidator.validate(jsonRequest);
    		} catch (Exception e) {
    			String message = " msecCustomerProfileOtherIncomeValidator.validate(jsonRequest) validate request for customer single profile failed!";
    			logger.error(methodName, message, e);
    		}
    		if (faultInfo != null) {
    			if (faultInfo_additional != null && !faultInfo_additional.getFieldError().isEmpty()) {
    				faultInfo.getFieldError().addAll(faultInfo_additional.getFieldError());
    			}
    		} else {
    			faultInfo = faultInfo_additional;
    		}
    	}
    	
    	// only validating the physical address if the user is not an authorized
    	// user.
    	if (payload.getDifferentPhysicalAddress() != null && payload.getDifferentPhysicalAddress()  && !payload.getAuthorizedUser()) {
    		com.td.mbna.msec.midtier.types.common.ValidationException faultInfo_2 = null;
    		try {
    			faultInfo_2 = msecCustomerProfilePhisicalAddressValidator.validate(jsonRequest);
    		} catch (Exception e) {
    			String message = " msecCustomerProfilePhisicalAddressValidator.validate(jsonRequest) validate request for customer single profile failed!";
    			logger.error(methodName, message, e);
    		}
    		if (faultInfo != null) {
    			if (faultInfo_2 != null && !faultInfo_2.getFieldError().isEmpty()) {
    				faultInfo.getFieldError().addAll(faultInfo_2.getFieldError());
    			}
    		} else {
    			faultInfo = faultInfo_2;
    		}
    	}
    	
    	/* Validating Authorized user information */
    	com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.RequestPayload updateCustomerRqPayLoad = jsonRequest.getRequestPayload();
    	List<com.td.mbna.msec.midtier.customerprofile.payload.AccountKycAuInfoType> actKycAuInfoTpList = updateCustomerRqPayLoad.getAuthorizedUsers();
    	
    	if ((actKycAuInfoTpList != null) && (actKycAuInfoTpList.size() > 0)) {
    		for (com.td.mbna.msec.midtier.customerprofile.payload.AccountKycAuInfoType actKycAuInfoTp : actKycAuInfoTpList) {
    			if(actKycAuInfoTp == null){
    				continue;
    			}
    			com.td.mbna.msec.midtier.customerprofile.payload.CustomerAcctInfoType auAcctInfo = actKycAuInfoTp.getKycAuCustAcctInfo();
    			com.td.mbna.msec.midtier.types.common.ValidationException faultInfo_auInfoType = null;
    			try {
    				faultInfo_auInfoType = msecAuthorizedUserValidator.validate(auAcctInfo);
    			} catch (Exception e) {
    				String message = " msecAuthorizedUserValidator.validate(auAcctInfo) validate request for customer single profile failed!";
    				logger.error(methodName, message, e);
    			}
    			if (faultInfo != null) {
    				if (faultInfo_auInfoType != null && !faultInfo_auInfoType.getFieldError().isEmpty()) {
    					faultInfo.getFieldError().addAll(faultInfo_auInfoType.getFieldError());
    				}
    			} else {
    				faultInfo = faultInfo_auInfoType;
    			}
    			
    		}
    	}
    	
    	// check if the 4 fields of employer address are all filled out, or all
    	// blank
    	
    	String employerStreet = updateCustomerRqPayLoad.getEmployerAddress() == null ? "" : updateCustomerRqPayLoad.getEmployerAddress();
    	String emplyoerCity = updateCustomerRqPayLoad.getEmployerCity() == null ? "" : updateCustomerRqPayLoad.getEmployerCity();
    	String employerPostalCode = updateCustomerRqPayLoad.getEmployerPostalCode() == null ? "": updateCustomerRqPayLoad.getEmployerPostalCode();
    	String employerProvince = updateCustomerRqPayLoad.getEmployerProvince() == null ? "" : updateCustomerRqPayLoad.getEmployerProvince();
    	
    	// all fields are not filled, or they are not blank
    	boolean areFilled = employerStreet.length() > 0 && emplyoerCity.length() > 0 && employerPostalCode.length() > 0 && employerProvince.length() > 0;
    	boolean areAllBlank = employerStreet.length() == 0 && emplyoerCity.length() == 0 && employerPostalCode.length() == 0 && employerProvince.length() == 0;
    	
    	if (!( areFilled|| areAllBlank)) {
    		
    		com.td.mbna.msec.midtier.types.common.FieldErrorType fieldError = new com.td.mbna.msec.midtier.types.common.FieldErrorType();
    		fieldError.setErrorCode(MISSING_FULL_EMPLOYER_ADDRESS);
    		fieldError.setSeverity("ERROR");
    		fieldError.setErrorDescription(MISSING_FULL_EMPLOYER_ADDRESS);
    		if (faultInfo == null) {
    			faultInfo = new ValidationException();
    		}
    		faultInfo.getFieldError().add(fieldError);
    	}
    	
    	if (faultInfo != null && !faultInfo.getFieldError().isEmpty()) {
    		throw faultInfo;
    	}
		return true;
	}


    private void scheduleServiceCall(ParallelServiceCaller updateUserSvcCaller, final com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest request, String ...token) throws Exception {

        ServiceCall<?> updPrimaryCall = new ServiceCall<UpdateCustomerProfileResponse>() {
            @Override
            public UpdateCustomerProfileResponse invoke() throws Exception {
                UpdateCustomerProfileResponse odsUpdateResult = null;
                try {
                    odsUpdateResult = updateCustomerProfile(request, token);
                } catch (Exception exp) {
                    throw exp;
                }
                return odsUpdateResult;
            }
        };

        updateUserSvcCaller.scheduleCall(request.getAcctNum(), updPrimaryCall);
    }

    private com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest generateRequest(com.td.mbna.msec.midtier.customerprofile.payload.ProfileUpdateType profileUpdateType, com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest request) throws Exception {
        com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest updateRequest = new com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest();
        com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.RequestPayload pl = new com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.RequestPayload();

        copyToPayload(pl, profileUpdateType);
        pl.setEmailUpdateOnly(request.getRequestPayload().isEmailUpdateOnly());
        updateRequest.setRequestPayload(pl);
        updateRequest.setCustId(profileUpdateType.getCustId());
        updateRequest.setAcctNum(profileUpdateType.getAcctId());
        updateRequest.setAliasCustId(profileUpdateType.getAliasCustomerID());
        updateRequest.setIsPrimaryUser(profileUpdateType.getIsPrimaryUser());
        updateRequest.setSessionInfo(request.getSessionInfo());
        updateRequest.setLanguagePref(profileUpdateType.getLanguagePref());
        updateRequest.setAuditInfo(request.getAuditInfo());
        if(request.getAuditInfo() !=null){
            updateRequest.getAuditInfo().setBusinessEventReason("Multi-Account Selection");
        }
        return updateRequest;
    }

    private void copyToPayload(com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.RequestPayload pl, com.td.mbna.msec.midtier.customerprofile.payload.ProfileUpdateType profileUpdateType) throws Exception {
        if (profileUpdateType.getEmployerPostalCode() != null) {
            profileUpdateType.setEmployerPostalCode(profileUpdateType.getEmployerPostalCode().replaceAll(" ", ""));
        }
        PropertyUtils.copyProperties(pl, profileUpdateType);

        pl.setCustId(profileUpdateType.getCustId());
        pl.setAcctId(profileUpdateType.getAcctId());
        pl.setAliasCustomerID(profileUpdateType.getAliasCustomerID());
        pl.setEmail(profileUpdateType.getEmail());
        pl.setAuthorizedUser(profileUpdateType.getIsPrimaryUser() == null ? false : !profileUpdateType.getIsPrimaryUser() );
    }


    private boolean validateMultiProfileRequest(com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest updateRequest) {
    	
    	String methodName = "UpdateCustomerProfileOperation::validateMultiProfileRequest"; 
    	
    	ValidationException faultInfoForAllProfiles = new ValidationException();
    	
    	for (com.td.mbna.msec.midtier.customerprofile.payload.ProfileUpdateType profileUpdateType : updateRequest.getRequestPayload().getMultiProfilesRq()) {
    		ValidationException faultInfo = null;
    		try {
				faultInfo = msecMultiProfileValidator.validate(profileUpdateType);
			} catch (Exception e) {
				String message = " msecMultiProfileValidator.validate(profileUpdateType) validate request for customer multi profiles failed!";
    			logger.error(methodName, message, e);
			}
    		
    		if (faultInfo != null && faultInfo.getFieldError() != null && faultInfo.getFieldError().size() > 0) {
    			faultInfoForAllProfiles.getFieldError().addAll(faultInfo.getFieldError());
    		}
    	}
    	
    	if (!faultInfoForAllProfiles.getFieldError().isEmpty()) {
    		throw faultInfoForAllProfiles;
    	}
		return true;
	}
    
    private UpdateCustomerProfileResponse updateMultiProfiles(com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest updateRequest, String ...token)
            throws Exception {
    	String methodName = "UpdateCustomerProfileOperation::updateMultiProfiles"; 
        ParallelServiceCaller updateUserSvcCaller = new ParallelServiceCaller();
        for (com.td.mbna.msec.midtier.customerprofile.payload.ProfileUpdateType profileUpdateType : updateRequest.getRequestPayload().getMultiProfilesRq()) {
            scheduleServiceCall(updateUserSvcCaller, generateRequest(profileUpdateType, updateRequest), token);
        }

        try {
			updateUserSvcCaller.sync();
		} catch (Exception e) {
			String message = " updateUserSvcCaller.sync() failed!";
			logger.error(methodName, message, e);
			throw ExceptionUtil.genRuntimeException(e);
		}

        return generateResponse(updateRequest, updateUserSvcCaller);
    }
    private UpdateCustomerProfileResponse generateResponse(com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest updateRequest,
                                                           ParallelServiceCaller updateUserSvcCaller) throws Exception {

        UpdateCustomerProfileResponse response = new UpdateCustomerProfileResponse();
        UpdateCustomerProfileResponse.ResponsePayload pl = new UpdateCustomerProfileResponse.ResponsePayload();
        response.setResponsePayload(pl);
        
        for (com.td.mbna.msec.midtier.customerprofile.payload.ProfileUpdateType profileUpdateType : updateRequest.getRequestPayload().getMultiProfilesRq()) {
        	if(profileUpdateType == null){
        		continue;
        	}
            UpdateCustomerProfileResponse rs = updateUserSvcCaller.getResponse(profileUpdateType.getAcctId(), UpdateCustomerProfileResponse.class);

            ProfileUpdateType updateType = new ProfileUpdateType();
            if(rs != null){
            	PropertyUtils.copyProperties(updateType, rs.getResponsePayload());
            	updateType.setStatus(rs.getResponsePayload().isStatus());
            	updateType.getErrorMsgs().addAll(rs.getErrorMsgs());
            }
            updateType.setAuditInfo(JAXBJsonConverter.convertJsonToJAXBInterface(updateRequest.getAuditInfo(), AuditLogType.class));
            updateType.setLanguagePref(updateRequest.getLanguagePref());

            response.getResponsePayload().getMultiProfilesRs().add(updateType);
        }

        return response;
    }
    
    private UpdateCustomerProfileResponse updateCustomerProfile(com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest jsonUpdateRequest, String... token) {
    	String methodName = "UpdateCustomerProfileOperation::updateCustomerProfile"; 
    	com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.RequestPayload payload = jsonUpdateRequest.getRequestPayload();
		final StatusFlags status = new StatusFlags();
		this.init(status);

        //MDM does not support income frequency, it will be stored as yearly
        //Convert income to yearly based on income frequency from UI
        String incomeFrenquency = payload.getIncomeFrequency();
        BigDecimal income = payload.getIncome();
        if (income != null) {
            payload.setIncome(IncomeUtil.convertIncome(incomeFrenquency, income));
            payload.setIncomeFrequency(IncomeUtil.YEARLY);
        }

        if (payload.getHasOtherIncome() != null && payload.getHasOtherIncome()) {
            String otherIncomeFrenquency = payload.getOtherIncomeFrequency();
            BigDecimal otherIncome = payload.getOtherIncome();
            payload.setOtherIncome(IncomeUtil.convertIncome(otherIncomeFrenquency, otherIncome));
            payload.setOtherIncomeFrequency(IncomeUtil.YEARLY);
        }
        
        //1
        RetrieveCustomerProfileResponse.ResponsePayload retvPayload  = null;
        if(jsonUpdateRequest.getRequestPayload().isEmailUpdateOnly()){
        	retvPayload = checkEmailChange(jsonUpdateRequest, status);
        }else{
        	retvPayload = checkProfileChanges(jsonUpdateRequest, status);
        }

        UpdateCustomerProfileResponse xResponse = new UpdateCustomerProfileResponse();
        UpdateCustomerProfileResponse.ResponsePayload xResponsePayLoad = new UpdateCustomerProfileResponse.ResponsePayload();
        xResponse.setResponsePayload(xResponsePayLoad);
        boolean result = false;

        // If any of the timestamps are different, that means the values have been changed by another channel. The operation will fail and the user will have to invoke
        // the application again
        StringBuilder sb = compareTimestamps(payload, retvPayload);
        if (sb.length() > 0l) {
        	String message = "UpdateCustomerProfile timestamp mismatch: errors in  "+sb.toString();
        	logger.error(methodName, message);
        	throw ExceptionUtil.genBusinessException(ErrorCode,message); 
        }

        /*Updating AU info in updateprofile page -MBNA-314---Starts here	*/

        List<com.td.mbna.msec.midtier.customerprofile.payload.AccountKycAuInfoType> updatedAuList = jsonUpdateRequest.getRequestPayload().getAuthorizedUsers();
        List<AccountKycAuInfoType> initialAuList = retvPayload.getAuthorizedUsers();

		/*creating a map of all the AU CODS request objects which has been modified by the user.
		Also map of status flags for the changed AU is created as well*/
        Map<String, TEnvUpdateCustomerProfileRq> authorizedUsersReqMap = new HashMap<String, TEnvUpdateCustomerProfileRq>();
        Map<String, StatusFlags> authroizedUsersChangesMap = new HashMap<String, StatusFlags>();

        for (com.td.mbna.msec.midtier.customerprofile.payload.AccountKycAuInfoType updatedAu : updatedAuList) {
        	if(updatedAu == null){
        		continue;
        	}
            for (AccountKycAuInfoType initialAu : initialAuList) {
            	if(initialAu == null){
            		continue;
            	}
                if (updatedAu.getKycAliasCustomerID().equals(initialAu.getKycAliasCustomerID())) {
                    //verifying the changes
                    try {
                        checkAuthorizedUserChanges(authorizedUsersReqMap, authroizedUsersChangesMap, updatedAu, initialAu);
                    } catch (BusinessException e) {
                        String errorCode = e.getFaultInfo() != null ? e.getFaultInfo().getErrorCode() : GENERAL_ERROR;
                        String message = "Error in checking authorized user changes";
                        logger.error(methodName, message,e);
                        throw ExceptionUtil.genBusinessException(errorCode,message);
                    }
                }
            }
        }

        /*Updating AU info in updateprofile page -MBNA-314---Ends here	*/

        // check if address changes is allow
        //   1. only primary user can make changes
        //   2. primary user cannot change authorized user's physical address
        if (status.physicalAddressState.isChanged() || status.mailAddressState.isChanged()) {
            if (jsonUpdateRequest.getIsPrimaryUser() != null && jsonUpdateRequest.getIsPrimaryUser()) {
            	if (jsonUpdateRequest.getRequestPayload().getAuthorizedUser()) {
            		status.physicalAddressState.setChanged(false);
            	}
            } else {
            	String message = "Address update is not allowed for AU";
            	logger.error(methodName, message);
            	throw ExceptionUtil.genBusinessException("MS552",message);
            }
        }


        // 
        try {
            result = updateCustomerProfileODS(status, 
            		jsonUpdateRequest, 
            		authorizedUsersReqMap, 
            		authroizedUsersChangesMap, 
            		xResponse, 
            		retvPayload);
        } catch (Exception e) {
        	String message = "updateCustomerProfileODS failed";
        	logger.error(methodName, message,e);
           throw ExceptionUtil.genBusinessException(GENERAL_ERROR,message);
        }

        //something changed. SS1203 is for update profile. SS2510 is for KYC. Both indicate profile changed.
        if (result) {
            if (jsonUpdateRequest.getRequestPayload().getMultiProfilesRq() != null && jsonUpdateRequest.getRequestPayload().getMultiProfilesRq().size() > 0) {
                jsonUpdateRequest.getAuditInfo().setBusinessEventReason(MILTI_ACCOUNT_SELECTION);
            }
            genAuditLog(jsonUpdateRequest, "SS1203", AuditService.TRANSACTION_SUCCESS, null);
        }

        // if not change at all. SS1204 is for update profile, SS2520 is for KYC. Both indicate no change to profile
        if (!(result || status.preferenceState.isChanged() || status.otherState.isChanged() || isTrigerContactUpdate(status))) {
            genAuditLog(jsonUpdateRequest, "SS1204", null, null);
        }

        try {
            // Finally create email if any changes
            if (isChangesToTriggerNotes(status, authroizedUsersChangesMap)) {
                callEmailNotification(jsonUpdateRequest, status, token);
            }
        } catch (Exception e) {
        	String message = "isChangesToTriggerNotes or callEmailNotification failed";
        	logger.error(methodName, message,e);
            throw ExceptionUtil.genBusinessException(GENERAL_ERROR,message);
        }
        
        try {
        	//We always need to create notes so we can get KYC no changes
        	createCustomerNotes(jsonUpdateRequest, retvPayload, status, authroizedUsersChangesMap, token);
        } catch (Exception e) {
        	String message = "createCustomerNotes failed";
        	logger.error(methodName, message,e);
        	throw ExceptionUtil.genBusinessException(GENERAL_ERROR,message);
        }

        xResponsePayLoad.setStatus(true);
        return xResponse;

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

    // this is to keep track of what fields are changed for the PCH or AU. Used for audit logging and customer notes
    private static class StatusFlags {
        public CustomerState mailAddressState = null;
        public CustomerState emailState = null;
        public CustomerState phoneState = null;
        public CustomerState physicalAddressState = null;
        public CustomerState preferenceState = null;
        public CustomerState otherState = null;
        public RetrieveCustomerProfileResponse.ResponsePayload currentImagePayLoad = null;

        public boolean otherIncomeExists = false;
        public boolean primaryEmploymentChanged = false;
        public boolean otherIncomeChanged = false;
        public boolean primaryIncomeChanged = false;
        public BigDecimal existingOtherIncome = null;
        public String existingOtherIncomeSrc = null;
        private List<CustomerState> customerStateLst;

    }


    /**
     * Queues and sends AU update profile requets
     *
     * @param updateRequest             the PCH profile update request. The session information is in this object.
     * @param authorizedUsersReqMap     a map that contains a list of authorized users requests
     * @param authroizedUsersChangesMap a map that contains what's changed for each AU
     * @param updateUserSvcCaller       the parallel service caller object.
     */
    private void queueAuRequests(
            final com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest updateRequest,
            Map<String, TEnvUpdateCustomerProfileRq> authorizedUsersReqMap,
            Map<String, StatusFlags> authroizedUsersChangesMap,
            final ParallelServiceCaller updateUserSvcCaller) {
    	
        if (authorizedUsersReqMap.isEmpty()) {
        	return;
        }
        
        String methodName = "UpdateCustomerProfileOperation::queueAuRequests"; 
        
        Templates td2mtResTranformer = null;
        try {
        	td2mtResTranformer = TransformUtil.getRsTemplate("odsSetKycAcctsInfoAu");
        } catch (Exception e) {
        	String message = "TransformUtil.getRsTemplate(odsSetKycAcctsInfoAu) failed";
        	logger.error(methodName, message, e);
        	throw ExceptionUtil.genBusinessException(message);
        }
        
        final Templates responseTemplate = td2mtResTranformer;
        final Map<String, StatusFlags> finalChangeMap = authroizedUsersChangesMap;
        
        for (String custId : authorizedUsersReqMap.keySet()) {
        	final TEnvUpdateCustomerProfileRq auRequest = authorizedUsersReqMap.get(custId);
        	final String auCustId = custId;
        	ServiceCall<?> updAuthorizedCall = new ServiceCall<SetKycAcctsInfoResponse>() {
        		@Override
        		public SetKycAcctsInfoResponse invoke() throws Exception {
        			
        			TEnvUpdateCustomerProfileRs res = null;
        			try {
        				res = TdOdsCustomerProfileService.updateCustomer(auRequest);
        				SetKycAcctsInfoResponse response = TransformUtil.transformRequest(responseTemplate, res, null, SetKycAcctsInfoResponse.class);
        				StatusFlags whatsChanged = finalChangeMap.get(auCustId);
        				
        				if (whatsChanged.phoneState.isChanged()) {
        					//AU phone changed
        					genAuditLog(updateRequest, "SS1217", null, auCustId);
        				}
        				if (whatsChanged.mailAddressState.isChanged()) {
        					//mailing address changed
        					genAuditLog(updateRequest, "SS1213", null, auCustId);
        				}
        				
        				return response;
        			} catch (Exception exp) {
        				logger.error("queueAuRequests", "queueAuRequests failed", exp);
        				genAuditLog(updateRequest, "SS1214", null, auCustId);
        				throw exp;
        			}
        		}
        	};
        	try {
        		updateUserSvcCaller.scheduleCall(auCustId, updAuthorizedCall);
        	} catch (Exception e) {
            	String message = "updateUserSvcCaller.scheduleCall(auCustId, updAuthorizedCall) failed";
            	logger.error(methodName, message, e);
            	throw ExceptionUtil.genBusinessException(message);
        	}
        }
    }
    private RetrieveCustomerProfileResponse.ResponsePayload checkEmailChange(final com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest updateRequest,
            StatusFlags status){
        RetrieveCustomerProfileResponse.ResponsePayload retvPayload = retrieveCustomerProfile(updateRequest, null);
        com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.RequestPayload updPayload = updateRequest.getRequestPayload();
        
        // set the existence flags for mailing address, telephones and email
        status.currentImagePayLoad = retvPayload;
        
        if (!updateRequest.getRequestPayload().getAuthorizedUser()) {

            // ----------------------------- Email ----------------------------------------------------
            compareFields(updPayload.getMarketingEmailWanted() == null ? false : updPayload.getMarketingEmailWanted().booleanValue(), retvPayload.isMarketingEmailWanted(), "MarketingEmailOption", status.preferenceState);
            compareFields(updPayload.getConfirmationEmailWanted() == null ? false : updPayload.getConfirmationEmailWanted().booleanValue() , retvPayload.isConfirmationEmailWanted(), "ConfirmationEmailOption", status.preferenceState);
            compareFields(updPayload.getEmail(), retvPayload.getEmail(), "Email", status.emailState);

        }

        return retvPayload;
    }

    private RetrieveCustomerProfileResponse.ResponsePayload checkProfileChanges(final com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest updateRequest,
                                                                                StatusFlags status) {
        RetrieveCustomerProfileResponse.ResponsePayload retvPayload = retrieveCustomerProfile(updateRequest, null);
        com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.RequestPayload updPayload = updateRequest.getRequestPayload();

        // set the existence flags for mailing address, telephones and email
        status.currentImagePayLoad = retvPayload;


        // ----------------------------- Mailing address ----------------------------------------------------
        compareFields(updPayload.getMailingAddressLine1(), retvPayload.getMailingAddressLine1(), "MailingAddressLine1", status.mailAddressState);
        compareFields(updPayload.getMailingAddressLine2(), retvPayload.getMailingAddressLine2(), "MailingAddressLine2", status.mailAddressState);
        compareFields(updPayload.getMailingCity(), retvPayload.getMailingCity(), "MailingCity", status.mailAddressState);

        String updMPC = updPayload.getMailingPostalCode();
        if (updMPC != null) {
        	updMPC = updMPC.replaceAll(" ", "");
        }
        
        String rtvMPC = retvPayload.getMailingPostalCode();
        if (rtvMPC != null) {
        	rtvMPC = rtvMPC.replaceAll(" ", "");
        }
        compareFields(updMPC, rtvMPC, "MailingPostalCode", status.mailAddressState);
        compareFields(updPayload.getMailingProvince(), retvPayload.getMailingProvince(), "MailingProvince", status.mailAddressState);


        // ----------------------------- Physical address ----------------------------------------------------

        // if user switch from different mailing address to same 
        // then GUI will not send the physical address
        // Action: physical address should be set to the mailing address
        // if getDifferentPhysicalAddress == false means the mailing address is the same as physical address, so copy physical address to 
        if (updPayload.getDifferentPhysicalAddress() == null || !updPayload.getDifferentPhysicalAddress()) {
            updPayload.setPhysicalAddressLine1(updPayload.getMailingAddressLine1());
            updPayload.setPhysicalAddressLine2(updPayload.getMailingAddressLine2());
            updPayload.setPhysicalCity(updPayload.getMailingCity());
            updPayload.setPhysicalPostalCode(updPayload.getMailingPostalCode());
            updPayload.setPhysicalProvince(updPayload.getMailingProvince());
        }

        //Only compare the physical addresses if
        // either current or update profile has physical address and the other doesn't
        // or the updated payload has a physical address
        ///the physical address in the retrieve payload is always 1 line
        //but the physical address in the update payload could be in two lines because UI has two fields
        if (updPayload.getPhysicalAddressLine1() != null && updPayload.getPhysicalAddressLine1().trim().length() > 0) {

            String updatedPhysicalAddress = updPayload.getPhysicalAddressLine1() + " " + updPayload.getPhysicalAddressLine2();
            
            compareFields(updatedPhysicalAddress.trim(), retvPayload.getPhysicalAddressLine1(), "PhysicalAddressLine1", status.physicalAddressState);
            compareFields(updPayload.getPhysicalCity(), retvPayload.getPhysicalCity(), "PhysicalCity", status.physicalAddressState);
            
            String updPC = updPayload.getPhysicalPostalCode();
            String retvPC = retvPayload.getPhysicalPostalCode();
            
            if (updPC != null) {
            	updPC = updPC.replaceAll(" ", "");
            }
            if (retvPC != null) {
            	retvPC = retvPC.replaceAll(" ", "");
            }
            compareFields(updPC, retvPC, "PhysicalPostalCode", status.physicalAddressState);
            compareFields(updPayload.getPhysicalProvince(), retvPayload.getPhysicalProvince(), "PhysicalProvince", status.physicalAddressState);
        }

        //now check if mailing address is changed. If mailing address and physical addresses are changed at the same time, we should only send one email
        if (status.mailAddressState.changed == true && status.physicalAddressState.changed == true) {
            status.physicalAddressState.setSendNotification(false); // sending the email notification for physical address to false so we dont' send another email to the customer.
        }

        // ----------------------------- Phones ----------------------------------------------------
        compareFields(updPayload.getBusinessPhone(), retvPayload.getBusinessPhone(), "BusinessPhone", status.phoneState);
        compareFields(updPayload.getHomePhone(), retvPayload.getHomePhone(), "HomePhone", status.phoneState);
        compareFields(updPayload.getMobilePhone(), retvPayload.getMobilePhone(), "MobilePhone", status.phoneState);

        if (!updateRequest.getRequestPayload().getAuthorizedUser()) {


            // ----------------------------- Email ----------------------------------------------------
            compareFields(updPayload.getMarketingEmailWanted() == null ? false :updPayload.getMarketingEmailWanted().booleanValue(), retvPayload.isMarketingEmailWanted(), "MarketingEmailOption", status.preferenceState);
            compareFields(updPayload.getConfirmationEmailWanted() == null ? false : updPayload.getConfirmationEmailWanted().booleanValue() , retvPayload.isConfirmationEmailWanted(), "ConfirmationEmailOption", status.preferenceState);
            compareFields(updPayload.getEmail(), retvPayload.getEmail(), "Email", status.emailState);

            // ----------------------------- Primary Income
            compareFields(updPayload.getIncome(), retvPayload.getIncome(), "Income", status.otherState);
            status.primaryIncomeChanged = status.otherState.isChanged();
            // Do not reset status.otherState. primaryEmploymentChanged will include primaryIncome information.

            // ----------------------------- Employment -------------------------------------------------------
            compareFields(updPayload.getEmployerName(), retvPayload.getEmployerName(), "EmployerName", status.otherState);
            compareFields(updPayload.getEmployerAddress(), retvPayload.getEmployerAddress(), "EmployerAddress", status.otherState);
            compareFields(updPayload.getEmployerCity(), retvPayload.getEmployerCity(), "EmployerCity", status.otherState);
            compareFields(updPayload.getEmployerProvince(), retvPayload.getEmployerProvince(), "EmployerProvince", status.otherState);
            compareFields(updPayload.getEmployerPostalCode(), retvPayload.getEmployerPostalCode(), "EmployerPostalCode", status.otherState);
            compareFields(updPayload.getEmployerPhone(), retvPayload.getEmployerPhone(), "EmployerPhone", status.otherState);
            compareFields(updPayload.getNatureOfBusiness(), retvPayload.getNatureOfBusiness(), "NatureOfBusiness", status.otherState);
            compareFields(updPayload.getEmploymentStatus(), retvPayload.getEmploymentStatus(), "EmploymentStatus", status.otherState);
            compareFields(updPayload.getOccupation(), retvPayload.getOccupation(), "Occupation", status.otherState);
            compareFields(updPayload.getPosition(), retvPayload.getPosition(), "Position", status.otherState);

            status.primaryEmploymentChanged = status.otherState.isChanged();
            status.otherState.setChanged(false);

            compareFields(updPayload.getHasOtherIncome() == null ? false : updPayload.getHasOtherIncome().booleanValue(), retvPayload.isHasOtherIncome(), "OtherIncome", status.otherState);
            
            if (updateRequest.getRequestPayload().getHasOtherIncome() != null && updateRequest.getRequestPayload().getHasOtherIncome()) {
                compareFields(updPayload.getOtherIncome(), retvPayload.getOtherIncome(), "OtherIncome", status.otherState);
                compareFields(updPayload.getOtherIncomeSource(), retvPayload.getOtherIncomeSource(), "OtherIncomeSource", status.otherState);
            }
            
            status.otherIncomeExists = retvPayload.isHasOtherIncome();
            
            if (status.otherIncomeExists) {
                status.existingOtherIncome = retvPayload.getOtherIncome();
                status.existingOtherIncomeSrc = retvPayload.getOtherIncomeSource();

            }
            status.otherIncomeChanged = status.otherState.isChanged();
            status.otherState.setChanged(status.primaryEmploymentChanged || status.otherIncomeChanged);
        }

        return retvPayload;
    }

    private void checkAuthorizedUserChanges(
            Map<String, TEnvUpdateCustomerProfileRq> authorizedUsersReqMap,
            Map<String, StatusFlags> authroizedUsersChangesMap,
            com.td.mbna.msec.midtier.customerprofile.payload.AccountKycAuInfoType updatedAu,
            AccountKycAuInfoType initialAu) throws BusinessException {

        final StatusFlags auStatusFlags = new StatusFlags();
        this.init(auStatusFlags);
        String methodName = "UpdateCustomerProfileOperation::checkAuthorizedUserChanges"; 

        boolean userInfoChanged = false;
        Map<String, Object> updParamValues = new HashMap<String, Object>();
        updParamValues.put(CustomerProfileUtil.PARTY_ID, updatedAu.getKycAuCustAcctInfo().getCustId());
        updParamValues.put(CustomerProfileUtil.USER_ROLE, CustomerProfileUtil.XSL_ROLE_CODE_AUTHORIZED);
        updParamValues.put(CustomerProfileUtil.ACCOUNT_NUMBER, updatedAu.getKycAuCustAcctInfo().getAcctNum());
        updParamValues.put(CustomerProfileUtil.ALIAS_CUSTOMER_ID, updatedAu.getKycAliasCustomerID());
        updParamValues.put(CustomerProfileUtil.XSL_PERSON_LASTUPDATEDTS, initialAu.getKycPersonLastUpdatedTS());
        updParamValues.put(CustomerProfileUtil.XSL_BOOK_OF_BUSINESS_LASTUPDATEDTS, initialAu.getKycBookOfBusLastUpdatedTS());
        updParamValues.put(CustomerProfileUtil.XSL_PARTYAGREEMENT_LASTUPDATEDTS, initialAu.getKycAuCustAcctInfo().getPartyAgreementLastUpdatedTS());
        updParamValues.put("trackId", UuidUtil.genUuid());
        SimpleDateFormat dateFmt = new SimpleDateFormat(CustomerProfileUtil.START_DATE_FMT);
        updParamValues.put(CustomerProfileUtil.XSL_START_DATE, dateFmt.format(new Date()));

        // Making sure we have the correct time stamp before submitting.
        if (!CustomerProfileUtil.compareUpdateTS(updatedAu.getKycAuCustAcctInfo().getMailingLastUpdatedTS(), initialAu.getKycAuCustAcctInfo().getMailingLastUpdatedTS()) ||
                !CustomerProfileUtil.compareUpdateTS(updatedAu.getKycAuCustAcctInfo().getBusinessPhoneLastUpdatedTS(), initialAu.getKycAuCustAcctInfo().getBusinessPhoneLastUpdatedTS()) ||
                !CustomerProfileUtil.compareUpdateTS(updatedAu.getKycAuCustAcctInfo().getMobilePhoneLastUpdatedTS(), initialAu.getKycAuCustAcctInfo().getMobilePhoneLastUpdatedTS()) ||
                !CustomerProfileUtil.compareUpdateTS(updatedAu.getKycAuCustAcctInfo().getHomePhoneLastUpdatedTS(), initialAu.getKycAuCustAcctInfo().getHomePhoneLastUpdatedTS())) {
        	com.td.mbna.msec.midtier.types.common.BusinessException faultInfo = new com.td.mbna.msec.midtier.types.common.BusinessException();
            faultInfo.setErrorDescription(ErrorCode);
            faultInfo.setErrorCode(ErrorCode);
            faultInfo.setErrorSource("UpdateCustomerProfileOperationRealImpl");
            String message = "CustomerProfile -authorized users timestamp mismatch";
            logger.error(methodName, message);
            throw new com.td.mbna.msec.midtier.exceptions.BusinessException(message, faultInfo);

        }


        /*------------------------------------------------------------------------------------------*/
        /********* Authorized user::::::  Mailing address section  **********************************/
        /*------------------------------------------------------------------------------------------*/

        updParamValues.put(CustomerProfileUtil.XSL_IS_MAILINGADDRESS_CHANGED, "false");
        // Setup MAILING(BILLING) Address;
        if (!compareAuFields(initialAu.getKycAuCustAcctInfo().getMailingAddressLine1(), updatedAu.getKycAuCustAcctInfo().getMailingAddressLine1(), "MailingAddressLine1", auStatusFlags.mailAddressState) ||
                !compareAuFields(initialAu.getKycAuCustAcctInfo().getMailingAddressLine2(), updatedAu.getKycAuCustAcctInfo().getMailingAddressLine2(), "MailingAddressLine2", auStatusFlags.mailAddressState) ||
                !compareAuFields(initialAu.getKycAuCustAcctInfo().getMailingCity(), updatedAu.getKycAuCustAcctInfo().getMailingCity(), "MailingCity", auStatusFlags.mailAddressState) ||
                !compareAuFields(initialAu.getKycAuCustAcctInfo().getMailingProvince(), updatedAu.getKycAuCustAcctInfo().getMailingProvince(), "MailingProvince", auStatusFlags.mailAddressState) ||
                !compareAuFields(initialAu.getKycAuCustAcctInfo().getMailingPostalCode(), updatedAu.getKycAuCustAcctInfo().getMailingPostalCode(), "MailingPostalCode", auStatusFlags.mailAddressState)) {
            userInfoChanged = true;

            updParamValues.put(CustomerProfileUtil.XSL_IS_MAILINGADDRESS_CHANGED, "true");
            if (initialAu.getKycAuCustAcctInfo().getMailingLastUpdatedTS() != null) {
                updParamValues.put(CustomerProfileUtil.XSL_IS_MAILINGADDRESS_PRESENT, "true");
                updParamValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_LASTUPDATEDTS, initialAu.getKycAuCustAcctInfo().getMailingLastUpdatedTS());
                updParamValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_ARGLOC_LASTUPDATEDTS, initialAu.getKycAuCustAcctInfo().getMailingArgLocLastUpdatedTS());
            } else {
                updParamValues.put(CustomerProfileUtil.XSL_IS_MAILINGADDRESS_PRESENT, "false");

            }

            updParamValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_LINEONE, updatedAu.getKycAuCustAcctInfo().getMailingAddressLine1());
            updParamValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_LINETWO, updatedAu.getKycAuCustAcctInfo().getMailingAddressLine2());
            updParamValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_LOCALITY, updatedAu.getKycAuCustAcctInfo().getMailingCity());
            updParamValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_AREA, updatedAu.getKycAuCustAcctInfo().getMailingProvince());
            updParamValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_COUNTRY, "CA"); // It has to be a Canada address. It is not allowed to modify non-canadian address
            updParamValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_POSTALCODE, updatedAu.getKycAuCustAcctInfo().getMailingPostalCode());
        }

        /*------------------------------------------------------------------------------------------*/
        /********* Authorized user::::::  Business Phone section  ***********************************/
        /*------------------------------------------------------------------------------------------*/
        updParamValues.put(CustomerProfileUtil.XSL_IS_BUSINESSPHONE_CHANGED, "false");
        if (!compareAuFields(initialAu.getKycAuCustAcctInfo().getBusinessPhone(), updatedAu.getKycAuCustAcctInfo().getBusinessPhone(), "BusinessPhone", auStatusFlags.phoneState)) {
            userInfoChanged = true;

            updParamValues.put(CustomerProfileUtil.XSL_IS_BUSINESSPHONE_CHANGED, "true");
            updParamValues.put(CustomerProfileUtil.XSL_BUSINESSPHONE_NUMBER, updatedAu.getKycAuCustAcctInfo().getBusinessPhone());
            if (initialAu.getKycAuCustAcctInfo().getBusinessPhoneLastUpdatedTS() != null) {
                updParamValues.put(CustomerProfileUtil.XSL_IS_BUSINESSPHONE_PRESENT, "true");
                updParamValues.put(CustomerProfileUtil.XSL_BUSINESSPHONE_LASTUPDATEDTS, initialAu.getKycAuCustAcctInfo().getBusinessPhoneLastUpdatedTS());
                updParamValues.put(CustomerProfileUtil.XSL_BUSINESSPHONE_LOC_LASTUPDATEDTS, initialAu.getKycAuCustAcctInfo().getBusinessPhoneLocLastUpdatedTS());

                // To remove, set the endTS
                if (updatedAu.getKycAuCustAcctInfo().getBusinessPhone() == null || updatedAu.getKycAuCustAcctInfo().getBusinessPhone().trim().length() == 0) {
                    updParamValues.put(CustomerProfileUtil.XSL_BUSINESSPHONE_ENDTS, dateFmt.format(new Date()));
                    updParamValues.put(CustomerProfileUtil.XSL_BUSINESSPHONE_NUMBER, initialAu.getKycAuCustAcctInfo().getBusinessPhone());
                } else {
                    updParamValues.put(CustomerProfileUtil.XSL_BUSINESSPHONE_ENDTS, "");
                }
            } else {
                updParamValues.put(CustomerProfileUtil.XSL_IS_BUSINESSPHONE_PRESENT, "false");
            }
        }

        /*------------------------------------------------------------------------------------------*/
        /*********** Authorized user::::::  Mobile Phone section  ***********************************/
        /*------------------------------------------------------------------------------------------*/
        updParamValues.put(CustomerProfileUtil.XSL_IS_MOBILEPHONE_CHANGED, "false");
        if (!compareAuFields(initialAu.getKycAuCustAcctInfo().getMobilePhone(), updatedAu.getKycAuCustAcctInfo().getMobilePhone(), "MobilePhone", auStatusFlags.phoneState)) {
            userInfoChanged = true;
            updParamValues.put(CustomerProfileUtil.XSL_IS_MOBILEPHONE_CHANGED, "true");
            updParamValues.put(CustomerProfileUtil.XSL_MOBILEPHONE_NUMBER, updatedAu.getKycAuCustAcctInfo().getMobilePhone());
            if (initialAu.getKycAuCustAcctInfo().getMobilePhoneLastUpdatedTS() != null) {
                updParamValues.put(CustomerProfileUtil.XSL_IS_MOBILEPHONE_PRESENT, "true");
                updParamValues.put(CustomerProfileUtil.XSL_MOBILEPHONE_LASTUPDATEDTS, initialAu.getKycAuCustAcctInfo().getMobilePhoneLastUpdatedTS());
                updParamValues.put(CustomerProfileUtil.XSL_MOBILEPHONE_LOC_LASTUPDATEDTS, initialAu.getKycAuCustAcctInfo().getMobilePhoneLocLastUpdatedTS());

                // To remove, set the endTS
                if (updatedAu.getKycAuCustAcctInfo().getMobilePhone() == null || updatedAu.getKycAuCustAcctInfo().getMobilePhone().trim().length() == 0) {
                    updParamValues.put(CustomerProfileUtil.XSL_MOBILEPHONE_ENDTS, dateFmt.format(new Date()));
                    updParamValues.put(CustomerProfileUtil.XSL_MOBILEPHONE_NUMBER, initialAu.getKycAuCustAcctInfo().getMobilePhone());
                } else {
                    updParamValues.put(CustomerProfileUtil.XSL_MOBILEPHONE_ENDTS, "");
                }
            } else {
                updParamValues.put(CustomerProfileUtil.XSL_IS_MOBILEPHONE_PRESENT, "false");
            }
        }
        /*------------------------------------------------------------------------------------------*/
        /************* Authorized user::::::  Home Phone section  ***********************************/
        /*------------------------------------------------------------------------------------------*/
        updParamValues.put(CustomerProfileUtil.XSL_IS_HOMEPHONE_CHANGED, "false");
        if (!compareAuFields(initialAu.getKycAuCustAcctInfo().getHomePhone(), updatedAu.getKycAuCustAcctInfo().getHomePhone(), "HomePhone", auStatusFlags.phoneState)) {
            userInfoChanged = true;
            updParamValues.put(CustomerProfileUtil.XSL_IS_HOMEPHONE_CHANGED, "true");
            updParamValues.put(CustomerProfileUtil.XSL_HOMEPHONE_NUMBER, updatedAu.getKycAuCustAcctInfo().getHomePhone());
            if (initialAu.getKycAuCustAcctInfo().getHomePhoneLastUpdatedTS() != null) {
                updParamValues.put(CustomerProfileUtil.XSL_IS_HOMEPHONE_PRESENT, "true");
                updParamValues.put(CustomerProfileUtil.XSL_HOMEPHONE_LASTUPDATEDTS, initialAu.getKycAuCustAcctInfo().getHomePhoneLastUpdatedTS());
                updParamValues.put(CustomerProfileUtil.XSL_HOMEPHONE_LOC_LASTUPDATEDTS, initialAu.getKycAuCustAcctInfo().getHomePhoneLocLastUpdatedTS());

                // To remove, set the endTS
                if (updatedAu.getKycAuCustAcctInfo().getHomePhone() == null || updatedAu.getKycAuCustAcctInfo().getHomePhone().trim().length() == 0) {
                    updParamValues.put(CustomerProfileUtil.XSL_HOMEPHONE_ENDTS, dateFmt.format(new Date()));
                    updParamValues.put(CustomerProfileUtil.XSL_HOMEPHONE_NUMBER, initialAu.getKycAuCustAcctInfo().getHomePhone());
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
                generatedReq = (TEnvUpdateCustomerProfileRq) BackEndSrvcUtil.genRequest2(null, 
                		TdOp_setKycAcctsInfoForAU, 
                		updParamValues, 
                		null, 
                		BackEndSrvcUtil.TDOperation.TdOdsCustomerProfileService_updateCustomerProfile);
            }
        } catch (Exception e) {
            String message = "failed to generate request for AU update:" + updatedAu.getKycAuCustAcctInfo().getCustId();
            logger.error(methodName, message, e);
            throw ExceptionUtil.genRuntimeException(e);
        }

        // Add the new request to the list
        if (generatedReq != null) {
            TEnvUpdateCustomerProfileRq auReq = authorizedUsersReqMap.get(updatedAu.getKycAuCustAcctInfo().getCustId());

            if (auReq == null) {
                authorizedUsersReqMap.put(updatedAu.getKycAuCustAcctInfo().getCustId(), generatedReq);
                authroizedUsersChangesMap.put(updatedAu.getKycAuCustAcctInfo().getCustId(), auStatusFlags);
            }
        }

    }

    private void createCustomerNotes(final com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest updateRequest,
                                     RetrieveCustomerProfileResponse.ResponsePayload retvPayload,
                                     StatusFlags status,
                                     Map<String, StatusFlags> authroizedUsersChangesMap,
                                     String ...token) {
        boolean anyChanges = false;
        List<String> customerNotesHeader = getHeader(updateRequest);

        for (Iterator<CustomerState> iterator = status.customerStateLst.iterator(); iterator.hasNext(); ) {
            CustomerState notes = iterator.next();
            if (notes.isChanged()) {
                anyChanges = true;
                createNotes(updateRequest, retvPayload, customerNotesHeader, notes, token);
            }
        }

        //creating customer notes for authorized users
        for (String auId : authroizedUsersChangesMap.keySet()) {
            StatusFlags auStatusFlag = authroizedUsersChangesMap.get(auId);

            for (Iterator<CustomerState> auIterator = auStatusFlag.customerStateLst.iterator(); auIterator.hasNext(); ) {
                CustomerState auNotes = auIterator.next();
                if (auNotes.isChanged()) {
                    anyChanges = true;
                    createAUNotes(updateRequest, retvPayload, customerNotesHeader, auNotes, auId, token);
                }
            }
        }
        if (!anyChanges)
            createNotes(updateRequest, retvPayload, customerNotesHeader, null, token);
    }

    private void createAUNotes(final com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest updateRequest,
                               final RetrieveCustomerProfileResponse.ResponsePayload retvPayload,
                               List<String> customerNotesHeader, CustomerState notes, String auId, String ...token) {
    	
    	List<String> customerNotesList = new ArrayList<String>();
    	customerNotesList.addAll(customerNotesHeader);
    	
    	com.td.mbna.msec.midtier.customerprofile.payload.CustomerAcctInfoType updatedAU = null;
    	CustomerAcctInfoType initialAU = null;
    	
    	//getting updated authorized user
    	for (com.td.mbna.msec.midtier.customerprofile.payload.AccountKycAuInfoType uAuth : updateRequest.getRequestPayload().getAuthorizedUsers()) {
    		if(uAuth == null){
    			continue;
    		}
    		if (uAuth.getKycAuCustAcctInfo().getCustId().equals(auId)) {
    			updatedAU = uAuth.getKycAuCustAcctInfo();
    		}
    	}
    	
    	//getting the initial authorized user
    	for (AccountKycAuInfoType iAuth : retvPayload.getAuthorizedUsers()) {
    		if(iAuth == null){
    			continue;
    		}
    		if (iAuth.getKycAuCustAcctInfo().getCustId().equals(auId)) {
    			initialAU = iAuth.getKycAuCustAcctInfo();
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	if (notes != null) {
    		logger.debug(notes.toString());
    		
    		switch (notes.getHeader()) {
    		case CustomerState.MAIL_ADDRESS_STATE:
    			sb.append("Mailing Address:");
    			sb.append(PREVIOUS);
    			sb.append(CustomerProfileUtil.formatCustomerNoteCommon(initialAU.getMailingAddressLine1())).append(SPACE);
    			sb.append(CustomerProfileUtil.formatCustomerNoteCommon(initialAU.getMailingAddressLine2())).append(SPACE);
    			sb.append(CustomerProfileUtil.formatCustomerNoteCommon(initialAU.getMailingCity())).append(COMMA_SPACE);
    			sb.append(initialAU.getMailingProvince()).append(SPACE);
    			sb.append(CustomerProfileUtil.formatCustomerNotesPostalCode(initialAU.getMailingPostalCode())).append(SPACE);
    			
    			sb.append(NEW);
    			sb.append(CustomerProfileUtil.formatCustomerNoteCommon(updatedAU.getMailingAddressLine1())).append(SPACE);
    			sb.append(CustomerProfileUtil.formatCustomerNoteCommon(updatedAU.getMailingAddressLine2())).append(SPACE);
    			sb.append(CustomerProfileUtil.formatCustomerNoteCommon(updatedAU.getMailingCity())).append(COMMA_SPACE);
    			sb.append(updatedAU.getMailingProvince()).append(SPACE);
    			sb.append(CustomerProfileUtil.formatCustomerNotesPostalCode(updatedAU.getMailingPostalCode()));
    			break;
    			
    		case CustomerState.PHONE_STATE:
    			sb.append("Phone:");
    			sb.append("Home");
    			sb.append(PREVIOUS);
    			sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(initialAU.getHomePhone())).append(SPACE);
    			
    			sb.append(NEW);
    			sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(updatedAU.getHomePhone()));
    			sb.append("Business");
    			sb.append(PREVIOUS);
    			sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(initialAU.getBusinessPhone())).append(SPACE);
    			
    			sb.append(NEW);
    			sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(updatedAU.getBusinessPhone()));
    			sb.append("Mobile");
    			sb.append(PREVIOUS);
    			sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(initialAU.getMobilePhone())).append(SPACE);
    			
    			sb.append(NEW);
    			sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(updatedAU.getMobilePhone()));
    			break;
    		}
    	}
    	customerNotesList.add(sb.toString());
    	
        try {
        	midtierExecutor.execute(() -> {
        		mbnaCCA.creatCustomerNotes(customerNotesList, updateRequest, token);
        	});
        } catch (Exception e) {
            logger.error("createAUNotes", "createAUNotes failed", e); //dont'throw the exception
        }
    }


    /**
     * Depending of the changes, creates customer notes with prior and new values of all the fields from
     * corresponding block of information : Mail address, E-mail, Phone. If any field from a block has been
     * changed all fields from block are listed in the notes.
     *
     * @param updateRequest
     * @param retvPayload
     * @param customerNotesHeader
     * @param notes
     * @throws BusinessError
     * @throws SystemError
     */
    private void createNotes(final com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest updateRequest,
                             final RetrieveCustomerProfileResponse.ResponsePayload retvPayload,
                             List<String> customerNotesHeader, CustomerState notes, String ...token) {
    	List<String> customerNotesList = new ArrayList<String>();
    	customerNotesList.addAll(customerNotesHeader);
    	com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.RequestPayload updPayload = updateRequest.getRequestPayload();
    	StringBuilder sb = new StringBuilder();
    	if (notes != null) {
    		logger.debug(notes.toString());
    		
    		switch (notes.getHeader()) {
    		case CustomerState.MAIL_ADDRESS_STATE:
    			sb.append("Mailing Address:");
    			sb.append(PREVIOUS);
    			sb.append(CustomerProfileUtil.formatCustomerNoteCommon(retvPayload.getMailingAddressLine1())).append(SPACE);
    			sb.append(CustomerProfileUtil.formatCustomerNoteCommon(retvPayload.getMailingAddressLine2())).append(SPACE);
    			sb.append(CustomerProfileUtil.formatCustomerNoteCommon(retvPayload.getMailingCity())).append(COMMA_SPACE);
    			sb.append(retvPayload.getMailingProvince()).append(SPACE);
    			sb.append(CustomerProfileUtil.formatCustomerNotesPostalCode(retvPayload.getMailingPostalCode())).append(SPACE);
    			
    			sb.append(NEW);
    			sb.append(CustomerProfileUtil.formatCustomerNoteCommon(updPayload.getMailingAddressLine1())).append(SPACE);
    			sb.append(CustomerProfileUtil.formatCustomerNoteCommon(updPayload.getMailingAddressLine2())).append(SPACE);
    			sb.append(CustomerProfileUtil.formatCustomerNoteCommon(updPayload.getMailingCity())).append(COMMA_SPACE);
    			sb.append(updPayload.getMailingProvince()).append(SPACE);
    			sb.append(CustomerProfileUtil.formatCustomerNotesPostalCode(updPayload.getMailingPostalCode()));
    			break;
    			
    		case CustomerState.PHYSICAL_ADDRESS_STATE:
    			sb.append("Physical Address:");
    			sb.append(PREVIOUS);
    			sb.append(CustomerProfileUtil.formatCustomerNoteCommon(retvPayload.getPhysicalAddressLine1())).append(SPACE);
    			sb.append(CustomerProfileUtil.formatCustomerNoteCommon(retvPayload.getPhysicalAddressLine2())).append(SPACE);
    			sb.append(CustomerProfileUtil.formatCustomerNoteCommon(retvPayload.getPhysicalCity())).append(COMMA_SPACE);
    			sb.append(retvPayload.getPhysicalProvince()).append(SPACE);
    			sb.append(CustomerProfileUtil.formatCustomerNotesPostalCode(retvPayload.getPhysicalPostalCode())).append(SPACE);
    			
    			sb.append(NEW);
    			sb.append(CustomerProfileUtil.formatCustomerNoteCommon(updPayload.getPhysicalAddressLine1())).append(SPACE);
    			sb.append(CustomerProfileUtil.formatCustomerNoteCommon(updPayload.getPhysicalAddressLine2())).append(SPACE);
    			sb.append(CustomerProfileUtil.formatCustomerNoteCommon(updPayload.getPhysicalCity())).append(COMMA_SPACE);
    			sb.append(updPayload.getPhysicalProvince()).append(SPACE);
    			sb.append(CustomerProfileUtil.formatCustomerNotesPostalCode(updPayload.getPhysicalPostalCode()));
    			break;
    			
    		case CustomerState.EMAIL_STATE:
    			sb.append("Email:");
    			sb.append(PREVIOUS);
    			sb.append(retvPayload.getEmail()).append(SPACE);
    			
    			sb.append(NEW);
    			sb.append(updPayload.getEmail());
    			break;
    			
    		case CustomerState.PREFERENCES_STATE:
    			boolean confirmEmailOptionChanged = retvPayload.isConfirmationEmailWanted() != (updPayload.getConfirmationEmailWanted() == null ? false : updPayload.getConfirmationEmailWanted().booleanValue());
    			boolean mkgEmailOptionChanged = retvPayload.isMarketingEmailWanted() != (updPayload.getMarketingEmailWanted() == null ? false : updPayload.getMarketingEmailWanted().booleanValue());
    			if (confirmEmailOptionChanged) {
    				sb.append("Send Confirmation Emails:");
    				sb.append(PREVIOUS);
    				sb.append(retvPayload.isConfirmationEmailWanted() ? "on" : "off").append(SPACE);
    				
    				sb.append(NEW);
    				sb.append((updPayload.getConfirmationEmailWanted() != null && updPayload.getConfirmationEmailWanted()) ? "on" : "off");
    			}
    			if (mkgEmailOptionChanged) {
    				if (confirmEmailOptionChanged) {
    					sb.append(SPACE).append(SPACE);
    				}
    				sb.append("Send Marketing Emails:");
    				sb.append(PREVIOUS);
    				sb.append(retvPayload.isMarketingEmailWanted() ? "on" : "off").append(SPACE);
    				sb.append(NEW);
    				sb.append((updPayload.getMarketingEmailWanted() != null && updPayload.getMarketingEmailWanted() )? "on" : "off");
    			}
    			
    			break;
    			
    		case CustomerState.PHONE_STATE:
    			sb.append("Phone:");
    			sb.append("Home");
    			sb.append(PREVIOUS);
    			sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(retvPayload.getHomePhone())).append(SPACE);
    			
    			sb.append(NEW);
    			sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(updPayload.getHomePhone()));
    			sb.append("Business");
    			sb.append(PREVIOUS);
    			sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(retvPayload.getBusinessPhone())).append(SPACE);
    			
    			sb.append(NEW);
    			sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(updPayload.getBusinessPhone()));
    			sb.append("Mobile");
    			sb.append(PREVIOUS);
    			sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(retvPayload.getMobilePhone())).append(SPACE);
    			
    			sb.append(NEW);
    			sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(updPayload.getMobilePhone()));
    			break;
    			
    		case CustomerState.OTHER_STATE:
    			sb.append("Employment:");
    			if ((notes.isFieldChanged("EmploymentStatus")) || (notes.isFieldChanged("Occupation")) || (notes.isFieldChanged("NatureOfBusiness")) || (notes.isFieldChanged("Position"))) {
    				sb.append(" Status");
    				sb.append(PREVIOUS);
    				sb.append(CustomerProfileUtil.formatCustomerNoteCommon(retvPayload.getEmploymentStatus()));
    				sb.append(COMMA);
    				sb.append(CustomerProfileUtil.getOccupationDescription(retvPayload.getOccupation()));
    				sb.append(COMMA);
    				sb.append(CustomerProfileUtil.formatCustomerNoteCommon(retvPayload.getNatureOfBusiness()));
    				sb.append(COMMA);
    				sb.append(CustomerProfileUtil.formatCustomerNoteCommon(retvPayload.getPosition())).append(SPACE);
    				
    				sb.append(NEW);
    				sb.append(CustomerProfileUtil.formatCustomerNoteCommon(updPayload.getEmploymentStatus()));
    				sb.append(COMMA);
    				sb.append(CustomerProfileUtil.getOccupationDescription(updPayload.getOccupation()));
    				sb.append(COMMA);
    				sb.append(CustomerProfileUtil.formatCustomerNoteCommon(updPayload.getNatureOfBusiness()));
    				sb.append(COMMA);
    				sb.append(CustomerProfileUtil.formatCustomerNoteCommon(updPayload.getPosition()));
    			}
    			
    			if (notes.isFieldChanged("EmployerName")) {
    				sb.append(" Employer Name");
    				sb.append(PREVIOUS);
    				sb.append(retvPayload.getEmployerName()).append(SPACE);
    				
    				sb.append(NEW);
    				sb.append(updPayload.getEmployerName());
    			}
    			if (notes.isFieldChanged("EmployerAddress")) {
    				sb.append(" Employer Address");
    				sb.append(PREVIOUS);
    				sb.append(CustomerProfileUtil.formatCustomerNoteCommon(retvPayload.getEmployerAddress())).append(SPACE);
    				sb.append(CustomerProfileUtil.formatCustomerNoteCommon(retvPayload.getEmployerCity())).append(COMMA_SPACE);
    				sb.append(retvPayload.getEmployerProvince()).append(SPACE);
    				sb.append(CustomerProfileUtil.formatCustomerNotesPostalCode(retvPayload.getEmployerPostalCode())).append(SPACE);
    				
    				sb.append(NEW);
    				sb.append(CustomerProfileUtil.formatCustomerNoteCommon(updPayload.getEmployerAddress())).append(SPACE);
    				sb.append(CustomerProfileUtil.formatCustomerNoteCommon(updPayload.getEmployerCity())).append(COMMA_SPACE);
    				sb.append(updPayload.getEmployerProvince()).append(SPACE);
    				sb.append(CustomerProfileUtil.formatCustomerNotesPostalCode(updPayload.getEmployerPostalCode()));
    			}
    			if (notes.isFieldChanged("EmployerPhone")) {
    				sb.append(" Employer Phone");
    				sb.append(PREVIOUS);
    				sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(retvPayload.getEmployerPhone())).append(SPACE);
    				
    				sb.append(NEW);
    				sb.append(CustomerProfileUtil.formatCustomerNotesPhoneNum(updPayload.getEmployerPhone()));
    			}
    			if (notes.isFieldChanged("Income")) {
    				// Please note income frequency is not needed because it's always annual
    				sb.append(" Income");
    				sb.append(PREVIOUS);
    				sb.append(CustomerProfileUtil.formatCustomerNotesIncome(retvPayload.getIncome())).append(SPACE);
    				
    				sb.append(NEW);
    				sb.append(CustomerProfileUtil.formatCustomerNotesIncome(updPayload.getIncome()));
    			}
    			if (notes.isFieldChanged("OtherIncome") || (notes.isFieldChanged("OtherIncomeSource"))) {
    				// Please note income frequency is not needed because it's always annual
    				sb.append(" Other Income");
    				sb.append(PREVIOUS);
    				sb.append(CustomerProfileUtil.formatCustomerNotesIncome(retvPayload.getOtherIncome())).append(SPACE);
    				sb.append(CustomerProfileUtil.formatCustomerNoteCommon(retvPayload.getOtherIncomeSource())).append(SPACE);
    				
    				sb.append(NEW);
    				sb.append(CustomerProfileUtil.formatCustomerNotesIncome(updPayload.getOtherIncome())).append(SPACE);
    				sb.append(CustomerProfileUtil.formatCustomerNoteCommon(updPayload.getOtherIncomeSource()));
    			}
    			break;
    		}
    	}
    	customerNotesList.add(sb.toString());
        try {
        	midtierExecutor.execute(() -> {
        		mbnaCCA.creatCustomerNotes(customerNotesList, updateRequest, token);
        	});
        } catch (Exception e) {
            logger.error("createNotes","createNotes failed", e); //dont'throw the exception
        }
    }

    /**
     * Creates a header for customer notes depending whether any filed has been changed. Also
     * distinguish between KYC call and Customer Update call.
     *
     * @param request - request for an update.
     * @return - list of string for notes header.
     */
    private List<String> getHeader(BaseRequest request) {
        String headerCaption;

        headerCaption = "Update Profile";

        List<String> customerNotes = new ArrayList<String>();
        customerNotes.add(getHeaderContent(request, headerCaption));
        if (headerCaption.equals(CustomerProfileUtil.CONFIRM_KYC)) {
            customerNotes.add("KYC confirmed (no changes)");
        }
        return customerNotes;
    }

    private final static String DATE_TIME = "Date/Time: ";
    private final static String REQUEST_ORIGIN = "  Origin of request: OLB  Action performed: ";
    private final static String PRIMARY = "Primary";
    private final static String AUTHORIZED = "Authorized";
    private final static String USER = "  Initiating User: ";
    private final static String DASH = "-";
    private static final String SINGLE_SPACE = " ";
    private static final String SPACE_SEPARATOR = "  ";

    // copy from CustomerNotesUtil
    private static String getHeaderContent(BaseRequest baseRequest,String actionPerformed) {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(DATE_TIME);
        synchronized(formatDate){
            strBuilder.append(formatDate.format(new Date()));
        }
        strBuilder.append(REQUEST_ORIGIN);
        strBuilder.append(actionPerformed);
        strBuilder.append(USER);
        strBuilder.append((baseRequest.getIsPrimaryUser() == null ? false : baseRequest.getIsPrimaryUser().booleanValue()) ? PRIMARY : AUTHORIZED);
        strBuilder.append(SINGLE_SPACE);
        strBuilder.append(DASH);
        strBuilder.append(SINGLE_SPACE);
        strBuilder.append(baseRequest.getSessionInfo().getFirstName());
        strBuilder.append(SINGLE_SPACE);
        strBuilder.append(baseRequest.getSessionInfo().getLastName());
        strBuilder.append(SPACE_SEPARATOR);
        return strBuilder.toString();
    }


    /**
     * This function queues services calls to CODS for PCH and AU. Audit logging specific to the person is also done inside this function.
     *
     * @param status                    status object that keeps track of which PCH field is updated
     * @param updateRequest             The PCH update profile request
     * @param authorizedUsersReqMap     a map that contains a list of authorized users requests
     * @param authroizedUsersChangesMap a map that contains what's changed for each AU
     * @param response
     * @param retvPayload
     * @return
     * @throws Exception
     */
    private boolean updateCustomerProfileODS(
            final StatusFlags status,
            final com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest updateRequest,
            Map<String, TEnvUpdateCustomerProfileRq> authorizedUsersReqMap,
            Map<String, StatusFlags> authroizedUsersChangesMap,
            UpdateCustomerProfileResponse response,
            RetrieveCustomerProfileResponse.ResponsePayload retvPayload) throws Exception {
    	
    	String methodName = "UpdateCustomerProfileOperation::checkAuthorizedUserChanges"; 
    	
        boolean changed = false;

        Map<String, Object> updParamValues = new HashMap<String, Object>();

        updParamValues.put(CustomerProfileUtil.PARTY_ID, updateRequest.getRequestPayload().getCustId());
        if (updateRequest.getRequestPayload().getAuthorizedUser()){
            updParamValues.put(CustomerProfileUtil.USER_ROLE, CustomerProfileUtil.XSL_ROLE_CODE_AUTHORIZED);
        }else{
            updParamValues.put(CustomerProfileUtil.USER_ROLE, CustomerProfileUtil.XSL_ROLE_CODE_PRIMARY);
        }
        updParamValues.put(CustomerProfileUtil.ACCOUNT_NUMBER, updateRequest.getAcctNum());
        updParamValues.put(CustomerProfileUtil.ALIAS_CUSTOMER_ID, updateRequest.getRequestPayload().getAliasCustomerID());
        updParamValues.put("trackId", UuidUtil.genUuid());
        updParamValues.put(CustomerProfileUtil.XSL_PERSON_LASTUPDATEDTS, eifn(retvPayload.getPersonLastUpdatedTS()));
        updParamValues.put(CustomerProfileUtil.XSL_BOOK_OF_BUSINESS_LASTUPDATEDTS, eifn(retvPayload.getBookOfBusLastUpdatedTS()));
        updParamValues.put(CustomerProfileUtil.XSL_PARTYAGREEMENT_LASTUPDATEDTS, JAXBJsonConverter.convert(updateRequest.getRequestPayload().getPartyAgreementLastUpdatedTS()));
        SimpleDateFormat dateFmt = new SimpleDateFormat(CustomerProfileUtil.START_DATE_FMT);
        updParamValues.put(CustomerProfileUtil.XSL_START_DATE, dateFmt.format(new Date()));

        // Set up the map for updating Contacts
        if (isPhoneChanged("BusinessPhone", status)) {
            changed = true;
            updParamValues.put(CustomerProfileUtil.XSL_IS_BUSINESSPHONE_CHANGED, "true");
            setupBusinessPhoneParam(updParamValues, status, updateRequest);
        } else {
            updParamValues.put(CustomerProfileUtil.XSL_IS_BUSINESSPHONE_CHANGED, "false");
        }

        if (isPhoneChanged("HomePhone", status)) {
            changed = true;
            updParamValues.put(CustomerProfileUtil.XSL_IS_HOMEPHONE_CHANGED, "true");
            setupHomePhoneParam(updParamValues, status, updateRequest);
        } else {
            updParamValues.put(CustomerProfileUtil.XSL_IS_HOMEPHONE_CHANGED, "false");
        }

        if (isPhoneChanged("MobilePhone", status)) {
            changed = true;
            updParamValues.put(CustomerProfileUtil.XSL_IS_MOBILEPHONE_CHANGED, "true");
            setupMobilePhoneParam(updParamValues, status, updateRequest);
        } else {
            updParamValues.put(CustomerProfileUtil.XSL_IS_MOBILEPHONE_CHANGED, "false");
        }

        if (status.emailState.isChanged()) {
            changed = true;
            updParamValues.put(CustomerProfileUtil.XSL_IS_EMAIL_CHANGED, "true");
            setupEmailParam(updParamValues, status, updateRequest);
        } else {
            updParamValues.put(CustomerProfileUtil.XSL_IS_EMAIL_CHANGED, "false");
        }

        if (status.mailAddressState.isChanged()) {
            changed = true;
            updParamValues.put(CustomerProfileUtil.XSL_IS_MAILINGADDRESS_CHANGED, "true");
            setupMailingAddressParam(updParamValues, status, updateRequest);
        } else {
            updParamValues.put(CustomerProfileUtil.XSL_IS_MAILINGADDRESS_CHANGED, "false");
        }

        if (status.physicalAddressState.isChanged()) {
            changed = true;
            updParamValues.put(CustomerProfileUtil.XSL_IS_PHYSICALADDRESS_CHANGED, "true");
            setupPhysicalAddressParam(updParamValues, status, updateRequest);
        } else {
            updParamValues.put(CustomerProfileUtil.XSL_IS_PHYSICALADDRESS_CHANGED, "false");
        }

        // Set up the map for updating profile
        if (status.primaryEmploymentChanged) {
            changed = true;
            updParamValues.put(CustomerProfileUtil.XSL_IS_EMPLOYMENT_CHANGED, "true");
            setupEmploymentParam(updParamValues, status, updateRequest);
        } else {
            updParamValues.put(CustomerProfileUtil.XSL_IS_EMPLOYMENT_CHANGED, "false");
        }
        
        if (status.primaryIncomeChanged) {
        	changed = true;
        	updParamValues.put(CustomerProfileUtil.XSL_IS_PRIMARYINCOME_CHANGED, "true");        	
        }else{
        	updParamValues.put(CustomerProfileUtil.XSL_IS_PRIMARYINCOME_CHANGED, "false");        	
        }
        
        if (status.otherIncomeChanged) {
            changed = true;
            updParamValues.put(CustomerProfileUtil.XSL_IS_OTHERINCOME_CHANGED, "true");
            setupOtherIncomeParam(updParamValues, status, updateRequest);
        } else {
            updParamValues.put(CustomerProfileUtil.XSL_IS_OTHERINCOME_CHANGED, "false");
        }

        if (status.primaryIncomeChanged || status.otherIncomeChanged) {
            changed = true;
            updParamValues.put(CustomerProfileUtil.XSL_IS_GROSSINCOME_CHANGED, "true");
            setupGrossIncomeParam(updParamValues, status, updateRequest);
        } else {
            updParamValues.put(CustomerProfileUtil.XSL_IS_GROSSINCOME_CHANGED, "false");
        }
        
        final ParallelServiceCaller updateUserSvcCaller = new ParallelServiceCaller();
        queueAuRequests(updateRequest, authorizedUsersReqMap, authroizedUsersChangesMap, updateUserSvcCaller);
        //queueing up the PCH update call
        //at this point, the AU udpate calls have already been queued
        final Map<String, Object> finalUpdParamValues = updParamValues;
        final String loginId = updateRequest.getSessionInfo().getLoginId();
        ServiceCall<?> updPrimaryCall = null;
        if (changed) {
            updPrimaryCall = new ServiceCall<JAXBElement<CustomerProfileType>>() {
                @SuppressWarnings("unchecked")
                @Override
                public JAXBElement<CustomerProfileType> invoke() throws Exception {

                    JAXBElement<CustomerProfileType> odsUpdateResult = null;
                    JAXBContext mtJaxBContext = JaxbUtil.getJaxbContext("com.mbnaweb.xsd.msgs.customerprofile");

                    try {
                        odsUpdateResult = (JAXBElement<CustomerProfileType>) BackEndSrvcUtil.invokeService(
                                (String) null,
                                UPDATE_CUSTOMER_PROFILE,
                                UPDATE_CUSTOMER_PROFILE_RS,
                                TdOdsCustomerProfileService.TdOp_odsRetrieveCustomerProfile,
                                updateRequest.getSessionInfo().getLoginId(),
                                null,
                                null,
                                finalUpdParamValues,
                                null,
                                BackEndSrvcUtil.TDOperation.TdOdsCustomerProfileService_updateCustomerProfile,
                                mtJaxBContext);
                    } catch (Exception exp) {
                    	String message = "TdOdsCustomerProfileService_updateCustomerProfile failed";
                    	logger.error(methodName, message, exp);
                        genAuditLog(updateRequest, "SS1215", null, null);
                        throw exp;
                    }

                    return odsUpdateResult;
                }
            };

            try {
                updateUserSvcCaller.scheduleCall(loginId, updPrimaryCall);
            } catch (Exception e) {
            	String message = "updateUserSvcCaller.scheduleCall(loginId, updPrimaryCall) failed";
            	logger.error(methodName, message, e);
                throw ExceptionUtil.genRuntimeException(e);
            }

        }
        //send the parallel service calls, to update PCH and AU
        try {
			updateUserSvcCaller.sync();
		} catch (Exception e) {
			String message = "updateUserSvcCaller.sync() failed";
			logger.error(methodName, message, e);
			throw ExceptionUtil.genRuntimeException(e);
		}
        /**  check the parallel caller response map, if there's response whose key is an AU's ucid, that means that AU update was sucessful. **/
        if (authorizedUsersReqMap != null && authorizedUsersReqMap.size() > 0) {
            for (String auUCID : authorizedUsersReqMap.keySet()) {
                SetKycAcctsInfoResponse auUpdateResponse = (SetKycAcctsInfoResponse) updateUserSvcCaller.getResponse(auUCID, SetKycAcctsInfoResponse.class);
                if (auUpdateResponse != null) {
                    changed = true;
                    break;
                }
            }
        }

        // Save confirmation email option only if the ODS update is successful.
        // This would make the update profile screen seems "transactional" to the user
        // as the email option is not updated if the ODS operation failed.
        if (isConfirmationEmailOptionChanged(status)) {
            saveConfirmEmailOption(updateRequest);
            changed = true;
        }
        //was the update successful?
        CustomerProfileType custProf = null;
        JAXBElement<CustomerProfileType> odsResultFromParallelCallerRepMap = null;
        UpdateCustomerProfileResponse resp = null;
        if (updPrimaryCall != null) {
            //the PCH update never happened - nothing was changed.
            odsResultFromParallelCallerRepMap = updateUserSvcCaller.getResponse(loginId, updPrimaryCall.getResponseClassName());
            if (odsResultFromParallelCallerRepMap == null) {
                custProf = null;
                resp = new UpdateCustomerProfileResponse();
            } else {
                //PCH update was successful. I got a response resp
                custProf = odsResultFromParallelCallerRepMap.getValue();
                resp = CustomerProfileUtil.convertForUpdate(custProf);
            }
        }
        // Copy all the values from request to response
        PropertyUtils.copyProperties(response.getResponsePayload(), JAXBJsonConverter.convertJsonToJAXBInterface(updateRequest.getRequestPayload(), com.mbnaweb.xsd.msgs.customerprofile.UpdateCustomerProfileRequest.RequestPayload.class));
        //since PCH update is successful, updating the audit log

        /**  ============================= AUDIT LOGGING FOR PCH BEGINS =============================**/

        /**
         * Changing any employment demographic information should create SS2512 or SS1207
         * Changing any address (physical or mailing) should create SS2511 or SS1206
         * Changing the email address should create SS2513 or SS1208
         * Changing the email notifications in Update profile should create SS1209 if they turn notifications on or SS1210 if they turn notifications off
         * Changing the marketing email notifications in Update profile should create SS1211 if the turn notifications on or SS1212 if they turn notification off
         */

        if (status.otherState.isChanged()) {
            genAuditLog(updateRequest, "SS1207", null, null);
        }

        if (isTrigerContactUpdate(status)) {
            if (status.mailAddressState.isChanged() || status.physicalAddressState.isChanged()) {
                if (status.mailAddressState.isChanged()) {
                    updateResponseForMailing(response, resp);
                }
                if (status.physicalAddressState.isChanged()) {
                    updateResponseForPhysical(response, resp);
                }
                genAuditLog(updateRequest, "SS1206", null, loginId);
            }
            if (status.emailState.isChanged()) {
                if (updateRequest.getRequestPayload().getMultiProfilesRq() != null && updateRequest.getRequestPayload().getMultiProfilesRq().size() > 0) {
                    updateRequest.getAuditInfo().setBusinessEventReason(MILTI_ACCOUNT_SELECTION);
                }
                genAuditLog(updateRequest, "SS1208", null, loginId);
            }
        }

        if (status.phoneState.isChanged()) {
            genAuditLog(updateRequest, "SS1216", null, loginId);
        }

        /**  ============================= AUDIT LOGGING FOR PCH ENDS =============================**/
        return changed;
    }

    // Return an empty string if the input object is null.  This is needed since XSL does not accept null objects as parameters
    private static Object eifn(Object s) {
        return s == null ? "" : s;
    }

    private static RetrieveCustomerProfileResponse.ResponsePayload retrieveCustomerProfile(com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest updateRequest, RcpFilter requestFilter) {
    	
    	RetrieveCustomerProfileRequest retrieveCustomerProfileRequest = new RetrieveCustomerProfileRequest();
    	retrieveCustomerProfileRequest.setCustId(updateRequest.getCustId());
    	retrieveCustomerProfileRequest.setAcctNum(updateRequest.getAcctNum());
    	retrieveCustomerProfileRequest.setCustInterface(updateRequest.getCustInterface());
    	
    	RetrieveCustomerProfileRequest.RequestPayload rcpPayload = new RetrieveCustomerProfileRequest.RequestPayload();
    	retrieveCustomerProfileRequest.setRequestPayload(rcpPayload);
    	rcpPayload.setCustId(updateRequest.getRequestPayload().getCustId());
    	rcpPayload.setAcctNum(updateRequest.getRequestPayload().getAcctId());
    	rcpPayload.setAuthorizedUser(updateRequest.getRequestPayload().getAuthorizedUser());
    	rcpPayload.setCallContext("updateProfile");
    	
    	retrieveCustomerProfileRequest.setSessionInfo(JAXBJsonConverter.convertJsonToJAXBInterface(updateRequest.getSessionInfo(), TrackingInfoType.class));
    	RetrieveCustomerProfileResponse retrieveResponse = null;
    	
        try {
        	retrieveResponse = RetrieveCustomerProfileOperation.doRetrieveCustomerProfileViaOds(retrieveCustomerProfileRequest, requestFilter);
        	RetrieveCustomerProfileResponse.ResponsePayload retvPayload = retrieveResponse.getResponsePayload();
        	copyIdsForUpdateRequest(updateRequest,retvPayload);
        	return retvPayload;
        } catch (Exception e) {
            logger.error("retrieveCustomerProfile", "retrieveCustomerProfile failed", e);
            throw ExceptionUtil.genRuntimeException(e);
        }
    }

    private static void copyIdsForUpdateRequest(UpdateCustomerProfileRequest updateRequest,	ResponsePayload retvPayload) {
//    	updateRequest.getRequestPayload();
    	com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.RequestPayload requestPayload = updateRequest.getRequestPayload();
    	requestPayload.setEmploymentId(retvPayload.getEmploymentId());
    	requestPayload.setGrossIncomeId(retvPayload.getGrossIncomeId());
    	requestPayload.setIncomeId(retvPayload.getIncomeId());
    	requestPayload.setOtherIncomeId(retvPayload.getOtherIncomeId());
	}

	/**
     * Update the address in the response according to the response in the UpdateCustomerProfile
     */
    private void updateResponseForMailing(UpdateCustomerProfileResponse response, UpdateCustomerProfileResponse updateResult) {
        UpdateCustomerProfileResponse.ResponsePayload resp = response.getResponsePayload();
        UpdateCustomerProfileResponse.ResponsePayload updRes = updateResult.getResponsePayload();
        if (updRes.getMailingAddressLine1() != null && updRes.getMailingAddressLine1().trim().length() > 0) {
            resp.setMailingAddressLine1(updRes.getMailingAddressLine1());
            resp.setMailingAddressLine2(updRes.getMailingAddressLine2());
            resp.setMailingCity(updRes.getMailingCity());
            resp.setMailingPostalCode(updRes.getMailingPostalCode());
            resp.setMailingProvince(updRes.getMailingProvince());
        }
    }

    /**
     * Update the address in the response according to the response in the UpdateCustomerProfile
     */
    private void updateResponseForPhysical(UpdateCustomerProfileResponse response, UpdateCustomerProfileResponse updateResult) {
        UpdateCustomerProfileResponse.ResponsePayload resp = response.getResponsePayload();
        UpdateCustomerProfileResponse.ResponsePayload updRes = updateResult.getResponsePayload();
        resp.setPhysicalAddressLine1(updRes.getPhysicalAddressLine1());
        resp.setPhysicalCity(updRes.getPhysicalCity());
        resp.setPhysicalPostalCode(updRes.getPhysicalPostalCode());
        resp.setPhysicalProvince(updRes.getPhysicalProvince());
    }

    /**
     * Compare the timestamps. If the timestamps have been changed since the field values are displayed, then return
     * false
     */
    private StringBuilder compareTimestamps(com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.RequestPayload oriValue, RetrieveCustomerProfileResponse.ResponsePayload curValue) {
    	StringBuilder sb = new StringBuilder();
        // Check physical address
        if (!CustomerProfileUtil.compareUpdateTS(oriValue.getPhysicalLastUpdatedTS(), curValue.getPhysicalLastUpdatedTS())){
        	sb.append("physicalLastUpdatedTS; ");
            }

        // Check the business phone
        if (!CustomerProfileUtil.compareUpdateTS(oriValue.getBusinessPhoneLastUpdatedTS(), curValue.getBusinessPhoneLastUpdatedTS()))
        	sb.append("BusinessPhoneLastUpdatedTS; ");

        // Check the home phone
        if (!CustomerProfileUtil.compareUpdateTS(oriValue.getHomePhoneLastUpdatedTS(), curValue.getHomePhoneLastUpdatedTS()))
        	sb.append("HomePhoneLastUpdatedTS; ");

        // Check the mobile phone
        if (!CustomerProfileUtil.compareUpdateTS(oriValue.getMobilePhoneLastUpdatedTS(), curValue.getMobilePhoneLastUpdatedTS()))
        	sb.append("MobilePhoneLastUpdatedTS; ");

        // Check Email
        if (!CustomerProfileUtil.compareUpdateTS(oriValue.getEmailLastUpdatedTS(), curValue.getEmailLastUpdatedTS()))
        	sb.append("EmailLastUpdatedTS; ");
        
        if (!CustomerProfileUtil.compareUpdateTS(oriValue.getEmailAddressLastUpdatedTS(), curValue.getEmailAddressLastUpdatedTS()))
        	sb.append("EmailAddressLastUpdatedTS; ");

        // Check Personal info
        if (!CustomerProfileUtil.compareUpdateTS(oriValue.getPersonLastUpdatedTS(), curValue.getPersonLastUpdatedTS()))
        	sb.append("PersonLastUpdatedTS; ");

        // Check Address Mailing and Primary Residence
        if (!CustomerProfileUtil.compareUpdateTS(oriValue.getMailingLastUpdatedTS(), curValue.getMailingLastUpdatedTS()))
        	sb.append("MailingLastUpdatedTS; ");

        if (!CustomerProfileUtil.compareUpdateTS(oriValue.getMailingArgLocLastUpdatedTS(), curValue.getMailingArgLocLastUpdatedTS()))
        	sb.append("MailingArgLocLastUpdatedTS; ");

        // Check Employment, PrimIncome, OtherIncome,
        if (!CustomerProfileUtil.compareUpdateTS(oriValue.getEmploymentLastUpdatedTS(), curValue.getEmploymentLastUpdatedTS()))
        	sb.append("EmploymentLastUpdatedTS; ");
        if (!CustomerProfileUtil.compareUpdateTS(oriValue.getPrimIncomeLastUpdatedTS(), curValue.getPrimIncomeLastUpdatedTS()))
        	sb.append("PrimIncomeLastUpdatedTS; ");
        if (!CustomerProfileUtil.compareUpdateTS(oriValue.getOtherIncomeLastUpdatedTS(), curValue.getOtherIncomeLastUpdatedTS()))
        	sb.append("OtherIncomeLastUpdatedTS; ");
        // Marketing preference related timestamps
        if (!CustomerProfileUtil.compareUpdateTS(oriValue.getPersonalEmailLastUpdatedTS(), curValue.getPersonalEmailLastUpdatedTS()))
        	sb.append("PersonalEmailLastUpdatedTS; ");
        if (!CustomerProfileUtil.compareUpdateTS(oriValue.getPersonalEmailLocLastUpdatedTS(), curValue.getPersonalEmailLocLastUpdatedTS()))
        	sb.append("PersonalEmailLocLastUpdatedTS; ");
        return sb;
    }

    /**
     * Set the map for updating business phone
     */
    private void setupBusinessPhoneParam(Map<String, Object> paramValues, StatusFlags status, final com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest request) {
        //  phone changes
        com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.RequestPayload updPayload = request.getRequestPayload();
        paramValues.put(CustomerProfileUtil.XSL_BUSINESSPHONE_NUMBER, updPayload.getBusinessPhone());
        SimpleDateFormat dateFmt = new SimpleDateFormat(CustomerProfileUtil.DATE_FMT);
        if (status.currentImagePayLoad.getBusinessPhoneLastUpdatedTS() != null) {
            paramValues.put(CustomerProfileUtil.XSL_IS_BUSINESSPHONE_PRESENT, "true");
            paramValues.put(CustomerProfileUtil.XSL_BUSINESSPHONE_LASTUPDATEDTS, status.currentImagePayLoad.getBusinessPhoneLastUpdatedTS());
            paramValues.put(CustomerProfileUtil.XSL_BUSINESSPHONE_LOC_LASTUPDATEDTS, status.currentImagePayLoad.getBusinessPhoneLocLastUpdatedTS());

            // To remove, set the endTS
            if (updPayload.getBusinessPhone() == null || updPayload.getBusinessPhone().trim().length() == 0) {
                paramValues.put(CustomerProfileUtil.XSL_BUSINESSPHONE_ENDTS, dateFmt.format(new Date()));
                paramValues.put(CustomerProfileUtil.XSL_BUSINESSPHONE_NUMBER, status.currentImagePayLoad.getBusinessPhone());
            } else {
                paramValues.put(CustomerProfileUtil.XSL_BUSINESSPHONE_ENDTS, "");
            }
        } else {
            paramValues.put(CustomerProfileUtil.XSL_IS_BUSINESSPHONE_PRESENT, "false");
        }
    }

    /**
     * Set the map for updating home phone
     */
    private void setupHomePhoneParam(Map<String, Object> paramValues, StatusFlags status, final com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest request) {
        //  phone changes
        com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.RequestPayload updPayload = request.getRequestPayload();
        paramValues.put(CustomerProfileUtil.XSL_HOMEPHONE_NUMBER, updPayload.getHomePhone());
        SimpleDateFormat dateFmt = new SimpleDateFormat(CustomerProfileUtil.DATE_FMT);
        if (status.currentImagePayLoad.getHomePhoneLastUpdatedTS() != null) {
            paramValues.put(CustomerProfileUtil.XSL_IS_HOMEPHONE_PRESENT, "true");
            paramValues.put(CustomerProfileUtil.XSL_HOMEPHONE_LASTUPDATEDTS, status.currentImagePayLoad.getHomePhoneLastUpdatedTS());
            paramValues.put(CustomerProfileUtil.XSL_HOMEPHONE_LOC_LASTUPDATEDTS, status.currentImagePayLoad.getHomePhoneLocLastUpdatedTS());

            // To remove, set the endTS
            if (updPayload.getHomePhone() == null || updPayload.getHomePhone().trim().length() == 0) {
                paramValues.put(CustomerProfileUtil.XSL_HOMEPHONE_ENDTS, dateFmt.format(new Date()));
                paramValues.put(CustomerProfileUtil.XSL_HOMEPHONE_NUMBER, status.currentImagePayLoad.getHomePhone());
            } else {
                paramValues.put(CustomerProfileUtil.XSL_HOMEPHONE_ENDTS, "");
            }
        } else {
            paramValues.put(CustomerProfileUtil.XSL_IS_HOMEPHONE_PRESENT, "false");
        }
    }

    /**
     * Set the map for updating mobile phone
     */
    private void setupMobilePhoneParam(Map<String, Object> paramValues, StatusFlags status, final com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest request) {
        //  phone changes
        com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.RequestPayload updPayload = request.getRequestPayload();
        paramValues.put(CustomerProfileUtil.XSL_MOBILEPHONE_NUMBER, updPayload.getMobilePhone());
        SimpleDateFormat dateFmt = new SimpleDateFormat(CustomerProfileUtil.DATE_FMT);
        if (status.currentImagePayLoad.getMobilePhoneLastUpdatedTS() != null) {
            paramValues.put(CustomerProfileUtil.XSL_IS_MOBILEPHONE_PRESENT, "true");
            paramValues.put(CustomerProfileUtil.XSL_MOBILEPHONE_LASTUPDATEDTS, status.currentImagePayLoad.getMobilePhoneLastUpdatedTS());
            paramValues.put(CustomerProfileUtil.XSL_MOBILEPHONE_LOC_LASTUPDATEDTS, status.currentImagePayLoad.getMobilePhoneLocLastUpdatedTS());

            // To remove, set the endTS
            if (updPayload.getMobilePhone() == null || updPayload.getMobilePhone().trim().length() == 0) {
                paramValues.put(CustomerProfileUtil.XSL_MOBILEPHONE_ENDTS, dateFmt.format(new Date()));
                paramValues.put(CustomerProfileUtil.XSL_MOBILEPHONE_NUMBER, status.currentImagePayLoad.getMobilePhone());
            } else {
                paramValues.put(CustomerProfileUtil.XSL_MOBILEPHONE_ENDTS, "");
            }
        } else {
            paramValues.put(CustomerProfileUtil.XSL_IS_MOBILEPHONE_PRESENT, "false");
        }
    }

    /**
     * Set the map for updating email
     */
    private void setupEmailParam(Map<String, Object> paramValues, StatusFlags status, final com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest request) {
        //  email changes
        com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.RequestPayload updPayload = request.getRequestPayload();
        paramValues.put(CustomerProfileUtil.XSL_EMAIL_ADDRESS, updPayload.getEmail());
        SimpleDateFormat dateFmt = new SimpleDateFormat(CustomerProfileUtil.DATE_FMT);
        if (status.currentImagePayLoad.getEmailLastUpdatedTS() != null) {
            paramValues.put(CustomerProfileUtil.XSL_IS_EMAIL_PRESENT, "true");
            paramValues.put(CustomerProfileUtil.XSL_EMAIL_LASTUPDATEDTS, status.currentImagePayLoad.getEmailLastUpdatedTS());
            paramValues.put(CustomerProfileUtil.XSL_EMAILADDRESS_LASTUPDATEDTS, status.currentImagePayLoad.getEmailAddressLastUpdatedTS());

            // To remove, set the endTS
            if (updPayload.getEmail() == null || updPayload.getEmail().trim().length() == 0) {
                paramValues.put(CustomerProfileUtil.XSL_EMAIL_ENDTS, dateFmt.format(new Date()));
                paramValues.put(CustomerProfileUtil.XSL_EMAIL_ADDRESS, status.currentImagePayLoad.getEmail());
            } else {
                paramValues.put(CustomerProfileUtil.XSL_EMAIL_ENDTS, "");
            }
        } else {
            paramValues.put(CustomerProfileUtil.XSL_IS_EMAIL_PRESENT, "false");
        }
    }

    /**
     * Set the map for updating mailing address
     */
    private void setupMailingAddressParam(Map<String, Object> paramValues, StatusFlags status, final com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest request) {

        logger.debug("entering setupMailingAddressParam()");

        //  mailing address changes
        com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.RequestPayload updPayload = request.getRequestPayload();
        paramValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_LINEONE, updPayload.getMailingAddressLine1());

        logger.debug("mailing address line 1:" + updPayload.getMailingAddressLine1());
        logger.debug("mailing address line 2:" + updPayload.getMailingAddressLine2());
        paramValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_LINETWO, updPayload.getMailingAddressLine2());
        paramValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_LOCALITY, updPayload.getMailingCity());
        paramValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_AREA, updPayload.getMailingProvince());
        paramValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_COUNTRY, "CA"); // It has to be a Canada address
        paramValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_POSTALCODE, updPayload.getMailingPostalCode());

        if (status.currentImagePayLoad.getMailingLastUpdatedTS() != null) {
            paramValues.put(CustomerProfileUtil.XSL_IS_MAILINGADDRESS_PRESENT, "true");
            paramValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_LASTUPDATEDTS, status.currentImagePayLoad.getMailingLastUpdatedTS());
            paramValues.put(CustomerProfileUtil.XSL_MAILINGADDRESS_ARGLOC_LASTUPDATEDTS, status.currentImagePayLoad.getMailingArgLocLastUpdatedTS());
        } else {
            paramValues.put(CustomerProfileUtil.XSL_IS_MAILINGADDRESS_PRESENT, "false");
        }

        logger.debug("exiting setupMailingAddressParam()");
    }

    /**
     * Set the map for updating physical address
     */
    private void setupPhysicalAddressParam(Map<String, Object> paramValues, StatusFlags status, final com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest request) {
        logger.debug("entering setupPhysicalAddressParam()");
        //  physical address changes
        com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.RequestPayload updPayload = request.getRequestPayload();

        //UI has two fields, physical address 1 and physical address 2. But ODS only accepts 1 entry. So we have to combined the two input in UI
        String addrCombined = CustomerProfileUtil.normalizeSpace(updPayload.getPhysicalAddressLine1() + " " + updPayload.getPhysicalAddressLine2());
        logger.debug("combined pyhsical address: " + addrCombined);
        paramValues.put(CustomerProfileUtil.XSL_PHYSICALADDRESS_LINEONE, addrCombined);
        paramValues.put(CustomerProfileUtil.XSL_PHYSICALADDRESS_LOCALITY, updPayload.getPhysicalCity());
        paramValues.put(CustomerProfileUtil.XSL_PHYSICALADDRESS_AREA, updPayload.getPhysicalProvince());
        paramValues.put(CustomerProfileUtil.XSL_PHYSICALADDRESS_COUNTRY, "CA"); // It has to be a Canada address
        paramValues.put(CustomerProfileUtil.XSL_PHYSICALADDRESS_POSTALCODE, updPayload.getPhysicalPostalCode());

        /* Just change the content of physical address if it is the same as Mailing.*/
        paramValues.put(CustomerProfileUtil.XSL_PHYSICALADDRESS_ENDTS_NEEDED, "false");

        if (status.currentImagePayLoad.getPhysicalLastUpdatedTS() != null) {
            paramValues.put(CustomerProfileUtil.XSL_IS_PHYSICALADDRESS_PRESENT, "true");
            paramValues.put(CustomerProfileUtil.XSL_PHYSICALADDRESS_PARTYLOC_ADDR_LASTUPDATEDTS, status.currentImagePayLoad.getPhysicalLastUpdatedTS());
            paramValues.put(CustomerProfileUtil.XSL_PHYSICALADDRESS_PARTYLOC_LASTUPDATEDTS, status.currentImagePayLoad.getPhysicalPartyLocationLastUpdatedTS());
            paramValues.put(CustomerProfileUtil.XSL_PHYSICALADDRESS_PARTYLOCID, status.currentImagePayLoad.getPhysicalPartyLocationID());
        } else {
            paramValues.put(CustomerProfileUtil.XSL_IS_PHYSICALADDRESS_PRESENT, "false");
        }
        logger.debug("exiting setupPhysicalAddressParam()");
    }

    /**
     * Set the map for updating employment profile
     */
    private void setupEmploymentParam(Map<String, Object> paramValues, StatusFlags status, final com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest request) {
        //  Employment changes
        SimpleDateFormat dateFmt = new SimpleDateFormat(CustomerProfileUtil.DATE_FMT);
        com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.RequestPayload updPayload = request.getRequestPayload();
        if(updPayload.getIncomeId() != null){
        	paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_PRIMARYINCOME_ID, updPayload.getIncomeId());        	
        }
        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_PRIMARYINCOME, updPayload.getIncome() == null ? "" : updPayload.getIncome());
        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_POSITION, updPayload.getPosition() == null ? "" : updPayload.getPosition());
        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_OCCUPATION, updPayload.getOccupation() == null ? "" : updPayload.getOccupation());
        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_NATUREOFBUSINESS, updPayload.getNatureOfBusiness() == null ? "" : updPayload.getNatureOfBusiness());
        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_EMPLOYERNAME, updPayload.getEmployerName() == null ? "" : updPayload.getEmployerName());

        if (updPayload.getEmployerPhone() != null) {
            paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_PHONE_CHANGED, "true");
            paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_PHONE, updPayload.getEmployerPhone());
        } else {
            paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_PHONE_CHANGED, "false");
            paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_PHONE, "");
        }

        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_ADDRESS_LINEONE, updPayload.getEmployerAddress() == null ? "" : updPayload.getEmployerAddress());
        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_ADDRESS_LOCALITY, updPayload.getEmployerCity() == null ? "" : updPayload.getEmployerCity());
        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_ADDRESS_AREA, updPayload.getEmployerProvince() == null ? "" : updPayload.getEmployerProvince());
        //Passing country code only if the address is updated
        if (updPayload.getEmployerAddress() == null || updPayload.getEmployerAddress().equals("")) {
            paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_ADDRESS_COUNTRY, "");
        } else {
            paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_ADDRESS_COUNTRY, "CA");// It has to be a Canada address
        }
        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_ADDRESS_POSTALCODE, updPayload.getEmployerPostalCode() == null ? "" : updPayload.getEmployerPostalCode());
        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_STARTTS, dateFmt.format(new Date()));
        if(updPayload.getEmploymentId() != null){
        	paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_ID, updPayload.getEmploymentId());
        }
        paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_STATUS, updPayload.getEmploymentStatus() == null ? "" : updPayload.getEmploymentStatus());
        if (status.currentImagePayLoad.getEmploymentLastUpdatedTS() != null) {
            paramValues.put(CustomerProfileUtil.XSL_IS_EMPLOYMENT_PRESENT, "true");
            paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_LASTUPDATEDTS, status.currentImagePayLoad.getEmploymentLastUpdatedTS());
        } else {
            paramValues.put(CustomerProfileUtil.XSL_IS_EMPLOYMENT_PRESENT, "false");
        }
        if (status.currentImagePayLoad.getPrimIncomeLastUpdatedTS() != null) {
            paramValues.put(CustomerProfileUtil.XSL_IS_PRIMARYINCOME_PRESENT, "true");
            paramValues.put(CustomerProfileUtil.XSL_EMPLOYMENT_PRIMARYINCOME_LASTUPDATEDTS, status.currentImagePayLoad.getPrimIncomeLastUpdatedTS());
        } else {
            paramValues.put(CustomerProfileUtil.XSL_IS_PRIMARYINCOME_PRESENT, "false");
        }
    }

    /**
     * Set the map for updating other income profile
     */
    private void setupOtherIncomeParam(Map<String, Object> paramValues, StatusFlags status, final com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest request) {
        //  Employment changes
        SimpleDateFormat dateFmt = new SimpleDateFormat(CustomerProfileUtil.DATE_FMT);
        com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.RequestPayload updPayload = request.getRequestPayload();

        if (status.currentImagePayLoad.getOtherIncomeLastUpdatedTS() != null) {
            paramValues.put(CustomerProfileUtil.XSL_IS_OTHERINCOME_PRESENT, "true");
            paramValues.put(CustomerProfileUtil.XSL_OTHERINCOME_LASTUPDATEDTS, status.currentImagePayLoad.getOtherIncomeLastUpdatedTS());
        } else {
            paramValues.put(CustomerProfileUtil.XSL_IS_OTHERINCOME_PRESENT, "false");
        }

        if (updPayload.getHasOtherIncome() != null && updPayload.getHasOtherIncome()) {
            paramValues.put(CustomerProfileUtil.XSL_OTHERINCOME_ENDTS, "");
            if(updPayload.getOtherIncomeId() != null){
            	paramValues.put(CustomerProfileUtil.XSL_OTHERINCOME_ID, updPayload.getOtherIncomeId());
            }
            paramValues.put(CustomerProfileUtil.XSL_OTHERINCOME_VALUE, updPayload.getOtherIncome());
            paramValues.put(CustomerProfileUtil.XSL_OTHERINCOME_SOURCE, updPayload.getOtherIncomeSource());
        } else {
            paramValues.put(CustomerProfileUtil.XSL_OTHERINCOME_ENDTS, dateFmt.format(new Date()));
            if(updPayload.getOtherIncomeId() != null){
            	paramValues.put(CustomerProfileUtil.XSL_OTHERINCOME_ID, updPayload.getOtherIncomeId());
            }
            paramValues.put(CustomerProfileUtil.XSL_OTHERINCOME_VALUE, status.existingOtherIncome);
            paramValues.put(CustomerProfileUtil.XSL_OTHERINCOME_SOURCE, status.existingOtherIncomeSrc);
        }
    }

    /**
     * Set the map for updating other income profile
     */
    private void setupGrossIncomeParam(Map<String, Object> paramValues, StatusFlags status, final com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest request) {
        //  GROSS-INDIVIDUAL changes
        com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.RequestPayload updPayload = request.getRequestPayload();
        BigDecimal grossIncome = updPayload.getIncome();
        BigDecimal otherIncome = updPayload.getOtherIncome();
        if (grossIncome == null){
        	grossIncome = BigDecimal.ZERO;
        }
        if (updPayload.getHasOtherIncome() != null && updPayload.getHasOtherIncome()) {
            if (otherIncome == null){
            	otherIncome = BigDecimal.ZERO;
            }
            grossIncome = grossIncome.add(otherIncome);
        }
        grossIncome = grossIncome.setScale(2, RoundingMode.DOWN);

        if (status.currentImagePayLoad.getGrossIncomeLastUpdatedTS() != null) {
            paramValues.put(CustomerProfileUtil.XSL_IS_GROSSINCOME_PRESENT, "true");
            paramValues.put(CustomerProfileUtil.XSL_GROSSINCOME_LASTUPDATEDTS, status.currentImagePayLoad.getGrossIncomeLastUpdatedTS());
        } else {
            paramValues.put(CustomerProfileUtil.XSL_IS_GROSSINCOME_PRESENT, "false");
        }
        if(updPayload.getGrossIncomeId() != null){
        	paramValues.put(CustomerProfileUtil.XSL_GROSSINCOME_ID, updPayload.getGrossIncomeId());
        }
        paramValues.put(CustomerProfileUtil.XSL_GROSSINCOME_VALUE, grossIncome);
    }

    /**
     * Signals whether any field has been changed in both PCH and AU.
     *
     * @return - true/false
     */
    private boolean isChangesToTriggerNotes(StatusFlags status, Map<String, StatusFlags> authroizedUsersChangesMap) {
        boolean changesToTrigerNotes = false;
        for (Iterator<CustomerState> iterator = status.customerStateLst.iterator(); iterator.hasNext(); ) {
            CustomerState notes = iterator.next();
            changesToTrigerNotes = changesToTrigerNotes || notes.isChanged();
        }

        for (String auId : authroizedUsersChangesMap.keySet()) {
            StatusFlags auStatusFlag = authroizedUsersChangesMap.get(auId);
            for (Iterator<CustomerState> auIterator = auStatusFlag.customerStateLst.iterator(); auIterator.hasNext(); ) {
                CustomerState auNotes = auIterator.next();
                changesToTrigerNotes = changesToTrigerNotes || auNotes.isChanged();
            }

        }
        return changesToTrigerNotes;
    }

    private boolean isTrigerContactUpdate(StatusFlags status) {
        boolean result = status.mailAddressState.isChanged() || status.physicalAddressState.isChanged() || status.phoneState.isChanged() || status.emailState.isChanged();
        return result;
    }

    /**
     * Compares strings
     *
     * @param str1    - new value
     * @param str2    - prior value
     * @param caption - field caption
     * @param notes   - notes to be generated if any.
     */
    private void compareFields(String str1, String str2, String caption, CustomerState notes) {
        // null and empty string is the same.
        String trimStr1 = (str1 == null || str1.isEmpty()) ? null : (str1.trim().length() == 0) ? null : str1.trim();
        String trimStr2 = (str2 == null || str2.isEmpty()) ? null : (str2.trim().length() == 0) ? null : str2.trim();
        boolean equal = (trimStr1 == null) ? (trimStr2 == null ? true : false) : trimStr1.equalsIgnoreCase(trimStr2);

        if (!equal) {
            notes.setChanged(true);
            notes.addFieldCaption(caption);
        }
    }

    /**
     * Compares boolean
     *
     * @param arg1    - new value
     * @param arg2    - prior value
     * @param caption - field caption
     * @param notes   - notes to be generated if any.
     */
    private void compareFields(boolean arg1, boolean arg2, String caption, CustomerState notes) {

        if (arg1 != arg2) {
            notes.setChanged(true);
            notes.addFieldCaption(caption);
        }
    }

    /**
     * Compares BigDecimals
     *
     * @param arg1    - new value
     * @param arg2    - prior value
     * @param caption - field caption
     * @param notes   - notes to be generated if any.
     */
    private void compareFields(BigDecimal arg1, BigDecimal arg2, String caption, CustomerState notes) {

        String str1 = (arg1 == null) ? String.valueOf(BigDecimal.ZERO.setScale(2, RoundingMode.DOWN)) : arg1.setScale(2, RoundingMode.DOWN).toPlainString();
        String str2 = (arg2 == null) ? String.valueOf(BigDecimal.ZERO.setScale(2, RoundingMode.DOWN)) : arg2.setScale(2, RoundingMode.DOWN).toPlainString();
        compareFields(str1, str2, caption, notes);
    }
    /**
     * Compares strings
     *
     * @param str1    - new value
     * @param str2    - prior value
     * @param caption - field caption
     * @param notes   - notes to be generated if any.
     */
    private boolean compareAuFields(String str1, String str2, String caption, CustomerState notes) {
        // null and empty string is the same.
        String trimStr1 = (str1 == null || str1.isEmpty()) ? null : (str1.trim().length() == 0) ? null : str1.trim();
        String trimStr2 = (str2 == null || str2.isEmpty()) ? null : (str2.trim().length() == 0) ? null : str2.trim();
        boolean equal = (trimStr1 == null) ? (trimStr2 == null ? true : false) : trimStr1.equalsIgnoreCase(trimStr2);

        if (!equal) {
            notes.setChanged(true);
            notes.addFieldCaption(caption);
        }
        return equal;
    }

    protected class CustomerState {
        // mailing address state
        public static final int MAIL_ADDRESS_STATE = 1;
        // email state
        public static final int EMAIL_STATE = 2;
        // phone state
        public static final int PHONE_STATE = 3;
        // email preference state ((for both marketing & confirmation email's)
        public static final int PREFERENCES_STATE = 4;
        // other state
        public static final int OTHER_STATE = 5;
        // physical address state
        public static final int PHYSICAL_ADDRESS_STATE = 6;

        private boolean isSendNotification = true; //indicate if email notification should be sent or not. Default is send notification if changed.
        private boolean changed; // means at least one field from the block has been changed
        private int header;
        private String emailBusinessEventID;

        private Set<String> fieldsCaptions = new HashSet<>();

        private CustomerState(int header, String emailBusinessEventID) {
            this.header = header;
            this.emailBusinessEventID = emailBusinessEventID;
            this.fieldsCaptions = new HashSet<String>();
        }

        public boolean isChanged() {
            return changed;
        }

        public void setChanged(boolean changed) {
            this.changed = changed;
        }

        public int getHeader() {
            return header;
        }

        public void setHeader(int header) {
            this.header = header;
        }

        public Set<String> getFieldsCaptions() {
            return fieldsCaptions;
        }

        public void addFieldCaption(String caption) {
            fieldsCaptions.add(caption);
        }

        public boolean isFieldChanged(String caption) {
            return (fieldsCaptions.contains(caption));
        }

        public String getEmailBusinessEventID() {
            return emailBusinessEventID;
        }

        @Override
        public String toString() {
            StringBuilder notes = new StringBuilder();
            notes.append(" Header: ");
            notes.append(this.getHeader());
            notes.append(" Has been changed: ");
            notes.append(this.isChanged());
            notes.append(" Fields changed: ");
            for (Iterator<String> iterator = fieldsCaptions.iterator(); iterator.hasNext(); ) {
                notes.append(iterator.next());
                notes.append(CustomerProfileUtil.SPACE);
            }
            return notes.toString();
        }

        public boolean isSendNotification() {
            return isSendNotification;
        }

        public void setSendNotification(boolean isSendNotification) {
            this.isSendNotification = isSendNotification;
        }
    }

    /**
     * Calls email service if phone, email or mailing address have been changed
     * customerStateLst - contains the states of all blocks above.
     *
     * @param updateRequest
     */
    public void callEmailNotification(com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest updateRequest, StatusFlags status, String ...token) {

    	boolean isSendMailFlag = false;
    	isSendMailFlag = updateRequest != null ? updateRequest.getRequestPayload().getConfirmationEmailWanted() == null ? false : updateRequest.getRequestPayload().getConfirmationEmailWanted().booleanValue() : false;
    	
    	if ( !isSendMailFlag) {
    		return;
    	}
    	EmailInfoImpl emailInfoBean = getBaseEmailBean(updateRequest, status);
    	if (emailInfoBean.isTriggerEmailNotification()) {
    		midtierExecutor.execute(() -> {
    			try {
    				emailInfoBean.setToken(token != null && token.length > 0 ? token[0] : null);
                	mbnaAlert.addAlertEvent(emailInfoBean);
    			} catch (Exception e) {
    				logger.error("callEmailNotification", "update customer profile SOAP service  - sendEmail failed", e);
    			}
    		});
    	} else {
    		logger.debug(" notification is explicitly set to false. Email not sent");
    	}
    }

    /**
     * Creates base e-mail notification bean. Uses update request to feed in info.
     *
     * @param updateRequest
     * @return - basic email notification bean
     */
    private EmailInfoImpl getBaseEmailBean(com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest updateRequest, StatusFlags status) {
        com.td.mbna.msec.midtier.types.common.EmailNotificationInfoType emailNotificationInfo = updateRequest.getRequestPayload().getEmailNotificationInfo();

        EmailInfoImpl emailInfoBean = new EmailInfoImpl(emailNotificationInfo, updateRequest.getSessionInfo().getLoginId(), IMBNAConstants.ALERT_TYPE_CD_SECUREGENERIC, updateRequest.getIsPrimaryUser() == null ? false : updateRequest.getIsPrimaryUser().booleanValue());
        emailInfoBean.setConnectId(updateRequest.getSessionInfo().getConnectId());
        if (emailNotificationInfo == null) {
        	return null;
        }
        
        emailInfoBean.setAcctNum(updateRequest.getAcctNum());
        emailInfoBean.setTriggerEmailNotification((emailNotificationInfo.getSendEmail() == null ? false : emailNotificationInfo.getSendEmail().booleanValue()) || isConfirmationEmailOptionChanged(status));

        if (emailNotificationInfo.getOldEmailAddressChange() != null) {
        	emailInfoBean.setOldEmailAddress(emailNotificationInfo.getOldEmailAddressChange());
        }

        LocalDate now = LocalDate.now();
		emailInfoBean.addAttribute(CONTENT_CD, UPDATE_PROFILE);
		emailInfoBean.addAttribute(UCP_FIRST_NAME, emailNotificationInfo.getPrimaryUserFirstName());
		emailInfoBean.addAttribute(UCP_APP_DATE, ISO_DATE.format(now));
		emailInfoBean.addAttribute(UCP_LAST_FOUR_DIGIT, emailNotificationInfo.getPrimaryUserCardEnding());  
		emailInfoBean.addAttribute(UCP_PRODUCT_NAME, emailNotificationInfo.getCardName());

        return emailInfoBean;
    }

    private void genAuditLog(com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest updateRequest, String code, String logStatus, String ucid) {

        try {
            com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest updateRequestNew = copyObject(updateRequest);
            updateRequestNew.getAuditInfo().setTransactionCode(code);
            if (ucid != null && ucid.trim().length() > 0) {
                updateRequestNew.getAuditInfo().setDescription(ucid);
            }

            long auditStartTime = updateRequest.getAuditInfo().getAuditStartTime();
            long processingTime = 0;
            if (auditStartTime > 0) {
                processingTime = System.currentTimeMillis() - auditStartTime;
            }
            com.td.mbna.msec.midtier.types.common.BaseResponse response = new com.td.mbna.msec.midtier.types.common.BaseResponse();
            if (logStatus != null) {
                response.setStatus(logStatus);
            } else {
                // Don't need to log processing time if it is not logging status.
                processingTime = 0;
            }

            AuditServiceWork auditServiceWork = new AuditServiceWork(updateRequestNew, response, new Date(), processingTime);
            auditServiceWork.run();

        } catch (Exception e) {
            logger.error("genAuditLog", "update customer profile SOAP service  - genAuditLog failed", e);
            throw ExceptionUtil.genRuntimeException(e);
        }
    }

    private com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest copyObject(com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest updateRequest) {
        com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest updateRequestNew;
        try {

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(updateRequest);
            out.flush();
            out.close();

            ObjectInputStream in = new ObjectInputStream(
                    new ByteArrayInputStream(bos.toByteArray()));
            updateRequestNew = (com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest) in.readObject();
            bos.close();
            in.close();
        } catch (Exception e) {
            logger.error("copyObject", "Failed while copying object, returning original: ", e);
            return updateRequest;
        }
        return updateRequestNew;
    }

    private boolean isConfirmationEmailOptionChanged(StatusFlags status) {
        return status.preferenceState.isFieldChanged("ConfirmationEmailOption");
    }


    private boolean isPhoneChanged(String type, StatusFlags status) {
        return status.phoneState.getFieldsCaptions().contains(type);
    }

    private void init(StatusFlags status) {
        status.mailAddressState = new CustomerState(CustomerState.MAIL_ADDRESS_STATE, IMBNAConstants.BUSINESSEVENT_ID_UPDATECUSTOMER_ADDRESS_REQUEST);
        status.emailState = new CustomerState(CustomerState.EMAIL_STATE, IMBNAConstants.BUSINESSEVENT_ID_UPDATECUSTOMER_EMAIL_REQUEST);
        status.phoneState = new CustomerState(CustomerState.PHONE_STATE, IMBNAConstants.BUSINESSEVENT_ID_UPDATECUSTOMER_PHONE_REQUEST);
        status.physicalAddressState = new CustomerState(CustomerState.PHYSICAL_ADDRESS_STATE, IMBNAConstants.BUSINESSEVENT_ID_UPDATECUSTOMER_ADDRESS_REQUEST);
        status.preferenceState = new CustomerState(CustomerState.PREFERENCES_STATE, CustomerProfileUtil.EMPTY);
        status.otherState = new CustomerState(CustomerState.OTHER_STATE, CustomerProfileUtil.EMPTY);
        status.customerStateLst = new ArrayList<>(3);
        status.customerStateLst.add(status.mailAddressState);
        status.customerStateLst.add(status.emailState);
        status.customerStateLst.add(status.phoneState);
        status.customerStateLst.add(status.otherState);
        status.customerStateLst.add(status.physicalAddressState);
        status.customerStateLst.add(status.preferenceState);
    }

    private void saveConfirmEmailOption(com.td.mbna.msec.midtier.customerprofile.payload.updatecustomerprofile.UpdateCustomerProfileRequest updateRequest) {
    	String pref=(updateRequest.getRequestPayload().getConfirmationEmailWanted() != null && updateRequest.getRequestPayload().getConfirmationEmailWanted()) ? "true" : "false";
        String customerId = updateRequest.getCustId();
        Accounts accounts = DBMybatisService.getAccount(customerId, updateRequest.getAcctNum());
//        Accounts accounts = DBService.getAccount(customerId, updateRequest.getAcctNum());
        if (accounts == null) {
            accounts = new Accounts();
            accounts.setCustomerId(customerId);
            accounts.setAccountNumber(updateRequest.getAcctNum());
            accounts.setEmailPreference(pref);
            DBMybatisService.createAccounts(accounts);
//            DBService.saveOrUpdateAccounts(accounts);
        }else{
        	accounts.setEmailPreference(pref);
        	DBMybatisService.updateAccounts(accounts);        	
//        	DBService.saveOrUpdateAccounts(accounts);        	
        }
    }

}