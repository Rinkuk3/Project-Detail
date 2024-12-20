package com.td.api.mbcca.creditcard.request;

public class CcapiExtension {

    private String debitCardNum;

    public String getDebitCardNum() {
        return debitCardNum;
    }

    public void setDebitCardNum(String debitCardNum) {
        this.debitCardNum = debitCardNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CcapiExtension.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("debitCardNum");
        sb.append('=');
        sb.append(((this.debitCardNum == null)?"<null>":this.debitCardNum));
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
        result = ((result* 31)+((this.debitCardNum == null)? 0 :this.debitCardNum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CcapiExtension) == false) {
            return false;
        }
        CcapiExtension rhs = ((CcapiExtension) other);
        return ((this.debitCardNum == rhs.debitCardNum)||((this.debitCardNum!= null)&&this.debitCardNum.equals(rhs.debitCardNum)));
    }

}
