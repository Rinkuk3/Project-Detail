package com.td.api.mbcca.response.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Score {

    private String typeCd;
    private String val;
    private String sourceId;
    private Date startDttm;
    private String desc;
    private List<Reason> reason = new ArrayList<Reason>();
    private String reportingPartyName;

    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public Date getStartDttm() {
        return startDttm;
    }

    public void setStartDttm(Date startDttm) {
        this.startDttm = startDttm;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Reason> getReason() {
        return reason;
    }

    public void setReason(List<Reason> reason) {
        this.reason = reason;
    }

    public String getReportingPartyName() {
        return reportingPartyName;
    }

    public void setReportingPartyName(String reportingPartyName) {
        this.reportingPartyName = reportingPartyName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Score.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("typeCd");
        sb.append('=');
        sb.append(((this.typeCd == null)?"<null>":this.typeCd));
        sb.append(',');
        sb.append("val");
        sb.append('=');
        sb.append(((this.val == null)?"<null>":this.val));
        sb.append(',');
        sb.append("sourceId");
        sb.append('=');
        sb.append(((this.sourceId == null)?"<null>":this.sourceId));
        sb.append(',');
        sb.append("startDttm");
        sb.append('=');
        sb.append(((this.startDttm == null)?"<null>":this.startDttm));
        sb.append(',');
        sb.append("desc");
        sb.append('=');
        sb.append(((this.desc == null)?"<null>":this.desc));
        sb.append(',');
        sb.append("reason");
        sb.append('=');
        sb.append(((this.reason == null)?"<null>":this.reason));
        sb.append(',');
        sb.append("reportingPartyName");
        sb.append('=');
        sb.append(((this.reportingPartyName == null)?"<null>":this.reportingPartyName));
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
        result = ((result* 31)+((this.val == null)? 0 :this.val.hashCode()));
        result = ((result* 31)+((this.sourceId == null)? 0 :this.sourceId.hashCode()));
        result = ((result* 31)+((this.reason == null)? 0 :this.reason.hashCode()));
        result = ((result* 31)+((this.typeCd == null)? 0 :this.typeCd.hashCode()));
        result = ((result* 31)+((this.startDttm == null)? 0 :this.startDttm.hashCode()));
        result = ((result* 31)+((this.reportingPartyName == null)? 0 :this.reportingPartyName.hashCode()));
        result = ((result* 31)+((this.desc == null)? 0 :this.desc.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Score) == false) {
            return false;
        }
        Score rhs = ((Score) other);
        return ((((((((this.val == rhs.val)||((this.val!= null)&&this.val.equals(rhs.val)))&&((this.sourceId == rhs.sourceId)||((this.sourceId!= null)&&this.sourceId.equals(rhs.sourceId))))&&((this.reason == rhs.reason)||((this.reason!= null)&&this.reason.equals(rhs.reason))))&&((this.typeCd == rhs.typeCd)||((this.typeCd!= null)&&this.typeCd.equals(rhs.typeCd))))&&((this.startDttm == rhs.startDttm)||((this.startDttm!= null)&&this.startDttm.equals(rhs.startDttm))))&&((this.reportingPartyName == rhs.reportingPartyName)||((this.reportingPartyName!= null)&&this.reportingPartyName.equals(rhs.reportingPartyName))))&&((this.desc == rhs.desc)||((this.desc!= null)&&this.desc.equals(rhs.desc))));
    }

}
