package com.td.api.ofm.response;

import java.util.ArrayList;
import java.util.List;

import com.td.api.ofm.common.TCCAAPIBalanceSegmentEventDetail;
import com.td.api.ofm.common.TRecCtrlPageOut;

public class TSvcRetrieveCreditCardAgreementBalanceSegmentEventListRs {

    private TRecCtrlPageOut pagination;
    private List<TCCAAPIBalanceSegmentEventDetail> balanceSegmentEvent = new ArrayList<TCCAAPIBalanceSegmentEventDetail>();

    public TRecCtrlPageOut getPagination() {
        return pagination;
    }

    public void setPagination(TRecCtrlPageOut pagination) {
        this.pagination = pagination;
    }

    public List<TCCAAPIBalanceSegmentEventDetail> getBalanceSegmentEvent() {
        return balanceSegmentEvent;
    }

    public void setBalanceSegmentEvent(List<TCCAAPIBalanceSegmentEventDetail> balanceSegmentEvent) {
        this.balanceSegmentEvent = balanceSegmentEvent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TSvcRetrieveCreditCardAgreementBalanceSegmentEventListRs.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("pagination");
        sb.append('=');
        sb.append(((this.pagination == null)?"<null>":this.pagination));
        sb.append(',');
        sb.append("balanceSegmentEvent");
        sb.append('=');
        sb.append(((this.balanceSegmentEvent == null)?"<null>":this.balanceSegmentEvent));
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
        result = ((result* 31)+((this.balanceSegmentEvent == null)? 0 :this.balanceSegmentEvent.hashCode()));
        result = ((result* 31)+((this.pagination == null)? 0 :this.pagination.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TSvcRetrieveCreditCardAgreementBalanceSegmentEventListRs) == false) {
            return false;
        }
        TSvcRetrieveCreditCardAgreementBalanceSegmentEventListRs rhs = ((TSvcRetrieveCreditCardAgreementBalanceSegmentEventListRs) other);
        return (((this.balanceSegmentEvent == rhs.balanceSegmentEvent)||((this.balanceSegmentEvent!= null)&&this.balanceSegmentEvent.equals(rhs.balanceSegmentEvent)))&&((this.pagination == rhs.pagination)||((this.pagination!= null)&&this.pagination.equals(rhs.pagination))));
    }

}
