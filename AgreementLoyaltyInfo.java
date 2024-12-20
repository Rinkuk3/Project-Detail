package com.td.api.mbcca.response.account;

import java.util.ArrayList;
import java.util.List;

public class AgreementLoyaltyInfo {

    private boolean enrolledInd;
    private List<AccountRewardQualifierInfo> accountRewardQualifierInfo = new ArrayList<AccountRewardQualifierInfo>();

    public boolean getEnrolledInd() {
        return enrolledInd;
    }

    public void setEnrolledInd(boolean enrolledInd) {
        this.enrolledInd = enrolledInd;
    }

    public List<AccountRewardQualifierInfo> getAccountRewardQualifierInfo() {
        return accountRewardQualifierInfo;
    }

    public void setAccountRewardQualifierInfo(List<AccountRewardQualifierInfo> accountRewardQualifierInfo) {
        this.accountRewardQualifierInfo = accountRewardQualifierInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AgreementLoyaltyInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("enrolledInd");
        sb.append('=');
        sb.append(this.enrolledInd);
        sb.append(',');
        sb.append("accountRewardQualifierInfo");
        sb.append('=');
        sb.append(((this.accountRewardQualifierInfo == null)?"<null>":this.accountRewardQualifierInfo));
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
        result = ((result* 31)+((this.enrolledInd) ? 0 : 1));
        result = ((result* 31)+((this.accountRewardQualifierInfo == null)? 0 :this.accountRewardQualifierInfo.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AgreementLoyaltyInfo) == false) {
            return false;
        }
        AgreementLoyaltyInfo rhs = ((AgreementLoyaltyInfo) other);
        return ((this.enrolledInd == rhs.enrolledInd)&&((this.accountRewardQualifierInfo == rhs.accountRewardQualifierInfo)||((this.accountRewardQualifierInfo!= null)&&this.accountRewardQualifierInfo.equals(rhs.accountRewardQualifierInfo))));
    }

}
