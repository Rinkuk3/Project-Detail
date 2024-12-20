package com.td.api.mbcca.response.card;

public class DeviceTSYSExtension {

    private String accountNum;

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DeviceTSYSExtension.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("accountNum");
        sb.append('=');
        sb.append(((this.accountNum == null)?"<null>":this.accountNum));
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
        result = ((result* 31)+((this.accountNum == null)? 0 :this.accountNum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DeviceTSYSExtension) == false) {
            return false;
        }
        DeviceTSYSExtension rhs = ((DeviceTSYSExtension) other);
        return ((this.accountNum == rhs.accountNum)||((this.accountNum!= null)&&this.accountNum.equals(rhs.accountNum)));
    }

}
