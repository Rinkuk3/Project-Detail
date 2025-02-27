package com.td.api.mbcca.response.account;

import java.util.Date;

public class StreetAddress {

    private String startDt;
    private String endDt;
    private Date startDttm;
    private Date endDttm;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String territory;
    private Object postalCode;
    private String country;
    private String countryCd;
    private String desc;
    private Date lastUpdateDttm;
    private String validatedIndicatorCd;
    private Boolean overriddenInd;
    private String key;

    public String getStartDt() {
        return startDt;
    }

    public void setStartDt(String startDt) {
        this.startDt = startDt;
    }

    public String getEndDt() {
        return endDt;
    }

    public void setEndDt(String endDt) {
        this.endDt = endDt;
    }

    public Date getStartDttm() {
        return startDttm;
    }

    public void setStartDttm(Date startDttm) {
        this.startDttm = startDttm;
    }

    public Date getEndDttm() {
        return endDttm;
    }

    public void setEndDttm(Date endDttm) {
        this.endDttm = endDttm;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTerritory() {
        return territory;
    }

    public void setTerritory(String territory) {
        this.territory = territory;
    }

    public Object getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Object postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCd() {
        return countryCd;
    }

    public void setCountryCd(String countryCd) {
        this.countryCd = countryCd;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getLastUpdateDttm() {
        return lastUpdateDttm;
    }

    public void setLastUpdateDttm(Date lastUpdateDttm) {
        this.lastUpdateDttm = lastUpdateDttm;
    }

    public String getValidatedIndicatorCd() {
        return validatedIndicatorCd;
    }

    public void setValidatedIndicatorCd(String validatedIndicatorCd) {
        this.validatedIndicatorCd = validatedIndicatorCd;
    }

    public Boolean getOverriddenInd() {
        return overriddenInd;
    }

    public void setOverriddenInd(Boolean overriddenInd) {
        this.overriddenInd = overriddenInd;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StreetAddress.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("startDt");
        sb.append('=');
        sb.append(((this.startDt == null)?"<null>":this.startDt));
        sb.append(',');
        sb.append("endDt");
        sb.append('=');
        sb.append(((this.endDt == null)?"<null>":this.endDt));
        sb.append(',');
        sb.append("startDttm");
        sb.append('=');
        sb.append(((this.startDttm == null)?"<null>":this.startDttm));
        sb.append(',');
        sb.append("endDttm");
        sb.append('=');
        sb.append(((this.endDttm == null)?"<null>":this.endDttm));
        sb.append(',');
        sb.append("addressLine1");
        sb.append('=');
        sb.append(((this.addressLine1 == null)?"<null>":this.addressLine1));
        sb.append(',');
        sb.append("addressLine2");
        sb.append('=');
        sb.append(((this.addressLine2 == null)?"<null>":this.addressLine2));
        sb.append(',');
        sb.append("addressLine3");
        sb.append('=');
        sb.append(((this.addressLine3 == null)?"<null>":this.addressLine3));
        sb.append(',');
        sb.append("city");
        sb.append('=');
        sb.append(((this.city == null)?"<null>":this.city));
        sb.append(',');
        sb.append("territory");
        sb.append('=');
        sb.append(((this.territory == null)?"<null>":this.territory));
        sb.append(',');
        sb.append("postalCode");
        sb.append('=');
        sb.append(((this.postalCode == null)?"<null>":this.postalCode));
        sb.append(',');
        sb.append("country");
        sb.append('=');
        sb.append(((this.country == null)?"<null>":this.country));
        sb.append(',');
        sb.append("countryCd");
        sb.append('=');
        sb.append(((this.countryCd == null)?"<null>":this.countryCd));
        sb.append(',');
        sb.append("desc");
        sb.append('=');
        sb.append(((this.desc == null)?"<null>":this.desc));
        sb.append(',');
        sb.append("lastUpdateDttm");
        sb.append('=');
        sb.append(((this.lastUpdateDttm == null)?"<null>":this.lastUpdateDttm));
        sb.append(',');
        sb.append("validatedIndicatorCd");
        sb.append('=');
        sb.append(((this.validatedIndicatorCd == null)?"<null>":this.validatedIndicatorCd));
        sb.append(',');
        sb.append("overriddenInd");
        sb.append('=');
        sb.append(((this.overriddenInd == null)?"<null>":this.overriddenInd));
        sb.append(',');
        sb.append("key");
        sb.append('=');
        sb.append(((this.key == null)?"<null>":this.key));
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
        result = ((result* 31)+((this.overriddenInd == null)? 0 :this.overriddenInd.hashCode()));
        result = ((result* 31)+((this.country == null)? 0 :this.country.hashCode()));
        result = ((result* 31)+((this.lastUpdateDttm == null)? 0 :this.lastUpdateDttm.hashCode()));
        result = ((result* 31)+((this.startDttm == null)? 0 :this.startDttm.hashCode()));
        result = ((result* 31)+((this.city == null)? 0 :this.city.hashCode()));
        result = ((result* 31)+((this.postalCode == null)? 0 :this.postalCode.hashCode()));
        result = ((result* 31)+((this.endDttm == null)? 0 :this.endDttm.hashCode()));
        result = ((result* 31)+((this.countryCd == null)? 0 :this.countryCd.hashCode()));
        result = ((result* 31)+((this.endDt == null)? 0 :this.endDt.hashCode()));
        result = ((result* 31)+((this.validatedIndicatorCd == null)? 0 :this.validatedIndicatorCd.hashCode()));
        result = ((result* 31)+((this.startDt == null)? 0 :this.startDt.hashCode()));
        result = ((result* 31)+((this.addressLine1 == null)? 0 :this.addressLine1 .hashCode()));
        result = ((result* 31)+((this.addressLine2 == null)? 0 :this.addressLine2 .hashCode()));
        result = ((result* 31)+((this.addressLine3 == null)? 0 :this.addressLine3 .hashCode()));
        result = ((result* 31)+((this.key == null)? 0 :this.key.hashCode()));
        result = ((result* 31)+((this.territory == null)? 0 :this.territory.hashCode()));
        result = ((result* 31)+((this.desc == null)? 0 :this.desc.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StreetAddress) == false) {
            return false;
        }
        StreetAddress rhs = ((StreetAddress) other);
        return ((((((((((((((((((this.overriddenInd == rhs.overriddenInd)||((this.overriddenInd!= null)&&this.overriddenInd.equals(rhs.overriddenInd)))&&((this.country == rhs.country)||((this.country!= null)&&this.country.equals(rhs.country))))&&((this.lastUpdateDttm == rhs.lastUpdateDttm)||((this.lastUpdateDttm!= null)&&this.lastUpdateDttm.equals(rhs.lastUpdateDttm))))&&((this.startDttm == rhs.startDttm)||((this.startDttm!= null)&&this.startDttm.equals(rhs.startDttm))))&&((this.city == rhs.city)||((this.city!= null)&&this.city.equals(rhs.city))))&&((this.postalCode == rhs.postalCode)||((this.postalCode!= null)&&this.postalCode.equals(rhs.postalCode))))&&((this.endDttm == rhs.endDttm)||((this.endDttm!= null)&&this.endDttm.equals(rhs.endDttm))))&&((this.countryCd == rhs.countryCd)||((this.countryCd!= null)&&this.countryCd.equals(rhs.countryCd))))&&((this.endDt == rhs.endDt)||((this.endDt!= null)&&this.endDt.equals(rhs.endDt))))&&((this.validatedIndicatorCd == rhs.validatedIndicatorCd)||((this.validatedIndicatorCd!= null)&&this.validatedIndicatorCd.equals(rhs.validatedIndicatorCd))))&&((this.startDt == rhs.startDt)||((this.startDt!= null)&&this.startDt.equals(rhs.startDt))))&&((this.addressLine1 == rhs.addressLine1)||((this.addressLine1 != null)&&this.addressLine1 .equals(rhs.addressLine1))))&&((this.addressLine2 == rhs.addressLine2)||((this.addressLine2 != null)&&this.addressLine2 .equals(rhs.addressLine2))))&&((this.addressLine3 == rhs.addressLine3)||((this.addressLine3 != null)&&this.addressLine3 .equals(rhs.addressLine3))))&&((this.key == rhs.key)||((this.key!= null)&&this.key.equals(rhs.key))))&&((this.territory == rhs.territory)||((this.territory!= null)&&this.territory.equals(rhs.territory))))&&((this.desc == rhs.desc)||((this.desc!= null)&&this.desc.equals(rhs.desc))));
    }

}
