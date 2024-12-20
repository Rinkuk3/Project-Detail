package com.td.mbna.msec.midtier.transfer;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.xml.ws.soap.SOAPFaultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springmodules.validation.valang.ValangValidator;

import com.td.mbna.msec.midtier.autopay.payload.validatebankaccount.ValidateBankAccountRequest;
import com.td.mbna.msec.midtier.autopay.payload.validatebankaccount.ValidateBankAccountResponse;
import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.mbnaap.MbnaAP;
import com.td.mbna.msec.midtier.persistance.entity.TtcDestinations;
//import com.td.mbna.msec.midtier.persistance.hibernate.DBService;
import com.td.mbna.msec.midtier.persistance.mybatis.DBMybatisService;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.transfer.payload.DepositToChequingPayeeType;
import com.td.mbna.msec.midtier.transfer.payload.updatedeposittochequingpayee.UpdateDepositToChequingPayeeRequest;
import com.td.mbna.msec.midtier.transfer.payload.updatedeposittochequingpayee.UpdateDepositToChequingPayeeResponse;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.types.common.FieldErrorType;
import com.td.mbna.msec.midtier.types.common.ValidationException;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;

@Component
public class UpdateDepositToChequingPayeeOperation implements MsecMidtierCommonOperations<UpdateDepositToChequingPayeeRequest, UpdateDepositToChequingPayeeResponse>
{

    @Autowired
    private MbnaAP mbnaAP;

	@Autowired
	private ValangValidator updateDepositToChequingPayeeRequestValidator;

	private MsecValidator msecValidator;
	@PostConstruct
	private void init() {
		msecValidator = new MsecVlangValidator(updateDepositToChequingPayeeRequestValidator);
	}

	private static MbnaLogger logger = new MbnaLogger(UpdateDepositToChequingPayeeOperation.class);

	@SuppressWarnings("unchecked")
	public UpdateDepositToChequingPayeeResponse invokeService(UpdateDepositToChequingPayeeRequest jsonRequest, String... token)	{
		
		UpdateDepositToChequingPayeeResponse response = new UpdateDepositToChequingPayeeResponse();
		try {
	    	DepositToChequingPayeeType payee = jsonRequest.getRequestPayload().getPayee();
	    	
	    	ValidateBankAccountRequest validateBankAccountRequest = new ValidateBankAccountRequest();
	    	String bankId = payee.getBankId();
	    	String transitNum = payee.getTransitNum();
			validateBankAccountRequest.getRequestPayload().setBankNum(bankId);
			validateBankAccountRequest.getRequestPayload().setBranchNum(transitNum);
	    	validateBankAccountRequest.getRequestPayload().setBankAccount(payee.getAcctNum());

	    	ValidateBankAccountResponse validateBankAccountResponse = this.mbnaAP.validateBankAccount(validateBankAccountRequest, token[0]);
	    	
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
	    	
	    	
	    	TtcDestinations payeeDto = new TtcDestinations();
	    	String payeeId = payee.getId();
			NumberFormat numFormat = NumberFormat.getInstance(Locale.CANADA);
	       	payeeDto.setTtcDestinationId(numFormat.parse(payeeId).intValue());
	    	payeeDto.setCustomerId(jsonRequest.getCustId());
	    	payeeDto.setNickname(payee.getNickName());
	    	payeeDto.setBankId(stripLeadingZeros(payee.getBankId()));
	    	payeeDto.setTransitNum(payee.getTransitNum());
	    	payeeDto.setAccountNumber(payee.getAcctNum());
//	    	DBService.updateTtcDestination(payeeDto);
	       	DBMybatisService.updateTtcDestination(payeeDto);
	       	return response;
		} catch (ValidationException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Exception in TTC account update: ", e.getLocalizedMessage(),e); // Unexpected exception, log stack trace
			throw MidtierUtilHelper.prepareBusinessException("MS179", "MS179", e);
		}
    }
    
    private static String stripLeadingZeros(String s) {
    	String rc = s;
    	int i = s.lastIndexOf("0");
    	if (i != -1 && i < s.length()-1) {
    		rc = s.substring(i+1);
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
		return msecValidator;
	}
}
