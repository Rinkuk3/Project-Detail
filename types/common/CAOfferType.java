package com.td.mbna.msec.midtier.types.common;

import java.io.Serializable;

public class CAOfferType implements Serializable {

	private static final long serialVersionUID = 3725475094922569362L;
    private String disclosureId;
    private String eligibleNegotiatedType;

    public String getDisclosureId() {
        return disclosureId;
    }

    public void setDisclosureId(String disclosureId) {
        this.disclosureId = disclosureId;
    }

    public String getEligibleNegotiatedType() {
        return eligibleNegotiatedType;
    }

    public void setEligibleNegotiatedType(String eligibleNegotiatedType) {
        this.eligibleNegotiatedType = eligibleNegotiatedType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CAOfferType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("disclosureId");
        sb.append('=');
        sb.append(((this.disclosureId == null)?"<null>":this.disclosureId));
        sb.append(',');
        sb.append("eligibleNegotiatedType");
        sb.append('=');
        sb.append(((this.eligibleNegotiatedType == null)?"<null>":this.eligibleNegotiatedType));
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
        result = ((result* 31)+((this.eligibleNegotiatedType == null)? 0 :this.eligibleNegotiatedType.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CAOfferType) == false) {
            return false;
        }
        CAOfferType rhs = ((CAOfferType) other);
        return (((this.disclosureId == rhs.disclosureId)||((this.disclosureId!= null)&&this.disclosureId.equals(rhs.disclosureId)))&&((this.eligibleNegotiatedType == rhs.eligibleNegotiatedType)||((this.eligibleNegotiatedType!= null)&&this.eligibleNegotiatedType.equals(rhs.eligibleNegotiatedType))));
    }

}
