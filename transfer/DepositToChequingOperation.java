package com.td.mbna.msec.midtier.transfer;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.jaxws.JaxWsSoapFaultException;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import com.td.api.mbpad.response.retrievebranch.Branch;
import com.td.api.mbpad.response.retrievebranch.FinancialInstitutionName;
import com.td.api.mbpad.response.retrievebranch.RetrieveBranchResponse;
import com.td.api.mbpad.response.retrievebranch.StreetAddress;
import com.td.mbna.msec.midtier.autopay.payload.validatebankaccount.ValidateBankAccountRequest;
import com.td.mbna.msec.midtier.autopay.payload.validatebankaccount.ValidateBankAccountResponse;
import com.td.mbna.msec.midtier.eligibility.payload.getentitlementflags.GetEntitlementFlagsResponse;
import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.mbnaap.MbnaAP;
import com.td.mbna.msec.midtier.mbofp.MbnaOFP;
import com.td.mbna.msec.midtier.ofm.util.OfmEligibilityUtil;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.services.EmailInfoImpl;
import com.td.mbna.msec.midtier.services.IMBNAConstants;
import com.td.mbna.msec.midtier.transfer.payload.DepositToChequingPayeeType;
import com.td.mbna.msec.midtier.transfer.payload.DepositToChequingPaymentInfoType;
import com.td.mbna.msec.midtier.transfer.payload.deposittochequing.DepositToChequingRequest;
import com.td.mbna.msec.midtier.transfer.payload.deposittochequing.DepositToChequingResponse;
import com.td.mbna.msec.midtier.transfer.payload.deposittochequing.RequestPayload;
import com.td.mbna.msec.midtier.transfer.payload.deposittochequing.ResponsePayload;
import com.td.mbna.msec.midtier.transfer.util.TotalUtil;
import com.td.mbna.msec.midtier.types.common.BTOfferType;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.types.common.EligIdType;
import com.td.mbna.msec.midtier.types.common.EmailNotificationInfoType;
import com.td.mbna.msec.midtier.types.common.FieldErrorType;
import com.td.mbna.msec.midtier.types.common.PromotionOfferType;
import com.td.mbna.msec.midtier.types.common.ValidationException;
import com.td.mbna.msec.midtier.types.eligibility.AcctEligType;
import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.CustomerNotesUtil;
import com.td.mbna.msec.midtier.util.FeeUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.UuidUtil;
import com.td.mbna.msec.midtier.util.ods.OdsHelper;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;
import com.td.mbna.msec.midtier.util.tsys.TsysHelper;
import com.td.mbna.msec.midtier.util.tsys.TsysRequest;

import static java.time.format.DateTimeFormatter.ISO_DATE;

@Component
public class DepositToChequingOperation implements MsecMidtierCommonOperations<DepositToChequingRequest, DepositToChequingResponse> {
    private static MbnaLogger logger = new MbnaLogger(DepositToChequingOperation.class);
    private static final String GENERAL_ERROR = "MS601";
    private static final String MONTH_DAY_YEAR = "MMM dd, yyyy";
    private static final String TRANSFER_TO_CHEQUING = "Transfer to chequing";
    private static final BigDecimal OneHundred = new BigDecimal("100");

    private static final String CONTENT_CD = "contentCd";
	private static final String BT_TO_BANK = "bttobankaccount";
	private static final String BT_FIRST_NAME = "firstName";
	private static final String BT_APP_DATE = "appDate";
	private static final String BT_PRODUCT_NAME = "productName";
	private static final String BT_LAST_FOUR_DIGIT = "cardLastFourDigit";
	private static final String BT_REFERENCE_NUMBER = "referenceNumber";

    private static final String Property_ProcessTimeMin = "ttc.process.time.min";
    private static final String Property_ProcessTimeMax = "ttc.process.time.max";

    @Autowired
    private ValangValidator depositToChequingRequestValidator;

    @Autowired
    private OfmEligibilityUtil ofmEligibilityUtil;

    @Autowired
    private MbnaOFP mbnaOFP;

    @Autowired
    private MbnaAP mbnaAP;

    public DepositToChequingResponse invokeService(DepositToChequingRequest request, String... token) {
    	
    	String methodName = "DepositToChequingOperation:invokeService";
    	//	1. validate request
    	try {
			if (request.getRequestPayload().getConfirmed() == null || !request.getRequestPayload().getConfirmed()) {
				return validateDepositeToChequing(request, token[0]);
			}
		} catch (Exception e) {
			if (e instanceof ValidationException) {
				throw (ValidationException)e;
			}
			
			String errorCode = GENERAL_ERROR;
			String desc = "TTC Step 1 - transferToChequing request validation failed "+e.getLocalizedMessage();
			logger.error(methodName,desc);
			throw MidtierUtilHelper.prepareBusinessException(errorCode, desc, e);
		}
    	
    	//2. disposition
    	String custId = request.getCustId();
    	String acctNum = request.getAcctNum();
    	String offerId = request.getRequestPayload().getSelectedOffer().getOfferID();
    	boolean isStandardRate = "STANDARD_RATE_BT".equals(offerId);
    	
    	try {
			if (!isStandardRate) {
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
		} catch (Exception e) {
			String errorCode = GENERAL_ERROR;
			String desc = "TTC Step 2::2 - mbnaOFP.updateOfferDisposition failed "+e.getLocalizedMessage();
			logger.error(methodName,desc);
			throw MidtierUtilHelper.prepareBusinessException(errorCode, desc, e);
		}
    	
    	//3. get bank info
		DepositToChequingPaymentInfoType paymentInfo = request.getRequestPayload().getPaymentInfo();
    	Map<String, Object> params = TsysHelper.genStandardParams(TsysRequest.requestBalanceTransfer, request);

    	try {
	        RetrieveBranchResponse retrieveBranchResponse = mbnaAP.retrieveBranch(paymentInfo.getPayee().getBankId(), paymentInfo.getPayee().getTransitNum(), token[0]);

	        if (retrieveBranchResponse != null && retrieveBranchResponse.getBranch() != null && retrieveBranchResponse.getBranch().size() > 0) {
	        	Branch branch = retrieveBranchResponse.getBranch().get(0);
	        	String bankNameEn = "";
	        	String bankNameFr = "";
	        	for (FinancialInstitutionName financialInstitutionName : branch.getFinancialInstitutionName()) {
	        		if (financialInstitutionName != null && "EN".equalsIgnoreCase(financialInstitutionName.getLanguageCd())) {
	        			bankNameEn = financialInstitutionName.getText();
	        		}
	        		if (financialInstitutionName != null && "FR".equalsIgnoreCase(financialInstitutionName.getLanguageCd())) {
	        			bankNameFr = financialInstitutionName.getText();
	        		}
	        	}
				params.put("payeeBankName", bankNameEn);
				if (branch.getLocator() != null && branch.getLocator().getStreetAddress() != null) {
					StreetAddress streetAddress = branch.getLocator().getStreetAddress();
					params.put("addressLine1", streetAddress.getAddressLine1());
					params.put("addressLine2", "");
					params.put("city", streetAddress.getCity() == null ? " " : streetAddress.getCity());
					params.put("province", streetAddress.getTerritory() == null ? " " : streetAddress.getTerritory());
					params.put("postalCode", streetAddress.getPostalCode() == null ? " " : streetAddress.getPostalCode());
				} else {
					logger.warning("Address doesn't exist in branches response");
				}
			}
		} catch (Exception e) {
			String errorCode = GENERAL_ERROR;
			String desc ="TTC Step 3::2 - mbnaAP.retrieveBranch failed "+e.getLocalizedMessage();
			logger.error(methodName,desc);
			throw MidtierUtilHelper.prepareBusinessException(errorCode, desc, e);
		}
    	
		//4.
		// Generate requestBalanceTransfer request
		//First get the Card Number from RetrieveRelationships service
		Map<String, Object> retRelParams = new HashMap<String, Object>();
		retRelParams.put("arrangementNO", acctNum);
		
		String cardNumber;
		try {
			cardNumber = OdsHelper.getCreditCardNum(custId, acctNum);
		} catch (Exception e) {
			String errorCode  = GENERAL_ERROR;
			String desc = "";
			if (e instanceof JaxWsSoapFaultException) {
				desc = "TTC Step 4::1 - CODS TdOdsCustomerProfileService retrieveCustomerProfileViaAcctNum SOAP service failed"+e.getLocalizedMessage();
				errorCode = TDRestServiceUtil.getSoapErrorMessage(methodName,((JaxWsSoapFaultException) e).getFault(),GENERAL_ERROR);
			} else {
				desc = "TTC Step 4::2 - CODS TdOdsCustomerProfileService retrieveCustomerProfileViaAcctNum failed"+e.getLocalizedMessage();
			}
			logger.error(methodName,desc);
			throw MidtierUtilHelper.prepareBusinessException(errorCode, desc, e);
		}
		
		//5. OFP
		PromotionOfferType selectedOffer = request.getRequestPayload().getSelectedOffer();
		BigDecimal transferAmt = paymentInfo.getAmount();
		
		params.put("acctId", acctNum);
		params.put("cardNum", cardNumber);
		params.put("offerId", selectedOffer.getOfferID());
		params.put("amount", transferAmt);
		params.put("payeeName", request.getSessionInfo().getFirstName() + " " + request.getSessionInfo().getLastName());
		params.put("payeeAcctNum", paymentInfo.getPayee().getAcctNum());
		params.put("payeeBankId", paymentInfo.getPayee().getBankId());
		params.put("payeeBankTransit", paymentInfo.getPayee().getTransitNum());
		params.put("rate", selectedOffer.getBtOffer().getRate());
		params.put("subProductId", selectedOffer.getSubProductId());
		
		if (isStandardRate) {
			params.put("feeType", "FULL-FEE");
		} else {
			if (selectedOffer.getBtOffer().getEligibleNegotiatedType() != null) {
				params.put("feeType", selectedOffer.getBtOffer().getEligibleNegotiatedType());
			} else {
				params.put("feeType", "");
			}
		}
		
		DepositToChequingResponse response;
		try {
			response = this.mbnaOFP.depositToChequing(params, token[0]);
		} catch (Exception e) {
			String errorCode = GENERAL_ERROR;
			String desc= "";
			if (e instanceof JaxWsSoapFaultException) {
				desc= "TTC Step 5::1 - OFP depositToChequing failed"+e.getLocalizedMessage();
				errorCode = TDRestServiceUtil.getSoapErrorMessage(methodName,((JaxWsSoapFaultException) e).getFault(),GENERAL_ERROR);
			} else {
				desc= "TTC Step 5::2 - OFP depositToChequing failed"+e.getLocalizedMessage();
			}
			logger.error(methodName,desc);
			throw MidtierUtilHelper.prepareBusinessException(errorCode, desc, e);
		}
		
		//6. OFM getGetEntitlementFlagsResponse
		response.getResponsePayload().setTransferFee(TotalUtil.getDepositToChequingFee(request.getRequestPayload()));
		response.getResponsePayload().setTotalAmt(TotalUtil.getDepositToChequingTotal(request.getRequestPayload()));
		response.getResponsePayload().setMinNumOfDays(Integer.parseInt(ConfigUtil.getProperty(Property_ProcessTimeMin)));
		response.getResponsePayload().setMaxNumOfDays(Integer.parseInt(ConfigUtil.getProperty(Property_ProcessTimeMax)));
		
		try {
			response.getResponsePayload().setAllowBalanceTransfer(false);
			response.getResponsePayload().setAllowTransferToChequing(false);
			// Call OFM only if requestBalance() is successful.
			if (response.getResponsePayload().getStatus() != null && response.getResponsePayload().getStatus()) { //.isStatus()
				GetEntitlementFlagsResponse eligResponse = ofmEligibilityUtil.getGetEntitlementFlagsResponse(request, cardNumber, acctNum, request.getIsPrimaryUser() == null ? false : request.getIsPrimaryUser().booleanValue(), OfmEligibilityUtil.DEFAULT_PRODUCT_CODES, false, token[0]);
				// Note: don't have to check whether it is a valid response. For NPE, it will set the eligibility to false.
				AcctEligType acctElig = eligResponse.getResponsePayload().getCustElig().getAcctsElig().get(0);
				response.getResponsePayload().setAllowBalanceTransfer(OfmEligibilityUtil.isAllowed(acctElig.getAcctElig(), EligIdType.BALANCE_TRANSFER));
				response.getResponsePayload().setAllowTransferToChequing(OfmEligibilityUtil.isAllowed(acctElig.getAcctElig(), EligIdType.TRANSFER_TO_CHEQUING));
			}
			return response;
		} catch (Exception e) {
			String errorCode = GENERAL_ERROR;
			String desc = "";
			if (e instanceof JaxWsSoapFaultException) {
				desc = "TTC Step 6::1 - SOAP service failed:ofmEligibilityUtil.getGetEntitlementFlagsResponse, The following error which happened during the update of the eligibility after Balance Transfer is ignored."+e.getLocalizedMessage();
				errorCode = TDRestServiceUtil.getSoapErrorMessage(methodName,((JaxWsSoapFaultException) e).getFault(),GENERAL_ERROR);
			} else {
				desc = "TTC Step 6::2 - ofmEligibilityUtil.getGetEntitlementFlagsResponse, The following error which happened during the update of the eligibility after Balance Transfer is ignored."+e.getLocalizedMessage();
			}
			logger.error(methodName,desc);
			throw MidtierUtilHelper.prepareBusinessException(errorCode, desc, e);
		}

    }
    
    private DepositToChequingResponse validateDepositeToChequing(DepositToChequingRequest jsonRequest, String token) throws Exception{
    	ValidateBankAccountRequest validateBankAccountRequest = new ValidateBankAccountRequest();
    	String bankId = jsonRequest.getRequestPayload().getPaymentInfo().getPayee().getBankId();
    	String transitNum = jsonRequest.getRequestPayload().getPaymentInfo().getPayee().getTransitNum();
		validateBankAccountRequest.getRequestPayload().setBankNum(bankId);
		validateBankAccountRequest.getRequestPayload().setBranchNum(transitNum);
    	validateBankAccountRequest.getRequestPayload().setBankAccount(jsonRequest.getRequestPayload().getPaymentInfo().getPayee().getAcctNum());

    	ValidateBankAccountResponse validateBankAccountResponse = this.mbnaAP.validateBankAccount(validateBankAccountRequest, token);
    	
    	String methodName = "validateDepositeToChequing() ";
    	
    	if (validateBankAccountResponse == null || validateBankAccountResponse.getResponsePayload() == null || !validateBankAccountResponse.getResponsePayload().isValidAccount()) {
            FieldErrorType fieldError = new FieldErrorType();
            fieldError.setField("");

            String errCode = "MS601";
            String errMsg = "Error validating the bank information. Please try again.";
    		logger.error(methodName, errMsg);
    		
    		if (validateBankAccountResponse != null && validateBankAccountResponse.getStatus() != null){
    			if (validateBankAccountResponse.getStatus().toUpperCase().contains("ACCOUNT ")) {
    				errCode = "MS549";
    				errMsg = "Invalid number for your account. Please try again.";
    			} else if (validateBankAccountResponse.getStatus().toUpperCase().contains("ROUTING INFORMATION")) {
    				errCode = "MS172";
    				errMsg = "The combination of transit number and institution number is invalid. Please try again.";
    			}
    		}
            fieldError.setErrorCode(errCode);
            fieldError.setErrorDescription(errMsg);
            String desc = "TTC Step 1::0 - mbnaAP.validateBankAccount returned false, throwing ValidationException ";
			logger.error("DepositToChequingOperation::validateDepositeToChequing",desc);
            throw MidtierUtilHelper.prepareValidationException(fieldError.getErrorCode(), desc);
    	}

        ResponsePayload respLoad = new ResponsePayload();
        
        RetrieveBranchResponse retrieveBranchResponse = mbnaAP.retrieveBranch(bankId, transitNum, token);

        if (retrieveBranchResponse != null && retrieveBranchResponse.getBranch() != null && retrieveBranchResponse.getBranch().size() > 0) {
        	Branch branch = retrieveBranchResponse.getBranch().get(0);
        	for (FinancialInstitutionName financialInstitutionName : branch.getFinancialInstitutionName()) {
        		if (financialInstitutionName != null && "EN".equalsIgnoreCase(financialInstitutionName.getLanguageCd())) {
        			respLoad.setTransferTo(financialInstitutionName.getText());
        		}
        		if (financialInstitutionName != null && "FR".equalsIgnoreCase(financialInstitutionName.getLanguageCd())) {
        			respLoad.setTransferToFr(financialInstitutionName.getText());
        		}
        	}
        }
        
        respLoad.setTransferFee(TotalUtil.getDepositToChequingFee(jsonRequest.getRequestPayload()));
        respLoad.setTotalAmt(TotalUtil.getDepositToChequingTotal(jsonRequest.getRequestPayload()));
        DepositToChequingResponse resp = new DepositToChequingResponse();
        resp.setResponsePayload(respLoad);
        return resp;
    }

    
    @Override
    public boolean requiresDisclosureConsent() {
        return true;
    }

    @Override
    public String getConsentDisclosureFailedMsgCode() {
        return "MS179";
    }

    @Override
    public boolean generateAutoComment() {
        return true;
    }

    @Override
    public List<String> createAutoComment(BaseRequest request, BaseResponse response) {
        DepositToChequingRequest req = (DepositToChequingRequest) request;
        RequestPayload payload = req.getRequestPayload();
        if (payload.getConfirmed() == null || !payload.getConfirmed()) {
        	return null;
        }
        String header = CustomerNotesUtil.getHeaderContent(request, TRANSFER_TO_CHEQUING);
        StringBuilder strBuffer = new StringBuilder();
        strBuffer.append(header);

        NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();
        SimpleDateFormat dateFormatter = new SimpleDateFormat(MONTH_DAY_YEAR);
        PromotionOfferType offer = payload.getSelectedOffer();
        String offerId = offer == null ? "N/A" : ("" + offer.getOfferID());
        DepositToChequingPayeeType payee = payload.getPaymentInfo().getPayee();
        BigDecimal amount = payload.getPaymentInfo().getAmount();
        strBuffer.append("Offer ID: ").append(offerId).append("  Product Account Number: ").append(formatCardEnding(req.getAuditInfo().getCardEnding()));
        if (offer != null) {
            BTOfferType bto = offer.getBtOffer();
            strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
            if (bto.getExpiryDate() != null) {
                strBuffer.append("Exp Date: ").append(dateFormatter.format(new Date(bto.getExpiryDate())));
                strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
            } else {
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
        strBuffer.append("  Account Number: ").append(genAutoCommentAcctNum(payee));
        strBuffer.append("  Amount: ").append(moneyFormatter.format(amount));
        if (offer != null) {
            strBuffer.append(CustomerNotesUtil.SPACE_SEPARATOR);
            strBuffer.append("Fee Amount: ").append(moneyFormatter.format(FeeUtil.getBalanceTransferFee(offer, amount)));
        }

        return Arrays.asList(new String[]{strBuffer.toString()});
    }

    private final static String genAutoCommentAcctNum(DepositToChequingPayeeType payee) {
        StringBuilder rc = new StringBuilder();
        String bankId = payee.getBankId();
        String transitNum = payee.getTransitNum();
        String tgtAcctNum = payee.getAcctNum();
        rc.append(transitNum).append("-").append(bankId).append("-").append(tgtAcctNum);
        return rc.toString();
    }


    private static String formatCardEnding(String cardEndingDigits) {
        return "****-****-****-" + cardEndingDigits;
    }

    @Override
    public EmailInfo getEmailInfoBean(BaseRequest baseRequest, BaseResponse baseResponse) {
        DepositToChequingRequest request = (DepositToChequingRequest) baseRequest;
        DepositToChequingResponse response = (DepositToChequingResponse) baseResponse;
        if (request.getRequestPayload().getConfirmed() == null || !request.getRequestPayload().getConfirmed() || response.getResponsePayload().getStatus() == null || !response.getResponsePayload().getStatus()) {
            return null;
        }
        
        EmailNotificationInfoType emailNotificationInfoType = request.getRequestPayload().getEmailNotificationInfo();
        EmailInfoImpl emailInfoBean = new EmailInfoImpl(emailNotificationInfoType, baseRequest.getSessionInfo().getLoginId(), IMBNAConstants.ALERT_TYPE_CD_BALANCETRANSFER, request.getIsPrimaryUser() == null ? false : request.getIsPrimaryUser().booleanValue());
        emailInfoBean.setConnectId(baseRequest.getSessionInfo().getConnectId());
        if (emailNotificationInfoType == null){
        	return null;
        }
        
        emailInfoBean.setAcctNum(request.getAcctNum());

        LocalDate now = LocalDate.now();
		emailInfoBean.addAttribute(CONTENT_CD, BT_TO_BANK);
		emailInfoBean.addAttribute(BT_FIRST_NAME, emailNotificationInfoType.getPrimaryUserFirstName());
		emailInfoBean.addAttribute(BT_APP_DATE, ISO_DATE.format(now));
		emailInfoBean.addAttribute(BT_LAST_FOUR_DIGIT, emailNotificationInfoType.getPrimaryUserCardEnding());  
		emailInfoBean.addAttribute(BT_REFERENCE_NUMBER, response.getResponsePayload().getRefId());
		emailInfoBean.addAttribute(BT_PRODUCT_NAME, emailNotificationInfoType.getCardName());
		
        return emailInfoBean;
    }

    public MsecValidator getValidator() {
        return new MsecVlangValidator(depositToChequingRequestValidator);
    }

}