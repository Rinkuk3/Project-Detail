package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class PhoneNumber implements Serializable {

	private static final long serialVersionUID = -5145136342172036100L;
    private String phoneNumber;
    private String phoneType;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PhoneNumber.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("phoneNumber");
        sb.append('=');
        sb.append(((this.phoneNumber == null)?"<null>":this.phoneNumber));
        sb.append(',');
        sb.append("phoneType");
        sb.append('=');
        sb.append(((this.phoneType == null)?"<null>":this.phoneType));
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
        result = ((result* 31)+((this.phoneType == null)? 0 :this.phoneType.hashCode()));
        result = ((result* 31)+((this.phoneNumber == null)? 0 :this.phoneNumber.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PhoneNumber) == false) {
            return false;
        }
        PhoneNumber rhs = ((PhoneNumber) other);
        return (((this.phoneType == rhs.phoneType)||((this.phoneType!= null)&&this.phoneType.equals(rhs.phoneType)))&&((this.phoneNumber == rhs.phoneNumber)||((this.phoneNumber!= null)&&this.phoneNumber.equals(rhs.phoneNumber))));
    }

}
