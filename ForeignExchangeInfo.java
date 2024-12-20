package com.td.api.mbcca.response.account;

import java.math.BigDecimal;

import com.td.api.mbcca.shared.Cccyamt;

public class ForeignExchangeInfo {

    private Boolean foreignTransactionInd;
    private Cccyamt exchangeMarkupFeeCccyamt;
    private String markupChargeCd;
    BigDecimal conversionMarkupRate;
    private FromCccyamt fromCccyamt;

    public Boolean getForeignTransactionInd() {
        return foreignTransactionInd;
    }

    public void setForeignTransactionInd(Boolean foreignTransactionInd) {
        this.foreignTransactionInd = foreignTransactionInd;
    }

    public Cccyamt getExchangeMarkupFeeCccyamt() {
        return exchangeMarkupFeeCccyamt;
    }

    public void setExchangeMarkupFeeCccyamt(Cccyamt exchangeMarkupFeeCccyamt) {
        this.exchangeMarkupFeeCccyamt = exchangeMarkupFeeCccyamt;
    }

    public String getMarkupChargeCd() {
        return markupChargeCd;
    }

    public void setMarkupChargeCd(String markupChargeCd) {
        this.markupChargeCd = markupChargeCd;
    }

    public BigDecimal getConversionMarkupRate() {
        return conversionMarkupRate;
    }

    public void setConversionMarkupRate(BigDecimal conversionMarkupRate) {
        this.conversionMarkupRate = conversionMarkupRate;
    }

    public FromCccyamt getFromCccyamt() {
        return fromCccyamt;
    }

    public void setFromCccyamt(FromCccyamt fromCccyamt) {
        this.fromCccyamt = fromCccyamt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ForeignExchangeInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("foreignTransactionInd");
        sb.append('=');
        sb.append(((this.foreignTransactionInd == null)?"<null>":this.foreignTransactionInd));
        sb.append(',');
        sb.append("exchangeMarkupFeeCccyamt");
        sb.append('=');
        sb.append(((this.exchangeMarkupFeeCccyamt == null)?"<null>":this.exchangeMarkupFeeCccyamt));
        sb.append(',');
        sb.append("markupChargeCd");
        sb.append('=');
        sb.append(((this.markupChargeCd == null)?"<null>":this.markupChargeCd));
        sb.append(',');
        sb.append("conversionMarkupRate");
        sb.append('=');
        sb.append(((this.conversionMarkupRate == null)?"<null>":this.conversionMarkupRate));
        sb.append(',');
        sb.append("fromCccyamt");
        sb.append('=');
        sb.append(((this.fromCccyamt == null)?"<null>":this.fromCccyamt));
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
        result = ((result* 31)+((this.conversionMarkupRate == null)? 0 :this.conversionMarkupRate.hashCode()));
        result = ((result* 31)+((this.fromCccyamt == null)? 0 :this.fromCccyamt.hashCode()));
        result = ((result* 31)+((this.markupChargeCd == null)? 0 :this.markupChargeCd.hashCode()));
        result = ((result* 31)+((this.foreignTransactionInd == null)? 0 :this.foreignTransactionInd.hashCode()));
        result = ((result* 31)+((this.exchangeMarkupFeeCccyamt == null)? 0 :this.exchangeMarkupFeeCccyamt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ForeignExchangeInfo) == false) {
            return false;
        }
        ForeignExchangeInfo rhs = ((ForeignExchangeInfo) other);
        return ((((((this.conversionMarkupRate == rhs.conversionMarkupRate)||((this.conversionMarkupRate!= null)&&this.conversionMarkupRate.equals(rhs.conversionMarkupRate)))&&((this.fromCccyamt == rhs.fromCccyamt)||((this.fromCccyamt!= null)&&this.fromCccyamt.equals(rhs.fromCccyamt))))&&((this.markupChargeCd == rhs.markupChargeCd)||((this.markupChargeCd!= null)&&this.markupChargeCd.equals(rhs.markupChargeCd))))&&((this.foreignTransactionInd == rhs.foreignTransactionInd)||((this.foreignTransactionInd!= null)&&this.foreignTransactionInd.equals(rhs.foreignTransactionInd))))&&((this.exchangeMarkupFeeCccyamt == rhs.exchangeMarkupFeeCccyamt)||((this.exchangeMarkupFeeCccyamt!= null)&&this.exchangeMarkupFeeCccyamt.equals(rhs.exchangeMarkupFeeCccyamt))));
    }

}
