package com.td.mbna.msec.midtier.transfer;

import com.td.mbna.msec.midtier.eligibility.payload.getentitlementflags.GetEntitlementFlagsResponse;
import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.mbofp.MbnaOFP;
import com.td.mbna.msec.midtier.ofm.util.OfmEligibilityUtil;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.services.EmailInfoImpl;
import com.td.mbna.msec.midtier.services.IMBNAConstants;
import com.td.mbna.msec.midtier.transfer.payload.BTConfirmationType;
import com.td.mbna.msec.midtier.transfer.payload.balancetransfertocreditor.BalanceTransferToCreditorRequest;
import com.td.mbna.msec.midtier.transfer.payload.balancetransfertocreditor.BalanceTransferToCreditorResponse;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.types.common.EligIdType;
import com.td.mbna.msec.midtier.types.common.EmailNotificationInfoType;
import com.td.mbna.msec.midtier.types.common.PromotionOfferType;
import com.td.mbna.msec.midtier.types.eligibility.AcctEligType;
import com.td.mbna.msec.midtier.util.*;
import com.td.mbna.msec.midtier.util.ods.OdsHelper;
import com.td.mbna.msec.midtier.util.tsys.TsysHelper;
import com.td.mbna.msec.midtier.util.tsys.TsysRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import javax.annotation.PostConstruct;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static java.time.format.DateTimeFormatter.ISO_DATE;


@Component
public class BalanceTransferToCreditorOperation implements MsecMidtierCommonOperations<BalanceTransferToCreditorRequest, BalanceTransferToCreditorResponse>
{
	private static final String CONTENT_CD = "contentCd";
	private static final String BT_TO_CREDITOR = "bttocreditor";
	private static final String BT_FIRST_NAME = "firstName";
	private static final String BT_APP_DATE = "appDate";
	private static final String BT_PRODUCT_NAME = "productName";
	private static final String BT_LAST_FOUR_DIGIT = "cardLastFourDigit";

	@Autowired
	private ValangValidator balanceTransferToCreditorRequestValidator;

	@Autowired
	private MbnaOFP mbnaOFP;

	@Autowired
	private OfmEligibilityUtil ofmEligibilityUtil;

	private MsecValidator msecValidator;

	@PostConstruct
	private void init() {
		msecValidator = new MsecVlangValidator(balanceTransferToCreditorRequestValidator);
	}

	private static final String BALANCE_TRANSFER = "Balance Transfer";
	private static final String MONTH_DAY_YEAR = "MMM dd, yyyy";

	private static final String Property_ProcessTimeMin = "bt.process.time.min";
	private static final String Property_ProcessTimeMax = "bt.process.time.max";

	private final static BigDecimal OneHundred = new BigDecimal("100");

	private static MbnaLogger logger = new MbnaLogger(BalanceTransferToCreditorOperation.class);

	public BalanceTransferToCreditorResponse invokeService(BalanceTransferToCreditorRequest request, String... token)
	{
		String methodName ="BalanceTransferToCreditorOperation:invokeService";
		BalanceTransferToCreditorResponse response = new BalanceTransferToCreditorResponse();
		//1 validation
		if (request == null || request.getRequestPayload()==null || request.getSessionInfo() == null) {
			String desc = "BT Step 3::1 - transferToChequing SOAP service request validation failed ";
			logger.error(methodName,desc);
			throw ExceptionUtil.genBusinessException("MS601", desc);
		}

		if (request.getRequestPayload().getConfirmed() == null || !request.getRequestPayload().getConfirmed()) {
			return response;
		}

		//2 ofp disposition
		String acctNum = request.getAcctNum();
		String custId = request.getCustId();
		String offerId = request.getRequestPayload().getSelectedOffer().getOfferID();
		boolean isStandardRate = "STANDARD_RATE_BT".equals(offerId);

		if(!isStandardRate) {
			// First, we need to call updateOfferDisposition
			Map<String, Object> paramValues = new HashMap<String, Object>();
			paramValues.put("msgId1", UuidUtil.genUuid());
			paramValues.put("msgId2", UuidUtil.genUuid());
			paramValues.put("offerId", request.getRequestPayload().getSelectedOffer().getOfferID());
			paramValues.put("acctId", acctNum);
			paramValues.put("custId", custId);
			paramValues.put("roleCD", request.getRequestPayload().getRoleCD());
			paramValues.put("subProductId", request.getRequestPayload().getSelectedOffer().getSubProductId());

			this.mbnaOFP.updateOfferDisposition(paramValues, token[0]);
		}

		//Get the Card Number from RetrieveRelationships service
		Map<String, Object> retRelParams = new HashMap<String, Object>();
		retRelParams.put("arrangementNO", acctNum);

		//3 get card number from CODS
		String cardNumber = null;
		try {
			cardNumber = OdsHelper.getCreditCardNum(custId, acctNum);
		} catch (Exception e) {
			String desc = "BT Step 3::3 - CODS SOAP service: OdsHelper.getCreditCardNum(custId, acctNum) failed "+e.getMessage();
			logger.error(methodName,desc);
			throw ExceptionUtil.genBusinessException(desc);
		}

		//4 ofp bt
		Map<String, Object> params = TsysHelper.genStandardParams(TsysRequest.requestBalanceTransfer, request);

		params.put("acctId", acctNum);
		params.put("cardNum", cardNumber);
		params.put("firstName", request.getSessionInfo().getFirstName());
		params.put("lastName", request.getSessionInfo().getLastName());
		PromotionOfferType selectedOffer = request.getRequestPayload().getSelectedOffer();
		if(selectedOffer != null){
			params.put("offerId", selectedOffer.getOfferID());
			params.put("subProductId", selectedOffer.getSubProductId());
			if(selectedOffer.getBtOffer() != null){
				params.put("rate", selectedOffer.getBtOffer().getRate());
			}
		}

		if(isStandardRate){
			params.put("feeType", "FULL-FEE");
		}else{
			if(selectedOffer != null && selectedOffer.getBtOffer() != null && selectedOffer.getBtOffer().getEligibleNegotiatedType()!=null){
				params.put("feeType", selectedOffer.getBtOffer().getEligibleNegotiatedType());
			}else{
				params.put("feeType", "");
			}
		}

		List<BTConfirmationType> btConfirmationList = response.getResponsePayload().getConfirmation();
		BalanceTransferToCreditorResponse mtResCurrent = null;

		int numRequests = request.getRequestPayload().getPaymentInfo().size();
		for (int i = 0; i < numRequests; i++) {

			// Generate requestBalanceTransfer request
			BigDecimal transferAmt = request.getRequestPayload().getPaymentInfo().get(i).getAmount();
			params.put("amount", transferAmt);

			String payeeCradNum = request.getRequestPayload().getPaymentInfo().get(i).getPayee().getCardNum();
			params.put("payeeCardNum", payeeCradNum);

			String merchantId = request.getRequestPayload().getPaymentInfo().get(i).getPayee().getMerchantId();
			params.put("merchantId", merchantId);


			// call API for BT
			mtResCurrent = this.mbnaOFP.balanceTransferToCreditor(params, token[0]);

			BTConfirmationType btConfirmation = new BTConfirmationType();
			btConfirmation.setStatus(mtResCurrent.getResponsePayload().getConfirmation().get(0).getStatus());
			btConfirmation.setRefId(mtResCurrent.getResponsePayload().getConfirmation().get(0).getRefId());
			btConfirmation.setPaymentInfo(request.getRequestPayload().getPaymentInfo().get(i));
			btConfirmationList.add(btConfirmation);

			if(!btConfirmation.getStatus()){
				String desc = "BT Step 3::4 - one of mbnaOFP.balanceTransferToCreditor failed of payee id="+merchantId+" payye:"+request.getRequestPayload().getPaymentInfo().get(i).getPayee().getNickName();
				logger.error(methodName,desc);
				btConfirmation.setErrorCode(GENERAL_ERROR);
				response.getResponsePayload().setContainFailure(true);
			}
		}

		//5 ofm optional
		response.getResponsePayload().setMinNumOfDays(Integer.parseInt(ConfigUtil.getProperty(Property_ProcessTimeMin)));
		response.getResponsePayload().setMaxNumOfDays(Integer.parseInt(ConfigUtil.getProperty(Property_ProcessTimeMax)));
		boolean allFailed = true;
		for (BTConfirmationType aConfirmation : btConfirmationList) {
			allFailed = allFailed && !aConfirmation.getStatus();
		}

		// - at least one of the transfer were successful
		try {
			if (!allFailed) {
				GetEntitlementFlagsResponse eligResponse = ofmEligibilityUtil.getGetEntitlementFlagsResponse(request, cardNumber, acctNum, request.getIsPrimaryUser() == null ? false : request.getIsPrimaryUser().booleanValue(), OfmEligibilityUtil.DEFAULT_PRODUCT_CODES, false, token[0]);
				// Note: don't have to check whether it is a valid response. For NPE, it will set the eligibility to false.
				AcctEligType acctElig = eligResponse.getResponsePayload().getCustElig().getAcctsElig().get(0);
				response.getResponsePayload().setAllowBalanceTransfer(OfmEligibilityUtil.isAllowed(acctElig.getAcctElig(), EligIdType.BALANCE_TRANSFER));
				response.getResponsePayload().setAllowTransferToChequing(OfmEligibilityUtil.isAllowed(acctElig.getAcctElig(), EligIdType.TRANSFER_TO_CHEQUING));
			}

		}
		catch (Exception e) {
			String desc = "BT Step 3::5 - ofmEligibilityUtil.getGetEntitlementFlagsResponse after Balance Transfer is ignored. "+e.getMessage();
			logger.error(methodName,desc);
			response.getResponsePayload().setAllowBalanceTransfer(false);
			response.getResponsePayload().setAllowTransferToChequing(false);
		}

		return response;

	}

	@Override
	public boolean requiresDisclosureConsent() {
		return true;
	}

	@Override
	public String getConsentDisclosureFailedMsgCode() {
		return "MS204";
	}

	@Override
	public boolean generateAutoComment() {
		return true;
	}

	private static boolean anyTransferSucceeded(List<com.td.mbna.msec.midtier.transfer.payload.BTConfirmationType> confirmations) {
		boolean rc = false;
		for (com.td.mbna.msec.midtier.transfer.payload.BTConfirmationType confirmation : confirmations) {
			if (transferSucceeded(confirmation)) {
				rc = true;
				break;
			}
		}
		return rc;
	}

	private static boolean transferSucceeded(com.td.mbna.msec.midtier.transfer.payload.BTConfirmationType confirmation) {
		return confirmation.getStatus() != null && confirmation.getStatus() && confirmation.getRefId() != null && confirmation.getRefId().trim().length() > 0;
	}

	private static String formatCardEnding(String cardEndingDigits){
		return "****-****-****-"+cardEndingDigits;
	}

	@Override
	public List<String> createAutoComment(BaseRequest request, BaseResponse response) {
		BalanceTransferToCreditorRequest req = (BalanceTransferToCreditorRequest) request;
		com.td.mbna.msec.midtier.transfer.payload.balancetransfertocreditor.RequestPayload payload = req.getRequestPayload();
		if (payload.getConfirmed() == null || !payload.getConfirmed()) {
			return null;
		}

		List<com.td.mbna.msec.midtier.transfer.payload.BTConfirmationType> confirmations = ((BalanceTransferToCreditorResponse)response).getResponsePayload().getConfirmation();
		if (anyTransferSucceeded(confirmations) == false) { // all transfers failed;
			return null;
		}
		String header = CustomerNotesUtil.getHeaderContent(request, BALANCE_TRANSFER);
		StringBuilder strBuffer = new StringBuilder();
		strBuffer.append(header);

		com.td.mbna.msec.midtier.types.common.PromotionOfferType offer = payload.getSelectedOffer();
		SimpleDateFormat dateFormatter = new SimpleDateFormat(MONTH_DAY_YEAR);
		String offerId = offer == null ? "N/A" : (""+offer.getOfferID());
		strBuffer.append("Offer ID: ").append(offerId).append("  Product Account Number: ").append(formatCardEnding(req.getAuditInfo().getCardEnding()));

		if (offer != null){
			com.td.mbna.msec.midtier.types.common.BTOfferType bto = offer.getBtOffer();
			strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
			if (bto.getExpiryDate() != null) {
				strBuffer.append("Exp Date: ").append(dateFormatter.format(new Date(bto.getExpiryDate())));
				strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
			}
			else {
				strBuffer.append("Duration: ").append(bto.getDuration());
				strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
			}
			if (bto.getRate() != null) {
				BigDecimal decimalRate = bto.getRate().divide(OneHundred);
				NumberFormat percentFormatter = NumberFormat.getPercentInstance();
				percentFormatter.setMaximumFractionDigits(2);
				strBuffer.append("Interest Rate: ").append(percentFormatter.format(decimalRate));
			}
		}
		List<com.td.mbna.msec.midtier.transfer.payload.BalanceTransferToCreditorPaymentInfoType> payments = payload.getPaymentInfo();
		int i = 1, c = 0;
		NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
		for (com.td.mbna.msec.midtier.transfer.payload.BalanceTransferToCreditorPaymentInfoType payment : payments) {
			com.td.mbna.msec.midtier.transfer.payload.BTConfirmationType confirmation = confirmations.get(c++);
			if (transferSucceeded(confirmation) == false) continue;
			com.td.mbna.msec.midtier.transfer.payload.BalanceTransferToCreditorPayeeType payee = payment.getPayee();
			BigDecimal amount = payment.getAmount();
			strBuffer.append("  " + (i++) + ". Financial Institution: ").append(payee.getCardIssuerName());
			strBuffer.append("  Account Number: ").append(CustomerNotesUtil.maskCardNum(payee.getCardNum(), true));
			strBuffer.append("  Amount: ").append(moneyFormatter.format(amount));
			if ( offer != null){
				strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
				strBuffer.append("Fee Amount: ").append(moneyFormatter.format(FeeUtil.getBalanceTransferFee(offer, amount)));
			}
		}
		return Arrays.asList(new String[]{strBuffer.toString()});
	}

	@Override
	public EmailInfo getEmailInfoBean(BaseRequest baseRequest, BaseResponse baseResponse) {
		BalanceTransferToCreditorRequest request = (BalanceTransferToCreditorRequest)baseRequest;

		if (request.getRequestPayload().getConfirmed() == null || !request.getRequestPayload().getConfirmed() ){
			return null;
		}

		BalanceTransferToCreditorResponse response = (BalanceTransferToCreditorResponse)baseResponse;
		if (response.getResponsePayload() == null) {
			return null;
		}

		if (response.getResponsePayload().getConfirmation() == null) {
			logger.error("getEmailInfoBean", "BTToCreditor response confirmation info is NULL. No emailInfoBean returned.");
			return null;
		}

		// We need to find out whether any of the requests were successful, if none, then do not send email
		boolean hasSuccessfulRequests = false;
		for(com.td.mbna.msec.midtier.transfer.payload.BTConfirmationType btConfirmation : response.getResponsePayload().getConfirmation()) {
			if (btConfirmation.getStatus() != null && btConfirmation.getStatus()) {
				hasSuccessfulRequests = true;
				break;
			}
		}

		if (!request.getRequestPayload().getConfirmed() || !hasSuccessfulRequests) {
			return null;
		}

		EmailNotificationInfoType emailNotificationInfoType = request.getRequestPayload().getEmailNotificationInfo();
		EmailInfoImpl emailInfoBean = new EmailInfoImpl(emailNotificationInfoType, baseRequest.getSessionInfo().getLoginId(), IMBNAConstants.ALERT_TYPE_CD_BALANCETRANSFER, request.getIsPrimaryUser() == null ? false : request.getIsPrimaryUser().booleanValue());
		emailInfoBean.setConnectId(baseRequest.getSessionInfo().getConnectId());
		if (emailNotificationInfoType == null){
			return null;
		}

		emailInfoBean.setAcctNum(request.getAcctNum());

		List<String> confirmationNumList = new ArrayList<>();
		for(com.td.mbna.msec.midtier.transfer.payload.BTConfirmationType btConfirmation : response.getResponsePayload().getConfirmation()) {
			confirmationNumList.add(btConfirmation.getRefId());
		}
		emailInfoBean.setConfirmationNumbers(confirmationNumList);

		LocalDate now = LocalDate.now();
		emailInfoBean.addAttribute(CONTENT_CD, BT_TO_CREDITOR);
		emailInfoBean.addAttribute(BT_FIRST_NAME, emailNotificationInfoType.getPrimaryUserFirstName());
		emailInfoBean.addAttribute(BT_APP_DATE, ISO_DATE.format(now));
		emailInfoBean.addAttribute(BT_LAST_FOUR_DIGIT, emailNotificationInfoType.getPrimaryUserCardEnding());
		emailInfoBean.addAttribute(BT_PRODUCT_NAME, emailNotificationInfoType.getCardName());

		return emailInfoBean;
	}

	@Override
	public MsecValidator getValidator() {
		return msecValidator;
	}
}
