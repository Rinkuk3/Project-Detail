package com.td.mbna.msec.midtier.customerprofile;

import com.mbnaweb.xsd.msgs.customerprofile.*;
import com.mbnaweb.xsd.types.common.CardHolderType;
import com.mbnaweb.xsd.types.common.CustAcctType;
import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.tdwsservices.RcpFilter;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.types.common.ValidationException;
import com.td.mbna.msec.midtier.util.CustomerProfileUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.ParallelServiceCaller;
import com.td.mbna.msec.midtier.util.ServiceCall;
import com.td.mbna.msec.midtier.util.ods.OdsHelper;
import com.td.mbna.msec.midtier.util.services.JAXBJsonConverter;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import javax.annotation.PostConstruct;

import java.util.List;

@Component
public class GetKycAcctsInfoOperation implements MsecMidtierCommonOperations<com.td.mbna.msec.midtier.customerprofile.payload.getkycacctsinfo.GetKycAcctsInfoRequest, com.td.mbna.msec.midtier.customerprofile.payload.getkycacctsinfo.GetKycAcctsInfoResponse> {


    private static final String GENERAL_ERROR = "MS601";
    private static MbnaLogger logger = new MbnaLogger(GetKycAcctsInfoOperation.class);
    
    @Autowired
    private ValangValidator getKycAcctsInfo_CustAcctType_Validator;

    private MsecValidator msecGetKycAcctsInfoCustAcctTypeValidator;

    @PostConstruct
    private void init() {
        msecGetKycAcctsInfoCustAcctTypeValidator = new MsecVlangValidator(getKycAcctsInfo_CustAcctType_Validator);
    }
    
    @Override
    public com.td.mbna.msec.midtier.customerprofile.payload.getkycacctsinfo.GetKycAcctsInfoResponse invokeService(com.td.mbna.msec.midtier.customerprofile.payload.getkycacctsinfo.GetKycAcctsInfoRequest request, String... token) {
    	String methodName = "GetKycAcctsInfoOperation::invokeService";
    	com.mbnaweb.xsd.msgs.customerprofile.GetKycAcctsInfoRequest jaxbRequest = JAXBJsonConverter
    			.convertJsonToJAXBInterface(request, com.mbnaweb.xsd.msgs.customerprofile.GetKycAcctsInfoRequest.class);
    	
    	GetKycAcctsInfoRequest.RequestPayload reqPayload = jaxbRequest.getRequestPayload();
    	
    	//Validate GetKycAcctsInfoRequest.RequestPayload.kycNeededAccts
    	List<CustAcctType> custAcctTpList = reqPayload.getKycNeededAccts();
    	ValidationException faultInfo = null;
    	if ((custAcctTpList != null) && (custAcctTpList.size() > 0)) {
    		for (CustAcctType custAcctTp: custAcctTpList) {
    			
    			ValidationException faultInfo_custAcctType = null;
    			try {
					faultInfo_custAcctType = msecGetKycAcctsInfoCustAcctTypeValidator.validate(custAcctTp);
				} catch (Exception e) {
					String message = " msecGetKycAcctsInfoCustAcctTypeValidator.validate(custAcctTp) failed";
					logger.error(methodName, message, e);
				}
    			
    			if (faultInfo != null) {
    				if (faultInfo_custAcctType != null && !faultInfo_custAcctType.getFieldError().isEmpty()) {
    					faultInfo.getFieldError().addAll(faultInfo_custAcctType.getFieldError());
    				}
    			} else {
    				faultInfo = faultInfo_custAcctType;
    			}
    		}
    	}
    	
    	if (faultInfo != null && !faultInfo.getFieldError().isEmpty()) {
    		String message = " getkyc request validation failed";
    		logger.error(methodName, message);
    		throw faultInfo;
    	}
    	GetKycAcctsInfoResponse response = null;
        try {
        	response = getKycAcctsInfo(jaxbRequest);
        } catch (Exception e) {
        	String message = "Error in retrieving kyc info";
			logger.error(methodName, message, e);
            throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,message, e);
        }
        return JAXBJsonConverter.convertoJAXBToJsonInterface(response, com.td.mbna.msec.midtier.customerprofile.payload.getkycacctsinfo.GetKycAcctsInfoResponse.class);
    }

    private GetKycAcctsInfoResponse getKycAcctsInfo(com.mbnaweb.xsd.msgs.customerprofile.GetKycAcctsInfoRequest jaxbRequest) throws Exception {

            // From the header of the request, get the UCID of the login user and get profiles using parallel call
            String logonCustId = jaxbRequest.getCustId();
            CustomerProfileType custProf = OdsHelper.getCustomerProfile(logonCustId, RcpFilter.ALL);
            final ParallelServiceCaller acctUserInfoRtr = new ParallelServiceCaller();
            // For the list of the accounts, get the information using parallel calls
            for (CustAcctType custAcct : jaxbRequest.getRequestPayload().getKycNeededAccts()) {
            	if(custAcct == null){
            		continue;
            	}
                CustomerAcctType matchAcct = CustomerProfileUtil.findCustAcctFromProfile(custProf, custAcct.getAcctNum());
                // Get the list of the authorized user. Note: the user should already be PCH (Primary Card Holder).
                List<CardHolderType> authUsers = matchAcct.getOtherCardHolders();
                scheduleAuthUserAcctInfoRetrieval(acctUserInfoRtr, authUsers);
            }
            // Set up the logon user information
            GetKycAcctsInfoResponse rc = new GetKycAcctsInfoResponse();
            GetKycAcctsInfoResponse.ResponsePayload resPayload = new GetKycAcctsInfoResponse.ResponsePayload();
            rc.setResponsePayload(resPayload);
            resPayload.setKycCustInfo(custProf.getCustInfo());
            List<AccountKycInfoType> kycAcctsInfo = resPayload.getKycAcctsInfo();

            // Wait for all Accounts Authorized-Users data
            acctUserInfoRtr.sync();

            //
            for (CustAcctType custAcct : jaxbRequest.getRequestPayload().getKycNeededAccts()) {
            	if(custAcct== null){
            		continue;
            	}
                AccountKycInfoType acctKycInfo = new AccountKycInfoType();
                kycAcctsInfo.add(acctKycInfo);
                acctKycInfo.setKycAcct(custAcct);
                CustomerAcctType matchAcct = CustomerProfileUtil.findCustAcctFromProfile(custProf, custAcct.getAcctNum());
                acctKycInfo.setKycCustAcctInfo(matchAcct.getCardHolderAcctInfo());
                List<AccountKycAuInfoType> auList = acctKycInfo.getKycAuthorizeUsers();
                for (CardHolderType authUser : matchAcct.getOtherCardHolders()) {
                	if(authUser== null){
                		continue;
                	}
                    String authUserCustId = authUser.getCustomerID();
                    CustomerInfoType authUserCustInfo = acctUserInfoRtr.getResponse(authUserCustId, CustomerInfoType.class);
                    AccountKycAuInfoType auInfo = new AccountKycAuInfoType();
                    auList.add(auInfo);
                    auInfo.setKycAuBirthDate(authUserCustInfo.getBirthDate());
                    auInfo.setKycAuName(authUserCustInfo.getName());
                    auInfo.setKycAliasCustomerID(authUser.getAliasCustomerID());
                    auInfo.setKycBookOfBusLastUpdatedTS(authUserCustInfo.getBookOfBusLastUpdatedTS());
                    auInfo.setKycPersonLastUpdatedTS(authUserCustInfo.getPersonLastUpdatedTS());
                    // AU account-specific information has already been retrieved OdsHelper.getCustomerProfile(logonCustId, RcpFilter.ALL_BUT_PREFERENCES)
                    // call above.  Just retrieve the corresponding info and set in the response.
                    CustomerAcctProfileType authUserAcctProf = CustomerProfileUtil.findOtherUserAcctProfile(matchAcct, authUserCustId);
                    auInfo.setKycAuCustAcctInfo(authUserAcctProf.getAcctInfo());
                }
            }
            return rc;
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
    public List<String> createAutoComment(BaseRequest request, BaseResponse response) {
        return null;
    }

    @Override
    public EmailInfo getEmailInfoBean(BaseRequest request, BaseResponse response) {
        return null;
    }

    @Override
    public MsecValidator getValidator() {
        return null;
    }

	private static void scheduleAuthUserAcctInfoRetrieval(ParallelServiceCaller acctUserInfoRtr, List<CardHolderType> authUsers) throws Exception {
        for (CardHolderType authUser : authUsers) {
        	if(authUser == null){
        		continue;
        	}
            final String authUserId = authUser.getCustomerID();
            ServiceCall<?> rtrUserInfoCall = new ServiceCall<CustomerInfoType>() {
                @Override
                public CustomerInfoType invoke() throws Exception {
                    return OdsHelper.getCustInfo(authUserId, RcpFilter.PROFILE);
                }
            };
            acctUserInfoRtr.scheduleCall(authUserId, rtrUserInfoCall);
        }
    }
}
