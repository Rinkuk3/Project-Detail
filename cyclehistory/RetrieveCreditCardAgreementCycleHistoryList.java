package com.td.api.mbcca.response.account.cyclehistory;

import java.util.ArrayList;
import java.util.List;

import com.td.api.mbcca.response.account.CycleInfo;
import com.td.api.mbcca.shared.Status;

public class RetrieveCreditCardAgreementCycleHistoryList {

    private Status status;
    private List<CycleInfo> cycleInfo = new ArrayList<CycleInfo>();

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<CycleInfo> getCycleInfo() {
        return cycleInfo;
    }

    public void setCycleInfo(List<CycleInfo> cycleInfo) {
        this.cycleInfo = cycleInfo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RetrieveCreditCardAgreementCycleHistoryList.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("cycleInfo");
        sb.append('=');
        sb.append(((this.cycleInfo == null)?"<null>":this.cycleInfo));
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
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        result = ((result* 31)+((this.cycleInfo == null)? 0 :this.cycleInfo.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RetrieveCreditCardAgreementCycleHistoryList) == false) {
            return false;
        }
        RetrieveCreditCardAgreementCycleHistoryList rhs = ((RetrieveCreditCardAgreementCycleHistoryList) other);
        return (((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status)))&&((this.cycleInfo == rhs.cycleInfo)||((this.cycleInfo!= null)&&this.cycleInfo.equals(rhs.cycleInfo))));
    }

}
