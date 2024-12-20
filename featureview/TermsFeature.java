package com.td.api.mbcca.response.account.featureview;

import java.util.ArrayList;
import java.util.List;

public class TermsFeature {

    private String lastUpdateDt;
    private String agreementFeeFeatureId;
    private String transactionFeeFeatureId;
    private String membershipFeeFeatureId;
    private String triadPendingAgreementFeeFeatureId;
    private String triadPendingTransactionFeeFeatureId;
    private String triadPendingMembershipFeeFeatureId;
    private String featureGroupId;
    private List<TermBalance> termBalance = new ArrayList<TermBalance>();

    public String getLastUpdateDt() {
        return lastUpdateDt;
    }

    public void setLastUpdateDt(String lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    public String getAgreementFeeFeatureId() {
        return agreementFeeFeatureId;
    }

    public void setAgreementFeeFeatureId(String agreementFeeFeatureId) {
        this.agreementFeeFeatureId = agreementFeeFeatureId;
    }

    public String getTransactionFeeFeatureId() {
        return transactionFeeFeatureId;
    }

    public void setTransactionFeeFeatureId(String transactionFeeFeatureId) {
        this.transactionFeeFeatureId = transactionFeeFeatureId;
    }

    public String getMembershipFeeFeatureId() {
        return membershipFeeFeatureId;
    }

    public void setMembershipFeeFeatureId(String membershipFeeFeatureId) {
        this.membershipFeeFeatureId = membershipFeeFeatureId;
    }

    public String getTriadPendingAgreementFeeFeatureId() {
        return triadPendingAgreementFeeFeatureId;
    }

    public void setTriadPendingAgreementFeeFeatureId(String triadPendingAgreementFeeFeatureId) {
        this.triadPendingAgreementFeeFeatureId = triadPendingAgreementFeeFeatureId;
    }

    public String getTriadPendingTransactionFeeFeatureId() {
        return triadPendingTransactionFeeFeatureId;
    }

    public void setTriadPendingTransactionFeeFeatureId(String triadPendingTransactionFeeFeatureId) {
        this.triadPendingTransactionFeeFeatureId = triadPendingTransactionFeeFeatureId;
    }

    public String getTriadPendingMembershipFeeFeatureId() {
        return triadPendingMembershipFeeFeatureId;
    }

    public void setTriadPendingMembershipFeeFeatureId(String triadPendingMembershipFeeFeatureId) {
        this.triadPendingMembershipFeeFeatureId = triadPendingMembershipFeeFeatureId;
    }

    public String getFeatureGroupId() {
        return featureGroupId;
    }

    public void setFeatureGroupId(String featureGroupId) {
        this.featureGroupId = featureGroupId;
    }

    public List<TermBalance> getTermBalance() {
        return termBalance;
    }

    public void setTermBalance(List<TermBalance> termBalance) {
        this.termBalance = termBalance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TermsFeature.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("lastUpdateDt");
        sb.append('=');
        sb.append(((this.lastUpdateDt == null)?"<null>":this.lastUpdateDt));
        sb.append(',');
        sb.append("agreementFeeFeatureId");
        sb.append('=');
        sb.append(((this.agreementFeeFeatureId == null)?"<null>":this.agreementFeeFeatureId));
        sb.append(',');
        sb.append("transactionFeeFeatureId");
        sb.append('=');
        sb.append(((this.transactionFeeFeatureId == null)?"<null>":this.transactionFeeFeatureId));
        sb.append(',');
        sb.append("membershipFeeFeatureId");
        sb.append('=');
        sb.append(((this.membershipFeeFeatureId == null)?"<null>":this.membershipFeeFeatureId));
        sb.append(',');
        sb.append("triadPendingAgreementFeeFeatureId");
        sb.append('=');
        sb.append(((this.triadPendingAgreementFeeFeatureId == null)?"<null>":this.triadPendingAgreementFeeFeatureId));
        sb.append(',');
        sb.append("triadPendingTransactionFeeFeatureId");
        sb.append('=');
        sb.append(((this.triadPendingTransactionFeeFeatureId == null)?"<null>":this.triadPendingTransactionFeeFeatureId));
        sb.append(',');
        sb.append("triadPendingMembershipFeeFeatureId");
        sb.append('=');
        sb.append(((this.triadPendingMembershipFeeFeatureId == null)?"<null>":this.triadPendingMembershipFeeFeatureId));
        sb.append(',');
        sb.append("featureGroupId");
        sb.append('=');
        sb.append(((this.featureGroupId == null)?"<null>":this.featureGroupId));
        sb.append(',');
        sb.append("termBalance");
        sb.append('=');
        sb.append(((this.termBalance == null)?"<null>":this.termBalance));
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
        result = ((result* 31)+((this.agreementFeeFeatureId == null)? 0 :this.agreementFeeFeatureId.hashCode()));
        result = ((result* 31)+((this.featureGroupId == null)? 0 :this.featureGroupId.hashCode()));
        result = ((result* 31)+((this.triadPendingTransactionFeeFeatureId == null)? 0 :this.triadPendingTransactionFeeFeatureId.hashCode()));
        result = ((result* 31)+((this.termBalance == null)? 0 :this.termBalance.hashCode()));
        result = ((result* 31)+((this.lastUpdateDt == null)? 0 :this.lastUpdateDt.hashCode()));
        result = ((result* 31)+((this.transactionFeeFeatureId == null)? 0 :this.transactionFeeFeatureId.hashCode()));
        result = ((result* 31)+((this.membershipFeeFeatureId == null)? 0 :this.membershipFeeFeatureId.hashCode()));
        result = ((result* 31)+((this.triadPendingAgreementFeeFeatureId == null)? 0 :this.triadPendingAgreementFeeFeatureId.hashCode()));
        result = ((result* 31)+((this.triadPendingMembershipFeeFeatureId == null)? 0 :this.triadPendingMembershipFeeFeatureId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TermsFeature) == false) {
            return false;
        }
        TermsFeature rhs = ((TermsFeature) other);
        return ((((((((((this.agreementFeeFeatureId == rhs.agreementFeeFeatureId)||((this.agreementFeeFeatureId!= null)&&this.agreementFeeFeatureId.equals(rhs.agreementFeeFeatureId)))&&((this.featureGroupId == rhs.featureGroupId)||((this.featureGroupId!= null)&&this.featureGroupId.equals(rhs.featureGroupId))))&&((this.triadPendingTransactionFeeFeatureId == rhs.triadPendingTransactionFeeFeatureId)||((this.triadPendingTransactionFeeFeatureId!= null)&&this.triadPendingTransactionFeeFeatureId.equals(rhs.triadPendingTransactionFeeFeatureId))))&&((this.termBalance == rhs.termBalance)||((this.termBalance!= null)&&this.termBalance.equals(rhs.termBalance))))&&((this.lastUpdateDt == rhs.lastUpdateDt)||((this.lastUpdateDt!= null)&&this.lastUpdateDt.equals(rhs.lastUpdateDt))))&&((this.transactionFeeFeatureId == rhs.transactionFeeFeatureId)||((this.transactionFeeFeatureId!= null)&&this.transactionFeeFeatureId.equals(rhs.transactionFeeFeatureId))))&&((this.membershipFeeFeatureId == rhs.membershipFeeFeatureId)||((this.membershipFeeFeatureId!= null)&&this.membershipFeeFeatureId.equals(rhs.membershipFeeFeatureId))))&&((this.triadPendingAgreementFeeFeatureId == rhs.triadPendingAgreementFeeFeatureId)||((this.triadPendingAgreementFeeFeatureId!= null)&&this.triadPendingAgreementFeeFeatureId.equals(rhs.triadPendingAgreementFeeFeatureId))))&&((this.triadPendingMembershipFeeFeatureId == rhs.triadPendingMembershipFeeFeatureId)||((this.triadPendingMembershipFeeFeatureId!= null)&&this.triadPendingMembershipFeeFeatureId.equals(rhs.triadPendingMembershipFeeFeatureId))));
    }

}
