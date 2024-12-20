package com.td.mbna.msec.midtier.disclosure;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.stereotype.Component;

import com.mbnaweb.xsd.msgs.disclosure.GetDisclosureResponse;
import com.mbnaweb.xsd.msgs.offers.RetrieveOffersResponse;
import com.mbnaweb.xsd.types.common.PCOfferType;
import com.mbnaweb.xsd.types.common.PromotionOfferType;
import com.td.mbna.msec.midtier.disclosure.payload.getdisclosure.GetDisclosureRequest;
import com.td.mbna.msec.midtier.exceptions.BusinessException;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.types.common.DisclosureInputType;
import com.td.mbna.msec.midtier.types.common.InstallmentPlanDetails;
import com.td.mbna.msec.midtier.types.common.ProductChangeDisclosureType;
import com.td.mbna.msec.midtier.util.BackEndSrvcUtil;
import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.JaxbUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.UuidUtil;
import com.td.mbna.msec.midtier.util.services.JAXBJsonConverter;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;

@Component
public class GetDisclosureOperation implements MsecMidtierCommonOperations<GetDisclosureRequest, com.td.mbna.msec.midtier.disclosure.payload.getdisclosure.GetDisclosureResponse> {
	
	private static MbnaLogger logger = new MbnaLogger(GetDisclosureOperation.class);
	private static int disclosureMinimumLength = 0;
	private final static int DEFAULT_DISCLOSURE_MINIMUM = 10;
	public final static String OFFER_CONTRACT_ID = "STANDARD_RATE_BT";

	/** Name of the request template for assembling the disclosure */
	private final static String ASSEMBLE_DISCLOSURE = "assembleDisclosure";
	/** Name of the response template for assembling the disclosure */
	private final static String ASSEMBLE_DISCLOSURE_FOR_DISCLOSURE = "assembleDisclosure_getDisclosure";
	/** Name of the credit limit response used for assembling the disclosure */
	private final static String ASSEMBLE_DISCLOSURE_CLD_CLI = "assembleDisclosure_creditlimit";
	/** Name of the EAA response used for assembling the disclosure */
	private final static String ASSEMBLE_DISCLOSURE_EAA = "assembleDisclosure_eaa";
	/** Name of the TTC response used for assembling the disclosure */
	private final static String ASSEMBLE_DISCLOSURE_TTC = "assembleDisclosure_transfer";
	/** Name of the BT response used for assembling the disclosure */
	private final static String ASSEMBLE_DISCLOSURE_BT = "assembleDisclosure_balance";
	/**
	 * Name of the TD request template for retrieving offers
	 * getAppliedSubproducts
	 */
	private final static String GET_APPLIED_SUBPRODUCTS = "retrieveOffersAppliedSubproducts";

	private static Map<Integer, String> frenchCharsReplaceMap;

	private static final String GENERAL_ERROR = "MS601";

	private final static String AU_FEE_DISCLOSURE = "AUT1";
	private final static String IP_MPPD_DISCLOSURE = "MPPD";
	private final static String DOCUMENT_TYPE_CD = "Disclosure";
	private final static String PARTY_TYPE_CD = "Customer";
	private final static String VARIANT = "legal";
	private final static String AGREEMENT_TYPE_CD = "Account";
	private final static String AGREEMENT_SOURCE = "source";
	private final static String IP_PROMOTION_PLAN = "PaymentPlan";
	private final static String IP_ADJUDICATION_METHOD = "PRE-APPROVED";



	/**
	 * **This method is called only for Balance tranfer,TTC and product change
	 * disclosure requests only. **If the disclosure type is product change
	 * offers:getSubProductType call is made to retrieve sub products.
	 * 
	 * @throws Exception
	 * */
	private static String prepareMetaData(String documentTypeCD,
										  DisclosureInputType disclosureInput, String acctNum,
										  String languageId) throws Exception {
		
		String methodName = "prepareMetaData";
		logger.debug(methodName, "Entering...");
		
		// logging added in scope of MBNA-7751. Remove once real handling
		// of the province is in place!
		StringBuilder provinceElement = new StringBuilder("");
		if (disclosureInput.getCustomerPhysicalProvince() != null) {
			provinceElement.append("<Province><AdminAreaCd>");
			provinceElement.append(disclosureInput.getCustomerPhysicalProvince());
			provinceElement.append("</AdminAreaCd></Province>");
		}
		logger.debug(String.format(
				"Disclosure request for offer %s came for province %s",
				disclosureInput.getOfferId(),
				disclosureInput.getCustomerPhysicalProvince()));
		
		DecimalFormat df = new DecimalFormat("#0.00");
		StringBuilder metaData = new StringBuilder(
				"<DocumentRq  xmlns=\"http://schemas.td.com/tdct/srm/disclosuresandlettersapplication/disclosure/v1\"><DocumentTypeCd>Disclosure</DocumentTypeCd><Party><PartyTypeCd>Customer</PartyTypeCd>");

		// Creating disclosure request for BT/TTC pages
		if (disclosureInput.getProductChangeVariables() == null) {

			boolean feeExist = true;
			if (disclosureInput.getFixedFee() != null
					&& disclosureInput.getFixedFee().compareTo(BigDecimal.ZERO) == 0) {
				feeExist = false;
			}

			metaData.append("<Agreement><AgreementTypeCd>Account</AgreementTypeCd><AgreementFeature><AgreementFeatureTypeCd>AcctFee</AgreementFeatureTypeCd>");
			if (feeExist) {
				// If there is fixed fee, only send the fixed fee.
				if (disclosureInput.getFixedFee() != null) {
					metaData.append("<AgreementFeatureMetric>");
					metaData.append(addTag("AgreementFeatureMetricCd",
							"BalanceTransferFixedAmtFee"));
					metaData.append(addTag("AgreementFeatureMetricAmt",
							df.format(disclosureInput.getFixedFee())));
					metaData.append("</AgreementFeatureMetric>");
				} else {
					if (disclosureInput.getTransactionFeeRate() != null) {
						metaData.append("<AgreementFeatureMetric>");
						metaData.append(addTag("AgreementFeatureMetricCd",
								"BalanceTransferPercentageFee"));
						metaData.append(addTag("AgreementFeatureMetricRate",
								df.format(disclosureInput
										.getTransactionFeeRate())));
						metaData.append("</AgreementFeatureMetric>");
					}
					if (disclosureInput.getMinimumFee() != null) {
						metaData.append("<AgreementFeatureMetric>");
						metaData.append(addTag("AgreementFeatureMetricCd",
								"BalanceTransferMinimumAmtFee"));
						metaData.append(addTag("AgreementFeatureMetricAmt",
								df.format(disclosureInput.getMinimumFee())));
						metaData.append("</AgreementFeatureMetric>");
					}
					if (disclosureInput.getMaximumFee() != null) {
						metaData.append("<AgreementFeatureMetric>");
						metaData.append(addTag("AgreementFeatureMetricCd",
								"BalanceTransferMaximumAmtFee"));
						metaData.append(addTag("AgreementFeatureMetricAmt",
								df.format(disclosureInput.getMaximumFee())));
						metaData.append("</AgreementFeatureMetric>");
					}
				}
			}
			metaData.append("</AgreementFeature></Agreement>"+ provinceElement.toString() + "<PromotionOffer><PromotionTypeCd>BalXferAccChqDep</PromotionTypeCd>");
			
			if (disclosureInput.getOfferId()
					.equalsIgnoreCase(OFFER_CONTRACT_ID)) {
				metaData.append(addTag("AnnualInterestRate",
						df.format(disclosureInput.getInterestRate())));
			} else {
				metaData.append(addTag("AnnualInterestRate",
						df.format(disclosureInput.getInterestRate())));
				metaData.append(addTag("PromotionFeatureAnnualInterestRate",
						df.format(disclosureInput.getPromoInterestRate())));
				if (disclosureInput.getTransactionEndDate() != null) {
					Date endDate = new Date(disclosureInput.getTransactionEndDate());
					if (disclosureInput.getIsEarlyExpired() != null && disclosureInput.getIsEarlyExpired()) {
						DateFormat dateF = new SimpleDateFormat("yyyy-MM-dd");
						synchronized (dateF) {
							metaData.append(addTag(
									"PromotionFeatureEarlyExpiryDt",
									dateF.format(endDate)));
						}
					} else {
						DateFormat dateTimeF = new SimpleDateFormat(
								"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
						synchronized (dateTimeF) {
							metaData.append(addTag("PromotionFeatureEndDt",
									dateTimeF.format(endDate)));
						}
					}
				} else if (disclosureInput.getDuration() != null
						&& disclosureInput.getDuration().intValue() > 0) {
					metaData.append(addTag("PromotionFeatureDurationNum",
							disclosureInput.getDuration().toString()));
				}
			}
			metaData.append("</PromotionOffer></Party></DocumentRq>");
		} else {
			// Disclosure request for product change. getAppliedSubProducts
			// service call to Offers is made to retrieve more parameters.
			List<PromotionOfferType> offers = getOffersAppliedSubProducts(acctNum);

			ProductChangeDisclosureType productChangeDisclosureVar = disclosureInput
					.getProductChangeVariables();
			/**
			 * Construct the metaDataString based on the parameters of getOffers
			 * and getAppliedSubProducts
			 **/
			// constructing disclosure source tags
			metaData.append("<Agreement><AgreementTypeCd>Account</AgreementTypeCd><GroupingCode>source</GroupingCode>");
			metaData.append("<Product>");
			metaData.append(addTag("BranchId",
					productChangeDisclosureVar.getBranchIdentifierSrc()));
			metaData.append(addTag("ClientProductCode",
					productChangeDisclosureVar.getClientProductCodeSrc()));

			metaData.append(addTag("ProductName",
					replaceTrademarkSymbols(productChangeDisclosureVar
							.getProductNameSrc())));
			metaData.append(addTag("TSYSProductCode",
					productChangeDisclosureVar.getTsysProductCodeSrc()));
			metaData.append("</Product></Agreement>");

			// constructing disclosure target values
			metaData.append("<Agreement><AgreementTypeCd>Account</AgreementTypeCd>");

			metaData.append("<AgreementFee>");
			metaData.append(addFeeTag("AccessChequeDepFixedAmtFee",
					productChangeDisclosureVar
							.getFixedAccessChequeDepositAccountFee2()));
			metaData.append(addFeeTag("AccessChequeDepMaximumAmtFee",
					productChangeDisclosureVar
							.getMaximumAccessChequeDepositAccountFee2()));
			metaData.append(addFeeTag("AccessChequeDepMinimumAmtFee",
					productChangeDisclosureVar
							.getMinimumAccessChequeDepositAccountFee2()));
			metaData.append(addFeeTag("AccessChequeDepPercentageFee",
					productChangeDisclosureVar
							.getAccessChequeDepositAccountFee2()));
			metaData.append(addFeeTag("AnnualFee",
					productChangeDisclosureVar.getAccountAnnualFee2()));
			metaData.append(addFeeTag("ATMFixedAmtFee",
					productChangeDisclosureVar.getFixedATMAccountFee2()));
			metaData.append(addFeeTag("ATMMaximumAmtFee",
					productChangeDisclosureVar.getMaximumAtmAccountfee2()));
			metaData.append(addFeeTag("ATMMinimumAmtFee",
					productChangeDisclosureVar.getMinimumATMAccountFee2()));
			metaData.append(addFeeTag("ATMPercentageFee",
					productChangeDisclosureVar.getAtmAccountFee2()));
			metaData.append(addFeeTag("BalanceTransferFixedAmtFee",
					productChangeDisclosureVar
							.getFixedBalanceTransferAccountFee2()));
			metaData.append(addFeeTag("BalanceTransferMaximumAmtFee",
					productChangeDisclosureVar
							.getMaximumBalanceTransferAccountFee2()));
			metaData.append(addFeeTag("BalanceTransferMinimumAmtFee",
					productChangeDisclosureVar
							.getMinimumBalanceTransferAccountFee2()));
			metaData.append(addFeeTag("BalanceTransferPercentageFee",
					productChangeDisclosureVar.getBalanceTransferAccountfee2()));
			metaData.append(addFeeTag("CashEquivalentFixedFee",
					productChangeDisclosureVar
							.getFixedCashEquivalentAccountFee2()));
			metaData.append(addFeeTag("CashEquivalentMaximumFee",
					productChangeDisclosureVar
							.getMaximumCashEquivalentAccountFee2()));
			metaData.append(addFeeTag("CashEquivalentMinimumFee",
					productChangeDisclosureVar
							.getMinimumCashEquivalentAccountFee2()));
			metaData.append(addFeeTag("CashEquivalentPercentageFee",
					productChangeDisclosureVar.getCashEquivalentAccountFee2()));
			metaData.append(addFeeTag("InactiveCreditBalFee",
					productChangeDisclosureVar.getInactiveCreditBalanceFee2()));
			metaData.append(addFeeTag("OTCFixedAmtFee",
					productChangeDisclosureVar.getFixedOTCaccountFee2()));
			metaData.append(addFeeTag("OTCMaximumAmtFee",
					productChangeDisclosureVar.getMaximumOTCAccountFee2()));
			metaData.append(addFeeTag("OTCMinimumAmtFee",
					productChangeDisclosureVar.getMinimumOTCAccountFee2()));
			metaData.append(addFeeTag("OTCPercentageFee",
					productChangeDisclosureVar.getOtcAccountFee2()));
			metaData.append(addFeeTag("OverCreditLimitFee",
					productChangeDisclosureVar.getOverCreditLimitFee2()));
			metaData.append(addFeeTag("ReturnedAccessChequeFee",
					productChangeDisclosureVar.getReturnedAccessChequeFee2()));
			metaData.append(addFeeTag("ReturnedPaymentFee",
					productChangeDisclosureVar.getReturnedPaymentFee2()));
			metaData.append("</AgreementFee>");

			metaData.append(addTag(
					"BillingCycleInactiveNum",
					new Integer(productChangeDisclosureVar
							.getNumberOfBillingcyclestoInactive()).toString()));
			metaData.append(addTag("DefaultRatePercentChangeType",
					productChangeDisclosureVar
							.getDefaultRatePercentChangeType()));
			metaData.append("<GroupingCode>target</GroupingCode>");
			metaData.append(addFeeTag("MinimumPaymentRate",
					productChangeDisclosureVar.getMinimumPaymentPercent()));
			metaData.append(addTag("PointsProgram",
					replaceTrademarkSymbols(productChangeDisclosureVar
							.getPointsProgramName())));

			metaData.append("<Product>");
			metaData.append(addTag("BranchId",
					productChangeDisclosureVar.getBranchIdentifier2()));
			metaData.append(addTag("ClientProductCode",
					productChangeDisclosureVar.getClientProductCode2()));
			// sending product name based on language pref
			if ("en".equals(languageId)) {
				metaData.append(addTag("ProductName",
						replaceTrademarkSymbols(productChangeDisclosureVar
								.getProductNameEn())));
			} else {
				metaData.append(addTag("ProductName",
						replaceTrademarkSymbols(productChangeDisclosureVar
								.getProductNameFr())));
			}

			metaData.append(addTag("TSYSProductCode",
					productChangeDisclosureVar.getTsysProductCode2()));
			metaData.append("</Product>");

			metaData.append("<Statement>");
			metaData.append(addFeeTag("MinPayAmt",
					productChangeDisclosureVar.getMinimumPaymentDue2()));
			metaData.append("<StatementTypeCd>Statement</StatementTypeCd><StatementMetric><StatementMetricTypeCd>MinPayAmt</StatementMetricTypeCd>");
			metaData.append(addFeeTag("StatementMetricAmt",
					productChangeDisclosureVar.getMinimumPaymentDue2()));
			metaData.append("</StatementMetric></Statement>");

			metaData.append("</Agreement>");
			metaData.append(provinceElement.toString());
			
			// ---------------------

			boolean btFlag = false;
			for (PromotionOfferType subProduct : offers) {
				PCOfferType pcOfferType = subProduct.getPcOffer();
				if (subProduct.getSubProductType().equals("BALANCE-TRANSFER")) {
					btFlag = true;
					metaData.append("<PromotionOffer>");
					metaData.append(addTag("PromotionTypeCd",
							"BalXferAccChqDep"));
					metaData.append(addFeeTag("AnnualInterestRate",
							productChangeDisclosureVar
									.getBalXferAccessChqDepAIR()));
					metaData.append(addTag(
							"BalanceTransferAmtInd",
							new Boolean(pcOfferType
									.isBalanceTransferAmountIndicator())
									.toString()));
					metaData.append(addTag("OfferContext",
							subProduct.getOfferType()));
					metaData.append(addFeeTag(
							"PromotionFeatureAnnualInterestRate",
							pcOfferType.getBalXferAccessChqDepPromoAIR()));
					if (pcOfferType.getBalXferAccessChqDepPromoDuration() > 0) {
						metaData.append(addTag(
								"PromotionFeatureDurationNum",
								new Integer(pcOfferType
										.getBalXferAccessChqDepPromoDuration())
										.toString()));
					}
					DateFormat dateF = new SimpleDateFormat(
							"yyyy-MM-dd'T'HH:mm:ss.SSS");
					if (pcOfferType.getBalXferAccessChqDepPromoEndDate() != null) {
						synchronized (dateF) {
							metaData.append(addTag(
									"PromotionFeatureEndDt",
									dateF.format(pcOfferType
											.getBalXferAccessChqDepPromoEndDate()
											.toGregorianCalendar().getTime())));
						}
					}
					metaData.append(addTag("PromotionOfferId",
							subProduct.getOfferID()));
					metaData.append(addTag(
							"RateForLifeInd",
							new Boolean(
									pcOfferType
											.isBalancetransferpromoRateForLifeindicator())
									.toString()));
					if (pcOfferType.getBalXferAccessChqDepTOWDuration() > 0) {
						metaData.append(addTag(
								"TransactionDurationNum",
								new Integer(pcOfferType
										.getBalXferAccessChqDepTOWDuration())
										.toString()));
						metaData.append(addTag(
								"TransactionDurationTypeCd",
								pcOfferType
										.getBalXferAccessChqDepTOWDurationTypeCode()));
					}
					metaData.append("</PromotionOffer>");
				}
			}

			if (!btFlag) {
				metaData.append("<PromotionOffer>");
				metaData.append(addTag("PromotionTypeCd", "BalXferAccChqDep"));
				metaData.append(addFeeTag("AnnualInterestRate",
						productChangeDisclosureVar.getBalXferAccessChqDepAIR()));
				metaData.append("</PromotionOffer>");
			}

			boolean puchaseFlag = false;
			for (PromotionOfferType subProduct : offers) {
				PCOfferType pcOfferType = subProduct.getPcOffer();
				if (subProduct.getSubProductType().equals("RETAIL")) {
					puchaseFlag = true;
					metaData.append("<PromotionOffer>");
					metaData.append(addTag("PromotionTypeCd", "Purchase"));
					metaData.append(addFeeTag("AnnualInterestRate",
							productChangeDisclosureVar.getPurchaseAIR()));
					metaData.append(addFeeTag(
							"PromotionFeatureAnnualInterestRate",
							pcOfferType.getPurchasePromoAIR()));
					metaData.append(addTag("PromotionOfferId",
							subProduct.getOfferID()));
					metaData.append(addTag("RateForLifeInd", new Boolean(
							pcOfferType.isPurchasePromoRateForLifeindicator())
							.toString()));
					metaData.append("</PromotionOffer>");
				}
			}
			if (!puchaseFlag) {
				metaData.append("<PromotionOffer>");
				metaData.append(addTag("PromotionTypeCd", "Purchase"));
				metaData.append(addFeeTag("AnnualInterestRate",
						productChangeDisclosureVar.getPurchaseAIR()));
				metaData.append("</PromotionOffer>");
			}

			metaData.append("<PromotionOffer>");
			metaData.append(addTag("PromotionTypeCd", "CashAdvance"));
			metaData.append(addFeeTag("AnnualInterestRate",
					productChangeDisclosureVar.getCashAdvanceAIR()));
			metaData.append("</PromotionOffer>");

			metaData.append("</Party></DocumentRq>");
		}
		return metaData.toString();
	}

	public static String addTag(String elementName, String value) {
		return "<" + elementName + ">" + value + "</" + elementName + ">";
	}

	public static String addFeeTag(String elementName, BigDecimal value) {
		if (null == value) {
			return "";
		}

		DecimalFormat df = new DecimalFormat("#0.00");
		return "<" + elementName + ">" + df.format(value) + "</" + elementName	+ ">";
	}

	private static int getMinimumLength() {
		String methodName = "getMinimumLength";
		logger.debug(methodName, "Entering...");
		
		if (disclosureMinimumLength != 0) {
			return disclosureMinimumLength;
		}
		
		try {
			String minimumLengthStr = ConfigUtil.getProperty("disclosure.minimumLength");
			if (minimumLengthStr != null){
				disclosureMinimumLength = Integer.parseInt(ConfigUtil.getProperty("disclosure.minimumLength"));
			}
		} catch (Exception ex) {
			logger.error("getMinimumLength", "Failed in getMinimumLength: ", ex);
		}
		if (disclosureMinimumLength == 0){
			disclosureMinimumLength = DEFAULT_DISCLOSURE_MINIMUM;
		}
		return disclosureMinimumLength;
	}

	/**
	 * @throws Exception
	 *             Sends request to getAppliedSubProducts of OOMS
	 */
	private static List<PromotionOfferType> getOffersAppliedSubProducts(String acctNum) throws Exception {
		
		String methodName = "getOffersAppliedSubProducts";
		logger.debug(methodName, "Entering...");
		
		List<PromotionOfferType> offers = null;

		// Retrieve relevant details from UI request and auto-generate the
		// Message ID
		JAXBContext mtJaxBContext = JaxbUtil.getJaxbContext("com.mbnaweb.xsd.msgs.offers");
		Map<String, Object> paramValues = new HashMap<String, Object>();
		paramValues.put("accountNo", acctNum);
		String[] uuidPair = UuidUtil.genUuidPair();
		paramValues.put("msgId", uuidPair[0]);
		paramValues.put("msgId2", uuidPair[1]);
		RetrieveOffersResponse mtRes = (RetrieveOffersResponse) BackEndSrvcUtil
				.invokeService(
						GET_APPLIED_SUBPRODUCTS,
						GET_APPLIED_SUBPRODUCTS,
						GET_APPLIED_SUBPRODUCTS,
						GET_APPLIED_SUBPRODUCTS,
						null,
						null,
						null,
						paramValues,
						paramValues,
						BackEndSrvcUtil.TDOperation.TdOffersService_getAppliedSubProducts,
						mtJaxBContext);

		offers = mtRes.getResponsePayload().getPromotionOffer();

		return offers;
	}

	static {

		if (frenchCharsReplaceMap == null) {
			frenchCharsReplaceMap = new HashMap<Integer, String>();
		}
		frenchCharsReplaceMap.put(192, "&#192;");
		frenchCharsReplaceMap.put(224, "&#224;");
		frenchCharsReplaceMap.put(194, "&#194;");
		frenchCharsReplaceMap.put(226, "&#226;");
		frenchCharsReplaceMap.put(198, "&#198;");
		frenchCharsReplaceMap.put(230, "&#230;");
		frenchCharsReplaceMap.put(199, "&#199;");
		frenchCharsReplaceMap.put(231, "&#231;");
		frenchCharsReplaceMap.put(201, "&#201;");
		frenchCharsReplaceMap.put(233, "&#233;");
		frenchCharsReplaceMap.put(200, "&#200;");
		frenchCharsReplaceMap.put(232, "&#232;");
		frenchCharsReplaceMap.put(202, "&#202;");
		frenchCharsReplaceMap.put(234, "&#234;");
		frenchCharsReplaceMap.put(203, "&#203;");
		frenchCharsReplaceMap.put(235, "&#235;");
		frenchCharsReplaceMap.put(206, "&#206;");
		frenchCharsReplaceMap.put(238, "&#238;");
		frenchCharsReplaceMap.put(207, "&#207;");
		frenchCharsReplaceMap.put(239, "&#239;");
		frenchCharsReplaceMap.put(212, "&#212;");
		frenchCharsReplaceMap.put(244, "&#244;");
		frenchCharsReplaceMap.put(338, "&#338;");
		frenchCharsReplaceMap.put(339, "&#339;");
		frenchCharsReplaceMap.put(217, "&#217;");
		frenchCharsReplaceMap.put(249, "&#249;");
		frenchCharsReplaceMap.put(219, "&#219;");
		frenchCharsReplaceMap.put(251, "&#251;");
		frenchCharsReplaceMap.put(220, "&#220;");
		frenchCharsReplaceMap.put(252, "&#252;");
		frenchCharsReplaceMap.put(376, "&#376;");
		frenchCharsReplaceMap.put(255, "&#255;");
	}

	/**
	 * This method replaces registered trademark,MD,MC symbols
	 * 
	 * @param input
	 * @return
	 */
	private static String replaceTrademarkSymbols(String input) {
		String methodName = "replaceTrademarkSymbols";
		logger.debug(methodName, "Entering...");
		if (input == null){
			return input;
		}

		// Code to replace French chars
		char[] words = input.toCharArray();
		StringBuilder out = new StringBuilder(input.length());

		for (int i = 0; i < words.length; i++) {
			int charIntvalue = words[i];
			if (frenchCharsReplaceMap.containsKey(charIntvalue)) {
				out.append(frenchCharsReplaceMap.get(charIntvalue));
			} else {
				out.append(words[i]);
			}
		}
		String strInput = out.toString();

		strInput = strInput.replace("\u00AE", "&#174;");
		strInput = strInput.replace("<sup>MD</sup>", "&#7481;&#7472;");
		strInput = strInput.replace("\u1D39\u1D30", "&#7481;&#7472;");
		strInput = strInput.replace("<sup>MC</sup>", "&#7481;&#7580;");
		strInput = strInput.replace("<sup>TM</sup>", "&#8482;");

		return strInput;
	}

	@Override
	public com.td.mbna.msec.midtier.disclosure.payload.getdisclosure.GetDisclosureResponse invokeService(GetDisclosureRequest request, String... token) {
		String methodName = "invokeService";
		logger.debug(methodName, "Entering...");

		try {
			String loginId = request.getSessionInfo().getLoginId();
			if(null == loginId){
				loginId = request.getSessionInfo().getConnectId();
			}

			String languageId = request.getLanguagePref();
			if (languageId == null)
				languageId = "en";
			else if (languageId.toLowerCase(Locale.CANADA).startsWith("fr"))
				languageId = "fr";
			else
				languageId = "en";
			String mimeType = "HTML";

			Map<String, Object> paramValues = new HashMap<String, Object>();
			// set languageId to en temporarily. It should be taken from the
			// request and map it to en/fr
			paramValues.put("languageID", languageId);
			paramValues.put("mimeType", mimeType);
			// documentType will be taken from a property file later.
			// each operation has its own documentType
			String documentTypeCD = request.getRequestPayload().getDisclosureType();

			paramValues.put("documentType", documentTypeCD);
			paramValues.put("documentUsage", "Template");
			// temporarily use this text as metadata
			// otherwise the text should be read from the session.
			String metadata = "";
			if (request.getRequestPayload().getDisclosureInput() != null) {

				//if AUT1
				if (request.getRequestPayload().getDisclosureType().equalsIgnoreCase(AU_FEE_DISCLOSURE)) {
					metadata = prepareMetaDataForAuFee(request.getRequestPayload().getDisclosureInput());
				}
				// if MPPD
				else if (request.getRequestPayload().getDisclosureType().equalsIgnoreCase(IP_MPPD_DISCLOSURE)) {
					metadata = prepareMetaDataForMPPD(request.getRequestPayload().getDisclosureInput());
				} else {
					metadata = prepareMetaData(documentTypeCD, request.getRequestPayload().getDisclosureInput(),request.getAcctNum(), languageId);
				}
			}

			paramValues.put("metadataContent", metadata);

			String tdResName = "";
			switch (documentTypeCD) {
			case "CLD1":
				tdResName = ASSEMBLE_DISCLOSURE_CLD_CLI;				
				break;
			case "CLI1":
				tdResName = ASSEMBLE_DISCLOSURE_CLD_CLI;				
				break;
			case "EAA1":
				tdResName = ASSEMBLE_DISCLOSURE_EAA;				
				break;
			case "EAA2":
				tdResName = ASSEMBLE_DISCLOSURE_EAA;				
				break;
			case "BCE1":
				tdResName = ASSEMBLE_DISCLOSURE_TTC;				
				break;
			case "BCE2":
				tdResName = ASSEMBLE_DISCLOSURE_TTC;				
				break;
			case "BCC1":
				tdResName = ASSEMBLE_DISCLOSURE_BT;				
				break;
			case "BCO1":
				tdResName = ASSEMBLE_DISCLOSURE_BT;				
				break;

			default:
				tdResName = ASSEMBLE_DISCLOSURE;
				break;
			}
//			if (documentTypeCD.equals("CLD1") || documentTypeCD.equals("CLI1")) {
//				tdResName = ASSEMBLE_DISCLOSURE_CLD_CLI;
//			} else if (documentTypeCD.equals("EAA1")
//					|| documentTypeCD.equals("EAA2")) {
//				tdResName = ASSEMBLE_DISCLOSURE_EAA;
//			} else if (documentTypeCD.equals("BCE1")
//					|| documentTypeCD.equals("BCE2")) {
//				tdResName = ASSEMBLE_DISCLOSURE_TTC;
//			} else if (documentTypeCD.equals("BCC1")
//					|| documentTypeCD.equals("BCO1")) {
//				tdResName = ASSEMBLE_DISCLOSURE_BT;
//			} else {
//				tdResName = ASSEMBLE_DISCLOSURE;
//			}
			JAXBContext mtJaxBContext = JaxbUtil.getJaxbContext("com.mbnaweb.xsd.msgs.disclosure");
			logger.debug(methodName, "request tdResName="+tdResName);
			GetDisclosureResponse response = (GetDisclosureResponse) BackEndSrvcUtil
					.invokeService(
							ASSEMBLE_DISCLOSURE,
							ASSEMBLE_DISCLOSURE,
							tdResName,
							ASSEMBLE_DISCLOSURE_FOR_DISCLOSURE,
							loginId,
							null,
							null,
							paramValues,
							paramValues,
							BackEndSrvcUtil.TDOperation.TdDisclosureCfgService_assembleDisclosure,
							mtJaxBContext);

			String disclosureHtml = response.getResponsePayload().getContent();
//			logger.debug(methodName, "response.getResponsePayload().getContent()="+disclosureHtml);
			if (disclosureHtml == null) {
				throw new Exception("Disclosure content is empty for "	+ documentTypeCD + " for language " + languageId);
			}
			disclosureHtml = disclosureHtml.toUpperCase(Locale.CANADA);
			if (!disclosureHtml.contains("<BODY")) {
				throw new Exception("Disclosure content does not contain <BODY> for "
								+ documentTypeCD + " for language "
								+ languageId);
			} 
			if (!disclosureHtml.contains("</BODY")) {
				throw new Exception("Disclosure content does not contain </BODY> for "
								+ documentTypeCD + " for language "
								+ languageId);
			}
			int startIndex = disclosureHtml.indexOf("<BODY");
			int actualStart = disclosureHtml.indexOf(">", startIndex);
			int endIndex = disclosureHtml.indexOf("</BODY>");
			String disclosure = response.getResponsePayload().getContent().substring(actualStart + 1, endIndex);
			
			if (disclosure.length() < getMinimumLength()) {
				logger.error(methodName, "Parsed content for " + documentTypeCD + " is empty.");
				throw new Exception("Disclosure content less than "
						+ getMinimumLength() + " for " + documentTypeCD
						+ " for language " + languageId);
			}
			
			response.getResponsePayload().setContent(disclosure);
			response.getResponsePayload().getDisclosureInfo().setDisclosureDocTypeId(documentTypeCD);
			response.getResponsePayload().getDisclosureInfo().setDisclosureLangId(languageId);
			response.getResponsePayload().getDisclosureInfo().setDisclosureMetaData(metadata);
			return JAXBJsonConverter.convertoJAXBToJsonInterface(response, com.td.mbna.msec.midtier.disclosure.payload.getdisclosure.GetDisclosureResponse.class);
		} catch (BusinessException bEx) {
			logger.error(methodName, "Disclosure Failed - SSMT006: "+ bEx.getMessage(), bEx);
			String errorCode = bEx.getFaultInfo() != null ?  bEx.getFaultInfo().getErrorCode() : GENERAL_ERROR;
			throw MidtierUtilHelper.prepareBusinessException(errorCode,"Disclosure failed - SSMT006: "+ bEx.getMessage(), bEx);
		} catch (SystemException sEx) {
			logger.error(methodName, "Disclosure failed - SSMT006: "+ sEx.getMessage(), sEx);
			String errorCode = sEx.getFaultInfo() != null ?  sEx.getFaultInfo().getErrorCode() : GENERAL_ERROR;
			throw MidtierUtilHelper.prepareBusinessException(errorCode,"Disclosure fialed - SSMT006: "+ sEx.getMessage(), sEx);
		} catch (Exception e) {
			logger.error(methodName, "Disclosure failed - SSMT006: "+ e.getMessage(), e);
			throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,"Disclosure failed - SSMT006: "+ e.getMessage(), e);
		}

	}

	private static String prepareMetaDataForAuFee(DisclosureInputType disclosureInput) {
		String methodName = "prepareMetaDataForAuFee";
		logger.debug(methodName, "Entering...");
		
		String str = "<DocumentRq xmlns= \"http://schemas.td.com/tdct/srm/disclosuresandlettersapplication/disclosure/v1\"> <DocumentTypeCd>Disclosure</DocumentTypeCd> <Party> <PartyTypeCd>Customer</PartyTypeCd> <Agreement> <AgreementTypeCd>Account</AgreementTypeCd> <AgreementFeature> <AgreementFeatureTypeCd>AcctFee</AgreementFeatureTypeCd> <AgreementFeatureMetric> <AgreementFeatureMetricCd>AdditionalCardAnnualFee</AgreementFeatureMetricCd> <AgreementFeatureMetricAmt>{auFee}</AgreementFeatureMetricAmt> </AgreementFeatureMetric><AgreementFeatureMetric> <AgreementFeatureMetricCd>AdditionalCardAnnualMaxFee</AgreementFeatureMetricCd> <AgreementFeatureMetricAmt>{MaxFee}</AgreementFeatureMetricAmt> </AgreementFeatureMetric></AgreementFeature> </Agreement> </Party> </DocumentRq>";

		if (disclosureInput.getAuFee() != null){
			str=str.replaceAll("\\{auFee\\}", String.valueOf(disclosureInput.getAuFee().floatValue()));
		} else {
			str=str.replaceAll("\\{auFee\\}", "0.0");
		}
		
		if (disclosureInput.getMaximumFee() != null){
			str=str.replaceAll("\\{MaxFee\\}", String.valueOf(disclosureInput.getMaximumFee().floatValue()));
		} else {
			str=str.replaceAll("\\{MaxFee\\}", "0.0");
		}
		logger.debug("AUT1 XML file str="+str);
		return str;
	}
	
	private static String prepareMetaDataForMPPD(DisclosureInputType disclosureInput) throws JAXBException {
		String methodName = "prepareMetaDataForMPPD";
		logger.debug(methodName, "Entering...");
		InstallmentPlanDetails ipDetails = disclosureInput.getInstallmentPlanDetails();

		com.td.mbna.msec.midtier.disclosure.xsd.metadata.ip.DocumentRq documentRq = new com.td.mbna.msec.midtier.disclosure.xsd.metadata.ip.DocumentRq();

		documentRq.setDocumentTypeCd(DOCUMENT_TYPE_CD);
		documentRq.setVariant(VARIANT);

		com.td.mbna.msec.midtier.disclosure.xsd.metadata.ip.DocumentRq.Party party = new com.td.mbna.msec.midtier.disclosure.xsd.metadata.ip.DocumentRq.Party();
		party.setPartyTypeCd(PARTY_TYPE_CD);

		com.td.mbna.msec.midtier.disclosure.xsd.metadata.ip.DocumentRq.Party.Agreement agreement = new com.td.mbna.msec.midtier.disclosure.xsd.metadata.ip.DocumentRq.Party.Agreement();
		agreement.setAgreementTypeCd(AGREEMENT_TYPE_CD);
		agreement.setGroupingCode(AGREEMENT_SOURCE);
		agreement.setMinPayOptionSetID(ipDetails.getMinPayOptionSetID());

		party.setAgreement(agreement);

		com.td.mbna.msec.midtier.disclosure.xsd.metadata.ip.DocumentRq.Party.PromotionOffer promotionOffer = new com.td.mbna.msec.midtier.disclosure.xsd.metadata.ip.DocumentRq.Party.PromotionOffer();

		promotionOffer.setPromotionTypeCd(IP_PROMOTION_PLAN);
		promotionOffer.setAdjudicationMethod(IP_ADJUDICATION_METHOD);
		promotionOffer.setPromotionFeatureStartDt(JAXBJsonConverter.convert(ipDetails.getPromotionFeatureStartDt()));
		promotionOffer.setPromotionFeatureEndDt(JAXBJsonConverter.convert(ipDetails.getPromotionFeatureEndDate()));
		promotionOffer.setPromotionFeatureEarlyExpiryDt(JAXBJsonConverter.convert(ipDetails.getPromotionFeatureEarlyExpiryDt()));

		promotionOffer.setPromotionFeatureAnnualInterestRate(ipDetails.getPromotionFeatureAnnualInterestRate());
		promotionOffer.setPromotionFeatureDurationNum(ipDetails.getPromotionFeatureDuration().shortValue());
		promotionOffer.setPromotionFeatureDurationTypeCd(ipDetails.getPromotionFeatureDurationTypeCd());

		promotionOffer.setPromotionOfferId(ipDetails.getPromotionOfferId());
		promotionOffer.setPercentageFee(ipDetails.getPercentageFee());
		promotionOffer.setFixedAmtFee(ipDetails.getFixedAmtFee());
		promotionOffer.setPurchaseAmt(ipDetails.getPurchaseAmt());

		promotionOffer.setNickName(ipDetails.getNickName());
		promotionOffer.setTotalEstimatedInterestAmt(ipDetails.getTotalEstimatedInterestAmt());
		promotionOffer.setCostofBorrowingAmt(ipDetails.getCostOfBorrowingAmt());

		promotionOffer.setMonthlyPaymentAmt(ipDetails.getMonthlyPaymentAmt());
		promotionOffer.setTotalPaymentPlanAmt(ipDetails.getTotalPaymentPlanAmt());

		party.setPromotionOffer(promotionOffer);
		documentRq.setParty(party);

		JAXBContext jaxbContext = JAXBContext.newInstance(com.td.mbna.msec.midtier.disclosure.xsd.metadata.ip.DocumentRq.class);

		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty("jaxb.fragment", true);

		StringWriter sw = new StringWriter();

		jaxbMarshaller.marshal(documentRq,sw);

		return sw.toString();

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
