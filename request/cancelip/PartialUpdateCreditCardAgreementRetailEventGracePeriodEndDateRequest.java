package com.td.api.mbcca.request.cancelip;

public class PartialUpdateCreditCardAgreementRetailEventGracePeriodEndDateRequest {

    private String gracePeriodEndDt;
    private String sameAsCashPaymentOptionFeatureId;
    private String instalmentPaymentOptionFeatureDt;

    public String getGracePeriodEndDt() {
        return gracePeriodEndDt;
    }

    public void setGracePeriodEndDt(String gracePeriodEndDt) {
        this.gracePeriodEndDt = gracePeriodEndDt;
    }

    public String getSameAsCashPaymentOptionFeatureId() {
        return sameAsCashPaymentOptionFeatureId;
    }

    public void setSameAsCashPaymentOptionFeatureId(String sameAsCashPaymentOptionFeatureId) {
        this.sameAsCashPaymentOptionFeatureId = sameAsCashPaymentOptionFeatureId;
    }

    public String getInstalmentPaymentOptionFeatureDt() {
        return instalmentPaymentOptionFeatureDt;
    }

    public void setInstalmentPaymentOptionFeatureDt(String instalmentPaymentOptionFeatureDt) {
        this.instalmentPaymentOptionFeatureDt = instalmentPaymentOptionFeatureDt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PartialUpdateCreditCardAgreementRetailEventGracePeriodEndDateRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("gracePeriodEndDt");
        sb.append('=');
        sb.append(((this.gracePeriodEndDt == null)?"<null>":this.gracePeriodEndDt));
        sb.append(',');
        sb.append("sameAsCashPaymentOptionFeatureId");
        sb.append('=');
        sb.append(((this.sameAsCashPaymentOptionFeatureId == null)?"<null>":this.sameAsCashPaymentOptionFeatureId));
        sb.append(',');
        sb.append("instalmentPaymentOptionFeatureDt");
        sb.append('=');
        sb.append(((this.instalmentPaymentOptionFeatureDt == null)?"<null>":this.instalmentPaymentOptionFeatureDt));
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
        result = ((result* 31)+((this.sameAsCashPaymentOptionFeatureId == null)? 0 :this.sameAsCashPaymentOptionFeatureId.hashCode()));
        result = ((result* 31)+((this.instalmentPaymentOptionFeatureDt == null)? 0 :this.instalmentPaymentOptionFeatureDt.hashCode()));
        result = ((result* 31)+((this.gracePeriodEndDt == null)? 0 :this.gracePeriodEndDt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PartialUpdateCreditCardAgreementRetailEventGracePeriodEndDateRequest) == false) {
            return false;
        }
        PartialUpdateCreditCardAgreementRetailEventGracePeriodEndDateRequest rhs = ((PartialUpdateCreditCardAgreementRetailEventGracePeriodEndDateRequest) other);
        return ((((this.sameAsCashPaymentOptionFeatureId == rhs.sameAsCashPaymentOptionFeatureId)||((this.sameAsCashPaymentOptionFeatureId!= null)&&this.sameAsCashPaymentOptionFeatureId.equals(rhs.sameAsCashPaymentOptionFeatureId)))&&((this.instalmentPaymentOptionFeatureDt == rhs.instalmentPaymentOptionFeatureDt)||((this.instalmentPaymentOptionFeatureDt!= null)&&this.instalmentPaymentOptionFeatureDt.equals(rhs.instalmentPaymentOptionFeatureDt))))&&((this.gracePeriodEndDt == rhs.gracePeriodEndDt)||((this.gracePeriodEndDt!= null)&&this.gracePeriodEndDt.equals(rhs.gracePeriodEndDt))));
    }

}
