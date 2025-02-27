package com.td.api.mbcca.response.account;

public class StatusChangesInfo {

    private String productChangeStatusLastChangedDt;
    private String agreementClosedStatusDt;
    private String creditRevokedStatusLastChangedDt;
    private String collectionStatusLastChangedDt;
    private String agreementStatusLastChangedDt;
    private String creditBureauStatusLastChangedDt;
    private String securityFraudStatusLastChangedDt;
    private String watchStatusLastChangedDt;
    private String agreementClosedStatusLastChangedDt;
    private String potentialPurgeStatusLastChangedDt;

    public String getProductChangeStatusLastChangedDt() {
        return productChangeStatusLastChangedDt;
    }

    public void setProductChangeStatusLastChangedDt(String productChangeStatusLastChangedDt) {
        this.productChangeStatusLastChangedDt = productChangeStatusLastChangedDt;
    }

    public String getAgreementClosedStatusDt() {
        return agreementClosedStatusDt;
    }

    public void setAgreementClosedStatusDt(String agreementClosedStatusDt) {
        this.agreementClosedStatusDt = agreementClosedStatusDt;
    }

    public String getCreditRevokedStatusLastChangedDt() {
        return creditRevokedStatusLastChangedDt;
    }

    public void setCreditRevokedStatusLastChangedDt(String creditRevokedStatusLastChangedDt) {
        this.creditRevokedStatusLastChangedDt = creditRevokedStatusLastChangedDt;
    }

    public String getCollectionStatusLastChangedDt() {
        return collectionStatusLastChangedDt;
    }

    public void setCollectionStatusLastChangedDt(String collectionStatusLastChangedDt) {
        this.collectionStatusLastChangedDt = collectionStatusLastChangedDt;
    }

    public String getAgreementStatusLastChangedDt() {
        return agreementStatusLastChangedDt;
    }

    public void setAgreementStatusLastChangedDt(String agreementStatusLastChangedDt) {
        this.agreementStatusLastChangedDt = agreementStatusLastChangedDt;
    }

    public String getCreditBureauStatusLastChangedDt() {
        return creditBureauStatusLastChangedDt;
    }

    public void setCreditBureauStatusLastChangedDt(String creditBureauStatusLastChangedDt) {
        this.creditBureauStatusLastChangedDt = creditBureauStatusLastChangedDt;
    }

    public String getSecurityFraudStatusLastChangedDt() {
        return securityFraudStatusLastChangedDt;
    }

    public void setSecurityFraudStatusLastChangedDt(String securityFraudStatusLastChangedDt) {
        this.securityFraudStatusLastChangedDt = securityFraudStatusLastChangedDt;
    }

    public String getWatchStatusLastChangedDt() {
        return watchStatusLastChangedDt;
    }

    public void setWatchStatusLastChangedDt(String watchStatusLastChangedDt) {
        this.watchStatusLastChangedDt = watchStatusLastChangedDt;
    }

    public String getAgreementClosedStatusLastChangedDt() {
        return agreementClosedStatusLastChangedDt;
    }

    public void setAgreementClosedStatusLastChangedDt(String agreementClosedStatusLastChangedDt) {
        this.agreementClosedStatusLastChangedDt = agreementClosedStatusLastChangedDt;
    }

    public String getPotentialPurgeStatusLastChangedDt() {
        return potentialPurgeStatusLastChangedDt;
    }

    public void setPotentialPurgeStatusLastChangedDt(String potentialPurgeStatusLastChangedDt) {
        this.potentialPurgeStatusLastChangedDt = potentialPurgeStatusLastChangedDt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StatusChangesInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("productChangeStatusLastChangedDt");
        sb.append('=');
        sb.append(((this.productChangeStatusLastChangedDt == null)?"<null>":this.productChangeStatusLastChangedDt));
        sb.append(',');
        sb.append("agreementClosedStatusDt");
        sb.append('=');
        sb.append(((this.agreementClosedStatusDt == null)?"<null>":this.agreementClosedStatusDt));
        sb.append(',');
        sb.append("creditRevokedStatusLastChangedDt");
        sb.append('=');
        sb.append(((this.creditRevokedStatusLastChangedDt == null)?"<null>":this.creditRevokedStatusLastChangedDt));
        sb.append(',');
        sb.append("collectionStatusLastChangedDt");
        sb.append('=');
        sb.append(((this.collectionStatusLastChangedDt == null)?"<null>":this.collectionStatusLastChangedDt));
        sb.append(',');
        sb.append("agreementStatusLastChangedDt");
        sb.append('=');
        sb.append(((this.agreementStatusLastChangedDt == null)?"<null>":this.agreementStatusLastChangedDt));
        sb.append(',');
        sb.append("creditBureauStatusLastChangedDt");
        sb.append('=');
        sb.append(((this.creditBureauStatusLastChangedDt == null)?"<null>":this.creditBureauStatusLastChangedDt));
        sb.append(',');
        sb.append("securityFraudStatusLastChangedDt");
        sb.append('=');
        sb.append(((this.securityFraudStatusLastChangedDt == null)?"<null>":this.securityFraudStatusLastChangedDt));
        sb.append(',');
        sb.append("watchStatusLastChangedDt");
        sb.append('=');
        sb.append(((this.watchStatusLastChangedDt == null)?"<null>":this.watchStatusLastChangedDt));
        sb.append(',');
        sb.append("agreementClosedStatusLastChangedDt");
        sb.append('=');
        sb.append(((this.agreementClosedStatusLastChangedDt == null)?"<null>":this.agreementClosedStatusLastChangedDt));
        sb.append(',');
        sb.append("potentialPurgeStatusLastChangedDt");
        sb.append('=');
        sb.append(((this.potentialPurgeStatusLastChangedDt == null)?"<null>":this.potentialPurgeStatusLastChangedDt));
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
        result = ((result* 31)+((this.agreementStatusLastChangedDt == null)? 0 :this.agreementStatusLastChangedDt.hashCode()));
        result = ((result* 31)+((this.productChangeStatusLastChangedDt == null)? 0 :this.productChangeStatusLastChangedDt.hashCode()));
        result = ((result* 31)+((this.agreementClosedStatusLastChangedDt == null)? 0 :this.agreementClosedStatusLastChangedDt.hashCode()));
        result = ((result* 31)+((this.creditBureauStatusLastChangedDt == null)? 0 :this.creditBureauStatusLastChangedDt.hashCode()));
        result = ((result* 31)+((this.securityFraudStatusLastChangedDt == null)? 0 :this.securityFraudStatusLastChangedDt.hashCode()));
        result = ((result* 31)+((this.agreementClosedStatusDt == null)? 0 :this.agreementClosedStatusDt.hashCode()));
        result = ((result* 31)+((this.potentialPurgeStatusLastChangedDt == null)? 0 :this.potentialPurgeStatusLastChangedDt.hashCode()));
        result = ((result* 31)+((this.creditRevokedStatusLastChangedDt == null)? 0 :this.creditRevokedStatusLastChangedDt.hashCode()));
        result = ((result* 31)+((this.collectionStatusLastChangedDt == null)? 0 :this.collectionStatusLastChangedDt.hashCode()));
        result = ((result* 31)+((this.watchStatusLastChangedDt == null)? 0 :this.watchStatusLastChangedDt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StatusChangesInfo) == false) {
            return false;
        }
        StatusChangesInfo rhs = ((StatusChangesInfo) other);
        return (((((((((((this.agreementStatusLastChangedDt == rhs.agreementStatusLastChangedDt)||((this.agreementStatusLastChangedDt!= null)&&this.agreementStatusLastChangedDt.equals(rhs.agreementStatusLastChangedDt)))&&((this.productChangeStatusLastChangedDt == rhs.productChangeStatusLastChangedDt)||((this.productChangeStatusLastChangedDt!= null)&&this.productChangeStatusLastChangedDt.equals(rhs.productChangeStatusLastChangedDt))))&&((this.agreementClosedStatusLastChangedDt == rhs.agreementClosedStatusLastChangedDt)||((this.agreementClosedStatusLastChangedDt!= null)&&this.agreementClosedStatusLastChangedDt.equals(rhs.agreementClosedStatusLastChangedDt))))&&((this.creditBureauStatusLastChangedDt == rhs.creditBureauStatusLastChangedDt)||((this.creditBureauStatusLastChangedDt!= null)&&this.creditBureauStatusLastChangedDt.equals(rhs.creditBureauStatusLastChangedDt))))&&((this.securityFraudStatusLastChangedDt == rhs.securityFraudStatusLastChangedDt)||((this.securityFraudStatusLastChangedDt!= null)&&this.securityFraudStatusLastChangedDt.equals(rhs.securityFraudStatusLastChangedDt))))&&((this.agreementClosedStatusDt == rhs.agreementClosedStatusDt)||((this.agreementClosedStatusDt!= null)&&this.agreementClosedStatusDt.equals(rhs.agreementClosedStatusDt))))&&((this.potentialPurgeStatusLastChangedDt == rhs.potentialPurgeStatusLastChangedDt)||((this.potentialPurgeStatusLastChangedDt!= null)&&this.potentialPurgeStatusLastChangedDt.equals(rhs.potentialPurgeStatusLastChangedDt))))&&((this.creditRevokedStatusLastChangedDt == rhs.creditRevokedStatusLastChangedDt)||((this.creditRevokedStatusLastChangedDt!= null)&&this.creditRevokedStatusLastChangedDt.equals(rhs.creditRevokedStatusLastChangedDt))))&&((this.collectionStatusLastChangedDt == rhs.collectionStatusLastChangedDt)||((this.collectionStatusLastChangedDt!= null)&&this.collectionStatusLastChangedDt.equals(rhs.collectionStatusLastChangedDt))))&&((this.watchStatusLastChangedDt == rhs.watchStatusLastChangedDt)||((this.watchStatusLastChangedDt!= null)&&this.watchStatusLastChangedDt.equals(rhs.watchStatusLastChangedDt))));
    }

}
