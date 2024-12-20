package com.td.api.mbcca.creditcard.request;

import java.math.BigDecimal;

import com.td.api.mbcca.shared.Cccyamt;

public class AgreementLimitInfo {

    java.math.BigDecimal creditLimitChangeAmt;
    private TsysExtension tsysExtension;
    java.math.BigDecimal currentCreditLimitAmt;
    private Cccyamt newCreditLimitCccyamt;
    private String creditLimitStartDt;
    private String creditLimitEndDt;
    private Boolean deleteFutureCreditLimitInd;
    private Boolean deleteTemporaryCreditLimitInd;
    private Cccyamt cashAdvanceLimitCccyamt;
    private String cashAdvanceLimitStartDt;
    private String cashAdvanceLimitEndDt;
    private Boolean deleteCashAdvanceLimitInd;

    public BigDecimal getCreditLimitChangeAmt() {
        return creditLimitChangeAmt;
    }

    public void setCreditLimitChangeAmt(BigDecimal creditLimitChangeAmt) {
        this.creditLimitChangeAmt = creditLimitChangeAmt;
    }

    public TsysExtension getTsysExtension() {
        return tsysExtension;
    }

    public void setTsysExtension(TsysExtension tsysExtension) {
        this.tsysExtension = tsysExtension;
    }

    public BigDecimal getCurrentCreditLimitAmt() {
        return currentCreditLimitAmt;
    }

    public void setCurrentCreditLimitAmt(BigDecimal currentCreditLimitAmt) {
        this.currentCreditLimitAmt = currentCreditLimitAmt;
    }

    public Cccyamt getNewCreditLimitCccyamt() {
        return newCreditLimitCccyamt;
    }

    public void setNewCreditLimitCccyamt(Cccyamt newCreditLimitCccyamt) {
        this.newCreditLimitCccyamt = newCreditLimitCccyamt;
    }

    public String getCreditLimitStartDt() {
        return creditLimitStartDt;
    }

    public void setCreditLimitStartDt(String creditLimitStartDt) {
        this.creditLimitStartDt = creditLimitStartDt;
    }

    public String getCreditLimitEndDt() {
        return creditLimitEndDt;
    }

    public void setCreditLimitEndDt(String creditLimitEndDt) {
        this.creditLimitEndDt = creditLimitEndDt;
    }

    public Boolean getDeleteFutureCreditLimitInd() {
        return deleteFutureCreditLimitInd;
    }

    public void setDeleteFutureCreditLimitInd(Boolean deleteFutureCreditLimitInd) {
        this.deleteFutureCreditLimitInd = deleteFutureCreditLimitInd;
    }

    public Boolean getDeleteTemporaryCreditLimitInd() {
        return deleteTemporaryCreditLimitInd;
    }

    public void setDeleteTemporaryCreditLimitInd(Boolean deleteTemporaryCreditLimitInd) {
        this.deleteTemporaryCreditLimitInd = deleteTemporaryCreditLimitInd;
    }

    public Cccyamt getCashAdvanceLimitCccyamt() {
        return cashAdvanceLimitCccyamt;
    }

    public void setCashAdvanceLimitCccyamt(Cccyamt cashAdvanceLimitCccyamt) {
        this.cashAdvanceLimitCccyamt = cashAdvanceLimitCccyamt;
    }

    public String getCashAdvanceLimitStartDt() {
        return cashAdvanceLimitStartDt;
    }

    public void setCashAdvanceLimitStartDt(String cashAdvanceLimitStartDt) {
        this.cashAdvanceLimitStartDt = cashAdvanceLimitStartDt;
    }

    public String getCashAdvanceLimitEndDt() {
        return cashAdvanceLimitEndDt;
    }

    public void setCashAdvanceLimitEndDt(String cashAdvanceLimitEndDt) {
        this.cashAdvanceLimitEndDt = cashAdvanceLimitEndDt;
    }

    public Boolean getDeleteCashAdvanceLimitInd() {
        return deleteCashAdvanceLimitInd;
    }

    public void setDeleteCashAdvanceLimitInd(Boolean deleteCashAdvanceLimitInd) {
        this.deleteCashAdvanceLimitInd = deleteCashAdvanceLimitInd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AgreementLimitInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("creditLimitChangeAmt");
        sb.append('=');
        sb.append(((this.creditLimitChangeAmt == null)?"<null>":this.creditLimitChangeAmt));
        sb.append(',');
        sb.append("tsysExtension");
        sb.append('=');
        sb.append(((this.tsysExtension == null)?"<null>":this.tsysExtension));
        sb.append(',');
        sb.append("currentCreditLimitAmt");
        sb.append('=');
        sb.append(((this.currentCreditLimitAmt == null)?"<null>":this.currentCreditLimitAmt));
        sb.append(',');
        sb.append("newCreditLimitCccyamt");
        sb.append('=');
        sb.append(((this.newCreditLimitCccyamt == null)?"<null>":this.newCreditLimitCccyamt));
        sb.append(',');
        sb.append("creditLimitStartDt");
        sb.append('=');
        sb.append(((this.creditLimitStartDt == null)?"<null>":this.creditLimitStartDt));
        sb.append(',');
        sb.append("creditLimitEndDt");
        sb.append('=');
        sb.append(((this.creditLimitEndDt == null)?"<null>":this.creditLimitEndDt));
        sb.append(',');
        sb.append("deleteFutureCreditLimitInd");
        sb.append('=');
        sb.append(((this.deleteFutureCreditLimitInd == null)?"<null>":this.deleteFutureCreditLimitInd));
        sb.append(',');
        sb.append("deleteTemporaryCreditLimitInd");
        sb.append('=');
        sb.append(((this.deleteTemporaryCreditLimitInd == null)?"<null>":this.deleteTemporaryCreditLimitInd));
        sb.append(',');
        sb.append("cashAdvanceLimitCccyamt");
        sb.append('=');
        sb.append(((this.cashAdvanceLimitCccyamt == null)?"<null>":this.cashAdvanceLimitCccyamt));
        sb.append(',');
        sb.append("cashAdvanceLimitStartDt");
        sb.append('=');
        sb.append(((this.cashAdvanceLimitStartDt == null)?"<null>":this.cashAdvanceLimitStartDt));
        sb.append(',');
        sb.append("cashAdvanceLimitEndDt");
        sb.append('=');
        sb.append(((this.cashAdvanceLimitEndDt == null)?"<null>":this.cashAdvanceLimitEndDt));
        sb.append(',');
        sb.append("deleteCashAdvanceLimitInd");
        sb.append('=');
        sb.append(((this.deleteCashAdvanceLimitInd == null)?"<null>":this.deleteCashAdvanceLimitInd));
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
        result = ((result* 31)+((this.cashAdvanceLimitCccyamt == null)? 0 :this.cashAdvanceLimitCccyamt.hashCode()));
        result = ((result* 31)+((this.creditLimitEndDt == null)? 0 :this.creditLimitEndDt.hashCode()));
        result = ((result* 31)+((this.creditLimitStartDt == null)? 0 :this.creditLimitStartDt.hashCode()));
        result = ((result* 31)+((this.newCreditLimitCccyamt == null)? 0 :this.newCreditLimitCccyamt.hashCode()));
        result = ((result* 31)+((this.deleteTemporaryCreditLimitInd == null)? 0 :this.deleteTemporaryCreditLimitInd.hashCode()));
        result = ((result* 31)+((this.deleteCashAdvanceLimitInd == null)? 0 :this.deleteCashAdvanceLimitInd.hashCode()));
        result = ((result* 31)+((this.creditLimitChangeAmt == null)? 0 :this.creditLimitChangeAmt.hashCode()));
        result = ((result* 31)+((this.cashAdvanceLimitStartDt == null)? 0 :this.cashAdvanceLimitStartDt.hashCode()));
        result = ((result* 31)+((this.currentCreditLimitAmt == null)? 0 :this.currentCreditLimitAmt.hashCode()));
        result = ((result* 31)+((this.cashAdvanceLimitEndDt == null)? 0 :this.cashAdvanceLimitEndDt.hashCode()));
        result = ((result* 31)+((this.tsysExtension == null)? 0 :this.tsysExtension.hashCode()));
        result = ((result* 31)+((this.deleteFutureCreditLimitInd == null)? 0 :this.deleteFutureCreditLimitInd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AgreementLimitInfo) == false) {
            return false;
        }
        AgreementLimitInfo rhs = ((AgreementLimitInfo) other);
        return (((((((((((((this.cashAdvanceLimitCccyamt == rhs.cashAdvanceLimitCccyamt)||((this.cashAdvanceLimitCccyamt!= null)&&this.cashAdvanceLimitCccyamt.equals(rhs.cashAdvanceLimitCccyamt)))&&((this.creditLimitEndDt == rhs.creditLimitEndDt)||((this.creditLimitEndDt!= null)&&this.creditLimitEndDt.equals(rhs.creditLimitEndDt))))&&((this.creditLimitStartDt == rhs.creditLimitStartDt)||((this.creditLimitStartDt!= null)&&this.creditLimitStartDt.equals(rhs.creditLimitStartDt))))&&((this.newCreditLimitCccyamt == rhs.newCreditLimitCccyamt)||((this.newCreditLimitCccyamt!= null)&&this.newCreditLimitCccyamt.equals(rhs.newCreditLimitCccyamt))))&&((this.deleteTemporaryCreditLimitInd == rhs.deleteTemporaryCreditLimitInd)||((this.deleteTemporaryCreditLimitInd!= null)&&this.deleteTemporaryCreditLimitInd.equals(rhs.deleteTemporaryCreditLimitInd))))&&((this.deleteCashAdvanceLimitInd == rhs.deleteCashAdvanceLimitInd)||((this.deleteCashAdvanceLimitInd!= null)&&this.deleteCashAdvanceLimitInd.equals(rhs.deleteCashAdvanceLimitInd))))&&((this.creditLimitChangeAmt == rhs.creditLimitChangeAmt)||((this.creditLimitChangeAmt!= null)&&this.creditLimitChangeAmt.equals(rhs.creditLimitChangeAmt))))&&((this.cashAdvanceLimitStartDt == rhs.cashAdvanceLimitStartDt)||((this.cashAdvanceLimitStartDt!= null)&&this.cashAdvanceLimitStartDt.equals(rhs.cashAdvanceLimitStartDt))))&&((this.currentCreditLimitAmt == rhs.currentCreditLimitAmt)||((this.currentCreditLimitAmt!= null)&&this.currentCreditLimitAmt.equals(rhs.currentCreditLimitAmt))))&&((this.cashAdvanceLimitEndDt == rhs.cashAdvanceLimitEndDt)||((this.cashAdvanceLimitEndDt!= null)&&this.cashAdvanceLimitEndDt.equals(rhs.cashAdvanceLimitEndDt))))&&((this.tsysExtension == rhs.tsysExtension)||((this.tsysExtension!= null)&&this.tsysExtension.equals(rhs.tsysExtension))))&&((this.deleteFutureCreditLimitInd == rhs.deleteFutureCreditLimitInd)||((this.deleteFutureCreditLimitInd!= null)&&this.deleteFutureCreditLimitInd.equals(rhs.deleteFutureCreditLimitInd))));
    }

}
