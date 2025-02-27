package com.td.api.mbcca.shared;

public class MerchantInfo {

    private String merchantNum;
    private String merchantCategoryCd;
    private String name;
    private String city;
    private String territory;
    private String country;
    private Object postalCode;
    private String telephoneNum;
    private String merchantCategoryCodeDesc;

    public String getMerchantNum() {
        return merchantNum;
    }

    public void setMerchantNum(String merchantNum) {
        this.merchantNum = merchantNum;
    }

    public String getMerchantCategoryCd() {
        return merchantCategoryCd;
    }

    public void setMerchantCategoryCd(String merchantCategoryCd) {
        this.merchantCategoryCd = merchantCategoryCd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Object getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Object postalCode) {
        this.postalCode = postalCode;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public String getMerchantCategoryCodeDesc() {
        return merchantCategoryCodeDesc;
    }

    public void setMerchantCategoryCodeDesc(String merchantCategoryCodeDesc) {
        this.merchantCategoryCodeDesc = merchantCategoryCodeDesc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MerchantInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("merchantNum");
        sb.append('=');
        sb.append(((this.merchantNum == null)?"<null>":this.merchantNum));
        sb.append(',');
        sb.append("merchantCategoryCd");
        sb.append('=');
        sb.append(((this.merchantCategoryCd == null)?"<null>":this.merchantCategoryCd));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("city");
        sb.append('=');
        sb.append(((this.city == null)?"<null>":this.city));
        sb.append(',');
        sb.append("territory");
        sb.append('=');
        sb.append(((this.territory == null)?"<null>":this.territory));
        sb.append(',');
        sb.append("country");
        sb.append('=');
        sb.append(((this.country == null)?"<null>":this.country));
        sb.append(',');
        sb.append("postalCode");
        sb.append('=');
        sb.append(((this.postalCode == null)?"<null>":this.postalCode));
        sb.append(',');
        sb.append("telephoneNum");
        sb.append('=');
        sb.append(((this.telephoneNum == null)?"<null>":this.telephoneNum));
        sb.append(',');
        sb.append("merchantCategoryCodeDesc");
        sb.append('=');
        sb.append(((this.merchantCategoryCodeDesc == null)?"<null>":this.merchantCategoryCodeDesc));
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
        result = ((result* 31)+((this.country == null)? 0 :this.country.hashCode()));
        result = ((result* 31)+((this.city == null)? 0 :this.city.hashCode()));
        result = ((result* 31)+((this.telephoneNum == null)? 0 :this.telephoneNum.hashCode()));
        result = ((result* 31)+((this.merchantNum == null)? 0 :this.merchantNum.hashCode()));
        result = ((result* 31)+((this.postalCode == null)? 0 :this.postalCode.hashCode()));
        result = ((result* 31)+((this.merchantCategoryCd == null)? 0 :this.merchantCategoryCd.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.merchantCategoryCodeDesc == null)? 0 :this.merchantCategoryCodeDesc.hashCode()));
        result = ((result* 31)+((this.territory == null)? 0 :this.territory.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MerchantInfo) == false) {
            return false;
        }
        MerchantInfo rhs = ((MerchantInfo) other);
        return ((((((((((this.country == rhs.country)||((this.country!= null)&&this.country.equals(rhs.country)))&&((this.city == rhs.city)||((this.city!= null)&&this.city.equals(rhs.city))))&&((this.telephoneNum == rhs.telephoneNum)||((this.telephoneNum!= null)&&this.telephoneNum.equals(rhs.telephoneNum))))&&((this.merchantNum == rhs.merchantNum)||((this.merchantNum!= null)&&this.merchantNum.equals(rhs.merchantNum))))&&((this.postalCode == rhs.postalCode)||((this.postalCode!= null)&&this.postalCode.equals(rhs.postalCode))))&&((this.merchantCategoryCd == rhs.merchantCategoryCd)||((this.merchantCategoryCd!= null)&&this.merchantCategoryCd.equals(rhs.merchantCategoryCd))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.merchantCategoryCodeDesc == rhs.merchantCategoryCodeDesc)||((this.merchantCategoryCodeDesc!= null)&&this.merchantCategoryCodeDesc.equals(rhs.merchantCategoryCodeDesc))))&&((this.territory == rhs.territory)||((this.territory!= null)&&this.territory.equals(rhs.territory))));
    }

}
