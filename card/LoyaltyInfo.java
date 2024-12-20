package com.td.api.mbcca.response.card;

public class LoyaltyInfo {

    private String programCd;
    private String accountNum;

    public String getProgramCd() {
        return programCd;
    }

    public void setProgramCd(String programCd) {
        this.programCd = programCd;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LoyaltyInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("programCd");
        sb.append('=');
        sb.append(((this.programCd == null)?"<null>":this.programCd));
        sb.append(',');
        sb.append("accountNum");
        sb.append('=');
        sb.append(((this.accountNum == null)?"<null>":this.accountNum));
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
        result = ((result* 31)+((this.programCd == null)? 0 :this.programCd.hashCode()));
        result = ((result* 31)+((this.accountNum == null)? 0 :this.accountNum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LoyaltyInfo) == false) {
            return false;
        }
        LoyaltyInfo rhs = ((LoyaltyInfo) other);
        return (((this.programCd == rhs.programCd)||((this.programCd!= null)&&this.programCd.equals(rhs.programCd)))&&((this.accountNum == rhs.accountNum)||((this.accountNum!= null)&&this.accountNum.equals(rhs.accountNum))));
    }

}
