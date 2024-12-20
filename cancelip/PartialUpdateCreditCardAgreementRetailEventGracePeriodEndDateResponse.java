package com.td.api.mbcca.response.cancelip;

import com.td.api.mbcca.shared.Status;

public class PartialUpdateCreditCardAgreementRetailEventGracePeriodEndDateResponse {

    private Status status;
    private String earlyExpirationReasonCd;
    private Boolean instalmentPlanFeeRefundInd;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getEarlyExpirationReasonCd() {
        return earlyExpirationReasonCd;
    }

    public void setEarlyExpirationReasonCd(String earlyExpirationReasonCd) {
        this.earlyExpirationReasonCd = earlyExpirationReasonCd;
    }

    public Boolean getInstalmentPlanFeeRefundInd() {
        return instalmentPlanFeeRefundInd;
    }

    public void setInstalmentPlanFeeRefundInd(Boolean instalmentPlanFeeRefundInd) {
        this.instalmentPlanFeeRefundInd = instalmentPlanFeeRefundInd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PartialUpdateCreditCardAgreementRetailEventGracePeriodEndDateResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("earlyExpirationReasonCd");
        sb.append('=');
        sb.append(((this.earlyExpirationReasonCd == null)?"<null>":this.earlyExpirationReasonCd));
        sb.append(',');
        sb.append("instalmentPlanFeeRefundInd");
        sb.append('=');
        sb.append(((this.instalmentPlanFeeRefundInd == null)?"<null>":this.instalmentPlanFeeRefundInd));
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
        result = ((result* 31)+((this.instalmentPlanFeeRefundInd == null)? 0 :this.instalmentPlanFeeRefundInd.hashCode()));
        result = ((result* 31)+((this.earlyExpirationReasonCd == null)? 0 :this.earlyExpirationReasonCd.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PartialUpdateCreditCardAgreementRetailEventGracePeriodEndDateResponse) == false) {
            return false;
        }
        PartialUpdateCreditCardAgreementRetailEventGracePeriodEndDateResponse rhs = ((PartialUpdateCreditCardAgreementRetailEventGracePeriodEndDateResponse) other);
        return ((((this.instalmentPlanFeeRefundInd == rhs.instalmentPlanFeeRefundInd)||((this.instalmentPlanFeeRefundInd!= null)&&this.instalmentPlanFeeRefundInd.equals(rhs.instalmentPlanFeeRefundInd)))&&((this.earlyExpirationReasonCd == rhs.earlyExpirationReasonCd)||((this.earlyExpirationReasonCd!= null)&&this.earlyExpirationReasonCd.equals(rhs.earlyExpirationReasonCd))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

}
