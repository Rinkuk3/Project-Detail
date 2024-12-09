package com.td.mbna.msec.midtier.customerprofile;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mbnaweb.xsd.msgs.customerprofile.AccountKycAuInfoType;
import com.mbnaweb.xsd.msgs.customerprofile.CustomerAcctProfileType;
import com.mbnaweb.xsd.msgs.customerprofile.CustomerAcctType;
import com.mbnaweb.xsd.msgs.customerprofile.CustomerInfoType;
import com.mbnaweb.xsd.msgs.customerprofile.CustomerProfileType;
import com.mbnaweb.xsd.msgs.customerprofile.RetrieveCustomerProfileRequest;
import com.mbnaweb.xsd.msgs.customerprofile.RetrieveCustomerProfileResponse;
import com.mbnaweb.xsd.types.common.CardHolderType;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.tdwsservices.RcpFilter;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.CustomerProfileUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.ParallelServiceCaller;
import com.td.mbna.msec.midtier.util.ServiceCall;
import com.td.mbna.msec.midtier.util.ods.OdsHelper;
import com.td.mbna.msec.midtier.util.services.JAXBJsonConverter;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;

@Component
public class RetrieveCustomerProfileOperation implements MsecMidtierCommonOperations<com.td.mbna.msec.midtier.customerprofile.payload.retrievecustomerprofile.RetrieveCustomerProfileRequest, com.td.mbna.msec.midtier.customerprofile.payload.retrievecustomerprofile.RetrieveCustomerProfileResponse> {
	
	private static final String GENERAL_ERROR = "MS601";
	private static MbnaLogger logger = new MbnaLogger(RetrieveCustomerProfileOperation.class);

	public static RetrieveCustomerProfileResponse doRetrieveCustomerProfileViaOds(final RetrieveCustomerProfileRequest request, RcpFilter requestFilter) throws Exception
    {
    	String methodName = "RetrieveCustomerProfileOperation::doRetrieveCustomerProfileViaOds";
    	final ParallelServiceCaller acctUserInfoRtr = new ParallelServiceCaller();
    	
    	RetrieveCustomerProfileResponse rc;
    	RetrieveCustomerProfileRequest.RequestPayload reqPL = request.getRequestPayload();
    	boolean isPrimaryUser = (reqPL.isAuthorizedUser() == false);
		String custId = reqPL.getCustId();
		String acctNum = reqPL.getAcctNum();
		
		//setting the filters
		if (requestFilter == null) {
			requestFilter = (isPrimaryUser)?RcpFilter.ALL:RcpFilter.ALL_BUT_RELATIONSHIPS;
    	}
		
    	if (isPrimaryUser) {
    		
    		CustomerProfileType custProfile = OdsHelper.getAcctPchFullProfile(acctNum, requestFilter);  
    		
    		CustomerAcctType matchAcct = custProfile.getAccounts().get(0);
    		CustomerAcctProfileType pchAcctProfile = matchAcct.getPchAcctProfile();
    		
    		if (pchAcctProfile.getCustInfo().getCustId().equals(custId) == false) {
    			String message = " Retrieved primary customer ID is not the same as the one in request ";
    			logger.error(methodName, message);
    			throw new RuntimeException(message);
    		}
    		
    		List<CardHolderType> authUsers =matchAcct.getOtherCardHolders();
    		scheduleAuthUserAcctInfoRetrieval(acctUserInfoRtr, authUsers);
    		acctUserInfoRtr.sync();
    		List<AccountKycAuInfoType> auList = new ArrayList<AccountKycAuInfoType>();
    		for(CardHolderType authUser:authUsers){
    			if(authUser == null){
    				continue;
    			}
    			AccountKycAuInfoType auInfo = new AccountKycAuInfoType();
    			auList.add(auInfo);
    			String authUserCustId = authUser.getCustomerID();
		 		CustomerInfoType authUserCustInfo = acctUserInfoRtr.getResponse(authUserCustId, CustomerInfoType.class);
		 		auInfo.setKycAuBirthDate(authUserCustInfo.getBirthDate());
		 		auInfo.setKycAuName(authUserCustInfo.getName());
		 		auInfo.setKycAliasCustomerID(authUser.getAliasCustomerID());
		 		auInfo.setKycBookOfBusLastUpdatedTS(authUserCustInfo.getBookOfBusLastUpdatedTS());
		 		auInfo.setKycPersonLastUpdatedTS(authUserCustInfo.getPersonLastUpdatedTS());		 		
		 		CustomerAcctProfileType authUserAcctProf = CustomerProfileUtil.findOtherUserAcctProfile(matchAcct, authUserCustId);  
 				auInfo.setKycAuCustAcctInfo(authUserAcctProf.getAcctInfo());				
 				
    		}
    		rc = CustomerProfileUtil.convert(pchAcctProfile);
    		rc.getResponsePayload().getAuthorizedUsers().addAll(auList);
    		CustomerProfileUtil.formatForUI(rc);
    		return rc;
    		
    	}
    	// au
    	CustomerAcctProfileType capt = OdsHelper.getCustAcctProfile(custId, acctNum, requestFilter);
    	rc = CustomerProfileUtil.convert(capt);
    	CustomerProfileUtil.formatForUI(rc);
    	return rc;
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

	@Override
	public com.td.mbna.msec.midtier.customerprofile.payload.retrievecustomerprofile.RetrieveCustomerProfileResponse invokeService(com.td.mbna.msec.midtier.customerprofile.payload.retrievecustomerprofile.RetrieveCustomerProfileRequest requestInJson, String... token) {
		String methodName = "RetrieveCustomerProfileOperation::invokeService";
		try {
			com.mbnaweb.xsd.msgs.customerprofile.RetrieveCustomerProfileRequest request = JAXBJsonConverter
					.convertJsonToJAXBInterface(requestInJson, com.mbnaweb.xsd.msgs.customerprofile.RetrieveCustomerProfileRequest.class);


			RetrieveCustomerProfileResponse response = doRetrieveCustomerProfileViaOds(request, null);
			return JAXBJsonConverter.convertoJAXBToJsonInterface(response, com.td.mbna.msec.midtier.customerprofile.payload.retrievecustomerprofile.RetrieveCustomerProfileResponse.class);
		} catch (Exception e) {
			String message = " retreiving customer profile failed ";
			logger.error(methodName, message,e);
			throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,message, e);
		}
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
}