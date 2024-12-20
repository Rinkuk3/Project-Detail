package com.td.api.enrollment.retrieve;

public class Relationship {

    private String relationshipCd;
    private String relationshipVal;

    public String getRelationshipCd() {
        return relationshipCd;
    }

    public void setRelationshipCd(String relationshipCd) {
        this.relationshipCd = relationshipCd;
    }

    public String getRelationshipVal() {
        return relationshipVal;
    }

    public void setRelationshipVal(String relationshipVal) {
        this.relationshipVal = relationshipVal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Relationship.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("relationshipCd");
        sb.append('=');
        sb.append(((this.relationshipCd == null)?"<null>":this.relationshipCd));
        sb.append(',');
        sb.append("relationshipVal");
        sb.append('=');
        sb.append(((this.relationshipVal == null)?"<null>":this.relationshipVal));
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
        result = ((result* 31)+((this.relationshipCd == null)? 0 :this.relationshipCd.hashCode()));
        result = ((result* 31)+((this.relationshipVal == null)? 0 :this.relationshipVal.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Relationship) == false) {
            return false;
        }
        Relationship rhs = ((Relationship) other);
        return (((this.relationshipCd == rhs.relationshipCd)||((this.relationshipCd!= null)&&this.relationshipCd.equals(rhs.relationshipCd)))&&((this.relationshipVal == rhs.relationshipVal)||((this.relationshipVal!= null)&&this.relationshipVal.equals(rhs.relationshipVal))));
    }

}
