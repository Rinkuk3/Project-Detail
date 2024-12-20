package com.td.mbna.msec.midtier.offers.payload.requestInstallmentPlan;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.td.mbna.msec.midtier.types.common.DisclosureInfoType;
import com.td.mbna.msec.midtier.types.common.InstallmentPlanDetails;

public class ResponsePayload {

    private List<DisclosureInfoType> disclosureInfo = new ArrayList<DisclosureInfoType>();

    private InstallmentPlanDetails installmentPlanDetails;

    private String eventId;

    private String dynamicDisclosureContent;

    private String staticDisclosureContent;

    private Boolean moreIpEligibleTransactionsAvailable;

    public String getDynamicDisclosureContent() {
        return dynamicDisclosureContent;
    }

    public void setDynamicDisclosureContent(String dynamicDisclosureContent) {
        this.dynamicDisclosureContent = dynamicDisclosureContent;
    }

    public String getStaticDisclosureContent() {
        return staticDisclosureContent;
    }

    public void setStaticDisclosureContent(String staticDisclosureContent) {
        this.staticDisclosureContent = staticDisclosureContent;
    }

    public Boolean getMoreIpEligibleTransactionsAvailable() {
        return moreIpEligibleTransactionsAvailable;
    }

    public void setMoreIpEligibleTransactionsAvailable(Boolean moreIpEligibleTransactionsAvailable) {
        this.moreIpEligibleTransactionsAvailable = moreIpEligibleTransactionsAvailable;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public List<DisclosureInfoType> getDisclosureInfo() {
        return disclosureInfo;
    }

    public void setDisclosureInfo(List<DisclosureInfoType> disclosureInfo) {
        this.disclosureInfo = disclosureInfo;
    }

    public InstallmentPlanDetails getInstallmentPlanDetails() {
        return installmentPlanDetails;
    }

    public void setInstallmentPlanDetails(InstallmentPlanDetails installmentPlanDetails) {
        this.installmentPlanDetails = installmentPlanDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponsePayload that = (ResponsePayload) o;
        return Objects.equals(disclosureInfo, that.disclosureInfo) &&
                Objects.equals(installmentPlanDetails, that.installmentPlanDetails) &&
                Objects.equals(eventId, that.eventId) &&
                Objects.equals(dynamicDisclosureContent, that.dynamicDisclosureContent) &&
                Objects.equals(staticDisclosureContent, that.staticDisclosureContent) &&
                Objects.equals(moreIpEligibleTransactionsAvailable, that.moreIpEligibleTransactionsAvailable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disclosureInfo, installmentPlanDetails, eventId, dynamicDisclosureContent, staticDisclosureContent, moreIpEligibleTransactionsAvailable);
    }

    @Override
    public String toString() {
        return "ResponsePayload{" +
                "disclosureInfo=" + disclosureInfo +
                ", installmentPlanDetails=" + installmentPlanDetails +
                ", eventId='" + eventId + '\'' +
                ", dynamicDisclosureContent='" + dynamicDisclosureContent + '\'' +
                ", staticDisclosureContent='" + staticDisclosureContent + '\'' +
                ", moreIpEligibleTransactionsAvailable=" + moreIpEligibleTransactionsAvailable +
                '}';
    }
}