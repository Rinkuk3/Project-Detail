package com.td.api.mbcca.response.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.td.api.mbcca.shared.Cccyamt;

public class TermsInfo {

    private List<FinanceChargeFeeLevel> financeChargeFeeLevel = new ArrayList<FinanceChargeFeeLevel>();
    BigDecimal minimumPaymentAmt;
    BigDecimal minimumPaymentPct;
    private Boolean subjectToChangeInTermsInd;
    private String changeInTermsDesc;
    private String checkReturnFeeDesc;
    private Cccyamt checkReturnFeeCccyamt;
    private Cccyamt paidInFullBalanceCccyamt;
    private MembershipSingleFee membershipSingleFee;
    private String annualMembershipFeeNextChargeDt;

    public List<FinanceChargeFeeLevel> getFinanceChargeFeeLevel() {
        return financeChargeFeeLevel;
    }

    public void setFinanceChargeFeeLevel(List<FinanceChargeFeeLevel> financeChargeFeeLevel) {
        this.financeChargeFeeLevel = financeChargeFeeLevel;
    }

    public BigDecimal getMinimumPaymentAmt() {
        return minimumPaymentAmt;
    }

    public void setMinimumPaymentAmt(BigDecimal minimumPaymentAmt) {
        this.minimumPaymentAmt = minimumPaymentAmt;
    }

    public BigDecimal getMinimumPaymentPct() {
        return minimumPaymentPct;
    }

    public void setMinimumPaymentPct(BigDecimal minimumPaymentPct) {
        this.minimumPaymentPct = minimumPaymentPct;
    }

    public Boolean getSubjectToChangeInTermsInd() {
        return subjectToChangeInTermsInd;
    }

    public void setSubjectToChangeInTermsInd(Boolean subjectToChangeInTermsInd) {
        this.subjectToChangeInTermsInd = subjectToChangeInTermsInd;
    }

    public String getChangeInTermsDesc() {
        return changeInTermsDesc;
    }

    public void setChangeInTermsDesc(String changeInTermsDesc) {
        this.changeInTermsDesc = changeInTermsDesc;
    }

    public String getCheckReturnFeeDesc() {
        return checkReturnFeeDesc;
    }

    public void setCheckReturnFeeDesc(String checkReturnFeeDesc) {
        this.checkReturnFeeDesc = checkReturnFeeDesc;
    }

    public Cccyamt getCheckReturnFeeCccyamt() {
        return checkReturnFeeCccyamt;
    }

    public void setCheckReturnFeeCccyamt(Cccyamt checkReturnFeeCccyamt) {
        this.checkReturnFeeCccyamt = checkReturnFeeCccyamt;
    }

    public Cccyamt getPaidInFullBalanceCccyamt() {
        return paidInFullBalanceCccyamt;
    }

    public void setPaidInFullBalanceCccyamt(Cccyamt paidInFullBalanceCccyamt) {
        this.paidInFullBalanceCccyamt = paidInFullBalanceCccyamt;
    }

    public MembershipSingleFee getMembershipSingleFee() {
        return membershipSingleFee;
    }

    public void setMembershipSingleFee(MembershipSingleFee membershipSingleFee) {
        this.membershipSingleFee = membershipSingleFee;
    }

    public String getAnnualMembershipFeeNextChargeDt() {
        return annualMembershipFeeNextChargeDt;
    }

    public void setAnnualMembershipFeeNextChargeDt(String annualMembershipFeeNextChargeDt) {
        this.annualMembershipFeeNextChargeDt = annualMembershipFeeNextChargeDt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TermsInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("financeChargeFeeLevel");
        sb.append('=');
        sb.append(((this.financeChargeFeeLevel == null)?"<null>":this.financeChargeFeeLevel));
        sb.append(',');
        sb.append("minimumPaymentAmt");
        sb.append('=');
        sb.append(((this.minimumPaymentAmt == null)?"<null>":this.minimumPaymentAmt));
        sb.append(',');
        sb.append("minimumPaymentPct");
        sb.append('=');
        sb.append(((this.minimumPaymentPct == null)?"<null>":this.minimumPaymentPct));
        sb.append(',');
        sb.append("subjectToChangeInTermsInd");
        sb.append('=');
        sb.append(((this.subjectToChangeInTermsInd == null)?"<null>":this.subjectToChangeInTermsInd));
        sb.append(',');
        sb.append("changeInTermsDesc");
        sb.append('=');
        sb.append(((this.changeInTermsDesc == null)?"<null>":this.changeInTermsDesc));
        sb.append(',');
        sb.append("checkReturnFeeDesc");
        sb.append('=');
        sb.append(((this.checkReturnFeeDesc == null)?"<null>":this.checkReturnFeeDesc));
        sb.append(',');
        sb.append("checkReturnFeeCccyamt");
        sb.append('=');
        sb.append(((this.checkReturnFeeCccyamt == null)?"<null>":this.checkReturnFeeCccyamt));
        sb.append(',');
        sb.append("paidInFullBalanceCccyamt");
        sb.append('=');
        sb.append(((this.paidInFullBalanceCccyamt == null)?"<null>":this.paidInFullBalanceCccyamt));
        sb.append(',');
        sb.append("membershipSingleFee");
        sb.append('=');
        sb.append(((this.membershipSingleFee == null)?"<null>":this.membershipSingleFee));
        sb.append(',');
        sb.append("annualMembershipFeeNextChargeDt");
        sb.append('=');
        sb.append(((this.annualMembershipFeeNextChargeDt == null)?"<null>":this.annualMembershipFeeNextChargeDt));
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
        result = ((result* 31)+((this.checkReturnFeeDesc == null)? 0 :this.checkReturnFeeDesc.hashCode()));
        result = ((result* 31)+((this.subjectToChangeInTermsInd == null)? 0 :this.subjectToChangeInTermsInd.hashCode()));
        result = ((result* 31)+((this.paidInFullBalanceCccyamt == null)? 0 :this.paidInFullBalanceCccyamt.hashCode()));
        result = ((result* 31)+((this.membershipSingleFee == null)? 0 :this.membershipSingleFee.hashCode()));
        result = ((result* 31)+((this.minimumPaymentAmt == null)? 0 :this.minimumPaymentAmt.hashCode()));
        result = ((result* 31)+((this.checkReturnFeeCccyamt == null)? 0 :this.checkReturnFeeCccyamt.hashCode()));
        result = ((result* 31)+((this.annualMembershipFeeNextChargeDt == null)? 0 :this.annualMembershipFeeNextChargeDt.hashCode()));
        result = ((result* 31)+((this.financeChargeFeeLevel == null)? 0 :this.financeChargeFeeLevel.hashCode()));
        result = ((result* 31)+((this.minimumPaymentPct == null)? 0 :this.minimumPaymentPct.hashCode()));
        result = ((result* 31)+((this.changeInTermsDesc == null)? 0 :this.changeInTermsDesc.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TermsInfo) == false) {
            return false;
        }
        TermsInfo rhs = ((TermsInfo) other);
        return (((((((((((this.checkReturnFeeDesc == rhs.checkReturnFeeDesc)||((this.checkReturnFeeDesc!= null)&&this.checkReturnFeeDesc.equals(rhs.checkReturnFeeDesc)))&&((this.subjectToChangeInTermsInd == rhs.subjectToChangeInTermsInd)||((this.subjectToChangeInTermsInd!= null)&&this.subjectToChangeInTermsInd.equals(rhs.subjectToChangeInTermsInd))))&&((this.paidInFullBalanceCccyamt == rhs.paidInFullBalanceCccyamt)||((this.paidInFullBalanceCccyamt!= null)&&this.paidInFullBalanceCccyamt.equals(rhs.paidInFullBalanceCccyamt))))&&((this.membershipSingleFee == rhs.membershipSingleFee)||((this.membershipSingleFee!= null)&&this.membershipSingleFee.equals(rhs.membershipSingleFee))))&&((this.minimumPaymentAmt == rhs.minimumPaymentAmt)||((this.minimumPaymentAmt!= null)&&this.minimumPaymentAmt.equals(rhs.minimumPaymentAmt))))&&((this.checkReturnFeeCccyamt == rhs.checkReturnFeeCccyamt)||((this.checkReturnFeeCccyamt!= null)&&this.checkReturnFeeCccyamt.equals(rhs.checkReturnFeeCccyamt))))&&((this.annualMembershipFeeNextChargeDt == rhs.annualMembershipFeeNextChargeDt)||((this.annualMembershipFeeNextChargeDt!= null)&&this.annualMembershipFeeNextChargeDt.equals(rhs.annualMembershipFeeNextChargeDt))))&&((this.financeChargeFeeLevel == rhs.financeChargeFeeLevel)||((this.financeChargeFeeLevel!= null)&&this.financeChargeFeeLevel.equals(rhs.financeChargeFeeLevel))))&&((this.minimumPaymentPct == rhs.minimumPaymentPct)||((this.minimumPaymentPct!= null)&&this.minimumPaymentPct.equals(rhs.minimumPaymentPct))))&&((this.changeInTermsDesc == rhs.changeInTermsDesc)||((this.changeInTermsDesc!= null)&&this.changeInTermsDesc.equals(rhs.changeInTermsDesc))));
    }

}
