package com.td.mbna.msec.midtier.offers.payload.cancelInstallmentPlan;

import java.util.Objects;

import com.td.mbna.msec.midtier.types.common.BaseRequest;

public class CancelInstallmentPlanRequest extends BaseRequest {

    private static final long serialVersionUID = 3742292828977276848L;

    private RequestPayload requestPayload;

    public RequestPayload getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(RequestPayload requestPayload) {
        this.requestPayload = requestPayload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CancelInstallmentPlanRequest that = (CancelInstallmentPlanRequest) o;
        return Objects.equals(requestPayload, that.requestPayload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), requestPayload);
    }
}