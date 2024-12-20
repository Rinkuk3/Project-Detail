package com.td.api.mbcca.creditcard.request;

public class AlternateDisclosureGroup {

    private String groupId;
    private Boolean activeInd;
    private String startDateActionCd;
    private String startDt;
    private String endDateActionCd;
    private String endDt;
    private Boolean systemGenerationDateInd;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Boolean getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(Boolean activeInd) {
        this.activeInd = activeInd;
    }

    public String getStartDateActionCd() {
        return startDateActionCd;
    }

    public void setStartDateActionCd(String startDateActionCd) {
        this.startDateActionCd = startDateActionCd;
    }

    public String getStartDt() {
        return startDt;
    }

    public void setStartDt(String startDt) {
        this.startDt = startDt;
    }

    public String getEndDateActionCd() {
        return endDateActionCd;
    }

    public void setEndDateActionCd(String endDateActionCd) {
        this.endDateActionCd = endDateActionCd;
    }

    public String getEndDt() {
        return endDt;
    }

    public void setEndDt(String endDt) {
        this.endDt = endDt;
    }

    public Boolean getSystemGenerationDateInd() {
        return systemGenerationDateInd;
    }

    public void setSystemGenerationDateInd(Boolean systemGenerationDateInd) {
        this.systemGenerationDateInd = systemGenerationDateInd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AlternateDisclosureGroup.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("groupId");
        sb.append('=');
        sb.append(((this.groupId == null)?"<null>":this.groupId));
        sb.append(',');
        sb.append("activeInd");
        sb.append('=');
        sb.append(((this.activeInd == null)?"<null>":this.activeInd));
        sb.append(',');
        sb.append("startDateActionCd");
        sb.append('=');
        sb.append(((this.startDateActionCd == null)?"<null>":this.startDateActionCd));
        sb.append(',');
        sb.append("startDt");
        sb.append('=');
        sb.append(((this.startDt == null)?"<null>":this.startDt));
        sb.append(',');
        sb.append("endDateActionCd");
        sb.append('=');
        sb.append(((this.endDateActionCd == null)?"<null>":this.endDateActionCd));
        sb.append(',');
        sb.append("endDt");
        sb.append('=');
        sb.append(((this.endDt == null)?"<null>":this.endDt));
        sb.append(',');
        sb.append("systemGenerationDateInd");
        sb.append('=');
        sb.append(((this.systemGenerationDateInd == null)?"<null>":this.systemGenerationDateInd));
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
        result = ((result* 31)+((this.activeInd == null)? 0 :this.activeInd.hashCode()));
        result = ((result* 31)+((this.groupId == null)? 0 :this.groupId.hashCode()));
        result = ((result* 31)+((this.startDateActionCd == null)? 0 :this.startDateActionCd.hashCode()));
        result = ((result* 31)+((this.startDt == null)? 0 :this.startDt.hashCode()));
        result = ((result* 31)+((this.endDt == null)? 0 :this.endDt.hashCode()));
        result = ((result* 31)+((this.endDateActionCd == null)? 0 :this.endDateActionCd.hashCode()));
        result = ((result* 31)+((this.systemGenerationDateInd == null)? 0 :this.systemGenerationDateInd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AlternateDisclosureGroup) == false) {
            return false;
        }
        AlternateDisclosureGroup rhs = ((AlternateDisclosureGroup) other);
        return ((((((((this.activeInd == rhs.activeInd)||((this.activeInd!= null)&&this.activeInd.equals(rhs.activeInd)))&&((this.groupId == rhs.groupId)||((this.groupId!= null)&&this.groupId.equals(rhs.groupId))))&&((this.startDateActionCd == rhs.startDateActionCd)||((this.startDateActionCd!= null)&&this.startDateActionCd.equals(rhs.startDateActionCd))))&&((this.startDt == rhs.startDt)||((this.startDt!= null)&&this.startDt.equals(rhs.startDt))))&&((this.endDt == rhs.endDt)||((this.endDt!= null)&&this.endDt.equals(rhs.endDt))))&&((this.endDateActionCd == rhs.endDateActionCd)||((this.endDateActionCd!= null)&&this.endDateActionCd.equals(rhs.endDateActionCd))))&&((this.systemGenerationDateInd == rhs.systemGenerationDateInd)||((this.systemGenerationDateInd!= null)&&this.systemGenerationDateInd.equals(rhs.systemGenerationDateInd))));
    }

}
