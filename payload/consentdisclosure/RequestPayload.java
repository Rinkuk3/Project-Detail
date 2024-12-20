package com.td.mbna.msec.midtier.disclosure.payload.consentdisclosure;

import java.util.ArrayList;
import java.util.List;

import com.td.mbna.msec.midtier.types.common.DisclosureInfoType;

public class RequestPayload {

    private List<DisclosureInfoType> disclosureInfo = new ArrayList<DisclosureInfoType>();
    private String connectId;

    public List<DisclosureInfoType> getDisclosureInfo() {
        return disclosureInfo;
    }

    public void setDisclosureInfo(List<DisclosureInfoType> disclosureInfo) {
        this.disclosureInfo = disclosureInfo;
    }

    public String getConnectId() {
        return connectId;
    }

    public void setConnectId(String connectId) {
        this.connectId = connectId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("disclosureInfo");
        sb.append('=');
        sb.append(((this.disclosureInfo == null)?"<null>":this.disclosureInfo));
        sb.append(',');
        sb.append("connectId");
        sb.append('=');
        sb.append(((this.connectId == null)?"<null>":this.connectId));
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
        result = ((result* 31)+((this.connectId == null)? 0 :this.connectId.hashCode()));
        result = ((result* 31)+((this.disclosureInfo == null)? 0 :this.disclosureInfo.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestPayload) == false) {
            return false;
        }
        RequestPayload rhs = ((RequestPayload) other);
        return (((this.connectId == rhs.connectId)||((this.connectId!= null)&&this.connectId.equals(rhs.connectId)))&&((this.disclosureInfo == rhs.disclosureInfo)||((this.disclosureInfo!= null)&&this.disclosureInfo.equals(rhs.disclosureInfo))));
    }

}
