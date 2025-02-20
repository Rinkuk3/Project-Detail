package com.td.api.mbofp.response.retrievecampaign;

public class FeatureGroup__2 {

    private TowTerm towTerm;

    public TowTerm getTowTerm() {
        return towTerm;
    }

    public void setTowTerm(TowTerm towTerm) {
        this.towTerm = towTerm;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FeatureGroup__2 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("towTerm");
        sb.append('=');
        sb.append(((this.towTerm == null)?"<null>":this.towTerm));
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
        result = ((result* 31)+((this.towTerm == null)? 0 :this.towTerm.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FeatureGroup__2) == false) {
            return false;
        }
        FeatureGroup__2 rhs = ((FeatureGroup__2) other);
        return ((this.towTerm == rhs.towTerm)||((this.towTerm!= null)&&this.towTerm.equals(rhs.towTerm)));
    }

}
