package com.td.mbna.msec.midtier.mbofp;

import java.math.BigDecimal;
import java.util.Map;

import com.td.api.mbofp.response.installmentplan.AddTargetPromotionAgreementFinancialEventResponse;
import com.td.mbna.msec.midtier.offers.payload.requestInstallmentPlan.RequestInstallmentPlanRequest;
import com.td.mbna.msec.midtier.offers.payload.requestinsurance.RequestInsuranceResponse;
import com.td.mbna.msec.midtier.offers.payload.requestproductchange.RequestProductChangeResponse;
import com.td.mbna.msec.midtier.offers.payload.retrieveoffers.RetrieveOffersResponse;
import com.td.mbna.msec.midtier.transfer.payload.balancetransfertocreditor.BalanceTransferToCreditorResponse;
import com.td.mbna.msec.midtier.transfer.payload.deposittochequing.DepositToChequingResponse;
import com.td.mbna.msec.midtier.types.common.IpCalculation;

public interface MbnaOFP {
    public RetrieveOffersResponse retrieveOfferList(Map<String, String> params, String token);
    public void updateOfferDisposition(Map<String, Object> params, String token);
    public RequestInsuranceResponse insuranceEnrolment(Map<String, Object> params, String token);
    public RequestProductChangeResponse requestProductChange(Map<String, Object> params, String token);
    public DepositToChequingResponse depositToChequing(Map<String, Object> params, String token);
    public BalanceTransferToCreditorResponse balanceTransferToCreditor(Map<String, Object> params, String token);
    public IpCalculation calculateIpPaymentDetails(BigDecimal interestRate, BigDecimal contractAnnualRate, BigDecimal setupFee, BigDecimal transactionAmt, int duration, String offerId);
    public AddTargetPromotionAgreementFinancialEventResponse requestInstallmentPlan(RequestInstallmentPlanRequest requestInstallmentPlanRequest, String token);
}
