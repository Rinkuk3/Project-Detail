package com.td.mbna.msec.midtier.cardlock.payload;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

public class CardAuthorizationStatus {

    private Boolean active;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardAuthorizationStatus)) return false;
        CardAuthorizationStatus that = (CardAuthorizationStatus) o;
        return Objects.equals(getActive(), that.getActive());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActive());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("active", active)
                .toString();
    }
}
