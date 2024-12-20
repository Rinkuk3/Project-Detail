package com.td.api.kms.request;

public class AdditionalAuthenticationData {

    private String encodingSchemeTypeCd;
    private String plainTxt;

    public String getEncodingSchemeTypeCd() {
        return encodingSchemeTypeCd;
    }

    public void setEncodingSchemeTypeCd(String encodingSchemeTypeCd) {
        this.encodingSchemeTypeCd = encodingSchemeTypeCd;
    }

    public String getPlainTxt() {
        return plainTxt;
    }

    public void setPlainTxt(String plainTxt) {
        this.plainTxt = plainTxt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AdditionalAuthenticationData.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("encodingSchemeTypeCd");
        sb.append('=');
        sb.append(((this.encodingSchemeTypeCd == null)?"<null>":this.encodingSchemeTypeCd));
        sb.append(',');
        sb.append("plainTxt");
        sb.append('=');
        sb.append(((this.plainTxt == null)?"<null>":this.plainTxt));
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
        result = ((result* 31)+((this.encodingSchemeTypeCd == null)? 0 :this.encodingSchemeTypeCd.hashCode()));
        result = ((result* 31)+((this.plainTxt == null)? 0 :this.plainTxt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AdditionalAuthenticationData) == false) {
            return false;
        }
        AdditionalAuthenticationData rhs = ((AdditionalAuthenticationData) other);
        return (((this.encodingSchemeTypeCd == rhs.encodingSchemeTypeCd)||((this.encodingSchemeTypeCd!= null)&&this.encodingSchemeTypeCd.equals(rhs.encodingSchemeTypeCd)))&&((this.plainTxt == rhs.plainTxt)||((this.plainTxt!= null)&&this.plainTxt.equals(rhs.plainTxt))));
    }

}
