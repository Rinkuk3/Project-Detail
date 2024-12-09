package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class ROfferType implements Serializable {

	private static final long serialVersionUID = 157286161073427626L;
    private String disclosureId;

    public String getDisclosureId() {
        return disclosureId;
    }

    public void setDisclosureId(String disclosureId) {
        this.disclosureId = disclosureId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ROfferType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("disclosureId");
        sb.append('=');
        sb.append(((this.disclosureId == null)?"<null>":this.disclosureId));
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
        result = ((result* 31)+((this.disclosureId == null)? 0 :this.disclosureId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ROfferType) == false) {
            return false;
        }
        ROfferType rhs = ((ROfferType) other);
        return ((this.disclosureId == rhs.disclosureId)||((this.disclosureId!= null)&&this.disclosureId.equals(rhs.disclosureId)));
    }

}
