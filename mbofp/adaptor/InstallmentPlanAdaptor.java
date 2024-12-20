package com.td.mbna.msec.midtier.mbofp.adaptor;

import com.td.api.mbofp.request.common.TransactionCccyamt;
import com.td.api.mbofp.request.installmentplan.*;
import com.td.mbna.msec.midtier.offers.payload.requestInstallmentPlan.RequestInstallmentPlanRequest;
import org.springframework.stereotype.Component;

@Component
public class InstallmentPlanAdaptor {

    private static final String ACCESS_CHANNEL_TYPE_CD = "ONLINE-SECURE-SITE";
    private static final String SOLICITATION_CHANNEL_TYPE_CD = "INTERNET-SECURE";
    private static final String EVENT_DESC = "INSTALLMENT-PLAN";
    private static final String CURRENCY_CD = "CAD";
    private static final String TERM_BALANCE_CD = "0001";

    public AddTargetPromotionAgreementFinancialEventRequest generateIPFinancialEventRequest(RequestInstallmentPlanRequest requestInstallmentPlanRequest) {

        AddTargetPromotionAgreementFinancialEventRequest request = new AddTargetPromotionAgreementFinancialEventRequest();
        TargetPromotionAgreementFinancialEvent targetPromotionAgreementFinancialEvent = new TargetPromotionAgreementFinancialEvent();

        request.setTargetPromotionAgreementFinancialEvent(targetPromotionAgreementFinancialEvent);

        //populate promotion product offer
        PromotionProductOffer promotionProductOffer = new PromotionProductOffer();
        promotionProductOffer.setOfferId(requestInstallmentPlanRequest.getRequestPayload().getOfferId());
        promotionProductOffer.setProductId(requestInstallmentPlanRequest.getRequestPayload().getProductId());

        Feature feature = new Feature();
        feature.setFrontEndFeeInd(false);

        promotionProductOffer.setFeature(feature);

        targetPromotionAgreementFinancialEvent.setPromotionProductOffer(promotionProductOffer);


        //populate financial event
        FinancialEvent financialEvent = new FinancialEvent();

        financialEvent.setEventDesc(EVENT_DESC);
        financialEvent.setEventId(requestInstallmentPlanRequest.getRequestPayload().getEventId());
        financialEvent.setDebitTxt(requestInstallmentPlanRequest.getRequestPayload().getNickName());
        financialEvent.setTermBalanceCd(TERM_BALANCE_CD);

        TransactionCccyamt transactionCccyamt = new TransactionCccyamt();
        transactionCccyamt.setAmount(requestInstallmentPlanRequest.getRequestPayload().getTransactionAmt());
        transactionCccyamt.setCurrencyCd(CURRENCY_CD);

        financialEvent.setTransactionCccyamt(transactionCccyamt);

        targetPromotionAgreementFinancialEvent.setFinancialEvent(financialEvent);


        //populate agreement
        Agreement agreement = new Agreement();

        agreement.setHostAgreementNum(requestInstallmentPlanRequest.getAcctNum());

        AgreementToCard agreementToCard = new AgreementToCard();
        agreementToCard.setCardNum(requestInstallmentPlanRequest.getCardNum());
        agreement.setAgreementToCard(agreementToCard);

        AgreementToDocument agreementToDocument = new AgreementToDocument();
        agreementToDocument.setStatementDataDt(requestInstallmentPlanRequest.getRequestPayload().getStatementDataDt());
        agreement.setAgreementToDocument(agreementToDocument);

        targetPromotionAgreementFinancialEvent.setAgreement(agreement);

        //populate promotion channel
        PromotionChannel promotionChannel = new PromotionChannel();
        promotionChannel.setAccessChannelTypeCd(ACCESS_CHANNEL_TYPE_CD);
        promotionChannel.setSolicitationChannelTypeCd(SOLICITATION_CHANNEL_TYPE_CD);

        targetPromotionAgreementFinancialEvent.setPromotionChannel(promotionChannel);


        return request;
    }


}
