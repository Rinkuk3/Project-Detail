package com.td.mbna.msec.midtier.cardlock.payload;

import com.td.mbna.msec.midtier.types.common.BaseResponse;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

public class CardLockResponse extends BaseResponse {

    private ResponsePayload responsePayload;

    public ResponsePayload getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(ResponsePayload responsePayload) {
        this.responsePayload = responsePayload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardLockResponse)) return false;
        CardLockResponse that = (CardLockResponse) o;
        return Objects.equals(getResponsePayload(), that.getResponsePayload());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResponsePayload());
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("responsePayload", responsePayload)
                .toString();
    }
}
