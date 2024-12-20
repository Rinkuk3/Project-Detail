package com.td.api.mbcca.creditcard.request;

import com.td.api.mbcca.shared.Cccyamt;

public class CreditCardAgreement {

    private AddressInfo addressInfo;
    private FdrExtension fdrExtension;
    private AgreementLimitInfo agreementLimitInfo;
    private CcapiExtension ccapiExtension;
    private String billingCycleDayOfMonthNum;
    private String disclosureGroupId;
    private AlternateDisclosureGroup alternateDisclosureGroup;
    private String pricingMethodSubtypeCd;
    private Cccyamt minimumPaymentDueCccyamt;
    private Cccyamt highBalanceCccyamt;
    private String lastCheckRejectionFeeDateActionCd;
    private String lastNotSufficientFundsFeeDateActionCd;
    private ChargeOffStatus chargeOffStatus;
    private ReinstatementStatus reinstatementStatus;
    private PastDueInfo pastDueInfo;

    public AddressInfo getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(AddressInfo addressInfo) {
        this.addressInfo = addressInfo;
    }

    public FdrExtension getFdrExtension() {
        return fdrExtension;
    }

    public void setFdrExtension(FdrExtension fdrExtension) {
        this.fdrExtension = fdrExtension;
    }

    public AgreementLimitInfo getAgreementLimitInfo() {
        return agreementLimitInfo;
    }

    public void setAgreementLimitInfo(AgreementLimitInfo agreementLimitInfo) {
        this.agreementLimitInfo = agreementLimitInfo;
    }

    public CcapiExtension getCcapiExtension() {
        return ccapiExtension;
    }

    public void setCcapiExtension(CcapiExtension ccapiExtension) {
        this.ccapiExtension = ccapiExtension;
    }

    public String getBillingCycleDayOfMonthNum() {
        return billingCycleDayOfMonthNum;
    }

    public void setBillingCycleDayOfMonthNum(String billingCycleDayOfMonthNum) {
        this.billingCycleDayOfMonthNum = billingCycleDayOfMonthNum;
    }

    public String getDisclosureGroupId() {
        return disclosureGroupId;
    }

    public void setDisclosureGroupId(String disclosureGroupId) {
        this.disclosureGroupId = disclosureGroupId;
    }

    public AlternateDisclosureGroup getAlternateDisclosureGroup() {
        return alternateDisclosureGroup;
    }

    public void setAlternateDisclosureGroup(AlternateDisclosureGroup alternateDisclosureGroup) {
        this.alternateDisclosureGroup = alternateDisclosureGroup;
    }

    public String getPricingMethodSubtypeCd() {
        return pricingMethodSubtypeCd;
    }

    public void setPricingMethodSubtypeCd(String pricingMethodSubtypeCd) {
        this.pricingMethodSubtypeCd = pricingMethodSubtypeCd;
    }

    public Cccyamt getMinimumPaymentDueCccyamt() {
        return minimumPaymentDueCccyamt;
    }

    public void setMinimumPaymentDueCccyamt(Cccyamt minimumPaymentDueCccyamt) {
        this.minimumPaymentDueCccyamt = minimumPaymentDueCccyamt;
    }

    public Cccyamt getHighBalanceCccyamt() {
        return highBalanceCccyamt;
    }

    public void setHighBalanceCccyamt(Cccyamt highBalanceCccyamt) {
        this.highBalanceCccyamt = highBalanceCccyamt;
    }

    public String getLastCheckRejectionFeeDateActionCd() {
        return lastCheckRejectionFeeDateActionCd;
    }

    public void setLastCheckRejectionFeeDateActionCd(String lastCheckRejectionFeeDateActionCd) {
        this.lastCheckRejectionFeeDateActionCd = lastCheckRejectionFeeDateActionCd;
    }

    public String getLastNotSufficientFundsFeeDateActionCd() {
        return lastNotSufficientFundsFeeDateActionCd;
    }

    public void setLastNotSufficientFundsFeeDateActionCd(String lastNotSufficientFundsFeeDateActionCd) {
        this.lastNotSufficientFundsFeeDateActionCd = lastNotSufficientFundsFeeDateActionCd;
    }

    public ChargeOffStatus getChargeOffStatus() {
        return chargeOffStatus;
    }

    public void setChargeOffStatus(ChargeOffStatus chargeOffStatus) {
        this.chargeOffStatus = chargeOffStatus;
    }

    public ReinstatementStatus getReinstatementStatus() {
        return reinstatementStatus;
    }

    public void setReinstatementStatus(ReinstatementStatus reinstatementStatus) {
        this.reinstatementStatus = reinstatementStatus;
    }

    public PastDueInfo getPastDueInfo() {
        return pastDueInfo;
    }

    public void setPastDueInfo(PastDueInfo pastDueInfo) {
        this.pastDueInfo = pastDueInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CreditCardAgreement.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("addressInfo");
        sb.append('=');
        sb.append(((this.addressInfo == null)?"<null>":this.addressInfo));
        sb.append(',');
        sb.append("fdrExtension");
        sb.append('=');
        sb.append(((this.fdrExtension == null)?"<null>":this.fdrExtension));
        sb.append(',');
        sb.append("agreementLimitInfo");
        sb.append('=');
        sb.append(((this.agreementLimitInfo == null)?"<null>":this.agreementLimitInfo));
        sb.append(',');
        sb.append("ccapiExtension");
        sb.append('=');
        sb.append(((this.ccapiExtension == null)?"<null>":this.ccapiExtension));
        sb.append(',');
        sb.append("billingCycleDayOfMonthNum");
        sb.append('=');
        sb.append(((this.billingCycleDayOfMonthNum == null)?"<null>":this.billingCycleDayOfMonthNum));
        sb.append(',');
        sb.append("disclosureGroupId");
        sb.append('=');
        sb.append(((this.disclosureGroupId == null)?"<null>":this.disclosureGroupId));
        sb.append(',');
        sb.append("alternateDisclosureGroup");
        sb.append('=');
        sb.append(((this.alternateDisclosureGroup == null)?"<null>":this.alternateDisclosureGroup));
        sb.append(',');
        sb.append("pricingMethodSubtypeCd");
        sb.append('=');
        sb.append(((this.pricingMethodSubtypeCd == null)?"<null>":this.pricingMethodSubtypeCd));
        sb.append(',');
        sb.append("minimumPaymentDueCccyamt");
        sb.append('=');
        sb.append(((this.minimumPaymentDueCccyamt == null)?"<null>":this.minimumPaymentDueCccyamt));
        sb.append(',');
        sb.append("highBalanceCccyamt");
        sb.append('=');
        sb.append(((this.highBalanceCccyamt == null)?"<null>":this.highBalanceCccyamt));
        sb.append(',');
        sb.append("lastCheckRejectionFeeDateActionCd");
        sb.append('=');
        sb.append(((this.lastCheckRejectionFeeDateActionCd == null)?"<null>":this.lastCheckRejectionFeeDateActionCd));
        sb.append(',');
        sb.append("lastNotSufficientFundsFeeDateActionCd");
        sb.append('=');
        sb.append(((this.lastNotSufficientFundsFeeDateActionCd == null)?"<null>":this.lastNotSufficientFundsFeeDateActionCd));
        sb.append(',');
        sb.append("chargeOffStatus");
        sb.append('=');
        sb.append(((this.chargeOffStatus == null)?"<null>":this.chargeOffStatus));
        sb.append(',');
        sb.append("reinstatementStatus");
        sb.append('=');
        sb.append(((this.reinstatementStatus == null)?"<null>":this.reinstatementStatus));
        sb.append(',');
        sb.append("pastDueInfo");
        sb.append('=');
        sb.append(((this.pastDueInfo == null)?"<null>":this.pastDueInfo));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.addressInfo == null)? 0 :this.addressInfo.hashCode()));
        result = ((result* 31)+((this.pricingMethodSubtypeCd == null)? 0 :this.pricingMethodSubtypeCd.hashCode()));
        result = ((result* 31)+((this.lastCheckRejectionFeeDateActionCd == null)? 0 :this.lastCheckRejectionFeeDateActionCd.hashCode()));
        result = ((result* 31)+((this.agreementLimitInfo == null)? 0 :this.agreementLimitInfo.hashCode()));
        result = ((result* 31)+((this.reinstatementStatus == null)? 0 :this.reinstatementStatus.hashCode()));
        result = ((result* 31)+((this.disclosureGroupId == null)? 0 :this.disclosureGroupId.hashCode()));
        result = ((result* 31)+((this.fdrExtension == null)? 0 :this.fdrExtension.hashCode()));
        result = ((result* 31)+((this.minimumPaymentDueCccyamt == null)? 0 :this.minimumPaymentDueCccyamt.hashCode()));
        result = ((result* 31)+((this.highBalanceCccyamt == null)? 0 :this.highBalanceCccyamt.hashCode()));
        result = ((result* 31)+((this.lastNotSufficientFundsFeeDateActionCd == null)? 0 :this.lastNotSufficientFundsFeeDateActionCd.hashCode()));
        result = ((result* 31)+((this.billingCycleDayOfMonthNum == null)? 0 :this.billingCycleDayOfMonthNum.hashCode()));
        result = ((result* 31)+((this.alternateDisclosureGroup == null)? 0 :this.alternateDisclosureGroup.hashCode()));
        result = ((result* 31)+((this.ccapiExtension == null)? 0 :this.ccapiExtension.hashCode()));
        result = ((result* 31)+((this.pastDueInfo == null)? 0 :this.pastDueInfo.hashCode()));
        result = ((result* 31)+((this.chargeOffStatus == null)? 0 :this.chargeOffStatus.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreditCardAgreement) == false) {
            return false;
        }
        CreditCardAgreement rhs = ((CreditCardAgreement) other);
        return ((((((((((((((((this.addressInfo == rhs.addressInfo)||((this.addressInfo!= null)&&this.addressInfo.equals(rhs.addressInfo)))&&((this.pricingMethodSubtypeCd == rhs.pricingMethodSubtypeCd)||((this.pricingMethodSubtypeCd!= null)&&this.pricingMethodSubtypeCd.equals(rhs.pricingMethodSubtypeCd))))&&((this.lastCheckRejectionFeeDateActionCd == rhs.lastCheckRejectionFeeDateActionCd)||((this.lastCheckRejectionFeeDateActionCd!= null)&&this.lastCheckRejectionFeeDateActionCd.equals(rhs.lastCheckRejectionFeeDateActionCd))))&&((this.agreementLimitInfo == rhs.agreementLimitInfo)||((this.agreementLimitInfo!= null)&&this.agreementLimitInfo.equals(rhs.agreementLimitInfo))))&&((this.reinstatementStatus == rhs.reinstatementStatus)||((this.reinstatementStatus!= null)&&this.reinstatementStatus.equals(rhs.reinstatementStatus))))&&((this.disclosureGroupId == rhs.disclosureGroupId)||((this.disclosureGroupId!= null)&&this.disclosureGroupId.equals(rhs.disclosureGroupId))))&&((this.fdrExtension == rhs.fdrExtension)||((this.fdrExtension!= null)&&this.fdrExtension.equals(rhs.fdrExtension))))&&((this.minimumPaymentDueCccyamt == rhs.minimumPaymentDueCccyamt)||((this.minimumPaymentDueCccyamt!= null)&&this.minimumPaymentDueCccyamt.equals(rhs.minimumPaymentDueCccyamt))))&&((this.highBalanceCccyamt == rhs.highBalanceCccyamt)||((this.highBalanceCccyamt!= null)&&this.highBalanceCccyamt.equals(rhs.highBalanceCccyamt))))&&((this.lastNotSufficientFundsFeeDateActionCd == rhs.lastNotSufficientFundsFeeDateActionCd)||((this.lastNotSufficientFundsFeeDateActionCd!= null)&&this.lastNotSufficientFundsFeeDateActionCd.equals(rhs.lastNotSufficientFundsFeeDateActionCd))))&&((this.billingCycleDayOfMonthNum == rhs.billingCycleDayOfMonthNum)||((this.billingCycleDayOfMonthNum!= null)&&this.billingCycleDayOfMonthNum.equals(rhs.billingCycleDayOfMonthNum))))&&((this.alternateDisclosureGroup == rhs.alternateDisclosureGroup)||((this.alternateDisclosureGroup!= null)&&this.alternateDisclosureGroup.equals(rhs.alternateDisclosureGroup))))&&((this.ccapiExtension == rhs.ccapiExtension)||((this.ccapiExtension!= null)&&this.ccapiExtension.equals(rhs.ccapiExtension))))&&((this.pastDueInfo == rhs.pastDueInfo)||((this.pastDueInfo!= null)&&this.pastDueInfo.equals(rhs.pastDueInfo))))&&((this.chargeOffStatus == rhs.chargeOffStatus)||((this.chargeOffStatus!= null)&&this.chargeOffStatus.equals(rhs.chargeOffStatus))));
    }

}
