package com.td.mbna.msec.midtier.types.eligibility;

import java.io.Serializable;

import com.td.mbna.msec.midtier.types.common.EligIdType;

public class EligType implements Serializable {

	private static final long serialVersionUID = 1L;
    private EligIdType eligId;
    private Boolean eligValue;

    public EligIdType getEligId() {
        return eligId;
    }

    public void setEligId(EligIdType eligId) {
        this.eligId = eligId;
    }

    public Boolean isEligValue() {
        return eligValue;
    }

    public void setEligValue(Boolean eligValue) {
        this.eligValue = eligValue;
    }

    public Boolean getEligValue() {
        return eligValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EligType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("eligId");
        sb.append('=');
        sb.append(((this.eligId == null)?"<null>":this.eligId));
        sb.append(',');
        sb.append("eligValue");
        sb.append('=');
        sb.append(((this.eligValue == null)?"<null>":this.eligValue));
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
        result = ((result* 31)+((this.eligId == null)? 0 :this.eligId.hashCode()));
        result = ((result* 31)+((this.eligValue == null)? 0 :this.eligValue.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EligType) == false) {
            return false;
        }
        EligType rhs = ((EligType) other);
        return (((this.eligId == rhs.eligId)||((this.eligId!= null)&&this.eligId.equals(rhs.eligId)))&&((this.eligValue == rhs.eligValue)||((this.eligValue!= null)&&this.eligValue.equals(rhs.eligValue))));
    }
}
