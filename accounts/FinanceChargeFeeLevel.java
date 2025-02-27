package com.td.api.mbcca.response.account;

import java.math.BigDecimal;

import com.td.api.mbcca.shared.Cccyamt;

public class FinanceChargeFeeLevel {

    private String termBalanceCd;
    BigDecimal aprRate;
    private String aprTypeCd;
    BigDecimal spreadRate;
    BigDecimal upperLimitRate;
    BigDecimal lowerLimitRate;
    BigDecimal interestIndexRate;
    private String interestCalculationTypeCd;
    private String termBalanceDesc;
    private Cccyamt minimumFinancialChargeCccyamt;
    BigDecimal lastStatementAPRRate;
    BigDecimal futureAPRRate;
    BigDecimal periodicRate;

    public String getTermBalanceCd() {
        return termBalanceCd;
    }

    public void setTermBalanceCd(String termBalanceCd) {
        this.termBalanceCd = termBalanceCd;
    }

    public BigDecimal getAprRate() {
        return aprRate;
    }

    public void setAprRate(BigDecimal aprRate) {
        this.aprRate = aprRate;
    }

    public String getAprTypeCd() {
        return aprTypeCd;
    }

    public void setAprTypeCd(String aprTypeCd) {
        this.aprTypeCd = aprTypeCd;
    }

    public BigDecimal getSpreadRate() {
        return spreadRate;
    }

    public void setSpreadRate(BigDecimal spreadRate) {
        this.spreadRate = spreadRate;
    }

    public BigDecimal getUpperLimitRate() {
        return upperLimitRate;
    }

    public void setUpperLimitRate(BigDecimal upperLimitRate) {
        this.upperLimitRate = upperLimitRate;
    }

    public BigDecimal getLowerLimitRate() {
        return lowerLimitRate;
    }

    public void setLowerLimitRate(BigDecimal lowerLimitRate) {
        this.lowerLimitRate = lowerLimitRate;
    }

    public BigDecimal getInterestIndexRate() {
        return interestIndexRate;
    }

    public void setInterestIndexRate(BigDecimal interestIndexRate) {
        this.interestIndexRate = interestIndexRate;
    }

    public String getInterestCalculationTypeCd() {
        return interestCalculationTypeCd;
    }

    public void setInterestCalculationTypeCd(String interestCalculationTypeCd) {
        this.interestCalculationTypeCd = interestCalculationTypeCd;
    }

    public String getTermBalanceDesc() {
        return termBalanceDesc;
    }

    public void setTermBalanceDesc(String termBalanceDesc) {
        this.termBalanceDesc = termBalanceDesc;
    }

    public Cccyamt getMinimumFinancialChargeCccyamt() {
        return minimumFinancialChargeCccyamt;
    }

    public void setMinimumFinancialChargeCccyamt(Cccyamt minimumFinancialChargeCccyamt) {
        this.minimumFinancialChargeCccyamt = minimumFinancialChargeCccyamt;
    }

    public BigDecimal getLastStatementAPRRate() {
        return lastStatementAPRRate;
    }

    public void setLastStatementAPRRate(BigDecimal lastStatementAPRRate) {
        this.lastStatementAPRRate = lastStatementAPRRate;
    }

    public BigDecimal getFutureAPRRate() {
        return futureAPRRate;
    }

    public void setFutureAPRRate(BigDecimal futureAPRRate) {
        this.futureAPRRate = futureAPRRate;
    }

    public BigDecimal getPeriodicRate() {
        return periodicRate;
    }

    public void setPeriodicRate(BigDecimal periodicRate) {
        this.periodicRate = periodicRate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FinanceChargeFeeLevel.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("termBalanceCd");
        sb.append('=');
        sb.append(((this.termBalanceCd == null)?"<null>":this.termBalanceCd));
        sb.append(',');
        sb.append("aprRate");
        sb.append('=');
        sb.append(((this.aprRate == null)?"<null>":this.aprRate));
        sb.append(',');
        sb.append("aprTypeCd");
        sb.append('=');
        sb.append(((this.aprTypeCd == null)?"<null>":this.aprTypeCd));
        sb.append(',');
        sb.append("spreadRate");
        sb.append('=');
        sb.append(((this.spreadRate == null)?"<null>":this.spreadRate));
        sb.append(',');
        sb.append("upperLimitRate");
        sb.append('=');
        sb.append(((this.upperLimitRate == null)?"<null>":this.upperLimitRate));
        sb.append(',');
        sb.append("lowerLimitRate");
        sb.append('=');
        sb.append(((this.lowerLimitRate == null)?"<null>":this.lowerLimitRate));
        sb.append(',');
        sb.append("interestIndexRate");
        sb.append('=');
        sb.append(((this.interestIndexRate == null)?"<null>":this.interestIndexRate));
        sb.append(',');
        sb.append("interestCalculationTypeCd");
        sb.append('=');
        sb.append(((this.interestCalculationTypeCd == null)?"<null>":this.interestCalculationTypeCd));
        sb.append(',');
        sb.append("termBalanceDesc");
        sb.append('=');
        sb.append(((this.termBalanceDesc == null)?"<null>":this.termBalanceDesc));
        sb.append(',');
        sb.append("minimumFinancialChargeCccyamt");
        sb.append('=');
        sb.append(((this.minimumFinancialChargeCccyamt == null)?"<null>":this.minimumFinancialChargeCccyamt));
        sb.append(',');
        sb.append("lastStatementAPRRate");
        sb.append('=');
        sb.append(((this.lastStatementAPRRate == null)?"<null>":this.lastStatementAPRRate));
        sb.append(',');
        sb.append("futureAPRRate");
        sb.append('=');
        sb.append(((this.futureAPRRate == null)?"<null>":this.futureAPRRate));
        sb.append(',');
        sb.append("periodicRate");
        sb.append('=');
        sb.append(((this.periodicRate == null)?"<null>":this.periodicRate));
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
        result = ((result* 31)+((this.interestIndexRate == null)? 0 :this.interestIndexRate.hashCode()));
        result = ((result* 31)+((this.interestCalculationTypeCd == null)? 0 :this.interestCalculationTypeCd.hashCode()));
        result = ((result* 31)+((this.spreadRate == null)? 0 :this.spreadRate.hashCode()));
        result = ((result* 31)+((this.futureAPRRate == null)? 0 :this.futureAPRRate.hashCode()));
        result = ((result* 31)+((this.periodicRate == null)? 0 :this.periodicRate.hashCode()));
        result = ((result* 31)+((this.aprRate == null)? 0 :this.aprRate.hashCode()));
        result = ((result* 31)+((this.termBalanceDesc == null)? 0 :this.termBalanceDesc.hashCode()));
        result = ((result* 31)+((this.aprTypeCd == null)? 0 :this.aprTypeCd.hashCode()));
        result = ((result* 31)+((this.lastStatementAPRRate == null)? 0 :this.lastStatementAPRRate.hashCode()));
        result = ((result* 31)+((this.lowerLimitRate == null)? 0 :this.lowerLimitRate.hashCode()));
        result = ((result* 31)+((this.upperLimitRate == null)? 0 :this.upperLimitRate.hashCode()));
        result = ((result* 31)+((this.minimumFinancialChargeCccyamt == null)? 0 :this.minimumFinancialChargeCccyamt.hashCode()));
        result = ((result* 31)+((this.termBalanceCd == null)? 0 :this.termBalanceCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FinanceChargeFeeLevel) == false) {
            return false;
        }
        FinanceChargeFeeLevel rhs = ((FinanceChargeFeeLevel) other);
        return ((((((((((((((this.interestIndexRate == rhs.interestIndexRate)||((this.interestIndexRate!= null)&&this.interestIndexRate.equals(rhs.interestIndexRate)))&&((this.interestCalculationTypeCd == rhs.interestCalculationTypeCd)||((this.interestCalculationTypeCd!= null)&&this.interestCalculationTypeCd.equals(rhs.interestCalculationTypeCd))))&&((this.spreadRate == rhs.spreadRate)||((this.spreadRate!= null)&&this.spreadRate.equals(rhs.spreadRate))))&&((this.futureAPRRate == rhs.futureAPRRate)||((this.futureAPRRate!= null)&&this.futureAPRRate.equals(rhs.futureAPRRate))))&&((this.periodicRate == rhs.periodicRate)||((this.periodicRate!= null)&&this.periodicRate.equals(rhs.periodicRate))))&&((this.aprRate == rhs.aprRate)||((this.aprRate!= null)&&this.aprRate.equals(rhs.aprRate))))&&((this.termBalanceDesc == rhs.termBalanceDesc)||((this.termBalanceDesc!= null)&&this.termBalanceDesc.equals(rhs.termBalanceDesc))))&&((this.aprTypeCd == rhs.aprTypeCd)||((this.aprTypeCd!= null)&&this.aprTypeCd.equals(rhs.aprTypeCd))))&&((this.lastStatementAPRRate == rhs.lastStatementAPRRate)||((this.lastStatementAPRRate!= null)&&this.lastStatementAPRRate.equals(rhs.lastStatementAPRRate))))&&((this.lowerLimitRate == rhs.lowerLimitRate)||((this.lowerLimitRate!= null)&&this.lowerLimitRate.equals(rhs.lowerLimitRate))))&&((this.upperLimitRate == rhs.upperLimitRate)||((this.upperLimitRate!= null)&&this.upperLimitRate.equals(rhs.upperLimitRate))))&&((this.minimumFinancialChargeCccyamt == rhs.minimumFinancialChargeCccyamt)||((this.minimumFinancialChargeCccyamt!= null)&&this.minimumFinancialChargeCccyamt.equals(rhs.minimumFinancialChargeCccyamt))))&&((this.termBalanceCd == rhs.termBalanceCd)||((this.termBalanceCd!= null)&&this.termBalanceCd.equals(rhs.termBalanceCd))));
    }

}
