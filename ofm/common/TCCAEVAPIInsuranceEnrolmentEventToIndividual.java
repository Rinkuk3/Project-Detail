package com.td.api.ofm.common;

public class TCCAEVAPIInsuranceEnrolmentEventToIndividual {

    private String partyId;

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TCCAEVAPIInsuranceEnrolmentEventToIndividual.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("partyId");
        sb.append('=');
        sb.append(((this.partyId == null)?"<null>":this.partyId));
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
        result = ((result* 31)+((this.partyId == null)? 0 :this.partyId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TCCAEVAPIInsuranceEnrolmentEventToIndividual) == false) {
            return false;
        }
        TCCAEVAPIInsuranceEnrolmentEventToIndividual rhs = ((TCCAEVAPIInsuranceEnrolmentEventToIndividual) other);
        return ((this.partyId == rhs.partyId)||((this.partyId!= null)&&this.partyId.equals(rhs.partyId)));
    }

}
