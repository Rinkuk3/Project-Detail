package com.td.mbna.msec.midtier.cardservice;

import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.td.mbna.msec.midtier.mbnaad.MbnaAd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.jaxws.JaxWsSoapFaultException;
import org.springframework.stereotype.Service;
import org.springmodules.validation.valang.ValangValidator;

import com.td.mbna.msec.midtier.cardservice.payload.validatecpi.ValidateCPIRequest;
import com.td.mbna.msec.midtier.cardservice.payload.validatecpi.ValidateCPIResponse;
import com.td.mbna.msec.midtier.framework.MsecVlangValidator;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.BackEndSrvcUtil;
import com.td.mbna.msec.midtier.util.JaxbUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.JAXBJsonConverter;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;
import com.td.mbna.msec.midtier.util.tsys.TsysHelper;
import com.td.mbna.msec.midtier.util.tsys.TsysRequest;

@Service
public class ValidateCPIOperation implements MsecMidtierCommonOperations<ValidateCPIRequest, ValidateCPIResponse> {

	@Autowired
	private ValangValidator validateCPIRequestValidator;

	@Autowired
	MbnaAd mbnaAd;

	private static MbnaLogger logger = new MbnaLogger(ValidateCPIOperation.class);

	// validate CPI operation name
	public static final String VALIDATE_CPI = "validateCPI";
	private static final String GENERAL_ERROR = "MS601";

	public ValidateCPIResponse invokeService(ValidateCPIRequest request, String... token)  {
		String methodName = "ValidateCPIOperation:invokeService";
		if(request == null ||  request.getRequestPayload() == null){
			String desc = "Midtier Validate CPI Step 1 - Either request or RequestPayload are empty. error code: MS276";
			logger.error(methodName,desc);
			throw MidtierUtilHelper.prepareBusinessException("MS276",desc);
		}

		if ( request.getRequestPayload().getRealExpiryMonth() == null || request.getRequestPayload().getRealExpiryMonth().isEmpty() )
		{
			if(request.getAuditInfo() != null) {
				//Change the AuditLog event code in the request to "Client fails CPI verification for activate card"
				logger.info("Changing the AuditLog event code from " + request.getAuditInfo().getTransactionCode() + " to SS0204");
				request.getAuditInfo().setTransactionCode("SS0204");
			}
			String desc = "Midtier Validate CPI Step 2 - expiry month is empty in Account (real). error code: MS276";
			logger.error(methodName,desc);
			throw MidtierUtilHelper.prepareBusinessException("MS276",desc);
		}

		if ( request.getRequestPayload().getRealExpiryYear() == null || request.getRequestPayload().getRealExpiryYear().isEmpty())
		{
			if(request.getAuditInfo() != null) {
				//Change the AuditLog event code in the request to "Client fails CPI verification for activate card"
				logger.info("Changing the AuditLog event code from " + request.getAuditInfo().getTransactionCode() + " to SS0204");
				request.getAuditInfo().setTransactionCode("SS0204");
			}
			String desc = "Midtier Validate CPI Step 3 - expiry year is empty in Account (real). error code: MS276";
			logger.error(methodName,desc);
			throw MidtierUtilHelper.prepareBusinessException("MS276",desc);
		}


		if (request.getRequestPayload().getExpiryMonth() != Integer.parseInt(request.getRequestPayload().getRealExpiryMonth()) )
		{
			if(request.getAuditInfo() != null) {
				//Change the AuditLog event code in the request to "Client fails CPI verification for activate card"
				logger.info("Changing the AuditLog event code from " + request.getAuditInfo().getTransactionCode() + " to SS0204");
				request.getAuditInfo().setTransactionCode("SS0204");
			}
			String desc = "Midtier Validate CPI Step 4 - provided expiry month doesn't match with actual values. error code: MS279:" + request.getRequestPayload().getExpiryMonth() + "," + request.getRequestPayload().getRealExpiryMonth();
			logger.error(methodName,desc);
			throw MidtierUtilHelper.prepareBusinessException("MS279",desc);

		}
		if (Integer.parseInt(request.getRequestPayload().getExpiryYear()) != Integer.parseInt(request.getRequestPayload().getRealExpiryYear()))
		{
			if(request.getAuditInfo() != null) {
				//Change the AuditLog event code in the request to "Client fails CPI verification for activate card"
				logger.info("Changing the AuditLog event code from " + request.getAuditInfo().getTransactionCode() + " to SS0204");
				request.getAuditInfo().setTransactionCode("SS0204");
			}
			String desc = "Midtier Validate CPI Step 5 - provided expiry year doesn't match with actual values. error code: MS279:" + request.getRequestPayload().getExpiryYear() + "," + request.getRequestPayload().getRealExpiryYear();
			logger.error(methodName,desc);
			throw MidtierUtilHelper.prepareBusinessException("MS279",desc);

		}
		String loginId =  null;
		if(request.getSessionInfo() != null){
			loginId = request.getSessionInfo().getLoginId();
		}
		if(loginId == null && request.getSessionInfo() != null){
			loginId = request.getSessionInfo().getConnectId();
		}
		String acctNum = request.getAcctNum();
		ValidateCPIResponse response = null;

		Map<String, Object> paramValues = TsysHelper.genStandardParams(TsysRequest.retrieveCardAccountInfo, request);
		paramValues.put(TsysHelper.TsysXslParam_accNum, acctNum);
		paramValues.put("authorizedUser", new Boolean(true));
		paramValues.put("CardCVC", request.getRequestPayload().getCvc());

		if (request.isMultiCard()) {
			paramValues.put("allCards",false);
			paramValues.put("cardNum",request.getRequestPayload().getCardNum());
		}

		logger.debug("About to call CardService:updateCardAccountInfo");

		ValidateCPIResponse xResponse = null;

        /*JAXBContext mtJaxBContext = null;
		try {
			mtJaxBContext = JaxbUtil.getJaxbContext("com.mbnaweb.xsd.msgs.card");
		} catch (JAXBException e) {
			String desc = "Midtier Validate CPI Step 7::1 - prepare SOAP service failed in CardService!"+e.getLocalizedMessage();
        	logger.error(methodName,desc);
			throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,desc);
		}

        com.mbnaweb.xsd.msgs.card.ValidateCPIResponse xResponse = null;
		try {
			xResponse = (com.mbnaweb.xsd.msgs.card.ValidateCPIResponse) BackEndSrvcUtil.invokeService(VALIDATE_CPI, VALIDATE_CPI,
					loginId, null, null,
					paramValues, null,
					BackEndSrvcUtil.TDOperation.TdCardService_updateCardAccountInfo,
					mtJaxBContext);
		} catch (Exception e) {
			String errorCode = GENERAL_ERROR;
           if (e instanceof JaxWsSoapFaultException) {
            errorCode = TDRestServiceUtil.getSoapErrorMessage("ValidateCPIOperation.invokeService",((JaxWsSoapFaultException) e).getFault(),GENERAL_ERROR);
           }
           String desc = "Midtier Validate CPI Step 7::2 - validateCPI downstream service CardService:updateCardAccountInfo has SOAP service issue.";
           logger.error(methodName,desc);
           throw MidtierUtilHelper.prepareBusinessException(errorCode, desc, e);
		}*/

		xResponse = mbnaAd.cardVerification(request.getSessionInfo().getConnectId(), request.getRequestPayload().getCardNum(), request.getRequestPayload().getCvc(), request.getRequestPayload().getRealExpiryYear(), request.getRequestPayload().getRealExpiryMonth(), token[0]);
        if (xResponse != null) {
			logger.debug(xResponse.getResponsePayload().isStatus() + "message");
			if (!xResponse.getResponsePayload().isStatus()) {
				if (request.getAuditInfo() != null) {
					//Change the AuditLog event code in the request to "Client fails CPI verification for activate card"
					logger.info("Changing the AuditLog event code from " + request.getAuditInfo().getTransactionCode() + " to SS0204");
					request.getAuditInfo().setTransactionCode("SS0204");
				}
				String desc = "Midtier Validate CPI Step 7:3 - validateCPI failed from downstream due to invalid user input data, this may caused by invliad CVC/Month/Year.";
				logger.error(methodName, desc);
				throw MidtierUtilHelper.prepareBusinessException("MS279", desc);
			}
		} else {
			logger.debug("Successfully activated the card.");
			return xResponse;
		}
		return xResponse;
//        try {
//
//
//        } catch (Exception e) {
//
//            String errorCode = "";
//            String desc = "";
//            if (e instanceof JaxWsSoapFaultException) {
//            	desc = "Midtier Validate CPI Step 7::1 - validateCPI downstream service has SOAP service issue.";
//            	logger.error("ValidateCPI",desc);
//                errorCode = TDRestServiceUtil.getSoapErrorMessage("ValidateCPIOperation.invokeService",((JaxWsSoapFaultException) e).getFault(),GENERAL_ERROR);
//
//            } else if (e instanceof BusinessException) {
//            	desc = "Midtier Validate CPI Step 7::2 - downstream Service has business exception:";
//            	logger.error("ValidateCPI: ",desc + e.getLocalizedMessage(),e);
//                errorCode = ((BusinessException) e).getFaultInfo().getErrorCode();
//            } else {
//            	desc = "Midtier Validate CPI Step 7::3 - downstream Service has exception:";
//            	logger.error("ValidateCPI: ",desc+ e.getLocalizedMessage(),e);
//                errorCode = GENERAL_ERROR;
//            }
//           throw MidtierUtilHelper.prepareBusinessException(errorCode, desc, e);
//
//        }

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
		return new MsecVlangValidator(validateCPIRequestValidator);
	}
}
