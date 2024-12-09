package com.td.mbna.msec.midtier.types.common;

import com.google.gson.annotations.JsonAdapter;
import com.td.mbna.msec.midtier.serializers.GsonDateDeSerializer;

import java.io.Serializable;

public class CardNumHistoryType implements Serializable {

	private static final long serialVersionUID = -7453527460429556326L;
    private String card;
    private String cardHolderName;
    private String status;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long startDate;
    @JsonAdapter(value = GsonDateDeSerializer.class)
    private Long endDate;

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CardNumHistoryType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("card");
        sb.append('=');
        sb.append(((this.card == null) ? "<null>" : this.card));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null) ? "<null>" : this.status));
        sb.append(',');
        sb.append("startDate");
        sb.append('=');
        sb.append(((this.startDate == null) ? "<null>" : this.startDate));
        sb.append(',');
        sb.append("endDate");
        sb.append('=');
        sb.append(((this.endDate == null) ? "<null>" : this.endDate));
        sb.append(',');
        sb.append("cardHolderName");
        sb.append('=');
        sb.append(((this.cardHolderName == null) ? "<null>" : this.cardHolderName));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.endDate == null) ? 0 : this.endDate.hashCode()));
        result = ((result * 31) + ((this.card == null) ? 0 : this.card.hashCode()));
        result = ((result * 31) + ((this.startDate == null) ? 0 : this.startDate.hashCode()));
        result = ((result * 31) + ((this.status == null) ? 0 : this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CardNumHistoryType) == false) {
            return false;
        }
        CardNumHistoryType rhs = ((CardNumHistoryType) other);
        return (((((this.endDate == rhs.endDate) || ((this.endDate != null) && this.endDate.equals(rhs.endDate))) && ((this.card == rhs.card) || ((this.card != null) && this.card.equals(rhs.card)))) && ((this.startDate == rhs.startDate) || ((this.startDate != null) && this.startDate.equals(rhs.startDate)))) && ((this.status == rhs.status) || ((this.status != null) && this.status.equals(rhs.status))));
    }

}
