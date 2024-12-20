package com.td.api.mbcca.response.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Accountstatus {

    private String cd;
    private String reasonCd;
    private String reasonDesc;
    private String startDt;

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getReasonCd() {
        return reasonCd;
    }

    public void setReasonCd(String reasonCd) {
        this.reasonCd = reasonCd;
    }

    public String getReasonDesc() {
        return reasonDesc;
    }

    public void setReasonDesc(String reasonDesc) {
        this.reasonDesc = reasonDesc;
    }

    public String getStartDt() {
        return startDt;
    }

    public void setStartDt(String startDt) {
        this.startDt = startDt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Accountstatus.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cd");
        sb.append('=');
        sb.append(((this.cd == null)?"<null>":this.cd));
        sb.append(',');
        sb.append("reasonCd");
        sb.append('=');
        sb.append(((this.reasonCd == null)?"<null>":this.reasonCd));
        sb.append(',');
        sb.append("reasonDesc");
        sb.append('=');
        sb.append(((this.reasonDesc == null)?"<null>":this.reasonDesc));
        sb.append(',');
        sb.append("startDt");
        sb.append('=');
        sb.append(((this.startDt == null)?"<null>":this.startDt));
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
        result = ((result* 31)+((this.cd == null)? 0 :this.cd.hashCode()));
        result = ((result* 31)+((this.startDt == null)? 0 :this.startDt.hashCode()));
        result = ((result* 31)+((this.reasonDesc == null)? 0 :this.reasonDesc.hashCode()));
        result = ((result* 31)+((this.reasonCd == null)? 0 :this.reasonCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Accountstatus) == false) {
            return false;
        }
        Accountstatus rhs = ((Accountstatus) other);
        return (((((this.cd == rhs.cd)||((this.cd!= null)&&this.cd.equals(rhs.cd)))&&((this.startDt == rhs.startDt)||((this.startDt!= null)&&this.startDt.equals(rhs.startDt))))&&((this.reasonDesc == rhs.reasonDesc)||((this.reasonDesc!= null)&&this.reasonDesc.equals(rhs.reasonDesc))))&&((this.reasonCd == rhs.reasonCd)||((this.reasonCd!= null)&&this.reasonCd.equals(rhs.reasonCd))));
    }

}
