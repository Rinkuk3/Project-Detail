package com.td.mbna.msec.midtier.types.common;

import com.google.gson.annotations.JsonAdapter;
import com.td.mbna.msec.midtier.serializers.GsonDateTimeDeSerializer;

import java.io.Serializable;

public class UnformattedAddress implements Serializable {

	private static final long serialVersionUID = 1L;
    private String addrLine1;
    private String addrLine2;
    private String city;
    private String province;
    private String postalCode;
    @JsonAdapter(value = GsonDateTimeDeSerializer.class)
    private Long lastUpdatedTS;

    public String getAddrLine1() {
        return addrLine1;
    }

    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }

    public String getAddrLine2() {
        return addrLine2;
    }

    public void setAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
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

    public Long getLastUpdatedTS() {
        return lastUpdatedTS;
    }

    public void setLastUpdatedTS(Long lastUpdatedTS) {
        this.lastUpdatedTS = lastUpdatedTS;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(UnformattedAddress.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("addrLine1");
        sb.append('=');
        sb.append(((this.addrLine1 == null)?"<null>":this.addrLine1));
        sb.append(',');
        sb.append("addrLine2");
        sb.append('=');
        sb.append(((this.addrLine2 == null)?"<null>":this.addrLine2));
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
        sb.append("lastUpdatedTS");
        sb.append('=');
        sb.append(((this.lastUpdatedTS == null)?"<null>":this.lastUpdatedTS));
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
        result = ((result* 31)+((this.city == null)? 0 :this.city.hashCode()));
        result = ((result* 31)+((this.addrLine2 == null)? 0 :this.addrLine2 .hashCode()));
        result = ((result* 31)+((this.addrLine1 == null)? 0 :this.addrLine1 .hashCode()));
        result = ((result* 31)+((this.postalCode == null)? 0 :this.postalCode.hashCode()));
        result = ((result* 31)+((this.lastUpdatedTS == null)? 0 :this.lastUpdatedTS.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UnformattedAddress) == false) {
            return false;
        }
        UnformattedAddress rhs = ((UnformattedAddress) other);
        return (((((((this.province == rhs.province)||((this.province!= null)&&this.province.equals(rhs.province)))&&((this.city == rhs.city)||((this.city!= null)&&this.city.equals(rhs.city))))&&((this.addrLine2 == rhs.addrLine2)||((this.addrLine2 != null)&&this.addrLine2 .equals(rhs.addrLine2))))&&((this.addrLine1 == rhs.addrLine1)||((this.addrLine1 != null)&&this.addrLine1 .equals(rhs.addrLine1))))&&((this.postalCode == rhs.postalCode)||((this.postalCode!= null)&&this.postalCode.equals(rhs.postalCode))))&&((this.lastUpdatedTS == rhs.lastUpdatedTS)||((this.lastUpdatedTS!= null)&&this.lastUpdatedTS.equals(rhs.lastUpdatedTS))));
    }

}
