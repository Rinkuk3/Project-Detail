package com.td.mbna.msec.midtier.content.payload.getlinkcontent;

import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.content.payload.LinkContentType;

public class ResponsePayload {

    private List<LinkContentType> linkContent = new ArrayList<LinkContentType>();

    public List<LinkContentType> getLinkContent() {
        return linkContent;
    }

    public void setLinkContent(List<LinkContentType> linkContent) {
        this.linkContent = linkContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ResponsePayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("linkContent");
        sb.append('=');
        sb.append(((this.linkContent == null)?"<null>":this.linkContent));
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
        result = ((result* 31)+((this.linkContent == null)? 0 :this.linkContent.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResponsePayload) == false) {
            return false;
        }
        ResponsePayload rhs = ((ResponsePayload) other);
        return ((this.linkContent == rhs.linkContent)||((this.linkContent!= null)&&this.linkContent.equals(rhs.linkContent)));
    }

}
