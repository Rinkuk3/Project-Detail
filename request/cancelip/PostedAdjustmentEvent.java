package com.td.api.mbcca.request.cancelip;

import java.util.ArrayList;
import java.util.List;

public class PostedAdjustmentEvent {

    private String postedEventId;
    private PostedEventAltkey postedEventAltkey;
    private List<AdjustmentEvent> adjustmentEvent = new ArrayList<AdjustmentEvent>();

    public String getPostedEventId() {
        return postedEventId;
    }

    public void setPostedEventId(String postedEventId) {
        this.postedEventId = postedEventId;
    }

    public PostedEventAltkey getPostedEventAltkey() {
        return postedEventAltkey;
    }

    public void setPostedEventAltkey(PostedEventAltkey postedEventAltkey) {
        this.postedEventAltkey = postedEventAltkey;
    }

    public List<AdjustmentEvent> getAdjustmentEvent() {
        return adjustmentEvent;
    }

    public void setAdjustmentEvent(List<AdjustmentEvent> adjustmentEvent) {
        this.adjustmentEvent = adjustmentEvent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PostedAdjustmentEvent.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("postedEventId");
        sb.append('=');
        sb.append(((this.postedEventId == null)?"<null>":this.postedEventId));
        sb.append(',');
        sb.append("postedEventAltkey");
        sb.append('=');
        sb.append(((this.postedEventAltkey == null)?"<null>":this.postedEventAltkey));
        sb.append(',');
        sb.append("adjustmentEvent");
        sb.append('=');
        sb.append(((this.adjustmentEvent == null)?"<null>":this.adjustmentEvent));
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
        result = ((result* 31)+((this.postedEventId == null)? 0 :this.postedEventId.hashCode()));
        result = ((result* 31)+((this.adjustmentEvent == null)? 0 :this.adjustmentEvent.hashCode()));
        result = ((result* 31)+((this.postedEventAltkey == null)? 0 :this.postedEventAltkey.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PostedAdjustmentEvent) == false) {
            return false;
        }
        PostedAdjustmentEvent rhs = ((PostedAdjustmentEvent) other);
        return ((((this.postedEventId == rhs.postedEventId)||((this.postedEventId!= null)&&this.postedEventId.equals(rhs.postedEventId)))&&((this.adjustmentEvent == rhs.adjustmentEvent)||((this.adjustmentEvent!= null)&&this.adjustmentEvent.equals(rhs.adjustmentEvent))))&&((this.postedEventAltkey == rhs.postedEventAltkey)||((this.postedEventAltkey!= null)&&this.postedEventAltkey.equals(rhs.postedEventAltkey))));
    }

}
