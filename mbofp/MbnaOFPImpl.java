package com.td.mbna.msec.midtier.mbofp;

import com.td.api.mbofp.response.installmentplan.AddTargetPromotionAgreementFinancialEventResponse;
import com.td.mbna.msec.midtier.mbofp.facade.MbnaOfpFacade;
import com.td.mbna.msec.midtier.offers.payload.requestInstallmentPlan.RequestInstallmentPlanRequest;
import com.td.mbna.msec.midtier.offers.payload.requestinsurance.RequestInsuranceResponse;
import com.td.mbna.msec.midtier.offers.payload.requestproductchange.RequestProductChangeResponse;
import com.td.mbna.msec.midtier.offers.payload.retrieveoffers.RetrieveOffersResponse;
import com.td.mbna.msec.midtier.transfer.payload.balancetransfertocreditor.BalanceTransferToCreditorResponse;
import com.td.mbna.msec.midtier.transfer.payload.deposittochequing.DepositToChequingResponse;
import com.td.mbna.msec.midtier.types.common.IpCalculation;
import com.td.mbna.msec.midtier.util.FeeUtil;
import com.td.mbna.msec.midtier.util.perf.ProfileLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class MbnaOFPImpl implements MbnaOFP {

    @Autowired
    private MbnaOfpFacade mbnaOfpFacade;
    
    @Override
	@ProfileLog
    public RetrieveOffersResponse retrieveOfferList(Map<String, String> params, String token) {
    	RetrieveOffersResponse response = mbnaOfpFacade.retrieveOfferList(params, token);
    	return response;
    }

	@Override
	@ProfileLog
	public void updateOfferDisposition(Map<String, Object> params, String token) {
		mbnaOfpFacade.updateOfferDisposition(params, token);		
	}

	@Override
	@ProfileLog
	public RequestInsuranceResponse insuranceEnrolment(Map<String, Object> params, String token) {
		return mbnaOfpFacade.insuranceEnrolment(params, token);
	}

	@Override
	@ProfileLog
	public RequestProductChangeResponse requestProductChange(Map<String, Object> params, String token) {
		return mbnaOfpFacade.requestProductChange(params, token);
	}

	@Override
	@ProfileLog
	public DepositToChequingResponse depositToChequing(Map<String, Object> params, String token) {
		return mbnaOfpFacade.depositToChequing(params, token);
	}

	@Override
	@ProfileLog
	public BalanceTransferToCreditorResponse balanceTransferToCreditor(Map<String, Object> params, String token) {
		return mbnaOfpFacade.balanceTransferToCreditor(params, token);
	}

	@Override
	@ProfileLog
    public IpCalculation calculateIpPaymentDetails(BigDecimal interestRate, BigDecimal contractAnnualRate, BigDecimal setupFee, BigDecimal transactionAmt, int duration, String offerId) {
    	return FeeUtil.calculateIpPaymentDetails(interestRate, contractAnnualRate, setupFee, transactionAmt, duration, offerId);
    }

	@Override
	@ProfileLog
	public AddTargetPromotionAgreementFinancialEventResponse requestInstallmentPlan(RequestInstallmentPlanRequest requestInstallmentPlanRequest, String token) {
		return mbnaOfpFacade.requestInstallmentPlan(requestInstallmentPlanRequest,token);
	}
}
