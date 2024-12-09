package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class SimpleAddress implements Serializable {

	private static final long serialVersionUID = 1578842978972213086L;
    private String streetAddress;
    private String city;
    private String province;
    private String postalCode;

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SimpleAddress.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("streetAddress");
        sb.append('=');
        sb.append(((this.streetAddress == null)?"<null>":this.streetAddress));
        sb.append(',');
        sb.append("city");
        sb.append('=');
        sb.append(((this.city == null)?"<null>":this.city));
        sb.append(',');
        sb.append("province");
        sb.append('=');
        sb.append(((this.province == null)?"<null>":this.province));
        sb.append(',');
        sb.append("postalCode");
        sb.append('=');
        sb.append(((this.postalCode == null)?"<null>":this.postalCode));
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
        result = ((result* 31)+((this.province == null)? 0 :this.province.hashCode()));
        result = ((result* 31)+((this.streetAddress == null)? 0 :this.streetAddress.hashCode()));
        result = ((result* 31)+((this.city == null)? 0 :this.city.hashCode()));
        result = ((result* 31)+((this.postalCode == null)? 0 :this.postalCode.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SimpleAddress) == false) {
            return false;
        }
        SimpleAddress rhs = ((SimpleAddress) other);
        return (((((this.province == rhs.province)||((this.province!= null)&&this.province.equals(rhs.province)))&&((this.streetAddress == rhs.streetAddress)||((this.streetAddress!= null)&&this.streetAddress.equals(rhs.streetAddress))))&&((this.city == rhs.city)||((this.city!= null)&&this.city.equals(rhs.city))))&&((this.postalCode == rhs.postalCode)||((this.postalCode!= null)&&this.postalCode.equals(rhs.postalCode))));
    }

}
