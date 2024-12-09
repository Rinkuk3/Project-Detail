package com.td.mbna.msec.midtier.cardservice;

import com.td.mbna.msec.midtier.cardservice.payload.activatecard.ActivateCardRequest;
import com.td.mbna.msec.midtier.util.*;
import com.td.mbna.msec.midtier.util.services.MidtierUtilHelper;
import com.td.mbna.msec.midtier.util.tsys.TsysHelper;
import com.td.mbna.msec.midtier.util.tsys.TsysRequest;
import com.td.schemas.tdct.srm.card.service.v1.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.util.JAXBResult;
import javax.xml.transform.Templates;
import javax.xml.transform.stream.StreamSource;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class CardActivationBaseOperations {

    private static MbnaLogger logger = new MbnaLogger(CardActivationBaseOperations.class);

    protected static final String GENERAL_ERROR = "MS601";

    protected ActivationUtil.LastRequestReason findLastReason(TRetrieveCardAccountInfoRs tRetrieveCardAccountInfoRs)  {
        InqCustCardInfoResponseType cardInfo =((TSvcRetrieveCardAccountInfoRs) tRetrieveCardAccountInfoRs.getAbstractBusinessSvcMsg().getValue()).getCustomerCardInfo();
        List<ICCcardInfoResponseDataType> listOfCardInfo = null;
        if (cardInfo != null) {
            listOfCardInfo = cardInfo.getCardInfo();
        }
        if (listOfCardInfo != null && listOfCardInfo.size() > 0) {
            TCardRequestReason lastRequestReason = listOfCardInfo.get(0).getCardRequestInfo().getValue().getLastRequestReason().getValue();
            return ActivationUtil.LastRequestReason.getEnum(lastRequestReason.value());
        } else {
            //this should not happen. but in case it happens.
            logger.error("findLastReason", "findLastReason faile:" + tRetrieveCardAccountInfoRs);
            throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,"LastRequestReason wasn't returned from service.");
        }
    }


    @SuppressWarnings("unchecked")
	protected TRetrieveCardAccountInfoRs retrieveCreditCardInfo(ActivateCardRequest activateCardRequest)  {

        try {

            // Generate retrieveCardAccountInfo request
            InputStream tdReqStubXml = TransformUtil.getTdRqStubXml(TsysRequest.retrieveCardAccountInfo.name());
            Templates mt2tdReqTranformer = TransformUtil.getRqTemplate(TsysRequest.retrieveCardAccountInfo.name());
            Map<String, Object> paramValues = TsysHelper.genStandardParams(TsysRequest.retrieveCardAccountInfo, activateCardRequest);
            paramValues.put(TsysHelper.TsysXslParam_cardNum, activateCardRequest.getRequestPayload().getCardNum());
            paramValues.put("authorizedUser", (activateCardRequest.getIsPrimaryUser() == null || !activateCardRequest.getIsPrimaryUser()));
            paramValues.put("customerId", activateCardRequest.getAliasCustId());
            paramValues.put("allCards", false);
            JAXBResult result0 = new JAXBResult(JaxbUtil.getJaxbContext(BackEndSrvcUtil.getTDserviceReqMsgClass(BackEndSrvcUtil.TDOperation.TdCardService_retrieveCardAccountInfo)));
            TransformUtil.transformRequest(mt2tdReqTranformer, new StreamSource(tdReqStubXml), paramValues, result0);
            IoUtil.closeIgnoreException(tdReqStubXml);
            JAXBElement<TRetrieveCardAccountInfoRq> req = (JAXBElement<TRetrieveCardAccountInfoRq>) result0.getResult();

            final TRetrieveCardAccountInfoRq req1 = req.getValue();
            return  null;
           // return TdCardService.retrieveCardAccountInfo2(req1);
        } catch (Exception e) {
            logger.error("retrieveCreditCardInfo",e.getLocalizedMessage(),e);
            throw MidtierUtilHelper.prepareBusinessException(GENERAL_ERROR,GENERAL_ERROR, e);
        }

    }

    protected boolean isCardActivated(TRetrieveCardAccountInfoRs tRetrieveCardAccountInfoRs) throws Exception {
        InqCustCardInfoResponseType cardInfo =((TSvcRetrieveCardAccountInfoRs) tRetrieveCardAccountInfoRs.getAbstractBusinessSvcMsg().getValue()).getCustomerCardInfo();
        List<ICCcardInfoResponseDataType> listOfCardInfo = null;
        if (cardInfo != null) {
            listOfCardInfo = ((TSvcRetrieveCardAccountInfoRs) tRetrieveCardAccountInfoRs.getAbstractBusinessSvcMsg().getValue()).getCustomerCardInfo().getCardInfo();
        }
        String cardActivationIndicator = null;
        ICCcardInfoResponseDataType.ReceiptVerification receiptVerification;

        if (listOfCardInfo != null && listOfCardInfo.size() > 0) {

            receiptVerification = listOfCardInfo.get(0).getReceiptVerification() != null? listOfCardInfo.get(0).getReceiptVerification().getValue(): null;

            if (receiptVerification == null || receiptVerification.getReceiptIndicated() == null) {
                logger.warning("ReceiptVerification flag wasn't returned.");
                return true;
            }
            else {
                cardActivationIndicator = receiptVerification.getReceiptIndicated().getValue();
            }

        } else {
            //this should not happen. but in case it happens.
            logger.error("isCardActivated", "ReceiptVerification flag wasn't returned." + tRetrieveCardAccountInfoRs);
            throw new Exception("Card Activation flag wasn't returned from service.");
        }

        if (cardActivationIndicator.equalsIgnoreCase("N")) return false;
        return true;
    }


}
