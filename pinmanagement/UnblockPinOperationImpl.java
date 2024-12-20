package com.td.mbna.msec.midtier.pinmanagement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.td.mbna.msec.midtier.mbnaad.MbnaAd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.jaxws.JaxWsSoapFaultException;
import org.springframework.stereotype.Component;

import com.td.mbna.msec.midtier.pinmanagement.payload.unlockpin.UnblockPinRequest;
import com.td.mbna.msec.midtier.pinmanagement.payload.unlockpin.UnblockPinResponse;
import com.td.mbna.msec.midtier.service.EmailInfo;
import com.td.mbna.msec.midtier.service.MsecMidtierCommonOperations;
import com.td.mbna.msec.midtier.service.MsecValidator;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.BackEndSrvcUtil;
import com.td.mbna.msec.midtier.util.CustomerNotesUtil;
import com.td.mbna.msec.midtier.util.JaxbUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.UuidUtil;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;

@Component("unblockPinOperation")
public class UnblockPinOperationImpl implements MsecMidtierCommonOperations<UnblockPinRequest, UnblockPinResponse> {

    private static MbnaLogger logger = new MbnaLogger(UnblockPinOperationImpl.class);

    private final static String OPERATION = "PIN unblock";
    private final static String TD_RetrievePin = "RetrievePin";
    private static final String GENERAL_ERROR = "MS601";

    @Autowired
    MbnaAd mbnaAd;

    @Override
    public UnblockPinResponse invokeService(UnblockPinRequest request, String... token) {

    	String methodName = "PinManagementService:UnblockPinOperationImpl:invokeService";
    	
    	/** Retrieve PIN **/
    	Map<String, Object> paramValues = new HashMap<String, Object>();
    	
    	paramValues.put("msgId1", UuidUtil.genUuid());
    	paramValues.put("msgId2", UuidUtil.genUuid());
    	paramValues.put("acctNum", request.getAcctNum());
    	paramValues.put("custId", request.getAliasCustId());
    	paramValues.put("sendPINChgScript", request.getRequestPayload().getSendPINChgScript()); // set this to true to unblock PIN
    	
    	if (request.isMultiCard()) {
    		paramValues.put("allCards",false);
    		paramValues.put("cardNum",request.getCardNum());
    	}
    	
    	/*logger.debug("Loading JAXB Context...");
    	
    	JAXBContext mtJaxBContext = null;
		try {
			mtJaxBContext = JaxbUtil.getJaxbContext("com.mbnaweb.xsd.msgs.pinmanagement");
		} catch (JAXBException e) {
			String desc = "PIN unblockpin 1::1 - preparefor SOAP service call failed:"+e.getLocalizedMessage() ;
			logger.error(methodName,desc);
			throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,desc);
		}*/
    	
    	logger.debug("Calling Credit Card service to Retrieve PIN to unblock it");

        UnblockPinResponse unblockPinResponse = mbnaAd.unblockPin(request.getSessionInfo().getConnectId(), request.getCardNum(), request.getRequestPayload().getPartyKey(),
                token[0], request.getRequestPayload().getSequenceNumber(), request.getRequestPayload().getSendPINChgScript());
    	
    	/*com.mbnaweb.xsd.msgs.pinmanagement.GetPinResponse xGetPinResponse = null;
    	String loginId = request.getSessionInfo().getLoginId();
		try {
			xGetPinResponse = (com.mbnaweb.xsd.msgs.pinmanagement.GetPinResponse) BackEndSrvcUtil.invokeService(TD_RetrievePin, TD_RetrievePin,
					loginId, null, null,
					paramValues, null,
					BackEndSrvcUtil.TDOperation.TdCardService_retrievePIN,
					mtJaxBContext);
		} catch (Exception e) {
			String errorCode = GENERAL_ERROR;
			if (e instanceof JaxWsSoapFaultException) {
              errorCode = TDRestServiceUtil.getSoapErrorMessage("UnblockPinOperationImpl::invokeService",((JaxWsSoapFaultException) e).getFault(),GENERAL_ERROR);
			}
			String desc = "PIN unblockpin 1::2 - CardService SOAP service call failed:"+e.getLocalizedMessage() ;
			logger.error(methodName,desc);
			throw MidtierUtilHelper.prepareBusinessException(errorCode,desc);
		}*/
    	
//    	com.mbnaweb.xsd.msgs.pinmanagement.UnblockPinResponse responseUnblock = new com.mbnaweb.xsd.msgs.pinmanagement.UnblockPinResponse();
//    	com.mbnaweb.xsd.msgs.pinmanagement.UnblockPinResponse.ResponsePayload payload = new com.mbnaweb.xsd.msgs.pinmanagement.UnblockPinResponse.ResponsePayload();
    	
    	//if the encrypted pin block isn't null and empty, that means the operation succeeded and the pin is unblocked. return true.
    	//String encryptedPinBlock = xGetPinResponse.getResponsePayload().getEncryptedPinBlock();
//    	payload.setStatus(encryptedPinBlock != null && encryptedPinBlock.length() > 0);
//    	responseUnblock.setResponsePayload(payload);
    	
//    	logger.debug("Converting JAXB Interface to new interface");
    	//convert interfaces
//    	UnblockPinResponse unblockPinResponse = JAXBJsonConverter.convertoJAXBToJsonInterface(responseUnblock,com.td.mbna.msec.midtier.pinmanagement.payload.unlockpin.UnblockPinResponse.class);
        return unblockPinResponse;

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
        return true;
    }

    @Override
    public List<String> createAutoComment(BaseRequest request, BaseResponse response) {
        List<String> commentList = Arrays.asList(new String[]{CustomerNotesUtil.getHeaderContent(request, OPERATION)});
        return commentList;
    }

    @Override
    public EmailInfo getEmailInfoBean(BaseRequest request, BaseResponse response) {
        return null;
    }

    @Override
    public MsecValidator getValidator() {
        return null;
    }

//    private static String getSoapErrorMessage (String methodName, SOAPFault soapFault) {
//        String errorMessage = GENERAL_ERROR;
//        try {
//            errorMessage = (String) soapFault.getDetail().getFirstChild().getTextContent();
//        }
//        catch (Exception e) {
//            logger.error(methodName,"Unable to retrieve the error code from soap fault exception",e);
//        }
//        return errorMessage;
//    }
}
