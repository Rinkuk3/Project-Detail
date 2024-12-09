package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class CustomerIncomeInfoType implements Serializable {

	private static final long serialVersionUID = -2639476678813386228L;
    private String occupation;
    private java.math.BigDecimal income;
    private String incomeFrequency;
    private String housingStatus;
    private java.math.BigDecimal housingPayment;
    private java.math.BigDecimal additionalIncome;
    private String additionalIncomeFrequency;
    private String additionalIncomeSource;

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public java.math.BigDecimal getIncome() {
        return income;
    }

    public void setIncome(java.math.BigDecimal income) {
        this.income = income;
    }

    public String getIncomeFrequency() {
        return incomeFrequency;
    }

    public void setIncomeFrequency(String incomeFrequency) {
        this.incomeFrequency = incomeFrequency;
    }

    public String getHousingStatus() {
        return housingStatus;
    }

    public void setHousingStatus(String housingStatus) {
        this.housingStatus = housingStatus;
    }

    public java.math.BigDecimal getHousingPayment() {
        return housingPayment;
    }

    public void setHousingPayment(java.math.BigDecimal housingPayment) {
        this.housingPayment = housingPayment;
    }

    public java.math.BigDecimal getAdditionalIncome() {
        return additionalIncome;
    }

    public void setAdditionalIncome(java.math.BigDecimal additionalIncome) {
        this.additionalIncome = additionalIncome;
    }

    public String getAdditionalIncomeFrequency() {
        return additionalIncomeFrequency;
    }

    public void setAdditionalIncomeFrequency(String additionalIncomeFrequency) {
        this.additionalIncomeFrequency = additionalIncomeFrequency;
    }

    public String getAdditionalIncomeSource() {
        return additionalIncomeSource;
    }

    public void setAdditionalIncomeSource(String additionalIncomeSource) {
        this.additionalIncomeSource = additionalIncomeSource;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CustomerIncomeInfoType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("occupation");
        sb.append('=');
        sb.append(((this.occupation == null)?"<null>":this.occupation));
        sb.append(',');
        sb.append("income");
        sb.append('=');
        sb.append(((this.income == null)?"<null>":this.income));
        sb.append(',');
        sb.append("incomeFrequency");
        sb.append('=');
        sb.append(((this.incomeFrequency == null)?"<null>":this.incomeFrequency));
        sb.append(',');
        sb.append("housingStatus");
        sb.append('=');
        sb.append(((this.housingStatus == null)?"<null>":this.housingStatus));
        sb.append(',');
        sb.append("housingPayment");
        sb.append('=');
        sb.append(((this.housingPayment == null)?"<null>":this.housingPayment));
        sb.append(',');
        sb.append("additionalIncome");
        sb.append('=');
        sb.append(((this.additionalIncome == null)?"<null>":this.additionalIncome));
        sb.append(',');
        sb.append("additionalIncomeFrequency");
        sb.append('=');
        sb.append(((this.additionalIncomeFrequency == null)?"<null>":this.additionalIncomeFrequency));
        sb.append(',');
        sb.append("additionalIncomeSource");
        sb.append('=');
        sb.append(((this.additionalIncomeSource == null)?"<null>":this.additionalIncomeSource));
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
        result = ((result* 31)+((this.income == null)? 0 :this.income.hashCode()));
        result = ((result* 31)+((this.housingPayment == null)? 0 :this.housingPayment.hashCode()));
        result = ((result* 31)+((this.occupation == null)? 0 :this.occupation.hashCode()));
        result = ((result* 31)+((this.housingStatus == null)? 0 :this.housingStatus.hashCode()));
        result = ((result* 31)+((this.additionalIncomeFrequency == null)? 0 :this.additionalIncomeFrequency.hashCode()));
        result = ((result* 31)+((this.additionalIncomeSource == null)? 0 :this.additionalIncomeSource.hashCode()));
        result = ((result* 31)+((this.additionalIncome == null)? 0 :this.additionalIncome.hashCode()));
        result = ((result* 31)+((this.incomeFrequency == null)? 0 :this.incomeFrequency.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerIncomeInfoType) == false) {
            return false;
        }
        CustomerIncomeInfoType rhs = ((CustomerIncomeInfoType) other);
        return (((((((((this.income == rhs.income)||((this.income!= null)&&this.income.equals(rhs.income)))&&((this.housingPayment == rhs.housingPayment)||((this.housingPayment!= null)&&this.housingPayment.equals(rhs.housingPayment))))&&((this.occupation == rhs.occupation)||((this.occupation!= null)&&this.occupation.equals(rhs.occupation))))&&((this.housingStatus == rhs.housingStatus)||((this.housingStatus!= null)&&this.housingStatus.equals(rhs.housingStatus))))&&((this.additionalIncomeFrequency == rhs.additionalIncomeFrequency)||((this.additionalIncomeFrequency!= null)&&this.additionalIncomeFrequency.equals(rhs.additionalIncomeFrequency))))&&((this.additionalIncomeSource == rhs.additionalIncomeSource)||((this.additionalIncomeSource!= null)&&this.additionalIncomeSource.equals(rhs.additionalIncomeSource))))&&((this.additionalIncome == rhs.additionalIncome)||((this.additionalIncome!= null)&&this.additionalIncome.equals(rhs.additionalIncome))))&&((this.incomeFrequency == rhs.incomeFrequency)||((this.incomeFrequency!= null)&&this.incomeFrequency.equals(rhs.incomeFrequency))));
    }

}
