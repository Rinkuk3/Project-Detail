package com.td.mbna.msec.midtier.pinmanagement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.td.api.kms.request.AddEncryptionJobRq;
import com.td.mbna.msec.midtier.mbnaad.MbnaAd;
import com.td.mbna.msec.midtier.mbnaad.request.response.RetrieveAccessCardListRs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.remoting.jaxws.JaxWsSoapFaultException;
import org.springframework.stereotype.Component;

import com.td.api.kms.request.AddDecryptionJobRq;
import com.td.api.kms.response.AddDecryptionJobRs;
import com.td.mbna.msec.midtier.pinmanagement.payload.getpin.GetPinRequest;
import com.td.mbna.msec.midtier.pinmanagement.payload.getpin.GetPinResponse;
import com.td.mbna.msec.midtier.pinmanagement.payload.getpin.ResponsePayload;
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
import com.td.mbna.msec.midtier.util.services.MSECConstants;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component("viewPinOperation")
public class ViewPinOperationImpl implements MsecMidtierCommonOperations<GetPinRequest,GetPinResponse> {

    private static MbnaLogger logger = new MbnaLogger(ViewPinOperationImpl.class);
    private static final String GENERAL_ERROR = "MS601";
    private final static String TD_RetrievePin = "RetrievePin";
    private final static String OPERATION = "View PIN";

    @Autowired
    private TDRestServiceUtil tdRestServiceUtil;

   @Autowired
    private MbnaAd mbnaAd;

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

    @Override
    public GetPinResponse invokeService(GetPinRequest request, String... token) {

        String methodName = "ViewPinOperationImpl:invokeService";
        String loginId = request.getSessionInfo().getLoginId();
//
//        com.mbnaweb.xsd.msgs.pinmanagement.GetPinResponse xResponse = null;
        
        Map<String, Object> paramValues = new HashMap<String, Object>();

        // calling MbnaAd and retriving encrypted pin
          GetPinResponse getPinResponse = mbnaAd.viewPin(request.getSessionInfo().getConnectId(), request.getCardNum(),
                  request.getRequestPayload().getPartyKey(), token[0]);
        
//        paramValues.put("msgId1", UuidUtil.genUuid());
//        paramValues.put("msgId2", UuidUtil.genUuid());
//        paramValues.put("acctNum", request.getAcctNum());
//        paramValues.put("custId", request.getAliasCustId());
//        paramValues.put("sendPINChgScript", true); // set this to true to unblock PIN
//
//        if (request.isMultiCard()) {
//        	paramValues.put("allCards",false);
//        	paramValues.put("cardNum",request.getCardNum());
//        }
//
//        logger.debug("Succesfully loaded JAXB Context. Calling Credit Card Service to retrive pin.");
//
//        // 1. Call cardService to get the PIN block from TSYS
//        JAXBContext mtJaxBContext = null;
//		try {
//			mtJaxBContext = JaxbUtil.getJaxbContext("com.mbnaweb.xsd.msgs.pinmanagement");
//		} catch (JAXBException e) {
//			String desc = "PIN ViewPin 1::0 - preparefor SOAP service call failed:"+e.getLocalizedMessage() ;
//        	logger.error(methodName, desc);
//        	throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,desc);
//		}
//
//        try {
//			xResponse = (com.mbnaweb.xsd.msgs.pinmanagement.GetPinResponse) BackEndSrvcUtil.invokeService(TD_RetrievePin, TD_RetrievePin,
//					loginId, null, null,
//					paramValues, null,
//					BackEndSrvcUtil.TDOperation.TdCardService_retrievePIN,
//					mtJaxBContext);
//		} catch (Exception e) {
//			String errorCode = GENERAL_ERROR;
//			if (e instanceof JaxWsSoapFaultException) {
//              errorCode = TDRestServiceUtil.getSoapErrorMessage("ViewPinOperationImpl::invokeService",((JaxWsSoapFaultException) e).getFault(),GENERAL_ERROR);
//          }
//			String desc = "PIN ViewPin 1::1 - CardService SOAP service call failed:"+e.getLocalizedMessage() ;
//			logger.error(methodName, desc);
//			throw MidtierUtilHelper.prepareBusinessException(errorCode,desc);
//		}
//
//
//        paramValues.clear();


        
        paramValues.put(MSECConstants.ZPK_ALIAS, request.getRequestPayload().getZpkAlias());
        paramValues.put(MSECConstants.WTK_ALIAS, request.getRequestPayload().getWtkAlias());
        paramValues.put(MSECConstants.TSYSPinBlock, getPinResponse.getResponsePayload().getEncryptedPinBlock());
        
        AddDecryptionJobRq addDecryptionJobRq = null;

        addDecryptionJobRq = RestServiceUtil.createDecryptRequest(paramValues);
        
        logger.debug(" Succesfully retrieved PIN. Calling KMS to decrypt the pin.");
        
        // 2 call rest service KMS API
        AddDecryptionJobRs addDecryptionJobRs = null;
        try {
			addDecryptionJobRs = tdRestServiceUtil.invokeRestService(BackEndSrvcUtil.TDOperation.TdKeyManagementService_decrypt, addDecryptionJobRq, AddDecryptionJobRs.class, token[0]);
		} catch (Exception e) {
			String desc = "PIN ViewPin 1::2 - KMA API call failed:"+e.getLocalizedMessage() ;
			logger.error(methodName, desc);
			throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,desc);
		}
        
        //replace TSYS PIN block with the KMS re-encrypted PIN block
        
        if (addDecryptionJobRs == null || addDecryptionJobRs.getCryptographyKey() == null || addDecryptionJobRs.getCryptographyKey().isEmpty() || addDecryptionJobRs.getData() == null) {
        	String desc = "PIN ViewPin 1::3 - Unable to decrypt the PIN from KMS" ;
        	logger.error(methodName, desc);
        	throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,desc);
        }
        
        GetPinResponse response = new GetPinResponse();        
        ResponsePayload responsePayload = new ResponsePayload();
        response.setResponsePayload(responsePayload);
        
        responsePayload.setEncryptedPinBlock(addDecryptionJobRs.getData().getPlainTxt());
        responsePayload.setKmsSingleUseKey(addDecryptionJobRs.getCryptographyKey().get(0).getKeyVal()); //single use key
        responsePayload.setKmsCDV(addDecryptionJobRs.getCryptographyKey().get(0).getCheckDigitVal());// checksum to check if single use key is valid or not
        
        return response;

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
