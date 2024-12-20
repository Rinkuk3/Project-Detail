package com.td.api.mbofp.request.balancetransfer;

public class RequestDestinationDepositTransactionAgreement {

    private String branchNum;
    private String accountNum;
    private BranchAddress branchAddress;
    private String agreementPurposeSubtypeCd;

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

    public String getAgreementPurposeSubtypeCd() {
        return agreementPurposeSubtypeCd;
    }

    public void setAgreementPurposeSubtypeCd(String agreementPurposeSubtypeCd) {
        this.agreementPurposeSubtypeCd = agreementPurposeSubtypeCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestDestinationDepositTransactionAgreement.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("agreementPurposeSubtypeCd");
        sb.append('=');
        sb.append(((this.agreementPurposeSubtypeCd == null)?"<null>":this.agreementPurposeSubtypeCd));
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
        result = ((result* 31)+((this.branchNum == null)? 0 :this.branchNum.hashCode()));
        result = ((result* 31)+((this.branchAddress == null)? 0 :this.branchAddress.hashCode()));
        result = ((result* 31)+((this.agreementPurposeSubtypeCd == null)? 0 :this.agreementPurposeSubtypeCd.hashCode()));
        result = ((result* 31)+((this.accountNum == null)? 0 :this.accountNum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestDestinationDepositTransactionAgreement) == false) {
            return false;
        }
        RequestDestinationDepositTransactionAgreement rhs = ((RequestDestinationDepositTransactionAgreement) other);
        return (((((this.branchNum == rhs.branchNum)||((this.branchNum!= null)&&this.branchNum.equals(rhs.branchNum)))&&((this.branchAddress == rhs.branchAddress)||((this.branchAddress!= null)&&this.branchAddress.equals(rhs.branchAddress))))&&((this.agreementPurposeSubtypeCd == rhs.agreementPurposeSubtypeCd)||((this.agreementPurposeSubtypeCd!= null)&&this.agreementPurposeSubtypeCd.equals(rhs.agreementPurposeSubtypeCd))))&&((this.accountNum == rhs.accountNum)||((this.accountNum!= null)&&this.accountNum.equals(rhs.accountNum))));
    }

}
