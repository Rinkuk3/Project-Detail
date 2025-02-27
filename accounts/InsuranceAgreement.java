package com.td.api.mbcca.response.account;

import java.util.ArrayList;
import java.util.List;

public class InsuranceAgreement {

    private String statusCd;
    private String cancellationStatusReasonCd;
    private String signedDt;
    private List<ProductFeature> productFeature = new ArrayList<ProductFeature>();
    private String lastMaintenanceDt;

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

    public String getSignedDt() {
        return signedDt;
    }

    public void setSignedDt(String signedDt) {
        this.signedDt = signedDt;
    }

    public List<ProductFeature> getProductFeature() {
        return productFeature;
    }

    public void setProductFeature(List<ProductFeature> productFeature) {
        this.productFeature = productFeature;
    }

    public String getLastMaintenanceDt() {
        return lastMaintenanceDt;
    }

    public void setLastMaintenanceDt(String lastMaintenanceDt) {
        this.lastMaintenanceDt = lastMaintenanceDt;
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
        sb.append("signedDt");
        sb.append('=');
        sb.append(((this.signedDt == null)?"<null>":this.signedDt));
        sb.append(',');
        sb.append("productFeature");
        sb.append('=');
        sb.append(((this.productFeature == null)?"<null>":this.productFeature));
        sb.append(',');
        sb.append("lastMaintenanceDt");
        sb.append('=');
        sb.append(((this.lastMaintenanceDt == null)?"<null>":this.lastMaintenanceDt));
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
        result = ((result* 31)+((this.cancellationStatusReasonCd == null)? 0 :this.cancellationStatusReasonCd.hashCode()));
        result = ((result* 31)+((this.lastMaintenanceDt == null)? 0 :this.lastMaintenanceDt.hashCode()));
        result = ((result* 31)+((this.statusCd == null)? 0 :this.statusCd.hashCode()));
        result = ((result* 31)+((this.signedDt == null)? 0 :this.signedDt.hashCode()));
        result = ((result* 31)+((this.productFeature == null)? 0 :this.productFeature.hashCode()));
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
        return ((((((this.cancellationStatusReasonCd == rhs.cancellationStatusReasonCd)||((this.cancellationStatusReasonCd!= null)&&this.cancellationStatusReasonCd.equals(rhs.cancellationStatusReasonCd)))&&((this.lastMaintenanceDt == rhs.lastMaintenanceDt)||((this.lastMaintenanceDt!= null)&&this.lastMaintenanceDt.equals(rhs.lastMaintenanceDt))))&&((this.statusCd == rhs.statusCd)||((this.statusCd!= null)&&this.statusCd.equals(rhs.statusCd))))&&((this.signedDt == rhs.signedDt)||((this.signedDt!= null)&&this.signedDt.equals(rhs.signedDt))))&&((this.productFeature == rhs.productFeature)||((this.productFeature!= null)&&this.productFeature.equals(rhs.productFeature))));
    }

}
