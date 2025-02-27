package com.td.api.mbcca.shared;

public class TsysExtensionCurrencyNumericCd {

    private String currencyNumericCd;

    public String getCurrencyNumericCd() {
        return currencyNumericCd;
    }

    public void setCurrencyNumericCd(String currencyNumericCd) {
        this.currencyNumericCd = currencyNumericCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TsysExtensionCurrencyNumericCd.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("currencyNumericCd");
        sb.append('=');
        sb.append(((this.currencyNumericCd == null)?"<null>":this.currencyNumericCd));
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
        result = ((result* 31)+((this.currencyNumericCd == null)? 0 :this.currencyNumericCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TsysExtensionCurrencyNumericCd) == false) {
            return false;
        }
        TsysExtensionCurrencyNumericCd rhs = ((TsysExtensionCurrencyNumericCd) other);
        return ((this.currencyNumericCd == rhs.currencyNumericCd)||((this.currencyNumericCd!= null)&&this.currencyNumericCd.equals(rhs.currencyNumericCd)));
    }

}
