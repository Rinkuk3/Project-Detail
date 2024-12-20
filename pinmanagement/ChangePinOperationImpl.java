package com.td.mbna.msec.midtier.pinmanagement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.td.mbna.msec.midtier.mbnaad.MbnaAd;
import com.td.mbna.msec.midtier.util.services.MSECConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.jaxws.JaxWsSoapFaultException;
import org.springframework.stereotype.Component;

import com.td.api.kms.request.AddEncryptionJobRq;
import com.td.api.kms.response.AddEncryptionJobRs;
import com.td.mbna.msec.midtier.pinmanagement.payload.changepin.ChangePinRequest;
import com.td.mbna.msec.midtier.pinmanagement.payload.changepin.ChangePinResponse;
import com.td.mbna.msec.midtier.pinmanagement.util.RestServiceUtil;
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
import com.td.mbna.msec.midtier.util.services.JAXBJsonConverter;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;

@Component("changePinOperation")
public class ChangePinOperationImpl  implements MsecMidtierCommonOperations<ChangePinRequest,ChangePinResponse>   {

    private static MbnaLogger logger = new MbnaLogger(ChangePinOperationImpl.class);
    private final static String OPERATION = "Change PIN";
    private static final String GENERAL_ERROR = "MS601";
    private final static String TD_UpdatePin = "UpdatePin";

    @Autowired
    private TDRestServiceUtil tdRestServiceUtil;

    @Autowired
    private MbnaAd mbnaAd;

    @Override
    public ChangePinResponse invokeService(ChangePinRequest request, String... token) {

        String methodName = "ChangePinOperationImpl::invokeService";

        Map<String, Object> paramValues = new HashMap<String, Object>();
        
        paramValues.put("singleUseKey", request.getRequestPayload().getSingleUseKey());
        paramValues.put("cdv", request.getRequestPayload().getCdv());
        paramValues.put("zpkAlias", request.getRequestPayload().getZpkAlias());
        paramValues.put("wtkAlias", request.getRequestPayload().getWtkAlias());
        paramValues.put("pinblock", request.getRequestPayload().getEncryptedPinBlock());
        
        if (request.isMultiCard()) {
        	paramValues.put("allCards",false);
        	paramValues.put("cardNum",request.getCardNum());
        }
        
        AddEncryptionJobRq addEncryptionJobRq = RestServiceUtil.createEncryptRequest(paramValues);
        
        logger.debug("Calling KMS to encrypt PIN");
        AddEncryptionJobRs addEncryptionJobRs = null;
        try {
			addEncryptionJobRs = tdRestServiceUtil.invokeRestService(BackEndSrvcUtil.TDOperation.TdKeyManagementService_encrypt, addEncryptionJobRq, AddEncryptionJobRs.class, token[0]);
		} catch (Exception e) {
        	String desc = "PIN ChangePin 1::1 - Error in KMS API :" + BackEndSrvcUtil.TDOperation.TdKeyManagementService_encrypt+e.getLocalizedMessage();
        	logger.error(methodName,desc);
        	throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,desc);
		}
        
        //sending this the encrypted PIN to TSYS
        
        paramValues.clear();
        
        logger.debug("Calling Credit Card Service to Update PIN");


        ChangePinResponse updatePinResponse = mbnaAd.updatePin(request.getSessionInfo().getConnectId(), request.getCardNum(),
                addEncryptionJobRs.getCipherData().getCipherTxt(), request.getRequestPayload().getPartyKey(), token[0]);

        // clear view Pin response
        MSECConstants.IS_PIN_CACHE_DISABLED = true;
        
//        paramValues.put("msgId1", UuidUtil.genUuid());
//        paramValues.put("msgId2", UuidUtil.genUuid());
//        paramValues.put("acctNum", request.getAcctNum());
//        paramValues.put("custId", request.getAliasCustId());
//        paramValues.put("pin", addEncryptionJobRs.getCipherData().getCipherTxt());
//
//        if (request.isMultiCard()) {
//        	paramValues.put("allCards",false);
//        	paramValues.put("cardNum",request.getCardNum());
//        }
//
//        JAXBContext mtJaxBContext = null;
//        try {
//			mtJaxBContext = JaxbUtil.getJaxbContext("com.mbnaweb.xsd.msgs.pinmanagement");
//		} catch (JAXBException e) {
//			String desc = "PIN ChangePin 1::2 - preparefor SOAP service call failed:"+e.getLocalizedMessage() ;
//			logger.error(methodName,desc);
//			throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,desc);
//		}
        
//        String loginId = request.getSessionInfo().getLoginId();
//        com.mbnaweb.xsd.msgs.pinmanagement.ChangePinResponse xResponse = null;
////        ChangePinResponse response =  null;
//		try {
//			xResponse = (com.mbnaweb.xsd.msgs.pinmanagement.ChangePinResponse) BackEndSrvcUtil.invokeService(TD_UpdatePin, TD_UpdatePin,
//					loginId, null, null,
//					paramValues, null,
//					BackEndSrvcUtil.TDOperation.TdCardService_updatePIN,
//					mtJaxBContext);
//		} catch (Exception e) {
//
//			String errorCode = GENERAL_ERROR;
//			if (e instanceof JaxWsSoapFaultException) {
//              errorCode = TDRestServiceUtil.getSoapErrorMessage("ChangePinOperationImpl::invokeService",((JaxWsSoapFaultException) e).getFault(),GENERAL_ERROR);
//          }
//			String desc = "PIN ChangePin 1::3 - CardService SOAP service call failed:"+e.getLocalizedMessage() ;
//			logger.error(methodName,desc);
//			throw MidtierUtilHelper.prepareBusinessException(errorCode,desc);
//		}
        
        
//        return response;
        return updatePinResponse;

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
