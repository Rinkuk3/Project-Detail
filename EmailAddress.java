package com.td.api.mbcca.response.account;

import java.util.Date;

public class EmailAddress {

    private String startDt;
    private String endDt;
    private Date startDttm;
    private Date endDttm;
    private String text;
    private String domainName;
    private String desc;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EmailAddress.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("text");
        sb.append('=');
        sb.append(((this.text == null)?"<null>":this.text));
        sb.append(',');
        sb.append("domainName");
        sb.append('=');
        sb.append(((this.domainName == null)?"<null>":this.domainName));
        sb.append(',');
        sb.append("desc");
        sb.append('=');
        sb.append(((this.desc == null)?"<null>":this.desc));
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
        result = ((result* 31)+((this.domainName == null)? 0 :this.domainName.hashCode()));
        result = ((result* 31)+((this.endDttm == null)? 0 :this.endDttm.hashCode()));
        result = ((result* 31)+((this.startDt == null)? 0 :this.startDt.hashCode()));
        result = ((result* 31)+((this.endDt == null)? 0 :this.endDt.hashCode()));
        result = ((result* 31)+((this.text == null)? 0 :this.text.hashCode()));
        result = ((result* 31)+((this.desc == null)? 0 :this.desc.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EmailAddress) == false) {
            return false;
        }
        EmailAddress rhs = ((EmailAddress) other);
        return (((((((((this.lastUpdateDttm == rhs.lastUpdateDttm)||((this.lastUpdateDttm!= null)&&this.lastUpdateDttm.equals(rhs.lastUpdateDttm)))&&((this.startDttm == rhs.startDttm)||((this.startDttm!= null)&&this.startDttm.equals(rhs.startDttm))))&&((this.domainName == rhs.domainName)||((this.domainName!= null)&&this.domainName.equals(rhs.domainName))))&&((this.endDttm == rhs.endDttm)||((this.endDttm!= null)&&this.endDttm.equals(rhs.endDttm))))&&((this.startDt == rhs.startDt)||((this.startDt!= null)&&this.startDt.equals(rhs.startDt))))&&((this.endDt == rhs.endDt)||((this.endDt!= null)&&this.endDt.equals(rhs.endDt))))&&((this.text == rhs.text)||((this.text!= null)&&this.text.equals(rhs.text))))&&((this.desc == rhs.desc)||((this.desc!= null)&&this.desc.equals(rhs.desc))));
    }

}
