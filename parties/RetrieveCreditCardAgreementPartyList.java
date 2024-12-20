package com.td.api.mbcca.response.account.parties;

import java.util.ArrayList;
import java.util.List;

import com.td.api.mbcca.response.account.CreditCardAgreementToParty;
import com.td.api.mbcca.shared.Status;

public class RetrieveCreditCardAgreementPartyList {

    private Status status;
    private List<CreditCardAgreementToParty> creditCardAgreementToParty = new ArrayList<CreditCardAgreementToParty>();

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<CreditCardAgreementToParty> getCreditCardAgreementToParty() {
        return creditCardAgreementToParty;
    }

    public void setCreditCardAgreementToParty(List<CreditCardAgreementToParty> creditCardAgreementToParty) {
        this.creditCardAgreementToParty = creditCardAgreementToParty;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RetrieveCreditCardAgreementPartyList.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("creditCardAgreementToParty");
        sb.append('=');
        sb.append(((this.creditCardAgreementToParty == null)?"<null>":this.creditCardAgreementToParty));
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
        result = ((result* 31)+((this.creditCardAgreementToParty == null)? 0 :this.creditCardAgreementToParty.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RetrieveCreditCardAgreementPartyList) == false) {
            return false;
        }
        RetrieveCreditCardAgreementPartyList rhs = ((RetrieveCreditCardAgreementPartyList) other);
        return (((this.creditCardAgreementToParty == rhs.creditCardAgreementToParty)||((this.creditCardAgreementToParty!= null)&&this.creditCardAgreementToParty.equals(rhs.creditCardAgreementToParty)))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

}
