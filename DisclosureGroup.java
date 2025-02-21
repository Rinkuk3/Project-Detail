package com.td.api.mbcca.response.account;

public class DisclosureGroup {

    private String typeCd;
    private String groupCd;
    private String desc;
    private Boolean activeInd;
    private String startDt;
    private String endDt;
    private Boolean neverEndInd;
    private String lastUpdateDt;

    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    public String getGroupCd() {
        return groupCd;
    }

    public void setGroupCd(String groupCd) {
        this.groupCd = groupCd;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Boolean getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(Boolean activeInd) {
        this.activeInd = activeInd;
    }

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

    public Boolean getNeverEndInd() {
        return neverEndInd;
    }

    public void setNeverEndInd(Boolean neverEndInd) {
        this.neverEndInd = neverEndInd;
    }

    public String getLastUpdateDt() {
        return lastUpdateDt;
    }

    public void setLastUpdateDt(String lastUpdateDt) {
        this.lastUpdateDt = lastUpdateDt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DisclosureGroup.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("typeCd");
        sb.append('=');
        sb.append(((this.typeCd == null)?"<null>":this.typeCd));
        sb.append(',');
        sb.append("groupCd");
        sb.append('=');
        sb.append(((this.groupCd == null)?"<null>":this.groupCd));
        sb.append(',');
        sb.append("desc");
        sb.append('=');
        sb.append(((this.desc == null)?"<null>":this.desc));
        sb.append(',');
        sb.append("activeInd");
        sb.append('=');
        sb.append(((this.activeInd == null)?"<null>":this.activeInd));
        sb.append(',');
        sb.append("startDt");
        sb.append('=');
        sb.append(((this.startDt == null)?"<null>":this.startDt));
        sb.append(',');
        sb.append("endDt");
        sb.append('=');
        sb.append(((this.endDt == null)?"<null>":this.endDt));
        sb.append(',');
        sb.append("neverEndInd");
        sb.append('=');
        sb.append(((this.neverEndInd == null)?"<null>":this.neverEndInd));
        sb.append(',');
        sb.append("lastUpdateDt");
        sb.append('=');
        sb.append(((this.lastUpdateDt == null)?"<null>":this.lastUpdateDt));
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
        result = ((result* 31)+((this.neverEndInd == null)? 0 :this.neverEndInd.hashCode()));
        result = ((result* 31)+((this.typeCd == null)? 0 :this.typeCd.hashCode()));
        result = ((result* 31)+((this.activeInd == null)? 0 :this.activeInd.hashCode()));
        result = ((result* 31)+((this.lastUpdateDt == null)? 0 :this.lastUpdateDt.hashCode()));
        result = ((result* 31)+((this.startDt == null)? 0 :this.startDt.hashCode()));
        result = ((result* 31)+((this.endDt == null)? 0 :this.endDt.hashCode()));
        result = ((result* 31)+((this.groupCd == null)? 0 :this.groupCd.hashCode()));
        result = ((result* 31)+((this.desc == null)? 0 :this.desc.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DisclosureGroup) == false) {
            return false;
        }
        DisclosureGroup rhs = ((DisclosureGroup) other);
        return (((((((((this.neverEndInd == rhs.neverEndInd)||((this.neverEndInd!= null)&&this.neverEndInd.equals(rhs.neverEndInd)))&&((this.typeCd == rhs.typeCd)||((this.typeCd!= null)&&this.typeCd.equals(rhs.typeCd))))&&((this.activeInd == rhs.activeInd)||((this.activeInd!= null)&&this.activeInd.equals(rhs.activeInd))))&&((this.lastUpdateDt == rhs.lastUpdateDt)||((this.lastUpdateDt!= null)&&this.lastUpdateDt.equals(rhs.lastUpdateDt))))&&((this.startDt == rhs.startDt)||((this.startDt!= null)&&this.startDt.equals(rhs.startDt))))&&((this.endDt == rhs.endDt)||((this.endDt!= null)&&this.endDt.equals(rhs.endDt))))&&((this.groupCd == rhs.groupCd)||((this.groupCd!= null)&&this.groupCd.equals(rhs.groupCd))))&&((this.desc == rhs.desc)||((this.desc!= null)&&this.desc.equals(rhs.desc))));
    }

}
