package com.td.mbna.msec.midtier.customerprofile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mbnaweb.xsd.msgs.account.GetAccountOverviewsRequest;
import com.mbnaweb.xsd.msgs.account.GetAccountOverviewsResponse;
import com.mbnaweb.xsd.msgs.customerprofile.CustomerAcctLogonInfoType;
import com.mbnaweb.xsd.msgs.customerprofile.CustomerAcctProfileType;
import com.mbnaweb.xsd.msgs.customerprofile.CustomerAcctType;
import com.mbnaweb.xsd.msgs.customerprofile.CustomerProfileType;
import com.mbnaweb.xsd.msgs.customerprofile.GetUserInfoAndAccountsRequest;
import com.mbnaweb.xsd.msgs.customerprofile.GetUserInfoAndAccountsResponse;
import com.mbnaweb.xsd.types.common.AcctOverviewType;
import com.mbnaweb.xsd.types.common.BaseRequest;
import com.mbnaweb.xsd.types.common.CardHolderType;
import com.mbnaweb.xsd.types.common.CardNumHistoryType;
import com.mbnaweb.xsd.types.common.CustAcctType;
import com.mbnaweb.xsd.types.common.TtcDestinationsInfoType;
import com.td.api.mbcca.CardInfo;
import com.td.mbna.msec.midtier.eligibility.payload.getentitlementflags.GetEntitlementFlagsResponse;
import com.td.mbna.msec.midtier.mbofp.MbnaOFP;
import com.td.mbna.msec.midtier.offers.RetrieveOffersForAccountsOperation;
import com.td.mbna.msec.midtier.offers.payload.retrieveoffers.RetrieveOffersResponse;
import com.td.mbna.msec.midtier.offers.payload.retrieveoffersforaccounts.RetrieveOffersForAccountsResponse;
import com.td.mbna.msec.midtier.ofm.util.OfmEligibilityUtil;
import com.td.mbna.msec.midtier.persistance.entity.TtcDestinations;
//import com.td.mbna.msec.midtier.persistance.hibernate.DBService;
import com.td.mbna.msec.midtier.persistance.mybatis.DBMybatisService;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.AccountOffersType;
import com.td.mbna.msec.midtier.types.eligibility.CustEligType;
import com.td.mbna.msec.midtier.util.AffinityInfoUtil;
import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.CustomerProfileUtil;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.ParallelServiceCaller;
import com.td.mbna.msec.midtier.util.RequestUtil;
import com.td.mbna.msec.midtier.util.ServiceCall;
import com.td.mbna.msec.midtier.util.ods.OdsHelper;
import com.td.mbna.msec.midtier.util.services.JAXBJsonConverter;
import com.td.mbna.msec.midtier.util.services.MSECConstants;

@Component
public class GetUserInfoAndAccountsOperation implements
		MsecMidtierCommonOperations<com.td.mbna.msec.midtier.customerprofile.payload.getuserinfoandaccounts.GetUserInfoAndAccountsRequest, com.td.mbna.msec.midtier.customerprofile.payload.getuserinfoandaccounts.GetUserInfoAndAccountsResponse> {

	private static MbnaLogger logger = new MbnaLogger(GetUserInfoAndAccountsOperation.class);

	@Autowired
	private RetrieveOffersForAccountsOperation retrieveOffersForAccountsOperation;

	@Autowired
	private GetAccountOverViewsOperation getAccountOverViewsOperation;

	@Autowired
	private OfmEligibilityUtil ofmEligibilityUtil;

	@Autowired
	private MbnaOFP mbnaOFP;

	private GetAccountOverviewsRequest genGetCustomerAccountsRequest(
			com.mbnaweb.xsd.msgs.customerprofile.GetUserInfoAndAccountsRequest request,
			List<CustAcctType> enrolledAccts, List<CustAcctType> allAccts, ParallelServiceCaller parallelCaller) {
		GetAccountOverviewsRequest getAcctReq = new GetAccountOverviewsRequest();
		RequestUtil.copyHeader(request, getAcctReq);
		GetAccountOverviewsRequest.RequestPayload getAcctReqPL = new GetAccountOverviewsRequest.RequestPayload();
		getAcctReq.setRequestPayload(getAcctReqPL);
		getAcctReqPL.getEnrolledAccts().addAll(enrolledAccts);
		getAcctReqPL.getAllAccts().addAll(allAccts);
		return getAcctReq;
	}

	private void scheduleRetrieveOffersForAccounts(BaseRequest request,
			GetAccountOverviewsResponse enrolledAcctOverviews, ParallelServiceCaller rtrOffersCaller, String token)
			throws Exception {
		scheduleRetrieveOffersForAccounts(request.getSessionInfo().getConnectId(), request.getCustId(),
				enrolledAcctOverviews, rtrOffersCaller, token);
	}

	private void scheduleRetrieveOffersForAccounts(String connectId, String custId,
			com.mbnaweb.xsd.msgs.account.GetAccountOverviewsResponse acctOverviewsRes,
			ParallelServiceCaller rtrOffersCaller, String token) throws Exception {
		List<AcctOverviewType> acctOverviews = acctOverviewsRes.getResponsePayload().getCustAccts();
		for (AcctOverviewType acctOverview : acctOverviews) {
			ServiceCall<?> rtrOffersCall = new ServiceCall<RetrieveOffersResponse>() {
				@Override
				public RetrieveOffersResponse invoke() throws Exception {
					Map<String, String> params = new HashMap<>(3);
					params.put(MSECConstants.TD_OFP_API_AGREEMENT_ID, acctOverview.getAcctNum());
					params.put(MSECConstants.CONNECT_ID, connectId);
					params.put(MSECConstants.TD_OFP_API_PARTY_ID, custId);
					if (acctOverview.getCreditLimit() != null) {
						params.put(MSECConstants.TD_OFP_API_CREDIT_LIMIT, acctOverview.getCreditLimit().toString());
					}
					return mbnaOFP.retrieveOfferList(params, token);
				}
			};
			rtrOffersCaller.scheduleCall(acctOverview.getAcctNum(), rtrOffersCall);
		}
	}

	private RetrieveOffersForAccountsResponse getRetrieveOffersForAccountsResult(List<CustAcctType> enrolledAccts,
			ParallelServiceCaller rtrOffersCaller) throws Exception {
		List<String> acctNumbers = enrolledAccts.stream().map(acct -> acct.getAcctNum()).collect(Collectors.toList());
		return this.retrieveOffersForAccountsOperation.getRetrieveOffersForAccountsResult(acctNumbers, rtrOffersCaller);
	}

	private GetAccountOverviewsResponse scheduleGetAccountOverviews(
			com.mbnaweb.xsd.msgs.customerprofile.GetUserInfoAndAccountsRequest request,
			List<CustAcctType> enrolledAccts, List<CustAcctType> allAccts, ParallelServiceCaller parallelCaller,
			String token) throws Exception {
		GetAccountOverviewsRequest getAcctReq = genGetCustomerAccountsRequest(request, enrolledAccts, allAccts,
				parallelCaller);
		return getAccountOverViewsOperation.scheduleCalls(getAcctReq, parallelCaller, token);
	}

	private GetAccountOverviewsResponse getGetCustomerAccountsResponseResult(
			GetAccountOverviewsResponse getAccountOverviewsResponse, GetUserInfoAndAccountsRequest request,
			List<CustAcctType> enrolledAccts, List<CustAcctType> allAccts, ParallelServiceCaller parallelCaller)
			throws Exception {
		GetAccountOverviewsRequest getAcctReq = genGetCustomerAccountsRequest(request, enrolledAccts, allAccts,
				parallelCaller);
		GetAccountOverviewsResponse rc = getAccountOverViewsOperation.getResult(getAccountOverviewsResponse, getAcctReq,
				parallelCaller);
		return rc;
	}

	private void populatePayload(List<CustAcctType> enrolledAccts, boolean cardServiceOk, CustomerProfileType custPf,
			GetAccountOverviewsResponse enrolledAcctOverviews, GetEntitlementFlagsResponse eligRes,
			com.mbnaweb.xsd.msgs.customerprofile.GetUserInfoAndAccountsResponse.ResponsePayload responsePL)
			throws Exception {
		if (responsePL == null || eligRes == null || eligRes.getResponsePayload() == null
				|| eligRes.getResponsePayload().getCustElig() == null) {
			return;
		}
		List<CustomerAcctLogonInfoType> acctCustDetailsList = responsePL.getAccountCustomerDetails();
		CustEligType custElig = eligRes.getResponsePayload().getCustElig();
		int numEnrolledAccts = enrolledAccts.size();
		for (int i = 0; i < numEnrolledAccts; i++) {
			final String acctNum = enrolledAccts.get(i).getAcctNum();
			final CustomerAcctLogonInfoType acctCustDetails = new CustomerAcctLogonInfoType();
			acctCustDetailsList.add(acctCustDetails);
			CustomerAcctProfileType custAcctPf = CustomerProfileUtil.genCustAcctProfile(custPf, acctNum);
			acctCustDetails.setCustInfo(custAcctPf.getCustInfo());
			acctCustDetails.setAcctInfo(custAcctPf.getAcctInfo());

			CustomerAcctType custAcct = CustomerProfileUtil.findCustAcctFromProfile(custPf, acctNum);
			if (custAcct != null) {
				acctCustDetails.setCardHolder(custAcct.getCardHolder());
				acctCustDetails.setPrimaryCardHolder(custAcct.getPrimaryCardHolder());
				acctCustDetails.getOtherCardHolders().addAll(custAcct.getOtherCardHolders());
				if (custAcct.getCardHolder().isPrimaryUser()) {
					acctCustDetails.setPrimaryUserContact(CustomerProfileUtil.mapToContactInfoType(custAcctPf));
				} else {
					acctCustDetails.setPrimaryUserContact(
							CustomerProfileUtil.mapToContactInfoType(custAcct.getPchAcctProfile()));
				}
			}
			ofmEligibilityUtil.checkCardServiceAndUpdate(custElig, acctNum, cardServiceOk);
		}
		responsePL.setCustElig(JAXBJsonConverter.convertJsonToJAXBInterface(custElig,
				com.mbnaweb.xsd.types.eligibility.CustEligType.class));
		populateAcctOverviews(enrolledAcctOverviews, responsePL, custElig);
		checkCardHolders(custPf, enrolledAcctOverviews);//
		populateAccountNumberAndCardHolderName(responsePL, enrolledAcctOverviews);
	}

	private void checkCardHolders(CustomerProfileType custPf, GetAccountOverviewsResponse enrolledAcctOverviews) {
		Map<String, GetAccountOverviewsResponse.ResponsePayload.CardHolderInfo> cardHolderListInProfile = new HashMap<>();
		List<CustomerAcctType> customerAccts = custPf.getAccounts();
		if (customerAccts != null && customerAccts.size() > 0) {
			for (CustomerAcctType cat : customerAccts) {
				if (cat.getOtherCardHolders() != null && cat.getOtherCardHolders().size() > 0) {
					for (com.mbnaweb.xsd.types.common.CardHolderType cht : cat.getOtherCardHolders()) {
						cardHolderListInProfile.put(cht.getAliasCustomerID(), convertCardHolder(cht));
					}
				}
				if (cat.getPrimaryCardHolder() != null && cat.getPrimaryCardHolder().getAliasCustomerID() != null) {
					cardHolderListInProfile.put(cat.getPrimaryCardHolder().getAliasCustomerID(),
							convertCardHolder(cat.getPrimaryCardHolder()));
				}
				if (cat.getCardHolder() != null && cat.getCardHolder().getAliasCustomerID() != null) {
					cardHolderListInProfile.put(cat.getCardHolder().getAliasCustomerID(),
							convertCardHolder(cat.getCardHolder()));
				}
			}
		}
		List<GetAccountOverviewsResponse.ResponsePayload.CardHolderInfo> chis = new ArrayList<>();
		chis.addAll(cardHolderListInProfile.values());
		chis.sort((o1, o2) -> o1.getCustomerId().compareTo(o2.getCustomerId()));

		final StringBuffer sb1 = new StringBuffer("cardHolders1: ");
		chis.stream().forEach(chi -> sb1.append(chi.getCustomerId()).append(",").append(chi.getCardNumber()).append(",")
				.append(chi.getCardHolderName()).append(";"));
		logger.info(sb1.toString());

		List<GetAccountOverviewsResponse.ResponsePayload.CardHolderInfo> cardHolders = enrolledAcctOverviews
				.getResponsePayload().getCardHolderInfo();
		cardHolders.sort((o1, o2) -> o1.getCustomerId().compareTo(o2.getCustomerId()));
		final StringBuffer sb2 = new StringBuffer("cardHolders2: ");
		cardHolders.stream().forEach(chi -> sb2.append(chi.getCustomerId()).append(",").append(chi.getCardNumber())
				.append(",").append(chi.getCardHolderName()).append(";"));
		logger.info(sb2.toString() + " cardHolders length difference: " + (sb1.length() - sb2.length()));

	}

	private GetAccountOverviewsResponse.ResponsePayload.CardHolderInfo convertCardHolder(
			com.mbnaweb.xsd.types.common.CardHolderType cht) {
		GetAccountOverviewsResponse.ResponsePayload.CardHolderInfo chi = new GetAccountOverviewsResponse.ResponsePayload.CardHolderInfo();
		chi.setCustomerId(cht.getAliasCustomerID());
		chi.setCardNumber(cht.getCardNumber());
		chi.setCardHolderName(cht.getCardHolderName());
		return chi;
	}

	private void populateAccountNumberAndCardHolderName(GetUserInfoAndAccountsResponse.ResponsePayload responsePL,
			GetAccountOverviewsResponse enrolledAcctOverviews) throws Exception {
		String customerId, codsCustId;
		Map<String, List<String>> cardsListByCustomerId;
		List<String> historicalCardsList;
		for (CustomerAcctLogonInfoType aCustomerAcctLogonInfoType : responsePL.getAccountCustomerDetails()) {
			cardsListByCustomerId = populateHistoricalCards(aCustomerAcctLogonInfoType.getAcctInfo().getAcctNum());
			if (aCustomerAcctLogonInfoType.getCardHolder() != null) {
				// update card holder
				customerId = aCustomerAcctLogonInfoType.getCardHolder().getAliasCustomerID();
				codsCustId = aCustomerAcctLogonInfoType.getCardHolder().getCustomerID();
				for (GetAccountOverviewsResponse.ResponsePayload.CardHolderInfo aCardHolderInfo : enrolledAcctOverviews
						.getResponsePayload().getCardHolderInfo()) {
					if (aCardHolderInfo.getCustomerId().equals(customerId)) {
						aCustomerAcctLogonInfoType.getCardHolder().setCardNumber(aCardHolderInfo.getCardNumber());
						aCustomerAcctLogonInfoType.getCardHolder()
								.setTransferFromCardNumber(aCardHolderInfo.getTransferFromCardNumber());
						aCustomerAcctLogonInfoType.getCardHolder()
								.setCardHolderName(aCardHolderInfo.getCardHolderName());
						aCustomerAcctLogonInfoType.getCardHolder().setAliasCustomerID(aCardHolderInfo.getCustomerId());
						// populate historical cards
						historicalCardsList = cardsListByCustomerId.get(codsCustId);
						aCustomerAcctLogonInfoType.getCardHolder().getHistoricalCardNumbers().clear();
						aCustomerAcctLogonInfoType.getCardHolder().getHistoricalCardNumbers()
								.addAll(historicalCardsList);
						break;
					}
				}
			}
			// update primary card holder
			if (aCustomerAcctLogonInfoType.getPrimaryCardHolder() != null) {
				customerId = aCustomerAcctLogonInfoType.getPrimaryCardHolder().getAliasCustomerID();
				codsCustId = aCustomerAcctLogonInfoType.getPrimaryCardHolder().getCustomerID();
				for (GetAccountOverviewsResponse.ResponsePayload.CardHolderInfo aCardHolderInfo : enrolledAcctOverviews
						.getResponsePayload().getCardHolderInfo()) {
					if (aCardHolderInfo.getCustomerId().equals(customerId)) {
						aCustomerAcctLogonInfoType.getPrimaryCardHolder()
								.setCardNumber(aCardHolderInfo.getCardNumber());
						aCustomerAcctLogonInfoType.getPrimaryCardHolder()
								.setTransferFromCardNumber(aCardHolderInfo.getTransferFromCardNumber());
						aCustomerAcctLogonInfoType.getPrimaryCardHolder()
								.setCardHolderName(aCardHolderInfo.getCardHolderName());
						aCustomerAcctLogonInfoType.getPrimaryCardHolder()
								.setAliasCustomerID(aCardHolderInfo.getCustomerId());
						// populate historical cards
						historicalCardsList = cardsListByCustomerId.get(codsCustId);
						aCustomerAcctLogonInfoType.getPrimaryCardHolder().getHistoricalCardNumbers().clear();
						aCustomerAcctLogonInfoType.getPrimaryCardHolder().getHistoricalCardNumbers()
								.addAll(historicalCardsList);
						break;
					}
				}
			}
			// update other card holders
			if (aCustomerAcctLogonInfoType.getOtherCardHolders() != null
					&& aCustomerAcctLogonInfoType.getOtherCardHolders().size() > 0) {
				for (CardHolderType anOtherCardHolderType : aCustomerAcctLogonInfoType.getOtherCardHolders()) {
					customerId = anOtherCardHolderType.getAliasCustomerID();
					codsCustId = anOtherCardHolderType.getCustomerID();
					for (GetAccountOverviewsResponse.ResponsePayload.CardHolderInfo aCardHolderInfo : enrolledAcctOverviews
							.getResponsePayload().getCardHolderInfo()) {
						if (aCardHolderInfo.getCustomerId().equals(customerId)) {
							anOtherCardHolderType.setCardNumber(aCardHolderInfo.getCardNumber());
							anOtherCardHolderType
									.setTransferFromCardNumber(aCardHolderInfo.getTransferFromCardNumber());
							anOtherCardHolderType.setCardHolderName(aCardHolderInfo.getCardHolderName());
							anOtherCardHolderType.setAliasCustomerID(aCardHolderInfo.getCustomerId());
							// populate historical cards
							historicalCardsList = cardsListByCustomerId.get(codsCustId);
							anOtherCardHolderType.getHistoricalCardNumbers().clear();
							anOtherCardHolderType.getHistoricalCardNumbers().addAll(historicalCardsList);
							break;
						}
					}
				}
			}
		}
	}

	private Map<String, List<String>> populateHistoricalCards(String accountId) throws Exception {
		Map<String, List<String>> cardsListByCustomerId = new HashMap<>();
		CustomerProfileType customerProfileType = OdsHelper.getCardHistory(accountId);
		CustomerAcctType selectedCustomerAcctType = null;
		List<CustomerAcctProfileType> otherCardHolders = null;
		for (CustomerAcctType customerAcctType : customerProfileType.getAccounts()) {
			if (customerAcctType.getAcctNum().equalsIgnoreCase(accountId)) {
				selectedCustomerAcctType = customerAcctType;
				break;
			}
		}
		if (selectedCustomerAcctType != null) {
			cardsListByCustomerId.put(selectedCustomerAcctType.getCardHolderAcctInfo().getCustId(),
					getCardNumbersList(selectedCustomerAcctType.getCardHolderAcctInfo().getCardNumList()));
			otherCardHolders = selectedCustomerAcctType.getOtherAcctProfiles();
			if (otherCardHolders != null && otherCardHolders.size() > 0) {
				for (CustomerAcctProfileType anAuDetail : selectedCustomerAcctType.getOtherAcctProfiles()) {
					cardsListByCustomerId.put(anAuDetail.getAcctInfo().getCustId(),
							getCardNumbersList(anAuDetail.getAcctInfo().getCardNumList()));
				}
			}
		}
		return cardsListByCustomerId;
	}

	private List<String> getCardNumbersList(List<CardNumHistoryType> cardNumHistoryTypeList) {
		List<String> cardsList = new ArrayList<>();
		for (CardNumHistoryType aCardNumber : cardNumHistoryTypeList) {
			cardsList.add(aCardNumber.getCard());
		}
		return cardsList;
	}

	private void populateAcctOverviews(GetAccountOverviewsResponse enrolledAcctOverviews,
			GetUserInfoAndAccountsResponse.ResponsePayload responsePL, CustEligType custElig) {
		List<AcctOverviewType> acctOverviews = enrolledAcctOverviews.getResponsePayload().getCustAccts();
		List<AcctOverviewType> resAcctOverviews = responsePL.getCustAccts();
		for (AcctOverviewType acctOverview : acctOverviews) {
			acctOverview.setOffersParams(null); // offersParams is already consumed by code that retrieved the offers;
												// no point sending it back, so remove.
			resAcctOverviews.add(acctOverview);
			if (acctOverview.getBtContractOffer() == null) { // when no match txn fee table entry found, disable BT &
																// TTC
				ofmEligibilityUtil.disableBT(custElig, acctOverview.getAcctNum());
			}
		}
	}

	private static void populateEnrolledAcctData(List<CustAcctType> enrolledAccts, List<CustAcctType> allAcctsWithData)
			throws Exception {
		String methodName = "populateEnrolledAcctData";
		logger.toJson(methodName + "--in::allAcctsWithData", allAcctsWithData);
		logger.toJson(methodName + "--in::enrolledAccts", enrolledAccts);
		Map<String, CustAcctType> acctNum2InfoMap = new HashMap<String, CustAcctType>(allAcctsWithData.size());
		for (CustAcctType acctWithData : allAcctsWithData) {
			acctNum2InfoMap.put(acctWithData.getAcctNum(), acctWithData);
		}
		for (CustAcctType enrolledAcct : enrolledAccts) {
			CustAcctType matchingAcctWithData = acctNum2InfoMap.get(enrolledAcct.getAcctNum());
			if (matchingAcctWithData == null) {
				continue;
			}
			CustomerProfileUtil.setValues(matchingAcctWithData, enrolledAcct);
		}
		logger.toJson(methodName + "--out::enrolledAccts", enrolledAccts);
	}

	private static void populateAffinity(List<CustAcctType> allAcctsWithAffinityInfo, List<CustAcctType> allAccts)
			throws Exception {
		Map<String, CustAcctType> acctNum2InfoMap = new HashMap<String, CustAcctType>(allAcctsWithAffinityInfo.size());
		for (CustAcctType acctWithAffinity : allAcctsWithAffinityInfo) {
			acctNum2InfoMap.put(acctWithAffinity.getAcctNum(), acctWithAffinity);
		}
		for (CustAcctType acct : allAccts) {
			CustAcctType matchingAcctWithAffinity = acctNum2InfoMap.get(acct.getAcctNum());
			if (matchingAcctWithAffinity == null) {
				continue;
			}
			AffinityInfoUtil.setAffinityRelatedValues(matchingAcctWithAffinity, acct);
		}
	}

	@Override
	public com.td.mbna.msec.midtier.customerprofile.payload.getuserinfoandaccounts.GetUserInfoAndAccountsResponse invokeService(
			com.td.mbna.msec.midtier.customerprofile.payload.getuserinfoandaccounts.GetUserInfoAndAccountsRequest requestInJson,
			String... token) {

		String methodName = "GetUserInfoAndAccountsOperation::invokeService";
		String logonCustId = requestInJson.getRequestPayload().getCustomerId();
		List<CustAcctType> xEnrolledAccts = new ArrayList<>();
		for (com.td.mbna.msec.midtier.types.common.CustAcctType acct : requestInJson.getRequestPayload()
				.getEnrolledAccts()) {
			com.mbnaweb.xsd.types.common.CustAcctType xAcct = JAXBJsonConverter.convertoJAXBToJsonInterface(acct,
					com.mbnaweb.xsd.types.common.CustAcctType.class);
			xEnrolledAccts.add(xAcct);
		}

		com.mbnaweb.xsd.msgs.customerprofile.GetUserInfoAndAccountsResponse xResponse = new com.mbnaweb.xsd.msgs.customerprofile.GetUserInfoAndAccountsResponse();
		com.mbnaweb.xsd.msgs.customerprofile.GetUserInfoAndAccountsResponse.ResponsePayload xResponsePL = new com.mbnaweb.xsd.msgs.customerprofile.GetUserInfoAndAccountsResponse.ResponsePayload();
		xResponse.setResponsePayload(xResponsePL);
		xResponsePL.getEnrolledAccts().addAll(xEnrolledAccts);
		xResponsePL.setCustId(logonCustId);

		// ========================================================
		List<CustAcctType> allAcctRelationship = null;
		try {
			logger.info(methodName,
					"==============================call OdsHelper.getCustAcctRelationship... ========================");
			allAcctRelationship = OdsHelper.getCustAcctRelationship(logonCustId);
		} catch (Exception e) {
			String desc = " OdsHelper.getCustAcctRelationship failed for customer :" + logonCustId;
			logger.error(methodName, desc, e);
			throw ExceptionUtil.genBusinessException(desc);
		}
		if (allAcctRelationship == null || allAcctRelationship.isEmpty()) {
			String message = "";
			throw ExceptionUtil.genBusinessException(message);
		}
		logger.info("allAcctRelationship=", allAcctRelationship.toString());

		logger.toJson("allAcctRelationship=", allAcctRelationship);

		// has enrolled accounts continue
		ParallelServiceCaller parallelCaller = new ParallelServiceCaller();

		// customer profile call
		try {
			logger.debug(methodName,
					"============================call OdsLogonHelper.scheduleLogonProfilesRetrieval...====================== ");
			OdsLogonHelper.scheduleLogonProfilesRetrieval(logonCustId, xEnrolledAccts, parallelCaller);
		} catch (Exception e) {
			String desc = " OdsLogonHelper.scheduleLogonProfilesRetrieval failed for customer :" + logonCustId;
			logger.error(methodName, desc, e);
			throw ExceptionUtil.genBusinessException(desc);
		}

		requestInJson.setCustId(logonCustId);

		com.mbnaweb.xsd.msgs.customerprofile.GetUserInfoAndAccountsRequest xRequest = JAXBJsonConverter
				.convertJsonToJAXBInterface(requestInJson,
						com.mbnaweb.xsd.msgs.customerprofile.GetUserInfoAndAccountsRequest.class);
		xRequest.setCustId(logonCustId);

		// account overviews
		GetAccountOverviewsResponse getAccountOverviewsResponse = null;
		try {
			logger.info(methodName,
					"==============================call scheduleGetAccountOverviews... ========================");
			getAccountOverviewsResponse = scheduleGetAccountOverviews(xRequest, xEnrolledAccts, allAcctRelationship,
					parallelCaller, token[0]);
		} catch (Exception e) {
			String desc = " scheduleGetAccountOverviews failed for customer :" + logonCustId;
			logger.error(methodName, desc, e);
			throw ExceptionUtil.genBusinessException(desc);
		}
		logger.toJson("scheduleGetAccountOverviews post allAcctRelationship = ", allAcctRelationship);
		// submit the web service calls to run in parallel

		/* MBNA-738 TTC link has to shown on BT banner */
		ServiceCall<TtcDestinations> getSavedTTCPayees = new ServiceCall<TtcDestinations>() {
			@Override
			public TtcDestinations invoke() throws Exception {
				// return DBMybatisService.getLatestTtcSavedPayee(customerId);
				logger.info(methodName,
						"==============================call DBService.getLatestTtcSavedPayee... ========================");
				return DBMybatisService.getLatestTtcSavedPayee(logonCustId);
				// return DBService.getLatestTtcSavedPayee(logonCustId);
			}
		};

		// ==========================================
		// kick off the DB retrieval calls with sync calls

		// getSavedTTCPayees
		try {
			logger.info(methodName,
					"==============================call parallelCaller.scheduleCall, getSavedTTCPayees... ========================");
			parallelCaller.scheduleCall("getSavedTTCPayees", getSavedTTCPayees);
		} catch (Exception e) {
			String desc = " getSavedTTCPayees failed in DBMybatisService for :" + logonCustId;
			logger.error(methodName, desc, e);
		}

		logger.info(methodName,
				"==============================call parallelCaller.useAsynchrousCall... ========================");

		// parallelCaller.useAsynchrousCall();
		// return to async mode

		// wait for the web service calls and DB retrieval to finish

		//
		try {
			logger.debug(methodName,
					"==============================call parallelCaller.sync... ========================");
			parallelCaller.sync();
		} catch (Exception e) {
			String desc = " parallelCaller.sync() failed for :" + logonCustId;
			logger.error(methodName, desc, e);
		}

		// =================================================================
		GetAccountOverviewsResponse enrolledAcctOverviews = null;
		logger.toJson("pre-3-allAcctRelationship", allAcctRelationship);
		try {
			logger.debug(methodName,
					"==============================call getGetCustomerAccountsResponseResult... ========================");
			enrolledAcctOverviews = getGetCustomerAccountsResponseResult(getAccountOverviewsResponse, xRequest,
					xEnrolledAccts, allAcctRelationship, parallelCaller);
		} catch (Exception e) {
			String desc = " getGetCustomerAccountsResponseResult failed for :" + logonCustId;
			logger.error(methodName, desc, e);
			throw ExceptionUtil.genBusinessException(desc);
		}
		logger.info("1-enrolledAcctOverviews" + enrolledAcctOverviews.toString());
		logger.toJson("1-enrolledAcctOverviews", enrolledAcctOverviews);
		logger.toJson("getGetCustomerAccountsResponseResult post allAcctRelationship=", allAcctRelationship);

		// retrieve the responses of the web service calls
		// 16
		OdsLogonHelper.RetrieveLogonInfoResponse rc = null;
		try {
			logger.info(methodName,
					"==============================call OdsLogonHelper.getLogonProfilesRetrievalResult... ========================");
			rc = OdsLogonHelper.logonProfilesRetrieval(logonCustId, xEnrolledAccts, parallelCaller);
		} catch (Exception e) {
			String desc = " OdsLogonHelper.getLogonProfilesRetrievalResult failed for :" + logonCustId;
			logger.error(methodName, desc, e);
		}

		CustomerProfileType xLogonCustPf = null;
		if (rc != null) {
			xLogonCustPf = rc.getLogonCustomerProfile();
		}
		List<CustAcctType> allAccts = null;
		if (xLogonCustPf != null) {
			allAccts = new ArrayList<>(xLogonCustPf.getAccounts());
		} else {
			String desc = " no profile for the login customer :" + logonCustId;
			logger.error(methodName, desc);
			throw ExceptionUtil.genBusinessException(desc);
		}
		logger.toJson("xEnrolledAccts", xEnrolledAccts);
		logger.toJson("allAcctRelationship", allAcctRelationship);
		logger.toJson(" ===============before populate affinity, allAccts===", allAccts);
		// the account in customer profile contains more information than needed in
		// response, so trim extra info
		// Affinity information has already been populated into the allAcctRelationship
		// array
		// by code triggered by scheduleGetAccountOverviews() above.
		// The affinity retrieval is done there because it issues the required TSYS call
		// whose response is required for DB retrieval of affinity info.
		// Now let's consolidate the affinity information from allAcctRelationship to
		// allAccts array.

		try {
			logger.info(methodName, "==============================call populateAffinity... ========================");
			populateAffinity(allAcctRelationship, allAccts);
		} catch (Exception e) {
			String desc = " populateAffinity failed for :" + logonCustId;
			logger.error(methodName, desc, e);
		}

		// accounts under the enrolledAccts list come from Enrollment service and
		// contain
		// limited information. Accounts under allAccts come from ODS with much more
		// information.
		// Therefore, populate the extra info from allAccts into enrolledAccts.

		try {
			logger.info(methodName,
					"==============================call populateEnrolledAcctData... ========================");
			populateEnrolledAcctData(xEnrolledAccts, allAccts);
		} catch (Exception e) {
			String desc = " populateEnrolledAcctData failed for :" + logonCustId;
			logger.error(methodName, desc, e);
		}

		List<ParallelServiceCaller> relatedUserInfoRtrs = null;
		relatedUserInfoRtrs = rc.getRelatedProfileCallers();
		logger.toJson("1-xEnrolledAccts", xEnrolledAccts);
		// logger.toJson("1-xLogonCustPf", xLogonCustPf);
		// logger.toJson("1-relatedUserInfoRtrs", relatedUserInfoRtrs);
		try {
			logger.info(methodName,
					"==============================call OdsLogonHelper.populateRelatedUserInfo... ========================");
			OdsLogonHelper.populateRelatedUserInfo(xEnrolledAccts, xLogonCustPf, relatedUserInfoRtrs);
		} catch (Exception e) {
			String desc = " OdsLogonHelper.populateRelatedUserInfo failed for :" + logonCustId;
			logger.error(methodName, desc, e);
		}
		logger.toJson("2-xEnrolledAccts", xEnrolledAccts);
		// logger.toJson("2-xLogonCustPf", xLogonCustPf);
		// logger.toJson("2-relatedUserInfoRtrs", relatedUserInfoRtrs);

		ParallelServiceCaller eligAndOfferCaller = new ParallelServiceCaller();
		if (xEnrolledAccts.size() == 1) { // only one account, no need to spawn the retrieveOffers call to a thread.
											// Call it synchronously
			logger.info(methodName,
					"==============================call eligAndOfferCaller.useSynchrousCall... ========================");
			logger.info(methodName, xEnrolledAccts.toString());
			eligAndOfferCaller.useSynchrousCall();
		}

		try {
			logger.debug(methodName,
					"==============================call scheduleRetrieveOffersForAccounts... ========================");
			scheduleRetrieveOffersForAccounts(xRequest, enrolledAcctOverviews, eligAndOfferCaller, token[0]);
		} catch (Exception e) {
			String desc = " scheduleRetrieveOffersForAccounts failed for :" + logonCustId;
			logger.error(methodName, desc, e);
		}

		// trim extra info stored in CustomerAcctType objects that need not be returned
		// logger.debug("CustomerProfileUtil.downConvert :: IN::
		// xLogonCustPf.getAccounts()= "+new
		// GsonBuilder().serializeNulls().setPrettyPrinting().create().toJson(xLogonCustPf.getAccounts()));
		allAccts = CustomerProfileUtil.downConvert(xLogonCustPf.getAccounts());
		// logger.debug("CustomerProfileUtil.downConvert::OUT allAccts= "+new
		// GsonBuilder().serializeNulls().setPrettyPrinting().create().toJson(allAccts));

		List<com.td.mbna.msec.midtier.types.common.CustAcctType> jsonAllAccts = convertCustAcctTypes(allAccts);

		// call entitlement api using card number
		try {
			logger.info(methodName,
					"==============================call ofmEligibilityUtil.scheduleCalls... ========================");
			logger.info(methodName, requestInJson.toString() + " " + jsonAllAccts.toString());
			ofmEligibilityUtil.scheduleCalls(requestInJson, jsonAllAccts, eligAndOfferCaller, token[0]);
		} catch (Exception e) {
			String message = " ofmEligibilityUtil.scheduleCalls failed for :" + logonCustId + " message : "
					+ e.getLocalizedMessage();
			logger.error(methodName, message, e);
			throw ExceptionUtil.genBusinessException(message);
		}

		// wait for eligibility and offers web service calls to finish
		try {
			logger.debug(methodName,
					"==============================call eligAndOfferCaller.sync... ========================");
			eligAndOfferCaller.sync();
		} catch (Exception e) {
			String desc = " eligAndOfferCaller.sync() failed for :" + logonCustId;
			logger.error(methodName, desc, e);
		}

		GetEntitlementFlagsResponse eligRes = null;
		try {
			logger.info(methodName,
					"==============================call ofmEligibilityUtil.getResult... ========================");
			eligRes = ofmEligibilityUtil.getResult(requestInJson, jsonAllAccts, eligAndOfferCaller, token[0]);
		} catch (Exception e) {
			String message = " ofmEligibilityUtil.getResult failed for :" + logonCustId;
			logger.error(methodName, message, e);
			throw ExceptionUtil.genBusinessException(message);
		}

		RetrieveOffersForAccountsResponse offersRes = null;
		try {
			logger.info(methodName,
					"==============================call getRetrieveOffersForAccountsResult... ========================");
			offersRes = getRetrieveOffersForAccountsResult(xEnrolledAccts, eligAndOfferCaller);
			logger.info("getRetrieveOffersForAccountsResult" + offersRes.getResponsePayload().getAccountOffers());
		} catch (Exception e) {
			String desc = " getRetrieveOffersForAccountsResult failed for :" + logonCustId;
			logger.error(methodName, desc, e);
		}

		// Find out if card service is up and running. This flag will be used to turn
		// off eligibility flags for operations that require card service.
		boolean cardServiceOk = (parallelCaller.getResponse(xEnrolledAccts.get(0).getAcctNum(), CardInfo.class) != null)
				? true
				: false;
		logger.info("cardServiceOk" + cardServiceOk);

		// populate retrieved data into response payload
		try {
			logger.info(methodName, "==============================call populatePayload... ========================");
			populatePayload(xEnrolledAccts, cardServiceOk, xLogonCustPf, enrolledAcctOverviews, eligRes, xResponsePL);
		} catch (Exception e) {
			String desc = "populatePayload failed for :" + logonCustId;
			logger.error(methodName, desc, e);
		}

		/* MBNA-738 Adding saved TTC to all the accounts object */
		// TTC
		TtcDestinations ttcSavedPayee = getSavedTTCPayees.getResponse();
		for (AcctOverviewType accountOverview : xResponsePL.getCustAccts()) {
			if (ttcSavedPayee == null) {
				break;
			}

			TtcDestinationsInfoType ttcDestinationsInfoType = new TtcDestinationsInfoType();

			ttcDestinationsInfoType.setTtcDestinationId(ttcSavedPayee.getTtcDestinationId().intValue());
			ttcDestinationsInfoType.setNickname(ttcSavedPayee.getNickname());
			int index = (ttcSavedPayee.getAccountNumber().length() <= 4) ? 0
					: ttcSavedPayee.getAccountNumber().length() - 4;
			ttcDestinationsInfoType.setAccountEnding(ttcSavedPayee.getAccountNumber().substring(index));
			accountOverview.setTtcLastSavedPayee(ttcDestinationsInfoType);

		}

		// KYC
		boolean enforceKYC = ConfigUtil.isEnforceKYC();
		logger.info("enforceKYC" + enforceKYC);
		List<CustAcctType> kycs = CustomerProfileUtil.getLogonKycList(xLogonCustPf, allAccts, xResponsePL.getCustElig(),
				enforceKYC);

		if (kycs != null) {
			xResponse.getResponsePayload().getKycAccts().addAll(kycs);
		}
		List<CustAcctType> types = CustomerProfileUtil.getCliKycList(xLogonCustPf, allAccts, xResponsePL.getCustElig());
		if (types != null) {
			xResponse.getResponsePayload().getCliAccts().addAll(types);
		}
		xResponse.getResponsePayload().getAllAccts().addAll(allAccts);

		// finnaly, convert from xsd response to return response
		com.td.mbna.msec.midtier.customerprofile.payload.getuserinfoandaccounts.GetUserInfoAndAccountsResponse response = JAXBJsonConverter
				.convertoJAXBToJsonInterface(xResponse,
						com.td.mbna.msec.midtier.customerprofile.payload.getuserinfoandaccounts.GetUserInfoAndAccountsResponse.class);

		if (response.getResponsePayload().getAccountOffers() == null) {
			List<AccountOffersType> accountOffers = new ArrayList<AccountOffersType>();
			response.getResponsePayload().setAccountOffers(accountOffers);
		}
		response.getResponsePayload().getAccountOffers().addAll(offersRes.getResponsePayload().getAccountOffers());
		logger.info("userInfoAndAccounts" + response.getResponsePayload().toString());
		return response;

	}

	private List<com.td.mbna.msec.midtier.types.common.CustAcctType> convertCustAcctTypes(List<CustAcctType> allAccts) {
		List<com.td.mbna.msec.midtier.types.common.CustAcctType> jsonAllAccts = new ArrayList<>(allAccts.size());
		for (CustAcctType jaxbT : allAccts) {
			if (jaxbT == null) {
				continue;
			}
			try {
				com.td.mbna.msec.midtier.types.common.CustAcctType jsonT = JAXBJsonConverter
						.convertoJAXBToJsonInterface(jaxbT, com.td.mbna.msec.midtier.types.common.CustAcctType.class);
				jsonAllAccts.add(jsonT);
			} catch (Exception e) {
				throw ExceptionUtil.genRuntimeException(e);
			}
		}
		return jsonAllAccts;
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
	public List<String> createAutoComment(com.td.mbna.msec.midtier.types.common.BaseRequest request,
			com.td.mbna.msec.midtier.types.common.BaseResponse response) {
		return null;
	}

	@Override
	public EmailInfo getEmailInfoBean(com.td.mbna.msec.midtier.types.common.BaseRequest request,
			com.td.mbna.msec.midtier.types.common.BaseResponse response) {
		return null;
	}

	@Override
	public MsecValidator getValidator() {
		return null;
	}
}