package com.td.api.mbcca.response.account;

public class AccountRewardQualifierInfo {

    private String accountRewardQualifierCd;

    public String getAccountRewardQualifierCd() {
        return accountRewardQualifierCd;
    }

    public void setAccountRewardQualifierCd(String accountRewardQualifierCd) {
        this.accountRewardQualifierCd = accountRewardQualifierCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AccountRewardQualifierInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("accountRewardQualifierCd");
        sb.append('=');
        sb.append(((this.accountRewardQualifierCd == null)?"<null>":this.accountRewardQualifierCd));
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
        result = ((result* 31)+((this.accountRewardQualifierCd == null)? 0 :this.accountRewardQualifierCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AccountRewardQualifierInfo) == false) {
            return false;
        }
        AccountRewardQualifierInfo rhs = ((AccountRewardQualifierInfo) other);
        return ((this.accountRewardQualifierCd == rhs.accountRewardQualifierCd)||((this.accountRewardQualifierCd!= null)&&this.accountRewardQualifierCd.equals(rhs.accountRewardQualifierCd)));
    }

}
