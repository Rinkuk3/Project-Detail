package com.td.mbna.msec.midtier.offers.payload.cancelInstallmentPlan;

import java.util.Objects;

public class ResponsePayload {

    public enum RefundStatus {NOT_ELIGIBLE,PASSED,FAILED};

    private Boolean cancelStatus = false;
    private RefundStatus refundStatus = RefundStatus.NOT_ELIGIBLE;

    public Boolean getCancelStatus() {
        return cancelStatus;
    }

    public void setCancelStatus(Boolean cancelStatus) {
        this.cancelStatus = cancelStatus;
    }

    public RefundStatus getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(RefundStatus refundStatus) {
        this.refundStatus = refundStatus;
    }

    @Override
    public String toString() {
        return "ResponsePayload{" +
                "cancelStatus=" + cancelStatus +
                ", refundStatus=" + refundStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponsePayload that = (ResponsePayload) o;
        return Objects.equals(cancelStatus, that.cancelStatus) &&
                Objects.equals(refundStatus, that.refundStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cancelStatus, refundStatus);
    }
}
