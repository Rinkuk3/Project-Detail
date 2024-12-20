
package com.td.api.mbcapd.response.retrievecapd;

import java.util.ArrayList;
import java.util.List;

public class AgreementInquiryResponse {

    private List<Agreement> agreement = new ArrayList<Agreement>();

    public List<Agreement> getAgreement() {
        return agreement;
    }

    public void setAgreement(List<Agreement> agreement) {
        this.agreement = agreement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AgreementInquiryResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("agreement");
        sb.append('=');
        sb.append(((this.agreement == null)?"<null>":this.agreement));
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
        result = ((result* 31)+((this.agreement == null)? 0 :this.agreement.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AgreementInquiryResponse) == false) {
            return false;
        }
        AgreementInquiryResponse rhs = ((AgreementInquiryResponse) other);
        return ((this.agreement == rhs.agreement)||((this.agreement!= null)&&this.agreement.equals(rhs.agreement)));
    }

}
