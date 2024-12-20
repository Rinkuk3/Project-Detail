package com.td.api.mbcca.response.account.featureview;

import java.util.ArrayList;
import java.util.List;

import com.td.api.mbcca.shared.Cccyamt;

public class AnnualFee {

    private Cccyamt lastAssessedCccyamt;
    private Cccyamt overrideCccyamt;
    private String nextAssessmentDt;
    private String renewalMonthNum;
    private String lastAssessedDt;
    private String lastUpdateDt;
    private List<CardReceiptVerificationNextAnnualFee> cardReceiptVerificationNextAnnualFee = new ArrayList<CardReceiptVerificationNextAnnualFee>();

    public Cccyamt getLastAssessedCccyamt() {
        return lastAssessedCccyamt;
    }

    public void setLastAssessedCccyamt(Cccyamt lastAssessedCccyamt) {
        this.lastAssessedCccyamt = lastAssessedCccyamt;
    }

    public Cccyamt getOverrideCccyamt() {
        return overrideCccyamt;
    }

    public void setOverrideCccyamt(Cccyamt overrideCccyamt) {
        this.overrideCccyamt = overrideCccyamt;
    }

    public String getNextAssessmentDt() {
        return nextAssessmentDt;
    }

    public void setNextAssessmentDt(String nextAssessmentDt) {
        this.nextAssessmentDt = nextAssessmentDt;
    }

    public String getRenewalMonthNum() {
        return renewalMonthNum;
    }

    public void setRenewalMonthNum(String renewalMonthNum) {
        this.renewalMonthNum = renewalMonthNum;
    }

    public String getLastAssessedDt() {
        return lastAssessedDt;
    }

    public void setLastAssessedDt(String lastAssessedDt) {
        this.lastAssessedDt = lastAssessedDt;
    }

    public String getLastUpdateDt() {
        return lastUpdateDt;
    }

    public void setLastUpdateDt(String lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    public List<CardReceiptVerificationNextAnnualFee> getCardReceiptVerificationNextAnnualFee() {
        return cardReceiptVerificationNextAnnualFee;
    }

    public void setCardReceiptVerificationNextAnnualFee(List<CardReceiptVerificationNextAnnualFee> cardReceiptVerificationNextAnnualFee) {
        this.cardReceiptVerificationNextAnnualFee = cardReceiptVerificationNextAnnualFee;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AnnualFee.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("lastAssessedCccyamt");
        sb.append('=');
        sb.append(((this.lastAssessedCccyamt == null)?"<null>":this.lastAssessedCccyamt));
        sb.append(',');
        sb.append("overrideCccyamt");
        sb.append('=');
        sb.append(((this.overrideCccyamt == null)?"<null>":this.overrideCccyamt));
        sb.append(',');
        sb.append("nextAssessmentDt");
        sb.append('=');
        sb.append(((this.nextAssessmentDt == null)?"<null>":this.nextAssessmentDt));
        sb.append(',');
        sb.append("renewalMonthNum");
        sb.append('=');
        sb.append(((this.renewalMonthNum == null)?"<null>":this.renewalMonthNum));
        sb.append(',');
        sb.append("lastAssessedDt");
        sb.append('=');
        sb.append(((this.lastAssessedDt == null)?"<null>":this.lastAssessedDt));
        sb.append(',');
        sb.append("lastUpdateDt");
        sb.append('=');
        sb.append(((this.lastUpdateDt == null)?"<null>":this.lastUpdateDt));
        sb.append(',');
        sb.append("cardReceiptVerificationNextAnnualFee");
        sb.append('=');
        sb.append(((this.cardReceiptVerificationNextAnnualFee == null)?"<null>":this.cardReceiptVerificationNextAnnualFee));
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
        result = ((result* 31)+((this.lastUpdateDt == null)? 0 :this.lastUpdateDt.hashCode()));
        result = ((result* 31)+((this.overrideCccyamt == null)? 0 :this.overrideCccyamt.hashCode()));
        result = ((result* 31)+((this.nextAssessmentDt == null)? 0 :this.nextAssessmentDt.hashCode()));
        result = ((result* 31)+((this.lastAssessedCccyamt == null)? 0 :this.lastAssessedCccyamt.hashCode()));
        result = ((result* 31)+((this.cardReceiptVerificationNextAnnualFee == null)? 0 :this.cardReceiptVerificationNextAnnualFee.hashCode()));
        result = ((result* 31)+((this.renewalMonthNum == null)? 0 :this.renewalMonthNum.hashCode()));
        result = ((result* 31)+((this.lastAssessedDt == null)? 0 :this.lastAssessedDt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AnnualFee) == false) {
            return false;
        }
        AnnualFee rhs = ((AnnualFee) other);
        return ((((((((this.lastUpdateDt == rhs.lastUpdateDt)||((this.lastUpdateDt!= null)&&this.lastUpdateDt.equals(rhs.lastUpdateDt)))&&((this.overrideCccyamt == rhs.overrideCccyamt)||((this.overrideCccyamt!= null)&&this.overrideCccyamt.equals(rhs.overrideCccyamt))))&&((this.nextAssessmentDt == rhs.nextAssessmentDt)||((this.nextAssessmentDt!= null)&&this.nextAssessmentDt.equals(rhs.nextAssessmentDt))))&&((this.lastAssessedCccyamt == rhs.lastAssessedCccyamt)||((this.lastAssessedCccyamt!= null)&&this.lastAssessedCccyamt.equals(rhs.lastAssessedCccyamt))))&&((this.cardReceiptVerificationNextAnnualFee == rhs.cardReceiptVerificationNextAnnualFee)||((this.cardReceiptVerificationNextAnnualFee!= null)&&this.cardReceiptVerificationNextAnnualFee.equals(rhs.cardReceiptVerificationNextAnnualFee))))&&((this.renewalMonthNum == rhs.renewalMonthNum)||((this.renewalMonthNum!= null)&&this.renewalMonthNum.equals(rhs.renewalMonthNum))))&&((this.lastAssessedDt == rhs.lastAssessedDt)||((this.lastAssessedDt!= null)&&this.lastAssessedDt.equals(rhs.lastAssessedDt))));
    }

}
