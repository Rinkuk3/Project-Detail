
package com.td.api.mbcapd.response.retrievecapd;

import java.util.ArrayList;
import java.util.List;

public class AlertGroup {

    private String groupCd;
    private Boolean blocklistedInd;
    private List<AlertType> alertType = new ArrayList<AlertType>();

    public String getGroupCd() {
        return groupCd;
    }

    public void setGroupCd(String groupCd) {
        this.groupCd = groupCd;
    }

    public Boolean getBlocklistedInd() {
        return blocklistedInd;
    }

    public void setBlocklistedInd(Boolean blocklistedInd) {
        this.blocklistedInd = blocklistedInd;
    }

    public List<AlertType> getAlertType() {
        return alertType;
    }

    public void setAlertType(List<AlertType> alertType) {
        this.alertType = alertType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AlertGroup.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("groupCd");
        sb.append('=');
        sb.append(((this.groupCd == null)?"<null>":this.groupCd));
        sb.append(',');
        sb.append("blocklistedInd");
        sb.append('=');
        sb.append(((this.blocklistedInd == null)?"<null>":this.blocklistedInd));
        sb.append(',');
        sb.append("alertType");
        sb.append('=');
        sb.append(((this.alertType == null)?"<null>":this.alertType));
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
        result = ((result* 31)+((this.blocklistedInd == null)? 0 :this.blocklistedInd.hashCode()));
        result = ((result* 31)+((this.alertType == null)? 0 :this.alertType.hashCode()));
        result = ((result* 31)+((this.groupCd == null)? 0 :this.groupCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AlertGroup) == false) {
            return false;
        }
        AlertGroup rhs = ((AlertGroup) other);
        return ((((this.blocklistedInd == rhs.blocklistedInd)||((this.blocklistedInd!= null)&&this.blocklistedInd.equals(rhs.blocklistedInd)))&&((this.alertType == rhs.alertType)||((this.alertType!= null)&&this.alertType.equals(rhs.alertType))))&&((this.groupCd == rhs.groupCd)||((this.groupCd!= null)&&this.groupCd.equals(rhs.groupCd))));
    }

}
