package com.td.api.mbofp.request.balancetransfer;

public class RequestDestinationExternalBankAccount {

    private String bankNum;
    private String branchNum;
    private String accountNum;
    private BranchAddress branchAddress;
    private String bankName;
    private String accountPurposeSubtypeCd;

    public String getBankNum() {
        return bankNum;
    }

    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }

    public String getBranchNum() {
        return branchNum;
    }

    public void setBranchNum(String branchNum) {
        this.branchNum = branchNum;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public BranchAddress getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(BranchAddress branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountPurposeSubtypeCd() {
        return accountPurposeSubtypeCd;
    }

    public void setAccountPurposeSubtypeCd(String accountPurposeSubtypeCd) {
        this.accountPurposeSubtypeCd = accountPurposeSubtypeCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestDestinationExternalBankAccount.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("bankNum");
        sb.append('=');
        sb.append(((this.bankNum == null)?"<null>":this.bankNum));
        sb.append(',');
        sb.append("branchNum");
        sb.append('=');
        sb.append(((this.branchNum == null)?"<null>":this.branchNum));
        sb.append(',');
        sb.append("accountNum");
        sb.append('=');
        sb.append(((this.accountNum == null)?"<null>":this.accountNum));
        sb.append(',');
        sb.append("branchAddress");
        sb.append('=');
        sb.append(((this.branchAddress == null)?"<null>":this.branchAddress));
        sb.append(',');
        sb.append("bankName");
        sb.append('=');
        sb.append(((this.bankName == null)?"<null>":this.bankName));
        sb.append(',');
        sb.append("accountPurposeSubtypeCd");
        sb.append('=');
        sb.append(((this.accountPurposeSubtypeCd == null)?"<null>":this.accountPurposeSubtypeCd));
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
        result = ((result* 31)+((this.bankNum == null)? 0 :this.bankNum.hashCode()));
        result = ((result* 31)+((this.accountNum == null)? 0 :this.accountNum.hashCode()));
        result = ((result* 31)+((this.branchNum == null)? 0 :this.branchNum.hashCode()));
        result = ((result* 31)+((this.branchAddress == null)? 0 :this.branchAddress.hashCode()));
        result = ((result* 31)+((this.bankName == null)? 0 :this.bankName.hashCode()));
        result = ((result* 31)+((this.accountPurposeSubtypeCd == null)? 0 :this.accountPurposeSubtypeCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestDestinationExternalBankAccount) == false) {
            return false;
        }
        RequestDestinationExternalBankAccount rhs = ((RequestDestinationExternalBankAccount) other);
        return (((((((this.bankNum == rhs.bankNum)||((this.bankNum!= null)&&this.bankNum.equals(rhs.bankNum)))&&((this.accountNum == rhs.accountNum)||((this.accountNum!= null)&&this.accountNum.equals(rhs.accountNum))))&&((this.branchNum == rhs.branchNum)||((this.branchNum!= null)&&this.branchNum.equals(rhs.branchNum))))&&((this.branchAddress == rhs.branchAddress)||((this.branchAddress!= null)&&this.branchAddress.equals(rhs.branchAddress))))&&((this.bankName == rhs.bankName)||((this.bankName!= null)&&this.bankName.equals(rhs.bankName))))&&((this.accountPurposeSubtypeCd == rhs.accountPurposeSubtypeCd)||((this.accountPurposeSubtypeCd!= null)&&this.accountPurposeSubtypeCd.equals(rhs.accountPurposeSubtypeCd))));
    }

}
