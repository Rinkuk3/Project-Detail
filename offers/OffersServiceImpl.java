package com.td.mbna.msec.midtier.offers;

import com.td.mbna.msec.midtier.offers.payload.cancelInstallmentPlan.CancelInstallmentPlanRequest;
import com.td.mbna.msec.midtier.offers.payload.cancelInstallmentPlan.CancelInstallmentPlanResponse;
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
import com.td.mbna.msec.midtier.offers.payload.requestInstallmentPlan.RequestInstallmentPlanRequest;
import com.td.mbna.msec.midtier.offers.payload.requestInstallmentPlan.RequestInstallmentPlanResponse;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.perf.ProfileLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("midtierOffersService")
public class OffersServiceImpl implements OffersService {

    private final static MbnaLogger logger = new MbnaLogger(OffersServiceImpl.class);

    @Autowired
    private RequestCashAdvanceRegistrationOperation requestCashAdvanceRegistrationOperation;

    @Autowired
    private RequestInsuranceOperation requestInsuranceOperation;

    @Autowired
    private RequestProductChangeOperation requestProductChangeOperation;

    @Autowired
    private RequestRetailRegistrationOperation requestRetailRegistrationOperation;

    @Autowired
    private RetrieveOffersForAccountsOperation retrieveOffersForAccountsOperation;

    @Autowired
    private RetrieveOffersOperation retrieveOffersOperation;

    @Autowired
    private UpdateBalanceProtectionInsuranceOperation updateBalanceProtectionInsuranceOperation;

    @Autowired
    private RequestMinPaymentDeferralPaymentOperation requestMinPaymentDeferralPaymentOperation;

    @Autowired
    private RequestInstallmentPlanOperation requestInstallmentPlanOperation;

    @Autowired
    private CancelInstallmentPlanOperation cancelInstallmentPlanOperation;

    @Override
    @ProfileLog
    public RetrieveOffersResponse retrieveOffers(RetrieveOffersRequest retrieveOffersRequest, String... token) {
        try {
            return this.retrieveOffersOperation.invokeService(retrieveOffersRequest, token);
        } catch (Exception e) {
            logger.error("retrieveOffers failed", e);
            throw ExceptionUtil.genRuntimeException(e);
        }
    }

    @Override
    @ProfileLog
    public RetrieveOffersForAccountsResponse retrieveOffersForAccounts(RetrieveOffersForAccountsRequest retrieveOffersForAccountsRequest, String... token) {
        try {
            return this.retrieveOffersForAccountsOperation.invokeService(retrieveOffersForAccountsRequest, token);
        } catch (Exception e) {
            logger.error("retrieveOffersForAccounts failed", e);
            throw ExceptionUtil.genRuntimeException(e);
        }
    }

    @Override
    @ProfileLog
    public UpdateBalanceProtectionInsuranceResponse updateBalanceProtectionInsurance(UpdateBalanceProtectionInsuranceRequest updateBalanceProtectionInsuranceRequest, String... token) {
        return updateBalanceProtectionInsuranceOperation.invokeService(updateBalanceProtectionInsuranceRequest, token);
    }

    @Override
    @ProfileLog
    public RequestProductChangeResponse requestProductChange(RequestProductChangeRequest requestProductChangeRequest, String... token) {
        try {
            RequestProductChangeResponse response = this.requestProductChangeOperation.invokeService(requestProductChangeRequest, token);
            return response;
        } catch (Exception e) {
            logger.error("requestProductChange failed", e);
            throw ExceptionUtil.genRuntimeException(e);
        }
    }

    @Override
    @ProfileLog
    public RequestRetailRegistrationResponse requestRetailRegistration(RequestRetailRegistrationRequest request) {
        try {
            return this.requestRetailRegistrationOperation.invokeService(request);
        } catch (Exception e) {
            logger.error("requestRetailRegistration failed", e);
            throw ExceptionUtil.genRuntimeException(e);
        }
    }

    @Override
    @ProfileLog
    public RequestCashAdvanceRegistrationResponse requestCashAdvanceRegistration(RequestCashAdvanceRegistrationRequest request) {
        try {
            return this.requestCashAdvanceRegistrationOperation.invokeService(request);
        } catch (Exception e) {
            logger.error("requestCashAdvanceRegistration failed", e);
            throw ExceptionUtil.genRuntimeException(e);
        }
    }

    @Override
    @ProfileLog
    public RequestInsuranceResponse requestInsurance(RequestInsuranceRequest requestInsuranceRequest, String... token) {
        try {
            RequestInsuranceResponse response = this.requestInsuranceOperation.invokeService(requestInsuranceRequest, token);
            response.getResponsePayload().setStatus(true);
            return response;
        } catch (Exception e) {
            logger.error("requestInsurance failed", e);
            throw ExceptionUtil.genRuntimeException(e);
        }
    }

    @Override
    @ProfileLog
    public RequestMinPaymentDeferralResponse requestMinPaymentDeferral(RequestMinPaymentDeferralRequest request, String... token) {
        return requestMinPaymentDeferralPaymentOperation.invokeService(request,token);
    }

    @Override
    @ProfileLog
    public RequestInstallmentPlanResponse requestInstallmentPlan(RequestInstallmentPlanRequest request, String... token) {
        return requestInstallmentPlanOperation.invokeService(request,token);
    }

    @Override
    @ProfileLog
    public CancelInstallmentPlanResponse cancelInstallmentPlan(CancelInstallmentPlanRequest cancelInstallmentPlanRequest, String... token) {
        return cancelInstallmentPlanOperation.invokeService(cancelInstallmentPlanRequest,token);
    }


}
