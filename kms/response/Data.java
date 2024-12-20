package com.td.api.kms.response;

public class Data {

    private String encodingSchemeTypeCd;
    private String plainTxt;
    private Integer lengthCnt;

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

    public Integer getLengthCnt() {
        return lengthCnt;
    }

    public void setLengthCnt(Integer lengthCnt) {
        this.lengthCnt = lengthCnt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Data.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("encodingSchemeTypeCd");
        sb.append('=');
        sb.append(((this.encodingSchemeTypeCd == null)?"<null>":this.encodingSchemeTypeCd));
        sb.append(',');
        sb.append("plainTxt");
        sb.append('=');
        sb.append(((this.plainTxt == null)?"<null>":this.plainTxt));
        sb.append(',');
        sb.append("lengthCnt");
        sb.append('=');
        sb.append(((this.lengthCnt == null)?"<null>":this.lengthCnt));
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
        result = ((result* 31)+((this.lengthCnt == null)? 0 :this.lengthCnt.hashCode()));
        result = ((result* 31)+((this.encodingSchemeTypeCd == null)? 0 :this.encodingSchemeTypeCd.hashCode()));
        result = ((result* 31)+((this.plainTxt == null)? 0 :this.plainTxt.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Data) == false) {
            return false;
        }
        Data rhs = ((Data) other);
        return ((((this.lengthCnt == rhs.lengthCnt)||((this.lengthCnt!= null)&&this.lengthCnt.equals(rhs.lengthCnt)))&&((this.encodingSchemeTypeCd == rhs.encodingSchemeTypeCd)||((this.encodingSchemeTypeCd!= null)&&this.encodingSchemeTypeCd.equals(rhs.encodingSchemeTypeCd))))&&((this.plainTxt == rhs.plainTxt)||((this.plainTxt!= null)&&this.plainTxt.equals(rhs.plainTxt))));
    }

}
