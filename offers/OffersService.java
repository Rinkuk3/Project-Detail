package com.td.mbna.msec.midtier.offers;

import com.td.mbna.msec.midtier.offers.payload.cancelInstallmentPlan.CancelInstallmentPlanRequest;
import com.td.mbna.msec.midtier.offers.payload.cancelInstallmentPlan.CancelInstallmentPlanResponse;
import com.td.mbna.msec.midtier.offers.payload.requestInstallmentPlan.RequestInstallmentPlanRequest;
import com.td.mbna.msec.midtier.offers.payload.requestInstallmentPlan.RequestInstallmentPlanResponse;
import com.td.mbna.msec.midtier.offers.payload.requestcashadvanceregistration.RequestCashAdvanceRegistrationRequest;
import com.td.mbna.msec.midtier.offers.payload.requestcashadvanceregistration.RequestCashAdvanceRegistrationResponse;
import com.td.mbna.msec.midtier.offers.payload.requestinsurance.RequestInsuranceRequest;
import com.td.mbna.msec.midtier.offers.payload.requestinsurance.RequestInsuranceResponse;
import com.td.mbna.msec.midtier.offers.payload.requestminpaymentdeferral.RequestMinPaymentDeferralRequest;
import com.td.mbna.msec.midtier.offers.payload.requestminpaymentdeferral.RequestMinPaymentDeferralResponse;
import com.td.mbna.msec.midtier.offers.payload.requestproductchange.RequestProductChangeRequest;
import com.td.mbna.msec.midtier.offers.payload.requestproductchange.RequestProductChangeResponse;
import com.td.mbna.msec.midtier.offers.payload.requestretailregistration.RequestRetailRegistrationRequest;
import com.td.mbna.msec.midtier.offers.payload.requestretailregistration.RequestRetailRegistrationResponse;
import com.td.mbna.msec.midtier.offers.payload.retrieveoffers.RetrieveOffersRequest;
import com.td.mbna.msec.midtier.offers.payload.retrieveoffers.RetrieveOffersResponse;
import com.td.mbna.msec.midtier.offers.payload.retrieveoffersforaccounts.RetrieveOffersForAccountsRequest;
import com.td.mbna.msec.midtier.offers.payload.retrieveoffersforaccounts.RetrieveOffersForAccountsResponse;
import com.td.mbna.msec.midtier.offers.payload.updatebalanceprotectioninsurance.UpdateBalanceProtectionInsuranceRequest;
import com.td.mbna.msec.midtier.offers.payload.updatebalanceprotectioninsurance.UpdateBalanceProtectionInsuranceResponse;


public interface OffersService {
	public RetrieveOffersResponse retrieveOffers(RetrieveOffersRequest retrieveOffersRequest, String... token);
	public RetrieveOffersForAccountsResponse retrieveOffersForAccounts(RetrieveOffersForAccountsRequest retrieveOffersForAccountsRequest, String... token);
	public UpdateBalanceProtectionInsuranceResponse updateBalanceProtectionInsurance(UpdateBalanceProtectionInsuranceRequest updateBalanceProtectionInsuranceRequest, String... token);
	public RequestProductChangeResponse requestProductChange(RequestProductChangeRequest requestProductChangeRequest, String... token);
	public RequestRetailRegistrationResponse requestRetailRegistration(RequestRetailRegistrationRequest requestRetailRegistrationRequest);
	public RequestCashAdvanceRegistrationResponse requestCashAdvanceRegistration(RequestCashAdvanceRegistrationRequest requestCashAdvanceRegistrationRequest);
	public RequestInsuranceResponse requestInsurance(RequestInsuranceRequest request, String... token);
	public RequestMinPaymentDeferralResponse requestMinPaymentDeferral(RequestMinPaymentDeferralRequest request, String... token);
	public RequestInstallmentPlanResponse requestInstallmentPlan(RequestInstallmentPlanRequest request, String... token);
	public CancelInstallmentPlanResponse cancelInstallmentPlan(CancelInstallmentPlanRequest cancelInstallmentPlanRequest, String... token);
}
