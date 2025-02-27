package com.td.api.mbcca.response.account;

import java.util.Date;

public class TelephoneNumber {

    private String startDt;
    private String endDt;
    private Date startDttm;
    private Date endDttm;
    private String telephoneNum;
    private String countryCodeNum;
    private String areaCodeNum;
    private String exchangeNum;
    private String lineNum;
    private String extensionNum;
    private Date lastUpdateDttm;

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

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public String getCountryCodeNum() {
        return countryCodeNum;
    }

    public void setCountryCodeNum(String countryCodeNum) {
        this.countryCodeNum = countryCodeNum;
    }

    public String getAreaCodeNum() {
        return areaCodeNum;
    }

    public void setAreaCodeNum(String areaCodeNum) {
        this.areaCodeNum = areaCodeNum;
    }

    public String getExchangeNum() {
        return exchangeNum;
    }

    public void setExchangeNum(String exchangeNum) {
        this.exchangeNum = exchangeNum;
    }

    public String getLineNum() {
        return lineNum;
    }

    public void setLineNum(String lineNum) {
        this.lineNum = lineNum;
    }

    public String getExtensionNum() {
        return extensionNum;
    }

    public void setExtensionNum(String extensionNum) {
        this.extensionNum = extensionNum;
    }

    public Date getLastUpdateDttm() {
        return lastUpdateDttm;
    }

    public void setLastUpdateDttm(Date lastUpdateDttm) {
        this.lastUpdateDttm = lastUpdateDttm;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TelephoneNumber.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("telephoneNum");
        sb.append('=');
        sb.append(((this.telephoneNum == null)?"<null>":this.telephoneNum));
        sb.append(',');
        sb.append("countryCodeNum");
        sb.append('=');
        sb.append(((this.countryCodeNum == null)?"<null>":this.countryCodeNum));
        sb.append(',');
        sb.append("areaCodeNum");
        sb.append('=');
        sb.append(((this.areaCodeNum == null)?"<null>":this.areaCodeNum));
        sb.append(',');
        sb.append("exchangeNum");
        sb.append('=');
        sb.append(((this.exchangeNum == null)?"<null>":this.exchangeNum));
        sb.append(',');
        sb.append("lineNum");
        sb.append('=');
        sb.append(((this.lineNum == null)?"<null>":this.lineNum));
        sb.append(',');
        sb.append("extensionNum");
        sb.append('=');
        sb.append(((this.extensionNum == null)?"<null>":this.extensionNum));
        sb.append(',');
        sb.append("lastUpdateDttm");
        sb.append('=');
        sb.append(((this.lastUpdateDttm == null)?"<null>":this.lastUpdateDttm));
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
        result = ((result* 31)+((this.lastUpdateDttm == null)? 0 :this.lastUpdateDttm.hashCode()));
        result = ((result* 31)+((this.startDttm == null)? 0 :this.startDttm.hashCode()));
        result = ((result* 31)+((this.telephoneNum == null)? 0 :this.telephoneNum.hashCode()));
        result = ((result* 31)+((this.areaCodeNum == null)? 0 :this.areaCodeNum.hashCode()));
        result = ((result* 31)+((this.countryCodeNum == null)? 0 :this.countryCodeNum.hashCode()));
        result = ((result* 31)+((this.exchangeNum == null)? 0 :this.exchangeNum.hashCode()));
        result = ((result* 31)+((this.endDttm == null)? 0 :this.endDttm.hashCode()));
        result = ((result* 31)+((this.startDt == null)? 0 :this.startDt.hashCode()));
        result = ((result* 31)+((this.endDt == null)? 0 :this.endDt.hashCode()));
        result = ((result* 31)+((this.lineNum == null)? 0 :this.lineNum.hashCode()));
        result = ((result* 31)+((this.extensionNum == null)? 0 :this.extensionNum.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TelephoneNumber) == false) {
            return false;
        }
        TelephoneNumber rhs = ((TelephoneNumber) other);
        return ((((((((((((this.lastUpdateDttm == rhs.lastUpdateDttm)||((this.lastUpdateDttm!= null)&&this.lastUpdateDttm.equals(rhs.lastUpdateDttm)))&&((this.startDttm == rhs.startDttm)||((this.startDttm!= null)&&this.startDttm.equals(rhs.startDttm))))&&((this.telephoneNum == rhs.telephoneNum)||((this.telephoneNum!= null)&&this.telephoneNum.equals(rhs.telephoneNum))))&&((this.areaCodeNum == rhs.areaCodeNum)||((this.areaCodeNum!= null)&&this.areaCodeNum.equals(rhs.areaCodeNum))))&&((this.countryCodeNum == rhs.countryCodeNum)||((this.countryCodeNum!= null)&&this.countryCodeNum.equals(rhs.countryCodeNum))))&&((this.exchangeNum == rhs.exchangeNum)||((this.exchangeNum!= null)&&this.exchangeNum.equals(rhs.exchangeNum))))&&((this.endDttm == rhs.endDttm)||((this.endDttm!= null)&&this.endDttm.equals(rhs.endDttm))))&&((this.startDt == rhs.startDt)||((this.startDt!= null)&&this.startDt.equals(rhs.startDt))))&&((this.endDt == rhs.endDt)||((this.endDt!= null)&&this.endDt.equals(rhs.endDt))))&&((this.lineNum == rhs.lineNum)||((this.lineNum!= null)&&this.lineNum.equals(rhs.lineNum))))&&((this.extensionNum == rhs.extensionNum)||((this.extensionNum!= null)&&this.extensionNum.equals(rhs.extensionNum))));
    }

}
