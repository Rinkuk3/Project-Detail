package com.td.api.mbcca.response.account;

public class FdrExtension {

    private String birthDt;

    public String getBirthDt() {
        return birthDt;
    }

    public void setBirthDt(String birthDt) {
        this.birthDt = birthDt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FdrExtension.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("birthDt");
        sb.append('=');
        sb.append(((this.birthDt == null)?"<null>":this.birthDt));
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
        result = ((result* 31)+((this.birthDt == null)? 0 :this.birthDt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FdrExtension) == false) {
            return false;
        }
        FdrExtension rhs = ((FdrExtension) other);
        return ((this.birthDt == rhs.birthDt)||((this.birthDt!= null)&&this.birthDt.equals(rhs.birthDt)));
    }

}
