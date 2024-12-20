package com.td.api.mbcca.creditcard.response;

public class AlternateDisclosureGroup {

    private Boolean activeInd;
    private String systemGeneratedStartDt;
    private String systemGeneratedEndDt;

    public Boolean getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(Boolean activeInd) {
        this.activeInd = activeInd;
    }

    public String getSystemGeneratedStartDt() {
        return systemGeneratedStartDt;
    }

    public void setSystemGeneratedStartDt(String systemGeneratedStartDt) {
        this.systemGeneratedStartDt = systemGeneratedStartDt;
    }

    public String getSystemGeneratedEndDt() {
        return systemGeneratedEndDt;
    }

    public void setSystemGeneratedEndDt(String systemGeneratedEndDt) {
        this.systemGeneratedEndDt = systemGeneratedEndDt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AlternateDisclosureGroup.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("activeInd");
        sb.append('=');
        sb.append(((this.activeInd == null)?"<null>":this.activeInd));
        sb.append(',');
        sb.append("systemGeneratedStartDt");
        sb.append('=');
        sb.append(((this.systemGeneratedStartDt == null)?"<null>":this.systemGeneratedStartDt));
        sb.append(',');
        sb.append("systemGeneratedEndDt");
        sb.append('=');
        sb.append(((this.systemGeneratedEndDt == null)?"<null>":this.systemGeneratedEndDt));
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
        result = ((result* 31)+((this.systemGeneratedStartDt == null)? 0 :this.systemGeneratedStartDt.hashCode()));
        result = ((result* 31)+((this.systemGeneratedEndDt == null)? 0 :this.systemGeneratedEndDt.hashCode()));
        result = ((result* 31)+((this.activeInd == null)? 0 :this.activeInd.hashCode()));
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
        return ((((this.systemGeneratedStartDt == rhs.systemGeneratedStartDt)||((this.systemGeneratedStartDt!= null)&&this.systemGeneratedStartDt.equals(rhs.systemGeneratedStartDt)))&&((this.systemGeneratedEndDt == rhs.systemGeneratedEndDt)||((this.systemGeneratedEndDt!= null)&&this.systemGeneratedEndDt.equals(rhs.systemGeneratedEndDt))))&&((this.activeInd == rhs.activeInd)||((this.activeInd!= null)&&this.activeInd.equals(rhs.activeInd))));
    }

}
