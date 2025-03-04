package com.td.mbna.msec.midtier.util.ods;

import com.mbnaweb.xsd.msgs.customerprofile.*;
import com.mbnaweb.xsd.types.common.CardHolderType;
import com.mbnaweb.xsd.types.common.CardNumHistoryType;
import com.mbnaweb.xsd.types.common.CustAcctType;
import com.td.schemas.tdct.srm.customerprofile.service.v1.*;
import com.td.mbna.msec.midtier.persistance.entity.Accounts;
//import com.td.mbna.msec.midtier.persistance.hibernate.DBService;
import com.td.mbna.msec.midtier.persistance.mybatis.DBMybatisService;
import com.td.mbna.msec.midtier.session.SessionMidProvider;
import com.td.mbna.msec.midtier.tdwsservices.TdOdsCustomerProfileService;
import com.td.mbna.msec.midtier.tdwsservices.RcpFilter;
import com.td.mbna.msec.midtier.util.CustomerProfileUtil;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.TransformUtil;

import javax.xml.transform.Templates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OdsHelper 
{
	// If the country is not specified, it will be treated as Canadian
	public static final String DEFAULT_COUNTRY = "CA";
	
	private  final static Templates CustProfileRetriever;
	
	@Autowired
	private SessionMidProvider sessionMidProvider;
	
	private static MbnaLogger logger = new MbnaLogger(OdsHelper.class);

	static {
		try {
			CustProfileRetriever = TransformUtil.getRsTemplate(TdOdsCustomerProfileService.TdOp_odsRetrieveCustomerProfile);
		} catch (Exception e) {
			logger.error("OdsHelper - static block", e.getMessage(),e);
			throw ExceptionUtil.genRuntimeException(e);
		}
	}
	
	/**
	 * get Customer Account profile - contains customer level information and information about an account which matches the acctNum in the parameters
	 * @param custId
	 * @param acctNum
	 * @param filter
	 * @return
	 * @throws Exception
	 */
    public static CustomerAcctProfileType getCustAcctProfile(String custId, String acctNum, RcpFilter filter) throws Exception {
    	CustomerAcctProfileType rc = new CustomerAcctProfileType();
    	CustomerProfileType custProf = getCustomerProfile(custId, filter);
    	if(custProf == null){
    		return rc;
    	}
    	rc.setCustInfo(custProf.getCustInfo());
    	List<CustomerAcctType> accounts = custProf.getAccounts();
    	if(accounts == null || accounts.isEmpty()){
    		return rc;
    	}
    	
    	for (CustomerAcctType account : accounts) {
    		if (acctNum.equals(account.getAcctNum())) {
    			rc.setAcctInfo(account.getCardHolderAcctInfo());
    			break;
    		}
    	}
    	return rc;
    }
    
    public static CustomerInfoType getCustInfo(String custId, RcpFilter filter) throws Exception {
    	// retrieve person-level information like names and language code
    	// this is used to retrieve authorized user information
    	return getCustomerProfile(custId, filter).getCustInfo(); 
    }
    
    /**
     * get the account and PCH profile
     * @param acctNum
     * @param filter
     * @return
     * @throws Exception
     */
    public static CustomerAcctProfileType getAcctPchProfile(String acctNum, RcpFilter filter) throws Exception {
    	CustomerAcctProfileType rc = new CustomerAcctProfileType();
		TEnvRetrieveCustomerProfileRs odsCustProf = TdOdsCustomerProfileService.retrieveCustomerProfileViaAcctNum(acctNum, filter); // calling via account number should yield just one profile object
    	CustomerProfileType custProf = convertToMtCustomerProfile(odsCustProf, filter);
    	validateCustomerProfileViaAcctNum(custProf, acctNum);      	
    	
    	rc.setCustInfo(custProf.getCustInfo());
    	rc.setAcctInfo(custProf.getAccounts().get(0).getCardHolderAcctInfo()); // since ODS was account-centric, it should have returned one and only one account 
    	return rc;
    }
    
    /**
     * get the account and PCH profile along with all the authorized users
     * @param acctNum
     * @param filter
     * @return
     * @throws Exception
     */
    public static CustomerProfileType getAcctPchFullProfile(String acctNum, RcpFilter filter) throws Exception {
    	
		TEnvRetrieveCustomerProfileRs odsCustProf = TdOdsCustomerProfileService.retrieveCustomerProfileViaAcctNum(acctNum, filter); // calling via account number should yield just one profile object
    	CustomerProfileType custProf = convertToMtCustomerProfile(odsCustProf, filter);    	
    	validateCustomerProfileViaAcctNum(custProf, acctNum);   
    	
    	CustomerAcctProfileType rc = new CustomerAcctProfileType();
    	rc.setCustInfo(custProf.getCustInfo());
    	rc.setAcctInfo(custProf.getAccounts().get(0).getCardHolderAcctInfo());  
    	custProf.getAccounts().get(0).setPchAcctProfile(rc);
    	return custProf;
    }
    
    
    
	public static List<CustAcctType> getCustAcctRelationship(String custId) throws Exception {
		CustomerProfileType logonCustAcctRelationship = OdsHelper.getCustomerProfile(custId, RcpFilter.RELATIONSHIPS);
		return CustomerProfileUtil.downConvert(logonCustAcctRelationship.getAccounts());
	}
    
	/**
	 * get a list of card that belong to this customer. 
	 * @param custId
	 * @param acctNum
	 * @return Both active, lost, stolen cards of the customer
	 * @throws Exception
	 */
	public List<CardNumHistoryType> getCardHistory(String custId, String acctNum) throws Exception {
	        String sCalledKey = "odshelper_getCardHistory_"+custId+acctNum+"_called_";
	        String sCalledValue = (String) sessionMidProvider.getSessionAttribute(sCalledKey);
	        String sKey = "odshelper_getCardHistory_"+custId+acctNum;
	        List<CardNumHistoryType> xHistoryCards = (List<CardNumHistoryType>) sessionMidProvider.getSessionAttribute(sKey);
	        // 1. check cache if historyCards is already in cache then get it from cache
	        if(!"true".equalsIgnoreCase(sCalledValue)){
				TEnvRetrieveCustomerProfileRs odsCustProf = TdOdsCustomerProfileService.retrieveCustomerProfileViaAcctNum(acctNum, RcpFilter.RELATIONSHIPS_CARDHISTORY);
		    	CustomerProfileType custProf = TransformUtil.transformRequest(CustProfileRetriever, odsCustProf, null, CustomerProfileType.class);
				CustomerAcctType account = custProf.getAccounts().get(0);
				List<CardHolderType> otherCardHolders =account.getOtherCardHolders();
				CardHolderType cardHolderType =otherCardHolders.stream().filter(otherCardHolder->custId.equals(otherCardHolder.getCustomerID())).findAny().orElse(null);
			  	if (custId.equals(account.getCardHolder().getCustomerID())|| custId.equals(cardHolderType.getCustomerID()) ) {
			  		xHistoryCards = (account.getCardNumList());
				}else{
					logger.warning("custId=" + custId + "; acctNum=" + acctNum + "; " + account.getCardHolder().getCustomerID());
				}
//			  	return null;
		      	sessionMidProvider.setSessionAttribute(sKey, xHistoryCards);
	        	sessionMidProvider.setSessionAttribute(sCalledKey, "true");
	        }
	        return xHistoryCards;

	}

	/**
	 * get a list of card that belong to this customer.
	 * @param acctNum
	 * @return Both active, lost, stolen cards of the customer
	 * @throws Exception
	 */
	public static CustomerProfileType getCardHistory(String acctNum) throws Exception {

		TEnvRetrieveCustomerProfileRs odsCustProf = TdOdsCustomerProfileService.retrieveCustomerProfileViaAcctNum(acctNum, RcpFilter.RELATIONSHIPS_CARDHISTORY);
		CustomerProfileType custProf = TransformUtil.transformRequest(CustProfileRetriever, odsCustProf, null, CustomerProfileType.class);
		populateCardHistoryList(odsCustProf,custProf);

		return custProf;
	}

	private static void populateCardHistoryList(TEnvRetrieveCustomerProfileRs odsCustProf, CustomerProfileType customerProfileType) {

		logger.debug("populating historical card list");
		
		if(odsCustProf == null ||odsCustProf.getAbstractBusinessSvcRs() == null){
			return;
		}
		
		TSvcRetrieveCustomerProfileRs tSvcRetrieveCustomerProfileRs =  ((TSvcRetrieveCustomerProfileRs) odsCustProf.getAbstractBusinessSvcRs().getValue());
		if(tSvcRetrieveCustomerProfileRs == null ||tSvcRetrieveCustomerProfileRs.getPerson() == null ||tSvcRetrieveCustomerProfileRs.getPerson().getPartyAgreement() == null){
			return;
		}

		for(TPartyAgreement tPartyAgreement : tSvcRetrieveCustomerProfileRs.getPerson().getPartyAgreement()) {
			if(tPartyAgreement == null){
				continue;
			}
			if ("PRIMARY-ACCOUNT-HOLDER".equalsIgnoreCase(tPartyAgreement.getPartyAgreementRoleCd())) {

				if (tPartyAgreement.getAgreementAccessDevice() != null 
						&& tPartyAgreement.getAgreementAccessDevice().size() > 0) {
					customerProfileType.getAccounts().get(0).getCardHolderAcctInfo().getCardNumList().addAll(getCardHistoryList(tPartyAgreement.getAgreementAccessDevice()));
				}

				List<TPartyAgreementRelated>  relatedParties = tPartyAgreement.getPartyAgreementRelated();
				TRelatedPartyAgreement tRelatedPartyAgreement;

				if (relatedParties != null && relatedParties.size() > 0) {
					String auCustId;

					for(TPartyAgreementRelated aRelatedPartyDetails : relatedParties) {

						if(aRelatedPartyDetails == null){
							continue;
						}
						tRelatedPartyAgreement = aRelatedPartyDetails.getPartyAgreement();
						auCustId = tRelatedPartyAgreement.getParty().getPartyID();

						if ( tRelatedPartyAgreement.getAgreementAccessDevice() == null || tRelatedPartyAgreement.getAgreementAccessDevice().isEmpty()) {
							continue;
						}
						//find the other card holder and update the list.
						List<CustomerAcctProfileType> types = customerProfileType.getAccounts().get(0).getOtherAcctProfiles();
						if(types == null || types.isEmpty()){
							continue;
						}
						for(CustomerAcctProfileType  anAUAcctProfile: types ) {
							
							if(anAUAcctProfile == null){
								continue;
							}
							if (anAUAcctProfile.getAcctInfo().getCustId().equalsIgnoreCase(auCustId)) {
								anAUAcctProfile.getAcctInfo().getCardNumList().addAll(getCardHistoryList(tRelatedPartyAgreement.getAgreementAccessDevice()));
							}
							
						}

					}
				}


			}
		}


	}

	private static List<CardNumHistoryType> getCardHistoryList(List<TAgreementAccessDevice> cards) {
		List<CardNumHistoryType> cardNumHistoryTypeList = new ArrayList<>();
		if (cards == null || cards.isEmpty()){
			return cardNumHistoryTypeList;
		}
		CardNumHistoryType aHistoricCard;
		TCard tCard;

		for(TAgreementAccessDevice tAgreementAccessDevice : cards) {
			if(tAgreementAccessDevice == null){
				continue;
			}
			aHistoricCard = new CardNumHistoryType();

			if (tAgreementAccessDevice.getCard() != null && tAgreementAccessDevice.getCard().size() > 0) {
				tCard = tAgreementAccessDevice.getCard().get(0);

				aHistoricCard.setCard(tCard.getCardNum());
				aHistoricCard.setCardHolderName(tCard.getCardName());
				aHistoricCard.setStatus(tAgreementAccessDevice.getAgreementAccessDeviceStatusCd());

				cardNumHistoryTypeList.add(aHistoricCard);
			}

		}

		return cardNumHistoryTypeList;

	}
	
	public static String getCreditCardNum(String custId, String acctNum) throws Exception {
		String cardNum = null;
		// Please note ODS returns credit card numbers only if the RELATIONSHIPS filter is present
		
		TEnvRetrieveCustomerProfileRs odsCustProf = TdOdsCustomerProfileService.retrieveCustomerProfileViaAcctNum(acctNum, RcpFilter.RELATIONSHIPS); 
    	CustomerProfileType custProf = convertToMtCustomerProfile(odsCustProf, RcpFilter.RELATIONSHIPS); 
    	validateCustomerProfileViaAcctNum(custProf, acctNum);
    	CustomerAcctType account = custProf.getAccounts().get(0);
    	if (custId.equals(account.getCardHolder().getCustomerID())) {
    		cardNum = account.getCardNum();
    	}
    	else {
    		for (CustomerAcctProfileType pch : account.getOtherAcctProfiles()) {
    			if(pch == null){
    				continue;
    			}
    			CustomerAcctInfoType pchAcctInfo = pch.getAcctInfo();
    			if (custId.equals(pchAcctInfo.getCustId())) {
    				cardNum =  pchAcctInfo.getCardNum();
    				break;
    			}
    		}
    	}
    	if (cardNum == null) {
    		String desc = "CODS SOAP service OdsHelper.getCreditCardNum(custId, acctNum) failed to find card# for account " + acctNum + " customer " + custId;
			logger.error(desc);
			throw ExceptionUtil.genBusinessException(desc);
    	}
    	return cardNum;
	}
	

	
	
	/**
	 *  Validate customer profile returned from a account-centric ODS retrieve request
	 * @param custProf
	 * @param acctNum
	 */
	private static void validateCustomerProfileViaAcctNum(CustomerProfileType custProf, String acctNum) {
    	List<CustomerAcctType> accounts = custProf.getAccounts();
    	if (accounts.size() != 1) {
    		throw new RuntimeException("ODS retrieve via account# " + acctNum + " yields more than one account.");
    	}
    	CustomerAcctType returnedAcct = custProf.getAccounts().get(0);
    	if (returnedAcct.getAcctNum().equals(acctNum) == false) {
    		throw new RuntimeException("ODS retrieve via account# " + acctNum + " returns account with acct# " + returnedAcct.getAcctNum());
    	}
	}
		

    private static CustomerProfileType convertToMtCustomerProfile(TEnvRetrieveCustomerProfileRs odsCustProf, RcpFilter filter) throws Exception {
    	    	
    	CustomerProfileType custProf = TransformUtil.transformRequest(CustProfileRetriever, odsCustProf, null, CustomerProfileType.class);
    	
    	
    	// Default the country code if blank.
    	if (custProf.getCustInfo() != null && (custProf.getCustInfo().getPhysicalCountry() == null || custProf.getCustInfo().getPhysicalCountry().trim().length() == 0)) {
    		custProf.getCustInfo().setPhysicalCountry(DEFAULT_COUNTRY);
    	}
		for (CustomerAcctType acct: custProf.getAccounts()) {
			if(acct == null){
				continue;
			}
			if (acct.getCardHolderAcctInfo() != null && (acct.getCardHolderAcctInfo().getMailingCountry() == null || acct.getCardHolderAcctInfo().getMailingCountry().trim().length() == 0)) {
				acct.getCardHolderAcctInfo().setMailingCountry(DEFAULT_COUNTRY);
			}
			if (acct.getPchAcctProfile() != null) {
				if (acct.getPchAcctProfile().getCustInfo() != null && (acct.getPchAcctProfile().getCustInfo().getPhysicalCountry() == null || acct.getPchAcctProfile().getCustInfo().getPhysicalCountry().trim().length() == 0)) {
					acct.getPchAcctProfile().getCustInfo().setPhysicalCountry(DEFAULT_COUNTRY);
				}
				if (acct.getPchAcctProfile().getAcctInfo() != null && (acct.getPchAcctProfile().getAcctInfo().getMailingCountry() == null || acct.getPchAcctProfile().getAcctInfo().getMailingCountry().trim().length() == 0)) {
					acct.getPchAcctProfile().getAcctInfo().setMailingCountry(DEFAULT_COUNTRY);
				}
			}
			for (CustomerAcctProfileType auAcct : acct.getOtherAcctProfiles()) {
				if(auAcct == null){
					continue;
				}
				if (auAcct.getCustInfo() != null && (auAcct.getCustInfo().getPhysicalCountry() == null || auAcct.getCustInfo().getPhysicalCountry().trim().length() == 0)) {
					auAcct.getCustInfo().setPhysicalCountry(DEFAULT_COUNTRY);
				}
				if (auAcct.getAcctInfo() != null && (auAcct.getAcctInfo().getMailingCountry() == null || auAcct.getAcctInfo().getMailingCountry().trim().length() == 0)) {
					auAcct.getAcctInfo().setMailingCountry(DEFAULT_COUNTRY);
				}
			}
		}

		boolean contactsFilterUsed = filter.containsFilter(RcpFilter.CONTACTS);
		List<CustomerAcctType> accounts = custProf.getAccounts();
		boolean wantsEmailPref = filter.containsFilter(RcpFilter.PREFERENCES);
		for (CustomerAcctType account : accounts) {
			if(account == null){
				continue;
			}
			if (wantsEmailPref && account.getPrimaryCardHolder() != null) {
				String pchCustId = account.getPrimaryCardHolder().getCustomerID();
				String acctNum =  account.getAcctNum();
//				Accounts dbCustAcct = DBService.getAccount(pchCustId, acctNum);
				Accounts dbCustAcct = DBMybatisService.getAccount(pchCustId, acctNum);
				if (dbCustAcct != null && dbCustAcct.getEmailPreference() != null && "true".equalsIgnoreCase(dbCustAcct.getEmailPreference().trim())) {
					CustomerProfileUtil.findCustAcctInfoFromProfile(custProf, acctNum).setConfirmationEmailWanted(true);
				}
			}
			if (contactsFilterUsed) {
				checkMailingAddressExists(account);
			}
			CardHolderType logonCust = account.getCardHolder();
			if (logonCust.isPrimaryUser()) {
				account.setPrimaryCardHolder(logonCust);
			}
			CustomerProfileUtil.setCardHolderDetails(custProf.getCustInfo(), logonCust); // set basic person-level info for logon customer
			CustomerProfileUtil.marshalAddresses(custProf.getCustInfo(), account.getCardHolderAcctInfo());
			for (CustomerAcctProfileType authUser : account.getOtherAcctProfiles()) {
				if(authUser == null){
					continue;
				}
				CustomerProfileUtil.marshalAddresses(custProf.getCustInfo(),authUser.getAcctInfo());				
			}
		}
		return custProf;
    }

    /**
     * returns a complete customer profile: customer information, and a list of accounts.
     * @param custId
     * @param filter
     * @return
     * @throws Exception
     */
	public static CustomerProfileType getCustomerProfile(String custId, RcpFilter filter) throws Exception {
		TEnvRetrieveCustomerProfileRs odsCustProf = TdOdsCustomerProfileService.retrieveCustomerProfileViaPartyId(custId, filter);
		CustomerProfileType custProf = convertToMtCustomerProfile(odsCustProf, filter);
		return custProf;
	}

	// Check that mailing address exists for all UCID returned by the current retrieveCustomerProfile call.
	private static void checkMailingAddressExists(CustomerAcctType account) {
		checkMailingAddressExists(account.getCardHolderAcctInfo());	// make sure mailing address exists for card holder
		if (account.getCardHolder().isPrimaryUser() == false && account.getPchAcctProfile() != null) {	// make sure mailing address exists for primary card holder, if not same person as card holder
			checkMailingAddressExists(account.getPchAcctProfile().getAcctInfo());
		}
		for (CustomerAcctProfileType otherAcct : account.getOtherAcctProfiles()) { // make sure mailing address exists for other card holders, if any
			if(otherAcct == null){
				continue;
			}
			checkMailingAddressExists(otherAcct.getAcctInfo());
		}
	}
		
	private static void checkMailingAddressExists(CustomerAcctInfoType custAcctInfo) {
		if (CustomerProfileUtil.compareField(custAcctInfo.getMailingAddressLine1(), null) 
				|| CustomerProfileUtil.compareField(custAcctInfo.getMailingCity(), null) 
				|| CustomerProfileUtil.compareField(custAcctInfo.getMailingProvince(), null) 
				|| CustomerProfileUtil.compareField(custAcctInfo.getMailingPostalCode(), null)) {
			
			String message = "checkMailingAddressExists(CustomerAcctInfoType custAcctInfo):: Account ending " + custAcctInfo.getAcctNum().substring(custAcctInfo.getAcctNum().length()-4) + "'s card holder " + custAcctInfo.getCustId() + " is missing mailing address in ODS response.";
			logger.error(message);
//			throw ExceptionUtil.genBusinessException(message);
		}
	}

}
