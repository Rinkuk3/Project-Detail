package com.td.api.kms.response;

public class Hash {

    private String encodingSchemeTypeCd;
    private String hashVal;
    private Integer lengthCnt;

    public String getEncodingSchemeTypeCd() {
        return encodingSchemeTypeCd;
    }

    public void setEncodingSchemeTypeCd(String encodingSchemeTypeCd) {
        this.encodingSchemeTypeCd = encodingSchemeTypeCd;
    }

    public String getHashVal() {
        return hashVal;
    }

    public void setHashVal(String hashVal) {
        this.hashVal = hashVal;
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
        sb.append(Hash.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("encodingSchemeTypeCd");
        sb.append('=');
        sb.append(((this.encodingSchemeTypeCd == null)?"<null>":this.encodingSchemeTypeCd));
        sb.append(',');
        sb.append("hashVal");
        sb.append('=');
        sb.append(((this.hashVal == null)?"<null>":this.hashVal));
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
        result = ((result* 31)+((this.hashVal == null)? 0 :this.hashVal.hashCode()));
        result = ((result* 31)+((this.lengthCnt == null)? 0 :this.lengthCnt.hashCode()));
        result = ((result* 31)+((this.encodingSchemeTypeCd == null)? 0 :this.encodingSchemeTypeCd.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Hash) == false) {
            return false;
        }
        Hash rhs = ((Hash) other);
        return ((((this.hashVal == rhs.hashVal)||((this.hashVal!= null)&&this.hashVal.equals(rhs.hashVal)))&&((this.lengthCnt == rhs.lengthCnt)||((this.lengthCnt!= null)&&this.lengthCnt.equals(rhs.lengthCnt))))&&((this.encodingSchemeTypeCd == rhs.encodingSchemeTypeCd)||((this.encodingSchemeTypeCd!= null)&&this.encodingSchemeTypeCd.equals(rhs.encodingSchemeTypeCd))));
    }

}
