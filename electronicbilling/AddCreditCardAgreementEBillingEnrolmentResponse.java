package com.td.api.mbcca.response.account.electronicbilling;

import com.td.api.mbcca.shared.Status;

public class AddCreditCardAgreementEBillingEnrolmentResponse {

    private Status status;
    private String responseTypeCd;
    private String responseReasonDesc;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getResponseTypeCd() {
        return responseTypeCd;
    }

    public void setResponseTypeCd(String responseTypeCd) {
        this.responseTypeCd = responseTypeCd;
    }

    public String getResponseReasonDesc() {
        return responseReasonDesc;
    }

    public void setResponseReasonDesc(String responseReasonDesc) {
        this.responseReasonDesc = responseReasonDesc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AddCreditCardAgreementEBillingEnrolmentResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("responseTypeCd");
        sb.append('=');
        sb.append(((this.responseTypeCd == null)?"<null>":this.responseTypeCd));
        sb.append(',');
        sb.append("responseReasonDesc");
        sb.append('=');
        sb.append(((this.responseReasonDesc == null)?"<null>":this.responseReasonDesc));
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
        result = ((result* 31)+((this.responseReasonDesc == null)? 0 :this.responseReasonDesc.hashCode()));
        result = ((result* 31)+((this.responseTypeCd == null)? 0 :this.responseTypeCd.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddCreditCardAgreementEBillingEnrolmentResponse) == false) {
            return false;
        }
        AddCreditCardAgreementEBillingEnrolmentResponse rhs = ((AddCreditCardAgreementEBillingEnrolmentResponse) other);
        return ((((this.responseReasonDesc == rhs.responseReasonDesc)||((this.responseReasonDesc!= null)&&this.responseReasonDesc.equals(rhs.responseReasonDesc)))&&((this.responseTypeCd == rhs.responseTypeCd)||((this.responseTypeCd!= null)&&this.responseTypeCd.equals(rhs.responseTypeCd))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

}
