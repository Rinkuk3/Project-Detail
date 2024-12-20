package com.td.api.mbcca.response.account;

import com.td.api.mbcca.response.account.electronicbilling.ElectronicBillingService;
import com.td.api.mbcca.response.account.featureview.FeatureView;
import com.td.api.mbcca.response.insurance.InsuranceAgreement;

public class AccountOverview {

    private RetrieveCreditCardAgreement retrieveCreditCardAgreement;
    private ElectronicBillingService electronicBillingService;
    private FeatureView featureView;
    private InsuranceAgreement insuranceAgreement;

    public RetrieveCreditCardAgreement getRetrieveCreditCardAgreement() {
        return retrieveCreditCardAgreement;
    }

    public void setRetrieveCreditCardAgreement(RetrieveCreditCardAgreement retrieveCreditCardAgreement) {
        this.retrieveCreditCardAgreement = retrieveCreditCardAgreement;
    }

    public ElectronicBillingService getElectronicBillingService() {
        return electronicBillingService;
    }

    public void setElectronicBillingService(ElectronicBillingService electronicBillingService) {
        this.electronicBillingService = electronicBillingService;
    }

    public FeatureView getFeatureView() {
        return featureView;
    }

    public void setFeatureView(FeatureView featureView) {
        this.featureView = featureView;
    }

    public InsuranceAgreement getInsuranceAgreement() {
        return insuranceAgreement;
    }

    public void setInsuranceAgreement(InsuranceAgreement insuranceAgreement) {
        this.insuranceAgreement = insuranceAgreement;
    }

    @Override
    public String toString() {
        return "AccountOverview{" +
                "retrieveCreditCardAgreement=" + retrieveCreditCardAgreement +
                ", electronicBillingService=" + electronicBillingService +
                ", featureView=" + featureView +
                ", insuranceAgreement=" + insuranceAgreement +
                '}';
    }
}
