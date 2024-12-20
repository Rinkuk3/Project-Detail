package com.td.api.mbofp.request.updateofferdisposition;

public class AgreementIdentification {

    private String typeCd;
    private String identifierVal;

    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd;
    }

    public String getIdentifierVal() {
        return identifierVal;
    }

    public void setIdentifierVal(String identifierVal) {
        this.identifierVal = identifierVal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AgreementIdentification.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("typeCd");
        sb.append('=');
        sb.append(((this.typeCd == null)?"<null>":this.typeCd));
        sb.append(',');
        sb.append("identifierVal");
        sb.append('=');
        sb.append(((this.identifierVal == null)?"<null>":this.identifierVal));
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
        result = ((result* 31)+((this.typeCd == null)? 0 :this.typeCd.hashCode()));
        result = ((result* 31)+((this.identifierVal == null)? 0 :this.identifierVal.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AgreementIdentification) == false) {
            return false;
        }
        AgreementIdentification rhs = ((AgreementIdentification) other);
        return (((this.typeCd == rhs.typeCd)||((this.typeCd!= null)&&this.typeCd.equals(rhs.typeCd)))&&((this.identifierVal == rhs.identifierVal)||((this.identifierVal!= null)&&this.identifierVal.equals(rhs.identifierVal))));
    }

}
