package com.td.mbna.msec.midtier.cardlock.payload;

import com.td.mbna.msec.midtier.types.common.BaseRequest;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CardLockRequest extends BaseRequest {

    private static final long serialVersionUID = 660748238846653520L;

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

        if (!(o instanceof CardLockRequest)) return false;

        CardLockRequest that = (CardLockRequest) o;

        return new EqualsBuilder().appendSuper(super.equals(o)).append(getRequestPayload(), that.getRequestPayload()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(getRequestPayload()).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("requestPayload", requestPayload)
                .append("custId", custId)
                .append("auditInfo", auditInfo)
                .append("aliasCustId", aliasCustId)
                .append("acctNum", acctNum)
                .append("acctType", acctType)
                .append("languagePref", languagePref)
                .append("reserved1", reserved1)
                .append("custInterface", custInterface)
                .append("isPrimaryUser", isPrimaryUser)
                .append("isMultiCard", isMultiCard)
                .append("cardNum", cardNum)
                .append("sessionInfo", sessionInfo)
                .toString();
    }
}
