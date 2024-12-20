package com.td.api.mbcca.creditcard.request;

public class TsysExtension {

    private String creditLimitChangeActionCd;

    public String getCreditLimitChangeActionCd() {
        return creditLimitChangeActionCd;
    }

    public void setCreditLimitChangeActionCd(String creditLimitChangeActionCd) {
        this.creditLimitChangeActionCd = creditLimitChangeActionCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TsysExtension.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("creditLimitChangeActionCd");
        sb.append('=');
        sb.append(((this.creditLimitChangeActionCd == null)?"<null>":this.creditLimitChangeActionCd));
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
        result = ((result* 31)+((this.creditLimitChangeActionCd == null)? 0 :this.creditLimitChangeActionCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TsysExtension) == false) {
            return false;
        }
        TsysExtension rhs = ((TsysExtension) other);
        return ((this.creditLimitChangeActionCd == rhs.creditLimitChangeActionCd)||((this.creditLimitChangeActionCd!= null)&&this.creditLimitChangeActionCd.equals(rhs.creditLimitChangeActionCd)));
    }

}
