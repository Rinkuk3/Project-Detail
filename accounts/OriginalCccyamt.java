package com.td.api.mbcca.response.account;

import java.math.BigDecimal;

import com.td.api.mbcca.shared.TsysExtensionCurrencyNumericCd;

public class OriginalCccyamt {

    BigDecimal amount;
    private String currencyCd;
    private TsysExtensionCurrencyNumericCd tsysExtension;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrencyCd() {
        return currencyCd;
    }

    public void setCurrencyCd(String currencyCd) {
        this.currencyCd = currencyCd;
    }

    public TsysExtensionCurrencyNumericCd getTsysExtension() {
        return tsysExtension;
    }

    public void setTsysExtension(TsysExtensionCurrencyNumericCd tsysExtension) {
        this.tsysExtension = tsysExtension;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(OriginalCccyamt.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("amount");
        sb.append('=');
        sb.append(((this.amount == null)?"<null>":this.amount));
        sb.append(',');
        sb.append("currencyCd");
        sb.append('=');
        sb.append(((this.currencyCd == null)?"<null>":this.currencyCd));
        sb.append(',');
        sb.append("tsysExtension");
        sb.append('=');
        sb.append(((this.tsysExtension == null)?"<null>":this.tsysExtension));
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
        result = ((result* 31)+((this.amount == null)? 0 :this.amount.hashCode()));
        result = ((result* 31)+((this.currencyCd == null)? 0 :this.currencyCd.hashCode()));
        result = ((result* 31)+((this.tsysExtension == null)? 0 :this.tsysExtension.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OriginalCccyamt) == false) {
            return false;
        }
        OriginalCccyamt rhs = ((OriginalCccyamt) other);
        return ((((this.amount == rhs.amount)||((this.amount!= null)&&this.amount.equals(rhs.amount)))&&((this.currencyCd == rhs.currencyCd)||((this.currencyCd!= null)&&this.currencyCd.equals(rhs.currencyCd))))&&((this.tsysExtension == rhs.tsysExtension)||((this.tsysExtension!= null)&&this.tsysExtension.equals(rhs.tsysExtension))));
    }

}
