package com.td.mbna.msec.midtier.customerprofile;

import java.util.ArrayList;
import java.util.List;

import com.mbnaweb.xsd.msgs.customerprofile.CustomerAcctProfileType;
import com.mbnaweb.xsd.msgs.customerprofile.CustomerAcctType;
import com.mbnaweb.xsd.msgs.customerprofile.CustomerInfoType;
import com.mbnaweb.xsd.msgs.customerprofile.CustomerProfileType;
import com.mbnaweb.xsd.types.common.CardHolderType;
import com.mbnaweb.xsd.types.common.CustAcctType;
import com.td.mbna.msec.midtier.tdwsservices.RcpFilter;
import com.td.mbna.msec.midtier.util.CustomerProfileUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.ParallelServiceCaller;
import com.td.mbna.msec.midtier.util.ServiceCall;
import com.td.mbna.msec.midtier.util.ods.OdsHelper;


class OdsLogonHelper {
	
	private static MbnaLogger logger = new MbnaLogger(OdsLogonHelper.class);
	
	static class RetrieveLogonInfoResponse {
		CustomerProfileType logonProfile;
		List<ParallelServiceCaller> relatedProfileCallers;
		CustomerProfileType getLogonCustomerProfile() {
			return logonProfile;
		}
		void setLogonProfile(CustomerProfileType logonProfile) {
			this.logonProfile = logonProfile;
		}
		List<ParallelServiceCaller> getRelatedProfileCallers() {
			return relatedProfileCallers;
		}
		void setRelatedProfileRetrievers(
				List<ParallelServiceCaller> relatedProfileCallers) {
			this.relatedProfileCallers = relatedProfileCallers;
		}
	}
	
    static void scheduleLogonProfilesRetrieval(final String logonCustId, final List<CustAcctType> enrolledAccts, ParallelServiceCaller parallelCaller) throws Exception {
		ServiceCall<?> rtrLogonProfileCall = new ServiceCall<RetrieveLogonInfoResponse>() {
			@Override
			public RetrieveLogonInfoResponse invoke() throws Exception {
				return getLogonCustomerProfile(logonCustId, enrolledAccts);
			}
		};
		parallelCaller.scheduleCall(logonCustId, rtrLogonProfileCall);
    }

	// refactoring code to call synchorous call directly .

	static RetrieveLogonInfoResponse logonProfilesRetrieval(final String logonCustId, final List<CustAcctType> enrolledAccts, ParallelServiceCaller parallelCaller) throws Exception {


				return getLogonCustomerProfile(logonCustId, enrolledAccts);

	}

    static RetrieveLogonInfoResponse getLogonProfilesRetrievalResult(final String logonCustId, final List<CustAcctType> enrolledAccts, ParallelServiceCaller parallelCaller) throws Exception {
		return parallelCaller.getResponse(logonCustId, RetrieveLogonInfoResponse.class);
    }
	
    private static RetrieveLogonInfoResponse getLogonCustomerProfile(String logonCustId, List<CustAcctType> enrolledAccts) throws Exception
    {
    	String methodName = "OdsLogonHelper::getLogonCustomerProfile";
    	RetrieveLogonInfoResponse response = new RetrieveLogonInfoResponse();
		CustomerProfileType logonCustProf = OdsHelper.getCustomerProfile(logonCustId, RcpFilter.ALL);
		
		//Logging all the accounts returned
		StringBuilder codsAccountsStr = new StringBuilder();
		if(logonCustProf != null){
			for(CustomerAcctType customerAcctType:logonCustProf.getAccounts()){
				if(customerAcctType == null){
					continue;
				}
				codsAccountsStr.append("{ C"+customerAcctType.getAcctNum().substring(customerAcctType.getAcctNum().length()-4)+" }");
			}
		}
		logger.warning("Accounts returned from CODS - "+codsAccountsStr);
		
		response.setLogonProfile(logonCustProf);
		int numEnrolledAccts = enrolledAccts.size();
		List<ParallelServiceCaller> acctUserInfoRtrs = new ArrayList<ParallelServiceCaller>(numEnrolledAccts);
		response.setRelatedProfileRetrievers(acctUserInfoRtrs);
	   	for (int i = 0; i < numEnrolledAccts; i++) {
	   		CustAcctType enrolledAcct = enrolledAccts.get(i);
			String acctNum = enrolledAcct.getAcctNum();
			CustomerAcctType account = CustomerProfileUtil.findCustAcctFromProfile(logonCustProf, acctNum);
			if(account == null){
				String message = "Accounts mismatch between CODS and Enrollment,Accounts mismatch between CODS and Enrollment: Account T"+acctNum.substring(acctNum.length()-4)+" is missing from CODS for UCID ending -"+logonCustId.substring(logonCustId.length()-4)+"in "+methodName;
				logger.warn(message);
				continue;
			}
			
			CardHolderType logonCust = account.getCardHolder();
			final ParallelServiceCaller acctUserInfoRtr = new ParallelServiceCaller();
			acctUserInfoRtrs.add(acctUserInfoRtr);
			if (logonCust.isPrimaryUser()) {
				List<CardHolderType> authUsers = account.getOtherCardHolders();
				scheduleAcctAuthUserInfoRetrieval(acctUserInfoRtr, authUsers);
			}
			else {
				if(account.getPrimaryCardHolder() != null){
					List<CardHolderType> authUsers = account.getOtherCardHolders();
					scheduleAcctAuthUserInfoRetrieval(acctUserInfoRtr, authUsers);
					scheduleAcctPchProfileRetrieval(acctUserInfoRtr, account.getPrimaryCardHolder().getCustomerID());
				}
			}
		}
	   	// retrieve affinity info for all accounts
	   	
		return response;
    }
    
    private static void scheduleAcctPchProfileRetrieval(ParallelServiceCaller acctUserInfoRtr, final String primaryUserId) throws Exception {
		ServiceCall<?> rtrUserInfoCall = new ServiceCall<CustomerInfoType>() {
			@Override
			public CustomerInfoType invoke() throws Exception {
				return OdsHelper.getCustInfo(primaryUserId, RcpFilter.PROFILE);
			}
		};
		acctUserInfoRtr.scheduleCall(primaryUserId, rtrUserInfoCall);
    }
    
    private static void scheduleAcctAuthUserInfoRetrieval(ParallelServiceCaller acctUserInfoRtr, List<CardHolderType> authUsers) throws Exception {
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
    
    static void populateRelatedUserInfo(List<CustAcctType> enrolledAccts, CustomerProfileType logonCustProf, List<ParallelServiceCaller> relatedUserInfoRtrs) throws Exception {
    	String methodName ="populateRelatedUserInfo";
    	logger.toJson(methodName, enrolledAccts);
    	logger.toJson(methodName, logonCustProf);
    	if(enrolledAccts == null || relatedUserInfoRtrs == null || relatedUserInfoRtrs.isEmpty()){
    		return;
    	}
		int numEnrolledAccts = enrolledAccts.size();
	   	for (int i = 0; i < numEnrolledAccts; i++) {
	   		CustAcctType enrolledAcct = enrolledAccts.get(i);
			CustomerAcctType account = CustomerProfileUtil.findCustAcctFromProfile(logonCustProf, enrolledAcct.getAcctNum());
			if(account == null){
				continue;
			}
    		ParallelServiceCaller acctRelatedUserInfoRtr = relatedUserInfoRtrs.get(i);
    		if(acctRelatedUserInfoRtr == null){
    			return;
    		}
        	acctRelatedUserInfoRtr.sync();
        	CardHolderType logonCust = account.getCardHolder();
        	if (logonCust.isPrimaryUser()) {	// logon customer is the primary card holder
        		// logon customer is the PCH, still need to retrieve info for all authorized users
	    		List<CardHolderType> acctAuthUsers = account.getOtherCardHolders();
	    		populateAccountAuthorizedUserInfo(acctAuthUsers, acctRelatedUserInfoRtr);
        	}
        	else {
        		// logon customer is an authorized user, so retrieve information for the primary user
        		CardHolderType acctPch = account.getPrimaryCardHolder();
        		CustomerInfoType acctPchCustInfo = acctRelatedUserInfoRtr.getResponse(acctPch.getCustomerID(), CustomerInfoType.class);
        		CustomerProfileUtil.setCardHolderDetails(acctPchCustInfo, acctPch);
        		CustomerAcctProfileType acctPchProfile = account.getPchAcctProfile();
        		acctPchProfile.setCustInfo(acctPchCustInfo);
				List<CardHolderType> acctAuthUsers = account.getOtherCardHolders();
				populateAccountAuthorizedUserInfo(acctAuthUsers, acctRelatedUserInfoRtr);
        	}
    	}
    }
    
    private static void populateAccountAuthorizedUserInfo(List<CardHolderType> acctAuthUsers, ParallelServiceCaller acctRelatedUserInfoRtr) 
    	throws Exception {
    	for (CardHolderType acctAuthUser : acctAuthUsers) {
    		if(acctAuthUser == null){
    			continue;
    		}
    		String acctAuthUserId = acctAuthUser.getCustomerID();
    		CustomerInfoType acctAuthUserInfo = acctRelatedUserInfoRtr.getResponse(acctAuthUserId, CustomerInfoType.class);
    		CustomerProfileUtil.setCardHolderDetails(acctAuthUserInfo, acctAuthUser);
    	}
   	}
}
