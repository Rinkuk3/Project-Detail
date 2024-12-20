
package com.td.api.mbcapd.response.retrievecapd;

import java.util.ArrayList;
import java.util.List;

public class AlertSetup {
    private String alertSetupId;
    private String alertTypeCd;
    private String alertSetupVal;
    private String deliveryMethodCd;
    private List<String> alertSetupOptionVal = new ArrayList<String>();
    private Boolean thresholdExceededInd;
    private String alertBlocklistSetupGroupCd;

    public String getAlertSetupId() {
        return alertSetupId;
    }

    public void setAlertSetupId(String alertSetupId) {
        this.alertSetupId = alertSetupId;
    }

    public String getAlertTypeCd() {
        return alertTypeCd;
    }

    public void setAlertTypeCd(String alertTypeCd) {
        this.alertTypeCd = alertTypeCd;
    }

    public String getAlertSetupVal() {
        return alertSetupVal;
    }

    public void setAlertSetupVal(String alertSetupVal) {
        this.alertSetupVal = alertSetupVal;
    }


    public String getDeliveryMethodCd() {
        return deliveryMethodCd;
    }

    public void setDeliveryMethodCd(String deliveryMethodCd) {
        this.deliveryMethodCd = deliveryMethodCd;
    }

    public List<String> getAlertSetupOptionVal() {
        return alertSetupOptionVal;
    }

    public void setAlertSetupOptionVal(List<String> alertSetupOptionVal) {
        this.alertSetupOptionVal = alertSetupOptionVal;
    }

    public Boolean getThresholdExceededInd() {
        return thresholdExceededInd;
    }

    public void setThresholdExceededInd(Boolean thresholdExceededInd) {
        this.thresholdExceededInd = thresholdExceededInd;
    }

    public String getAlertBlocklistSetupGroupCd() {
        return alertBlocklistSetupGroupCd;
    }

    public void setAlertBlocklistSetupGroupCd(String alertBlocklistSetupGroupCd) {
        this.alertBlocklistSetupGroupCd = alertBlocklistSetupGroupCd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AlertSetup.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("alertSetupId");
        sb.append('=');
        sb.append(((this.alertSetupId == null)?"<null>":this.alertSetupId));
        sb.append(',');
        sb.append("alertTypeCd");
        sb.append('=');
        sb.append(((this.alertTypeCd == null)?"<null>":this.alertTypeCd));
        sb.append(',');
        sb.append("alertSetupVal");
        sb.append('=');
        sb.append(((this.alertSetupVal == null)?"<null>":this.alertSetupVal));
        sb.append(',');
        sb.append("deliveryMethodCd");
        sb.append('=');
        sb.append(((this.deliveryMethodCd == null)?"<null>":this.deliveryMethodCd));
        sb.append(',');
        sb.append("alertSetupOptionVal");
        sb.append('=');
        sb.append(((this.alertSetupOptionVal == null)?"<null>":this.alertSetupOptionVal));
        sb.append(',');
        sb.append("thresholdExceededInd");
        sb.append('=');
        sb.append(((this.thresholdExceededInd == null)?"<null>":this.thresholdExceededInd));
        sb.append(',');
        sb.append("alertBlocklistSetupGroupCd");
        sb.append('=');
        sb.append(((this.alertBlocklistSetupGroupCd == null)?"<null>":this.alertBlocklistSetupGroupCd));
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
        result = ((result* 31)+((this.alertSetupId == null)? 0 :this.alertSetupId.hashCode()));
        result = ((result* 31)+((this.deliveryMethodCd == null)? 0 :this.deliveryMethodCd.hashCode()));
        result = ((result* 31)+((this.alertSetupVal == null)? 0 :this.alertSetupVal.hashCode()));
        result = ((result* 31)+((this.alertTypeCd == null)? 0 :this.alertTypeCd.hashCode()));
        result = ((result* 31)+((this.alertSetupOptionVal == null)? 0 :this.alertSetupOptionVal.hashCode()));
        result = ((result* 31)+((this.alertBlocklistSetupGroupCd == null)? 0 :this.alertBlocklistSetupGroupCd.hashCode()));
        result = ((result* 31)+((this.thresholdExceededInd == null)? 0 :this.thresholdExceededInd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AlertSetup) == false) {
            return false;
        }
        AlertSetup rhs = ((AlertSetup) other);
        return ((((((((this.alertSetupId == rhs.alertSetupId)||((this.alertSetupId!= null)&&this.alertSetupId.equals(rhs.alertSetupId)))&&((this.deliveryMethodCd == rhs.deliveryMethodCd)||((this.deliveryMethodCd!= null)&&this.deliveryMethodCd.equals(rhs.deliveryMethodCd))))&&((this.alertSetupVal == rhs.alertSetupVal)||((this.alertSetupVal!= null)&&this.alertSetupVal.equals(rhs.alertSetupVal))))&&((this.alertTypeCd == rhs.alertTypeCd)||((this.alertTypeCd!= null)&&this.alertTypeCd.equals(rhs.alertTypeCd))))&&((this.alertSetupOptionVal == rhs.alertSetupOptionVal)||((this.alertSetupOptionVal!= null)&&this.alertSetupOptionVal.equals(rhs.alertSetupOptionVal))))&&((this.alertBlocklistSetupGroupCd == rhs.alertBlocklistSetupGroupCd)||((this.alertBlocklistSetupGroupCd!= null)&&this.alertBlocklistSetupGroupCd.equals(rhs.alertBlocklistSetupGroupCd))))&&((this.thresholdExceededInd == rhs.thresholdExceededInd)||((this.thresholdExceededInd!= null)&&this.thresholdExceededInd.equals(rhs.thresholdExceededInd))));
    }

}
