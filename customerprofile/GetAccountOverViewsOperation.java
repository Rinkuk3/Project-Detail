package com.td.mbna.msec.midtier.customerprofile;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mbnaweb.xsd.msgs.account.GetAccountOverviewsRequest;
import com.mbnaweb.xsd.msgs.account.GetAccountOverviewsResponse;
import com.mbnaweb.xsd.types.common.AcctOverviewType;
import com.mbnaweb.xsd.types.common.BTOfferType;
import com.mbnaweb.xsd.types.common.CustAcctType;
import com.td.api.mbcca.CardInfo;
import com.td.mbna.msec.midtier.mbcca.MbnaCCA;
import com.td.mbna.msec.midtier.types.common.AcctSnapshotType;
import com.td.mbna.msec.midtier.util.AffinityInfoUtil;
import com.td.mbna.msec.midtier.util.FeeUtil;
import com.td.mbna.msec.midtier.util.ParallelServiceCaller;
import com.td.mbna.msec.midtier.util.ServiceCall;
import com.td.mbna.msec.midtier.util.services.JAXBJsonConverter;

/**
 * This class contains the actual implementation for the getCustomerAccounts operation.
 * it will invoke the following TD services:
 *  - the retrieveCreditCardAccount operation of the Credit Card Account Service
 *  - the retrieveCardAccountInfo operation of the Card Service
 */
@Component
public class GetAccountOverViewsOperation {

	final static String not_insured = "Not Insured";
	private static final String DATE_FORMAT = "yyyy-MM-dd";

	@Autowired
	private MbnaCCA mbnaCCA;

	public GetAccountOverviewsResponse scheduleCalls (final GetAccountOverviewsRequest request, ParallelServiceCaller parallelCaller, String token) throws Exception {
		
		Set<String> enrolledAcctNums = genEnrolledAcctNumSet(request.getRequestPayload().getEnrolledAccts());

		List<String> acctNums = request.getRequestPayload().getAllAccts().stream().map(CustAcctType::getAcctNum).sorted().collect(Collectors.toList());

		GetAccountOverviewsResponse getAccountOverviewsResponse = mbnaCCA.retrieveAccountsOverview(request.getSessionInfo().getConnectId(), acctNums,token);


		 for (CustAcctType acct: request.getRequestPayload().getAllAccts()) {
			if(acct == null){
				continue;
			}
			String acctNum = acct.getAcctNum();
			if(acctNum == null){
				continue;
			}
			boolean isEnrolledAcct = enrolledAcctNums.contains(acctNum);

			boolean isMultiCard = false;

			for(AcctOverviewType acctOverviewType : getAccountOverviewsResponse.getResponsePayload().getCustAccts()) {
				if(acctOverviewType == null){
					continue;
				}
				if (acctNum.equalsIgnoreCase(acctOverviewType.getAcctNum())) {
					isMultiCard = acctOverviewType.isIsMultiCard();
					break;
				}
			}

			if (isEnrolledAcct && acct.getCardHolder() != null) { // Call TdCardService.retrieveCardAccountInfo for each enrolled account

				boolean finalIsMultiCard = isMultiCard;
				ServiceCall<?> retrieveCreditCardInfoCall = new ServiceCall<CardInfo>() {

					@Override
					public CardInfo invoke()  {
						return mbnaCCA.retrieveCreditCardInfo(request.getSessionInfo().getConnectId(), finalIsMultiCard,acct.getCardNum(),acct.getCardHolder().getAliasCustomerID(),acct.getCardHolder().isPrimaryUser(),token);
					}
				};

				parallelCaller.scheduleCall(acctNum, retrieveCreditCardInfoCall);
			}

			if (isEnrolledAcct) { // call retrieveTransaction for each enrolled account

				ServiceCall<?> rtrTxnCall = new ServiceCall<AcctSnapshotType>() {
					@Override
					public AcctSnapshotType invoke()  {
						return mbnaCCA.retrieveRealTimeAuthSummary(request.getSessionInfo().getConnectId(),acctNum,token);
					}
				};
				parallelCaller.scheduleCall(acctNum, rtrTxnCall);

			}
		}

		 return getAccountOverviewsResponse;
	}

	public GetAccountOverviewsResponse getResult(GetAccountOverviewsResponse mtRes,GetAccountOverviewsRequest request, ParallelServiceCaller parallelCaller) throws Exception {

		String[] membershipFeeDesc;
		String auFee;

		CardInfo cardInfo;

		//populate affinity info
		// Set affinity info for all accounts, including non-enrolled accounts because KYC may include non-enrolled accounts
		for (final CustAcctType customerAccount : request.getRequestPayload().getAllAccts()) {
			if (customerAccount == null) {
				continue;
			}
			for (AcctOverviewType acctOverviewType : mtRes.getResponsePayload().getCustAccts()) {
				if (customerAccount.getAcctNum() == null || acctOverviewType == null) {
					continue;
				}
				if (customerAccount.getAcctNum().equalsIgnoreCase(acctOverviewType.getAcctNum())) {
					AffinityInfoUtil.setAccountAffinityRelatedInfo(customerAccount, acctOverviewType);
					break;
				}
			}
		}

		Set<String> enrolledAcctNums = genEnrolledAcctNumSet(request.getRequestPayload().getEnrolledAccts());


		ListIterator<AcctOverviewType> acctOverviewTypeListIterator = mtRes.getResponsePayload().getCustAccts().listIterator();

		AcctOverviewType customerAccount;
		while (acctOverviewTypeListIterator.hasNext()) {

			customerAccount = acctOverviewTypeListIterator.next();
			//populate details only for enrolled accounts.
			if (enrolledAcctNums != null && customerAccount != null && enrolledAcctNums.contains(customerAccount.getAcctNum())) {

				com.td.mbna.msec.midtier.types.common.BTOfferType btOfferType = FeeUtil.genBtContractOffer(customerAccount.getBtFeeLookupCode(), customerAccount.getContractRate());
				customerAccount.setBtContractOffer(JAXBJsonConverter.convertJsonToJAXBInterface(btOfferType, BTOfferType.class));

				if (StringUtils.isNotBlank(customerAccount.getMembershipFeeDesc())) {
					membershipFeeDesc = customerAccount.getMembershipFeeDesc().split("W");
					if (membershipFeeDesc.length > 1) {
						auFee = membershipFeeDesc[1].replaceAll("[^0-9.]", "");
						if (StringUtils.isNotBlank(auFee)) customerAccount.setAuFee(new BigDecimal(auFee));
					}
				}

				AcctSnapshotType acctSnapshotType = parallelCaller.getResponse(customerAccount.getAcctNum(), AcctSnapshotType.class);

				if (acctSnapshotType != null) {
					customerAccount.setTemporaryAuthorizationsToday(acctSnapshotType.getTemporaryAuthorizationsToday());

					if (acctSnapshotType.getAcctOverview() != null) {

						customerAccount.setCreditAvail(acctSnapshotType.getAcctOverview().getCreditAvail());
						customerAccount.setCashAdvanceAvail(acctSnapshotType.getAcctOverview().getCashAdvanceAvail());

						if (acctSnapshotType.getAcctOverview().getOffersParams() != null) {
							customerAccount.getOffersParams().setMoneyPadAmount(acctSnapshotType.getAcctOverview().getOffersParams().getMoneyPadAmount());
							customerAccount.getOffersParams().setCashAdvanceAvailable(acctSnapshotType.getAcctOverview().getOffersParams().getCashAdvanceAvailable());
						}
					}
				}

				cardInfo = parallelCaller.getResponse(customerAccount.getAcctNum(), CardInfo.class);
				if(cardInfo != null){
					if (customerAccount.isIsMultiCard()) {
						customerAccount.setCardActivated((cardInfo.getCard() != null && cardInfo.getCard().getReceiptVerificationInd() != null) ? cardInfo.getCard().getReceiptVerificationInd() : false);
					} else {
						customerAccount.setCardActivated((cardInfo.getCard() != null && cardInfo.getCard().getReceiptVerificationInd() != null) ? cardInfo.getCard().getReceiptVerificationInd() : true);
					}
					
					if(null != cardInfo.getCard() && null != cardInfo.getCard().getCardExpiration()){
						customerAccount.setExpirationDate(JAXBJsonConverter.convert(cardInfo.getCard().getCardExpiration().getExpirationYm(),DATE_FORMAT));
					}
					customerAccount.setSequenceNumber(cardInfo.getChipCard() != null ? new BigInteger(cardInfo.getChipCard().getSequenceNum()) : null);
				}
			} else {
				acctOverviewTypeListIterator.remove();
			}
		}

		return mtRes;

	}



	private static Set<String> genEnrolledAcctNumSet(List<CustAcctType> enrolledAccts) {
		return enrolledAccts
				.stream()
				.map(CustAcctType::getAcctNum)
				.collect(Collectors.toSet());
	}
}