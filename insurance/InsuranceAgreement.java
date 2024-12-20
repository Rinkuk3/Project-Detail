package com.td.api.mbcca.response.insurance;

import java.util.ArrayList;
import java.util.List;

import com.td.api.mbcca.shared.Cccyamt;

public class InsuranceAgreement {

    private String statusCd;
    private String cancellationStatusReasonCd;
    private String openDt;
    private String signedDt;
    private String lastMaintenanceDt;
    private String providerName;
    private String providerTelephoneNum;
    private List<ProductFeature> productFeature = new ArrayList<ProductFeature>();
    private Cccyamt lastPremiumCccyamt;
    private String lastPremiumDt;
    private String balanceProtectionInsuranceCd;
    private String featureGroupId;
    private String featureGroupDesc;

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public String getCancellationStatusReasonCd() {
        return cancellationStatusReasonCd;
    }

    public void setCancellationStatusReasonCd(String cancellationStatusReasonCd) {
        this.cancellationStatusReasonCd = cancellationStatusReasonCd;
    }

    public String getOpenDt() {
        return openDt;
    }

    public void setOpenDt(String openDt) {
        this.openDt = openDt;
    }

    public String getSignedDt() {
        return signedDt;
    }

    public void setSignedDt(String signedDt) {
        this.signedDt = signedDt;
    }

    public String getLastMaintenanceDt() {
        return lastMaintenanceDt;
    }

    public void setLastMaintenanceDt(String lastMaintenanceDt) {
        this.lastMaintenanceDt = lastMaintenanceDt;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderTelephoneNum() {
        return providerTelephoneNum;
    }

    public void setProviderTelephoneNum(String providerTelephoneNum) {
        this.providerTelephoneNum = providerTelephoneNum;
    }

    public List<ProductFeature> getProductFeature() {
        return productFeature;
    }

    public void setProductFeature(List<ProductFeature> productFeature) {
        this.productFeature = productFeature;
    }

    public Cccyamt getLastPremiumCccyamt() {
        return lastPremiumCccyamt;
    }

    public void setLastPremiumCccyamt(Cccyamt lastPremiumCccyamt) {
        this.lastPremiumCccyamt = lastPremiumCccyamt;
    }

    public String getLastPremiumDt() {
        return lastPremiumDt;
    }

    public void setLastPremiumDt(String lastPremiumDt) {
        this.lastPremiumDt = lastPremiumDt;
    }

    public String getBalanceProtectionInsuranceCd() {
        return balanceProtectionInsuranceCd;
    }

    public void setBalanceProtectionInsuranceCd(String balanceProtectionInsuranceCd) {
        this.balanceProtectionInsuranceCd = balanceProtectionInsuranceCd;
    }

    public String getFeatureGroupId() {
        return featureGroupId;
    }

    public void setFeatureGroupId(String featureGroupId) {
        this.featureGroupId = featureGroupId;
    }

    public String getFeatureGroupDesc() {
        return featureGroupDesc;
    }

    public void setFeatureGroupDesc(String featureGroupDesc) {
        this.featureGroupDesc = featureGroupDesc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(InsuranceAgreement.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("statusCd");
        sb.append('=');
        sb.append(((this.statusCd == null)?"<null>":this.statusCd));
        sb.append(',');
        sb.append("cancellationStatusReasonCd");
        sb.append('=');
        sb.append(((this.cancellationStatusReasonCd == null)?"<null>":this.cancellationStatusReasonCd));
        sb.append(',');
        sb.append("openDt");
        sb.append('=');
        sb.append(((this.openDt == null)?"<null>":this.openDt));
        sb.append(',');
        sb.append("signedDt");
        sb.append('=');
        sb.append(((this.signedDt == null)?"<null>":this.signedDt));
        sb.append(',');
        sb.append("lastMaintenanceDt");
        sb.append('=');
        sb.append(((this.lastMaintenanceDt == null)?"<null>":this.lastMaintenanceDt));
        sb.append(',');
        sb.append("providerName");
        sb.append('=');
        sb.append(((this.providerName == null)?"<null>":this.providerName));
        sb.append(',');
        sb.append("providerTelephoneNum");
        sb.append('=');
        sb.append(((this.providerTelephoneNum == null)?"<null>":this.providerTelephoneNum));
        sb.append(',');
        sb.append("productFeature");
        sb.append('=');
        sb.append(((this.productFeature == null)?"<null>":this.productFeature));
        sb.append(',');
        sb.append("lastPremiumCccyamt");
        sb.append('=');
        sb.append(((this.lastPremiumCccyamt == null)?"<null>":this.lastPremiumCccyamt));
        sb.append(',');
        sb.append("lastPremiumDt");
        sb.append('=');
        sb.append(((this.lastPremiumDt == null)?"<null>":this.lastPremiumDt));
        sb.append(',');
        sb.append("balanceProtectionInsuranceCd");
        sb.append('=');
        sb.append(((this.balanceProtectionInsuranceCd == null)?"<null>":this.balanceProtectionInsuranceCd));
        sb.append(',');
        sb.append("featureGroupId");
        sb.append('=');
        sb.append(((this.featureGroupId == null)?"<null>":this.featureGroupId));
        sb.append(',');
        sb.append("featureGroupDesc");
        sb.append('=');
        sb.append(((this.featureGroupDesc == null)?"<null>":this.featureGroupDesc));
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
        result = ((result* 31)+((this.providerTelephoneNum == null)? 0 :this.providerTelephoneNum.hashCode()));
        result = ((result* 31)+((this.featureGroupDesc == null)? 0 :this.featureGroupDesc.hashCode()));
        result = ((result* 31)+((this.lastPremiumDt == null)? 0 :this.lastPremiumDt.hashCode()));
        result = ((result* 31)+((this.statusCd == null)? 0 :this.statusCd.hashCode()));
        result = ((result* 31)+((this.lastPremiumCccyamt == null)? 0 :this.lastPremiumCccyamt.hashCode()));
        result = ((result* 31)+((this.productFeature == null)? 0 :this.productFeature.hashCode()));
        result = ((result* 31)+((this.cancellationStatusReasonCd == null)? 0 :this.cancellationStatusReasonCd.hashCode()));
        result = ((result* 31)+((this.lastMaintenanceDt == null)? 0 :this.lastMaintenanceDt.hashCode()));
        result = ((result* 31)+((this.featureGroupId == null)? 0 :this.featureGroupId.hashCode()));
        result = ((result* 31)+((this.openDt == null)? 0 :this.openDt.hashCode()));
        result = ((result* 31)+((this.signedDt == null)? 0 :this.signedDt.hashCode()));
        result = ((result* 31)+((this.providerName == null)? 0 :this.providerName.hashCode()));
        result = ((result* 31)+((this.balanceProtectionInsuranceCd == null)? 0 :this.balanceProtectionInsuranceCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof InsuranceAgreement) == false) {
            return false;
        }
        InsuranceAgreement rhs = ((InsuranceAgreement) other);
        return ((((((((((((((this.providerTelephoneNum == rhs.providerTelephoneNum)||((this.providerTelephoneNum!= null)&&this.providerTelephoneNum.equals(rhs.providerTelephoneNum)))&&((this.featureGroupDesc == rhs.featureGroupDesc)||((this.featureGroupDesc!= null)&&this.featureGroupDesc.equals(rhs.featureGroupDesc))))&&((this.lastPremiumDt == rhs.lastPremiumDt)||((this.lastPremiumDt!= null)&&this.lastPremiumDt.equals(rhs.lastPremiumDt))))&&((this.statusCd == rhs.statusCd)||((this.statusCd!= null)&&this.statusCd.equals(rhs.statusCd))))&&((this.lastPremiumCccyamt == rhs.lastPremiumCccyamt)||((this.lastPremiumCccyamt!= null)&&this.lastPremiumCccyamt.equals(rhs.lastPremiumCccyamt))))&&((this.productFeature == rhs.productFeature)||((this.productFeature!= null)&&this.productFeature.equals(rhs.productFeature))))&&((this.cancellationStatusReasonCd == rhs.cancellationStatusReasonCd)||((this.cancellationStatusReasonCd!= null)&&this.cancellationStatusReasonCd.equals(rhs.cancellationStatusReasonCd))))&&((this.lastMaintenanceDt == rhs.lastMaintenanceDt)||((this.lastMaintenanceDt!= null)&&this.lastMaintenanceDt.equals(rhs.lastMaintenanceDt))))&&((this.featureGroupId == rhs.featureGroupId)||((this.featureGroupId!= null)&&this.featureGroupId.equals(rhs.featureGroupId))))&&((this.openDt == rhs.openDt)||((this.openDt!= null)&&this.openDt.equals(rhs.openDt))))&&((this.signedDt == rhs.signedDt)||((this.signedDt!= null)&&this.signedDt.equals(rhs.signedDt))))&&((this.providerName == rhs.providerName)||((this.providerName!= null)&&this.providerName.equals(rhs.providerName))))&&((this.balanceProtectionInsuranceCd == rhs.balanceProtectionInsuranceCd)||((this.balanceProtectionInsuranceCd!= null)&&this.balanceProtectionInsuranceCd.equals(rhs.balanceProtectionInsuranceCd))));
    }

}
