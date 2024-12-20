
package com.td.api.mbcapd.response.retrievecapd;

import java.util.ArrayList;
import java.util.List;

public class AlertBlocklistSetup {

    private String bankingLineOfBusinessCd;
    private List<AlertGroup> alertGroup = new ArrayList<AlertGroup>();

    public String getBankingLineOfBusinessCd() {
        return bankingLineOfBusinessCd;
    }

    public void setBankingLineOfBusinessCd(String bankingLineOfBusinessCd) {
        this.bankingLineOfBusinessCd = bankingLineOfBusinessCd;
    }
    
    public List<AlertGroup> getAlertGroup() {
        return alertGroup;
    }

    public void setAlertGroup(List<AlertGroup> alertGroup) {
        this.alertGroup = alertGroup;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AlertBlocklistSetup.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("bankingLineOfBusinessCd");
        sb.append('=');
        sb.append(((this.bankingLineOfBusinessCd == null)?"<null>":this.bankingLineOfBusinessCd));
        sb.append(',');
        sb.append("alertGroup");
        sb.append('=');
        sb.append(((this.alertGroup == null)?"<null>":this.alertGroup));
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
        result = ((result* 31)+((this.alertGroup == null)? 0 :this.alertGroup.hashCode()));
        result = ((result* 31)+((this.bankingLineOfBusinessCd == null)? 0 :this.bankingLineOfBusinessCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AlertBlocklistSetup) == false) {
            return false;
        }
        AlertBlocklistSetup rhs = ((AlertBlocklistSetup) other);
        return (((this.alertGroup == rhs.alertGroup)||((this.alertGroup!= null)&&this.alertGroup.equals(rhs.alertGroup)))&&((this.bankingLineOfBusinessCd == rhs.bankingLineOfBusinessCd)||((this.bankingLineOfBusinessCd!= null)&&this.bankingLineOfBusinessCd.equals(rhs.bankingLineOfBusinessCd))));
    }
}
