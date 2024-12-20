package com.td.mbna.msec.midtier.disclosure.payload.getdisclosure;

import com.td.mbna.msec.midtier.types.common.DisclosureInputType;

public class RequestPayload {

    private String disclosureType;
    private DisclosureInputType disclosureInput;

    public String getDisclosureType() {
        return disclosureType;
    }

    public void setDisclosureType(String disclosureType) {
        this.disclosureType = disclosureType;
    }

    public DisclosureInputType getDisclosureInput() {
        return disclosureInput;
    }

    public void setDisclosureInput(DisclosureInputType disclosureInput) {
        this.disclosureInput = disclosureInput;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RequestPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("disclosureType");
        sb.append('=');
        sb.append(((this.disclosureType == null)?"<null>":this.disclosureType));
        sb.append(',');
        sb.append("disclosureInput");
        sb.append('=');
        sb.append(((this.disclosureInput == null)?"<null>":this.disclosureInput));
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
        result = ((result* 31)+((this.disclosureType == null)? 0 :this.disclosureType.hashCode()));
        result = ((result* 31)+((this.disclosureInput == null)? 0 :this.disclosureInput.hashCode()));
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
        return (((this.disclosureType == rhs.disclosureType)||((this.disclosureType!= null)&&this.disclosureType.equals(rhs.disclosureType)))&&((this.disclosureInput == rhs.disclosureInput)||((this.disclosureInput!= null)&&this.disclosureInput.equals(rhs.disclosureInput))));
    }

}
