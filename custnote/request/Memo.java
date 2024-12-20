package com.td.api.mbcca.custnote.request;

import java.util.ArrayList;
import java.util.List;

public class Memo {

    private String eventTypeCd;
    private List<String> lineTxt = new ArrayList<String>();

    public String getEventTypeCd() {
        return eventTypeCd;
    }

    public void setEventTypeCd(String eventTypeCd) {
        this.eventTypeCd = eventTypeCd;
    }

    public List<String> getLineTxt() {
        return lineTxt;
    }

    public void setLineTxt(List<String> lineTxt) {
        this.lineTxt = lineTxt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Memo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("eventTypeCd");
        sb.append('=');
        sb.append(((this.eventTypeCd == null)?"<null>":this.eventTypeCd));
        sb.append(',');
        sb.append("lineTxt");
        sb.append('=');
        sb.append(((this.lineTxt == null)?"<null>":this.lineTxt));
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
        result = ((result* 31)+((this.eventTypeCd == null)? 0 :this.eventTypeCd.hashCode()));
        result = ((result* 31)+((this.lineTxt == null)? 0 :this.lineTxt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Memo) == false) {
            return false;
        }
        Memo rhs = ((Memo) other);
        return (((this.eventTypeCd == rhs.eventTypeCd)||((this.eventTypeCd!= null)&&this.eventTypeCd.equals(rhs.eventTypeCd)))&&((this.lineTxt == rhs.lineTxt)||((this.lineTxt!= null)&&this.lineTxt.equals(rhs.lineTxt))));
    }

}
